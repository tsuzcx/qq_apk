import android.opengl.GLES20;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.a;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class aded
{
  public static final float[] bT = { -0.5F, 0.5F, 0.0F, 0.0F, 1.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, 1.0F, 0.0F, 0.5F, 0.5F, 0.0F, 1.0F, 1.0F };
  public static final float[] bU = { -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 1.0F, 0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.5F, 0.5F, 0.0F, 1.0F, 0.0F };
  public static final short[] c = { 0, 1, 2, 2, 3, 0 };
  
  public static int a(adec paramadec)
  {
    if ((paramadec == null) || (paramadec.b == null)) {}
    for (;;)
    {
      return 0;
      try
      {
        int i = ((ArVideoResourceInfo)paramadec.b.uk.get(0)).cIe;
        if (i >= 0) {}
        for (;;)
        {
          return i;
          i = 0;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Throwable paramadec) {}
    }
    paramadec.printStackTrace();
    return 0;
  }
  
  public static ArCloudConfigInfo.a a(String paramString)
  {
    ArCloudConfigInfo.a locala = new ArCloudConfigInfo.a();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length >= 1) {
          locala.width = Integer.valueOf(paramString[0]).intValue();
        }
        if (paramString.length >= 2) {
          locala.height = Integer.valueOf(paramString[1]).intValue();
        }
      }
    }
    return locala;
  }
  
  public static ArCloudConfigInfo.a a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a(paramString);
    if ((paramString.width == 0) || (paramString.height == 0)) {
      return paramString;
    }
    int i = paramString.width;
    int j = paramString.height;
    if (paramInt2 * 1.0F / j > paramInt1 * 1.0F / i)
    {
      paramInt1 = j * 1 * paramInt1 / i;
      paramString.scaleX = 2.0F;
    }
    for (paramString.scaleY = (paramInt1 * 2.0F / paramInt2);; paramString.scaleY = 2.0F)
    {
      paramString.uN = 0.0F;
      paramString.uO = 0.0F;
      paramString.uP = 0.0F;
      return paramString;
      paramString.scaleX = (i * 1 * paramInt2 / j * 2.0F / paramInt1);
    }
  }
  
  public static ArCloudConfigInfo.a a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArCloudConfigInfo.a locala = a(paramString);
    if ((locala.width == 0) || (locala.height == 0))
    {
      locala.width = paramInt1;
      locala.height = paramInt2;
    }
    float f7 = paramInt1 * 1.0F / Math.max(1, paramInt2);
    float f8 = locala.width;
    float f9 = locala.height;
    float f2 = 1.0F;
    float f1 = 1.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f10 = 1.0F * f8 / f9;
    float f5;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\|");
      if (paramString != null)
      {
        if (paramString.length >= 3) {
          f2 = Float.valueOf(paramString[2]).floatValue();
        }
        if (paramString.length >= 4) {
          f1 = Float.valueOf(paramString[3]).floatValue();
        }
        if (paramString.length >= 5) {
          f3 = Float.valueOf(paramString[4]).floatValue();
        }
        if (paramString.length >= 6) {
          f4 = -Float.valueOf(paramString[5]).floatValue();
        }
        f5 = f4;
        paramInt2 = 1;
        f4 = f3;
        f3 = f5;
      }
    }
    for (;;)
    {
      paramInt1 = 1;
      f5 = f1;
      float f6 = f2;
      if (paramInt2 != 0)
      {
        if ((f2 <= 0.05F) || (f1 <= 0.05F)) {
          break label385;
        }
        if (f10 > f7)
        {
          paramInt1 = 1;
          f6 = f2;
          f5 = f1;
        }
      }
      else
      {
        if (!paramBoolean) {
          break label500;
        }
        locala.scaleX = (10.0F * f7);
        locala.scaleY = 10.0F;
        locala.uN = 0.0F;
        locala.uO = 0.0F;
        locala.uP = -5.0F;
        if (paramInt2 != 0)
        {
          if (paramInt1 == 0) {
            break label459;
          }
          locala.scaleX *= f6;
          locala.scaleY = (locala.scaleX * (f9 / f8));
          f1 = locala.scaleX / 2.0F;
          label320:
          locala.uN = (f4 * f7 / f1);
          locala.uO = (f3 / f1);
        }
      }
      label385:
      label459:
      label500:
      do
      {
        QLog.i("ARVideoUtil", 1, "parseVideoLayout layout = " + locala);
        return locala;
        paramInt1 = 0;
        f5 = f1;
        f6 = f2;
        break;
        if (f2 > 0.05F)
        {
          paramInt1 = 1;
          f5 = f1;
          f6 = f2;
          break;
        }
        if (f1 > 0.05F)
        {
          paramInt1 = 0;
          f5 = f1;
          f6 = f2;
          break;
        }
        if (f10 > f7)
        {
          paramInt1 = 1;
          f6 = 1.0F;
          f5 = f1;
          break;
        }
        paramInt1 = 0;
        f5 = 1.0F;
        f6 = f2;
        break;
        locala.scaleY *= f5;
        locala.scaleX = (locala.scaleY * (f8 / f9));
        f1 = locala.scaleY / 2.0F;
        break label320;
        locala.scaleX = 2.0F;
        locala.scaleY = 2.0F;
        locala.uN = 0.0F;
        locala.uO = 0.0F;
        locala.uP = 0.0F;
      } while (paramInt2 == 0);
      if (paramInt1 != 0)
      {
        locala.scaleX *= f6;
        locala.scaleY = (locala.scaleX * f7 * (f9 / f8));
      }
      for (f1 = locala.scaleX / 2.0F;; f1 = locala.scaleY / 2.0F)
      {
        locala.uN = (f4 / f1);
        locala.uO = (f3 / f1);
        break;
        locala.scaleY *= f5;
        locala.scaleX = (locala.scaleY / f7 * (f8 / f9));
      }
      f4 = 0.0F;
      f2 = 1.0F;
      f3 = 0.0F;
      paramInt2 = 0;
    }
  }
  
  public static Pair<Integer, adkf> a(adec paramadec)
  {
    int k = 0;
    adkf localadkf = adke.a(0);
    if (paramadec.b.type == 2) {}
    for (;;)
    {
      int j;
      try
      {
        j = Integer.parseInt(((ArVideoResourceInfo)paramadec.b.uk.get(0)).bur);
        if (j < 0)
        {
          i = k;
          return new Pair(Integer.valueOf(i), localadkf);
        }
      }
      catch (Throwable paramadec)
      {
        j = 0;
        continue;
        if (j != 0)
        {
          i = k;
          if (j != 1) {
            continue;
          }
        }
        i = j;
        continue;
      }
      if (paramadec.b.type != 3)
      {
        i = k;
        if (paramadec.b.type != 4) {}
      }
      else if ((paramadec.b.type == 4) && ("circle".equalsIgnoreCase(((ArVideoResourceInfo)paramadec.b.uk.get(0)).bur)))
      {
        i = 1;
      }
      else
      {
        try
        {
          paramadec = ((ArVideoResourceInfo)paramadec.b.uk.get(0)).bur.split("\\|");
          if ((paramadec == null) || (paramadec.length < 5)) {
            break;
          }
          i = Integer.parseInt(paramadec[0]);
          j = Integer.parseInt(paramadec[1]);
          int m = Integer.parseInt(paramadec[2]);
          int n = Integer.parseInt(paramadec[3]);
          int i1 = Integer.parseInt(paramadec[4]);
          if ((i > 255) || (j > 255) || (m > 255) || (n > 255) || (i < 0) || (j < 0) || (m < 0) || (n < 0) || (i1 < 0) || (i1 > 100)) {
            break label601;
          }
          localadkf.i(i / 255.0F, j / 255.0F, m / 255.0F);
          localadkf.keyType = 1;
          localadkf.uY = (n / 255.0F);
          localadkf.uZ = (i1 / 100.0F);
          if ((paramadec != null) && (paramadec.length >= 6) && (Integer.parseInt(paramadec[5]) == 1)) {
            localadkf.keyType = 2;
          }
          if ((paramadec != null) && (paramadec.length >= 8))
          {
            i = Integer.parseInt(paramadec[6]);
            paramadec = paramadec[7];
            if ((i == 2) && (!TextUtils.isEmpty(paramadec)))
            {
              paramadec = paramadec.split(";");
              if ((paramadec == null) || (paramadec.length != 3)) {
                break label606;
              }
              localadkf.va = Float.valueOf(paramadec[0]).floatValue();
              localadkf.vb = Float.valueOf(paramadec[1]).floatValue();
              localadkf.vc = Float.valueOf(paramadec[2]).floatValue();
              localadkf.keyType = 3;
              break label606;
            }
            if ((i == 3) && (!TextUtils.isEmpty(paramadec)))
            {
              paramadec = paramadec.split(";");
              if ((paramadec == null) || (paramadec.length != 3)) {
                break label611;
              }
              localadkf.va = Float.valueOf(paramadec[0]).floatValue();
              localadkf.vb = Float.valueOf(paramadec[1]).floatValue();
              localadkf.vc = Float.valueOf(paramadec[2]).floatValue();
              localadkf.keyType = 4;
              break label611;
            }
            if ((i == 4) && (!TextUtils.isEmpty(paramadec)))
            {
              localadkf.fragmentShader = adjy.g(paramadec, "uniform int uDisplayType;\n", null, "    if(uDisplayType == 1){\n        // 需要渲染成圆形\n        float x = vTextureCoord.x;\n        float y = vTextureCoord.y;\n        // 圆心(0.5, 0.5), 0.25=0.5*0.5\n        if(pow(abs(x-0.5), 2.0) + pow(abs(y-0.5), 2.0) >= 0.25) {\n            gl_FragColor[3] = 0.0;\n        }\n    }\n");
              localadkf.keyType = 5;
            }
          }
          i = 2;
        }
        catch (Throwable paramadec)
        {
          i = k;
        }
        if (QLog.isColorLevel())
        {
          paramadec.printStackTrace();
          i = k;
        }
      }
    }
    int i = 0;
    break label603;
    label601:
    i = 0;
    for (;;)
    {
      label603:
      break;
      label606:
      i = 2;
      continue;
      label611:
      i = 2;
    }
  }
  
  public static boolean adL()
  {
    String str = Build.MODEL.toLowerCase();
    return (Build.MANUFACTURER.toLowerCase().contains("meizu")) && (str.contains("m040"));
  }
  
  public static void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      QLog.d("ARVideoUtil", 1, paramString + ": glError " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aded
 * JD-Core Version:    0.7.0.1
 */