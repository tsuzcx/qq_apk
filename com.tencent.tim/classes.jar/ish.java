import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class ish
  extends isd
{
  public isk a;
  public Paint ap = new Paint();
  public Paint ar = new Paint();
  public int atb;
  public itc c;
  public itc[] c;
  public itc[] d = new itc[4];
  public Canvas e;
  public int mHeight;
  public boolean mIsBig;
  public int mLeft;
  public Rect mRect = new Rect();
  public int mTop;
  public int mWidth;
  
  public ish(isk paramisk)
  {
    Bitmap localBitmap = Bitmap.createBitmap(252, 148, Bitmap.Config.ARGB_8888);
    this.a = paramisk;
    this.b = new itc(localBitmap);
    this.e = new Canvas(localBitmap);
    setRotation(-10.0F);
    this.ap.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public void aqk()
  {
    Rect localRect = this.a.getBounds();
    int j = localRect.left - this.mLeft;
    int i = j;
    if (j < this.atb) {
      i = this.atb;
    }
    j = localRect.top - this.mTop;
    setBounds(i, j, this.mWidth + i, this.mHeight + j);
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager, itc[] paramArrayOfitc)
  {
    this.d[0] = new itc(paramAVRedPacketManager.o("qav_redpacket_score_80.png"));
    this.d[1] = new itc(paramAVRedPacketManager.o("qav_redpacket_score_90.png"));
    this.d[2] = new itc(paramAVRedPacketManager.o("qav_redpacket_score_100.png"));
    this.d[3] = new itc(paramAVRedPacketManager.o("qav_redpacket_score_110.png"));
    this.jdField_c_of_type_Itc = new itc(paramAVRedPacketManager.o("qav_redpacket_score_combo.png"));
    this.jdField_c_of_type_ArrayOfItc = paramArrayOfitc;
  }
  
  public void bP(int paramInt1, int paramInt2)
  {
    this.e.drawPaint(this.ap);
    if (paramInt1 > 2)
    {
      this.mRect.set(0, 13, 37, 59);
      if (this.jdField_c_of_type_ArrayOfItc != null)
      {
        if (paramInt1 < 10) {
          break label239;
        }
        if (this.jdField_c_of_type_ArrayOfItc[(paramInt1 / 10)] != null) {
          this.jdField_c_of_type_ArrayOfItc[(paramInt1 / 10)].draw(this.e, this.mRect, this.ar);
        }
        this.mRect.set(37, 13, 74, 59);
        if (this.jdField_c_of_type_ArrayOfItc[(paramInt1 % 10)] != null) {
          this.jdField_c_of_type_ArrayOfItc[(paramInt1 % 10)].draw(this.e, this.mRect, this.ar);
        }
        this.mRect.set(74, 0, 229, 59);
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Itc != null) {
        this.jdField_c_of_type_Itc.draw(this.e, this.mRect, this.ar);
      }
      this.mRect.set(0, 59, 252, 148);
      paramInt1 = (paramInt2 - 80) / 10;
      if ((paramInt1 >= 0) && (paramInt1 < this.d.length) && (this.d[paramInt1] != null)) {
        this.d[paramInt1].draw(this.e, this.mRect, this.ar);
      }
      return;
      label239:
      if (this.jdField_c_of_type_ArrayOfItc[paramInt1] != null) {
        this.jdField_c_of_type_ArrayOfItc[paramInt1].draw(this.e, this.mRect, this.ar);
      }
      this.mRect.set(37, 0, 192, 59);
    }
  }
  
  public void iP(boolean paramBoolean)
  {
    this.mIsBig = paramBoolean;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeft = (paramInt1 * 104 / 750);
    this.mTop = (paramInt1 * 123 / 750);
    this.mWidth = (paramInt1 * 252 / 750);
    this.mHeight = (paramInt1 * 148 / 750);
    this.atb = (paramInt1 * 10 / 750);
  }
  
  public void recycle()
  {
    super.recycle();
    itc[] arrayOfitc = this.d;
    int j = arrayOfitc.length;
    int i = 0;
    while (i < j)
    {
      itc localitc = arrayOfitc[i];
      if (localitc != null) {
        localitc.recycle();
      }
      i += 1;
    }
    if (this.jdField_c_of_type_Itc != null) {
      this.jdField_c_of_type_Itc.recycle();
    }
    this.jdField_c_of_type_ArrayOfItc = null;
    this.a = null;
    this.d = null;
    this.jdField_c_of_type_Itc = null;
    this.e = null;
    this.ar = null;
    this.ap = null;
    this.mRect = null;
  }
  
  public void update(long paramLong)
  {
    paramLong -= this.mStartTime;
    int k = 0;
    int j = 0;
    int i;
    float f;
    if (this.mIsBig) {
      if ((paramLong > 0L) && (paramLong < 100L))
      {
        i = (int)(255L * paramLong / 100L);
        if (paramLong > 200L) {
          break label141;
        }
        f = 0.0055F * (float)paramLong + 0.0F;
      }
    }
    for (;;)
    {
      setAlpha(i);
      setScale(f);
      return;
      if ((paramLong >= 100L) && (paramLong <= 1250L))
      {
        i = 255;
        break;
      }
      i = j;
      if (paramLong <= 1250L) {
        break;
      }
      i = j;
      if (paramLong >= 1350L) {
        break;
      }
      i = (int)(255L * (paramLong - 1350L) / -100L);
      break;
      label141:
      if ((paramLong > 200L) && (paramLong <= 300L))
      {
        f = -0.001F * (float)paramLong + 1.3F;
      }
      else if ((paramLong > 300L) && (paramLong <= 1150L))
      {
        f = 1.0F;
      }
      else if ((paramLong > 1150L) && (paramLong <= 1250L))
      {
        f = 0.001F * (float)paramLong - 0.15F;
      }
      else if ((paramLong > 1250L) && (paramLong <= 1350L))
      {
        f = -0.011F * (float)paramLong + 14.85F;
      }
      else
      {
        f = 0.0F;
        continue;
        if (paramLong < 100L) {
          i = (int)(255L * paramLong / 100L);
        }
        for (;;)
        {
          if (paramLong > 200L) {
            break label357;
          }
          f = 0.0055F * (float)paramLong + 0.0F;
          break;
          if ((paramLong >= 100L) && (paramLong <= 650L))
          {
            i = 255;
          }
          else
          {
            i = k;
            if (paramLong > 650L)
            {
              i = k;
              if (paramLong < 750L) {
                i = (int)(255L * (paramLong - 750L) / -100L);
              }
            }
          }
        }
        label357:
        if ((paramLong > 200L) && (paramLong <= 300L)) {
          f = -0.001F * (float)paramLong + 1.3F;
        } else if ((paramLong > 300L) && (paramLong <= 550L)) {
          f = 1.0F;
        } else if ((paramLong > 550L) && (paramLong <= 650L)) {
          f = 0.001F * (float)paramLong + 0.45F;
        } else if ((paramLong > 650L) && (paramLong <= 750L)) {
          f = -0.011F * (float)paramLong + 8.25F;
        } else {
          f = 0.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ish
 * JD-Core Version:    0.7.0.1
 */