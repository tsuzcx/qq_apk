import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.qphone.base.util.QLog;

public class kop
  extends NativeText
{
  protected String abw;
  
  public kop(VafContext paramVafContext)
  {
    super(paramVafContext);
    QLog.d("ReadInJoyIconText", 2, "ReadInJoyIconText create");
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    QLog.d("ReadInJoyIconText", 2, "key ->" + paramInt + " , value = " + paramString);
    if (paramInt == 1083)
    {
      if (paramString != null)
      {
        this.abw = paramString;
        setDrawableLeft(null);
      }
      return true;
    }
    if (paramInt == 1084) {
      if (paramString != null)
      {
        int i = Utils.dp2px(jzp.o(paramString, 0));
        this.mNative.setCompoundDrawablePadding(i);
      }
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramString);
      if (paramInt == 48)
      {
        Float localFloat = Utils.toFloat(paramString);
        if (localFloat != null)
        {
          this.mAlpha = localFloat.floatValue();
          getNativeView().setAlpha(this.mAlpha);
        }
        else
        {
          QLog.d("ReadInJoyIconText", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
        }
      }
    }
  }
  
  public void setDrawableLeft(String paramString)
  {
    QLog.d("ReadInJoyIconText", 2, "setDrawableLeft drawableLeftPath->" + this.drawableLeftPath + " , drawableRightPath = " + this.abw);
    if (this.drawableLeftPath != null) {}
    for (paramString = DrawableUtil.getDrawable(this.mNative.getContext(), this.drawableLeftPath, null, null);; paramString = null)
    {
      if (this.abw != null) {}
      for (Drawable localDrawable = DrawableUtil.getDrawable(this.mNative.getContext(), this.abw, null, null);; localDrawable = null)
      {
        this.mNative.setCompoundDrawablesWithIntrinsicBounds(paramString, null, localDrawable, null);
        return;
      }
    }
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new kop(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kop
 * JD-Core Version:    0.7.0.1
 */