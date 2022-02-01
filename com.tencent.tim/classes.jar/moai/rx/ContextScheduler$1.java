package moai.rx;

import android.support.annotation.NonNull;
import com.google.common.cache.CacheLoader;
import moai.fragment.base.LifeDetection;

final class ContextScheduler$1
  extends CacheLoader<LifeDetection, ContextScheduler>
{
  public ContextScheduler load(@NonNull LifeDetection paramLifeDetection)
    throws Exception
  {
    return new ContextScheduler(paramLifeDetection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.ContextScheduler.1
 * JD-Core Version:    0.7.0.1
 */