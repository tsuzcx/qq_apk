package retrofit.mime;

import com.alibaba.fastjson.JSONWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public final class JSONEncodedTypedOutput
  extends FormUrlEncodedTypedOutput
{
  final JSONWriter content = new JSONWriter(new OutputStreamWriter(this.output));
  int length = -1;
  final ByteArrayOutputStream output = new ByteArrayOutputStream();
  
  public JSONEncodedTypedOutput()
  {
    this.content.startObject();
  }
  
  public <T> void addField(String paramString, T paramT)
  {
    this.content.writeKey(paramString);
    this.content.writeValue(paramT);
  }
  
  public <T> void addField(String paramString, boolean paramBoolean1, T paramT, boolean paramBoolean2)
  {
    addField(paramString, paramT);
  }
  
  public String fileName()
  {
    return null;
  }
  
  public long length()
  {
    if (this.length >= 0) {
      return this.length;
    }
    try
    {
      this.content.flush();
      this.content.endObject();
      this.content.close();
      this.length = this.output.size();
      return this.length;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public String mimeType()
  {
    return "application/json; charset=UTF-8";
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.output.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.mime.JSONEncodedTypedOutput
 * JD-Core Version:    0.7.0.1
 */