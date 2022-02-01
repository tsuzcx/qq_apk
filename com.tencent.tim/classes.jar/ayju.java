import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import org.json.JSONObject;

public class ayju
  extends aykd
{
  public static String cWP = "LineLayer";
  public aymk a = new aymk();
  public int mMode = 1;
  
  public ayju(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  private void btP()
  {
    if (this.mMode == 1) {
      this.a.xw(101);
    }
    while ((this.mMode == 2) || (this.mMode != 4)) {
      return;
    }
    this.a.xw(104);
  }
  
  private void setMode(int paramInt)
  {
    switch (paramInt)
    {
    }
    aymp localaymp;
    do
    {
      do
      {
        return;
        this.mMode = 1;
        return;
        this.mMode = 2;
        return;
        this.mMode = 3;
        return;
        this.mMode = 4;
        localaymp = (aymp)this.a.b(103);
      } while (localaymp == null);
      localaymp.setMode(104);
      localaymp.buB();
      return;
      this.mMode = 6;
      localaymp = (aymp)this.a.b(103);
    } while (localaymp == null);
    localaymp.setMode(105);
    localaymp.ek(this.b.mBitmapWidth, this.b.mBitmapHeight);
  }
  
  public boolean E(JSONObject paramJSONObject)
  {
    return this.a.E(paramJSONObject);
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.mMode == 5)
    {
      return this.a.a(102, paramMotionEvent);
      ras.so("0X80076BE");
      ras.sp("0X80075CB");
    }
    if (this.mMode == 1) {
      return this.a.a(101, paramMotionEvent);
    }
    if (this.mMode == 3) {
      return this.a.a(103, paramMotionEvent);
    }
    if (this.mMode == 4) {
      return this.a.a(104, paramMotionEvent);
    }
    if (this.mMode == 6) {
      return this.a.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public byte[] K()
  {
    return ((aymp)this.a.b(103)).mMosaicMask;
  }
  
  public boolean Lo()
  {
    return (this.mMode == 3) || (this.mMode == 4) || (this.mMode == 6);
  }
  
  public Bitmap X()
  {
    return ((aymp)this.a.b(103)).cJ;
  }
  
  public ayml a(int paramInt)
  {
    return this.a.b(paramInt);
  }
  
  public void a(ayju.a parama)
  {
    Bitmap localBitmap = this.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.W();
    aymp localaymp = (aymp)this.a.b(103);
    if (localaymp != null) {
      localaymp.a(parama, this.scaleValue, localBitmap, this.drawRect);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    ram.d("LineLayer", "switchImageMode.");
    this.mMode = 5;
    this.a.b(paramAppInterface, paramInt2);
  }
  
  public void a(DoodleTextureView paramDoodleTextureView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.a);
    }
  }
  
  public boolean aN(long paramLong)
  {
    return true;
  }
  
  protected void an(Canvas paramCanvas)
  {
    this.a.c(paramCanvas, this.scaleValue);
    btP();
  }
  
  public void ao(Canvas paramCanvas)
  {
    b(paramCanvas, this.scaleValue);
  }
  
  public void ap(Canvas paramCanvas)
  {
    this.a.e(paramCanvas, this.scaleValue);
  }
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    this.a.d(paramCanvas, paramFloat);
    if (this.a.Lt())
    {
      Bitmap localBitmap = this.a.cG;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.a.buw();
    }
    for (;;)
    {
      this.a.bup();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  public void btO()
  {
    ((aymp)this.a.b(103)).buD();
  }
  
  public void btQ()
  {
    ram.d("LineLayer", "switchMosaicMode.");
    if (this.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La())
    {
      setMode(4);
      return;
    }
    setMode(6);
  }
  
  public void btR()
  {
    ram.d("LineLayer", "switchNormalMode.");
    setMode(1);
  }
  
  public boolean bz()
  {
    return this.mMode == 1;
  }
  
  public void clear()
  {
    this.a.apk();
    ram.d("LineLayer", "clear over.");
  }
  
  public void eSd()
  {
    aymp localaymp = (aymp)this.a.b(103);
    if (localaymp != null) {
      localaymp.e(this.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public String getTag()
  {
    return "LineLayer";
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    super.setSize(paramInt1, paramInt2);
    aymp localaymp = (aymp)this.a.b(103);
    if (localaymp != null) {
      localaymp.setSize(paramInt1, paramInt2);
    }
  }
  
  public int tp()
  {
    int[] arrayOfInt = this.a.A();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public void undo()
  {
    if (this.a.Lv()) {
      super.notifyChange();
    }
  }
  
  public static abstract interface a
  {
    public abstract void f(Bitmap paramBitmap, boolean paramBoolean);
    
    public abstract void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayju
 * JD-Core Version:    0.7.0.1
 */