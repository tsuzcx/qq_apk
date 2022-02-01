import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class wge
  implements wld<wzt, xbe>
{
  wge(wfy paramwfy, wgh paramwgh, String paramString) {}
  
  public void a(@NonNull wzt paramwzt, @Nullable xbe paramxbe, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramxbe);
    if ((paramErrorMessage.isFail()) || (paramxbe == null))
    {
      yqp.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Wgh.a(true);
      return;
    }
    paramwzt = (wpj)wpm.a(5);
    if (paramxbe.a != null)
    {
      paramErrorMessage = paramxbe.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramxbe.a = paramwzt.a(paramxbe.a);
    ((wfy)wpm.a(28)).a(paramxbe.b);
    this.jdField_a_of_type_Wfy.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Wgh.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wge
 * JD-Core Version:    0.7.0.1
 */