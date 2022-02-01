import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

public class wih
  extends SimpleJob<Void>
{
  wih(wia paramwia) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (wfv)wth.a(30);
    paramVarArgs = paramJobContext.b();
    ThreadManager.getUIHandler().post(new AlbumGalleryCapturePart.7.1(this, paramVarArgs, paramJobContext));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wih
 * JD-Core Version:    0.7.0.1
 */