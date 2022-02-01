import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ikf
{
  public static ikf a;
  public boolean RU;
  public int anZ = 0;
  public int aoa = 0;
  public List<ikf.a> fh;
  
  public static ikf a()
  {
    if ((a == null) || (a.RU)) {
      a = b();
    }
    return a;
  }
  
  public static List<ikf.a> aj()
  {
    ikf localikf = a();
    if (localikf != null) {
      return localikf.fh;
    }
    return null;
  }
  
  private static ikf b()
  {
    int i1 = 3;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC!");
    }
    String str = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.AVPanCfg.name());
    QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC dpcValue: " + str);
    ArrayList localArrayList = new ArrayList();
    int i;
    int k;
    int m;
    int n;
    if (!TextUtils.isEmpty(str)) {
      for (;;)
      {
        try
        {
          Object localObject1 = str.split("\\|");
          if ((localObject1 != null) && (localObject1.length >= 3))
          {
            j = ahzq.Z(localObject1[0], 0);
            localObject3 = localObject1[1];
            i = j;
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              i = j;
              localObject3 = ((String)localObject3).split("-");
              k = 0;
              i = j;
              if (k < localObject3.length)
              {
                Object localObject4 = localObject3[k];
                i = j;
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label623;
                }
                i = j;
                localObject4 = ((String)localObject4).split("_");
                i = j;
                if (localObject4.length < 2) {
                  break label615;
                }
                i = j;
                m = ahzq.Z(localObject4[0], 0);
                i = j;
                n = ahzq.Z(localObject4[1], 0);
                label204:
                if ((m <= 0) || (n <= 0)) {
                  break label623;
                }
                i = j;
                localArrayList.add(new ikf.a(n, m));
                break label623;
              }
            }
            i = j;
            k = ahzq.Z(localObject1[2], 3);
            i = j;
            label249:
            if (localArrayList.size() == 0)
            {
              localArrayList.add(new ikf.a(215, 4));
              localArrayList.add(new ikf.a(150, 8));
            }
            localObject1 = new ikf();
            ((ikf)localObject1).anZ = i;
            ((ikf)localObject1).aoa = k;
            ((ikf)localObject1).fh = localArrayList;
            if ((str == null) || (str.isEmpty())) {
              bool = true;
            }
            ((ikf)localObject1).RU = bool;
            return localObject1;
          }
          catch (Exception localException1)
          {
            j = i;
          }
          if ((localObject1 == null) || (localObject1.length != 1)) {
            continue;
          }
          j = ahzq.Z(localObject1[0], 0);
          i = j;
          QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC configs.length == 1");
          k = i1;
          i = j;
          continue;
        }
        catch (Exception localException2)
        {
          Object localObject3;
          Object localObject2;
          int j = 0;
          continue;
          m = 0;
          n = 0;
          continue;
        }
        k = i1;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC exception:", localException1);
          k = i1;
          i = j;
          continue;
          if ((localException1 != null) && (localException1.length == 2))
          {
            j = ahzq.Z(localException1[0], 0);
            localObject2 = localException1[1];
            i = j;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              i = j;
              localObject2 = ((String)localObject2).split("-");
              k = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = j;
      if (k < localObject2.length)
      {
        localObject3 = localObject2[k];
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label630;
        }
        i = j;
        localObject3 = ((String)localObject3).split("_");
        i = j;
        if (localObject3.length >= 2)
        {
          i = j;
          m = ahzq.Z(localObject3[0], 0);
          i = j;
          n = ahzq.Z(localObject3[1], 0);
          if ((m <= 0) || (n <= 0)) {
            break label630;
          }
          i = j;
          localArrayList.add(new ikf.a(n, m));
          break label630;
        }
      }
      else
      {
        i = j;
        QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC configs.length == 2");
        k = i1;
        i = j;
        break label249;
      }
      i = 0;
      k = i1;
      break label249;
      label615:
      m = 0;
      n = 0;
      break label204;
      label623:
      k += 1;
      break;
      label630:
      k += 1;
    }
  }
  
  public static int kV()
  {
    ikf localikf = a();
    if (localikf != null) {
      return localikf.aoa;
    }
    return 3;
  }
  
  public static boolean tB()
  {
    ikf localikf = a();
    return (localikf != null) && (localikf.anZ == 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hotVideoSwitch: ").append(this.anZ);
    localStringBuilder.append(" mPanoramaEffectMemory: ").append(this.aoa);
    Iterator localIterator = this.fh.iterator();
    String str = "";
    while (localIterator.hasNext())
    {
      ikf.a locala = (ikf.a)localIterator.next();
      if (locala != null) {
        str = str + locala.aoc + "_" + locala.aob + "-";
      }
    }
    localStringBuilder.append(" hotVideoBlurMemory: ").append(str);
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    int aob;
    int aoc;
    
    public a(int paramInt1, int paramInt2)
    {
      this.aob = paramInt1;
      this.aoc = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikf
 * JD-Core Version:    0.7.0.1
 */