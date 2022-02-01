import com.tencent.image.NativeGifImage;
import java.io.File;

public class udu
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private udv jdField_a_of_type_Udv;
  
  public udu(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Udv = null;
  }
  
  public void a(udv paramudv)
  {
    this.jdField_a_of_type_Udv = paramudv;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_Udv != null) {
        this.jdField_a_of_type_Udv.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     udu
 * JD-Core Version:    0.7.0.1
 */