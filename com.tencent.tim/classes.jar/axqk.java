import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.data.TemplateData;

public final class axqk
  implements Parcelable.Creator<TemplateData>
{
  public TemplateData a(Parcel paramParcel)
  {
    return new TemplateData(paramParcel);
  }
  
  public TemplateData[] a(int paramInt)
  {
    return new TemplateData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqk
 * JD-Core Version:    0.7.0.1
 */