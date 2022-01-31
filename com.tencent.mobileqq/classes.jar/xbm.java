import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class xbm
  extends SimpleObserver<xlb>
{
  xbm(xbk paramxbk, xlb paramxlb) {}
  
  public void a(xlb paramxlb)
  {
    super.onNext(paramxlb);
    this.jdField_a_of_type_Xbk.a(5);
    paramxlb = this.jdField_a_of_type_Xlb.a;
    wxe.b("EditVideoSave", "publishParam = " + paramxlb);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Xbk.jdField_a_of_type_Xby.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Xbk.jdField_a_of_type_Xby.getActivity().getIntent();
      if (localIntent == null) {
        break label331;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Xbk.jdField_a_of_type_Xby.a(), paramxlb.b, i, j, this.jdField_a_of_type_Xbk.jdField_a_of_type_Xan.a.a());
      xbk.a(this.jdField_a_of_type_Xbk, paramxlb.b);
      localIntent.putExtra("mediacodec_encode_enable", true);
      this.jdField_a_of_type_Xbk.jdField_a_of_type_Xby.getActivity().startActivityForResult(localIntent, 111);
      xbk.a(this.jdField_a_of_type_Xbk, SystemClock.elapsedRealtime());
      this.jdField_a_of_type_Xbk.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Xbk.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Xbk.b = ((int)(7000.0D / paramxlb.a * 4.0D));
      wxe.b("EditVideoSave", "[30s]progressIncrement Old = " + this.jdField_a_of_type_Xbk.b);
      if (this.jdField_a_of_type_Xbk.b <= 0) {
        this.jdField_a_of_type_Xbk.b = 2;
      }
      wxe.b("EditVideoSave", "[30s]progressIncrement new = " + this.jdField_a_of_type_Xbk.b);
      this.jdField_a_of_type_Xbk.f();
      if (azhg.a().jdField_a_of_type_Int == 1) {}
      for (i = 1;; i = 2)
      {
        axpl.j(i);
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
    wxe.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Xbk.jdField_a_of_type_Xan.a(0);
    this.jdField_a_of_type_Xbk.g();
    QQToast.a(this.jdField_a_of_type_Xbk.jdField_a_of_type_Xby.a(), alud.a(2131704140), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wxe.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Xbk.jdField_a_of_type_Xan.a(0);
    QQToast.a(this.jdField_a_of_type_Xbk.jdField_a_of_type_Xby.a(), 1, alud.a(2131704208) + paramError, 0).a();
    this.jdField_a_of_type_Xbk.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbm
 * JD-Core Version:    0.7.0.1
 */