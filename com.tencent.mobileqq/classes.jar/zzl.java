import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.worldcup.ARWorldCupStateListener;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable.IWorldCupGameEndCallBack;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupResourceInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class zzl
  implements Runnable
{
  public zzl(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, int paramInt) {}
  
  public void run()
  {
    boolean bool = false;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 13: 
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.b != 2));
          ARWorldCupGlobalSceneRenderable.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
          ARWorldCupGameLogicManager.a().a(ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a() + "/res/worldcup/");
          ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable, 3, ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a() + "/res/worldcup/360.mp4", false);
          ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a(true);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
            this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacks(ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable));
          }
          ThreadManager.getSubThreadHandler().post(new zzm(this));
        } while (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) == null);
        ARWorldCupGameLogicManager.a().a();
        QLog.d("ARWorldCupGlobalSceneRenderable", 2, "nativeCallBack status " + this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.a(4);
        ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
        return;
        ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).c();
        ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable, 6, ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a() + "/res/worldcup/get_ball.mp4", false);
        return;
        ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).c();
        ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable, 8, ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a() + "/res/worldcup/ready_batch.mp4", true);
        return;
        if (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) == null)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("mTouchView.initView()  ");
          if (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) == null) {
            bool = true;
          }
          QLog.d("ARWorldCupGlobalSceneRenderable", 2, bool);
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X8009315", "0X8009315", 0, 0, "", "", "", "");
        bool = ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
        ThreadManager.getUIHandler().post(new zzn(this, bool));
        return;
        ARWorldCupGlobalSceneRenderable.d(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
        return;
      } while ((ARWorldCupGameLogicManager.a().b()) || (ARWorldCupGameLogicManager.a().a == null));
      ARWorldCupGameLogicManager.a().a.a(13);
      return;
    }
    ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a(false);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.jdField_a_of_type_Boolean = true;
    ARWorldCupGameLogicManager.a().f();
    if (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) != null) {
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a(3, null);
    }
    ThreadManager.getSubThreadHandler().post(new zzo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzl
 * JD-Core Version:    0.7.0.1
 */