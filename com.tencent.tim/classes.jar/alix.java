import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class alix
  extends InputStream
  implements aliv
{
  protected aliv.a a;
  protected PipedInputStream a;
  protected PipedOutputStream a;
  protected Context context;
  protected int duG;
  protected byte[] fh;
  protected byte[] fi;
  protected byte[] fj;
  protected byte[] fk = new byte[1];
  
  public alix(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public aliv.a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.jdField_a_of_type_Aliv$a.size = 0;
    int j = paramInt2;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt2 > 0)
    {
      if (paramInt2 > 1920 - this.jdField_a_of_type_JavaIoPipedInputStream.available()) {
        paramInt1 = 1920 - this.jdField_a_of_type_JavaIoPipedInputStream.available();
      }
      m(paramArrayOfByte, i, paramInt1);
      i += paramInt1;
      paramInt1 = paramInt2 - paramInt1;
      paramInt2 = paramInt1;
    }
    return this.jdField_a_of_type_Aliv$a;
  }
  
  public void close()
    throws IOException
  {
    if (this.jdField_a_of_type_JavaIoPipedInputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedInputStream.close();
      this.jdField_a_of_type_JavaIoPipedInputStream = null;
    }
  }
  
  @TargetApi(9)
  public void init(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    this.jdField_a_of_type_JavaIoPipedOutputStream = new PipedOutputStream();
    if (Build.VERSION.SDK_INT <= 8)
    {
      this.jdField_a_of_type_JavaIoPipedInputStream = new aqjm(this.jdField_a_of_type_JavaIoPipedOutputStream, 1920);
      return;
    }
    this.jdField_a_of_type_JavaIoPipedInputStream = new PipedInputStream(this.jdField_a_of_type_JavaIoPipedOutputStream, 1920);
  }
  
  protected void m(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.jdField_a_of_type_JavaIoPipedOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    while (this.jdField_a_of_type_JavaIoPipedInputStream.available() >= this.duG)
    {
      paramInt1 = read(this.fj, this.jdField_a_of_type_Aliv$a.size);
      paramArrayOfByte = this.jdField_a_of_type_Aliv$a;
      paramArrayOfByte.size = (paramInt1 + paramArrayOfByte.size);
    }
  }
  
  public int read()
    throws IOException
  {
    if (read(this.fk, 0, 1) == 1) {
      return this.fk[0] & 0xFF;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    return read(paramArrayOfByte, paramInt, paramArrayOfByte.length);
  }
  
  public void release()
    throws IOException
  {
    if (this.jdField_a_of_type_JavaIoPipedOutputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedOutputStream.close();
      this.jdField_a_of_type_JavaIoPipedOutputStream = null;
    }
    close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alix
 * JD-Core Version:    0.7.0.1
 */