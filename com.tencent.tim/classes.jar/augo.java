import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.mail.MailPluginManager.1;
import com.tencent.tim.mail.MailPluginManager.3;
import com.tencent.tim.mail.MailPluginManager.4;
import com.tencent.tim.mail.MailPluginManager.5;
import com.tencent.tim.mail.MailPluginRecentMsg;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class augo
  implements Manager
{
  public static String bRl = acbn.SDCARD_PATH + "TempMail" + File.separator;
  private MailPluginRecentMsg a;
  private Boolean aX = Boolean.valueOf(false);
  private Intent au = new Intent();
  BroadcastReceiver bT = new augq(this);
  private boolean diP;
  private int erx = 1;
  private int ery;
  private int erz;
  private arhz m;
  private QQAppInterface mApp;
  private EntityManager mEntityManager;
  private Handler mHandler = new augp(this, Looper.getMainLooper());
  
  public augo(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = new IntentFilter("com.tencent.androidqqmail.tim.mail.broadcast");
    this.mApp.getApp().registerReceiver(this.bT, paramQQAppInterface);
    ThreadManager.executeOnFileThread(new MailPluginManager.1(this));
  }
  
  private String a(MessageForFile paramMessageForFile, List<String> paramList)
  {
    Object localObject = null;
    FileManagerEntity localFileManagerEntity = audx.a(this.mApp, paramMessageForFile);
    paramMessageForFile = localObject;
    if (!TextUtils.isEmpty(localFileManagerEntity.strFilePath))
    {
      File localFile = new File(localFileManagerEntity.strFilePath);
      paramMessageForFile = localObject;
      if (localFile.exists())
      {
        paramMessageForFile = localFile.getName() + " (可在附件中查看)";
        paramList.add(localFileManagerEntity.strFilePath);
      }
    }
    return paramMessageForFile;
  }
  
  private String a(MessageForLongMsg paramMessageForLongMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i;
    Object localObject2;
    synchronized (paramMessageForLongMsg.fragmentListSyncLock)
    {
      int k = paramMessageForLongMsg.longMsgFragmentList.size();
      i = 0;
      if (i >= k) {
        break label304;
      }
      localObject2 = (MessageRecord)paramMessageForLongMsg.longMsgFragmentList.get(i);
      if ((localObject2 instanceof MessageForReplyText)) {
        localStringBuilder.append(((MessageForReplyText)localObject2).msg);
      } else if ((localObject2 instanceof MessageForText)) {
        localStringBuilder.append(((MessageForText)localObject2).msg);
      }
    }
    int n;
    int j;
    if ((localObject2 instanceof MessageForMixedMsg))
    {
      localObject2 = (MessageForMixedMsg)localObject2;
      n = ((MessageForMixedMsg)localObject2).msgElemList.size();
      j = 0;
    }
    for (;;)
    {
      if (j < n)
      {
        Object localObject3 = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(j);
        if ((localObject3 instanceof MessageForReplyText))
        {
          if (TextUtils.isEmpty(((MessageRecord)localObject3).msg)) {
            break label340;
          }
          localStringBuilder.append(((MessageForReplyText)localObject3).msg);
          break label340;
        }
        if ((localObject3 instanceof MessageForText))
        {
          localStringBuilder.append(((MessageForText)localObject3).msg);
          break label340;
        }
        if (!(localObject3 instanceof MessageForPic)) {
          break label340;
        }
        localObject3 = d((MessageForPic)localObject3);
        if (localObject3 == null) {
          break label340;
        }
        localStringBuilder.append(" ").append((String)localObject3);
        break label340;
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = d((MessageForPic)localObject2);
          if (localObject2 != null)
          {
            localStringBuilder.append(" ").append((String)localObject2);
            break label333;
            label304:
            ??? = localStringBuilder.toString();
            paramMessageForLongMsg = (MessageForLongMsg)???;
            if (aofy.Z((String)???)) {
              paramMessageForLongMsg = aofy.M((String)???);
            }
            return paramMessageForLongMsg;
          }
        }
      }
      label333:
      i += 1;
      break;
      label340:
      j += 1;
    }
  }
  
  private String a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int j = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    if (i < j)
    {
      localObject1 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      Object localObject2;
      if ((localObject1 instanceof MessageForReplyText))
      {
        localObject2 = (MessageForReplyText)localObject1;
        if (((MessageForReplyText)localObject2).sb != null)
        {
          localObject1 = ((MessageForReplyText)localObject2).sb.toString();
          label78:
          localStringBuilder.append((String)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = ((MessageRecord)localObject1).msg;
        break label78;
        if ((localObject1 instanceof MessageForText))
        {
          localObject2 = (MessageForText)localObject1;
          if (((MessageForText)localObject2).sb != null) {}
          for (localObject1 = ((MessageForText)localObject2).sb.toString();; localObject1 = ((MessageRecord)localObject1).msg)
          {
            localStringBuilder.append((String)localObject1);
            break;
          }
        }
        if ((localObject1 instanceof MessageForPic))
        {
          localObject1 = d((MessageForPic)localObject1);
          if (localObject1 != null) {
            localStringBuilder.append(" ").append((String)localObject1);
          }
        }
      }
    }
    Object localObject1 = localStringBuilder.toString();
    paramMessageForMixedMsg = (MessageForMixedMsg)localObject1;
    if (aofy.Z((String)localObject1)) {
      paramMessageForMixedMsg = aofy.M((String)localObject1);
    }
    return paramMessageForMixedMsg;
  }
  
  private String a(MessageForReplyText paramMessageForReplyText)
  {
    if (paramMessageForReplyText.sb != null) {}
    for (paramMessageForReplyText = paramMessageForReplyText.sb.toString();; paramMessageForReplyText = paramMessageForReplyText.msg)
    {
      Object localObject = paramMessageForReplyText;
      if (aofy.Z(paramMessageForReplyText)) {
        localObject = aofy.M(paramMessageForReplyText);
      }
      return localObject;
    }
  }
  
  private String a(MessageForShortVideo paramMessageForShortVideo, List<String> paramList)
  {
    String str1 = ShortVideoUtils.e(paramMessageForShortVideo);
    if (str1 == null) {
      QLog.e("MailPluginManager", 1, new Object[] { "getVideoMsgPath null, ", paramMessageForShortVideo.getUserLogString() });
    }
    String str2;
    do
    {
      return null;
      str2 = "视频" + (this.ery + 1) + ".mp4";
      paramMessageForShortVideo = bRl + str2;
    } while (!aqhq.copyFile(str1, paramMessageForShortVideo));
    str1 = str2 + " (可在附件中查看)";
    paramList.add(paramMessageForShortVideo);
    this.ery += 1;
    return str1;
  }
  
  private String a(MessageForTroopFile paramMessageForTroopFile, List<String> paramList)
  {
    Object localObject = null;
    apcy localapcy = apsv.a(this.mApp, paramMessageForTroopFile);
    paramMessageForTroopFile = localObject;
    if (!TextUtils.isEmpty(localapcy.LocalFile))
    {
      File localFile = new File(localapcy.LocalFile);
      paramMessageForTroopFile = localObject;
      if (localFile.exists())
      {
        paramMessageForTroopFile = localFile.getName() + " (可在附件中查看)";
        paramList.add(localapcy.LocalFile);
      }
    }
    return paramMessageForTroopFile;
  }
  
  private void b(MailPluginRecentMsg paramMailPluginRecentMsg, int paramInt)
  {
    this.a = paramMailPluginRecentMsg;
    Object localObject = this.mApp.a().a();
    paramMailPluginRecentMsg = ((acxw)localObject).a(acbn.bnN, 8001);
    paramMailPluginRecentMsg.lastmsgtime = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
    paramMailPluginRecentMsg.msgType = 0;
    paramMailPluginRecentMsg.displayName = this.mApp.getApplication().getString(2131695619);
    ((acxw)localObject).e(paramMailPluginRecentMsg);
    localObject = accy.ay(this.mApp.getApp());
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).startsWith("com.tencent.qqmail")))
    {
      this.mApp.a().G(acbn.bnN, 8001, paramInt);
      this.mApp.b().as(paramMailPluginRecentMsg);
      this.mApp.cLO();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginManager", 2, "updateRencentMsg unReadNum=" + paramInt);
    }
    ThreadManager.executeOnFileThread(new MailPluginManager.4(this));
  }
  
  private String c(MessageForText paramMessageForText)
  {
    if (paramMessageForText.sb != null) {}
    for (paramMessageForText = paramMessageForText.sb.toString();; paramMessageForText = paramMessageForText.msg)
    {
      Object localObject = paramMessageForText;
      if (aofy.Z(paramMessageForText)) {
        localObject = aofy.M(paramMessageForText);
      }
      return localObject;
    }
  }
  
  private String d(MessageForPic paramMessageForPic)
  {
    Object localObject = aoop.a(paramMessageForPic, 131075);
    if (aoiz.getFile(((URL)localObject).toString()) != null) {
      localObject = aoiz.getFilePath(((URL)localObject).toString());
    }
    for (;;)
    {
      if (localObject == null)
      {
        QLog.e("MailPluginManager", 1, new Object[] { "getPicMsgPath null, ", paramMessageForPic.getUserLogString() });
        return null;
        localObject = aoop.a(paramMessageForPic, 1);
        if (aoiz.getFile(((URL)localObject).toString()) != null)
        {
          localObject = aoiz.getFilePath(((URL)localObject).toString());
          continue;
        }
        localObject = aoop.a(paramMessageForPic, 65537);
        if (aoiz.getFile(((URL)localObject).toString()) != null) {
          localObject = aoiz.getFilePath(((URL)localObject).toString());
        }
      }
      else
      {
        return "<img src=\"file://localhost" + (String)localObject + "\" alt=\"[图片]\"/>";
      }
      localObject = null;
    }
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (jof.a(paramChatMessage)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForMarketFace)) || ((paramChatMessage instanceof MessageForReplyText)) || ((paramChatMessage instanceof MessageForLongMsg)) || ((paramChatMessage instanceof MessageForMixedMsg))) {
                return true;
              }
              if (((paramChatMessage instanceof MessageForPic)) && (!acei.W(paramChatMessage))) {
                return true;
              }
              if (!(paramChatMessage instanceof MessageForShortVideo)) {
                break;
              }
              paramQQAppInterface = (MessageForShortVideo)paramChatMessage;
            } while ((paramQQAppInterface.busiType == 2) || (ShortVideoUtils.e(paramQQAppInterface) == null));
            return true;
            if (!(paramChatMessage instanceof MessageForFile)) {
              break;
            }
            paramQQAppInterface = audx.a(paramQQAppInterface, (MessageForFile)paramChatMessage);
          } while ((TextUtils.isEmpty(paramQQAppInterface.strFilePath)) || (!new File(paramQQAppInterface.strFilePath).exists()));
          return true;
          if (!(paramChatMessage instanceof MessageForTroopFile)) {
            break;
          }
          paramQQAppInterface = apsv.a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
        } while ((TextUtils.isEmpty(paramQQAppInterface.LocalFile)) || (!new File(paramQQAppInterface.LocalFile).exists()));
        return true;
      } while ((!(paramChatMessage instanceof MessageForStructing)) || (paramChatMessage.msgtype != -2011));
      paramQQAppInterface = (MessageForStructing)paramChatMessage;
    } while ((paramQQAppInterface.structingMsg == null) || (paramQQAppInterface.structingMsg.mMsgServiceID == 82) || (paramQQAppInterface.structingMsg.fwFlag == 1) || (paramQQAppInterface.structingMsg.hasFlag(1)));
    return true;
  }
  
  private String i(MessageForStructing paramMessageForStructing)
  {
    Object localObject1 = null;
    if (paramMessageForStructing.structingMsg != null)
    {
      if (!(paramMessageForStructing.structingMsg instanceof StructMsgForHypertext)) {
        break label46;
      }
      localObject1 = ((StructMsgForHypertext)paramMessageForStructing.structingMsg).getSpannableString(false).toString();
    }
    for (;;)
    {
      paramMessageForStructing = (MessageForStructing)localObject1;
      if (localObject1 == null) {
        paramMessageForStructing = "[结构化消息]";
      }
      return paramMessageForStructing;
      label46:
      if ("viewMultiMsg".equals(paramMessageForStructing.structingMsg.mMsgAction))
      {
        localObject1 = "[多条转发消息]";
      }
      else
      {
        String str;
        if (paramMessageForStructing.structingMsg.mMsgServiceID == 32)
        {
          str = paramMessageForStructing.getSummaryMsg();
          if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
          {
            Object localObject2 = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
            paramMessageForStructing = ((StructMsgForGeneralShare)localObject2).mContentSummary;
            localObject1 = paramMessageForStructing;
            if (paramMessageForStructing == null)
            {
              localObject1 = paramMessageForStructing;
              if (((StructMsgForGeneralShare)localObject2).mStructMsgItemLists != null)
              {
                localObject2 = ((StructMsgForGeneralShare)localObject2).mStructMsgItemLists.iterator();
                for (;;)
                {
                  localObject1 = paramMessageForStructing;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  Object localObject3 = (anqu)((Iterator)localObject2).next();
                  localObject1 = paramMessageForStructing;
                  if ((localObject3 instanceof antd))
                  {
                    localObject3 = (antd)localObject3;
                    localObject1 = paramMessageForStructing;
                    if (((antd)localObject3).rz != null)
                    {
                      localObject3 = ((antd)localObject3).rz.iterator();
                      for (;;)
                      {
                        localObject1 = paramMessageForStructing;
                        if (!((Iterator)localObject3).hasNext()) {
                          break;
                        }
                        localObject1 = (anqu)((Iterator)localObject3).next();
                        if ((localObject1 instanceof anux)) {
                          paramMessageForStructing = ((anux)localObject1).text;
                        }
                      }
                    }
                  }
                  paramMessageForStructing = (MessageForStructing)localObject1;
                }
              }
            }
            if (localObject1 != null) {
              localObject1 = str + (String)localObject1;
            }
          }
        }
        else
        {
          str = paramMessageForStructing.getSummaryMsg();
          localObject1 = str;
          if (paramMessageForStructing.structingMsg.mMsgUrl == null) {
            continue;
          }
          localObject1 = str + "\n" + paramMessageForStructing.structingMsg.mMsgUrl;
          continue;
        }
        localObject1 = str;
      }
    }
  }
  
  public void B(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return;
    }
    Object localObject1;
    if (paramChatMessage.istroop == 1) {
      localObject1 = aqgv.a(this.mApp, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramChatMessage.senderuin;
      }
      localObject1 = new HashMap();
      ((Map)localObject1).put(paramChatMessage.senderuin, localObject2);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramChatMessage);
      e((Map)localObject1, (ArrayList)localObject2);
      return;
      if (paramChatMessage.istroop == 3000)
      {
        if (aqgv.aa(this.mApp, paramChatMessage.frienduin)) {
          localObject1 = aqgv.a(this.mApp, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
        } else if (paramChatMessage.isSend()) {
          localObject1 = this.mApp.getCurrentNickname();
        } else {
          localObject1 = aqgv.m(this.mApp, paramChatMessage.frienduin, paramChatMessage.senderuin);
        }
      }
      else {
        localObject1 = aqgv.t(this.mApp, paramChatMessage.senderuin);
      }
    }
  }
  
  public MailPluginRecentMsg a()
  {
    return this.a;
  }
  
  public void a(MailPluginRecentMsg paramMailPluginRecentMsg, int paramInt)
  {
    if (paramMailPluginRecentMsg != null)
    {
      if (!BaseActivity.mAppForground)
      {
        String str1 = this.mApp.getApp().getResources().getString(2131695619);
        String str2 = paramMailPluginRecentMsg.getDigest(this.mApp.getApp().getResources());
        String str3 = str1 + "：" + str2;
        Bitmap localBitmap = aqcu.decodeResource(this.mApp.getApp().getResources(), 2130841031);
        Intent localIntent = new Intent(this.mApp.getApp(), SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.bIk);
        localIntent.putExtra("fragment_id", 1);
        localIntent.setFlags(335544320);
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.mApp.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
        localToServiceMsg.extraData.putStringArray("cmds", new String[] { str3, str1, str2 });
        localToServiceMsg.extraData.putParcelable("intent", localIntent);
        localToServiceMsg.extraData.putParcelable("bitmap", localBitmap);
        this.mApp.sendToService(localToServiceMsg);
      }
      this.mApp.cLD();
      b(paramMailPluginRecentMsg, paramInt);
    }
  }
  
  public void e(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return;
    }
    ThreadManager.post(new MailPluginManager.5(this, paramArrayList, paramMap), 5, null, true);
  }
  
  public void euR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginManager", 2, "preloadMailPlugin");
    }
    this.diP = false;
    augt.a().a(this.mApp, "cmd_preload", null);
    this.mHandler.sendEmptyMessageDelayed(112, 30000L);
  }
  
  public void euS()
  {
    ThreadManager.getFileThreadHandler().postDelayed(new MailPluginManager.3(this), 5000L);
  }
  
  public void g(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("enterMailPlugin, mHasLoadPlugin = ").append(this.diP).append(", activity.isFinishing() = ");
      if (paramActivity == null)
      {
        localObject = "null";
        QLog.d("MailPluginManager", 2, localObject + ", enterType = " + paramInt);
      }
    }
    else
    {
      if ((paramActivity != null) && (!paramActivity.isFinishing())) {
        break label94;
      }
    }
    label256:
    for (;;)
    {
      return;
      localObject = Boolean.valueOf(paramActivity.isFinishing());
      break;
      label94:
      if (this.diP) {
        if (paramInt == 2)
        {
          localObject = "com.tencent.androidqqmail.tim.RouteActivity";
          paramIntent.setClassName(paramActivity, (String)localObject);
          paramActivity.startActivity(paramIntent);
        }
      }
      for (;;)
      {
        if (paramInt != 1) {
          break label256;
        }
        this.mApp.b().a(acbn.bnN, 8001, false, true);
        return;
        localObject = "com.tencent.androidqqmail.tim.MainActivity";
        break;
        this.erx = paramInt;
        this.au = paramIntent;
        this.m = new arhz(paramActivity, this.mApp.getApplication().getResources().getDimensionPixelSize(2131299627));
        this.m.setMessage(this.mApp.getApplication().getString(2131695620));
        this.m.show();
        if (this.mHandler.hasMessages(113)) {
          this.mHandler.removeMessages(113);
        }
        this.mHandler.sendEmptyMessageDelayed(113, 30000L);
      }
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.mApp.getApp().unregisterReceiver(this.bT);
      if ((this.mEntityManager != null) && (this.mEntityManager.isOpen())) {
        this.mEntityManager.close();
      }
      if (this.mHandler != null) {
        this.mHandler.removeCallbacksAndMessages(null);
      }
      if ((this.m != null) && (this.m.isShowing())) {
        this.m.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augo
 * JD-Core Version:    0.7.0.1
 */