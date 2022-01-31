import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class xjv
  extends Handler
{
  public xjv(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1000: 
    default: 
    case 1103: 
    case 1102: 
    case 1001: 
    case 1100: 
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("EditLocalVideoActivity", 2, "handleMessage, MSG_ON_CONFIRM");
          }
          EditLocalVideoActivity.a(this.a, false);
          if (EditLocalVideoActivity.a(this.a).isPlaying()) {
            EditLocalVideoActivity.a(this.a).pause();
          }
          EditLocalVideoActivity.a(this.a).setPlayDuration(EditLocalVideoActivity.a(this.a), EditLocalVideoActivity.b(this.a) - EditLocalVideoActivity.a(this.a));
          EditLocalVideoActivity.a(this.a).start();
          EditLocalVideoActivity.a(this.a, true);
          return;
          if (EditLocalVideoActivity.a(this.a) != null) {
            try
            {
              paramMessage = (String)paramMessage.obj;
              int i = EditLocalVideoActivity.a(this.a).getWidth();
              int j = EditLocalVideoActivity.a(this.a).getHeight();
              if (QLog.isColorLevel()) {
                QLog.d("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER, filename=" + paramMessage + ", w=" + i + ", h=" + j);
              }
              EditLocalVideoActivity.a(this.a, this.a.a(paramMessage, i, j, false));
              if (EditLocalVideoActivity.a(this.a) != null)
              {
                ViewGroup.LayoutParams localLayoutParams = EditLocalVideoActivity.a(this.a).getLayoutParams();
                localLayoutParams.height = j;
                localLayoutParams.width = i;
                EditLocalVideoActivity.a(this.a).setLayoutParams(localLayoutParams);
                EditLocalVideoActivity.a(this.a).setImageBitmap(EditLocalVideoActivity.a(this.a));
                if (EditLocalVideoActivity.a(this.a)) {
                  EditLocalVideoActivity.a(this.a).setVisibility(0);
                }
                EditLocalVideoActivity.a(this.a, i);
                EditLocalVideoActivity.b(this.a, j);
                EditLocalVideoActivity.a(this.a, paramMessage);
                return;
              }
            }
            catch (Throwable paramMessage)
            {
              QLog.w("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER failed", paramMessage);
              return;
            }
          }
        }
        new AlertDialog.Builder(this.a).setMessage("初始化裁剪组件失败").setNegativeButton(2131428346, new xjw(this)).setCancelable(false).create().show();
        return;
      } while (EditLocalVideoActivity.a(this.a) == null);
      EditLocalVideoActivity.a(this.a).requestLayout();
      return;
    case 9999: 
      EditLocalVideoActivity.a(this.a, "play_local_video", "play_local_video_success", "1", Build.MODEL);
      try
      {
        new AlertDialog.Builder(this.a).setMessage("加载视频超时").setNegativeButton(2131428346, new xjx(this)).setCancelable(false).create().show();
        return;
      }
      catch (Exception paramMessage)
      {
        QLog.e("EditLocalVideoActivity", 2, "LOAD_VIDEO_TIME_OUT showDialog error", paramMessage);
        return;
      }
    case 1101: 
      Toast.makeText(this.a.getApplicationContext(), "裁剪的视频格式不支持，请重新选择视频", 1).show();
      EditLocalVideoActivity.a(this.a);
      return;
    case 1006: 
      this.a.a("608", "3", "1", true);
      LpReportInfo_pf00064.allReport(664, 3, 4);
      paramMessage = (String)paramMessage.obj;
      EditLocalVideoActivity.a(this.a, paramMessage);
      return;
    case 1007: 
      this.a.a("608", "3", "2", true);
      EditLocalVideoActivity.b(this.a, true);
      return;
    }
    EditLocalVideoActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjv
 * JD-Core Version:    0.7.0.1
 */