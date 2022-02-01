import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;

public final class amcc
  implements Parcelable.Creator<AIOBrowserBaseData>
{
  public AIOBrowserBaseData a(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    try
    {
      localObject = AIOBrowserBaseData.a((String)localObject);
      ((AIOBrowserBaseData)localObject).readFromParcel(paramParcel);
      return localObject;
    }
    catch (ClassNotFoundException paramParcel)
    {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public AIOBrowserBaseData[] a(int paramInt)
  {
    return new AIOBrowserBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcc
 * JD-Core Version:    0.7.0.1
 */