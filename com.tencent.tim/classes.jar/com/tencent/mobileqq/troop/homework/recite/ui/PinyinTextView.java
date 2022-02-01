package com.tencent.mobileqq.troop.homework.recite.ui;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import aqho;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PinyinTextView
  extends TextView
{
  private float Aj = 3.0F;
  private float Ak = 15.0F;
  private float Al = 8.0F;
  float Am = 0.0F;
  float An = 0.0F;
  float Ao = 0.0F;
  float Ap = 0.0F;
  float Aq;
  protected List<WordInfo> HT = new ArrayList();
  private float PADDING = 35.0F;
  a jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a = new a();
  ReciteDisplayView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView;
  private Paint.FontMetrics b;
  private final String cpD = "shuang";
  private final String cpE = acfp.m(2131709661);
  private final int dUs = 141;
  private int dUt = 1;
  int dUu = 1;
  float density;
  private float fE;
  private int fontSize = 20;
  private TextPaint k = new TextPaint(1);
  private TextPaint l = new TextPaint(1);
  private float paddingTop = 8.0F;
  public int row = 1;
  
  public PinyinTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PinyinTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    dZQ();
  }
  
  public PinyinTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dZQ();
  }
  
  public PinyinTextView(ReciteDisplayView paramReciteDisplayView, Context paramContext, int paramInt)
  {
    this(paramContext, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = paramReciteDisplayView;
    this.dUt = paramInt;
    if (aBg()) {
      this.fontSize = 24;
    }
    this.Aj = aqho.convertDpToPixel(getContext(), 10.0F);
    if (aBg()) {
      this.Ak = aqho.convertDpToPixel(getContext(), 18.6F);
    }
    for (this.Al = aqho.convertDpToPixel(getContext(), 18.0F);; this.Al = aqho.convertDpToPixel(getContext(), 12.0F))
    {
      this.paddingTop = this.Al;
      dZQ();
      return;
      this.Ak = aqho.convertDpToPixel(getContext(), 0.5F);
    }
  }
  
  public static boolean isEnglishPunctuation(char paramChar)
  {
    return (paramChar == '\'') || (paramChar == ';') || (paramChar == ',') || (paramChar == '.') || (paramChar == '?') || (paramChar == '!') || (paramChar == '"') || (paramChar == '_') || (paramChar == '-') || (paramChar == ':') || (paramChar == '@') || (paramChar == '<') || (paramChar == '>') || (paramChar == '(') || (paramChar == ')');
  }
  
  public static boolean qz(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      do
      {
        return false;
        paramString = paramString.toCharArray();
      } while (paramString.length >= 0);
      char c = paramString[0];
      bool = isEnglishPunctuation(c);
      paramString = Character.UnicodeBlock.of(c);
      if ((bool) || (paramString == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (paramString == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (paramString == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || (paramString == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS)) {
        return true;
      }
    } while ((Build.VERSION.SDK_INT < 19) || ((!bool) && (paramString != Character.UnicodeBlock.VERTICAL_FORMS)));
    return true;
  }
  
  public void a(int paramInt, a parama)
  {
    boolean bool3 = false;
    if ((this.dUt == 1) && (paramInt == 0)) {
      parama.x += 2.0F * (this.Am + this.Ak);
    }
    WordInfo localWordInfo2 = (WordInfo)this.HT.get(paramInt);
    WordInfo localWordInfo1 = null;
    paramInt += 1;
    if (paramInt < this.HT.size()) {
      localWordInfo1 = (WordInfo)this.HT.get(paramInt);
    }
    float f1 = parama.x;
    float f2 = g(localWordInfo2.text) + f1;
    float f3 = this.Ak;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    if (localWordInfo1 == null)
    {
      f1 = this.Am;
      if (f1 + (f2 + f3) - this.Ak <= parama.width - this.fE) {
        break label321;
      }
      bool1 = qB(localWordInfo2.text);
      if (localWordInfo1 == null) {
        break label307;
      }
      bool3 = qA(localWordInfo1.text);
      bool4 = bO(localWordInfo2.text, localWordInfo1.text);
      bool2 = bool1;
      bool1 = bool4;
    }
    for (;;)
    {
      if ((f2 - this.Ak > parama.width - this.fE) || (bool2) || (bool3) || (bool1))
      {
        f2 = this.fE;
        if (!aBg()) {
          break label302;
        }
      }
      label302:
      for (f1 = this.Am * 0.0F;; f1 = 0.0F)
      {
        parama.x = (f1 + f2);
        parama.y = (parama.y + this.Al + this.Am + this.Ao + this.Aj);
        return;
        f1 = g(localWordInfo1.text);
        break;
      }
      label307:
      bool4 = false;
      bool2 = bool1;
      bool1 = bool4;
      continue;
      label321:
      bool1 = false;
      bool2 = false;
    }
  }
  
  boolean aBg()
  {
    return this.dUt == 2;
  }
  
  public void b(int paramInt, a parama)
  {
    WordInfo localWordInfo2 = (WordInfo)this.HT.get(paramInt);
    WordInfo localWordInfo1 = null;
    paramInt += 1;
    if (paramInt < this.HT.size()) {
      localWordInfo1 = (WordInfo)this.HT.get(paramInt);
    }
    parama.x = (parama.x + g(localWordInfo2.text) + this.Ak);
    if (((localWordInfo2.text.equalsIgnoreCase("…")) || (localWordInfo2.text.equalsIgnoreCase("─")) || (localWordInfo2.text.equalsIgnoreCase("-"))) && (localWordInfo1 != null) && (localWordInfo1.text.equalsIgnoreCase(localWordInfo2.text))) {
      parama.x = (parama.x - this.Ak - g(localWordInfo2.text) + this.An);
    }
  }
  
  public boolean bO(String paramString1, String paramString2)
  {
    return ((paramString1.equalsIgnoreCase("…")) && (paramString2.equalsIgnoreCase("…"))) || ((paramString1.equalsIgnoreCase("─")) && (paramString2.equalsIgnoreCase("─"))) || ((paramString1.equalsIgnoreCase("-")) && (paramString2.equalsIgnoreCase("-")));
  }
  
  public void dZQ()
  {
    this.k.setColor(WordInfo.COLOR_DEFAULT);
    this.l.setColor(WordInfo.COLOR_DEFAULT_PINYIN);
    float f = getResources().getDisplayMetrics().density;
    this.k.setStrokeWidth(f * 2.0F);
    this.k.setTextSize(aqho.convertDpToPixel(getContext(), this.fontSize));
    this.l.setStrokeWidth(f);
    this.l.setTextSize(aqho.convertDpToPixel(getContext(), this.fontSize) / 2.0F);
    Rect localRect = new Rect();
    this.k.getTextBounds(this.cpE, 0, this.cpE.length(), localRect);
    if (localRect.width() > localRect.height()) {}
    for (f = localRect.width();; f = localRect.height())
    {
      this.Am = f;
      if (aBg())
      {
        this.l.getTextBounds("shuang", 0, "shuang".length(), localRect);
        this.Ap = localRect.width();
        this.Ao = localRect.height();
      }
      this.b = this.k.getFontMetrics();
      this.An = this.k.measureText("…");
      this.density = getResources().getDisplayMetrics().density;
      return;
    }
  }
  
  public float g(String paramString)
  {
    if ((paramString.equalsIgnoreCase("…")) || (paramString.equalsIgnoreCase("─"))) {
      return this.An;
    }
    return this.Am;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    if ((this.HT != null) && (this.HT.size() > 0))
    {
      a.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.y = (this.Am + this.Al + this.Ao + this.Aj);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.width = getWidth();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a;
      float f2 = this.fE;
      if (aBg()) {
        f1 = 0.0F * this.Am;
      }
      ((a)localObject).x = (f1 + f2);
      int i = 0;
      while (i < this.HT.size())
      {
        localObject = (WordInfo)this.HT.get(i);
        this.k.setColor(((WordInfo)localObject).color);
        this.l.setColor(((WordInfo)localObject).colorPinyin);
        a(i, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a);
        if (!TextUtils.isEmpty(((WordInfo)localObject).text))
        {
          if ((((WordInfo)localObject).isNormalWord()) && (aBg()))
          {
            f2 = this.l.measureText(((WordInfo)localObject).pinyin2Display);
            f1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.x;
            f2 = (this.Am - f2) / 2.0F;
            paramCanvas.drawText(((WordInfo)localObject).pinyin2Display.substring(0, ((WordInfo)localObject).pinyin2Display.length()), f2 + f1, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.y - this.Am - this.Aj, this.l);
          }
          paramCanvas.drawText(((WordInfo)localObject).text, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.x, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.y, this.k);
          b(i, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a);
          WordInfo localWordInfo = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a();
          f1 = getTop() + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.y + this.Ao + this.Aj + this.Am;
          int j = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.getBottom() * 2 / 3;
          if ((localWordInfo != null) && (localWordInfo.paragraphPos == ((WordInfo)localObject).paragraphPos) && (localWordInfo.wordPos == ((WordInfo)localObject).wordPos) && (this.Aq != f1) && (f1 > j))
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.t(((WordInfo)localObject).paragraphPos, f1 - j);
            this.Aq = f1;
          }
        }
        i += 1;
      }
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    if (i == 1073741824) {}
    for (i = View.MeasureSpec.getSize(paramInt1);; i = 0)
    {
      if (j == 1073741824) {
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 < 141) {
          paramInt2 = 141;
        }
        setMeasuredDimension(i, paramInt2);
        return;
        if (j == -2147483648)
        {
          if ((this.k != null) && (this.HT != null) && (this.HT.size() != 0)) {
            paramInt1 = (int)((this.HT.size() / 10 + 1) * 2 * (this.b.bottom - this.b.top) + this.paddingTop);
          }
        }
        else if ((this.HT != null) && (this.HT.size() != 0))
        {
          paramInt1 = Math.max(this.HT.size(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.jH(((WordInfo)this.HT.get(0)).paragraphPos));
          float f2;
          if (!aBg())
          {
            this.fE = y(i);
            a.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a);
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.width = i;
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.y = (this.Am + this.Al + this.Ao + this.Aj);
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a;
            f2 = this.fE;
            if (!aBg()) {
              break label385;
            }
          }
          label385:
          for (float f1 = this.Am * 0.0F;; f1 = 0.0F)
          {
            ((a)localObject).x = (f1 + f2);
            paramInt1 = 0;
            while (paramInt1 < this.HT.size())
            {
              a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a);
              b(paramInt1, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a);
              paramInt1 += 1;
            }
            f1 = paramInt1;
            f2 = this.Am;
            f1 = (paramInt1 - 1) * this.Ak + f1 * f2;
            if (f1 < i)
            {
              this.fE = ((i - f1) / 2.0F);
              break;
            }
            this.fE = y(i);
            break;
          }
          Object localObject = this.k.getFontMetrics();
          f1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$a.y;
          paramInt1 = (int)(((Paint.FontMetrics)localObject).descent + f1);
          continue;
        }
        paramInt1 = 0;
      }
    }
  }
  
  public boolean qA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = paramString.toCharArray();
      int i = 0;
      while (i < paramString.length)
      {
        int j = paramString[i];
        if ((j == 39) || (j == 59) || (j == 65292) || (j == 44) || (j == 12290) || (j == 46) || (j == 65311) || (j == 63) || (j == 65281) || (j == 33) || (j == 8221) || (j == 95) || (j == 65306) || (j == 58) || (j == 64) || (j == 183) || (j == 8212) || (j == 45) || (j == 8217) || (j == 12289) || (j == 65289) || (j == 41) || (j == 12299) || (j == 12297) || (j == 62) || (j == 65307) || (j == 126)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean qB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equalsIgnoreCase("《")) && (!paramString.equalsIgnoreCase("（")) && (!paramString.equalsIgnoreCase("(")) && (!paramString.equalsIgnoreCase("〈")) && (!paramString.equalsIgnoreCase("<")) && (!paramString.equalsIgnoreCase("‘")) && (!paramString.equalsIgnoreCase("“"))) {
      return false;
    }
    return true;
  }
  
  public void setWordInfos(ParagraphInfo paramParagraphInfo, int paramInt, boolean paramBoolean)
  {
    if (paramParagraphInfo == null) {}
    String[] arrayOfString1;
    String[] arrayOfString2;
    do
    {
      return;
      if (paramParagraphInfo.wordList != null)
      {
        this.HT = new ArrayList();
        if (paramBoolean)
        {
          paramParagraphInfo = paramParagraphInfo.wordList.iterator();
          while (paramParagraphInfo.hasNext())
          {
            localWordInfo = (WordInfo)paramParagraphInfo.next();
            if (localWordInfo.wordPos <= paramInt) {
              this.HT.add(localWordInfo);
            }
          }
        }
        this.HT = new ArrayList(paramParagraphInfo.wordList);
        requestLayout();
        invalidate();
        return;
      }
      arrayOfString1 = paramParagraphInfo.generateOrGetPinyinWithTone();
      arrayOfString2 = paramParagraphInfo.generateOrGetContents();
    } while ((arrayOfString1 == null) || (arrayOfString2 == null));
    this.HT.clear();
    int i = 0;
    try
    {
      if ((i >= arrayOfString2.length) || ((paramBoolean) && (i > paramInt)))
      {
        requestLayout();
        invalidate();
        return;
      }
    }
    catch (IndexOutOfBoundsException paramParagraphInfo)
    {
      QLog.e("ReciteDetect.PinyinTextView", 2, "pinyin len:" + arrayOfString1.length + "|" + arrayOfString1.toString() + ", hanzi len:" + arrayOfString2.length + "|" + arrayOfString2.toString());
      return;
    }
    String str = arrayOfString2[i];
    if (i < arrayOfString1.length) {}
    for (WordInfo localWordInfo = arrayOfString1[i];; localWordInfo = null)
    {
      if (qz(str)) {}
      for (localWordInfo = new WordInfo(null, str);; localWordInfo = new WordInfo(localWordInfo, str))
      {
        localWordInfo.wordPos = i;
        localWordInfo.paragraphPos = paramParagraphInfo.paragraphPos;
        this.HT.add(localWordInfo);
        i += 1;
        break;
      }
    }
  }
  
  float y(int paramInt)
  {
    float f1 = paramInt;
    float f2;
    do
    {
      f2 = f1 - this.Am - this.Ak;
      f1 = f2;
    } while (f2 >= this.PADDING * 2.0F);
    f1 = f2 + this.Ak;
    if (f1 < this.PADDING) {
      return aqho.convertDpToPixel(getContext(), f1 / 2.0F) + (this.Am + this.Ak);
    }
    return aqho.convertDpToPixel(getContext(), f1 / 2.0F);
  }
  
  class a
  {
    int width;
    float x;
    float y;
    
    a() {}
    
    private void reset()
    {
      this.x = 0.0F;
      this.y = 0.0F;
      this.width = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView
 * JD-Core Version:    0.7.0.1
 */