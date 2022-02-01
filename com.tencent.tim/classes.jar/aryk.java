import android.content.Context;
import java.util.HashMap;

public class aryk
{
  protected static aryk b;
  protected aryj.b b;
  protected final HashMap<String, aryj> bq = new HashMap();
  protected Context mContext;
  
  protected aryk(Context paramContext)
  {
    this.jdField_b_of_type_Aryj$b = new aryl(this);
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static aryk a(Context paramContext)
  {
    if (jdField_b_of_type_Aryk != null) {
      return jdField_b_of_type_Aryk;
    }
    try
    {
      if (jdField_b_of_type_Aryk == null) {
        jdField_b_of_type_Aryk = new aryk(paramContext);
      }
      paramContext = jdField_b_of_type_Aryk;
      return paramContext;
    }
    finally {}
  }
  
  public aryj a(Class<? extends aryh> paramClass, long paramLong, String paramString)
    throws RuntimeException
  {
    synchronized (this.bq)
    {
      if (this.mContext == null) {
        throw new RuntimeException("call initiate(Context context) before this");
      }
    }
    if (paramString == null) {
      throw new RuntimeException("invalid table name");
    }
    Object localObject = aryj.l(paramLong, paramString);
    localObject = (aryj)this.bq.get(localObject);
    if (localObject == null)
    {
      paramClass = new aryj(this.mContext, paramClass, paramLong, paramString);
      paramClass.a(this.jdField_b_of_type_Aryj$b);
      this.bq.put(paramClass.uniqueKey(), paramClass);
    }
    for (;;)
    {
      return paramClass;
      paramClass = (Class<? extends aryh>)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryk
 * JD-Core Version:    0.7.0.1
 */