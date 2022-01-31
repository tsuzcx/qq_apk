import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class vio
  extends SimpleObserver<vsd>
{
  vio(vim paramvim, vsd paramvsd) {}
  
  public void a(vsd paramvsd)
  {
    super.onNext(paramvsd);
    this.jdField_a_of_type_Vim.a(5);
    paramvsd = this.jdField_a_of_type_Vsd.a;
    veg.b("EditVideoSave", "publishParam = " + paramvsd);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Vim.jdField_a_of_type_Vja.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Vim.jdField_a_of_type_Vja.getActivity().getIntent();
      if (localIntent == null) {
        break label331;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Vim.jdField_a_of_type_Vja.a(), paramvsd.b, i, j, this.jdField_a_of_type_Vim.jdField_a_of_type_Vhp.a.a());
      vim.a(this.jdField_a_of_type_Vim, paramvsd.b);
      localIntent.putExtra("mediacodec_encode_enable", true);
      this.jdField_a_of_type_Vim.jdField_a_of_type_Vja.getActivity().startActivityForResult(localIntent, 111);
      vim.a(this.jdField_a_of_type_Vim, SystemClock.elapsedRealtime());
      this.jdField_a_of_type_Vim.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_Vim.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Vim.b = ((int)(7000.0D / paramvsd.a * 4.0D));
      veg.b("EditVideoSave", "[30s]progressIncrement Old = " + this.jdField_a_of_type_Vim.b);
      if (this.jdField_a_of_type_Vim.b <= 0) {
        this.jdField_a_of_type_Vim.b = 2;
      }
      veg.b("EditVideoSave", "[30s]progressIncrement new = " + this.jdField_a_of_type_Vim.b);
      this.jdField_a_of_type_Vim.f();
      if (axhp.a().jdField_a_of_type_Int == 1) {}
      for (i = 1;; i = 2)
      {
        avtb.j(i);
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
    veg.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Vim.jdField_a_of_type_Vhp.a(0);
    this.jdField_a_of_type_Vim.g();
    bcpw.a(this.jdField_a_of_type_Vim.jdField_a_of_type_Vja.a(), ajyc.a(2131703745), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Vim.jdField_a_of_type_Vhp.a(0);
    bcpw.a(this.jdField_a_of_type_Vim.jdField_a_of_type_Vja.a(), 1, ajyc.a(2131703813) + paramError, 0).a();
    this.jdField_a_of_type_Vim.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vio
 * JD-Core Version:    0.7.0.1
 */