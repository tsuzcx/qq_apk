import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class pcz
{
  protected pdg b;
  protected Context mContext;
  protected ExtraTypeInfo mExtraTypeInfo;
  protected RecyclerView mRecyclerView;
  
  protected boolean D(View paramView)
  {
    Rect localRect;
    int j;
    if (paramView != null)
    {
      localRect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
      paramView.getGlobalVisibleRect(localRect);
      j = paramView.getHeight();
      if (localRect.bottom <= 0) {
        break label140;
      }
      if (localRect.bottom > ankt.cIE) {
        localRect.bottom = ankt.cIE;
      }
    }
    label140:
    for (int i = localRect.bottom - localRect.top;; i = 0)
    {
      float f = i / j;
      QLog.d(pdg.TAG, 4, f + "  " + localRect.bottom + "  " + localRect.top);
      return f >= 0.5D;
    }
  }
  
  public void a(Context paramContext, RecyclerView paramRecyclerView, pdg parampdg)
  {
    this.mContext = paramContext;
    this.mRecyclerView = paramRecyclerView;
    this.b = parampdg;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, rxy paramrxy, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void bhT() {}
  
  public void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {}
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {}
  
  public void onDestroy() {}
  
  public void onPageSelected(int paramInt) {}
  
  public void onPause() {}
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcz
 * JD-Core Version:    0.7.0.1
 */