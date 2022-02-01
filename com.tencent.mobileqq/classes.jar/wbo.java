import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;

public abstract interface wbo
{
  public abstract void a(String paramString, int paramInt1, int paramInt2, wbk paramwbk);
  
  public abstract void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wbk paramwbk);
  
  public abstract void a(String paramString, int paramInt1, File paramFile, int paramInt2, wbk paramwbk);
  
  public abstract void a(String paramString, int paramInt, wbk paramwbk);
  
  public abstract void b(String paramString, int paramInt1, File paramFile, int paramInt2, wbk paramwbk);
  
  public abstract void b(String paramString, int paramInt, wbk paramwbk);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbo
 * JD-Core Version:    0.7.0.1
 */