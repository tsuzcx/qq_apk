import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axuj
  extends DynamicTextItem
{
  private static final float EP;
  private static final int MAX_WIDTH;
  private static Method Z;
  private static final int[] tU = { 5, 5, 5, 5 };
  private float EM;
  private float EN;
  private float EO;
  private List<Float> Nn;
  private Shader jdField_b_of_type_AndroidGraphicsShader;
  private InputFilter jdField_b_of_type_AndroidTextInputFilter;
  private Bitmap bM;
  private RectF by = new RectF();
  private String cWf = "";
  private int eHw = Color.parseColor("#ffa414");
  private int eHx = Color.parseColor("#ff1a14");
  private int eHy = Color.parseColor("#1f14ff");
  private float mHeight;
  private TextPaint mTextPaint;
  private float mWidth;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    EP = wja.dp2px(2.0F, localResources);
    int i = ayom.tw();
    MAX_WIDTH = localResources.getDisplayMetrics().widthPixels - rgb.PADDING - i * 2;
  }
  
  public axuj(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
    }
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    this.EO = (localResources.getDisplayMetrics().density * 2.0F);
    this.Nn = new ArrayList();
    this.EM = wja.dp2px(25.0F, localResources);
    this.EN = wja.dp2px(3.0F, localResources);
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setTextSize(this.EM);
    this.mTextPaint.setAntiAlias(true);
    if (paramTypeface != null) {
      this.mTextPaint.setTypeface(paramTypeface);
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (Z == null) {
        Z = Paint.class.getDeclaredMethod("setLetterSpacing", new Class[] { Float.TYPE });
      }
      if (Z != null) {
        Z.invoke(this.mTextPaint, new Object[] { Float.valueOf(-0.09F) });
      }
    }
    catch (Exception paramTypeface)
    {
      label159:
      break label159;
    }
    if (paramBitmap != null)
    {
      this.bM = paramBitmap;
      this.jdField_b_of_type_AndroidGraphicsShader = new BitmapShader(this.bM, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }
  }
  
  private CharSequence d(String paramString)
  {
    int m = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int i = 0;
    int j = 0;
    if (j < paramString.length())
    {
      if ((paramString.charAt(j) != '\n') && (paramString.charAt(j) != '\r') && (i < tU[k]))
      {
        localStringBuilder.append(paramString.charAt(j));
        i += 1;
      }
      int n;
      do
      {
        j += 1;
        break;
        localStringBuilder.append('\n');
        if ((paramString.charAt(j) == '\n') || (paramString.charAt(j) == '\r')) {
          break label230;
        }
        localStringBuilder.append(paramString.charAt(j));
        i = 1;
        n = k + 1;
        k = n;
      } while (n < tU.length);
    }
    this.Nn.clear();
    paramString = new SpannableString(localStringBuilder.toString());
    i = 0;
    float f = 0.0F;
    j = m;
    label179:
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\n') || (paramString.charAt(i) == '\r'))
      {
        this.Nn.add(Float.valueOf(f));
        f = 0.0F;
      }
      for (;;)
      {
        i += 1;
        break label179;
        label230:
        i = 0;
        break;
        k = (int)(this.EM + j * this.EN);
        paramString.setSpan(new axtr(k, 0.85F), i, i + 1, 17);
        f += k;
        j += 1;
      }
    }
    this.Nn.add(Float.valueOf(f));
    return paramString;
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_b_of_type_AndroidTextInputFilter == null) {
      this.jdField_b_of_type_AndroidTextInputFilter = new axul(this, 20);
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
    return this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() + 3.0F * this.EO;
  }
  
  public boolean isEmpty()
  {
    return (TextUtils.isEmpty(this.cWf)) || (super.isEmpty());
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.EO * 2.0F, 0.0F);
    paramCanvas.save();
    this.mTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.translate(this.EO * -2.0F, this.EO * 3.0F);
    this.mTextPaint.setColor(this.eHy);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    this.mTextPaint.setColor(-16777216);
    this.mTextPaint.setStyle(Paint.Style.STROKE);
    this.mTextPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    this.mTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.translate(-this.EO, 1.5F * this.EO);
    this.mTextPaint.setColor(this.eHx);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    this.mTextPaint.setColor(-16777216);
    this.mTextPaint.setStyle(Paint.Style.STROKE);
    this.mTextPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    this.mTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.translate(0.0F, 0.0F);
    this.mTextPaint.setColor(this.eHw);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (this.jdField_b_of_type_AndroidGraphicsShader != null)
    {
      this.mTextPaint.setShader(this.jdField_b_of_type_AndroidGraphicsShader);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      this.mTextPaint.setShader(null);
    }
    this.mTextPaint.setColor(-16777216);
    this.mTextPaint.setStyle(Paint.Style.STROKE);
    this.mTextPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (ou(0))
    {
      int j = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
      int i = 0;
      float f1 = 0.0F;
      while (i < j)
      {
        f1 = Math.max(f1, this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(i));
        i += 1;
      }
      f1 = this.mWidth;
      float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      float f3 = this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
      this.by.left = (this.EO * -2.0F + f3 - f1 / 2.0F - EP);
      this.by.top = (0.0F - EP * 3.0F);
      this.by.right = (f1 / 2.0F + f3 + EP * 2.0F);
      this.by.bottom = (f2 + this.EO * 3.0F + EP * 2.0F);
      paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
    }
    paramCanvas.restore();
    paramCanvas.restore();
  }
  
  public void setText(int paramInt, String paramString)
  {
    super.setText(paramInt, paramString);
    paramString = a(paramInt, new axuk(this));
    this.cWf = paramString;
    int i = 0;
    Object localObject = tU;
    int j = localObject.length;
    paramInt = 0;
    while (paramInt < j)
    {
      i += localObject[paramInt];
      paramInt += 1;
    }
    if (paramString.length() > i) {
      paramString = paramString.substring(0, i);
    }
    for (;;)
    {
      localObject = d(paramString);
      Iterator localIterator = this.Nn.iterator();
      for (float f = 0.0F; localIterator.hasNext(); f = Math.max(((Float)localIterator.next()).floatValue(), f)) {}
      f = Math.min(MAX_WIDTH, f);
      this.jdField_b_of_type_AndroidTextStaticLayout = axvp.create((CharSequence)localObject, 0, ((CharSequence)localObject).length(), this.mTextPaint, (int)f, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, tU.length);
      localObject = paramString;
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 4)
      {
        paramInt = this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(3);
        localObject = paramString;
        if (paramInt > 0)
        {
          paramInt = Math.min(paramInt, paramString.length());
          localObject = paramString.substring(0, paramInt);
          if ((!((String)localObject).endsWith("\n")) && (!((String)localObject).endsWith("\r"))) {
            break label341;
          }
        }
      }
      label341:
      for (localObject = paramString.substring(0, paramInt - 1);; localObject = paramString.substring(0, paramInt))
      {
        paramString = d((String)localObject);
        this.jdField_b_of_type_AndroidTextStaticLayout = axvp.create(paramString, 0, paramString.length(), this.mTextPaint, (int)f, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, tU.length);
        this.mWidth = 0.0F;
        i = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
        paramInt = 0;
        while (paramInt < i)
        {
          this.mWidth = Math.max(this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt), this.mWidth);
          paramInt += 1;
        }
      }
      this.mHeight = (this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() + 3.0F * this.EO);
      this.mWidth += 2.0F * this.EO;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axuj
 * JD-Core Version:    0.7.0.1
 */