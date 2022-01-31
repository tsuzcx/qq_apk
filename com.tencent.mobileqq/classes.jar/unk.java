import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;

public class unk
  extends Animation
{
  private float jdField_a_of_type_Float;
  private float b;
  
  public unk(ComboAnimation3 paramComboAnimation3) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f2 = 1.0F;
    float f1;
    if (paramFloat < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 11.0F)
    {
      f1 = paramFloat / (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 11.0F);
      if (paramFloat >= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 6.0F) {
        break label139;
      }
      f2 = 1.0F + paramFloat / (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 6.0F) * 0.5F;
    }
    for (;;)
    {
      paramTransformation.setAlpha(f1);
      paramTransformation.getMatrix().setScale(f2, f2, this.jdField_a_of_type_Float, this.b);
      return;
      if (paramFloat < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 20.0F)
      {
        f1 = 1.0F;
        break;
      }
      f1 = 1.0F - (paramFloat - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 20.0F) / (4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float);
      break;
      label139:
      if (paramFloat < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 11.0F) {
        f2 = 1.5F - (paramFloat - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 6.0F) * 0.5F / (5.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float);
      }
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Float = (paramInt1 * 0.5F);
    this.b = (paramInt2 * 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     unk
 * JD-Core Version:    0.7.0.1
 */