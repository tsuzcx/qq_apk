import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;

public class vfn
  extends SimpleObserver<vsa>
{
  vfn(vfl paramvfl) {}
  
  public void a(vsa paramvsa)
  {
    super.onNext(paramvsa);
    this.a.a(40);
    paramvsa = paramvsa.a.b;
    ved.b("EditPicSave", "picPath = " + paramvsa);
    if (this.a.jdField_a_of_type_Vix.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramvsa), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.f();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ved.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Vhm.a(0);
    this.a.g();
    bcql.a(this.a.jdField_a_of_type_Vix.a(), ajya.a(2131703699), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Vhm.a(0);
    bcql.a(this.a.jdField_a_of_type_Vix.a(), 1, ajya.a(2131703700) + paramError, 0).a();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfn
 * JD-Core Version:    0.7.0.1
 */