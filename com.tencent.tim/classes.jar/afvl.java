import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class afvl
{
  private List<String> iD = new ArrayList(20);
  private QQAppInterface mApp;
  
  public afvl(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  void dcX()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.iD.size())
    {
      if (i != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append((String)this.iD.get(i));
      i += 1;
    }
    if (this.mApp != null) {
      anot.a(this.mApp, "dc00898", "", "", "0X8009324", "0X8009324", 0, 0, "", "", localStringBuffer.toString(), "");
    }
    this.iD.clear();
  }
  
  public void flush()
  {
    if (this.iD.size() > 0) {
      dcX();
    }
  }
  
  public void lO(String paramString)
  {
    this.iD.add(paramString);
    if (this.iD.size() >= 20) {
      dcX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvl
 * JD-Core Version:    0.7.0.1
 */