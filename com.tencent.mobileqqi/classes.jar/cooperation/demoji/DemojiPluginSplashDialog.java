package cooperation.demoji;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DemojiPluginSplashDialog
  extends Dialog
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RelativeLayout b;
  
  public DemojiPluginSplashDialog(Context paramContext)
  {
    super(paramContext, 2131624477);
    setContentView(2130903653);
    a(paramContext);
  }
  
  private int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(Context paramContext)
  {
    int i = (int)(143.0F * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindow().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int j = localDisplayMetrics.widthPixels;
    j = localDisplayMetrics.widthPixels * 4 / 3;
    int k = localDisplayMetrics.heightPixels - j;
    boolean bool = true;
    if (k >= i)
    {
      bool = false;
      j = a(paramContext, 44.0F);
    }
    for (i = k - i + a(paramContext, 99.0F);; i = Math.max(k, a(paramContext, 55.0F)))
    {
      a(bool, j, i);
      return;
      j = a(paramContext, 44.0F);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233262));
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131233263));
      this.b = ((RelativeLayout)findViewById(2131233264));
    }
    for (this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233265));; this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233269)))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = paramInt1;
      this.b.getLayoutParams().height = paramInt2;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.b.setVisibility(0);
      if (paramInt2 < 178)
      {
        this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams().height = paramInt2;
        this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams().width = paramInt2;
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131233267));
      this.b = ((RelativeLayout)findViewById(2131233268));
    }
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.demoji.DemojiPluginSplashDialog
 * JD-Core Version:    0.7.0.1
 */