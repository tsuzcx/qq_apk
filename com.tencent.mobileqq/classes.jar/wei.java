import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituResponse;

public final class wei
  implements Parcelable.Creator
{
  public ZhituResponse a(Parcel paramParcel)
  {
    return new ZhituResponse(paramParcel);
  }
  
  public ZhituResponse[] a(int paramInt)
  {
    return new ZhituResponse[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wei
 * JD-Core Version:    0.7.0.1
 */