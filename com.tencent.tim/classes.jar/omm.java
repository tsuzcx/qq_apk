import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushOpDialogModel;

public final class omm
  implements Parcelable.Creator<WSPushOpDialogModel>
{
  public WSPushOpDialogModel a(Parcel paramParcel)
  {
    return new WSPushOpDialogModel(paramParcel);
  }
  
  public WSPushOpDialogModel[] a(int paramInt)
  {
    return new WSPushOpDialogModel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omm
 * JD-Core Version:    0.7.0.1
 */