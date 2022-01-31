import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

final class ytz
  extends LinearLayout
  implements yts
{
  private int jdField_a_of_type_Int = -2147483648;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ytp jdField_a_of_type_Ytp;
  private int b = -2147483648;
  
  public ytz(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      yxp.d("GdtBannerViewWithPictureText", "constructor");
      return;
    }
    setOrientation(0);
    setGravity(16);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Ytp = new ytp(paramContext, paramString1);
    this.jdField_a_of_type_Ytp.setId(2131366951);
    addView(this.jdField_a_of_type_Ytp);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131366954);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#333333"));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.b <= 0) || (this.jdField_a_of_type_Ytp == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      yxp.d("GdtBannerViewWithPictureText", "setSize error");
      return;
    }
    ytx localytx = new ytx(getContext(), paramInt1, paramInt2);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(Double.valueOf(1.0D * (paramInt2 - localytx.b * 2) / this.b * this.jdField_a_of_type_Int + localytx.b * 2).intValue(), paramInt2);
    this.jdField_a_of_type_Ytp.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Ytp.setPadding(localytx.b, localytx.b, localytx.b, localytx.b);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = localytx.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, localytx.d);
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytz
 * JD-Core Version:    0.7.0.1
 */