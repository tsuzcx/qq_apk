import android.view.MotionEvent;

public class anjj
{
  private anjh b;
  
  public anjj(anjh.a parama)
  {
    this.b = new anjh(parama);
  }
  
  public void a(anjj.a parama, long paramLong)
  {
    switch (parama.action)
    {
    case 4: 
    default: 
      return;
    case 5: 
      this.b.a(paramLong, parama.dIl, parama.zM, parama.zN, 5, parama.timestamp);
      return;
    case 0: 
      this.b.a(paramLong, parama.bA[0], parama.dr[0], parama.ds[0], 0, parama.timestamp);
      return;
    case 2: 
      this.b.a(paramLong, parama.bA, parama.dr, parama.ds, parama.timestamp);
      return;
    case 6: 
      this.b.b(paramLong, parama.dIl, parama.zM, parama.zN, 6, parama.timestamp);
      return;
    case 1: 
      this.b.b(paramLong, parama.bA[0], parama.dr[0], parama.ds[0], 1, parama.timestamp);
      return;
    }
    this.b.b(paramLong, parama.bA, parama.dr, parama.ds, parama.timestamp);
  }
  
  public static class a
  {
    final int action;
    final int[] bA;
    final int dIk;
    final int dIl;
    final float[] dr;
    final float[] ds;
    final long timestamp;
    final float zM;
    final float zN;
    
    public a(MotionEvent paramMotionEvent)
    {
      this.action = paramMotionEvent.getActionMasked();
      this.dIk = paramMotionEvent.getPointerCount();
      this.bA = new int[this.dIk];
      this.dr = new float[this.dIk];
      this.ds = new float[this.dIk];
      int i = 0;
      while (i < this.dIk)
      {
        this.bA[i] = paramMotionEvent.getPointerId(i);
        this.dr[i] = paramMotionEvent.getX(i);
        this.ds[i] = paramMotionEvent.getY(i);
        i += 1;
      }
      this.timestamp = System.currentTimeMillis();
      i = paramMotionEvent.getActionIndex();
      this.dIl = paramMotionEvent.getPointerId(i);
      this.zM = paramMotionEvent.getX(i);
      this.zN = paramMotionEvent.getY(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjj
 * JD-Core Version:    0.7.0.1
 */