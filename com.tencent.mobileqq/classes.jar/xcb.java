import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class xcb
  extends SimpleObserver<xlb>
{
  xcb(xca paramxca, xlb paramxlb) {}
  
  public void a(xlb paramxlb)
  {
    super.onNext(paramxlb);
    this.jdField_a_of_type_Xca.jdField_a_of_type_Xby.b();
    this.jdField_a_of_type_Xca.jdField_a_of_type_Xby.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_Xca.o();
    this.jdField_a_of_type_Xca.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_Xca.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xal)localIterator.next()).b(paramxlb);
    }
    this.jdField_a_of_type_Xca.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Xca.jdField_a_of_type_Xby.b();
    paramxlb = (xaz)this.jdField_a_of_type_Xca.a(xaz.class);
    if (paramxlb != null) {
      paramxlb.k();
    }
    if (this.jdField_a_of_type_Xca.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramxlb = this.jdField_a_of_type_Xca.jdField_a_of_type_Xby.getActivity();
      if (paramxlb != null)
      {
        ((EditWebVideoActivity)paramxlb).d(alud.a(2131704362));
        xca.a(this.jdField_a_of_type_Xca, paramxlb, this.jdField_a_of_type_Xca.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_Xlb.a);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Xca.jdField_a_of_type_Xby.a(), alud.a(2131704361), 0).a();
    this.jdField_a_of_type_Xca.jdField_a_of_type_Xby.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_Xca.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.jdField_a_of_type_Xca.jdField_a_of_type_Xby.a(), alud.a(2131704365), 0).a();
    this.jdField_a_of_type_Xca.jdField_a_of_type_Xby.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcb
 * JD-Core Version:    0.7.0.1
 */