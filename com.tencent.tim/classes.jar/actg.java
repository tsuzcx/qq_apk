import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.widget.AlphaClickableButton;
import com.tencent.widget.AlphaClickableTextView;

public class actg
  implements LayoutInflater.Factory2
{
  private static final int[] ATTRS = { 16843087, 16843088, 16844078, 2131034746, 2131035140, 2131035331, 2131035329 };
  private Activity mActivity;
  
  public actg(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    TextView localTextView = null;
    if (paramString.equals("TextView")) {
      localTextView = new TextView(paramContext, paramAttributeSet);
    }
    do
    {
      return localTextView;
      if (paramString.equals("Button")) {
        return new Button(paramContext, paramAttributeSet);
      }
      if (paramString.endsWith("DragTextView")) {
        return new DragTextView(paramContext, paramAttributeSet);
      }
      if (paramString.equals("com.tencent.mobileqq.widget.FormSwitchItem")) {
        return new FormSwitchItem(paramContext, paramAttributeSet);
      }
      if (paramString.equals("com.tencent.mobileqq.widget.FormSimpleItem")) {
        return new FormSimpleItem(paramContext, paramAttributeSet);
      }
      if (paramString.equals("com.tencent.mobileqq.widget.FormSwitchSimpleItem")) {
        return new FormSwitchSimpleItem(paramContext, paramAttributeSet);
      }
      if (paramString.equals("com.tencent.mobileqq.widget.FormMultiLineSwitchItem")) {
        return new FormMultiLineSwitchItem(paramContext, paramAttributeSet);
      }
      if (paramString.equals("com.tencent.widget.AlphaClickableTextView")) {
        return new AlphaClickableTextView(paramContext, paramAttributeSet);
      }
    } while (!paramString.equals("com.tencent.widget.AlphaClickableButton"));
    return new AlphaClickableButton(paramContext, paramAttributeSet);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    paramView = a(paramString, paramContext, paramAttributeSet);
    if (paramView != null)
    {
      paramString = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
      int i = 0;
      if (i < ATTRS.length)
      {
        int j = paramString.getResourceId(i, 0);
        if (j == 0) {}
        for (;;)
        {
          i += 1;
          break;
          paramAttributeSet = paramContext.getString(j);
          switch (ATTRS[i])
          {
          default: 
            break;
          case 16843087: 
            if ((paramView instanceof TextView)) {
              ((TextView)paramView).setText(paramAttributeSet);
            } else if ((paramView instanceof Button)) {
              ((Button)paramView).setText(paramAttributeSet);
            } else if ((paramView instanceof FormSwitchItem)) {
              ((FormSwitchItem)paramView).setText(paramAttributeSet);
            }
            break;
          case 16843088: 
            if ((paramView instanceof TextView)) {
              ((TextView)paramView).setHint(paramAttributeSet);
            } else if ((paramView instanceof Button)) {
              ((Button)paramView).setHint(paramAttributeSet);
            }
            break;
          case 16844078: 
            if ((paramView instanceof TextView)) {
              ((TextView)paramView).setContentDescription(paramAttributeSet);
            } else if ((paramView instanceof Button)) {
              ((Button)paramView).setContentDescription(paramAttributeSet);
            }
            break;
          case 2131034746: 
            if ((paramView instanceof FormSimpleItem)) {
              ((FormSimpleItem)paramView).setLeftText(paramAttributeSet);
            }
            break;
          case 2131035140: 
            if ((paramView instanceof FormSimpleItem)) {
              ((FormSimpleItem)paramView).setRightText(paramAttributeSet);
            }
            break;
          case 2131035331: 
            if ((paramView instanceof FormSwitchItem)) {
              ((FormSwitchItem)paramView).setText(paramAttributeSet);
            }
            break;
          case 2131035329: 
            if ((paramView instanceof FormMultiLineSwitchItem)) {
              ((FormMultiLineSwitchItem)paramView).setSecendLineText(paramAttributeSet);
            }
            break;
          }
        }
      }
      paramString.recycle();
    }
    return paramView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     actg
 * JD-Core Version:    0.7.0.1
 */