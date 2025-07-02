package problems;

public class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        // el orden de los sandiches importa (No se pueden servir mas sandwich si no hay quien coma el top del stack)
        int res = students.length; // Ir contando cuantos estudiantes quedan
        int ceros = 0;
        int ones = 0;
        // Contar el numero de preferencias por estudiantes, con esto veremos si hay alguno que se pueda comer el top
        for (int type : students) {
            if(type == 0) ceros++;
            else ones++;
        }

        // Recorrer los sandiches e ir decrementando los estudiantes que faltan
        for(int type: sandwiches) {
            if(type == 0 && ceros > 0) {
                ceros--;
                res--;
            } else if(type == 1 && ones > 0) {
                ones--;
                res--;
            } else {
                break;
            }
        }

        return res;
    }
}
