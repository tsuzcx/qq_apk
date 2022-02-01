import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public class aatn
{
  private static AtomicLong x = new AtomicLong(0L);
  private long Mv = -1L;
  private long Mw = -1L;
  private TreeMap<Long, WordingItem> a = new TreeMap();
  private Bitmap jdField_bd_of_type_AndroidGraphicsBitmap;
  private Paint jdField_bd_of_type_AndroidGraphicsPaint;
  private String bem;
  private boolean bzq;
  private boolean bzr = true;
  private boolean bzs;
  private int cjZ = 15;
  private Canvas i;
  private float mHeight;
  private boolean mPause;
  private RenderBuffer mRenderFBO;
  private float mSpeedRate = 1.0F;
  private int mState = 0;
  private float mWidth;
  private float rD = -1.0F;
  private float rE = -1.0F;
  private float rF = 1.0F;
  private float rG = 1.0F;
  private float rH;
  private float rI;
  
  private WordingItem a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      WordingItem localWordingItem = (WordingItem)((Map.Entry)localIterator.next()).getValue();
      if ((localWordingItem != null) && (localWordingItem.qB == paramLong1)) {
        return localWordingItem;
      }
    }
    return null;
  }
  
  private float aL()
  {
    float f1 = this.rD / this.mWidth;
    float f2 = this.rE / this.mHeight;
    if (f1 > f2) {
      return f1;
    }
    return f2;
  }
  
  private void clearCache()
  {
    if (this.jdField_bd_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_bd_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_bd_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
    if ((this.i != null) && (this.jdField_bd_of_type_AndroidGraphicsPaint != null)) {
      this.i.drawPaint(this.jdField_bd_of_type_AndroidGraphicsPaint);
    }
    if ((this.mRenderFBO != null) && (this.bzs))
    {
      GLES20.glClearStencil(0);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(17664);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
  }
  
  private long eM()
  {
    return x.incrementAndGet();
  }
  
  protected void Gw(int paramInt) {}
  
  protected long L(long paramLong)
  {
    long l = 0L;
    if (!this.bzr)
    {
      paramLong = l;
      if (this.Mv >= 0L) {
        paramLong = this.Mv;
      }
      return paramLong;
    }
    return paramLong / this.cjZ;
  }
  
  protected boolean Xk()
  {
    return false;
  }
  
  protected boolean Xl()
  {
    return false;
  }
  
  public boolean Xm()
  {
    return this.bzs;
  }
  
  public float a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.mWidth;
    }
    return this.rD;
  }
  
  public long a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong)
  {
    if ((paramCanvas == null) && (paramRenderBuffer == null)) {
      return -1L;
    }
    if ((this.a.size() == 0) && (3 == this.mState)) {
      return -1L;
    }
    if (this.Mv < 0L) {
      this.Mv = 0L;
    }
    long l = this.Mv;
    if (paramLong > 0L) {}
    for (l = paramLong / this.cjZ;; l += 1L)
    {
      if (l < this.Mv)
      {
        QLog.d("BaseAnimDrawer", 2, "nextFrame , targetindex <= mFrameIndex, timestamp:" + paramLong + "  frameindex:" + this.Mv);
        return -2L;
      }
      if (l == this.Mv)
      {
        QLog.d("BaseAnimDrawer", 2, "nextFrame , targetindex == mFrameIndex, timestamp:" + paramLong + "  frameindex:" + this.Mv + " cachevalid:" + this.bzq);
        if (this.bzq) {
          return this.Mv;
        }
        return -2L;
      }
      if ((paramRenderBuffer != null) && (this.bzs))
      {
        paramRenderBuffer.bind();
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "nextFrame timestamp:" + paramLong);
        }
      }
      this.rH += this.rI;
      clearCache();
      if (this.mPause) {}
      boolean bool;
      for (paramLong = this.Mv - 1L;; paramLong = this.Mv)
      {
        bool = a(paramCanvas, paramRenderBuffer, paramLong, this.cjZ);
        if (!this.mPause) {
          this.Mv += 1L;
        }
        if ((bool) || (this.Mv <= this.Mw + 1L)) {
          break;
        }
        if ((paramRenderBuffer != null) && (this.bzs)) {
          paramRenderBuffer.unbind();
        }
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "nextFrame drawer is finished:" + this.Mv);
        }
        return -1L;
      }
      if (this.mPause) {}
      for (;;)
      {
        if ((paramRenderBuffer != null) && (this.bzs)) {
          paramRenderBuffer.unbind();
        }
        if (!bool) {
          break label428;
        }
        return this.Mv;
        if (this.Mv < l) {
          break;
        }
      }
      label428:
      if (!this.bzr) {
        return -1L;
      }
      if (this.Mv > this.Mw) {
        return -1L;
      }
      return -2L;
    }
  }
  
  public void a(Context paramContext, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramFloat1 > 0.0F)
    {
      this.mWidth = paramFloat1;
      this.rD = paramFloat1;
    }
    if (paramFloat2 > 0.0F)
    {
      this.mHeight = paramFloat2;
      this.rE = paramFloat2;
    }
    if (paramInt > 0) {
      this.cjZ = paramInt;
    }
    this.bzr = paramBoolean;
    this.bem = paramString;
    clear();
    bn(paramContext, paramString);
  }
  
  public void a(Context paramContext, float paramFloat1, float paramFloat2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramFloat1 > 0.0F) {
      this.rD = paramFloat1;
    }
    if (paramFloat2 > 0.0F) {
      this.rE = paramFloat2;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, paramInt2, paramInt3);
    localParcel.setDataPosition(0);
    paramArrayOfByte = new ArrayList();
    localParcel.readTypedList(paramArrayOfByte, WordingItem.CREATOR);
    paramArrayOfByte = paramArrayOfByte.iterator();
    while (paramArrayOfByte.hasNext())
    {
      WordingItem localWordingItem = (WordingItem)paramArrayOfByte.next();
      this.a.put(Long.valueOf(localWordingItem.mID), localWordingItem);
    }
    this.mWidth = localParcel.readFloat();
    this.mHeight = localParcel.readFloat();
    if (this.rE <= 0.0F) {
      this.rE = this.mHeight;
    }
    if (this.rD <= 0.0F) {
      this.rD = this.mWidth;
    }
    this.cjZ = localParcel.readInt();
    this.bem = localParcel.readString();
    localParcel.recycle();
    this.bzr = paramBoolean;
    this.rF = aL();
    bn(paramContext, this.bem);
    reset();
    setState(3);
  }
  
  protected void a(WordingItem paramWordingItem) {}
  
  protected boolean a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public boolean aJ(boolean paramBoolean)
  {
    this.bzs = paramBoolean;
    if (this.bzs) {
      this.bzs = Xk();
    }
    return this.bzs;
  }
  
  protected float aP()
  {
    return this.rF;
  }
  
  protected float aQ()
  {
    return this.mSpeedRate;
  }
  
  protected void apk() {}
  
  public float b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.mHeight;
    }
    return this.rE;
  }
  
  protected Typeface b(String paramString)
  {
    Typeface localTypeface = null;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localTypeface = Typeface.createFromFile(paramString);
      return localTypeface;
    }
    catch (Exception paramString)
    {
      QLog.e("BaseAnimDrawer", 2, "createTypeFace exception:" + paramString.toString());
    }
    return null;
  }
  
  public void b(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseAnimDrawer", 2, "setText, state:" + this.mState + " time:" + paramLong1 + "-" + paramLong2 + " wording: " + paramString1 + "-" + paramString2 + " final:" + paramBoolean);
    }
    WordingItem localWordingItem = a(paramLong1, paramLong2);
    if (localWordingItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseAnimDrawer", 2, "is new item");
      }
      localWordingItem = new WordingItem();
      localWordingItem.qB = paramLong1;
      localWordingItem.MH = paramLong2;
      if (!TextUtils.isEmpty(paramString1)) {
        localWordingItem.beq = paramString1;
      }
      if (localWordingItem.beq == null) {
        localWordingItem.beq = "";
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localWordingItem.ber = paramString2;
      }
      if (localWordingItem.ber == null) {
        localWordingItem.ber = "";
      }
      localWordingItem.mID = eM();
      if (this.mState == 3)
      {
        this.a.put(Long.valueOf(localWordingItem.mID), localWordingItem);
        paramString1 = localWordingItem;
      }
    }
    for (;;)
    {
      a(paramString1);
      return;
      paramString1 = localWordingItem;
      if (!paramBoolean)
      {
        this.a.put(Long.valueOf(localWordingItem.mID), localWordingItem);
        paramString1 = localWordingItem;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "is old item:" + localWordingItem.beq + "-" + paramString1);
        }
        if (!TextUtils.isEmpty(paramString1)) {
          localWordingItem.beq = paramString1;
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localWordingItem.ber = paramString2;
        }
        localWordingItem.MH = paramLong2;
        paramString1 = localWordingItem;
        if (paramBoolean)
        {
          paramString1 = localWordingItem;
          if (this.mState != 3)
          {
            this.a.remove(Long.valueOf(localWordingItem.mID));
            paramString1 = localWordingItem;
          }
        }
      }
    }
  }
  
  public boolean bA(long paramLong)
  {
    if (!Xm()) {
      return false;
    }
    if (this.mRenderFBO == null) {
      this.mRenderFBO = new RenderBuffer((int)this.rD, (int)this.rE, 33984);
    }
    paramLong = a(null, this.mRenderFBO, paramLong);
    if ((paramLong != -1L) && (paramLong != -2L)) {}
    for (this.bzq = true;; this.bzq = false) {
      return this.bzq;
    }
  }
  
  protected void bn(Context paramContext, String paramString) {}
  
  protected void cbt() {}
  
  public void clear()
  {
    try
    {
      apk();
      this.a.clear();
      reset();
      return;
    }
    finally {}
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  protected boolean isPause()
  {
    return this.mPause;
  }
  
  public void pause(boolean paramBoolean)
  {
    this.mPause = paramBoolean;
  }
  
  public void reset()
  {
    try
    {
      this.Mv = -1L;
      if (this.a.size() == 0) {
        return;
      }
      if ((Xl()) && (this.a.size() > 0))
      {
        Iterator localIterator = this.a.values().iterator();
        while (localIterator.hasNext())
        {
          WordingItem localWordingItem = (WordingItem)localIterator.next();
          if (localWordingItem != null)
          {
            if (this.Mw < L(localWordingItem.qB)) {
              this.Mw = L(localWordingItem.qB);
            }
            a(localWordingItem);
          }
        }
      }
    }
    finally {}
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
    Gw(paramInt);
  }
  
  public void unInit()
  {
    cbt();
    if (this.mRenderFBO != null)
    {
      this.mRenderFBO.destroy();
      this.mRenderFBO = null;
    }
    if (this.i != null) {
      this.i = null;
    }
    if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_bd_of_type_AndroidGraphicsPaint = null;
    this.a.clear();
  }
  
  public int v(boolean paramBoolean)
  {
    if (this.mState == 3) {
      return this.a.size();
    }
    if (paramBoolean) {
      return 0;
    }
    return za();
  }
  
  protected int za()
  {
    return 0;
  }
  
  public int ze()
  {
    return this.cjZ;
  }
  
  public int zf()
  {
    if ((this.bzq) && (this.mRenderFBO != null)) {
      return this.mRenderFBO.getTexId();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatn
 * JD-Core Version:    0.7.0.1
 */