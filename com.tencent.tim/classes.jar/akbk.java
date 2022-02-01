import android.app.Activity;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;

public class akbk
  extends sxz
{
  public akbk(NearbyProfilePicBrowserActivity paramNearbyProfilePicBrowserActivity) {}
  
  public sxg a(Activity paramActivity, sxm paramsxm)
  {
    return new akbl(paramActivity, paramsxm);
  }
  
  public sxi a(Activity paramActivity, sxm paramsxm)
  {
    return new akbp((PicBrowserActivity)paramActivity, paramsxm);
  }
  
  public sxm a(Activity paramActivity)
  {
    paramActivity = new akbt(this.a, this.a.mPicInfos);
    paramActivity.setSelectedIndex(this.a.mIndex);
    return paramActivity;
  }
  
  public sxn a(Activity paramActivity, sxm paramsxm)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbk
 * JD-Core Version:    0.7.0.1
 */