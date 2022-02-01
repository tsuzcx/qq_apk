import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment;

public class kdj
  extends BroadcastReceiver
{
  public kdj(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("action_decode_finish".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = (Bitmap)paramIntent.getParcelableExtra("bitmap");
      if ((this.a.pUin != null) && (this.a.pUin.equals(paramContext)) && (paramIntent != null)) {
        this.a.icon.setImageBitmap(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
      } while ((!"action_follow_status_finish".equals(paramContext)) || (!String.valueOf(paramIntent.getStringExtra("uin")).equals(this.a.pUin)));
      this.a.Oe = paramIntent.getBooleanExtra("isFollow", false);
    } while (this.a.followBtn == null);
    if (this.a.Oe)
    {
      this.a.followBtn.setEnabled(false);
      this.a.followBtn.setBackgroundResource(0);
      return;
    }
    this.a.followBtn.setEnabled(true);
    this.a.followBtn.setBackgroundResource(2130847964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdj
 * JD-Core Version:    0.7.0.1
 */