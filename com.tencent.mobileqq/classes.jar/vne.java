import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class vne
  implements View.OnClickListener
{
  vne(vmw paramvmw) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() instanceof Activity)) {
      this.a.a(0.0F, 0.0F);
    }
    ArrayList localArrayList = new ArrayList();
    if (vmw.a(this.a)) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(vtt.a("ext1", str));
      vtr.a(91, 2, this.a.a(), localArrayList, vmw.b(this.a));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vne
 * JD-Core Version:    0.7.0.1
 */