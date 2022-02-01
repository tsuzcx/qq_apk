import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public abstract interface qgz
{
  public abstract void a(int paramInt, qgz.b paramb);
  
  public abstract boolean a(qgy.d paramd);
  
  public abstract List<qgz.c> ap(List<qgy.c> paramList);
  
  @NonNull
  public abstract qgy.f b();
  
  public abstract void create();
  
  public abstract void destroy();
  
  public static abstract class a
    implements qgz
  {
    public boolean a(qgy.d paramd)
    {
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ErrorMessage paramErrorMessage, List<qgy.c> paramList, boolean paramBoolean);
    
    public abstract void b(ErrorMessage paramErrorMessage, List<qgy.d> paramList, boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void a(qgz.c.a parama);
    
    public static abstract interface a
    {
      public abstract void C(List<qgy.d> paramList, boolean paramBoolean);
      
      public abstract void b(ErrorMessage paramErrorMessage, List<qgy.c> paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgz
 * JD-Core Version:    0.7.0.1
 */