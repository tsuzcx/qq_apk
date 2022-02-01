package taiji;

import android.util.Log;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class bj
{
  private static JceInputStream a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("UTF-8");
    return paramArrayOfByte;
  }
  
  public static <T extends JceStruct> T a(byte[] paramArrayOfByte, T paramT, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      if (paramT == null) {
        return null;
      }
      Object localObject = paramT;
      if (paramBoolean) {}
      try
      {
        localObject = paramT.newInit();
        ((JceStruct)localObject).recyle();
        ((JceStruct)localObject).readFrom(a(paramArrayOfByte));
        return localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        paramT = new StringBuilder();
        paramT.append("getJceStruct exception: ");
        paramT.append(paramArrayOfByte);
        Log.e("JceStructUtil", paramT.toString());
      }
    }
    return null;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("UTF-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bj
 * JD-Core Version:    0.7.0.1
 */