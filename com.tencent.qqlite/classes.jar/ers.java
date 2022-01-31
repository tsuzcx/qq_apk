import android.graphics.Bitmap;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import java.util.LinkedList;

public class ers
  extends DiscussionObserver
{
  private ers(FaceDecoder paramFaceDecoder) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (FaceDecoder.a(this.a) != null)
    {
      Bitmap localBitmap = this.a.a(101, paramString);
      if ((paramBoolean1) && (localBitmap != null)) {
        FaceDecoder.a(this.a).a(FaceDecoder.a(this.a) + FaceDecoder.a(this.a).size(), 101, paramString, localBitmap);
      }
    }
    if ((!FaceDecoder.a(this.a)) && (!FaceDecoder.a(this.a).isEmpty()) && (FaceDecoder.a(this.a) < 4)) {
      FaceDecoder.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ers
 * JD-Core Version:    0.7.0.1
 */