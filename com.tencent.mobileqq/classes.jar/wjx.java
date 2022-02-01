import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class wjx
  extends SimpleJob<Void>
{
  wjx(wjt paramwjt, String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    try
    {
      wjt.a(this.jdField_a_of_type_Wjt).lock();
      paramJobContext = DownloadingUrlEntry.makeKey(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      wjt.a(this.jdField_a_of_type_Wjt).remove(paramJobContext);
      paramJobContext = QQStoryContext.a().a().createEntityManager();
      paramVarArgs = wte.a(paramJobContext, DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int) });
      if ((paramVarArgs != null) && (paramVarArgs.size() > 0))
      {
        paramVarArgs = (DownloadingUrlEntry)paramVarArgs.get(0);
        paramVarArgs.setStatus(1000);
        paramVarArgs.bIsDownloadCompleted = 1;
        paramJobContext.persistOrReplace(paramVarArgs);
      }
      return null;
    }
    finally
    {
      wjt.a(this.jdField_a_of_type_Wjt).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjx
 * JD-Core Version:    0.7.0.1
 */