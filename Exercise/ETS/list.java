// package Exercise.ETS;
// import java.util.LinkedList;

// class list {
    
// static LinkedList<Integer> change (int [] a, int i) {
//     // 1. Deklarasi LinkedList
//     LinkedList<Integer> list = new LinkedList<>();

//     // 2. Tambahkan semua elemen array ke LinkedList
//     for(int v : a) {
//         list.add(v);
//     }

//     // 3. Cek apakah nilai sebelum indeks i tidak lebih kecil dari list.get(i)
//     for(int j = 0; j < i; j++) {
//         if (list.get(j) >= list.get(i)) {
//             // Gunakan rumus angka acak yang lebih kecil dari list.get(i)
//             list.set(j, (int)(Math.random() * list.get(i)));
//         }
//     }

//     // 4. Cetak seluruh nilai dalam LinkedList
//     for(int v : list) {
//         System.out.print(v + " ");
//     }

//     return list;
//     }
// }