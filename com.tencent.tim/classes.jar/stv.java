import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.RecommendedListResp;

public final class stv
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stv
 * JD-Core Version:    0.7.0.1
 */