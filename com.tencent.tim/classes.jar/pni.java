import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.List;

public abstract interface pni
{
  public abstract void a(pni.a parama);
  
  public abstract void stop();
  
  public abstract void vP(int paramInt);
  
  public abstract void w(List<png> paramList, boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt1, int paramInt2, png parampng);
    
    public abstract void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, png parampng);
    
    public abstract void a(String paramString, int paramInt1, File paramFile, int paramInt2, png parampng);
    
    public abstract void a(String paramString, int paramInt, png parampng);
    
    public abstract void b(String paramString, int paramInt1, File paramFile, int paramInt2, png parampng);
    
    public abstract void b(String paramString, int paramInt, png parampng);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pni
 * JD-Core Version:    0.7.0.1
 */