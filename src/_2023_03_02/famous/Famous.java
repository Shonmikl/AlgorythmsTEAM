package _2023_03_02.famous;

public class Famous {
    Famous getFamous(Famous[] persons) {
        Famous f = null;

        int first = 0;
        int last = (persons.length - 1);

        while (first != last) {
            if (persons[first].knows(persons[last])) {
                first++;
            } else last--;
        }

        for (int i = 0; i < persons.length; i++) {
            if (i != first &&
                    (persons[i].knows(persons[first]) || persons[first].knows(persons[i]))) {
                f = null;
            } else f = persons[first];
        }
        return f;
    }

    private boolean knows(Famous person) {
        return true;
    }
}
