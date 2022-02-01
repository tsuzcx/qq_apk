import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyProgressView.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import org.json.JSONException;
import org.json.JSONObject;

public class lss
  extends NativeText
{
  public RectF D = new RectF();
  public RectF E = new RectF();
  public Paint aB = new Paint();
  private String afu;
  private String afv;
  private int mProgress;
  
  public lss(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new ReadInjoyProgressView.1(this, paramVafContext.getContext());
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mNative.setBackgroundColor(0);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof JSONObject)) {
      paramObject = (JSONObject)paramObject;
    }
    try
    {
      this.mProgress = paramObject.getInt("progress");
      this.afu = paramObject.getString("bgcolor");
      this.afv = paramObject.getString("fgcolor");
      return true;
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lss(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lss
 * JD-Core Version:    0.7.0.1
 */