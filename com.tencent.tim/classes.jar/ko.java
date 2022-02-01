import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETSegment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class ko
{
  public ETFont a;
  private kq[] a;
  private ArrayList<kp> as = new ArrayList(16);
  private ArrayList<CharacterStyle> at = new ArrayList(4);
  private ArrayList<kr> au = new ArrayList(16);
  private boolean cq;
  public boolean cr = false;
  public int hU;
  private int hV;
  int hW = -1;
  public ETFont mFont;
  public int mHeight;
  private int mLinkBackcolor;
  public boolean mMagicFont;
  private int mMaxWidth;
  public long mMsgId = 0L;
  private CharSequence mText;
  public int mWidth;
  Paint paint = new Paint(1);
  public AtomicBoolean z = new AtomicBoolean(false);
  
  public ko()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, "", 24.0F);
  }
  
  private String U()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_ArrayOfKq == null) || (this.jdField_a_of_type_ArrayOfKq.length == 0)) {
      return null;
    }
    if ((this.as == null) || (this.as.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.as.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = ((kp)localIterator.next()).i();
      if (localObject == null) {
        return null;
      }
      localObject = ((ArrayList)localObject).iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        km localkm = (km)((Iterator)localObject).next();
        if (localkm == null) {
          return null;
        }
        String str = localkm.R();
        if (str != null)
        {
          localkm.P(j);
          j += str.length();
          localStringBuilder.append(str);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private int a(char paramChar1, char paramChar2)
  {
    return (paramChar1 << '\n') + paramChar2 - 56613888;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramCharSequence == null) {
      return "";
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramCharSequence.length()) {
      paramInt1 = paramCharSequence.length();
    }
    paramInt2 = paramInt1 - i;
    if (paramInt2 <= 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramInt2];
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      arrayOfChar[paramInt1] = paramCharSequence.charAt(paramInt1 + i);
      paramInt1 += 1;
    }
    return String.valueOf(arrayOfChar);
  }
  
  private void a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramCharacterStyle = new kp(paramCharacterStyle, paramInt1, paramInt2, paramInt3, paramBoolean);
    paramCharacterStyle.R(this.mLinkBackcolor);
    this.as.add(paramCharacterStyle);
  }
  
  private void a(ETEngine paramETEngine, int paramInt)
    throws Exception
  {
    if (this.jdField_a_of_type_ArrayOfKq != null) {
      this.jdField_a_of_type_ArrayOfKq = null;
    }
    int m = this.as.size();
    int i = 0;
    int j = 0;
    int k = 0;
    Object localObject1;
    while (i < m)
    {
      localObject1 = (kp)this.as.get(i);
      k = ((kp)localObject1).a(paramETEngine, paramInt, j, k);
      j = ((kp)localObject1).getCurrentX();
      i += 1;
    }
    k += 1;
    this.jdField_a_of_type_ArrayOfKq = new kq[k];
    paramInt = 0;
    while (paramInt < k)
    {
      this.jdField_a_of_type_ArrayOfKq[paramInt] = new kq();
      paramInt += 1;
    }
    paramInt = 0;
    Object localObject2;
    while (paramInt < m)
    {
      localObject1 = ((kp)this.as.get(paramInt)).i();
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (km)((ArrayList)localObject1).get(i);
        j = ((km)localObject2).getLineNumber();
        if ((j >= 0) && (j < k)) {
          this.jdField_a_of_type_ArrayOfKq[j].a((km)localObject2);
        }
        i += 1;
      }
      paramInt += 1;
    }
    paramInt = 0;
    i = 0;
    while (paramInt < k)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfKq[paramInt];
      ((kq)localObject1).a(paramETEngine, 0, i, this.hU);
      localObject2 = ((kq)localObject1).i().iterator();
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        km localkm = (km)((Iterator)localObject2).next();
        kr[] arrayOfkr = localkm.a(paramETEngine, j, i, ((kq)localObject1).getHeight(), paramInt);
        if ((arrayOfkr != null) && (arrayOfkr.length > 0)) {
          Collections.addAll(this.au, arrayOfkr);
        }
        j += localkm.getWidth();
      }
      i += ((kq)localObject1).getHeight();
      paramInt += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    paramString = new kp(paramString, paramInt1, paramInt2, paramETFont, paramBoolean);
    paramString.R(this.mLinkBackcolor);
    this.as.add(paramString);
    this.cr = false;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = new kp(paramString, paramInt1, paramInt2, paramETFont, paramBoolean1);
    paramString.R(this.mLinkBackcolor);
    paramString.mMagicFont = paramBoolean2;
    this.as.add(paramString);
    this.cr = false;
  }
  
  private Object[] a()
  {
    if ((this.at != null) && (this.at.size() > 0)) {
      return this.at.toArray();
    }
    return null;
  }
  
  private int aw()
  {
    if ((this.jdField_a_of_type_ArrayOfKq == null) || (this.jdField_a_of_type_ArrayOfKq.length == 0)) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfKq.length;
    return this.jdField_a_of_type_ArrayOfKq[(i - 1)].getWidth();
  }
  
  private void eI()
  {
    if (this.as != null) {
      this.as.clear();
    }
    if ((this.mText != null) && (this.mFont != null))
    {
      if ((this.mText instanceof Spanned)) {
        eJ();
      }
    }
    else {
      return;
    }
    a(this.mText.toString(), 0, this.mText.length(), this.mFont, false);
  }
  
  private void eJ()
  {
    this.at.clear();
    Object localObject = (Spanned)this.mText;
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
    ko.b[] arrayOfb = new ko.b[arrayOfCharacterStyle.length];
    if ((arrayOfb == null) || (arrayOfb.length == 0))
    {
      a(this.mText.toString(), 0, this.mText.length(), this.mFont, false);
      return;
    }
    int i = 0;
    while (i < arrayOfCharacterStyle.length)
    {
      arrayOfb[i] = new ko.b();
      arrayOfb[i].start = ((Spanned)localObject).getSpanStart(arrayOfCharacterStyle[i]);
      arrayOfb[i].end = ((Spanned)localObject).getSpanEnd(arrayOfCharacterStyle[i]);
      arrayOfb[i].a = arrayOfCharacterStyle[i];
      i += 1;
    }
    Arrays.sort(arrayOfb, new ko.a());
    i = 0;
    int j = 0;
    label176:
    int m;
    int k;
    if (i < arrayOfCharacterStyle.length)
    {
      m = arrayOfb[i].start;
      k = arrayOfb[i].end;
      if (m - j > 0) {
        a(a(this.mText, j, m).toString(), j, m, this.mFont, false);
      }
      if (k - m > 0)
      {
        if (!(arrayOfb[i].a instanceof ClickableSpan)) {
          break label379;
        }
        if ((m <= 0) || (this.mText.charAt(m - 1) != '\024')) {
          break label610;
        }
      }
    }
    label610:
    for (j = m + 1;; j = m)
    {
      a(a(this.mText, j, k).toString(), j, k, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, true);
      for (;;)
      {
        if ((i == arrayOfCharacterStyle.length - 1) && (k < this.mText.length())) {
          a(a(this.mText, k, this.mText.length()).toString(), k, this.mText.length(), this.mFont, false);
        }
        i += 1;
        j = k;
        break label176;
        break;
        label379:
        if ((arrayOfb[i].a instanceof aofk.a))
        {
          localObject = (aofk.a)arrayOfb[i].a;
          this.at.add(localObject);
          a((CharacterStyle)localObject, this.at.indexOf(localObject), m, k, false);
        }
        else if ((arrayOfb[i].a instanceof RelativeSizeSpan))
        {
          localObject = a(this.mText, m, k);
          RelativeSizeSpan localRelativeSizeSpan = (RelativeSizeSpan)arrayOfb[i].a;
          ETFont localETFont = new ETFont(this.mFont.mFontId, this.mFont.mFontPath, this.mFont.getSize());
          localETFont.copy(this.mFont);
          localETFont.setSize(localRelativeSizeSpan.getSizeChange() * this.mFont.getSize());
          a(((CharSequence)localObject).toString(), m, k, localETFont, false, true);
        }
        else if ((arrayOfb[i].a instanceof amfz))
        {
          localObject = (amfz)arrayOfb[i].a;
          this.at.add(localObject);
          a((CharacterStyle)localObject, this.at.indexOf(localObject), m, k, false);
        }
      }
    }
  }
  
  public void Q(int paramInt)
  {
    this.mLinkBackcolor = paramInt;
  }
  
  Rect a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfKq.length)) {
      return null;
    }
    kq localkq = this.jdField_a_of_type_ArrayOfKq[paramInt];
    paramInt = localkq.getLeft();
    int i = localkq.getTop();
    return new Rect(paramInt, i, this.mWidth + paramInt, i + localkq.getHeight());
  }
  
  public aofk.a a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    kq[] arrayOfkq = this.jdField_a_of_type_ArrayOfKq;
    int j = arrayOfkq.length;
    if (i < j)
    {
      Object localObject = arrayOfkq[i];
      localRect.left = ((kq)localObject).getLeft();
      localRect.top = ((kq)localObject).getTop();
      localRect.right = (localRect.left + ((kq)localObject).getWidth());
      localRect.bottom = (localRect.top + ((kq)localObject).getHeight());
      if (!localRect.contains(paramInt1, paramInt2)) {}
      do
      {
        i += 1;
        break;
        localObject = ((kq)localObject).a(paramInt1);
      } while (localObject == null);
      return ((km)localObject).a();
    }
    return null;
  }
  
  public ETDecoration a(ETEngine paramETEngine, boolean paramBoolean)
  {
    if (paramETEngine == null) {
      return null;
    }
    String str = U();
    int j = aw();
    int k = getLines();
    ETSegment[] arrayOfETSegment = a(paramETEngine);
    Object[] arrayOfObject = a();
    int i;
    if (!paramBoolean)
    {
      this.hW = -1;
      if (this.at != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.at.size())
      {
        if (((CharacterStyle)this.at.get(i) instanceof amfz)) {
          this.hW = i;
        }
      }
      else {
        return ETDecoration.createDecoration(paramETEngine, str, this.mWidth, this.mHeight, j, k, arrayOfETSegment, arrayOfObject, this.cq, this.mMaxWidth, this.mFont, paramBoolean);
      }
      i += 1;
    }
  }
  
  kr a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.au.size())) {
      return null;
    }
    return (kr)this.au.get(paramInt);
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ArrayOfKq == null) {}
    for (;;)
    {
      return;
      kq[] arrayOfkq = this.jdField_a_of_type_ArrayOfKq;
      int k = arrayOfkq.length;
      int j = 0;
      int i = paramInt2;
      paramInt2 = j;
      while (paramInt2 < k)
      {
        kq localkq = arrayOfkq[paramInt2];
        localkq.a(paramCanvas, paramInt1, i);
        i += localkq.getHeight();
        paramInt2 += 1;
      }
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int j = 2048;
    if (paramCanvas == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    int n;
    int i;
    if (paramBitmap != null)
    {
      n = paramBitmap.getWidth();
      i = paramBitmap.getHeight();
      if (Build.VERSION.SDK_INT < 14) {
        break label234;
      }
      paramInt1 = paramCanvas.getMaximumBitmapHeight();
    }
    for (paramInt2 = paramCanvas.getMaximumBitmapWidth();; paramInt2 = j)
    {
      if ((n <= paramInt2) && (i <= paramInt1)) {
        paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      }
      for (;;)
      {
        paramCanvas.restore();
        return;
        Rect localRect = new Rect(0, 0, 0, 0);
        while (i > 0)
        {
          int k;
          if (i >= paramInt1)
          {
            k = paramInt1;
            localRect.left = 0;
            localRect.bottom += k;
            j = n;
            label136:
            if (j <= 0) {
              break label211;
            }
            if (j < paramInt2) {
              break label204;
            }
          }
          label204:
          for (int m = paramInt2;; m = j)
          {
            j -= m;
            localRect.right += m;
            paramCanvas.drawBitmap(paramBitmap, localRect, localRect, null);
            localRect.left = (m + localRect.left);
            break label136;
            k = i;
            break;
          }
          label211:
          localRect.top = (k + localRect.top);
          i -= k;
        }
      }
      label234:
      paramInt1 = 2048;
    }
  }
  
  @TargetApi(14)
  public final void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, boolean paramBoolean)
  {
    if ((paramETEngine == null) || (paramBitmap == null))
    {
      break label8;
      break label8;
    }
    label8:
    int n;
    int j;
    int i;
    Object localObject1;
    int k;
    label174:
    for (;;)
    {
      return;
      if ((this.mWidth > 0) && (this.mHeight > 0))
      {
        n = paramBitmap.getHeight();
        if ((paramETDecoration == null) || (2 != paramETDecoration.getDecorationType())) {
          break label176;
        }
        j = 0;
        i = 0;
        if (paramBoolean)
        {
          paramETDecoration.drawScene(paramBitmap, 0, 0, this.mFont);
          return;
        }
        localObject1 = paramETDecoration.mMargins;
        if (localObject1 != null)
        {
          j = ((Rect)localObject1).left;
          i = ((Rect)localObject1).top;
        }
        paramETDecoration.drawBackground(paramBitmap, this.mFont);
        if (this.jdField_a_of_type_ArrayOfKq == null) {
          break;
        }
        paramETDecoration = this.jdField_a_of_type_ArrayOfKq;
        int i1 = paramETDecoration.length;
        int m = 0;
        k = i;
        i = m;
        for (;;)
        {
          if (i >= i1) {
            break label174;
          }
          localObject1 = paramETDecoration[i];
          ((kq)localObject1).a(paramETEngine, paramBitmap, null, j, k);
          k += ((kq)localObject1).getHeight();
          if (k >= n) {
            break;
          }
          i += 1;
        }
      }
    }
    label176:
    if (!paramBoolean) {
      paramETDecoration = null;
    }
    for (;;)
    {
      if ((paramETDecoration != null) && (1 == paramETDecoration.getDecorationType())) {
        paramETDecoration.drawBackground(paramBitmap, this.mFont);
      }
      if (this.jdField_a_of_type_ArrayOfKq != null)
      {
        j = 0;
        localObject1 = this.jdField_a_of_type_ArrayOfKq;
        k = localObject1.length;
        i = 0;
      }
      for (;;)
      {
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          localObject2.a(paramETEngine, paramBitmap, paramETDecoration, 0, j);
          j += localObject2.getHeight();
          if (j < n) {}
        }
        else
        {
          if ((paramETDecoration == null) || (1 != paramETDecoration.getDecorationType())) {
            break;
          }
          paramETDecoration.drawForeground(paramBitmap, this.mFont);
          return;
        }
        i += 1;
      }
    }
  }
  
  public boolean a(ETEngine paramETEngine, int paramInt1, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2, boolean paramBoolean, int paramInt3)
    throws Throwable
  {
    this.hV = paramInt1;
    this.cq = paramBoolean;
    this.mMaxWidth = paramInt3;
    this.mText = paramCharSequence;
    this.mFont = paramETFont;
    this.cr = true;
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.mFont != null))
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(this.mFont);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(paramInt2);
    }
    eI();
    if (this.cr) {
      return false;
    }
    a(paramETEngine, paramInt1);
    if (this.jdField_a_of_type_ArrayOfKq == null) {
      throw new Exception("measure textLines fail");
    }
    int j = this.jdField_a_of_type_ArrayOfKq.length;
    paramInt2 = 0;
    paramInt3 = 0;
    paramInt1 = 0;
    int k;
    if (paramInt2 < j)
    {
      int i = this.jdField_a_of_type_ArrayOfKq[paramInt2].getWidth();
      k = this.jdField_a_of_type_ArrayOfKq[paramInt2].getHeight();
      if (i <= paramInt1) {
        break label254;
      }
      paramInt1 = i;
    }
    label254:
    for (;;)
    {
      paramInt3 += k;
      paramInt2 += 1;
      break;
      this.mWidth = paramInt1;
      this.mHeight = paramInt3;
      if ((this.mWidth <= 0) || (this.mHeight <= 0)) {
        throw new Exception("mesure fail mWidth=" + this.mWidth + ",mHeight" + this.mHeight);
      }
      this.z.set(true);
      return true;
    }
  }
  
  public ETSegment[] a(ETEngine paramETEngine)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ArrayOfKq == null) {
      return null;
    }
    kq[] arrayOfkq = this.jdField_a_of_type_ArrayOfKq;
    int n = arrayOfkq.length;
    int k = 0;
    int j = 0;
    int i = 0;
    kq localkq;
    int m;
    label74:
    km localkm;
    ETSegment localETSegment;
    Object localObject2;
    int i1;
    int i2;
    if (k < n)
    {
      localkq = arrayOfkq[k];
      Object localObject1 = localkq.i();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      m = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localkm = (km)((Iterator)localObject1).next();
        if (localkm == null) {
          return null;
        }
        localETSegment = new ETSegment();
        localETSegment.type = 0;
        localETSegment.codePoint = -1;
        localETSegment.textOffset = 0;
        localETSegment.textLength = 0;
        localETSegment.lineNum = 0;
        localETSegment.textSize = 0;
        localETSegment.x = 0;
        localETSegment.y = 0;
        localObject2 = localkm.R();
        if (localObject2 == null) {
          break label513;
        }
        localETSegment.textLength = ((String)localObject2).length();
        localETSegment.textOffset = i;
        localETSegment.type = 0;
        i = ((String)localObject2).length() + i;
        i1 = localkq.getHeight();
        i2 = localkm.getHeight();
        int i3 = localkq.az();
        int i4 = localkm.a(paramETEngine);
        localETSegment.x = m;
        localETSegment.y = (i1 - i2 + j - (i3 - i4));
      }
    }
    label513:
    for (;;)
    {
      localObject2 = localkm.T();
      if (localObject2 != null)
      {
        localETSegment.textLength = 1;
        localETSegment.type = 1;
        localETSegment.codePoint = a(((String)localObject2).charAt(0), ((String)localObject2).charAt(1));
        i1 = localkq.getHeight();
        i2 = localkm.getHeight();
        localETSegment.x = m;
        localETSegment.y = (i1 - i2 + j);
      }
      i1 = localkm.getSpanIndex();
      if (i1 > -1)
      {
        localETSegment.type = 2;
        localETSegment.codePoint = i1;
        i1 = localkq.getHeight();
        i2 = localkm.getHeight();
        localETSegment.x = m;
        localETSegment.y = (i1 - i2 + j);
        localObject2 = localkm.a();
        if ((localObject2 instanceof amfz))
        {
          localObject2 = (amfz)localObject2;
          ((amfz)localObject2).left = m;
          ((amfz)localObject2).top = localETSegment.y;
        }
      }
      localETSegment.textSize = localkm.getFontSize();
      localETSegment.lineNum = localkm.getLineNumber();
      localArrayList.add(localETSegment);
      m = localkm.getWidth() + m;
      break label74;
      m = localkq.getHeight();
      k += 1;
      j += m;
      break;
      return (ETSegment[])localArrayList.toArray(new ETSegment[localArrayList.size()]);
    }
  }
  
  public kr[] a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfKq == null) || (paramInt >= this.jdField_a_of_type_ArrayOfKq.length)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.au.iterator();
    while (localIterator.hasNext())
    {
      kr localkr = (kr)localIterator.next();
      if (localkr.lineIndex == paramInt) {
        localArrayList.add(localkr);
      }
    }
    return (kr[])localArrayList.toArray(new kr[0]);
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject1;
    int i;
    int k;
    if ((this.hW > -1) && (this.hW < this.at.size()))
    {
      localObject1 = (amfz)this.at.get(this.hW);
      this.paint.setTextSize(this.mFont.mFontSize);
      this.paint.setColor(this.mFont.mFontColor);
      i = ((amfz)localObject1).getHeight();
      k = (int)((amfz)localObject1).top;
      ((amfz)localObject1).cCu = false;
      ((amfz)localObject1).draw(paramCanvas, null, 0, 0, ((amfz)localObject1).left, (int)((amfz)localObject1).top, 0, i + k, this.paint);
    }
    if (this.jdField_a_of_type_ArrayOfKq == null) {}
    for (;;)
    {
      return;
      localObject1 = this.jdField_a_of_type_ArrayOfKq;
      k = localObject1.length;
      i = paramInt2;
      paramInt2 = j;
      while (paramInt2 < k)
      {
        Object localObject2 = localObject1[paramInt2];
        localObject2.c(paramCanvas, paramInt1, i);
        i += localObject2.getHeight();
        paramInt2 += 1;
      }
    }
  }
  
  public int getLines()
  {
    if (this.jdField_a_of_type_ArrayOfKq != null) {
      return this.jdField_a_of_type_ArrayOfKq.length;
    }
    return 0;
  }
  
  int h(int paramInt1, int paramInt2)
  {
    int j = x(paramInt2);
    int k = this.au.size();
    int i = k - 1;
    paramInt2 = 0;
    if (paramInt2 < k)
    {
      kr localkr = (kr)this.au.get(paramInt2);
      if (localkr.lineIndex == j)
      {
        if (paramInt1 > localkr.f.right) {
          break label87;
        }
        return paramInt2;
      }
      if (localkr.lineIndex <= j) {}
    }
    else
    {
      return i + 1;
    }
    for (;;)
    {
      paramInt2 += 1;
      break;
      label87:
      i = paramInt2;
    }
  }
  
  public int i(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    kq[] arrayOfkq = this.jdField_a_of_type_ArrayOfKq;
    int j = arrayOfkq.length;
    if (i < j)
    {
      Object localObject = arrayOfkq[i];
      localRect.left = ((kq)localObject).getLeft();
      localRect.top = ((kq)localObject).getTop();
      localRect.right = (localRect.left + ((kq)localObject).getWidth());
      localRect.bottom = (localRect.top + ((kq)localObject).getHeight());
      if (!localRect.contains(paramInt1, paramInt2)) {}
      do
      {
        i += 1;
        break;
        localObject = ((kq)localObject).a(paramInt1);
      } while (localObject == null);
      return ((km)localObject).a().ax();
    }
    return -1;
  }
  
  int x(int paramInt)
  {
    int j = this.jdField_a_of_type_ArrayOfKq.length;
    int i = 0;
    while (i < j)
    {
      kq localkq = this.jdField_a_of_type_ArrayOfKq[i];
      int k = localkq.getTop();
      if (paramInt < localkq.getHeight() + k) {
        return i;
      }
      i += 1;
    }
    return j - 1;
  }
  
  static class a
    implements Comparator<ko.b>
  {
    public int a(ko.b paramb1, ko.b paramb2)
    {
      if (paramb1.start != paramb2.start)
      {
        if (paramb1.start > paramb2.start) {
          return 1;
        }
        return -1;
      }
      return paramb1.end - paramb2.end;
    }
  }
  
  static class b
  {
    CharacterStyle a;
    int end;
    int start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ko
 * JD-Core Version:    0.7.0.1
 */