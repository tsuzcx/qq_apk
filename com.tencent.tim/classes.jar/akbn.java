import android.app.Activity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;

public class akbn
  extends sxz
{
  public akbn(PicBrowserActivity paramPicBrowserActivity) {}
  
  public sxg a(Activity paramActivity, sxm paramsxm)
  {
    return super.a(paramActivity, paramsxm);
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
 * Qualified Name:     akbn
 * JD-Core Version:    0.7.0.1
 */