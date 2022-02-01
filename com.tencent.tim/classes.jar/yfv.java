import android.graphics.Bitmap;
import com.tencent.image.NativeGifImage;
import java.io.File;
import java.io.IOException;

public class yfv
  extends NativeGifImage
{
  public yfv(File paramFile, boolean paramBoolean)
    throws IOException
  {
    super(paramFile, paramBoolean);
  }
  
  public Bitmap an()
  {
    return this.mCurrentFrameBitmap;
  }
  
  public void chU()
  {
    getNextFrame();
    applyNextFrame();
  }
  
  public int getCurrentFrameIndex()
  {
    return this.mCurrentFrameIndex;
  }
  
  public int getFrameCount()
  {
    return this.mMetaData[FRAME_COUNT_INDEX];
  }
  
  public int getFrameDelay()
  {
    return this.mMetaData[POST_INVALIDATION_TIME_INDEX];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfv
 * JD-Core Version:    0.7.0.1
 */