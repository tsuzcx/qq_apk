import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.6.1;

public class qzt
  implements qxn.a
{
  qzt(qzh paramqzh) {}
  
  public void done()
  {
    ram.w("NewMyStorySegment", "finish get all data from server steps");
    new Handler(Looper.getMainLooper()).post(new NewMyStorySegment.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzt
 * JD-Core Version:    0.7.0.1
 */