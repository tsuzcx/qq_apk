package androidx.appcompat.app;

import android.content.res.Resources.NotFoundException;

final class AppCompatDelegateImpl$1
  implements Thread.UncaughtExceptionHandler
{
  AppCompatDelegateImpl$1(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  private boolean shouldWrapException(Throwable paramThrowable)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramThrowable instanceof Resources.NotFoundException))
    {
      paramThrowable = paramThrowable.getMessage();
      bool1 = bool2;
      if (paramThrowable != null) {
        if (!paramThrowable.contains("drawable"))
        {
          bool1 = bool2;
          if (!paramThrowable.contains("Drawable")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (shouldWrapException(paramThrowable))
    {
      Resources.NotFoundException localNotFoundException = new Resources.NotFoundException(paramThrowable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
      localNotFoundException.initCause(paramThrowable.getCause());
      localNotFoundException.setStackTrace(paramThrowable.getStackTrace());
      this.val$defHandler.uncaughtException(paramThread, localNotFoundException);
      return;
    }
    this.val$defHandler.uncaughtException(paramThread, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.1
 * JD-Core Version:    0.7.0.1
 */