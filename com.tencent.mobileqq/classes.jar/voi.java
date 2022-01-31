import android.view.View;
import com.tencent.qphone.base.util.BaseApplication;

public class voi
  implements vri
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int = xod.d(BaseApplication.getContext());
  private int b = -1;
  private int c = -1;
  
  public voi(vog paramvog) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Vog.a() != 0) {
      return;
    }
    this.c = paramInt;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Vog.a() != 0) {
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
      this.jdField_a_of_type_Vog.a.setTranslationY(this.jdField_a_of_type_Int - paramInt2);
      return;
    }
    this.jdField_a_of_type_Vog.a.setTranslationY(-paramInt2);
  }
  
  public void b(int paramInt)
  {
    wsv.a("Q.qqstory.playernew.LoadingMoreWidget", "onPageScrollStateChanged newState=%d visible=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Vog.a()));
    if (this.jdField_a_of_type_Vog.a() != 0) {}
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
          this.jdField_a_of_type_Vog.a.clearAnimation();
          return;
        }
      } while (paramInt != 0);
      if (this.jdField_a_of_type_Float < 0.5D)
      {
        this.jdField_a_of_type_Vog.a.setTranslationY(0.0F);
        return;
      }
    } while (this.c == -1);
    this.jdField_a_of_type_Vog.a.setTranslationY(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     voi
 * JD-Core Version:    0.7.0.1
 */