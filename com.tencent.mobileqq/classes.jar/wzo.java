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

public class wzo
  extends wzy
{
  public int a;
  public xcu a;
  
  public wzo(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Xcu = new xcu();
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    xcy localxcy;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Int = 1;
        return;
        this.jdField_a_of_type_Int = 2;
        return;
        this.jdField_a_of_type_Int = 3;
        return;
        this.jdField_a_of_type_Int = 4;
        localxcy = (xcy)this.jdField_a_of_type_Xcu.a(103);
      } while (localxcy == null);
      localxcy.a(104);
      localxcy.b();
      return;
      this.jdField_a_of_type_Int = 6;
      localxcy = (xcy)this.jdField_a_of_type_Xcu.a(103);
    } while (localxcy == null);
    localxcy.a(105);
    localxcy.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Xcu.d(101);
    }
    while ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int != 4)) {
      return;
    }
    this.jdField_a_of_type_Xcu.d(104);
  }
  
  public int a()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Xcu.a();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public Bitmap a()
  {
    return ((xcy)this.jdField_a_of_type_Xcu.a(103)).b;
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public xcw a(int paramInt)
  {
    return this.jdField_a_of_type_Xcu.a(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xcu.i();
    wsv.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    xcy localxcy = (xcy)this.jdField_a_of_type_Xcu.a(103);
    if (localxcy != null) {
      localxcy.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Xcu.a(paramCanvas, this.jdField_a_of_type_Float);
    j();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_Xcu.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_Xcu.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_Xcu.a;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_Xcu.j();
    }
    for (;;)
    {
      this.jdField_a_of_type_Xcu.c();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  @TargetApi(14)
  public void a(DoodleTextureView paramDoodleTextureView, DoodleView paramDoodleView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_Xcu);
    }
    paramDoodleTextureView = (xcy)this.jdField_a_of_type_Xcu.a(103);
    if (paramDoodleTextureView != null) {
      paramDoodleTextureView.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    wsv.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Xcu.a(paramAppInterface, paramInt2);
  }
  
  public void a(wzp paramwzp)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    xcy localxcy = (xcy)this.jdField_a_of_type_Xcu.a(103);
    if (localxcy != null) {
      localxcy.a(paramwzp, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Xcu.d();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.jdField_a_of_type_Int == 5)
    {
      return this.jdField_a_of_type_Xcu.a(102, paramMotionEvent);
      wtb.a("0X80076BE");
      wtb.b("0X80075CB");
    }
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_a_of_type_Xcu.a(101, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_Xcu.a(103, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_Xcu.a(104, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_Xcu.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public byte[] a()
  {
    return ((xcy)this.jdField_a_of_type_Xcu.a(103)).a;
  }
  
  public void b()
  {
    ((xcy)this.jdField_a_of_type_Xcu.a(103)).c();
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Xcu.c()) {
      super.g();
    }
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Xcu.c(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6);
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void d()
  {
    wsv.b("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      a(4);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.g())
    {
      a(6);
      return;
    }
    a(3);
  }
  
  public void e()
  {
    wsv.b("LineLayer", "switchNormalMode.");
    a(1);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Xcu != null) {
      this.jdField_a_of_type_Xcu.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzo
 * JD-Core Version:    0.7.0.1
 */