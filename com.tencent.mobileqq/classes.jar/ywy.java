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
public class ywy
  extends yxs
{
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public List<yxc> a;
  public Map<String, List<String>> a;
  public yxc a;
  public yxf a;
  public zca a;
  public boolean a;
  public Paint b;
  public List<ywz> b;
  public Paint c;
  public Paint d;
  
  public ywy(DoodleView paramDoodleView)
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
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Yxc);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Yxc);
    }
  }
  
  private void a(yxc paramyxc, Canvas paramCanvas)
  {
    if (paramyxc == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Zca.a(paramyxc));
    paramyxc.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      yxc localyxc = (yxc)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Zca.a(localyxc, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Yxc = localyxc;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Yxc = null;
    this.jdField_a_of_type_Zca.a();
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846736);
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
    this.jdField_a_of_type_Zca = new zca();
    this.jdField_a_of_type_Zca.a(true);
    this.jdField_a_of_type_Zca.a(18.0F);
    this.jdField_a_of_type_Zca.b(0.2F);
  }
  
  private void d()
  {
    yqp.b("FaceLayer", "click the item:" + this.jdField_a_of_type_Yxc);
    if ((this.jdField_a_of_type_Yxf != null) && (this.jdField_a_of_type_Yxc != null) && (this.jdField_a_of_type_Yxf.a(this.jdField_a_of_type_Yxc))) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Yxc);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Yxc != null) {
      this.jdField_a_of_type_Yxc.c();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      yqp.b("FaceLayer", "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Yxc != null)
    {
      int i = (int)(this.jdField_a_of_type_Yxc.n * this.jdField_a_of_type_Yxc.j);
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
    this.jdField_a_of_type_Yxc = null;
    this.jdField_a_of_type_Zca.a();
    yqp.b("FaceLayer", "clear over.");
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((yxc)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      yxc localyxc = (yxc)localIterator.next();
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Zca.a(localyxc));
      localyxc.a(paramCanvas, false);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  public void a(ywz paramywz, String paramString)
  {
    if (paramywz != null)
    {
      paramywz.a(paramString);
      g();
    }
  }
  
  public void a(yxf paramyxf)
  {
    this.jdField_a_of_type_Yxf = paramyxf;
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
      this.jdField_a_of_type_Zca.a(paramMotionEvent, false);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_Yxc != null) {
        this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Yxc);
      }
      if (this.jdField_a_of_type_Yxc != null)
      {
        this.jdField_a_of_type_Yxc.b();
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
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, yxg paramyxg)
  {
    if (paramDrawable == null) {
      yqp.e("FaceLayer", "Face drawable is null.");
    }
    do
    {
      return false;
      if (paramyxg == null)
      {
        yqp.e("FaceLayer", "ItemParams is null.");
        return false;
      }
      if (!b()) {
        break;
      }
      yqp.e("FaceLayer", "has max face count. add face failed.");
    } while (this.jdField_a_of_type_Yxf == null);
    this.jdField_a_of_type_Yxf.a(50);
    return false;
    yqp.a("FaceLayer", "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramyxg);
    yxg localyxg = yxg.a(paramyxg);
    int i = (int)(localyxg.jdField_a_of_type_Int * localyxg.jdField_a_of_type_Float);
    int j = (int)(localyxg.b * localyxg.jdField_a_of_type_Float);
    float f2 = localyxg.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f3 = localyxg.jdField_a_of_type_AndroidGraphicsPointF.y;
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
    localyxg.jdField_a_of_type_AndroidGraphicsPointF.x = f2;
    localyxg.jdField_a_of_type_AndroidGraphicsPointF.y = f3;
    yqp.a("FaceLayer", "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramyxg);
    if (TextUtils.isEmpty(localyxg.jdField_a_of_type_JavaLangString))
    {
      yqp.b("FaceLayer", "Create Normal FaceItem.");
      paramString1 = new yxc(this, paramDrawable, localyxg, paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      super.g();
      if (!(paramString1 instanceof ywz)) {
        break label445;
      }
      this.jdField_b_of_type_JavaUtilList.add((ywz)paramString1);
    }
    for (;;)
    {
      return true;
      yqp.b("FaceLayer", "Create FaceAndTextItem with text:" + localyxg.jdField_a_of_type_JavaLangString);
      paramString1 = new ywz(this, paramDrawable, localyxg, paramString1, paramString2);
      ((ywz)paramString1).a();
      break;
      label445:
      paramyxg = this.jdField_a_of_type_JavaUtilMap;
      paramDrawable = (List)paramyxg.get(paramString1.d);
      paramString2 = paramDrawable;
      if (paramDrawable == null)
      {
        paramString2 = new ArrayList();
        paramyxg.put(paramString1.d, paramString2);
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
      if (((yxc)localIterator.next() instanceof ywz)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    yxc localyxc;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localyxc = (yxc)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (!(localyxc instanceof ywz)) {
        break label80;
      }
      DoodleLayout.a("delete_poi");
      yqv.a("0X80076D2");
      yqv.b("0X80075E7");
      this.jdField_b_of_type_JavaUtilList.remove(localyxc);
    }
    label80:
    List localList;
    do
    {
      do
      {
        return;
        DoodleLayout.a("delete_oneface");
        yqv.a("0X80076CB");
        yqv.b("0X80075E0");
        localList = (List)this.jdField_a_of_type_JavaUtilMap.get(localyxc.d);
      } while (localList == null);
      localList.remove(localyxc.e);
    } while (!localList.isEmpty());
    this.jdField_a_of_type_JavaUtilMap.remove(localyxc.d);
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
      paramMotionEvent = (yxc)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_Zca.a(paramMotionEvent, f1, f2, false)) {
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
        paramMotionEvent = (yxc)this.jdField_a_of_type_JavaUtilList.get(i);
        if (this.jdField_a_of_type_Zca.a(paramMotionEvent, f1, f2, f3, f4)) {
          this.jdField_a_of_type_Yxc = paramMotionEvent;
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
    this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Yxc);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Yxc);
    this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Yxc);
    return true;
  }
  
  public boolean d(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Yxt != null) {
      this.jdField_a_of_type_Yxt.a(this, paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Zca.a(paramMotionEvent, false);
      super.g();
      return true;
      this.jdField_a_of_type_Zca.a();
      this.jdField_a_of_type_Yxc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywy
 * JD-Core Version:    0.7.0.1
 */