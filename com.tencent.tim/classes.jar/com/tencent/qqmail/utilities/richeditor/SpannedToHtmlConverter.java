package com.tencent.qqmail.utilities.richeditor;

import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.Stack;

public class SpannedToHtmlConverter
{
  public static String toHtml(Spanned paramSpanned)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    withinHtml(localStringBuilder, paramSpanned);
    return localStringBuilder.toString();
  }
  
  private static void withinBlockquote(StringBuilder paramStringBuilder, Spanned paramSpanned, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - 1;
    while ((i >= paramInt1) && (paramSpanned.length() > i) && (paramSpanned.charAt(i) == '\n')) {
      i -= 1;
    }
    int j = i + 1;
    i = j;
    if (j > paramInt1) {
      for (int k = paramInt1;; k = paramInt1)
      {
        i = j;
        if (k >= j) {
          break;
        }
        if (paramSpanned.length() < j) {}
        for (i = -1;; i = TextUtils.indexOf(paramSpanned, '\n', k, j))
        {
          paramInt1 = i;
          if (i < 0) {
            paramInt1 = j;
          }
          i = 0;
          while ((paramInt1 < j) && (paramSpanned.charAt(paramInt1) == '\n'))
          {
            i += 1;
            paramInt1 += 1;
          }
        }
        if (paramInt1 == paramInt2) {}
        for (boolean bool = true;; bool = false)
        {
          withinParagraph(paramStringBuilder, paramSpanned, k, paramInt1 - i, i, bool);
          if (i <= 0) {
            break;
          }
          if (paramSpanned.length() != 0) {
            paramStringBuilder.append("<br>");
          }
          k = 1;
          while (k < i)
          {
            paramStringBuilder.append("<br>");
            k += 1;
          }
        }
      }
    }
    while (i < paramInt2)
    {
      paramStringBuilder.append("<br>");
      i += 1;
    }
  }
  
  private static void withinDiv(StringBuilder paramStringBuilder, Spanned paramSpanned, int paramInt1, int paramInt2)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    while (paramInt1 < paramInt2)
    {
      int j = paramSpanned.nextSpanTransition(paramInt1, paramInt2, QuoteSpan.class);
      QuoteSpan[] arrayOfQuoteSpan = (QuoteSpan[])paramSpanned.getSpans(paramInt1, j, QuoteSpan.class);
      int k = arrayOfQuoteSpan.length;
      int i = 0;
      while (i < k)
      {
        localBoolean = arrayOfQuoteSpan[i];
        paramStringBuilder.append("<blockquote>");
        localBoolean = Boolean.valueOf(true);
        i += 1;
      }
      if (localBoolean.booleanValue()) {
        paramStringBuilder.append("<div>");
      }
      withinBlockquote(paramStringBuilder, paramSpanned, paramInt1, j);
      if (localBoolean.booleanValue()) {
        paramStringBuilder.append("</div>");
      }
      i = arrayOfQuoteSpan.length;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        QuoteSpan localQuoteSpan = arrayOfQuoteSpan[paramInt1];
        paramStringBuilder.append("</blockquote>");
        paramInt1 += 1;
      }
      paramInt1 = j;
    }
  }
  
  private static void withinHtml(StringBuilder paramStringBuilder, Spanned paramSpanned)
  {
    int i1 = paramSpanned.length();
    Stack localStack = new Stack();
    int k = 0;
    int n;
    ParagraphStyle[] arrayOfParagraphStyle;
    String str;
    int m;
    int i;
    int j;
    if (k < paramSpanned.length())
    {
      n = paramSpanned.nextSpanTransition(k, i1, ParagraphStyle.class);
      arrayOfParagraphStyle = (ParagraphStyle[])paramSpanned.getSpans(k, n, ParagraphStyle.class);
      str = " ";
      if ((!localStack.empty()) && (paramSpanned.getSpanEnd(localStack.peek()) <= k))
      {
        if ((localStack.peek() instanceof OLBulletSpan)) {
          paramStringBuilder.append("</ol>");
        }
        for (;;)
        {
          localStack.pop();
          break;
          if ((localStack.peek() instanceof ULBulletSpan)) {
            paramStringBuilder.append("</ul>");
          }
        }
      }
      m = 0;
      i = 0;
      j = 0;
      label145:
      if (m < arrayOfParagraphStyle.length) {
        if ((arrayOfParagraphStyle[m] instanceof OLBulletSpan))
        {
          if (paramSpanned.getSpanStart(arrayOfParagraphStyle[m]) != k) {
            break label571;
          }
          localStack.push(arrayOfParagraphStyle[m]);
          paramStringBuilder.append("<ol>");
        }
      }
    }
    label571:
    for (;;)
    {
      m += 1;
      break label145;
      if ((arrayOfParagraphStyle[m] instanceof ULBulletSpan))
      {
        if (paramSpanned.getSpanStart(arrayOfParagraphStyle[m]) == k)
        {
          localStack.push(arrayOfParagraphStyle[m]);
          paramStringBuilder.append("<ul>");
        }
      }
      else if ((arrayOfParagraphStyle[m] instanceof QMBulletSpan))
      {
        i = 1;
      }
      else if ((arrayOfParagraphStyle[m] instanceof AlignmentSpan))
      {
        Layout.Alignment localAlignment = ((AlignmentSpan)arrayOfParagraphStyle[m]).getAlignment();
        if (localAlignment == Layout.Alignment.ALIGN_CENTER)
        {
          str = "align=\"center\" " + str;
          j = 1;
        }
        else if (localAlignment == Layout.Alignment.ALIGN_OPPOSITE)
        {
          str = "align=\"right\" " + str;
          j = 1;
        }
        else
        {
          str = "align=\"left\" " + str;
          j = 1;
          continue;
          if (i != 0) {
            paramStringBuilder.append("<li>");
          }
          if (j != 0) {
            paramStringBuilder.append("<div " + str + ">");
          }
          if (((i != 0) || (j != 0)) && (paramSpanned.charAt(n - 1) == '\n')) {
            withinDiv(paramStringBuilder, paramSpanned, k, n - 1);
          }
          for (;;)
          {
            if (j != 0) {
              paramStringBuilder.append("</div>");
            }
            if (i != 0) {
              paramStringBuilder.append("</li>");
            }
            k = n;
            break;
            withinDiv(paramStringBuilder, paramSpanned, k, n);
          }
          if (!localStack.empty())
          {
            if ((localStack.peek() instanceof OLBulletSpan)) {
              paramStringBuilder.append("</ol>");
            }
            for (;;)
            {
              localStack.pop();
              break;
              if ((localStack.peek() instanceof ULBulletSpan)) {
                paramStringBuilder.append("</ul>");
              }
            }
          }
          return;
        }
      }
    }
  }
  
  private static void withinParagraph(StringBuilder paramStringBuilder, Spanned paramSpanned, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    for (paramInt3 = paramInt1; paramInt3 < paramInt2; paramInt3 = paramInt1)
    {
      paramInt1 = paramSpanned.nextSpanTransition(paramInt3, paramInt2, CharacterStyle.class);
      CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])paramSpanned.getSpans(paramInt3, paramInt1, CharacterStyle.class);
      int j = 0;
      int i;
      while (j < arrayOfCharacterStyle.length)
      {
        if ((arrayOfCharacterStyle[j] instanceof StyleSpan))
        {
          i = ((StyleSpan)arrayOfCharacterStyle[j]).getStyle();
          if ((i & 0x1) != 0) {
            paramStringBuilder.append("<b>");
          }
          if ((i & 0x2) != 0) {
            paramStringBuilder.append("<i>");
          }
        }
        String str;
        if ((arrayOfCharacterStyle[j] instanceof TypefaceSpan))
        {
          str = ((TypefaceSpan)arrayOfCharacterStyle[j]).getFamily();
          if (!str.equals("monospace")) {
            break label648;
          }
          paramStringBuilder.append("<tt>");
        }
        for (;;)
        {
          if ((arrayOfCharacterStyle[j] instanceof SuperscriptSpan)) {
            paramStringBuilder.append("<sup>");
          }
          if ((arrayOfCharacterStyle[j] instanceof SubscriptSpan)) {
            paramStringBuilder.append("<sub>");
          }
          if ((arrayOfCharacterStyle[j] instanceof UnderlineSpan)) {
            paramStringBuilder.append("<u>");
          }
          if ((arrayOfCharacterStyle[j] instanceof StrikethroughSpan)) {
            paramStringBuilder.append("<strike>");
          }
          if ((arrayOfCharacterStyle[j] instanceof URLSpan))
          {
            paramStringBuilder.append("<a href='");
            paramStringBuilder.append(((URLSpan)arrayOfCharacterStyle[j]).getURL());
            paramStringBuilder.append("'>");
          }
          i = paramInt3;
          if ((arrayOfCharacterStyle[j] instanceof QMAudioSpan))
          {
            if (paramSpanned.getSpanStart(arrayOfCharacterStyle[j]) >= paramInt3)
            {
              paramStringBuilder.append("<audio src=\"");
              paramStringBuilder.append(((QMAudioSpan)arrayOfCharacterStyle[j]).getSource());
              paramStringBuilder.append("\" qmtitle=\"");
              paramStringBuilder.append(((QMAudioSpan)arrayOfCharacterStyle[j]).getName());
              paramStringBuilder.append("\" qmsize=\"");
              paramStringBuilder.append(((QMAudioSpan)arrayOfCharacterStyle[j]).getSizeString());
              paramStringBuilder.append("\" class=\"");
              paramStringBuilder.append(((QMAudioSpan)arrayOfCharacterStyle[j]).getClassString());
              paramStringBuilder.append("\" controls=\"");
              paramStringBuilder.append(((QMAudioSpan)arrayOfCharacterStyle[j]).getControls());
              paramStringBuilder.append("\" preload=\"");
              paramStringBuilder.append(((QMAudioSpan)arrayOfCharacterStyle[j]).getPreload());
              paramStringBuilder.append("\" qmduration=\"");
              paramStringBuilder.append(((QMAudioSpan)arrayOfCharacterStyle[j]).getQmduration());
              paramStringBuilder.append("\"></audio>");
            }
            i = paramInt1;
          }
          paramInt3 = i;
          if ((arrayOfCharacterStyle[j] instanceof ImageSpan))
          {
            if (paramSpanned.getSpanStart(arrayOfCharacterStyle[j]) >= i)
            {
              paramStringBuilder.append("<div><img src=\"");
              paramStringBuilder.append(((ImageSpan)arrayOfCharacterStyle[j]).getSource());
              paramStringBuilder.append("\" class=\"app-upload-image\" style=\"margin:4px 0;\" /></div>");
            }
            paramInt3 = paramInt1;
          }
          if ((arrayOfCharacterStyle[j] instanceof AbsoluteSizeSpan))
          {
            paramStringBuilder.append("<font size='");
            paramStringBuilder.append((int)(((AbsoluteSizeSpan)arrayOfCharacterStyle[j]).getSize() / (QMUIKit.DENSITY * 6.0F)));
            paramStringBuilder.append("'>");
          }
          if (!(arrayOfCharacterStyle[j] instanceof ForegroundColorSpan)) {
            break label688;
          }
          paramStringBuilder.append("<font color='#");
          for (str = Integer.toHexString(((ForegroundColorSpan)arrayOfCharacterStyle[j]).getForegroundColor() + 16777216); str.length() < 6; str = "0" + str) {}
          label648:
          paramStringBuilder.append("<font face=\"");
          paramStringBuilder.append(str);
          paramStringBuilder.append("\">");
        }
        paramStringBuilder.append(str);
        paramStringBuilder.append("'>");
        label688:
        if ((arrayOfCharacterStyle[j] instanceof BackgroundColorSpan))
        {
          paramStringBuilder.append("<font style='background-color:#");
          for (str = Integer.toHexString(((BackgroundColorSpan)arrayOfCharacterStyle[j]).getBackgroundColor() + 16777216); str.length() < 6; str = "0" + str) {}
          paramStringBuilder.append(str);
          paramStringBuilder.append("'>");
        }
        if ((arrayOfCharacterStyle[j] instanceof QMSignSpan)) {
          paramStringBuilder.append("<span class='mail-footer'><sign>");
        }
        j += 1;
      }
      withinStyle(paramStringBuilder, paramSpanned, paramInt3, paramInt1);
      paramInt3 = arrayOfCharacterStyle.length - 1;
      if (paramInt3 >= 0)
      {
        if (((arrayOfCharacterStyle[paramInt3] instanceof ForegroundColorSpan)) || ((arrayOfCharacterStyle[paramInt3] instanceof BackgroundColorSpan))) {
          paramStringBuilder.append("</font>");
        }
        if ((arrayOfCharacterStyle[paramInt3] instanceof AbsoluteSizeSpan)) {
          paramStringBuilder.append("</font>");
        }
        if ((arrayOfCharacterStyle[paramInt3] instanceof URLSpan)) {
          paramStringBuilder.append("</a>");
        }
        if ((arrayOfCharacterStyle[paramInt3] instanceof StrikethroughSpan)) {
          paramStringBuilder.append("</strike>");
        }
        if ((arrayOfCharacterStyle[paramInt3] instanceof UnderlineSpan)) {
          paramStringBuilder.append("</u>");
        }
        if ((arrayOfCharacterStyle[paramInt3] instanceof SubscriptSpan)) {
          paramStringBuilder.append("</sub>");
        }
        if ((arrayOfCharacterStyle[paramInt3] instanceof SuperscriptSpan)) {
          paramStringBuilder.append("</sup>");
        }
        if ((arrayOfCharacterStyle[paramInt3] instanceof TypefaceSpan))
        {
          if (!((TypefaceSpan)arrayOfCharacterStyle[paramInt3]).getFamily().equals("monospace")) {
            break label1089;
          }
          paramStringBuilder.append("</tt>");
        }
        for (;;)
        {
          if ((arrayOfCharacterStyle[paramInt3] instanceof StyleSpan))
          {
            i = ((StyleSpan)arrayOfCharacterStyle[paramInt3]).getStyle();
            if ((i & 0x1) != 0) {
              paramStringBuilder.append("</b>");
            }
            if ((i & 0x2) != 0) {
              paramStringBuilder.append("</i>");
            }
          }
          if ((arrayOfCharacterStyle[paramInt3] instanceof QMSignSpan)) {
            paramStringBuilder.append("</sign></span>");
          }
          paramInt3 -= 1;
          break;
          label1089:
          paramStringBuilder.append("</font>");
        }
      }
    }
  }
  
  private static void withinStyle(StringBuilder paramStringBuilder, Spanned paramSpanned, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      int i = paramSpanned.charAt(paramInt1);
      if ((i == 60) || (i == 60)) {
        paramStringBuilder.append("&lt;");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if ((i == 62) || (i == 62))
        {
          paramStringBuilder.append("&gt;");
        }
        else if ((i == 38) || (i == 38))
        {
          paramStringBuilder.append("&amp;");
        }
        else if (i == 34)
        {
          paramStringBuilder.append("&quot;");
        }
        else if (i == 160)
        {
          paramStringBuilder.append("&nbsp;");
        }
        else if (i == 162)
        {
          paramStringBuilder.append("&cent;");
        }
        else if (i == 163)
        {
          paramStringBuilder.append("&pound;");
        }
        else if (i == 165)
        {
          paramStringBuilder.append("&yen;");
        }
        else if (i == 167)
        {
          paramStringBuilder.append("&sect;");
        }
        else if (i == 169)
        {
          paramStringBuilder.append("&copy;");
        }
        else if (i == 174)
        {
          paramStringBuilder.append("&reg;");
        }
        else if (i == 215)
        {
          paramStringBuilder.append("&times;");
        }
        else if (i == 247)
        {
          paramStringBuilder.append("&divide;");
        }
        else if (i == 8364)
        {
          paramStringBuilder.append("&euro;");
        }
        else if (i == 8482)
        {
          paramStringBuilder.append("&trade;");
        }
        else if ((i > 126) || (i < 32))
        {
          paramStringBuilder.append(i);
        }
        else if (i == 32)
        {
          while ((paramInt1 + 1 < paramInt2) && (paramSpanned.charAt(paramInt1 + 1) == ' '))
          {
            paramStringBuilder.append("&nbsp;");
            paramInt1 += 1;
          }
          paramStringBuilder.append("&nbsp;");
        }
        else
        {
          paramStringBuilder.append(i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.SpannedToHtmlConverter
 * JD-Core Version:    0.7.0.1
 */