import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pdg
  extends RecyclerView.OnScrollListener
{
  public static String TAG = "QCircleFeedScrollHelper";
  public static int bho = -1;
  public static int bhp;
  public static int bhq = 1;
  public static float lK = 200.0F;
  public static float lL = 3.0F;
  private boolean azr;
  private int bhr;
  private int bhs;
  private List<pcz> lC = new ArrayList();
  private final Context mContext;
  private final RecyclerView mRecycleView;
  private long zL;
  
  public pdg(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.mContext = paramContext;
    this.mRecycleView = paramRecyclerView;
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt1, rxy paramrxy, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      ((pcz)localIterator.next()).a(paramRecyclerView, paramInt1, paramrxy, paramInt2, paramInt3, paramInt4, paramInt5, this.azr);
    }
  }
  
  private void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      ((pcz)localIterator.next()).a(paramRecyclerView, paramInt1, paramInt2, paramBoolean);
    }
  }
  
  private void rq(boolean paramBoolean)
  {
    int[] arrayOfInt = y();
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      ((pcz)localIterator.next()).d(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3], paramBoolean);
    }
  }
  
  private int[] y()
  {
    int[] arrayOfInt1 = new int[4];
    try
    {
      if ((this.mRecycleView != null) && ((this.mRecycleView.getLayoutManager() instanceof rxy)))
      {
        Object localObject = (rxy)this.mRecycleView.getLayoutManager();
        int[] arrayOfInt2 = ((rxy)localObject).findFirstVisibleItemPositions(null);
        int[] arrayOfInt3 = ((rxy)localObject).findLastVisibleItemPositions(null);
        int[] arrayOfInt4 = ((rxy)localObject).findFirstCompletelyVisibleItemPositions(null);
        localObject = ((rxy)localObject).findLastCompletelyVisibleItemPositions(null);
        arrayOfInt1[0] = arrayOfInt2[0];
        arrayOfInt1[1] = arrayOfInt3[0];
        arrayOfInt1[2] = arrayOfInt4[0];
        arrayOfInt1[3] = localObject[0];
        QLog.d(TAG, 4, "computePosition result: " + arrayOfInt1[0] + " " + arrayOfInt1[1] + "  " + arrayOfInt1[2] + "  " + arrayOfInt1[3]);
      }
      return arrayOfInt1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt1;
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      ((pcz)localIterator.next()).a(paramExtraTypeInfo);
    }
  }
  
  public void a(pcz parampcz)
  {
    if (parampcz != null)
    {
      parampcz.a(this.mContext, this.mRecycleView, this);
      this.lC.add(parampcz);
    }
  }
  
  public void bjJ()
  {
    this.bhr = bho;
    this.bhs = 0;
    this.zL = 0L;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      ((pcz)localIterator.next()).onAttachedToRecyclerView(paramRecyclerView);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      ((pcz)localIterator.next()).onPause();
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    rxy localrxy = (rxy)this.mRecycleView.getLayoutManager();
    int[] arrayOfInt = y();
    a(paramRecyclerView, paramInt, localrxy, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (paramInt2 >= 0)
    {
      this.azr = true;
      if ((this.bhr != bhp) && (this.bhr != bho))
      {
        bjJ();
        QLog.d(TAG, 4, "change orient to up:" + this.bhr);
      }
      if (this.zL == 0L) {
        this.zL = System.currentTimeMillis();
      }
      this.bhs += paramInt2;
      this.bhr = bhp;
      float f = (float)(System.currentTimeMillis() - this.zL);
      if (f > lK)
      {
        bjJ();
        if (Math.abs(this.bhs / f) < lL)
        {
          if (paramInt2 < 0) {
            break label265;
          }
          bool1 = true;
          label147:
          rq(bool1);
        }
      }
      if (paramInt2 < 0) {
        break label271;
      }
    }
    label265:
    label271:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      b(paramRecyclerView, paramInt1, paramInt2, bool1);
      return;
      this.azr = false;
      if ((this.bhr != bhq) && (this.bhr != bho))
      {
        bjJ();
        QLog.d(TAG, 4, "change orient to down:" + this.bhr);
      }
      if (this.zL == 0L) {
        this.zL = System.currentTimeMillis();
      }
      this.bhs += paramInt2;
      this.bhr = bhq;
      break;
      bool1 = false;
      break label147;
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      ((pcz)localIterator.next()).onViewAttachedToWindow(paramViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    Iterator localIterator = this.lC.iterator();
    while (localIterator.hasNext()) {
      ((pcz)localIterator.next()).onViewDetachedFromWindow(paramViewHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdg
 * JD-Core Version:    0.7.0.1
 */