import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;

public final class alvo
  implements Parcelable.Creator<RevokeMsgInfo>
{
  public RevokeMsgInfo a(Parcel paramParcel)
  {
    boolean bool = true;
    RevokeMsgInfo localRevokeMsgInfo = new RevokeMsgInfo();
    localRevokeMsgInfo.istroop = paramParcel.readInt();
    localRevokeMsgInfo.shmsgseq = paramParcel.readLong();
    localRevokeMsgInfo.frienduin = paramParcel.readString();
    localRevokeMsgInfo.bYF = paramParcel.readString();
    localRevokeMsgInfo.msguid = paramParcel.readLong();
    localRevokeMsgInfo.time = paramParcel.readLong();
    localRevokeMsgInfo.authorUin = paramParcel.readString();
    localRevokeMsgInfo.opType = paramParcel.readInt();
    localRevokeMsgInfo.dyl = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localRevokeMsgInfo.czE = bool;
      return localRevokeMsgInfo;
      bool = false;
    }
  }
  
  public RevokeMsgInfo[] a(int paramInt)
  {
    return new RevokeMsgInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvo
 * JD-Core Version:    0.7.0.1
 */