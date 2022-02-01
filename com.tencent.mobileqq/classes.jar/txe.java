import com.tencent.image.NativeGifImage;
import java.io.File;

public class txe
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private txf jdField_a_of_type_Txf;
  
  public txe(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Txf = null;
  }
  
  public void a(txf paramtxf)
  {
    this.jdField_a_of_type_Txf = paramtxf;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_Txf != null) {
        this.jdField_a_of_type_Txf.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txe
 * JD-Core Version:    0.7.0.1
 */