package moai.core.watcher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class Watchers$1
  implements InvocationHandler
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    throw new IllegalArgumentException("Interface definitions must extend Watcher interface.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.watcher.Watchers.1
 * JD-Core Version:    0.7.0.1
 */