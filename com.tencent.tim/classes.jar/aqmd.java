import android.content.Context;
import android.content.res.Resources;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SendByFile.1;
import com.tencent.util.Pair;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aqmd
{
  private long atc = wC();
  private long atd = 1048576000L;
  private long ate = 104345600L;
  private boolean cUB = true;
  
  public static void a(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (paramInt == 1) {
          paramQQAppInterface.a().aV(str, paramString);
        } else {
          paramQQAppInterface.a().a(str, paramString, paramString, paramInt, true);
        }
      }
    }
  }
  
  public aqmd a(long paramLong)
  {
    this.atc = paramLong;
    return this;
  }
  
  public aqmd a(boolean paramBoolean)
  {
    this.cUB = paramBoolean;
    return this;
  }
  
  public Pair<ArrayList<String>, ArrayList<String>> a(List<String> paramList, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2)
  {
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    if (paramList == null) {
      return localPair;
    }
    ((ArrayList)localPair.first).clear();
    ((ArrayList)localPair.second).clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (ImageManager.isNetworkUrl(str))
      {
        ((ArrayList)localPair.first).add(str);
      }
      else
      {
        paramList = null;
        if (paramMap1 != null) {
          paramList = (LocalMediaInfo)paramMap1.get(str);
        }
        Object localObject = paramList;
        if (paramList == null)
        {
          localObject = paramList;
          if (paramMap2 != null) {
            localObject = (LocalMediaInfo)paramMap2.get(str);
          }
        }
        if (localObject == null)
        {
          ((ArrayList)localPair.first).add(str);
        }
        else
        {
          int i = aqfy.getMediaType((LocalMediaInfo)localObject);
          long l2 = ((LocalMediaInfo)localObject).fileSize;
          long l1 = l2;
          if (l2 <= 0L)
          {
            paramList = new File(str);
            l1 = l2;
            if (paramList.exists()) {
              l1 = paramList.length();
            }
          }
          if (i == 1)
          {
            if ((l1 > this.atd) || ((l1 > this.ate) && (paramBoolean)))
            {
              if (this.cUB)
              {
                ((ArrayList)localPair.second).add(str);
                aqfy.edE();
              }
            }
            else {
              ((ArrayList)localPair.first).add(str);
            }
          }
          else if ((l1 > this.atc) && (paramBoolean))
          {
            if (this.cUB) {
              ((ArrayList)localPair.second).add(str);
            }
          }
          else {
            ((ArrayList)localPair.first).add(str);
          }
        }
      }
    }
    return localPair;
  }
  
  public boolean a(Context paramContext, String paramString, boolean paramBoolean1, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2, boolean paramBoolean2)
  {
    if (ImageManager.isNetworkUrl(paramString))
    {
      paramBoolean2 = false;
      return paramBoolean2;
    }
    LocalMediaInfo localLocalMediaInfo = null;
    if (paramMap1 != null) {
      localLocalMediaInfo = (LocalMediaInfo)paramMap1.get(paramString);
    }
    paramMap1 = localLocalMediaInfo;
    if (localLocalMediaInfo == null)
    {
      paramMap1 = localLocalMediaInfo;
      if (paramMap2 != null) {
        paramMap1 = (LocalMediaInfo)paramMap2.get(paramString);
      }
    }
    if (paramMap1 == null) {
      return false;
    }
    int i = aqfy.getMediaType(paramMap1);
    long l2 = paramMap1.fileSize;
    long l1 = l2;
    if (l2 <= 0L)
    {
      paramString = new File(paramString);
      l1 = l2;
      if (paramString.exists()) {
        l1 = paramString.length();
      }
    }
    paramString = "";
    double d1;
    if (i == 1)
    {
      if ((l1 <= this.atd) && ((l1 <= this.ate) || (!paramBoolean1))) {
        break label574;
      }
      if (this.cUB)
      {
        if (!paramBoolean2) {
          break label582;
        }
        paramString = "M";
        paramMap1 = new DecimalFormat("#.##");
        if (l1 > this.atd)
        {
          double d2 = (float)this.atd * 1.0F / 1024.0F / 1024.0F + 1.0F;
          d1 = d2;
          if (d2 > 1000.0D)
          {
            paramString = "G";
            d1 = d2 / 1024.0D;
          }
          label234:
          paramString = String.format(paramContext.getResources().getString(2131690262), new Object[] { "" + paramMap1.format(d1), paramString });
        }
      }
    }
    for (;;)
    {
      label283:
      paramBoolean1 = true;
      for (;;)
      {
        paramMap1 = paramString;
        if (paramBoolean1)
        {
          paramMap1 = paramString;
          if (!paramBoolean2) {
            if (!this.cUB) {
              break label560;
            }
          }
        }
        label560:
        for (paramMap1 = paramContext.getResources().getString(2131690106);; paramMap1 = paramContext.getResources().getString(2131690107))
        {
          paramBoolean2 = paramBoolean1;
          if (!paramBoolean1) {
            break;
          }
          aurs.runOnUiThread(new SendByFile.1(this, paramContext, paramMap1));
          return paramBoolean1;
          d1 = this.ate / 1024L / 1024L + 1L;
          break label234;
          if (!paramBoolean2) {
            break label582;
          }
          paramString = String.format(paramContext.getResources().getString(2131690263), new Object[] { "" + (this.ate / 1024L / 1024L + 1L) });
          break label283;
          if ((l1 <= this.atc) || (!paramBoolean1)) {
            break label574;
          }
          if (this.cUB) {
            if (paramBoolean2) {
              paramString = String.format(paramContext.getResources().getString(2131690209), new Object[] { "" + this.atc / 1024L / 1024L });
            }
          }
          for (;;)
          {
            paramBoolean1 = true;
            break;
            if (paramBoolean2) {
              paramString = String.format(paramContext.getResources().getString(2131690210), new Object[] { "" + this.atc / 1024L / 1024L });
            }
          }
        }
        label574:
        paramString = "";
        paramBoolean1 = false;
      }
      label582:
      paramString = "";
    }
  }
  
  public boolean a(Context paramContext, List<String> paramList, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2)
  {
    if (paramList == null) {}
    do
    {
      while (!paramList.hasNext())
      {
        return false;
        paramList = paramList.iterator();
      }
    } while (!a(paramContext, (String)paramList.next(), paramBoolean, paramMap1, paramMap2, false));
    return true;
  }
  
  public aqmd b(long paramLong)
  {
    this.atd = paramLong;
    return this;
  }
  
  protected int wC()
  {
    return (int)aopb.hm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmd
 * JD-Core Version:    0.7.0.1
 */