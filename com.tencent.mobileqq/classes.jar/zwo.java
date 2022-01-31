import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable;
import com.tencent.qphone.base.util.QLog;

public class zwo
  implements Runnable
{
  public zwo(Interactive3DRenderable paramInteractive3DRenderable, int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong) {}
  
  public void run()
  {
    Interactive3DRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DRenderable).native_onTouchMove(this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, this.b, this.jdField_a_of_type_Long, Interactive3DRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DRenderable).mCurrentActiveId);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_MOVE native_onTouchMove");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zwo
 * JD-Core Version:    0.7.0.1
 */