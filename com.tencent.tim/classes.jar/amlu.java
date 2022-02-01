import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;

public abstract class amlu<M extends ampu, V extends amxw>
  extends amlt<M, V>
  implements aqdf.a, AbsListView.e
{
  protected aqdf a;
  protected int mScrollState = 0;
  private ListView s;
  
  public amlu(ListView paramListView, aqdf paramaqdf)
  {
    this.s = paramListView;
    this.a = paramaqdf;
    paramaqdf.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.a.isPausing()) && ((this.mScrollState == 0) || (this.mScrollState == 1)))
    {
      int i = this.s.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        ampu localampu = (ampu)this.s.getChildAt(paramInt1).getTag(2131381960);
        if ((localampu != null) && (localampu.pG() == paramInt2) && (paramString.equals(localampu.getUin())))
        {
          amsp localamsp = (amsp)this.s.getChildAt(paramInt1).getTag(2131381962);
          amxw localamxw = (amxw)this.s.getChildAt(paramInt1).getTag(2131381965);
          if ((localamsp != null) && (localamxw != null)) {
            localamsp.a(localampu, localamxw, paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.s == null) {}
    for (;;)
    {
      return;
      this.mScrollState = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.a.isPausing()) {
        this.a.resume();
      }
      int i = this.s.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        ampu localampu = (ampu)this.s.getChildAt(paramInt).getTag(2131381960);
        amsp localamsp = (amsp)this.s.getChildAt(paramInt).getTag(2131381962);
        amxw localamxw = (amxw)this.s.getChildAt(paramInt).getTag(2131381965);
        if ((localamsp != null) && (localampu != null) && (paramAbsListView != null)) {
          localamsp.a(localampu, localamxw);
        }
        paramInt += 1;
      }
    }
    this.a.edu();
    this.a.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlu
 * JD-Core Version:    0.7.0.1
 */