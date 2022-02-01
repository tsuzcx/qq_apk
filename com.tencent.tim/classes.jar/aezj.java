import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IPSiteModel.Gxzb;

public final class aezj
  implements Parcelable.Creator
{
  public IPSiteModel.Gxzb a(Parcel paramParcel)
  {
    IPSiteModel.Gxzb localGxzb = new IPSiteModel.Gxzb();
    localGxzb.appid = paramParcel.readInt();
    localGxzb.appName = paramParcel.readString();
    localGxzb.cover = paramParcel.readString();
    localGxzb.feeType = paramParcel.readInt();
    localGxzb.id = paramParcel.readString();
    localGxzb.name = paramParcel.readString();
    return localGxzb;
  }
  
  public IPSiteModel.Gxzb[] a(int paramInt)
  {
    return new IPSiteModel.Gxzb[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aezj
 * JD-Core Version:    0.7.0.1
 */