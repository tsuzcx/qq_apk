import android.util.Log;

public abstract class iqc
{
  private String TAG = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  protected iqb a;
  
  public void a(iqb paramiqb)
  {
    Log.d(this.TAG, "init");
    this.a = paramiqb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqc
 * JD-Core Version:    0.7.0.1
 */