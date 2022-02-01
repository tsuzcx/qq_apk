import android.support.annotation.IntRange;

public abstract interface wop
{
  public abstract void a(wop.a parama);
  
  public abstract void cancel();
  
  public abstract void doOnDestroy();
  
  public abstract void doOnPause();
  
  public abstract void doOnResume();
  
  @IntRange(from=0L, to=3L)
  public abstract int getType();
  
  public abstract void play();
  
  public static abstract interface a
  {
    public abstract void yH(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wop
 * JD-Core Version:    0.7.0.1
 */