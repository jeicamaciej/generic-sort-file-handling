# segregacja_rasowa

Stworzenie aplikacji, ktora odczytuje dane z pliku csv. Sciezke do pliku bedziesz
podawac w parametrach startowych apki i musisz to poprawnie odczytac, sparsowac
i przechowywac w jakies klasie. Stworzysz dwie klasy, pierwsza to bedzie
“Database”, ktora bedzie singletonem. Bedzie miala ona poczatkowo dwie metody:
readPeople(File file) oraz displayPeople(). Odczytanie z pliku bedzie parsowalo
kazdego czlowieka do obiektu typu Person, ktorzy beda trzymani w liscie ktora
bedzie w bazie danych. displayPeople zrobi tylko ladnego printla. Apka n poczatku
tylko czyta z pliku, zapisuje i wyswietla. Polecam duzy plik z danymi, moze cos
znajdziesz w necie, najwyzej mozesz miec inne dane niz wyzej wymienione
2. Wrzucenie tego na repo, z ladnymi komentarzami. Ja chetnie porobie review.
3. Dodajemy sortowanie! Dodasz do bazy danych metode sortAndDisplayPeople, ktora
bedize przyjmowac jako argument jakis obiekt typu Sorter<T extends Comparable>
gdzie Sorter jest interfejsem z metoda Collection<T> sort(Collection<T> col). Kazda
klasa implementujaca ten interfejs bedzie implementowac sortowanie i ZWRACAC
NOWA KOLEKCJE i nie zmieniac wogoletej co przyszla. To jest wazne. Ponadto, po
posortowaniu bedzie wypisywac czas sortowania. Bedziesz musial zaimplementowac
nastepujace algorytmy sortowania: bubble sort, quick sort, merge sort, insertion sort.
Teraz w aplikacji bedziesz musial dodac dialog gdzie bedziesz pytac goscia jakim
algorytmem chce posortowac dane. Zwroc uwage ze klasa czlowieka musi teraz
miec comparable, wiec bedziesz chcial uzyc i zaimplementowac metode compareTo.
Powiedzmy, ze bedziesz sortowac na razie po nazwisku. Po posortowaniu
wypisujesz czas (co robi za ciebie metoda sortujaca) oraz wypisuje sie posortowana
kolekcja, ale nie zmieniasz w jej naszej prymitywnej bazie. Algorytmy sortujace
rozszerz o sortowanie na ArrayList i LinkedList. To znaczy rob dwa razy sortowania
po to by porownac szybkosc w zaleznosci od kolekcji. Roznie moze byc na roznych
algorytmach. Dobra strona o sortach https://eduinf.waw.pl/inf/alg/003_sort/0010.php
4. Teraz bedzie ciezej, trzeba uzytkownikowi dodac kolejna opcje - podac po jakim polu
chce posortowac :) pomoga ci tu indeksy i sprawdzanie klas oraz uzywania
compareTo z metod konkretnych pol. Ponadto, mysle ze beda Ci potrzebne mapy
javowe aby to dobrze zrobic. Zrobisz dla roznych map to co dla list powyzej i tez
bedziemy wypluwac posortowane dane po danym polu.
5. Prosta funkcjonalnosc - dodajemy mozliwosc eksportowania posortowanych danych
do pliku...xml. Moze sie przydac potem. Nie masz zadnych zagniezdzen wiec sprobuj
to wyeksportowac bez bibliotek. Metoda eksportujaca powinna byc w bazie
6. Wjezdzaja biblioteki! Mozesz dodac gradle do projektu i sprobowac dodac biblioteke
JAXB i nia eksportowac pliki do xml. Mozesz tez dodac opcje odczytywania przy
starcie apki z xml i uzywac jaxb. Apka powinna po rozszerzeniu ogarnac ktorego
parsera uzyc (kolejny interfejs sie przyda).
7. Dodajemy JUnit - przyda Ci sie napisac troche unit testow sprawdzajacych dzialania
twoich metod
8. Baza na kolekcji jest ble. Chcesz byc fensi? Sciagnij dockera i sprobuj uruchomic na
nim mysql. Nastepnie podlacz apke do tej bazy za pomoca JDBC ktore dodasz do
projektu, dane do bazy bedziesz trzymac w pliku typu .properties (url, haslo, nazwy).
Do bazy uzytkownikow poki co zapisujesz i odczytujesz. Mozesz tez napisac metode
do sortowania ale za pomoca bazy i sobie czasy porownac. Moze byc ciekawe.
