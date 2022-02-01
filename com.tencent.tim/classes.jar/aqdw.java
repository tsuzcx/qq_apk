import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class aqdw
{
  amhj f;
  QQAppInterface mApp;
  
  public aqdw(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public Bundle l(Bundle paramBundle)
  {
    paramBundle = paramBundle.getStringArrayList("key");
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key", paramBundle);
    if ((paramBundle == null) || (paramBundle.size() == 0)) {
      return localBundle;
    }
    if (this.f == null) {
      this.f = ((amhj)this.mApp.getManager(15));
    }
    if (this.f == null) {
      return localBundle;
    }
    ArrayList localArrayList = new ArrayList(paramBundle.size());
    Iterator localIterator = paramBundle.iterator();
    String str1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      str1 = "";
      Object localObject;
      if (str2 == null)
      {
        localObject = null;
        label124:
        paramBundle = str1;
        if (localObject != null)
        {
          paramBundle = str1;
          if (localObject.length != 3) {}
        }
      }
      for (;;)
      {
        try
        {
          int j = Integer.parseInt(localObject[0]);
          String str3 = localObject[1];
          int i = Integer.parseInt(localObject[2]);
          paramBundle = str1;
          if (j == 1)
          {
            j = Integer.parseInt(str3);
            localObject = this.f.a(j);
            paramBundle = str1;
            if (localObject != null)
            {
              if (i != 201) {
                continue;
              }
              paramBundle = ((amev)localObject).bigIcon;
            }
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          paramBundle = str1;
          continue;
        }
        ajrk.f("getIconUrl", "getIconUrl", new Object[] { str2, paramBundle });
        localArrayList.add(paramBundle);
        break;
        localObject = str2.split("_s_");
        break label124;
        paramBundle = ((amev)localObject).bZO;
      }
    }
    localBundle.putStringArrayList("path", localArrayList);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdw
 * JD-Core Version:    0.7.0.1
 */