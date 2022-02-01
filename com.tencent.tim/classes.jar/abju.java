import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class abju
{
  public static void a(int paramInt1, int paramInt2, abjw paramabjw, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(null, paramInt1, paramInt2, paramabjw, paramContext, paramString1, paramString2, paramBoolean);
  }
  
  public static void a(abjw paramabjw, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramabjw != null) {
      a(paramabjw.zA(), paramabjw.zB(), paramabjw, paramContext, paramString1, paramString2, paramBoolean);
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, abjw paramabjw, Context paramContext, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramabjw == null) || (paramContext == null) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (paramString3.length() > 12) {
      paramString3 = paramString3.substring(0, 11) + "...";
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 == 0) {
        i = paramabjw.zA();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = paramabjw.zB();
      }
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      abjv localabjv1 = new abjv(paramabjw.a(), aqgz.getDesity(), i, paramInt1, paramString2, paramString3);
      float f1 = i;
      localabjv1.mStartX = f1;
      localabjv1.jU = f1;
      localabjv1.mStartY = 0.0F;
      localabjv1.ek = 0.0F;
      localabjv1.jV = (-i / 4000.0F);
      localabjv1.jW = 0.0F;
      localabjv1.mScale = 1.0F;
      localabjv1.mTextSize = (17.0F * paramContext.getResources().getDisplayMetrics().scaledDensity);
      localabjv1.bDt = true;
      localabjv1.mUin = paramString1;
      Random localRandom = new Random();
      paramInt2 = 0;
      while (paramInt2 < 5)
      {
        abjv localabjv2 = new abjv(paramabjw.a(), aqgz.getDesity(), i, paramInt1, paramString2, paramString3);
        localabjv2.jV = (-i / (3000.0F - paramInt2 * 500));
        localabjv2.jW = 0.0F;
        int j = localRandom.nextInt(3);
        localabjv2.mAlpha = ((int)(new float[] { 0.6F, 0.8F, 1.0F }[j] * 255.0F));
        localabjv2.mTextSize = (new int[] { 14, 14, 12, 12, 12 }[paramInt2] * paramContext.getResources().getDisplayMetrics().scaledDensity);
        localabjv2.mScale = abjr.a(localabjv1, localabjv2);
        f1 = i * localRandom.nextFloat() + i / 2;
        localabjv2.mStartX = f1;
        localabjv2.jU = f1;
        f1 = paramInt1;
        float f2 = abjr.x(localabjv2.mTextSize);
        float f3 = localabjv2.mTopPadding * 2;
        f1 = (paramInt1 - (f1 * 0.28F + f2 + f3)) * localRandom.nextFloat();
        localabjv2.mStartY = f1;
        localabjv2.ek = f1;
        localabjv2.bDt = true;
        localabjv2.mUin = paramString1;
        localArrayList.add(localabjv2);
        paramInt2 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBarrageUtil", 2, "bulkApolloBarrages use:" + (System.currentTimeMillis() - l));
      }
      localArrayList.add(localabjv1);
      paramabjw.af(localArrayList, paramBoolean);
      return;
    }
  }
  
  public static int d(Paint paramPaint)
  {
    return (int)(1.0F + paramPaint.measureText(acfp.m(2131702446)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abju
 * JD-Core Version:    0.7.0.1
 */