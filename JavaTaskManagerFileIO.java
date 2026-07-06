import java.util.*;
import java.io.*;

public class JavaTaskManagerFileIO {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        ArrayList<String> tasks = new ArrayList<>();
        File file = new File("tasks.txt");

            if(file.exists()){
            System.out.println("File Found");
            }else{
                System.out.println("File Not Found");
                try{
    file.createNewFile();
    System.out.println("File Created Successfully!");
}catch(IOException e){
    System.out.println("Error Creating File!");
}
            }
                try{
    Scanner fileReader = new Scanner(file);

    while(fileReader.hasNextLine()){
        String task = fileReader.nextLine();
        tasks.add(task);
    }

    fileReader.close();

}catch(FileNotFoundException e){
    System.out.println("Error Reading File!");
}
while(true){ 
        System.out.println("========== TASK MANAGEMENT SYSTEM ==========");
        System.out.println("1. Add Task\n" + 
                        "2. View Tasks\n" + 
                        "3. Update Task\n" + 
                        "4. Delete Task\n" + 
                        "5. Exit");
                        System.out.print("Enter Your Choice : ");
                         int choice = scan.nextInt();
                         scan.nextLine();
                       
                          if(choice == 1){
                            System.out.println("Add Task Selected");
                            System.out.print("Enter Task : ");
                              String task = scan.nextLine();
                              tasks.add(task); 
                              
    try{
        FileWriter writer = new FileWriter(file);

        for(int i = 0; i < tasks.size(); i++){
            writer.write(tasks.get(i) + "\n");
        }

        writer.close();

    }catch(IOException e){
        System.out.println("Error Writing File!");
    }

    System.out.println("Task Added Successfully!");
                        }else if(choice == 2){
                            System.out.println("View Task Selected");
                            System.out.println("Task List");
                            if(tasks.size() == 0){
                            System.out.println("No Tasks Available!");
                          }else{ 
                            for(int i = 0; i < tasks.size(); i++){
                           System.out.println((i + 1) + ". " + tasks.get(i));
                            }
                          }
                        }else if(choice == 3){

    System.out.println("Update Task Selected");

    if(tasks.size() == 0){
        System.out.println("No Tasks Available!");
    }else{

        System.out.println("Task List");
        for(int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Enter Task Number: ");
         int index = scan.nextInt();
        scan.nextLine();

        if(index >= 1 && index <= tasks.size()){

            System.out.print("Enter New Task: ");
            String newTask = scan.nextLine();

            tasks.set(index - 1, newTask);
             try {
                            FileWriter writer = new FileWriter(file);

                            for (int i = 0; i < tasks.size(); i++) {
                                writer.write(tasks.get(i) + "\n");
                            }

                            writer.close();

                        } catch (IOException e) {
                            System.out.println("Error Writing File!");
                        }

            System.out.println("Task Updated Successfully!");
        }else{
            System.out.println("Invalid Task Number!");
        }
    }
                        }else if(choice == 4){

    System.out.println("Delete Task Selected");

    if(tasks.size() == 0){
        System.out.println("No Tasks Available!");
    }else{

        System.out.println("Task List");
        for(int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Enter Task Number: ");
        int index = scan.nextInt();
        scan.nextLine();

        if(index >= 1 && index <= tasks.size()){
            tasks.remove(index - 1);
            try {
                            FileWriter writer = new FileWriter(file);

                            for (int i = 0; i < tasks.size(); i++) {
                                writer.write(tasks.get(i) + "\n");
                            }

                            writer.close();

                        } catch (IOException e) {
                            System.out.println("Error Writing File!");
                        }

            System.out.println("Task Deleted Successfully!");
        }else{
            System.out.println("Invalid Task Number!");
        }
    }
                        }else if(choice == 5){
                          System.out.println("Thank You!");
                          break;
                        }else{
                            System.out.println("Invalid Choice");
                        
    }
}
}
}

