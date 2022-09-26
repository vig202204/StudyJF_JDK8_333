package chapter_10_Misc;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;
import static java.lang.System.setOut;

/** Практичні вправи для розумників і розумниць
*   Погугліть як використовувати клас HashMap.
*   Спробуйте створити програму HashMapDemo, яка схожа на програму ArrayListDemo,
*   але в колекції зберігаються імена і телефони.
**/
public class hashMapDemo {
    public static void main(String[] args) {

// Контроль наявності дубликата
        HashMap<String, String> phoneBook = new HashMap();
        phoneBook.put("FirstName", "+38 067 618 68 68");

// Перевірка на дублікат
        if (phoneBook.containsKey("FirstName")) { //&& phoneBook.containsValue("+38 067 618 68 68")
            out.println(phoneBook);
            if (phoneBook.containsKey("FirstName") == phoneBook.containsValue("+38 067 618 68 68")) {
                out.println("Такий запис вже у наявності у довіднику phoneBook");
            }
            phoneBook.put("FirstName", "+38 067 618 68 68");
        }
        out.println("Друк вмісту: " + phoneBook);
        phoneBook.clear();

//Створюємо і заповнюємо HashMap
        HashMap<String, String> friends = new HashMap();
        int idFriend = 1;
        friends.put("Олена", "+380 50 123 54 67");
        friends.put("Анна", "+380 97 123 45 87");
        friends.put("Микола", "+380 68 432 56 89");
        friends.put("Сергій", "+380 93 876 34 65");
//Скільки в нього друзів?
        int friendsCount = friends.size();
//Друкуємо вміст HashMap
        for (String key : friends.keySet()) {
            out.println("Друг No" + idFriend++ + ": " + " це " + key + ", його тел.: " + friends.get(key));
        }

        friends.clear();

        int lastkey = 0;
        HashMap<Integer, List<String>> idPhoneBook = new HashMap<>();
// Наповнюємо HashMap різномірним Value
        idPhoneBook.put(3, Arrays.asList("Микола", "+380 68 432 56 89", "+380 93 876 34 65", "+380 93 876 34 65"));
        idPhoneBook.put(2, Arrays.asList("Анна","+380 97 123 45 87"));
        idPhoneBook.put(4, Arrays.asList("Сергій", "+380 93 876 34 65", "+380 77 876 34 65"));
        idPhoneBook.put(1, Arrays.asList("Олена", "+380 50 123 54 67", "+380 93 876 34 65"));
        System.out.println("Keyset: " + idPhoneBook.keySet());

// Друкуємо вміст
        // Thanks fo Baeldung.com
        for (Integer key : idPhoneBook.keySet()) {
            System.out.println("key: " + key + " value: " + idPhoneBook.get(key));
        }
// Шукаємо та затим друкуємо строку з попередньо визначеним значенням Key
        int searchingKey = 3;
        System.out.println("Searching key: " + searchingKey + " value: " + idPhoneBook.get(searchingKey));
        System.out.println("Друг No" + searchingKey + " value: " + idPhoneBook.get(searchingKey));
    }
}


