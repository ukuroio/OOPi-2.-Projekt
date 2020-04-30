Teine rühmatöö.
Martin Puškin ja Uku Roio

Projekt on täiendav liides meie esimesele projektile, milleks oli erinevaid tehteid 
sooritav kalkulaator jäägiklassikorpuses või polünoomide ringis üle selle jäägiklassikorpuse.

Programm koosneb tehteid sooritavadest klassidest "Polünoomid" ja "Jäägiklass" (kirjeldused 
eelmise projekti ReadMe failis), peaklassist "Tegevused", mis loob peamise akna, kus saab 
valida, millise mooduli järgi ja millist tehet sooritama hakatakse, ning klassist "TeineAken",
mis avab uue akna, kus seda tehet sooritatakse. 

Klass "Tegevused": Avab akna, mille suurus on muudetav, mille keskel saab sisestada mooduli 
(viskab erindi, kui tegemist pole algarvuga), ja mille vasakus servas on tehte valik jäägiklassi-
korpuses ning paremas servas tehte valik polünoomide ringis. Kui tehakse viga, siis tuleb vastav
tekst keskele tekstikasti alla. All on ka Välju nupp, mille vajutamisel (või ka risti vajutamisel) 
küsib programm kinnitust, mille annab kasutaja ENTER klahvi vajutamisega. Lahkumisel kirjutatakse 
tehete logi konsooli.

Klass "TeineAken": Avab teise akna, milles sooritatakse vastavalt tehte ja mooduli valikule soovitud 
tehe. Tehte tulemus kirjutatakse logifaili (meetod kirjutaFaili) koos mooduliga ja kuvatakse samas 
ka samas aknas. Akent kuvab meetod display, mis võtab argumentideks mooduli ja tehte arvu (igal 
võimalikul tehtel on vastav arv), mida sooritama hakatakse.


Projekti tegemine toimus kahes etapis. Esmalt tegi Uku kõige üldisema peamise akna, misjärel uuris 
Martin, kuidas programmis avada teine funtksionaalne aken. Siis kirjutaski Martin valmis koodi, mis 
avab uue akna ning sooritab tehted jäägiklassikorpustes (ja ka mooduli valimise, erindite tuvastamise 
ning loogilisema nuppude paigutuse). Seejärel lisas Uku tehted polünoomide ringis (taas kõige 
kaasnevaga). Siis tuli aga OOPi kontrolltöö, milleks pidi valmistuma, ja projekt jäi tükiks ajaks 
pooleli. 
Teises etapis programmeeris Uku faili kirjutamise, sealt lugemise ning "Välju" nupu koos kinnituse
küsimisega. Martin kirjutas ReadMe faili :)

Ajakulu oli Martinil umbes 2.5h, Ukul 3.5h. 

Suur probleem oli algul see, et Martinil ei lugenud Gradle koodi UTF-8 kodeeringus (nt klassi 
"Jäägiklass" ei leitud). Läks vähemalt 1h lisaaega, et välja uurida, kuidas see build.gradles ära
parandada. Ukul oli probleemiks see, et faili int-ide kirjutamine ei töötanud. Seega pidi lõpuks
kõik Stringideks muutma. 

Minu arvates on projekt väga hästi valminud ja lõpptulemus nii mugav, kiire kui ka ilus. Tõsiseid
probleeme ei tekkinud, aga kindlasti õppisime paremini JavaFX-ga graafikat looma. Programmi testisime
erinevaid tehteid sisestades ja tulemusi kontrollides. Nii leidsime veel viimasel hetkel, et 
täienduses, mille Martin jäägiklassikorpustes astendamise meetodile tegi, oli viga. See on aga nüüd 
edukalt parandatud!
