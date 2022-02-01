import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class awly
  extends awlz
{
  private int mShadowColor;
  private float mShadowDx;
  private float mShadowDy;
  private float mShadowRadius;
  
  public awly(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  private int E(String paramString)
  {
    int j = 3;
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException(getClass().getName() + " setGravity value can not be null");
    }
    int i;
    if ("center".equals(paramString)) {
      i = 17;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while ("left".equals(paramString));
      i = j;
    } while (!"right".equals(paramString));
    return 5;
  }
  
  private void fK(String paramString)
  {
    try
    {
      ((TextView)this.ey).setTextSize(0, gi(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void setTextColor(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TextView)this.ey).setTextColor(Color.parseColor(paramString));
  }
  
  protected void RC()
  {
    super.RC();
    ((TextView)this.ey).setShadowLayer(this.mShadowRadius, this.mShadowDx, this.mShadowDy, this.mShadowColor);
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    super.setAttribute(paramString1, paramString2);
    if (!(this.ey instanceof TextView)) {}
    do
    {
      return;
      if ("content".equals(paramString1))
      {
        ((TextView)this.ey).setText(paramString2);
        return;
      }
      if ("text_color".equals(paramString1))
      {
        setTextColor(paramString2);
        return;
      }
      if ("text_align".equals(paramString1))
      {
        ((TextView)this.ey).setGravity(E(paramString2));
        return;
      }
      if ("max_lines".equals(paramString1))
      {
        ((TextView)this.ey).setMaxLines(Integer.parseInt(paramString2));
        return;
      }
      if ("shadow_color".equals(paramString1))
      {
        this.mShadowColor = Color.parseColor(paramString2);
        return;
      }
      if ("shadow_x".equals(paramString1))
      {
        this.mShadowDx = Float.parseFloat(paramString2);
        return;
      }
      if ("shadow_y".equals(paramString1))
      {
        this.mShadowDy = Float.parseFloat(paramString2);
        return;
      }
      if ("shadow_radius".equals(paramString1))
      {
        this.mShadowRadius = Float.parseFloat(paramString2);
        return;
      }
    } while (!"text_size".equals(paramString1));
    fK(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awly
 * JD-Core Version:    0.7.0.1
 */