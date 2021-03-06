package com.Clas;
// thuật toắn xắp xếp trộn
//xắp xêpso sánh
// thường dùng đc trộn 2 danh sách và tạo ra 1 mảng với với phép so sánh và đưa
// cho nó vào mảng mới ; tuần tự cho đến khi 2 mảng rổng

// mergeSort(arr[], l,  r)
// if r > l
//      1. Tìm chỉ số nằm giữa mảng để chia mảng thành 2 nửa:
//              middle m = (l+r)/2
//      2. Gọi đệ quy hàm mergeSort cho nửa đầu tiên:
//              mergeSort(arr, l, m)
//      3. Gọi đệ quy hàm mergeSort cho nửa thứ hai:
//              mergeSort(arr, m+1, r)
//      4. Gộp 2 nửa mảng đã sắp xếp ở (2) và (3):
//              merge(arr, 1, m, r)
// link :https://www.youtube.com/watch?v=JSceec-wEyw
public class MergeSort {

    // Merge hai mảng con của arr[].
    // Mảng con thứ nhất là arr[l..m]
    // Mảng con thứ hai là arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {

        // Tìm kích thước của 2 mảng con để merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Tạo mảng tạm
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge các mảng tạm lại

        // Chỉ mục ban đầu của 2 mảng con
        int i = 0, j = 0;

        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của L[] nếu có
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {

            // Tìm điểm chính giữa
            int m = (l + r) / 2;

            // Hàm đệ quy tiếp tục chia đôi
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    // In các phần tử của mảng
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {25, 30, 45, 6, 11, 90, 15};

        System.out.println("Mảng ban đầu:");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr);
    }
}
