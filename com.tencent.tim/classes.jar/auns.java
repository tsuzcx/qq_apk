import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class auns
{
  public static void F(List<aunr> paramList1, List<aunr> paramList2)
  {
    Collections.sort(paramList2, new auns.a());
    paramList1.addAll(paramList2);
  }
  
  public static boolean a(aunr paramaunr)
  {
    return false;
  }
  
  public static File b(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.startsWith("http://"))
      {
        paramString1 = paramString2;
        if (paramString2.length() > 7) {
          paramString1 = paramString2.substring(7);
        }
      }
      paramString1 = aqmr.toNoSpaceHexString(paramString1);
    }
    return paramContext.getFileStreamPath(paramString1);
  }
  
  public static Bitmap d(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    aqcu.decodeFile(paramFile.getAbsolutePath(), localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((i > 150) && (j > 150))
    {
      int k = i / 150;
      j /= 150;
      if (k <= j) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      localOptions.inSampleSize = i;
      localOptions.inJustDecodeBounds = false;
      return aqcu.decodeFile(paramFile.getAbsolutePath(), localOptions);
    }
  }
  
  public static class a
    implements Comparator<aunr>
  {
    private boolean b(aunr paramaunr)
    {
      return (paramaunr != null) && (paramaunr.c != null);
    }
    
    public int a(aunr paramaunr1, aunr paramaunr2)
    {
      if ((b(paramaunr1)) && (b(paramaunr2))) {
        if (paramaunr1.c.sPriority <= paramaunr2.c.sPriority) {}
      }
      while (b(paramaunr1))
      {
        return -1;
        if (paramaunr1.c.sPriority < paramaunr2.c.sPriority) {
          return 1;
        }
        return 0;
      }
      if (b(paramaunr2)) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auns
 * JD-Core Version:    0.7.0.1
 */