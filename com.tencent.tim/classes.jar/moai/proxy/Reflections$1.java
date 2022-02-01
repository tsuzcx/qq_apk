package moai.proxy;

import com.google.common.base.Defaults;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class Reflections$1
  implements InvocationHandler
{
  Reflections$1(Nullable paramNullable) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramObject = this.val$delegate.get();
    if (paramObject != null) {
      return paramMethod.invoke(paramObject, paramArrayOfObject);
    }
    return Defaults.defaultValue(paramMethod.getReturnType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.proxy.Reflections.1
 * JD-Core Version:    0.7.0.1
 */