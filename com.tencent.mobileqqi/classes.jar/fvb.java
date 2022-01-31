import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class fvb
{
  protected fvb a;
  public boolean a;
  protected boolean b;
  
  public fvb(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    this.jdField_a_of_type_Fvb = this;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public fvb a()
  {
    return this.jdField_a_of_type_Fvb;
  }
  
  public String a()
  {
    return "StateBase";
  }
  
  public void a()
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onResumeTrans. ");
  }
  
  public void a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow:" + String.valueOf(paramInt);
    }
    for (;;)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onFileRequestBeHandledByPC.handleType = " + str);
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
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onSenderUploadProgressNotify. speed:" + paramInt1 + " progress:" + paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onSenderUploadException. errcode:" + paramInt + " resason:" + paramString);
  }
  
  public void a(long paramLong) {}
  
  protected final void a(String paramString)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Fvb.a() + "->" + paramString + ")");
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onRecvOnLineFileResult. ret:" + paramBoolean);
  }
  
  public boolean a()
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onRecvOnLineFile.");
    return true;
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. recvOnLineFile entity is null");
      return false;
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramString);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onSenderUploadCompleted. type:" + paramInt + "time:" + paramLong);
    return false;
  }
  
  protected final boolean a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. state:" + this.jdField_a_of_type_Fvb.a() + paramString + " entity is null ");
      return true;
    }
    return false;
  }
  
  public void b()
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onSenderCancelUpload. ");
  }
  
  public void b(int paramInt)
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onFailedOfLocalSomeThingHappen. type:" + paramInt);
  }
  
  protected final void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] make progress entity = null.handleProgressNotify");
      return;
    }
    if (paramInt2 > 100)
    {
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] handleProgressNotify progress > 100. progress=" + paramInt2);
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
        QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  handleProgressNotify. state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + ". averspeed = " + paramInt1 + ". progress = " + paramInt2 + ". nOlSenderProgress =" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress + ". err notify. return");
        if (-1 != this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress = 0;
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = l;
        if ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 14) || (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 15))
        {
          localFileManagerEntity = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.clone();
          localFileManagerEntity.status = 11;
          this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
          return;
          if (paramInt2 > this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress) {
            break label684;
          }
          if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress == 0)
          {
            if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed <= 1.0E-007F) {
              break label684;
            }
            i = 1;
            continue;
          }
          i = 1;
          continue;
        }
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        return;
      }
      this.jdField_b_of_type_Boolean = false;
      b(l);
      float f1 = (100 - paramInt2) / 100.0F / (paramInt1 * 1024 / (float)this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      float f2 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed = ((0.9F - f2) / f1);
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = l;
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress = paramInt2;
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  -----handleProgressNotify. state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + ". averspeed = " + paramInt1 + ". progress = " + paramInt2 + ". fOlRecvSpeed = " + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed + "f/s" + ". fOlRecvProgressOnNotify =" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify);
      if ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 14) || (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 15))
      {
        localFileManagerEntity = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.clone();
        localFileManagerEntity.status = 11;
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      label684:
      i = 0;
    }
  }
  
  protected final void b(long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] make progress entity = null.makeProgress");
    }
    long l1;
    float f1;
    label494:
    float f2;
    float f3;
    float f4;
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.b()));
      if (0L == this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.k)
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.k = 102400L;
        l1 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
        long l2 = ((float)this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * 0.1F);
        if (l1 > 104857600L)
        {
          this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.k = (l2 / 60L);
          if (l1 > 524288000L)
          {
            this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.k = (l2 / 120L);
            if (l1 > 1073741824L) {
              this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.k = (l2 / 180L);
            }
          }
        }
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] initGoSpeed =" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.k + "b/s");
      }
      f1 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed;
      if (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a())
      {
        l1 = (2000.0D * (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * (1.0D - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify) / 102400.0D));
        f1 = (float)this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.k / (float)this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
        if (l1 <= 30000L) {
          break label494;
        }
      }
      for (;;)
      {
        if (paramLong - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime > l1)
        {
          QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " the progress maker think time out. timeOutInterval=" + l1 + "curRecvSpeed = " + f1 + ".lastTime =" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime + ". makeTime =" + paramLong);
          if (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a())
          {
            this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a(true, 0L);
            this.jdField_b_of_type_Boolean = true;
            return;
            l1 = (2000.0F * (0.9F - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify) / f1);
            break;
            l1 = 30000L;
            continue;
          }
          this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a(true, 0L);
          this.jdField_b_of_type_Boolean = true;
          return;
        }
      }
      f2 = (float)(paramLong - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) / 1000.0F;
      f3 = f1 * f2;
      f4 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify + f3;
      if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a()) {
        break;
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress > 0.1F) || (Math.abs(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress - 0.1F) < 1.0E-008D));
    if (f4 > 0.1F) {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.1F;
    }
    for (;;)
    {
      if (paramLong - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.j > 50000L)
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.j = paramLong;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] -----state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " the making progress of upload is: " + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress + "[curRecvSpeed=" + f1 + ".maketime=" + paramLong + ".lastTime=" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime + "f/s. makeTime_s=" + f2 + "s. addProgress = " + f3 + ". timeOutInterval=" + l1 + ". filesize=" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + ". nOlSenderProgress=" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress + ". fOlRecvProgressOnNotify =" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify + " ] ");
      }
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      return;
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = f4;
      continue;
      if ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress > 0.9F) || (Math.abs(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress - 0.9F) < 1.0E-008D)) {
        break;
      }
      if (f4 > 0.9F) {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.9F;
      } else {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = f4;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Fvb.a() + " recv  success response of ask progress");
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Fvb.a() + " recv  failed response of ask progress");
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.c();
    i();
  }
  
  public void c()
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onPauseTrans. ");
  }
  
  protected void d()
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onUploadTimeOut:");
  }
  
  public void e()
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onSenderReplayComeOnRecv:");
  }
  
  public void f()
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle onRecvButSenderReplayTimeOut:");
  }
  
  public void g()
  {
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]  state:" + OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a() + " can not handle doSomeThingOnUploadDone:");
  }
  
  public void h() {}
  
  public void i()
  {
    a(4, null);
  }
  
  public void j()
  {
    a(3, null);
  }
  
  public void k()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Fvb.a() + "->StateEnd)");
    this.jdField_a_of_type_Fvb = new fvj(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fvb
 * JD-Core Version:    0.7.0.1
 */