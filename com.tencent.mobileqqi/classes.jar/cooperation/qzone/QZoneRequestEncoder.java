package cooperation.qzone;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_req;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class QZoneRequestEncoder
{
  public static final String a = "getCover";
  private static final String b = "hostuin";
  private static final String c = "QzoneNewService.getCover";
  
  public static JceStruct a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return a(paramArrayOfByte, "getCover");
  }
  
  private static JceStruct a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramString == null)) {
      return null;
    }
    paramArrayOfByte = b(paramArrayOfByte);
    Object localObject = new WNSStream();
    try
    {
      paramArrayOfByte = ((WNSStream)localObject).a(paramArrayOfByte);
      localObject = new UniAttribute();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode == 0))
      {
        ((UniAttribute)localObject).setEncodeName("utf-8");
        ((UniAttribute)localObject).decode(paramArrayOfByte.Extra);
        localObject = (QmfBusiControl)((UniAttribute)localObject).get("busiCompCtl");
        if ((localObject != null) && (1 == ((QmfBusiControl)localObject).compFlag))
        {
          localObject = WNSStream.b(paramArrayOfByte.BusiBuff);
          if (localObject == null) {
            break label158;
          }
          paramArrayOfByte.BusiBuff = ((byte[])localObject);
        }
        localObject = new UniAttribute();
        ((UniAttribute)localObject).setEncodeName("utf-8");
        ((UniAttribute)localObject).decode(paramArrayOfByte.BusiBuff);
        return (JceStruct)((UniAttribute)localObject).get(paramString);
      }
      if (paramArrayOfByte != null)
      {
        int i = paramArrayOfByte.WnsCode;
        if (i != 0) {
          return null;
        }
      }
      if (paramArrayOfByte == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label158:
    return null;
  }
  
  public static byte[] a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject1 = new mobile_sub_get_cover_req();
    ((mobile_sub_get_cover_req)localObject1).uin = paramLong1;
    ((mobile_sub_get_cover_req)localObject1).flag = paramInt;
    try
    {
      Object localObject2 = new UniAttribute();
      ((UniAttribute)localObject2).setEncodeName("utf8");
      ((UniAttribute)localObject2).put("hostuin", Long.valueOf(paramLong2));
      paramInt = MsfSdkUtils.getNextAppSeq();
      if ((localObject1 != null) && ("getCover" != null) && ("getCover".length() > 0)) {
        ((UniAttribute)localObject2).put("getCover", localObject1);
      }
      localObject1 = ((UniAttribute)localObject2).encode();
      localObject2 = QUA.a();
      String str = PlatformInfor.a().e();
      localObject2 = new WNSStream(1000027, (String)localObject2, paramLong2, new byte[0], str, null);
      if (localObject1 != null)
      {
        localObject1 = a(((WNSStream)localObject2).a(paramInt, "QzoneNewService.getCover", (byte[])localObject1, true));
        return localObject1;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
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
  
  private static byte[] b(byte[] paramArrayOfByte)
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
 * Qualified Name:     cooperation.qzone.QZoneRequestEncoder
 * JD-Core Version:    0.7.0.1
 */