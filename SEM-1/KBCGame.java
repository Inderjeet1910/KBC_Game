import java.util.Scanner;

class KBCGame{
    static Scanner sc=new Scanner(System.in);

    static String []questions={"What is the capital of France","Which planet is known as Red planet","Who is the Author of Harry Potter","Whhich planet is Known as Dwarf planet"};

    static String []options={"A.Berlin  B.Paris  C.Delhi  D.New York","A.Pluto  B.Earth  C.Mars  D.Saturn","A.Jk Rowling  B.Inderjeet  C.Saurab  D.Alen","A.Pluto  B.Earth  C.Mars  D.Jupiter"};

    static String []lifeLine={"A.Berlin  B.Paris","C.Mars  D.Saturn","A.Jk Rowling  B.Inderjeet","A.Pluto  B.Jupiter"};

    static char []answers={'B','C','A','A'};

    int questionIndex=0;

    double priceMoney;

    int LifeLine=3;

    void play(){
        System.out.println("Welcome to Kaun Banega Crorepati");
        // System.out.println("------------------------------------");
        boolean flag=false;
        while (questionIndex<questions.length) {
            this.displayQuestion();
            String ques;
            
            if(LifeLine>0){
                System.out.println("You have "+LifeLine+" Lifeline The name of Lifeline is 50-50");
                System.out.println("if you Have To use Lifeline Then Enter Yes");
                System.out.println("--------------------------------------------");
                ques=sc.nextLine();
                LifeLine--;
            }

            else{
                System.out.println("You are out of lifeline");
                ques="No";
            }

            if(ques.equalsIgnoreCase("Yes")){
                System.out.println("The updated options are after lifeLine is:"+lifeLine[questionIndex]);
                char userAnswere=this.checkAnswere();
                if(userAnswere==answers[questionIndex]){
                    System.out.println("Correct Answere");
                    if(questionIndex==0){
                        this.priceMoney+=100000;
                        System.out.println("You have Won 100000");
                    }
                    else if(questionIndex==1){
                        this.priceMoney+=200000;
                        System.out.println("You have Won 200000");
                    }
                    else if(questionIndex==2){
                        this.priceMoney+=300000;
                        System.out.println("You have Won 300000");
                    }
                    else{
                        this.priceMoney+=400000;
                        System.out.println("You have Won 400000");
                    }
                    flag=true;
                }
                else{
                    flag=false;
                    System.out.println("Game over you have lost!");
                    break;
                }
                // LifeLine--;
            }

            else{
                char userAnswere=this.checkAnswere();
                if(userAnswere==answers[questionIndex]){
                    System.out.println("Correct Answere");
                    if(questionIndex==0){
                        this.priceMoney+=100000;
                        System.out.println("You have Won 100000");
                    }
                    else if(questionIndex==1){
                        this.priceMoney+=200000;
                        System.out.println("You have Won 200000");
                    }
                    else if(questionIndex==2){
                        this.priceMoney+=300000;
                        System.out.println("You have Won 300000");
                    }
                    else{
                        this.priceMoney+=400000;
                        System.out.println("You have Won 400000");
                    }
                    flag=true;
                }
                else{
                    flag=false;
                    System.out.println("Game over you have lost!");
                    break;
                }
            }

            if(questionIndex<questions.length-1){
                System.out.println("Do you want to continue ahead");
                System.out.println("Type in yes or no");
                String contin=sc.next();
                sc.nextLine();
                if(contin.equalsIgnoreCase("NO")){
                     break;
                }
            }

            questionIndex++;
        }
        if(flag){
            System.out.println("Congratulation You have passed the game");
            System.out.println("The Price Money you have won is:"+this.priceMoney);
        }
    }

    void displayQuestion(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Question no:"+(questionIndex+1)+"\n"+questions[questionIndex]);
        System.out.println("Your Options are:\n"+options[questionIndex]);
        System.out.println("---------------------------------------------------------------");
    }

    char checkAnswere(){
        char userAnswere;
        while(true){
            System.out.println("Your Answere from (A/B/C/D) is:");
            char userAnswere2=sc.next().charAt(0);
            String input=""+userAnswere2;
            if(input.length()==1 && (input.equals("A") || input.equals("B") || input.equals("C") || input.equals("D"))){
                userAnswere=input.charAt(0);
                break;
            }
            else{
                System.out.println("Enter correct value like A,B,C,D");
            }
        }
        return userAnswere;
    }
}
class Run{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of players Who wants to play the game");
        int n=sc.nextInt();
        KBCGame []arr=new KBCGame[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=new KBCGame();
        }
        for(int i=0;i<arr.length;i++){
            System.out.println("----------------------------");
            System.out.println("Playing for Player:"+(i+1));
            arr[i].play();
        }
    }
}