import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class aeiz
{
  private String mPattern;
  private ArrayList<aejb> rz;
  
  public aeiz(String paramString)
  {
    this.mPattern = paramString;
    this.rz = G(paramString);
  }
  
  public ArrayList<aejb> G(String paramString)
  {
    ArrayList localArrayList = H(paramString);
    if (localArrayList.size() == 0) {
      return null;
    }
    if (!((String)localArrayList.get(0)).equals("$")) {
      return null;
    }
    paramString = new ArrayList();
    int i = 1;
    for (;;)
    {
      try
      {
        if (i < localArrayList.size())
        {
          str1 = (String)localArrayList.get(i);
          if (TextUtils.isEmpty(str1)) {
            return null;
          }
          if (str1.charAt(0) == '.')
          {
            paramString.add(new aejc(str1.substring(1)));
          }
          else
          {
            String str2 = aejd.a().ki(str1);
            if (!TextUtils.isEmpty(str2)) {
              paramString.add(new aejc(str2));
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ArkMsgReplyConfigMgr", 1, "parsePattern error:" + localException.getMessage());
      }
      return paramString;
      String str1 = aejd.a().kh(str1);
      if (!TextUtils.isEmpty(str1)) {
        paramString.add(new aeja(Integer.parseInt(str1)));
      } else {
        return null;
      }
      i += 1;
    }
  }
  
  public ArrayList<String> H(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new StringBuilder();
    int i = 0;
    int j = 0;
    if (j < paramString.length())
    {
      char c = paramString.charAt(j);
      Object localObject2;
      if (i == 0) {
        if (c != '.')
        {
          localObject2 = localObject1;
          if (c != '[') {}
        }
        else
        {
          if (((StringBuilder)localObject1).length() == 0) {
            return null;
          }
          localArrayList.add(((StringBuilder)localObject1).toString());
          localObject2 = new StringBuilder();
          if (c != '[') {
            break label126;
          }
          i = 1;
        }
      }
      for (;;)
      {
        ((StringBuilder)localObject2).append(c);
        j += 1;
        localObject1 = localObject2;
        break;
        label126:
        i = 0;
        continue;
        localObject2 = localObject1;
        if (c == ']')
        {
          i = 0;
          localObject2 = localObject1;
        }
      }
    }
    if (((StringBuilder)localObject1).length() == 0) {
      return null;
    }
    localArrayList.add(((StringBuilder)localObject1).toString());
    return localArrayList;
  }
  
  public Object a(Map<String, Object> paramMap)
  {
    Object localObject;
    if (paramMap == null)
    {
      localObject = null;
      return localObject;
    }
    if (this.rz.size() == 0) {
      return null;
    }
    Iterator localIterator = this.rz.iterator();
    for (;;)
    {
      localObject = paramMap;
      if (!localIterator.hasNext()) {
        break;
      }
      paramMap = ((aejb)localIterator.next()).g(paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeiz
 * JD-Core Version:    0.7.0.1
 */