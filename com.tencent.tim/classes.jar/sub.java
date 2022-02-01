import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class sub
  implements View.OnClickListener
{
  sub(stw paramstw) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.this$0.mRuntime.getActivity();
    if (localActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((stw.fZ != null) && (!TextUtils.isEmpty(stw.a(this.this$0))))
      {
        obe localobe = (obe)stw.fZ.get(stw.a(this.this$0));
        if (localobe != null) {
          if (localobe.getStatus() == 3)
          {
            localobe.doRefresh();
            this.this$0.bAM();
            localobe.setStatus(4);
            if (this.this$0.gc != null) {
              this.this$0.gc.setVisibility(8);
            }
            stw.fZ.remove(stw.a(this.this$0));
          }
          else if (localobe.getStatus() == 0)
          {
            jpa.a(localActivity.getApplicationContext(), stw.a(this.this$0), localobe.mDownloadUrl, localobe.aCy, localobe);
            localobe.setStatus(1);
            if (this.this$0.AY != null) {
              this.this$0.AY.setCompoundDrawables(null, null, null, null);
            }
            this.this$0.mCheckupHandler.postDelayed(this.this$0.dC, 2000L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sub
 * JD-Core Version:    0.7.0.1
 */