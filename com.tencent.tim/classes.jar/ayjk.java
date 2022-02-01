import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
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
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ayjk
  extends aykd
{
  public static final String TAG = ayjk.class.getSimpleName();
  public List<ayjk.a> Ny = new ArrayList();
  public ayjk.a a;
  private ayjk.b jdField_a_of_type_Ayjk$b;
  private ayoo jdField_a_of_type_Ayoo;
  public boolean aHA;
  public Paint aV;
  public Paint aW;
  public boolean dzy;
  private boolean isVisible = true;
  public int mStartX;
  public int mStartY;
  public TextPaint mTextPaint;
  private String tag = TAG;
  
  public ayjk(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    init();
  }
  
  public ayjk(DoodleView paramDoodleView, String paramString)
  {
    this(paramDoodleView);
    this.tag = paramString;
  }
  
  private boolean Ln()
  {
    return tp() == 10;
  }
  
  private void M(MotionEvent paramMotionEvent)
  {
    if (z(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.Ny.remove(this.jdField_a_of_type_Ayjk$a);
      this.Ny.add(this.jdField_a_of_type_Ayjk$a);
    }
  }
  
  private void N(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Ayjk$a = null;
    this.jdField_a_of_type_Ayoo.reset();
    notifyChange();
    tJ(false);
  }
  
  private void a(ayjk.a parama, Canvas paramCanvas)
  {
    ram.i(TAG, "drawItem start.");
    if (parama == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Ayoo.a(parama));
    parama.a(paramCanvas, true);
    paramCanvas.restore();
    ram.i(TAG, "drawItem end.");
  }
  
  private void click()
  {
    ram.d(TAG, "click the item:" + this.jdField_a_of_type_Ayjk$a);
    if ((this.jdField_a_of_type_Ayjk$b != null) && (this.jdField_a_of_type_Ayjk$a != null)) {
      this.jdField_a_of_type_Ayjk$b.a(this.jdField_a_of_type_Ayjk$a);
    }
  }
  
  private void eRZ()
  {
    if (this.jdField_a_of_type_Ayjk$a == null) {
      return;
    }
    ram.d(TAG, "before limit translate value. translateXValue = %f, translateYValue = %f.", Float.valueOf(this.jdField_a_of_type_Ayjk$a.translateXValue), Float.valueOf(this.jdField_a_of_type_Ayjk$a.translateYValue));
    float f5 = this.jdField_a_of_type_Ayjk$a.centerP.x + this.jdField_a_of_type_Ayjk$a.translateXValue;
    float f4 = this.jdField_a_of_type_Ayjk$a.centerP.y + this.jdField_a_of_type_Ayjk$a.translateYValue;
    float f1 = this.jdField_a_of_type_Ayjk$a.translateXValue;
    float f3 = this.jdField_a_of_type_Ayjk$a.translateYValue;
    if (f5 - this.jdField_a_of_type_Ayjk$a.width / 2.0F < this.drawRect.left) {
      f1 = this.jdField_a_of_type_Ayjk$a.width / 2.0F - this.jdField_a_of_type_Ayjk$a.centerP.x;
    }
    float f2 = f1;
    if (f5 + this.jdField_a_of_type_Ayjk$a.width / 2.0F > this.drawRect.right) {
      f2 = this.drawRect.right - this.jdField_a_of_type_Ayjk$a.width / 2.0F - this.jdField_a_of_type_Ayjk$a.centerP.x;
    }
    f1 = f3;
    if (f4 - this.jdField_a_of_type_Ayjk$a.height / 2.0F < this.drawRect.top) {
      f1 = this.jdField_a_of_type_Ayjk$a.height / 2.0F - this.jdField_a_of_type_Ayjk$a.centerP.y;
    }
    if (this.jdField_a_of_type_Ayjk$a.height / 2.0F + f4 > this.drawRect.bottom) {
      f1 = this.drawRect.bottom - this.jdField_a_of_type_Ayjk$a.height / 2.0F - this.jdField_a_of_type_Ayjk$a.centerP.y;
    }
    this.jdField_a_of_type_Ayjk$a.translateXValue = f2;
    this.jdField_a_of_type_Ayjk$a.translateYValue = f1;
    ram.d(TAG, "after limit translate value. translateXValue = %f, translateYValue = %f.", Float.valueOf(this.jdField_a_of_type_Ayjk$a.translateXValue), Float.valueOf(this.jdField_a_of_type_Ayjk$a.translateYValue));
  }
  
  private void init()
  {
    this.jdField_a_of_type_Ayoo = new ayoo();
    this.jdField_a_of_type_Ayoo.tP(true);
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    this.mTextPaint.setStyle(Paint.Style.FILL);
    this.mTextPaint.setTypeface(Typeface.DEFAULT);
    this.aW = new Paint();
    this.aW.setAntiAlias(true);
    this.aW.setStyle(Paint.Style.STROKE);
    this.aW.setColor(-16711936);
    this.aW.setStrokeWidth(2.0F);
    this.aI.setStrokeWidth(2.0F);
    this.aV = new Paint();
    this.aV.setAntiAlias(true);
    this.aV.setStyle(Paint.Style.STROKE);
    this.aV.setColor(-65536);
    this.aV.setStrokeWidth(2.0F);
  }
  
  private boolean z(float paramFloat1, float paramFloat2)
  {
    int i = this.Ny.size() - 1;
    while (i >= 0)
    {
      ayjk.a locala = (ayjk.a)this.Ny.get(i);
      if (this.jdField_a_of_type_Ayoo.a(locala, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_Ayjk$a = locala;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int k = (int)paramMotionEvent.getX();
    int j = Math.abs(k - this.mStartX);
    int m = Math.abs(i - this.mStartY);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Ayoo.a(paramMotionEvent, false);
      eRZ();
      return true;
      this.mStartX = k;
      this.mStartY = i;
      this.aHA = false;
      M(paramMotionEvent);
      if (this.jdField_a_of_type_Ayjk$a != null)
      {
        this.jdField_a_of_type_Ayoo.l(this.jdField_a_of_type_Ayjk$a);
        continue;
        if (m > 5)
        {
          i = 1;
          label133:
          if (j <= 5) {
            break label159;
          }
        }
        label159:
        for (j = 1; (j | i) != 0; j = 0)
        {
          this.aHA = true;
          break;
          i = 0;
          break label133;
        }
        if ((!this.aHA) && ((this.jdField_a_of_type_Ayjk$a instanceof ayjk.a))) {
          click();
        }
        N(paramMotionEvent);
      }
    }
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    if (this.dzy) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.Ny.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (ayjk.a)this.Ny.get(i);
      if (this.jdField_a_of_type_Ayoo.a(paramMotionEvent, f1, f2, false)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public String Ir()
  {
    if ((this.Ny == null) || (this.Ny.isEmpty())) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.Ny.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((ayjk.a)localIterator.next()).toJsonObject());
    }
    ram.i(TAG, "AtLayer getAtJsonArray:" + localJSONArray.toString());
    return localJSONArray.toString();
  }
  
  public void a(ayjk.b paramb)
  {
    this.jdField_a_of_type_Ayjk$b = paramb;
  }
  
  public boolean a(String paramString1, Drawable paramDrawable, String paramString2, String paramString3, ayjk.c paramc, PointF paramPointF)
  {
    if (paramDrawable == null) {
      ram.e(TAG, "addAtItem faceDrawable is null.");
    }
    do
    {
      return false;
      if (paramc == null)
      {
        ram.e(TAG, "addAtItem params is null.");
        return false;
      }
      if (!Ln()) {
        break;
      }
      ram.e(TAG, "has max at count. add at failed.");
    } while (this.jdField_a_of_type_Ayjk$b == null);
    this.jdField_a_of_type_Ayjk$b.xj(10);
    return false;
    ram.b(TAG, "addAtItem before, faceDrawable : %s , remark : %s , LayerParams : %s", paramDrawable, paramString2, paramc);
    ayjk.c localc = ayjk.c.a(paramc);
    PointF localPointF = paramPointF;
    if (paramPointF == null) {
      localPointF = f();
    }
    localc.centerP = localPointF;
    int i = (int)(localc.width * localc.scale);
    int j = (int)(localc.height * localc.scale);
    float f2 = localc.centerP.x;
    float f3 = localc.centerP.y;
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
    localc.centerP.x = f2;
    localc.centerP.y = f3;
    ram.b(TAG, "addAtItem after, faceDrawable : %s , remark : %s , LayerParams : %s", paramDrawable, paramString2, paramc);
    ram.i(TAG, "Create AtItem.");
    paramString1 = new ayjk.a(paramString1, paramDrawable, paramString2, paramString3, localc);
    ram.d(TAG, "before add item to list. size = %d.", Integer.valueOf(this.Ny.size()));
    this.Ny.add(paramString1);
    ram.d(TAG, "after add item to list. size = %d.", Integer.valueOf(this.Ny.size()));
    notifyChange();
    return true;
  }
  
  public boolean aN(long paramLong)
  {
    return true;
  }
  
  protected void an(Canvas paramCanvas)
  {
    if (this.isVisible)
    {
      Iterator localIterator = this.Ny.iterator();
      while (localIterator.hasNext()) {
        a((ayjk.a)localIterator.next(), paramCanvas);
      }
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
    Iterator localIterator = this.Ny.iterator();
    while (localIterator.hasNext())
    {
      ayjk.a locala = (ayjk.a)localIterator.next();
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Ayoo.a(locala));
      locala.a(paramCanvas, false);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  public void clear()
  {
    this.Ny.clear();
    this.jdField_a_of_type_Ayjk$a = null;
    this.jdField_a_of_type_Ayoo.reset();
    ram.d(TAG, "clear over.");
  }
  
  public void eRY()
  {
    if ((this.Ny != null) && (!this.Ny.isEmpty()))
    {
      ram.d(TAG, "before remove item from list. size = %d.", Integer.valueOf(this.Ny.size()));
      this.Ny.remove(this.Ny.size() - 1);
      ram.d(TAG, "after remove item from list. size = %d.", Integer.valueOf(this.Ny.size()));
      notifyChange();
    }
  }
  
  public PointF f()
  {
    PointF localPointF = new PointF();
    if ((this.Ny == null) || (this.Ny.isEmpty()))
    {
      localPointF.x = (this.drawRect.width() / 2);
      localPointF.y = (this.drawRect.height() / 2);
      ram.d(TAG, "get default center pointer in doodle center. x = %f, y = %f.", Float.valueOf(localPointF.x), Float.valueOf(localPointF.y));
      ram.d(TAG, "get default center pointer. x = %f, y = %f.", Float.valueOf(localPointF.x), Float.valueOf(localPointF.y));
      return localPointF;
    }
    float f = this.drawRect.height();
    Iterator localIterator = this.Ny.iterator();
    label122:
    if (localIterator.hasNext())
    {
      ayjk.a locala = (ayjk.a)localIterator.next();
      if ((locala.translateXValue != 0.0F) || (locala.translateYValue != 0.0F) || (locala.centerP.y > f)) {
        break label253;
      }
      f = locala.centerP.y;
    }
    label253:
    for (;;)
    {
      break label122;
      if (f == this.drawRect.height()) {}
      for (f = this.drawRect.height() / 2;; f -= wja.dp2px(40.0F, this.context.getResources()))
      {
        localPointF.x = (this.drawRect.width() / 2);
        localPointF.y = f;
        break;
      }
    }
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  @NonNull
  public List<String> hX()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.Ny == null) || (this.Ny.isEmpty())) {
      return localArrayList;
    }
    Iterator localIterator = this.Ny.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ayjk.a)localIterator.next()).uin);
    }
    return localArrayList;
  }
  
  public boolean isEmpty()
  {
    return tp() == 0;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
  }
  
  public int tp()
  {
    if (this.Ny == null) {}
    for (int i = 0;; i = this.Ny.size())
    {
      ram.d(TAG, "getDoodleCount:" + i);
      return i;
    }
  }
  
  public boolean uo(String paramString)
  {
    if ((this.Ny == null) || (this.Ny.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.Ny.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((ayjk.a)localIterator.next()).uin, paramString))
      {
        ram.e(TAG, "add repeated uin.");
        return true;
      }
    }
    return false;
  }
  
  public void y(int paramInt, float paramFloat)
  {
    if (this.jdField_a_of_type_Ayjk$a == null) {
      return;
    }
    this.jdField_a_of_type_Ayjk$a.direction = paramInt;
    this.jdField_a_of_type_Ayjk$a.translateXValue = paramFloat;
    notifyChange();
  }
  
  public class a
    extends ayoo.a
  {
    StaticLayout a;
    RectF bO;
    Rect bb;
    Drawable cp;
    public int direction;
    Bitmap hE;
    Bitmap hF;
    String name;
    public String remark;
    int textColor;
    int textSize;
    public String uin;
    
    public a(@NonNull String paramString1, @NonNull Drawable paramDrawable, @NonNull String paramString2, @NonNull String paramString3, @NonNull ayjk.c paramc)
    {
      super(paramc.scale, paramc.rotate, paramc.translateXValue, paramc.translateYValue, paramc.width, paramc.height, false);
      this.direction = paramc.direction;
      try
      {
        this.hE = BitmapFactory.decodeResource(ayjk.this.context.getResources(), 2130847270);
        this.hF = BitmapFactory.decodeResource(ayjk.this.context.getResources(), 2130847271);
        this.bb = new Rect(0, 0, (int)this.width, (int)this.height);
        this.uin = paramString1;
        this.cp = paramDrawable;
        this.bO = new RectF(paramDrawable.getBounds());
        this.remark = paramString2;
        this.name = paramString3;
        this.textSize = paramc.textSize;
        this.textColor = paramc.textColor;
        return;
      }
      catch (OutOfMemoryError this$1)
      {
        for (;;)
        {
          ram.e(ayjk.TAG, "BitmapFactory.decodeResource outOfMemoryError : %s.", ayjk.this);
        }
      }
    }
    
    public void a(Canvas paramCanvas, boolean paramBoolean)
    {
      ram.i(ayjk.TAG, "AtItem draw start.");
      paramCanvas.save();
      paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
      NinePatch localNinePatch;
      if (this.direction == 0)
      {
        localNinePatch = new NinePatch(this.hE, this.hE.getNinePatchChunk(), null);
        localNinePatch.draw(paramCanvas, this.bb);
        paramCanvas.restore();
        paramCanvas.save();
        float f2 = (this.height - this.bO.height()) / 2.0F;
        if (this.direction != 0) {
          break label343;
        }
        paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
        f1 = wja.dp2px(10.0F, ayjk.this.context.getResources());
        label136:
        paramCanvas.translate(f1, f2);
        this.cp.draw(paramCanvas);
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
        if (this.direction != 0) {
          break label381;
        }
      }
      label343:
      label381:
      for (float f1 = wja.dp2px(36.0F, ayjk.this.context.getResources());; f1 = wja.dp2px(8.0F, ayjk.this.context.getResources()))
      {
        ayjk.this.mTextPaint.setTextSize(this.textSize);
        ayjk.this.mTextPaint.setColor(this.textColor);
        int i = (int)ayjk.this.mTextPaint.measureText(this.remark);
        this.a = new StaticLayout(this.remark, ayjk.this.mTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        paramCanvas.translate(f1, (this.height - this.a.getHeight()) / 2.0F);
        this.a.draw(paramCanvas);
        paramCanvas.restore();
        ram.i(ayjk.TAG, "AtItem draw end.");
        return;
        localNinePatch = new NinePatch(this.hF, this.hF.getNinePatchChunk(), null);
        break;
        paramCanvas.translate(this.width / 2.0F, -this.height / 2.0F);
        f1 = -wja.dp2px(30.0F, ayjk.this.context.getResources());
        break label136;
      }
    }
    
    public JSONObject toJsonObject()
    {
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("u", this.uin);
          localJSONObject.put("n", this.name);
          localJSONObject.put("o", this.direction);
          if (this.direction != 0) {
            continue;
          }
          i = (int)((this.centerP.x + this.translateXValue - this.width / 2.0F) / ayjk.this.drawRect.width() * 1000.0F);
          int j = (int)((this.centerP.y + this.translateYValue) / ayjk.this.drawRect.height() * 1000.0F);
          localJSONObject.put("x", i);
          localJSONObject.put("y", j);
        }
        catch (JSONException localJSONException)
        {
          int i;
          float f1;
          float f2;
          float f3;
          localJSONException.printStackTrace();
          continue;
        }
        ram.i(ayjk.TAG, "AtItem toJsonObject:" + localJSONObject.toString());
        return localJSONObject;
        f1 = this.centerP.x;
        f2 = this.translateXValue;
        f3 = this.width / 2.0F;
        i = ayjk.this.drawRect.width();
        i = (int)((f1 + f2 + f3) / i * 1000.0F);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ayjk.a parama);
    
    public abstract void xj(int paramInt);
  }
  
  public static class c
  {
    public PointF centerP;
    public int direction;
    public int height;
    public float rotate;
    public float scale;
    public int textColor;
    public int textSize;
    public float translateXValue;
    public float translateYValue;
    public int width;
    
    public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this(new PointF(0.0F, 0.0F), 1.0F, 0.0F, 0.0F, 0.0F, paramInt1, paramInt2, paramInt5, paramInt3, paramInt4);
    }
    
    public c(PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.centerP = paramPointF;
      this.scale = paramFloat1;
      this.rotate = paramFloat2;
      this.translateXValue = paramFloat3;
      this.translateYValue = paramFloat4;
      this.width = paramInt1;
      this.height = paramInt2;
      this.direction = paramInt3;
      this.textColor = paramInt4;
      this.textSize = paramInt5;
    }
    
    public static c a(@NonNull c paramc)
    {
      return new c(paramc.centerP, paramc.scale, paramc.rotate, paramc.translateXValue, paramc.translateYValue, paramc.width, paramc.height, paramc.direction, paramc.textColor, paramc.textSize);
    }
    
    public String toString()
    {
      return "LayerParams{centerP=" + this.centerP + ", scale=" + this.scale + ", rotate=" + this.rotate + ", translateXValue=" + this.translateXValue + ", translateYValue=" + this.translateYValue + ", width=" + this.width + ", height=" + this.height + ", textColor=" + this.textColor + ", textSize=" + this.textSize + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjk
 * JD-Core Version:    0.7.0.1
 */