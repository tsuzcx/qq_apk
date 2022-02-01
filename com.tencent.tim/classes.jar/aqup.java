import android.view.SurfaceHolder;

public abstract interface aqup
{
  public abstract void a(aqup.a parama);
  
  public abstract void a(aqup.b paramb);
  
  public abstract void a(aqup.c paramc);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getPlayState();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract boolean play(String paramString, int paramInt);
  
  public abstract void release();
  
  public abstract boolean resume();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setDisplay(SurfaceHolder paramSurfaceHolder);
  
  public abstract void start();
  
  public static abstract interface a
  {
    public abstract void b(aqup paramaqup);
  }
  
  public static abstract interface b
  {
    public abstract void onPlayStateChanged(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a(aqup paramaqup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqup
 * JD-Core Version:    0.7.0.1
 */