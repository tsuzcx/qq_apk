import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vbq
  implements View.OnClickListener
{
  vbq(vbk paramvbk) {}
  
  public void onClick(View paramView)
  {
    QLog.d("QCircleFolderSplashPart", 4, "btn onClick");
    vrf.a("", 20, vbk.a(this.a));
    if (vbk.c(this.a)) {}
    for (String str = "1";; str = "2")
    {
      vrf.a("", 19, 4, 0, str);
      uxp.a().a(false);
      vbk.a(this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbq
 * JD-Core Version:    0.7.0.1
 */