import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.1;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class akoz
  extends PopupWindow
  implements RadioGroup.OnCheckedChangeListener
{
  private akoz.a jdField_a_of_type_Akoz$a;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  
  private akoz(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131365396));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
  }
  
  public static akoz a(Activity paramActivity, List<akoz.b> paramList, int paramInt, akoz.a parama)
  {
    if ((paramActivity == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Resources localResources = paramActivity.getResources();
    int m = wja.dp2px(36.0F, localResources);
    int k = wja.dp2px(150.0F, localResources);
    View localView = LayoutInflater.from(paramActivity).inflate(2131561523, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131364056);
    RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131365396);
    Object localObject = null;
    int j = 0;
    int i = 78;
    RadioButton localRadioButton;
    if (j < paramList.size())
    {
      akoz.b localb = (akoz.b)paramList.get(j);
      localRadioButton = (RadioButton)LayoutInflater.from(paramActivity).inflate(2131561522, null);
      localRadioButton.setText(localb.bUe);
      localRadioButton.setTag(localb);
      localRadioButton.setId(j);
      if (j != paramInt) {
        break label297;
      }
      localRadioButton.setChecked(true);
      localObject = localRadioButton;
    }
    label297:
    for (;;)
    {
      localRadioGroup.addView(localRadioButton, j, new LinearLayout.LayoutParams(-1, -2));
      j += 1;
      i += m;
      break;
      paramInt = i;
      if (i > wja.dp2px(300.0F, localResources)) {
        paramInt = wja.dp2px(300.0F, localResources);
      }
      if (localObject != null) {
        localBounceScrollView.post(new TranslateLanguageOptionsView.1(localObject, localBounceScrollView));
      }
      paramActivity = new akoz(paramActivity, localView, k, paramInt);
      paramActivity.setAnimationStyle(2131755037);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setFocusable(true);
      paramActivity.setOutsideTouchable(true);
      paramActivity.a(parama);
      return paramActivity;
    }
  }
  
  public void a(akoz.a parama)
  {
    this.jdField_a_of_type_Akoz$a = parama;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    try
    {
      akoz.b localb = (akoz.b)((RadioButton)paramRadioGroup.getChildAt(paramInt)).getTag();
      if (this.jdField_a_of_type_Akoz$a != null) {
        this.jdField_a_of_type_Akoz$a.a(paramInt, localb);
      }
      dismiss();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, akoz.b paramb);
  }
  
  public static class b
  {
    public String bUe;
    public String languageCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akoz
 * JD-Core Version:    0.7.0.1
 */