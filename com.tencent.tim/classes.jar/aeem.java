import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aeem
  implements InvocationHandler
{
  private Activity activity;
  private boolean bTr;
  private boolean bTs;
  private List<aeem.a> listeners = new ArrayList();
  
  public aeem(Activity paramActivity, boolean paramBoolean)
  {
    this.activity = paramActivity;
    this.bTr = paramBoolean;
  }
  
  public void a(aeem.a parama)
  {
    this.listeners.add(parama);
  }
  
  public boolean agx()
  {
    return this.bTr;
  }
  
  public void cWx()
  {
    if ((!this.bTs) && (this.activity != null))
    {
      this.bTs = true;
      aeej.a(this.activity, this);
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    if ((paramMethod.getName().equalsIgnoreCase("onTranslucentConversionComplete")) && (paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      this.bTr = true;
      paramMethod = paramArrayOfObject[0];
      if (QLog.isColorLevel()) {
        QLog.d("TranslucentConvertor", 2, "onTranslucentConversionComplete: " + paramMethod);
      }
      paramObject = Boolean.valueOf(false);
      if ((paramMethod instanceof Boolean)) {
        paramObject = (Boolean)paramMethod;
      }
      paramMethod = this.listeners.iterator();
      while (paramMethod.hasNext()) {
        ((aeem.a)paramMethod.next()).Ha(paramObject.booleanValue());
      }
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void Ha(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeem
 * JD-Core Version:    0.7.0.1
 */