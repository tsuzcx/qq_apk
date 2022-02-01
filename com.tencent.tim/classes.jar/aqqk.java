import com.tencent.image.NativeGifImage;
import java.io.File;
import java.io.IOException;

public class aqqk
  extends NativeGifImage
{
  private int bdP = 1;
  
  public aqqk(File paramFile, boolean paramBoolean, float paramFloat, int paramInt)
    throws IOException
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
    this.bdP = paramInt;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.bdP) {
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqk
 * JD-Core Version:    0.7.0.1
 */