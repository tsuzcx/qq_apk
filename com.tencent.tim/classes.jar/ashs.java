import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qidian.QidianProfileCardActivity.QidianCompoundProfileItem;

public final class ashs
  implements Parcelable.Creator<QidianProfileCardActivity.QidianCompoundProfileItem>
{
  public QidianProfileCardActivity.QidianCompoundProfileItem a(Parcel paramParcel)
  {
    boolean bool2 = true;
    QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
    localQidianCompoundProfileItem.uin = paramParcel.readString();
    localQidianCompoundProfileItem.name = paramParcel.readString();
    localQidianCompoundProfileItem.title = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localQidianCompoundProfileItem.isVerified = bool1;
      localQidianCompoundProfileItem.type = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQidianCompoundProfileItem.cNv = bool1;
      localQidianCompoundProfileItem.faceUrl = paramParcel.readString();
      localQidianCompoundProfileItem.cEP = paramParcel.readString();
      return localQidianCompoundProfileItem;
      bool1 = false;
      break;
    }
  }
  
  public QidianProfileCardActivity.QidianCompoundProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianCompoundProfileItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashs
 * JD-Core Version:    0.7.0.1
 */