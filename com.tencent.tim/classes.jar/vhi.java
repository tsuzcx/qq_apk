import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.MainFragment.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vhi
  extends MainFragment.c
{
  public vhi(MainFragment paramMainFragment)
  {
    super(null);
  }
  
  public void onClick(View paramView)
  {
    acep localacep = this.this$0.b();
    if ((localacep instanceof ReadinjoyTabFrame)) {
      ((ReadinjoyTabFrame)localacep).aXF();
    }
    lbz.a().aJr();
    MainFragment.b(MainFragment.a(this.this$0), MainFragment.a(this.this$0));
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhi
 * JD-Core Version:    0.7.0.1
 */