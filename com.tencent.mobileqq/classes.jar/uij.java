import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class uij
  implements uni<vby, vdj>
{
  uij(uid paramuid, uim paramuim, String paramString) {}
  
  public void a(@NonNull vby paramvby, @Nullable vdj paramvdj, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramvdj);
    if ((paramErrorMessage.isFail()) || (paramvdj == null))
    {
      wsv.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Uim.a(true);
      return;
    }
    paramvby = (uro)urr.a(5);
    if (paramvdj.a != null)
    {
      paramErrorMessage = paramvdj.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramvdj.a = paramvby.a(paramvdj.a);
    ((uid)urr.a(28)).a(paramvdj.b);
    this.jdField_a_of_type_Uid.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Uim.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uij
 * JD-Core Version:    0.7.0.1
 */