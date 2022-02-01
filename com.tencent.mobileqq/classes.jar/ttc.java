import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.qphone.base.util.QLog;

public class ttc
  extends NativeText
{
  protected String a;
  
  public ttc(VafContext paramVafContext)
  {
    super(paramVafContext);
    QLog.d("ReadInJoyIconText", 2, "ReadInJoyIconText create");
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    QLog.d("ReadInJoyIconText", 2, "key ->" + paramInt + " , value = " + paramString);
    if (paramInt == 1085)
    {
      if (paramString != null)
      {
        this.a = paramString;
        setDrawableLeft(null);
      }
      return true;
    }
    if (paramInt == 1086) {
      if (paramString != null)
      {
        int i = Utils.dp2px(nzv.a(paramString, 0));
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
    QLog.d("ReadInJoyIconText", 2, "setDrawableLeft drawableLeftPath->" + this.drawableLeftPath + " , drawableRightPath = " + this.a);
    if (this.drawableLeftPath != null) {}
    for (paramString = DrawableUtil.getDrawable(this.mNative.getContext(), this.drawableLeftPath, null, null);; paramString = null)
    {
      if (this.a != null) {}
      for (Drawable localDrawable = DrawableUtil.getDrawable(this.mNative.getContext(), this.a, null, null);; localDrawable = null)
      {
        this.mNative.setCompoundDrawablesWithIntrinsicBounds(paramString, null, localDrawable, null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttc
 * JD-Core Version:    0.7.0.1
 */