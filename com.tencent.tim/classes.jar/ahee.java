import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar.7.1;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahee
  implements View.OnClickListener
{
  public ahee(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.a(this.this$0, true);
      new Handler().postDelayed(new SendBottomBar.7.1(this), 800L);
      SendBottomBar.b(this.this$0);
      switch (SendBottomBar.a(this.this$0).DX())
      {
      case 2: 
      case 3: 
      case 4: 
      case 6: 
      default: 
        if (!AppNetConnInfo.isNetSupport()) {
          ahao.OS(2131696206);
        }
        break;
      case 7: 
        SendBottomBar.c(this.this$0);
        break;
      case 1: 
        SendBottomBar.d(this.this$0);
        break;
      case 5: 
        SendBottomBar.e(this.this$0);
        break;
      case 8: 
        SendBottomBar.f(this.this$0);
        break;
      case 9: 
        this.this$0.dmR();
        break;
      case 10: 
        new auge(SendBottomBar.a(this.this$0), SendBottomBar.a(this.this$0)).euN();
        continue;
        int j = SendBottomBar.a(this.this$0).DW();
        if (j == 1) {}
        for (int i = 1;; i = 0)
        {
          if (j != 5) {
            break label249;
          }
          this.this$0.dmE();
          break;
        }
        label249:
        if (i != 0) {
          SendBottomBar.a(this.this$0, true);
        } else {
          SendBottomBar.g(this.this$0);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahee
 * JD-Core Version:    0.7.0.1
 */