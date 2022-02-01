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
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class aymp
  extends ayml
{
  public static final int brD = Color.parseColor("#FF000000");
  public ayju.a a;
  aymi a;
  public aymo a;
  public boolean aHQ;
  private boolean aHR = true;
  int awc = 0;
  public int brE;
  public int brF;
  int brG;
  int brH;
  public int brt;
  public int bru;
  public BitmapShader c;
  Bitmap cI;
  public Bitmap cJ;
  DoodleLayout d;
  Rect drawRect;
  public byte[][] e;
  Canvas h;
  public float mLastX;
  public float mLastY;
  public Paint mLinePaint = new Paint();
  int mMode = 103;
  public byte[] mMosaicMask;
  public int mMosaicSize = 10;
  public float nm;
  public float nn;
  float scaleValue;
  
  public aymp(aymi paramaymi)
  {
    this.mLinePaint.setAntiAlias(true);
    this.mLinePaint.setStyle(Paint.Style.STROKE);
    this.mLinePaint.setStrokeJoin(Paint.Join.ROUND);
    this.mLinePaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_Aymi = paramaymi;
  }
  
  private void buC()
  {
    if (!this.aHQ) {}
    for (;;)
    {
      return;
      ram.d("MosaicOperator", "------------------------------------------------------------------------");
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.e.length)
      {
        int j = 0;
        while (j < this.e[0].length)
        {
          localStringBuilder.append(this.e[i][j] + " ");
          j += 1;
        }
        ram.d("MosaicOperator", localStringBuilder.toString());
        localStringBuilder.delete(0, localStringBuilder.length());
        i += 1;
      }
    }
  }
  
  private void el(int paramInt1, int paramInt2)
  {
    int i = 0;
    ram.d("MosaicOperator", "increaseMask:x=" + paramInt1 + ",y=" + paramInt2 + ",MosaicMaskWidth:" + this.brE + ",MosaicMaskHeight:" + this.brF);
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = paramInt1;
    arrayOfInt1[1] = (paramInt1 - 1);
    arrayOfInt1[2] = paramInt1;
    arrayOfInt1[3] = (paramInt1 + 1);
    arrayOfInt1[4] = paramInt1;
    int[] arrayOfInt2 = new int[5];
    arrayOfInt2[0] = paramInt2;
    arrayOfInt2[1] = paramInt2;
    arrayOfInt2[2] = (paramInt2 - 1);
    arrayOfInt2[3] = paramInt2;
    arrayOfInt2[4] = (paramInt2 + 1);
    paramInt1 = i;
    while ((paramInt1 < arrayOfInt1.length) && (paramInt1 < arrayOfInt2.length))
    {
      paramInt2 = arrayOfInt1[paramInt1];
      i = arrayOfInt2[paramInt1];
      if ((paramInt2 >= 0) && (i >= 0) && (paramInt2 < this.brE) && (i < this.brF))
      {
        int j = this.brE * i + paramInt2;
        byte[] arrayOfByte;
        if (this.mMosaicMask[j] != 127)
        {
          arrayOfByte = this.mMosaicMask;
          arrayOfByte[j] = ((byte)(arrayOfByte[j] + 1));
        }
        if ((this.aHQ) && (this.e[i][paramInt2] < 127))
        {
          arrayOfByte = this.e[i];
          arrayOfByte[paramInt2] = ((byte)(arrayOfByte[paramInt2] + 1));
        }
      }
      paramInt1 += 1;
    }
  }
  
  private void em(int paramInt1, int paramInt2)
  {
    int i = 0;
    ram.d("MosaicOperator", "decreaseMask:x=" + paramInt1 + ",y=" + paramInt2 + ",MosaicMaskWidth:" + this.brE + ",MosaicMaskHeight:" + this.brF);
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = paramInt1;
    arrayOfInt1[1] = (paramInt1 - 1);
    arrayOfInt1[2] = paramInt1;
    arrayOfInt1[3] = (paramInt1 + 1);
    arrayOfInt1[4] = paramInt1;
    int[] arrayOfInt2 = new int[5];
    arrayOfInt2[0] = paramInt2;
    arrayOfInt2[1] = paramInt2;
    arrayOfInt2[2] = (paramInt2 - 1);
    arrayOfInt2[3] = paramInt2;
    arrayOfInt2[4] = (paramInt2 + 1);
    paramInt1 = i;
    while ((paramInt1 < arrayOfInt1.length) && (paramInt1 < arrayOfInt2.length))
    {
      paramInt2 = arrayOfInt1[paramInt1];
      i = arrayOfInt2[paramInt1];
      if ((paramInt2 >= 0) && (i >= 0) && (paramInt2 < this.brE) && (i < this.brF))
      {
        int j = this.brE * i + paramInt2;
        byte[] arrayOfByte;
        if (this.mMosaicMask[j] > 0)
        {
          arrayOfByte = this.mMosaicMask;
          arrayOfByte[j] = ((byte)(arrayOfByte[j] - 1));
        }
        if ((this.aHQ) && (this.e[i][paramInt2] > 0))
        {
          arrayOfByte = this.e[i];
          arrayOfByte[paramInt2] = ((byte)(arrayOfByte[paramInt2] - 1));
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void a(Canvas paramCanvas, aymo paramaymo, float paramFloat)
  {
    if (paramaymo.mode == 103) {}
    do
    {
      return;
      if (paramaymo.mode == 104)
      {
        if (this.c == null) {
          buB();
        }
        this.mLinePaint.setXfermode(null);
        this.mLinePaint.setStrokeWidth(45.0F);
        if (this.c != null) {
          this.mLinePaint.setShader(this.c);
        }
        paramCanvas.drawPath(paramaymo.path, this.mLinePaint);
        return;
      }
    } while (paramaymo.mode != 105);
    if (this.h == null)
    {
      ram.w("MosaicOperator", "do not init yet");
      return;
    }
    this.h.save();
    this.h.scale(paramFloat, paramFloat);
    if (this.awc == 0) {
      this.awc = wja.dp2px(16.0F, BaseApplicationImpl.getContext().getResources());
    }
    this.mLinePaint.setXfermode(null);
    this.mLinePaint.setStrokeWidth(this.awc);
    this.mLinePaint.setShader(null);
    this.mLinePaint.setColor(brD);
    this.h.drawPath(paramaymo.path, this.mLinePaint);
    this.h.restore();
    this.aHR = true;
  }
  
  public void a(ayju.a parama, float paramFloat, Bitmap paramBitmap, Rect paramRect)
  {
    this.jdField_a_of_type_Ayju$a = parama;
    this.scaleValue = paramFloat;
    this.cI = paramBitmap;
    this.drawRect = paramRect;
  }
  
  public void a(aymo paramaymo)
  {
    if (paramaymo.mode == 103)
    {
      DoodleLayout.sx("delete_mosaics");
      ras.so("0X80076C2");
      List localList = paramaymo.oP;
      paramaymo = paramaymo.oQ;
      int i = 0;
      while ((i < localList.size()) && (i < paramaymo.size()))
      {
        em(((Integer)localList.get(i)).intValue(), ((Integer)paramaymo.get(i)).intValue());
        i += 1;
      }
      buD();
    }
    do
    {
      return;
      if (paramaymo.mode == 104)
      {
        ras.sp("0X80075CF");
        return;
      }
    } while (paramaymo.mode != 105);
    tN(false);
    DoodleLayout.sx("delete_mosaics");
    ras.so("0X80076C2");
  }
  
  public void btP()
  {
    if (this.mMode == 105)
    {
      this.mLinePaint.setXfermode(null);
      this.mLinePaint.setColor(brD);
      this.mLinePaint.setStrokeWidth(this.awc);
    }
    do
    {
      return;
      this.mLinePaint.setXfermode(null);
      this.mLinePaint.setStrokeWidth(45.0F);
    } while (this.c == null);
    this.mLinePaint.setShader(this.c);
  }
  
  public void buB()
  {
    float f2 = 0.0F;
    if (this.c != null) {}
    Bitmap localBitmap;
    label26:
    do
    {
      return;
      if (this.d == null) {
        break;
      }
      localBitmap = this.d.W();
      this.cI = localBitmap;
    } while (this.cI == null);
    int j;
    if (((this.d.getBusinessId() == 1) || (this.d.a.th() == 8)) && (this.mMode == 104))
    {
      i = rpq.getWindowScreenWidth(BaseApplicationImpl.getContext());
      j = rpq.getWindowScreenHeight(BaseApplicationImpl.getContext());
      ram.d("MosaicOperator", "reset drawRect. drawRect changed from [%d, %d, %d, %d] to [%d, %d, %d, %d].", new Object[] { Integer.valueOf(this.drawRect.left), Integer.valueOf(this.drawRect.top), Integer.valueOf(this.drawRect.right), Integer.valueOf(this.drawRect.bottom), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j) });
      this.drawRect = new Rect(0, 0, i, j);
    }
    if (Math.min(this.drawRect.width(), this.drawRect.height()) / 8 < 28) {}
    for (int i = 2;; i = 8)
    {
      Object localObject;
      for (;;)
      {
        try
        {
          localBitmap = Bitmap.createBitmap(this.drawRect.width() / i, this.drawRect.height() / i, Bitmap.Config.RGB_565);
          if (((this.d.getBusinessId() != 1) && (this.d.a.th() != 8)) || (this.mMode != 104)) {
            break label565;
          }
          f1 = localBitmap.getWidth() / this.cI.getWidth();
          f3 = localBitmap.getHeight() / this.cI.getHeight();
          if (f1 >= f3) {
            break label538;
          }
          f3 = (localBitmap.getHeight() - this.cI.getHeight() * f1) / 2.0F;
          ram.a("MosaicOperator", "init matrix. scale[%f, %f]. translate[%f, %f].", Float.valueOf(f1), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3));
          localObject = new Matrix();
          ((Matrix)localObject).postScale(f1, f1);
          ((Matrix)localObject).postTranslate(f2, f3);
          new Canvas(localBitmap).drawBitmap(this.cI, (Matrix)localObject, null);
          int k = Math.min(localBitmap.getWidth(), localBitmap.getHeight()) / 28;
          j = k;
          if (k == 0) {
            j = 1;
          }
          ayon.b(localBitmap, j);
          localObject = Bitmap.createBitmap(this.drawRect.width(), this.drawRect.height(), Bitmap.Config.RGB_565);
          if (localObject != null) {
            break label588;
          }
          localBitmap.recycle();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("MosaicOperator", 2, "failed to create mosaic bitmap");
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          ram.e("MosaicOperator", "initMosaicPicMode.", localOutOfMemoryError);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          ram.e("MosaicOperator", "initMosaicPicMode.", localIllegalArgumentException);
          return;
        }
        localBitmap = null;
        break label26;
        label538:
        f2 = (localIllegalArgumentException.getWidth() - this.cI.getWidth() * f3) / 2.0F;
        float f1 = f3;
        float f3 = 0.0F;
        continue;
        label565:
        f1 = localIllegalArgumentException.getWidth() / this.cI.getWidth();
        f3 = 0.0F;
        f2 = 0.0F;
      }
      label588:
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(i, i);
      localCanvas.drawBitmap(localIllegalArgumentException, localMatrix, null);
      localIllegalArgumentException.recycle();
      this.c = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    }
  }
  
  public void buD()
  {
    if (this.jdField_a_of_type_Ayju$a != null)
    {
      if (this.mMode != 105) {
        break label50;
      }
      this.jdField_a_of_type_Ayju$a.f(this.cJ, this.aHR);
    }
    for (;;)
    {
      this.aHR = false;
      if (this.aHQ) {
        buC();
      }
      return;
      label50:
      this.jdField_a_of_type_Ayju$a.h(this.mMosaicMask, this.brE, this.brF);
    }
  }
  
  public void buE()
  {
    this.c = null;
  }
  
  public void clear()
  {
    this.jdField_a_of_type_Aymo = new aymo(this.mMode);
    if (this.mMode == 104) {
      return;
    }
    if (this.mMode == 105)
    {
      tN(true);
      return;
    }
    int i;
    if (this.mMosaicMask != null)
    {
      i = 0;
      while (i < this.mMosaicMask.length)
      {
        this.mMosaicMask[i] = 0;
        i += 1;
      }
    }
    if (this.aHQ)
    {
      i = 0;
      while (i < this.e.length)
      {
        int j = 0;
        while (j < this.e[0].length)
        {
          this.e[i][j] = 0;
          j += 1;
        }
        i += 1;
      }
    }
    buD();
  }
  
  public void e(DoodleLayout paramDoodleLayout)
  {
    this.d = paramDoodleLayout;
  }
  
  public void ek(int paramInt1, int paramInt2)
  {
    if (this.cJ != null) {
      return;
    }
    this.brG = paramInt1;
    this.brH = paramInt2;
    this.cJ = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.h = new Canvas(this.cJ);
    this.aHR = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.mLastX = f1;
      this.mLastY = f2;
      this.jdField_a_of_type_Aymo = new aymo(this.mMode);
      if (this.jdField_a_of_type_Aymi != null) {
        this.jdField_a_of_type_Aymi.a(this.jdField_a_of_type_Aymo);
      }
      int i;
      int j;
      if (this.mMode == 103)
      {
        DoodleLayout.sx("use_mosaics");
        ras.so("0X80076C1");
        i = (int)(this.nn * f1 / this.mMosaicSize);
        j = (int)(this.nn * f2 / this.mMosaicSize);
        if ((i >= 0) && (j >= 0))
        {
          this.jdField_a_of_type_Aymo.oP.add(Integer.valueOf(i));
          this.jdField_a_of_type_Aymo.oQ.add(Integer.valueOf(j));
          el(i, j);
          buD();
        }
      }
      else if (this.mMode == 104)
      {
        this.jdField_a_of_type_Aymo.path.reset();
        this.jdField_a_of_type_Aymo.path.moveTo(f1, f2);
        this.jdField_a_of_type_Aymo.path.lineTo(f1 + 1.0F, f2 + 1.0F);
        this.jdField_a_of_type_Aymo.Gp.add(new aymw(aymw.eKC, f1, f2));
        this.jdField_a_of_type_Aymo.Gp.add(new aymw(aymw.eKD, f1 + 1.0F, 1.0F + f2));
      }
      else if (this.mMode == 105)
      {
        this.jdField_a_of_type_Aymo.path.reset();
        this.jdField_a_of_type_Aymo.path.moveTo(f1, f2);
        this.jdField_a_of_type_Aymo.path.lineTo(f1 + 1.0F, f2 + 1.0F);
        this.jdField_a_of_type_Aymo.Gp.add(new aymw(aymw.eKC, f1, f2));
        this.jdField_a_of_type_Aymo.Gp.add(new aymw(aymw.eKD, f1 + 1.0F, 1.0F + f2));
        continue;
        int k;
        int m;
        if (this.mMode == 103)
        {
          i = ((Integer)this.jdField_a_of_type_Aymo.oP.get(this.jdField_a_of_type_Aymo.oP.size() - 1)).intValue();
          j = ((Integer)this.jdField_a_of_type_Aymo.oQ.get(this.jdField_a_of_type_Aymo.oQ.size() - 1)).intValue();
          k = (int)(this.nn * f1 / this.mMosaicSize);
          m = (int)(this.nn * f2 / this.mMosaicSize);
          if (((k != i) || (m != j)) && (k >= 0) && (m >= 0))
          {
            this.jdField_a_of_type_Aymo.oP.add(Integer.valueOf(k));
            this.jdField_a_of_type_Aymo.oQ.add(Integer.valueOf(m));
            el(k, m);
            buD();
          }
        }
        else
        {
          float f3;
          float f4;
          if (this.mMode == 104)
          {
            f3 = (this.mLastX + f1) / 2.0F;
            f4 = (this.mLastY + f2) / 2.0F;
            this.jdField_a_of_type_Aymo.path.quadTo(this.mLastX, this.mLastY, f3, f4);
            this.jdField_a_of_type_Aymo.Gp.add(new aymw(aymw.eKE, this.mLastX, this.mLastY, f3, f4));
            this.mLastX = f1;
            this.mLastY = f2;
          }
          else if (this.mMode == 105)
          {
            f3 = (this.mLastX + f1) / 2.0F;
            f4 = (this.mLastY + f2) / 2.0F;
            this.jdField_a_of_type_Aymo.path.quadTo(this.mLastX, this.mLastY, f3, f4);
            this.jdField_a_of_type_Aymo.Gp.add(new aymw(aymw.eKE, this.mLastX, this.mLastY, f3, f4));
            this.mLastX = f1;
            this.mLastY = f2;
            continue;
            if (this.mMode == 103)
            {
              i = ((Integer)this.jdField_a_of_type_Aymo.oP.get(this.jdField_a_of_type_Aymo.oP.size() - 1)).intValue();
              j = ((Integer)this.jdField_a_of_type_Aymo.oQ.get(this.jdField_a_of_type_Aymo.oQ.size() - 1)).intValue();
              k = (int)(this.nn * f1 / this.mMosaicSize);
              m = (int)(this.nn * f2 / this.mMosaicSize);
              if (((k != i) || (m != j)) && (k >= 0) && (m >= 0))
              {
                this.jdField_a_of_type_Aymo.oP.add(Integer.valueOf(k));
                this.jdField_a_of_type_Aymo.oQ.add(Integer.valueOf(m));
                el(k, m);
                buD();
              }
            }
          }
        }
      }
    }
  }
  
  public void setMode(int paramInt)
  {
    this.mMode = paramInt;
  }
  
  public void setMosaicSize(int paramInt)
  {
    ram.d("MosaicOperator", "set MosaicSize:" + paramInt);
    this.mMosaicSize = paramInt;
  }
  
  public void setMosaicStandardSize(int paramInt1, int paramInt2)
  {
    ram.d("MosaicOperator", "standardWidth:" + paramInt1 + ",standardHeight:" + paramInt2);
    this.brt = paramInt1;
    this.bru = paramInt2;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.nm = (this.brt / paramInt1);
    this.nn = (this.bru / paramInt2);
    if (this.nn <= 0.0F)
    {
      ram.e("MosaicOperator", "mosaicHeightScale <= 0.");
      this.nn = this.scaleValue;
    }
    this.brE = ((int)(paramInt1 * this.nn / this.mMosaicSize));
    this.brF = ((int)(this.bru / this.mMosaicSize));
    ram.d("MosaicOperator", "create mosaic mask array, width:" + this.brE + ",height:" + this.brF + ",array length:" + this.brE * this.brF);
    this.mMosaicMask = new byte[this.brE * this.brF];
    paramInt1 = 0;
    while (paramInt1 < this.mMosaicMask.length)
    {
      this.mMosaicMask[paramInt1] = 0;
      paramInt1 += 1;
    }
    if (this.aHQ)
    {
      paramInt1 = this.brF;
      paramInt2 = this.brE;
      this.e = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt1, paramInt2 }));
      paramInt1 = 0;
      while (paramInt1 < this.brF)
      {
        paramInt2 = 0;
        while (paramInt2 < this.brE)
        {
          this.e[paramInt1][paramInt2] = 0;
          paramInt2 += 1;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void tN(boolean paramBoolean)
  {
    if ((this.mMode == 105) && (this.h != null))
    {
      ram.b("MosaicOperator", "clearMp4MosaicCanvasAndDraw notify=%s", Boolean.valueOf(paramBoolean));
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      this.h.drawPaint(localPaint);
      this.aHR = true;
      if (paramBoolean) {
        buD();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymp
 * JD-Core Version:    0.7.0.1
 */