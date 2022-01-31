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
public class vkp
  extends vlj
{
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public List<vkt> a;
  public Map<String, List<String>> a;
  public vkt a;
  public vkw a;
  public vpr a;
  public boolean a;
  public Paint b;
  public List<vkq> b;
  public Paint c;
  public Paint d;
  
  public vkp(DoodleView paramDoodleView)
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
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Vkt);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Vkt);
    }
  }
  
  private void a(vkt paramvkt, Canvas paramCanvas)
  {
    if (paramvkt == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Vpr.a(paramvkt));
    paramvkt.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      vkt localvkt = (vkt)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Vpr.a(localvkt, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Vkt = localvkt;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Vkt = null;
    this.jdField_a_of_type_Vpr.a();
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845839);
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
    this.jdField_a_of_type_Vpr = new vpr();
    this.jdField_a_of_type_Vpr.a(true);
    this.jdField_a_of_type_Vpr.a(18.0F);
    this.jdField_a_of_type_Vpr.b(0.2F);
  }
  
  private void d()
  {
    veg.b("FaceLayer", "click the item:" + this.jdField_a_of_type_Vkt);
    if ((this.jdField_a_of_type_Vkw != null) && (this.jdField_a_of_type_Vkt != null) && (this.jdField_a_of_type_Vkw.a(this.jdField_a_of_type_Vkt))) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Vkt);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Vkt != null) {
      this.jdField_a_of_type_Vkt.c();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      veg.b("FaceLayer", "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Vkt != null)
    {
      int i = (int)(this.jdField_a_of_type_Vkt.n * this.jdField_a_of_type_Vkt.j);
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
    this.jdField_a_of_type_Vkt = null;
    this.jdField_a_of_type_Vpr.a();
    veg.b("FaceLayer", "clear over.");
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((vkt)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      vkt localvkt = (vkt)localIterator.next();
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Vpr.a(localvkt));
      localvkt.a(paramCanvas, false);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  public void a(vkq paramvkq, String paramString)
  {
    if (paramvkq != null)
    {
      paramvkq.a(paramString);
      g();
    }
  }
  
  public void a(vkw paramvkw)
  {
    this.jdField_a_of_type_Vkw = paramvkw;
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
      this.jdField_a_of_type_Vpr.a(paramMotionEvent, false);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Vkt != null) {
        this.jdField_a_of_type_Vpr.a(this.jdField_a_of_type_Vkt);
      }
      if (this.jdField_a_of_type_Vkt != null)
      {
        this.jdField_a_of_type_Vkt.b();
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
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, vkx paramvkx)
  {
    if (paramDrawable == null) {
      veg.e("FaceLayer", "Face drawable is null.");
    }
    do
    {
      return false;
      if (paramvkx == null)
      {
        veg.e("FaceLayer", "ItemParams is null.");
        return false;
      }
      if (!b()) {
        break;
      }
      veg.e("FaceLayer", "has max face count. add face failed.");
    } while (this.jdField_a_of_type_Vkw == null);
    this.jdField_a_of_type_Vkw.a(50);
    return false;
    veg.a("FaceLayer", "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramvkx);
    vkx localvkx = vkx.a(paramvkx);
    int i = (int)(localvkx.jdField_a_of_type_Int * localvkx.jdField_a_of_type_Float);
    int j = (int)(localvkx.b * localvkx.jdField_a_of_type_Float);
    float f2 = localvkx.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f3 = localvkx.jdField_a_of_type_AndroidGraphicsPointF.y;
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
    localvkx.jdField_a_of_type_AndroidGraphicsPointF.x = f2;
    localvkx.jdField_a_of_type_AndroidGraphicsPointF.y = f3;
    veg.a("FaceLayer", "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramvkx);
    if (TextUtils.isEmpty(localvkx.jdField_a_of_type_JavaLangString))
    {
      veg.b("FaceLayer", "Create Normal FaceItem.");
      paramString1 = new vkt(this, paramDrawable, localvkx, paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      super.g();
      if (!(paramString1 instanceof vkq)) {
        break label445;
      }
      this.jdField_b_of_type_JavaUtilList.add((vkq)paramString1);
    }
    for (;;)
    {
      return true;
      veg.b("FaceLayer", "Create FaceAndTextItem with text:" + localvkx.jdField_a_of_type_JavaLangString);
      paramString1 = new vkq(this, paramDrawable, localvkx, paramString1, paramString2);
      ((vkq)paramString1).a();
      break;
      label445:
      paramvkx = this.jdField_a_of_type_JavaUtilMap;
      paramDrawable = (List)paramvkx.get(paramString1.d);
      paramString2 = paramDrawable;
      if (paramDrawable == null)
      {
        paramString2 = new ArrayList();
        paramvkx.put(paramString1.d, paramString2);
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
      if (((vkt)localIterator.next() instanceof vkq)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    vkt localvkt;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localvkt = (vkt)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (!(localvkt instanceof vkq)) {
        break label80;
      }
      DoodleLayout.a("delete_poi");
      vem.a("0X80076D2");
      vem.b("0X80075E7");
      this.jdField_b_of_type_JavaUtilList.remove(localvkt);
    }
    label80:
    List localList;
    do
    {
      do
      {
        return;
        DoodleLayout.a("delete_oneface");
        vem.a("0X80076CB");
        vem.b("0X80075E0");
        localList = (List)this.jdField_a_of_type_JavaUtilMap.get(localvkt.d);
      } while (localList == null);
      localList.remove(localvkt.e);
    } while (!localList.isEmpty());
    this.jdField_a_of_type_JavaUtilMap.remove(localvkt.d);
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
      paramMotionEvent = (vkt)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Vpr.a(paramMotionEvent, f1, f2, false)) {
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
        paramMotionEvent = (vkt)this.jdField_a_of_type_JavaUtilList.get(i);
        if (this.jdField_a_of_type_Vpr.a(paramMotionEvent, f1, f2, f3, f4)) {
          this.jdField_a_of_type_Vkt = paramMotionEvent;
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
    this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Vkt);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Vkt);
    this.jdField_a_of_type_Vpr.a(this.jdField_a_of_type_Vkt);
    return true;
  }
  
  public boolean d(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Vlk != null) {
      this.jdField_a_of_type_Vlk.a(this, paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Vpr.a(paramMotionEvent, false);
      super.g();
      return true;
      this.jdField_a_of_type_Vpr.a();
      this.jdField_a_of_type_Vkt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkp
 * JD-Core Version:    0.7.0.1
 */