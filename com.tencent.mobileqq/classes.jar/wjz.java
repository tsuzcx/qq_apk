import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class wjz
  implements woy<xdo, xez>
{
  wjz(wjt paramwjt, wkc paramwkc, String paramString) {}
  
  public void a(@NonNull xdo paramxdo, @Nullable xez paramxez, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramxez);
    if ((paramErrorMessage.isFail()) || (paramxez == null))
    {
      yuk.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Wkc.a(true);
      return;
    }
    paramxdo = (wte)wth.a(5);
    if (paramxez.a != null)
    {
      paramErrorMessage = paramxez.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramxez.a = paramxdo.a(paramxez.a);
    ((wjt)wth.a(28)).a(paramxez.b);
    this.jdField_a_of_type_Wjt.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Wkc.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjz
 * JD-Core Version:    0.7.0.1
 */