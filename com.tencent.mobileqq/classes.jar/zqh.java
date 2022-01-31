import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.file.DevVideoMsgProcessor.1;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class zqh
{
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {}
    while (lmm.b(BaseApplicationImpl.getContext())) {
      return;
    }
    if (!bdal.a())
    {
      bfhq.a().a(2131719535);
      return;
    }
    Object localObject = aljq.aX + "shortvideo/" + System.currentTimeMillis() + ".mp4";
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    localIntent.putExtra("android.intent.extra.videoQuality", 1);
    PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).edit().putString("device_video_path", (String)localObject).commit();
    if (Build.VERSION.SDK_INT > 10)
    {
      localObject = new File((String)localObject);
      ((File)localObject).getParentFile().mkdirs();
      localIntent.putExtra("output", Uri.fromFile((File)localObject));
      localIntent.putExtra("android.intent.extra.durationLimit", 60);
      localIntent.putExtra("android.intent.extra.sizeLimit", 1073741824);
      FileProvider7Helper.intentCompatForN(paramActivity, localIntent);
    }
    paramActivity.startActivityForResult(localIntent, 83);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new DevVideoMsgProcessor.1(paramString1, paramString2, paramQQAppInterface));
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, float paramFloat)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    MessageRecord localMessageRecord;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localMessageRecord = ((QQAppInterface)localObject).a().a(paramString, paramInt, paramLong);
      if (localMessageRecord != null) {
        break label43;
      }
    }
    label43:
    do
    {
      MessageForDevShortVideo localMessageForDevShortVideo;
      do
      {
        return;
        if (!(localMessageRecord instanceof MessageForDevShortVideo)) {
          break;
        }
        localMessageForDevShortVideo = (MessageForDevShortVideo)localMessageRecord;
        localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
        localMessageForDevShortVideo.fileSessionId = paramSession.uSessionID;
        localMessageForDevShortVideo.videoFileProgress = ((int)(100.0F * paramFloat));
        localMessageForDevShortVideo.serial();
        ((QQAppInterface)localObject).a().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevShortVideo.msgData);
      } while (!QLog.isColorLevel());
      QLog.d("DeviceShortVideo", 2, "updatemsg msg.uniseq:" + localMessageRecord.uniseq + " ===> filesize:" + localMessageForDevShortVideo.videoFileSize);
      return;
    } while (!(localMessageRecord instanceof MessageForDevLittleVideo));
    paramSession = (MessageForDevLittleVideo)localMessageRecord;
    paramSession.videoFileStatus = 1002;
    paramSession.videoFileProgress = ((int)(100.0F * paramFloat));
    paramSession.serial();
    ((QQAppInterface)localObject).a().a(paramString, paramInt, localMessageRecord.uniseq, paramSession.msgData);
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    MessageRecord localMessageRecord;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      localMessageRecord = ((QQAppInterface)localObject1).a().a(paramString, paramInt, paramLong);
      if (localMessageRecord != null) {
        break label43;
      }
    }
    label43:
    Object localObject2;
    label173:
    do
    {
      do
      {
        return;
        if ((localMessageRecord instanceof MessageForDevShortVideo))
        {
          localObject2 = (MessageForDevShortVideo)localMessageRecord;
          if (!paramSession.bSend) {
            if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(ztk.e))
            {
              Object localObject3 = new zqg();
              ((zqg)localObject3).a = paramSession.strFilePathSrc;
              ((zqg)localObject3).a();
              ((MessageForDevShortVideo)localObject2).md5 = ((zqg)localObject3).jdField_c_of_type_JavaLangString;
              ((MessageForDevShortVideo)localObject2).videoFileTime = ((int)(((zqg)localObject3).jdField_b_of_type_Long / 1000L));
              ((MessageForDevShortVideo)localObject2).thumbWidth = ((zqg)localObject3).jdField_b_of_type_Int;
              ((MessageForDevShortVideo)localObject2).thumbHeight = ((zqg)localObject3).jdField_c_of_type_Int;
              ((MessageForDevShortVideo)localObject2).thumbMD5 = ((zqg)localObject3).e;
              if (!paramBoolean) {
                break label282;
              }
              ((MessageForDevShortVideo)localObject2).videoFileStatus = 2003;
              localObject3 = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
              bdcs.b(paramSession.strFilePathSrc, (String)localObject3);
            }
          }
          for (;;)
          {
            ((MessageForDevShortVideo)localObject2).msg = ((MessageForDevShortVideo)localObject2).getSummary();
            ((MessageForDevShortVideo)localObject2).serial();
            ((QQAppInterface)localObject1).a().a(paramString, paramInt, localMessageRecord.uniseq, ((MessageForDevShortVideo)localObject2).msgData);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("DeviceShortVideo", 2, "updatemsg msg.uniseq:" + localMessageRecord.uniseq + " ===> fileStatus:" + ShortVideoUtils.b(((MessageForDevShortVideo)localObject2).videoFileStatus));
            return;
            ((MessageForDevShortVideo)localObject2).videoFileStatus = 2005;
            break label173;
            ((MessageForDevShortVideo)localObject2).videoFileSize = ((int)paramSession.uFileSizeSrc);
            localMessageRecord.issend = 1;
            if (paramBoolean) {
              ((MessageForDevShortVideo)localObject2).videoFileStatus = 1003;
            } else {
              ((MessageForDevShortVideo)localObject2).videoFileStatus = 1005;
            }
          }
        }
      } while (!(localMessageRecord instanceof MessageForDevLittleVideo));
      localObject2 = (MessageForDevLittleVideo)localMessageRecord;
    } while (!paramSession.bSend);
    label282:
    if (paramBoolean) {
      ((MessageForDevLittleVideo)localObject2).videoFileStatus = 1003;
    }
    for (((MessageForDevLittleVideo)localObject2).videoFileProgress = 100;; ((MessageForDevLittleVideo)localObject2).videoFileProgress = 0)
    {
      ((MessageForDevLittleVideo)localObject2).serial();
      ((QQAppInterface)localObject1).a().a(paramString, paramInt, localMessageRecord.uniseq, localMessageRecord.msgData);
      return;
      ((MessageForDevLittleVideo)localObject2).videoFileStatus = 1005;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zqh
 * JD-Core Version:    0.7.0.1
 */