import com.tencent.mobileqq.app.QQAppInterface;

public class agms
  extends agku
{
  aghq a = null;
  QQAppInterface app;
  String bHG;
  String dirKey;
  
  public agms(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.app = paramQQAppInterface;
    this.bHG = paramString1;
    this.dirKey = paramString2;
    ix();
  }
  
  public int Em()
  {
    return 4;
  }
  
  public boolean alr()
  {
    this.app.a().fC(this.bHG, this.dirKey);
    return true;
  }
  
  public void clear()
  {
    if (this.a != null) {
      this.app.a().deleteObserver(this.a);
    }
  }
  
  public void ix()
  {
    this.a = new agmt(this);
    this.app.a().addObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agms
 * JD-Core Version:    0.7.0.1
 */