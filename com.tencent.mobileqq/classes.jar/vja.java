import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class vja
  extends SimpleObserver<vsa>
{
  vja(viz paramviz, vsa paramvsa) {}
  
  public void a(vsa paramvsa)
  {
    super.onNext(paramvsa);
    this.jdField_a_of_type_Viz.jdField_a_of_type_Vix.b();
    this.jdField_a_of_type_Viz.jdField_a_of_type_Vix.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_Viz.o();
    this.jdField_a_of_type_Viz.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_Viz.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vhk)localIterator.next()).b(paramvsa);
    }
    this.jdField_a_of_type_Viz.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Viz.jdField_a_of_type_Vix.b();
    paramvsa = (vhy)this.jdField_a_of_type_Viz.a(vhy.class);
    if (paramvsa != null) {
      paramvsa.k();
    }
    if (this.jdField_a_of_type_Viz.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramvsa = this.jdField_a_of_type_Viz.jdField_a_of_type_Vix.getActivity();
      if (paramvsa != null)
      {
        ((EditWebVideoActivity)paramvsa).d(ajya.a(2131703978));
        viz.a(this.jdField_a_of_type_Viz, paramvsa, this.jdField_a_of_type_Viz.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_Vsa.a);
      }
      return;
    }
    bcql.a(this.jdField_a_of_type_Viz.jdField_a_of_type_Vix.a(), ajya.a(2131703977), 0).a();
    this.jdField_a_of_type_Viz.jdField_a_of_type_Vix.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_Viz.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    bcql.a(this.jdField_a_of_type_Viz.jdField_a_of_type_Vix.a(), ajya.a(2131703981), 0).a();
    this.jdField_a_of_type_Viz.jdField_a_of_type_Vix.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vja
 * JD-Core Version:    0.7.0.1
 */