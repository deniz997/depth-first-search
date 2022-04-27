import java.util.Scanner;
import java.util.Vector;

class Knoten {

    public Knoten(int knotenIndex) {
        this.knotenIndex = knotenIndex;
    }

    public Vector<Knoten> getNachKnoten() {
        return nachKnoten;
    }

    public void setNachKnoten(Vector<Knoten> nachKnoten) {
        this.nachKnoten = nachKnoten;
    }

    private int knotenIndex;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    private boolean visited = false;
    private Vector<Knoten> nachKnoten = new Vector();

    @Override
    public String toString() {
        return String.valueOf(knotenIndex);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int dim = sc.nextInt();
        Vector<Knoten> knotenListe = new Vector<>();
        int[][] matrix = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            Knoten v = new Knoten(i);
            knotenListe.add(i, v);
        }
        Knoten temp;

        for (int k = 0; k < dim; k++) {
            for (int i = 0; i < dim; i++) {
                matrix[k][i] = sc.nextInt();
                temp = knotenListe.get(k);
                if (matrix[k][i] == 1) {
                    temp.getNachKnoten().add(knotenListe.get(i));
                }
            }
        }

        Knoten startKnoten = knotenListe.get(sc.nextInt());

        //DFS

        temp = startKnoten;
        Vector<Knoten> besucht = new Vector<>();
        Vector<Knoten> stack = new Vector<>();
        Knoten addtoStack = temp;
        besucht.add(temp);
        stack.add(temp);
        temp.setVisited(true);
        while (stack.size() != 0) {
            for (int i = 0; i < temp.getNachKnoten().size(); i++) {
                addtoStack = temp.getNachKnoten().elementAt(i);
                if (!addtoStack.isVisited()) {
                    stack.add(addtoStack);
                    addtoStack.setVisited(true);
                    break;
                }
            }
            if (!besucht.contains(addtoStack)) {
                besucht.add(addtoStack);
            }
            temp = stack.lastElement();
            int count = 0;

            if (temp.getNachKnoten().size() != 0) {
                for (int i = 0; i < temp.getNachKnoten().size(); i++) {
                    if (temp.getNachKnoten().elementAt(i).isVisited()) {
                        count++;
                    }
                }
            }
            if (temp.getNachKnoten().size() == 0 || count == temp.getNachKnoten().size()) {
                stack.remove(stack.lastElement());
            }

        }
        String ergebnis = besucht.toString().replaceAll("[],]", "").replace("[", "");
        System.out.println(ergebnis);
        return;
    }
}