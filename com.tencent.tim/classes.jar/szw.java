import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DeviceCommonMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor.1;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.a;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class szw
  extends szg
{
  private final QQAppInterface app;
  private ConcurrentHashMap<Long, szg.b> cD = new ConcurrentHashMap(20);
  private ArrayList<szg.a> mCallbacks = new ArrayList();
  
  public szw(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    int i = 0;
    if (i < this.mCallbacks.size())
    {
      Object localObject = (szg.a)this.mCallbacks.get(i);
      View localView = ((szg.a)localObject).getView();
      localObject = ((szg.a)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((MessageForDeviceFile.a)localObject).a(localView, paramMessageForDeviceFile);
      }
      for (;;)
      {
        i += 1;
        break;
        this.mCallbacks.remove(i);
        i -= 1;
      }
    }
  }
  
  private void fl(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    this.app.b().s(paramList, this.app.getCurrentAccountUin());
    if (QLog.isDevelopLevel()) {
      QLog.d("DeviceComnFileMsgProcessor", 4, "cost:" + (System.currentTimeMillis() - l));
    }
  }
  
  public MessageForDeviceFile a(Long paramLong)
  {
    paramLong = (szg.b)this.cD.get(paramLong);
    if (paramLong == null) {
      return null;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramLong = ((QQAppInterface)localAppRuntime).b().a(paramLong.mPeerUin, paramLong.mUinType, paramLong.mUniseq);
      if (paramLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceComnFileMsgProcessor", 2, "device file msg null");
        }
        return null;
      }
      if ((paramLong instanceof MessageForDeviceFile)) {
        return (MessageForDeviceFile)paramLong;
      }
    }
    return null;
  }
  
  public MessageForDeviceFile a(String paramString, MessageForDeviceFile paramMessageForDeviceFile)
  {
    this.app.b().t(paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
    ArrayList localArrayList = new ArrayList();
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)anbi.e(paramMessageForDeviceFile);
    if ("device_groupchat".equals(paramMessageForDeviceFile.extStr))
    {
      localMessageForDeviceFile.strServiceName = paramString;
      localMessageForDeviceFile.filePath = localMessageForDeviceFile.filePath;
      localMessageForDeviceFile.srcFileName = ahav.getFileName(localMessageForDeviceFile.filePath);
      localMessageForDeviceFile.fileSize = ahav.getFileSizes(localMessageForDeviceFile.filePath);
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.progress = 0.0F;
      ((acle)this.app.getBusinessHandler(13)).W(localMessageForDeviceFile);
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      paramString = aqhu.c(BaseApplication.getContext(), Uri.parse(localMessageForDeviceFile.filePath));
      aqhu.b(BaseApplication.getContext(), localMessageForDeviceFile.filePath, paramString, 160, 160);
      xya.b(((syw)this.app.getBusinessHandler(51)).b(Long.parseLong(localMessageForDeviceFile.frienduin), localMessageForDeviceFile.filePath, paramString), localMessageForDeviceFile);
      localArrayList.add(localMessageForDeviceFile);
      fl(localArrayList);
      label236:
      return localMessageForDeviceFile;
    }
    this.cD.remove(Long.valueOf(paramMessageForDeviceFile.uSessionID));
    String str1 = paramMessageForDeviceFile.filePath;
    String str2 = paramMessageForDeviceFile.frienduin;
    localMessageForDeviceFile.strServiceName = paramString;
    localMessageForDeviceFile.filePath = str1;
    localMessageForDeviceFile.srcFileName = paramMessageForDeviceFile.srcFileName;
    localMessageForDeviceFile.msgStatus = 2;
    localMessageForDeviceFile.nFileStatus = 1;
    localMessageForDeviceFile.progress = 0.0F;
    localMessageForDeviceFile.nFileMsgType = paramMessageForDeviceFile.nFileMsgType;
    localMessageForDeviceFile.msg = this.app.getApp().getString(2131692597);
    if (paramString.compareTo(szy.aIl) == 0)
    {
      localMessageForDeviceFile.msg = this.app.getApp().getString(2131692598);
      label361:
      ((acle)this.app.getBusinessHandler(13)).W(localMessageForDeviceFile);
      paramMessageForDeviceFile = (syw)this.app.getBusinessHandler(51);
      if ((paramMessageForDeviceFile == null) || (!paramMessageForDeviceFile.gs(str2))) {
        break label617;
      }
      if (paramString.compareTo(szy.aIl) != 0) {
        break label545;
      }
      localMessageForDeviceFile.uSessionID = paramMessageForDeviceFile.b(Long.parseLong(str2), str1, null);
    }
    for (;;)
    {
      localMessageForDeviceFile.fileSize = ahav.getFileSizes(str1);
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      c(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      break;
      if (paramString.compareTo(szy.aIk) != 0) {
        break label361;
      }
      localMessageForDeviceFile.msg = this.app.getApp().getString(2131692596);
      localMessageForDeviceFile.copies = paramMessageForDeviceFile.copies;
      localMessageForDeviceFile.duplexMode = paramMessageForDeviceFile.duplexMode;
      break label361;
      label545:
      if (paramString.compareTo(szy.aIn) == 0)
      {
        localMessageForDeviceFile.uSessionID = paramMessageForDeviceFile.a(Long.parseLong(str2), str1, 0);
      }
      else
      {
        paramString = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a(str1, paramString, null, Long.parseLong(str2));
        if (paramString == null) {
          break label236;
        }
        localMessageForDeviceFile.uSessionID = paramString.uSessionID;
        continue;
        label617:
        paramString = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a(str1, paramString, null, Long.parseLong(str2));
        if (paramString == null) {
          break label236;
        }
        localMessageForDeviceFile.uSessionID = paramString.uSessionID;
      }
    }
  }
  
  public void a(View paramView, MessageForDeviceFile.a parama)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      szg.a locala = (szg.a)localIterator.next();
      if (locala.getView() == paramView)
      {
        locala.callback = new WeakReference(parama);
        return;
      }
    }
    this.mCallbacks.add(new szg.a(this, paramView, parama));
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    paramSession = a(Long.valueOf(paramSession.uSessionID));
    if (paramSession == null) {
      return;
    }
    paramSession.nFileStatus = 3;
    paramSession.progress = paramFloat;
    a(paramSession);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (paramSession == null) {}
    Object localObject1;
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      if (!paramSession.bSend) {
        DeviceCommonMsgProcessor.c(paramSession, paramBoolean);
      }
      localObject1 = (syw)this.app.getBusinessHandler(51);
      localMessageForDeviceFile = a(Long.valueOf(paramSession.uSessionID));
    } while (localMessageForDeviceFile == null);
    Object localObject2 = ((syw)localObject1).a(Long.parseLong(localMessageForDeviceFile.frienduin));
    int i = 0;
    long l = 0L;
    if (localObject2 != null)
    {
      i = ((DeviceInfo)localObject2).productId;
      l = ((DeviceInfo)localObject2).din;
    }
    if (paramSession.actionInfo.strServiceName.compareTo(szy.aIl) == 0)
    {
      localObject2 = this.app;
      if (!paramBoolean) {
        break label661;
      }
    }
    label661:
    for (int j = 0;; j = 1)
    {
      tar.a((AppRuntime)localObject2, l, "Net_SendMsg_Pic", 0, j, i);
      if ((paramSession.actionInfo.strServiceName.compareTo(szy.aIk) == 0) && (paramSession.bSend) && (paramBoolean))
      {
        String str = new String(paramSession.vFileMD5Src);
        localObject2 = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a(paramSession);
        Bundle localBundle = new Bundle();
        localBundle.putInt("copies", localMessageForDeviceFile.copies);
        localBundle.putInt("duplexMode", localMessageForDeviceFile.duplexMode);
        localBundle.putInt("mediaSize", localMessageForDeviceFile.mediaSize);
        localBundle.putInt("mediaType", localMessageForDeviceFile.mediaType);
        localBundle.putInt("scaling", localMessageForDeviceFile.scaling);
        localBundle.putInt("orientation", localMessageForDeviceFile.orientation);
        localBundle.putInt("color", localMessageForDeviceFile.color);
        localBundle.putInt("quality", localMessageForDeviceFile.quality);
        ((syw)localObject1).a(Long.parseLong(localMessageForDeviceFile.frienduin), str, String.valueOf(((Session)localObject2).uSessionID), paramSession.strFileNameSrc, paramSession.emFileType, localBundle);
        localObject1 = (MessageForDeviceFile)anbi.d(-4500);
        ((MessageForDeviceFile)localObject1).strServiceName = szy.aIk;
        ((MessageForDeviceFile)localObject1).msgtype = -4500;
        ((MessageForDeviceFile)localObject1).istroop = 9501;
        ((MessageForDeviceFile)localObject1).filePath = paramSession.strFilePathSrc;
        ((MessageForDeviceFile)localObject1).srcFileName = paramSession.strFileNameSrc;
        ((MessageForDeviceFile)localObject1).fileSize = paramSession.uFileSizeSrc;
        ((MessageForDeviceFile)localObject1).issend = 0;
        ((MessageForDeviceFile)localObject1).isread = true;
        ((MessageForDeviceFile)localObject1).selfuin = this.app.getCurrentAccountUin();
        ((MessageForDeviceFile)localObject1).senderuin = localMessageForDeviceFile.frienduin;
        ((MessageForDeviceFile)localObject1).frienduin = localMessageForDeviceFile.frienduin;
        ((MessageForDeviceFile)localObject1).msgStatus = 2;
        ((MessageForDeviceFile)localObject1).nFileStatus = 1;
        ((MessageForDeviceFile)localObject1).time = anaz.gQ();
        ((MessageForDeviceFile)localObject1).progress = 0.0F;
        ((MessageForDeviceFile)localObject1).uSessionID = ((Session)localObject2).uSessionID;
        ((MessageForDeviceFile)localObject1).msg = this.app.getApp().getString(2131692596);
        ((MessageForDeviceFile)localObject1).nFileMsgType = 1;
        ((MessageForDeviceFile)localObject1).copies = localMessageForDeviceFile.copies;
        ((MessageForDeviceFile)localObject1).duplexMode = localMessageForDeviceFile.duplexMode;
        ((MessageForDeviceFile)localObject1).mediaSize = localMessageForDeviceFile.mediaSize;
        ((MessageForDeviceFile)localObject1).scaling = localMessageForDeviceFile.scaling;
        ((MessageForDeviceFile)localObject1).color = localMessageForDeviceFile.color;
        ((MessageForDeviceFile)localObject1).quality = localMessageForDeviceFile.quality;
        ((MessageForDeviceFile)localObject1).uint32_src_uin_type = 1;
        ((MessageForDeviceFile)localObject1).serial();
        c(((MessageForDeviceFile)localObject1).uSessionID, ((MessageForDeviceFile)localObject1).frienduin, ((MessageForDeviceFile)localObject1).istroop, ((MessageForDeviceFile)localObject1).uniseq);
        this.app.b().b((MessageRecord)localObject1, this.app.getCurrentAccountUin());
        this.app.q(1, false, true);
        ThreadManager.getUIHandler().postDelayed(new DeviceComnFileMsgProcessor.1(this, (MessageForDeviceFile)localObject1), 900000L);
      }
      g(paramSession.actionInfo.strServiceName, paramSession.uSessionID, paramBoolean);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, float paramFloat)
  {
    if (paramMessageRecord == null) {}
    while (!(paramMessageRecord instanceof MessageForDeviceFile)) {
      return;
    }
    paramMessageRecord = (MessageForDeviceFile)paramMessageRecord;
    paramMessageRecord.nFileStatus = 3;
    paramMessageRecord.progress = paramFloat;
    a(paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, Boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      break label4;
    }
    label4:
    while (!(paramMessageRecord instanceof MessageForDeviceFile)) {
      return;
    }
    paramMessageRecord = (MessageForDeviceFile)paramMessageRecord;
    paramMessageRecord.progress = 1.0F;
    if (paramBoolean.booleanValue()) {
      paramMessageRecord.nFileStatus = 5;
    }
    for (paramMessageRecord.msgStatus = 0;; paramMessageRecord.msgStatus = 1)
    {
      paramMessageRecord.serial();
      this.app.b().c(paramMessageRecord.frienduin, 9501, paramMessageRecord.uniseq, paramMessageRecord.msgData);
      a(paramMessageRecord);
      paramMessageRecord = this.app.getHandler(Conversation.class);
      if (paramMessageRecord == null) {
        break;
      }
      paramMessageRecord.sendEmptyMessage(1009);
      return;
      paramMessageRecord.nFileStatus = 6;
    }
  }
  
  public void a(String paramString, AbsStructMsg paramAbsStructMsg)
  {
    MessageForStructing localMessageForStructing = anbi.a(this.app, this.app.getCurrentAccountUin(), paramString, this.app.getCurrentAccountUin(), 9501, 100L, paramAbsStructMsg);
    this.app.b().b(localMessageForStructing, this.app.getCurrentAccountUin());
    ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(paramString), paramAbsStructMsg);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject1 = (String)paramList.next();
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)anbi.d(-4500);
      localMessageForDeviceFile.strServiceName = paramString1;
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = ((String)localObject1);
      localMessageForDeviceFile.srcFileName = ahav.getFileName((String)localObject1);
      localMessageForDeviceFile.fileSize = ahav.getFileSizes((String)localObject1);
      localMessageForDeviceFile.issend = 1;
      localMessageForDeviceFile.isread = true;
      localMessageForDeviceFile.selfuin = this.app.getCurrentAccountUin();
      localMessageForDeviceFile.senderuin = this.app.getCurrentAccountUin();
      localMessageForDeviceFile.frienduin = paramString2;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.time = anaz.gQ();
      localMessageForDeviceFile.progress = 0.0F;
      localMessageForDeviceFile.msg = this.app.getApp().getString(2131692597);
      localMessageForDeviceFile.nFileMsgType = 1;
      if (paramString1.compareTo(szy.aIl) == 0)
      {
        localMessageForDeviceFile.nFileMsgType = 2;
        localMessageForDeviceFile.msg = this.app.getApp().getString(2131692598);
      }
      int i;
      if (paramString1.compareTo(szy.aIk) == 0)
      {
        int i3 = 1;
        int i2 = 1;
        int i1 = 1;
        int n = 1;
        int m = 1;
        int k = 1;
        int j = 1;
        i = 1;
        if (paramBundle != null)
        {
          i3 = paramBundle.getInt("copies", 1);
          i2 = paramBundle.getInt("duplexMode", 1);
          i1 = paramBundle.getInt("mediaSize", 1);
          n = paramBundle.getInt("mediaType", 1);
          m = paramBundle.getInt("scaling", 1);
          k = paramBundle.getInt("orientation", 1);
          j = paramBundle.getInt("color", 1);
          i = paramBundle.getInt("quality", 1);
        }
        localMessageForDeviceFile.msg = this.app.getApp().getString(2131692596);
        localMessageForDeviceFile.copies = i3;
        localMessageForDeviceFile.duplexMode = i2;
        localMessageForDeviceFile.mediaSize = i1;
        localMessageForDeviceFile.mediaType = n;
        localMessageForDeviceFile.scaling = m;
        localMessageForDeviceFile.orientation = k;
        localMessageForDeviceFile.color = j;
        localMessageForDeviceFile.quality = i;
      }
      ((acle)this.app.getBusinessHandler(13)).W(localMessageForDeviceFile);
      Object localObject2 = (syw)this.app.getBusinessHandler(51);
      if ((localObject2 != null) && (((syw)localObject2).gs(paramString2))) {
        if (paramString1.compareTo(szy.aIl) == 0)
        {
          String str = aqhu.c(BaseApplication.getContext(), Uri.parse((String)localObject1));
          aqhu.b(BaseApplication.getContext(), (String)localObject1, str, 160, 160);
          localMessageForDeviceFile.uSessionID = ((syw)localObject2).b(Long.parseLong(paramString2), (String)localObject1, str);
        }
      }
      for (;;)
      {
        label526:
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          localMessageForDeviceFile.nFileStatus = 6;
          localMessageForDeviceFile.msgStatus = 1;
        }
        localMessageForDeviceFile.serial();
        c(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
        localArrayList.add(localMessageForDeviceFile);
        break;
        if (paramString1.compareTo(szy.aIn) == 0)
        {
          localMessageForDeviceFile.uSessionID = ((syw)localObject2).a(Long.parseLong(paramString2), (String)localObject1, 0);
        }
        else
        {
          if (paramString1.compareTo(szy.aIk) == 0)
          {
            localObject2 = ((syw)localObject2).a(Long.parseLong(paramString2));
            i = 0;
            if (localObject2 != null) {
              i = ((DeviceInfo)localObject2).productId;
            }
            if (ahav.getFileType((String)localObject1) != 0) {
              break label722;
            }
            tar.a(this.app, "Usr_CloudPrint_SendFile", 1, 0, i);
          }
          for (;;)
          {
            localObject1 = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a((String)localObject1, paramString1, null, Long.parseLong(paramString2));
            if (localObject1 == null) {
              break;
            }
            localMessageForDeviceFile.uSessionID = ((Session)localObject1).uSessionID;
            break label526;
            label722:
            tar.a(this.app, "Usr_CloudPrint_SendFile", 2, 0, i);
          }
          localObject1 = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a((String)localObject1, paramString1, null, Long.parseLong(paramString2));
          if (localObject1 == null) {
            break;
          }
          localMessageForDeviceFile.uSessionID = ((Session)localObject1).uSessionID;
        }
      }
    }
    fl(localArrayList);
  }
  
  public boolean a(String paramString1, String paramString2, List<String> paramList)
  {
    a(paramString1, paramString2, paramList, null);
    return true;
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localArrayList.add(paramMessageForDeviceFile);
    } while (((DeviceFileHandler)this.app.getBusinessHandler(50)).af(localArrayList));
    ahao.OS(2131695433);
  }
  
  public boolean b(String paramString, List<FileInfo> paramList)
  {
    syw localsyw = (syw)this.app.getBusinessHandler(51);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        MessageForDeviceFile localMessageForDeviceFile;
        int j;
        localException.printStackTrace();
        continue;
        if (i != 0)
        {
          if (j == 2) {
            localMessageForDeviceFile.strServiceName = "8001-NASDevVideoFile";
          } else if (j == 1) {
            localMessageForDeviceFile.strServiceName = "8000-NASDevMusicFile";
          } else if (j == 3) {
            localMessageForDeviceFile.strServiceName = "8002-NASDevDocumentFile";
          } else {
            localMessageForDeviceFile.strServiceName = "8003-NASDevCommonFile";
          }
        }
        else
        {
          localMessageForDeviceFile.strServiceName = szy.aIj;
          continue;
          label512:
          if (localMessageForDeviceFile.strServiceName.compareTo(szy.aIn) == 0)
          {
            localMessageForDeviceFile.uSessionID = localsyw.a(Long.parseLong(paramString), ((FileInfo)localObject).getPath(), 0);
          }
          else
          {
            localObject = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a(((FileInfo)localObject).getPath(), localMessageForDeviceFile.strServiceName, null, Long.parseLong(paramString));
            if (localObject != null)
            {
              localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
              continue;
              label600:
              localObject = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a(((FileInfo)localObject).getPath(), localMessageForDeviceFile.strServiceName, null, Long.parseLong(paramString));
              if (localObject != null) {
                localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
              }
            }
          }
        }
      }
      label650:
      fl(localException);
      return true;
    }
    if ((localsyw != null) && (localsyw.i(l1, 9))) {}
    for (int i = 1;; i = 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label650;
        }
        localObject = (FileInfo)paramList.next();
        localMessageForDeviceFile = (MessageForDeviceFile)anbi.d(-4500);
        j = ((FileInfo)localObject).getType();
        if (j != 0) {
          break;
        }
        localMessageForDeviceFile.strServiceName = szy.aIl;
        localMessageForDeviceFile.msgtype = -4500;
        localMessageForDeviceFile.istroop = 9501;
        localMessageForDeviceFile.filePath = ((FileInfo)localObject).getPath();
        localMessageForDeviceFile.srcFileName = ahav.getFileName(((FileInfo)localObject).getPath());
        localMessageForDeviceFile.fileSize = ahav.getFileSizes(((FileInfo)localObject).getPath());
        localMessageForDeviceFile.issend = 1;
        localMessageForDeviceFile.isread = true;
        localMessageForDeviceFile.selfuin = this.app.getCurrentAccountUin();
        localMessageForDeviceFile.senderuin = this.app.getCurrentAccountUin();
        localMessageForDeviceFile.frienduin = paramString;
        localMessageForDeviceFile.msgStatus = 2;
        localMessageForDeviceFile.nFileStatus = 1;
        localMessageForDeviceFile.time = anaz.gQ();
        localMessageForDeviceFile.progress = 0.0F;
        localMessageForDeviceFile.msg = this.app.getApp().getString(2131692597);
        localMessageForDeviceFile.nFileMsgType = 1;
        if (localMessageForDeviceFile.strServiceName.compareTo(szy.aIl) == 0)
        {
          localMessageForDeviceFile.nFileMsgType = 2;
          localMessageForDeviceFile.msg = this.app.getApp().getString(2131692598);
        }
        ((acle)this.app.getBusinessHandler(13)).W(localMessageForDeviceFile);
        if ((localsyw == null) || (!localsyw.gs(paramString))) {
          break label600;
        }
        if (localMessageForDeviceFile.strServiceName.compareTo(szy.aIl) != 0) {
          break label512;
        }
        localMessageForDeviceFile.uSessionID = localsyw.b(Long.parseLong(paramString), ((FileInfo)localObject).getPath(), null);
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          localMessageForDeviceFile.nFileStatus = 6;
          localMessageForDeviceFile.msgStatus = 1;
        }
        localMessageForDeviceFile.serial();
        c(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
        localArrayList.add(localMessageForDeviceFile);
      }
    }
  }
  
  public void bh(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    float f;
    do
    {
      return;
      int i = paramBundle.getInt("cookie", 0);
      f = paramBundle.getFloat("percent", 0.0F);
      paramBundle = a(Long.valueOf(i));
    } while (paramBundle == null);
    paramBundle.nFileStatus = 3;
    paramBundle.progress = f;
    a(paramBundle);
  }
  
  public void bi(Bundle paramBundle)
  {
    boolean bool = true;
    if (paramBundle == null) {}
    int k;
    int m;
    do
    {
      return;
      k = paramBundle.getInt("cookie", 0);
      m = paramBundle.getInt("err_code", 1);
      localObject = (syw)this.app.getBusinessHandler(51);
      paramBundle = a(Long.valueOf(k));
    } while (paramBundle == null);
    Object localObject = ((syw)localObject).a(Long.parseLong(paramBundle.frienduin));
    long l = 0L;
    int i;
    if (localObject != null)
    {
      i = ((DeviceInfo)localObject).productId;
      l = ((DeviceInfo)localObject).din;
    }
    for (;;)
    {
      int j;
      if (paramBundle.strServiceName.compareTo(szy.aIl) == 0)
      {
        localObject = this.app;
        if (m == 0)
        {
          j = 0;
          tar.a((AppRuntime)localObject, l, "Net_SendMsg_Pic", 0, j, i);
        }
      }
      else
      {
        paramBundle = paramBundle.strServiceName;
        l = k;
        if (m != 0) {
          break label161;
        }
      }
      for (;;)
      {
        g(paramBundle, l, bool);
        return;
        j = 1;
        break;
        label161:
        bool = false;
      }
      i = 0;
    }
  }
  
  public void c(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.cD.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new szg.b(this, paramString, paramInt, paramLong2);
      this.cD.put(Long.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceComnFileMsgProcessor", 2, "found resume");
  }
  
  public void c(Session paramSession)
  {
    paramSession = a(Long.valueOf(paramSession.uSessionID));
    if (paramSession == null) {
      return;
    }
    paramSession.nFileStatus = 2;
    a(paramSession);
  }
  
  public void g(String paramString, long paramLong, boolean paramBoolean)
  {
    MessageForDeviceFile localMessageForDeviceFile = a(Long.valueOf(paramLong));
    if (localMessageForDeviceFile == null) {
      return;
    }
    DeviceInfo localDeviceInfo = ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(localMessageForDeviceFile.frienduin));
    if (localDeviceInfo != null) {}
    for (int i = localDeviceInfo.productId;; i = 0)
    {
      localMessageForDeviceFile.progress = 1.0F;
      if (paramBoolean)
      {
        localMessageForDeviceFile.nFileStatus = 5;
        localMessageForDeviceFile.msgStatus = 0;
        label76:
        localMessageForDeviceFile.msg = this.app.getApp().getString(2131692310);
        if (paramString.compareTo(szy.aIl) != 0) {
          break label251;
        }
        localMessageForDeviceFile.msg = this.app.getApp().getString(2131692315);
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DeviceComnFileMsgProcessor", 4, "onServiceSessionComplete:" + paramLong);
        }
        localMessageForDeviceFile.serial();
        this.app.b().c(localMessageForDeviceFile.frienduin, 9501, localMessageForDeviceFile.uniseq, localMessageForDeviceFile.msgData);
        a(localMessageForDeviceFile);
        this.cD.remove(Long.valueOf(paramLong));
        paramString = this.app.getHandler(Conversation.class);
        if (paramString == null) {
          break;
        }
        paramString.sendEmptyMessage(1009);
        return;
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
        localMessageForDeviceFile.progress = 0.0F;
        break label76;
        label251:
        if (paramString.compareTo(szy.aIk) == 0)
        {
          localMessageForDeviceFile.msg = this.app.getApp().getString(2131692596);
          if (!paramBoolean)
          {
            paramString = (DeviceFileHandler)this.app.getBusinessHandler(50);
            if (localMessageForDeviceFile.isSend())
            {
              if (paramString.I(paramLong) == -5103058) {
                localMessageForDeviceFile.nFileStatus = 7;
              }
              if (ahav.getFileType(localMessageForDeviceFile.filePath) == 0) {
                tar.a(this.app, "Usr_CloudPrint_SendFile", 1, 2, i);
              } else {
                tar.a(this.app, "Usr_CloudPrint_SendFile", 2, 2, i);
              }
            }
            else
            {
              int j = paramString.I(paramLong);
              switch (j)
              {
              default: 
                localMessageForDeviceFile.nFileStatus = 6;
              }
              for (;;)
              {
                tar.a(this.app, "Usr_CloudPrint_SendPrint", 2, j, i);
                break;
                localMessageForDeviceFile.nFileStatus = 10;
                continue;
                localMessageForDeviceFile.nFileStatus = 18;
                continue;
                localMessageForDeviceFile.nFileStatus = 8;
                continue;
                localMessageForDeviceFile.nFileStatus = 9;
                continue;
                localMessageForDeviceFile.nFileStatus = 19;
                continue;
                localMessageForDeviceFile.nFileStatus = 12;
                continue;
                localMessageForDeviceFile.nFileStatus = 13;
                continue;
                localMessageForDeviceFile.nFileStatus = 14;
                continue;
                localMessageForDeviceFile.nFileStatus = 15;
                continue;
                localMessageForDeviceFile.nFileStatus = 16;
                continue;
                localMessageForDeviceFile.nFileStatus = 17;
                continue;
                localMessageForDeviceFile.nFileStatus = 20;
                continue;
                localMessageForDeviceFile.nFileStatus = 21;
                continue;
                localMessageForDeviceFile.nFileStatus = 22;
                localMessageForDeviceFile.nFileStatus = 24;
                continue;
                localMessageForDeviceFile.nFileStatus = 25;
              }
            }
          }
          else if (localMessageForDeviceFile.isSend())
          {
            if (ahav.getFileType(localMessageForDeviceFile.filePath) == 0) {
              tar.a(this.app, "Usr_CloudPrint_SendFile", 1, 1, i);
            } else {
              tar.a(this.app, "Usr_CloudPrint_SendFile", 2, 1, i);
            }
          }
          else
          {
            tar.a(this.app, "Usr_CloudPrint_SendPrint", 1, 0, i);
          }
        }
      }
    }
  }
  
  public void o(String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)anbi.d(-4500);
      localMessageForDeviceFile.strServiceName = szy.aIl;
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = str;
      localMessageForDeviceFile.srcFileName = ahav.getFileName(str);
      localMessageForDeviceFile.fileSize = ahav.getFileSizes(str);
      localMessageForDeviceFile.issend = 1;
      localMessageForDeviceFile.isread = true;
      localMessageForDeviceFile.selfuin = this.app.getCurrentAccountUin();
      localMessageForDeviceFile.senderuin = this.app.getCurrentAccountUin();
      localMessageForDeviceFile.frienduin = paramString;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.time = anaz.gQ();
      localMessageForDeviceFile.progress = 0.0F;
      localMessageForDeviceFile.msg = (this.app.getApp().getString(2131696176) + ": " + this.app.getApp().getString(2131692598));
      localMessageForDeviceFile.nFileMsgType = 2;
      localMessageForDeviceFile.extStr = "device_groupchat";
      ((acle)this.app.getBusinessHandler(13)).W(localMessageForDeviceFile);
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      this.app.b().b(localMessageForDeviceFile, this.app.getCurrentAccountUin());
      str = aqhu.c(BaseApplication.getContext(), Uri.parse(localMessageForDeviceFile.filePath));
      aqhu.b(BaseApplication.getContext(), localMessageForDeviceFile.filePath, str, 160, 160);
      int i = ((syw)this.app.getBusinessHandler(51)).b(Long.parseLong(localMessageForDeviceFile.frienduin), localMessageForDeviceFile.filePath, str);
      localMessageForDeviceFile.uSessionID = i;
      c(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      xya.b(i, localMessageForDeviceFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szw
 * JD-Core Version:    0.7.0.1
 */