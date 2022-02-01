import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class yrz
  extends SimpleObserver<zem>
{
  yrz(yrx paramyrx) {}
  
  public void a(zem paramzem)
  {
    super.onNext(paramzem);
    this.a.a(40);
    paramzem = paramzem.a.b;
    yqp.b("EditPicSave", "picPath = " + paramzem);
    if (this.a.jdField_a_of_type_Yvj.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramzem), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.f();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yqp.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Yty.a(0);
    this.a.g();
    QQToast.a(this.a.jdField_a_of_type_Yvj.a(), anni.a(2131702480), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yqp.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Yty.a(0);
    QQToast.a(this.a.jdField_a_of_type_Yvj.a(), 1, anni.a(2131702481) + paramError, 0).a();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrz
 * JD-Core Version:    0.7.0.1
 */