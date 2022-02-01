import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class xxf
  extends SimpleObserver<yjh>
{
  xxf(xxd paramxxd) {}
  
  public void a(yjh paramyjh)
  {
    super.onNext(paramyjh);
    this.a.a(40);
    paramyjh = paramyjh.a.b;
    xvv.b("EditPicSave", "picPath = " + paramyjh);
    if (this.a.jdField_a_of_type_Yan.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramyjh), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.g();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    xvv.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Xzd.a(0);
    this.a.h();
    QQToast.a(this.a.jdField_a_of_type_Yan.a(), amtj.a(2131702822), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xvv.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Xzd.a(0);
    QQToast.a(this.a.jdField_a_of_type_Yan.a(), 1, amtj.a(2131702823) + paramError, 0).a();
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxf
 * JD-Core Version:    0.7.0.1
 */