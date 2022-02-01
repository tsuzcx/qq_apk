import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;

public class amjl
  extends amjz
{
  private SearchHistory a;
  
  public amjl(QQAppInterface paramQQAppInterface, SearchHistory paramSearchHistory)
  {
    this.a = paramSearchHistory;
  }
  
  public int IO()
  {
    return 0;
  }
  
  public void PG(String paramString) {}
  
  public SearchHistory a()
  {
    return this.a;
  }
  
  public Drawable aP()
  {
    return null;
  }
  
  public String getExtraInfo()
  {
    return null;
  }
  
  public String getIdentifier()
  {
    return this.a.uin;
  }
  
  public int pG()
  {
    switch (this.a.type)
    {
    default: 
    case 3000: 
    case 1: 
    case 1006: 
    case 56938: 
    case 1008: 
      do
      {
        return 1;
        return 101;
        return 4;
        return 11;
      } while (!TextUtils.equals(this.a.uin, acbn.blw));
      return 110;
    }
    return 111;
  }
  
  public String yU()
  {
    return this.a.extralInfo;
  }
  
  public String yV()
  {
    return this.a.displayName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjl
 * JD-Core Version:    0.7.0.1
 */