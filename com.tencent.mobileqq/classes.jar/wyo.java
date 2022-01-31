import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class wyo
  extends SimpleObserver<xlb>
{
  wyo(wym paramwym) {}
  
  public void a(xlb paramxlb)
  {
    super.onNext(paramxlb);
    this.a.a(40);
    paramxlb = paramxlb.a.b;
    wxe.b("EditPicSave", "picPath = " + paramxlb);
    if (this.a.jdField_a_of_type_Xby.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramxlb), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.f();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wxe.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Xan.a(0);
    this.a.g();
    QQToast.a(this.a.jdField_a_of_type_Xby.a(), alud.a(2131704083), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wxe.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Xan.a(0);
    QQToast.a(this.a.jdField_a_of_type_Xby.a(), 1, alud.a(2131704084) + paramError, 0).a();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyo
 * JD-Core Version:    0.7.0.1
 */