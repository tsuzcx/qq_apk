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

public class yxc
  extends Handler
{
  public yxc(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
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
            this.a.d();
            paramMessage = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
            if (this.a.jdField_a_of_type_Yxh != null)
            {
              this.a.jdField_a_of_type_Yxh.a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a);
              this.a.jdField_a_of_type_Yxh.a(paramMessage);
              this.a.jdField_a_of_type_Yxh.notifyDataSetChanged();
            }
          } while (paramMessage == null);
          if (paramMessage.jdField_b_of_type_Int == 0)
          {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
            return;
          }
          if ((paramMessage.jdField_b_of_type_Int == 1) && (!this.a.jdField_a_of_type_Boolean))
          {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
            return;
          }
          if (!TextUtils.isEmpty(paramMessage.g))
          {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
            return;
          }
        } while (!this.a.jdField_b_of_type_Boolean);
        this.a.jdField_b_of_type_Boolean = false;
        this.a.a(paramMessage);
        return;
        paramMessage = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
        if ((paramMessage != null) && (paramMessage.g != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", 2, "MSG_PLAY_MUSIC music is NULL");
      return;
      paramMessage.f = ((int)ShortVideoUtils.getDuration(paramMessage.g));
      if (paramMessage.d < 0) {
        paramMessage.d = 0;
      }
      if (paramMessage.d + this.a.jdField_a_of_type_Int > paramMessage.f) {
        paramMessage.d = 0;
      }
      paramMessage.e = (paramMessage.d + this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(3);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
      this.a.a(true);
      MusicHorizontalSeekView.a((this.a.a() + 500) / 1000, this.a.getContext().getResources().getDisplayMetrics().widthPixels);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.d);
      this.a.b(paramMessage.d, paramMessage.e);
      return;
    case 11: 
      paramMessage = this.a.jdField_a_of_type_Yxk;
      paramMessage.f = ((int)ShortVideoUtils.getDuration(paramMessage.g));
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramMessage);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(3);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
      this.a.a(true);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.d);
      this.a.b(paramMessage.d, paramMessage.e);
      return;
    case 3: 
      this.a.d();
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(yxk.jdField_a_of_type_Yxk);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131703197));
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.a.a(true);
      return;
    case 6: 
      if ((this.a.c) && (this.a.jdField_a_of_type_Ywu != null)) {
        this.a.jdField_a_of_type_Ywu.b();
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(yxk.jdField_b_of_type_Yxk);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(1);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131703320));
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.a.a(true);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a.getContext(), paramMessage, 0).a();
      this.a.a(true);
      return;
    case 8: 
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setPlayedPosition(this.a.jdField_b_of_type_Int);
      return;
    case 9: 
      if (this.a.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
      {
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg1);
      return;
    case 10: 
      paramMessage = (yxk)paramMessage.obj;
      paramMessage.jdField_b_of_type_Int = 4;
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramMessage);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(4);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131703235) + paramMessage.jdField_b_of_type_JavaLangString);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.a.a(true);
      return;
    }
    paramMessage = (yxk)paramMessage.obj;
    this.a.b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxc
 * JD-Core Version:    0.7.0.1
 */