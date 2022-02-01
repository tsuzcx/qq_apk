import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.util.Map;

public abstract interface qmc
{
  public abstract void a(qmc.a parama);
  
  public abstract void a(qmc.h paramh);
  
  public abstract int getAudioSessionId();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isPlaying();
  
  public abstract void pause()
    throws IllegalStateException;
  
  public abstract void prepareAsync()
    throws IllegalStateException;
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt)
    throws IllegalStateException;
  
  public abstract void setAudioSessionId(int paramInt)
    throws IllegalArgumentException, IllegalStateException;
  
  public abstract void setAudioStreamType(int paramInt);
  
  public abstract void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setOnCompletionListener(qmc.b paramb);
  
  public abstract void setOnErrorListener(qmc.c paramc);
  
  public abstract void setOnInfoListener(qmc.d paramd);
  
  public abstract void setOnPreparedListener(qmc.e parame);
  
  public abstract void setOnSeekCompleteListener(qmc.f paramf);
  
  public abstract void setScreenOnWhilePlaying(boolean paramBoolean);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  public abstract void start()
    throws IllegalStateException;
  
  public abstract void stop()
    throws IllegalStateException;
  
  public static abstract interface a
  {
    public abstract void a(qmc paramqmc, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void b(qmc paramqmc);
  }
  
  public static abstract interface c
  {
    public abstract boolean b(qmc paramqmc, int paramInt1, int paramInt2);
  }
  
  public static abstract interface d
  {
    public abstract boolean a(qmc paramqmc, int paramInt1, int paramInt2);
  }
  
  public static abstract interface e
  {
    public abstract void a(qmc paramqmc);
  }
  
  public static abstract interface f
  {
    public abstract void c(qmc paramqmc);
  }
  
  public static abstract interface g
  {
    public abstract void d(qmc paramqmc);
  }
  
  public static abstract interface h
  {
    public abstract void a(qmc paramqmc, int paramInt1, int paramInt2);
  }
  
  public static abstract interface i
  {
    public abstract void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmc
 * JD-Core Version:    0.7.0.1
 */