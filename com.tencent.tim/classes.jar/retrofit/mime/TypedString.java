package retrofit.mime;

import java.io.UnsupportedEncodingException;

public class TypedString
  extends TypedByteArray
{
  public TypedString(String paramString)
  {
    super("text/plain; charset=UTF-8", convertToBytes(paramString));
  }
  
  private static byte[] convertToBytes(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public String toString()
  {
    try
    {
      String str = "TypedString[" + new String(getBytes(), "UTF-8") + "]";
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError("Must be able to decode UTF-8");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.mime.TypedString
 * JD-Core Version:    0.7.0.1
 */