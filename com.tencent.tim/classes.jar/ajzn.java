import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class ajzn
  implements ajzp.e
{
  ajzn(ajzh paramajzh, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void b(ajzp paramajzp)
  {
    if (this.a.jdField_a_of_type_Ajzh$a != null) {
      this.a.jdField_a_of_type_Ajzh$a.dAk();
    }
    ajxs localajxs;
    if (((this.a.mContext instanceof BaseActivity)) && (((BaseActivity)this.a.mContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.a.mApp);
      }
      this.a.b.a(this.d.id, null);
      if (this.a.jdField_a_of_type_Ajyc != null) {
        this.a.jdField_a_of_type_Ajyc.l(this.d.id, 100, 0, "");
      }
      ((akio)this.a.mApp.getManager(263)).Nu(this.d.id);
      localajxs = new ajxs().i("video_view").h("video");
      if (!this.d.isFollowed) {
        break label367;
      }
    }
    label367:
    for (paramajzp = "0";; paramajzp = "1")
    {
      localajxs.g(paramajzp).b().f(ajxs.dlD + "").dy(this.a.mApp);
      this.a.jdField_a_of_type_Ajzp.start();
      if (!this.cqW)
      {
        long l = this.a.getFileSize();
        double d1 = this.a.gu() / l;
        ajxt.a(this.d.id, 1, String.valueOf(d1), String.valueOf(l), String.valueOf(this.a.gu()), String.valueOf(ajxt.gs()), true);
      }
      this.a.mHandler.removeMessages(2025);
      this.a.mHandler.sendEmptyMessageDelayed(2025, 100L);
      this.a.mHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzn
 * JD-Core Version:    0.7.0.1
 */