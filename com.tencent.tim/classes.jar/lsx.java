import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeUsersCommentsView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class lsx
  extends ViewBase
{
  private static String TAG = "UsersCommentsView";
  private NativeUsersCommentsView a;
  
  public lsx(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeUsersCommentsView(paramVafContext.getContext());
    this.a.setOrientation(1);
  }
  
  public void clearDynamicData()
  {
    this.a.setComments(null);
    this.a.setCommentAllLink(null);
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
    this.a.refresh();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    if (!super.setAttribute(paramInt, paramObject)) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    try
    {
      this.a.setComments((JSONArray)paramObject);
      return true;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        QLog.e(TAG, 2, "UsersCommentsView", paramObject);
      }
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    if (!super.setAttribute(paramInt, paramString))
    {
      switch (paramInt)
      {
      default: 
        return false;
      }
      this.a.setCommentAllLink(paramString);
    }
    return true;
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lsx(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsx
 * JD-Core Version:    0.7.0.1
 */