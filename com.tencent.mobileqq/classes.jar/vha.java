import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class vha
{
  public static final int a = bgtn.a(17.0F);
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject = a(null, paramString, a, false);
    paramString = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((TextCell)((Iterator)localObject).next()).getText();
      if (str != null) {
        paramString.append(str);
      }
    }
    return paramString.toString();
  }
  
  public static ArrayList<TextCell> a(vhc paramvhc, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    return a(paramvhc, paramCharSequence, paramInt, paramBoolean, true, -1);
  }
  
  public static ArrayList<TextCell> a(vhc paramvhc, CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramvhc, paramCharSequence, paramInt, paramBoolean1, paramBoolean2, -1);
  }
  
  public static ArrayList<TextCell> a(vhc paramvhc, CharSequence paramCharSequence, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramCharSequence)) {
      localObject = new ArrayList();
    }
    int j;
    do
    {
      ArrayList localArrayList;
      do
      {
        return localObject;
        j = paramCharSequence.hashCode();
        if (!paramBoolean2) {
          break;
        }
        localArrayList = vhd.a().a(j);
        if (localArrayList == null) {
          break;
        }
        localObject = localArrayList;
      } while (!localArrayList.isEmpty());
      new ArrayList();
      int i = paramInt2;
      if (paramInt2 == -1) {
        i = paramInt1 - bgtn.b(1.5F);
      }
      paramvhc = b(paramvhc, paramCharSequence, i, paramBoolean1);
      localObject = paramvhc;
    } while (!paramBoolean2);
    vhd.a().a(j, paramvhc);
    return paramvhc;
  }
  
  private static ArrayList<TextCell> b(vhc paramvhc, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList(5);
    localArrayList3.add(new vfh(paramvhc, Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2)));
    localArrayList3.add(new vfg(vgb.i));
    localArrayList3.add(new vfh(paramvhc, vgb.l));
    localArrayList3.add(new vfi(paramvhc, vgb.k));
    Object localObject = localArrayList3.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((vfj)((Iterator)localObject).next()).a(paramCharSequence.toString());
    }
    int k = paramCharSequence.length();
    localObject = new StringBuilder(k);
    int i = 0;
    if (i < k)
    {
      Iterator localIterator = localArrayList3.iterator();
      while (localIterator.hasNext())
      {
        vfj localvfj = (vfj)localIterator.next();
        if (localvfj.a(i))
        {
          if (((StringBuilder)localObject).length() > 0)
          {
            localArrayList2.add(new TextCell(0, ((StringBuilder)localObject).toString()));
            ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
          }
          localArrayList1.clear();
          localArrayList1 = localvfj.a(paramInt, paramBoolean, paramvhc, paramCharSequence, localArrayList1);
          if (localArrayList1 != null) {
            localArrayList2.addAll(localArrayList1);
          }
          i = localvfj.a() - 1;
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((StringBuilder)localObject).append(paramCharSequence.charAt(i));
      }
      i += 1;
      break;
      if (((StringBuilder)localObject).length() > 0) {
        localArrayList2.add(new TextCell(0, ((StringBuilder)localObject).toString()));
      }
      return localArrayList2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vha
 * JD-Core Version:    0.7.0.1
 */