import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class wuf
  extends SimpleObserver<xgs>
{
  wuf(wud paramwud) {}
  
  public void a(xgs paramxgs)
  {
    super.onNext(paramxgs);
    this.a.a(40);
    paramxgs = paramxgs.a.b;
    wsv.b("EditPicSave", "picPath = " + paramxgs);
    if (this.a.jdField_a_of_type_Wxp.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramxgs), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.f();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Wwe.a(0);
    this.a.g();
    QQToast.a(this.a.jdField_a_of_type_Wxp.a(), alpo.a(2131704071), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Wwe.a(0);
    QQToast.a(this.a.jdField_a_of_type_Wxp.a(), 1, alpo.a(2131704072) + paramError, 0).a();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wuf
 * JD-Core Version:    0.7.0.1
 */