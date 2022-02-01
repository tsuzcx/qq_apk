import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class yab
  extends SimpleObserver<yjh>
{
  yab(yaa paramyaa, yjh paramyjh) {}
  
  public void a(yjh paramyjh)
  {
    super.onNext(paramyjh);
    this.jdField_a_of_type_Yaa.a(5);
    paramyjh = this.jdField_a_of_type_Yjh.a;
    xvv.b("EditVideoSave", "publishParam = " + paramyjh);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Yaa.jdField_a_of_type_Yan.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Yaa.jdField_a_of_type_Yan.getActivity().getIntent();
      if (localIntent == null) {
        break label212;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Yaa.jdField_a_of_type_Yan.a(), paramyjh.b, i, j, this.jdField_a_of_type_Yaa.jdField_a_of_type_Xzd.a.getBussinessId());
      yaa.a(this.jdField_a_of_type_Yaa, paramyjh.b);
      this.jdField_a_of_type_Yaa.jdField_a_of_type_Yan.getActivity().startActivityForResult(localIntent, 111);
      this.jdField_a_of_type_Yaa.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Yaa.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Yaa.b = ((int)(7000.0D / paramyjh.a * 4.0D));
      this.jdField_a_of_type_Yaa.g();
      return;
      label212:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    xvv.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Yaa.jdField_a_of_type_Xzd.a(0);
    this.jdField_a_of_type_Yaa.h();
    QQToast.a(this.jdField_a_of_type_Yaa.jdField_a_of_type_Yan.a(), amtj.a(2131702960), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xvv.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Yaa.jdField_a_of_type_Xzd.a(0);
    QQToast.a(this.jdField_a_of_type_Yaa.jdField_a_of_type_Yan.a(), 1, amtj.a(2131702898) + paramError, 0).a();
    this.jdField_a_of_type_Yaa.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yab
 * JD-Core Version:    0.7.0.1
 */