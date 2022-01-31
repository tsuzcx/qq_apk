import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class zzi
  implements Runnable
{
  public zzi(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.b != 0) {
        break label230;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.jdField_a_of_type_Int = 0;
      switch (i)
      {
      case 5: 
      case 7: 
      case 9: 
      case 11: 
      default: 
        ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
      }
    }
    label230:
    do
    {
      do
      {
        return;
        if (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) != null)
        {
          QLog.d("ARWorldCupGlobalSceneRenderable", 2, "native_switchGameStatusWithVideoId status " + this.b);
          ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_switchGameStatusWithVideoId(i, this.c);
        }
        if ((i == 6) || (i == 8))
        {
          QLog.d("ARWorldCupGlobalSceneRenderable", 2, "startMediaTimeListener tempNextStatus " + i);
          ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
        }
        if (i != 3) {
          break;
        }
        ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable, true);
        ThreadManager.getSubThreadHandler().post(new zzj(this));
        break;
      } while (this.b != 1);
      i = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.b;
      switch (i)
      {
      case 3: 
      case 5: 
      case 7: 
      case 8: 
      case 9: 
      case 11: 
      default: 
        return;
      }
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
      ThreadManager.getUIHandler().post(new zzk(this));
      i += 1;
    } while ((i <= 0) || (i >= 14));
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzi
 * JD-Core Version:    0.7.0.1
 */