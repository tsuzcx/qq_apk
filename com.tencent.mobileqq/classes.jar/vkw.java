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

public class vkw
  extends vlg
{
  public int a;
  public voc a;
  
  public vkw(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Voc = new voc();
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    vog localvog;
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
        localvog = (vog)this.jdField_a_of_type_Voc.a(103);
      } while (localvog == null);
      localvog.a(104);
      localvog.b();
      return;
      this.jdField_a_of_type_Int = 6;
      localvog = (vog)this.jdField_a_of_type_Voc.a(103);
    } while (localvog == null);
    localvog.a(105);
    localvog.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Voc.d(101);
    }
    while ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int != 4)) {
      return;
    }
    this.jdField_a_of_type_Voc.d(104);
  }
  
  public int a()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Voc.a();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public Bitmap a()
  {
    return ((vog)this.jdField_a_of_type_Voc.a(103)).b;
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public voe a(int paramInt)
  {
    return this.jdField_a_of_type_Voc.a(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Voc.i();
    ved.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    vog localvog = (vog)this.jdField_a_of_type_Voc.a(103);
    if (localvog != null) {
      localvog.c(paramInt1, paramInt2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Voc.a(paramCanvas, this.jdField_a_of_type_Float);
    j();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_Voc.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_Voc.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_Voc.a;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_Voc.j();
    }
    for (;;)
    {
      this.jdField_a_of_type_Voc.c();
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
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_Voc);
    }
    paramDoodleTextureView = (vog)this.jdField_a_of_type_Voc.a(103);
    if (paramDoodleTextureView != null) {
      paramDoodleTextureView.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    ved.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Voc.a(paramAppInterface, paramInt2);
  }
  
  public void a(vkx paramvkx)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    vog localvog = (vog)this.jdField_a_of_type_Voc.a(103);
    if (localvog != null) {
      localvog.a(paramvkx, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Voc.d();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.jdField_a_of_type_Int == 5)
    {
      return this.jdField_a_of_type_Voc.a(102, paramMotionEvent);
      vej.a("0X80076BE");
      vej.b("0X80075CB");
    }
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_a_of_type_Voc.a(101, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_Voc.a(103, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_Voc.a(104, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_Voc.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public byte[] a()
  {
    return ((vog)this.jdField_a_of_type_Voc.a(103)).a;
  }
  
  public void b()
  {
    ((vog)this.jdField_a_of_type_Voc.a(103)).c();
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
    if (this.jdField_a_of_type_Voc.c()) {
      super.g();
    }
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Voc.c(paramCanvas, this.jdField_a_of_type_Float);
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
    ved.b("LineLayer", "switchMosaicMode.");
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
    ved.b("LineLayer", "switchNormalMode.");
    a(1);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Voc != null) {
      this.jdField_a_of_type_Voc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkw
 * JD-Core Version:    0.7.0.1
 */