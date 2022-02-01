import java.util.ArrayList;

public abstract interface angu
{
  public abstract void a(int paramInt, angq paramangq);
  
  public abstract void b(int paramInt, angq paramangq);
  
  public abstract void h(int paramInt, ArrayList<angq> paramArrayList);
  
  public abstract void onUpdateProgress(int paramInt);
  
  public static abstract class a
    implements angu
  {
    public void b(int paramInt, angq paramangq) {}
    
    public void h(int paramInt, ArrayList<angq> paramArrayList) {}
  }
  
  public static abstract class b
    implements angu
  {
    public void a(int paramInt, angq paramangq) {}
    
    public void b(int paramInt, angq paramangq) {}
    
    public void onUpdateProgress(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angu
 * JD-Core Version:    0.7.0.1
 */