package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Validar el caracter que necesita cada caracter de cierre
        Map<Character, Character> map = new HashMap<>();
        // Ingresar los caracteres de cierre como llave para validar que tengan un caracter de apertura en el stack
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        // Recorrer el string para ingresar en el stack los caracteres de apertura y validar los de cierre
        for(char c : s.toCharArray()) { // toCharArray convierte el String en un array de char
            // Validar si encontramos un caracter de cierre, es decir si esta en el map como llave
            if(map.containsKey(c)) {
                // Validamos que el top del stack sea el de apertura correspondiente
                char closeChar = map.get(c);
                if(!stack.isEmpty() && map.get(c) == stack.peek()) {
                    stack.pop(); // Es valido y lo retiramos
                } else {
                    return false;
                }
            } else {
                // Si no esta en el map significa que es un caracter de apertura, lo agregamos al stack
                stack.push(c);
            }
        }
        // Si el stack al final esta vacio significa que cada caracter de apertura tenia uno de cierre
        return stack.isEmpty();
    }
}
