import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment;

public class kdk
  extends acje
{
  public kdk(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void m(boolean paramBoolean, String paramString)
  {
    if (this.a.followBtn != null)
    {
      if ((paramBoolean) && (this.a.pUin != null) && (this.a.pUin.equals(paramString)))
      {
        this.a.followBtn.setEnabled(false);
        this.a.followBtn.setBackgroundResource(0);
      }
    }
    else {
      return;
    }
    this.a.followBtn.setEnabled(true);
    this.a.followBtn.setBackgroundResource(2130847964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdk
 * JD-Core Version:    0.7.0.1
 */