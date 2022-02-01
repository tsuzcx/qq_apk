import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;

public final class mij
  implements Parcelable.Creator<UgcVideo>
{
  public UgcVideo a(Parcel paramParcel)
  {
    return new UgcVideo(paramParcel);
  }
  
  public UgcVideo[] a(int paramInt)
  {
    return new UgcVideo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mij
 * JD-Core Version:    0.7.0.1
 */