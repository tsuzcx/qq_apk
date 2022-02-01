import ActionMsg.MsgBody;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class aqfw
{
  public static MsgBody a(String paramString)
  {
    MsgBody localMsgBody = new MsgBody();
    try
    {
      JceInputStream localJceInputStream = new JceInputStream(HexUtil.hexStr2Bytes(paramString));
      localJceInputStream.setServerEncoding("utf-8");
      localMsgBody.readFrom(localJceInputStream);
      return localMsgBody;
    }
    catch (Exception localException)
    {
      QLog.w("ActionMsgUtil", 2, "decode error msg = " + paramString);
      QLog.w("ActionMsgUtil", 2, localException.toString());
      localMsgBody.msg = "";
      localMsgBody.action = "";
      localMsgBody.shareAppID = 0L;
      localMsgBody.actMsgContentValue = "";
    }
    return localMsgBody;
  }
  
  public static aqfw.a a(byte[] paramArrayOfByte)
  {
    aqfw.a locala = new aqfw.a();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        locala.dYZ = paramArrayOfByte.get();
        if (paramArrayOfByte.get() != 0) {
          continue;
        }
        i = -3004;
        locala.opType = i;
        if (paramArrayOfByte.hasRemaining())
        {
          i = paramArrayOfByte.get();
          byte[] arrayOfByte = new byte[paramArrayOfByte.getShort()];
          paramArrayOfByte.get(arrayOfByte);
          locala.contentType = i;
          locala.csF = new String(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("ActionMsgUtil", 2, "decodeAppShareCookie succes appShareCookie.buissnessType =" + locala.dYZ + "appShareCookie.action" + locala.opType + "appShareCookie.actionType" + locala.contentType + "appShareCookie.actionValue" + locala.csF);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        int i;
        paramArrayOfByte.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ActionMsgUtil", 2, "decodeAppShareCookie", paramArrayOfByte);
      }
      return locala;
      i = -3005;
    }
    return locala;
  }
  
  public static String b(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    String str = paramString1;
    if (paramString1 == null)
    {
      str = "";
      QLog.w("ActionMsgUtil", 2, "encode msg is null");
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = "";
      QLog.w("ActionMsgUtil", 2, "encode action is null");
    }
    paramString2 = new MsgBody();
    paramString2.msg = str;
    paramString2.action = paramString1;
    paramString2.shareAppID = paramLong;
    paramString2.actMsgContentValue = paramString3;
    paramString1 = new JceOutputStream();
    paramString1.setServerEncoding("utf-8");
    paramString2.writeTo(paramString1);
    return HexUtil.bytes2HexStr(paramString1.toByteArray());
  }
  
  public static boolean cJ(int paramInt)
  {
    return paramInt == -2016;
  }
  
  public static String encode(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2, 0L, null);
  }
  
  public static boolean fJ(int paramInt)
  {
    return (paramInt == -2009) || (paramInt == -3012);
  }
  
  public static boolean mn(int paramInt)
  {
    return (paramInt == -3000) || (paramInt == -3004) || (paramInt == -3005);
  }
  
  public static boolean mo(int paramInt)
  {
    return paramInt == -2007;
  }
  
  public static boolean mp(int paramInt)
  {
    return paramInt == -2039;
  }
  
  public static class a
  {
    public int contentType;
    public String csF;
    public int dYZ;
    public int opType = -3000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfw
 * JD-Core Version:    0.7.0.1
 */