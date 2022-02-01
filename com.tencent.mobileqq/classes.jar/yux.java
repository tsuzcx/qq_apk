import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class yux
  extends SimpleObserver<zem>
{
  yux(yuv paramyuv, zem paramzem) {}
  
  public void a(zem paramzem)
  {
    super.onNext(paramzem);
    this.jdField_a_of_type_Yuv.a(5);
    paramzem = this.jdField_a_of_type_Zem.a;
    yqp.b("EditVideoSave", "publishParam = " + paramzem);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Yuv.jdField_a_of_type_Yvj.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Yuv.jdField_a_of_type_Yvj.getActivity().getIntent();
      if (localIntent == null) {
        break label331;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Yuv.jdField_a_of_type_Yvj.a(), paramzem.b, i, j, this.jdField_a_of_type_Yuv.jdField_a_of_type_Yty.a.a());
      yuv.a(this.jdField_a_of_type_Yuv, paramzem.b);
      localIntent.putExtra("mediacodec_encode_enable", true);
      this.jdField_a_of_type_Yuv.jdField_a_of_type_Yvj.getActivity().startActivityForResult(localIntent, 111);
      yuv.a(this.jdField_a_of_type_Yuv, SystemClock.elapsedRealtime());
      this.jdField_a_of_type_Yuv.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Yuv.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Yuv.b = ((int)(7000.0D / paramzem.a * 4.0D));
      yqp.b("EditVideoSave", "[30s]progressIncrement Old = " + this.jdField_a_of_type_Yuv.b);
      if (this.jdField_a_of_type_Yuv.b <= 0) {
        this.jdField_a_of_type_Yuv.b = 2;
      }
      yqp.b("EditVideoSave", "[30s]progressIncrement new = " + this.jdField_a_of_type_Yuv.b);
      this.jdField_a_of_type_Yuv.f();
      if (bcig.a().jdField_a_of_type_Int == 1) {}
      for (i = 1;; i = 2)
      {
        banm.j(i);
        return;
      }
      label331:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yqp.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Yuv.jdField_a_of_type_Yty.a(0);
    this.jdField_a_of_type_Yuv.g();
    QQToast.a(this.jdField_a_of_type_Yuv.jdField_a_of_type_Yvj.a(), anni.a(2131702537), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yqp.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Yuv.jdField_a_of_type_Yty.a(0);
    QQToast.a(this.jdField_a_of_type_Yuv.jdField_a_of_type_Yvj.a(), 1, anni.a(2131702605) + paramError, 0).a();
    this.jdField_a_of_type_Yuv.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yux
 * JD-Core Version:    0.7.0.1
 */