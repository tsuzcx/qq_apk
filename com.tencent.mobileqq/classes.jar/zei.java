import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.RecommendedListResp;

public final class zei
  implements Parcelable.Creator<NewerGuidePlugin.RecommendedListResp>
{
  public NewerGuidePlugin.RecommendedListResp a(Parcel paramParcel)
  {
    return new NewerGuidePlugin.RecommendedListResp(paramParcel);
  }
  
  public NewerGuidePlugin.RecommendedListResp[] a(int paramInt)
  {
    return new NewerGuidePlugin.RecommendedListResp[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zei
 * JD-Core Version:    0.7.0.1
 */