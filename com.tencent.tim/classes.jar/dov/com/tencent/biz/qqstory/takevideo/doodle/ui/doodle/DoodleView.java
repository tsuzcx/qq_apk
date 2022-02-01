package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import ayjl;
import ayjm;
import ayju;
import aykd;
import aykf;
import ayki;
import aymk;
import aymm;
import aymp;
import ayom;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import ram;

public class DoodleView
  extends View
{
  protected ayjm a;
  protected aykd a;
  public ayki a;
  public EditVideoParams a;
  public DoodleLayout a;
  private Comparator<aykd> au = new aymm(this);
  private LinkedList<aykd> ax = new LinkedList();
  private Paint bd;
  private Bitmap cH;
  private boolean dzX;
  private Canvas g;
  protected Map<String, aykd> gh;
  public boolean isEnable = true;
  public int mBitmapHeight;
  public int mBitmapWidth;
  public int mHeight;
  private long mTimeStamp;
  public int mWidth;
  protected List<aykd> oO;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private boolean Lx()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.mBitmapWidth > 0)
    {
      bool1 = bool3;
      if (this.mBitmapHeight > 0) {
        bool1 = bool2;
      }
    }
    try
    {
      this.cH = Bitmap.createBitmap(this.mBitmapWidth, this.mBitmapHeight, Bitmap.Config.ARGB_8888);
      bool1 = bool2;
      this.g = new Canvas(this.cH);
      bool1 = true;
      bool2 = true;
      ram.d("DoodleView", "create Doodle bitmap, width:" + this.mBitmapWidth + ",height:" + this.mBitmapHeight);
      bool1 = bool2;
      return bool1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ram.e("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
    }
    return bool1;
  }
  
  private boolean Ly()
  {
    return (this.cH != null) && (!this.cH.isRecycled());
  }
  
  private void buA()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = (ayju)this.gh.get("LineLayer");
    if ((localObject != null) && (((ayju)localObject).a.Lt()) && (((ayju)localObject).a.cG == null)) {
      ((ayju)localObject).a.xu(this.cH.getWidth());
    }
    this.g.drawPaint(this.bd);
    Canvas localCanvas = new Canvas(this.cH);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()) && (localObject != null)) {
      ((ayju)localObject).ap(localCanvas);
    }
    localObject = new LinkedList(this.gh.values());
    Collections.sort((List)localObject, this.au);
    int i = ((LinkedList)localObject).size() - 1;
    while (i >= 0)
    {
      aykd localaykd = (aykd)((LinkedList)localObject).get(i);
      if (localaykd != null) {
        localaykd.ao(localCanvas);
      }
      i -= 1;
    }
    ram.d("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - l));
  }
  
  private void bux()
  {
    this.oO.add(this.jdField_a_of_type_Ayjm);
    this.jdField_a_of_type_Ayki.a.a(this.oO, this);
    Object localObject = this.oO.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aykd localaykd = (aykd)((Iterator)localObject).next();
      this.gh.put(localaykd.getTag(), localaykd);
    }
    ram.d("DoodleView", "DoodleView hold layers:" + this.gh.toString());
    this.jdField_a_of_type_Aykd = this.jdField_a_of_type_Ayjm;
    if (this.oO.size() > 1) {}
    for (localObject = (aykd)this.oO.get(1);; localObject = null)
    {
      if ((localObject != null) && ((((aykd)localObject).getWidth() != this.mWidth) || (((aykd)localObject).getHeight() != this.mHeight))) {
        onSizeChanged(this.mWidth, this.mHeight, ((aykd)localObject).getWidth(), ((aykd)localObject).getHeight());
      }
      super.requestLayout();
      return;
    }
  }
  
  private boolean du(long paramLong)
  {
    if ((this.gh == null) || (this.gh.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.gh.values().iterator();
    while (localIterator.hasNext()) {
      if (!((aykd)localIterator.next()).aN(paramLong)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean E(JSONObject paramJSONObject)
  {
    Iterator localIterator = this.oO.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if ((((aykd)localIterator.next()).E(paramJSONObject)) || (bool)) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public boolean Lw()
  {
    return this.jdField_a_of_type_Aykd == this.jdField_a_of_type_Ayjm;
  }
  
  public Bitmap U()
  {
    if (!Lx())
    {
      ram.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    buA();
    return this.cH;
  }
  
  public aykd a()
  {
    return this.jdField_a_of_type_Aykd;
  }
  
  public aykd a(MotionEvent paramMotionEvent)
  {
    LinkedList localLinkedList = new LinkedList(this.oO);
    Collections.sort(localLinkedList, this.au);
    int i = 0;
    while (i < localLinkedList.size())
    {
      aykd localaykd = (aykd)localLinkedList.get(i);
      if ((localaykd != null) && (localaykd.I(paramMotionEvent))) {
        return localaykd;
      }
      i += 1;
    }
    return this.jdField_a_of_type_Ayjm;
  }
  
  public <LAYER extends aykd> LAYER a(String paramString)
  {
    paramString = (aykd)this.gh.get(paramString);
    if (paramString == null) {
      throw new IllegalArgumentException("this layer is not exist in DoodleView.");
    }
    return paramString;
  }
  
  public void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, float paramFloat3, PointF paramPointF, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(paramBoolean1, paramFloat1, (int)paramFloat2, (int)paramFloat3, paramPointF, paramBoolean2, paramInt);
  }
  
  /* Error */
  public boolean a(Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 93
    //   5: new 95	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 336
    //   15: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_3
    //   19: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 117	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 338	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:U	()Landroid/graphics/Bitmap;
    //   32: astore 8
    //   34: aload 8
    //   36: ifnonnull +14 -> 50
    //   39: ldc 93
    //   41: ldc_w 340
    //   44: invokestatic 117	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload 4
    //   49: ireturn
    //   50: aconst_null
    //   51: astore 7
    //   53: aconst_null
    //   54: astore 5
    //   56: aconst_null
    //   57: astore 6
    //   59: new 342	java/io/File
    //   62: dup
    //   63: aload_3
    //   64: invokespecial 343	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 9
    //   69: aload 5
    //   71: astore_3
    //   72: aload 9
    //   74: invokevirtual 346	java/io/File:exists	()Z
    //   77: ifne +12 -> 89
    //   80: aload 5
    //   82: astore_3
    //   83: aload 9
    //   85: invokevirtual 349	java/io/File:createNewFile	()Z
    //   88: pop
    //   89: aload 5
    //   91: astore_3
    //   92: new 351	java/io/FileOutputStream
    //   95: dup
    //   96: aload 9
    //   98: invokespecial 354	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore 5
    //   103: aload 8
    //   105: aload_1
    //   106: iload_2
    //   107: aload 5
    //   109: invokevirtual 358	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   112: pop
    //   113: iconst_1
    //   114: istore 4
    //   116: aload 5
    //   118: ifnull -71 -> 47
    //   121: aload 5
    //   123: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   133: iconst_1
    //   134: ireturn
    //   135: astore 5
    //   137: aload 6
    //   139: astore_1
    //   140: aload_1
    //   141: astore_3
    //   142: aload 5
    //   144: invokevirtual 365	java/io/FileNotFoundException:printStackTrace	()V
    //   147: aload_1
    //   148: ifnull -101 -> 47
    //   151: aload_1
    //   152: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   162: iconst_0
    //   163: ireturn
    //   164: astore 5
    //   166: aload 7
    //   168: astore_1
    //   169: aload_1
    //   170: astore_3
    //   171: aload 5
    //   173: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull -130 -> 47
    //   180: aload_1
    //   181: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: astore_1
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   202: aload_1
    //   203: athrow
    //   204: astore_3
    //   205: aload_3
    //   206: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   209: goto -7 -> 202
    //   212: astore_1
    //   213: aload 5
    //   215: astore_3
    //   216: goto -22 -> 194
    //   219: astore_3
    //   220: aload 5
    //   222: astore_1
    //   223: aload_3
    //   224: astore 5
    //   226: goto -57 -> 169
    //   229: astore_3
    //   230: aload 5
    //   232: astore_1
    //   233: aload_3
    //   234: astore 5
    //   236: goto -96 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	DoodleView
    //   0	239	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	239	2	paramInt	int
    //   0	239	3	paramString	String
    //   1	114	4	bool	boolean
    //   54	68	5	localFileOutputStream	java.io.FileOutputStream
    //   135	8	5	localFileNotFoundException	java.io.FileNotFoundException
    //   164	57	5	localIOException	java.io.IOException
    //   224	11	5	str	String
    //   57	81	6	localObject1	Object
    //   51	116	7	localObject2	Object
    //   32	72	8	localBitmap	Bitmap
    //   67	30	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   121	126	128	java/io/IOException
    //   72	80	135	java/io/FileNotFoundException
    //   83	89	135	java/io/FileNotFoundException
    //   92	103	135	java/io/FileNotFoundException
    //   151	155	157	java/io/IOException
    //   72	80	164	java/io/IOException
    //   83	89	164	java/io/IOException
    //   92	103	164	java/io/IOException
    //   180	184	186	java/io/IOException
    //   72	80	193	finally
    //   83	89	193	finally
    //   92	103	193	finally
    //   142	147	193	finally
    //   171	176	193	finally
    //   198	202	204	java/io/IOException
    //   103	113	212	finally
    //   103	113	219	java/io/IOException
    //   103	113	229	java/io/FileNotFoundException
  }
  
  public void b(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    Object localObject = (ayju)this.gh.get("LineLayer");
    if (localObject != null)
    {
      localObject = (aymp)((ayju)localObject).a.b(103);
      if (localObject != null)
      {
        if (!paramEditVideoParams.La()) {
          break label55;
        }
        ((aymp)localObject).setMode(104);
      }
    }
    return;
    label55:
    if (((paramEditVideoParams.a instanceof EditTakeVideoSource)) || ((paramEditVideoParams.a instanceof EditLocalVideoSource)))
    {
      ((aymp)localObject).setMode(105);
      return;
    }
    ((aymp)localObject).setMode(103);
  }
  
  public void buk()
  {
    ayju localayju = (ayju)this.gh.get("LineLayer");
    if ((localayju != null) && (localayju.a.Lt()) && (this.mBitmapWidth > 0)) {
      localayju.a.xt(this.mBitmapWidth);
    }
  }
  
  public void buy()
  {
    setActiveLayer(this.jdField_a_of_type_Ayjm);
    setTopLevelLayer(this.jdField_a_of_type_Ayjm);
  }
  
  public void buz()
  {
    if (this.oO != null)
    {
      Iterator localIterator = this.oO.iterator();
      while (localIterator.hasNext()) {
        ((aykd)localIterator.next()).clear();
      }
      if (this.g != null) {
        this.g.drawPaint(this.bd);
      }
    }
    super.invalidate();
  }
  
  public int getBitmapHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getBitmapWidth()
  {
    return this.mBitmapWidth;
  }
  
  public long getTimeStamp()
  {
    return this.mTimeStamp;
  }
  
  protected void init()
  {
    this.bd = new Paint();
    this.bd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.oO = new ArrayList();
    this.gh = new LinkedHashMap();
    this.jdField_a_of_type_Ayjm = new ayjm(this);
    this.jdField_a_of_type_Aykd = this.jdField_a_of_type_Ayjm;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    invalidate();
  }
  
  public boolean isEmpty()
  {
    Iterator localIterator = this.oO.iterator();
    while (localIterator.hasNext()) {
      if (!((aykd)localIterator.next()).isEmpty()) {
        return false;
      }
    }
    return true;
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.oO.iterator();
    while (localIterator.hasNext()) {
      ((aykd)localIterator.next()).onDestroy();
    }
    recycleBitmap();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.isEnable) {}
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()))
      {
        localObject = this.gh.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          aykd localaykd = (aykd)((Map.Entry)((Iterator)localObject).next()).getValue();
          if ((localaykd instanceof ayju)) {
            ((ayju)localaykd).a.aq(paramCanvas);
          }
        }
      }
      this.ax.clear();
      this.ax.addAll(this.gh.values());
      Collections.sort(this.ax, this.au);
      int i = this.ax.size() - 1;
      while (i >= 0)
      {
        localObject = (aykd)this.ax.get(i);
        if (localObject != null) {
          ((aykd)localObject).draw(paramCanvas);
        }
        i -= 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if ((j != -2147483648) || (k == -2147483648)) {
      paramInt1 = i * 3 / 2;
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_Ayki != null)
    {
      ram.d("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_Ayki.bre + ",MaxHeight:" + this.jdField_a_of_type_Ayki.brf);
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      if (this.jdField_a_of_type_Ayki.bre == 0)
      {
        paramInt3 = this.mWidth;
        label108:
        if (this.jdField_a_of_type_Ayki.brf != 0) {
          break label227;
        }
      }
      label227:
      for (paramInt4 = this.mHeight;; paramInt4 = this.jdField_a_of_type_Ayki.brf)
      {
        float f = ayom.a(this.mWidth, this.mHeight, paramInt3, paramInt4);
        this.mBitmapWidth = ((int)(this.mWidth * f));
        this.mBitmapHeight = ((int)(this.mHeight * f));
        Iterator localIterator = this.oO.iterator();
        while (localIterator.hasNext())
        {
          aykd localaykd = (aykd)localIterator.next();
          localaykd.ae(f);
          localaykd.setSize(paramInt1, paramInt2);
        }
        break;
        paramInt3 = this.jdField_a_of_type_Ayki.bre;
        break label108;
      }
    }
    this.mBitmapWidth = 0;
    this.mBitmapHeight = 0;
    ram.e("DoodleView", "DoodleConfig is null.");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.dzX) {
      return true;
    }
    if ((this.jdField_a_of_type_Aykd == this.jdField_a_of_type_Ayjm) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_Aykd = a(paramMotionEvent);
      this.jdField_a_of_type_Aykd.tJ(true);
      this.jdField_a_of_type_Aykd.eSo();
      ram.d("DoodleView", this.jdField_a_of_type_Aykd.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_Aykd.M(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
  }
  
  public void recycleBitmap()
  {
    ram.d("DoodleView", "recycle bitmap.");
    if (Ly())
    {
      this.cH.recycle();
      this.cH = null;
      this.g = null;
    }
  }
  
  public void setActiveLayer(aykd paramaykd)
  {
    aykd localaykd = this.jdField_a_of_type_Aykd;
    this.jdField_a_of_type_Aykd = paramaykd;
    if (localaykd == this.jdField_a_of_type_Aykd) {
      return;
    }
    localaykd.onPause();
    this.jdField_a_of_type_Aykd.onResume();
  }
  
  public void setDoodleConfig(ayki paramayki)
  {
    ram.d("DoodleView", "init DoodleConfig: " + paramayki.toString());
    this.jdField_a_of_type_Ayki = paramayki;
    this.oO.clear();
    this.gh.clear();
    bux();
  }
  
  public void setDoodleLayout(DoodleLayout paramDoodleLayout)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = paramDoodleLayout;
  }
  
  public void setEnableVisible(boolean paramBoolean)
  {
    this.isEnable = paramBoolean;
  }
  
  public void setPreventTouch(boolean paramBoolean)
  {
    this.dzX = paramBoolean;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.mTimeStamp = paramLong;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (du(paramLong))
      {
        requestLayout();
        invalidate();
      }
      return;
    }
    ThreadManager.getUIHandler().post(new DoodleView.2(this, paramLong));
  }
  
  public void setTopLevelLayer(aykd paramaykd)
  {
    Iterator localIterator = this.oO.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      aykd localaykd = (aykd)localIterator.next();
      if ((localaykd.RV() <= i) || ((localaykd instanceof ayjl))) {
        break label64;
      }
      i = localaykd.RV();
    }
    label64:
    for (;;)
    {
      break;
      paramaykd.afl(i);
      return;
    }
  }
  
  public boolean un(String paramString)
  {
    return a(Bitmap.CompressFormat.PNG, 100, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */