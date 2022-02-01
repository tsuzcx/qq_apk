import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.OnlineFileSessionWorker.1;
import com.tencent.tim.filemanager.core.OnlineFileSessionWorker.2;
import com.tencent.tim.filemanager.core.OnlineFileSessionWorker.3;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class atul
{
  private Timer E;
  private Timer F;
  long Ib = 0L;
  long YW = 0L;
  long YX = 0L;
  long YY = 0L;
  atul.ak jdField_a_of_type_Atul$ak = new atul.ak();
  private atul.d jdField_a_of_type_Atul$d;
  public QQAppInterface app;
  public FileManagerEntity c = null;
  private Object dI = new Object();
  private Object dJ = new Object();
  long sessionId;
  
  public atul(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.app = paramQQAppInterface;
    this.sessionId = paramLong;
    this.jdField_a_of_type_Atul$d = new atul.d();
  }
  
  private void A(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.c == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] setCurStateOfEntityTo can not find entity . state change :(" + this.jdField_a_of_type_Atul$d.vh() + "-> StateEnd)");
      this.jdField_a_of_type_Atul$d = new atul.l();
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state:" + this.jdField_a_of_type_Atul$d.vh() + " curstate of entity change: (opType:" + this.c.nOpType + " status:" + this.c.status + ") -> (opType:" + paramInt1 + "  status:" + paramInt2 + ") savedb=" + paramBoolean);
      this.c.nOpType = paramInt1;
      this.c.status = paramInt2;
    } while (!paramBoolean);
    this.app.a().u(this.c);
  }
  
  private boolean aV(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    switch (paramInt1)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] error optype:" + paramInt1);
    }
    for (;;)
    {
      if (!bool)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] goto next state failed. state change :(" + this.jdField_a_of_type_Atul$d.vh() + "-> StateEnd)");
        this.jdField_a_of_type_Atul$d = new atul.l();
      }
      return bool;
      switch (paramInt2)
      {
      default: 
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] no status. when GOTO_UPLOAD:" + paramInt2);
        break;
      case 9: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateCancelUploadWhenRecv)");
        this.jdField_a_of_type_Atul$d = new atul.g();
        bool = true;
        break;
      case 10: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateChangeToOffFailedWhenRecv)");
        this.jdField_a_of_type_Atul$d = new atul.i();
        bool = true;
        break;
      case 11: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateLocalFailedWhenRecv)");
        this.jdField_a_of_type_Atul$d = new atul.s();
        bool = true;
        break;
      case 12: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateExcepInvalidWhenRecv)");
        this.jdField_a_of_type_Atul$d = new atul.o();
        bool = true;
        break;
      case 14: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateUploadingWhenRecv)");
        this.jdField_a_of_type_Atul$d = new atul.af();
        bool = true;
        break;
      case 15: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateWaitResultWhenRecv)");
        this.jdField_a_of_type_Atul$d = new atul.aj();
        bool = true;
        break;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 13: 
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when GOTO_UPLOAD:" + paramInt2);
        continue;
        switch (paramInt2)
        {
        default: 
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] no status. when STOP_UPLOAD:" + paramInt2);
          break;
        case 9: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateCancelUploadWhenPause)");
          this.jdField_a_of_type_Atul$d = new atul.f();
          bool = true;
          break;
        case 10: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateChangeToOffFailedWhenPause)");
          this.jdField_a_of_type_Atul$d = new atul.h();
          bool = true;
          break;
        case 11: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateLocalFailedWhenPause)");
          this.jdField_a_of_type_Atul$d = new atul.r();
          bool = true;
          break;
        case 12: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateExcepInvalidWhenPause)");
          this.jdField_a_of_type_Atul$d = new atul.n();
          bool = true;
          break;
        case 14: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateUploadingWhenPause)");
          this.jdField_a_of_type_Atul$d = new atul.ae();
          bool = true;
          break;
        case 15: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateWaitResultWhenPause)");
          this.jdField_a_of_type_Atul$d = new atul.ai();
          bool = true;
          break;
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 13: 
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when STOP_UPLOAD:" + paramInt2);
          continue;
          switch (paramInt2)
          {
          default: 
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] no status. when BE_PC_HANDLED:" + paramInt2);
            break;
          case 5: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateAcceptByPC)");
            this.jdField_a_of_type_Atul$d = new atul.a();
            bool = true;
            break;
          case 6: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateRefuseByPC)");
            this.jdField_a_of_type_Atul$d = new atul.t();
            bool = true;
            break;
          case 7: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateSaveToWeiYunByPC)");
            this.jdField_a_of_type_Atul$d = new atul.x();
            bool = true;
            break;
          case 8: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateSenderCancelSend)");
            this.jdField_a_of_type_Atul$d = new atul.aa();
            bool = true;
            break;
          case 9: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateCancelUploadWhenChangeToOff)");
            this.jdField_a_of_type_Atul$d = new atul.e();
            bool = true;
            break;
          case 12: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateExcepInvalidWhenChangeToOff)");
            this.jdField_a_of_type_Atul$d = new atul.m();
            bool = true;
            break;
          case 13: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateUploadoneWhenChangeToOff)");
            this.jdField_a_of_type_Atul$d = new atul.ag();
            bool = true;
            break;
          case 14: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateUploadingWhenChangeToOff)");
            this.jdField_a_of_type_Atul$d = new atul.ad();
            bool = true;
            break;
          case 11: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateLocalFailedWhenChangeToOff)");
            this.jdField_a_of_type_Atul$d = new atul.q();
            bool = true;
            break;
          case 4: 
          case 10: 
          case 15: 
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when BE_PC_HANDLED:" + paramInt2);
            continue;
            switch (paramInt2)
            {
            default: 
              QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] no status. when TYPE_UNKNOW:" + paramInt2);
              break;
            case 4: 
              QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateRequest)");
              this.jdField_a_of_type_Atul$d = new atul.w();
              bool = true;
              break;
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
              QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when TYPE_UNKNOW:" + paramInt2);
              continue;
              QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateGotoOffFileProcess)");
              this.jdField_a_of_type_Atul$d = new atul.p();
              bool = true;
              continue;
              switch (paramInt2)
              {
              default: 
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when BE_PC_HANDLED_ON_RECV2OFF_FAILED:" + paramInt2);
                break;
              case 5: 
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateAcceptByPCWhenToOffFailed)");
                this.jdField_a_of_type_Atul$d = new atul.c();
                bool = true;
                break;
              case 6: 
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateRefuseByPCWhenToOffFailed)");
                this.jdField_a_of_type_Atul$d = new atul.v();
                bool = true;
                break;
              case 7: 
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
                this.jdField_a_of_type_Atul$d = new atul.z();
                bool = true;
                break;
              case 8: 
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Atul$d.vh() + "->StateSenderCancelSendWhenToOffFailed)");
                this.jdField_a_of_type_Atul$d = new atul.ac();
                bool = true;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
  }
  
  private void dhP()
  {
    if (this.c != null)
    {
      if (0L != this.c.lastTime) {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state :" + this.jdField_a_of_type_Atul$d.vh() + " initForMakeProgress. but had init. lastTime =" + this.c.lastTime);
      }
      this.c.lastTime = System.currentTimeMillis();
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state :" + this.jdField_a_of_type_Atul$d.vh() + " initForMakeProgress lastTime =" + this.c.lastTime);
    }
  }
  
  private void ib(int paramInt1, int paramInt2)
  {
    if (this.c == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] setStateToDatabase can not find entity . state change :(" + this.jdField_a_of_type_Atul$d.vh() + "-> StateEnd)");
      this.jdField_a_of_type_Atul$d = new atul.l();
      return;
    }
    FileManagerEntity localFileManagerEntity = this.c.clone();
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] current status(opType:" + localFileManagerEntity.nOpType + " status:" + localFileManagerEntity.status + "). saveto db(opType:" + paramInt1 + "  status:" + paramInt2 + ")");
    if (-2 != paramInt1) {
      localFileManagerEntity.nOpType = paramInt1;
    }
    if (-2 != paramInt2) {
      localFileManagerEntity.status = paramInt2;
    }
    this.app.a().u(localFileManagerEntity);
  }
  
  private void ic(int paramInt1, int paramInt2)
  {
    if (this.c != null)
    {
      this.c.nOpType = paramInt1;
      this.c.status = paramInt2;
    }
  }
  
  private void id(int paramInt1, int paramInt2)
  {
    if (this.c == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] setDBStateOfEntityTo can not find entity . state change :(" + this.jdField_a_of_type_Atul$d.vh() + "-> StateEnd)");
      this.jdField_a_of_type_Atul$d = new atul.l();
      return;
    }
    FileManagerEntity localFileManagerEntity = this.c.clone();
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state:" + this.jdField_a_of_type_Atul$d.vh() + " curstate: (opType:" + this.c.nOpType + " status:" + this.c.status + ").  save state:(opType:" + paramInt1 + "  status:" + paramInt2 + ") to DB");
    localFileManagerEntity.nOpType = paramInt1;
    localFileManagerEntity.status = paramInt2;
    this.app.a().u(localFileManagerEntity);
  }
  
  public void Jk(boolean paramBoolean)
  {
    atul.ak localak;
    if (paramBoolean)
    {
      localak = this.jdField_a_of_type_Atul$ak;
      localak.cXI += 1;
      dhQ();
    }
    for (;;)
    {
      this.jdField_a_of_type_Atul$d.Jk(paramBoolean);
      this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
      return;
      localak = this.jdField_a_of_type_Atul$ak;
      localak.cXJ += 1;
    }
  }
  
  public void Jl(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitAskUpProgressResultTimer. when onAskSenderUpProgressResult = false");
      dhS();
    }
    this.jdField_a_of_type_Atul$d.Jl(paramBoolean);
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  void Jm(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atul$ak.ceg)
    {
      this.jdField_a_of_type_Atul$ak.ceg = false;
      this.jdField_a_of_type_Atul$ak.cee = false;
      this.jdField_a_of_type_Atul$ak.cef = false;
      if (paramBoolean) {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.sessionId + "]  internalRecvOnlineFileOver.recv success!!");
      }
    }
    else
    {
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.sessionId + "]  internalRecvOnlineFileOver.recv failed!!");
  }
  
  public void Ob(int paramInt)
  {
    this.jdField_a_of_type_Atul$d.Ob(paramInt);
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
    dic();
  }
  
  public void Oc(int paramInt)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onNetworkChanged");
    stopAllTimer();
    this.jdField_a_of_type_Atul$d.Oe(1);
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  void Od(int paramInt)
  {
    if (1 == paramInt) {
      if (this.jdField_a_of_type_Atul$ak.ceg)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " recv olfile is going on. but the resp of sender is error");
        this.jdField_a_of_type_Atul$ak.cee = true;
      }
    }
    while ((2 != paramInt) || (!this.jdField_a_of_type_Atul$ak.ceg)) {
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " recv olfile is going on. but the resp of ask progress is error");
    this.jdField_a_of_type_Atul$ak.cef = true;
  }
  
  void aN(float paramFloat)
  {
    ThreadManager.post(new OnlineFileSessionWorker.3(this, paramFloat), 8, null, true);
  }
  
  boolean alG()
  {
    if (this.c == null) {}
    do
    {
      return false;
      if (this.c.nOlSenderProgress != 0) {
        return true;
      }
    } while (this.c.fOlRecvSpeed <= 1.0E-007F);
    return true;
  }
  
  boolean alH()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.c != null)
    {
      bool1 = bool2;
      if (-1 != this.c.nOlSenderProgress) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean alI()
  {
    return this.jdField_a_of_type_Atul$d.cec;
  }
  
  public boolean alJ()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " user recv online file....!!");
    boolean bool = this.jdField_a_of_type_Atul$d.alJ();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
    return bool;
  }
  
  boolean alK()
  {
    return (!this.jdField_a_of_type_Atul$ak.ceg) || ((this.jdField_a_of_type_Atul$ak.cee) && (this.jdField_a_of_type_Atul$ak.cef));
  }
  
  void au(long paramLong, String paramString)
  {
    int i;
    Object localObject;
    if ((paramLong != 0L) && (paramLong != this.Ib))
    {
      List localList = this.app.b().k(paramString, 0);
      if ((localList == null) || (localList.isEmpty())) {
        break label235;
      }
      i = localList.size() - 1;
      if (i < 0) {
        break label235;
      }
      localObject = (MessageRecord)localList.get(i);
      if (aqiu.mt(((MessageRecord)localObject).issend)) {
        break label214;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (!((MessageRecord)localObject).isread) {
          break label229;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] sendMsgReadedReport curFriendUin is " + paramString + ", shmsgseq  is " + paramLong);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(new Pair(Long.valueOf(paramString), Long.valueOf(paramLong)));
          ((tob)this.app.a().a("c2c_processor")).cL((ArrayList)localObject);
          this.Ib = paramLong;
        }
        return;
        label214:
        i -= 1;
        break;
        i = 1;
        continue;
        label229:
        i = 0;
      }
      label235:
      localObject = null;
    }
  }
  
  public boolean b(int paramInt, String paramString, long paramLong)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderUploadCompleted");
    stopAllTimer();
    boolean bool = this.jdField_a_of_type_Atul$d.b(paramInt, paramString, paramLong);
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
    return bool;
  }
  
  boolean b(boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    if (this.F == null)
    {
      if (this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]. askUpProgress entity is null");
        paramBoolean = bool;
      }
      do
      {
        do
        {
          return paramBoolean;
          if ((!paramBoolean) || (this.c.nOlSenderProgress == 0)) {}
          paramBoolean = bool;
        } while (1 == 0);
        bool = this.app.a().q(this.c.peerUin, this.c.nOLfileSessionId);
        this.YW += 1L;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Atul$d.vh() + " ask upload progress isSuccess = " + bool + ". askUpProgressCount=" + this.YW);
        paramBoolean = bool;
      } while (!bool);
      jv(paramLong);
      return bool;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]. askUpProgress is going on. return");
    return false;
  }
  
  public void ct(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Atul$d.ct(paramInt, paramString);
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  void dhQ()
  {
    long l = 30000L;
    if (ahav.amK()) {
      l = 50000L;
    }
    synchronized (this.dI)
    {
      if (this.E != null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Atul$d.vh() + " failure to startWaitSenderReplayOnRecvTimer ant it is runing");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Atul$d.vh() + " startWaitSenderReplayOnRecvTimer. outTimerInterval=" + l);
      this.E = new Timer();
      this.E.schedule(new OnlineFileSessionWorker.1(this), l);
      return;
    }
  }
  
  public void dhR()
  {
    synchronized (this.dI)
    {
      if (this.E != null)
      {
        this.E.cancel();
        this.E = null;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitSenderReplayOnRecvTimer");
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitSenderReplayOnRecvTimer.but timer had stop");
    }
  }
  
  public void dhS()
  {
    synchronized (this.dJ)
    {
      if (this.F != null)
      {
        this.F.cancel();
        this.F = null;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitAskUpProgressResultTimer");
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitAskUpProgressResultTimer.but timer had stop");
    }
  }
  
  public void dhT()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderCancelUpload");
    stopAllTimer();
    this.jdField_a_of_type_Atul$d.dhT();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public void dhU()
  {
    this.jdField_a_of_type_Atul$d.dhU();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public void dhV()
  {
    this.jdField_a_of_type_Atul$d.dhV();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public void dhW()
  {
    this.jdField_a_of_type_Atul$d.did();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public void dhX()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitSenderReplayOnRecvTimer. stopWaitAskUpProgressResultTimer. when onSenderReplayComeOnRecv");
    dhR();
    dhS();
    this.jdField_a_of_type_Atul$d.dhX();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public void dhY()
  {
    this.jdField_a_of_type_Atul$d.dhY();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public void dhZ()
  {
    if (this.c == null) {}
    long l;
    do
    {
      return;
      l = anaz.gQ();
    } while ((this.c.getCloudType() != 0) || (l - this.c.srvTime <= 172800L));
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state :" + this.jdField_a_of_type_Atul$d.vh() + " is too long session and invaild!!!! invaild time=" + 172800L);
    this.jdField_a_of_type_Atul$d.die();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public void dia()
  {
    this.jdField_a_of_type_Atul$d.dia();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public void dib()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitAskUpProgressResultTimer. when onAskUpProgressAndSessionInvaid");
    dhS();
    this.jdField_a_of_type_Atul$d.dib();
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  void dic()
  {
    if (this.c != null)
    {
      if ((5 == this.c.status) || (6 == this.c.status) || (7 == this.c.status))
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " checkAndDeleteRecordFromFM mEntity.nOpType = " + this.c.nOpType);
        this.c.bDelInFM = true;
        this.app.a().b(this.c, false);
        this.app.a().b(true, 3, null);
      }
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[]  state:" + this.jdField_a_of_type_Atul$d.vh() + " checkAndDeleteRecordFromFM. mEntity = null");
  }
  
  public void ie(int paramInt1, int paramInt2)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stopWaitAskUpProgressResultTimer. stopWaitSenderReplayOnRecvTimer. when onSenderUploadProgressNotify");
    dhS();
    dhR();
    this.jdField_a_of_type_Atul$d.ie(paramInt1, paramInt2);
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  void jv(long paramLong)
  {
    long l = paramLong;
    if (0L == paramLong)
    {
      l = 30000L;
      if (ahav.amK()) {
        l = 50000L;
      }
    }
    synchronized (this.dJ)
    {
      if (this.F != null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Atul$d.vh() + " failure to startWaitAskUpProgressResultTimer ant it is runing");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Atul$d.vh() + " startWaitAskUpProgressResultTimer. outTimerInterval=" + l);
      this.F = new Timer();
      this.F.schedule(new OnlineFileSessionWorker.2(this), l);
      return;
    }
  }
  
  public void jw(long paramLong)
  {
    this.jdField_a_of_type_Atul$d.jw(paramLong);
    this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
  }
  
  public boolean m(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] init failed. state change :(" + this.jdField_a_of_type_Atul$d.vh() + "-> StateEnd)");
      this.jdField_a_of_type_Atul$d = new atul.l();
      return false;
    }
    this.c = paramFileManagerEntity;
    boolean bool = aV(this.c.nOpType, this.c.status);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] init state to:" + this.jdField_a_of_type_Atul$d.vh());
    return bool;
  }
  
  public void stop()
  {
    if ((this.jdField_a_of_type_Atul$d != null) && (this.c != null))
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " stop worker...");
      stopAllTimer();
      this.jdField_a_of_type_Atul$d.onStop();
      this.c = null;
      this.sessionId = 0L;
      this.jdField_a_of_type_Atul$d = this.jdField_a_of_type_Atul$d.a();
    }
  }
  
  void stopAllTimer()
  {
    dhR();
    dhS();
  }
  
  boolean t(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Atul$ak.ceg) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " internalRecvOnlineFile. recv is going on, why?? ");
    }
    boolean bool = this.app.a().p(paramString, paramLong);
    if (!bool)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " internalRecvOnlineFile. recv cmd send failed.... ");
      paramString = this.jdField_a_of_type_Atul$ak;
      paramString.cXJ += 1;
    }
    do
    {
      return bool;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " internalRecvOnlineFile. recv cmd send success, and will ask progress .... ");
      this.jdField_a_of_type_Atul$ak.ceg = true;
      this.jdField_a_of_type_Atul$ak.cee = false;
      this.jdField_a_of_type_Atul$ak.cef = false;
    } while (b(true, 0L));
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Atul$d.vh() + " internalRecvOnlineFile. ask progress failed.... ");
    Od(2);
    return bool;
  }
  
  class a
    extends atul.l
  {
    public a()
    {
      super();
    }
    
    protected String vh()
    {
      return "StateAcceptByPC";
    }
  }
  
  class aa
    extends atul.l
  {
    public aa()
    {
      super();
    }
    
    protected String vh()
    {
      return "StateSenderCancelSend";
    }
  }
  
  class ab
    extends atul.d
  {
    public ab()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 8);
      atul.c(atul.this, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSend)");
      this.b = new atul.aa(atul.this);
    }
    
    protected String vh()
    {
      return "StateSenderCancelSendWhenPause";
    }
  }
  
  class ac
    extends atul.d
  {
    public ac()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 8);
      atul.c(atul.this, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSend)");
      this.b = new atul.aa(atul.this);
    }
    
    protected String vh()
    {
      return "StateSenderCancelSendWhenToOffFailed";
    }
  }
  
  class ad
    extends atul.d
  {
    public ad()
    {
      super();
    }
    
    protected boolean alJ()
    {
      if (mq("onRecvOnLineFile")) {
        return false;
      }
      atul.a(atul.this, 9, 11);
      atul.a(atul.this, 9, 14, false);
      IR("StateUploadingWhenRecv");
      this.b = new atul.af(atul.this);
      return true;
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 11, 13);
      atul.c(atul.this, 11, 13);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenChangeToOff)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.ag(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 12);
      atul.c(atul.this, 11, 12);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenChangeToOff");
      this.b = new atul.m(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 9);
      atul.c(atul.this, 11, 9);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenRecv)");
      this.b = new atul.g(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
    }
    
    protected void jw(long paramLong)
    {
      jx(paramLong);
    }
    
    protected void onStop() {}
    
    protected String vh()
    {
      return "StateUploadingWhenChangeToOff";
    }
  }
  
  class ae
    extends atul.d
  {
    public ae()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        atul.a(atul.this);
        atul.b(atul.this, 10, 11);
        atul.c(atul.this, 10, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
        this.b = new ae(atul.this);
        return;
      }
      atul.b(atul.this, 10, 10);
      atul.c(atul.this, 10, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenPause)");
      this.b = new atul.h(atul.this);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  recv failed!!");
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 3);
      atul.c(atul.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenPause)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.ah(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 10, 12);
      atul.c(atul.this, 10, 12);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenPause)");
      this.b = new atul.n(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 10, 9);
      atul.c(atul.this, 10, 9);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenPause)");
      this.b = new atul.f(atul.this);
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.c(atul.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new atul.af(atul.this);
    }
    
    protected void did()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. doSomeThingOnUploadDone entity is null");
        return;
      }
      localFileManagerEntity.setfProgress(0.0F);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 3);
      atul.c(atul.this, 1, 3);
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      this.b = new atul.p(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
    }
    
    protected void jw(long paramLong)
    {
      jx(paramLong);
    }
    
    protected String vh()
    {
      return "StateUploadingWhenPause";
    }
  }
  
  class af
    extends atul.d
  {
    public af()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        atul.a(atul.this);
        atul.b(atul.this, 9, 11);
        atul.c(atul.this, 9, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
        this.b = new af(atul.this);
        return;
      }
      atul.b(atul.this, 9, 10);
      atul.c(atul.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.b = new atul.i(atul.this);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  recv failed!!");
    }
    
    protected void Oe(int paramInt)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFailedOfLocalSomeThingHappen entity is null");
        return;
      }
      atul.b(atul.this, 9, 11);
      atul.c(atul.this, 9, 11);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenRecv)");
      this.b = new atul.s(atul.this);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      if (localFileManagerEntity.getfProgress() < 0.9F)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. start make progress pass to 100% directly");
        this.ced = true;
        atul.this.aN(1.0F);
        return true;
      }
      did();
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      paramString = atul.this.c;
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 9, 12);
      atul.c(atul.this, 9, 12);
      atul.this.app.a().a(paramString.uniseq, paramString.nSessionId, paramString.peerUin, paramString.peerType, 12, null, 5, null);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenRecv)");
      this.b = new atul.o(atul.this);
    }
    
    protected void dhT()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 9);
      atul.c(atul.this, 11, 9);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenRecv)");
      this.b = new atul.g(atul.this);
    }
    
    protected void dhU()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 10, -2);
      atul.c(atul.this, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
      this.b = new atul.ae(atul.this);
    }
    
    protected void did()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. doSomeThingOnUploadDone entity is null");
        return;
      }
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      localFileManagerEntity.setfProgress(0.0F);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 0);
      atul.c(atul.this, 1, 2);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + ". doSomeThingOnUploadDone start recv offline file....)");
      atul.this.app.a().b(atul.this.sessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 1);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      this.b = new atul.p(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
    }
    
    protected void jw(long paramLong)
    {
      jx(paramLong);
    }
    
    protected void onStop()
    {
      if (mq("onStop")) {
        return;
      }
      atul.a(atul.this, 9, 11, true);
      IR("StateLocalFailedWhenRecv");
      this.b = new atul.s(atul.this);
    }
    
    protected String vh()
    {
      return "StateUploadingWhenRecv";
    }
  }
  
  class ag
    extends atul.l
  {
    public ag()
    {
      super();
    }
    
    protected String vh()
    {
      return "StateUploadoneWhenChangeToOff";
    }
  }
  
  class ah
    extends atul.l
  {
    public ah()
    {
      super();
    }
    
    protected String vh()
    {
      return "StateUploadoneWhenPause";
    }
  }
  
  class ai
    extends atul.d
  {
    public ai()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      if (atul.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onRecvOnLineFileResult entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of accept,  waiting the cmd of starting upload");
        return;
      }
      atul.this.Od(1);
      if (!atul.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
        return;
      }
      atul.this.Jm(false);
      atul.b(atul.this, 10, 10);
      atul.c(atul.this, 10, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenPause)");
      this.b = new atul.h(atul.this);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  recv failed!!");
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (mq("onAskSenderUpProgressResult")) {
        return;
      }
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress,  waiting the notify of progress");
        return;
      }
      atul.this.Od(2);
      if (!atul.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
        return;
      }
      atul.this.Jm(false);
      atul.b(atul.this, 10, 10);
      atul.c(atul.this, 10, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenPause)");
      this.b = new atul.h(atul.this);
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        atul.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        atul.this.stopAllTimer();
        break label63;
        atul.b(atul.this, 10, 5);
        atul.c(atul.this, 10, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPCWhenPause)");
        this.b = new atul.b(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 6);
        atul.c(atul.this, 10, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPCWhenPause)");
        this.b = new atul.u(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 8);
        atul.c(atul.this, 10, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSendWhenPause)");
        this.b = new atul.ab(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 7);
        atul.c(atul.this, 10, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPCWhenPause)");
        this.b = new atul.y(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this);
        atul.b(atul.this, 10, 11);
        atul.c(atul.this, 10, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
        this.b = new atul.ae(atul.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 3);
      atul.c(atul.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenPause)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.ah(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new atul.n(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 10, 9, true);
      IR("StateCancelUploadWhenPause");
      this.b = new atul.f(atul.this);
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 9, 10);
      atul.c(atul.this, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenRecv)");
      this.b = new atul.aj(atul.this);
    }
    
    protected void dhX()
    {
      if (atul.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onSenderReplayComeOnRecv entity is null");
        return;
      }
      atul.this.Jm(true);
      atul.a(atul.this);
      atul.b(atul.this, 10, 11);
      atul.c(atul.this, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
      this.b = new atul.ae(atul.this);
    }
    
    protected void dhY()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + "onRecvButSenderReplayTimeOut entity is null");
        return;
      }
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + atul.this.a.cXI);
      atul.this.Od(1);
      if (!atul.this.alK())
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " sender replay time out and no handle it. here waiting response of asking progress");
        return;
      }
      atul.this.Jm(false);
      if (atul.this.a.cXI < 9223372036854775807L)
      {
        atul.a(atul.this, 10, 10, true);
        IR("StateChangeToOffFailedWhenPause");
        this.b = new atul.h(atul.this);
        return;
      }
      atul.a(atul.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new atul.n(atul.this);
    }
    
    protected void dia()
    {
      if (mq("onAskSenderUpProgressTimeOut")) {
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + atul.this.a.cXI);
      atul.this.Od(2);
      if (!atul.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " ask progress time out and no handle it. here waiting response of sender when recv");
        return;
      }
      atul.this.Jm(false);
      if (atul.this.a.cXI < 9223372036854775807L)
      {
        atul.a(atul.this, 10, 10, true);
        IR("StateChangeToOffFailedWhenPause");
        this.b = new atul.h(atul.this);
        return;
      }
      atul.a(atul.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new atul.n(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      if (mq("onSenderUploadProgressNotify")) {
        return;
      }
      atul.this.Jm(true);
      atul.a(atul.this);
      jdMethod_if(paramInt1, paramInt2);
      atul.a(atul.this, 10, 11);
      atul.a(atul.this, 10, 14, false);
      IR("StateUploadingWhenPause");
      this.b = new atul.ae(atul.this);
    }
    
    protected String vh()
    {
      return "StateWaitResultWhenPause";
    }
  }
  
  class aj
    extends atul.d
  {
    public aj()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. StateWaitingRecvResult entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of accept,  waiting the cmd of starting upload");
        return;
      }
      atul.this.Od(1);
      if (!atul.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
        return;
      }
      atul.this.Jm(false);
      atul.b(atul.this, 9, 10);
      atul.c(atul.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.b = new atul.i(atul.this);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  recv failed!!");
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (mq("onAskSenderUpProgressResult")) {
        return;
      }
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress,  waiting the notify of progress");
        return;
      }
      atul.this.Od(2);
      if (!atul.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + "ask progress server result = false and no handle it. here waiting response of sender on recv");
        return;
      }
      atul.this.Jm(false);
      atul.b(atul.this, 9, 10);
      atul.c(atul.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.b = new atul.i(atul.this);
      FileManagerEntity localFileManagerEntity = atul.this.c;
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        atul.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        atul.this.stopAllTimer();
        break label63;
        atul.b(atul.this, 11, 5);
        atul.c(atul.this, 11, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPC)");
        this.b = new atul.a(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 11, 6);
        atul.c(atul.this, 11, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPC)");
        this.b = new atul.t(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 11, 8);
        atul.c(atul.this, 11, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSend)");
        this.b = new atul.aa(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 11, 7);
        atul.c(atul.this, 11, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPC)");
        this.b = new atul.x(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this);
        atul.b(atul.this, 9, 11);
        atul.c(atul.this, 9, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
        this.b = new atul.af(atul.this);
        paramInt = 0;
      }
    }
    
    protected void Oe(int paramInt)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFailedOfLocalSomeThingHappen entity is null");
        return;
      }
      atul.b(atul.this, 9, 10);
      atul.c(atul.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.b = new atul.i(atul.this);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      if (localFileManagerEntity.getfProgress() < 0.9F)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. start make progress pass to 100% directly");
        this.ced = true;
        atul.this.aN(1.0F);
        return true;
      }
      did();
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new atul.o(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new atul.g(atul.this);
    }
    
    protected void dhU()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onPauseTrans entity is null");
        return;
      }
      atul.b(atul.this, 10, -2);
      atul.c(atul.this, 10, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenPause)");
      this.b = new atul.ai(atul.this);
    }
    
    protected void dhX()
    {
      if (atul.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onSenderReplayComeOnRecv entity is null");
        return;
      }
      atul.this.Jm(true);
      atul.a(atul.this);
      atul.b(atul.this, 9, 11);
      atul.c(atul.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new atul.af(atul.this);
    }
    
    protected void dhY()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " onRecvButSenderReplayTimeOut entity is null");
        return;
      }
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " you had recv the file, but sender replay time out!!!!, recvCmdSucAndHadTryCount =" + atul.this.a.cXI);
      atul.this.Od(1);
      if (!atul.this.alK())
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " sender replay time out and no handle it. here waiting response of asking progress");
        return;
      }
      atul.this.Jm(false);
      if (atul.this.a.cXI < 9223372036854775807L)
      {
        atul.a(atul.this, 9, 10, true);
        IR("StateChangeToOffFailedWhenRecv");
        this.b = new atul.i(atul.this);
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
        return;
      }
      atul.a(atul.this, 9, 12, true);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
      IR("StateExcepInvalidWhenRecv");
      this.b = new atul.o(atul.this);
    }
    
    protected void dia()
    {
      if (mq("onAskSenderUpProgressTimeOut")) {
        return;
      }
      FileManagerEntity localFileManagerEntity = atul.this.c;
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " you had recv the file, but  ask progress time out!!!!, recvCmdSucAndHadTryCount =" + atul.this.a.cXI);
      atul.this.Od(2);
      if (!atul.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + " ask progress time out and no handle it. here waiting response of sender when recv");
        return;
      }
      atul.this.Jm(false);
      if (atul.this.a.cXI < 9223372036854775807L)
      {
        atul.a(atul.this, 9, 10, true);
        IR("StateChangeToOffFailedWhenRecv");
        this.b = new atul.i(atul.this);
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
        return;
      }
      atul.a(atul.this, 9, 12, true);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
      IR("StateExcepInvalidWhenRecv");
      this.b = new atul.o(atul.this);
    }
    
    protected void did()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. doSomeThingOnUploadDone entity is null");
        return;
      }
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      localFileManagerEntity.setfProgress(0.0F);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 0);
      atul.c(atul.this, 1, 2);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + ". doSomeThingOnUploadDone start recv offline file....)");
      atul.this.app.a().b(atul.this.sessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 1);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      this.b = new atul.p(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      if (mq("onSenderUploadProgressNotify")) {
        return;
      }
      atul.this.Jm(true);
      atul.a(atul.this);
      jdMethod_if(paramInt1, paramInt2);
      atul.a(atul.this, 9, 11);
      atul.a(atul.this, 9, 14, false);
      IR("StateUploadingWhenRecv");
      this.b = new atul.af(atul.this);
    }
    
    protected void onStop() {}
    
    protected String vh()
    {
      return "StateWaitResultWhenRecv";
    }
  }
  
  class ak
  {
    int cXI = 0;
    int cXJ = 0;
    boolean cee = false;
    boolean cef = false;
    boolean ceg = false;
    
    ak() {}
  }
  
  class b
    extends atul.d
  {
    public b()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 5);
      atul.c(atul.this, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPC)");
      this.b = new atul.a(atul.this);
    }
    
    protected String vh()
    {
      return "StateAcceptByPCWhenPause";
    }
  }
  
  class c
    extends atul.d
  {
    public c()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 5);
      atul.c(atul.this, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPC)");
      this.b = new atul.a(atul.this);
    }
    
    protected String vh()
    {
      return "StateAcceptByPCWhenToOffFailed";
    }
  }
  
  public class d
  {
    protected d b = this;
    protected boolean cec = false;
    protected boolean ced = false;
    
    d() {}
    
    protected final void IR(String paramString)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->" + paramString + ")");
    }
    
    protected void Jk(boolean paramBoolean)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onRecvOnLineFileResult. ret:" + paramBoolean);
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  failed response of ask progress");
      atul.this.dhS();
      dia();
    }
    
    protected void Ob(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow:" + String.valueOf(paramInt);
      }
      for (;;)
      {
        QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state:" + atul.a(atul.this).vh() + " can not handle onFileRequestBeHandledByPC.handleType = " + str);
        return;
        str = "(pc accept)";
        continue;
        str = "(pc refuse)";
        continue;
        str = "(pc cancel send";
        continue;
        str = "(pc save to weiyun)";
        continue;
        str = "(pc change to off trans)";
      }
    }
    
    protected void Oe(int paramInt)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onFailedOfLocalSomeThingHappen. type:" + paramInt);
    }
    
    d a()
    {
      return this.b;
    }
    
    protected boolean alJ()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onRecvOnLineFile.");
      return true;
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      atul.this.c.Uuid = new String(paramString);
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onSenderUploadCompleted. type:" + paramInt + "time:" + paramLong);
      return false;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onSenderUploadException. errcode:" + paramInt + " resason:" + paramString);
    }
    
    protected void dhT()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onSenderCancelUpload. ");
    }
    
    protected void dhU()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onPauseTrans. ");
    }
    
    protected void dhV()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onResumeTrans. ");
    }
    
    protected void dhX()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onSenderReplayComeOnRecv:");
    }
    
    protected void dhY()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onRecvButSenderReplayTimeOut:");
    }
    
    protected void dia()
    {
      ct(4, null);
    }
    
    protected void dib()
    {
      ct(3, null);
    }
    
    protected void did()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle doSomeThingOnUploadDone:");
    }
    
    protected void die() {}
    
    protected void ie(int paramInt1, int paramInt2)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  state:" + atul.a(atul.this).vh() + " can not handle onSenderUploadProgressNotify. speed:" + paramInt1 + " progress:" + paramInt2);
    }
    
    protected final void jdMethod_if(int paramInt1, int paramInt2)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] make progress entity = null.handleProgressNotify");
        return;
      }
      if (paramInt2 > 100)
      {
        QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] handleProgressNotify progress > 100. progress=" + paramInt2);
        return;
      }
      int i;
      if (paramInt1 == 0) {
        i = 1;
      }
      for (;;)
      {
        long l = System.currentTimeMillis();
        FileManagerEntity localFileManagerEntity;
        if (i != 0)
        {
          QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  handleProgressNotify. state:" + atul.a(atul.this).vh() + ". averspeed = " + paramInt1 + ". progress = " + paramInt2 + ". nOlSenderProgress =" + atul.this.c.nOlSenderProgress + ". err notify. return");
          if (-1 != atul.this.c.nOlSenderProgress) {
            break;
          }
          atul.this.c.nOlSenderProgress = 0;
          atul.this.c.lastTime = l;
          if ((atul.this.c.status == 14) || (atul.this.c.status == 15))
          {
            localFileManagerEntity = atul.this.c.clone();
            localFileManagerEntity.status = 11;
            atul.this.app.a().u(localFileManagerEntity);
            return;
            if (paramInt2 > atul.this.c.nOlSenderProgress) {
              break label682;
            }
            if (atul.this.c.nOlSenderProgress == 0)
            {
              if (atul.this.c.fOlRecvSpeed <= 1.0E-007F) {
                break label682;
              }
              i = 1;
              continue;
            }
            i = 1;
            continue;
          }
          atul.this.app.a().u(atul.this.c);
          return;
        }
        this.ced = false;
        jx(l);
        float f1 = (100 - paramInt2) / 100.0F / (paramInt1 * 1024 / (float)atul.this.c.fileSize);
        float f2 = atul.this.c.getfProgress();
        atul.this.c.fOlRecvSpeed = ((0.9F - f2) / f1);
        atul.this.c.lastTime = l;
        atul.this.c.nOlSenderProgress = paramInt2;
        atul.this.c.fOlRecvProgressOnNotify = atul.this.c.getfProgress();
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  -----handleProgressNotify. state:" + atul.a(atul.this).vh() + ". averspeed = " + paramInt1 + ". progress = " + paramInt2 + ". fOlRecvSpeed = " + atul.this.c.fOlRecvSpeed + "f/s. fOlRecvProgressOnNotify =" + atul.this.c.fOlRecvProgressOnNotify);
        if ((atul.this.c.status == 14) || (atul.this.c.status == 15))
        {
          localFileManagerEntity = atul.this.c.clone();
          localFileManagerEntity.status = 11;
          atul.this.app.a().u(localFileManagerEntity);
          return;
        }
        atul.this.app.a().u(atul.this.c);
        return;
        label682:
        i = 0;
      }
    }
    
    protected void jw(long paramLong) {}
    
    protected final void jx(long paramLong)
    {
      if (atul.this.c == null) {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] make progress entity = null.makeProgress");
      }
      long l1;
      float f1;
      label497:
      float f2;
      float f3;
      float f4;
      do
      {
        do
        {
          return;
        } while ((this.ced) || (!atul.this.alH()));
        if (0L == atul.this.YY)
        {
          atul.this.YY = 102400L;
          l1 = atul.this.c.fileSize;
          long l2 = ((float)atul.this.c.fileSize * 0.1F);
          if (l1 > 104857600L)
          {
            atul.this.YY = (l2 / 60L);
            if (l1 > 524288000L)
            {
              atul.this.YY = (l2 / 120L);
              if (l1 > 1073741824L) {
                atul.this.YY = (l2 / 180L);
              }
            }
          }
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.c.nSessionId + "] initGoSpeed =" + atul.this.YY + "b/s");
        }
        f1 = atul.this.c.fOlRecvSpeed;
        if (!atul.this.alG())
        {
          l1 = (2000.0D * (atul.this.c.fileSize * (1.0D - atul.this.c.fOlRecvProgressOnNotify) / 102400.0D));
          f1 = (float)atul.this.YY / (float)atul.this.c.fileSize;
          if (l1 <= 30000L) {
            break label497;
          }
        }
        for (;;)
        {
          if (paramLong - atul.this.c.lastTime > l1)
          {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.c.nSessionId + "] state:" + atul.a(atul.this).vh() + " the progress maker think time out. timeOutInterval=" + l1 + "curRecvSpeed = " + f1 + ".lastTime =" + atul.this.c.lastTime + ". makeTime =" + paramLong);
            if (!atul.this.alG())
            {
              atul.this.b(true, 0L);
              this.ced = true;
              return;
              l1 = (2000.0F * (0.9F - atul.this.c.fOlRecvProgressOnNotify) / f1);
              break;
              l1 = 30000L;
              continue;
            }
            atul.this.b(true, 0L);
            this.ced = true;
            return;
          }
        }
        f2 = (float)(paramLong - atul.this.c.lastTime) / 1000.0F;
        f3 = f1 * f2;
        f4 = atul.this.c.fOlRecvProgressOnNotify + f3;
        if (atul.this.alG()) {
          break;
        }
      } while ((atul.this.c.getfProgress() > 0.1F) || (Math.abs(atul.this.c.getfProgress() - 0.1F) < 1.0E-008D));
      if (f4 > 0.1F) {
        atul.this.c.setfProgress(0.1F);
      }
      for (;;)
      {
        if (paramLong - atul.this.YX > 50000L)
        {
          atul.this.YX = paramLong;
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.c.nSessionId + "] -----state:" + atul.a(atul.this).vh() + " the making progress of upload is: " + atul.this.c.getfProgress() + "[curRecvSpeed=" + f1 + ".maketime=" + paramLong + ".lastTime=" + atul.this.c.lastTime + "f/s. makeTime_s=" + f2 + "s. addProgress = " + f3 + ". timeOutInterval=" + l1 + ". filesize=" + atul.this.c.fileSize + ". nOlSenderProgress=" + atul.this.c.nOlSenderProgress + ". fOlRecvProgressOnNotify =" + atul.this.c.fOlRecvProgressOnNotify + " ] ");
        }
        atul.this.app.a().a(atul.this.c.uniseq, atul.this.c.nSessionId, atul.this.c.peerUin, atul.this.c.peerType, 16, null, 0, null);
        return;
        atul.this.c.setfProgress(f4);
        continue;
        if ((atul.this.c.getfProgress() > 0.9F) || (Math.abs(atul.this.c.getfProgress() - 0.9F) < 1.0E-008D)) {
          break;
        }
        if (f4 > 0.9F) {
          atul.this.c.setfProgress(0.9F);
        } else {
          atul.this.c.setfProgress(f4);
        }
      }
    }
    
    protected final boolean mq(String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. state:" + this.b.vh() + paramString + " entity is null ");
        return true;
      }
      return false;
    }
    
    protected void onStop()
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateEnd)");
      this.b = new atul.l(atul.this);
    }
    
    public String vh()
    {
      return "StateBase";
    }
  }
  
  class e
    extends atul.d
  {
    public e()
    {
      super();
    }
    
    protected boolean alJ()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      atul.b(atul.this, 11, 9);
      atul.c(atul.this, 11, 9);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenRecv)");
      this.b = new atul.g(atul.this);
      return true;
    }
    
    protected String vh()
    {
      return "StateCancelUploadWhenChangeToOff";
    }
  }
  
  class f
    extends atul.d
  {
    public f()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 9);
      atul.c(atul.this, 11, 9);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenRecv)");
      this.b = new atul.g(atul.this);
    }
    
    protected String vh()
    {
      return "StateCancelUploadWhenPause";
    }
  }
  
  class g
    extends atul.l
  {
    public g()
    {
      super();
    }
    
    protected String vh()
    {
      return "StateCancelUploadWhenRecv";
    }
  }
  
  class h
    extends atul.d
  {
    public h()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      if (atul.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. StateWaitingRecvResult entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        atul.a(atul.this);
        atul.a(atul.this, 10, 11, true);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenPause)");
        this.b = new atul.r(atul.this);
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenPause)");
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress, not handle it");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  failed response of ask progress, not handle it");
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        atul.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        atul.this.dhR();
        break label63;
        atul.b(atul.this, 10, 5);
        atul.c(atul.this, 10, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPCWhenPause)");
        this.b = new atul.b(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 6);
        atul.c(atul.this, 10, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPCWhenPause)");
        this.b = new atul.u(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 8);
        atul.c(atul.this, 10, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSendWhenPause)");
        this.b = new atul.ab(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 7);
        atul.c(atul.this, 10, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPCWhenPause)");
        this.b = new atul.y(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this);
        atul.b(atul.this, 10, 11);
        atul.c(atul.this, 10, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffWhenPause)");
        this.b = new atul.j(atul.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 3);
      atul.c(atul.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenPause)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.ah(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new atul.n(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 10, 9, true);
      IR("StateCancelUploadWhenPause");
      this.b = new atul.f(atul.this);
    }
    
    protected void dhV()
    {
      if (mq("onResumeTrans")) {}
      FileManagerEntity localFileManagerEntity;
      do
      {
        return;
        localFileManagerEntity = atul.this.c;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "start send recv cmd.... [" + atul.this.a.cXI + "-" + atul.this.a.cXJ + "]");
      } while (!atul.this.t(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
      atul.c(atul.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenRecv)");
      this.b = new atul.aj(atul.this);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      atul.this.app.a().a(atul.this.c.uniseq, atul.this.c.nSessionId, atul.this.c.peerUin, atul.this.c.peerType, 16, null, 0, null);
    }
    
    protected void dhX()
    {
      if (atul.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onSenderReplayComeOnRecv entity is null");
        return;
      }
      atul.a(atul.this);
      atul.a(atul.this, 10, 11, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenPause)");
      this.b = new atul.r(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      if (mq("onSenderUploadProgressNotify")) {
        return;
      }
      atul.a(atul.this);
      jdMethod_if(paramInt1, paramInt2);
      atul.a(atul.this, 10, 11);
      atul.a(atul.this, 10, 14, false);
      IR("StateUploadingWhenPause");
      this.b = new atul.ae(atul.this);
    }
    
    protected String vh()
    {
      return "StateChangeToOffFailedWhenPause";
    }
  }
  
  class i
    extends atul.d
  {
    public i()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      if (atul.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. StateWaitingRecvResult entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        atul.a(atul.this);
        atul.a(atul.this, 9, 11, true);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenRecv)");
        this.b = new atul.s(atul.this);
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress, not handle it");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + " recv  failed response of ask progress, not handle it");
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        atul.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        atul.this.dhR();
        break label63;
        atul.b(atul.this, 13, 5);
        atul.c(atul.this, 13, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPCWhenToOffFailed)");
        this.b = new atul.c(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 13, 6);
        atul.c(atul.this, 13, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPCWhenToOffFailed)");
        this.b = new atul.v(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 13, 8);
        atul.c(atul.this, 13, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSendWhenToOffFailed)");
        this.b = new atul.ac(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 13, 7);
        atul.c(atul.this, 13, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
        this.b = new atul.z(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this);
        atul.b(atul.this, 13, 11);
        atul.c(atul.this, 13, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffWhenToOffFailed)");
        this.b = new atul.k(atul.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 0);
      atul.c(atul.this, 1, 0);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.p(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (mq("onSenderUploadException")) {
        return;
      }
      atul.a(atul.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new atul.o(atul.this);
    }
    
    protected void dhT()
    {
      if (mq("onSenderCancelUpload")) {
        return;
      }
      atul.a(atul.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new atul.g(atul.this);
    }
    
    protected void dhV()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null) {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
      }
      do
      {
        return;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "start send recv cmd.... [" + atul.this.a.cXI + "-" + atul.this.a.cXJ + "]");
      } while (!atul.this.t(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
      atul.c(atul.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenRecv)");
      this.b = new atul.aj(atul.this);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      atul.this.app.a().a(atul.this.c.uniseq, atul.this.c.nSessionId, atul.this.c.peerUin, atul.this.c.peerType, 16, null, 0, null);
    }
    
    protected void dhX()
    {
      if (mq("onSenderReplayComeOnRecv")) {
        return;
      }
      atul.a(atul.this);
      atul.a(atul.this, 9, 11, true);
      IR("StateLocalFailedWhenRecv");
      this.b = new atul.s(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      if (mq("onSenderUploadProgressNotify")) {
        return;
      }
      atul.a(atul.this);
      jdMethod_if(paramInt1, paramInt2);
      atul.a(atul.this, 9, 11, true);
      IR("StateLocalFailedWhenRecv");
      this.b = new atul.s(atul.this);
    }
    
    protected String vh()
    {
      return "StateChangeToOffFailedWhenRecv";
    }
  }
  
  class j
    extends atul.d
  {
    public j()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 9, 11);
      atul.c(atul.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new atul.af(atul.this);
    }
    
    protected String vh()
    {
      return "StateChangeToOffWhenPause";
    }
  }
  
  class k
    extends atul.d
  {
    public k()
    {
      super();
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      if (mq("onSenderUploadCompleted")) {
        return false;
      }
      FileManagerEntity localFileManagerEntity = atul.this.c;
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      atul.a(atul.this, 1, 0, true);
      IR("StateGotoOffFileProcess");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.p(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (mq("onSenderUploadException")) {
        return;
      }
      atul.a(atul.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new atul.o(atul.this);
    }
    
    protected void dhT()
    {
      if (mq("onSenderCancelUpload")) {
        return;
      }
      atul.a(atul.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new atul.g(atul.this);
    }
    
    protected void dhV()
    {
      if (mq("onResumeTrans")) {
        return;
      }
      atul.a(atul.this, 9, 11);
      atul.a(atul.this, 9, 14, false);
      IR("StateUploadingWhenRecv");
      this.b = new atul.af(atul.this);
      atul.this.b(true, 0L);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
    }
    
    protected String vh()
    {
      return "StateChangeToOffWhenToOffFailed";
    }
  }
  
  class l
    extends atul.d
  {
    l()
    {
      super();
      this.cec = true;
      this.ced = true;
    }
    
    protected String vh()
    {
      return "StateEnd";
    }
  }
  
  class m
    extends atul.d
  {
    public m()
    {
      super();
    }
    
    protected boolean alJ()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      atul.b(atul.this, 9, 12);
      atul.c(atul.this, 9, 12);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenRecv)");
      this.b = new atul.o(atul.this);
      return true;
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 11, 13);
      atul.c(atul.this, 11, 13);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenChangeToOff)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.ag(atul.this);
      return true;
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
      atul.b(atul.this, 11, 11);
      atul.c(atul.this, 11, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenChangeToOff)");
      this.b = new atul.ad(atul.this);
    }
    
    protected String vh()
    {
      return "StateExcepInvalidWhenChangeToOff";
    }
  }
  
  class n
    extends atul.d
  {
    public n()
    {
      super();
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        atul.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        atul.this.dhR();
        break label63;
        atul.b(atul.this, 10, 5);
        atul.c(atul.this, 10, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPCWhenPause)");
        this.b = new atul.b(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 6);
        atul.c(atul.this, 10, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPCWhenPause)");
        this.b = new atul.u(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 8);
        atul.c(atul.this, 10, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSendWhenPause)");
        this.b = new atul.ab(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 10, 7);
        atul.c(atul.this, 10, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPCWhenPause)");
        this.b = new atul.y(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this);
        atul.b(atul.this, 10, 11);
        atul.c(atul.this, 10, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
        this.b = new atul.ae(atul.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 3);
      atul.c(atul.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.p(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new n(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 10, 9, true);
      IR("StateCancelUploadWhenPause");
      this.b = new atul.f(atul.this);
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 9, 12);
      atul.c(atul.this, 9, 12);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenRecv)");
      this.b = new atul.o(atul.this);
    }
    
    protected void dhX()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onSenderReplayComeOnRecv entity is null");
        return;
      }
      atul.a(atul.this);
      atul.a(atul.this, 10, 11, true);
      IR("StateLocalFailedWhenPause");
      this.b = new atul.r(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
      atul.b(atul.this, 10, 11);
      atul.c(atul.this, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
      this.b = new atul.ae(atul.this);
    }
    
    protected String vh()
    {
      return "StateExcepInvalidWhenPause";
    }
  }
  
  class o
    extends atul.l
  {
    public o()
    {
      super();
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        atul.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        atul.this.dhR();
        break label63;
        atul.b(atul.this, 11, 5);
        atul.c(atul.this, 11, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPC)");
        this.b = new atul.a(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 11, 6);
        atul.c(atul.this, 11, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPC)");
        this.b = new atul.t(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 11, 8);
        atul.c(atul.this, 11, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSend)");
        this.b = new atul.aa(atul.this);
        paramInt = i;
        continue;
        atul.b(atul.this, 11, 7);
        atul.c(atul.this, 11, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPC)");
        this.b = new atul.x(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this);
        atul.b(atul.this, 11, 11);
        atul.c(atul.this, 11, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenChangeToOff)");
        this.b = new atul.ad(atul.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 5);
      }
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 0);
      atul.c(atul.this, 1, 0);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.p(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new o(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new atul.g(atul.this);
    }
    
    protected void dhX()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFailedOfLocalSomeThingHappen entity is null");
        return;
      }
      atul.a(atul.this);
      atul.a(atul.this, 9, 11, true);
      IR("StateLocalFailedWhenRecv");
      this.b = new atul.s(atul.this);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      jdMethod_if(paramInt1, paramInt2);
      atul.b(atul.this, 9, 11);
      atul.c(atul.this, 9, 11);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenRecv)");
      this.b = new atul.s(atul.this);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected String vh()
    {
      return "StateExcepInvalidWhenRecv";
    }
  }
  
  class p
    extends atul.l
  {
    public p()
    {
      super();
    }
    
    protected String vh()
    {
      return "StateGotoOffFileProcess";
    }
  }
  
  class q
    extends atul.d
  {
    public q()
    {
      super();
    }
    
    protected boolean alJ()
    {
      if (mq("onRecvOnLineFile")) {
        return false;
      }
      atul.a(atul.this, 9, 11);
      atul.a(atul.this, 9, 14, false);
      IR("StateUploadingWhenRecv");
      this.b = new atul.af(atul.this);
      FileManagerEntity localFileManagerEntity = atul.this.c;
      atul.this.app.a().a(atul.this.c.uniseq, atul.this.c.nSessionId, atul.this.c.peerUin, atul.this.c.peerType, 16, null, 0, null);
      return true;
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      if (mq("onSenderUploadCompleted")) {
        return false;
      }
      FileManagerEntity localFileManagerEntity = atul.this.c;
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      localFileManagerEntity.setCloudType(1);
      atul.a(atul.this, 11, 13, true);
      IR("StateUploadoneWhenChangeToOff");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.ag(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (mq("onSenderUploadException")) {
        return;
      }
      atul.a(atul.this, 11, 12, true);
      IR("StateExcepInvalidWhenChangeToOff");
      this.b = new atul.m(atul.this);
    }
    
    protected void dhT()
    {
      if (mq("onSenderCancelUpload")) {
        return;
      }
      atul.a(atul.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new atul.g(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
    }
    
    protected void jw(long paramLong)
    {
      jx(paramLong);
    }
    
    protected void onStop() {}
    
    protected String vh()
    {
      return "StateLocalFailedWhenChangeToOff";
    }
  }
  
  class r
    extends atul.d
  {
    public r()
    {
      super();
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 3);
      atul.c(atul.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.p(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new atul.n(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 10, 9, true);
      IR("StateCancelUploadWhenPause");
      this.b = new atul.f(atul.this);
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.c(atul.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new atul.af(atul.this);
      atul.this.b(true, 0L);
      atul.this.app.a().a(atul.this.c.uniseq, atul.this.c.nSessionId, atul.this.c.peerUin, atul.this.c.peerType, 16, null, 0, null);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
    }
    
    protected void jw(long paramLong)
    {
      jx(paramLong);
    }
    
    protected String vh()
    {
      return "StateLocalFailedWhenPause";
    }
  }
  
  class s
    extends atul.d
  {
    public s()
    {
      super();
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      atul.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      atul.b(atul.this, 1, 0);
      atul.c(atul.this, 1, 0);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.p(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new atul.o(atul.this);
    }
    
    protected void dhT()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new atul.g(atul.this);
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.c(atul.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new atul.af(atul.this);
      atul.this.b(true, 0L);
      atul.this.app.a().a(atul.this.c.uniseq, atul.this.c.nSessionId, atul.this.c.peerUin, atul.this.c.peerType, 16, null, 0, null);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
    }
    
    protected void jw(long paramLong)
    {
      jx(paramLong);
    }
    
    protected String vh()
    {
      return "StateLocalFailedWhenRecv";
    }
  }
  
  class t
    extends atul.l
  {
    public t()
    {
      super();
    }
    
    protected String vh()
    {
      return "StateRefuseByPC";
    }
  }
  
  class u
    extends atul.d
  {
    public u()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 6);
      atul.c(atul.this, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPC)");
      this.b = new atul.t(atul.this);
    }
    
    protected String vh()
    {
      return "StateRefuseByPCWhenPause";
    }
  }
  
  class v
    extends atul.d
  {
    public v()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 6);
      atul.c(atul.this, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPC)");
      this.b = new atul.t(atul.this);
    }
    
    protected String vh()
    {
      return "StateRefuseByPCWhenToOffFailed";
    }
  }
  
  class w
    extends atul.d
  {
    public w()
    {
      super();
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        atul.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + atul.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        atul.this.dhR();
        break label63;
        atul.a(atul.this, 11, 5, true);
        IR("StateAcceptByPC");
        this.b = new atul.a(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this, 11, 6, true);
        IR("StateRefuseByPC");
        this.b = new atul.t(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this, 11, 8, true);
        IR("StateSenderCancelSend");
        this.b = new atul.aa(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this, 11, 7, true);
        IR("StateSaveToWeiYunByPC");
        this.b = new atul.x(atul.this);
        paramInt = i;
        continue;
        atul.a(atul.this);
        atul.a(atul.this, 11, 11);
        atul.a(atul.this, 11, 14, false);
        IR("StateUploadingWhenChangeToOff");
        this.b = new atul.ad(atul.this);
        paramInt = 0;
      }
    }
    
    protected boolean alJ()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      atul.b(atul.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "start send recv cmd.... [" + atul.this.a.cXI + "-" + atul.this.a.cXJ + "]");
      boolean bool = atul.this.t(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
      if (bool)
      {
        atul.c(atul.this, 9, 15);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenRecv)");
        this.b = new atul.aj(atul.this);
      }
      for (;;)
      {
        atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
        return bool;
        atul.c(atul.this, 9, 10);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
        this.b = new atul.i(atul.this);
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]  failure to send recv cmd!!! ");
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.setfProgress(0.0F);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        atul.this.app.a().a(localFileManagerEntity, 7);
      }
      localFileManagerEntity.setCloudType(1);
      atul.a(atul.this, 1, -1, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      atul.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new atul.p(atul.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      super.ct(paramInt, paramString);
    }
    
    protected void dhT()
    {
      FileManagerEntity localFileManagerEntity = atul.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.a(atul.this, 11, 9, true);
      atul.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
      IR("StateCancelUploadWhenRecv");
      this.b = new atul.g(atul.this);
    }
    
    protected void die()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. onCheckIsTooLongSession entity is null");
        return;
      }
      atul.a(atul.this, 9, 12, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenRecv)");
      this.b = new atul.o(atul.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      atul.a(atul.this);
      jdMethod_if(paramInt1, paramInt2);
      atul.a(atul.this, 11, 11);
      atul.a(atul.this, 11, 14, false);
      IR("StateUploadingWhenChangeToOff");
      this.b = new atul.ad(atul.this);
    }
    
    protected String vh()
    {
      return "StateRequest";
    }
  }
  
  class x
    extends atul.l
  {
    public x()
    {
      super();
    }
    
    protected String vh()
    {
      return "StateSaveToWeiYunByPC";
    }
  }
  
  class y
    extends atul.d
  {
    public y()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 7);
      atul.c(atul.this, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPC)");
      this.b = new atul.x(atul.this);
    }
    
    protected String vh()
    {
      return "StateSaveToWeiYunByPCWhenPause";
    }
  }
  
  class z
    extends atul.d
  {
    public z()
    {
      super();
    }
    
    protected void dhV()
    {
      if (atul.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      atul.b(atul.this, 11, 7);
      atul.c(atul.this, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + atul.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPC)");
      this.b = new atul.x(atul.this);
    }
    
    protected String vh()
    {
      return "StateSaveToWeiYunByPCWhenToOffFailed";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atul
 * JD-Core Version:    0.7.0.1
 */