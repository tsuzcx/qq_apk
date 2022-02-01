import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditPicSave.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class rbt
  extends SimpleObserver<rkm>
{
  rbt(rbr paramrbr) {}
  
  public void b(rkm paramrkm)
  {
    super.onNext(paramrkm);
    this.this$0.updateProgress(40);
    paramrkm = paramrkm.a.aAZ;
    ram.d("EditPicSave", "picPath = " + paramrkm);
    if (this.this$0.jdField_a_of_type_Rel.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramrkm), 5, this.this$0.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
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
    this.this$0.b.changeState(0);
    this.this$0.dismissProgressDialog();
    QQToast.a(this.this$0.jdField_a_of_type_Rel.getContext(), acfp.m(2131705465), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("EditPicSave", "saveVideo error ：" + paramError);
    this.this$0.b.changeState(0);
    QQToast.a(this.this$0.jdField_a_of_type_Rel.getContext(), 1, acfp.m(2131705466) + paramError, 0).show();
    this.this$0.dismissProgressDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbt
 * JD-Core Version:    0.7.0.1
 */