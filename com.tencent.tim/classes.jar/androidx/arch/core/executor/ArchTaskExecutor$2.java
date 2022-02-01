package androidx.arch.core.executor;

import java.util.concurrent.Executor;

final class ArchTaskExecutor$2
  implements Executor
{
  public void execute(Runnable paramRunnable)
  {
    ArchTaskExecutor.getInstance().executeOnDiskIO(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.arch.core.executor.ArchTaskExecutor.2
 * JD-Core Version:    0.7.0.1
 */