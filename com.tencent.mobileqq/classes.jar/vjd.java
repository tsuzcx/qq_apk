import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class vjd
  extends SimpleObserver<vsd>
{
  vjd(vjc paramvjc, vsd paramvsd) {}
  
  public void a(vsd paramvsd)
  {
    super.onNext(paramvsd);
    this.jdField_a_of_type_Vjc.jdField_a_of_type_Vja.b();
    this.jdField_a_of_type_Vjc.jdField_a_of_type_Vja.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_Vjc.o();
    this.jdField_a_of_type_Vjc.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_Vjc.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vhn)localIterator.next()).b(paramvsd);
    }
    this.jdField_a_of_type_Vjc.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Vjc.jdField_a_of_type_Vja.b();
    paramvsd = (vib)this.jdField_a_of_type_Vjc.a(vib.class);
    if (paramvsd != null) {
      paramvsd.k();
    }
    if (this.jdField_a_of_type_Vjc.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramvsd = this.jdField_a_of_type_Vjc.jdField_a_of_type_Vja.getActivity();
      if (paramvsd != null)
      {
        ((EditWebVideoActivity)paramvsd).d(ajyc.a(2131703967));
        vjc.a(this.jdField_a_of_type_Vjc, paramvsd, this.jdField_a_of_type_Vjc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_Vsd.a);
      }
      return;
    }
    bcpw.a(this.jdField_a_of_type_Vjc.jdField_a_of_type_Vja.a(), ajyc.a(2131703966), 0).a();
    this.jdField_a_of_type_Vjc.jdField_a_of_type_Vja.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_Vjc.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    bcpw.a(this.jdField_a_of_type_Vjc.jdField_a_of_type_Vja.a(), ajyc.a(2131703970), 0).a();
    this.jdField_a_of_type_Vjc.jdField_a_of_type_Vja.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vjd
 * JD-Core Version:    0.7.0.1
 */