import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(11)
public class rft
  extends rgf
{
  public rft.b a;
  public rft.c a;
  public riy a;
  public boolean aHA;
  public Paint aU;
  public Paint aV;
  public Paint aW;
  public Paint aX;
  public Drawable di;
  public Map<String, List<String>> gg = new HashMap();
  public int mStartY;
  public TextPaint mTextPaint;
  public List<rft.b> oJ = new ArrayList();
  public List<rft.a> oK = new ArrayList();
  
  public rft(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    init();
  }
  
  private boolean Ln()
  {
    return tp() == 50;
  }
  
  private void M(MotionEvent paramMotionEvent)
  {
    if (z(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.oJ.remove(this.jdField_a_of_type_Rft$b);
      this.oJ.add(this.jdField_a_of_type_Rft$b);
    }
  }
  
  private void N(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Rft$b = null;
    this.jdField_a_of_type_Riy.reset();
    super.notifyChange();
    super.tJ(false);
  }
  
  private void a(rft.b paramb, Canvas paramCanvas)
  {
    if (paramb == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Riy.a(paramb));
    paramb.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private void cancelAnimator()
  {
    if (this.jdField_a_of_type_Rft$b != null) {
      this.jdField_a_of_type_Rft$b.cancelAnimator();
    }
  }
  
  private void click()
  {
    ram.d("FaceLayer", "click the item:" + this.jdField_a_of_type_Rft$b);
    if ((this.jdField_a_of_type_Rft$c != null) && (this.jdField_a_of_type_Rft$b != null) && (this.jdField_a_of_type_Rft$c.a(this.jdField_a_of_type_Rft$b))) {
      this.oJ.remove(this.jdField_a_of_type_Rft$b);
    }
  }
  
  private void init()
  {
    this.aU = new Paint();
    this.di = this.context.getResources().getDrawable(2130847618);
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    this.mTextPaint.setStyle(Paint.Style.FILL);
    this.mTextPaint.setTypeface(Typeface.DEFAULT);
    this.aV = new Paint();
    this.aV.setAntiAlias(true);
    this.aV.setStyle(Paint.Style.STROKE);
    this.aV.setColor(-65536);
    this.aV.setStrokeWidth(2.0F);
    this.aW = new Paint();
    this.aW.setAntiAlias(true);
    this.aW.setStyle(Paint.Style.STROKE);
    this.aW.setColor(-16711936);
    this.aW.setStrokeWidth(2.0F);
    this.aI.setStrokeWidth(2.0F);
    this.aX = new Paint();
    this.aX.setStrokeWidth(1.0F);
    this.aX.setColor(-1);
    this.aX.setStyle(Paint.Style.STROKE);
    this.aX.setPathEffect(new DashPathEffect(new float[] { 8.0F, 6.0F }, 0.0F));
    this.jdField_a_of_type_Riy = new riy();
    this.jdField_a_of_type_Riy.tP(true);
    this.jdField_a_of_type_Riy.setMaxScale(18.0F);
    this.jdField_a_of_type_Riy.setMinScale(0.2F);
  }
  
  private boolean z(float paramFloat1, float paramFloat2)
  {
    int i = this.oJ.size() - 1;
    while (i >= 0)
    {
      rft.b localb = (rft.b)this.oJ.get(i);
      if (this.jdField_a_of_type_Riy.a(localb, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Rft$b = localb;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.mStartY);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Riy.a(paramMotionEvent, false);
      return true;
      this.mStartY = i;
      this.aHA = false;
      M(paramMotionEvent);
      if (this.jdField_a_of_type_Rft$b != null) {
        this.jdField_a_of_type_Riy.d(this.jdField_a_of_type_Rft$b);
      }
      if (this.jdField_a_of_type_Rft$b != null)
      {
        this.jdField_a_of_type_Rft$b.startAnimator();
        continue;
        cancelAnimator();
        continue;
        if (j > 5)
        {
          this.aHA = true;
          cancelAnimator();
          continue;
          cancelAnimator();
          if (!this.aHA) {
            click();
          }
          N(paramMotionEvent);
        }
      }
    }
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.oJ.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (rft.b)this.oJ.get(i);
      if (this.jdField_a_of_type_Riy.a(paramMotionEvent, f1, f2, false)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean J(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return false;
    }
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    float f3 = paramMotionEvent.getX(1);
    float f4 = paramMotionEvent.getY(1);
    int i = this.oJ.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        paramMotionEvent = (rft.b)this.oJ.get(i);
        if (this.jdField_a_of_type_Riy.a(paramMotionEvent, f1, f2, f3, f4)) {
          this.jdField_a_of_type_Rft$b = paramMotionEvent;
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
    this.oJ.remove(this.jdField_a_of_type_Rft$b);
    this.oJ.add(this.jdField_a_of_type_Rft$b);
    this.jdField_a_of_type_Riy.d(this.jdField_a_of_type_Rft$b);
    return true;
  }
  
  public boolean K(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Rgf$a != null) {
      this.jdField_a_of_type_Rgf$a.a(this, paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Riy.a(paramMotionEvent, false);
      super.notifyChange();
      return true;
      this.jdField_a_of_type_Riy.reset();
      this.jdField_a_of_type_Rft$b = null;
    }
  }
  
  public void a(rft.a parama, String paramString)
  {
    if (parama != null)
    {
      parama.setText(paramString);
      notifyChange();
    }
  }
  
  public void a(rft.c paramc)
  {
    this.jdField_a_of_type_Rft$c = paramc;
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, rft.d paramd)
  {
    if (paramDrawable == null) {
      ram.e("FaceLayer", "Face drawable is null.");
    }
    do
    {
      return false;
      if (paramd == null)
      {
        ram.e("FaceLayer", "ItemParams is null.");
        return false;
      }
      if (!Ln()) {
        break;
      }
      ram.e("FaceLayer", "has max face count. add face failed.");
    } while (this.jdField_a_of_type_Rft$c == null);
    this.jdField_a_of_type_Rft$c.xj(50);
    return false;
    ram.a("FaceLayer", "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramd);
    rft.d locald = rft.d.a(paramd);
    int i = (int)(locald.width * locald.scale);
    int j = (int)(locald.height * locald.scale);
    float f2 = locald.centerP.x;
    float f3 = locald.centerP.y;
    float f1 = f2;
    if (f2 - i / 2 < this.drawRect.left) {
      f1 = this.drawRect.left + i / 2;
    }
    f2 = f1;
    if (i / 2 + f1 > this.drawRect.right) {
      f2 = this.drawRect.right - i / 2;
    }
    f1 = f3;
    if (f3 - j / 2 < this.drawRect.top) {
      f1 = this.drawRect.top + j / 2;
    }
    f3 = f1;
    if (j / 2 + f1 > this.drawRect.bottom) {
      f3 = this.drawRect.bottom - j / 2;
    }
    locald.centerP.x = f2;
    locald.centerP.y = f3;
    ram.a("FaceLayer", "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramd);
    if (TextUtils.isEmpty(locald.text))
    {
      ram.d("FaceLayer", "Create Normal FaceItem.");
      paramString1 = new rft.b(paramDrawable, locald, paramString1, paramString2);
      this.oJ.add(paramString1);
      super.notifyChange();
      if (!(paramString1 instanceof rft.a)) {
        break label445;
      }
      this.oK.add((rft.a)paramString1);
    }
    for (;;)
    {
      return true;
      ram.d("FaceLayer", "Create FaceAndTextItem with text:" + locald.text);
      paramString1 = new rft.a(paramDrawable, locald, paramString1, paramString2);
      ((rft.a)paramString1).btN();
      break;
      label445:
      paramd = this.gg;
      paramDrawable = (List)paramd.get(paramString1.category);
      paramString2 = paramDrawable;
      if (paramDrawable == null)
      {
        paramString2 = new ArrayList();
        paramd.put(paramString1.category, paramString2);
      }
      paramString2.add(paramString1.name);
    }
  }
  
  protected void an(Canvas paramCanvas)
  {
    Iterator localIterator = this.oJ.iterator();
    while (localIterator.hasNext()) {
      a((rft.b)localIterator.next(), paramCanvas);
    }
  }
  
  public void ao(Canvas paramCanvas)
  {
    b(paramCanvas, this.scaleValue);
  }
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.oJ.iterator();
    while (localIterator.hasNext())
    {
      rft.b localb = (rft.b)localIterator.next();
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Riy.a(localb));
      localb.a(paramCanvas, false);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  public void btM()
  {
    rft.b localb;
    if ((this.oJ != null) && (!this.oJ.isEmpty()))
    {
      localb = (rft.b)this.oJ.remove(this.oJ.size() - 1);
      if (!(localb instanceof rft.a)) {
        break label80;
      }
      DoodleLayout.sx("delete_poi");
      ras.so("0X80076D2");
      ras.sp("0X80075E7");
      this.oK.remove(localb);
    }
    label80:
    List localList;
    do
    {
      do
      {
        return;
        DoodleLayout.sx("delete_oneface");
        ras.so("0X80076CB");
        ras.sp("0X80075E0");
        localList = (List)this.gg.get(localb.category);
      } while (localList == null);
      localList.remove(localb.name);
    } while (!localList.isEmpty());
    this.gg.remove(localb.category);
  }
  
  public Rect c(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_Rft$b != null)
    {
      int i = (int)(this.jdField_a_of_type_Rft$b.width * this.jdField_a_of_type_Rft$b.scaleValue);
      paramRect.set(0, 0, i, i);
    }
    return paramRect;
  }
  
  public void clear()
  {
    this.oJ.clear();
    this.jdField_a_of_type_Rft$b = null;
    this.jdField_a_of_type_Riy.reset();
    ram.d("FaceLayer", "clear over.");
  }
  
  public String getTag()
  {
    return "FaceLayer";
  }
  
  public boolean isEmpty()
  {
    return (this.oJ == null) || (this.oJ.isEmpty());
  }
  
  public int tp()
  {
    if (this.oJ == null) {}
    for (int i = 0;; i = this.oJ.size())
    {
      ram.d("FaceLayer", "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public int[] z()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Iterator localIterator = this.oJ.iterator();
    while (localIterator.hasNext()) {
      if (((rft.b)localIterator.next() instanceof rft.a)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public final class a
    extends rft.b
  {
    StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
    final String aAw = "...";
    String aAx;
    boolean aHB;
    int bqP;
    Path dashPath = new Path();
    int lineHeight;
    String text;
    int textColor;
    int textSize;
    
    public a(@NonNull Drawable paramDrawable, @NonNull rft.d paramd, String paramString1, String paramString2)
    {
      super(paramDrawable, paramd, paramString1, paramString2);
      this.textSize = paramd.textSize;
      this.textColor = paramd.textColor;
      setText(paramd.text);
      this.bsp = rpq.dip2px(BaseApplicationImpl.getContext(), 7.5F);
    }
    
    public void a(Canvas paramCanvas, boolean paramBoolean)
    {
      float f2 = this.width;
      float f1 = this.height;
      if (f2 * this.scaleValue < 200.0F) {
        f2 = 200.0F / this.scaleValue;
      }
      if (this.scaleValue * f1 < 200.0F) {
        f1 = 200.0F / this.scaleValue;
      }
      paramCanvas.save();
      paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
      if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
        paramCanvas.translate(0.0F, this.lineHeight);
      }
      this.drawable.draw(paramCanvas);
      paramCanvas.translate(0.0F, this.X.height());
      paramCanvas.save();
      paramCanvas.translate(6.0F, 16.0F);
      rft.this.mTextPaint.setTextSize(this.textSize);
      rft.this.mTextPaint.setColor(this.textColor);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      if (paramBoolean)
      {
        paramCanvas.save();
        paramCanvas.translate(0.0F, 10.0F);
        if (this.aHB)
        {
          rft.this.aX.setAlpha(this.bqP);
          paramCanvas.drawPath(this.dashPath, rft.this.aX);
        }
        paramCanvas.restore();
      }
      paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 32);
      rft.this.di.setBounds(0, 0, (int)this.width, 6);
      rft.this.di.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public void btN()
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
      localValueAnimator.setDuration(1000L);
      localValueAnimator.setRepeatCount(2);
      localValueAnimator.setRepeatMode(2);
      localValueAnimator.addUpdateListener(new rfu(this));
      localValueAnimator.addListener(new rfv(this));
      localValueAnimator.start();
    }
    
    public void draw(Canvas paramCanvas)
    {
      paramCanvas.save();
      paramCanvas.concat(rft.this.a.a(this));
      paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
      if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
        paramCanvas.translate(0.0F, this.lineHeight);
      }
      this.drawable.draw(paramCanvas);
      paramCanvas.translate(0.0F, this.X.height());
      paramCanvas.save();
      paramCanvas.translate(6.0F, 16.0F);
      rft.this.mTextPaint.setTextSize(this.textSize);
      rft.this.mTextPaint.setColor(this.textColor);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(0.0F, 10.0F);
      if (this.aHB)
      {
        rft.this.aX.setAlpha(this.bqP);
        paramCanvas.drawPath(this.dashPath, rft.this.aX);
      }
      paramCanvas.restore();
      paramCanvas.translate(0.0F, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 32);
      rft.this.di.setBounds(0, 0, (int)this.width, 6);
      rft.this.di.draw(paramCanvas);
      paramCanvas.restore();
      if (this.aIp) {
        riw.a(paramCanvas, rft.this.a, this, 0, 2130845494, 2130845501);
      }
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public void setText(String paramString)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        ram.e("FaceLayer", "text is empty.");
        str = "";
      }
      ram.d("FaceLayer", "text:" + str);
      this.aAx = str;
      this.text = str;
      int j = (int)(this.width - 12.0F);
      rft.this.mTextPaint.setTextSize(this.textSize);
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.aAx, rft.this.mTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 2)
      {
        int i = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(1);
        paramString = this.aAx.substring(0, i);
        ram.d("FaceLayer", "subString : " + this.aAx + " -> " + paramString);
        this.aAx = paramString;
        i = this.aAx.length();
        this.aAx += "...";
        this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.aAx, rft.this.mTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        i -= 1;
        while ((i > 0) && (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 2))
        {
          paramString = this.aAx.substring(0, i) + "...";
          ram.d("FaceLayer", "delete last char : " + this.aAx + " -> " + paramString);
          this.aAx = paramString;
          this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.aAx, rft.this.mTextPaint, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
          i -= 1;
        }
        if (i == 0) {
          ram.e("FaceLayer", "text size is too large :" + this.textSize);
        }
      }
      ram.d("FaceLayer", "final text : " + this.aAx + " , original text : " + this.text);
      paramString = new Rect();
      this.jdField_a_of_type_AndroidTextStaticLayout.getLineBounds(0, paramString);
      this.lineHeight = paramString.height();
      this.dashPath.reset();
      this.dashPath.addRoundRect(new RectF(0.0F, 0.0F, this.width, this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 12), 4.0F, 4.0F, Path.Direction.CCW);
    }
  }
  
  public class b
    extends riy.a
  {
    public final RectF X;
    public final String category;
    public final Drawable drawable;
    public final String name;
    
    public b(@NonNull Drawable paramDrawable, @NonNull rft.d paramd, String paramString1, String paramString2)
    {
      super(paramd.scale, paramd.rotate, paramd.translateXValue, paramd.translateYValue, paramd.width, paramd.height, true);
      this.drawable = paramDrawable;
      this.category = paramString1;
      this.name = paramString2;
      this.X = new RectF(paramDrawable.getBounds());
    }
    
    public void a(Canvas paramCanvas, boolean paramBoolean)
    {
      float f2 = this.width;
      float f1 = this.height;
      if (f2 * this.scaleValue < 200.0F) {
        f2 = 200.0F / this.scaleValue;
      }
      if (this.scaleValue * f1 < 200.0F) {
        f1 = 200.0F / this.scaleValue;
      }
      paramCanvas.save();
      paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
      this.drawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public void cancelAnimator()
    {
      if ((this.N != null) && (this.aIo)) {
        this.N.cancel();
      }
    }
    
    public void draw(Canvas paramCanvas)
    {
      float f2 = this.width;
      float f1 = this.height;
      if (f2 * this.scaleValue < 200.0F) {
        f2 = 200.0F / this.scaleValue;
      }
      if (this.scaleValue * f1 < 200.0F) {
        f1 = 200.0F / this.scaleValue;
      }
      paramCanvas.save();
      paramCanvas.concat(rft.this.a.a(this));
      paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
      this.drawable.draw(paramCanvas);
      paramCanvas.restore();
      if (this.aIp) {
        riw.a(paramCanvas, rft.this.a, this, 0, 2130845494, 2130845501);
      }
    }
    
    public void startAnimator()
    {
      if (this.N == null)
      {
        this.N = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
        this.N.setDuration(200L);
        this.N.setInterpolator(new LinearInterpolator());
        this.N.addUpdateListener(new rfw(this));
        this.N.addListener(new rfx(this));
      }
      if (!this.aIo) {
        this.N.start();
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(rft.a parama);
    
    public abstract boolean a(rft.b paramb);
    
    public abstract void xj(int paramInt);
  }
  
  public static class d
  {
    public final PointF centerP;
    public final int height;
    public final float rotate;
    public final float scale;
    public final String text;
    public final int textColor;
    public final int textSize;
    public final float translateXValue;
    public final float translateYValue;
    public final int width;
    
    public d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2)
    {
      this.centerP = new PointF(paramFloat1, paramFloat2);
      this.scale = paramFloat3;
      this.rotate = paramFloat4;
      this.translateXValue = paramFloat5;
      this.translateYValue = paramFloat6;
      this.width = paramInt1;
      this.height = paramInt2;
      this.text = "";
      this.textColor = -1;
      this.textSize = 0;
    }
    
    public d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      this.centerP = new PointF(paramFloat1, paramFloat2);
      this.scale = paramFloat3;
      this.rotate = paramFloat4;
      this.translateXValue = paramFloat5;
      this.translateYValue = paramFloat6;
      this.width = paramInt1;
      this.height = paramInt2;
      this.text = paramString;
      this.textColor = paramInt3;
      this.textSize = paramInt4;
    }
    
    public static d a(@NonNull d paramd)
    {
      return new d(paramd.centerP.x, paramd.centerP.y, paramd.scale, paramd.rotate, paramd.translateXValue, paramd.translateYValue, paramd.width, paramd.height, paramd.text, paramd.textColor, paramd.textSize);
    }
    
    public String toString()
    {
      return "LayerParams{centerP=" + this.centerP + ", scale=" + this.scale + ", rotate=" + this.rotate + ", translateXValue=" + this.translateXValue + ", translateYValue=" + this.translateYValue + ", width=" + this.width + ", height=" + this.height + ", text='" + this.text + '\'' + ", textColor=" + this.textColor + ", textSize=" + this.textSize + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rft
 * JD-Core Version:    0.7.0.1
 */