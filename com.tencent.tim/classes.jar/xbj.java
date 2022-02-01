import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;

class xbj
  extends ClickableSpan
{
  xbj(xbf paramxbf) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(this.a.mContext))
    {
      QQToast.a(this.a.mContext, acfp.m(2131705022), 2000).show();
      return;
    }
    paramView = new Intent(this.a.mContext, QQBrowserActivity.class);
    paramView.putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
    paramView.putExtra("hide_more_button", true);
    this.a.mContext.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbj
 * JD-Core Version:    0.7.0.1
 */