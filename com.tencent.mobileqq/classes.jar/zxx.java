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

public class zxx
  extends zve
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<zvf> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<Long, zvg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  
  public zxx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (QLog.isDevelopLevel()) {
      QLog.d("DeviceComnFileMsgProcessor", 4, "cost:" + (System.currentTimeMillis() - l));
    }
  }
  
  private void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (zvf)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((zvf)localObject).a();
      localObject = ((zvf)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((apen)localObject).a(localView, paramMessageForDeviceFile);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
    }
  }
  
  public MessageForDeviceFile a(Long paramLong)
  {
    paramLong = (zvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    if (paramLong == null) {
      return null;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramLong = ((QQAppInterface)localAppRuntime).a().a(paramLong.jdField_a_of_type_JavaLangString, paramLong.jdField_a_of_type_Int, paramLong.jdField_a_of_type_Long);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
    ArrayList localArrayList = new ArrayList();
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)azaf.a(paramMessageForDeviceFile);
    if ("device_groupchat".equals(paramMessageForDeviceFile.extStr))
    {
      localMessageForDeviceFile.strServiceName = paramString;
      localMessageForDeviceFile.filePath = localMessageForDeviceFile.filePath;
      localMessageForDeviceFile.srcFileName = arrr.a(localMessageForDeviceFile.filePath);
      localMessageForDeviceFile.fileSize = arrr.a(localMessageForDeviceFile.filePath);
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.progress = 0.0F;
      ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localMessageForDeviceFile);
      if (!bdin.d(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      paramString = bdhj.a(BaseApplication.getContext(), Uri.parse(localMessageForDeviceFile.filePath));
      bdhj.a(BaseApplication.getContext(), localMessageForDeviceFile.filePath, paramString, 160, 160);
      agoz.a(((ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(localMessageForDeviceFile.frienduin), localMessageForDeviceFile.filePath, paramString), localMessageForDeviceFile);
      localArrayList.add(localMessageForDeviceFile);
      a(localArrayList);
      label236:
      return localMessageForDeviceFile;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForDeviceFile.uSessionID));
    String str1 = paramMessageForDeviceFile.filePath;
    String str2 = paramMessageForDeviceFile.frienduin;
    localMessageForDeviceFile.strServiceName = paramString;
    localMessageForDeviceFile.filePath = str1;
    localMessageForDeviceFile.srcFileName = paramMessageForDeviceFile.srcFileName;
    localMessageForDeviceFile.msgStatus = 2;
    localMessageForDeviceFile.nFileStatus = 1;
    localMessageForDeviceFile.progress = 0.0F;
    localMessageForDeviceFile.nFileMsgType = paramMessageForDeviceFile.nFileMsgType;
    localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691650);
    if (paramString.compareTo(zxz.d) == 0)
    {
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691651);
      label361:
      ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localMessageForDeviceFile);
      paramMessageForDeviceFile = (ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((paramMessageForDeviceFile == null) || (!paramMessageForDeviceFile.a(str2))) {
        break label617;
      }
      if (paramString.compareTo(zxz.d) != 0) {
        break label545;
      }
      localMessageForDeviceFile.uSessionID = paramMessageForDeviceFile.a(Long.parseLong(str2), str1, null);
    }
    for (;;)
    {
      localMessageForDeviceFile.fileSize = arrr.a(str1);
      if (!bdin.d(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      break;
      if (paramString.compareTo(zxz.c) != 0) {
        break label361;
      }
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691649);
      localMessageForDeviceFile.copies = paramMessageForDeviceFile.copies;
      localMessageForDeviceFile.duplexMode = paramMessageForDeviceFile.duplexMode;
      break label361;
      label545:
      if (paramString.compareTo(zxz.f) == 0)
      {
        localMessageForDeviceFile.uSessionID = paramMessageForDeviceFile.a(Long.parseLong(str2), str1, 0);
      }
      else
      {
        paramString = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(str1, paramString, null, Long.parseLong(str2));
        if (paramString == null) {
          break label236;
        }
        localMessageForDeviceFile.uSessionID = paramString.uSessionID;
        continue;
        label617:
        paramString = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(str1, paramString, null, Long.parseLong(str2));
        if (paramString == null) {
          break label236;
        }
        localMessageForDeviceFile.uSessionID = paramString.uSessionID;
      }
    }
  }
  
  public void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new zvg(this, paramString, paramInt, paramLong2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceComnFileMsgProcessor", 2, "found resume");
  }
  
  public void a(Bundle paramBundle)
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
    b(paramBundle);
  }
  
  public void a(View paramView, apen paramapen)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zvf localzvf = (zvf)localIterator.next();
      if (localzvf.a() == paramView)
      {
        localzvf.b = new WeakReference(paramapen);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new zvf(this, paramView, paramapen));
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    paramSession = a(Long.valueOf(paramSession.uSessionID));
    if (paramSession == null) {
      return;
    }
    paramSession.nFileStatus = 3;
    paramSession.progress = paramFloat;
    b(paramSession);
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
        DeviceCommonMsgProcessor.a(paramSession, paramBoolean);
      }
      localObject1 = (ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      localMessageForDeviceFile = a(Long.valueOf(paramSession.uSessionID));
    } while (localMessageForDeviceFile == null);
    Object localObject2 = ((ztp)localObject1).a(Long.parseLong(localMessageForDeviceFile.frienduin));
    int i = 0;
    long l = 0L;
    if (localObject2 != null)
    {
      i = ((DeviceInfo)localObject2).productId;
      l = ((DeviceInfo)localObject2).din;
    }
    if (paramSession.actionInfo.strServiceName.compareTo(zxz.d) == 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!paramBoolean) {
        break label661;
      }
    }
    label661:
    for (int j = 0;; j = 1)
    {
      aagb.a((AppRuntime)localObject2, l, "Net_SendMsg_Pic", 0, j, i);
      if ((paramSession.actionInfo.strServiceName.compareTo(zxz.c) == 0) && (paramSession.bSend) && (paramBoolean))
      {
        String str = new String(paramSession.vFileMD5Src);
        localObject2 = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(paramSession);
        Bundle localBundle = new Bundle();
        localBundle.putInt("copies", localMessageForDeviceFile.copies);
        localBundle.putInt("duplexMode", localMessageForDeviceFile.duplexMode);
        localBundle.putInt("mediaSize", localMessageForDeviceFile.mediaSize);
        localBundle.putInt("mediaType", localMessageForDeviceFile.mediaType);
        localBundle.putInt("scaling", localMessageForDeviceFile.scaling);
        localBundle.putInt("orientation", localMessageForDeviceFile.orientation);
        localBundle.putInt("color", localMessageForDeviceFile.color);
        localBundle.putInt("quality", localMessageForDeviceFile.quality);
        ((ztp)localObject1).a(Long.parseLong(localMessageForDeviceFile.frienduin), str, String.valueOf(((Session)localObject2).uSessionID), paramSession.strFileNameSrc, paramSession.emFileType, localBundle);
        localObject1 = (MessageForDeviceFile)azaf.a(-4500);
        ((MessageForDeviceFile)localObject1).strServiceName = zxz.c;
        ((MessageForDeviceFile)localObject1).msgtype = -4500;
        ((MessageForDeviceFile)localObject1).istroop = 9501;
        ((MessageForDeviceFile)localObject1).filePath = paramSession.strFilePathSrc;
        ((MessageForDeviceFile)localObject1).srcFileName = paramSession.strFileNameSrc;
        ((MessageForDeviceFile)localObject1).fileSize = paramSession.uFileSizeSrc;
        ((MessageForDeviceFile)localObject1).issend = 0;
        ((MessageForDeviceFile)localObject1).isread = true;
        ((MessageForDeviceFile)localObject1).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((MessageForDeviceFile)localObject1).senderuin = localMessageForDeviceFile.frienduin;
        ((MessageForDeviceFile)localObject1).frienduin = localMessageForDeviceFile.frienduin;
        ((MessageForDeviceFile)localObject1).msgStatus = 2;
        ((MessageForDeviceFile)localObject1).nFileStatus = 1;
        ((MessageForDeviceFile)localObject1).time = ayzl.a();
        ((MessageForDeviceFile)localObject1).progress = 0.0F;
        ((MessageForDeviceFile)localObject1).uSessionID = ((Session)localObject2).uSessionID;
        ((MessageForDeviceFile)localObject1).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691649);
        ((MessageForDeviceFile)localObject1).nFileMsgType = 1;
        ((MessageForDeviceFile)localObject1).copies = localMessageForDeviceFile.copies;
        ((MessageForDeviceFile)localObject1).duplexMode = localMessageForDeviceFile.duplexMode;
        ((MessageForDeviceFile)localObject1).mediaSize = localMessageForDeviceFile.mediaSize;
        ((MessageForDeviceFile)localObject1).scaling = localMessageForDeviceFile.scaling;
        ((MessageForDeviceFile)localObject1).color = localMessageForDeviceFile.color;
        ((MessageForDeviceFile)localObject1).quality = localMessageForDeviceFile.quality;
        ((MessageForDeviceFile)localObject1).uint32_src_uin_type = 1;
        ((MessageForDeviceFile)localObject1).serial();
        a(((MessageForDeviceFile)localObject1).uSessionID, ((MessageForDeviceFile)localObject1).frienduin, ((MessageForDeviceFile)localObject1).istroop, ((MessageForDeviceFile)localObject1).uniseq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, false, true);
        ThreadManager.getUIHandler().postDelayed(new DeviceComnFileMsgProcessor.1(this, (MessageForDeviceFile)localObject1), 900000L);
      }
      a(paramSession.actionInfo.strServiceName, paramSession.uSessionID, paramBoolean);
      return;
    }
  }
  
  public void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localArrayList.add(paramMessageForDeviceFile);
    } while (((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(localArrayList));
    arri.a(2131694064);
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
    b(paramMessageRecord);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, 9501, paramMessageRecord.uniseq, paramMessageRecord.msgData);
      b(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (paramMessageRecord == null) {
        break;
      }
      paramMessageRecord.sendEmptyMessage(1009);
      return;
      paramMessageRecord.nFileStatus = 6;
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    MessageForDeviceFile localMessageForDeviceFile = a(Long.valueOf(paramLong));
    if (localMessageForDeviceFile == null) {
      return;
    }
    DeviceInfo localDeviceInfo = ((ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(localMessageForDeviceFile.frienduin));
    if (localDeviceInfo != null) {}
    for (int i = localDeviceInfo.productId;; i = 0)
    {
      localMessageForDeviceFile.progress = 1.0F;
      if (paramBoolean)
      {
        localMessageForDeviceFile.nFileStatus = 5;
        localMessageForDeviceFile.msgStatus = 0;
        label76:
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691346);
        if (paramString.compareTo(zxz.d) != 0) {
          break label251;
        }
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691351);
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DeviceComnFileMsgProcessor", 4, "onServiceSessionComplete:" + paramLong);
        }
        localMessageForDeviceFile.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForDeviceFile.frienduin, 9501, localMessageForDeviceFile.uniseq, localMessageForDeviceFile.msgData);
        b(localMessageForDeviceFile);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
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
        if (paramString.compareTo(zxz.c) == 0)
        {
          localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691649);
          if (!paramBoolean)
          {
            paramString = (DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50);
            if (localMessageForDeviceFile.isSend())
            {
              if (paramString.a(paramLong) == -5103058) {
                localMessageForDeviceFile.nFileStatus = 7;
              }
              if (arrr.a(localMessageForDeviceFile.filePath) == 0) {
                aagb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 1, 2, i);
              } else {
                aagb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 2, 2, i);
              }
            }
            else
            {
              int j = paramString.a(paramLong);
              switch (j)
              {
              default: 
                localMessageForDeviceFile.nFileStatus = 6;
              }
              for (;;)
              {
                aagb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendPrint", 2, j, i);
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
            if (arrr.a(localMessageForDeviceFile.filePath) == 0) {
              aagb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 1, 1, i);
            } else {
              aagb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 2, 1, i);
            }
          }
          else
          {
            aagb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendPrint", 1, 0, i);
          }
        }
      }
    }
  }
  
  public void a(String paramString, AbsStructMsg paramAbsStructMsg)
  {
    MessageForStructing localMessageForStructing = azaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 9501, 100L, paramAbsStructMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(paramString), paramAbsStructMsg);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject1 = (String)paramList.next();
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)azaf.a(-4500);
      localMessageForDeviceFile.strServiceName = paramString1;
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = ((String)localObject1);
      localMessageForDeviceFile.srcFileName = arrr.a((String)localObject1);
      localMessageForDeviceFile.fileSize = arrr.a((String)localObject1);
      localMessageForDeviceFile.issend = 1;
      localMessageForDeviceFile.isread = true;
      localMessageForDeviceFile.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.frienduin = paramString2;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.time = ayzl.a();
      localMessageForDeviceFile.progress = 0.0F;
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691650);
      localMessageForDeviceFile.nFileMsgType = 1;
      if (paramString1.compareTo(zxz.d) == 0)
      {
        localMessageForDeviceFile.nFileMsgType = 2;
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691651);
      }
      int i;
      if (paramString1.compareTo(zxz.c) == 0)
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
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691649);
        localMessageForDeviceFile.copies = i3;
        localMessageForDeviceFile.duplexMode = i2;
        localMessageForDeviceFile.mediaSize = i1;
        localMessageForDeviceFile.mediaType = n;
        localMessageForDeviceFile.scaling = m;
        localMessageForDeviceFile.orientation = k;
        localMessageForDeviceFile.color = j;
        localMessageForDeviceFile.quality = i;
      }
      ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localMessageForDeviceFile);
      Object localObject2 = (ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((localObject2 != null) && (((ztp)localObject2).a(paramString2))) {
        if (paramString1.compareTo(zxz.d) == 0)
        {
          String str = bdhj.a(BaseApplication.getContext(), Uri.parse((String)localObject1));
          bdhj.a(BaseApplication.getContext(), (String)localObject1, str, 160, 160);
          localMessageForDeviceFile.uSessionID = ((ztp)localObject2).a(Long.parseLong(paramString2), (String)localObject1, str);
        }
      }
      for (;;)
      {
        label526:
        if (!bdin.d(BaseApplication.getContext()))
        {
          localMessageForDeviceFile.nFileStatus = 6;
          localMessageForDeviceFile.msgStatus = 1;
        }
        localMessageForDeviceFile.serial();
        a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
        localArrayList.add(localMessageForDeviceFile);
        break;
        if (paramString1.compareTo(zxz.f) == 0)
        {
          localMessageForDeviceFile.uSessionID = ((ztp)localObject2).a(Long.parseLong(paramString2), (String)localObject1, 0);
        }
        else
        {
          if (paramString1.compareTo(zxz.c) == 0)
          {
            localObject2 = ((ztp)localObject2).a(Long.parseLong(paramString2));
            i = 0;
            if (localObject2 != null) {
              i = ((DeviceInfo)localObject2).productId;
            }
            if (arrr.a((String)localObject1) != 0) {
              break label722;
            }
            aagb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 1, 0, i);
          }
          for (;;)
          {
            localObject1 = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a((String)localObject1, paramString1, null, Long.parseLong(paramString2));
            if (localObject1 == null) {
              break;
            }
            localMessageForDeviceFile.uSessionID = ((Session)localObject1).uSessionID;
            break label526;
            label722:
            aagb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_CloudPrint_SendFile", 2, 0, i);
          }
          localObject1 = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a((String)localObject1, paramString1, null, Long.parseLong(paramString2));
          if (localObject1 == null) {
            break;
          }
          localMessageForDeviceFile.uSessionID = ((Session)localObject1).uSessionID;
        }
      }
    }
    a(localArrayList);
  }
  
  public void a(String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)azaf.a(-4500);
      localMessageForDeviceFile.strServiceName = zxz.d;
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = str;
      localMessageForDeviceFile.srcFileName = arrr.a(str);
      localMessageForDeviceFile.fileSize = arrr.a(str);
      localMessageForDeviceFile.issend = 1;
      localMessageForDeviceFile.isread = true;
      localMessageForDeviceFile.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.frienduin = paramString;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.time = ayzl.a();
      localMessageForDeviceFile.progress = 0.0F;
      localMessageForDeviceFile.msg = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694674) + ": " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691651));
      localMessageForDeviceFile.nFileMsgType = 2;
      localMessageForDeviceFile.extStr = "device_groupchat";
      ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localMessageForDeviceFile);
      if (!bdin.d(BaseApplication.getContext()))
      {
        localMessageForDeviceFile.nFileStatus = 6;
        localMessageForDeviceFile.msgStatus = 1;
      }
      localMessageForDeviceFile.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForDeviceFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      str = bdhj.a(BaseApplication.getContext(), Uri.parse(localMessageForDeviceFile.filePath));
      bdhj.a(BaseApplication.getContext(), localMessageForDeviceFile.filePath, str, 160, 160);
      int i = ((ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(localMessageForDeviceFile.frienduin), localMessageForDeviceFile.filePath, str);
      localMessageForDeviceFile.uSessionID = i;
      a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      agoz.a(i, localMessageForDeviceFile);
    }
  }
  
  public boolean a(String paramString1, String paramString2, List<String> paramList)
  {
    a(paramString1, paramString2, paramList, null);
    return true;
  }
  
  public boolean a(String paramString, List<FileInfo> paramList)
  {
    ztp localztp = (ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
          localMessageForDeviceFile.strServiceName = zxz.b;
          continue;
          label512:
          if (localMessageForDeviceFile.strServiceName.compareTo(zxz.f) == 0)
          {
            localMessageForDeviceFile.uSessionID = localztp.a(Long.parseLong(paramString), ((FileInfo)localObject).c(), 0);
          }
          else
          {
            localObject = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(((FileInfo)localObject).c(), localMessageForDeviceFile.strServiceName, null, Long.parseLong(paramString));
            if (localObject != null)
            {
              localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
              continue;
              label600:
              localObject = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(((FileInfo)localObject).c(), localMessageForDeviceFile.strServiceName, null, Long.parseLong(paramString));
              if (localObject != null) {
                localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
              }
            }
          }
        }
      }
      label650:
      a(localException);
      return true;
    }
    if ((localztp != null) && (localztp.a(l1, 9))) {}
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
        localMessageForDeviceFile = (MessageForDeviceFile)azaf.a(-4500);
        j = ((FileInfo)localObject).a();
        if (j != 0) {
          break;
        }
        localMessageForDeviceFile.strServiceName = zxz.d;
        localMessageForDeviceFile.msgtype = -4500;
        localMessageForDeviceFile.istroop = 9501;
        localMessageForDeviceFile.filePath = ((FileInfo)localObject).c();
        localMessageForDeviceFile.srcFileName = arrr.a(((FileInfo)localObject).c());
        localMessageForDeviceFile.fileSize = arrr.a(((FileInfo)localObject).c());
        localMessageForDeviceFile.issend = 1;
        localMessageForDeviceFile.isread = true;
        localMessageForDeviceFile.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localMessageForDeviceFile.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localMessageForDeviceFile.frienduin = paramString;
        localMessageForDeviceFile.msgStatus = 2;
        localMessageForDeviceFile.nFileStatus = 1;
        localMessageForDeviceFile.time = ayzl.a();
        localMessageForDeviceFile.progress = 0.0F;
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691650);
        localMessageForDeviceFile.nFileMsgType = 1;
        if (localMessageForDeviceFile.strServiceName.compareTo(zxz.d) == 0)
        {
          localMessageForDeviceFile.nFileMsgType = 2;
          localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691651);
        }
        ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localMessageForDeviceFile);
        if ((localztp == null) || (!localztp.a(paramString))) {
          break label600;
        }
        if (localMessageForDeviceFile.strServiceName.compareTo(zxz.d) != 0) {
          break label512;
        }
        localMessageForDeviceFile.uSessionID = localztp.a(Long.parseLong(paramString), ((FileInfo)localObject).c(), null);
        if (!bdin.d(BaseApplication.getContext()))
        {
          localMessageForDeviceFile.nFileStatus = 6;
          localMessageForDeviceFile.msgStatus = 1;
        }
        localMessageForDeviceFile.serial();
        a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
        localArrayList.add(localMessageForDeviceFile);
      }
    }
  }
  
  public void b(Bundle paramBundle)
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
      localObject = (ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      paramBundle = a(Long.valueOf(k));
    } while (paramBundle == null);
    Object localObject = ((ztp)localObject).a(Long.parseLong(paramBundle.frienduin));
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
      if (paramBundle.strServiceName.compareTo(zxz.d) == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (m == 0)
        {
          j = 0;
          aagb.a((AppRuntime)localObject, l, "Net_SendMsg_Pic", 0, j, i);
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
        a(paramBundle, l, bool);
        return;
        j = 1;
        break;
        label161:
        bool = false;
      }
      i = 0;
    }
  }
  
  public void b(Session paramSession)
  {
    paramSession = a(Long.valueOf(paramSession.uSessionID));
    if (paramSession == null) {
      return;
    }
    paramSession.nFileStatus = 2;
    b(paramSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zxx
 * JD-Core Version:    0.7.0.1
 */