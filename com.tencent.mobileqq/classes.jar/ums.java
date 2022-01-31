import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class ums
  implements urr<vgh, vhs>
{
  ums(umm paramumm, umv paramumv, String paramString) {}
  
  public void a(@NonNull vgh paramvgh, @Nullable vhs paramvhs, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramvhs);
    if ((paramErrorMessage.isFail()) || (paramvhs == null))
    {
      wxe.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Umv.a(true);
      return;
    }
    paramvgh = (uvx)uwa.a(5);
    if (paramvhs.a != null)
    {
      paramErrorMessage = paramvhs.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramvhs.a = paramvgh.a(paramvhs.a);
    ((umm)uwa.a(28)).a(paramvhs.b);
    this.jdField_a_of_type_Umm.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Umv.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ums
 * JD-Core Version:    0.7.0.1
 */