import android.view.View;
import com.tencent.qphone.base.util.BaseApplication;

public class tmx
  implements tpx
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int = vms.d(BaseApplication.getContext());
  private int b = -1;
  private int c = -1;
  
  public tmx(tmv paramtmv) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Tmv.a() != 0) {
      return;
    }
    this.c = paramInt;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Tmv.a() != 0) {
      return;
    }
    if (this.b == -1) {
      this.b = paramInt1;
    }
    if (this.b != paramInt1)
    {
      this.b = paramInt1;
      this.jdField_a_of_type_Float = paramFloat;
    }
    if (this.jdField_a_of_type_Float > 0.5D)
    {
      this.jdField_a_of_type_Tmv.a.setTranslationY(this.jdField_a_of_type_Int - paramInt2);
      return;
    }
    this.jdField_a_of_type_Tmv.a.setTranslationY(-paramInt2);
  }
  
  public void b(int paramInt)
  {
    urk.a("Q.qqstory.playernew.LoadingMoreWidget", "onPageScrollStateChanged newState=%d visible=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Tmv.a()));
    if (this.jdField_a_of_type_Tmv.a() != 0) {}
    do
    {
      do
      {
        return;
        if (paramInt == 1)
        {
          this.jdField_a_of_type_Float = -1.0F;
          this.b = -1;
          this.c = -1;
          this.jdField_a_of_type_Tmv.a.clearAnimation();
          return;
        }
      } while (paramInt != 0);
      if (this.jdField_a_of_type_Float < 0.5D)
      {
        this.jdField_a_of_type_Tmv.a.setTranslationY(0.0F);
        return;
      }
    } while (this.c == -1);
    this.jdField_a_of_type_Tmv.a.setTranslationY(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmx
 * JD-Core Version:    0.7.0.1
 */