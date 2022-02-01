import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class yly
  extends SimpleObserver<yya>
{
  yly(ylw paramylw) {}
  
  public void a(yya paramyya)
  {
    super.onNext(paramyya);
    this.a.a(40);
    paramyya = paramyya.a.b;
    ykq.b("EditPicSave", "picPath = " + paramyya);
    if (this.a.jdField_a_of_type_Ypg.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramyya), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.g();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Ynw.a(0);
    this.a.h();
    QQToast.a(this.a.jdField_a_of_type_Ypg.a(), anvx.a(2131703173), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ykq.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Ynw.a(0);
    QQToast.a(this.a.jdField_a_of_type_Ypg.a(), 1, anvx.a(2131703174) + paramError, 0).a();
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yly
 * JD-Core Version:    0.7.0.1
 */