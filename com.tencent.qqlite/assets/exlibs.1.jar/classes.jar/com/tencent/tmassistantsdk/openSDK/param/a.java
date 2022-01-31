package com.tencent.tmassistantsdk.openSDK.param;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCCmd;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCResponse;

public class a
{
  private static int a = 0;
  
  public static JceStruct a(IPCResponse paramIPCResponse)
  {
    JceStruct localJceStruct = a(IPCCmd.convert(paramIPCResponse.head.cmdId).toString());
    if ((localJceStruct != null) && (paramIPCResponse.body.length > 0)) {
      try
      {
        paramIPCResponse = new JceInputStream(paramIPCResponse.body);
        paramIPCResponse.setServerEncoding("utf-8");
        localJceStruct.readFrom(paramIPCResponse);
        return localJceStruct;
      }
      catch (Exception paramIPCResponse)
      {
        paramIPCResponse.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private static JceStruct a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = a.class.getPackage().getName() + ".jce." + paramString;
    paramString = paramString + "Response";
    try
    {
      paramString = (JceStruct)Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static IPCRequest a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    IPCRequest localIPCRequest = new IPCRequest();
    Object localObject = new IPCHead();
    int i = a;
    a = i + 1;
    ((IPCHead)localObject).requestId = i;
    if (paramJceStruct == null)
    {
      i = -1;
      ((IPCHead)localObject).cmdId = i;
      ((IPCHead)localObject).hostPackageName = f.b(f.a().b());
      ((IPCHead)localObject).hostVersionCode = String.valueOf(f.c(f.a().b()));
      localIPCRequest.head = ((IPCHead)localObject);
      if (paramJceStruct != null) {
        break label128;
      }
    }
    for (paramJceStruct = null;; paramJceStruct = ((JceOutputStream)localObject).toByteArray())
    {
      localIPCRequest.body = paramJceStruct;
      return localIPCRequest;
      String str = paramJceStruct.getClass().getSimpleName();
      i = IPCCmd.convert(str.substring(0, str.length() - 7)).value();
      break;
      label128:
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("utf-8");
      paramJceStruct.writeTo((JceOutputStream)localObject);
    }
  }
  
  public static IPCResponse a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      IPCResponse localIPCResponse = new IPCResponse();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localIPCResponse.readFrom(paramArrayOfByte);
        paramArrayOfByte = localIPCResponse;
        if (!TextUtils.isEmpty(localIPCResponse.head.hostPackageName))
        {
          paramArrayOfByte = localIPCResponse.body;
          byte[] arrayOfByte = "ji*9^&43U0X-~./(".getBytes();
          localIPCResponse.body = new e().a(paramArrayOfByte, arrayOfByte);
          return localIPCResponse;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(IPCRequest paramIPCRequest)
  {
    if (paramIPCRequest == null) {}
    do
    {
      return null;
      localObject = paramIPCRequest.body;
      byte[] arrayOfByte = "ji*9^&43U0X-~./(".getBytes();
      paramIPCRequest.body = new e().b((byte[])localObject, arrayOfByte);
    } while (paramIPCRequest == null);
    Object localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding("utf-8");
    paramIPCRequest.writeTo((JceOutputStream)localObject);
    return ((JceOutputStream)localObject).toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.a
 * JD-Core Version:    0.7.0.1
 */