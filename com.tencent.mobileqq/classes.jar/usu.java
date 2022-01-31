import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;

public class usu
  extends SimpleObserver<vfh>
{
  usu(uss paramuss) {}
  
  public void a(vfh paramvfh)
  {
    super.onNext(paramvfh);
    this.a.a(40);
    paramvfh = paramvfh.a.b;
    urk.b("EditPicSave", "picPath = " + paramvfh);
    if (this.a.jdField_a_of_type_Uwe.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramvfh), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.f();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    urk.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Uut.a(0);
    this.a.g();
    bbmy.a(this.a.jdField_a_of_type_Uwe.a(), ajjy.a(2131637903), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Uut.a(0);
    bbmy.a(this.a.jdField_a_of_type_Uwe.a(), 1, ajjy.a(2131637904) + paramError, 0).a();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usu
 * JD-Core Version:    0.7.0.1
 */