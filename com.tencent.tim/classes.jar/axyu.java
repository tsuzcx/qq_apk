import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.editipc.PeakIpcModuleServer.1;
import dov.com.qq.im.editipc.PeakIpcModuleServer.2;
import dov.com.qq.im.editipc.PeakIpcModuleServer.3;
import eipc.EIPCResult;

public class axyu
  extends QIPCModule
{
  private static axyu a;
  
  private axyu(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public static axyu a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	axyu:a	Laxyu;
    //   6: ifnonnull +27 -> 33
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 14	axyu:a	Laxyu;
    //   15: ifnonnull +15 -> 30
    //   18: new 2	axyu
    //   21: dup
    //   22: ldc 16
    //   24: invokespecial 17	axyu:<init>	(Ljava/lang/String;)V
    //   27: putstatic 14	axyu:a	Laxyu;
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 14	axyu:a	Laxyu;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	5	0	localaxyu	axyu
    //   42	5	0	localObject1	Object
    //   48	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	30	42	finally
    //   30	33	42	finally
    //   43	46	42	finally
    //   3	12	48	finally
    //   33	37	48	finally
    //   46	48	48	finally
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleServer", 2, "[onCall]action= " + paramString);
    }
    Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakIpcModuleServer", 2, "[onCall] get app failed.");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    Object localObject2;
    boolean bool1;
    if ("action_start_send".equals(paramString))
    {
      paramBundle = (Intent)paramBundle.getParcelable("key_intent");
      if (paramBundle != null)
      {
        paramString = (QQAppInterface)localObject1;
        localObject1 = paramBundle.getStringExtra("thumbfile_send_path");
        localObject2 = paramBundle.getStringExtra("thumbfile_md5");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          ThreadManager.post(new PeakIpcModuleServer.1(this, (String)localObject2, (String)localObject1), 5, null, false);
        }
        localObject1 = anfr.a(3, 0);
        localObject2 = anfr.a(0, paramBundle, (angi)localObject1);
        ((anfw)localObject2).cFp = true;
        ((angi)localObject1).b((anfw)localObject2);
        anfr.a((angi)localObject1, paramString);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("sendVideo intent= ");
        if (paramBundle != null)
        {
          paramString = paramBundle.getExtras();
          QLog.d("PeakIpcModuleServer", 2, paramString);
        }
      }
      else
      {
        if (paramBundle == null) {
          break label266;
        }
      }
      label266:
      for (bool1 = true;; bool1 = false)
      {
        localBundle.putBoolean("key_result", bool1);
        paramString = EIPCResult.createSuccessResult(localBundle);
        callbackResult(paramInt, paramString);
        return null;
        paramString = "";
        break;
      }
    }
    int i;
    long l2;
    long l1;
    if ("action_cancel_send".equals(paramString))
    {
      localObject2 = paramBundle.getString("uin");
      i = paramBundle.getInt("uintype");
      l2 = paramBundle.getLong("key_uinsequence");
      paramBundle = (QQAppInterface)localObject1;
      localObject1 = paramBundle.b().a((String)localObject2, i, l2);
      paramString = paramBundle.a().a((String)localObject2, l2);
      if (localObject1 != null)
      {
        l1 = ((MessageRecord)localObject1).uniseq;
        label350:
        if ((!(paramString instanceof aonn)) || (((aonn)paramString).cNq)) {
          break label570;
        }
        ((aonn)paramString).pause();
        bool1 = true;
        paramString = "forwardVideo";
      }
    }
    for (;;)
    {
      label380:
      boolean bool3;
      if (bool1)
      {
        bool3 = paramBundle.a().oy((String)localObject2 + l2);
        ambj.k(paramBundle, (String)localObject2, l2);
        bool2 = bool3;
        if (localObject1 != null) {
          ThreadManager.post(new PeakIpcModuleServer.2(this, paramBundle, (MessageRecord)localObject1), 8, null, true);
        }
      }
      for (boolean bool2 = bool3;; bool2 = false)
      {
        for (;;)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PeakIpcModuleServer", 2, "cancelInfo, uinseq:" + (String)localObject2 + ", uinType:" + i + ", sequence:" + l2 + ", msgSequence" + l1 + ", cancel:" + bool1 + ", removeProcess:" + bool2 + ", tips:" + paramString);
            }
            localBundle.putBoolean("key_result", bool1);
            paramString = EIPCResult.createSuccessResult(localBundle);
            break;
            l1 = -1L;
            break label350;
            label570:
            if (((paramString instanceof aojv)) && (!((aojv)paramString).cMm))
            {
              ((aojv)paramString).pause();
              bool1 = true;
              paramString = "C2CPic";
              break label380;
            }
            if ((!(paramString instanceof aokv)) || (((aokv)paramString).cMm)) {
              break label1833;
            }
            ((aokv)paramString).pause();
            bool1 = true;
            paramString = "GroupPic";
            break label380;
            Object localObject3;
            if ("action_pic_start_send".equals(paramString))
            {
              paramBundle.setClassLoader(getClass().getClassLoader());
              paramString = paramBundle.getString("key_file_path");
              localObject2 = (SessionInfo)paramBundle.getParcelable("key_session");
              localObject3 = paramBundle.getString("widgetinfo", "");
              paramBundle = paramBundle.getString("key_camera_material_name", "");
              if (!TextUtils.isEmpty(paramString))
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("key_story_photo_to_recent", true);
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localIntent.putExtra("widgetinfo", (String)localObject3);
                  localIntent.putExtra("key_camera_material_name", paramBundle);
                }
                ForwardUtils.a(localIntent, (SessionInfo)localObject2, paramString, (QQAppInterface)localObject1);
                localBundle.putBoolean("key_result", true);
              }
              for (bool1 = true;; bool1 = false)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PeakIpcModuleServer", 2, "sendPic success:" + bool1 + ", photoPath：" + paramString);
                }
                paramString = EIPCResult.createSuccessResult(localBundle);
                break;
                localBundle.putBoolean("key_result", false);
              }
            }
            if ("action_re_send".equals(paramString))
            {
              localObject2 = paramBundle.getString("uin");
              i = paramBundle.getInt("uintype");
              l1 = paramBundle.getLong("key_uinsequence");
              paramString = (QQAppInterface)localObject1;
              paramBundle = paramString.b().a((String)localObject2, i, l1);
              bool2 = false;
              if ((paramBundle instanceof MessageForShortVideo))
              {
                localObject1 = (MessageForShortVideo)paramBundle;
                if ((aqhq.fileExistsAndNotEmpty(ShortVideoUtils.bw(((MessageForShortVideo)localObject1).thumbMD5, "jpg"))) && (!TextUtils.isEmpty(((MessageForShortVideo)localObject1).videoFileName)) && (((MessageForShortVideo)localObject1).isStoryVideo))
                {
                  ((ambj)paramString.getManager(326)).a(((MessageForShortVideo)localObject1).frienduin, (MessageRecord)localObject1, ((MessageForShortVideo)localObject1).videoFileName);
                  localObject1 = anfr.a(4, 0);
                  localObject2 = anfr.a(0, paramBundle, (angi)localObject1);
                  ((anfw)localObject2).cFp = true;
                  ((angi)localObject1).b((anfw)localObject2);
                  anfr.a((angi)localObject1, paramString);
                  bool1 = true;
                  label1015:
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder().append("reSend success:").append(bool1).append(", message：");
                    if (paramBundle == null) {
                      break label1446;
                    }
                  }
                }
              }
              label1446:
              for (paramString = paramBundle.toString();; paramString = "")
              {
                QLog.d("PeakIpcModuleServer", 2, paramString);
                localBundle.putBoolean("key_result", bool1);
                paramString = EIPCResult.createSuccessResult(localBundle);
                break;
                ((MessageForShortVideo)localObject1).videoFileStatus = 1005;
                bool1 = false;
                break label1015;
                bool1 = bool2;
                if (!(paramBundle instanceof MessageForPic)) {
                  break label1015;
                }
                localObject1 = (MessageForPic)paramBundle;
                bool1 = bool2;
                if (!aqhq.fileExistsAndNotEmpty(((MessageForPic)localObject1).path)) {
                  break label1015;
                }
                bool1 = bool2;
                if (!((MessageForPic)localObject1).isStoryPhoto) {
                  break label1015;
                }
                ThreadManager.post(new PeakIpcModuleServer.3(this, paramString, (MessageForPic)localObject1), 5, null, false);
                if (((MessageForPic)localObject1).isSendFromLocal()) {
                  paramString.a().oy(paramString.a().y(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).uniseq));
                }
                localObject2 = new akxy.a();
                ((akxy.a)localObject2).setLocalPath(((MessageForPic)localObject1).path);
                ((akxy.a)localObject2).So(5);
                ((akxy.a)localObject2).NP(((MessageForPic)localObject1).frienduin);
                if (((MessageForPic)localObject1).fileSizeFlag == 1) {
                  ((akxy.a)localObject2).setProtocolType(aooh.a.dQD);
                }
                for (;;)
                {
                  ((akxy.a)localObject2).NT(((MessageForPic)localObject1).senderuin);
                  ((akxy.a)localObject2).kc(((MessageForPic)localObject1).selfuin);
                  ((akxy.a)localObject2).Sp(((MessageForPic)localObject1).istroop);
                  ((akxy.a)localObject2).St(((MessageForPic)localObject1).getConfessTopicId());
                  ((akxy.a)localObject2).extLong = ((MessageForPic)localObject1).extLong;
                  ((akxy.a)localObject2).extStr = ((MessageForPic)localObject1).extStr;
                  ((akxy.a)localObject2).Nw(true);
                  localObject3 = new akxy.b();
                  ((akxy.b)localObject3).msgseq = ((MessageForPic)localObject1).msgseq;
                  ((akxy.b)localObject3).shmsgseq = ((MessageForPic)localObject1).shmsgseq;
                  ((akxy.b)localObject3).msgUid = ((MessageForPic)localObject1).msgUid;
                  ((akxy.a)localObject2).a((akxy.b)localObject3);
                  ((akxy.a)localObject2).kx(((MessageForPic)localObject1).uniseq);
                  ((ambj)paramString.getManager(326)).aG(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).uniseq);
                  localObject3 = akxj.a(4, 5);
                  ((akxq)localObject3).c(((akxy.a)localObject2).a());
                  ((akxq)localObject3).b = ((MessageForPic)localObject1).picExtraData;
                  akxj.a((akxq)localObject3, paramString);
                  bool1 = true;
                  break;
                  ((akxy.a)localObject2).setProtocolType(aooh.a.dQC);
                }
              }
            }
            if ("action_get_troop_member_name".equals(paramString))
            {
              paramString = paramBundle.getString("troop_uin");
              paramBundle = paramBundle.getString("uin");
              try
              {
                localObject1 = (TroopManager)((QQAppInterface)localObject1).getManager(52);
                paramString = ((TroopManager)localObject1).getTroopMemberName(((TroopManager)localObject1).jp(paramString), paramBundle);
                localBundle.putBoolean("key_result", true);
                localBundle.putString("uinname", paramString);
                paramString = EIPCResult.createSuccessResult(localBundle);
              }
              catch (Exception paramString)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PeakIpcModuleServer", 2, "getTroopMemberName exception = " + paramString.getMessage());
                  }
                  paramString.printStackTrace();
                  paramString = "";
                }
              }
            }
          }
          if ("action_get_troop_info".equals(paramString))
          {
            paramString = paramBundle.getString("troop_uin");
            try
            {
              paramBundle = (TroopManager)((QQAppInterface)localObject1).getManager(52);
              paramString = paramBundle.a(paramBundle.jp(paramString), true);
              if (paramString != null)
              {
                localBundle.putBoolean("key_result", true);
                localBundle.putBoolean("troop_owner", paramString.isDisband());
                if ((paramString.isNewTroop()) && (!paramString.hasSetTroopHead())) {}
                for (bool1 = true;; bool1 = false)
                {
                  localBundle.putBoolean("troop_code", bool1);
                  paramString = EIPCResult.createSuccessResult(localBundle);
                  return paramString;
                }
              }
            }
            catch (Exception paramString)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PeakIpcModuleServer", 2, "ACTION_GET_TROOP_INFO exception = " + paramString.getMessage());
              }
              paramString.printStackTrace();
              paramString = null;
            }
          }
        }
        if ("action_get_name".equals(paramString))
        {
          paramString = paramBundle.getString("uin");
          try
          {
            paramString = aqgv.t((QQAppInterface)localObject1, paramString);
            localBundle.putBoolean("key_result", true);
            localBundle.putString("uinname", paramString);
            paramString = EIPCResult.createSuccessResult(localBundle);
            return paramString;
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PeakIpcModuleServer", 2, "ACTION_GET_NAME exception = " + paramString.getMessage());
            }
            paramString.printStackTrace();
          }
        }
        paramString = null;
        break;
      }
      label1833:
      paramString = "";
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyu
 * JD-Core Version:    0.7.0.1
 */