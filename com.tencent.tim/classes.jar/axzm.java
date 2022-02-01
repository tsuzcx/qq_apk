import java.util.concurrent.Executor;

final class axzm
  implements Executor
{
  public void execute(Runnable paramRunnable)
  {
    axzl.a().postToMainThread(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzm
 * JD-Core Version:    0.7.0.1
 */