import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.IP2VMusicEditListener;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class xrf
  extends Handler
{
  public xrf(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    case 6: 
    case 10: 
    default: 
    case 1: 
    case 2: 
    case 11: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.a.a();
              if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter != null)
              {
                this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(P2VEditMusicDialog.a(this.a).a());
                this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
              }
              paramMessage = P2VEditMusicDialog.a(this.a).a();
              this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(paramMessage);
              if (paramMessage == null) {
                break;
              }
              if (paramMessage.jdField_b_of_type_Int == 0)
              {
                this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
                return;
              }
              if (paramMessage.jdField_b_of_type_Int == 1)
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
            this.a.a(paramMessage.jdField_d_of_type_JavaLangString);
            return;
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
            return;
            this.a.a();
            paramMessage = P2VEditMusicDialog.a(this.a).a();
            if (paramMessage != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("zivonchen", 2, "MSG_PLAY_MUSIC music is NULL!!!!!");
          return;
          paramMessage.f = ((int)ShortVideoUtils.a(paramMessage.g));
          if (paramMessage.jdField_d_of_type_Int < 0) {
            paramMessage.jdField_d_of_type_Int = 0;
          }
          if (paramMessage.jdField_d_of_type_Int + this.a.jdField_a_of_type_Int > paramMessage.f) {
            paramMessage.jdField_d_of_type_Int = 0;
          }
          paramMessage.e = (paramMessage.jdField_d_of_type_Int + this.a.jdField_a_of_type_Int);
          P2VEditMusicDialog.a(this.a).b(3);
          this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
          this.a.b();
          MusicHorizontalSeekView.a((this.a.a() + 500) / 1000, this.a.getContext().getResources().getDisplayMetrics().widthPixels - ViewUtils.a(8.0F));
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.jdField_d_of_type_Int);
          this.a.b(paramMessage.jdField_d_of_type_Int, paramMessage.e);
        } while ((!this.a.jdField_a_of_type_Boolean) || (P2VEditMusicDialog.a(this.a) == null) || (!P2VEditMusicDialog.a(this.a).c()));
        P2VEditMusicDialog.a(this.a).l();
        this.a.jdField_a_of_type_Boolean = false;
        P2VEditMusicDialog.a(this.a).b(false);
        return;
        this.a.a();
        paramMessage = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        paramMessage.f = ((int)ShortVideoUtils.a(paramMessage.g));
        if (paramMessage.jdField_d_of_type_Int < 0) {
          paramMessage.jdField_d_of_type_Int = 0;
        }
        if (paramMessage.jdField_d_of_type_Int + this.a.jdField_a_of_type_Int > paramMessage.f) {
          paramMessage.jdField_d_of_type_Int = 0;
        }
        paramMessage.e = (paramMessage.jdField_d_of_type_Int + this.a.jdField_a_of_type_Int);
        P2VEditMusicDialog.a(this.a).a(paramMessage);
        P2VEditMusicDialog.a(this.a).b(3);
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
        this.a.b();
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.jdField_d_of_type_Int);
        this.a.b(paramMessage.jdField_d_of_type_Int, paramMessage.e);
      } while ((!this.a.jdField_a_of_type_Boolean) || (P2VEditMusicDialog.a(this.a) == null) || (!P2VEditMusicDialog.a(this.a).c()));
      P2VEditMusicDialog.a(this.a).l();
      this.a.jdField_a_of_type_Boolean = false;
      P2VEditMusicDialog.a(this.a).b(false);
      return;
    case 3: 
      this.a.a();
      P2VEditMusicDialog.a(this.a).a(QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      P2VEditMusicDialog.a(this.a).b(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前无任何音效");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a.getContext(), paramMessage, 0).a();
      return;
    case 8: 
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setPlayedPosition(this.a.jdField_b_of_type_Int);
      return;
    }
    if (this.a.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrf
 * JD-Core Version:    0.7.0.1
 */