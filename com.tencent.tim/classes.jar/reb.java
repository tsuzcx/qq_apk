import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class reb
  extends SimpleObserver<rkm>
{
  reb(rdz paramrdz, rkm paramrkm) {}
  
  public void b(rkm paramrkm)
  {
    super.onNext(paramrkm);
    this.this$0.updateProgress(5);
    paramrkm = this.a.b;
    ram.d("EditVideoSave", "publishParam = " + paramrkm);
    Intent localIntent;
    int j;
    int i;
    if (this.this$0.a.getActivity() != null)
    {
      localIntent = this.this$0.a.getActivity().getIntent();
      if (localIntent == null) {
        break label331;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.this$0.a.getContext(), paramrkm.fakeVid, i, j, this.this$0.b.a.tg());
      rdz.a(this.this$0, paramrkm.fakeVid);
      localIntent.putExtra("mediacodec_encode_enable", true);
      this.this$0.a.getActivity().startActivityForResult(localIntent, 111);
      rdz.a(this.this$0, SystemClock.elapsedRealtime());
      this.this$0.progress = 5;
      this.this$0.aGH = false;
      this.this$0.bpE = ((int)(7000.0D / paramrkm.videoDuration * 4.0D));
      ram.d("EditVideoSave", "[30s]progressIncrement Old = " + this.this$0.bpE);
      if (this.this$0.bpE <= 0) {
        this.this$0.bpE = 2;
      }
      ram.d("EditVideoSave", "[30s]progressIncrement new = " + this.this$0.bpE);
      this.this$0.adc();
      if (anij.a().dGP == 1) {}
      for (i = 1;; i = 2)
      {
        alwx.TI(i);
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
    ram.w("EditVideoSave", "saveVideo cancel !");
    this.this$0.b.changeState(0);
    this.this$0.dismissProgressDialog();
    QQToast.a(this.this$0.a.getContext(), acfp.m(2131705522), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.this$0.b.changeState(0);
    QQToast.a(this.this$0.a.getContext(), 1, acfp.m(2131705590) + paramError, 0).show();
    this.this$0.dismissProgressDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     reb
 * JD-Core Version:    0.7.0.1
 */