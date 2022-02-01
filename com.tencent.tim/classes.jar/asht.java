import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem;

public final class asht
  implements Parcelable.Creator<QidianProfileCardActivity.QidianSimpleProfileItem>
{
  public QidianProfileCardActivity.QidianSimpleProfileItem a(Parcel paramParcel)
  {
    boolean bool2 = true;
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.title = paramParcel.readString();
    localQidianSimpleProfileItem.content = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localQidianSimpleProfileItem.isClickable = bool1;
      localQidianSimpleProfileItem.type = paramParcel.readInt();
      localQidianSimpleProfileItem.aqA = paramParcel.readInt();
      localQidianSimpleProfileItem.action = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label109;
      }
      bool1 = true;
      label80:
      localQidianSimpleProfileItem.cNv = bool1;
      if (paramParcel.readByte() == 0) {
        break label114;
      }
    }
    label109:
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQidianSimpleProfileItem.deA = bool1;
      return localQidianSimpleProfileItem;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  public QidianProfileCardActivity.QidianSimpleProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianSimpleProfileItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asht
 * JD-Core Version:    0.7.0.1
 */