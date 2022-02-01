import android.view.View;

public abstract interface ajzp
{
  public abstract void a(ajzp.a parama);
  
  public abstract void a(ajzp.b paramb);
  
  public abstract void a(ajzp.c paramc);
  
  public abstract void a(ajzp.d paramd);
  
  public abstract void a(ajzp.e parame);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, long paramLong);
  
  public abstract long getCurrentPosition();
  
  public abstract int getProgress();
  
  public abstract View getView();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void restart();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void start();
  
  public abstract void stopPlayback();
  
  public static abstract interface a
  {
    public abstract void a(ajzp paramajzp);
  }
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract boolean a(ajzp paramajzp, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject);
  }
  
  public static abstract interface d {}
  
  public static abstract interface e
  {
    public abstract void b(ajzp paramajzp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzp
 * JD-Core Version:    0.7.0.1
 */