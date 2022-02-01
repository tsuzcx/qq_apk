import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;

public class aykb
  extends aykd
{
  public static int bqQ;
  public static int bqR;
  public static int bqS;
  public static int bqT;
  private aykb.a a;
  public aykb.b a;
  public boolean aHA;
  private ayoo b;
  private Paint db;
  private Paint dl;
  protected int mMode = 1;
  public int mStartY;
  
  public aykb(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    init();
    paramDoodleView.getResources().getDisplayMetrics();
  }
  
  private void a(aykb.b paramb)
  {
    if (paramb == null) {
      return;
    }
    boolean bool1 = this.jdField_b_of_type_Ayoo.a(paramb, StoryGuideLineView.bqQ, true);
    boolean bool2 = this.jdField_b_of_type_Ayoo.a(paramb, StoryGuideLineView.bqR, false);
    boolean bool3 = this.jdField_b_of_type_Ayoo.b(paramb, StoryGuideLineView.bqT, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      paramb.FG = paramb.nJ;
      paramb.an = paramb.centerP;
      paramb.FC = paramb.scaleValue;
      paramb.FD = paramb.nI;
      paramb.FE = paramb.translateXValue;
      paramb.FF = paramb.translateYValue;
    }
    for (;;)
    {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramb.aIq, paramb.nI, paramb.translateXValue, paramb.translateYValue, paramb.centerP, paramb.aHC, 0);
      if (this.jdField_a_of_type_Aykb$a == null) {
        break;
      }
      this.jdField_a_of_type_Aykb$a.b(bool1, bool2, false, bool3, paramb.aIq);
      return;
      paramb.nJ = paramb.FG;
      if (paramb.an != null) {
        paramb.centerP = paramb.an;
      }
      paramb.scaleValue = paramb.FC;
      paramb.nI = paramb.FD;
      if (bool3)
      {
        paramb.translateYValue = paramb.FF;
        if ((!bool1) && (!bool2)) {
          paramb.FE = paramb.translateXValue;
        }
      }
      if ((bool1) || (bool2))
      {
        paramb.translateXValue = paramb.FE;
        if (!bool3) {
          paramb.FF = paramb.translateYValue;
        }
      }
    }
  }
  
  private void eSb()
  {
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void init()
  {
    this.jdField_b_of_type_Ayoo = new ayoo();
    this.jdField_b_of_type_Ayoo.tP(true);
    this.jdField_b_of_type_Ayoo.setMaxScale(18.0F);
    this.jdField_b_of_type_Ayoo.setMinScale(0.5F);
    this.dl = new Paint();
    this.db = new Paint();
    this.db.setAntiAlias(true);
    this.db.setColor(Color.parseColor("#3DB8FF"));
    this.db.setStyle(Paint.Style.STROKE);
    this.db.setStrokeWidth(2.0F);
    this.db.setPathEffect(new DashPathEffect(new float[] { 6.0F, 7.0F }, 1.0F));
  }
  
  public Bundle G()
  {
    Bundle localBundle = super.G();
    if (this.jdField_a_of_type_Aykb$b != null) {
      localBundle.putParcelable("vote_paster", new InteractPasterParcelData(this.jdField_a_of_type_Aykb$b));
    }
    return localBundle;
  }
  
  protected boolean H(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.mStartY);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_Ayoo.a(paramMotionEvent, false);
      if ((this.jdField_a_of_type_Aykb$b != null) && (this.jdField_b_of_type_Ayoo.b() != null)) {
        break;
      }
      eSb();
      return true;
      this.mStartY = i;
      this.aHA = false;
      this.jdField_b_of_type_Ayoo.l(this.jdField_a_of_type_Aykb$b);
      continue;
      if (j > 5)
      {
        this.aHA = true;
        continue;
        if (!this.aHA) {
          click();
        }
        this.jdField_b_of_type_Ayoo.reset();
        a(this, false);
        eSo();
      }
    }
    a(this.jdField_a_of_type_Aykb$b);
    return true;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    if (this.mMode != 1) {}
    do
    {
      return false;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (this.jdField_b_of_type_Ayoo.a(this.jdField_a_of_type_Aykb$b, f1, f2, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoteLayer", 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoteLayer", 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    return false;
  }
  
  @Nullable
  public aykb.b a()
  {
    return this.jdField_a_of_type_Aykb$b;
  }
  
  public void a(@NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, String[] paramArrayOfString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.jdField_a_of_type_Aykb$b == null)
    {
      this.jdField_a_of_type_Aykb$b = new aykb.b(paramArrayOfString, paramBitmap, new PointF(rpq.getWindowScreenWidth(this.context) / 2, rpq.getWindowScreenHeight(this.context) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_Aykb$b.h = paramArrayOfRect;
    }
    for (this.jdField_a_of_type_Aykb$b.jn = paramArrayOfString;; this.jdField_a_of_type_Aykb$b.jn = paramArrayOfString)
    {
      this.mMode = 1;
      super.notifyChange();
      return;
      if (!this.jdField_a_of_type_Aykb$b.bitmap.isRecycled()) {
        this.jdField_a_of_type_Aykb$b.bitmap.recycle();
      }
      this.jdField_a_of_type_Aykb$b.bitmap = paramBitmap;
      this.jdField_a_of_type_Aykb$b.width = paramBitmap.getWidth();
      this.jdField_a_of_type_Aykb$b.height = paramBitmap.getHeight();
      this.jdField_a_of_type_Aykb$b.h = paramArrayOfRect;
      this.jdField_a_of_type_Aykb$b.scaleValue = paramFloat1;
      this.jdField_a_of_type_Aykb$b.nI = paramFloat2;
      this.jdField_a_of_type_Aykb$b.translateXValue = paramFloat3;
      this.jdField_a_of_type_Aykb$b.translateYValue = paramFloat4;
    }
  }
  
  public void a(aykb.a parama)
  {
    this.jdField_a_of_type_Aykb$a = parama;
  }
  
  public boolean aN(long paramLong)
  {
    return true;
  }
  
  protected void an(Canvas paramCanvas)
  {
    if (this.mMode == 1)
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_Aykb$b != null) {
        this.jdField_a_of_type_Aykb$b.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  public void ao(Canvas paramCanvas)
  {
    b(paramCanvas, this.scaleValue);
  }
  
  public void b(Canvas paramCanvas, float paramFloat) {}
  
  public void clear()
  {
    eSl();
  }
  
  public void click()
  {
    if ((this.jdField_a_of_type_Aykb$a != null) && (this.jdField_a_of_type_Aykb$b != null) && (this.jdField_a_of_type_Aykb$a.a(this.jdField_a_of_type_Aykb$b))) {
      this.jdField_a_of_type_Aykb$b = null;
    }
  }
  
  public void eC(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.eC(paramBundle);
    paramBundle = (InteractPasterParcelData)paramBundle.getParcelable("vote_paster");
  }
  
  public void eSl()
  {
    this.mMode = 1;
    if (this.jdField_a_of_type_Aykb$b != null)
    {
      if (!this.jdField_a_of_type_Aykb$b.bitmap.isRecycled()) {
        this.jdField_a_of_type_Aykb$b.bitmap.recycle();
      }
      this.jdField_a_of_type_Aykb$b = null;
    }
    if (this.jdField_a_of_type_Aykb$a != null) {
      this.jdField_a_of_type_Aykb$a.eRT();
    }
    notifyChange();
  }
  
  public void eSm()
  {
    this.mMode = 2;
    notifyChange();
  }
  
  public void eSn()
  {
    this.mMode = 1;
    notifyChange();
  }
  
  public String getTag()
  {
    return "VoteLayer";
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_Aykb$b == null;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(aykb.b paramb);
    
    public abstract void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
    
    public abstract void eRT();
  }
  
  public class b
    extends ayoo.a
  {
    public float FC = 1.0F;
    public float FD;
    public float FE;
    public float FF;
    public float FG = 1.0F;
    public aytm a;
    public boolean aHB;
    public PointF an;
    public ayjv.a b;
    @NonNull
    public Bitmap bitmap;
    public boolean dzD;
    public Rect[] h;
    public String[] jn;
    public int type;
    
    public b(String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
    {
      super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean);
      this.bitmap = paramBitmap;
      this.jdField_a_of_type_Aytm = new aytm();
      this.jn = paramArrayOfString;
    }
    
    public void draw(Canvas paramCanvas)
    {
      if ((this.bitmap == null) || (this.bitmap.isRecycled())) {
        if (QLog.isColorLevel()) {
          QLog.d("VoteLayer", 2, "draw bitmap is null");
        }
      }
      do
      {
        return;
        paramCanvas.save();
        paramCanvas.concat(aykb.a(this.jdField_a_of_type_Aykb).a(this));
        paramCanvas.drawBitmap(this.bitmap, -this.width / 2.0F, -this.height / 2.0F, aykb.a(this.jdField_a_of_type_Aykb));
        if ((this.aIp) && (this.aHB))
        {
          paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
          Path localPath = new Path();
          Rect[] arrayOfRect = this.h;
          int j = arrayOfRect.length;
          i = 0;
          while (i < j)
          {
            Rect localRect = arrayOfRect[i];
            localPath.reset();
            localPath.addRoundRect(new RectF(localRect.left + 10, localRect.top + 5, localRect.right - 10, localRect.bottom - 5), 4.0F, 4.0F, Path.Direction.CCW);
            paramCanvas.drawPath(localPath, aykb.b(this.jdField_a_of_type_Aykb));
            i += 1;
          }
        }
        paramCanvas.restore();
      } while (!this.aIp);
      int i = -1;
      if (this.dzD) {
        i = 2130840142;
      }
      ayom.a(paramCanvas, aykb.a(this.jdField_a_of_type_Aykb), this, i, 2130845495, 2130845502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykb
 * JD-Core Version:    0.7.0.1
 */