import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class vly
  implements vqp<wfe, wgp>
{
  vly(vls paramvls, vmb paramvmb, String paramString) {}
  
  public void a(@NonNull wfe paramwfe, @Nullable wgp paramwgp, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramwgp);
    if ((paramErrorMessage.isFail()) || (paramwgp == null))
    {
      xvv.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Vmb.a(true);
      return;
    }
    paramwfe = (vuu)vux.a(5);
    if (paramwgp.a != null)
    {
      paramErrorMessage = paramwgp.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramwgp.a = paramwfe.a(paramwgp.a);
    ((vls)vux.a(28)).a(paramwgp.b);
    this.jdField_a_of_type_Vls.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Vmb.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vly
 * JD-Core Version:    0.7.0.1
 */