import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vdg
  implements View.OnClickListener
{
  vdg(vda paramvda) {}
  
  public void onClick(View paramView)
  {
    QLog.d("QCircleFolderSplashPart", 4, "btn onClick");
    vtq.a("", 20, vda.a(this.a));
    if (vda.c(this.a)) {}
    for (String str = "1";; str = "2")
    {
      vtq.a("", 19, 4, 0, str);
      uyy.a().a(false);
      vda.a(this.a);
      this.a.b("show_publish_feed_guide_bubble", null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdg
 * JD-Core Version:    0.7.0.1
 */