import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;

public class lsd
  extends ViewBase
{
  private String TAG = "ReadInJoyMiddleBodyView";
  private NativeMiddleBodyView a;
  
  public lsd(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeMiddleBodyView(paramVafContext.getContext());
  }
  
  public boolean CF()
  {
    return (this.mPaddingLeft > 0) || (this.mPaddingRight > 0);
  }
  
  public void e(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (CF()) {
      paramLayoutParams.setMargins(0, 0, 0, 0);
    }
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
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof JSONArray));
      paramObject = (JSONArray)paramObject;
      bool1 = bool2;
    } while (paramObject.length() < 4);
    try
    {
      this.a.setRadius(paramObject.getString(0), paramObject.getString(1), paramObject.getString(2), paramObject.getString(3));
      return true;
    }
    catch (JSONException paramObject)
    {
      QLog.d(this.TAG, 2, "", paramObject);
    }
    return true;
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lsd(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsd
 * JD-Core Version:    0.7.0.1
 */