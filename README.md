# javaStudentSystemManagement
🧩 Cerințe detaliate
🧠 1. Clasa Student are următoarele câmpuri:

private int id;
private String name;
private String group;
private List<Grade> grades;
constructor complet, getter/setter
toString() care afișează frumos studentul + media generală calculată din note.

🧮 2. Clasa Grade are:
private String subject;
private double value;
constructor + getter/setter + toString()
validare: value trebuie să fie între 1 și 10.

⚙️ 3. Clasa StudentService: Aceasta gestionează o listă de studenți:
private List<Student> students = new ArrayList<>();
Trebuie să aibă metode:
addStudent(Student s) — adaugă un student nou.
Dacă ID-ul există deja, nu adaugă și aruncă excepție custom DuplicateIdException.
findByName(String name) — returnează toți studenții care conțin acel nume (case-insensitive).
getTopStudents(int n) — returnează primii n studenți după media notelor (folosind Stream + Comparator).
getAverageForSubject(String subject) — returnează media tuturor notelor dintr-o anumită materie (prin flatten stream).
groupByGroup() — întoarce un Map<String, List<Student>> care grupează studenții după grupă.
loadDemoData() — adaugă 5–6 studenți cu note fictive (folosește List.of etc.).

🧰 4. Main.java

În main(), creează un obiect StudentService și:
Apelează loadDemoData()
Afișează toți studenții.
Caută un student după nume (ex: "Ana").
Afișează top 3 studenți.
Afișează media la o materie (ex: "Java").
Afișează studenții grupați după group.
