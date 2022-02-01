import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class acgt
  implements acch.a
{
  public List<String> a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).a().aav()))
    {
      paramAppInterface = new ArrayList();
      paramAppInterface.add("100000");
      return paramAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgt
 * JD-Core Version:    0.7.0.1
 */