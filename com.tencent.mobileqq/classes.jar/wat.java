import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class wat
  implements wfk<wtz, wvk>
{
  wat(wan paramwan, waw paramwaw, String paramString) {}
  
  public void a(@NonNull wtz paramwtz, @Nullable wvk paramwvk, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramwvk);
    if ((paramErrorMessage.isFail()) || (paramwvk == null))
    {
      ykq.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Waw.a(true);
      return;
    }
    paramwtz = (wjp)wjs.a(5);
    if (paramwvk.a != null)
    {
      paramErrorMessage = paramwvk.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramwvk.a = paramwtz.a(paramwvk.a);
    ((wan)wjs.a(28)).a(paramwvk.b);
    this.jdField_a_of_type_Wan.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Waw.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wat
 * JD-Core Version:    0.7.0.1
 */