import android.content.Context;
import android.view.View;

public class ylx
  extends ymd
{
  protected ylx(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yny.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Ylv + " targetMode " + paramInt);
    ylt localylt;
    if (this.jdField_a_of_type_Ylv != null)
    {
      localylt = (ylt)this.jdField_a_of_type_Ylv;
      a();
      if (paramInt == 1)
      {
        a(localylt.jdField_a_of_type_AndroidViewView, localylt.jdField_a_of_type_Int, 0);
        a(localylt.f, localylt.j, localylt.k);
      }
    }
    else
    {
      return;
    }
    a(localylt.jdField_a_of_type_AndroidViewView, -localylt.jdField_a_of_type_Int, 0);
    a(localylt.f, -localylt.j, -localylt.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    ylt localylt = new ylt();
    localylt.jdField_a_of_type_AndroidViewView = paramView1;
    localylt.f = paramView2;
    localylt.g = paramView3;
    localylt.jdField_a_of_type_Int = ypk.a(-306, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localylt.j = ypk.a(-406, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localylt.k = ypk.a(125, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    float f = ypk.a(400, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localylt.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / ypk.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localylt.b = localylt.jdField_a_of_type_Float;
    }
    localylt.l = ypk.a(50, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localylt.m = ypk.a(-100, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    a(localylt, paramView4);
    this.jdField_a_of_type_Ylv = localylt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ylx
 * JD-Core Version:    0.7.0.1
 */