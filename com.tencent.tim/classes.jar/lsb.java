import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.qphone.base.util.QLog;

public class lsb
  extends ViewBase
{
  private lae a;
  private boolean ajo;
  private NativeReadInjoyImageView l;
  ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new lsc(this);
  
  public lsb(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.l = new NativeReadInjoyImageView(paramVafContext.getContext());
    if (this.l.getViewTreeObserver() != null) {
      this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.l.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.l.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.l;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.l.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.l.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.l.setBackgroundColor(this.mBackground);
  }
  
  public void pauseAnimation()
  {
    if (this.a != null) {
      this.a.pauseAnimation();
    }
  }
  
  public void resumeAnimation()
  {
    if (this.a != null) {
      this.a.resumeAnimation();
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    }
    try
    {
      this.a = lae.a(paramString);
      this.l.setImageDrawable(this.a);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyLottieView", 1, paramString.getMessage());
    }
    return true;
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lsb(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsb
 * JD-Core Version:    0.7.0.1
 */