import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class ok
  extends FilterOutputStream
{
  public int a;
  
  public ok(PubAccountHttpDownloader paramPubAccountHttpDownloader, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void write(int paramInt)
  {
    this.jdField_a_of_type_Int += 1;
    this.out.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int += paramInt2;
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ok
 * JD-Core Version:    0.7.0.1
 */