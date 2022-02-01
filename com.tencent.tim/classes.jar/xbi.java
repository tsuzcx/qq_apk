import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.widget.QQToast;

class xbi
  extends ClickableSpan
{
  xbi(xbf paramxbf) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(this.a.mContext))
    {
      QQToast.a(this.a.mContext, acfp.m(2131705023), 2000).show();
      return;
    }
    paramView = new Intent();
    paramView.setFlags(268435456);
    paramView.setAction("android.intent.action.VIEW");
    paramView.putExtra("devlock_open_source", "SmartDeviceMsg");
    paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
    this.a.mContext.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbi
 * JD-Core Version:    0.7.0.1
 */