import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(11)
public class xdn
  extends xeh
{
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public List<xdr> a;
  public Map<String, List<String>> a;
  public xdr a;
  public xdu a;
  public xip a;
  public boolean a;
  public Paint b;
  public List<xdo> b;
  public Paint c;
  public Paint d;
  
  public xdn(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    c();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Xdr);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Xdr);
    }
  }
  
  private void a(xdr paramxdr, Canvas paramCanvas)
  {
    if (paramxdr == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Xip.a(paramxdr));
    paramxdr.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      xdr localxdr = (xdr)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Xip.a(localxdr, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Xdr = localxdr;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Xdr = null;
    this.jdField_a_of_type_Xip.a();
    super.g();
    super.b(false);
  }
  
  private boolean b()
  {
    return a() == 50;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846297);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(-16711936);
    this.c.setStrokeWidth(2.0F);
    this.f.setStrokeWidth(2.0F);
    this.d = new Paint();
    this.d.setStrokeWidth(1.0F);
    this.d.setColor(-1);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setPathEffect(new DashPathEffect(new float[] { 8.0F, 6.0F }, 0.0F));
    this.jdField_a_of_type_Xip = new xip();
    this.jdField_a_of_type_Xip.a(true);
    this.jdField_a_of_type_Xip.a(18.0F);
    this.jdField_a_of_type_Xip.b(0.2F);
  }
  
  private void d()
  {
    wxe.b("FaceLayer", "click the item:" + this.jdField_a_of_type_Xdr);
    if ((this.jdField_a_of_type_Xdu != null) && (this.jdField_a_of_type_Xdr != null) && (this.jdField_a_of_type_Xdu.a(this.jdField_a_of_type_Xdr))) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Xdr);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xdr != null) {
      this.jdField_a_of_type_Xdr.c();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      wxe.b("FaceLayer", "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Xdr != null)
    {
      int i = (int)(this.jdField_a_of_type_Xdr.n * this.jdField_a_of_type_Xdr.j);
      paramRect.set(0, 0, i, i);
    }
    return paramRect;
  }
  
  public String a()
  {
    return "FaceLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Xdr = null;
    this.jdField_a_of_type_Xip.a();
    wxe.b("FaceLayer", "clear over.");
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((xdr)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      xdr localxdr = (xdr)localIterator.next();
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Xip.a(localxdr));
      localxdr.a(paramCanvas, false);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  public void a(xdo paramxdo, String paramString)
  {
    if (paramxdo != null)
    {
      paramxdo.a(paramString);
      g();
    }
  }
  
  public void a(xdu paramxdu)
  {
    this.jdField_a_of_type_Xdu = paramxdu;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Xip.a(paramMotionEvent, false);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Xdr != null) {
        this.jdField_a_of_type_Xip.a(this.jdField_a_of_type_Xdr);
      }
      if (this.jdField_a_of_type_Xdr != null)
      {
        this.jdField_a_of_type_Xdr.b();
        continue;
        e();
        continue;
        if (j > 5)
        {
          this.jdField_a_of_type_Boolean = true;
          e();
          continue;
          e();
          if (!this.jdField_a_of_type_Boolean) {
            d();
          }
          b(paramMotionEvent);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, xdv paramxdv)
  {
    if (paramDrawable == null) {
      wxe.e("FaceLayer", "Face drawable is null.");
    }
    do
    {
      return false;
      if (paramxdv == null)
      {
        wxe.e("FaceLayer", "ItemParams is null.");
        return false;
      }
      if (!b()) {
        break;
      }
      wxe.e("FaceLayer", "has max face count. add face failed.");
    } while (this.jdField_a_of_type_Xdu == null);
    this.jdField_a_of_type_Xdu.a(50);
    return false;
    wxe.a("FaceLayer", "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramxdv);
    xdv localxdv = xdv.a(paramxdv);
    int i = (int)(localxdv.jdField_a_of_type_Int * localxdv.jdField_a_of_type_Float);
    int j = (int)(localxdv.b * localxdv.jdField_a_of_type_Float);
    float f2 = localxdv.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f3 = localxdv.jdField_a_of_type_AndroidGraphicsPointF.y;
    float f1 = f2;
    if (f2 - i / 2 < this.jdField_a_of_type_AndroidGraphicsRect.left) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.left + i / 2;
    }
    f2 = f1;
    if (i / 2 + f1 > this.jdField_a_of_type_AndroidGraphicsRect.right) {
      f2 = this.jdField_a_of_type_AndroidGraphicsRect.right - i / 2;
    }
    f1 = f3;
    if (f3 - j / 2 < this.jdField_a_of_type_AndroidGraphicsRect.top) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.top + j / 2;
    }
    f3 = f1;
    if (j / 2 + f1 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
      f3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - j / 2;
    }
    localxdv.jdField_a_of_type_AndroidGraphicsPointF.x = f2;
    localxdv.jdField_a_of_type_AndroidGraphicsPointF.y = f3;
    wxe.a("FaceLayer", "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramxdv);
    if (TextUtils.isEmpty(localxdv.jdField_a_of_type_JavaLangString))
    {
      wxe.b("FaceLayer", "Create Normal FaceItem.");
      paramString1 = new xdr(this, paramDrawable, localxdv, paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      super.g();
      if (!(paramString1 instanceof xdo)) {
        break label445;
      }
      this.jdField_b_of_type_JavaUtilList.add((xdo)paramString1);
    }
    for (;;)
    {
      return true;
      wxe.b("FaceLayer", "Create FaceAndTextItem with text:" + localxdv.jdField_a_of_type_JavaLangString);
      paramString1 = new xdo(this, paramDrawable, localxdv, paramString1, paramString2);
      ((xdo)paramString1).a();
      break;
      label445:
      paramxdv = this.jdField_a_of_type_JavaUtilMap;
      paramDrawable = (List)paramxdv.get(paramString1.d);
      paramString2 = paramDrawable;
      if (paramDrawable == null)
      {
        paramString2 = new ArrayList();
        paramxdv.put(paramString1.d, paramString2);
      }
      paramString2.add(paramString1.e);
    }
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((xdr)localIterator.next() instanceof xdo)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    xdr localxdr;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localxdr = (xdr)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (!(localxdr instanceof xdo)) {
        break label80;
      }
      DoodleLayout.a("delete_poi");
      wxk.a("0X80076D2");
      wxk.b("0X80075E7");
      this.jdField_b_of_type_JavaUtilList.remove(localxdr);
    }
    label80:
    List localList;
    do
    {
      do
      {
        return;
        DoodleLayout.a("delete_oneface");
        wxk.a("0X80076CB");
        wxk.b("0X80075E0");
        localList = (List)this.jdField_a_of_type_JavaUtilMap.get(localxdr.d);
      } while (localList == null);
      localList.remove(localxdr.e);
    } while (!localList.isEmpty());
    this.jdField_a_of_type_JavaUtilMap.remove(localxdr.d);
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (xdr)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Xip.a(paramMotionEvent, f1, f2, false)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return false;
    }
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    float f3 = paramMotionEvent.getX(1);
    float f4 = paramMotionEvent.getY(1);
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        paramMotionEvent = (xdr)this.jdField_a_of_type_JavaUtilList.get(i);
        if (this.jdField_a_of_type_Xip.a(paramMotionEvent, f1, f2, f3, f4)) {
          this.jdField_a_of_type_Xdr = paramMotionEvent;
        }
      }
      else
      {
        if (i >= 0) {
          break;
        }
        return false;
      }
      i -= 1;
    }
    this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Xdr);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Xdr);
    this.jdField_a_of_type_Xip.a(this.jdField_a_of_type_Xdr);
    return true;
  }
  
  public boolean d(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Xei != null) {
      this.jdField_a_of_type_Xei.a(this, paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Xip.a(paramMotionEvent, false);
      super.g();
      return true;
      this.jdField_a_of_type_Xip.a();
      this.jdField_a_of_type_Xdr = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdn
 * JD-Core Version:    0.7.0.1
 */