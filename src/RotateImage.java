import java.util.Scanner;

public class RotateImage {

    // Task: Rotate the matrix 90 degrees clockwise in-place
    public void rotate(int[][] matrix, int n) {
        // Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            // We only loop to n / 2, otherwise we would swap them back to their original spots!
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // The problem statement says the first line contains 'n' and 'n'
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int cols = sc.nextInt(); // Read the redundant second 'n'
            
            int[][] matrix = new int[n][n];
            
            // Read matrix elements
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            RotateImage solver = new RotateImage();
            solver.rotate(matrix, n);
            
            // Output the rotated matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + (j == n - 1 ? "" : " "));
                }
                System.out.println();
            }
        }
        
        sc.close();
    }
}
