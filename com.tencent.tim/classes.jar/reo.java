import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class reo
  extends SimpleObserver<rkm>
{
  reo(ren paramren, rkm paramrkm) {}
  
  public void b(rkm paramrkm)
  {
    super.onNext(paramrkm);
    this.this$0.jdField_a_of_type_Rel.bpm();
    this.this$0.jdField_a_of_type_Rel.getActivity().overridePendingTransition(0, 0);
    this.this$0.checkThread();
    this.this$0.aHd = false;
    Iterator localIterator = this.this$0.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).c(paramrkm);
    }
    this.this$0.aHd = false;
    this.this$0.jdField_a_of_type_Rel.bpm();
    paramrkm = (rdo)this.this$0.a(rdo.class);
    if (paramrkm != null) {
      paramrkm.play();
    }
    if (this.this$0.oC.isEmpty())
    {
      paramrkm = this.this$0.jdField_a_of_type_Rel.getActivity();
      if (paramrkm != null)
      {
        ((EditWebVideoActivity)paramrkm).sq(acfp.m(2131705744));
        ren.a(this.this$0, paramrkm, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.a.b);
      }
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_Rel.getContext(), acfp.m(2131705743), 0).show();
    this.this$0.jdField_a_of_type_Rel.getActivity().finish();
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
    QQToast.a(this.this$0.jdField_a_of_type_Rel.getContext(), acfp.m(2131705747), 0).show();
    this.this$0.jdField_a_of_type_Rel.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     reo
 * JD-Core Version:    0.7.0.1
 */