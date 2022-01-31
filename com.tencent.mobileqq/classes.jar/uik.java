import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class uik
  implements uni<vby, vdj>
{
  uik(uid paramuid, String paramString, Object paramObject, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2) {}
  
  public void a(@NonNull vby arg1, @Nullable vdj paramvdj, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramvdj != null))
    {
      wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url success , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
      ??? = (uro)urr.a(5);
      if (paramvdj.a != null)
      {
        paramErrorMessage = paramvdj.a.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramvdj.a = ???.a(paramvdj.a);
      ((uid)urr.a(28)).a(paramvdj.b);
      this.jdField_a_of_type_Uid.c(this.jdField_a_of_type_JavaLangString, 0);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        try
        {
          if (this.b.get()) {
            this.jdField_a_of_type_JavaLangObject.notifyAll();
          }
          return;
          wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url fail , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        }
        catch (Exception paramvdj)
        {
          for (;;)
          {
            wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary lock error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uik
 * JD-Core Version:    0.7.0.1
 */