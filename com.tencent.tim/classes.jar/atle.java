import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class atle
  extends atdt
{
  public atle(QQAppInterface paramQQAppInterface, Activity paramActivity, augx paramaugx)
  {
    super(paramQQAppInterface, paramActivity, 0, paramaugx);
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
 * Qualified Name:     atle
 * JD-Core Version:    0.7.0.1
 */