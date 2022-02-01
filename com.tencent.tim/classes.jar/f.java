import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class f
  extends k
  implements k.a
{
  protected int[] A;
  protected int[] B;
  private ArrayList<Integer> C;
  private List<q> D;
  private List<q> E;
  protected int[] G;
  protected int[] H;
  protected int[] J;
  private int[] K;
  private int[] L;
  private long V;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  protected Path a;
  private final ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private f.a jdField_a_of_type_F$a;
  private int aB;
  private int aC;
  private Canvas b;
  private boolean hasInit;
  private Paint j;
  protected Paint k;
  private int lineSpace;
  private boolean mMagicFont;
  protected int[] mTempLocation = new int[2];
  protected int paddingBottom;
  protected int paddingLeft;
  protected int paddingRight;
  protected int paddingTop;
  private int realHeight;
  private int realWidth;
  private List<List<q>> s;
  private int screenHeight;
  private int screenWidth;
  private List<q> t;
  private int[] v = new int[2];
  private int[] w;
  protected int[] y;
  protected int[] z;
  
  public f(View paramView, ETFont paramETFont)
  {
    this.mFont = paramETFont;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView);
    this.jdField_a_of_type_F$a = new f.a();
    this.c = new Canvas();
  }
  
  private boolean F()
  {
    int i1 = 1;
    int i;
    int m;
    label41:
    int n;
    if (this.realWidth - this.paddingLeft - this.paddingRight <= 0)
    {
      i = 1;
      if (this.realHeight - this.paddingTop - this.paddingBottom > 0) {
        break label101;
      }
      m = 1;
      if (this.realWidth - this.paddingLeft - this.paddingRight <= this.screenWidth) {
        break label106;
      }
      n = 1;
      label64:
      if (this.realHeight - this.paddingTop - this.paddingBottom <= this.screenHeight) {
        break label111;
      }
    }
    for (;;)
    {
      return n | 0x0 | i | m | i1;
      i = 0;
      break;
      label101:
      m = 0;
      break label41;
      label106:
      n = 0;
      break label64;
      label111:
      i1 = 0;
    }
  }
  
  private boolean G()
  {
    this.C.clear();
    if (!c(this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom)) {}
    while (this.D.size() <= 0) {
      return false;
    }
    int n = this.D.size();
    int m = 0;
    int i = 1;
    label70:
    if (m < n)
    {
      q localq = (q)this.D.get(m);
      this.y[m] = localq.jdField_a_of_type_Char;
      this.z[m] = localq.left;
      this.A[m] = localq.top;
      this.B[m] = localq.width;
      this.G[m] = localq.height;
      if (localq.type == 2) {
        break label169;
      }
      i = 0;
    }
    label169:
    for (;;)
    {
      m += 1;
      break label70;
      if (i != 0) {
        break;
      }
      return true;
    }
  }
  
  private void M()
  {
    if (this.b == null) {
      this.b = new Canvas(this.d);
    }
    for (;;)
    {
      if (this.j == null)
      {
        this.j = new Paint();
        this.j.setColor(-16777216);
      }
      int i = 2;
      while (i < this.L.length)
      {
        int m = this.L[i];
        int n = this.L[(i + 1)];
        int i1 = this.L[(i + 2)];
        int i2 = this.L[(i + 3)];
        i2 = this.L[(i + 4)];
        q localq = (q)this.D.get(m);
        this.j.setTextSize(i2);
        float f1 = i2 / 2.0F;
        float f2 = (this.j.descent() + this.j.ascent()) / 2.0F;
        this.b.drawText(String.valueOf(localq.jdField_a_of_type_Char), n, i1 + (f1 - f2), this.j);
        i += 5;
      }
      this.b.setBitmap(this.d);
    }
  }
  
  private void R()
  {
    if (this.hasInit) {
      return;
    }
    this.hasInit = true;
    if (this.s == null) {
      this.s = new ArrayList();
    }
    if (this.D == null) {
      this.D = new ArrayList();
    }
    if (this.t == null) {
      this.t = new ArrayList();
    }
    if (this.E == null) {
      this.E = new ArrayList();
    }
    if ((this.screenWidth <= 0) || (this.screenHeight <= 0))
    {
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getResources().getDisplayMetrics();
      this.screenWidth = localDisplayMetrics.widthPixels;
      this.screenHeight = localDisplayMetrics.heightPixels;
    }
    if (this.C == null) {
      this.C = new ArrayList();
    }
    this.paddingLeft = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft();
    this.paddingRight = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingRight();
    this.paddingTop = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
    this.paddingBottom = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingBottom();
    if (this.k == null)
    {
      this.k = new Paint(1);
      this.k.setDither(true);
      this.k.setFilterBitmap(true);
      this.k.setStyle(Paint.Style.FILL);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  private void S()
  {
    int m = this.D.size();
    this.y = new int[m];
    this.z = new int[m];
    this.A = new int[m];
    this.B = new int[m];
    this.G = new int[m];
    this.K = new int[m];
    this.H = new int[m];
    this.J = new int[m];
    int i = 0;
    while (i < m)
    {
      q localq = (q)this.D.get(i);
      this.y[i] = localq.jdField_a_of_type_Char;
      this.z[i] = localq.left;
      this.A[i] = localq.top;
      this.B[i] = localq.width;
      this.G[i] = localq.height;
      this.K[i] = 0;
      if (localq.jdField_a_of_type_Char == 65535) {
        this.K[i] = 2;
      }
      if (localq.jdField_a_of_type_Char == '\n') {
        this.K[i] = 3;
      }
      i += 1;
    }
  }
  
  private void T()
  {
    int i = 0;
    while (i < this.y.length)
    {
      q localq1 = (q)this.D.get(i);
      if (this.K[i] == 1)
      {
        this.C.add(Integer.valueOf(i));
        localq1.aJ = true;
      }
      if (this.H[i] >= this.s.size())
      {
        int m = this.s.size();
        while (m <= this.H[i])
        {
          this.s.add(m, new ArrayList());
          m += 1;
        }
      }
      List localList = (List)this.s.get(this.H[i]);
      q localq2 = a();
      localq2.left = (this.z[i] - this.B[i] / 2);
      localq2.top = (this.A[i] - this.G[i] / 2);
      localq2.width = this.B[i];
      localq2.height = this.G[i];
      localq2.jdField_a_of_type_Char = localq1.jdField_a_of_type_Char;
      localq2.aJ = localq1.aJ;
      localq2.jdField_a_of_type_AndroidTextStyleCharacterStyle = localq1.jdField_a_of_type_AndroidTextStyleCharacterStyle;
      localq2.type = localq1.type;
      this.t.add(localq2);
      localList.add(this.J[i], localq2);
      i += 1;
    }
  }
  
  private void U()
  {
    int m = (int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() / 15.0F);
    int i;
    label47:
    Object localObject;
    int i1;
    int i2;
    int i3;
    int i4;
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.d);
      int n = this.D.size();
      i = 0;
      if (i >= n) {
        return;
      }
      localObject = (q)this.D.get(i);
      i1 = this.B[i];
      i2 = this.G[i];
      i3 = this.z[i] - i1 / 2;
      i4 = this.A[i] - i2 / 2;
      switch (((q)localObject).type)
      {
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.d);
      break;
      localObject = a(i1, m);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, i3, i2 + i4 - m, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      continue;
      if ((((q)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof aofk.a))
      {
        ((aofk.a)((q)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle).draw(this.jdField_a_of_type_AndroidGraphicsCanvas, null, 0, 0, i3, i4, i4 + i2, i4 + i2, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
      else if ((((q)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof amfz))
      {
        localObject = (amfz)((q)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
        ((amfz)localObject).cCu = false;
        ((amfz)localObject).draw(this.jdField_a_of_type_AndroidGraphicsCanvas, null, 0, 0, i3, i4, i4, i4 + i2, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
    }
  }
  
  private q a()
  {
    if (this.E.isEmpty()) {
      return new q();
    }
    return (q)this.E.remove(0);
  }
  
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    R();
    int i = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    if ((i == -2147483648) || (i == 1073741824)) {}
    int n;
    for (this.realWidth = Math.min(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMaxWidth, i1);; this.realWidth = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMaxWidth)
    {
      this.aB = (this.realWidth - this.paddingLeft - this.paddingRight);
      this.realHeight = 0;
      n = paramCharSequence.length();
      paramInt1 = this.E.size();
      if ((paramInt1 >= n) || (this.D.isEmpty())) {
        break;
      }
      while (paramInt1 < n)
      {
        if (!this.D.isEmpty()) {
          this.E.add(this.D.remove(0));
        }
        paramInt1 += 1;
      }
    }
    this.D.clear();
    this.s.clear();
    this.t.clear();
    this.w = new int[n];
    Object localObject = new int[n];
    paramInt1 = 0;
    while (paramInt1 < n)
    {
      localObject[paramInt1] = paramCharSequence.charAt(paramInt1);
      paramInt1 += 1;
    }
    float f2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize();
    int i2 = (int)f2;
    i.a().a(this.mFont.mFontId, (int[])localObject, i2, this.w);
    paramInt1 = 0;
    int m;
    if (paramInt1 < n)
    {
      m = this.w[paramInt1];
      i = m;
      float f1;
      if (m <= 0)
      {
        f1 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint().measureText(String.valueOf((char)localObject[paramInt1]));
        if (f1 <= 0.0F) {
          break label376;
        }
      }
      for (;;)
      {
        i = (int)(f1 * h.j(this.mFont.mFontId) / h.k(this.mFont.mFontId));
        this.C.add(Integer.valueOf(paramInt1));
        this.w[paramInt1] = i;
        paramInt1 += 1;
        break;
        label376:
        f1 = i2;
      }
    }
    CharacterStyle[] arrayOfCharacterStyle;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = (Spanned)paramCharSequence;
      arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
      this.jdField_a_of_type_F$a.a((Spanned)localObject);
      Arrays.sort(arrayOfCharacterStyle, this.jdField_a_of_type_F$a);
    }
    for (;;)
    {
      this.lineSpace = ((int)(h.g(this.mFont.mFontId) * f2 / h.k(this.mFont.mFontId)));
      this.aC = ((int)(h.j(this.mFont.mFontId) * f2 / h.k(this.mFont.mFontId)));
      if ((localObject != null) && (arrayOfCharacterStyle.length > 0))
      {
        paramInt1 = 0;
        i = 0;
        if (i < arrayOfCharacterStyle.length)
        {
          CharacterStyle localCharacterStyle = arrayOfCharacterStyle[i];
          i2 = ((Spanned)localObject).getSpanStart(localCharacterStyle);
          n = ((Spanned)localObject).getSpanEnd(localCharacterStyle);
          if (n == ((Spanned)localObject).length())
          {
            m = 1;
            label568:
            if ((i2 > paramInt1) && (n > i2)) {
              a(null, ko.a(paramCharSequence, paramInt1, i2), paramInt1, (int)f2, 0, this.aC);
            }
            if (!(localCharacterStyle instanceof ClickableSpan)) {
              break label697;
            }
            a(null, ko.a(paramCharSequence, i2, n), i2, (int)f2, 1, this.aC);
          }
          for (;;)
          {
            if ((i == arrayOfCharacterStyle.length - 1) && (m == 0)) {
              a(null, ko.a(paramCharSequence, n, ((Spanned)localObject).length()), n, (int)f2, 0, this.aC);
            }
            i += 1;
            paramInt1 = n;
            break;
            m = 0;
            break label568;
            label697:
            if (((localCharacterStyle instanceof aofk.a)) || ((localCharacterStyle instanceof amfz))) {
              a(localCharacterStyle);
            } else if ((localCharacterStyle instanceof RelativeSizeSpan)) {
              a((RelativeSizeSpan)localCharacterStyle, ko.a(paramCharSequence, i2, n), i2, (int)f2, 3, this.aC);
            } else {
              j.e(getTag(), "Un Know CharacterStyle   start:" + i2 + "  end:" + n);
            }
          }
        }
      }
      else
      {
        a(null, paramCharSequence, 0, (int)f2, 0, this.aC);
      }
      S();
      this.L = i.a().calculateExpressionSize(this.mFont.mFontId, this.y, this.z, this.A, this.B, this.G, this.K, this.H, this.J, this.lineSpace, this.aC, this.aB, this.mFont.mAnimationId);
      if ((this.L == null) || (this.L.length < 2))
      {
        this.realWidth = i1;
        this.realHeight = View.MeasureSpec.getSize(paramInt2);
        return;
      }
      this.realWidth = (this.L[0] + this.paddingLeft + this.paddingRight);
      this.realHeight = (this.L[1] + this.paddingTop + this.paddingBottom);
      T();
      return;
      localObject = null;
      arrayOfCharacterStyle = null;
    }
  }
  
  private boolean a(CharacterStyle paramCharacterStyle)
  {
    Object localObject;
    int m;
    int i;
    if ((paramCharacterStyle instanceof aofk.a))
    {
      localObject = ((aofk.a)paramCharacterStyle).getDrawable().getBounds();
      m = ((Rect)localObject).width();
      i = ((Rect)localObject).height();
    }
    for (;;)
    {
      localObject = a();
      ((q)localObject).jdField_a_of_type_Char = 65535;
      ((q)localObject).aJ = false;
      ((q)localObject).width = m;
      ((q)localObject).height = i;
      ((q)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
      ((q)localObject).type = 2;
      this.D.add(localObject);
      return true;
      if ((paramCharacterStyle instanceof amfz))
      {
        localObject = (amfz)paramCharacterStyle;
        m = ((amfz)localObject).IF();
        i = ((amfz)localObject).getHeight();
      }
      else
      {
        i = 0;
        m = 0;
      }
    }
  }
  
  private boolean a(RelativeSizeSpan paramRelativeSizeSpan, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    if (paramRelativeSizeSpan != null) {
      f2 = paramRelativeSizeSpan.getSizeChange();
    }
    int m = paramCharSequence.length();
    int i = 0;
    if (i < m)
    {
      char c = paramCharSequence.charAt(i);
      float f1;
      label65:
      label72:
      int n;
      if (paramInt1 + i < this.w.length)
      {
        f1 = this.w[(paramInt1 + i)];
        if (f1 <= 0.0F) {
          break label170;
        }
        n = (int)(f1 * h.j(this.mFont.mFontId) / h.k(this.mFont.mFontId));
        paramRelativeSizeSpan = a();
        paramRelativeSizeSpan.aJ = false;
        paramRelativeSizeSpan.type = paramInt3;
        paramRelativeSizeSpan.jdField_a_of_type_Char = c;
        if (c != '\n') {
          break label178;
        }
        paramRelativeSizeSpan.width = n;
      }
      for (paramRelativeSizeSpan.height = paramInt4;; paramRelativeSizeSpan.height = ((int)(paramInt4 * f2)))
      {
        this.D.add(paramRelativeSizeSpan);
        i += 1;
        break;
        f1 = paramInt2;
        break label65;
        label170:
        f1 = paramInt2;
        break label72;
        label178:
        paramRelativeSizeSpan.width = ((int)(n * f2));
      }
    }
    return true;
  }
  
  public void O()
  {
    if ((this.mFont == null) || (F())) {}
    while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    if (i.isDebug) {
      j.i(getTag(), "StartAnimation......animInfo:" + Arrays.toString(this.M));
    }
    this.frameIndex = 0;
    if ((this.M[0] > 0) && (this.M[1] > 0))
    {
      X();
      return;
    }
    i.a().renderExpressionBitmap(this.mFont.mFontId, this.y, this.z, this.A, this.B, this.G, this.K, this.lineSpace, this.aC, this.aB, this.mFont.mAnimationId, this.frameIndex, this.d, this.M, this.mFont.m_comboIndex);
    if ((this.M[0] > 0) && (this.M[1] > 0))
    {
      X();
      return;
    }
    j.e(getTag(), "StartAnimation......动画帧数和帧间隔数据异常 animInfo:" + Arrays.toString(this.M));
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new g(this));
  }
  
  protected void Q()
  {
    if (this.c == null) {
      this.c = new Canvas();
    }
    this.c.setBitmap(this.d);
    this.c.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public int a(int paramInt1, int paramInt2, lc paramlc)
  {
    int i = 0;
    while (i < this.t.size())
    {
      paramlc = (q)this.t.get(i);
      if ((paramInt1 >= paramlc.left) && (paramInt1 <= paramlc.left + paramlc.width) && (paramInt2 >= paramlc.top))
      {
        int m = paramlc.top;
        if (paramInt2 <= paramlc.height + m) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  protected Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = h.b(this.mFont.mFontId, this.mFont.m_comboIndex, paramInt1, paramInt2);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      i.a().a(this.mFont.mFontId, localBitmap2, null, this.mFont.m_comboIndex);
      h.b(this.mFont.mFontId, this.mFont.m_comboIndex, paramInt1, paramInt2, localBitmap2);
      localBitmap1 = localBitmap2;
      if (i.isDebug)
      {
        j.i(getTag(), "create new under line bitmap.... width:" + paramInt1 + "  height:" + paramInt2);
        localBitmap1 = localBitmap2;
      }
    }
    return localBitmap1;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
    throws Exception
  {
    if ((this.V == paramLong) && (this.mMagicFont == paramBoolean) && (this.mFont.equals(paramETFont)) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.isCacheMeasureResult())) {
      return this.v;
    }
    if (this.V != paramLong)
    {
      if (this.mFont != null) {
        this.mFont.mShouldDisplayAnimation = false;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.isFounderAnimating = false;
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.frameIndex = 0;
    }
    this.V = paramLong;
    this.mMagicFont = paramBoolean;
    this.mFont = new ETFont(-1, null, 0.0F);
    this.mFont.copy(paramETFont);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if ((this.mFont == null) || (TextUtils.isEmpty(this.mFont.mFontPath)) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getVisibility() == 8))
    {
      this.v[0] = i;
      this.v[1] = m;
      return this.v;
    }
    paramETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText();
    if (TextUtils.isEmpty(paramETFont))
    {
      this.v[0] = i;
      this.v[1] = m;
      return this.v;
    }
    paramLong = System.nanoTime();
    a(paramInt1, paramInt2, paramETFont);
    long l = System.nanoTime();
    if (i.isDebug) {
      j.i(getTag(), "字数：" + paramETFont.length() + "   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px   排版耗时：" + (float)(l - paramLong) / 1000000.0F + "ms");
    }
    if (F())
    {
      this.v[0] = i;
      this.v[1] = m;
      return this.v;
    }
    this.v[0] = this.realWidth;
    this.v[1] = this.realHeight;
    return this.v;
  }
  
  protected void c(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.hasSelected()) {
      return;
    }
    this.k.setColor(-256);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.k);
  }
  
  public void clearHighlightContent()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int m = this.t.size();
    int i = 0;
    if (i < m)
    {
      if ((i < paramInt1) || (i >= paramInt2)) {}
      for (;;)
      {
        i += 1;
        break;
        q localq = (q)this.t.get(i);
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        float f1 = this.paddingLeft + localq.left;
        float f2 = this.paddingTop + localq.top;
        float f3 = this.paddingLeft + localq.left + localq.width;
        int n = this.paddingTop;
        int i1 = localq.top;
        localPath.addRect(f1, f2, f3, localq.height + (n + i1), Path.Direction.CW);
      }
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
  
  public void locationByIndex(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (!paramBoolean) {
      i = paramInt - 1;
    }
    paramInt = i;
    if (i >= this.t.size()) {
      paramInt = this.t.size() - 1;
    }
    if (paramInt < 0) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(paramArrayOfInt);
    q localq = (q)this.t.get(paramInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.paddingLeft + localq.left;
      paramInt = paramArrayOfInt[1];
      i = this.paddingTop;
      m = localq.top;
      paramArrayOfInt[1] = (localq.height + (i + m) + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.paddingLeft + localq.left + localq.width;
    paramInt = paramArrayOfInt[1];
    i = this.paddingTop;
    int m = localq.top;
    paramArrayOfInt[1] = (localq.height + (i + m) + paramInt);
  }
  
  public boolean onDraw(Canvas paramCanvas)
  {
    if (F())
    {
      j.i(getTag(), "ExpressionLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!G())
    {
      j.i(getTag(), "ExpressionLayout::onDraw 创建bitmap失败！");
      return false;
    }
    Q();
    long l = System.nanoTime();
    M();
    i.a().renderExpressionBitmap(this.mFont.mFontId, this.y, this.z, this.A, this.B, this.G, this.K, this.lineSpace, this.aC, this.aB, this.mFont.mAnimationId, this.frameIndex, this.d, this.M, this.mFont.m_comboIndex);
    c(paramCanvas);
    U();
    paramCanvas.drawBitmap(this.d, this.paddingLeft, this.paddingTop, null);
    if ((this.mFont.mShouldDisplayAnimation) && (this.frameIndex == 0)) {
      O();
    }
    if (i.isDebug)
    {
      j.b(getTag(), l, "字数：" + this.y.length + "\n   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px\n");
      r("ExpressionLayout::onDraw......");
    }
    return true;
  }
  
  void r(String paramString)
  {
    int m = -1;
    Object localObject = null;
    String str;
    StringBuilder localStringBuilder;
    label68:
    int i;
    if (i.isDebug)
    {
      str = getTag();
      localStringBuilder = new StringBuilder().append(paramString).append("\n  text:");
      if (this.mFont != null) {
        break label416;
      }
      paramString = null;
      localStringBuilder = localStringBuilder.append(paramString).append("\n  fontId:");
      if (this.mFont != null) {
        break label427;
      }
      paramString = null;
      paramString = localStringBuilder.append(paramString).append("\n  chars.length:");
      if (this.y != null) {
        break label441;
      }
      i = 0;
      label90:
      paramString = paramString.append(i).append("\n  bitmapWidth:");
      if (this.d != null) {
        break label450;
      }
      i = -1;
      label111:
      paramString = paramString.append(i).append("\n  bitmapHeight:");
      if (this.d != null) {
        break label461;
      }
      i = m;
      label132:
      localStringBuilder = paramString.append(i).append("\n  viewWidth:").append(this.realWidth - this.paddingLeft - this.paddingRight).append("\n  viewHeight:").append(this.realHeight - this.paddingTop - this.paddingBottom).append("\n  paddingLeft:").append(this.paddingLeft).append("\n  paddingRight:").append(this.paddingRight).append("\n  paddingTop:").append(this.paddingTop).append("\n  paddingBottom:").append(this.paddingBottom).append("\n  screenWidth:").append(this.screenWidth).append("\n  screenHeight:").append(this.screenHeight).append("\n  x[]:").append(Arrays.toString(this.z)).append("\n  y[]:").append(Arrays.toString(this.A)).append("\n  width[]:").append(Arrays.toString(this.B)).append("\n  height[]:").append(Arrays.toString(this.G)).append("\n  mAnimationId:");
      if (this.mFont != null) {
        break label472;
      }
      paramString = null;
      label342:
      localStringBuilder = localStringBuilder.append(paramString).append("\n  shouldDisplayAnimation:");
      if (this.mFont != null) {
        break label486;
      }
    }
    label416:
    label427:
    label441:
    label450:
    label461:
    label472:
    label486:
    for (paramString = localObject;; paramString = Boolean.valueOf(this.mFont.mShouldDisplayAnimation))
    {
      j.i(str, paramString + "\n  frameIndex:" + this.frameIndex + "\n  animInfo:" + Arrays.toString(this.M) + "\n");
      return;
      paramString = this.mFont.mText;
      break;
      paramString = Integer.valueOf(this.mFont.mFontId);
      break label68;
      i = this.y.length;
      break label90;
      i = this.d.getWidth();
      break label111;
      i = this.d.getHeight();
      break label132;
      paramString = Long.valueOf(this.mFont.mAnimationId);
      break label342;
    }
  }
  
  public void release()
  {
    super.release();
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    this.b = null;
    this.c = null;
    if (this.j != null)
    {
      this.j.reset();
      this.j = null;
    }
    if (this.k != null) {
      this.k.reset();
    }
    if (this.jdField_a_of_type_AndroidGraphicsPath != null) {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    int n = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(this.mTempLocation);
    int i1 = paramInt1 - this.mTempLocation[0];
    int i2 = paramInt2 - this.mTempLocation[1];
    paramInt2 = this.t.size();
    paramInt1 = 0;
    Object localObject1;
    int i;
    int m;
    int i3;
    while (paramInt1 < paramInt2)
    {
      localObject1 = (q)this.t.get(paramInt1);
      i = this.paddingLeft;
      m = ((q)localObject1).left;
      i3 = this.paddingTop;
      int i4 = ((q)localObject1).top;
      int i5 = this.paddingLeft;
      int i6 = ((q)localObject1).left;
      int i7 = ((q)localObject1).width;
      int i8 = this.paddingTop;
      int i9 = ((q)localObject1).top;
      int i10 = ((q)localObject1).height;
      if ((i1 >= i + m) && (i1 <= i5 + i6 + i7) && (i2 >= i3 + i4) && (i2 <= i10 + (i8 + i9))) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt2 < this.s.size())
    {
      localObject1 = (List)this.s.get(paramInt2);
      if (localObject1 == null) {
        break label429;
      }
      if (((List)localObject1).size() > 0) {}
    }
    label429:
    for (;;)
    {
      paramInt2 += 1;
      break;
      Object localObject2 = ((List)localObject1).iterator();
      q localq;
      for (i = 0; ((Iterator)localObject2).hasNext(); i = localq.height + (m + i3) + i)
      {
        localq = (q)((Iterator)localObject2).next();
        m = this.paddingTop;
        i3 = localq.top;
      }
      m = n;
      if (i / ((List)localObject1).size() < i2)
      {
        if (paramInt2 == this.s.size() - 1) {
          m = n;
        }
      }
      else
      {
        while (m < ((List)localObject1).size())
        {
          localObject2 = (q)((List)localObject1).get(m);
          paramInt2 = this.paddingLeft;
          i = ((q)localObject2).left;
          if (i1 <= ((q)localObject2).width + (paramInt2 + i)) {
            return paramInt1 + m;
          }
          m += 1;
        }
        return ((List)localObject1).size() + paramInt1;
      }
      paramInt1 += ((List)localObject1).size();
      continue;
      return -1;
    }
  }
  
  static class a
    implements Comparator<CharacterStyle>
  {
    Spanned a;
    
    public int a(CharacterStyle paramCharacterStyle1, CharacterStyle paramCharacterStyle2)
    {
      int i = 1;
      if (this.a == null) {
        i = 0;
      }
      int j;
      int k;
      do
      {
        do
        {
          return i;
          j = this.a.getSpanStart(paramCharacterStyle1);
          k = this.a.getSpanStart(paramCharacterStyle2);
          if (j != k) {
            break;
          }
          j = this.a.getSpanEnd(paramCharacterStyle1);
          k = this.a.getSpanEnd(paramCharacterStyle2);
          if (j == k) {
            return 0;
          }
        } while (j > k);
        return -1;
      } while (j > k);
      return -1;
    }
    
    void a(Spanned paramSpanned)
    {
      this.a = paramSpanned;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     f
 * JD-Core Version:    0.7.0.1
 */