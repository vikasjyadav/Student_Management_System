import java.util.*;

class Student{
    
    private int ID,Marks;
    private String Name;

    Student(int ID, String Name, int Marks){
        this.ID = ID;
        this.Name = Name;
        this.Marks = Marks;
    }

    //Getter For ID
    public int GetID(){
        return ID;
    }

    //Setter For ID

    public void SetId(int ID){
        this.ID = ID;
    }

    //Getter For Name

    public String GetName(){
        return Name;
    }

    //Satter for Name

    public void SetName(String Name){
        this.Name = Name;
    }

    //Getter For Marks

    public int getMarks(){
        return Marks;
    }

    //Setter For Marks

    public void SetMarks(int Marks){
        this.Marks = Marks;
    }
}

class StudentManagement{
    Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>(); 
        StudentManagement sm = new StudentManagement();

        int choice;

        do{
            System.out.println("======Student Management Operation======");
            System.out.println("1.Add Students.");
            System.out.println("2.View Students.");
            System.out.println("3.Update Students.");
            System.out.println("4.Delete Students.");
            System.out.println("5.Exit");

            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sm.AddStudent(students);
                    break;
                case 2:
                    sm.ViewStudent(students);
                    break;
                case 3:
                    sm.UpdateStudent(students);
                    break;
                case 4:
                    sm.DeleteStudent(students);
                    break;
                case 5:
                    System.out.println("Exiting..");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice !");
            }
        }while(true);
    }
    
    void AddStudent(ArrayList<Student>students){

        System.out.print("Enter ID : ");
        int ID = sc.nextInt();
        sc.nextLine();
        for(Student s: students){
        if(s.GetID() == ID){
            System.out.println("The ID " + ID + " already exists. Please enter a different ID.");
            return; 
        }
}


        System.out.print("Enter Name Of The Student : ");
        String Name = sc.nextLine();

        System.out.print("Enter Marks : ");
        int Marks = sc.nextInt();

        Student s =new Student(ID,Name,Marks);
        students.add(s);

        System.out.println("Student added successfully.");
    }

    void ViewStudent(ArrayList<Student>students){
        if(students.isEmpty()){
            System.out.println("There Is no Any Student Recorded..");
        }

        else{
            System.out.println("---------Student Record---------");
            for(int i = 0; i<students.size();i++){
            Student s =  students.get(i);
            System.out.println("ID : "+s.GetID());
            System.out.println("Name : "+s.GetName());
            System.out.println("Marks : "+s.getMarks());
            System.out.println("-------------------------------");
            }
        }
    }

    void UpdateStudent(ArrayList<Student>students){
        int temp_id;
        System.out.print("Enter ID Of The Student That You Want To Update : ");
        temp_id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for(Student s : students){
            if(s.GetID() == temp_id){
                found =true;

                System.out.println("Sudent Found : "+s.GetName());
                System.out.println("What Do You Want To Upadate ? ");
                System.out.println("1.Name");
                System.out.println("2.Marks");
                System.out.println("Enter Your Choice : ");
                int choice = sc.nextInt();
                sc.nextLine();

                if(choice == 1){
                    System.out.print("Enter New Name : ");
                    String NewName = sc.nextLine();
                    s.SetName(NewName);
                    System.out.println("Name Upadated Successfully...");
                }else if(choice == 2){
                    System.out.print("Enter New Marks : ");
                    int NewMarks = sc.nextInt();
                    s.SetMarks(NewMarks);
                    System.out.println("Marks Upadated Successfully....");
                }
                else{
                    System.out.println("Invalid Choice!");
                }
                break;
            }
        }
        if(!found){
            System.out.println("ID Not Found");
        }
    }

void DeleteStudent(ArrayList<Student>students){
        System.out.print("Enter Id To DELETE : ");
        int temp_id = sc.nextInt();

        boolean found = false;

        for(int i = 0; i<students.size(); i++){
            if(students.get(i).GetID() == temp_id){
                students.remove(i);
                System.out.println("Student Deleted Successfully...");
                found =true;
            }
        }
        if(!found){
            System.out.println("Student Not Found!");
        }
    }
}
