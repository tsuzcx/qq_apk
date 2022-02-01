package retrofit.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class FormUrlEncodedTypedOutput
  implements TypedOutput
{
  final ByteArrayOutputStream content = new ByteArrayOutputStream();
  
  public <T> void addField(String paramString, T paramT)
  {
    addField(paramString, true, paramT, true);
  }
  
  public <T> void addField(String paramString, boolean paramBoolean1, T paramT, boolean paramBoolean2)
  {
    if (paramString == null) {
      throw new NullPointerException("name");
    }
    if (paramT == null) {
      throw new NullPointerException("value");
    }
    if (this.content.size() > 0) {
      this.content.write(38);
    }
    try
    {
      String str = paramT.toString();
      paramT = paramString;
      if (paramBoolean1) {
        paramT = URLEncoder.encode(paramString, "UTF-8");
      }
      paramString = str;
      if (paramBoolean2) {
        paramString = URLEncoder.encode(str, "UTF-8");
      }
      this.content.write(paramT.getBytes("UTF-8"));
      this.content.write(61);
      this.content.write(paramString.getBytes("UTF-8"));
      return;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public String fileName()
  {
    return null;
  }
  
  public long length()
  {
    return this.content.size();
  }
  
  public String mimeType()
  {
    return "application/x-www-form-urlencoded; charset=UTF-8";
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.content.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.mime.FormUrlEncodedTypedOutput
 * JD-Core Version:    0.7.0.1
 */