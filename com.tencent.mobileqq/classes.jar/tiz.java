import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushOpModel;

public final class tiz
  implements Parcelable.Creator<WSPushOpModel>
{
  public WSPushOpModel a(Parcel paramParcel)
  {
    return new WSPushOpModel(paramParcel);
  }
  
  public WSPushOpModel[] a(int paramInt)
  {
    return new WSPushOpModel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tiz
 * JD-Core Version:    0.7.0.1
 */