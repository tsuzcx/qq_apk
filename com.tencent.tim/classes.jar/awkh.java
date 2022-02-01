import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;

public class awkh
{
  public static <T extends JceStruct> T decodeWup(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramClass = (JceStruct)paramClass.newInstance();
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf8");
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkh
 * JD-Core Version:    0.7.0.1
 */