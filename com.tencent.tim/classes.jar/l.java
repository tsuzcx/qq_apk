import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class l
  extends k
  implements k.a
{
  public static boolean I;
  private ArrayList<Integer> C;
  protected List<q> D;
  private List<q> E;
  private List<q> G;
  protected int[] N;
  protected int[] O;
  protected int[] P;
  protected int[] Q;
  private long V;
  protected Canvas a;
  protected Path a;
  protected ETTextView a;
  private l.a a;
  private int aB;
  private int aE;
  private int aI;
  private int aM;
  private int aN;
  private int aU;
  protected boolean aw;
  protected Canvas b;
  private int cC;
  protected int cD;
  protected int cE;
  protected int cF;
  protected int cL;
  private boolean hasInit;
  private int itemCount;
  private Paint j;
  protected Paint k;
  private Paint jdField_l_of_type_AndroidGraphicsPaint;
  private SparseIntArray jdField_l_of_type_AndroidUtilSparseIntArray;
  private int left;
  protected int lineSpace;
  protected Paint m = new Paint();
  private boolean mMagicFont;
  protected int[] mTempLocation = new int[2];
  private int maxLength;
  protected int paddingBottom;
  protected int paddingLeft;
  protected int paddingRight;
  protected int paddingTop;
  protected int realHeight;
  protected int realWidth;
  protected List<List<q>> s;
  private int screenHeight;
  private int screenWidth;
  private int[] v = new int[2];
  private int[] w;
  protected int[] x;
  protected int[] y;
  
  public l(ETTextView paramETTextView, ETFont paramETFont)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = paramETTextView;
    this.mFont = paramETFont;
    R();
    this.jdField_a_of_type_L$a = new l.a();
    this.m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  private void R()
  {
    if (this.hasInit) {
      return;
    }
    this.hasInit = true;
    if (this.D == null) {
      this.D = new ArrayList();
    }
    if (this.G == null) {
      this.G = new ArrayList();
    }
    if (this.s == null) {
      this.s = new ArrayList();
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
    if (this.jdField_l_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_l_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_l_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_l_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_l_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    if (this.j == null)
    {
      this.j = new Paint(1);
      this.j.setDither(true);
      this.j.setFilterBitmap(true);
    }
    if (this.C == null) {
      this.C = new ArrayList();
    }
    if (this.jdField_l_of_type_AndroidUtilSparseIntArray == null) {
      this.jdField_l_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    }
    if (this.k == null)
    {
      this.k = new Paint(1);
      this.k.setDither(true);
      this.k.setFilterBitmap(true);
      this.k.setStyle(Paint.Style.FILL);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  private q a()
  {
    if (this.E.isEmpty()) {
      return new q();
    }
    return (q)this.E.remove(0);
  }
  
  @TargetApi(16)
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    R();
    paramInt2 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if ((paramInt2 == -2147483648) || (paramInt2 == 1073741824)) {}
    int i3;
    for (this.realWidth = Math.min(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMaxWidth, paramInt1);; this.realWidth = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMaxWidth)
    {
      this.realHeight = 0;
      this.aE = 0;
      this.aI = 0;
      this.aM = 0;
      this.itemCount = 0;
      this.maxLength = 0;
      this.aU = 0;
      this.aN = 1;
      this.left = 0;
      this.paddingLeft = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft();
      this.paddingRight = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingRight();
      this.paddingTop = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
      this.paddingBottom = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingBottom();
      this.aB = (this.realWidth - this.paddingLeft - this.paddingRight);
      if (Build.VERSION.SDK_INT >= 16) {
        this.maxLength = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getMaxEms();
      }
      this.aU = this.aB;
      this.s.clear();
      this.G.clear();
      paramInt1 = this.E.size();
      i3 = paramCharSequence.length();
      if ((paramInt1 >= i3) || (this.D.isEmpty())) {
        break;
      }
      while (paramInt1 < i3)
      {
        if (!this.D.isEmpty()) {
          this.E.add(this.D.remove(0));
        }
        paramInt1 += 1;
      }
    }
    this.D.clear();
    this.jdField_l_of_type_AndroidUtilSparseIntArray.clear();
    this.C.clear();
    this.w = new int[i3];
    Object localObject = new int[i3];
    int i = 0;
    int i1 = 0;
    paramInt2 = 0;
    int n;
    if (paramInt2 < i3)
    {
      localObject[paramInt2] = paramCharSequence.charAt(paramInt2);
      if (((localObject[paramInt2] >= 97) && (localObject[paramInt2] <= 122)) || ((localObject[paramInt2] >= 65) && (localObject[paramInt2] <= 90))) {
        if (i1 == 0)
        {
          paramInt1 = 1;
          n = paramInt2;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        i1 = paramInt1;
        i = n;
        break;
        paramInt1 = i1;
        n = i;
        if (paramInt2 == i3 - 1)
        {
          paramInt1 = 0;
          this.jdField_l_of_type_AndroidUtilSparseIntArray.put(i, i3 - i);
          n = i;
          continue;
          paramInt1 = i1;
          n = i;
          if (i1 != 0)
          {
            paramInt1 = 0;
            this.jdField_l_of_type_AndroidUtilSparseIntArray.put(i, paramInt2 - i);
            n = i;
          }
        }
      }
    }
    float f2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize();
    int i2 = (int)f2;
    i.a().a(this.mFont.mFontId, (int[])localObject, i2, this.w);
    paramInt1 = 0;
    float f1;
    if (paramInt1 < i3)
    {
      i = this.w[paramInt1];
      paramInt2 = i;
      if (i <= 0)
      {
        f1 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint().measureText(String.valueOf((char)localObject[paramInt1]));
        if (f1 <= 0.0F) {
          break label622;
        }
      }
      for (;;)
      {
        paramInt2 = (int)(f1 * h.j(this.mFont.mFontId) / h.k(this.mFont.mFontId));
        this.C.add(Integer.valueOf(paramInt1));
        this.w[paramInt1] = paramInt2;
        paramInt1 += 1;
        break;
        label622:
        f1 = i2;
      }
    }
    CharacterStyle[] arrayOfCharacterStyle;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = (Spanned)paramCharSequence;
      arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
      this.jdField_a_of_type_L$a.a((Spanned)localObject);
      Arrays.sort(arrayOfCharacterStyle, this.jdField_a_of_type_L$a);
    }
    for (;;)
    {
      this.lineSpace = ((int)(h.g(this.mFont.mFontId) * f2 / h.k(this.mFont.mFontId)));
      n = (int)(h.j(this.mFont.mFontId) * f2 / h.k(this.mFont.mFontId));
      CharacterStyle localCharacterStyle;
      int i4;
      boolean bool;
      if ((localObject != null) && (arrayOfCharacterStyle != null) && (arrayOfCharacterStyle.length > 0))
      {
        i = 0;
        i1 = arrayOfCharacterStyle.length;
        paramInt1 = 0;
        while (paramInt1 < i1)
        {
          localCharacterStyle = arrayOfCharacterStyle[paramInt1];
          if ((localCharacterStyle instanceof RelativeSizeSpan))
          {
            paramInt2 = ((Spanned)localObject).getSpanStart(localCharacterStyle);
            i3 = ((Spanned)localObject).getSpanEnd(localCharacterStyle);
            f1 = ((RelativeSizeSpan)localCharacterStyle).getSizeChange();
            while (paramInt2 < i3)
            {
              i4 = this.w[paramInt2];
              this.w[paramInt2] = ((int)(i4 * f1));
              paramInt2 += 1;
            }
          }
          paramInt1 += 1;
        }
        paramInt2 = 0;
        paramInt1 = i;
        if (paramInt2 < arrayOfCharacterStyle.length)
        {
          localCharacterStyle = arrayOfCharacterStyle[paramInt2];
          i1 = ((Spanned)localObject).getSpanStart(localCharacterStyle);
          i = ((Spanned)localObject).getSpanEnd(localCharacterStyle);
          if (i == ((Spanned)localObject).length())
          {
            bool = true;
            label917:
            if ((i1 <= paramInt1) || (i <= i1) || (!a(ko.a(paramCharSequence, paramInt1, i1), paramInt1, i2, 0, false, n))) {
              break label1082;
            }
          }
        }
        else
        {
          label951:
          if (Build.VERSION.SDK_INT < 16) {
            break label1545;
          }
        }
      }
      label1280:
      label1542:
      label1545:
      for (paramInt2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getMaxLines();; paramInt2 = 0)
      {
        f1 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint().getFontMetrics().bottom;
        this.cE = 0;
        this.cD = this.s.size();
        i3 = this.s.size();
        i = 0;
        n = 0;
        if ((i >= i3) || (i >= paramInt2))
        {
          if (this.aE < this.aB) {
            this.realWidth = (this.aE + this.paddingLeft + this.paddingRight);
          }
          this.realHeight = (this.paddingBottom + n + this.paddingTop);
          return;
          bool = false;
          break label917;
          label1082:
          if ((localCharacterStyle instanceof ClickableSpan)) {
            if (a(ko.a(paramCharSequence, i1, i), i1, i2, 1, bool, n)) {
              break label951;
            }
          }
          for (;;)
          {
            if ((paramInt2 == arrayOfCharacterStyle.length - 1) && (!bool) && (a(ko.a(paramCharSequence, i, ((Spanned)localObject).length()), i, i2, 0, true, n))) {
              break label1280;
            }
            paramInt2 += 1;
            paramInt1 = i;
            break;
            if (((localCharacterStyle instanceof aofk.a)) || ((localCharacterStyle instanceof amfz)))
            {
              if (!a(localCharacterStyle, i1, i, 2, bool)) {
                continue;
              }
              break label951;
            }
            if ((localCharacterStyle instanceof RelativeSizeSpan))
            {
              if (!a((RelativeSizeSpan)localCharacterStyle, ko.a(paramCharSequence, i1, i), i1, i2, 3, bool, n)) {
                continue;
              }
              break label951;
            }
            j.e("FounderColorLayout", "Un Know CharacterStyle   start:" + i1 + "  end:" + i);
          }
          break label951;
          a(paramCharSequence, 0, i2, 0, true, n);
          break label951;
        }
        paramCharSequence = (List)this.s.get(i);
        if ((paramCharSequence == null) || (paramCharSequence.isEmpty()))
        {
          if (i == i3 - 1) {}
          for (paramInt1 = 0;; paramInt1 = this.lineSpace)
          {
            paramInt1 += n + i2;
            i += 1;
            n = paramInt1;
            break;
          }
        }
        this.cE = Math.max(this.cE, paramCharSequence.size());
        paramInt1 = 0;
        i4 = paramCharSequence.size();
        i1 = 0;
        label1395:
        if (i1 < i4)
        {
          localObject = (q)paramCharSequence.get(i1);
          if (((q)localObject).height <= paramInt1) {
            break label1542;
          }
          paramInt1 = ((q)localObject).height;
        }
        for (;;)
        {
          i1 += 1;
          break label1395;
          i4 = paramCharSequence.size();
          i1 = 0;
          while (i1 < i4)
          {
            localObject = (q)paramCharSequence.get(i1);
            ((q)localObject).top = (paramInt1 - ((q)localObject).height + n - (int)((1.0F - ((q)localObject).height / paramInt1) * f1));
            i1 += 1;
          }
          if (i == i3 - 1) {}
          for (i1 = 0;; i1 = this.lineSpace)
          {
            paramInt1 = i1 + (n + paramInt1);
            break;
          }
        }
      }
      localObject = null;
      arrayOfCharacterStyle = null;
    }
  }
  
  private void a(Canvas paramCanvas, q paramq)
  {
    if ((paramq.width <= 0) || (paramq.height <= 0)) {
      return;
    }
    BitmapShader localBitmapShader = h.a(this.mFont.mFontId, this.mFont.m_comboIndex, paramq.width, paramq.height);
    Bitmap localBitmap2;
    Bitmap localBitmap1;
    if (localBitmapShader == null)
    {
      localBitmap2 = Bitmap.createBitmap(paramq.width, paramq.height, Bitmap.Config.ARGB_8888);
      localBitmap1 = Bitmap.createBitmap(paramq.width, paramq.height, Bitmap.Config.ARGB_8888);
      switch (i.a().a(this.mFont.mFontId, localBitmap2, localBitmap1, this.mFont.m_comboIndex))
      {
      default: 
        localBitmap2 = Bitmap.createBitmap(paramq.width, paramq.height, Bitmap.Config.ARGB_8888);
        if (this.b == null) {
          this.b = new Canvas(localBitmap2);
        }
        break;
      }
    }
    for (;;)
    {
      if (localBitmap1 != null) {
        this.b.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
      }
      if (localBitmapShader != null) {
        this.j.setShader(localBitmapShader);
      }
      this.j.setTextSize(paramq.height);
      this.b.drawText(String.valueOf(paramq.jdField_a_of_type_Char), 0.0F, (int)(paramq.height / 2.0F - (this.j.descent() + this.j.ascent()) / 2.0F), this.j);
      paramCanvas.drawBitmap(localBitmap2, paramq.left, paramq.top, this.j);
      localBitmap2.recycle();
      return;
      localBitmap2.recycle();
      localBitmap1.recycle();
      localBitmap1 = null;
      break;
      localBitmapShader = new BitmapShader(localBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      h.a(this.mFont.mFontId, this.mFont.m_comboIndex, paramq.width, paramq.height, localBitmapShader);
      localBitmap1.recycle();
      localBitmap1 = null;
      break;
      localBitmapShader = new BitmapShader(localBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      h.a(this.mFont.mFontId, this.mFont.m_comboIndex, paramq.width, paramq.height, localBitmapShader);
      h.a(this.mFont.mFontId, this.mFont.m_comboIndex, paramq.width, paramq.height, localBitmap1);
      break;
      localBitmap1 = h.a(this.mFont.mFontId, this.mFont.m_comboIndex, paramq.width, paramq.height);
      break;
      this.b.setBitmap(localBitmap2);
    }
  }
  
  private boolean a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject;
    if ((paramCharacterStyle instanceof aofk.a))
    {
      localObject = ((aofk.a)paramCharacterStyle).getDrawable().getBounds();
      paramInt2 = ((Rect)localObject).width();
      paramInt1 = ((Rect)localObject).height();
    }
    for (;;)
    {
      localObject = a();
      ((q)localObject).jdField_a_of_type_Char = 65535;
      ((q)localObject).aJ = false;
      ((q)localObject).width = paramInt2;
      ((q)localObject).height = paramInt1;
      ((q)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
      ((q)localObject).type = paramInt3;
      if (this.aU < ((q)localObject).width)
      {
        this.aM = Math.max(this.aI, this.aM);
        this.aI = ((q)localObject).width;
        this.aN += 1;
        this.left = 0;
        ((q)localObject).left = this.left;
        ((q)localObject).lineIndex = this.aN;
        this.left = ((q)localObject).width;
        this.aU = (this.aB - ((q)localObject).width);
        this.s.add(this.G);
        this.G = new ArrayList();
        this.G.add(localObject);
        this.D.add(localObject);
        label220:
        if (this.left > this.aE) {
          this.aE = this.left;
        }
        this.itemCount += 1;
        if ((this.maxLength <= 0) || (this.itemCount < this.maxLength)) {
          break label402;
        }
        this.s.add(this.G);
        bool = true;
      }
      label402:
      while (!paramBoolean)
      {
        return bool;
        if (!(paramCharacterStyle instanceof amfz)) {
          break label423;
        }
        localObject = (amfz)paramCharacterStyle;
        paramInt2 = ((amfz)localObject).IF();
        paramInt1 = ((amfz)localObject).getHeight();
        break;
        this.aI += ((q)localObject).width;
        ((q)localObject).left = this.left;
        ((q)localObject).lineIndex = this.aN;
        this.aU -= ((q)localObject).width;
        this.left += ((q)localObject).width;
        this.G.add(localObject);
        this.D.add(localObject);
        break label220;
      }
      this.s.add(this.G);
      return false;
      label423:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  private boolean a(RelativeSizeSpan paramRelativeSizeSpan, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    float f2 = paramRelativeSizeSpan.getSizeChange();
    int i3 = paramCharSequence.length();
    int n = 0;
    while (n < i3)
    {
      char c = paramCharSequence.charAt(n);
      paramRelativeSizeSpan = a();
      if (c == '\n')
      {
        paramRelativeSizeSpan.aJ = false;
        paramRelativeSizeSpan.type = paramInt3;
        paramRelativeSizeSpan.width = 0;
        paramRelativeSizeSpan.height = paramInt4;
        paramRelativeSizeSpan.jdField_a_of_type_Char = c;
        paramRelativeSizeSpan.left = this.left;
        paramRelativeSizeSpan.lineIndex = this.aN;
        this.aU = this.aB;
        this.aN += 1;
        this.left = 0;
        this.aM = Math.max(this.aI, this.aM);
        this.aI = 0;
        this.G.add(paramRelativeSizeSpan);
        this.s.add(this.G);
        this.G = new ArrayList();
        this.D.add(paramRelativeSizeSpan);
        if ((n == i3 - 1) && (paramBoolean)) {
          this.s.add(this.G);
        }
        n += 1;
      }
      else
      {
        int i2 = 0;
        int i = 0;
        int i1 = i2;
        if (this.jdField_l_of_type_AndroidUtilSparseIntArray.size() > 0)
        {
          int i4 = this.jdField_l_of_type_AndroidUtilSparseIntArray.get(paramInt1 + n);
          i1 = i2;
          if (i4 > 0)
          {
            i2 = 0;
            for (;;)
            {
              i1 = i;
              if (i2 >= i4) {
                break;
              }
              i1 = this.w[(paramInt1 + n + i2)];
              i2 += 1;
              i = i1 + i;
            }
          }
        }
        float f1;
        if (paramInt1 + n < this.w.length)
        {
          f1 = this.w[(paramInt1 + n)];
          label327:
          paramRelativeSizeSpan.aJ = this.C.contains(Integer.valueOf(paramInt1 + n));
          paramRelativeSizeSpan.type = paramInt3;
          paramRelativeSizeSpan.width = ((int)f1);
          if (!paramRelativeSizeSpan.aJ) {
            break label598;
          }
          i = paramInt2;
          label369:
          paramRelativeSizeSpan.height = ((int)(i * f2));
          paramRelativeSizeSpan.jdField_a_of_type_Char = c;
          if ((this.aU >= paramRelativeSizeSpan.width) && ((this.aU >= i1) || (this.left == 0))) {
            break label605;
          }
          this.aM = Math.max(this.aI, this.aM);
          this.aI = paramRelativeSizeSpan.width;
          this.aN += 1;
          this.left = 0;
          paramRelativeSizeSpan.left = this.left;
          paramRelativeSizeSpan.lineIndex = this.aN;
          this.left = paramRelativeSizeSpan.width;
          this.aU = (this.aB - paramRelativeSizeSpan.width);
          this.s.add(this.G);
          this.G = new ArrayList();
          this.G.add(paramRelativeSizeSpan);
        }
        for (;;)
        {
          if (this.left > this.aE) {
            this.aE = this.left;
          }
          this.itemCount += 1;
          if ((this.maxLength <= 0) || (this.itemCount < this.maxLength)) {
            break;
          }
          this.s.add(this.G);
          return true;
          f1 = paramInt2 * f2;
          break label327;
          label598:
          i = paramInt4;
          break label369;
          label605:
          this.aI += paramRelativeSizeSpan.width;
          paramRelativeSizeSpan.left = this.left;
          paramRelativeSizeSpan.lineIndex = this.aN;
          this.aU -= paramRelativeSizeSpan.width;
          this.left += paramRelativeSizeSpan.width;
          this.G.add(paramRelativeSizeSpan);
        }
      }
    }
    return false;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    int i3 = paramCharSequence.length();
    int n = 0;
    while (n < i3)
    {
      char c = paramCharSequence.charAt(n);
      q localq = a();
      if (c == '\n')
      {
        localq.aJ = false;
        localq.type = paramInt3;
        localq.width = 0;
        localq.height = paramInt4;
        localq.jdField_a_of_type_Char = c;
        localq.left = this.left;
        localq.lineIndex = this.aN;
        this.aU = this.aB;
        this.aN += 1;
        this.left = 0;
        this.aM = Math.max(this.aI, this.aM);
        this.aI = 0;
        this.G.add(localq);
        this.s.add(this.G);
        this.G = new ArrayList();
        this.D.add(localq);
        if ((n == i3 - 1) && (paramBoolean)) {
          this.s.add(this.G);
        }
        n += 1;
      }
      else
      {
        int i2 = 0;
        int i = 0;
        int i1 = i2;
        if (this.jdField_l_of_type_AndroidUtilSparseIntArray.size() > 0)
        {
          int i4 = this.jdField_l_of_type_AndroidUtilSparseIntArray.get(paramInt1 + n);
          i1 = i2;
          if (i4 > 0)
          {
            i2 = 0;
            for (;;)
            {
              i1 = i;
              if (i2 >= i4) {
                break;
              }
              i1 = this.w[(paramInt1 + n + i2)];
              i2 += 1;
              i = i1 + i;
            }
          }
        }
        float f;
        if (paramInt1 + n < this.w.length)
        {
          f = this.w[(paramInt1 + n)];
          label331:
          localq.aJ = this.C.contains(Integer.valueOf(paramInt1 + n));
          localq.type = paramInt3;
          localq.width = ((int)f);
          if (!localq.aJ) {
            break label605;
          }
          i = paramInt2;
          label376:
          localq.height = i;
          localq.jdField_a_of_type_Char = c;
          if ((this.aU >= localq.width) && ((this.aU >= i1) || (this.left == 0))) {
            break label612;
          }
          this.aM = Math.max(this.aI, this.aM);
          this.aI = localq.width;
          this.aN += 1;
          this.left = 0;
          localq.left = this.left;
          localq.lineIndex = this.aN;
          this.left = localq.width;
          this.aU = (this.aB - localq.width);
          this.s.add(this.G);
          this.G = new ArrayList();
          this.G.add(localq);
        }
        for (;;)
        {
          if (this.left > this.aE) {
            this.aE = this.left;
          }
          this.itemCount += 1;
          if ((this.maxLength <= 0) || (this.itemCount < this.maxLength)) {
            break;
          }
          this.s.add(this.G);
          return true;
          f = paramInt2;
          break label331;
          label605:
          i = paramInt4;
          break label376;
          label612:
          this.aI += localq.width;
          localq.left = this.left;
          localq.lineIndex = this.aN;
          this.aU -= localq.width;
          this.left += localq.width;
          this.G.add(localq);
        }
      }
    }
    return false;
  }
  
  protected boolean F()
  {
    int i2 = 1;
    int i;
    int n;
    label41:
    int i1;
    if (this.realWidth - this.paddingLeft - this.paddingRight <= 0)
    {
      i = 1;
      if (this.realHeight - this.paddingTop - this.paddingBottom > 0) {
        break label101;
      }
      n = 1;
      if (this.realWidth - this.paddingLeft - this.paddingRight <= this.screenWidth) {
        break label106;
      }
      i1 = 1;
      label64:
      if (this.realHeight - this.paddingTop - this.paddingBottom <= this.screenHeight) {
        break label111;
      }
    }
    for (;;)
    {
      return i1 | 0x0 | i | n | i2;
      i = 0;
      break;
      label101:
      n = 0;
      break label41;
      label106:
      i1 = 0;
      break label64;
      label111:
      i2 = 0;
    }
  }
  
  protected boolean G()
  {
    if (!c(this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom)) {
      return false;
    }
    int n = this.D.size();
    if (n <= 0) {
      return false;
    }
    if (this.cC != n) {
      this.y = new int[n];
    }
    if ((this.cC < n) || (this.cC - n > 100))
    {
      this.x = new int[n];
      this.N = new int[n];
      this.O = new int[n];
      this.P = new int[n];
    }
    this.cC = n;
    this.aw = true;
    int i = 0;
    while (i < n)
    {
      q localq = (q)this.D.get(i);
      this.y[i] = localq.jdField_a_of_type_Char;
      this.x[i] = localq.left;
      this.N[i] = localq.top;
      this.O[i] = localq.width;
      this.P[i] = localq.height;
      if (localq.type != 2) {
        this.aw = false;
      }
      i += 1;
    }
    return true;
  }
  
  public void O()
  {
    if ((this.mFont == null) || (F())) {}
    do
    {
      return;
      if (h.h(this.mFont.mFontId) < 3)
      {
        j.e("FounderColorLayout", "当前字体未加载或不支持动画..." + this.mFont.mFontPath);
        return;
      }
      if ((this.cD <= 0) || (this.cD > 5) || (this.aw))
      {
        j.e("FounderColorLayout", "0行或超过5行不支持播放动画..." + this.mFont.mFontPath);
        return;
      }
    } while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    if ((this.M[0] > 0) && (this.M[1] > 0))
    {
      X();
      return;
    }
    this.frameIndex = 0;
    i.a().a(this.mFont.mFontId, this.y, this.x, this.N, this.O, this.P, this.d, null, this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom, this.cD, this.cE, this.lineSpace, this.mFont.mAnimationId, this.frameIndex, this.M);
    if ((this.M[0] > 0) && (this.M[1] > 0))
    {
      X();
      return;
    }
    j.e("FounderColorLayout", "StartAnimation......动画帧数和帧间隔数据异常 animInfo:" + Arrays.toString(this.M));
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new m(this));
  }
  
  protected void Y()
  {
    int n = (int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() / 15.0F);
    int i;
    label47:
    q localq;
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.d);
      int i1 = this.D.size();
      i = 0;
      if (i >= i1) {
        return;
      }
      localq = (q)this.D.get(i);
      switch (localq.type)
      {
      }
    }
    for (;;)
    {
      if (localq.aJ) {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, localq);
      }
      i += 1;
      break label47;
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.d);
      break;
      Object localObject = a(localq.width, n);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, localq.left, localq.top + localq.height - n, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      continue;
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(localq.left, localq.top, localq.left + localq.width, localq.top + localq.height, this.m);
      if ((localq.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof aofk.a))
      {
        ((aofk.a)localq.jdField_a_of_type_AndroidTextStyleCharacterStyle).draw(this.jdField_a_of_type_AndroidGraphicsCanvas, null, 0, 0, localq.left, localq.top, localq.top + localq.height, localq.top + localq.height, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
      else if ((localq.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof amfz))
      {
        localObject = (amfz)localq.jdField_a_of_type_AndroidTextStyleCharacterStyle;
        ((amfz)localObject).cCu = false;
        ((amfz)localObject).draw(this.jdField_a_of_type_AndroidGraphicsCanvas, null, 0, 0, localq.left, localq.top, localq.top, localq.top + localq.height, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, lc paramlc)
  {
    int i = 0;
    while (i < this.D.size())
    {
      q localq = (q)this.D.get(i);
      if ((paramInt1 >= localq.left) && (paramInt1 <= localq.left + localq.width) && (paramInt2 >= localq.top))
      {
        int n = localq.top;
        if (paramInt2 <= localq.height + n) {
          return paramlc.z(i);
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
      i.a().a(this.mFont.mFontId, localBitmap2, null);
      h.b(this.mFont.mFontId, this.mFont.m_comboIndex, paramInt1, paramInt2, localBitmap2);
      localBitmap1 = localBitmap2;
      if (i.isDebug)
      {
        j.i("FounderColorLayout", "create new under line bitmap.... width:" + paramInt1 + "  height:" + paramInt2);
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
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.isFounderAnimating = false;
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.frameIndex = 0;
    }
    this.V = paramLong;
    this.mMagicFont = paramBoolean;
    this.mFont = new ETFont(-1, null, 0.0F);
    this.mFont.copy(paramETFont);
    this.v[0] = View.MeasureSpec.getSize(paramInt1);
    this.v[1] = View.MeasureSpec.getSize(paramInt2);
    if ((this.mFont == null) || (TextUtils.isEmpty(this.mFont.mFontPath)) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getVisibility() == 8)) {
      return this.v;
    }
    CharSequence localCharSequence = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText();
    if (TextUtils.isEmpty(localCharSequence)) {
      return this.v;
    }
    paramLong = System.nanoTime();
    a(paramInt1, paramInt2, localCharSequence);
    double d = (float)(System.nanoTime() - paramLong) / 1000000.0F;
    if (i.isDebug) {
      j.i("FounderColorLayout", "字数：" + localCharSequence.length() + "   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px   排版耗时：" + d + "ms");
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
      la.a("action_measure", paramETFont.mFontId, 4, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText().length(), d);
    }
    if (F()) {
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
    this.k.setColor(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.highlightBackgroundColor());
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.k);
  }
  
  public void clearHighlightContent()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
  
  protected void d(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(-256);
    localPaint.setStrokeWidth(1.0F);
    int i = 0;
    while (i < this.y.length)
    {
      paramCanvas.drawRect(this.paddingLeft + this.x[i], this.paddingTop + this.N[i], this.paddingLeft + this.x[i] + this.O[i], this.paddingTop + this.N[i] + this.P[i], localPaint);
      i += 1;
    }
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int n = this.D.size();
    int i = 0;
    if (i < n)
    {
      if ((i < paramInt1) || (i >= paramInt2)) {}
      for (;;)
      {
        i += 1;
        break;
        q localq = (q)this.D.get(i);
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        float f1 = this.paddingLeft + localq.left;
        float f2 = this.paddingTop + localq.top;
        float f3 = this.paddingLeft + localq.left + localq.width;
        int i1 = this.paddingTop;
        int i2 = localq.top;
        localPath.addRect(f1, f2, f3, localq.height + (i1 + i2), Path.Direction.CW);
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
    if (i >= this.D.size())
    {
      paramInt = this.D.size() - 1;
      paramBoolean = false;
    }
    if (paramInt < 0) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(paramArrayOfInt);
    q localq = (q)this.D.get(paramInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.paddingLeft + localq.left;
      paramInt = paramArrayOfInt[1];
      i = this.paddingTop;
      n = localq.top;
      paramArrayOfInt[1] = (localq.height + (i + n) + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.paddingLeft + localq.left + localq.width;
    paramInt = paramArrayOfInt[1];
    i = this.paddingTop;
    int n = localq.top;
    paramArrayOfInt[1] = (localq.height + (i + n) + paramInt);
  }
  
  public boolean onDraw(Canvas paramCanvas)
  {
    if (F())
    {
      r("FounderColorLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!G())
    {
      r("FounderColorLayout::onDraw 创建bitmap失败！");
      return false;
    }
    if ((this.s == null) || (this.s.isEmpty()))
    {
      r(acfp.m(2131706564));
      return false;
    }
    if (this.y.length <= 0)
    {
      r(acfp.m(2131706563));
      return false;
    }
    Q();
    c(paramCanvas);
    long l1 = System.nanoTime();
    int i = h.h(this.mFont.mFontId);
    if ((this.mFont.mShouldDisplayAnimation) && (!this.aw) && (i == 3) && (this.cD > 0) && (this.cD < 6))
    {
      i.a().a(this.mFont.mFontId, this.y, this.x, this.N, this.O, this.P, this.d, null, this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom, this.cD, this.cE, this.lineSpace, this.mFont.mAnimationId, this.frameIndex, this.M);
      Y();
      paramCanvas.drawBitmap(this.d, this.paddingLeft, this.paddingTop, null);
      if (this.frameIndex == 0) {
        O();
      }
      if (i.isDebug)
      {
        long l2 = System.nanoTime();
        j.e("FounderColorLayout", "动画帧耗时 frameIndex:" + this.frameIndex + "  行：" + this.cD + "  列：" + this.cE + "  耗时：" + (float)(l2 - l1) / 1000000.0F + "ms");
        if (this.frameIndex == 0) {
          r("drawAnimationText.....");
        }
      }
      return true;
    }
    if ((!this.aw) && (i == 5))
    {
      i.a().a(this.mFont.mFontId, this.y, this.x, this.N, this.O, this.P, this.d, this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom, this.mFont.m_comboIndex);
      Y();
      paramCanvas.drawBitmap(this.d, this.paddingLeft, this.paddingTop, null);
      return true;
    }
    this.Q = new int[0];
    i.a().a(this.mFont.mFontId, this.y, this.x, this.N, this.O, this.P, this.d, this.realWidth - this.paddingLeft - this.paddingRight, this.realHeight - this.paddingTop - this.paddingBottom, this.cF, this.Q, this.cL);
    Y();
    paramCanvas.drawBitmap(this.d, this.paddingLeft, this.paddingTop, null);
    return true;
  }
  
  protected void r(String paramString) {}
  
  public void release()
  {
    super.release();
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    this.b = null;
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    int i3 = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(this.mTempLocation);
    int i4 = this.mTempLocation[0];
    int i5 = this.mTempLocation[1];
    int i1 = 0;
    int n = 0;
    List localList;
    Object localObject;
    int i;
    label78:
    int i2;
    if (i1 < this.s.size())
    {
      localList = (List)this.s.get(i1);
      localObject = localList.iterator();
      i = -2147483648;
      if (((Iterator)localObject).hasNext())
      {
        q localq = (q)((Iterator)localObject).next();
        i2 = this.paddingTop;
        int i6 = localq.top;
        i2 = localq.height + (i2 + i6);
        if (i2 <= i) {
          break label274;
        }
        i = i2;
      }
    }
    label274:
    for (;;)
    {
      break label78;
      i2 = i3;
      if (i < paramInt2 - i5)
      {
        if (i1 == this.s.size() - 1) {
          i2 = i3;
        }
      }
      else
      {
        while (i2 < localList.size())
        {
          localObject = (q)localList.get(i2);
          paramInt2 = this.paddingLeft;
          i = ((q)localObject).left;
          if (paramInt1 - i4 <= ((q)localObject).width + (paramInt2 + i)) {
            return n + i2;
          }
          i2 += 1;
        }
        return localList.size() + n;
      }
      i = localList.size();
      i1 += 1;
      n += i;
      break;
      return -1;
    }
  }
  
  public void u(boolean paramBoolean)
  {
    super.u(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
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
    
    public void a(Spanned paramSpanned)
    {
      this.a = paramSpanned;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     l
 * JD-Core Version:    0.7.0.1
 */