import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;
import java.util.Set;

public class amwx
  extends amvg
{
  private Comparator<ampt> ad = new amwy(this);
  
  public amwx(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramString, paramSet);
  }
  
  public Comparator<ampt> f()
  {
    return this.ad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwx
 * JD-Core Version:    0.7.0.1
 */