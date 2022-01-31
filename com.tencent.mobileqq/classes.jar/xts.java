import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FrameAdapter;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor.Frame;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class xts
  implements Runnable
{
  public xts(VideoFramesRetriever paramVideoFramesRetriever) {}
  
  public void run()
  {
    if (VideoFramesRetriever.a(this.a) == null) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        long l = System.currentTimeMillis();
        xtt localxtt;
        localObject2 = VideoFramesRetriever.a(this.a).getFrameAtTime((localxtt.jdField_a_of_type_Int + localxtt.b) / 2 * 1000L);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFramesRetriever", 2, "getThumbnail Failed");
          }
          if ((VideoFramesRetriever.a(this.a)) || (VideoFramesRetriever.a(this.a) == null)) {
            break;
          }
          localxtt = (xtt)VideoFramesRetriever.a(this.a).take();
          if (!VideoFramesRetriever.a(this.a)) {
            continue;
          }
          return;
        }
        if (((Bitmap)localObject2).getWidth() > ((Bitmap)localObject2).getHeight())
        {
          i = 1;
          if (i == 0) {
            break label338;
          }
          f = VideoFramesRetriever.a(this.a) / ((Bitmap)localObject2).getHeight();
          Object localObject1 = new Matrix();
          ((Matrix)localObject1).postScale(f, f);
          if (i == 0) {
            break label356;
          }
          localObject1 = Bitmap.createBitmap((Bitmap)localObject2, (((Bitmap)localObject2).getWidth() - ((Bitmap)localObject2).getHeight()) / 2, 0, ((Bitmap)localObject2).getHeight(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, true);
          ((Bitmap)localObject2).recycle();
          localObject2 = new FramesProcessor.Frame();
          ((FramesProcessor.Frame)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1).copy(Bitmap.Config.RGB_565, true);
          ((FramesProcessor.Frame)localObject2).jdField_a_of_type_Int = (localxtt.jdField_a_of_type_Int / VideoFramesRetriever.b(this.a));
          ((Bitmap)localObject1).recycle();
          QLog.i("VideoFramesRetriever", 1, "end get frame bitmap, cost time=" + (System.currentTimeMillis() - l));
          VideoFramesRetriever.a(this.a).a((FramesProcessor.Frame)localObject2);
          VideoFramesRetriever.a(this.a).remove(Integer.valueOf(localxtt.jdField_a_of_type_Int));
          continue;
        }
        int i = 0;
      }
      catch (Throwable localThrowable)
      {
        localThrowable = localThrowable;
        QLog.e("VideoFramesRetriever", 2, "FrameFetchRunnable, Exception:", localThrowable);
        return;
      }
      finally {}
      continue;
      label338:
      float f = VideoFramesRetriever.a(this.a) / ((Bitmap)localObject2).getWidth();
      continue;
      label356:
      Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject2, 0, (((Bitmap)localObject2).getHeight() - ((Bitmap)localObject2).getWidth()) / 2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getWidth(), localMatrix, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xts
 * JD-Core Version:    0.7.0.1
 */