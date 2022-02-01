import com.tencent.image.NativeGifImage;
import java.io.File;

public class txc
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private txd jdField_a_of_type_Txd;
  
  public txc(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Txd = null;
  }
  
  public void a(txd paramtxd)
  {
    this.jdField_a_of_type_Txd = paramtxd;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_Txd != null) {
        this.jdField_a_of_type_Txd.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txc
 * JD-Core Version:    0.7.0.1
 */