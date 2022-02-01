import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.emoticonview.EmotionPreviewInfo;

public final class afou
  implements Parcelable.Creator<EmotionPreviewInfo>
{
  public EmotionPreviewInfo a(Parcel paramParcel)
  {
    return new EmotionPreviewInfo(paramParcel);
  }
  
  public EmotionPreviewInfo[] a(int paramInt)
  {
    return new EmotionPreviewInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afou
 * JD-Core Version:    0.7.0.1
 */