import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class oxx
  extends rxj
  implements rwx
{
  private ovs b;
  private PopupWindow mPopupWindow;
  
  public void biv()
  {
    if ((this.mPopupWindow != null) && (!this.mPopupWindow.isShowing()))
    {
      pco.h(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 8, 1L);
      if (this.b != null) {
        this.b.onRefreshData();
      }
      this.mPopupWindow.showAtLocation(a().getRootView(), 81, 0, 0);
    }
  }
  
  public void biw()
  {
    if ((this.mPopupWindow != null) && (this.mPopupWindow.isShowing())) {
      this.mPopupWindow.dismiss();
    }
  }
  
  protected void dC(View paramView)
  {
    this.b = new ovs(null);
    bx().add(this.b);
    super.dC(paramView);
    this.mPopupWindow = new PopupWindow(a(), -1, -1);
    this.mPopupWindow.setAnimationStyle(2131756060);
    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.mPopupWindow.setContentView(a());
    this.mPopupWindow.setOutsideTouchable(true);
    a().a().setBackgroundResource(2130844963);
    a().setBackgroundResource(2131165396);
    a().setOnClickListener(new oxy(this));
    a().setPadding(0, (int)(riw.getWindowScreenHeight(getContext()) * 0.6D), 0, 0);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTaskCenterEvent.class);
    return localArrayList;
  }
  
  public String getLogTag()
  {
    return "QCircleTaskCenterPart";
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    biw();
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    rwv.a().a(this);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    rwv.a().b(this);
  }
  
  public boolean onBackEvent()
  {
    if ((this.mPopupWindow != null) && (this.mPopupWindow.isShowing()))
    {
      biw();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof QCircleTaskCenterEvent)) || (((QCircleTaskCenterEvent)paramSimpleBaseEvent).mPopContextHashCode != getContext().hashCode())) {
      return;
    }
    if (((QCircleTaskCenterEvent)paramSimpleBaseEvent).mIsShowTaskPanel)
    {
      biv();
      return;
    }
    biw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxx
 * JD-Core Version:    0.7.0.1
 */