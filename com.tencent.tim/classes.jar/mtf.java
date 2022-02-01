import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

public class mtf
{
  private static String TAG = mtf.class.getSimpleName();
  private mtf.a jdField_a_of_type_Mtf$a;
  private mtf.c jdField_a_of_type_Mtf$c;
  private HashMap<Integer, mtf.b> ej;
  private Context mContext;
  private String mUrl;
  private long wJ;
  
  public mtf(Context paramContext, String paramString, HashMap<Integer, mtf.b> paramHashMap, long paramLong)
  {
    this.mContext = paramContext;
    this.mUrl = paramString;
    this.ej = paramHashMap;
    this.wJ = paramLong;
  }
  
  private void aRS() {}
  
  public void a(mtf.a parama)
  {
    this.jdField_a_of_type_Mtf$a = parama;
  }
  
  public void destory()
  {
    if (this.jdField_a_of_type_Mtf$c != null)
    {
      this.jdField_a_of_type_Mtf$c.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Mtf$c = null;
    }
    this.jdField_a_of_type_Mtf$a = null;
  }
  
  public void start()
  {
    this.jdField_a_of_type_Mtf$c = new mtf.c(Looper.getMainLooper());
    this.jdField_a_of_type_Mtf$c.sendEmptyMessageDelayed(1, this.wJ);
    aRS();
  }
  
  static abstract interface a
  {
    public abstract void a(int paramInt, String paramString, HashMap<Integer, mtf.b> paramHashMap, long paramLong);
  }
  
  static class b
  {
    public int aUn = 2147483647;
    public int index;
    public long wK;
    public long wL;
  }
  
  class c
    extends Handler
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
      } while (mtf.a(mtf.this) == null);
      mtf.a(mtf.this).a(4, null, null, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtf
 * JD-Core Version:    0.7.0.1
 */