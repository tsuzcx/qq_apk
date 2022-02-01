import android.os.Parcel;

public class anaj
{
  public int dEL;
  public int dEM;
  public int groupId;
  public String groupName;
  public String selfUin;
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.selfUin = paramParcel.readString();
    this.groupName = paramParcel.readString();
    this.groupId = paramParcel.readInt();
    this.dEL = paramParcel.readInt();
    this.dEM = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel)
  {
    paramParcel.writeString(this.selfUin);
    paramParcel.writeString(this.groupName);
    paramParcel.writeInt(this.groupId);
    paramParcel.writeInt(this.dEL);
    paramParcel.writeInt(this.dEM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anaj
 * JD-Core Version:    0.7.0.1
 */