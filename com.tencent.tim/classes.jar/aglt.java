import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.1;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.2;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class aglt
{
  private Timer E;
  private Timer F;
  long Ib = 0L;
  long YW = 0L;
  long YX = 0L;
  long YY = 0L;
  aglt.ak jdField_a_of_type_Aglt$ak = new aglt.ak();
  private aglt.d jdField_a_of_type_Aglt$d;
  public QQAppInterface app;
  public FileManagerEntity c = null;
  private Object dI = new Object();
  private Object dJ = new Object();
  long sessionId;
  
  public aglt(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.app = paramQQAppInterface;
    this.sessionId = paramLong;
    this.jdField_a_of_type_Aglt$d = new aglt.d();
  }
  
  private void A(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.c == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] setCurStateOfEntityTo can not find entity . state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "-> StateEnd)");
      this.jdField_a_of_type_Aglt$d = new aglt.l();
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state:" + this.jdField_a_of_type_Aglt$d.vh() + " curstate of entity change: (opType:" + this.c.nOpType + " status:" + this.c.status + ") -> (opType:" + paramInt1 + "  status:" + paramInt2 + ") savedb=" + paramBoolean);
      this.c.nOpType = paramInt1;
      this.c.status = paramInt2;
    } while (!paramBoolean);
    this.app.a().u(this.c);
  }
  
  private boolean aV(int paramInt1, int paramInt2)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] error optype:" + paramInt1);
    }
    for (;;)
    {
      if (!bool)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] goto next state failed. state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "-> StateEnd)");
        this.jdField_a_of_type_Aglt$d = new aglt.l();
      }
      return bool;
      bool = jF(paramInt2);
      continue;
      bool = jG(paramInt2);
      continue;
      bool = jH(paramInt2);
      continue;
      bool = jI(paramInt2);
      continue;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateGotoOffFileProcess)");
      this.jdField_a_of_type_Aglt$d = new aglt.p();
      bool = true;
      continue;
      bool = jJ(paramInt2);
    }
  }
  
  private void dhP()
  {
    if (this.c != null)
    {
      if (0L != this.c.lastTime) {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state :" + this.jdField_a_of_type_Aglt$d.vh() + " initForMakeProgress. but had init. lastTime =" + this.c.lastTime);
      }
      this.c.lastTime = System.currentTimeMillis();
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state :" + this.jdField_a_of_type_Aglt$d.vh() + " initForMakeProgress lastTime =" + this.c.lastTime);
    }
  }
  
  private void ib(int paramInt1, int paramInt2)
  {
    if (this.c == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] setStateToDatabase can not find entity . state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "-> StateEnd)");
      this.jdField_a_of_type_Aglt$d = new aglt.l();
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
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] setDBStateOfEntityTo can not find entity . state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "-> StateEnd)");
      this.jdField_a_of_type_Aglt$d = new aglt.l();
      return;
    }
    FileManagerEntity localFileManagerEntity = this.c.clone();
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state:" + this.jdField_a_of_type_Aglt$d.vh() + " curstate: (opType:" + this.c.nOpType + " status:" + this.c.status + ").  save state:(opType:" + paramInt1 + "  status:" + paramInt2 + ") to DB");
    localFileManagerEntity.nOpType = paramInt1;
    localFileManagerEntity.status = paramInt2;
    this.app.a().u(localFileManagerEntity);
  }
  
  private boolean jF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] no status. when GOTO_UPLOAD:" + paramInt);
      return false;
    case 9: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateCancelUploadWhenRecv)");
      this.jdField_a_of_type_Aglt$d = new aglt.g();
      return true;
    case 10: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_Aglt$d = new aglt.i();
      return true;
    case 11: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateLocalFailedWhenRecv)");
      this.jdField_a_of_type_Aglt$d = new aglt.s();
      return true;
    case 12: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateExcepInvalidWhenRecv)");
      this.jdField_a_of_type_Aglt$d = new aglt.o();
      return true;
    case 14: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateUploadingWhenRecv)");
      this.jdField_a_of_type_Aglt$d = new aglt.af();
      return true;
    case 15: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_Aglt$d = new aglt.aj();
      return true;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when GOTO_UPLOAD:" + paramInt);
    return false;
  }
  
  private boolean jG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] no status. when STOP_UPLOAD:" + paramInt);
      return false;
    case 9: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateCancelUploadWhenPause)");
      this.jdField_a_of_type_Aglt$d = new aglt.f();
      return true;
    case 10: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateChangeToOffFailedWhenPause)");
      this.jdField_a_of_type_Aglt$d = new aglt.h();
      return true;
    case 11: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateLocalFailedWhenPause)");
      this.jdField_a_of_type_Aglt$d = new aglt.r();
      return true;
    case 12: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateExcepInvalidWhenPause)");
      this.jdField_a_of_type_Aglt$d = new aglt.n();
      return true;
    case 14: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_Aglt$d = new aglt.ae();
      return true;
    case 15: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateWaitResultWhenPause)");
      this.jdField_a_of_type_Aglt$d = new aglt.ai();
      return true;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when STOP_UPLOAD:" + paramInt);
    return false;
  }
  
  private boolean jH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] no status. when BE_PC_HANDLED:" + paramInt);
      return false;
    case 5: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateAcceptByPC)");
      this.jdField_a_of_type_Aglt$d = new aglt.a();
      return true;
    case 6: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateRefuseByPC)");
      this.jdField_a_of_type_Aglt$d = new aglt.t();
      return true;
    case 7: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_Aglt$d = new aglt.x();
      return true;
    case 8: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_Aglt$d = new aglt.aa();
      return true;
    case 9: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateCancelUploadWhenChangeToOff)");
      this.jdField_a_of_type_Aglt$d = new aglt.e();
      return true;
    case 12: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateExcepInvalidWhenChangeToOff)");
      this.jdField_a_of_type_Aglt$d = new aglt.m();
      return true;
    case 13: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateUploadoneWhenChangeToOff)");
      this.jdField_a_of_type_Aglt$d = new aglt.ag();
      return true;
    case 14: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateUploadingWhenChangeToOff)");
      this.jdField_a_of_type_Aglt$d = new aglt.ad();
      return true;
    case 11: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateLocalFailedWhenChangeToOff)");
      this.jdField_a_of_type_Aglt$d = new aglt.q();
      return true;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when BE_PC_HANDLED:" + paramInt);
    return false;
  }
  
  private boolean jI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] no status. when TYPE_UNKNOW:" + paramInt);
      return false;
    case 4: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateRequest)");
      this.jdField_a_of_type_Aglt$d = new aglt.w();
      return true;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when TYPE_UNKNOW:" + paramInt);
    return false;
  }
  
  private boolean jJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] can not set the status. when BE_PC_HANDLED_ON_RECV2OFF_FAILED:" + paramInt);
      return false;
    case 5: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateAcceptByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aglt$d = new aglt.c();
      return true;
    case 6: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateRefuseByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aglt$d = new aglt.v();
      return true;
    case 7: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
      this.jdField_a_of_type_Aglt$d = new aglt.z();
      return true;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "->StateSenderCancelSendWhenToOffFailed)");
    this.jdField_a_of_type_Aglt$d = new aglt.ac();
    return true;
  }
  
  public void Jk(boolean paramBoolean)
  {
    aglt.ak localak;
    if (paramBoolean)
    {
      localak = this.jdField_a_of_type_Aglt$ak;
      localak.cXI += 1;
      dhQ();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aglt$d.Jk(paramBoolean);
      this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
      return;
      localak = this.jdField_a_of_type_Aglt$ak;
      localak.cXJ += 1;
    }
  }
  
  public void Jl(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitAskUpProgressResultTimer. when onAskSenderUpProgressResult = false");
      dhS();
    }
    this.jdField_a_of_type_Aglt$d.Jl(paramBoolean);
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  void Jm(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aglt$ak.ceg)
    {
      this.jdField_a_of_type_Aglt$ak.ceg = false;
      this.jdField_a_of_type_Aglt$ak.cee = false;
      this.jdField_a_of_type_Aglt$ak.cef = false;
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
    this.jdField_a_of_type_Aglt$d.Ob(paramInt);
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
    dic();
  }
  
  public void Oc(int paramInt)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onNetworkChanged");
    stopAllTimer();
    this.jdField_a_of_type_Aglt$d.Oe(1);
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  void Od(int paramInt)
  {
    if (1 == paramInt) {
      if (this.jdField_a_of_type_Aglt$ak.ceg)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " recv olfile is going on. but the resp of sender is error");
        this.jdField_a_of_type_Aglt$ak.cee = true;
      }
    }
    while ((2 != paramInt) || (!this.jdField_a_of_type_Aglt$ak.ceg)) {
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " recv olfile is going on. but the resp of ask progress is error");
    this.jdField_a_of_type_Aglt$ak.cef = true;
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
    return this.jdField_a_of_type_Aglt$d.cec;
  }
  
  public boolean alJ()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " user recv online file....!!");
    boolean bool = this.jdField_a_of_type_Aglt$d.alJ();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
    return bool;
  }
  
  boolean alK()
  {
    return (!this.jdField_a_of_type_Aglt$ak.ceg) || ((this.jdField_a_of_type_Aglt$ak.cee) && (this.jdField_a_of_type_Aglt$ak.cef));
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
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderUploadCompleted");
    stopAllTimer();
    boolean bool = this.jdField_a_of_type_Aglt$d.b(paramInt, paramString, paramLong);
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
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
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Aglt$d.vh() + " ask upload progress isSuccess = " + bool + ". askUpProgressCount=" + this.YW);
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
    this.jdField_a_of_type_Aglt$d.ct(paramInt, paramString);
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
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
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Aglt$d.vh() + " failure to startWaitSenderReplayOnRecvTimer ant it is runing");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Aglt$d.vh() + " startWaitSenderReplayOnRecvTimer. outTimerInterval=" + l);
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
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitSenderReplayOnRecvTimer");
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitSenderReplayOnRecvTimer.but timer had stop");
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
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitAskUpProgressResultTimer");
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitAskUpProgressResultTimer.but timer had stop");
    }
  }
  
  public void dhT()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderCancelUpload");
    stopAllTimer();
    this.jdField_a_of_type_Aglt$d.dhT();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  public void dhU()
  {
    this.jdField_a_of_type_Aglt$d.dhU();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  public void dhV()
  {
    this.jdField_a_of_type_Aglt$d.dhV();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  public void dhW()
  {
    this.jdField_a_of_type_Aglt$d.did();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  public void dhX()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitSenderReplayOnRecvTimer. stopWaitAskUpProgressResultTimer. when onSenderReplayComeOnRecv");
    dhR();
    dhS();
    this.jdField_a_of_type_Aglt$d.dhX();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  public void dhY()
  {
    this.jdField_a_of_type_Aglt$d.dhY();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
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
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] state :" + this.jdField_a_of_type_Aglt$d.vh() + " is too long session and invaild!!!! invaild time=" + 172800L);
    this.jdField_a_of_type_Aglt$d.die();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  public void dia()
  {
    this.jdField_a_of_type_Aglt$d.dia();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  public void dib()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitAskUpProgressResultTimer. when onAskUpProgressAndSessionInvaid");
    dhS();
    this.jdField_a_of_type_Aglt$d.dib();
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  void dic()
  {
    if (this.c != null)
    {
      if ((5 == this.c.status) || (6 == this.c.status) || (7 == this.c.status))
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " checkAndDeleteRecordFromFM mEntity.nOpType = " + this.c.nOpType);
        this.c.bDelInFM = true;
        this.app.a().b(this.c, false);
        this.app.a().b(true, 3, null);
      }
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " checkAndDeleteRecordFromFM. mEntity = null");
  }
  
  public void ie(int paramInt1, int paramInt2)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stopWaitAskUpProgressResultTimer. stopWaitSenderReplayOnRecvTimer. when onSenderUploadProgressNotify");
    dhS();
    dhR();
    this.jdField_a_of_type_Aglt$d.ie(paramInt1, paramInt2);
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
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
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Aglt$d.vh() + " failure to startWaitAskUpProgressResultTimer ant it is runing");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "] state:" + this.jdField_a_of_type_Aglt$d.vh() + " startWaitAskUpProgressResultTimer. outTimerInterval=" + l);
      this.F = new Timer();
      this.F.schedule(new OnlineFileSessionWorker.2(this), l);
      return;
    }
  }
  
  public void jw(long paramLong)
  {
    this.jdField_a_of_type_Aglt$d.jw(paramLong);
    this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
  }
  
  public boolean m(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] init failed. state change :(" + this.jdField_a_of_type_Aglt$d.vh() + "-> StateEnd)");
      this.jdField_a_of_type_Aglt$d = new aglt.l();
      return false;
    }
    this.c = paramFileManagerEntity;
    boolean bool = aV(this.c.nOpType, this.c.status);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "] init state to:" + this.jdField_a_of_type_Aglt$d.vh());
    return bool;
  }
  
  public void stop()
  {
    if ((this.jdField_a_of_type_Aglt$d != null) && (this.c != null))
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.c.nSessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " stop worker...");
      stopAllTimer();
      this.jdField_a_of_type_Aglt$d.onStop();
      this.c = null;
      this.sessionId = 0L;
      this.jdField_a_of_type_Aglt$d = this.jdField_a_of_type_Aglt$d.a();
    }
  }
  
  void stopAllTimer()
  {
    dhR();
    dhS();
  }
  
  boolean t(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Aglt$ak.ceg) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " internalRecvOnlineFile. recv is going on, why?? ");
    }
    boolean bool = this.app.a().p(paramString, paramLong);
    if (!bool)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " internalRecvOnlineFile. recv cmd send failed.... ");
      paramString = this.jdField_a_of_type_Aglt$ak;
      paramString.cXJ += 1;
    }
    do
    {
      return bool;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " internalRecvOnlineFile. recv cmd send success, and will ask progress .... ");
      this.jdField_a_of_type_Aglt$ak.ceg = true;
      this.jdField_a_of_type_Aglt$ak.cee = false;
      this.jdField_a_of_type_Aglt$ak.cef = false;
    } while (b(true, 0L));
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.sessionId + "]  state:" + this.jdField_a_of_type_Aglt$d.vh() + " internalRecvOnlineFile. ask progress failed.... ");
    Od(2);
    return bool;
  }
  
  class a
    extends aglt.l
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
    extends aglt.l
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
    extends aglt.d
  {
    public ab()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 8);
      aglt.c(aglt.this, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSend)");
      this.b = new aglt.aa(aglt.this);
    }
    
    protected String vh()
    {
      return "StateSenderCancelSendWhenPause";
    }
  }
  
  class ac
    extends aglt.d
  {
    public ac()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 8);
      aglt.c(aglt.this, 11, 8);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSend)");
      this.b = new aglt.aa(aglt.this);
    }
    
    protected String vh()
    {
      return "StateSenderCancelSendWhenToOffFailed";
    }
  }
  
  class ad
    extends aglt.d
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
      aglt.a(aglt.this, 9, 11);
      aglt.a(aglt.this, 9, 14, false);
      IR("StateUploadingWhenRecv");
      this.b = new aglt.af(aglt.this);
      return true;
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 11, 13);
      aglt.c(aglt.this, 11, 13);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenChangeToOff)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.ag(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 12);
      aglt.c(aglt.this, 11, 12);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenChangeToOff");
      this.b = new aglt.m(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 9);
      aglt.c(aglt.this, 11, 9);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenRecv)");
      this.b = new aglt.g(aglt.this);
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
    extends aglt.d
  {
    public ae()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        aglt.a(aglt.this);
        aglt.b(aglt.this, 10, 11);
        aglt.c(aglt.this, 10, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
        this.b = new ae(aglt.this);
        return;
      }
      aglt.b(aglt.this, 10, 10);
      aglt.c(aglt.this, 10, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenPause)");
      this.b = new aglt.h(aglt.this);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  recv failed!!");
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 3);
      aglt.c(aglt.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenPause)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.ah(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 10, 12);
      aglt.c(aglt.this, 10, 12);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenPause)");
      this.b = new aglt.n(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 10, 9);
      aglt.c(aglt.this, 10, 9);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenPause)");
      this.b = new aglt.f(aglt.this);
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.c(aglt.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new aglt.af(aglt.this);
    }
    
    protected void did()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. doSomeThingOnUploadDone entity is null");
        return;
      }
      localFileManagerEntity.fProgress = 0.0F;
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 3);
      aglt.c(aglt.this, 1, 3);
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      this.b = new aglt.p(aglt.this);
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
    extends aglt.d
  {
    public af()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        aglt.a(aglt.this);
        aglt.b(aglt.this, 9, 11);
        aglt.c(aglt.this, 9, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
        this.b = new af(aglt.this);
        return;
      }
      aglt.b(aglt.this, 9, 10);
      aglt.c(aglt.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.b = new aglt.i(aglt.this);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  recv failed!!");
    }
    
    protected void Oe(int paramInt)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFailedOfLocalSomeThingHappen entity is null");
        return;
      }
      aglt.b(aglt.this, 9, 11);
      aglt.c(aglt.this, 9, 11);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenRecv)");
      this.b = new aglt.s(aglt.this);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      if (localFileManagerEntity.fProgress < 0.9F)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. start make progress pass to 100% directly");
        this.ced = true;
        aglt.this.aN(1.0F);
        return true;
      }
      did();
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      paramString = aglt.this.c;
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 9, 12);
      aglt.c(aglt.this, 9, 12);
      aglt.this.app.a().a(paramString.uniseq, paramString.nSessionId, paramString.peerUin, paramString.peerType, 12, null, 5, null);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenRecv)");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void dhT()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 9);
      aglt.c(aglt.this, 11, 9);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenRecv)");
      this.b = new aglt.g(aglt.this);
    }
    
    protected void dhU()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 10, -2);
      aglt.c(aglt.this, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
      this.b = new aglt.ae(aglt.this);
    }
    
    protected void did()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. doSomeThingOnUploadDone entity is null");
        return;
      }
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      localFileManagerEntity.fProgress = 0.0F;
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 0);
      aglt.c(aglt.this, 1, 2);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + ". doSomeThingOnUploadDone start recv offline file....)");
      aglt.this.app.a().b(aglt.this.sessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 1);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      this.b = new aglt.p(aglt.this);
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
      aglt.a(aglt.this, 9, 11, true);
      IR("StateLocalFailedWhenRecv");
      this.b = new aglt.s(aglt.this);
    }
    
    protected String vh()
    {
      return "StateUploadingWhenRecv";
    }
  }
  
  class ag
    extends aglt.l
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
    extends aglt.l
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
    extends aglt.d
  {
    public ai()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      if (aglt.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onRecvOnLineFileResult entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of accept,  waiting the cmd of starting upload");
        return;
      }
      aglt.this.Od(1);
      if (!aglt.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
        return;
      }
      aglt.this.Jm(false);
      aglt.b(aglt.this, 10, 10);
      aglt.c(aglt.this, 10, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenPause)");
      this.b = new aglt.h(aglt.this);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  recv failed!!");
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (mq("onAskSenderUpProgressResult")) {
        return;
      }
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress,  waiting the notify of progress");
        return;
      }
      aglt.this.Od(2);
      if (!aglt.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " ask progress server result = false and no handle it. here waiting response of sender on recv");
        return;
      }
      aglt.this.Jm(false);
      aglt.b(aglt.this, 10, 10);
      aglt.c(aglt.this, 10, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenPause)");
      this.b = new aglt.h(aglt.this);
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        aglt.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        aglt.this.stopAllTimer();
        break label63;
        aglt.b(aglt.this, 10, 5);
        aglt.c(aglt.this, 10, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPCWhenPause)");
        this.b = new aglt.b(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 6);
        aglt.c(aglt.this, 10, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPCWhenPause)");
        this.b = new aglt.u(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 8);
        aglt.c(aglt.this, 10, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSendWhenPause)");
        this.b = new aglt.ab(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 7);
        aglt.c(aglt.this, 10, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPCWhenPause)");
        this.b = new aglt.y(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this);
        aglt.b(aglt.this, 10, 11);
        aglt.c(aglt.this, 10, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
        this.b = new aglt.ae(aglt.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 3);
      aglt.c(aglt.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenPause)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.ah(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new aglt.n(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 10, 9, true);
      IR("StateCancelUploadWhenPause");
      this.b = new aglt.f(aglt.this);
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 9, 10);
      aglt.c(aglt.this, 9, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenRecv)");
      this.b = new aglt.aj(aglt.this);
    }
    
    protected void dhX()
    {
      if (aglt.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onSenderReplayComeOnRecv entity is null");
        return;
      }
      aglt.this.Jm(true);
      aglt.a(aglt.this);
      aglt.b(aglt.this, 10, 11);
      aglt.c(aglt.this, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
      this.b = new aglt.ae(aglt.this);
    }
    
    protected void dhY()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + "onRecvButSenderReplayTimeOut entity is null");
        return;
      }
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " you had recv the file, but sender replay time out!!!! recvCmdSucAndHadTryCount=" + aglt.this.a.cXI);
      aglt.this.Od(1);
      if (!aglt.this.alK())
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " sender replay time out and no handle it. here waiting response of asking progress");
        return;
      }
      aglt.this.Jm(false);
      if (aglt.this.a.cXI < 9223372036854775807L)
      {
        aglt.a(aglt.this, 10, 10, true);
        IR("StateChangeToOffFailedWhenPause");
        this.b = new aglt.h(aglt.this);
        return;
      }
      aglt.a(aglt.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new aglt.n(aglt.this);
    }
    
    protected void dia()
    {
      if (mq("onAskSenderUpProgressTimeOut")) {
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " you had recv the file, but ask progress time out!!!!!, recvCmdSucAndHadTryCount =" + aglt.this.a.cXI);
      aglt.this.Od(2);
      if (!aglt.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " ask progress time out and no handle it. here waiting response of sender when recv");
        return;
      }
      aglt.this.Jm(false);
      if (aglt.this.a.cXI < 9223372036854775807L)
      {
        aglt.a(aglt.this, 10, 10, true);
        IR("StateChangeToOffFailedWhenPause");
        this.b = new aglt.h(aglt.this);
        return;
      }
      aglt.a(aglt.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new aglt.n(aglt.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      if (mq("onSenderUploadProgressNotify")) {
        return;
      }
      aglt.this.Jm(true);
      aglt.a(aglt.this);
      jdMethod_if(paramInt1, paramInt2);
      aglt.a(aglt.this, 10, 11);
      aglt.a(aglt.this, 10, 14, false);
      IR("StateUploadingWhenPause");
      this.b = new aglt.ae(aglt.this);
    }
    
    protected String vh()
    {
      return "StateWaitResultWhenPause";
    }
  }
  
  class aj
    extends aglt.d
  {
    public aj()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. StateWaitingRecvResult entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of accept,  waiting the cmd of starting upload");
        return;
      }
      aglt.this.Od(1);
      if (!aglt.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " recvonlinefile result = false and no handle it. here waiting response of asking progress");
        return;
      }
      aglt.this.Jm(false);
      aglt.b(aglt.this, 9, 10);
      aglt.c(aglt.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.b = new aglt.i(aglt.this);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  recv failed!!");
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (mq("onAskSenderUpProgressResult")) {
        return;
      }
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress,  waiting the notify of progress");
        return;
      }
      aglt.this.Od(2);
      if (!aglt.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + "ask progress server result = false and no handle it. here waiting response of sender on recv");
        return;
      }
      aglt.this.Jm(false);
      aglt.b(aglt.this, 9, 10);
      aglt.c(aglt.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.b = new aglt.i(aglt.this);
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        aglt.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        aglt.this.stopAllTimer();
        break label63;
        aglt.b(aglt.this, 11, 5);
        aglt.c(aglt.this, 11, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPC)");
        this.b = new aglt.a(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 11, 6);
        aglt.c(aglt.this, 11, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPC)");
        this.b = new aglt.t(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 11, 8);
        aglt.c(aglt.this, 11, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSend)");
        this.b = new aglt.aa(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 11, 7);
        aglt.c(aglt.this, 11, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPC)");
        this.b = new aglt.x(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this);
        aglt.b(aglt.this, 9, 11);
        aglt.c(aglt.this, 9, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
        this.b = new aglt.af(aglt.this);
        paramInt = 0;
      }
    }
    
    protected void Oe(int paramInt)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFailedOfLocalSomeThingHappen entity is null");
        return;
      }
      aglt.b(aglt.this, 9, 10);
      aglt.c(aglt.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
      this.b = new aglt.i(aglt.this);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      if (localFileManagerEntity.fProgress < 0.9F)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. start make progress pass to 100% directly");
        this.ced = true;
        aglt.this.aN(1.0F);
        return true;
      }
      did();
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new aglt.g(aglt.this);
    }
    
    protected void dhU()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onPauseTrans entity is null");
        return;
      }
      aglt.b(aglt.this, 10, -2);
      aglt.c(aglt.this, 10, 15);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenPause)");
      this.b = new aglt.ai(aglt.this);
    }
    
    protected void dhX()
    {
      if (aglt.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onSenderReplayComeOnRecv entity is null");
        return;
      }
      aglt.this.Jm(true);
      aglt.a(aglt.this);
      aglt.b(aglt.this, 9, 11);
      aglt.c(aglt.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new aglt.af(aglt.this);
    }
    
    protected void dhY()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " onRecvButSenderReplayTimeOut entity is null");
        return;
      }
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " you had recv the file, but sender replay time out!!!!, recvCmdSucAndHadTryCount =" + aglt.this.a.cXI);
      aglt.this.Od(1);
      if (!aglt.this.alK())
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " sender replay time out and no handle it. here waiting response of asking progress");
        return;
      }
      aglt.this.Jm(false);
      if (aglt.this.a.cXI < 9223372036854775807L)
      {
        aglt.a(aglt.this, 9, 10, true);
        IR("StateChangeToOffFailedWhenRecv");
        this.b = new aglt.i(aglt.this);
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
        return;
      }
      aglt.a(aglt.this, 9, 12, true);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
      IR("StateExcepInvalidWhenRecv");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void dia()
    {
      if (mq("onAskSenderUpProgressTimeOut")) {
        return;
      }
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " you had recv the file, but  ask progress time out!!!!, recvCmdSucAndHadTryCount =" + aglt.this.a.cXI);
      aglt.this.Od(2);
      if (!aglt.this.alK())
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + " ask progress time out and no handle it. here waiting response of sender when recv");
        return;
      }
      aglt.this.Jm(false);
      if (aglt.this.a.cXI < 9223372036854775807L)
      {
        aglt.a(aglt.this, 9, 10, true);
        IR("StateChangeToOffFailedWhenRecv");
        this.b = new aglt.i(aglt.this);
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 15, null);
        return;
      }
      aglt.a(aglt.this, 9, 12, true);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
      IR("StateExcepInvalidWhenRecv");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void did()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. doSomeThingOnUploadDone entity is null");
        return;
      }
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      localFileManagerEntity.fProgress = 0.0F;
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 0);
      aglt.c(aglt.this, 1, 2);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + ". doSomeThingOnUploadDone start recv offline file....)");
      aglt.this.app.a().b(aglt.this.sessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 1);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      this.b = new aglt.p(aglt.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      if (mq("onSenderUploadProgressNotify")) {
        return;
      }
      aglt.this.Jm(true);
      aglt.a(aglt.this);
      jdMethod_if(paramInt1, paramInt2);
      aglt.a(aglt.this, 9, 11);
      aglt.a(aglt.this, 9, 14, false);
      IR("StateUploadingWhenRecv");
      this.b = new aglt.af(aglt.this);
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
    extends aglt.d
  {
    public b()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 5);
      aglt.c(aglt.this, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPC)");
      this.b = new aglt.a(aglt.this);
    }
    
    protected String vh()
    {
      return "StateAcceptByPCWhenPause";
    }
  }
  
  class c
    extends aglt.d
  {
    public c()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 5);
      aglt.c(aglt.this, 11, 5);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPC)");
      this.b = new aglt.a(aglt.this);
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
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->" + paramString + ")");
    }
    
    protected void Jk(boolean paramBoolean)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onRecvOnLineFileResult. ret:" + paramBoolean);
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  failed response of ask progress");
      aglt.this.dhS();
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
        QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state:" + aglt.a(aglt.this).vh() + " can not handle onFileRequestBeHandledByPC.handleType = " + str);
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
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onFailedOfLocalSomeThingHappen. type:" + paramInt);
    }
    
    d a()
    {
      return this.b;
    }
    
    protected boolean alJ()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onRecvOnLineFile.");
      return true;
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      aglt.this.c.Uuid = new String(paramString);
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onSenderUploadCompleted. type:" + paramInt + "time:" + paramLong);
      return false;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onSenderUploadException. errcode:" + paramInt + " resason:" + paramString);
    }
    
    protected void dhT()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onSenderCancelUpload. ");
    }
    
    protected void dhU()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onPauseTrans. ");
    }
    
    protected void dhV()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onResumeTrans. ");
    }
    
    protected void dhX()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onSenderReplayComeOnRecv:");
    }
    
    protected void dhY()
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onRecvButSenderReplayTimeOut:");
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
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle doSomeThingOnUploadDone:");
    }
    
    protected void die() {}
    
    protected void ie(int paramInt1, int paramInt2)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  state:" + aglt.a(aglt.this).vh() + " can not handle onSenderUploadProgressNotify. speed:" + paramInt1 + " progress:" + paramInt2);
    }
    
    protected final void jdMethod_if(int paramInt1, int paramInt2)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] make progress entity = null.handleProgressNotify");
        return;
      }
      if (paramInt2 > 100)
      {
        QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] handleProgressNotify progress > 100. progress=" + paramInt2);
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
          QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  handleProgressNotify. state:" + aglt.a(aglt.this).vh() + ". averspeed = " + paramInt1 + ". progress = " + paramInt2 + ". nOlSenderProgress =" + aglt.this.c.nOlSenderProgress + ". err notify. return");
          if (-1 != aglt.this.c.nOlSenderProgress) {
            break;
          }
          aglt.this.c.nOlSenderProgress = 0;
          aglt.this.c.lastTime = l;
          if ((aglt.this.c.status == 14) || (aglt.this.c.status == 15))
          {
            localFileManagerEntity = aglt.this.c.clone();
            localFileManagerEntity.status = 11;
            aglt.this.app.a().u(localFileManagerEntity);
            return;
            if (paramInt2 > aglt.this.c.nOlSenderProgress) {
              break label682;
            }
            if (aglt.this.c.nOlSenderProgress == 0)
            {
              if (aglt.this.c.fOlRecvSpeed <= 1.0E-007F) {
                break label682;
              }
              i = 1;
              continue;
            }
            i = 1;
            continue;
          }
          aglt.this.app.a().u(aglt.this.c);
          return;
        }
        this.ced = false;
        jx(l);
        float f1 = (100 - paramInt2) / 100.0F / (paramInt1 * 1024 / (float)aglt.this.c.fileSize);
        float f2 = aglt.this.c.fProgress;
        aglt.this.c.fOlRecvSpeed = ((0.9F - f2) / f1);
        aglt.this.c.lastTime = l;
        aglt.this.c.nOlSenderProgress = paramInt2;
        aglt.this.c.fOlRecvProgressOnNotify = aglt.this.c.fProgress;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  -----handleProgressNotify. state:" + aglt.a(aglt.this).vh() + ". averspeed = " + paramInt1 + ". progress = " + paramInt2 + ". fOlRecvSpeed = " + aglt.this.c.fOlRecvSpeed + "f/s. fOlRecvProgressOnNotify =" + aglt.this.c.fOlRecvProgressOnNotify);
        if ((aglt.this.c.status == 14) || (aglt.this.c.status == 15))
        {
          localFileManagerEntity = aglt.this.c.clone();
          localFileManagerEntity.status = 11;
          aglt.this.app.a().u(localFileManagerEntity);
          return;
        }
        aglt.this.app.a().u(aglt.this.c);
        return;
        label682:
        i = 0;
      }
    }
    
    protected void jw(long paramLong) {}
    
    protected final void jx(long paramLong)
    {
      if (aglt.this.c == null) {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] make progress entity = null.makeProgress");
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
        } while ((this.ced) || (!aglt.this.alH()));
        if (0L == aglt.this.YY)
        {
          aglt.this.YY = 102400L;
          l1 = aglt.this.c.fileSize;
          long l2 = ((float)aglt.this.c.fileSize * 0.1F);
          if (l1 > 104857600L)
          {
            aglt.this.YY = (l2 / 60L);
            if (l1 > 524288000L)
            {
              aglt.this.YY = (l2 / 120L);
              if (l1 > 1073741824L) {
                aglt.this.YY = (l2 / 180L);
              }
            }
          }
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.c.nSessionId + "] initGoSpeed =" + aglt.this.YY + "b/s");
        }
        f1 = aglt.this.c.fOlRecvSpeed;
        if (!aglt.this.alG())
        {
          l1 = (2000.0D * (aglt.this.c.fileSize * (1.0D - aglt.this.c.fOlRecvProgressOnNotify) / 102400.0D));
          f1 = (float)aglt.this.YY / (float)aglt.this.c.fileSize;
          if (l1 <= 30000L) {
            break label497;
          }
        }
        for (;;)
        {
          if (paramLong - aglt.this.c.lastTime > l1)
          {
            QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.c.nSessionId + "] state:" + aglt.a(aglt.this).vh() + " the progress maker think time out. timeOutInterval=" + l1 + "curRecvSpeed = " + f1 + ".lastTime =" + aglt.this.c.lastTime + ". makeTime =" + paramLong);
            if (!aglt.this.alG())
            {
              aglt.this.b(true, 0L);
              this.ced = true;
              return;
              l1 = (2000.0F * (0.9F - aglt.this.c.fOlRecvProgressOnNotify) / f1);
              break;
              l1 = 30000L;
              continue;
            }
            aglt.this.b(true, 0L);
            this.ced = true;
            return;
          }
        }
        f2 = (float)(paramLong - aglt.this.c.lastTime) / 1000.0F;
        f3 = f1 * f2;
        f4 = aglt.this.c.fOlRecvProgressOnNotify + f3;
        if (aglt.this.alG()) {
          break;
        }
      } while ((aglt.this.c.fProgress > 0.1F) || (Math.abs(aglt.this.c.fProgress - 0.1F) < 1.0E-008D));
      if (f4 > 0.1F) {
        aglt.this.c.fProgress = 0.1F;
      }
      for (;;)
      {
        if (paramLong - aglt.this.YX > 50000L)
        {
          aglt.this.YX = paramLong;
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.c.nSessionId + "] -----state:" + aglt.a(aglt.this).vh() + " the making progress of upload is: " + aglt.this.c.fProgress + "[curRecvSpeed=" + f1 + ".maketime=" + paramLong + ".lastTime=" + aglt.this.c.lastTime + "f/s. makeTime_s=" + f2 + "s. addProgress = " + f3 + ". timeOutInterval=" + l1 + ". filesize=" + aglt.this.c.fileSize + ". nOlSenderProgress=" + aglt.this.c.nOlSenderProgress + ". fOlRecvProgressOnNotify =" + aglt.this.c.fOlRecvProgressOnNotify + " ] ");
        }
        aglt.this.app.a().a(aglt.this.c.uniseq, aglt.this.c.nSessionId, aglt.this.c.peerUin, aglt.this.c.peerType, 16, null, 0, null);
        return;
        aglt.this.c.fProgress = f4;
        continue;
        if ((aglt.this.c.fProgress > 0.9F) || (Math.abs(aglt.this.c.fProgress - 0.9F) < 1.0E-008D)) {
          break;
        }
        if (f4 > 0.9F) {
          aglt.this.c.fProgress = 0.9F;
        } else {
          aglt.this.c.fProgress = f4;
        }
      }
    }
    
    protected final boolean mq(String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. state:" + this.b.vh() + paramString + " entity is null ");
        return true;
      }
      return false;
    }
    
    protected void onStop()
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateEnd)");
      this.b = new aglt.l(aglt.this);
    }
    
    public String vh()
    {
      return "StateBase";
    }
  }
  
  class e
    extends aglt.d
  {
    public e()
    {
      super();
    }
    
    protected boolean alJ()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      aglt.b(aglt.this, 11, 9);
      aglt.c(aglt.this, 11, 9);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenRecv)");
      this.b = new aglt.g(aglt.this);
      return true;
    }
    
    protected String vh()
    {
      return "StateCancelUploadWhenChangeToOff";
    }
  }
  
  class f
    extends aglt.d
  {
    public f()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 9);
      aglt.c(aglt.this, 11, 9);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateCancelUploadWhenRecv)");
      this.b = new aglt.g(aglt.this);
    }
    
    protected String vh()
    {
      return "StateCancelUploadWhenPause";
    }
  }
  
  class g
    extends aglt.l
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
    extends aglt.d
  {
    public h()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      if (aglt.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. StateWaitingRecvResult entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        aglt.a(aglt.this);
        aglt.a(aglt.this, 10, 11, true);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenPause)");
        this.b = new aglt.r(aglt.this);
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenPause)");
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress, not handle it");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  failed response of ask progress, not handle it");
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        aglt.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        aglt.this.dhR();
        break label63;
        aglt.b(aglt.this, 10, 5);
        aglt.c(aglt.this, 10, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPCWhenPause)");
        this.b = new aglt.b(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 6);
        aglt.c(aglt.this, 10, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPCWhenPause)");
        this.b = new aglt.u(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 8);
        aglt.c(aglt.this, 10, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSendWhenPause)");
        this.b = new aglt.ab(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 7);
        aglt.c(aglt.this, 10, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPCWhenPause)");
        this.b = new aglt.y(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this);
        aglt.b(aglt.this, 10, 11);
        aglt.c(aglt.this, 10, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffWhenPause)");
        this.b = new aglt.j(aglt.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 3);
      aglt.c(aglt.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenPause)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.ah(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new aglt.n(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 10, 9, true);
      IR("StateCancelUploadWhenPause");
      this.b = new aglt.f(aglt.this);
    }
    
    protected void dhV()
    {
      if (mq("onResumeTrans")) {}
      FileManagerEntity localFileManagerEntity;
      do
      {
        return;
        localFileManagerEntity = aglt.this.c;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "start send recv cmd.... [" + aglt.this.a.cXI + "-" + aglt.this.a.cXJ + "]");
      } while (!aglt.this.t(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
      aglt.c(aglt.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenRecv)");
      this.b = new aglt.aj(aglt.this);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      aglt.this.app.a().a(aglt.this.c.uniseq, aglt.this.c.nSessionId, aglt.this.c.peerUin, aglt.this.c.peerType, 16, null, 0, null);
    }
    
    protected void dhX()
    {
      if (aglt.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onSenderReplayComeOnRecv entity is null");
        return;
      }
      aglt.a(aglt.this);
      aglt.a(aglt.this, 10, 11, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenPause)");
      this.b = new aglt.r(aglt.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      if (mq("onSenderUploadProgressNotify")) {
        return;
      }
      aglt.a(aglt.this);
      jdMethod_if(paramInt1, paramInt2);
      aglt.a(aglt.this, 10, 11);
      aglt.a(aglt.this, 10, 14, false);
      IR("StateUploadingWhenPause");
      this.b = new aglt.ae(aglt.this);
    }
    
    protected String vh()
    {
      return "StateChangeToOffFailedWhenPause";
    }
  }
  
  class i
    extends aglt.d
  {
    public i()
    {
      super();
    }
    
    protected void Jk(boolean paramBoolean)
    {
      if (aglt.this.c == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. StateWaitingRecvResult entity is null");
        return;
      }
      if (paramBoolean == true)
      {
        aglt.a(aglt.this);
        aglt.a(aglt.this, 9, 11, true);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenRecv)");
        this.b = new aglt.s(aglt.this);
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
    }
    
    protected void Jl(boolean paramBoolean)
    {
      if (paramBoolean == true)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  success response of ask progress, not handle it");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + " recv  failed response of ask progress, not handle it");
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        aglt.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        aglt.this.dhR();
        break label63;
        aglt.b(aglt.this, 13, 5);
        aglt.c(aglt.this, 13, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPCWhenToOffFailed)");
        this.b = new aglt.c(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 13, 6);
        aglt.c(aglt.this, 13, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPCWhenToOffFailed)");
        this.b = new aglt.v(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 13, 8);
        aglt.c(aglt.this, 13, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSendWhenToOffFailed)");
        this.b = new aglt.ac(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 13, 7);
        aglt.c(aglt.this, 13, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
        this.b = new aglt.z(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this);
        aglt.b(aglt.this, 13, 11);
        aglt.c(aglt.this, 13, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffWhenToOffFailed)");
        this.b = new aglt.k(aglt.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 0);
      aglt.c(aglt.this, 1, 0);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.p(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (mq("onSenderUploadException")) {
        return;
      }
      aglt.a(aglt.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void dhT()
    {
      if (mq("onSenderCancelUpload")) {
        return;
      }
      aglt.a(aglt.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new aglt.g(aglt.this);
    }
    
    protected void dhV()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null) {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
      }
      do
      {
        return;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "start send recv cmd.... [" + aglt.this.a.cXI + "-" + aglt.this.a.cXJ + "]");
      } while (!aglt.this.t(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId));
      aglt.c(aglt.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenRecv)");
      this.b = new aglt.aj(aglt.this);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
      aglt.this.app.a().a(aglt.this.c.uniseq, aglt.this.c.nSessionId, aglt.this.c.peerUin, aglt.this.c.peerType, 16, null, 0, null);
    }
    
    protected void dhX()
    {
      if (mq("onSenderReplayComeOnRecv")) {
        return;
      }
      aglt.a(aglt.this);
      aglt.a(aglt.this, 9, 11, true);
      IR("StateLocalFailedWhenRecv");
      this.b = new aglt.s(aglt.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      if (mq("onSenderUploadProgressNotify")) {
        return;
      }
      aglt.a(aglt.this);
      jdMethod_if(paramInt1, paramInt2);
      aglt.a(aglt.this, 9, 11, true);
      IR("StateLocalFailedWhenRecv");
      this.b = new aglt.s(aglt.this);
    }
    
    protected String vh()
    {
      return "StateChangeToOffFailedWhenRecv";
    }
  }
  
  class j
    extends aglt.d
  {
    public j()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 9, 11);
      aglt.c(aglt.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new aglt.af(aglt.this);
    }
    
    protected String vh()
    {
      return "StateChangeToOffWhenPause";
    }
  }
  
  class k
    extends aglt.d
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
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      aglt.a(aglt.this, 1, 0, true);
      IR("StateGotoOffFileProcess");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.p(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (mq("onSenderUploadException")) {
        return;
      }
      aglt.a(aglt.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void dhT()
    {
      if (mq("onSenderCancelUpload")) {
        return;
      }
      aglt.a(aglt.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new aglt.g(aglt.this);
    }
    
    protected void dhV()
    {
      if (mq("onResumeTrans")) {
        return;
      }
      aglt.a(aglt.this, 9, 11);
      aglt.a(aglt.this, 9, 14, false);
      IR("StateUploadingWhenRecv");
      this.b = new aglt.af(aglt.this);
      aglt.this.b(true, 0L);
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
    extends aglt.d
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
    extends aglt.d
  {
    public m()
    {
      super();
    }
    
    protected boolean alJ()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      aglt.b(aglt.this, 9, 12);
      aglt.c(aglt.this, 9, 12);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenRecv)");
      this.b = new aglt.o(aglt.this);
      return true;
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 11, 13);
      aglt.c(aglt.this, 11, 13);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadoneWhenChangeToOff)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.ag(aglt.this);
      return true;
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
      aglt.b(aglt.this, 11, 11);
      aglt.c(aglt.this, 11, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenChangeToOff)");
      this.b = new aglt.ad(aglt.this);
    }
    
    protected String vh()
    {
      return "StateExcepInvalidWhenChangeToOff";
    }
  }
  
  class n
    extends aglt.d
  {
    public n()
    {
      super();
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        aglt.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        aglt.this.dhR();
        break label63;
        aglt.b(aglt.this, 10, 5);
        aglt.c(aglt.this, 10, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPCWhenPause)");
        this.b = new aglt.b(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 6);
        aglt.c(aglt.this, 10, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPCWhenPause)");
        this.b = new aglt.u(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 8);
        aglt.c(aglt.this, 10, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSendWhenPause)");
        this.b = new aglt.ab(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 10, 7);
        aglt.c(aglt.this, 10, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPCWhenPause)");
        this.b = new aglt.y(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this);
        aglt.b(aglt.this, 10, 11);
        aglt.c(aglt.this, 10, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
        this.b = new aglt.ae(aglt.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 3);
      aglt.c(aglt.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.p(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new n(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 10, 9, true);
      IR("StateCancelUploadWhenPause");
      this.b = new aglt.f(aglt.this);
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 9, 12);
      aglt.c(aglt.this, 9, 12);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenRecv)");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void dhX()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onSenderReplayComeOnRecv entity is null");
        return;
      }
      aglt.a(aglt.this);
      aglt.a(aglt.this, 10, 11, true);
      IR("StateLocalFailedWhenPause");
      this.b = new aglt.r(aglt.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      jdMethod_if(paramInt1, paramInt2);
      aglt.b(aglt.this, 10, 11);
      aglt.c(aglt.this, 10, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenPause)");
      this.b = new aglt.ae(aglt.this);
    }
    
    protected String vh()
    {
      return "StateExcepInvalidWhenPause";
    }
  }
  
  class o
    extends aglt.l
  {
    public o()
    {
      super();
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        aglt.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        aglt.this.dhR();
        break label63;
        aglt.b(aglt.this, 11, 5);
        aglt.c(aglt.this, 11, 5);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateAcceptByPC)");
        this.b = new aglt.a(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 11, 6);
        aglt.c(aglt.this, 11, 6);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPC)");
        this.b = new aglt.t(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 11, 8);
        aglt.c(aglt.this, 11, 8);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSenderCancelSend)");
        this.b = new aglt.aa(aglt.this);
        paramInt = i;
        continue;
        aglt.b(aglt.this, 11, 7);
        aglt.c(aglt.this, 11, 7);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPC)");
        this.b = new aglt.x(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this);
        aglt.b(aglt.this, 11, 11);
        aglt.c(aglt.this, 11, 14);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenChangeToOff)");
        this.b = new aglt.ad(aglt.this);
        paramInt = 0;
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 5);
      }
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 0);
      aglt.c(aglt.this, 1, 0);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.p(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new o(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new aglt.g(aglt.this);
    }
    
    protected void dhX()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFailedOfLocalSomeThingHappen entity is null");
        return;
      }
      aglt.a(aglt.this);
      aglt.a(aglt.this, 9, 11, true);
      IR("StateLocalFailedWhenRecv");
      this.b = new aglt.s(aglt.this);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      jdMethod_if(paramInt1, paramInt2);
      aglt.b(aglt.this, 9, 11);
      aglt.c(aglt.this, 9, 11);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateLocalFailedWhenRecv)");
      this.b = new aglt.s(aglt.this);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 6, null);
    }
    
    protected String vh()
    {
      return "StateExcepInvalidWhenRecv";
    }
  }
  
  class p
    extends aglt.l
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
    extends aglt.d
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
      aglt.a(aglt.this, 9, 11);
      aglt.a(aglt.this, 9, 14, false);
      IR("StateUploadingWhenRecv");
      this.b = new aglt.af(aglt.this);
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      aglt.this.app.a().a(aglt.this.c.uniseq, aglt.this.c.nSessionId, aglt.this.c.peerUin, aglt.this.c.peerType, 16, null, 0, null);
      return true;
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      if (mq("onSenderUploadCompleted")) {
        return false;
      }
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      localFileManagerEntity.setCloudType(1);
      aglt.a(aglt.this, 11, 13, true);
      IR("StateUploadoneWhenChangeToOff");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.ag(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (mq("onSenderUploadException")) {
        return;
      }
      aglt.a(aglt.this, 11, 12, true);
      IR("StateExcepInvalidWhenChangeToOff");
      this.b = new aglt.m(aglt.this);
    }
    
    protected void dhT()
    {
      if (mq("onSenderCancelUpload")) {
        return;
      }
      aglt.a(aglt.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new aglt.g(aglt.this);
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
    extends aglt.d
  {
    public r()
    {
      super();
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 3);
      aglt.c(aglt.this, 1, 3);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.p(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 10, 12, true);
      IR("StateExcepInvalidWhenPause");
      this.b = new aglt.n(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 10, 9, true);
      IR("StateCancelUploadWhenPause");
      this.b = new aglt.f(aglt.this);
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.c(aglt.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new aglt.af(aglt.this);
      aglt.this.b(true, 0L);
      aglt.this.app.a().a(aglt.this.c.uniseq, aglt.this.c.nSessionId, aglt.this.c.peerUin, aglt.this.c.peerType, 16, null, 0, null);
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
    extends aglt.d
  {
    public s()
    {
      super();
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      aglt.this.au(paramLong, localFileManagerEntity.peerUin);
      localFileManagerEntity.setCloudType(1);
      aglt.b(aglt.this, 1, 0);
      aglt.c(aglt.this, 1, 0);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.p(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 9, 12, true);
      IR("StateExcepInvalidWhenRecv");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void dhT()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 11, 9, true);
      IR("StateCancelUploadWhenRecv");
      this.b = new aglt.g(aglt.this);
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.c(aglt.this, 9, 14);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateUploadingWhenRecv)");
      this.b = new aglt.af(aglt.this);
      aglt.this.b(true, 0L);
      aglt.this.app.a().a(aglt.this.c.uniseq, aglt.this.c.nSessionId, aglt.this.c.peerUin, aglt.this.c.peerType, 16, null, 0, null);
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
    extends aglt.l
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
    extends aglt.d
  {
    public u()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 6);
      aglt.c(aglt.this, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPC)");
      this.b = new aglt.t(aglt.this);
    }
    
    protected String vh()
    {
      return "StateRefuseByPCWhenPause";
    }
  }
  
  class v
    extends aglt.d
  {
    public v()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 6);
      aglt.c(aglt.this, 11, 6);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateRefuseByPC)");
      this.b = new aglt.t(aglt.this);
    }
    
    protected String vh()
    {
      return "StateRefuseByPCWhenToOffFailed";
    }
  }
  
  class w
    extends aglt.d
  {
    public w()
    {
      super();
    }
    
    protected void Ob(int paramInt)
    {
      int i = 1;
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onFileRequestBeHandledByPC entity is null");
        return;
      }
      if (5 != paramInt)
      {
        aglt.this.stopAllTimer();
        switch (paramInt)
        {
        default: 
          label63:
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + aglt.this.sessionId + "]  is not foud . handledbypc type error:" + paramInt);
          paramInt = 0;
        }
      }
      while (paramInt != 0)
      {
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 0, null);
        return;
        aglt.this.dhR();
        break label63;
        aglt.a(aglt.this, 11, 5, true);
        IR("StateAcceptByPC");
        this.b = new aglt.a(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this, 11, 6, true);
        IR("StateRefuseByPC");
        this.b = new aglt.t(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this, 11, 8, true);
        IR("StateSenderCancelSend");
        this.b = new aglt.aa(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this, 11, 7, true);
        IR("StateSaveToWeiYunByPC");
        this.b = new aglt.x(aglt.this);
        paramInt = i;
        continue;
        aglt.a(aglt.this);
        aglt.a(aglt.this, 11, 11);
        aglt.a(aglt.this, 11, 14, false);
        IR("StateUploadingWhenChangeToOff");
        this.b = new aglt.ad(aglt.this);
        paramInt = 0;
      }
    }
    
    protected boolean alJ()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      aglt.b(aglt.this, 9, 10);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "start send recv cmd.... [" + aglt.this.a.cXI + "-" + aglt.this.a.cXJ + "]");
      boolean bool = aglt.this.t(localFileManagerEntity.peerUin, localFileManagerEntity.nOLfileSessionId);
      if (bool)
      {
        aglt.c(aglt.this, 9, 15);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateWaitResultWhenRecv)");
        this.b = new aglt.aj(aglt.this);
      }
      for (;;)
      {
        aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 10, null, 6, null);
        return bool;
        aglt.c(aglt.this, 9, 10);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateChangeToOffFailedWhenRecv)");
        this.b = new aglt.i(aglt.this);
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]  failure to send recv cmd!!! ");
      }
    }
    
    protected boolean b(int paramInt, String paramString, long paramLong)
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return false;
      }
      localFileManagerEntity.Uuid = new String(paramString);
      localFileManagerEntity.fProgress = 0.0F;
      if ((ahav.getFileType(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        aglt.this.app.a().a(localFileManagerEntity, 7);
      }
      localFileManagerEntity.setCloudType(1);
      aglt.a(aglt.this, 1, -1, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateGotoOffFileProcess)");
      aglt.this.app.a().b(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
      this.b = new aglt.p(aglt.this);
      return true;
    }
    
    protected void ct(int paramInt, String paramString)
    {
      super.ct(paramInt, paramString);
    }
    
    protected void dhT()
    {
      FileManagerEntity localFileManagerEntity = aglt.this.c;
      if (localFileManagerEntity == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.a(aglt.this, 11, 9, true);
      aglt.this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 12, null, 5, null);
      IR("StateCancelUploadWhenRecv");
      this.b = new aglt.g(aglt.this);
    }
    
    protected void die()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. onCheckIsTooLongSession entity is null");
        return;
      }
      aglt.a(aglt.this, 9, 12, true);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateExcepInvalidWhenRecv)");
      this.b = new aglt.o(aglt.this);
    }
    
    protected void ie(int paramInt1, int paramInt2)
    {
      aglt.a(aglt.this);
      jdMethod_if(paramInt1, paramInt2);
      aglt.a(aglt.this, 11, 11);
      aglt.a(aglt.this, 11, 14, false);
      IR("StateUploadingWhenChangeToOff");
      this.b = new aglt.ad(aglt.this);
    }
    
    protected String vh()
    {
      return "StateRequest";
    }
  }
  
  class x
    extends aglt.l
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
    extends aglt.d
  {
    public y()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 7);
      aglt.c(aglt.this, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPC)");
      this.b = new aglt.x(aglt.this);
    }
    
    protected String vh()
    {
      return "StateSaveToWeiYunByPCWhenPause";
    }
  }
  
  class z
    extends aglt.d
  {
    public z()
    {
      super();
    }
    
    protected void dhV()
    {
      if (aglt.this.c == null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "]. recvOnLineFile entity is null");
        return;
      }
      aglt.b(aglt.this, 11, 7);
      aglt.c(aglt.this, 11, 7);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + aglt.this.sessionId + "] state change :(" + this.b.vh() + "->StateSaveToWeiYunByPC)");
      this.b = new aglt.x(aglt.this);
    }
    
    protected String vh()
    {
      return "StateSaveToWeiYunByPCWhenToOffFailed";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aglt
 * JD-Core Version:    0.7.0.1
 */