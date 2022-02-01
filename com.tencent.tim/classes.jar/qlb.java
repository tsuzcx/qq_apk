import android.view.View;

public abstract interface qlb
{
  public abstract qle.a a();
  
  public abstract void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(qlb.a parama);
  
  public abstract void a(qlb.b paramb);
  
  public abstract void a(qlb.c paramc);
  
  public abstract void a(qlb.d paramd);
  
  public abstract void a(qlb.e parame);
  
  public abstract void destroy();
  
  public abstract long getCurrentPosition();
  
  public abstract long getDuration();
  
  public abstract int getPlayType();
  
  public abstract View getView();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void restart();
  
  public abstract int sI();
  
  public abstract void setVisibility(int paramInt);
  
  public abstract void start();
  
  public abstract void stopPlayback();
  
  public static abstract interface a
  {
    public abstract void e(qlb paramqlb);
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract boolean a(qlb paramqlb, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject);
  }
  
  public static abstract interface d
  {
    public abstract boolean a(qlb paramqlb, int paramInt, Object paramObject);
  }
  
  public static abstract interface e
  {
    public abstract void d(qlb paramqlb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlb
 * JD-Core Version:    0.7.0.1
 */