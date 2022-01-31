import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class uwh
  extends SimpleObserver<vfh>
{
  uwh(uwg paramuwg, vfh paramvfh) {}
  
  public void a(vfh paramvfh)
  {
    super.onNext(paramvfh);
    this.jdField_a_of_type_Uwg.jdField_a_of_type_Uwe.b();
    this.jdField_a_of_type_Uwg.jdField_a_of_type_Uwe.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_Uwg.o();
    this.jdField_a_of_type_Uwg.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_Uwg.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uur)localIterator.next()).b(paramvfh);
    }
    this.jdField_a_of_type_Uwg.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Uwg.jdField_a_of_type_Uwe.b();
    paramvfh = (uvf)this.jdField_a_of_type_Uwg.a(uvf.class);
    if (paramvfh != null) {
      paramvfh.k();
    }
    if (this.jdField_a_of_type_Uwg.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramvfh = this.jdField_a_of_type_Uwg.jdField_a_of_type_Uwe.getActivity();
      if (paramvfh != null)
      {
        ((EditWebVideoActivity)paramvfh).d(ajjy.a(2131638182));
        uwg.a(this.jdField_a_of_type_Uwg, paramvfh, this.jdField_a_of_type_Uwg.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_Vfh.a);
      }
      return;
    }
    bbmy.a(this.jdField_a_of_type_Uwg.jdField_a_of_type_Uwe.a(), ajjy.a(2131638181), 0).a();
    this.jdField_a_of_type_Uwg.jdField_a_of_type_Uwe.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_Uwg.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    bbmy.a(this.jdField_a_of_type_Uwg.jdField_a_of_type_Uwe.a(), ajjy.a(2131638185), 0).a();
    this.jdField_a_of_type_Uwg.jdField_a_of_type_Uwe.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwh
 * JD-Core Version:    0.7.0.1
 */