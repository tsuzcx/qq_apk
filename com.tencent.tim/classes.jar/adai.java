import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

public class adai
  extends adah
{
  private adai.a a;
  protected QQAppInterface d;
  
  public adai(adai.a parama)
  {
    this.a = parama;
  }
  
  public adai(adai.a parama, QQAppInterface paramQQAppInterface)
  {
    this.a = parama;
    this.d = paramQQAppInterface;
  }
  
  private void aS(boolean paramBoolean, Object paramObject)
  {
    if (this.a == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
    }
    while (4 != this.a.dI()) {
      return;
    }
    this.a.b(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, this + "      Follow isSuccess:" + paramBoolean);
    }
    oidb_cmd0xc96.RspBody localRspBody;
    if (paramBoolean)
    {
      localRspBody = new oidb_cmd0xc96.RspBody();
      if (!(paramObject instanceof byte[])) {}
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        this.a.onSuccess(localRspBody);
        this.a.c(paramBoolean, paramObject);
        removeSelf();
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("AppletsObserver", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        this.a.p(paramObject);
        continue;
      }
      catch (Exception localException)
      {
        QLog.w("AppletsObserver", 4, localException.getMessage(), localException);
        this.a.p(paramObject);
        continue;
      }
      this.a.p(paramObject);
      continue;
      this.a.p(paramObject);
    }
  }
  
  private void aT(boolean paramBoolean, Object paramObject)
  {
    if (this.a == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
    }
    while (5 != this.a.dI()) {
      return;
    }
    this.a.b(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, this + "      unFollow isSuccess:" + paramBoolean);
    }
    oidb_cmd0xc96.RspBody localRspBody;
    if (paramBoolean)
    {
      localRspBody = new oidb_cmd0xc96.RspBody();
      if (!(paramObject instanceof byte[])) {}
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        this.a.onSuccess(localRspBody);
        this.a.c(paramBoolean, paramObject);
        removeSelf();
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("AppletsObserver", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        this.a.p(paramObject);
        continue;
      }
      catch (Exception localException)
      {
        QLog.w("AppletsObserver", 4, localException.getMessage(), localException);
        this.a.p(paramObject);
        continue;
      }
      this.a.p(paramObject);
      continue;
      this.a.p(paramObject);
    }
  }
  
  private void aU(boolean paramBoolean, Object paramObject)
  {
    if (this.a == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
    }
    while (7 != this.a.dI()) {
      return;
    }
    this.a.b(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, "PublicAccountNotifySetting isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      this.a.onSuccess(paramObject);
    }
    for (;;)
    {
      this.a.c(paramBoolean, paramObject);
      removeSelf();
      return;
      this.a.p(paramObject);
    }
  }
  
  private void removeSelf()
  {
    if (this.d != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "removeObserver  " + this);
      }
      this.d.removeObserver(this);
    }
  }
  
  public void cF(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      super.onUpdate(paramInt, paramBoolean, paramObject);
    case 6: 
      return;
    case 4: 
      aS(paramBoolean, paramObject);
      return;
    case 5: 
      aT(paramBoolean, paramObject);
      return;
    }
    aU(paramBoolean, paramObject);
  }
  
  public static abstract class a
  {
    public abstract void b(boolean paramBoolean, Object paramObject);
    
    public abstract void c(boolean paramBoolean, Object paramObject);
    
    public abstract int dI();
    
    public abstract void onSuccess(Object paramObject);
    
    public abstract void p(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adai
 * JD-Core Version:    0.7.0.1
 */