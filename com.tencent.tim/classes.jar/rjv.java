import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class rjv
  extends Handler
{
  public rjv(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    QLog.d("Q.qqstory.publish.edit.EditVideoMusicDialog", 1, new Object[] { "TESTLOG, handleMessage: ", Integer.valueOf(paramMessage.what) });
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return;
            this.this$0.bvf();
            paramMessage = this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
            if (this.this$0.jdField_a_of_type_Rka != null)
            {
              this.this$0.jdField_a_of_type_Rka.cr(this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.nu);
              this.this$0.jdField_a_of_type_Rka.f(paramMessage);
              this.this$0.jdField_a_of_type_Rka.notifyDataSetChanged();
            }
          } while (paramMessage == null);
          if (paramMessage.musicType == 0)
          {
            this.this$0.mUIHandler.sendEmptyMessage(3);
            return;
          }
          if ((paramMessage.musicType == 1) && (!this.this$0.mIsTakePhoto))
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
        paramMessage = this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
        if ((paramMessage != null) && (paramMessage.aAR != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "MSG_PLAY_MUSIC music is NULL");
      return;
      paramMessage.duration = ((int)ShortVideoUtils.getDuration(paramMessage.aAR));
      if (paramMessage.start < 0) {
        paramMessage.start = 0;
      }
      if (paramMessage.start + this.this$0.bsu > paramMessage.duration) {
        paramMessage.start = 0;
      }
      paramMessage.end = (paramMessage.start + this.this$0.bsu);
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.wY(3);
      this.this$0.G.setVisibility(8);
      this.this$0.oX.setVisibility(0);
      this.this$0.oW.setVisibility(0);
      this.this$0.yH.setVisibility(8);
      this.this$0.mTitleView.setText(paramMessage.title);
      this.this$0.tR(true);
      MusicHorizontalSeekView.ep((this.this$0.tx() + 500) / 1000, this.this$0.getContext().getResources().getDisplayMetrics().widthPixels);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.this$0.tx() + 500) / 1000, (Math.max(paramMessage.duration, this.this$0.bsu) + 500) / 1000);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.xF(paramMessage.start);
      this.this$0.eo(paramMessage.start, paramMessage.end);
      return;
    case 11: 
      paramMessage = this.this$0.c;
      paramMessage.duration = ((int)ShortVideoUtils.getDuration(paramMessage.aAR));
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramMessage);
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.wY(3);
      this.this$0.G.setVisibility(8);
      this.this$0.oX.setVisibility(0);
      this.this$0.oW.setVisibility(0);
      this.this$0.yH.setVisibility(8);
      this.this$0.mTitleView.setText(paramMessage.title);
      this.this$0.tR(true);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.this$0.tx() + 500) / 1000, (Math.max(paramMessage.duration, this.this$0.bsu) + 500) / 1000);
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.xF(paramMessage.start);
      this.this$0.eo(paramMessage.start, paramMessage.end);
      return;
    case 3: 
      this.this$0.bvf();
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(rkc.e);
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.wY(0);
      this.this$0.mTitleView.setText("");
      this.this$0.yH.setText(acfp.m(2131705489));
      this.this$0.yH.setVisibility(0);
      this.this$0.oW.setVisibility(8);
      this.this$0.tR(true);
      return;
    case 6: 
      if ((this.this$0.aIv) && (this.this$0.jdField_b_of_type_Rjp != null)) {
        this.this$0.jdField_b_of_type_Rjp.buV();
      }
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(rkc.f);
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.wY(1);
      this.this$0.mTitleView.setText("");
      this.this$0.yH.setText(acfp.m(2131705615));
      this.this$0.yH.setVisibility(0);
      this.this$0.oW.setVisibility(8);
      this.this$0.tR(true);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.this$0.getContext(), paramMessage, 0).show();
      this.this$0.tR(true);
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
    case 10: 
      paramMessage = (rkc)paramMessage.obj;
      paramMessage.musicType = 4;
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramMessage);
      this.this$0.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.wY(4);
      this.this$0.mTitleView.setText("");
      this.this$0.yH.setText(acfp.m(2131705527) + paramMessage.title);
      this.this$0.yH.setVisibility(0);
      this.this$0.oW.setVisibility(8);
      this.this$0.tR(true);
      return;
    }
    paramMessage = (rkc)paramMessage.obj;
    this.this$0.e(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjv
 * JD-Core Version:    0.7.0.1
 */