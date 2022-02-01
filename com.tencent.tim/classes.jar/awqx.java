import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ByteArrayEntity;

public class awqx
  extends ByteArrayEntity
{
  protected final int mLength;
  protected final int mOffset;
  
  public awqx(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    this.mOffset = paramInt1;
    this.mLength = paramInt2;
  }
  
  public InputStream getContent()
  {
    return new ByteArrayInputStream(this.content, this.mOffset, this.mLength);
  }
  
  public long getContentLength()
  {
    return this.mLength;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    paramOutputStream.write(this.content, this.mOffset, this.mLength);
    paramOutputStream.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqx
 * JD-Core Version:    0.7.0.1
 */