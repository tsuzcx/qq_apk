import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;

public final class alwi
  implements Parcelable.Creator<FilterCategory>
{
  public FilterCategory a(Parcel paramParcel)
  {
    return new FilterCategory(paramParcel);
  }
  
  public FilterCategory[] a(int paramInt)
  {
    return new FilterCategory[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwi
 * JD-Core Version:    0.7.0.1
 */