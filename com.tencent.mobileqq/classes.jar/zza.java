import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerImpl;
import java.util.Map;

public class zza
  implements Runnable
{
  public zza(ARRenderManagerImpl paramARRenderManagerImpl) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      this.a.jdField_a_of_type_JavaUtilMap.remove(this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a());
      this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.d();
      this.a.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zza
 * JD-Core Version:    0.7.0.1
 */