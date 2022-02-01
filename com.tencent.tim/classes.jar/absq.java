import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;

public final class absq
  implements Parcelable.Creator<IPCSpriteContext>
{
  public IPCSpriteContext a(Parcel paramParcel)
  {
    return new IPCSpriteContext(paramParcel);
  }
  
  public IPCSpriteContext[] a(int paramInt)
  {
    return new IPCSpriteContext[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absq
 * JD-Core Version:    0.7.0.1
 */