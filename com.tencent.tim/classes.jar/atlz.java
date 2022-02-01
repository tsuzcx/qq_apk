import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class atlz
  extends atdt
{
  public atlz(QQAppInterface paramQQAppInterface, Context paramContext, augx paramaugx)
  {
    super(paramQQAppInterface, paramContext, 2, paramaugx);
  }
  
  private List<Object> bs(List<? extends Object> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localArrayList.add(new atkr(auqb.c(paramList.get(0))));
      localArrayList.add(paramList.get(0));
      i = 1;
    }
    for (;;)
    {
      if (i < paramList.size()) {
        try
        {
          if (auqb.cr(auqb.c(paramList.get(i))).equals(auqb.cr(auqb.c(paramList.get(i - 1)))))
          {
            localArrayList.add(paramList.get(i));
          }
          else
          {
            localArrayList.add(new atkr(auqb.c(paramList.get(i))));
            localArrayList.add(paramList.get(i));
          }
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
        }
      } else {
        return localArrayList;
      }
      i += 1;
    }
  }
  
  public void mx(List<? extends Object> paramList)
  {
    super.mx(bs(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlz
 * JD-Core Version:    0.7.0.1
 */