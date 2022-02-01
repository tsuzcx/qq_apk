import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class yzh
  extends SimpleObserver<zih>
{
  yzh(yzg paramyzg, zih paramzih) {}
  
  public void a(zih paramzih)
  {
    super.onNext(paramzih);
    this.jdField_a_of_type_Yzg.jdField_a_of_type_Yze.b();
    this.jdField_a_of_type_Yzg.jdField_a_of_type_Yze.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_Yzg.o();
    this.jdField_a_of_type_Yzg.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_Yzg.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).b(paramzih);
    }
    this.jdField_a_of_type_Yzg.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Yzg.jdField_a_of_type_Yze.b();
    paramzih = (yyf)this.jdField_a_of_type_Yzg.a(yyf.class);
    if (paramzih != null) {
      paramzih.k();
    }
    if (this.jdField_a_of_type_Yzg.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramzih = this.jdField_a_of_type_Yzg.jdField_a_of_type_Yze.getActivity();
      if (paramzih != null)
      {
        ((EditWebVideoActivity)paramzih).d(anzj.a(2131702866));
        yzg.a(this.jdField_a_of_type_Yzg, paramzih, this.jdField_a_of_type_Yzg.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_Zih.a);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Yzg.jdField_a_of_type_Yze.a(), anzj.a(2131702865), 0).a();
    this.jdField_a_of_type_Yzg.jdField_a_of_type_Yze.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_Yzg.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.jdField_a_of_type_Yzg.jdField_a_of_type_Yze.a(), anzj.a(2131702869), 0).a();
    this.jdField_a_of_type_Yzg.jdField_a_of_type_Yze.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzh
 * JD-Core Version:    0.7.0.1
 */