package com.tencent.mobileqq.service.qzone;

import android.os.Bundle;
import android.os.RemoteException;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneRequestEncoder;
import java.util.HashMap;
import java.util.List;

public class QZoneService
  extends BaseProtocolCoder
{
  private static String[] a = { "QzoneService", "SQQzoneSvc" };
  
  private UniPacket a(String paramString)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("utf8");
    a(localUniPacket);
    localUniPacket.put("uin", Long.valueOf(Long.parseLong(paramString)));
    return localUniPacket;
  }
  
  private Object a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = QZoneRequestEncoder.a(paramFromServiceMsg.getWupBuffer());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "decodeGetQZoneCover|jceObj = " + paramFromServiceMsg);
    }
    return paramFromServiceMsg;
  }
  
  private void a(UniPacket paramUniPacket)
  {
    paramUniPacket.setEncodeName("utf8");
    paramUniPacket.put("version", Integer.valueOf(1091030));
    paramUniPacket.put("Q-UA", AppSetting.b());
    paramUniPacket.put("rupt", Boolean.valueOf(false));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    Object localObject = paramFromServiceMsg.getWupBuffer();
    paramToServiceMsg = new UniPacket(true);
    paramToServiceMsg.setEncodeName("utf-8");
    localObject = a((byte[])localObject);
    if (localObject != null) {
      paramToServiceMsg.decode((byte[])localObject);
    }
    if (((Integer)paramToServiceMsg.get("iRet")).intValue() >= 0)
    {
      localObject = new UniAttribute();
      ((UniAttribute)localObject).setEncodeName("utf-8");
      ((UniAttribute)localObject).decode((byte[])paramToServiceMsg.get("cannon"));
      if (((Integer)((UniAttribute)localObject).get("ret")).intValue() >= 0)
      {
        int i = ((Integer)((UniAttribute)localObject).get("ls")).intValue();
        int j = ((Integer)((UniAttribute)localObject).get("vc")).intValue();
        paramToServiceMsg = (List)((UniAttribute)localObject).get("l");
        paramFromServiceMsg.setMsgSuccess();
        paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
        paramFromServiceMsg.getAttributes().put("ls", Integer.valueOf(i));
        paramFromServiceMsg.getAttributes().put("vc", Integer.valueOf(j));
        return;
      }
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgFail();
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 175	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 177	java/io/ByteArrayInputStream:<init>	([B)V
    //   10: astore_3
    //   11: new 179	java/io/DataInputStream
    //   14: dup
    //   15: aload_3
    //   16: invokespecial 182	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore 4
    //   21: aload_2
    //   22: astore_1
    //   23: aload 4
    //   25: invokevirtual 185	java/io/DataInputStream:readInt	()I
    //   28: iconst_4
    //   29: isub
    //   30: newarray byte
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload 4
    //   37: aload_2
    //   38: invokevirtual 189	java/io/DataInputStream:read	([B)I
    //   41: pop
    //   42: aload_3
    //   43: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   46: aload 4
    //   48: invokevirtual 193	java/io/DataInputStream:close	()V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: aload_3
    //   55: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   58: aload 4
    //   60: invokevirtual 193	java/io/DataInputStream:close	()V
    //   63: aload_1
    //   64: areturn
    //   65: astore_2
    //   66: aload_1
    //   67: areturn
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 192	java/io/ByteArrayInputStream:close	()V
    //   73: aload 4
    //   75: invokevirtual 193	java/io/DataInputStream:close	()V
    //   78: aload_1
    //   79: athrow
    //   80: astore_2
    //   81: goto -3 -> 78
    //   84: astore_1
    //   85: aload_2
    //   86: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	QZoneService
    //   0	87	1	paramArrayOfByte	byte[]
    //   1	51	2	arrayOfByte	byte[]
    //   53	1	2	localException1	Exception
    //   65	1	2	localException2	Exception
    //   80	6	2	localException3	Exception
    //   10	60	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   19	55	4	localDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   23	33	53	java/lang/Exception
    //   35	42	53	java/lang/Exception
    //   54	63	65	java/lang/Exception
    //   23	33	68	finally
    //   35	42	68	finally
    //   69	78	80	java/lang/Exception
    //   42	51	84	java/lang/Exception
  }
  
  private byte[] b(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = a(paramToServiceMsg.getUin());
    localUniPacket.put("uin", Long.valueOf(Long.parseLong(paramToServiceMsg.getUin())));
    a(localUniPacket);
    localUniPacket.setServantName("QzoneServer");
    localUniPacket.setFuncName("GetNewAndUnread");
    return b(localUniPacket.encode());
  }
  
  /* Error */
  private byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 218	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 219	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: new 221	java/io/DataOutputStream
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 224	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_3
    //   17: aload_3
    //   18: aload_1
    //   19: arraylength
    //   20: iconst_4
    //   21: iadd
    //   22: invokevirtual 228	java/io/DataOutputStream:writeInt	(I)V
    //   25: aload_3
    //   26: aload_1
    //   27: invokevirtual 231	java/io/DataOutputStream:write	([B)V
    //   30: aload_2
    //   31: invokevirtual 234	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 235	java/io/ByteArrayOutputStream:close	()V
    //   39: aload_3
    //   40: invokevirtual 236	java/io/DataOutputStream:close	()V
    //   43: aload_1
    //   44: areturn
    //   45: astore_1
    //   46: aload_2
    //   47: invokevirtual 235	java/io/ByteArrayOutputStream:close	()V
    //   50: aload_3
    //   51: invokevirtual 236	java/io/DataOutputStream:close	()V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_1
    //   57: aconst_null
    //   58: areturn
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 235	java/io/ByteArrayOutputStream:close	()V
    //   64: aload_3
    //   65: invokevirtual 236	java/io/DataOutputStream:close	()V
    //   68: aload_1
    //   69: athrow
    //   70: astore_2
    //   71: goto -3 -> 68
    //   74: astore_2
    //   75: aload_1
    //   76: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	QZoneService
    //   0	77	1	paramArrayOfByte	byte[]
    //   7	54	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   70	1	2	localException1	Exception
    //   74	1	2	localException2	Exception
    //   16	49	3	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	35	45	java/lang/Exception
    //   46	54	56	java/lang/Exception
    //   17	35	59	finally
    //   60	68	70	java/lang/Exception
    //   35	43	74	java/lang/Exception
  }
  
  private byte[] c(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = a(paramToServiceMsg.getUin());
    localUniPacket.put("uin", Long.valueOf(Long.parseLong(paramToServiceMsg.getUin())));
    a(localUniPacket);
    localUniPacket.setServantName("FriendServer");
    localUniPacket.setFuncName("knrsNew");
    new UniAttribute();
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.setEncodeName("utf8");
    int i = paramToServiceMsg.extraData.getInt("ps");
    int j = paramToServiceMsg.extraData.getInt("pn");
    localUniAttribute.put("ps", Integer.valueOf(i));
    localUniAttribute.put("pn", Integer.valueOf(j));
    localUniPacket.put("cannon", localUniAttribute.encode());
    return b(localUniPacket.encode());
  }
  
  private byte[] d(ToServiceMsg paramToServiceMsg)
  {
    long l4 = 0L;
    String str = (String)paramToServiceMsg.getAttribute("uin");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("flag", Integer.valueOf(1));
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "handleGetQZoneCover|uin = " + str + ",flag=" + localInteger.intValue());
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        l3 = l4;
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          l3 = Long.parseLong(paramToServiceMsg.getUin());
          l2 = l1;
          return QZoneRequestEncoder.a(l2, l3, localInteger.intValue());
        }
        catch (Exception paramToServiceMsg)
        {
          long l1;
          long l3;
          long l2;
          break label111;
        }
        paramToServiceMsg = paramToServiceMsg;
        l1 = 0L;
      }
      label111:
      l2 = l1;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qzonecover.", 2, paramToServiceMsg.toString());
        l3 = l4;
        l2 = l1;
      }
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    Object localObject = null;
    if ("SQQzoneSvc.getCover".equals(str)) {
      localObject = a(paramFromServiceMsg, paramToServiceMsg);
    }
    return localObject;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
      localFromServiceMsg.setBusinessFail(1002, 1002, "");
      paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      return;
    }
    catch (RemoteException paramToServiceMsg) {}
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString)
  {
    try
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
      localFromServiceMsg.setBusinessFail(paramInt, paramInt, paramString);
      paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      return;
    }
    catch (RemoteException paramToServiceMsg) {}
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("QzoneService.knrsNew".equals(str)) {
      a(paramFromServiceMsg, paramToServiceMsg);
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.actionListener.onActionResult(paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      if (!"QzoneService.GetNewAndUnread".equals(str)) {}
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return false;
  }
  
  public byte[] a(ToServiceMsg paramToServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("QzoneService.knrsNew".equals(str)) {
      return c(paramToServiceMsg);
    }
    if ("QzoneService.GetNewAndUnread".equals(str)) {
      return b(paramToServiceMsg);
    }
    if ("SQQzoneSvc.getCover".equals(str)) {
      return d(paramToServiceMsg);
    }
    return null;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneService
 * JD-Core Version:    0.7.0.1
 */