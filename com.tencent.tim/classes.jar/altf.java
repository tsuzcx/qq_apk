import android.os.Bundle;
import java.lang.ref.WeakReference;

public abstract class altf<T>
  extends jnm.d
{
  protected T ex;
  private WeakReference<T> mWeakRef;
  
  protected altf(T paramT)
  {
    this.mWeakRef = new WeakReference(paramT);
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.ex = this.mWeakRef.get();
    if (this.ex == null) {
      return;
    }
    c(paramInt, paramArrayOfByte, paramBundle);
    this.ex = null;
  }
  
  protected abstract void c(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altf
 * JD-Core Version:    0.7.0.1
 */