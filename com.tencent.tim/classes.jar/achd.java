import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class achd
  implements acch.a
{
  private List<String> xC = new ArrayList();
  
  public List<String> a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (!this.xC.isEmpty())) {
      return this.xC;
    }
    return null;
  }
  
  public void bUk()
  {
    if (this.xC.isEmpty()) {
      this.xC.add("100066");
    }
  }
  
  public void bUl()
  {
    if (!this.xC.isEmpty()) {
      this.xC.remove("100066");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     achd
 * JD-Core Version:    0.7.0.1
 */