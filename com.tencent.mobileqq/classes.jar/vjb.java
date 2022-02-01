import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushVideoModel;

public final class vjb
  implements Parcelable.Creator<WSPushVideoModel>
{
  public WSPushVideoModel a(Parcel paramParcel)
  {
    return new WSPushVideoModel(paramParcel);
  }
  
  public WSPushVideoModel[] a(int paramInt)
  {
    return new WSPushVideoModel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjb
 * JD-Core Version:    0.7.0.1
 */