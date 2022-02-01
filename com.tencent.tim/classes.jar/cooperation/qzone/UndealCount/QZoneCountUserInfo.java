package cooperation.qzone.UndealCount;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import avse;
import awck;
import com.qq.taf.jce.JceInputStream;
import java.util.ArrayList;

public class QZoneCountUserInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QZoneCountUserInfo> CREATOR = new avse();
  public PassiveFeedsPush a;
  public int iYellowLevel;
  public int iYellowType;
  public byte isAnnualVip;
  public String nickName;
  public long uin;
  public ArrayList<feed_info> vec_feedInfos;
  
  public QZoneCountUserInfo() {}
  
  public QZoneCountUserInfo(Parcel paramParcel)
  {
    this.uin = paramParcel.readLong();
    this.iYellowType = paramParcel.readInt();
    this.iYellowLevel = paramParcel.readInt();
    this.isAnnualVip = paramParcel.readByte();
    this.a = ((PassiveFeedsPush)awck.decodeWup(PassiveFeedsPush.class, paramParcel.createByteArray()));
    this.vec_feedInfos = a(paramParcel);
    this.nickName = paramParcel.readString();
  }
  
  @NonNull
  private ArrayList<feed_info> a(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new feed_info());
    try
    {
      paramParcel = paramParcel.createByteArray();
      if ((paramParcel != null) && (paramParcel.length != 0))
      {
        paramParcel = new JceInputStream(paramParcel);
        paramParcel.setServerEncoding("utf8");
        paramParcel = (ArrayList)paramParcel.read(localArrayList, 0, false);
        return paramParcel;
      }
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
      return null;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof QZoneCountUserInfo))
    {
      paramObject = (QZoneCountUserInfo)paramObject;
      if ((this.uin != paramObject.uin) || (this.iYellowType != paramObject.iYellowType) || (this.isAnnualVip == paramObject.isAnnualVip) || (this.iYellowLevel == paramObject.iYellowLevel)) {
        bool = false;
      }
      do
      {
        do
        {
          return bool;
          if ((this.a != null) && (paramObject.a != null)) {
            break;
          }
        } while (this.a == paramObject.a);
        return false;
        if ((this.a.stBubbleSkin != null) && (paramObject.a.stBubbleSkin != null)) {
          break;
        }
      } while (this.a.stBubbleSkin == paramObject.a.stBubbleSkin);
      return false;
      return TextUtils.equals(this.a.stBubbleSkin.strBubbleZipUrl, paramObject.a.stBubbleSkin.strBubbleZipUrl);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    paramParcel.writeLong(this.uin);
    paramParcel.writeInt(this.iYellowType);
    paramParcel.writeInt(this.iYellowLevel);
    paramParcel.writeByte(this.isAnnualVip);
    if (this.a == null)
    {
      localObject1 = null;
      paramParcel.writeByteArray((byte[])localObject1);
      if (this.vec_feedInfos != null) {
        break label84;
      }
    }
    label84:
    for (Object localObject1 = localObject2;; localObject1 = awck.b(this.vec_feedInfos))
    {
      paramParcel.writeByteArray((byte[])localObject1);
      paramParcel.writeString(this.nickName);
      return;
      localObject1 = awck.encodeWup(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.UndealCount.QZoneCountUserInfo
 * JD-Core Version:    0.7.0.1
 */