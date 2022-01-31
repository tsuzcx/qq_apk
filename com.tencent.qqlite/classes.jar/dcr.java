import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.ReportInfo;

public final class dcr
  implements Parcelable.Creator
{
  public MessageForPic a(Parcel paramParcel)
  {
    boolean bool2 = true;
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.path = paramParcel.readString();
    localMessageForPic.size = paramParcel.readLong();
    localMessageForPic.type = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localMessageForPic.isRead = bool1;
      localMessageForPic.uuid = paramParcel.readString();
      localMessageForPic.groupFileID = paramParcel.readLong();
      localMessageForPic.md5 = paramParcel.readString();
      localMessageForPic.serverStoreSource = paramParcel.readString();
      localMessageForPic.thumbMsgUrl = paramParcel.readString();
      localMessageForPic.thumbWidth = paramParcel.readInt();
      localMessageForPic.thumbHeight = paramParcel.readInt();
      localMessageForPic.bigMsgUrl = paramParcel.readString();
      localMessageForPic.rawMsgUrl = paramParcel.readString();
      localMessageForPic.fileSizeFlag = paramParcel.readInt();
      localMessageForPic.picExtraFlag = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label417;
      }
      bool1 = true;
      label163:
      localMessageForPic.isMixed = bool1;
      if (paramParcel.readInt() != 1) {
        break label422;
      }
    }
    label417:
    label422:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localMessageForPic.isShareAppActionMsg = bool1;
      localMessageForPic.action = paramParcel.readString();
      localMessageForPic.shareAppID = paramParcel.readLong();
      localMessageForPic.actMsgContentValue = paramParcel.readString();
      localMessageForPic.localUUID = paramParcel.readString();
      localMessageForPic.subMsgId = paramParcel.readInt();
      localMessageForPic.isReport = paramParcel.readInt();
      localMessageForPic.subVersion = paramParcel.readInt();
      localMessageForPic.busiType = paramParcel.readInt();
      localMessageForPic.width = paramParcel.readLong();
      localMessageForPic.height = paramParcel.readLong();
      localMessageForPic.imageType = paramParcel.readInt();
      localMessageForPic.frienduin = paramParcel.readString();
      localMessageForPic.selfuin = paramParcel.readString();
      localMessageForPic.senderuin = paramParcel.readString();
      localMessageForPic.istroop = paramParcel.readInt();
      localMessageForPic.versionCode = paramParcel.readInt();
      localMessageForPic.uniseq = paramParcel.readLong();
      localMessageForPic.issend = paramParcel.readInt();
      localMessageForPic.time = paramParcel.readLong();
      localMessageForPic.msgtype = paramParcel.readInt();
      localMessageForPic.preDownState = paramParcel.readInt();
      localMessageForPic.preDownNetworkType = paramParcel.readInt();
      localMessageForPic.previewed = paramParcel.readInt();
      localMessageForPic.reportInfo = ((ReportInfo)paramParcel.readParcelable(ReportInfo.class.getClassLoader()));
      return localMessageForPic;
      bool1 = false;
      break;
      bool1 = false;
      break label163;
    }
  }
  
  public MessageForPic[] a(int paramInt)
  {
    return new MessageForPic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dcr
 * JD-Core Version:    0.7.0.1
 */