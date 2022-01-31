package cooperation.qzone;

import PUSHAPI.PushRsp;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import com.qq.jce.wup.UniAttribute;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import common.config.service.WupTool;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class QZoneMsfPushAckRequest
{
  public static final int a = 1000000;
  public static final String a = "wns.pushrsp";
  public static final int b = 1000006;
  private static final String b = "hostuin";
  private static final String c = "wns.pushrsp";
  private static final String d = "wns.pushrsp";
  
  public static UniAttribute a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramArrayOfByte = b(paramArrayOfByte, paramQQAppInterface);
    } while (paramArrayOfByte == null);
    return paramArrayOfByte;
  }
  
  public static void a(UniAttribute paramUniAttribute, int paramInt1, int paramInt2, String paramString)
  {
    if (((paramUniAttribute == null) || (paramInt1 == 0)) || (1000006 == paramInt1)) {}
  }
  
  public static byte[] a(long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      paramString = new PushRsp();
      paramString.ptime = paramLong2;
      paramString.is_bgd = 0;
      paramString.sUID = "<JIEHEBAN>";
      paramString = WupTool.a(paramString);
      int i = MsfSdkUtils.getNextAppSeq();
      Object localObject = QUA.a();
      String str = PlatformInfor.a().e();
      localObject = new WNSStream(1000027, (String)localObject, paramLong1, new byte[0], str);
      if (paramString != null)
      {
        paramString = a(((WNSStream)localObject).a(i, "wns.pushrsp", paramString, false));
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (VerifyError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length + 4);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(paramArrayOfByte.length + 4);
      localDataOutputStream.write(paramArrayOfByte);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label76:
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label76;
      }
    }
  }
  
  private static UniAttribute b(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new WNSStream();
    try
    {
      paramArrayOfByte = paramQQAppInterface.a(b(paramArrayOfByte));
      paramQQAppInterface = new UniAttribute();
      int i;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode == 0))
      {
        paramQQAppInterface.setEncodeName("utf-8");
        paramQQAppInterface.decode(paramArrayOfByte.Extra);
        paramQQAppInterface = (QmfBusiControl)paramQQAppInterface.get("busiCompCtl");
        if ((paramQQAppInterface != null) && (1 == paramQQAppInterface.compFlag))
        {
          paramQQAppInterface = WNSStream.b(paramArrayOfByte.BusiBuff);
          if (paramQQAppInterface != null) {
            paramArrayOfByte.BusiBuff = paramQQAppInterface;
          }
        }
        else
        {
          paramQQAppInterface = new UniAttribute();
          paramQQAppInterface.setEncodeName("utf-8");
          paramQQAppInterface.decode(paramArrayOfByte.BusiBuff);
          i = paramArrayOfByte.BizCode;
          paramArrayOfByte = paramQQAppInterface.get("ret", Short.valueOf(paramArrayOfByte.BizCode));
          if ((paramArrayOfByte instanceof Short)) {
            i = ((Short)paramArrayOfByte).intValue();
          }
          for (;;)
          {
            a(paramQQAppInterface, i, i, (String)paramQQAppInterface.get("msg", ""));
            return null;
            if ((paramArrayOfByte instanceof Integer)) {
              i = ((Integer)paramArrayOfByte).intValue();
            }
          }
        }
      }
      else if (paramArrayOfByte != null)
      {
        i = paramArrayOfByte.WnsCode;
        if (i != 0) {}
      }
      else if (paramArrayOfByte == null)
      {
        return null;
      }
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  protected static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(localByteArrayInputStream);
    try
    {
      paramArrayOfByte = new byte[localDataInputStream.readInt() - 4];
      label72:
      return paramArrayOfByte;
    }
    catch (Exception localException1)
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException5) {}
      localException1 = localException1;
      paramArrayOfByte = null;
      localException1.printStackTrace();
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        return paramArrayOfByte;
      }
    }
    finally
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException3)
      {
        break label72;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneMsfPushAckRequest
 * JD-Core Version:    0.7.0.1
 */