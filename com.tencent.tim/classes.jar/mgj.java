import com.tencent.image.NativeGifImage;
import java.io.File;

class mgj
  extends NativeGifImage
{
  mgj(mgi parammgi, File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == 1) {
      return;
    }
    super.executeNewTask();
  }
  
  public void reset()
  {
    super.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgj
 * JD-Core Version:    0.7.0.1
 */