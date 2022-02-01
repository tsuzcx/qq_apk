import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class awbs
  implements InvocationHandler
{
  awbs(awbq paramawbq) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramObject = paramMethod.getName();
    boolean bool;
    if ("onLoad".equals(paramObject)) {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
      {
        int i = ((Integer)paramArrayOfObject[0]).intValue();
        bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
        awbq.a(this.this$0, i, bool);
      }
    }
    for (;;)
    {
      return null;
      if (("onLoadFinish".equals(paramObject)) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
      {
        bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
        awbq.a(this.this$0, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awbs
 * JD-Core Version:    0.7.0.1
 */