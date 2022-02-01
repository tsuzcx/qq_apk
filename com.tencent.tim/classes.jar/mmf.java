import java.util.List;

public abstract interface mmf<T>
  extends List<T>
{
  public static abstract interface a<T extends mmf>
  {
    public abstract void a(T paramT);
    
    public abstract void a(T paramT, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void d(T paramT, int paramInt1, int paramInt2);
    
    public abstract void e(T paramT, int paramInt1, int paramInt2);
    
    public abstract void f(T paramT, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmf
 * JD-Core Version:    0.7.0.1
 */