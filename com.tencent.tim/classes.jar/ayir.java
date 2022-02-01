import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import java.util.Iterator;
import java.util.List;

class ayir
  extends SimpleObserver<ayqb>
{
  ayir(ayiq paramayiq) {}
  
  public void b(ayqb paramayqb)
  {
    super.onNext(paramayqb);
    this.this$0.jdField_a_of_type_Ayii.bpm();
    this.this$0.jdField_a_of_type_Ayii.getActivity().overridePendingTransition(0, 0);
    this.this$0.checkThread();
    this.this$0.aHd = false;
    Object localObject = this.this$0.lu.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((aygy)((Iterator)localObject).next()).c(paramayqb);
    }
    this.this$0.aHd = false;
    this.this$0.jdField_a_of_type_Ayii.bpm();
    localObject = (ayhm)this.this$0.a(ayhm.class);
    if (localObject != null) {
      ((ayhm)localObject).play();
    }
    if (this.this$0.oC.isEmpty())
    {
      localObject = this.this$0.jdField_a_of_type_Ayii.getActivity();
      if (localObject != null)
      {
        ((EditWebVideoActivity)localObject).sq(acfp.m(2131705742));
        ayiq.a(this.this$0, (Activity)localObject, this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a, paramayqb.b);
      }
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_Ayii.getContext(), acfp.m(2131705738), 0).show();
    this.this$0.jdField_a_of_type_Ayii.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.this$0.oC.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.this$0.jdField_a_of_type_Ayii.getContext(), acfp.m(2131705741), 0).show();
    this.this$0.jdField_a_of_type_Ayii.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayir
 * JD-Core Version:    0.7.0.1
 */