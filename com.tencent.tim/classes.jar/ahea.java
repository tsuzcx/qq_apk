import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahea
  implements View.OnClickListener
{
  public ahea(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str2 = acfp.m(2131714265) + agmz.fN() + acfp.m(2131714271);
    String str1 = null;
    String str3 = acfp.m(2131714283);
    if (SendBottomBar.a(this.this$0).eA() != -1)
    {
      str2 = acfp.m(2131714289);
      str1 = acfp.m(2131714285);
      str3 = acfp.m(2131714282);
    }
    this.this$0.m = aqha.a(SendBottomBar.a(this.this$0), 230, str1, str2, acfp.m(2131714281), str3, new aheb(this), new ahec(this));
    this.this$0.m.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahea
 * JD-Core Version:    0.7.0.1
 */