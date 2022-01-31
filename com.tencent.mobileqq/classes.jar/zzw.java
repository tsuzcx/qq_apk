import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class zzw
  implements Runnable
{
  public zzw(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3) {}
  
  public void run()
  {
    ARWorldCupGlobalSceneRenderable localARWorldCupGlobalSceneRenderable = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable;
    localARWorldCupGlobalSceneRenderable.e += this.jdField_a_of_type_ArrayOfInt.length;
    QLog.i("ARWorldCupGlobalSceneRenderable", 1, "insertWorldCupSpark. mInsertedSparkTotalCnt = " + this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.e + ", new cnt = " + this.jdField_a_of_type_ArrayOfInt.length + ", px[0] = " + this.jdField_a_of_type_ArrayOfInt[0] + ", py[0] = " + this.b[0] + ", degree[0] = " + this.c[0] + ", hasDrawedFrame = " + ARWorldCupGlobalSceneRenderable.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable));
    if ((ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) != null) && (ARWorldCupGlobalSceneRenderable.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable))) {
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_insertWorldCupSpark(this.jdField_a_of_type_ArrayOfInt, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzw
 * JD-Core Version:    0.7.0.1
 */