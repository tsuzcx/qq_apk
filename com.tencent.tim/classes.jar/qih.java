import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;

public final class qih
  implements Parcelable.Creator<AnimationParam>
{
  public AnimationParam a(Parcel paramParcel)
  {
    return new AnimationParam(paramParcel);
  }
  
  public AnimationParam[] a(int paramInt)
  {
    return new AnimationParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qih
 * JD-Core Version:    0.7.0.1
 */