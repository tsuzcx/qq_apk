import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class awlx
  extends awlz
{
  public awlx(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  private int gh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException(getClass().getName() + " setGravity value can not be null");
    }
    if ("center".equals(paramString)) {
      return 13;
    }
    if ("center_horizontal".equals(paramString)) {
      return 14;
    }
    if ("center_vertical".equals(paramString)) {
      return 15;
    }
    return 9;
  }
  
  protected void a(String paramString1, String paramString2, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.a(paramString1, paramString2, paramLayoutParams);
    paramLayoutParams = (RelativeLayout.LayoutParams)paramLayoutParams;
    if ("gravity".equals(paramString1)) {
      paramLayoutParams.addRule(gh(paramString2));
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!"relative".equals(paramString1));
        paramString1 = paramString2.split(" ");
      } while ((paramString1 == null) || (paramString1.length != 2));
      if ("bottom".equals(paramString1[1]))
      {
        paramLayoutParams.addRule(3, Integer.parseInt(paramString1[0]));
        paramLayoutParams.addRule(5, Integer.parseInt(paramString1[0]));
        return;
      }
    } while (!"right".equals(paramString1[1]));
    paramLayoutParams.addRule(6, Integer.parseInt(paramString1[0]));
  }
  
  protected ViewGroup.LayoutParams b(int paramInt1, int paramInt2)
  {
    return new RelativeLayout.LayoutParams(paramInt1, paramInt2);
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    super.setAttribute(paramString1, paramString2);
    if (!(this.ey instanceof RelativeLayout)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlx
 * JD-Core Version:    0.7.0.1
 */