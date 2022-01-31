import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.7.1;

public class vdc
  implements uzx
{
  vdc(vcp paramvcp) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    ved.e("NewMyStorySegment", "error occur when get friends data from server steps=%s,error=%s", new Object[] { paramErrorMessage.extraMsg, paramErrorMessage.getErrorMessage() });
    new Handler(Looper.getMainLooper()).post(new NewMyStorySegment.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdc
 * JD-Core Version:    0.7.0.1
 */