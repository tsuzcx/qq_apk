import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class zzv
  implements Runnable
{
  public zzv(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.e = 0;
    QLog.i("ARWorldCupGlobalSceneRenderable", 1, "setRecogRes. mInsertedSparkTotalCnt = 0, sparkShaderVertFileName = " + this.jdField_a_of_type_JavaLangString + ", sparkShaderFragFileName = " + this.jdField_b_of_type_JavaLangString + ", sparkFileName = " + this.jdField_c_of_type_JavaLangString + ", turnSpriteFileName = " + this.jdField_d_of_type_JavaLangString + ", lightSpriteFileName = " + this.e + ", circleR = " + this.jdField_a_of_type_Int + ", circleX = " + this.jdField_b_of_type_Int + ", circleY = " + this.jdField_c_of_type_Int + ", clockwise = " + this.jdField_d_of_type_Int + ", hasDrawedFrame = " + ARWorldCupGlobalSceneRenderable.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable));
    if ((ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) != null) && (ARWorldCupGlobalSceneRenderable.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable))) {
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_setRecogRes(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.e, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzv
 * JD-Core Version:    0.7.0.1
 */