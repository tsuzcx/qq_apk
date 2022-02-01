import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class acfn
{
  private static acfn a;
  long PH = 720000L;
  public String aJT = "";
  float[] aZ = { 0.94F, 0.6F, 0.0F };
  boolean bHF;
  public int cvF = 12;
  public int cvG = 3;
  public int cvH = 0;
  private int cvI = 1;
  private int cvJ = -1;
  private int cvK = 1;
  int[] ki = { 47185920, 68157440, 89128960, 120586240 };
  int[] kj = { 3840000, 1920000, 960000, 720000, 600000 };
  
  private acfn()
  {
    Object localObject1 = DeviceProfileManager.a();
    Object localObject2 = ((DeviceProfileManager)localObject1).jf("qq_process_gm");
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "config = " + (String)localObject2);
    }
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equals("0"))) {}
    int i;
    label359:
    do
    {
      do
      {
        return;
        localObject2 = ((String)localObject2).split("__");
        if (localObject2.length > 1) {
          localObject1 = localObject2[(localObject1.cuV % localObject2.length)];
        }
        for (;;)
        {
          localObject1 = ((String)localObject1).split(";");
          if (localObject1.length < 4) {
            break;
          }
          try
          {
            localObject2 = localObject1[0].split("\\|");
            i = 0;
            for (;;)
            {
              if (i >= this.ki.length) {
                break label359;
              }
              j = Integer.parseInt(localObject2[i]);
              if ((j <= 20) || (j >= 200)) {
                break;
              }
              this.ki[i] = (j * 1024 * 1024);
              i += 1;
            }
            localObject1 = localObject2[0];
            continue;
            throw new IllegalArgumentException("Illegal memory size " + j);
          }
          catch (Throwable localThrowable1) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("GuardManager", 2, "Exception: ", localThrowable1);
      return;
      localObject2 = localThrowable1[1].split("\\|");
      i = 0;
      while (i < this.kj.length)
      {
        j = Integer.parseInt(localObject2[i]);
        if ((j > 5) && (j < 100))
        {
          this.kj[i] = (j * 60 * 1000);
          i += 1;
        }
        else
        {
          throw new IllegalArgumentException("Illegal timeout value " + j);
        }
      }
      localObject2 = localThrowable1[2].split("\\|");
      float f;
      if (this.aZ.length < localObject2.length)
      {
        i = this.aZ.length;
        break label930;
        for (;;)
        {
          if (j >= i) {
            break label553;
          }
          f = Float.parseFloat(localObject2[j]);
          if ((f < 0.0F) || (f > 15.0F)) {
            break;
          }
          this.aZ[j] = f;
          j += 1;
        }
      }
      i = localObject2.length;
      break label930;
      throw new IllegalArgumentException("Illegal fraction value " + f);
      i = Integer.parseInt(localThrowable1[3].split("\\|")[0]);
      if ((i <= 1) || (i >= 120)) {
        break;
      }
      this.PH = (i * 60 * 1000);
    } while (localThrowable1.length <= 4);
    label479:
    localObject2 = localThrowable1[4].split("\\|");
    label553:
    int j = Integer.parseInt(localObject2[0]);
    if (j < 1) {
      i = 1;
    }
    for (;;)
    {
      for (;;)
      {
        if (24 % i == 0) {
          this.cvF = i;
        }
        j = Integer.parseInt(localObject2[1]);
        if (j < 0) {
          i = 0;
        }
        for (;;)
        {
          for (;;)
          {
            this.cvG = i;
            if (localThrowable1.length > 6)
            {
              this.cvH = Integer.parseInt(localThrowable1[5]);
              this.aJT = localThrowable1[6];
            }
            if (localThrowable1.length > 7)
            {
              i = Integer.parseInt(localThrowable1[7]);
              if ((i >= 1) && (i < 10)) {
                com.tencent.mobileqq.app.GuardManager.cvM = i;
              }
            }
            if (localThrowable1.length > 8)
            {
              localObject2 = localThrowable1[8].split("\\|");
              if (localObject2.length > 0) {
                com.tencent.mobileqq.app.GuardManager.cvN = Integer.parseInt(localObject2[0]);
              }
              if (localObject2.length > 1) {
                com.tencent.mobileqq.app.GuardManager.cvO = Integer.parseInt(localObject2[1]);
              }
            }
            if (localThrowable1.length <= 9) {
              break label883;
            }
            i = Integer.parseInt(localThrowable1[9]);
            if (i != 1) {
              break;
            }
            try
            {
              String str1 = System.getProperty("ro.miui.ui.version.name");
              if ((TextUtils.isEmpty(str1)) || (str1.length() != 2) || (Integer.parseInt(str1.substring(1)) < 7)) {
                break;
              }
              this.bHF = true;
              return;
            }
            catch (Throwable localThrowable2)
            {
              return;
            }
          }
          throw new IllegalArgumentException("Illegal wake interval " + i);
          i = j;
          if (j > this.cvF) {
            i = this.cvF;
          }
        }
        try
        {
          label883:
          String str2 = System.getProperty("ro.miui.ui.version.name");
          if ((TextUtils.isEmpty(str2)) || (str2.length() != 2) || (Integer.parseInt(str2.substring(1)) < 7)) {
            break;
          }
          this.bHF = true;
          return;
        }
        catch (Throwable localThrowable3)
        {
          return;
        }
      }
      label930:
      j = 0;
      break label479;
      i = j;
      if (j > 24) {
        i = 24;
      }
    }
  }
  
  public static acfn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acfn();
      }
      return a;
    }
    finally {}
  }
  
  public int P(long paramLong)
  {
    int j = Arrays.binarySearch(this.ki, (int)paramLong);
    int i = j;
    if (j < 0) {
      i = -1 - j;
    }
    j = i - this.cvI;
    if (j > 2) {
      i = 2;
    }
    do
    {
      return i;
      i = j;
    } while (j >= 0);
    return 0;
  }
  
  public int a(long[][] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramInt2 != this.cvJ)
    {
      paramInt1 = 0;
      float f2;
      for (float f1 = 0.0F; paramInt1 < 3; f1 += f2)
      {
        int i = 0;
        f2 = 0.0F;
        while (i < 15)
        {
          f2 += (float)paramArrayOfLong[paramInt1][i];
          i += 1;
        }
        f2 = this.aZ[paramInt1] * f2 * 5.0F / 15.0F;
        paramInt1 += 1;
      }
      paramInt1 = (int)(3.0F - f1);
      if (paramInt1 < 0) {
        paramInt1 = j;
      }
    }
    for (;;)
    {
      this.cvJ = paramInt2;
      this.cvK = paramInt1;
      return paramInt1;
      if (paramInt1 > 2)
      {
        paramInt1 = 2;
        continue;
        return this.cvK;
      }
    }
  }
  
  public long a(long[][] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    return this.kj[(P(paramLong) + a(paramArrayOfLong, paramInt1, paramInt2))];
  }
  
  public String rB()
  {
    return this.aJT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acfn
 * JD-Core Version:    0.7.0.1
 */