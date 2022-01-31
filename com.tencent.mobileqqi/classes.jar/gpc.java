import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MusicSharePlayActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class gpc
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  public gpc(StructMsgForAudioShare paramStructMsgForAudioShare) {}
  
  public void onClick(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = l;
      if ((paramView.getTag() instanceof AbsShareMsg)) {
        break label42;
      }
    }
    label42:
    do
    {
      return;
      Object localObject3 = (AbsShareMsg)paramView.getTag();
      Context localContext = paramView.getContext();
      try
      {
        Object localObject1 = (QQAppInterface)((BaseApplicationImpl)localContext.getApplicationContext()).getAppRuntime(((AbsShareMsg)localObject3).currentAccountUin);
        if (localObject1 != null) {
          MediaPlayerManager.a((QQAppInterface)localObject1).a(true);
        }
        if ((localObject3 != null) && (((AbsShareMsg)localObject3).mMsgServiceID == 2))
        {
          localObject1 = (StructMsgForAudioShare)localObject3;
          if (QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare))
          {
            QQPlayerService.c(localContext);
            paramView.setContentDescription(localResources.getString(2131562973));
            return;
          }
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        Object localObject2;
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("StructMsg", 4, localAccountNotMatchException.getStackTrace().toString());
          }
          localObject2 = null;
        }
        localObject3 = new SongInfo();
        ((SongInfo)localObject3).a = localObject2.mContentSrc;
        ((SongInfo)localObject3).b = localObject2.mContentTitle;
        ((SongInfo)localObject3).c = localObject2.mContentSummary;
        ((SongInfo)localObject3).d = localObject2.mContentCover;
        ((SongInfo)localObject3).e = localObject2.mMsgUrl;
        QQPlayerService.a(new Intent(localContext, MusicSharePlayActivity.class));
        QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare);
        QQPlayerService.a(localContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.getToken(), (SongInfo)localObject3);
        paramView.setContentDescription(localResources.getString(2131562615));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQPlayerService", 2, "msg is null or serviceId not audio_share");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gpc
 * JD-Core Version:    0.7.0.1
 */