import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class twv
{
  public List<String> a = new ArrayList();
  public List<String> b = new ArrayList();
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.b.contains(paramString))) {
      this.b.add(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twv
 * JD-Core Version:    0.7.0.1
 */