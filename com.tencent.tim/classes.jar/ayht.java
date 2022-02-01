import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class ayht
  extends SimpleObserver<ayqb>
{
  ayht(ayhs paramayhs, ayqb paramayqb) {}
  
  public void b(ayqb paramayqb)
  {
    super.onNext(paramayqb);
    this.this$0.updateProgress(5);
    paramayqb = this.a.b;
    ram.d("EditVideoSave", "publishParam = " + paramayqb);
    Intent localIntent;
    int j;
    int i;
    if (this.this$0.a.getActivity() != null)
    {
      localIntent = this.this$0.a.getActivity().getIntent();
      if (localIntent == null) {
        break label292;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.this$0.a.getContext(), paramayqb.fakeVid, i, j, this.this$0.b.a.tg());
      boolean bool;
      if (paramayqb.bsX != 0)
      {
        bool = true;
        localIntent.putExtra("video_edit_flag", bool);
        ayhs.a(this.this$0, paramayqb.fakeVid);
        if (this.this$0.eKi != 47) {
          break label260;
        }
        localIntent.putExtra("requestCode", 222);
        this.this$0.a.getActivity().startActivityForResult(localIntent, 222);
      }
      for (;;)
      {
        this.this$0.progress = 5.0F;
        this.this$0.aGH = false;
        this.this$0.Fy = (7000.0F / (float)paramayqb.videoDuration * 4.0F);
        this.this$0.adc();
        return;
        bool = false;
        break;
        label260:
        localIntent.putExtra("requestCode", 111);
        this.this$0.a.getActivity().startActivityForResult(localIntent, 111);
      }
      label292:
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
    QQToast.a(this.this$0.a.getContext(), acfp.m(2131705555), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.this$0.b.changeState(0);
    QQToast.a(this.this$0.a.getContext(), 1, acfp.m(2131705518) + paramError, 0).show();
    this.this$0.dismissProgressDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayht
 * JD-Core Version:    0.7.0.1
 */