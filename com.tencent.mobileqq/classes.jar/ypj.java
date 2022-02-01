import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class ypj
  extends SimpleObserver<yya>
{
  ypj(ypi paramypi, yya paramyya) {}
  
  public void a(yya paramyya)
  {
    super.onNext(paramyya);
    this.jdField_a_of_type_Ypi.jdField_a_of_type_Ypg.b();
    this.jdField_a_of_type_Ypi.jdField_a_of_type_Ypg.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_Ypi.o();
    this.jdField_a_of_type_Ypi.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_Ypi.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ynu)localIterator.next()).b(paramyya);
    }
    this.jdField_a_of_type_Ypi.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Ypi.jdField_a_of_type_Ypg.b();
    paramyya = (yoi)this.jdField_a_of_type_Ypi.a(yoi.class);
    if (paramyya != null) {
      paramyya.i();
    }
    if (this.jdField_a_of_type_Ypi.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramyya = this.jdField_a_of_type_Ypi.jdField_a_of_type_Ypg.getActivity();
      if (paramyya != null)
      {
        ((EditWebVideoActivity)paramyya).a(anvx.a(2131703447));
        ypi.a(this.jdField_a_of_type_Ypi, paramyya, this.jdField_a_of_type_Ypi.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource, this.jdField_a_of_type_Yya.a);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Ypi.jdField_a_of_type_Ypg.a(), anvx.a(2131703446), 0).a();
    this.jdField_a_of_type_Ypi.jdField_a_of_type_Ypg.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_Ypi.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.jdField_a_of_type_Ypi.jdField_a_of_type_Ypg.a(), anvx.a(2131703450), 0).a();
    this.jdField_a_of_type_Ypi.jdField_a_of_type_Ypg.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypj
 * JD-Core Version:    0.7.0.1
 */