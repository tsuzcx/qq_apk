import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;

public class lse
  extends ViewBase
{
  private NativeShareView a;
  
  public lse(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeShareView(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.a.setScreenBitmap(paramBitmap);
  }
  
  public void setCurrentPath(String paramString)
  {
    this.a.setCurrentPath(paramString);
  }
  
  public void setInitRunnable(Runnable paramRunnable)
  {
    this.a.setInitRunnable(paramRunnable);
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lse(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lse
 * JD-Core Version:    0.7.0.1
 */