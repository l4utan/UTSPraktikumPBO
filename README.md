# UTS Praktikum PBO — Team Solve Game Kooperatif

Game kooperatif sederhana berbasis Java. Dua karakter dengan kemampuan berbeda
harus saling bantu untuk menyelesaikan misi. Dibuat sebagai tugas UTS Praktikum
Pemrograman Berorientasi Objek (PBO).

## Tim

| Anggota | Tanggung jawab |
|---|---|
| Surya | `Skill`, `Karakter`, `Loncat`, `Merunduk`, `Karakter1`, `MainSurya` |
| Daniel | `Musuh`, `Lari`, `InjakMusuh`, `Karakter2`, `MainDaniel` |

## Ketentuan Tugas

- Karakter1: hanya bisa **loncat** dan **merunduk**.
- Karakter2: bisa **lari** dan **menginjak musuh**.
- Tiap anggota membuat Main Class sendiri berisi penyelesaian game kooperatif,
  memakai package dan kelas Karakter1 dan Karakter2.
- Setiap aksi satu karakter berdampak pada state karakter lain.
- Keypoint: Class, Object, Enkapsulasi, Relasi, Pewarisan, Overriding, Overloading.

## Struktur Folder

```
src/
├── base/
│   ├── Karakter.java        abstract: nama, partner, terimaBantuan()
│   ├── Musuh.java           target yang diinjak
│   └── Skill.java           abstract: nama, hitungan pemakaian, gunakan()
├── skill/
│   ├── Loncat.java          skill Karakter1
│   ├── Merunduk.java        skill Karakter1
│   ├── Lari.java            skill Karakter2
│   └── InjakMusuh.java      skill Karakter2
├── karakter1/
│   └── Karakter1.java
├── karakter2/
│   └── Karakter2.java
├──── MainSurya.java
└──── MainDaniel.java
```

## Desain

Karakter dan Skill sengaja dipisah (prinsip *single responsibility*):

- **Karakter** menyimpan state dan menjadi penjaga aturan ("boleh atau tidak").
- **Skill** menjalankan aksi, menghitung pemakaian, dan memberi dampak ke partner.
- Relasi: karakter *memiliki* skill (composition).

### Aturan Kooperatif

| Aksi Karakter1 | Dampak pada Karakter2 |
|---|---|
| `merunduk()` | Jalur terbuka, Karakter2 bisa `lari()`. Pijakan hilang. |
| `loncat()` | Karakter2 bisa `injakMusuh()`. Jalur tertutup. |

Karakter1 tidak bisa `loncat()` saat masih merunduk. Setelah Karakter2 menginjak
musuh, Karakter1 menerima notifikasi lewat `terimaBantuan("INJAK")`.

### Pemetaan Keypoint

| Konsep | Penerapan |
|---|---|
| Class dan Object | `Karakter1`, `Karakter2`, `Musuh`, 4 skill |
| Enkapsulasi | Semua field `private`, akses lewat getter dan method |
| Relasi | `partner` (asosiasi), karakter memiliki skill (composition), `InjakMusuh` memakai `Musuh` (dependency) |
| Pewarisan | `Karakter1`/`Karakter2` extends `Karakter`; skill extends `Skill` |
| Overriding | `terimaBantuan()`, `toString()`, `Skill.gunakan()` |
| Overloading | `loncat()`/`loncat(int)`, `lari()`/`lari(int)`, `gunakan(pemilik)`/`gunakan(pemilik, ...)` |

## Cara Menjalankan

Dari root repo:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")

java -cp out mainsurya.MainSurya
java -cp out maindaniel.MainDaniel
```

Output akhir: `MISI SELESAI` jika target terpenuhi, `MISI GAGAL` jika tidak.

## Skenario Misi

| Main | Target |
|---|---|
| `MainSurya` | 2 loncat, 3 musuh diinjak, jarak lari minimal 5m |
| `MainDaniel` | 3 loncat, 2 musuh diinjak, jarak lari minimal 3m |

## Alur Kerja Git

1. Satu branch per anggota, contoh `git checkout -b surya`.
2. Merge ke `main` lewat Pull Request. Jangan push langsung ke `main`.
3. Kontrak antar kelas: `Karakter.terimaBantuan(String jenis)` dengan jenis
   `"LONCAT"`, `"RUNDUK"`, `"INJAK"`. Jangan diubah tanpa kesepakatan berdua.

## Riwayat Pengerjaan

1. Merancang struktur folder dan pembagian kerja dua orang.
2. Versi awal: semua aksi sebagai method di kelas karakter.
3. Refactor: `Skill` dipisah dari `Karakter` (abstract class `Skill` + 4 subclass).
4. Rename `MainTeman` jadi `MainDaniel`, lalu `MainLaut` jadi `MainSurya`.

## Catatan Pengembangan

- Aksi antar karakter masih memakai `String`. Rawan typo. Opsi perbaikan: ganti
  dengan `enum`.
- Aturan keterikatan perlu dicocokkan dengan video contoh dari dosen.