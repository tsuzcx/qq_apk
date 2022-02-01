import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class yyr
  extends SimpleObserver<zih>
{
  yyr(yyq paramyyq, zih paramzih) {}
  
  public void a(zih paramzih)
  {
    super.onNext(paramzih);
    this.jdField_a_of_type_Yyq.a(5);
    paramzih = this.jdField_a_of_type_Zih.a;
    yuk.b("EditVideoSave", "publishParam = " + paramzih);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Yyq.jdField_a_of_type_Yze.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Yyq.jdField_a_of_type_Yze.getActivity().getIntent();
      if (localIntent == null) {
        break label212;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Yyq.jdField_a_of_type_Yze.a(), paramzih.b, i, j, this.jdField_a_of_type_Yyq.jdField_a_of_type_Yxt.a.a());
      yyq.a(this.jdField_a_of_type_Yyq, paramzih.b);
      this.jdField_a_of_type_Yyq.jdField_a_of_type_Yze.getActivity().startActivityForResult(localIntent, 111);
      this.jdField_a_of_type_Yyq.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Yyq.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Yyq.b = ((int)(7000.0D / paramzih.a * 4.0D));
      this.jdField_a_of_type_Yyq.f();
      return;
      label212:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Yyq.jdField_a_of_type_Yxt.a(0);
    this.jdField_a_of_type_Yyq.g();
    QQToast.a(this.jdField_a_of_type_Yyq.jdField_a_of_type_Yze.a(), anzj.a(2131702728), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Yyq.jdField_a_of_type_Yxt.a(0);
    QQToast.a(this.jdField_a_of_type_Yyq.jdField_a_of_type_Yze.a(), 1, anzj.a(2131702663) + paramError, 0).a();
    this.jdField_a_of_type_Yyq.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyr
 * JD-Core Version:    0.7.0.1
 */