import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class ayhu
  extends SimpleObserver<ayqb>
{
  ayhu(ayhs paramayhs, ayqb paramayqb) {}
  
  public void b(ayqb paramayqb)
  {
    super.onNext(paramayqb);
    this.this$0.updateProgress(5);
    paramayqb = this.a.b;
    ram.d("EditVideoSave", "publishParam = " + paramayqb);
    Intent localIntent1;
    int j;
    int i;
    if (this.this$0.a.getActivity() != null)
    {
      localIntent1 = this.this$0.a.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.this$0.a.getContext(), paramayqb.fakeVid, i, j, this.this$0.b.a.tg());
      ayhs.a(this.this$0, paramayqb.fakeVid);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (paramayqb.bsX != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.this$0.eKi != 47) {
          break label296;
        }
        this.this$0.a.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.this$0.progress = 5.0F;
        this.this$0.aGH = false;
        this.this$0.Fy = (50000.0F / (float)paramayqb.videoDuration);
        if (this.this$0.Fy == 0.0F) {
          this.this$0.Fy = 1.0F;
        }
        this.this$0.adc();
        return;
        bool = false;
        break;
        label296:
        this.this$0.a.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ram.w("EditVideoSave", "saveVideo cancel !");
    this.this$0.b.changeState(0);
    this.this$0.dismissProgressDialog();
    QQToast.a(this.this$0.a.getContext(), acfp.m(2131705601), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.this$0.b.changeState(0);
    QQToast.a(this.this$0.a.getContext(), 1, acfp.m(2131705510) + paramError, 0).show();
    this.this$0.dismissProgressDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhu
 * JD-Core Version:    0.7.0.1
 */