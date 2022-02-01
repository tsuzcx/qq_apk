import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer.2;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer.3;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import mqq.os.MqqHandler;

public class ahxp
{
  public Vector<String> E = new Vector();
  public ahxo.a a;
  public ahxq a;
  public AtomicBoolean cX = new AtomicBoolean(false);
  public AtomicBoolean cY = new AtomicBoolean(false);
  public AtomicBoolean cZ = new AtomicBoolean(false);
  public int dbM = -1;
  public Typeface k;
  public int mFontId;
  Paint mPaint;
  public int mType;
  public ArrayList<WeakReference<HiBoomTextView>> xh;
  
  ahxp(int paramInt, @Nonnull ahxo.a parama)
  {
    this.mFontId = paramInt;
    this.jdField_a_of_type_Ahxo$a = parama;
    KE(true);
  }
  
  /* Error */
  public static Bitmap D(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 68	java/io/BufferedInputStream
    //   5: dup
    //   6: new 70	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 76	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: invokestatic 82	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_0
    //   27: aload_1
    //   28: ifnull +9 -> 37
    //   31: aload_1
    //   32: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   35: aload_2
    //   36: astore_0
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: ldc 87
    //   42: iconst_1
    //   43: ldc 89
    //   45: aload_0
    //   46: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   49: aload_2
    //   50: areturn
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: astore_0
    //   56: ldc 87
    //   58: iconst_1
    //   59: ldc 89
    //   61: aload_2
    //   62: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_3
    //   66: astore_0
    //   67: aload_1
    //   68: ifnull -31 -> 37
    //   71: aload_1
    //   72: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: ldc 87
    //   80: iconst_1
    //   81: ldc 89
    //   83: aload_0
    //   84: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: astore_0
    //   94: ldc 87
    //   96: iconst_1
    //   97: ldc 89
    //   99: aload_2
    //   100: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_3
    //   104: astore_0
    //   105: aload_1
    //   106: ifnull -69 -> 37
    //   109: aload_1
    //   110: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: ldc 87
    //   118: iconst_1
    //   119: ldc 89
    //   121: aload_0
    //   122: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_0
    //   141: ldc 87
    //   143: iconst_1
    //   144: ldc 89
    //   146: aload_0
    //   147: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: goto -12 -> 138
    //   153: astore_1
    //   154: goto -24 -> 130
    //   157: astore_2
    //   158: goto -66 -> 92
    //   161: astore_2
    //   162: goto -108 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramString	String
    //   17	93	1	localBufferedInputStream	java.io.BufferedInputStream
    //   127	12	1	localObject1	Object
    //   153	1	1	localObject2	Object
    //   24	26	2	localBitmap	Bitmap
    //   51	11	2	localException1	Exception
    //   89	11	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   157	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   161	1	2	localException2	Exception
    //   1	103	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	35	39	java/io/IOException
    //   2	18	51	java/lang/Exception
    //   71	75	77	java/io/IOException
    //   2	18	89	java/lang/OutOfMemoryError
    //   109	113	115	java/io/IOException
    //   2	18	127	finally
    //   134	138	140	java/io/IOException
    //   20	25	153	finally
    //   56	65	153	finally
    //   94	103	153	finally
    //   20	25	157	java/lang/OutOfMemoryError
    //   20	25	161	java/lang/Exception
  }
  
  private void a(Canvas paramCanvas, String paramString, int paramInt1, int paramInt2, ahxq.a parama, ahxq.c paramc, float paramFloat)
  {
    int i;
    Paint localPaint;
    Bitmap localBitmap;
    Canvas localCanvas;
    Object localObject2;
    Object localObject1;
    if (paramInt1 > paramInt2)
    {
      i = paramInt1;
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localPaint.setTextSize(i);
      localPaint.setColor(-16777216);
      if (this.k != null) {
        localPaint.setTypeface(this.k);
      }
      localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localObject2 = null;
      localObject1 = paramc.lB;
      if ((localObject1 != null) && (localObject1[3] != 0)) {
        break label972;
      }
      if (!TextUtils.isEmpty(paramc.bMk)) {
        break label872;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(parama.bMh))
      {
        if ((!parama.bMh.startsWith("#")) || (parama.bMh.length() != 9)) {
          break label818;
        }
        localPaint.setColor(Color.parseColor(parama.bMh));
        localObject1 = localObject2;
      }
      label182:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1301;
      }
      localPaint.setColor(-16777216);
      localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject1);
      parama = (ahxq.a)localObject1;
      if (localObject1 != null)
      {
        if (((Bitmap)localObject1).getWidth() == i)
        {
          parama = (ahxq.a)localObject1;
          if (((Bitmap)localObject1).getHeight() == i) {}
        }
        else
        {
          parama = new Matrix();
          parama.setScale(i / ((Bitmap)localObject1).getWidth(), i / ((Bitmap)localObject1).getHeight());
          parama = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), parama, false);
        }
        localPaint.setShader(new BitmapShader(parama, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
      }
    }
    for (;;)
    {
      localCanvas.drawColor(Color.parseColor(paramc.bMl));
      localCanvas.drawText(paramString, 0.0F, (int)(i / 2.0F - (localPaint.descent() + localPaint.ascent()) / 2.0F), localPaint);
      localCanvas.save();
      if (parama != null) {
        parama.recycle();
      }
      if (paramc.dbQ > 0)
      {
        parama = null;
        if (!TextUtils.isEmpty(paramc.bMm))
        {
          localPaint.setShader(null);
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setStrokeJoin(Paint.Join.ROUND);
          localPaint.setStrokeCap(Paint.Cap.ROUND);
          localPaint.setStrokeWidth(paramc.dbQ * paramFloat);
          if ((!paramc.bMm.startsWith("#")) || (paramc.bMm.length() != 9)) {
            break label1241;
          }
          localPaint.setColor(Color.parseColor(paramc.bMm));
          label485:
          if (TextUtils.isEmpty(parama)) {
            break label1295;
          }
          localPaint.setColor(-16777216);
          localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(parama);
          parama = (ahxq.a)localObject1;
          if (localObject1 != null)
          {
            if (((Bitmap)localObject1).getWidth() == i)
            {
              parama = (ahxq.a)localObject1;
              if (((Bitmap)localObject1).getHeight() == i) {}
            }
            else
            {
              parama = new Matrix();
              parama.setScale(i / ((Bitmap)localObject1).getWidth(), i / ((Bitmap)localObject1).getHeight());
              parama = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), parama, false);
            }
            localPaint.setShader(new BitmapShader(parama, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
          }
        }
      }
      for (;;)
      {
        localCanvas.drawText(paramString, 0.0F, (int)(i / 2.0F - (localPaint.descent() + localPaint.ascent()) / 2.0F), localPaint);
        localCanvas.save();
        if (parama != null) {
          parama.recycle();
        }
        paramString = new Matrix();
        if ((localBitmap.getWidth() != paramInt1) || (localBitmap.getHeight() != paramInt2)) {
          paramString.postScale(paramInt1 / localBitmap.getWidth(), paramInt2 / localBitmap.getHeight());
        }
        paramString.postTranslate(paramc.lC[0] * paramFloat - paramInt1 / 2, paramc.lC[1] * paramFloat - paramInt2 / 2);
        paramString.postRotate(paramc.dbP, paramc.lC[0] * paramFloat, paramc.lC[1] * paramFloat);
        paramCanvas.drawBitmap(localBitmap, paramString, localPaint);
        paramCanvas.save();
        localBitmap.recycle();
        return;
        i = paramInt2;
        break;
        label818:
        localObject1 = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + parama.bMh;
        break label182;
        label872:
        if ((paramc.bMk.startsWith("#")) && (paramc.bMk.length() == 9))
        {
          localPaint.setColor(Color.parseColor(paramc.bMk));
          localObject1 = localObject2;
          break label182;
        }
        localObject1 = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + paramc.bMk;
        break label182;
        label972:
        parama = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + paramc.bMk;
        parama = (Bitmap)BaseApplicationImpl.sImageCache.get(parama);
        if (parama == null) {
          break label1301;
        }
        int m = parama.getWidth();
        int j = parama.getHeight();
        double d;
        if (localObject1[3] == -1)
        {
          m = (int)(Math.random() * (m - paramInt1));
          d = Math.random();
        }
        for (localObject1 = Bitmap.createBitmap(parama, m, (int)((j - paramInt2) * d), paramInt1, paramInt2);; localObject1 = Bitmap.createBitmap(parama, localObject1[0], localObject1[1], localObject1[2], localObject1[3]))
        {
          parama = (ahxq.a)localObject1;
          if (localObject1 == null) {
            break;
          }
          if (((Bitmap)localObject1).getWidth() == i)
          {
            parama = (ahxq.a)localObject1;
            if (((Bitmap)localObject1).getHeight() == i) {}
          }
          else
          {
            parama = new Matrix();
            parama.setScale(i / ((Bitmap)localObject1).getWidth(), i / ((Bitmap)localObject1).getHeight());
            parama = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), parama, false);
          }
          localPaint.setShader(new BitmapShader(parama, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
          break;
        }
        label1241:
        parama = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + paramc.bMm;
        break label485;
        label1295:
        parama = null;
      }
      label1301:
      parama = null;
    }
  }
  
  private void b(Canvas paramCanvas, String paramString, int paramInt1, int paramInt2, ahxq.a parama, ahxq.c paramc, float paramFloat)
  {
    Paint localPaint;
    float f1;
    float f2;
    if (paramInt1 > paramInt2)
    {
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localPaint.setTextSize(paramInt1);
      f1 = paramc.lC[0] * paramFloat;
      f2 = paramc.lC[1] * paramFloat;
      localPaint.setColor(Color.parseColor(paramc.bMl));
      paramCanvas.drawRect(f1 - paramInt1 / 2, f2 - paramInt1 / 2, f1 + paramInt1 / 2, f2 + paramInt1 / 2, localPaint);
      paramCanvas.save();
      if (this.k != null) {
        localPaint.setTypeface(this.k);
      }
      if (!TextUtils.isEmpty(paramc.bMk)) {
        break label396;
      }
      if ((!TextUtils.isEmpty(parama.bMh)) && (parama.bMh.startsWith("#")) && (parama.bMh.length() == 9)) {
        localPaint.setColor(Color.parseColor(parama.bMh));
      }
    }
    for (;;)
    {
      paramCanvas.drawText(paramString, f1 - paramInt1 / 2, paramInt1 / 2.0F - (localPaint.descent() + localPaint.ascent()) / 2.0F - paramInt1 / 2 + f2, localPaint);
      paramCanvas.save();
      if ((paramc.dbQ > 0) && (!TextUtils.isEmpty(paramc.bMm)))
      {
        localPaint.setShader(null);
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setStrokeJoin(Paint.Join.ROUND);
        localPaint.setStrokeCap(Paint.Cap.ROUND);
        localPaint.setStrokeWidth(paramc.dbQ * paramFloat);
        if ((paramc.bMm.startsWith("#")) && (paramc.bMm.length() == 9)) {
          localPaint.setColor(Color.parseColor(paramc.bMm));
        }
        paramCanvas.drawText(paramString, f1 - paramInt1 / 2, paramInt1 / 2.0F - (localPaint.descent() + localPaint.ascent()) / 2.0F - paramInt1 / 2 + f2, localPaint);
        paramCanvas.save();
      }
      return;
      paramInt1 = paramInt2;
      break;
      label396:
      if ((paramc.bMk.startsWith("#")) && (paramc.bMk.length() == 9)) {
        localPaint.setColor(Color.parseColor(paramc.bMk));
      }
    }
  }
  
  private void dqK()
  {
    ThreadManager.getUIHandler().post(new HiBoomFontDrawer.3(this));
  }
  
  private void lb(List<String> paramList)
  {
    ThreadManager.post(new HiBoomFontDrawer.2(this, paramList), 8, null, true);
  }
  
  private boolean mS(String paramString)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("#")))
    {
      paramString = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + paramString;
      i = 0;
      if (i >= this.E.size()) {
        break label99;
      }
      if (!paramString.equals(this.E.get(i))) {
        break label92;
      }
    }
    label92:
    label99:
    while (BaseApplicationImpl.sImageCache.get(paramString) != null)
    {
      return false;
      i += 1;
      break;
    }
    return true;
  }
  
  public int B(boolean paramBoolean)
  {
    Object localObject = new File(this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = 0;
        while (i < localObject.length)
        {
          if (localObject[i].endsWith(".hy")) {
            return 1;
          }
          if (localObject[i].endsWith(".fz")) {
            return 2;
          }
          if (localObject[i].endsWith(".hy3")) {
            return 3;
          }
          if (localObject[i].endsWith(".fz4")) {
            return 4;
          }
          i += 1;
        }
      }
    }
    if (paramBoolean)
    {
      this.cZ.set(false);
      this.jdField_a_of_type_Ahxo$a.Pw(this.mFontId);
    }
    return -1;
  }
  
  public void KE(boolean paramBoolean)
  {
    if (this.cY.get()) {
      return;
    }
    this.cY.set(true);
    ThreadManager.getFileThreadHandler().post(new HiBoomFontDrawer.1(this, paramBoolean));
  }
  
  public void a(HiBoomTextView paramHiBoomTextView)
  {
    if (this.xh == null) {
      this.xh = new ArrayList();
    }
    this.xh.add(new WeakReference(paramHiBoomTextView));
  }
  
  public void a(String paramString, int paramInt, Canvas paramCanvas)
    throws Exception
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new Exception("text is null!");
    }
    if (this.jdField_a_of_type_Ahxq == null) {
      throw new Exception("please init font first!");
    }
    Object localObject2 = null;
    int i = paramString.length();
    Object localObject3 = this.jdField_a_of_type_Ahxq.Cl.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject1 = (ahxq.a)((Iterator)localObject3).next();
    } while (((ahxq.a)localObject1).cMZ != i);
    if (localObject1 == null) {
      throw new Exception("hiboomStyle error!");
    }
    int j;
    label241:
    float f1;
    if (localObject1.lx[0] >= localObject1.lx[1])
    {
      j = localObject1.lx[1] * paramInt / localObject1.lx[0];
      i = paramInt;
      if (this.mPaint == null)
      {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setFilterBitmap(true);
      }
      if (!TextUtils.isEmpty(((ahxq.a)localObject1).bMg))
      {
        if ((!((ahxq.a)localObject1).bMg.startsWith("#")) || (((ahxq.a)localObject1).bMg.length() != 9)) {
          break label553;
        }
        paramCanvas.drawColor(Color.parseColor(((ahxq.a)localObject1).bMg));
      }
      f1 = i / localObject1.lx[0];
      paramInt = 0;
      label257:
      if (paramInt >= ((ahxq.a)localObject1).words.size()) {
        break label737;
      }
      localObject2 = (ahxq.c)((ahxq.a)localObject1).words.get(paramInt);
      i = (int)(localObject2.lA[0] * f1);
      j = (int)(localObject2.lA[1] * f1);
      if ((localObject2.lA[0] != localObject2.lA[1]) || (((!TextUtils.isEmpty(((ahxq.c)localObject2).bMk)) || (TextUtils.isEmpty(((ahxq.a)localObject1).bMh)) || (!((ahxq.a)localObject1).bMh.startsWith("#")) || (((ahxq.a)localObject1).bMh.length() != 9)) && ((TextUtils.isEmpty(((ahxq.c)localObject2).bMk)) || (!((ahxq.c)localObject2).bMk.startsWith("#")) || (((ahxq.c)localObject2).bMk.length() != 9) || ((((ahxq.c)localObject2).dbQ > 0) && ((((ahxq.c)localObject2).dbQ <= 0) || (TextUtils.isEmpty(((ahxq.c)localObject2).bMm)) || (!((ahxq.c)localObject2).bMm.startsWith("#")) || (((ahxq.c)localObject2).bMm.length() != 9))) || (((ahxq.c)localObject2).dbP != 0)))) {
        break label691;
      }
      b(paramCanvas, paramString.charAt(((ahxq.c)localObject2).dbO) + "", i, j, (ahxq.a)localObject1, (ahxq.c)localObject2, f1);
    }
    for (;;)
    {
      paramInt += 1;
      break label257;
      i = localObject1.lx[0] * paramInt / localObject1.lx[1];
      j = paramInt;
      break;
      label553:
      localObject2 = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + ((ahxq.a)localObject1).bMg;
      localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject2);
      if (localObject2 == null) {
        break label241;
      }
      localObject3 = new Matrix();
      if ((((Bitmap)localObject2).getWidth() != i) || (((Bitmap)localObject2).getHeight() != j)) {
        ((Matrix)localObject3).setScale(i / ((Bitmap)localObject2).getWidth(), j / ((Bitmap)localObject2).getHeight());
      }
      paramCanvas.drawBitmap((Bitmap)localObject2, (Matrix)localObject3, this.mPaint);
      break label241;
      label691:
      a(paramCanvas, paramString.charAt(((ahxq.c)localObject2).dbO) + "", i, j, (ahxq.a)localObject1, (ahxq.c)localObject2, f1);
    }
    label737:
    if (((ahxq.a)localObject1).Cm != null)
    {
      paramString = ((ahxq.a)localObject1).Cm.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (ahxq.b)paramString.next();
        if (!TextUtils.isEmpty(((ahxq.b)localObject1).bMi))
        {
          localObject2 = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + ((ahxq.b)localObject1).bMi;
          localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject2);
          localObject3 = new Matrix();
          float f2 = localObject1.ly[0] * f1;
          float f3 = localObject1.ly[1] * f1;
          if (localObject2 != null)
          {
            if ((((Bitmap)localObject2).getWidth() != f2) || (((Bitmap)localObject2).getHeight() != f3)) {
              ((Matrix)localObject3).postScale(f2 / ((Bitmap)localObject2).getWidth(), f3 / ((Bitmap)localObject2).getHeight());
            }
            ((Matrix)localObject3).postTranslate(localObject1.lz[0] * f1 - f2 / 2.0F, localObject1.lz[1] * f1 - f3 / 2.0F);
            ((Matrix)localObject3).postRotate(((ahxq.b)localObject1).dbN, localObject1.lz[0] * f1, localObject1.lz[1] * f1);
            paramCanvas.drawBitmap((Bitmap)localObject2, (Matrix)localObject3, this.mPaint);
            paramCanvas.save();
          }
        }
      }
    }
  }
  
  public void dqJ()
  {
    this.cZ.set(true);
    dqK();
  }
  
  public boolean jY(int paramInt)
  {
    ArrayList localArrayList = null;
    for (;;)
    {
      Object localObject3;
      boolean bool;
      try
      {
        localObject3 = this.jdField_a_of_type_Ahxq.Cl.iterator();
        Object localObject1 = localArrayList;
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = (ahxq.a)((Iterator)localObject3).next();
          int i = ((ahxq.a)localObject1).cMZ;
          if (i != paramInt) {
            continue;
          }
        }
        if (localObject1 == null)
        {
          bool = false;
          return bool;
        }
        localArrayList = new ArrayList();
        if (mS(((ahxq.a)localObject1).bMg)) {
          localArrayList.add(this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + ((ahxq.a)localObject1).bMg);
        }
        if (mS(((ahxq.a)localObject1).bMh)) {
          localArrayList.add(this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + ((ahxq.a)localObject1).bMh);
        }
        localObject3 = ((ahxq.a)localObject1).Cm.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          ahxq.b localb = (ahxq.b)((Iterator)localObject3).next();
          if (!mS(localb.bMi)) {
            continue;
          }
          localArrayList.add(this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + localb.bMi);
          continue;
        }
        localIterator = localObject2.words.iterator();
      }
      finally {}
      Iterator localIterator;
      while (localIterator.hasNext())
      {
        localObject3 = (ahxq.c)localIterator.next();
        if (mS(((ahxq.c)localObject3).bMl)) {
          localArrayList.add(this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + ((ahxq.c)localObject3).bMl);
        }
        if (mS(((ahxq.c)localObject3).bMk)) {
          localArrayList.add(this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + ((ahxq.c)localObject3).bMk);
        }
        if (mS(((ahxq.c)localObject3).bMm)) {
          localArrayList.add(this.jdField_a_of_type_Ahxo$a.getFontPath() + this.mFontId + File.separator + "images/" + ((ahxq.c)localObject3).bMm);
        }
      }
      if (localArrayList.size() == 0)
      {
        bool = true;
      }
      else
      {
        lb(localArrayList);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxp
 * JD-Core Version:    0.7.0.1
 */