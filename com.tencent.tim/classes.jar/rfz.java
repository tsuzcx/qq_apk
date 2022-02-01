import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class rfz
  extends rgf
{
  public rhy a;
  public int mMode = 1;
  
  public rfz(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Rhy = new rhy();
  }
  
  private void btP()
  {
    if (this.mMode == 1) {
      this.jdField_a_of_type_Rhy.xw(101);
    }
    while ((this.mMode == 2) || (this.mMode != 4)) {
      return;
    }
    this.jdField_a_of_type_Rhy.xw(104);
  }
  
  private void setMode(int paramInt)
  {
    switch (paramInt)
    {
    }
    rib localrib;
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
        localrib = (rib)this.jdField_a_of_type_Rhy.b(103);
      } while (localrib == null);
      localrib.setMode(104);
      localrib.buB();
      return;
      this.mMode = 6;
      localrib = (rib)this.jdField_a_of_type_Rhy.b(103);
    } while (localrib == null);
    localrib.setMode(105);
    localrib.ek(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.mBitmapWidth, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.mBitmapHeight);
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.mMode == 5)
    {
      return this.jdField_a_of_type_Rhy.a(102, paramMotionEvent);
      ras.so("0X80076BE");
      ras.sp("0X80075CB");
    }
    if (this.mMode == 1) {
      return this.jdField_a_of_type_Rhy.a(101, paramMotionEvent);
    }
    if (this.mMode == 3) {
      return this.jdField_a_of_type_Rhy.a(103, paramMotionEvent);
    }
    if (this.mMode == 4) {
      return this.jdField_a_of_type_Rhy.a(104, paramMotionEvent);
    }
    if (this.mMode == 6) {
      return this.jdField_a_of_type_Rhy.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean J(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public byte[] K()
  {
    return ((rib)this.jdField_a_of_type_Rhy.b(103)).mMosaicMask;
  }
  
  public boolean Lo()
  {
    return (this.mMode == 3) || (this.mMode == 4) || (this.mMode == 6);
  }
  
  public Bitmap X()
  {
    return ((rib)this.jdField_a_of_type_Rhy.b(103)).cJ;
  }
  
  public rhz a(int paramInt)
  {
    return this.jdField_a_of_type_Rhy.b(paramInt);
  }
  
  @TargetApi(14)
  public void a(DoodleTextureView paramDoodleTextureView, DoodleView paramDoodleView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_Rhy);
    }
    paramDoodleTextureView = (rib)this.jdField_a_of_type_Rhy.b(103);
    if (paramDoodleTextureView != null) {
      paramDoodleTextureView.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    ram.d("LineLayer", "switchImageMode.");
    this.mMode = 5;
    this.jdField_a_of_type_Rhy.b(paramAppInterface, paramInt2);
  }
  
  public void a(rfz.a parama)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.W();
    rib localrib = (rib)this.jdField_a_of_type_Rhy.b(103);
    if (localrib != null) {
      localrib.a(parama, this.scaleValue, localBitmap, this.drawRect);
    }
  }
  
  protected void an(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Rhy.c(paramCanvas, this.scaleValue);
    btP();
  }
  
  public void ao(Canvas paramCanvas)
  {
    b(paramCanvas, this.scaleValue);
  }
  
  public void ap(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Rhy.e(paramCanvas, this.scaleValue);
  }
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_Rhy.d(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_Rhy.Lt())
    {
      Bitmap localBitmap = this.jdField_a_of_type_Rhy.cG;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_Rhy.buw();
    }
    for (;;)
    {
      this.jdField_a_of_type_Rhy.bup();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  public void btO()
  {
    ((rib)this.jdField_a_of_type_Rhy.b(103)).buD();
  }
  
  public void btQ()
  {
    ram.d("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.La())
    {
      setMode(4);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Lg())
    {
      setMode(6);
      return;
    }
    setMode(3);
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
    this.jdField_a_of_type_Rhy.apk();
    ram.d("LineLayer", "clear over.");
  }
  
  public String getTag()
  {
    return "LineLayer";
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_Rhy.isEmpty();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Rhy != null) {
      this.jdField_a_of_type_Rhy.onDestroy();
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    super.setSize(paramInt1, paramInt2);
    rib localrib = (rib)this.jdField_a_of_type_Rhy.b(103);
    if (localrib != null) {
      localrib.setSize(paramInt1, paramInt2);
    }
  }
  
  public int tp()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Rhy.A();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public void undo()
  {
    if (this.jdField_a_of_type_Rhy.Lv()) {
      super.notifyChange();
    }
  }
  
  public static abstract interface a
  {
    public abstract void f(Bitmap paramBitmap, boolean paramBoolean);
    
    public abstract void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfz
 * JD-Core Version:    0.7.0.1
 */