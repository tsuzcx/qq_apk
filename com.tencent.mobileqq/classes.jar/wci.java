import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class wci
  extends vko
{
  public QQUserUIItem a;
  public String a;
  public List<QQUserUIItem> a;
  public String b;
  
  public String toString()
  {
    if (this.a == null) {
      return "UpdateUserInfoEvent " + super.toString();
    }
    return "UpdateUserInfoEvent " + this.a.toString() + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wci
 * JD-Core Version:    0.7.0.1
 */