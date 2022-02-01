import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import java.util.List;

public abstract class amno
  implements amwd<amnr>
{
  protected QQAppInterface app;
  
  public amno(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public abstract void R(String paramString, List<FTSEntity> paramList);
  
  public abstract void b(amwt paramamwt, amwe<amnq> paramamwe);
  
  public void cancel() {}
  
  public void destroy() {}
  
  public void init() {}
  
  public void pause() {}
  
  public void resume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amno
 * JD-Core Version:    0.7.0.1
 */