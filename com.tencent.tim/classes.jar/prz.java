import java.util.concurrent.atomic.AtomicBoolean;

public class prz
  implements psj
{
  protected AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  
  public boolean isDestroy()
  {
    return this.mIsDestroy.get();
  }
  
  public void onDestroy()
  {
    this.mIsDestroy.set(true);
  }
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prz
 * JD-Core Version:    0.7.0.1
 */