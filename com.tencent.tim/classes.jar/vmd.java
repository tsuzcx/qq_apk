import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import java.util.ArrayList;

public final class vmd
  implements Parcelable.Creator<ProfileActivity.AllInOne>
{
  public ProfileActivity.AllInOne a(Parcel paramParcel)
  {
    boolean bool = true;
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(null);
    localAllInOne.uin = paramParcel.readString();
    localAllInOne.pa = paramParcel.readInt();
    localAllInOne.age = paramParcel.readInt();
    localAllInOne.gender = paramParcel.readByte();
    localAllInOne.faceId = ((short)paramParcel.readInt());
    localAllInOne.maritalStatus = paramParcel.readByte();
    localAllInOne.profession_id = paramParcel.readInt();
    localAllInOne.constellation = paramParcel.readByte();
    localAllInOne.xuanYan = paramParcel.createByteArray();
    localAllInOne.aOE = paramParcel.readString();
    localAllInOne.troopcode = paramParcel.readString();
    localAllInOne.troopUin = paramParcel.readString();
    localAllInOne.discussUin = paramParcel.readString();
    localAllInOne.pr = new ArrayList();
    paramParcel.readTypedList(localAllInOne.pr, ProfileActivity.CardContactInfo.CREATOR);
    localAllInOne.bIW = paramParcel.readInt();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      localAllInOne.aZe = bool;
      localAllInOne.aOF = paramParcel.readString();
      localAllInOne.bIX = paramParcel.readInt();
      localAllInOne.nickname = paramParcel.readString();
      localAllInOne.remark = paramParcel.readString();
      localAllInOne.alias = paramParcel.readString();
      localAllInOne.contactName = paramParcel.readString();
      localAllInOne.aOH = paramParcel.readString();
      localAllInOne.aOI = paramParcel.readString();
      localAllInOne.aOJ = paramParcel.readString();
      localAllInOne.bIZ = paramParcel.readInt();
      localAllInOne.bJa = paramParcel.readInt();
      localAllInOne.bJb = paramParcel.readInt();
      localAllInOne.cf = paramParcel.createByteArray();
      localAllInOne.bJc = paramParcel.readInt();
      localAllInOne.bJd = paramParcel.readInt();
      localAllInOne.encId = paramParcel.readString();
      localAllInOne.uid = paramParcel.readString();
      localAllInOne.Gz = paramParcel.readLong();
      localAllInOne.subSourceId = paramParcel.readInt();
      localAllInOne.aOK = paramParcel.readString();
      localAllInOne.data = ((Bundle)paramParcel.readParcelable(Bundle.class.getClassLoader()));
      localAllInOne.bIY = paramParcel.readInt();
      localAllInOne.ae = ((Bundle)paramParcel.readParcelable(Bundle.class.getClassLoader()));
      localAllInOne.ch = paramParcel.createByteArray();
      return localAllInOne;
      bool = false;
    }
  }
  
  public ProfileActivity.AllInOne[] a(int paramInt)
  {
    return new ProfileActivity.AllInOne[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmd
 * JD-Core Version:    0.7.0.1
 */