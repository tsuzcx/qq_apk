import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;

public abstract interface wgz
{
  public abstract void a(String paramString, int paramInt1, int paramInt2, wgv paramwgv);
  
  public abstract void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wgv paramwgv);
  
  public abstract void a(String paramString, int paramInt1, File paramFile, int paramInt2, wgv paramwgv);
  
  public abstract void a(String paramString, int paramInt, wgv paramwgv);
  
  public abstract void b(String paramString, int paramInt1, File paramFile, int paramInt2, wgv paramwgv);
  
  public abstract void b(String paramString, int paramInt, wgv paramwgv);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgz
 * JD-Core Version:    0.7.0.1
 */