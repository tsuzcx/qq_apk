import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGifView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class lrx
  extends ViewBase
{
  private NativeGifView a;
  
  public lrx(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeGifView(paramVafContext.getContext());
  }
  
  private boolean CE()
  {
    return this.mParams.mLayoutHeight * this.mParams.mLayoutWidth > 2000000;
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
    this.a.setGifHeight(this.mParams.mLayoutHeight);
    this.a.setGifWidth(this.mParams.mLayoutWidth);
    this.a.setIsBigImg(CE());
    this.a.setBackgroundColor(this.mBackground);
    this.a.cI(this.mParams.mLayoutWidth, this.mParams.mLayoutHeight);
    this.a.invalidate();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    case 59: 
      try
      {
        this.mParams.mLayoutWidth = ((Integer)paramObject).intValue();
        this.a.requestLayout();
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
        }
      }
    }
    try
    {
      this.mParams.mLayoutHeight = ((Integer)paramObject).intValue();
      this.a.requestLayout();
      return true;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
      }
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramString);
    }
    for (;;)
    {
      return bool1;
      this.a.setGifUrl(paramString);
      return true;
      this.a.setCoverUrl(paramString);
      return true;
      try
      {
        paramString = Utils.toInteger(paramString);
        bool1 = bool2;
        if (this.a != null)
        {
          bool1 = bool2;
          if (paramString != null)
          {
            this.a.setScaleType(paramString.intValue());
            return true;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.d("ReadInJoyGifView", 2, paramString.getMessage());
      }
    }
    return true;
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lrx(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrx
 * JD-Core Version:    0.7.0.1
 */