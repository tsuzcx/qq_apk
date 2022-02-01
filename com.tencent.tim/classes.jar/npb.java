import com.tencent.qphone.base.util.QLog;

public class npb<T>
{
  public static final String tag = "zimage." + npb.class.getSimpleName();
  private final npc<T> b;
  private int mRefCount;
  private T mValue;
  
  public npb(T paramT, npc<T> paramnpc)
  {
    this.mValue = paramT;
    this.b = paramnpc;
    this.mRefCount = 1;
  }
  
  public void aZR()
  {
    try
    {
      this.mRefCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aZS()
  {
    try
    {
      this.mRefCount -= 1;
      if (this.mRefCount == 0)
      {
        if (QLog.isColorLevel()) {
          npe.log("Reference", " decReference 0 " + this.mValue);
        }
        if (this.mValue != null)
        {
          this.b.release(this.mValue);
          this.mValue = null;
        }
      }
      return;
    }
    finally {}
  }
  
  public T get()
  {
    try
    {
      Object localObject1 = this.mValue;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     npb
 * JD-Core Version:    0.7.0.1
 */