import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

final class yla
  extends FrameLayout
  implements yku
{
  private int jdField_a_of_type_Int = -2147483648;
  private ykr jdField_a_of_type_Ykr;
  private int b = -2147483648;
  
  public yla(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      yny.d("GdtBannerViewForCreativeSize193", "constructor");
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Ykr = new ykr(paramContext, paramString);
    this.jdField_a_of_type_Ykr.setId(2131301342);
    addView(this.jdField_a_of_type_Ykr);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.b <= 0) || (this.jdField_a_of_type_Ykr == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      yny.d("GdtBannerViewForCreativeSize193", "setSize error");
      return;
    }
    Object localObject = new ykz(getContext(), paramInt1, paramInt2);
    paramInt2 = Double.valueOf(1.0D * (paramInt1 - ((ykz)localObject).b * 2) / this.jdField_a_of_type_Int * this.b + ((ykz)localObject).b * 2).intValue();
    this.jdField_a_of_type_Ykr.setPadding(((ykz)localObject).b, ((ykz)localObject).b, ((ykz)localObject).b, ((ykz)localObject).b);
    localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    this.jdField_a_of_type_Ykr.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yla
 * JD-Core Version:    0.7.0.1
 */