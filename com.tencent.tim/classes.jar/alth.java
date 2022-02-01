import android.os.Bundle;
import android.util.SparseArray;

public abstract class alth
{
  protected static SparseArray<Class<?>> dm = new SparseArray();
  protected static SparseArray<Class<?>> dn = new SparseArray();
  
  static
  {
    dm.put(1, altj.class);
  }
  
  public abstract int Id();
  
  public void fromBundle(Bundle paramBundle) {}
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("redpoint.fromReceiverIPCCode", Id());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alth
 * JD-Core Version:    0.7.0.1
 */