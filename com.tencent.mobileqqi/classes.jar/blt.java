import android.os.Handler;
import android.view.View;
import com.tencent.av.ui.VideoLayerUI;

public class blt
  implements Runnable
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 0;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 1;
  final int g = 9;
  
  public blt(VideoLayerUI paramVideoLayerUI, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Float = ((paramInt4 - paramInt2) / 10.0F);
    this.jdField_b_of_type_Float = ((paramInt5 - paramInt3) / 10.0F);
    this.d = paramInt2;
    this.e = paramInt3;
    this.jdField_b_of_type_Int = paramInt4;
    this.c = paramInt5;
    this.f = paramInt1;
  }
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewView.findViewById(2131232279);
    if (this.jdField_a_of_type_Int == 9) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, this.f);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int > 9) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1L);
      }
      return;
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(localView, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.j = false;
    if (((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c) || (!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_Boolean)) || (((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d)) || ((!this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e)))) {
      localView.setBackgroundResource(2130838293);
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blt
 * JD-Core Version:    0.7.0.1
 */