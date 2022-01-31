import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

final class yld
  extends LinearLayout
  implements yku
{
  private int jdField_a_of_type_Int = -2147483648;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ykr jdField_a_of_type_Ykr;
  private int jdField_b_of_type_Int = -2147483648;
  private ykr jdField_b_of_type_Ykr;
  private ykr c;
  
  public yld(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      yny.d("GdtBannerViewForCreativeSize285", "constructor");
      return;
    }
    setOrientation(1);
    setGravity(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    addView(localLinearLayout, localLayoutParams);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Ykr = new ykr(paramContext, paramString1);
    this.jdField_a_of_type_Ykr.setId(2131301342);
    localLinearLayout.addView(this.jdField_a_of_type_Ykr);
    this.jdField_b_of_type_Ykr = new ykr(paramContext, paramString2);
    this.jdField_b_of_type_Ykr.setId(2131301343);
    localLinearLayout.addView(this.jdField_b_of_type_Ykr);
    this.c = new ykr(paramContext, paramString3);
    this.c.setId(2131301344);
    localLinearLayout.addView(this.c);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131301345);
    this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#333333"));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString4);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_Ykr == null) || (this.jdField_b_of_type_Ykr == null) || (this.c == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      yny.d("GdtBannerViewForCreativeSize285", "setSize error");
      return;
    }
    ykz localykz = new ykz(getContext(), paramInt1, paramInt2);
    paramInt2 = Double.valueOf((paramInt1 - localykz.jdField_a_of_type_Int * 2) * 1.0D / 3.0D).intValue();
    int i = Double.valueOf((paramInt2 - localykz.jdField_b_of_type_Int * 2) * 1.0D / this.jdField_a_of_type_Int * this.jdField_b_of_type_Int + localykz.jdField_b_of_type_Int * 2).intValue();
    paramInt1 = Double.valueOf(0.839285714285714D * paramInt1).intValue();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
    localLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_Ykr.setPadding(localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int);
    this.jdField_a_of_type_Ykr.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
    localLayoutParams.leftMargin = localykz.jdField_a_of_type_Int;
    this.jdField_b_of_type_Ykr.setPadding(localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int);
    this.jdField_b_of_type_Ykr.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
    localLayoutParams.leftMargin = localykz.jdField_a_of_type_Int;
    this.c.setPadding(localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int, localykz.jdField_b_of_type_Int);
    this.c.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(paramInt1, -2);
    localLayoutParams.topMargin = localykz.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, localykz.d);
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yld
 * JD-Core Version:    0.7.0.1
 */