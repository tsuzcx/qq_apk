import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class aeqp<T>
  extends aehv<T>
{
  @NonNull
  public abstract T N();
  
  @NonNull
  public abstract T O();
  
  @NonNull
  public abstract T a(@NonNull aeic[] paramArrayOfaeic);
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public T migrateOldOrDefaultContent(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 1) {
      localObject1 = N();
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        rom.fail(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = O();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = O();
      } else {
        rom.fail(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public T onParsed(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0))
    {
      ram.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfaeic = O();
      if (paramArrayOfaeic != null) {}
      for (boolean bool = true;; bool = false)
      {
        rom.assertTrue(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfaeic;
      }
    }
    ram.w("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfaeic.length);
    return a(paramArrayOfaeic);
  }
  
  public void onReqFailed(int paramInt)
  {
    ram.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void onUpdate(T paramT)
  {
    ram.w("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqp
 * JD-Core Version:    0.7.0.1
 */