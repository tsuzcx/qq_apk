import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class aklz
{
  public static CharSequence Y = "";
  public static CharSequence Z = "";
  public static aklz.b a;
  public static ahqt.a d;
  public static final HashMap<String, Integer> mc = new HashMap();
  
  static
  {
    mc.put("zh", Integer.valueOf(1));
    mc.put("en", Integer.valueOf(2));
    mc.put("ja", Integer.valueOf(3));
    mc.put("jp", Integer.valueOf(3));
    mc.put("ko", Integer.valueOf(4));
    mc.put("kr", Integer.valueOf(4));
    mc.put("fr", Integer.valueOf(5));
    mc.put("es", Integer.valueOf(6));
    mc.put("it", Integer.valueOf(7));
    mc.put("de", Integer.valueOf(8));
    mc.put("tr", Integer.valueOf(9));
    mc.put("ru", Integer.valueOf(10));
    mc.put("pt", Integer.valueOf(11));
    mc.put("vi", Integer.valueOf(12));
    mc.put("id", Integer.valueOf(13));
    mc.put("ms", Integer.valueOf(14));
    mc.put("th", Integer.valueOf(15));
  }
  
  public static void H(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OCRPerformUtil", 2, "forwardContent error, content is empty");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtra("isFromShare", true);
    paramString.putExtras(localBundle);
    ahgq.f(paramActivity, paramString, 21);
  }
  
  public static void I(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OCRPerformUtil", 2, "enterCropActivity error, picture path is empty");
      }
      return;
    }
    Intent localIntent = EditPicActivity.a(paramActivity, paramString, false, false, false, true, false, 2, 99, 9);
    localIntent.putExtra("babyq_ability", 2L);
    localIntent.putExtra("sub_business_id", 103);
    paramActivity.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformUtil", 2, String.format("enterCropActivity, path: %s", new Object[] { paramString }));
    }
    anot.a(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
  }
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 185	android/graphics/Matrix
    //   9: dup
    //   10: invokespecial 186	android/graphics/Matrix:<init>	()V
    //   13: astore 10
    //   15: aload 10
    //   17: fload 6
    //   19: fload 7
    //   21: invokevirtual 190	android/graphics/Matrix:postScale	(FF)Z
    //   24: pop
    //   25: iload_1
    //   26: ifge +204 -> 230
    //   29: iconst_0
    //   30: istore 8
    //   32: iload_2
    //   33: ifge +191 -> 224
    //   36: iconst_0
    //   37: istore 9
    //   39: iload 8
    //   41: iload_3
    //   42: iadd
    //   43: aload_0
    //   44: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   47: if_icmple +172 -> 219
    //   50: aload_0
    //   51: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   54: istore_1
    //   55: iload_1
    //   56: iload 8
    //   58: isub
    //   59: istore_1
    //   60: iload 9
    //   62: iload 4
    //   64: iadd
    //   65: aload_0
    //   66: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   69: if_icmple +144 -> 213
    //   72: aload_0
    //   73: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   76: istore_2
    //   77: iload_2
    //   78: iload 9
    //   80: isub
    //   81: istore_2
    //   82: aload_0
    //   83: iload 8
    //   85: iload 9
    //   87: iload_1
    //   88: iload_2
    //   89: aload 10
    //   91: iconst_0
    //   92: invokestatic 203	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   95: astore_0
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: iload_3
    //   100: istore_1
    //   101: ldc 95
    //   103: iconst_2
    //   104: new 205	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   111: ldc 208
    //   113: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: invokevirtual 216	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +68 -> 200
    //   135: ldc 95
    //   137: iconst_2
    //   138: new 205	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   145: ldc 221
    //   147: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload 8
    //   152: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc 226
    //   157: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 9
    //   162: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: ldc 228
    //   167: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: iload_1
    //   171: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc 230
    //   176: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 4
    //   181: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 232
    //   186: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 5
    //   191: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_0
    //   203: goto -102 -> 101
    //   206: astore_0
    //   207: iload_2
    //   208: istore 4
    //   210: goto -109 -> 101
    //   213: iload 4
    //   215: istore_2
    //   216: goto -134 -> 82
    //   219: iload_3
    //   220: istore_1
    //   221: goto -161 -> 60
    //   224: iload_2
    //   225: istore 9
    //   227: goto -188 -> 39
    //   230: iload_1
    //   231: istore 8
    //   233: goto -201 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramBitmap	Bitmap
    //   0	236	1	paramInt1	int
    //   0	236	2	paramInt2	int
    //   0	236	3	paramInt3	int
    //   0	236	4	paramInt4	int
    //   0	236	5	paramInt5	int
    //   0	236	6	paramFloat1	float
    //   0	236	7	paramFloat2	float
    //   30	202	8	i	int
    //   37	189	9	j	int
    //   13	77	10	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   39	55	98	java/lang/Exception
    //   60	77	202	java/lang/Exception
    //   82	96	206	java/lang/Exception
  }
  
  public static Bitmap a(String paramString, DisplayMetrics paramDisplayMetrics)
  {
    int i = paramDisplayMetrics.widthPixels;
    int j = paramDisplayMetrics.heightPixels;
    paramDisplayMetrics = new BitmapFactory.Options();
    paramDisplayMetrics.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramDisplayMetrics);
    i = calculateInSampleSize(paramDisplayMetrics, i, j);
    paramDisplayMetrics.inJustDecodeBounds = false;
    paramDisplayMetrics.inSampleSize = i;
    Bitmap localBitmap = ahqz.b(paramString, paramDisplayMetrics, 1, 4);
    paramDisplayMetrics = localBitmap;
    if (localBitmap != null)
    {
      i = aqhu.getExifOrientation(paramString);
      paramDisplayMetrics = localBitmap;
      if (i != 0)
      {
        paramDisplayMetrics = localBitmap;
        if (i % 90 == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OCRPerformUtil", 2, "decodeBitmapForOcr rotate:" + i);
          }
          j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramDisplayMetrics = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
    }
    return paramDisplayMetrics;
  }
  
  public static URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView, Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    if (paramURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static CharSequence a(ArrayList<ahqx> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 1;
    if (paramArrayList.hasNext())
    {
      ahqx localahqx = (ahqx)paramArrayList.next();
      if (localahqx.daM == i) {
        localStringBuilder.append(localahqx.text.trim());
      }
      for (;;)
      {
        break;
        localStringBuilder.append("\n\n").append(localahqx.text.trim());
        i = localahqx.daM;
      }
    }
    return new aofk(localStringBuilder.toString(), 8, 16);
  }
  
  public static String a(TextView paramTextView)
  {
    String str1 = null;
    if (paramTextView == null) {
      paramTextView = str1;
    }
    do
    {
      int i;
      int j;
      String str2;
      do
      {
        do
        {
          do
          {
            do
            {
              return paramTextView;
              i = paramTextView.getSelectionStart();
              j = paramTextView.getSelectionEnd();
              str2 = paramTextView.getText().toString();
              paramTextView = str1;
            } while (TextUtils.isEmpty(str2));
            paramTextView = str1;
          } while (i >= j);
          paramTextView = str1;
        } while (i < 0);
        paramTextView = str1;
      } while (j > str2.length());
      str1 = str2.substring(i, j);
      paramTextView = str1;
    } while (!QLog.isColorLevel());
    QLog.d("OCRPerformUtil", 2, "collectSelectedText " + str1);
    return str1;
  }
  
  public static void a(akoq paramakoq, int paramInt, Bitmap paramBitmap)
  {
    paramBitmap = new StackBlurManager(paramBitmap);
    paramBitmap.setDbg(false);
    paramakoq.fB = paramBitmap.process(paramInt);
  }
  
  public static List<String> aE(String paramString)
  {
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  public static void b(String paramString, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    if (a == null) {
      a = new aklz.b();
    }
    Object localObject = a;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
      ((aklz.b)localObject).bTK = paramString;
      if ((paramList == null) || (paramList.isEmpty())) {
        break label160;
      }
      if (a.Eb != null) {
        break label146;
      }
      a.Eb = new ArrayList();
    }
    for (;;)
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localObject = mx(paramList);
        if ((!TextUtils.isEmpty(paramList)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          a.Eb.add(paramList.toLowerCase());
        }
      }
      paramString = paramString.toLowerCase();
      break;
      label146:
      a.Eb.clear();
    }
    label160:
    a.md = paramHashMap;
    a.bTL = a.bTK;
    a.Ed = aE(a.bTL);
    a.bTM = ((String)a.Ed.get(0));
    a.Ec = aE(a.bTM);
    paramString = "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".trim().split("/");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramList = paramString[i];
      if (!a.h(a.Ec, paramList)) {
        a.Ec.add(paramList);
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformUtil", 2, "recordOcrLanInfo:ocrLanHolder:" + a.tc());
    }
  }
  
  public static boolean c(Bitmap paramBitmap)
  {
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    long l4 = 0L;
    int j = paramBitmap.getHeight() / 20;
    int i = j;
    if (j <= 0) {
      i = 5;
    }
    int k = paramBitmap.getWidth() / 20;
    j = k;
    if (k <= 0) {
      j = 5;
    }
    k = 0;
    while (k < paramBitmap.getHeight())
    {
      int m = 0;
      while (m < paramBitmap.getWidth())
      {
        int n = paramBitmap.getPixel(m, k);
        l4 += 1L;
        l3 += Color.red(n);
        l2 += Color.green(n);
        l1 += Color.blue(n);
        m += j;
      }
      k += i;
    }
    float f1 = (float)(l3 / l4);
    float f2 = (float)(l2 / l4);
    float f3 = (float)(l1 / l4);
    double d1 = f1;
    return f2 * 0.578D + d1 * 0.299D + f3 * 0.114D < 90.0D;
  }
  
  public static void cN(String paramString, int paramInt)
  {
    report(paramString, paramString, paramInt);
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    paramInt2 = paramOptions.outWidth;
    int i = 1;
    if (paramInt2 > paramInt1 * 1.2F)
    {
      i = j / 2;
      j = paramInt2 / 2;
      paramInt2 = 2;
      for (;;)
      {
        i = paramInt2;
        if (j / paramInt2 <= paramInt1) {
          break;
        }
        paramInt2 *= 2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("OCRPerformUtil", 2, "calculateInSampleSize:" + i);
    }
    return i;
  }
  
  public static int dD(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ((Integer)mc.get(paramString.trim().toLowerCase())).intValue();
    }
    return 0;
  }
  
  public static String mx(String paramString)
  {
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  public static void n(CharSequence paramCharSequence)
  {
    Y = paramCharSequence;
  }
  
  public static CharSequence o()
  {
    return Y;
  }
  
  public static void o(CharSequence paramCharSequence)
  {
    Z = paramCharSequence;
  }
  
  public static CharSequence p()
  {
    return Z;
  }
  
  public static void releaseCache()
  {
    if (d != null) {
      d = null;
    }
    if (a != null) {
      a = null;
    }
    if (Y != null) {
      Y = null;
    }
    if (Z != null) {
      Z = null;
    }
  }
  
  public static void report(String paramString1, String paramString2, int paramInt)
  {
    anot.a(null, "dc00898", "", "", paramString1, paramString2, paramInt, 0, "", "0", "0", "");
  }
  
  public static abstract interface a
  {
    public abstract void lJ(List<akoq> paramList);
  }
  
  public static class b
  {
    public List<String> Eb;
    public List<String> Ec;
    public List<String> Ed;
    public String bTK = "";
    public String bTL = "";
    public String bTM = "";
    public HashMap<String, String> md;
    
    public void Ny(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.bTL = paramString;
        this.Ed = aklz.aE(this.bTL);
        this.bTM = ((String)this.Ed.get(0));
      }
    }
    
    public void Nz(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.bTM = paramString;
      }
    }
    
    public Pair<String, String> f(String paramString)
    {
      Iterator localIterator = this.md.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((String)localEntry.getKey()).equalsIgnoreCase(paramString)) {
          return new Pair(localEntry.getKey(), localEntry.getValue());
        }
      }
      return null;
    }
    
    public boolean h(List<String> paramList, String paramString)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (((String)paramList.next()).trim().equalsIgnoreCase(paramString)) {
          return true;
        }
      }
      return false;
    }
    
    public String my(String paramString)
    {
      return OcrConfig.getDefaultLanguageName(paramString);
    }
    
    public String mz(String paramString)
    {
      if (paramString.equalsIgnoreCase("zh")) {
        return "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".trim().split("/")[0];
      }
      return "zh";
    }
    
    public String tc()
    {
      String str1 = "ocrLan:" + this.bTK + ", ocrLanOptions:" + this.Eb.toString();
      String str2 = "srcLan:" + this.bTL + ", srcLanOptions:" + this.Ec.toString();
      String str3 = "dstLan:" + this.bTM + ", dstLanOptions:" + this.Ed.toString();
      return str1 + "\n" + str2 + "\n" + str3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklz
 * JD-Core Version:    0.7.0.1
 */