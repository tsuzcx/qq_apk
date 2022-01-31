import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class vik
  extends SimpleObserver<vsa>
{
  vik(vij paramvij, vsa paramvsa) {}
  
  public void a(vsa paramvsa)
  {
    super.onNext(paramvsa);
    this.jdField_a_of_type_Vij.a(5);
    paramvsa = this.jdField_a_of_type_Vsa.a;
    ved.b("EditVideoSave", "publishParam = " + paramvsa);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Vij.jdField_a_of_type_Vix.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Vij.jdField_a_of_type_Vix.getActivity().getIntent();
      if (localIntent == null) {
        break label212;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Vij.jdField_a_of_type_Vix.a(), paramvsa.b, i, j, this.jdField_a_of_type_Vij.jdField_a_of_type_Vhm.a.a());
      vij.a(this.jdField_a_of_type_Vij, paramvsa.b);
      this.jdField_a_of_type_Vij.jdField_a_of_type_Vix.getActivity().startActivityForResult(localIntent, 111);
      this.jdField_a_of_type_Vij.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Vij.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Vij.b = ((int)(7000.0D / paramvsa.a * 4.0D));
      this.jdField_a_of_type_Vij.f();
      return;
      label212:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ved.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Vij.jdField_a_of_type_Vhm.a(0);
    this.jdField_a_of_type_Vij.g();
    bcql.a(this.jdField_a_of_type_Vij.jdField_a_of_type_Vix.a(), ajya.a(2131703840), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Vij.jdField_a_of_type_Vhm.a(0);
    bcql.a(this.jdField_a_of_type_Vij.jdField_a_of_type_Vix.a(), 1, ajya.a(2131703775) + paramError, 0).a();
    this.jdField_a_of_type_Vij.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vik
 * JD-Core Version:    0.7.0.1
 */