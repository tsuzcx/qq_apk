package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c.a;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.transport.DatagramTransport.a;
import com.huawei.hms.support.log.HMSLog;

public class IPCCallback
  extends c.a
{
  private final Class<? extends IMessageEntity> a;
  private final DatagramTransport.a b;
  
  public IPCCallback(Class<? extends IMessageEntity> paramClass, DatagramTransport.a parama)
  {
    this.a = paramClass;
    this.b = parama;
  }
  
  public void call(b paramb)
    throws RemoteException
  {
    if ((paramb == null) || (TextUtils.isEmpty(paramb.a)))
    {
      HMSLog.e("IPCCallback", "In call, URI cannot be empty.");
      throw new RemoteException();
    }
    e locale = a.a(paramb.c());
    Object localObject1 = null;
    Object localObject2;
    if (paramb.b() > 0)
    {
      localObject2 = newResponseInstance();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        locale.a(paramb.a(), (IMessageEntity)localObject2);
        localObject1 = localObject2;
      }
    }
    if (paramb.b != null)
    {
      localObject2 = new ResponseHeader();
      locale.a(paramb.b, (IMessageEntity)localObject2);
      this.b.a(((ResponseHeader)localObject2).getStatusCode(), localObject1);
      return;
    }
    this.b.a(0, localObject1);
  }
  
  protected IMessageEntity newResponseInstance()
  {
    if (this.a != null) {}
    try
    {
      IMessageEntity localIMessageEntity = (IMessageEntity)this.a.newInstance();
      return localIMessageEntity;
    }
    catch (InstantiationException localInstantiationException)
    {
      HMSLog.e("IPCCallback", "In newResponseInstance, instancing exception." + localInstantiationException.getMessage());
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label21:
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.api.IPCCallback
 * JD-Core Version:    0.7.0.1
 */