import android.support.annotation.NonNull;
import android.support.annotation.UiThread;

public abstract interface oeu<V extends oer>
{
  @UiThread
  public abstract void a(@NonNull V paramV);
  
  @UiThread
  public abstract void destroy();
  
  @UiThread
  public abstract void detachView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oeu
 * JD-Core Version:    0.7.0.1
 */