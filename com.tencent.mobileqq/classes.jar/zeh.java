import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.PhoneInfo;

public final class zeh
  implements Parcelable.Creator<NewerGuidePlugin.PhoneInfo>
{
  public NewerGuidePlugin.PhoneInfo a(Parcel paramParcel)
  {
    return new NewerGuidePlugin.PhoneInfo(paramParcel);
  }
  
  public NewerGuidePlugin.PhoneInfo[] a(int paramInt)
  {
    return new NewerGuidePlugin.PhoneInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zeh
 * JD-Core Version:    0.7.0.1
 */