import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;

public class zef
  implements TipsBarTask
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  
  zef(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    Resources localResources = paramContext.getResources();
    Object localObject = new ImageView(paramContext);
    ((ImageView)localObject).setId(2131362447);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = AIOUtils.a(12.0F, localResources);
    ((ImageView)localObject).setImageResource(2130838006);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131362448);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    localObject = new RelativeLayout.LayoutParams(-2, AIOUtils.a(44.0F, localResources));
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131362447);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131362449);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(8.0F, localResources);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(8.0F, localResources);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131362449);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(12.0F, localResources);
    paramContext.setBackgroundResource(2130838064);
    paramContext.setPadding(AIOUtils.a(8.0F, localResources), AIOUtils.a(4.0F, localResources), AIOUtils.a(8.0F, localResources), AIOUtils.a(4.0F, localResources));
    paramContext.setText("快速加入");
    paramContext.setTextSize(2, 14.0F);
    paramContext.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    paramContext.setOnClickListener(paramOnClickListener);
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%d人正在玩%s。", new Object[] { Long.valueOf(paramLong), paramString }));
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setSelected(true);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zef
 * JD-Core Version:    0.7.0.1
 */