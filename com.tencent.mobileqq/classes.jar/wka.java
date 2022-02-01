import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class wka
  implements woy<xdo, xez>
{
  wka(wjt paramwjt, String paramString, Object paramObject, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2) {}
  
  public void a(@NonNull xdo arg1, @Nullable xez paramxez, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramxez != null))
    {
      yuk.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url success , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
      ??? = (wte)wth.a(5);
      if (paramxez.a != null)
      {
        paramErrorMessage = paramxez.a.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramxez.a = ???.a(paramxez.a);
      ((wjt)wth.a(28)).a(paramxez.b);
      this.jdField_a_of_type_Wjt.c(this.jdField_a_of_type_JavaLangString, 0);
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
          yuk.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url fail , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        }
        catch (Exception paramxez)
        {
          for (;;)
          {
            yuk.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary lock error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wka
 * JD-Core Version:    0.7.0.1
 */