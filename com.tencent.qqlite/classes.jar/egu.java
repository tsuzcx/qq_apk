import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.transfile.CommenTransFileProcessor;
import java.util.TimerTask;

public class egu
  extends TimerTask
{
  public egu(CommenTransFileProcessor paramCommenTransFileProcessor, JceOutputStream paramJceOutputStream) {}
  
  public void run()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComQqTafJceJceOutputStream.toByteArray();
    CommenTransFileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileCommenTransFileProcessor, this.jdField_a_of_type_ComTencentMobileqqTransfileCommenTransFileProcessor.a, arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     egu
 * JD-Core Version:    0.7.0.1
 */