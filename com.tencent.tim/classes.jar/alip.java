import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloadStrategy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public final class alip
  implements Handler.Callback, Manager
{
  private final alip.a jdField_a_of_type_Alip$a = new alip.a();
  private alip.b jdField_a_of_type_Alip$b;
  private final auru jdField_a_of_type_Auru;
  private final alip.a b = new alip.a();
  private final alip.a c = new alip.a();
  private boolean cxo;
  private QQAppInterface mApp;
  private boolean mDestroy;
  
  public alip(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Auru = new auru(ThreadManager.getSubThreadLooper(), this);
    a(new PTTPreDownloadStrategy(this.mApp, this.jdField_a_of_type_Auru));
  }
  
  private void NO(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "handleAddrReady:" + paramBoolean);
    }
    this.cxo = paramBoolean;
    if (this.cxo)
    {
      a(this.jdField_a_of_type_Alip$a);
      a(this.b);
      a(this.c);
    }
  }
  
  private alip.a a(MessageForPtt paramMessageForPtt)
  {
    alip.a locala = null;
    if (paramMessageForPtt.istroop == 0) {
      locala = this.jdField_a_of_type_Alip$a;
    }
    do
    {
      return locala;
      if (paramMessageForPtt.istroop == 1) {
        return this.b;
      }
    } while (paramMessageForPtt.istroop != 3000);
    return this.c;
  }
  
  public static alip a(QQAppInterface paramQQAppInterface)
  {
    return (alip)paramQQAppInterface.getManager(127);
  }
  
  private void a(alip.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "cancelCache");
    }
    int i = 0;
    if (i < parama.yI.size())
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)parama.yI.get(i);
      if (this.jdField_a_of_type_Alip$b.d(localMessageForPtt)) {
        if (localMessageForPtt.extFlag != -1L) {
          break label120;
        }
      }
      label120:
      for (long l = localMessageForPtt.extFlag;; l = (0x3 ^ 0xFFFFFFFF) & localMessageForPtt.extFlag)
      {
        localMessageForPtt.extFlag = l;
        localMessageForPtt.serial();
        this.mApp.b().c(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
        i += 1;
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, MessageForPtt paramMessageForPtt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "handleDownloadFinish uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", sucess:" + paramBoolean);
    }
    if ((paramMessageForPtt.extFlag > 0L) && ((paramMessageForPtt.extFlag & 1L) > 0L))
    {
      if (!paramBoolean) {
        break label129;
      }
      this.jdField_a_of_type_Alip$b.d(paramMessageForPtt);
    }
    label129:
    while (((paramMessageForPtt.extFlag & 0x2) != 0L) || (!this.jdField_a_of_type_Alip$b.a(paramMessageForPtt, 3)))
    {
      paramMessageForPtt = a(paramMessageForPtt);
      if (paramMessageForPtt != null)
      {
        paramMessageForPtt.duB -= 1;
        if (paramMessageForPtt.duB < 0) {
          paramMessageForPtt.duB = 0;
        }
        a(paramMessageForPtt);
      }
      return;
    }
    if (paramMessageForPtt.extFlag == -1L) {}
    for (long l = paramMessageForPtt.extFlag;; l = (0x3 ^ 0xFFFFFFFF) & paramMessageForPtt.extFlag)
    {
      paramMessageForPtt.extFlag = l;
      paramMessageForPtt.serial();
      this.mApp.b().c(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      break;
    }
  }
  
  private boolean a(alip.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "startDownloadCache");
    }
    boolean bool = false;
    for (;;)
    {
      if ((parama.duB < 3) && (parama.yI.size() > 0))
      {
        MessageForPtt localMessageForPtt = (MessageForPtt)parama.yI.get(0);
        if (this.jdField_a_of_type_Alip$b.c(localMessageForPtt))
        {
          long l;
          if (!k(localMessageForPtt)) {
            if (this.jdField_a_of_type_Alip$b.d(localMessageForPtt))
            {
              if (localMessageForPtt.extFlag != -1L) {
                break label157;
              }
              l = localMessageForPtt.extFlag;
              label102:
              localMessageForPtt.extFlag = l;
            }
          }
          try
          {
            localMessageForPtt.serial();
            label113:
            this.mApp.b().c(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
            parama.yI.remove(0);
            for (bool = false;; bool = true)
            {
              break;
              label157:
              l = (0x3 ^ 0xFFFFFFFF) & localMessageForPtt.extFlag;
              break label102;
              parama.duB += 1;
              parama.yI.remove(0);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            break label113;
          }
        }
      }
    }
    return bool;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.url == null) {}
    int i;
    do
    {
      return 2005;
      if ((paramMessageForPtt.url.startsWith(acbn.SDCARD_ROOT)) && (aqhq.fileExists(paramMessageForPtt.getLocalFilePath()))) {
        return 2003;
      }
      i = paramQQAppInterface.a().c(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
    } while ((i == -1) && (paramMessageForPtt.fileSize == -4L));
    return i;
  }
  
  private boolean h(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.istroop == 1) && (this.mApp.cs(paramMessageForPtt.frienduin) != 1)) {}
    int i;
    alip.a locala;
    label298:
    label363:
    do
    {
      for (;;)
      {
        return true;
        if (!((HotChatManager)this.mApp.getManager(60)).kj(paramMessageForPtt.frienduin))
        {
          i = b(this.mApp, paramMessageForPtt);
          if (QLog.isColorLevel()) {
            QLog.d("PTTPreDownloader", 2, "handleReceivedPTT uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", status:" + i);
          }
          if ((i == 0) || (i == -1))
          {
            locala = a(paramMessageForPtt);
            if (locala != null)
            {
              if (!this.cxo) {
                break;
              }
              long l;
              if ((locala.duB < 3) && (this.jdField_a_of_type_Alip$b.c(paramMessageForPtt))) {
                if (!k(paramMessageForPtt)) {
                  if (this.jdField_a_of_type_Alip$b.d(paramMessageForPtt))
                  {
                    if (paramMessageForPtt.extFlag != -1L) {
                      break label298;
                    }
                    l = paramMessageForPtt.extFlag;
                    paramMessageForPtt.extFlag = l;
                    paramMessageForPtt.serial();
                    this.mApp.b().c(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
                  }
                }
              }
              for (;;)
              {
                if (paramMessageForPtt.voiceChangeFlag != 1) {
                  break label363;
                }
                anot.a(this.mApp, "CliOper", "", "", "changevoice", "0X8006F7D", 0, 0, "" + paramMessageForPtt.istroop, "", "", "");
                return true;
                l = (0x3 ^ 0xFFFFFFFF) & paramMessageForPtt.extFlag;
                break;
                locala.duB += 1;
                continue;
                i = locala.yI.size();
                locala.getClass();
                if (i + 1 < 99) {
                  locala.yI.add(paramMessageForPtt);
                }
              }
            }
          }
        }
      }
      i = locala.yI.size();
      locala.getClass();
    } while (i + 1 >= 99);
    locala.yI.add(paramMessageForPtt);
    return true;
  }
  
  private boolean i(MessageForPtt paramMessageForPtt)
  {
    return true;
  }
  
  private boolean j(MessageForPtt paramMessageForPtt)
  {
    long l = 2L;
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "handleViewPTT uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq);
    }
    if (this.jdField_a_of_type_Alip$b.a(paramMessageForPtt, 1)) {
      if (paramMessageForPtt.extFlag != -1L) {
        break label113;
      }
    }
    for (;;)
    {
      paramMessageForPtt.extFlag = l;
      paramMessageForPtt.serial();
      this.mApp.b().c(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      return true;
      label113:
      l = 0x2 | paramMessageForPtt.extFlag;
    }
  }
  
  private boolean k(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = false;
    int i = b(this.mApp, paramMessageForPtt);
    boolean bool1;
    aool localaool;
    if (i != 0)
    {
      bool1 = bool2;
      if (i != -1) {}
    }
    else
    {
      localaool = new aool();
      localaool.mSelfUin = this.mApp.getAccount();
      localaool.mPeerUin = paramMessageForPtt.frienduin;
      localaool.mUinType = paramMessageForPtt.istroop;
      localaool.mFileType = 2;
      localaool.mUniseq = paramMessageForPtt.uniseq;
      localaool.cNy = false;
      localaool.cmo = paramMessageForPtt.urlAtServer;
      localaool.clR = paramMessageForPtt.getLocalFilePath();
      if ((!paramMessageForPtt.isSendFromOtherTerminal()) && (!paramMessageForPtt.isSend())) {
        break label259;
      }
      bool1 = true;
    }
    for (;;)
    {
      localaool.cNz = bool1;
      localaool.mMd5 = paramMessageForPtt.md5;
      localaool.apQ = paramMessageForPtt.groupFileID;
      localaool.clM = paramMessageForPtt.groupFileKeyStr;
      localaool.dQF = paramMessageForPtt.subVersion;
      localaool.F = paramMessageForPtt;
      localaool.dpB = 1;
      localaool.en = new aool.e(6, 0);
      try
      {
        bool1 = this.mApp.a().a(localaool);
        if (QLog.isDevelopLevel()) {
          QLog.d("PTTPreDownloader", 4, "startDownload uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", doIt:" + bool1);
        }
        return bool1;
        label259:
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("PTTPreDownloader", 2, "startDownload  exception=" + localException.getMessage());
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public void a(alip.b paramb)
  {
    this.jdField_a_of_type_Alip$b = paramb;
  }
  
  public void a(boolean paramBoolean, int paramInt, aool.e parame, MessageForPtt paramMessageForPtt)
  {
    parame = this.jdField_a_of_type_Auru;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      parame.obtainMessage(2, i, paramInt, paramMessageForPtt).sendToTarget();
      return;
    }
  }
  
  public void cn(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    if (!paramBoolean1) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "onAddrProviderReady delay:" + paramBoolean2);
    }
    if (paramBoolean2)
    {
      localObject = this.jdField_a_of_type_Auru;
      if (paramBoolean1) {}
      for (;;)
      {
        localObject = ((auru)localObject).obtainMessage(3, i, 0);
        this.jdField_a_of_type_Auru.sendMessageDelayed((Message)localObject, 30000L);
        return;
        i = 0;
      }
    }
    this.jdField_a_of_type_Auru.removeMessages(3);
    Object localObject = this.jdField_a_of_type_Auru;
    if (paramBoolean1) {}
    for (i = j;; i = 0)
    {
      ((auru)localObject).obtainMessage(3, i, 0).sendToTarget();
      return;
    }
  }
  
  public boolean e(MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_Auru.obtainMessage(0, paramMessageForPtt).sendToTarget();
    return true;
  }
  
  public boolean f(MessageForPtt paramMessageForPtt)
  {
    long l = 2L;
    int j = 0;
    int i;
    if (paramMessageForPtt.isSendFromLocal()) {
      i = j;
    }
    while (i == 0)
    {
      return true;
      i = j;
      if (paramMessageForPtt.getPttStreamFlag() != 10001)
      {
        i = j;
        if (paramMessageForPtt.extFlag != -1L)
        {
          i = j;
          if ((paramMessageForPtt.extFlag & 0x2) <= 0L)
          {
            i = j;
            if (paramMessageForPtt.fileSize > 0L) {
              i = 1;
            }
          }
        }
      }
    }
    if (paramMessageForPtt.extFlag == -1L) {}
    for (;;)
    {
      paramMessageForPtt.extFlag = l;
      this.jdField_a_of_type_Auru.obtainMessage(4, paramMessageForPtt).sendToTarget();
      return true;
      l = 0x2 | paramMessageForPtt.extFlag;
    }
  }
  
  public boolean g(MessageForPtt paramMessageForPtt)
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.mDestroy) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      h((MessageForPtt)paramMessage.obj);
      return true;
    case 1: 
      i((MessageForPtt)paramMessage.obj);
      return true;
    case 3: 
      if (paramMessage.arg1 != 0) {
        bool = true;
      }
      NO(bool);
      return true;
    case 2: 
      if (paramMessage.arg1 != 0) {}
      for (bool = true;; bool = false)
      {
        a(bool, paramMessage.arg2, (MessageForPtt)paramMessage.obj);
        return true;
      }
    }
    j((MessageForPtt)paramMessage.obj);
    return true;
  }
  
  public void onDestroy()
  {
    this.mDestroy = true;
    this.jdField_a_of_type_Auru.removeMessages(0);
    this.jdField_a_of_type_Auru.removeMessages(1);
    this.jdField_a_of_type_Auru.removeMessages(2);
    this.jdField_a_of_type_Auru.removeMessages(3);
    this.jdField_a_of_type_Auru.removeMessages(4);
    a(this.jdField_a_of_type_Alip$a);
    a(this.b);
    a(this.c);
    this.jdField_a_of_type_Alip$b.onDestroy();
  }
  
  static class a
  {
    public int duB;
    public final int duC = 99;
    public final ArrayList<MessageForPtt> yI = new ArrayList(100);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(MessageForPtt paramMessageForPtt, int paramInt);
    
    public abstract boolean c(MessageForPtt paramMessageForPtt);
    
    public abstract boolean d(MessageForPtt paramMessageForPtt);
    
    public abstract void onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alip
 * JD-Core Version:    0.7.0.1
 */