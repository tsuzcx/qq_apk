import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.1;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.2;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter.1;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import mqq.app.MobileQQ;

public class agir
{
  private Handler cP;
  private HashMap<String, agir.k> kK;
  private QQAppInterface mApp;
  
  public agir(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.cP = new Handler(ThreadManager.getSubThreadLooper());
    this.kK = new HashMap();
  }
  
  private void IG(String paramString)
  {
    this.cP.post(new QFileMsgForwardManager.2(this, paramString));
  }
  
  private void IH(String paramString)
  {
    this.cP.post(new QFileMsgForwardManager.3(this, paramString));
  }
  
  private agir.i a(String paramString1, int paramInt, String paramString2, MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "createUploadTask: forwardRequestSeq is null");
      return null;
    }
    if (paramMessageRecord == null)
    {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "createUploadTask: file message record is null");
      return null;
    }
    paramString2 = new agir.i(paramString2, paramString1, paramInt, paramMessageRecord);
    paramString1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    if (ml(paramString1)) {
      if (paramInt == 0) {
        paramString1 = new agir.d(paramMessageRecord);
      }
    }
    for (;;)
    {
      label76:
      paramString2.a = paramString1;
      return paramString2;
      if (paramInt == 3000)
      {
        paramString1 = new agir.h(paramMessageRecord);
      }
      else if (paramInt == 1)
      {
        paramString1 = new agir.n(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName"), paramString1, null);
      }
      else
      {
        do
        {
          do
          {
            try
            {
              int i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
              switch (i)
              {
              default: 
                paramString1 = null;
              }
            }
            catch (NumberFormatException paramString1)
            {
              QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
              return null;
            }
            if (paramInt == 0)
            {
              paramString1 = new agir.a(paramMessageRecord);
              break;
            }
            if (paramInt == 3000)
            {
              paramString1 = new agir.b(paramMessageRecord);
              break;
            }
          } while (paramInt != 1);
          paramString1 = new agir.c(paramMessageRecord);
          break;
          if (paramInt == 0)
          {
            paramString1 = new agir.e(paramMessageRecord);
            break;
          }
          if (paramInt == 3000)
          {
            paramString1 = new agir.f(paramMessageRecord);
            break;
          }
        } while (paramInt != 1);
        paramString1 = new agir.g(paramMessageRecord);
      }
    }
    if (paramInt == 0) {
      paramInt = 3;
    }
    for (;;)
    {
      paramString1 = new agir.m(paramMessageRecord, paramInt, null);
      break label76;
      if (paramInt == 3000)
      {
        paramInt = 106;
      }
      else
      {
        if (paramInt != 1) {
          break;
        }
        paramInt = 102;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, agir.j paramj)
  {
    if (paramj == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "sendFeeds but callback is null fileid " + paramString);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "sendFeeds will call reqFeeds fileid " + paramString);
    smq.a(paramQQAppInterface, paramLong1, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramBundle, new agis(paramString, paramj, paramLong2));
  }
  
  private static void a(MessageRecord paramMessageRecord, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMessageRecord.saveExtInfoToExtStr(str, paramBundle.getString(str));
    }
  }
  
  private boolean aw(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardLasSuccess");
    if (!TextUtils.isEmpty(paramMessageRecord))
    {
      long l = Long.parseLong(paramMessageRecord);
      if (anaz.gQ() - l < 86400L) {
        return false;
      }
    }
    return true;
  }
  
  private void b(MessageRecord paramMessageRecord, Bundle paramBundle)
  {
    if (paramMessageRecord == null)
    {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "updateFileMessageRecordWithUuid: MessageRecord is null.");
      return;
    }
    a(paramMessageRecord, paramBundle);
    paramMessageRecord.saveExtInfoToExtStr("_m_ForwardFileStatus", "1");
    paramMessageRecord.saveExtInfoToExtStr("_m_ForwardLasSuccess", String.valueOf(anaz.gQ()));
  }
  
  private static String i(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      return BaseActivity.sTopActivity.app.getApplication().getResources().getString(2131693660);
    }
    if (paramLong > 10485760L) {
      return BaseActivity.sTopActivity.app.getApplication().getResources().getString(2131693662);
    }
    return BaseActivity.sTopActivity.app.getApplication().getResources().getString(2131693701);
  }
  
  private static boolean ml(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!aqhq.fileExistsAndNotEmpty(paramString))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, "filePath[" + paramString + "] file is not existed");
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool1 = bool2;
      if (ahav.getFileSizes(paramString) <= 10485760L) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "file is isSmall:" + bool1);
    return bool1;
  }
  
  public void a(agnn paramagnn, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "addMultiFileUploadRequest: file message record list is null");
    }
    this.cP.post(new QFileMsgForwardManager.1(this, paramagnn));
  }
  
  public void b(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (ahbr.ay(paramMessageRecord1)) {
      paramMessageRecord2.extStr = paramMessageRecord1.extStr;
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramMessageRecord1.getExtInfoFromExtStr("_m_ForwardFileType"));
        switch (i)
        {
        default: 
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardSenderUin", this.mApp.getCurrentAccountUin());
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileStatus", "4");
          paramMessageRecord2.removeExtInfoToExtStr("_m_ForwardFaildReason");
          paramMessageRecord2.removeExtInfoToExtStr("_m_ForwardLasSuccess");
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, localNumberFormatException.toString());
        int i = -1;
        continue;
        paramMessageRecord1 = this.mApp.a().a(paramMessageRecord1.uniseq, paramMessageRecord1.frienduin, paramMessageRecord1.istroop);
        if (paramMessageRecord1 == null) {
          continue;
        }
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", paramMessageRecord1.getFilePath());
        continue;
        paramMessageRecord1 = (MessageForTroopFile)ahav.e((ChatMessage)paramMessageRecord1);
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", apsv.a(this.mApp, paramMessageRecord1).LocalFile);
        continue;
      }
      Object localObject;
      if ((paramMessageRecord1 instanceof MessageForFile))
      {
        long l = paramMessageRecord1.uniseq;
        localObject = this.mApp.a().a(l, paramMessageRecord1.frienduin, paramMessageRecord1.istroop);
        if (localObject != null)
        {
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileName", ((FileManagerEntity)localObject).fileName);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(((FileManagerEntity)localObject).fileSize));
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardUuid", ((FileManagerEntity)localObject).Uuid);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileIdCrc", ((FileManagerEntity)localObject).fileIdCrc);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardMd5", ((FileManagerEntity)localObject).strFileMd5);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", ((FileManagerEntity)localObject).getFilePath());
          paramMessageRecord2.saveExtInfoToExtStr("_f_thumb_path_750_", ((FileManagerEntity)localObject).strLargeThumPath);
          paramMessageRecord2.saveExtInfoToExtStr("_f_thumb_path_384_", ((FileManagerEntity)localObject).strMiddleThumPath);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(((FileManagerEntity)localObject).imgWidth));
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(((FileManagerEntity)localObject).imgHeight));
          if (((FileManagerEntity)localObject).peerType == 0)
          {
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", ((FileManagerEntity)localObject).peerUin);
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "1");
          }
          for (;;)
          {
            if (((FileManagerEntity)localObject).status != 3) {
              break label451;
            }
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardStatusPaused", "1");
            break;
            if (((FileManagerEntity)localObject).peerType == 3000)
            {
              paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", ((FileManagerEntity)localObject).peerUin);
              paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "2");
            }
            else if (((FileManagerEntity)localObject).peerType == 1)
            {
              paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "3");
            }
          }
        }
        else
        {
          label451:
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "cann't find Entity by msg:" + paramMessageRecord1.uniseq);
        }
      }
      else if ((paramMessageRecord1 instanceof MessageForTroopFile))
      {
        paramMessageRecord1 = (MessageForTroopFile)paramMessageRecord1;
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "3");
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", paramMessageRecord1.frienduin);
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardSha", paramMessageRecord1.sha1);
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(paramMessageRecord1.fileSize));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(paramMessageRecord1.width));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(paramMessageRecord1.height));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardDuration", String.valueOf(paramMessageRecord1.duration));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardBusType", String.valueOf(paramMessageRecord1.bisID));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardUuid", paramMessageRecord1.url);
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileName", paramMessageRecord1.fileName);
        localObject = apsv.a(this.mApp, paramMessageRecord1);
        if (localObject != null)
        {
          paramMessageRecord2.saveExtInfoToExtStr("_f_thumb_path_750_", ((apcy)localObject).ThumbnailFile_Large);
          paramMessageRecord2.saveExtInfoToExtStr("_f_thumb_path_384_", ((apcy)localObject).coc);
          if (((paramMessageRecord1.width == 0) || (paramMessageRecord1.height == 0)) && (((apcy)localObject).dTo > 0) && (((apcy)localObject).dTp > 0))
          {
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(paramMessageRecord1.width));
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(paramMessageRecord1.height));
          }
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", ((apcy)localObject).LocalFile);
          if ((((apcy)localObject).Status == 2) || (((apcy)localObject).Status == 3)) {
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardStatusPaused", "1");
          }
        }
      }
    }
  }
  
  class a
    extends agir.l
  {
    protected String bHm;
    protected String bHn;
    protected String bHo;
    protected String bHp;
    protected String mFileName;
    protected String mFilePath;
    protected long mFileSize;
    protected String mUuid;
    protected String md5;
    
    a(MessageRecord paramMessageRecord)
    {
      super();
      this.mFileName = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.mFileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      this.mUuid = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      this.bHm = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
      this.md5 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      this.mFilePath = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
      this.bHn = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      this.bHo = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.bHp = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      if ("1".equals(this.bHp))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2BuddyTaskExcuter:" + this.mFileName + " faild, file is upload paused");
        }
        paramj.ch(agir.j(this.mFileSize, false), false);
        return;
      }
      if ((this.mUuid == null) || (this.mUuid.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2BuddyTaskExcuter:" + this.mFileName + " faild, file uuid is null");
        }
        paramj.ch(agir.j(this.mFileSize, true), false);
        return;
      }
      aghr localaghr = agir.a(agir.this).a().a();
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + this.mFileName + "]");
      }
      localaghr.a(paramString, paramInt, this.mUuid, this.bHm, this.mFileName, this.mFileSize, 3, new agit(this, paramString, paramj));
    }
    
    void eD(String paramString, int paramInt) {}
  }
  
  class b
    extends agir.l
  {
    protected String bHn;
    protected String bHo;
    protected String bHp;
    protected String bHq;
    protected String mFileName;
    protected long mFileSize;
    protected String mUuid;
    protected String md5;
    
    b(MessageRecord paramMessageRecord)
    {
      super();
      this.mFileName = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.mFileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      this.mUuid = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      this.bHq = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
      this.md5 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      this.bHn = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      this.bHo = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.bHp = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      if ("1".equals(this.bHp))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2DiscTaskExcuter:" + this.mFileName + " faild, file is upload paused");
        }
        paramj.ch(agir.j(this.mFileSize, false), false);
        return;
      }
      if ((this.mUuid == null) || (this.mUuid.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.mFileName + " Buddy2DiscTaskExcuter faild,文件不存在或已失效");
        }
        paramj.ch(agir.j(this.mFileSize, true), false);
        return;
      }
      agir.a(agir.this).a().a().a(paramString, paramInt, this.mUuid, this.bHq, this.mFileName, this.mFileSize, 106, new agiu(this, paramString, paramj));
    }
    
    void eD(String paramString, int paramInt) {}
  }
  
  class c
    extends agir.l
  {
    protected String bHm;
    protected String bHn;
    protected String bHo;
    protected String bHp;
    protected String mFileName;
    protected long mFileSize;
    protected String mUuid;
    protected String md5;
    
    c(MessageRecord paramMessageRecord)
    {
      super();
      this.mFileName = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.mFileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      this.mUuid = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      this.bHm = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
      this.md5 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      this.bHn = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      this.bHo = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.bHp = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      if ("1".equals(this.bHp))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2TroopTaskExcuter:" + this.mFileName + " faild, file is upload paused");
        }
        paramj.ch(agir.j(this.mFileSize, false), false);
        return;
      }
      if ((this.mUuid == null) || (this.mUuid.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.mFileName + " Buddy2TroopTaskExcuter faild uuid is null");
        }
        paramj.ch(agir.j(this.mFileSize, true), false);
        return;
      }
      agir.a(agir.this).a().a().a(paramString, paramInt, this.mUuid, this.bHm, this.mFileName, this.mFileSize, 102, new agiv(this, paramString, paramj));
    }
    
    void eD(String paramString, int paramInt) {}
  }
  
  public class d
    extends agir.l
  {
    private Bundle mBundle;
    public String mFileName;
    public String mFilePath;
    public long mFileSize;
    private long mSessionId;
    
    public d(MessageRecord paramMessageRecord)
    {
      super();
      this.mFileName = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.mFileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      this.mFilePath = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
      this$1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.mBundle = new Bundle();
      this.mBundle.putString("_m_ForwardImgWidth", agir.this);
      this.mBundle.putString("_m_ForwardImgHeight", paramMessageRecord);
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      this.mBundle.putString("_m_ForwardFileType", "1");
      this.mBundle.putString("_m_ForwardReceiverUin", paramString);
      this.mBundle.putString("_m_ForwardFileName", this.mFileName);
      ahav.a.getExecutor().execute(new QFileMsgForwardManager.BuddyUploadTaskExcuter.1(this, paramString, paramj));
    }
    
    void eD(String paramString, int paramInt) {}
  }
  
  class e
    extends agir.l
  {
    protected String bHn;
    protected String bHo;
    protected String bHp;
    protected String bHs;
    protected String mFileName;
    protected long mFileSize;
    protected String mUuid;
    protected String md5;
    
    e(MessageRecord paramMessageRecord)
    {
      super();
      this.mFileName = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.mFileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      this.mUuid = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      this.md5 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      this.bHs = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      this.bHn = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      this.bHo = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.bHp = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      if ("1".equals(this.bHp))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Disc2BuddyTaskExcuter:" + this.mFileName + " faild, file is upload paused");
        }
        paramj.ch(agir.j(this.mFileSize, false), false);
        return;
      }
      if ((this.mUuid == null) || (this.mUuid.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.mFileName + " Disc2BuddyTaskExcuter send faild uuid is null");
        }
        paramj.ch(agir.j(this.mFileSize, true), false);
        return;
      }
      agir.a(agir.this).a().a().a(paramString, paramInt, this.bHs, 3, this.mUuid, this.mFileName, this.mFileSize, this.md5, new agiy(this, paramString, paramj));
    }
    
    void eD(String paramString, int paramInt) {}
  }
  
  class f
    extends agir.l
  {
    protected String bHn;
    protected String bHo;
    protected String bHp;
    protected String bHs;
    protected String mFileName;
    protected long mFileSize;
    protected String mUuid;
    protected String md5;
    
    f(MessageRecord paramMessageRecord)
    {
      super();
      this.mFileName = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.mFileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      this.mUuid = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      this.md5 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      this.bHs = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      this.bHn = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      this.bHo = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.bHp = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      if ("1".equals(this.bHp))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Disc2DiscTaskExcuter:" + this.mFileName + " faild, file is upload paused");
        }
        paramj.ch(agir.j(this.mFileSize, false), false);
        return;
      }
      if ((this.mUuid == null) || (this.mUuid.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.mFileName + " Disc2DiscTaskExcuter send faild uuid is null");
        }
        paramj.ch(agir.j(this.mFileSize, true), false);
        return;
      }
      agir.a(agir.this).a().a().a(paramString, paramInt, this.bHs, 106, this.mUuid, this.mFileName, this.mFileSize, this.md5, new agiz(this, paramString, paramj));
    }
    
    void eD(String paramString, int paramInt) {}
  }
  
  class g
    extends agir.l
  {
    protected String bHn;
    protected String bHo;
    protected String bHp;
    protected String bHs;
    protected String mFileName;
    protected long mFileSize;
    protected String mUuid;
    protected String md5;
    
    g(MessageRecord paramMessageRecord)
    {
      super();
      this.mFileName = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.mFileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      this.mUuid = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      this.md5 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      this.bHs = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      this.bHn = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      this.bHo = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.bHp = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      if ("1".equals(this.bHp))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Disc2TroopTaskExcuter:" + this.mFileName + " faild, file is upload paused");
        }
        paramj.ch(agir.j(this.mFileSize, false), false);
        return;
      }
      if ((this.mUuid == null) || (this.mUuid.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.mFileName + " Disc2TroopTaskExcuter send faild uuid is null");
        }
        paramj.ch(agir.j(this.mFileSize, true), false);
        return;
      }
      agir.a(agir.this).a().a().a(paramString, paramInt, this.bHs, 102, this.mUuid, this.mFileName, this.mFileSize, this.md5, new agja(this, paramString, paramj));
    }
    
    void eD(String paramString, int paramInt) {}
  }
  
  class h
    extends agir.l
  {
    private Bundle mBundle;
    protected String mFileName;
    protected String mFilePath;
    protected long mFileSize;
    private long mSessionId;
    
    h(MessageRecord paramMessageRecord)
    {
      super();
      this.mFileName = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.mFileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      this.mFilePath = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
      this$1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.mBundle = new Bundle();
      this.mBundle.putString("_m_ForwardImgWidth", agir.this);
      this.mBundle.putString("_m_ForwardImgHeight", paramMessageRecord);
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      this.mBundle.putString("_m_ForwardFileType", "2");
      this.mBundle.putString("_m_ForwardReceiverUin", paramString);
      this.mBundle.putString("_m_ForwardFileName", this.mFileName);
      String str1 = agoy.t(ahav.t(this.mFilePath));
      String str2 = agoy.t(ahav.x(this.mFilePath));
      this.mFileSize = ahav.getFileSizes(this.mFilePath);
      this.mBundle.putString("_m_ForwardSize", this.mFileSize + "");
      this.mBundle.putString("_m_ForwardMd5", str1);
      this.mBundle.putString("_m_ForwardSha", str2);
      this.mBundle.putString("_m_ForwardDeadTime", "0");
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start DiscUploadTaskExcuter:" + this.mFileName);
      }
      agir.a(agir.this).a().a(str1, str2, this.mFileName, this.mFileSize, paramString, agir.a(agir.this).getCurrentAccountUin(), new agjb(this, paramj, str2));
    }
    
    void eD(String paramString, int paramInt) {}
  }
  
  public class i
  {
    agir.l a;
    public agir.j b;
    String bHt;
    int cXj;
    int status = 0;
    String toUin;
    MessageRecord w;
    
    i(String paramString1, String paramString2, int paramInt, MessageRecord paramMessageRecord)
    {
      this.bHt = paramString1;
      this.cXj = paramInt;
      this.toUin = paramString2;
      this.w = paramMessageRecord;
      this.b = new agjd(this, agir.this, paramMessageRecord);
    }
    
    void Ml()
    {
      if ((this.a != null) && (this.status == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task suc. status[" + this.status + "]");
        }
        this.status = 1;
        this.a.a(this.toUin, this.cXj, this.b);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task fail. status[" + this.status + "]");
    }
    
    void stopTask()
    {
      if ((this.a != null) && ((this.status == 1) || (this.status == 0)))
      {
        this.a.eD(this.toUin, this.cXj);
        this.status = 4;
      }
    }
  }
  
  public static abstract interface j
  {
    public abstract void ch(String paramString, boolean paramBoolean);
    
    public abstract void w(String paramString, Bundle paramBundle);
  }
  
  public class k
  {
    List<agir.i> AW;
    List<agir.i> AX;
    List<agir.i> AY;
    public List<agir.i> AZ;
    List<agir.i> Ba;
    public agnn b;
    String bHu;
    public HashMap<String, ArrayList<MessageRecord>> kL;
    int status;
    
    public k(agnn paramagnn, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
    {
      this.bHu = paramagnn;
      this.b = paramHashMap;
      this.status = 0;
      Object localObject;
      this.kL = localObject;
      this.AX = new ArrayList();
      this.AW = new ArrayList();
      this.AY = new ArrayList();
      this.AZ = new ArrayList();
      this.Ba = new ArrayList();
    }
    
    public void a(agir.i parami)
    {
      if (parami != null) {
        this.AX.add(parami);
      }
    }
    
    void dgS()
    {
      if (10 <= this.AX.size()) {}
      ArrayList localArrayList;
      for (int i = 10;; i = this.AX.size())
      {
        localArrayList = new ArrayList(i);
        int j = 0;
        while (j < i)
        {
          agir.i locali = (agir.i)this.AX.get(j);
          this.AW.add(locali);
          localArrayList.add(locali);
          j += 1;
        }
      }
      this.AX.removeAll(localArrayList);
    }
    
    public int getTaskCount()
    {
      return this.AX.size();
    }
    
    public void start()
    {
      dgS();
      Iterator localIterator = this.AW.iterator();
      while (localIterator.hasNext()) {
        ((agir.i)localIterator.next()).Ml();
      }
      this.status = 1;
    }
    
    public void stop()
    {
      Iterator localIterator = this.AW.iterator();
      while (localIterator.hasNext()) {
        ((agir.i)localIterator.next()).stopTask();
      }
      this.status = 5;
    }
    
    public void update()
    {
      int j = this.AY.size();
      int k = this.Ba.size();
      int m = this.AZ.size();
      Iterator localIterator = this.AW.iterator();
      int i = 0;
      agir.i locali;
      if (localIterator.hasNext())
      {
        locali = (agir.i)localIterator.next();
        if ((locali.status == 2) || (locali.status == 3) || (locali.status == 4)) {
          localIterator.remove();
        }
        if (locali.status == 2)
        {
          this.AY.add(locali);
          i += 1;
        }
      }
      for (;;)
      {
        break;
        if (locali.status == 3)
        {
          this.Ba.add(locali);
          i += 1;
        }
        else if (locali.status == 4)
        {
          this.AZ.add(locali);
          i += 1;
          continue;
          dgS();
          if (QLog.isColorLevel())
          {
            int n = this.AW.size();
            int i1 = this.AX.size();
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "request update, forwardSeq[ " + this.bHu + "] removeCount[" + i + "] leftCount[" + (n + i1) + "] finishCount[" + (m + (j + k)) + "]");
          }
          localIterator = this.AW.iterator();
          while (localIterator.hasNext()) {
            ((agir.i)localIterator.next()).Ml();
          }
          if ((this.AW.size() <= 0) && (this.AX.size() <= 0))
          {
            this.status = 5;
            if (QLog.isDevelopLevel()) {
              QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: forwardSeq[ " + this.bHu + "]");
            }
            agir.a(agir.this, this.bHu);
          }
          return;
        }
      }
    }
  }
  
  abstract class l
  {
    l() {}
    
    abstract void a(String paramString, int paramInt, agir.j paramj);
    
    abstract void eD(String paramString, int paramInt);
  }
  
  class m
    extends agir.l
  {
    private long Yw;
    private long Yx;
    private smq.l a = new agje(this);
    private String bHA;
    private String bHB;
    private String bHC;
    private String bHD;
    private String bHE;
    private String bHF;
    private String bHp;
    private String bHv;
    private String bHw;
    private String bHx;
    private String bHy;
    private String bHz;
    private agir.j c;
    private int cXk;
    private int cXl;
    private boolean cdA;
    private Bundle mBundle;
    
    private m(MessageRecord paramMessageRecord, int paramInt)
    {
      super();
      this.bHv = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
      this.bHw = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSha");
      this.bHx = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      this.bHy = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize");
      this.Yw = Long.parseLong(this.bHy);
      this.bHz = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
      this.bHA = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
      this.bHB = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
      this.bHC = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
      this.bHD = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
      this.bHE = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      this.bHp = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter begin filename " + this.bHx);
      this.cXk = paramInt;
    }
    
    /* Error */
    void a(String paramString, int paramInt, agir.j paramj)
    {
      // Byte code:
      //   0: aload_3
      //   1: ifnonnull +32 -> 33
      //   4: ldc 110
      //   6: iconst_1
      //   7: new 112	java/lang/StringBuilder
      //   10: dup
      //   11: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   14: ldc 164
      //   16: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   19: aload_0
      //   20: getfield 68	agir$m:bHx	Ljava/lang/String;
      //   23: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   32: return
      //   33: ldc 110
      //   35: iconst_1
      //   36: new 112	java/lang/StringBuilder
      //   39: dup
      //   40: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   43: ldc 168
      //   45: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: aload_0
      //   49: getfield 68	agir$m:bHx	Ljava/lang/String;
      //   52: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   61: ldc 170
      //   63: aload_0
      //   64: getfield 108	agir$m:bHp	Ljava/lang/String;
      //   67: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   70: ifeq +58 -> 128
      //   73: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   76: ifeq +36 -> 112
      //   79: ldc 110
      //   81: iconst_1
      //   82: new 112	java/lang/StringBuilder
      //   85: dup
      //   86: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   89: ldc 182
      //   91: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   94: aload_0
      //   95: getfield 68	agir$m:bHx	Ljava/lang/String;
      //   98: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   101: ldc 184
      //   103: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   109: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   112: aload_3
      //   113: aload_0
      //   114: getfield 80	agir$m:Yw	J
      //   117: iconst_0
      //   118: invokestatic 191	agir:j	(JZ)Ljava/lang/String;
      //   121: iconst_0
      //   122: invokeinterface 197 3 0
      //   127: return
      //   128: aload_0
      //   129: aload_3
      //   130: putfield 145	agir$m:c	Lagir$j;
      //   133: aload_0
      //   134: aload_1
      //   135: invokestatic 78	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   138: putfield 158	agir$m:Yx	J
      //   141: aload_0
      //   142: new 199	android/os/Bundle
      //   145: dup
      //   146: invokespecial 200	android/os/Bundle:<init>	()V
      //   149: putfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   152: aload_0
      //   153: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   156: ldc 52
      //   158: aload_0
      //   159: getfield 158	agir$m:Yx	J
      //   162: invokestatic 204	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   165: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   168: aload_0
      //   169: getfield 64	agir$m:bHw	Ljava/lang/String;
      //   172: ifnull +26 -> 198
      //   175: aload_0
      //   176: getfield 64	agir$m:bHw	Ljava/lang/String;
      //   179: invokevirtual 211	java/lang/String:isEmpty	()Z
      //   182: ifne +16 -> 198
      //   185: aload_0
      //   186: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   189: ldc 62
      //   191: aload_0
      //   192: getfield 64	agir$m:bHw	Ljava/lang/String;
      //   195: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   198: aload_0
      //   199: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   202: ldc 66
      //   204: aload_0
      //   205: getfield 68	agir$m:bHx	Ljava/lang/String;
      //   208: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   211: aload_0
      //   212: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   215: ldc 70
      //   217: aload_0
      //   218: getfield 72	agir$m:bHy	Ljava/lang/String;
      //   221: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   224: aload_0
      //   225: getfield 84	agir$m:bHz	Ljava/lang/String;
      //   228: invokestatic 217	ahav:mI	(Ljava/lang/String;)Z
      //   231: ifeq +16 -> 247
      //   234: aload_0
      //   235: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   238: ldc 82
      //   240: aload_0
      //   241: getfield 84	agir$m:bHz	Ljava/lang/String;
      //   244: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   247: aload_0
      //   248: getfield 88	agir$m:bHA	Ljava/lang/String;
      //   251: invokevirtual 211	java/lang/String:isEmpty	()Z
      //   254: ifne +16 -> 270
      //   257: aload_0
      //   258: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   261: ldc 86
      //   263: aload_0
      //   264: getfield 96	agir$m:bHC	Ljava/lang/String;
      //   267: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   270: aload_0
      //   271: getfield 92	agir$m:bHB	Ljava/lang/String;
      //   274: invokevirtual 211	java/lang/String:isEmpty	()Z
      //   277: ifne +16 -> 293
      //   280: aload_0
      //   281: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   284: ldc 90
      //   286: aload_0
      //   287: getfield 96	agir$m:bHC	Ljava/lang/String;
      //   290: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   293: aload_0
      //   294: getfield 96	agir$m:bHC	Ljava/lang/String;
      //   297: invokevirtual 211	java/lang/String:isEmpty	()Z
      //   300: ifne +16 -> 316
      //   303: aload_0
      //   304: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   307: ldc 94
      //   309: aload_0
      //   310: getfield 96	agir$m:bHC	Ljava/lang/String;
      //   313: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   316: iload_2
      //   317: ifne +165 -> 482
      //   320: aload_0
      //   321: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   324: ldc 219
      //   326: iconst_1
      //   327: invokestatic 222	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   330: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   333: aload_0
      //   334: getfield 60	agir$m:bHv	Ljava/lang/String;
      //   337: invokestatic 78	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   340: lstore 4
      //   342: aload_0
      //   343: getfield 104	agir$m:bHE	Ljava/lang/String;
      //   346: invokevirtual 211	java/lang/String:isEmpty	()Z
      //   349: ifeq +49 -> 398
      //   352: ldc 110
      //   354: iconst_1
      //   355: new 112	java/lang/StringBuilder
      //   358: dup
      //   359: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   362: ldc 224
      //   364: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   367: aload_0
      //   368: getfield 68	agir$m:bHx	Ljava/lang/String;
      //   371: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   374: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   377: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   380: aload_0
      //   381: getfield 145	agir$m:c	Lagir$j;
      //   384: aload_0
      //   385: getfield 80	agir$m:Yw	J
      //   388: iconst_1
      //   389: invokestatic 191	agir:j	(JZ)Ljava/lang/String;
      //   392: iconst_0
      //   393: invokeinterface 197 3 0
      //   398: aload_0
      //   399: getfield 100	agir$m:bHD	Ljava/lang/String;
      //   402: invokestatic 230	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   405: istore_2
      //   406: ldc 110
      //   408: iconst_1
      //   409: new 112	java/lang/StringBuilder
      //   412: dup
      //   413: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   416: ldc 232
      //   418: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   421: aload_0
      //   422: getfield 68	agir$m:bHx	Ljava/lang/String;
      //   425: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   428: ldc 234
      //   430: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   433: aload_0
      //   434: getfield 104	agir$m:bHE	Ljava/lang/String;
      //   437: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   440: ldc 236
      //   442: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   445: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   448: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   451: aload_0
      //   452: getfield 40	agir$m:this$0	Lagir;
      //   455: invokestatic 239	agir:a	(Lagir;)Lcom/tencent/mobileqq/app/QQAppInterface;
      //   458: lload 4
      //   460: iload_2
      //   461: aload_0
      //   462: getfield 104	agir$m:bHE	Ljava/lang/String;
      //   465: aload_0
      //   466: getfield 158	agir$m:Yx	J
      //   469: aload_0
      //   470: getfield 133	agir$m:cXk	I
      //   473: aconst_null
      //   474: aload_0
      //   475: getfield 50	agir$m:a	Lsmq$l;
      //   478: invokestatic 244	smq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JILjava/lang/String;JILandroid/os/Bundle;Lsmq$l;)V
      //   481: return
      //   482: iload_2
      //   483: sipush 3000
      //   486: if_icmpne +19 -> 505
      //   489: aload_0
      //   490: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   493: ldc 219
      //   495: iconst_2
      //   496: invokestatic 222	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   499: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   502: goto -169 -> 333
      //   505: iload_2
      //   506: iconst_1
      //   507: if_icmpne -174 -> 333
      //   510: aload_0
      //   511: getfield 148	agir$m:mBundle	Landroid/os/Bundle;
      //   514: ldc 219
      //   516: iconst_3
      //   517: invokestatic 222	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   520: invokevirtual 208	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   523: goto -190 -> 333
      //   526: astore_1
      //   527: ldc 110
      //   529: iconst_1
      //   530: new 112	java/lang/StringBuilder
      //   533: dup
      //   534: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   537: ldc 246
      //   539: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   542: aload_0
      //   543: getfield 60	agir$m:bHv	Ljava/lang/String;
      //   546: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   549: ldc 248
      //   551: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   554: aload_0
      //   555: getfield 68	agir$m:bHx	Ljava/lang/String;
      //   558: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   561: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   564: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   567: aload_0
      //   568: getfield 145	agir$m:c	Lagir$j;
      //   571: aload_0
      //   572: getfield 80	agir$m:Yw	J
      //   575: iconst_0
      //   576: invokestatic 191	agir:j	(JZ)Ljava/lang/String;
      //   579: iconst_0
      //   580: invokeinterface 197 3 0
      //   585: return
      //   586: astore_1
      //   587: ldc 110
      //   589: iconst_1
      //   590: new 112	java/lang/StringBuilder
      //   593: dup
      //   594: invokespecial 115	java/lang/StringBuilder:<init>	()V
      //   597: ldc 250
      //   599: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   602: iconst_0
      //   603: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   606: ldc 248
      //   608: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   611: aload_0
      //   612: getfield 68	agir$m:bHx	Ljava/lang/String;
      //   615: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   618: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   621: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   624: aload_0
      //   625: getfield 145	agir$m:c	Lagir$j;
      //   628: aload_0
      //   629: getfield 80	agir$m:Yw	J
      //   632: iconst_0
      //   633: invokestatic 191	agir:j	(JZ)Ljava/lang/String;
      //   636: iconst_0
      //   637: invokeinterface 197 3 0
      //   642: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	643	0	this	m
      //   0	643	1	paramString	String
      //   0	643	2	paramInt	int
      //   0	643	3	paramj	agir.j
      //   340	119	4	l	long
      // Exception table:
      //   from	to	target	type
      //   333	342	526	java/lang/NumberFormatException
      //   398	406	586	java/lang/NumberFormatException
    }
    
    void eD(String paramString, int paramInt)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter stopped filename " + this.bHx);
      this.cdA = true;
    }
  }
  
  class n
    extends agir.l
  {
    private long Yw;
    private long Yx;
    private apfx.c a = new agjf(this);
    private String bHx;
    private String bHz;
    private agir.j jdField_c_of_type_Agir$j;
    private UUID jdField_c_of_type_JavaUtilUUID;
    private boolean cdA;
    private Bundle mBundle;
    
    private n(String paramString1, String paramString2)
    {
      super();
      this.bHx = paramString1;
      this.bHz = paramString2;
      this.mBundle = new Bundle();
      this.mBundle.putString("_m_ForwardFileName", this.bHx);
      this.mBundle.putString("_m_ForwardFilePath", this.bHz);
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter begin filename " + this.bHx);
    }
    
    void a(String paramString, int paramInt, agir.j paramj)
    {
      if (paramj == null)
      {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run but callback is null filename " + this.bHx);
        return;
      }
      this.jdField_c_of_type_Agir$j = paramj;
      this.Yx = Long.parseLong(paramString);
      this.mBundle.putString("_m_ForwardReceiverUin", String.valueOf(this.Yx));
      this.jdField_c_of_type_JavaUtilUUID = UUID.randomUUID();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run WorkerId[" + this.jdField_c_of_type_JavaUtilUUID + "] filename " + this.bHx);
      apfx.a().a(this.jdField_c_of_type_JavaUtilUUID, this.Yx, this.bHx, this.bHz, this.a);
    }
    
    void eD(String paramString, int paramInt)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter stopped WorkerId[" + this.jdField_c_of_type_JavaUtilUUID + "] filename " + this.bHx);
      this.cdA = true;
      apfx.a().c(this.jdField_c_of_type_JavaUtilUUID, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agir
 * JD-Core Version:    0.7.0.1
 */