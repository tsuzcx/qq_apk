import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;

public final class omo
  implements Parcelable.Creator<WSPushPreloadModel>
{
  public WSPushPreloadModel a(Parcel paramParcel)
  {
    return new WSPushPreloadModel(paramParcel);
  }
  
  public WSPushPreloadModel[] a(int paramInt)
  {
    return new WSPushPreloadModel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omo
 * JD-Core Version:    0.7.0.1
 */