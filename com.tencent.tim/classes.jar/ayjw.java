import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.TextParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(14)
public class ayjw
  extends aykd
{
  public static final int DEFAULT_TEXT_COLOR;
  public static int PADDING;
  public static final String TAG = ayjw.class.getSimpleName();
  public static final int bqW;
  public static int bqX;
  public static int bqY;
  private static String cWP = "TextLayer";
  public static volatile int eKo;
  axug a;
  public ayjw.a a;
  public ayjw.c a;
  public ayoo a;
  PointF am = new PointF();
  public int atp;
  ayjw.c b;
  private Paint bd;
  public int bqZ;
  public int bra = bqW;
  public int brb;
  public Paint di;
  public int eKp;
  public int mItemHeight;
  public ArrayList<ayjw.c> mItems = new ArrayList();
  public int mMode;
  public int mScreenWidth;
  public int mStartY;
  
  static
  {
    DEFAULT_TEXT_COLOR = aytl.ek[1];
    bqW = Color.parseColor("#80000000");
    bqY = 270;
    eKo = 5;
  }
  
  public ayjw(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Axug = new axug();
    init();
  }
  
  public static void Zw(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        eKo -= 1;
        eKo = Math.min(eKo, 5);
        eKo = Math.max(eKo, 4);
        return;
      }
      finally {}
      eKo += 1;
    }
  }
  
  /* Error */
  private String a(String paramString, ayjw.c paramc)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 140	ayjw:getWidth	()I
    //   19: aload_0
    //   20: invokevirtual 143	ayjw:getHeight	()I
    //   23: getstatic 149	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: invokestatic 155	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   29: astore 4
    //   31: aload 4
    //   33: astore 5
    //   35: new 157	android/graphics/Canvas
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 160	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   44: astore 6
    //   46: aload 4
    //   48: astore 5
    //   50: aload 6
    //   52: aload_0
    //   53: getfield 162	ayjw:jdField_a_of_type_Ayoo	Layoo;
    //   56: aload_2
    //   57: invokevirtual 167	ayoo:a	(Layoo$a;)Landroid/graphics/Matrix;
    //   60: invokevirtual 171	android/graphics/Canvas:concat	(Landroid/graphics/Matrix;)V
    //   63: aload 4
    //   65: astore 5
    //   67: aload_2
    //   68: getfield 174	ayjw$c:c	Ldov/com/qq/im/capture/text/DynamicTextItem;
    //   71: aload 6
    //   73: invokevirtual 180	dov/com/qq/im/capture/text/DynamicTextItem:draw	(Landroid/graphics/Canvas;)V
    //   76: aload 4
    //   78: astore 5
    //   80: aload_1
    //   81: ldc 182
    //   83: invokestatic 186	ayjw:cC	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_1
    //   87: aload 4
    //   89: astore 5
    //   91: aload_0
    //   92: aload 4
    //   94: getstatic 192	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: bipush 100
    //   99: aload_1
    //   100: invokevirtual 195	ayjw:b	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   103: istore_3
    //   104: aload 4
    //   106: astore 5
    //   108: getstatic 57	ayjw:TAG	Ljava/lang/String;
    //   111: new 197	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   118: ldc 200
    //   120: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_2
    //   124: getfield 208	ayjw$c:width	F
    //   127: invokevirtual 211	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   130: ldc 213
    //   132: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_2
    //   136: getfield 208	ayjw$c:width	F
    //   139: invokevirtual 211	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   142: ldc 215
    //   144: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_1
    //   148: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 224	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: iload_3
    //   158: ifne +23 -> 181
    //   161: aload 4
    //   163: ifnull +16 -> 179
    //   166: aload 4
    //   168: invokevirtual 228	android/graphics/Bitmap:isRecycled	()Z
    //   171: ifne +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 231	android/graphics/Bitmap:recycle	()V
    //   179: aconst_null
    //   180: areturn
    //   181: aload_1
    //   182: astore_2
    //   183: aload 4
    //   185: ifnull -172 -> 13
    //   188: aload_1
    //   189: astore_2
    //   190: aload 4
    //   192: invokevirtual 228	android/graphics/Bitmap:isRecycled	()Z
    //   195: ifne -182 -> 13
    //   198: aload 4
    //   200: invokevirtual 231	android/graphics/Bitmap:recycle	()V
    //   203: aload_1
    //   204: areturn
    //   205: astore_2
    //   206: aconst_null
    //   207: astore 4
    //   209: aconst_null
    //   210: astore_1
    //   211: aload 4
    //   213: astore 5
    //   215: getstatic 57	ayjw:TAG	Ljava/lang/String;
    //   218: ldc 233
    //   220: aload_2
    //   221: invokestatic 237	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload_1
    //   225: astore_2
    //   226: aload 4
    //   228: ifnull -215 -> 13
    //   231: aload_1
    //   232: astore_2
    //   233: aload 4
    //   235: invokevirtual 228	android/graphics/Bitmap:isRecycled	()Z
    //   238: ifne -225 -> 13
    //   241: aload 4
    //   243: invokevirtual 231	android/graphics/Bitmap:recycle	()V
    //   246: aload_1
    //   247: areturn
    //   248: astore_1
    //   249: aconst_null
    //   250: astore 5
    //   252: aload 5
    //   254: ifnull +16 -> 270
    //   257: aload 5
    //   259: invokevirtual 228	android/graphics/Bitmap:isRecycled	()Z
    //   262: ifne +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 231	android/graphics/Bitmap:recycle	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore_1
    //   273: goto -21 -> 252
    //   276: astore_2
    //   277: aconst_null
    //   278: astore_1
    //   279: goto -68 -> 211
    //   282: astore_2
    //   283: goto -72 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	ayjw
    //   0	286	1	paramString	String
    //   0	286	2	paramc	ayjw.c
    //   103	55	3	bool	boolean
    //   29	213	4	localBitmap1	android.graphics.Bitmap
    //   33	233	5	localBitmap2	android.graphics.Bitmap
    //   44	28	6	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   15	31	205	java/lang/OutOfMemoryError
    //   15	31	248	finally
    //   35	46	272	finally
    //   50	63	272	finally
    //   67	76	272	finally
    //   80	87	272	finally
    //   91	104	272	finally
    //   108	157	272	finally
    //   215	224	272	finally
    //   35	46	276	java/lang/OutOfMemoryError
    //   50	63	276	java/lang/OutOfMemoryError
    //   67	76	276	java/lang/OutOfMemoryError
    //   80	87	276	java/lang/OutOfMemoryError
    //   91	104	282	java/lang/OutOfMemoryError
    //   108	157	282	java/lang/OutOfMemoryError
  }
  
  private void a(ayjw.c paramc)
  {
    boolean bool1 = this.jdField_a_of_type_Ayoo.a(paramc, StoryGuideLineView.bqQ, true);
    boolean bool2 = this.jdField_a_of_type_Ayoo.a(paramc, StoryGuideLineView.bqR, false);
    boolean bool3 = this.jdField_a_of_type_Ayoo.b(paramc, StoryGuideLineView.bqT, false);
    if (this.jdField_a_of_type_Ayjw$a != null) {
      this.jdField_a_of_type_Ayjw$a.b(bool1, bool2, false, bool3, paramc.aIq);
    }
    if (paramc != null)
    {
      if (paramc.aIp) {
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramc.aIq, paramc.nI, paramc.translateXValue, paramc.translateYValue, paramc.centerP, paramc.aHC, 2);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramc.aIq, paramc.nI, paramc.translateXValue, paramc.translateYValue, paramc.centerP, paramc.aHC, 1);
  }
  
  private boolean aQJ()
  {
    boolean bool = false;
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    if ((str.equalsIgnoreCase("vivo-vivo X6Plus D")) || (str.equalsIgnoreCase("motorola-Nexus 6"))) {
      bool = true;
    }
    ram.d(TAG, "isRubbish:" + bool + " brand:" + str);
    return bool;
  }
  
  public static String cC(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("folderPath should not be null");
    }
    String str = paramString1;
    if (!paramString1.endsWith("/")) {
      str = paramString1 + "/";
    }
    return str + System.currentTimeMillis() + "_" + paramString2;
  }
  
  private void eSb()
  {
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void init()
  {
    this.mItemHeight = wja.dp2px(50.0F, this.context.getResources());
    this.mScreenWidth = ayom.getWindowScreenWidth(this.context);
    this.bqZ = 1;
    this.mMode = 1;
    this.jdField_a_of_type_Ayoo = new ayoo();
    this.jdField_a_of_type_Ayoo.setMaxScale(6.0F);
    this.jdField_a_of_type_Ayoo.setMinScale(0.2F);
    this.jdField_a_of_type_Ayoo.tP(true);
    this.di = new Paint();
    this.di.setAntiAlias(true);
    this.di.setStyle(Paint.Style.STROKE);
    this.di.setColor(-1);
    this.di.setStrokeWidth(2.0F);
    this.bd = new Paint();
    this.bd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    bqX = ViewConfiguration.get(this.context).getScaledTouchSlop();
    if ((bqY == 270) && (aQJ())) {
      bqY = 540;
    }
  }
  
  public boolean E(JSONObject paramJSONObject)
  {
    if ((this.mItems == null) || (this.mItems.isEmpty())) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject = this.mItems.iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(new TextParcelData((ayjw.c)((Iterator)localObject).next()).convertToJSON());
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("topLevelWeight", this.eKq);
      ((JSONObject)localObject).put("isEditPic", this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a.La());
      ((JSONObject)localObject).put("textItems", localJSONArray);
      paramJSONObject.put(cWP, localObject);
      return true;
    }
    catch (Exception paramJSONObject) {}
    return false;
  }
  
  public Bundle G()
  {
    Bundle localBundle = super.G();
    ArrayList localArrayList = new ArrayList(this.mItems.size());
    int i = 0;
    while (i < this.mItems.size())
    {
      localArrayList.add(new TextParcelData((ayjw.c)this.mItems.get(i)));
      i += 1;
    }
    localBundle.putParcelableArrayList("TextParcelDataList", localArrayList);
    return localBundle;
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i;
    int j;
    if (isVisible())
    {
      i = (int)paramMotionEvent.getY();
      j = Math.abs(i - this.mStartY);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_Ayoo.a(paramMotionEvent, false);
        if (this.jdField_a_of_type_Ayjw$c == null) {
          eSb();
        }
        break;
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      this.jdField_a_of_type_Ayoo.l(this.jdField_a_of_type_Ayjw$c);
      eSc();
      this.jdField_a_of_type_Ayjw$c.startAnimator();
      this.mStartY = i;
      break;
      this.jdField_a_of_type_Ayjw$c.cancelAnimator();
      break;
      if (this.mMode == 3) {
        this.jdField_a_of_type_Ayjw$c.cancelAnimator();
      }
      if (j <= bqX) {
        break;
      }
      setMode(3);
      break;
      if (this.jdField_a_of_type_Ayjw$c != null) {
        this.jdField_a_of_type_Ayjw$c.cancelAnimator();
      }
      a(this, false);
      eSo();
      if (j < bqX)
      {
        btT();
        break;
      }
      if (this.mMode != 3) {
        break;
      }
      setMode(4);
      break;
      a(this.jdField_a_of_type_Ayjw$c);
    }
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    if (isVisible())
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(0);
      int i = this.mItems.size() - 1;
      if (i >= 0)
      {
        paramMotionEvent = (ayjw.c)this.mItems.get(i);
        if ((paramMotionEvent != null) && (paramMotionEvent.mSegmentKeeper != null) && (paramMotionEvent.aQT()) && (!paramMotionEvent.mSegmentKeeper.isCurrentIn())) {}
        while (!this.jdField_a_of_type_Ayoo.a(paramMotionEvent, f1, f2, false))
        {
          i -= 1;
          break;
        }
        this.jdField_a_of_type_Ayjw$c = paramMotionEvent;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.mItems.remove(this.jdField_a_of_type_Ayjw$c);
        this.mItems.add(this.jdField_a_of_type_Ayjw$c);
      }
      return bool;
    }
  }
  
  public void J(ArrayList<TextParcelData> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      setMode(4);
      this.mItems.clear();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        ayjw.c localc = ((TextParcelData)paramArrayList.next()).a(this);
        if (!paramBoolean)
        {
          localc.Zx(true);
          localc.mFrom = 1;
        }
        this.mItems.add(localc);
      } while (this.mItems.size() <= eKo);
    }
    notifyChange();
  }
  
  public void Zv(boolean paramBoolean)
  {
    setMode(5);
    if (paramBoolean) {
      eSe();
    }
  }
  
  public ayjw.c a()
  {
    if ((this.mItems != null) && (this.mItems.size() > eKo))
    {
      this.mItems.remove(this.jdField_a_of_type_Ayjw$c);
      return this.jdField_a_of_type_Ayjw$c;
    }
    return null;
  }
  
  public DynamicTextItem a()
  {
    if (this.jdField_a_of_type_Ayjw$c != null) {
      return this.jdField_a_of_type_Ayjw$c.c;
    }
    return null;
  }
  
  public DynamicTextItem a(int paramInt)
  {
    return a(null, null, paramInt);
  }
  
  public DynamicTextItem a(ayjw.b paramb, SegmentKeeper paramSegmentKeeper, int paramInt)
  {
    DynamicTextItem localDynamicTextItem = null;
    if (this.mItems.size() < eKo) {
      if (paramb == null) {
        break label87;
      }
    }
    label87:
    for (paramb = new ayjw.c(paramb);; paramb = new ayjw.c())
    {
      paramb.mFrom = paramInt;
      paramb.mSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      if (paramb.mFrom == 0) {
        SegmentKeeper.adjustTime(-1L * System.currentTimeMillis());
      }
      this.mItems.add(paramb);
      localDynamicTextItem = paramb.c;
      this.jdField_a_of_type_Ayjw$c = paramb;
      return localDynamicTextItem;
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext())
    {
      ayjw.c localc = (ayjw.c)localIterator.next();
      if (((!localc.aQL()) && (!localc.aQT())) || (paramBoolean)) {
        localc.draw(paramCanvas);
      }
    }
    paramCanvas.restore();
  }
  
  public void a(ayjw.a parama)
  {
    this.jdField_a_of_type_Ayjw$a = parama;
  }
  
  public void a(DynamicTextItem paramDynamicTextItem)
  {
    Object localObject;
    if ((paramDynamicTextItem != null) && (this.mItems.size() > 0))
    {
      localObject = null;
      Iterator localIterator = this.mItems.iterator();
      if (localIterator.hasNext())
      {
        ayjw.c localc = (ayjw.c)localIterator.next();
        if (!paramDynamicTextItem.equals(localc.c)) {
          break label72;
        }
        localObject = localc;
      }
    }
    label72:
    for (;;)
    {
      break;
      this.mItems.remove(localObject);
      return;
    }
  }
  
  public boolean aN(long paramLong)
  {
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext()) {
      if (((ayjw.c)localIterator.next()).mSegmentKeeper.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean aQI()
  {
    return (this.eKp > 0) && (this.atp > 0);
  }
  
  public void afk(int paramInt)
  {
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext())
    {
      ayjw.c localc = (ayjw.c)localIterator.next();
      if (localc.mSegmentKeeper != null) {
        localc.mSegmentKeeper.setMode(paramInt);
      }
    }
  }
  
  protected void an(Canvas paramCanvas)
  {
    Iterator localIterator;
    ayjw.c localc;
    if (this.mMode == 6)
    {
      if (this.jdField_b_of_type_Ayjw$c != null) {
        this.jdField_b_of_type_Ayjw$c.draw(paramCanvas);
      }
      localIterator = this.mItems.iterator();
      while (localIterator.hasNext())
      {
        localc = (ayjw.c)localIterator.next();
        if ((this.jdField_b_of_type_Ayjw$c != null) && (localc.c != this.jdField_b_of_type_Ayjw$c.c)) {
          localc.draw(paramCanvas);
        }
      }
    }
    if ((this.mMode == 4) || (this.mMode == 3)) {
      localIterator = this.mItems.iterator();
    }
    while (localIterator.hasNext())
    {
      ((ayjw.c)localIterator.next()).draw(paramCanvas);
      continue;
      if (this.mMode == 5)
      {
        localIterator = this.mItems.iterator();
        while (localIterator.hasNext())
        {
          localc = (ayjw.c)localIterator.next();
          if (localc.c != this.jdField_a_of_type_Ayjw$c.c) {
            localc.draw(paramCanvas);
          }
        }
      }
    }
  }
  
  public void ao(Canvas paramCanvas)
  {
    a(paramCanvas, this.scaleValue, false);
  }
  
  public ArrayList<TrackerStickerParam> at(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mItems != null) && (this.mItems.size() > 0))
    {
      Iterator localIterator = this.mItems.iterator();
      while (localIterator.hasNext())
      {
        ayjw.c localc = (ayjw.c)localIterator.next();
        if ((localc.aQL()) || (localc.aQT()))
        {
          Object localObject = a(paramString, localc);
          localObject = new TrackerStickerParam(getWidth() / 2, getHeight() / 2, 1.0F, 0.0F, 0.0F, 0.0F, getWidth(), getHeight(), getWidth(), getHeight(), (String)localObject, localc.qU);
          ((TrackerStickerParam)localObject).setSegmentList(localc.mSegmentKeeper.getSegmentList());
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void b(DynamicTextItem paramDynamicTextItem)
  {
    if (this.jdField_a_of_type_Ayjw$c != null)
    {
      this.jdField_a_of_type_Ayjw$c.c = paramDynamicTextItem;
      this.jdField_a_of_type_Ayjw$c.width = paramDynamicTextItem.getWidth();
      this.jdField_a_of_type_Ayjw$c.height = paramDynamicTextItem.getHeight();
    }
    if (this.jdField_b_of_type_Ayjw$c != null)
    {
      this.jdField_b_of_type_Ayjw$c.c = paramDynamicTextItem;
      if (this.jdField_a_of_type_Ayjw$c != null)
      {
        this.jdField_b_of_type_Ayjw$c.scaleValue = this.jdField_a_of_type_Ayjw$c.scaleValue;
        this.jdField_b_of_type_Ayjw$c.mT = this.jdField_a_of_type_Ayjw$c.scaleValue;
      }
    }
  }
  
  /* Error */
  public boolean b(android.graphics.Bitmap paramBitmap, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: getstatic 57	ayjw:TAG	Ljava/lang/String;
    //   6: new 197	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 728
    //   16: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload 4
    //   21: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 224	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_1
    //   31: ifnonnull +15 -> 46
    //   34: getstatic 57	ayjw:TAG	Ljava/lang/String;
    //   37: ldc_w 730
    //   40: invokestatic 224	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: iload 5
    //   45: ireturn
    //   46: aconst_null
    //   47: astore 8
    //   49: aconst_null
    //   50: astore 6
    //   52: aconst_null
    //   53: astore 7
    //   55: new 732	java/io/File
    //   58: dup
    //   59: aload 4
    //   61: invokespecial 733	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 9
    //   66: aload 6
    //   68: astore 4
    //   70: aload 9
    //   72: invokevirtual 736	java/io/File:exists	()Z
    //   75: ifne +13 -> 88
    //   78: aload 6
    //   80: astore 4
    //   82: aload 9
    //   84: invokevirtual 739	java/io/File:createNewFile	()Z
    //   87: pop
    //   88: aload 6
    //   90: astore 4
    //   92: new 741	java/io/FileOutputStream
    //   95: dup
    //   96: aload 9
    //   98: invokespecial 744	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore 6
    //   103: aload_1
    //   104: aload_2
    //   105: iload_3
    //   106: aload 6
    //   108: invokevirtual 748	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: iconst_1
    //   113: istore 5
    //   115: aload 6
    //   117: ifnull -74 -> 43
    //   120: aload 6
    //   122: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 754	java/io/IOException:printStackTrace	()V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_2
    //   135: aload 7
    //   137: astore_1
    //   138: aload_1
    //   139: astore 4
    //   141: aload_2
    //   142: invokevirtual 755	java/io/FileNotFoundException:printStackTrace	()V
    //   145: aload_1
    //   146: ifnull -103 -> 43
    //   149: aload_1
    //   150: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 754	java/io/IOException:printStackTrace	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aload 8
    //   165: astore_1
    //   166: aload_1
    //   167: astore 4
    //   169: aload_2
    //   170: invokevirtual 754	java/io/IOException:printStackTrace	()V
    //   173: aload_1
    //   174: ifnull -131 -> 43
    //   177: aload_1
    //   178: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 754	java/io/IOException:printStackTrace	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: astore_1
    //   191: aload 4
    //   193: ifnull +8 -> 201
    //   196: aload 4
    //   198: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 754	java/io/IOException:printStackTrace	()V
    //   208: goto -7 -> 201
    //   211: astore_1
    //   212: aload 6
    //   214: astore 4
    //   216: goto -25 -> 191
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: goto -57 -> 166
    //   226: astore_2
    //   227: aload 6
    //   229: astore_1
    //   230: goto -92 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	ayjw
    //   0	233	1	paramBitmap	android.graphics.Bitmap
    //   0	233	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	233	3	paramInt	int
    //   0	233	4	paramString	String
    //   1	113	5	bool	boolean
    //   50	178	6	localFileOutputStream	java.io.FileOutputStream
    //   53	83	7	localObject1	Object
    //   47	117	8	localObject2	Object
    //   64	33	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   120	125	127	java/io/IOException
    //   70	78	134	java/io/FileNotFoundException
    //   82	88	134	java/io/FileNotFoundException
    //   92	103	134	java/io/FileNotFoundException
    //   149	153	155	java/io/IOException
    //   70	78	162	java/io/IOException
    //   82	88	162	java/io/IOException
    //   92	103	162	java/io/IOException
    //   177	181	183	java/io/IOException
    //   70	78	190	finally
    //   82	88	190	finally
    //   92	103	190	finally
    //   141	145	190	finally
    //   169	173	190	finally
    //   196	201	203	java/io/IOException
    //   103	112	211	finally
    //   103	112	219	java/io/IOException
    //   103	112	226	java/io/FileNotFoundException
  }
  
  public void btT()
  {
    if ((this.jdField_a_of_type_Ayjw$a != null) && (this.jdField_a_of_type_Ayjw$c != null))
    {
      if (this.jdField_a_of_type_Ayjw$a.a(this.jdField_a_of_type_Ayjw$c)) {
        this.mItems.remove(this.jdField_a_of_type_Ayjw$c);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ayjw$a.c(this.jdField_a_of_type_Ayjw$c.c);
  }
  
  public void clear()
  {
    this.mMode = 1;
    this.bqZ = 1;
    this.bra = bqW;
    this.brb = 0;
    this.mItems.clear();
    this.jdField_a_of_type_Ayjw$c = null;
    ram.d(TAG, "clear over");
  }
  
  public void delete()
  {
    if (this.jdField_a_of_type_Ayjw$c != null)
    {
      this.mItems.remove(this.jdField_a_of_type_Ayjw$c);
      this.jdField_a_of_type_Ayjw$c.cancelAnimator();
      ram.d(TAG, "delete " + this.jdField_a_of_type_Ayjw$c);
      this.jdField_a_of_type_Ayjw$c = null;
    }
    if (this.mItems.size() == 0)
    {
      this.mMode = 1;
      this.bqZ = 1;
    }
  }
  
  public void eC(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.eC(paramBundle);
    J(paramBundle.getParcelableArrayList("TextParcelDataList"), paramBundle.getBoolean("edit_type_photo"));
  }
  
  public void eSc()
  {
    if ((this.jdField_a_of_type_Ayjw$c != null) && (!this.jdField_a_of_type_Ayjw$c.aQK())) {
      this.jdField_a_of_type_Ayjw$c.eSc();
    }
  }
  
  public void eSe()
  {
    if (!isEmpty())
    {
      setMode(6);
      if (this.jdField_a_of_type_Ayjw$c != null)
      {
        this.jdField_b_of_type_Ayjw$c = new ayjw.c(this.jdField_a_of_type_Ayjw$c);
        this.jdField_b_of_type_Ayjw$c.btY();
        ayjw.c.b(this.jdField_b_of_type_Ayjw$c);
      }
    }
    while (this.jdField_a_of_type_Ayjw$a == null) {
      return;
    }
    this.jdField_a_of_type_Ayjw$a.ad(1.0F);
  }
  
  public void eSf()
  {
    if (this.mItems.size() > 0) {
      this.mItems.remove(this.mItems.size() - 1);
    }
  }
  
  public void eSg()
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (this.mItems.size() > 0)
    {
      localObject2 = this.mItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ayjw.c localc = (ayjw.c)((Iterator)localObject2).next();
        if ((localc.c != null) && (localc.c.aPQ())) {
          ((List)localObject1).add(localc);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ayjw.c)((Iterator)localObject1).next();
      this.mItems.remove(localObject2);
    }
    if ((this.jdField_a_of_type_Ayjw$c != null) && (this.jdField_a_of_type_Ayjw$c.c != null) && (this.jdField_a_of_type_Ayjw$c.c.aPQ())) {
      this.jdField_a_of_type_Ayjw$c = null;
    }
  }
  
  public void eSh()
  {
    if (this.jdField_b_of_type_Ayjw$c != null)
    {
      setMode(6);
      ayjw.c.c(this.jdField_b_of_type_Ayjw$c);
    }
  }
  
  public void eSi()
  {
    if ((this.jdField_a_of_type_Ayjw$c != null) && (this.jdField_a_of_type_Ayjw$c.c != null)) {
      this.jdField_a_of_type_Ayjw$c.c.cz(-1, false);
    }
    if (this.mItems != null)
    {
      Iterator localIterator = this.mItems.iterator();
      while (localIterator.hasNext())
      {
        ayjw.c localc = (ayjw.c)localIterator.next();
        if (localc.c != null) {
          localc.c.cz(-1, false);
        }
      }
    }
    notifyChange();
  }
  
  public String getTag()
  {
    return TAG;
  }
  
  public boolean isEmpty()
  {
    return this.mMode == 1;
  }
  
  public boolean isVisible()
  {
    return (this.mMode == 4) || (this.mMode == 3);
  }
  
  public void lz(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      ram.e(TAG, "setTextOffset x:" + paramInt1 + "y=" + paramInt2);
      return;
    }
    ram.d(TAG, "setTextTop:" + paramInt1 + "y=" + paramInt2);
    this.eKp = paramInt1;
    this.atp = paramInt2;
  }
  
  public void setMode(int paramInt)
  {
    ram.d(TAG, "setMode:" + paramInt + ",preMode:" + this.bqZ);
    this.bqZ = this.mMode;
    this.mMode = paramInt;
    if (paramInt == 4) {
      eSo();
    }
    super.notifyChange();
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    super.setSize(paramInt1, paramInt2);
    this.am.x = (paramInt1 / 2);
    this.am.y = (0.42F * paramInt2);
    PADDING = (int)(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getBitmapWidth() * 0.04F);
  }
  
  public void tI(boolean paramBoolean)
  {
    ram.d(TAG, "setKeyboardState:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      super.notifyChange();
      return;
      setMode(4);
    }
  }
  
  public int tp()
  {
    if ((this.mItems != null) && (this.mItems.size() > 0)) {
      return this.mItems.size();
    }
    if (isVisible()) {
      return 1;
    }
    return 0;
  }
  
  public void xm(int paramInt)
  {
    if (paramInt < 0)
    {
      ram.e(TAG, "setTextTop:" + paramInt);
      return;
    }
    ram.d(TAG, "setTextTop:" + paramInt);
    this.brb = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(ayjw.c paramc);
    
    public abstract void ad(float paramFloat);
    
    public abstract void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
    
    public abstract void c(DynamicTextItem paramDynamicTextItem);
  }
  
  public static class b
  {
    public final PointF centerP;
    public final float height;
    public final float rotate;
    public final float scale;
    public final float translateXValue;
    public final float translateYValue;
    public final float width;
    
    public b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
    {
      this.centerP = new PointF(paramFloat1, paramFloat2);
      this.scale = paramFloat3;
      this.rotate = paramFloat4;
      this.translateXValue = paramFloat5;
      this.translateYValue = paramFloat6;
      this.width = paramFloat7;
      this.height = paramFloat8;
    }
  }
  
  public class c
    extends ayoo.a
  {
    public DynamicTextItem c;
    public int mFrom;
    public float mS;
    public float mT;
    public float mU;
    public float mV;
    public float mZ;
    public float mf;
    public float mg;
    public float na;
    public float nb;
    Rect rect;
    
    public c()
    {
      this(new ayjw.b(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
      this.centerP.set(ayjw.this.am);
      this.bsp = rpq.dip2px(BaseApplicationImpl.getContext(), 15.0F);
    }
    
    public c(@NonNull ayjw.b paramb)
    {
      super(paramb.scale, paramb.rotate, paramb.translateXValue, paramb.translateYValue, paramb.width, paramb.height, true);
      this.c = new axvb();
      this.width = this.c.getWidth();
      this.height = this.c.getHeight();
      this.mS = ayjw.PADDING;
      this.bsp = rpq.dip2px(BaseApplicationImpl.getContext(), 15.0F);
    }
    
    public c(@NonNull c paramc)
    {
      super(1.0F);
      if (paramc.rect == null) {}
      for (this.rect = new Rect(0, 0, 0, 0);; this.rect = new Rect(paramc.rect))
      {
        this.c = paramc.c;
        this.mS = paramc.mS;
        this.mT = paramc.mT;
        this.mU = paramc.mU;
        this.mV = paramc.mV;
        this.mZ = paramc.mZ;
        this.mf = paramc.mf;
        this.mg = paramc.mg;
        this.na = paramc.na;
        this.nb = paramc.nb;
        this.bsp = rpq.dip2px(BaseApplicationImpl.getContext(), 15.0F);
        a(paramc);
        return;
      }
    }
    
    private void drawEditBtn(Canvas paramCanvas)
    {
      paramCanvas.save();
      int i;
      label35:
      int k;
      label47:
      int j;
      if (this.ajB == 0)
      {
        i = 2130845500;
        if (!this.mSegmentKeeper.isDataLocked())
        {
          if (this.ajB != 0) {
            break label114;
          }
          i = 2130845506;
        }
        if (this.ajB != 1) {
          break label120;
        }
        k = 2130845496;
        if (this.ajB != 2) {
          break label127;
        }
        j = 2130845503;
        label58:
        if (this.dAg) {
          i = -1;
        }
        if (!ayjw.b(ayjw.this).a.aQQ()) {
          break label133;
        }
        j = -1;
        i = -1;
      }
      label133:
      for (;;)
      {
        ayom.a(paramCanvas, ayjw.this.a, this, i, k, j);
        paramCanvas.restore();
        return;
        i = 2130845499;
        break;
        label114:
        i = 2130845504;
        break label35;
        label120:
        k = 2130845495;
        break label47;
        label127:
        j = 2130845502;
        break label58;
      }
    }
    
    private void eSj()
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator.setDuration(ayjw.bqY);
      localValueAnimator.addUpdateListener(new ayjx(this));
      localValueAnimator.start();
    }
    
    private void eSk()
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator.setDuration(ayjw.bqY);
      localValueAnimator.addUpdateListener(new ayjy(this));
      localValueAnimator.start();
    }
    
    protected void btY()
    {
      this.mV = this.translateXValue;
      this.mZ = this.translateYValue;
      this.mT = this.scaleValue;
      this.mU = this.nI;
      this.mf = (ayjw.this.eKp - this.centerP.x - this.mV);
      this.mg = (ayjw.this.atp - this.centerP.y - this.mZ);
      this.na = (1.0F - this.mT);
      if (this.mU < 180.0F)
      {
        this.nb = (0.0F - this.mU);
        return;
      }
      this.nb = (360.0F - this.mU);
    }
    
    public void cancelAnimator()
    {
      if ((this.N != null) && (this.aIo)) {
        this.N.cancel();
      }
    }
    
    public void draw(Canvas paramCanvas)
    {
      if ((!this.mSegmentKeeper.isInSegment(ayjw.a(ayjw.this).getTimeStamp())) && (!this.aIp)) {}
      do
      {
        return;
        if (this.dzG) {
          paramCanvas.drawColor(Color.parseColor("#66000000"));
        }
        if ((this.dzE) && (this.aIp))
        {
          if ((this.isAnchor) && (this.dzH))
          {
            float f1 = this.FJ;
            float f2 = this.FH;
            float f3 = this.FK;
            float f4 = this.FI;
            float f5 = this.centerP.x;
            float f6 = this.translateXValue;
            float f7 = this.centerP.y;
            paramCanvas.drawLine(f2 + f1, f4 + f3, f6 + f5, this.translateYValue + f7, ayjw.this.di);
            paramCanvas.save();
            paramCanvas.concat(ayjw.this.a.b(this));
            int i = (int)(this.width * this.scaleValue * this.nJ) + this.bsp * 2;
            int j = (int)(this.height * this.scaleValue * this.nJ) + this.bsp * 2;
            paramCanvas.drawRect(new RectF(-i / 2, -j / 2, i / 2, j / 2), ayjw.a(ayjw.this));
            paramCanvas.restore();
          }
          if (this.isAnchor) {
            paramCanvas.drawColor(Color.parseColor("#66000000"));
          }
        }
        paramCanvas.save();
        paramCanvas.concat(ayjw.this.a.a(this));
        this.c.draw(paramCanvas);
        paramCanvas.restore();
      } while (!this.aIp);
      drawEditBtn(paramCanvas);
    }
    
    public void startAnimator()
    {
      if (this.N == null)
      {
        this.N = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
        this.N.setDuration(200L);
        this.N.setInterpolator(new LinearInterpolator());
        this.N.addUpdateListener(new ayjz(this));
        this.N.addListener(new ayka(this));
      }
      if (!this.aIo) {
        this.N.start();
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.rect != null) {
        localStringBuilder.append("centerP x : ").append(this.centerP.x).append(" y: ").append(this.centerP.y);
      }
      localStringBuilder.append("textLeft: ").append(this.mS);
      localStringBuilder.append("mSaveScaleValue: ").append(this.mT);
      localStringBuilder.append("mSaveRotateValue: ").append(this.mU);
      localStringBuilder.append("mSaveTranslateXValue: ").append(this.mV);
      localStringBuilder.append("mDistanceX: ").append(this.mf);
      localStringBuilder.append("mDistanceY: ").append(this.mg);
      localStringBuilder.append("mDScale: ").append(this.na);
      localStringBuilder.append("mDRotate: ").append(this.nb);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjw
 * JD-Core Version:    0.7.0.1
 */