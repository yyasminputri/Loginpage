Membuat Halaman Login dengan Jetpack Compose di Android

# Pendahuluan
Di dunia pengembangan aplikasi mobile, layar login seringkali menjadi interaksi pertama pengguna dengan aplikasi Anda. Sebuah halaman login yang dirancang dengan baik tidak hanya memberikan fungsionalitas, tetapi juga menciptakan kesan pertama yang mendalam. Dalam tutorial ini, kita akan membahas cara membuat halaman login modern dan menarik menggunakan Jetpack Compose, toolkit modern Android untuk membangun antarmuka pengguna (UI) asli.

# Latar Belakang
Jetpack Compose merupakan terobosan besar dalam pengembangan UI Android. Tidak seperti sistem tata letak berbasis XML tradisional, Compose memungkinkan pengembang untuk:
- Membuat UI secara deklaratif
- Mengurangi kode boilerplate
- Mengimplementasikan animasi dan interaksi kompleks dengan lebih mudah
- Menyediakan cara yang lebih intuitif untuk merancang antarmuka pengguna

Struktur Proyek dan Pembagian Kode
Komponen-komponen utama halaman login :
1. Penyiapan Proyek
Pertama, pastikan Anda memiliki dependensi berikut di file build.gradle:
```
gradledependencies {
    implementation "androidx.compose.ui:ui:1.5.4"
    implementation "androidx.compose.material3:material3:1.1.2"
    implementation "androidx.activity:activity-compose:1.8.1"
}
```
2. Aktivitas Utama dan Tema
```
 MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFF6F6) // Latar belakang pink muda
                ) {
                    LoginScreen()
                }
            }
        }
    }
}
```
Poin-poin kunci di sini adalah:
- Menggunakan setContent untuk mendefinisikan UI
- Membungkus konten dalam LoginPageTheme
- Membuat Surface dengan warna latar belakang lembut

3. Komposisi Layar Login
Fungsi LoginScreen() adalah tempat keajaiban terjadi :
```
Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier
        .padding(bottom = 36.dp)
        .size(120.dp)
) {
    // Lingkaran latar belakang dengan bayangan
    Surface(
        modifier = Modifier
            .size(120.dp)
            .shadow(
                elevation = 8.dp,
                shape = CircleShape,
                ambientColor = Color(0xFFD5CCFF)
            ),
        shape = CircleShape,
        color = Color(0xFFE8E4FF)
    ) {}

    // Ikon profil
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            shape = CircleShape,
            color = Color.White,
            modifier = Modifier
                .size(56.dp)
                .shadow(4.dp, CircleShape)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Pengguna",
                    tint = Color(0xFFA388EE),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
```
Elemen desain utama:
- Palet warna ungu lembut
- Permukaan berlapis dengan bayangan
- Ikon profil terpusat

### Bidang Teks
```
// Bidang Teks Email
OutlinedTextField(
    value = email,
    onValueChange = { email = it },
    label = { Text("Email") },
    bentuk = RoundedCornerShape(12.dp),
    modifier = Modifier
        .fillMaxWidth()
        .shadow(2.dp, RoundedCornerShape(12.dp)),
    leadingIcon = {
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = "Email",
            tint = Color.Gray
        )
    }
)

// Struktur serupa untuk Bidang Teks Kata Sandi
```

Pertimbangan desain:
- Sudut membulat
- Ikon pemimpin
- Efek bayangan halus

Tombol Login
```
Button(
    onClick = { /* Tangani logika login */ },
    modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .shadow(4.dp, RoundedCornerShape(12.dp)),
    shape = RoundedCornerShape(12.dp),
    colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF8B85F3)
    )
) {
    Text(
        "Login",
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}
```
Sorotan:
- Tombol penuh lebar
- Warna ungu lembut
- Teks tebal
- Bayangan untuk kedalaman

4. Tombol Login Sosial
```
@Composable
fun TombolLoginSosial(
    onClick: () -> Unit,
    icon: ImageVector,
    warna: Color,
    warnaLatar: Color
) {
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = warnaLatar,
        modifier = Modifier
            .size(48.dp)
            .shadow(4.dp, CircleShape)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = icon,
                contentDescription = "Login Sosial",
                tint = warna,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
```
Poin Kunci
- Jetpack Compose menyederhanakan pengembangan UI
- Gunakan bayangan dan pelapisan untuk kedalaman
- Pertahankan palet warna yang konsisten
- Jaga elemen UI modular dan dapat digunakan kembali

Kesimpulan
Membuat halaman login yang cantik adalah seni yang menggabungkan fungsionalitas dengan daya tarik estetika. Jetpack Compose menyediakan alat untuk membuat UI yang menakjubkan dan responsif dengan kode minimal.

Visual App <br>
<img width="222" alt="Screenshot 2025-05-11 at 21 46 45" src="https://github.com/user-attachments/assets/a50ee6ba-4d07-465b-8210-0d57e68038af" />
