import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.lang.ref.SoftReference;

public class mlu
  extends AsyncTask<Void, Void, Bitmap>
{
  private mlu.b a;
  private mlu.a jdField_b_of_type_Mlu$a;
  private mlw jdField_b_of_type_Mlw;
  private SoftReference<Bitmap> g;
  public int height;
  int id = -2147483648;
  private Object lock = new Object();
  public String path;
  public int position;
  private int tryCount;
  public int type;
  public int width;
  
  public mlu(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, mlu.a parama)
  {
    this.type = paramInt1;
    this.path = paramString;
    this.position = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.jdField_b_of_type_Mlu$a = parama;
  }
  
  private void aQa()
  {
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      return;
    }
  }
  
  private void release()
  {
    this.jdField_b_of_type_Mlu$a = null;
    this.a = null;
  }
  
  public Bitmap P()
  {
    if ((this.g != null) && (this.g.get() != null))
    {
      Bitmap localBitmap = (Bitmap)this.g.get();
      if (!localBitmap.isRecycled()) {
        return localBitmap;
      }
    }
    this.g = null;
    return null;
  }
  
  public void a(mlu.b paramb)
  {
    this.a = paramb;
  }
  
  public void a(mlw parammlw)
  {
    this.jdField_b_of_type_Mlw = parammlw;
  }
  
  protected Bitmap b(Void... arg1)
  {
    ??? = P();
    if (??? != null) {
      return ???;
    }
    this.tryCount += 1;
    Bitmap[] arrayOfBitmap = new Bitmap[1];
    arrayOfBitmap[0] = null;
    this.jdField_b_of_type_Mlw.a(this, new mlv(this, arrayOfBitmap));
    synchronized (this.lock)
    {
      try
      {
        this.lock.wait();
        return arrayOfBitmap[0];
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  protected void o(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.g = new SoftReference(paramBitmap);
    if (this.a != null) {
      this.a.c(this);
    }
    if (this.jdField_b_of_type_Mlu$a != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label68;
      }
      this.jdField_b_of_type_Mlu$a.a(paramBitmap, this);
    }
    for (;;)
    {
      release();
      return;
      label68:
      this.jdField_b_of_type_Mlu$a.aPX();
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    release();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.a != null) {
      this.a.b(this);
    }
  }
  
  public String toString()
  {
    return "CaptureTask{id=" + this.id + ", type=" + this.type + ", path='" + this.path + '\'' + ", position=" + this.position + ", width=" + this.width + ", height=" + this.height + '}';
  }
  
  public static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap, mlu parammlu);
    
    public abstract void aPX();
  }
  
  public static abstract interface b
  {
    public abstract void b(mlu parammlu);
    
    public abstract void c(mlu parammlu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mlu
 * JD-Core Version:    0.7.0.1
 */