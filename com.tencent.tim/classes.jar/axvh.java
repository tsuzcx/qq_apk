import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class axvh
  extends DynamicTextItem
{
  private InputFilter jdField_b_of_type_AndroidTextInputFilter;
  StaticLayout jdField_b_of_type_AndroidTextStaticLayout;
  private RectF by = new RectF();
  RectF bz = new RectF();
  private String cWf = "";
  public int eIe;
  Context mContext;
  TextPaint mPaint;
  private float mTextWidth;
  Random sRandom = new Random();
  public int[] tW = { 12, 20, 24 };
  
  public axvh(Context paramContext, int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.mContext = paramContext;
    this.eIe = sp2px(paramContext, 235.0F);
    this.mPaint = new TextPaint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTypeface(paramTypeface);
    this.mPaint.setTextSize(wja.dp2px(28.0F, paramContext.getResources()));
    this.mPaint.setColor(-1);
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
    }
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public String[] F(String paramString)
  {
    int i = 0;
    int j = 0;
    int k = paramString.length();
    String[] arrayOfString1;
    if (k <= 7)
    {
      arrayOfString2 = new String[k];
      i = j;
      for (;;)
      {
        arrayOfString1 = arrayOfString2;
        if (i >= k) {
          break;
        }
        arrayOfString2[i] = paramString.substring(i, i + 1);
        i += 1;
      }
    }
    String[] arrayOfString2 = new String[7];
    j = 0;
    for (;;)
    {
      arrayOfString1 = arrayOfString2;
      if (i >= 7) {
        break;
      }
      int m = this.sRandom.nextInt(k - (7 - i) + 1) + 1;
      k -= m;
      arrayOfString2[i] = paramString.substring(j, j + m);
      j += m;
      i += 1;
    }
    return arrayOfString1;
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public int Rw()
  {
    return 0;
  }
  
  public InputFilter a()
  {
    if (this.jdField_b_of_type_AndroidTextInputFilter == null) {
      this.jdField_b_of_type_AndroidTextInputFilter = new axvj(this, 20);
    }
    return this.jdField_b_of_type_AndroidTextInputFilter;
  }
  
  public CharSequence a(String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("“");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(paramArrayOfString[i]);
      i += 1;
    }
    ((StringBuilder)localObject).append("”");
    paramArrayOfString = c(paramArrayOfString);
    paramArrayOfString.add(0, Integer.valueOf(48));
    paramArrayOfString.add(Integer.valueOf(48));
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    j = ((SpannableString)localObject).length();
    i = 1;
    while (i < j - 1)
    {
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(wja.dp2px(((Integer)paramArrayOfString.get(i)).intValue(), this.mContext.getResources())), i, i + 1, 33);
      i += 1;
    }
    return localObject;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public ArrayList<Integer> c(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.tW;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList2.add(Integer.valueOf(localObject[i]));
      i += 1;
    }
    Collections.shuffle(localArrayList2);
    int m = paramArrayOfString.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      localObject = paramArrayOfString[j];
      Integer localInteger = (Integer)localArrayList2.get(i % localArrayList2.size());
      int n = ((String)localObject).length();
      int k = 0;
      if (k < n)
      {
        int i1 = ((String)localObject).charAt(k);
        if ((i1 == 8220) || (i1 == 8221)) {
          localArrayList1.add(Integer.valueOf(48));
        }
        for (;;)
        {
          k += 1;
          break;
          localArrayList1.add(localInteger);
        }
      }
      j += 1;
      i += 1;
    }
    return localArrayList1;
  }
  
  public float getHeight()
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null) {
      return this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
    }
    return 0.0F;
  }
  
  public float getWidth()
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null) {
      return this.jdField_b_of_type_AndroidTextStaticLayout.getWidth();
    }
    return 0.0F;
  }
  
  public boolean isEmpty()
  {
    return (TextUtils.isEmpty(this.cWf)) || (super.isEmpty());
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, 0.0F);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.ou(0))
      {
        int i = wja.dp2px(5.0F, this.mContext.getResources());
        this.by.left = i;
        this.by.top = (-i);
        this.by.right = (getWidth() + i);
        RectF localRectF = this.by;
        float f = getHeight();
        localRectF.bottom = (i + f);
        paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
      }
      paramCanvas.restore();
    }
  }
  
  @TargetApi(18)
  public void setText(int paramInt, String paramString)
  {
    float f = 0.0F;
    int i = 0;
    if ((TextUtils.equals(super.getText(0), paramString)) && (this.jdField_b_of_type_AndroidTextStaticLayout != null)) {
      return;
    }
    super.setText(paramInt, paramString);
    paramString = super.a(paramInt, new axvi(this));
    this.cWf = paramString;
    if (0 == 0) {}
    for (paramString = F(paramString);; paramString = null)
    {
      paramString = a(paramString);
      this.jdField_b_of_type_AndroidTextStaticLayout = axvp.create(paramString, 0, paramString.length(), this.mPaint, this.eIe, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 3);
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() >= 3)
      {
        paramInt = this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(2);
        paramString = paramString.subSequence(0, paramInt - 1) + "”";
        this.jdField_b_of_type_AndroidTextStaticLayout = axvp.create(paramString, 0, paramString.length(), this.mPaint, this.eIe, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 3);
      }
      int j = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
      paramInt = i;
      while (paramInt < j)
      {
        f = Math.max(f, this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
        paramInt += 1;
      }
      this.mTextWidth = f;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvh
 * JD-Core Version:    0.7.0.1
 */