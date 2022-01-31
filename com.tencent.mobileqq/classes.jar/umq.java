import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class umq
  extends SimpleJob<Void>
{
  umq(umm paramumm, String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    try
    {
      umm.a(this.jdField_a_of_type_Umm).lock();
      paramJobContext = DownloadingUrlEntry.makeKey(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      umm.a(this.jdField_a_of_type_Umm).remove(paramJobContext);
      paramJobContext = QQStoryContext.a().a().createEntityManager();
      paramVarArgs = uvx.a(paramJobContext, DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int) });
      if ((paramVarArgs != null) && (paramVarArgs.size() > 0))
      {
        paramVarArgs = (DownloadingUrlEntry)paramVarArgs.get(0);
        paramVarArgs.setStatus(1000);
        paramVarArgs.bIsDownloadCompleted = 1;
        paramJobContext.b(paramVarArgs);
      }
      return null;
    }
    finally
    {
      umm.a(this.jdField_a_of_type_Umm).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umq
 * JD-Core Version:    0.7.0.1
 */