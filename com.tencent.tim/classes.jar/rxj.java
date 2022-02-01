import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import java.util.ArrayList;
import java.util.List;

public class rxj
  extends rxk
{
  private QCircleBlockContainer b;
  private final int bvI;
  private int bvJ;
  private int bvK;
  private final ArrayList<rxq> nT = new ArrayList();
  
  public rxj()
  {
    this(0);
  }
  
  public rxj(int paramInt)
  {
    this(paramInt, null);
  }
  
  public rxj(int paramInt, List<rxq> paramList)
  {
    this(paramInt, paramList, 3, 1);
  }
  
  public rxj(int paramInt1, List<rxq> paramList, int paramInt2, int paramInt3)
  {
    if (paramList != null) {
      this.nT.addAll(paramList);
    }
    this.bvK = paramInt2;
    this.bvJ = paramInt3;
    this.bvI = paramInt1;
  }
  
  public QCircleBlockContainer a()
  {
    return this.b;
  }
  
  public QCircleStatusView a()
  {
    if (this.b != null) {
      return (QCircleStatusView)this.b.a();
    }
    return null;
  }
  
  public ArrayList<rxq> bx()
  {
    return this.nT;
  }
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    if (this.bvI != 0) {
      this.b = ((QCircleBlockContainer)paramView.findViewById(this.bvI));
    }
    if (this.b == null) {
      this.b = new QCircleBlockContainer(paramView.getContext());
    }
    this.b.setLayoutManagerType(this.bvK, this.bvJ);
    this.b.setBlockWrapper(this);
    this.b.setParentFragment(b());
    this.b.cx(this.nT);
    this.b.start();
  }
  
  public String getLogTag()
  {
    return "BlockPart";
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityDestroyed(paramActivity);
    }
    if (a() != null) {
      a().onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityStopped(paramActivity);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.b != null) && (this.b.onBackEvent())) {
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxj
 * JD-Core Version:    0.7.0.1
 */