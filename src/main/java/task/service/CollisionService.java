package task.service;

import org.springframework.stereotype.Service;
import task.domains.Response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollisionService {

    /**
     * method is looking for collisions for list of word
     * @param wordList - list of word
     * @return response with collisions
     */
    public Response searchCollision(List<String> wordList) {
        Response response = new Response();
        response.setOutList(new ArrayList<>());
        Iterator<String> iterator = wordList.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            List<String> collisionWords = findWordCollisions(word, wordList);
            if (!collisionWords.isEmpty() && collisionWords.size() > 1) {
                response.getOutList().add(collisionWords);
                wordList.removeAll(collisionWords);
                iterator = wordList.iterator();
            }
        }
        return response;
    }


    /**
     * method is looking for collisions for one word
     * @param inWord - the word for search
     * @param words - list of words
     * @return list of collisions
     */
    private static List<String> findWordCollisions(String inWord, List<String> words) {
        // get lower-cased letters
        String lowerWord = inWord.toLowerCase();
        int length = inWord.length();
        return words.stream()
                .filter(s -> s.length() == length)
                .filter(str -> lowerWord.chars().sum() == str.toLowerCase().chars().sum())
                .collect(Collectors.toList());
    }
}
