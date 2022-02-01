import com.tencent.mobileqq.app.QQAppInterface;

public class atvg
  extends attt
{
  QQAppInterface app;
  String bHG;
  atsn d = null;
  String dirKey;
  
  public atvg(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
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
    this.app.a().YZ(this.bHG);
    return true;
  }
  
  public void clear()
  {
    if (this.d != null) {
      this.app.a().deleteObserver(this.d);
    }
  }
  
  public void ix()
  {
    this.d = new atvh(this);
    this.app.a().addObserver(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvg
 * JD-Core Version:    0.7.0.1
 */