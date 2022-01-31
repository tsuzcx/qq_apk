import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class uvr
  extends SimpleObserver<vfh>
{
  uvr(uvq paramuvq, vfh paramvfh) {}
  
  public void a(vfh paramvfh)
  {
    super.onNext(paramvfh);
    this.jdField_a_of_type_Uvq.a(5);
    paramvfh = this.jdField_a_of_type_Vfh.a;
    urk.b("EditVideoSave", "publishParam = " + paramvfh);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Uvq.jdField_a_of_type_Uwe.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Uvq.jdField_a_of_type_Uwe.getActivity().getIntent();
      if (localIntent == null) {
        break label212;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Uvq.jdField_a_of_type_Uwe.a(), paramvfh.b, i, j, this.jdField_a_of_type_Uvq.jdField_a_of_type_Uut.a.a());
      uvq.a(this.jdField_a_of_type_Uvq, paramvfh.b);
      this.jdField_a_of_type_Uvq.jdField_a_of_type_Uwe.getActivity().startActivityForResult(localIntent, 111);
      this.jdField_a_of_type_Uvq.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Uvq.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Uvq.b = ((int)(7000.0D / paramvfh.a * 4.0D));
      this.jdField_a_of_type_Uvq.f();
      return;
      label212:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    urk.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Uvq.jdField_a_of_type_Uut.a(0);
    this.jdField_a_of_type_Uvq.g();
    bbmy.a(this.jdField_a_of_type_Uvq.jdField_a_of_type_Uwe.a(), ajjy.a(2131638044), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Uvq.jdField_a_of_type_Uut.a(0);
    bbmy.a(this.jdField_a_of_type_Uvq.jdField_a_of_type_Uwe.a(), 1, ajjy.a(2131637979) + paramError, 0).a();
    this.jdField_a_of_type_Uvq.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvr
 * JD-Core Version:    0.7.0.1
 */