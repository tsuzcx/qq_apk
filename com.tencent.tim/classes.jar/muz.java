import android.content.ContextWrapper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

class muz
  extends QIPCModule
{
  muz(muy parammuy, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ("CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD".equals(paramString))
    {
      paramBundle.setClassLoader(MessageForShortVideo.class.getClassLoader());
      paramString = (MessageForShortVideo)paramBundle.getParcelable("VALUE_SHORTVIDEO_MSG");
      paramBundle = wla.a((QQAppInterface)localObject);
      if (paramBundle != null)
      {
        if (muy.a(this.b) == null) {
          muy.a(this.b, new View(BaseApplicationImpl.getContext()));
        }
        muy.a(this.b, new mva(this, paramString));
        paramBundle.a(muy.a(this.b), muy.a(this.b));
      }
      paramString.busiType = 0;
      paramString = anfr.a((QQAppInterface)localObject, paramString, 1);
      if (paramString != null) {
        anfr.a(paramString, (QQAppInterface)localObject);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return null;
              if ("CMD_SHORTVIDEO_UPDATE_MSG_BY_UNISEQ".equals(paramString))
              {
                paramBundle.setClassLoader(MessageForShortVideo.class.getClassLoader());
                paramString = (MessageForShortVideo)paramBundle.getParcelable("VALUE_SHORTVIDEO_MSG");
                ((QQAppInterface)localObject).b().c(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
              }
              else if ("CMD_SHORTVIDEO_REQUEST_CLEAR".equals(paramString))
              {
                if (muy.a(this.b) != null)
                {
                  if (wla.a((QQAppInterface)localObject) != null) {
                    wla.a((QQAppInterface)localObject).a(muy.a(this.b), null);
                  }
                  muy.a(this.b, null);
                }
                muy.a(this.b, null);
              }
              else if ("CMD_HANDLE_FORWARD_DATA".equals(paramString))
              {
                muj.b((QQAppInterface)localObject, paramBundle);
              }
              else if ("CMD_INIT_READINJOY_MANAGER".equals(paramString))
              {
                ((QQAppInterface)localObject).getManager(96);
              }
              else
              {
                if ("CMD_PUB_ACCOUNT_CHECK_IS_FOLLOWED".equals(paramString)) {
                  try
                  {
                    bool = muj.b((QQAppInterface)localObject, paramBundle.getLong("VALUE_PUB_ACCOUNT_UIN"));
                    paramString = new Bundle();
                    paramString.putBoolean("VALUE_PUB_ACCOUNT_IS_FOLLOWED", bool);
                    return EIPCResult.createSuccessResult(paramString);
                  }
                  catch (Exception paramString)
                  {
                    for (;;)
                    {
                      boolean bool = true;
                    }
                  }
                }
                if ("CMD_FOLLOW_PUB_ACCOUNT".equals(paramString))
                {
                  muj.a((QQAppInterface)localObject, paramBundle.getString("VALUE_PUB_ACCOUNT_UIN"), false);
                }
                else
                {
                  if ("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_GET".equals(paramString))
                  {
                    paramBundle = new Bundle();
                    paramBundle.putBoolean("VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS", mzj.a().P(false));
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " shouldMuteInVideoFeed = " + mzj.a().P(false));
                    }
                    return EIPCResult.createSuccessResult(paramBundle);
                  }
                  if ("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_SET".equals(paramString))
                  {
                    localObject = Boolean.valueOf(false);
                    if (paramBundle != null) {
                      localObject = Boolean.valueOf(paramBundle.getBoolean("VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS", false));
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + "  VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS = " + localObject);
                    }
                    mzj.a().oU(((Boolean)localObject).booleanValue());
                  }
                  else
                  {
                    if ("CMD_IS_VIDEO_PLAY_NEED_ALERT_IN_XG".equals(paramString))
                    {
                      paramBundle = new Bundle();
                      paramBundle.putBoolean("VALUE_VIDEO_NEED_ALERT", mst.a().Eh());
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_VIDEO_NEED_ALERT = " + mst.a().Eh());
                      }
                      return EIPCResult.createSuccessResult(paramBundle);
                    }
                    if ("CMD_IS_VIDEO_CHATTING".equals(paramString))
                    {
                      paramString = new Bundle();
                      paramString.putBoolean("VALUE_IS_VIDEO_CHATTING", ((QQAppInterface)localObject).bF());
                      return EIPCResult.createSuccessResult(paramString);
                    }
                    if ("CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG".equals(paramString))
                    {
                      localObject = Boolean.valueOf(true);
                      if (paramBundle != null) {
                        localObject = Boolean.valueOf(paramBundle.getBoolean("VALUE_IS_CONFIRM_IN_XG"));
                      }
                      mst.a().anP = ((Boolean)localObject).booleanValue();
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_IS_CONFIRM_IN_XG = " + localObject);
                      }
                    }
                    else if ("CMD_NETWORK_CHANGE".equals(paramString))
                    {
                      localObject = Boolean.valueOf(true);
                      if (paramBundle != null) {
                        localObject = Boolean.valueOf(paramBundle.getBoolean("VALUE_NETWORK_CHANGE_IS_WIFI"));
                      }
                      mst.a().od(((Boolean)localObject).booleanValue());
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_NETWORK_CHANGE_IS_WIFI = " + localObject);
                      }
                    }
                    else if ("CMD_IGNORE_VOLUME_CHANGE".equals(paramString))
                    {
                      mzj.a().oV(true);
                    }
                    else if ("CMD_CANCEL_IGNORE_VOLUME_CHANGE".equals(paramString))
                    {
                      mzj.a().oV(false);
                    }
                    else
                    {
                      if ("CMD_GET_CURRENT_NICK_NAME".equals(paramString))
                      {
                        paramString = ((QQAppInterface)localObject).getCurrentNickname();
                        paramBundle = new Bundle();
                        paramBundle.putString("VALUE_GET_CURRENT_NICK_NAME", paramString);
                        return EIPCResult.createSuccessResult(paramBundle);
                      }
                      if ("CMD_GET_CURRENT_USER_HEAD".equals(paramString))
                      {
                        paramString = ((QQAppInterface)localObject).getCustomFaceFilePath(1, ((QQAppInterface)localObject).getCurrentUin(), 200);
                        paramBundle = new Bundle();
                        paramBundle.putString("CMD_GET_CURRENT_USER_HEAD", paramString);
                        return EIPCResult.createSuccessResult(paramBundle);
                      }
                      if ("CMD_CAMERA_CAPTURE_CHECK_SO_READY".equals(paramString))
                      {
                        paramString = new Bundle();
                        paramString.putBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY", Boolean.valueOf(kqg.b((QQAppInterface)localObject, BaseApplicationImpl.getContext())).booleanValue());
                        paramString.putBoolean("VALUE_CAMERA_IS_VIDEO_CHATTING", ((QQAppInterface)localObject).bF());
                        return EIPCResult.createSuccessResult(paramString);
                      }
                      if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
                      {
                        if (muy.a(this.b) == null) {
                          muy.a(this.b, new kqh((QQAppInterface)localObject, BaseApplicationImpl.getContext()));
                        }
                        muy.a(this.b).a(new mvb(this));
                        muy.a(this.b).start();
                      }
                      else
                      {
                        if ("CMD_GET_NICK_NAME_BY_UIN".equals(paramString))
                        {
                          muy.a(this.b, new mvc(this, (QQAppInterface)localObject));
                          ((QQAppInterface)localObject).addObserver(muy.a(this.b));
                          paramString = new Bundle();
                          paramString.putString("VALUE_USER_NICK_NAME", aqgv.b((QQAppInterface)localObject, paramBundle.getString("VALUE_USER_UIN_TO_GET_NICK_NAME"), true));
                          return EIPCResult.createSuccessResult(paramString);
                        }
                        if ("CMD_GET_NICK_NAME_BY_UIN_CANCLE".equals(paramString))
                        {
                          ((QQAppInterface)localObject).removeObserver(muy.a(this.b));
                        }
                        else
                        {
                          if (!"CMD_REPORT_START_TIME".equals(paramString)) {
                            break;
                          }
                          mxt.cd(((QQAppInterface)localObject).getApplication().getApplicationContext());
                        }
                      }
                    }
                  }
                }
              }
            }
            if ("CMD_GET_CLICK_COMMENT_ACTICLEINFO".equals(paramString))
            {
              paramBundle = new Bundle();
              paramBundle.putString("VALUE_CLICK_COMMENT_ACTICLEINFO", msg.a().ks());
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_CLICK_COMMENT_ACTICLEINFO = " + msg.a().ks());
              }
              return EIPCResult.createSuccessResult(paramBundle);
            }
            if (!"CMD_GET_UNREAD_MESSAGE_BOX_DATA".equals(paramString)) {
              break;
            }
          } while (msg.a().kr().isEmpty());
          paramBundle = msg.a().kr();
          localObject = new Bundle();
          ((Bundle)localObject).putString("VALUE_UNREAD_MESSAGE_BOX_DATA", paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 2, paramString + " VALUE_CLICK_COMMENT_ACTICLEINFO = " + paramBundle);
          }
          return EIPCResult.createSuccessResult((Bundle)localObject);
          if (!"CMD_GET_WEB_RENDER_DATA".equals(paramString)) {
            break;
          }
          paramString = paramBundle.getString("bundle_params_render_url");
        } while (TextUtils.isEmpty(paramString));
        paramString = lci.a(paramString);
      } while (paramString == null);
      paramBundle = new Bundle();
      paramBundle.putString("VALUE_WEB_RENDER_DATA", paramString.data);
      return EIPCResult.createSuccessResult(paramBundle);
      if ("CMD_GET_REPORT_KANDIAN_MODE".equals(paramString))
      {
        paramInt = kxm.nR();
        paramString = new Bundle();
        paramString.putInt("VALUE_REPORT_KANDIAN_MODE", paramInt);
        return EIPCResult.createSuccessResult(paramString);
      }
      if ("CMD_GET_REPORT_KANDIAN_MODE_NEW".equals(paramString))
      {
        paramInt = kct.nd();
        paramString = new Bundle();
        paramString.putInt("VALUE_REPORT_KANDIAN_MODE_NEW", paramInt);
        return EIPCResult.createSuccessResult(paramString);
      }
    } while (!"CMD_OPEN_VIOLA_FROM_TOOL".equals(paramString));
    localObject = paramBundle.getString("url");
    paramBundle = paramBundle.getString("webUrl");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (TextUtils.isEmpty(paramBundle)) {
        break label1565;
      }
      if ((SplashActivity.dO == null) || (SplashActivity.dO.get() == null)) {
        break label1558;
      }
    }
    label1558:
    for (paramString = (ContextWrapper)SplashActivity.dO.get();; paramString = BaseApplicationImpl.getContext())
    {
      ntp.a(paramString, "", (String)localObject, null, new mvd(this, paramBundle));
      return EIPCResult.createSuccessResult(null);
    }
    label1565:
    if ((SplashActivity.dO != null) && (SplashActivity.dO.get() != null)) {}
    for (paramString = (ContextWrapper)SplashActivity.dO.get();; paramString = BaseApplicationImpl.getContext())
    {
      ntp.b(paramString, "", (String)localObject, null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     muz
 * JD-Core Version:    0.7.0.1
 */