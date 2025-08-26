public class Main {
    public static void main(String[] args) {
        Faculty eng = new Faculty("Engineering");
        Department cs = new Department("Computer Science");
        cs.addMajor(new Major("Software Engineering", DegreeLevel.BACHELOR));
        cs.addMajor(new Major("Artificial Intelligence", DegreeLevel.MASTER));
        cs.addMajor(new Major("Computer Networks", DegreeLevel.PHD));
        eng.addDepartment(cs);

        // دانشکده دوم
        Faculty sci = new Faculty("Science");
        Department math = new Department("Mathematics");
        math.addMajor(new Major("Applied Mathematics", DegreeLevel.BACHELOR));
        math.addMajor(new Major("Statistics", DegreeLevel.MASTER));
        sci.addDepartment(math);

        // اضافه کردن دانشکده‌ها به دانشگاه
        University.faculties.add(eng);
        University.faculties.add(sci);

        // نمایش اطلاعات
        University.showInfo();



        System.out.println("----------");


        Menu menu = new Menu();
        menu.first();
        System.out.println("salam");
        menu.first();

    }
}