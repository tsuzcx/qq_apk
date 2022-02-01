import java.io.FilterOutputStream;
import java.io.OutputStream;

class tyd
  extends FilterOutputStream
{
  int jdField_a_of_type_Int = 0;
  
  public tyd(tyc paramtyc, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyd
 * JD-Core Version:    0.7.0.1
 */