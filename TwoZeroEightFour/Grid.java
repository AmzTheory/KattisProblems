package TwoZeroEightFour;

public class Grid {
    private int[][] cells;
    public Grid(){
        cells=new int[4][4];
    }
    public Grid(int[][] cells){
        this.cells=cells;
    }

    public void moveLeft(){
        moveRowLeft(0);
        moveRowLeft(1);
        moveRowLeft(2);
        moveRowLeft(3);
    }
    public void moveRight(){
        moveRowRight(0);
        moveRowRight(1);
        moveRowRight(2);
        moveRowRight(3);
    }
    public void moveUp(){
        moveColUp(0);
        moveColUp(1);
        moveColUp(2);
        moveColUp(3);
    }
    public void moveDown(){
        moveColDown(0);
        moveColDown(1);
        moveColDown(2);
        moveColDown(3);
    }
    //left
    private void moveRowLeft(int row) {
        int[] current = cells[row];
        for (int i = 3; i >=0; i--) {
            //current is zero
            if(i>0) {
                if (current[i] == 0) {
                    moveLeftBefore(i, row);
                    //element next to element zero
                } else if (current[i - 1] == 0) {
                    current[i - 1] = current[i];
                    current[i] = 0;
                    moveLeftBefore(i, row);
                    //identical element next to it
                } else if (current[i - 1] == current[i] && current[i] != 0) {
                    current[i - 1] = current[i - 1] * 2;
                    moveLeftBefore(i, row);
                    i--;
                }
            }else{
                if(i<0)
                    break;
                else if(current[i]==0)
                    moveLeftBefore(i,row);
            }

        }
    }
    private void moveLeftBefore(int col,int row){
        int[] current=cells[row];
        if(col==0){
            current[0]=current[1];
            current[1]=current[2];
            current[2]=current[3];
            current[3]=0;
        }
        else if(col==1){
            current[1]=current[2];
            current[2]=current[3];
            current[3]=0;
        }else if(col==2){
            current[2]=current[3];
            current[3]=0;
        }else if(col==3){
            current[3]=0;
        }
    }
    //right
    private void moveRowRight(int row){
        int[] current=cells[row];
        for(int i=0;i<cells.length;i++){
            //current is zero
            if(i<current.length-1) {
                if (current[i] == 0) {
                    moveRightBefore(i, row);
                    //element next to element zero
                } else if (current[i + 1] == 0) {
                    current[i + 1] = current[i];
                    current[i] = 0;
                    moveRightBefore(i, row);
                    //identical element next to it
                } else if (current[i + 1] == current[i] && current[i] != 0) {
                    current[i + 1] = current[i + 1] * 2;
                    moveRightBefore(i, row);
                    i++;
                }
            }else{
                if(current[i]==0)
                    moveRightBefore(i,row);
                break;
            }
        }
    }
    private void moveRightBefore(int col,int row){
        int[] current=cells[row];
        if(col==3){
            current[3]=current[2];
            current[2]=current[1];
            current[1]=current[0];
            current[0]=0;
        }
        else if(col==2){
            current[2]=current[1];
            current[1]=current[0];
        }else if(col==1){
            current[1]=current[0];
            current[0]=0;
        }else if(col==0){
            current[0]=0;
        }
    }
    private void moveColUp(int col){
        int[] current=getCol(col);
        for(int i=3;;i--){
          if(i>0) {
              if (current[i] == 0) {
                      moveUpBefore(i, current);
              } else if (current[i - 1] == 0) {
                  current[i - 1] = current[i];
                  current[i] = 0;
                  moveUpBefore(i, current);
              } else if (current[i - 1] == current[i] && current[i] != 0) {
                  current[i - 1] = current[i] * 2;
                  current[i] = 0;
                  moveUpBefore(i, current);
                  i--;
              }
          }else{
              if(i<0)
                  break;
              else if(current[i]==0)
                moveUpBefore(i,current);


              break;

          }
        }
        this.setCol(col,current);
    }
    private void moveUpBefore(int row,int[] values){
           if(row==0){
               values[0]=values[1];
               values[1]=values[2];
               values[2]=values[3];
               values[3]=0;
           }else if(row==1){
               values[1]=values[2];
                values[2]=values[3];
                values[3]=0;
           }else if(row==2){
                values[2]=values[3];
                values[3]=0;
           }else if(row==3){
                values[3]=0;
           }
    }
    private void moveColDown(int col){
        int[] current=getCol(col);
        for(int i=0;;i++){
            if(i<current.length-1) {
                if (current[i] == 0) {
                    moveDownBefore(i, current);
                } else if (current[i + 1] == 0) {
                    current[i + 1] = current[i];
                    current[i] = 0;
                    moveDownBefore(i, current);
                } else if (current[i + 1] == current[i] && current[i] != 0) {
                    current[i + 1] = current[i] * 2;
                    current[i] = 0;
                    moveDownBefore(i, current);
                    i++;
                }
            }else{
                if(i>3)
                    break;
                else if(current[i]==0)
                    moveDownBefore(4,current);


                break;

            }
        }
        this.setCol(col,current);
    }
    private void moveDownBefore(int row,int[] values){
        if(row==4){
            values[3]=values[2];
            values[2]=values[1];
            values[1]=values[0];
            values[0]=0;
        }else if(row==2){
            values[2]=values[1];
            values[1]=values[0];
            values[0]=0;
        }else if(row==1){
            values[1]=values[0];
            values[0]=0;
        }else if(row==3){
            values[0]=0;
        }
    }
    private int[] getCol(int col){
        int[] values=new int[4];
        for(int i=0;i<4;i++){
            values[i]=this.cells[i][col];
        }
        return values;
    }
    private void setCol(int col,int[] values){
        for(int i=0;i<4;i++){
            this.cells[i][col]=values[i];
        }
    }

    public void printGrid(){
        for (int i=0;i<cells.length;i++){
            int[] current=cells[i];
            System.out.println(current[0]+" "+current[1]+" "+current[2]+" "+current[3]);
        }
    }

}
