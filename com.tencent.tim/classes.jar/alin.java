import java.io.IOException;

public abstract interface alin
{
  public abstract void a(int paramInt, byte paramByte);
  
  public abstract void a(alio paramalio);
  
  public abstract void ao(float paramFloat);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void prepare()
    throws IOException;
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setDataSource(String paramString)
    throws IOException;
  
  public abstract void setStreamType(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alin
 * JD-Core Version:    0.7.0.1
 */