import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class acgv
  implements acch.a
{
  public List<String> a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      boolean bool = ((QQAppInterface)paramAppInterface).a().aav();
      paramAppInterface = aert.c();
      if ((bool) && (paramAppInterface.aht()))
      {
        paramAppInterface = new ArrayList();
        paramAppInterface.add("150000");
        paramAppInterface.add("150000.150100");
        return paramAppInterface;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgv
 * JD-Core Version:    0.7.0.1
 */