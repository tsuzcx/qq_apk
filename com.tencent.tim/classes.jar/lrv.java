import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class lrv
  extends ViewBase
{
  private RelativeLayout mRoot;
  private TextView pW;
  
  public lrv(VafContext paramVafContext)
  {
    super(paramVafContext);
    e(paramVafContext);
  }
  
  private void e(VafContext paramVafContext)
  {
    this.mRoot = new RelativeLayout(paramVafContext.getContext());
    this.pW = new TextView(paramVafContext.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, Utils.dp2px(20.0D));
    this.mRoot.setLayoutParams(localLayoutParams);
    this.pW.setGravity(17);
    this.pW.setPadding(Utils.dp2px(5.0D), 0, Utils.dp2px(5.0D), 0);
    this.pW.setTextSize(2, 12.0F);
    this.pW.setTextColor(-1);
    this.pW.setCompoundDrawablesWithIntrinsicBounds(paramVafContext.getContext().getResources().getDrawable(2130843540), null, null, null);
    this.pW.setCompoundDrawablePadding(Utils.dp2px(2.0D));
    this.pW.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130843516));
    paramVafContext = new RelativeLayout.LayoutParams(-2, Utils.dp2px(20.0D));
    paramVafContext.addRule(11);
    this.mRoot.setPadding(0, 0, Utils.dp2px(12.0D), 0);
    this.mRoot.addView(this.pW, paramVafContext);
  }
  
  public int getComMeasuredHeight()
  {
    return this.mRoot.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return (int)(float)aqgz.hK();
  }
  
  public View getNativeView()
  {
    return this.mRoot;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRoot.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mRoot.measure(paramInt1, paramInt2);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    return false;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = super.setAttribute(paramInt, paramString);
    }
    do
    {
      do
      {
        return bool;
      } while (TextUtils.isEmpty(paramString));
      this.pW.setText(paramString);
      return true;
      paramInt = jzp.o(paramString, 0);
    } while (paramInt <= 0);
    this.mRoot.setPadding(0, 0, Utils.dp2px(paramInt), 0);
    return true;
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lrv(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrv
 * JD-Core Version:    0.7.0.1
 */