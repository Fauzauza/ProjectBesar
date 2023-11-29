# Sistem Pemesanan Makanan

Aplikasi ini adalah sistem pemesanan makanan yang dikembangkan menggunakan bahasa pemrograman Java. Aplikasi ini menyediakan antarmuka yang memungkinkan pengguna untuk melihat menu makanan dari beberapa kategori, memilih makanan, menentukan jumlah pesanan, dan melihat rincian pesanan beserta total biaya.

## Daftar Isi

1. [Fitur](#fitur)
2. [Struktur Kode](#struktur-kode)
3. [Cara Penggunaan](#cara-penggunaan)
4. [Kontribusi](#kontribusi)
5. [Lisensi](#lisensi)

## Fitur

### 1. Tampilan Menu Makanan
   - Menampilkan menu makanan dari beberapa kategori, seperti Makanan Utama, Makanan Pembuka, dan Desserts.

### 2. Pemilihan Makanan
   - Memungkinkan pengguna memilih makanan dari setiap kategori.
   - Menampilkan daftar makanan dengan nama dan harga.

### 3. Pemesanan
   - Memungkinkan pengguna menentukan jumlah pesanan untuk setiap makanan.
   - Menyimpan pesanan dalam keranjang.

### 4. Rincian Pesanan
   - Menampilkan rincian pesanan yang mencakup nama makanan, jumlah pesanan, dan total biaya.
   - Menghitung total biaya pesanan.

### 5. Kategori Menu
   - Makanan Utama
   - Makanan Pembuka
   - Desserts

## Struktur Kode

- `Main.java`: Kelas utama untuk menjalankan aplikasi.
- `Menu.java`: Kelas abstrak untuk merepresentasikan item-menu.
- `Category.java`: Kelas untuk merepresentasikan kategori menu.
- `Order.java`: Kelas untuk merepresentasikan pesanan.
- `MenuItem.java`: Kelas konkret untuk merepresentasikan item-menu dengan harga.

## Cara Penggunaan

1. **Menjalankan Aplikasi:**
   - Pastikan Java sudah terinstal di komputer Anda.
   - Buka proyek di IntelliJ IDEA atau IDE Java lainnya.
   - Jalankan kelas `Main.java`.

2. **Melihat Menu dan Memilih Makanan:**
   - Pilih kategori menu (Makanan Utama, Makanan Pembuka, atau Desserts).
   - Pilih makanan dari daftar yang ditampilkan.

3. **Menambahkan Pesanan:**
   - Tentukan jumlah pesanan untuk setiap makanan yang dipilih.

4. **Melihat Rincian Pesanan:**
   - Aplikasi akan menampilkan rincian pesanan beserta total biaya.

5. **Menyelesaikan Pesanan:**
   - Pesanan dapat disimpan atau diubah sebelum menyelesaikannya.

## Kontribusi

Kontribusi sangat dihargai! Jika Anda menemukan bug atau memiliki saran perbaikan, silakan buka _issue_ atau kirimkan _pull request_.

## Lisensi

Projek ini tidak dilisensikan secara khusus. Anda bebas menggunakan, mengubah, dan mendistribusikannya sesuai kebutuhan Anda.


