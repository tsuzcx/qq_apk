import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class you
  extends SimpleObserver<yya>
{
  you(yot paramyot, yya paramyya) {}
  
  public void a(yya paramyya)
  {
    super.onNext(paramyya);
    this.jdField_a_of_type_Yot.a(5);
    paramyya = this.jdField_a_of_type_Yya.a;
    ykq.b("EditVideoSave", "publishParam = " + paramyya);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Yot.jdField_a_of_type_Ypg.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Yot.jdField_a_of_type_Ypg.getActivity().getIntent();
      if (localIntent == null) {
        break label212;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Yot.jdField_a_of_type_Ypg.a(), paramyya.b, i, j, this.jdField_a_of_type_Yot.jdField_a_of_type_Ynw.a.getBussinessId());
      yot.a(this.jdField_a_of_type_Yot, paramyya.b);
      this.jdField_a_of_type_Yot.jdField_a_of_type_Ypg.getActivity().startActivityForResult(localIntent, 111);
      this.jdField_a_of_type_Yot.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Yot.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Yot.b = ((int)(7000.0D / paramyya.a * 4.0D));
      this.jdField_a_of_type_Yot.g();
      return;
      label212:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Yot.jdField_a_of_type_Ynw.a(0);
    this.jdField_a_of_type_Yot.h();
    QQToast.a(this.jdField_a_of_type_Yot.jdField_a_of_type_Ypg.a(), anvx.a(2131703311), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ykq.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Yot.jdField_a_of_type_Ynw.a(0);
    QQToast.a(this.jdField_a_of_type_Yot.jdField_a_of_type_Ypg.a(), 1, anvx.a(2131703249) + paramError, 0).a();
    this.jdField_a_of_type_Yot.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     you
 * JD-Core Version:    0.7.0.1
 */