import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;

public final class axui
  implements Parcelable.Creator<DynamicTextItem.TextMap>
{
  public DynamicTextItem.TextMap a(Parcel paramParcel)
  {
    return new DynamicTextItem.TextMap(paramParcel);
  }
  
  public DynamicTextItem.TextMap[] a(int paramInt)
  {
    return new DynamicTextItem.TextMap[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axui
 * JD-Core Version:    0.7.0.1
 */