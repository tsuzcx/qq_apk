import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class wxs
  extends SimpleObserver<xgs>
{
  wxs(wxr paramwxr, xgs paramxgs) {}
  
  public void a(xgs paramxgs)
  {
    super.onNext(paramxgs);
    this.jdField_a_of_type_Wxr.jdField_a_of_type_Wxp.b();
    this.jdField_a_of_type_Wxr.jdField_a_of_type_Wxp.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_Wxr.o();
    this.jdField_a_of_type_Wxr.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_Wxr.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wwc)localIterator.next()).b(paramxgs);
    }
    this.jdField_a_of_type_Wxr.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Wxr.jdField_a_of_type_Wxp.b();
    paramxgs = (wwq)this.jdField_a_of_type_Wxr.a(wwq.class);
    if (paramxgs != null) {
      paramxgs.k();
    }
    if (this.jdField_a_of_type_Wxr.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramxgs = this.jdField_a_of_type_Wxr.jdField_a_of_type_Wxp.getActivity();
      if (paramxgs != null)
      {
        ((EditWebVideoActivity)paramxgs).d(alpo.a(2131704350));
        wxr.a(this.jdField_a_of_type_Wxr, paramxgs, this.jdField_a_of_type_Wxr.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_Xgs.a);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Wxr.jdField_a_of_type_Wxp.a(), alpo.a(2131704349), 0).a();
    this.jdField_a_of_type_Wxr.jdField_a_of_type_Wxp.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_Wxr.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.jdField_a_of_type_Wxr.jdField_a_of_type_Wxp.a(), alpo.a(2131704353), 0).a();
    this.jdField_a_of_type_Wxr.jdField_a_of_type_Wxp.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxs
 * JD-Core Version:    0.7.0.1
 */