import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.a;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aast
  extends Handler
{
  public aast(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    case 10: 
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          this.this$0.cap();
          if (this.this$0.jdField_a_of_type_Rka != null)
          {
            this.this$0.jdField_a_of_type_Rka.cr(this.this$0.se);
            this.this$0.jdField_a_of_type_Rka.notifyDataSetChanged();
          }
          paramMessage = this.this$0.b.a();
          if (this.this$0.jdField_a_of_type_Rka != null) {
            this.this$0.jdField_a_of_type_Rka.f(paramMessage);
          }
          if (paramMessage == null) {
            break;
          }
          if (paramMessage.musicType == 0)
          {
            this.this$0.mUIHandler.sendEmptyMessage(3);
            return;
          }
          if (paramMessage.musicType == 1)
          {
            this.this$0.mUIHandler.sendEmptyMessage(6);
            return;
          }
          if (!TextUtils.isEmpty(paramMessage.aAR))
          {
            this.this$0.mUIHandler.sendEmptyMessage(2);
            return;
          }
        } while (!this.this$0.aIu);
        this.this$0.aIu = false;
        this.this$0.d(paramMessage);
        return;
        if (!this.this$0.b.WP())
        {
          this.this$0.mUIHandler.sendEmptyMessage(3);
          return;
        }
        this.this$0.mUIHandler.sendEmptyMessage(6);
        return;
        this.this$0.cap();
        paramMessage = this.this$0.b.a();
        if (paramMessage != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(P2VEditMusicDialog.access$000(), 2, "MSG_PLAY_MUSIC music is NULL!!!!!");
      return;
      if (paramMessage.aAR == null)
      {
        QLog.e(P2VEditMusicDialog.access$000(), 2, "MSG_PLAY_MUSIC music.download_path is NULL!!!!!");
        return;
      }
      paramMessage.duration = ((int)ShortVideoUtils.getDuration(paramMessage.aAR));
      if (paramMessage.start < 0) {
        paramMessage.start = 0;
      }
      if (paramMessage.start + this.this$0.bsu > paramMessage.duration) {
        paramMessage.start = 0;
      }
      paramMessage.end = (paramMessage.start + this.this$0.bsu);
      this.this$0.b.Gd(3);
      this.this$0.G.setVisibility(8);
      this.this$0.oX.setVisibility(0);
      this.this$0.oW.setVisibility(0);
      this.this$0.yH.setVisibility(8);
      this.this$0.mTitleView.setText(paramMessage.title);
      this.this$0.cxW();
      MusicHorizontalSeekView.ep((this.this$0.tx() + 500) / 1000, this.this$0.getContext().getResources().getDisplayMetrics().widthPixels - aqnm.dip2px(8.0F));
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.this$0.tx() + 500) / 1000, (Math.max(paramMessage.duration, this.this$0.bsu) + 500) / 1000);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.xF(paramMessage.start);
      this.this$0.eo(paramMessage.start, paramMessage.end);
      return;
    case 11: 
      this.this$0.cap();
      paramMessage = this.this$0.c;
      paramMessage.duration = ((int)ShortVideoUtils.getDuration(paramMessage.aAR));
      if (paramMessage.start < 0) {
        paramMessage.start = 0;
      }
      if (paramMessage.start + this.this$0.bsu > paramMessage.duration) {
        paramMessage.start = 0;
      }
      paramMessage.end = (paramMessage.start + this.this$0.bsu);
      this.this$0.b.h(paramMessage);
      this.this$0.b.Gd(3);
      this.this$0.G.setVisibility(8);
      this.this$0.oX.setVisibility(0);
      this.this$0.oW.setVisibility(0);
      this.this$0.yH.setVisibility(8);
      this.this$0.mTitleView.setText(paramMessage.title);
      this.this$0.cxW();
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.this$0.tx() + 500) / 1000, (Math.max(paramMessage.duration, this.this$0.bsu) + 500) / 1000);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.xF(paramMessage.start);
      this.this$0.eo(paramMessage.start, paramMessage.end);
      return;
    case 3: 
      this.this$0.cap();
      this.this$0.b.h(rkc.e);
      this.this$0.b.Gd(0);
      this.this$0.mTitleView.setText("");
      this.this$0.yH.setText(acfp.m(2131709387));
      this.this$0.yH.setVisibility(0);
      this.this$0.oW.setVisibility(8);
      return;
    case 6: 
      this.this$0.cap();
      this.this$0.b.h(rkc.f);
      this.this$0.b.Gd(1);
      this.this$0.mTitleView.setText("");
      this.this$0.yH.setText(acfp.m(2131709386));
      this.this$0.yH.setVisibility(0);
      this.this$0.oW.setVisibility(8);
      P2VEditMusicDialog.a(this.this$0);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.this$0.getContext(), paramMessage, 0).show();
      return;
    case 8: 
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setPlayedPosition(this.this$0.bsv);
      return;
    case 9: 
      if (this.this$0.G.getVisibility() != 0)
      {
        this.this$0.G.setVisibility(0);
        this.this$0.oX.setVisibility(8);
      }
      this.this$0.G.setProgress(paramMessage.arg1);
      return;
    }
    paramMessage = (rkc)paramMessage.obj;
    this.this$0.e(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aast
 * JD-Core Version:    0.7.0.1
 */