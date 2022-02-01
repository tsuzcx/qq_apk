import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.12.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

public class plk
  extends SimpleJob<Void>
{
  plk(plh paramplh, pkd parampkd) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    boolean bool = this.c.If();
    if (this.c.sh() < 2) {
      pju.a(this.c, 10);
    }
    ThreadManager.getUIHandler().post(new AlbumGalleryCapturePart.12.1(this, bool));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plk
 * JD-Core Version:    0.7.0.1
 */