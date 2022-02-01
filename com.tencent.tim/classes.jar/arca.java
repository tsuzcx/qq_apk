import android.text.TextUtils;
import java.util.ArrayList;

public class arca
{
  public static final ArrayList<String> ec()
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject = (aeow)aeif.a().o(361);
        if ((localObject != null) && (!TextUtils.isEmpty(((aeow)localObject).bAf)))
        {
          localObject = ((aeow)localObject).bAf;
          localObject = ((String)localObject).split(";");
          int j = localObject.length;
          int i = 0;
          if (i < j)
          {
            localArrayList.add(localObject[i]);
            i += 1;
            continue;
          }
          return localArrayList;
        }
      }
      catch (Throwable localThrowable) {}
      String str = "QQ";
    }
  }
  
  public static final boolean s(int paramInt, boolean paramBoolean)
  {
    aeow localaeow = (aeow)aeif.a().o(361);
    if (localaeow != null) {}
    switch (paramInt)
    {
    default: 
      return paramBoolean;
    case 1: 
      return localaeow.bVo;
    case 2: 
      return localaeow.bVp;
    }
    return localaeow.bVq;
  }
  
  public static final boolean t(int paramInt, boolean paramBoolean)
  {
    aeow localaeow = (aeow)aeif.a().o(361);
    if (localaeow != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return paramBoolean;
        } while (Math.random() >= Float.valueOf(localaeow.bAc).floatValue());
        return true;
      } while (Math.random() >= Float.valueOf(localaeow.bAd).floatValue());
      return true;
    } while (Math.random() >= Float.valueOf(localaeow.bAe).floatValue());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arca
 * JD-Core Version:    0.7.0.1
 */