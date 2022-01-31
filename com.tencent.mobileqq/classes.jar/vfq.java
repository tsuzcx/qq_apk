import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;

public class vfq
  extends SimpleObserver<vsd>
{
  vfq(vfo paramvfo) {}
  
  public void a(vsd paramvsd)
  {
    super.onNext(paramvsd);
    this.a.a(40);
    paramvsd = paramvsd.a.b;
    veg.b("EditPicSave", "picPath = " + paramvsd);
    if (this.a.jdField_a_of_type_Vja.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramvsd), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.f();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Vhp.a(0);
    this.a.g();
    bcpw.a(this.a.jdField_a_of_type_Vja.a(), ajyc.a(2131703688), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Vhp.a(0);
    bcpw.a(this.a.jdField_a_of_type_Vja.a(), 1, ajyc.a(2131703689) + paramError, 0).a();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfq
 * JD-Core Version:    0.7.0.1
 */