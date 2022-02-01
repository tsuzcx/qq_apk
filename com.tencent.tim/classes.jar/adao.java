import com.tencent.mobileqq.applets.data.AppletItem;
import java.util.ArrayList;
import java.util.List;

public class adao
{
  public String des;
  public List<AppletItem> items = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppletsSetting:[").append("des = ").append(this.des).append(this.items);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adao
 * JD-Core Version:    0.7.0.1
 */