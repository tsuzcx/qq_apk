import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class adpl
  implements View.OnClickListener
{
  adpl(adpi paramadpi) {}
  
  public void onClick(View paramView)
  {
    if ((adpi.a(this.this$0) == null) || (adpi.a(this.this$0).size() <= 0) || (adpi.a(this.this$0) >= adpi.a(this.this$0).size()) || (adpi.a(this.this$0).get(adpi.a(this.this$0)) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = ((wyv)adpi.a(this.this$0).get(adpi.a(this.this$0))).getAppName();
      ArkAppCenter.a().post(str, new ArkAiAppPanel.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpl
 * JD-Core Version:    0.7.0.1
 */