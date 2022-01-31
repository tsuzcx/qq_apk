import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerImpl;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenerArumentManager;
import com.tencent.qphone.base.util.QLog;

public class zyz
  implements Runnable
{
  public zyz(ARRenderManagerImpl paramARRenderManagerImpl, ARBaseRender paramARBaseRender, ARRenderResourceInfo paramARRenderResourceInfo) {}
  
  public void run()
  {
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    ARRenderManagerImpl localARRenderManagerImpl = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl;
    int i = ARRenderManagerImpl.jdField_a_of_type_Int;
    localARRenderManagerImpl = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl;
    localARBaseRender.a_(i, ARRenderManagerImpl.b);
    localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localARBaseRender != null) && (localARBaseRender != this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender)) {
      localARBaseRender.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderResourceInfo.jdField_a_of_type_Int == 5) && ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderResourceInfo.jdField_a_of_type_Long == 2L) || (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderResourceInfo.jdField_a_of_type_Long == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a(bool, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderResourceInfo);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerImpl.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyz
 * JD-Core Version:    0.7.0.1
 */