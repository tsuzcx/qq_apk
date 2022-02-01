import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class apdk
  implements View.OnTouchListener
{
  apdk(apdj paramapdj, String paramString, apdj.a parama) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = new Intent(this.this$0.fs.getContext(), QQBrowserActivity.class);
      paramMotionEvent = aqqj.getUrl("troopEnterEffect");
      paramView.putExtra("url", paramMotionEvent + "&gc=" + this.this$0.cov);
      this.this$0.fs.getContext().startActivity(paramView);
      apdr.b("Grp_AIO", "action_clk", new String[] { this.this$0.cov });
      VasWebviewUtil.reportCommercialDrainage(this.aOy, "style", "0X8008E63", "", 1, 0, 0, "", Integer.toString(this.a.id), "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdk
 * JD-Core Version:    0.7.0.1
 */