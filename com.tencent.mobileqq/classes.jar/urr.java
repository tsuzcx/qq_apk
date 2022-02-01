import com.tencent.image.NativeGifImage;
import java.io.File;

public class urr
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private urs jdField_a_of_type_Urs;
  
  public urr(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Urs = null;
  }
  
  public void a(urs paramurs)
  {
    this.jdField_a_of_type_Urs = paramurs;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_Urs != null) {
        this.jdField_a_of_type_Urs.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urr
 * JD-Core Version:    0.7.0.1
 */