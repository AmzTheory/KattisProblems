public class BookingRoom {
    int r;
    int b;
    int arrayRoom[];

    public BookingRoom(int r, int b, int[] arrayRoom) {
        this.r = r;
        this.b = b;
        this.arrayRoom = arrayRoom;
    }
    public String solve(){
        if(r==b)
            return "too late";
        else{
            for(int i=0;i<this.arrayRoom.length;i++){
                if(arrayRoom[i]==0)
                    return (i+1)+"";
            }
        }
        return "";
    }
}
