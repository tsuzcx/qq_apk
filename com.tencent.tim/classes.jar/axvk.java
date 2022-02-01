import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class axvk
  extends DynamicTextItem
{
  public static final int MAX_WIDTH;
  public static final int TEXT_SIZE;
  public static final int eIb;
  axvr a;
  int awd = 0;
  private String ayV = "05/09";
  private InputFilter jdField_b_of_type_AndroidTextInputFilter;
  axvr jdField_b_of_type_Axvr;
  private RectF bJ = new RectF();
  private RectF by = new RectF();
  axvr c;
  private String cWn = "by";
  private int eIf;
  private int eIg;
  private int eIh;
  private int eIi;
  private int eIj;
  private int eIk;
  private int eIl;
  private int eIm;
  private float mHeight;
  private String mNickname = "jenny";
  private TextPaint mPaint = new TextPaint();
  private float mWidth;
  private TextPaint w;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    TEXT_SIZE = wja.dp2px(18.0F, localResources);
    eIb = wja.dp2px(6.0F, localResources);
    int i = ayom.tw();
    MAX_WIDTH = localResources.getDisplayMetrics().widthPixels - ayjw.PADDING - i * 2;
  }
  
  public axvk(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.mPaint.setTypeface(Typeface.DEFAULT);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null)
    {
      this.mPaint.setTypeface(Typeface.defaultFromStyle(1));
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mPaint.setTextSkewX(-0.15F);
      this.eIk = wja.dp2px(41.0F, BaseApplicationImpl.getContext().getResources());
      this.mPaint.setTextSize(this.eIk);
      this.mPaint.setColor(-1);
      this.mPaint.setTextAlign(Paint.Align.LEFT);
      this.eIg = wja.dp2px(34.0F, BaseApplicationImpl.getContext().getResources());
      this.eIh = wja.dp2px(45.0F, BaseApplicationImpl.getContext().getResources());
      this.eIl = wja.dp2px(4.0F, BaseApplicationImpl.getContext().getResources());
      this.eIm = wja.dp2px(3.0F, BaseApplicationImpl.getContext().getResources());
      this.c = new axvr(0);
      this.c.a(new axvc(-1, this.eIl, this.eIm));
      this.w = new TextPaint();
      this.w.setTextSkewX(-0.15F);
      if (paramTypeface != null) {
        this.w.setTypeface(paramTypeface);
      }
      this.w.setAntiAlias(true);
      this.w.setStyle(Paint.Style.FILL_AND_STROKE);
      this.eIj = wja.dp2px(19.0F, BaseApplicationImpl.getContext().getResources());
      this.w.setTextSize(this.eIj);
      this.w.setColor(-16777216);
      TextPaint localTextPaint = new TextPaint();
      if (paramTypeface != null) {
        localTextPaint.setTypeface(paramTypeface);
      }
      this.ayV = axvz.getCurrentDate();
      localTextPaint.setAntiAlias(true);
      localTextPaint.setTextSkewX(-0.15F);
      localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.eIi = wja.dp2px(23.0F, BaseApplicationImpl.getContext().getResources());
      localTextPaint.setTextSize(this.eIi);
      localTextPaint.setColor(-1);
      this.jdField_b_of_type_Axvr = new axvr(0);
      this.jdField_b_of_type_Axvr.a(new axvc(-16777216, this.eIl, this.eIm));
      this.jdField_b_of_type_Axvr.a(this.ayV, MAX_WIDTH, this.eIi, localTextPaint);
      if (paramList != null) {
        break label541;
      }
    }
    label541:
    for (paramInt = 0;; paramInt = paramList.size())
    {
      int i = 0;
      while (i < paramInt)
      {
        setText(i, (String)paramList.get(i));
        i += 1;
      }
      this.mPaint.setTypeface(paramTypeface);
      break;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, RectF paramRectF, PointF paramPointF)
  {
    if ((paramRectF == null) || (paramPointF == null)) {}
    do
    {
      return false;
      paramRectF = new RectF(paramRectF.left + paramPointF.x, paramRectF.top + paramPointF.y, paramRectF.right + paramPointF.x, paramRectF.bottom + paramPointF.y);
    } while ((paramFloat1 <= paramRectF.left) || (paramFloat1 >= paramRectF.right) || (paramFloat2 <= paramRectF.top) || (paramFloat2 >= paramRectF.bottom));
    return true;
  }
  
  public int Rv()
  {
    return 2;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = paramFloat1 / getWidth();
    RectF localRectF1 = new RectF(this.bJ.left * f, this.bJ.top * f, this.bJ.right * f, this.bJ.bottom * f);
    RectF localRectF2 = new RectF(this.by.left * f, this.by.top * f, this.by.right * f, f * this.by.bottom);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 1;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 0;
    }
    return -1;
  }
  
  public int a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable ayjw.c paramc, ayoo paramayoo)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramc != null) {
      return paramayoo.a(paramc, f1, f2);
    }
    paramMotionEvent = new PointF((paramFloat1 - getWidth()) / 2.0F, (paramFloat2 - getHeight()) / 2.0F);
    if (a(f1, f2, this.bJ, paramMotionEvent)) {
      return 1;
    }
    if (a(f1, f2, this.by, paramMotionEvent)) {
      return 0;
    }
    return -1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_b_of_type_AndroidTextInputFilter == null) {
      this.jdField_b_of_type_AndroidTextInputFilter = new axvl(this, 20);
    }
    return this.jdField_b_of_type_AndroidTextInputFilter;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.mHeight;
  }
  
  public float getWidth()
  {
    return this.mWidth;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.awd = 0;
    this.a.l(paramCanvas, 0, this.awd);
    this.awd = ((int)(this.awd + this.a.ce()));
    this.awd += this.eIg;
    this.jdField_b_of_type_Axvr.l(paramCanvas, 0, this.awd);
    this.awd = ((int)(this.awd + this.jdField_b_of_type_Axvr.ce()));
    this.awd += this.eIh;
    this.c.l(paramCanvas, 0, this.awd);
    if (super.ou(1))
    {
      this.bJ.set(this.c.a(2, this.c.getLine()));
      RectF localRectF = this.bJ;
      localRectF.top += this.awd;
      localRectF = this.bJ;
      localRectF.bottom += this.awd;
      paramCanvas.drawRoundRect(this.bJ, 6.0F, 6.0F, k());
    }
    this.awd = ((int)(this.awd + this.c.ce()));
    if (super.ou(0))
    {
      this.bJ.left = 0.0F;
      this.by.top = 0.0F;
      this.by.right = this.a.cd();
      this.by.bottom = this.a.ce();
      paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt >= Rv())) {
      return;
    }
    super.setText(paramInt, paramString);
    String str = super.gW(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.eIf = wja.dp2px(18.0F, BaseApplicationImpl.getContext().getResources());
    if (paramInt == 0)
    {
      paramString = " " + paramString;
      this.a = new axvr(0);
      this.a.a(new axvc(-16777216, this.eIl, this.eIm));
      this.a.a(paramString, MAX_WIDTH, this.eIk, this.mPaint);
      this.mWidth = Math.max(this.a.cd(), this.jdField_b_of_type_Axvr.cd());
      this.mWidth = Math.max(this.c.cd(), this.mWidth);
      this.mHeight = (this.a.ce() + this.eIg + this.jdField_b_of_type_Axvr.ce() + this.eIh + this.c.ce());
      return;
    }
    if (paramString.length() > 18) {}
    for (this.mNickname = paramString.substring(0, 18);; this.mNickname = paramString)
    {
      this.c.a(this.cWn + "\n" + this.mNickname, MAX_WIDTH, this.eIj, this.w);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvk
 * JD-Core Version:    0.7.0.1
 */