import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class wau
  implements wfk<wtz, wvk>
{
  wau(wan paramwan, String paramString, Object paramObject, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2) {}
  
  public void a(@NonNull wtz arg1, @Nullable wvk paramwvk, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramwvk != null))
    {
      ykq.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url success , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
      ??? = (wjp)wjs.a(5);
      if (paramwvk.a != null)
      {
        paramErrorMessage = paramwvk.a.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramwvk.a = ???.a(paramwvk.a);
      ((wan)wjs.a(28)).a(paramwvk.b);
      this.jdField_a_of_type_Wan.c(this.jdField_a_of_type_JavaLangString, 0);
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
          ykq.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url fail , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        }
        catch (Exception paramwvk)
        {
          for (;;)
          {
            ykq.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary lock error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wau
 * JD-Core Version:    0.7.0.1
 */