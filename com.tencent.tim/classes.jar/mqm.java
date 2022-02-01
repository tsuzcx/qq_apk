import org.jetbrains.annotations.NotNull;

public abstract interface mqm<R>
{
  public abstract void N(float paramFloat);
  
  public abstract void onFailed(int paramInt, @NotNull String paramString);
  
  public abstract void onStart(@NotNull String paramString);
  
  public abstract void onSuccess(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqm
 * JD-Core Version:    0.7.0.1
 */