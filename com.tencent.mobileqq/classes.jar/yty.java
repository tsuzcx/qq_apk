import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

final class yty
  extends FrameLayout
  implements yts
{
  private int jdField_a_of_type_Int = -2147483648;
  private ytp jdField_a_of_type_Ytp;
  private int b = -2147483648;
  
  public yty(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      yxp.d("GdtBannerViewForCreativeSize193", "constructor");
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Ytp = new ytp(paramContext, paramString);
    this.jdField_a_of_type_Ytp.setId(2131366951);
    addView(this.jdField_a_of_type_Ytp);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.b <= 0) || (this.jdField_a_of_type_Ytp == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      yxp.d("GdtBannerViewForCreativeSize193", "setSize error");
      return;
    }
    Object localObject = new ytx(getContext(), paramInt1, paramInt2);
    paramInt2 = Double.valueOf(1.0D * (paramInt1 - ((ytx)localObject).b * 2) / this.jdField_a_of_type_Int * this.b + ((ytx)localObject).b * 2).intValue();
    this.jdField_a_of_type_Ytp.setPadding(((ytx)localObject).b, ((ytx)localObject).b, ((ytx)localObject).b, ((ytx)localObject).b);
    localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    this.jdField_a_of_type_Ytp.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yty
 * JD-Core Version:    0.7.0.1
 */