import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView.a;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.ProteusPagerSnapHelper.1;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class ltx
  extends auwv
  implements ProteusRecycleView.a
{
  private int aPK = 3000;
  private int aPL = 1000;
  private int aPQ = 20;
  private boolean alc;
  private ProteusRecycleView b;
  public Runnable cH = new ProteusPagerSnapHelper.1(this);
  
  public void a(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
    throws IllegalStateException
  {
    super.a(paramRecyclerViewCompat);
    this.b = ((ProteusRecycleView)paramRecyclerViewCompat);
  }
  
  public void aNu()
  {
    eA(this.aPK);
  }
  
  public void eA(long paramLong)
  {
    this.alc = true;
    this.b.removeCallbacks(this.cH);
    this.b.postDelayed(this.cH, paramLong);
    this.b.b(this);
    this.b.a(this);
  }
  
  @Nullable
  public View findCenterView(LinearLayoutManager paramLinearLayoutManager)
  {
    int i = paramLinearLayoutManager.getChildCount();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    OrientationHelper localOrientationHelper;
    do
    {
      View localView;
      do
      {
        return localObject;
        localOrientationHelper = getOrientationHelper(paramLinearLayoutManager);
        localView = paramLinearLayoutManager.getChildAt(0);
        localObject = localView;
      } while (Math.abs(localOrientationHelper.getDecoratedStart(localView)) < this.aPQ);
      if (i <= 1) {
        break;
      }
      localObject = paramLinearLayoutManager.getChildAt(i - 1);
      i = localOrientationHelper.getDecoratedEnd((View)localObject);
    } while (Math.abs(localOrientationHelper.getTotalSpace() - i) < this.aPQ);
    return super.findCenterView(paramLinearLayoutManager);
  }
  
  public void p(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      this.b.removeCallbacks(this.cH);
      return;
    } while (!this.alc);
    this.b.postDelayed(this.cH, this.aPK);
  }
  
  public void rv(int paramInt)
  {
    this.aPK = paramInt;
  }
  
  public void rw(int paramInt)
  {
    this.aPL = paramInt;
  }
  
  public void stopLoop()
  {
    this.alc = false;
    this.b.removeCallbacks(this.cH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltx
 * JD-Core Version:    0.7.0.1
 */