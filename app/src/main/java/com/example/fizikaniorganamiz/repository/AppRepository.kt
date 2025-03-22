import com.example.fizikaniorganamiz.R
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 19/03/25
 * Javohir's MacBook Air
 */
class AppRepository private constructor(){

    companion object{
       lateinit var instance: AppRepository

       fun init(){
           if (!(::instance.isInitialized)){
               instance = AppRepository()
           }
       }
        fun getInstanceRepository(): AppRepository{
            return instance
        }
    }

    private val inventorList = listOf(
        InventorData(
            1,
            R.drawable.tesla_img,
            "Nikola Tesla",
            "Nikola Tesla 1856-yil 10-iyulda Avstriya imperiyasining",
            R.drawable.bg_tesla1,
            R.drawable.bg_tesla2
        ),
        InventorData(
            2,
            R.drawable.nyuton_img,
            "Isak Nyuton",
            "Daho Fizik Isak Nyuton 1643-yil 4-yanvarda Angliyaning Linkolnshir",
            R.drawable.bg_nyuton,
            R.drawable.bg_nyuton2
        ),
        InventorData(
            3,
            R.drawable.einstein_img,
            " Eynshteyn",
            "Albert Eynshteyn 1879-yil 14-martda Germaniyaning Ulm shahrida tug‘ilgan.",
            R.drawable.bg_einstein1,
            R.drawable.bg_einstein2
        ),
        InventorData(
            4,
            R.drawable.faradey_img,
            "Maykl Faradey",
            "Maykl Faradey 1791-yil 22-sentyabrda Angliyaning Nyuton shahrida",
            R.drawable.bg_faradey1,
            R.drawable.bg_faradey2
        ),
        InventorData(5,
            R.drawable.volta_img,
            "Volta",
            "Alessandro Volta 1745-yil 18-fevralda Italiyada, Komo shahrida ",
            R.drawable.bg_volta1
            , R.drawable.bg_volta2
        ),
        InventorData(
            6,
            R.drawable.amper_img,
            "Amper",
            "Amper1775-yil 20-yanvarda Fransiyaning Lion shahri yaqinidagi ",
            R.drawable.bg_amper1,
            R.drawable.bg_amper2
        ),
        InventorData(
            7,
            R.drawable.fulton_img,
            "Robert Fulton",
            "Robert Fulton 1765-yil 14-noyabrda AQShning Pensilvaniya shtatida",
            R.drawable.bg_fulton1,
            R.drawable.bg_fulton2
        ),
        InventorData(
            8,
            R.drawable.galileo_img,
            "Galileo Galilei",
            "Galileo Galilei 1564-yil 15-fevralda Italiyadagi Piza shahrida tug‘ilgan",
            R.drawable.bg_galileo1,
            R.drawable.bg_galileo2
        ),
        InventorData(
            9,
            R.drawable.watt_img,
            "James Watt",
            "James Watt 1736-yil 19-yanvarda Shotlandiyaning Grinok shahrida",
            R.drawable.bg_watt1,
            R.drawable.bg_watt2
        ),
    )
    private val articleList = listOf(
        ArticleData(1, R.drawable.article_img1,"Nyutonning tortishish qonuni","(1687-yil, Isaak Nyuton) – Osmon jismlari harakati va mexanikaning asosiy qonunlarini tushuntirdi."),
        ArticleData(2, R.drawable.article_img2,"Elektromagnit induksiya","(1831-yil, Maykl Faradey) – Elektr generatorlari va transformatorlarning paydo bo‘lishiga asos soldi."),
        ArticleData(3, R.drawable.article_img3,"Maxvell tenglamalari","(1860-yillar, Jeyms Klerk Maksvell) – Elektromagnit to‘lqinlarni"),
        ArticleData(4, R.drawable.article_img4,"Nisbiylik nazariyasi","(1905, 1915-yillar, Albert Eynshteyn) – Zamonaviy fizikaning asosiy."),
        ArticleData(5, R.drawable.article_img5,"Kvant mexanikasi","(20-asr boshlarida, Plank, Bor, Heyzenberg, Shryodinger) – Mikro olamning"),
        ArticleData(6, R.drawable.article_img6,"Yadro fizikasining rivojlanishi","(20-asr, Ernest Rezerford, Mari Kyuri, Enriko Fermi) – Atom"),
        ArticleData(7, R.drawable.article_img7,"Supero‘tkazuvchanlik"," (1911-yil, Heyke Kamerling Onnes) – Elektr energiyasini yo‘qotishsiz"),
        ArticleData(8,R.drawable.article_img8, "Lazer texnologiyasi","(1960-yillar, Teodor Meyman) – Optik aloqa, tibbiyot va sanoatda keng")
    )
    val selectionList = listOf(
        SelectionData(1,1,inventorList),
        SelectionData(2,2,articleList)
    )
}