import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class ayee
  extends SimpleObserver<ayqb>
{
  ayee(ayec paramayec) {}
  
  public void b(ayqb paramayqb)
  {
    super.onNext(paramayqb);
    this.this$0.updateProgress(40);
    paramayqb = paramayqb.a.aAZ;
    ram.d("EditPicSave", "picPath = " + paramayqb);
    if (this.this$0.jdField_a_of_type_Ayii.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, paramayqb), 64, this.this$0.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.this$0.progress = 40;
      this.this$0.aGH = false;
      this.this$0.bpE = 10;
      this.this$0.adc();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ram.w("EditPicSave", "saveVideo cancel !");
    if (!ayec.a(this.this$0))
    {
      if (this.this$0.b.a.tg() == 14) {
        this.this$0.b.aHd = false;
      }
      this.this$0.b.changeState(0);
    }
    this.this$0.dismissProgressDialog();
    QQToast.a(this.this$0.jdField_a_of_type_Ayii.getContext(), acfp.m(2131705459), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("EditPicSave", "saveVideo error ：" + paramError);
    if (!ayec.a(this.this$0))
    {
      if (this.this$0.b.a.tg() == 14) {
        this.this$0.b.aHd = false;
      }
      this.this$0.b.changeState(0);
    }
    QQToast.a(this.this$0.jdField_a_of_type_Ayii.getContext(), 1, acfp.m(2131705461) + paramError, 0).show();
    this.this$0.dismissProgressDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayee
 * JD-Core Version:    0.7.0.1
 */