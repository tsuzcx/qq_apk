import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class wxc
  extends SimpleObserver<xgs>
{
  wxc(wxb paramwxb, xgs paramxgs) {}
  
  public void a(xgs paramxgs)
  {
    super.onNext(paramxgs);
    this.jdField_a_of_type_Wxb.a(5);
    paramxgs = this.jdField_a_of_type_Xgs.a;
    wsv.b("EditVideoSave", "publishParam = " + paramxgs);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Wxb.jdField_a_of_type_Wxp.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Wxb.jdField_a_of_type_Wxp.getActivity().getIntent();
      if (localIntent == null) {
        break label212;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Wxb.jdField_a_of_type_Wxp.a(), paramxgs.b, i, j, this.jdField_a_of_type_Wxb.jdField_a_of_type_Wwe.a.a());
      wxb.a(this.jdField_a_of_type_Wxb, paramxgs.b);
      this.jdField_a_of_type_Wxb.jdField_a_of_type_Wxp.getActivity().startActivityForResult(localIntent, 111);
      this.jdField_a_of_type_Wxb.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Wxb.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Wxb.b = ((int)(7000.0D / paramxgs.a * 4.0D));
      this.jdField_a_of_type_Wxb.f();
      return;
      label212:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Wxb.jdField_a_of_type_Wwe.a(0);
    this.jdField_a_of_type_Wxb.g();
    QQToast.a(this.jdField_a_of_type_Wxb.jdField_a_of_type_Wxp.a(), alpo.a(2131704212), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Wxb.jdField_a_of_type_Wwe.a(0);
    QQToast.a(this.jdField_a_of_type_Wxb.jdField_a_of_type_Wxp.a(), 1, alpo.a(2131704147) + paramError, 0).a();
    this.jdField_a_of_type_Wxb.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxc
 * JD-Core Version:    0.7.0.1
 */