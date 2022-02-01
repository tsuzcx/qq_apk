import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class yvm
  extends SimpleObserver<zem>
{
  yvm(yvl paramyvl, zem paramzem) {}
  
  public void a(zem paramzem)
  {
    super.onNext(paramzem);
    this.jdField_a_of_type_Yvl.jdField_a_of_type_Yvj.b();
    this.jdField_a_of_type_Yvl.jdField_a_of_type_Yvj.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_Yvl.o();
    this.jdField_a_of_type_Yvl.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_Yvl.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ytw)localIterator.next()).b(paramzem);
    }
    this.jdField_a_of_type_Yvl.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Yvl.jdField_a_of_type_Yvj.b();
    paramzem = (yuk)this.jdField_a_of_type_Yvl.a(yuk.class);
    if (paramzem != null) {
      paramzem.k();
    }
    if (this.jdField_a_of_type_Yvl.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramzem = this.jdField_a_of_type_Yvl.jdField_a_of_type_Yvj.getActivity();
      if (paramzem != null)
      {
        ((EditWebVideoActivity)paramzem).d(anni.a(2131702759));
        yvl.a(this.jdField_a_of_type_Yvl, paramzem, this.jdField_a_of_type_Yvl.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_Zem.a);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Yvl.jdField_a_of_type_Yvj.a(), anni.a(2131702758), 0).a();
    this.jdField_a_of_type_Yvl.jdField_a_of_type_Yvj.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_Yvl.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.jdField_a_of_type_Yvl.jdField_a_of_type_Yvj.a(), anni.a(2131702762), 0).a();
    this.jdField_a_of_type_Yvl.jdField_a_of_type_Yvj.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvm
 * JD-Core Version:    0.7.0.1
 */