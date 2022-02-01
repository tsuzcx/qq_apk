import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class yvu
  extends SimpleObserver<zih>
{
  yvu(yvs paramyvs) {}
  
  public void a(zih paramzih)
  {
    super.onNext(paramzih);
    this.a.a(40);
    paramzih = paramzih.a.b;
    yuk.b("EditPicSave", "picPath = " + paramzih);
    if (this.a.jdField_a_of_type_Yze.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramzih), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.f();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_Yxt.a(0);
    this.a.g();
    QQToast.a(this.a.jdField_a_of_type_Yze.a(), anzj.a(2131702587), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_Yxt.a(0);
    QQToast.a(this.a.jdField_a_of_type_Yze.a(), 1, anzj.a(2131702588) + paramError, 0).a();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvu
 * JD-Core Version:    0.7.0.1
 */