import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rpn
{
  private static Map<String, List<Integer>> gm;
  private static final List<Integer> pe = Arrays.asList(new Integer[] { Integer.valueOf(120), Integer.valueOf(200), Integer.valueOf(320), Integer.valueOf(512), Integer.valueOf(640), Integer.valueOf(750), Integer.valueOf(1000) });
  private static final List<Integer> pf = Arrays.asList(new Integer[] { Integer.valueOf(40), Integer.valueOf(60), Integer.valueOf(80), Integer.valueOf(100), Integer.valueOf(120), Integer.valueOf(140), Integer.valueOf(160), Integer.valueOf(200) });
  private static final List<Integer> pg = Arrays.asList(new Integer[] { Integer.valueOf(180), Integer.valueOf(200), Integer.valueOf(320) });
  
  private static void bvO()
  {
    Object localObject = psr.mC();
    ram.d("Q.qqstory.home.ThumbnailUrlHelper", "Json config in string " + (String)localObject);
    if (((String)localObject).isEmpty()) {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "no thumb config found in sp, check later");
    }
    for (;;)
    {
      return;
      try
      {
        ram.d("Q.qqstory.home.ThumbnailUrlHelper", "json " + (String)localObject);
        localObject = new JSONObject((String)localObject);
        JSONArray localJSONArray1 = ((JSONObject)localObject).names();
        gm = new HashMap();
        int i = 0;
        while (i < localJSONArray1.length())
        {
          String str = localJSONArray1.getString(i);
          ram.d("Q.qqstory.home.ThumbnailUrlHelper", "get key " + str);
          JSONArray localJSONArray2 = ((JSONObject)localObject).getJSONArray(str);
          ram.d("Q.qqstory.home.ThumbnailUrlHelper", "get specs " + localJSONArray2);
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < localJSONArray2.length())
          {
            localArrayList.add(Integer.valueOf(localJSONArray2.getInt(j)));
            j += 1;
          }
          gm.put(str, localArrayList);
          i += 1;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        ram.e("Q.qqstory.home.ThumbnailUrlHelper", "Invalid json format, fredguo look look");
      }
    }
  }
  
  private static int d(List<Integer> paramList, int paramInt)
  {
    int k;
    if ((paramList == null) || (paramList.size() == 0)) {
      k = -1;
    }
    int j;
    int i;
    do
    {
      return k;
      j = paramList.size() - 1;
      i = 0;
      while (i < j - 1)
      {
        k = i + (j - i) / 2;
        if (((Integer)paramList.get(k)).intValue() > paramInt) {
          j = k;
        } else {
          i = k;
        }
      }
      k = paramInt;
    } while (((Integer)paramList.get(j)).intValue() == paramInt);
    return ((Integer)paramList.get(i)).intValue();
  }
  
  private static int ej(int paramInt)
  {
    if (gm == null) {}
    int m;
    for (List localList = pe;; localList = (List)gm.get("qqstory_pic"))
    {
      int i = localList.size();
      int j = 2147483647;
      m = i - 1;
      i = 0;
      while (i < localList.size())
      {
        int n = Math.abs(((Integer)localList.get(i)).intValue() - paramInt);
        int k = j;
        if (n <= j)
        {
          m = i;
          k = n;
        }
        i += 1;
        j = k;
      }
    }
    return ((Integer)localList.get(m)).intValue();
  }
  
  public static boolean fC(@NonNull String paramString)
  {
    if ((paramString.length() >= "https://p.qpic.cn".length() + "/qqstory_pic/".length()) && (paramString.startsWith("/qqstory_pic/", "https://p.qpic.cn".length()))) {
      return true;
    }
    return paramString.contains("/qqstory_pic/");
  }
  
  private static boolean fD(@NonNull String paramString)
  {
    int i;
    if (paramString.startsWith("http://")) {
      i = 7;
    }
    while (!paramString.startsWith("qqpublic.qpic.cn/", i))
    {
      return false;
      if (paramString.startsWith("https://")) {
        i = 8;
      } else {
        return false;
      }
    }
    i += 17;
    if (paramString.startsWith("qq_public_cover/", i)) {
      return true;
    }
    return paramString.startsWith("qq_public/", i);
  }
  
  @Deprecated
  public static boolean fE(@NonNull String paramString)
  {
    if ((paramString.length() >= "https://p.qpic.cn".length() + "/qqstory/".length()) && (paramString.startsWith("/qqstory/", "https://p.qpic.cn".length()))) {
      return true;
    }
    return paramString.contains("/qqstory/");
  }
  
  @Nullable
  private static String getBid(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return null;
      paramString = paramString.split("/");
    } while (paramString.length < 4);
    return paramString[3];
  }
  
  public static String gm(String paramString)
  {
    int i = v(paramString, 120);
    if (i < 0)
    {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "cannot find thumbsize in getMinimumThumbnailPath " + paramString);
      return paramString;
    }
    paramString = gp(paramString);
    ram.d("Q.qqstory.home.ThumbnailUrlHelper", "getMinimumThumbnailPath " + paramString + i);
    return paramString + i;
  }
  
  public static String gn(String paramString)
  {
    ram.d("Q.qqstory.home.ThumbnailUrlHelper", "get thumbnail in 200 " + paramString);
    int i = v(paramString, 200);
    if (i < 0)
    {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "get invalid thumbsize 200 with url " + paramString);
      return paramString;
    }
    paramString = gp(paramString);
    ram.d("Q.qqstory.home.ThumbnailUrlHelper", "return thumbnail in 200 " + paramString + i);
    return paramString + i;
  }
  
  public static String go(String paramString)
  {
    ram.d("Q.qqstory.home.ThumbnailUrlHelper", "get thumbnail in 320 " + paramString);
    int i = v(paramString, 320);
    if (i < 0)
    {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "get invalid thumbsize 320 with url " + paramString);
      return paramString;
    }
    paramString = gp(paramString);
    ram.d("Q.qqstory.home.ThumbnailUrlHelper", "return thumbnail in 320 " + paramString + i);
    return paramString + i;
  }
  
  public static String gp(String paramString)
  {
    String str;
    if (fD(paramString)) {
      str = gq(paramString);
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.endsWith("/"));
    int k = paramString.lastIndexOf("/");
    int j;
    if ((k >= 0) && (k < paramString.length() - 1))
    {
      str = paramString.substring(k + 1, paramString.length());
      j = str.length() - 1;
      i = 0;
      if (j >= 0) {
        if (Character.isDigit(str.charAt(j))) {
          break label126;
        }
      }
    }
    for (int i = 0;; i = 0)
    {
      str = paramString;
      if (i != 0) {
        str = paramString.substring(0, k);
      }
      return str + "/";
      label126:
      j -= 1;
      i = 1;
      break;
    }
  }
  
  public static String gq(String paramString)
  {
    if (paramString.endsWith("/")) {}
    label106:
    label116:
    for (;;)
    {
      return paramString;
      int m = paramString.lastIndexOf("/");
      int j;
      if ((m >= 0) && (m < paramString.length() - 1))
      {
        String str = paramString.substring(m + 1, paramString.length());
        j = 0;
        i = 0;
        if (j < str.length())
        {
          int k = 1;
          i = 1;
          char c = str.charAt(j);
          if (Character.isDigit(c)) {
            break label106;
          }
          i = k;
          if (c == '?') {}
        }
      }
      for (int i = 0;; i = 0)
      {
        if (i == 0) {
          break label116;
        }
        return paramString.substring(0, m + 1);
        j += 1;
        break;
      }
    }
  }
  
  public static String r(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (!fC(paramString))
    {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "not qqstory url for getFullScreenThumbnailPath " + paramString);
      return paramString;
    }
    paramString = gp(paramString);
    int i = ej(rpq.getWindowScreenWidth(paramContext));
    ram.d("Q.qqstory.home.ThumbnailUrlHelper", "get fullscreen thumbnail url " + paramString + i);
    return paramString + i;
  }
  
  private static int u(String paramString, int paramInt)
  {
    if (paramString == null) {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "origPath is null");
    }
    do
    {
      return -1;
      if (fC(paramString)) {
        return d(pe, paramInt);
      }
      if (fE(paramString)) {
        return d(pf, paramInt);
      }
    } while (!fD(paramString));
    return d(pg, paramInt);
  }
  
  private static int v(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "origPath is null");
      return -1;
    }
    if (gm == null) {
      bvO();
    }
    if (gm == null) {
      return u(paramString, paramInt);
    }
    String str = getBid(paramString);
    if (str == null)
    {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "cannot find bid with url " + paramString);
      return -1;
    }
    paramString = (List)gm.get(str);
    if (paramString == null)
    {
      ram.w("Q.qqstory.home.ThumbnailUrlHelper", "cannot find specs with bid " + str + ", check log");
      return -1;
    }
    return d(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpn
 * JD-Core Version:    0.7.0.1
 */