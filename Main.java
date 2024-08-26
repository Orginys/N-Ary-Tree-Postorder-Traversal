import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorder(Node root) {
        // Инициализация списка для хранения значений узлов в порядке обхода postorder
        List<Integer> result = new ArrayList<>();

        // Если корневой узел равен null, возвращаем пустой список
        if (root == null) {
            return result;
        }

        // Инициализация стека для хранения узлов при обходе дерева
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // Инициализация другого стека для хранения узлов в обратном порядке
        Stack<Node> output = new Stack<>();

        // Пока стек не пуст, продолжаем обход дерева
        while (!stack.isEmpty()) {
            // Извлекаем узел из стека
            Node node = stack.pop();

            // Добавляем узел в выходной стек
            output.push(node);

            // Проходим по всем дочерним узлам текущего узла
            for (Node child : node.children) {
                // Добавляем каждого дочернего узла в стек для дальнейшего обхода
                stack.push(child);
            }
        }

        // Извлекаем узлы из выходного стека и добавляем их значения в список результата
        while (!output.isEmpty()) {
            result.add(output.pop().val);
        }

        // Возвращаем список с обходом в порядке postorder
        return result;
    }
}