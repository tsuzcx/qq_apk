import java.nio.ByteBuffer;

public class vto
{
  int jdField_a_of_type_Int;
  public long a;
  ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  public boolean a;
  public boolean b;
  
  public vto()
  {
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
  }
  
  public String toString()
  {
    return "FrameInfo{buffer=" + this.jdField_a_of_type_Int + ", data=" + this.jdField_a_of_type_JavaNioByteBuffer + ", presentationTimeUs=" + this.jdField_a_of_type_Long + ", endOfStream=" + this.jdField_a_of_type_Boolean + ", representationChanged=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vto
 * JD-Core Version:    0.7.0.1
 */