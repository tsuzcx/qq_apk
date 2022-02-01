package com.tencent.qqmail.utilities.richeditor;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.Locale;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class HtmlToSpannedConverter
  extends DefaultHandler
{
  private static final float[] HEADER_SIZES = { 1.5F, 1.4F, 1.3F, 1.2F, 1.1F, 1.0F };
  private static final String STYLE = "style";
  public static final String STYLE_TAG = "style";
  private static final String TAG = "HtmlToSpannedConverter";
  boolean bAbleAnalyseHtml = true;
  boolean bTagSoup = false;
  private Html.ImageGetter mImageGetter;
  private String mSource;
  private SpannableStringBuilder mSpannableStringBuilder;
  private SparseArray<Integer> ulMapIndex = new SparseArray();
  
  public HtmlToSpannedConverter(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("html source null");
    }
    this.mSource = paramString;
    this.mSpannableStringBuilder = null;
  }
  
  private static void end(SpannableStringBuilder paramSpannableStringBuilder, Class<?> paramClass, Object paramObject)
  {
    int i = paramSpannableStringBuilder.length();
    paramClass = getLast(paramSpannableStringBuilder, paramClass);
    int j = paramSpannableStringBuilder.getSpanStart(paramClass);
    paramSpannableStringBuilder.removeSpan(paramClass);
    if (j != i) {
      paramSpannableStringBuilder.setSpan(paramObject, j, i, 33);
    }
  }
  
  private static void endA(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    Object localObject = getLast(paramSpannableStringBuilder, Href.class);
    int j = paramSpannableStringBuilder.getSpanStart(localObject);
    paramSpannableStringBuilder.removeSpan(localObject);
    if (j != i)
    {
      localObject = (Href)localObject;
      if (((Href)localObject).mHref != null) {
        paramSpannableStringBuilder.setSpan(new URLSpan(((Href)localObject).mHref), j, i, 33);
      }
    }
  }
  
  private static void endFont(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    Object localObject = getLast(paramSpannableStringBuilder, Font.class);
    int j = paramSpannableStringBuilder.getSpanStart(localObject);
    paramSpannableStringBuilder.removeSpan(localObject);
    if (j != i)
    {
      localObject = (Font)localObject;
      if (((Font)localObject).mColor != -1L) {
        paramSpannableStringBuilder.setSpan(new ForegroundColorSpan((int)(((Font)localObject).mColor & 0xFFFFFFFF)), j, i, 33);
      }
      if (((Font)localObject).mBackgroundColor != -1L) {
        paramSpannableStringBuilder.setSpan(new BackgroundColorSpan((int)(((Font)localObject).mBackgroundColor & 0xFFFFFFFF)), j, i, 33);
      }
      if (((Font)localObject).mFace != null) {
        paramSpannableStringBuilder.setSpan(new TypefaceSpan(((Font)localObject).mFace), j, i, 33);
      }
      if (((Font)localObject).mSize != -1) {
        paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(((Font)localObject).mSize), j, i, 33);
      }
    }
  }
  
  private static void endHeader(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    Object localObject = getLast(paramSpannableStringBuilder, Header.class);
    int j = paramSpannableStringBuilder.getSpanStart(localObject);
    paramSpannableStringBuilder.removeSpan(localObject);
    while ((i > j) && (paramSpannableStringBuilder.charAt(i - 1) == '\n')) {
      i -= 1;
    }
    if (j != i)
    {
      localObject = (Header)localObject;
      paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(HEADER_SIZES[localObject.mLevel]), j, i, 33);
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), j, i, 33);
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  private void endLi(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int m = 0;
    int i = 0;
    int k = 1;
    handleP(paramSpannableStringBuilder);
    int n = paramSpannableStringBuilder.length();
    Object localObject1 = getLast(paramSpannableStringBuilder, LiBullet.class);
    int i1 = paramSpannableStringBuilder.getSpanStart(localObject1);
    paramSpannableStringBuilder.removeSpan(localObject1);
    int j;
    Object localObject2;
    if (i1 != n)
    {
      localObject1 = paramSpannableStringBuilder.getSpans(0, n, Bullet.class);
      if (localObject1 != null) {
        break label137;
      }
      j = 1;
      localObject2 = getLast(paramSpannableStringBuilder, UlBullet.class);
      localObject1 = (OlBullet)getLast(paramSpannableStringBuilder, OlBullet.class);
      if ((localObject2 == null) || (localObject1 == null)) {
        break label144;
      }
      if (paramSpannableStringBuilder.getSpanStart(localObject2) >= paramSpannableStringBuilder.getSpanStart(localObject1)) {
        i = 1;
      }
    }
    label137:
    label144:
    label247:
    label250:
    for (;;)
    {
      if (i != 0)
      {
        paramSpannableStringBuilder.setSpan(new QMBulletSpan(24, -1, j), i1, n, 33);
        return;
        j = localObject1.length;
        break;
        if (localObject1 == null) {
          break label247;
        }
      }
      for (i = m;; i = 1)
      {
        if (localObject2 == null) {
          break label250;
        }
        i = 1;
        break;
        localObject2 = new QMBulletSpan(24, ((OlBullet)localObject1).getGroupIndex(), j);
        Integer localInteger = (Integer)this.ulMapIndex.get(((OlBullet)localObject1).getGroupIndex());
        i = k;
        if (localInteger != null) {
          i = localInteger.intValue() + 1;
        }
        this.ulMapIndex.put(((OlBullet)localObject1).getGroupIndex(), Integer.valueOf(i));
        ((QMBulletSpan)localObject2).setIndex(i);
        paramSpannableStringBuilder.setSpan(localObject2, i1, n, 33);
        return;
      }
    }
  }
  
  private void endSign(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    Object localObject = getLast(paramSpannableStringBuilder, QMSignSpan.class);
    int j = paramSpannableStringBuilder.getSpanStart(localObject);
    paramSpannableStringBuilder.removeSpan(localObject);
    paramSpannableStringBuilder.setSpan(new QMSignSpan(QMApplicationContext.sharedInstance(), 2131756053), j, i, 33);
  }
  
  private void endSoloScript(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = getLast(paramSpannableStringBuilder, SoloScript.class);
    int i = paramSpannableStringBuilder.getSpanStart(localObject);
    int j = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.removeSpan(localObject);
    paramSpannableStringBuilder.delete(i, j);
  }
  
  private void endSoloStyle(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = getLast(paramSpannableStringBuilder, SoloStyle.class);
    int i = paramSpannableStringBuilder.getSpanStart(localObject);
    int j = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.removeSpan(localObject);
    paramSpannableStringBuilder.delete(i, j);
  }
  
  private static void endStyle(SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    int i = paramSpannableStringBuilder.length();
    paramString = (Style)getLast(paramSpannableStringBuilder, Style.class);
    int j = paramSpannableStringBuilder.getSpanStart(paramString);
    paramSpannableStringBuilder.removeSpan(paramString);
    if (j != i)
    {
      paramString = paramString.font;
      if (paramString != null)
      {
        if (paramString.mColor >= 0L) {
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan((int)(paramString.mColor & 0xFFFFFFFF)), j, i, 33);
        }
        if (paramString.mBackgroundColor != -1L) {
          paramSpannableStringBuilder.setSpan(new BackgroundColorSpan((int)(paramString.mBackgroundColor & 0xFFFFFFFF)), j, i, 33);
        }
        if (paramString.mFace != null) {
          paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramString.mFace), j, i, 33);
        }
        if (paramString.mSize != -1) {
          paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(paramString.mSize), j, i, 33);
        }
      }
    }
  }
  
  private void endTitle(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = getLast(paramSpannableStringBuilder, Title.class);
    int i = paramSpannableStringBuilder.getSpanStart(localObject);
    int j = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.removeSpan(localObject);
    paramSpannableStringBuilder.delete(i, j);
  }
  
  static long getHtmlColor(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.trim().toLowerCase(Locale.getDefault());
      if ((paramString.startsWith("rgb(")) && (paramString.endsWith(")")))
      {
        paramString = paramString.substring(4, paramString.length() - 1).split(",");
        if (paramString.length != 3) {}
      }
      else
      {
        for (;;)
        {
          try
          {
            i = Color.rgb(Integer.parseInt(paramString[0].trim()) & 0xFF, Integer.parseInt(paramString[1].trim()) & 0xFF, Integer.parseInt(paramString[2].trim()) & 0xFF);
            return i & 0xFFFFFFFF;
          }
          catch (NumberFormatException paramString)
          {
            int i;
            continue;
          }
          try
          {
            i = Color.parseColor(paramString);
            return i & 0xFFFFFFFF;
          }
          catch (Exception paramString) {}
        }
      }
    }
    return -1L;
  }
  
  private static Object getLast(Spanned paramSpanned, Class<?> paramClass)
  {
    paramSpanned = paramSpanned.getSpans(0, paramSpanned.length(), paramClass);
    if (paramSpanned.length == 0) {
      return null;
    }
    return paramSpanned[(paramSpanned.length - 1)];
  }
  
  private XMLReader getXMLReader()
  {
    try
    {
      Class localClass = Class.forName("org.ccil.cowan.tagsoup.Parser");
      XMLReader localXMLReader = (XMLReader)localClass.newInstance();
      Object localObject2 = HTMLSchema.getSchema();
      localXMLReader.setProperty((String)localClass.getField("schemaProperty").get(null), localObject2);
      this.bTagSoup = true;
      return localXMLReader;
    }
    catch (Exception localException)
    {
      this.bTagSoup = false;
      Object localObject1 = SAXParserFactory.newInstance();
      ((SAXParserFactory)localObject1).setValidating(false);
      try
      {
        localObject1 = ((SAXParserFactory)localObject1).newSAXParser().getXMLReader();
        return localObject1;
      }
      catch (ParserConfigurationException localParserConfigurationException)
      {
        return null;
      }
      catch (SAXException localSAXException) {}
    }
    return null;
  }
  
  private static void handleBr(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append("\n");
  }
  
  private void handleEndTag(String paramString)
  {
    endStyle(this.mSpannableStringBuilder, paramString);
    if (paramString.equalsIgnoreCase("br")) {
      handleBr(this.mSpannableStringBuilder);
    }
    do
    {
      return;
      if (paramString.equalsIgnoreCase("p"))
      {
        handleP(this.mSpannableStringBuilder);
        return;
      }
      if (paramString.equalsIgnoreCase("div"))
      {
        handleP(this.mSpannableStringBuilder);
        return;
      }
      if (paramString.equalsIgnoreCase("em"))
      {
        end(this.mSpannableStringBuilder, Bold.class, new StyleSpan(1));
        return;
      }
      if (paramString.equalsIgnoreCase("b"))
      {
        end(this.mSpannableStringBuilder, Bold.class, new StyleSpan(1));
        return;
      }
      if (paramString.equalsIgnoreCase("strong"))
      {
        end(this.mSpannableStringBuilder, Italic.class, new StyleSpan(2));
        return;
      }
      if (paramString.equalsIgnoreCase("cite"))
      {
        end(this.mSpannableStringBuilder, Italic.class, new StyleSpan(2));
        return;
      }
      if (paramString.equalsIgnoreCase("dfn"))
      {
        end(this.mSpannableStringBuilder, Italic.class, new StyleSpan(2));
        return;
      }
      if (paramString.equalsIgnoreCase("i"))
      {
        end(this.mSpannableStringBuilder, Italic.class, new StyleSpan(2));
        return;
      }
      if (paramString.equalsIgnoreCase("big"))
      {
        end(this.mSpannableStringBuilder, Big.class, new RelativeSizeSpan(1.25F));
        return;
      }
      if (paramString.equalsIgnoreCase("small"))
      {
        end(this.mSpannableStringBuilder, Small.class, new RelativeSizeSpan(0.8F));
        return;
      }
      if (paramString.equalsIgnoreCase("font"))
      {
        endFont(this.mSpannableStringBuilder);
        return;
      }
      if (paramString.equalsIgnoreCase("blockquote"))
      {
        handleP(this.mSpannableStringBuilder);
        end(this.mSpannableStringBuilder, Blockquote.class, new QMQuoteSpan());
        return;
      }
      if (paramString.equalsIgnoreCase("tt"))
      {
        end(this.mSpannableStringBuilder, Monospace.class, new TypefaceSpan("monospace"));
        return;
      }
      if (paramString.equalsIgnoreCase("a"))
      {
        endA(this.mSpannableStringBuilder);
        return;
      }
      if (paramString.equalsIgnoreCase("u"))
      {
        end(this.mSpannableStringBuilder, Underline.class, new UnderlineSpan());
        return;
      }
      if (paramString.equalsIgnoreCase("sup"))
      {
        end(this.mSpannableStringBuilder, Super.class, new SuperscriptSpan());
        return;
      }
      if (paramString.equalsIgnoreCase("sub"))
      {
        end(this.mSpannableStringBuilder, Sub.class, new SubscriptSpan());
        return;
      }
      if (paramString.equalsIgnoreCase("ul"))
      {
        end(this.mSpannableStringBuilder, UlBullet.class, new ULBulletSpan());
        return;
      }
      if (paramString.equalsIgnoreCase("ol"))
      {
        end(this.mSpannableStringBuilder, OlBullet.class, new OLBulletSpan());
        return;
      }
      if (paramString.equalsIgnoreCase("li"))
      {
        endLi(this.mSpannableStringBuilder);
        return;
      }
      if ((paramString.length() == 2) && (Character.toLowerCase(paramString.charAt(0)) == 'h') && (paramString.charAt(1) >= '1') && (paramString.charAt(1) <= '6'))
      {
        handleP(this.mSpannableStringBuilder);
        endHeader(this.mSpannableStringBuilder);
        return;
      }
      if (paramString.equalsIgnoreCase("sign"))
      {
        endSign(this.mSpannableStringBuilder);
        return;
      }
      if (paramString.equalsIgnoreCase("style"))
      {
        endSoloStyle(this.mSpannableStringBuilder);
        return;
      }
      if (paramString.equalsIgnoreCase("title"))
      {
        endTitle(this.mSpannableStringBuilder);
        return;
      }
    } while (!paramString.equalsIgnoreCase("script"));
    endSoloScript(this.mSpannableStringBuilder);
  }
  
  private static void handleP(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    if ((i >= 1) && (paramSpannableStringBuilder.charAt(i - 1) != '\n')) {
      paramSpannableStringBuilder.append("\n");
    }
  }
  
  private void handleStartTag(String paramString, Attributes paramAttributes)
  {
    if (paramString.equalsIgnoreCase("br")) {}
    for (;;)
    {
      startStyle(this.mSpannableStringBuilder, paramString, paramAttributes);
      return;
      if (paramString.equalsIgnoreCase("p"))
      {
        handleP(this.mSpannableStringBuilder);
      }
      else if (paramString.equalsIgnoreCase("div"))
      {
        handleP(this.mSpannableStringBuilder);
      }
      else if (paramString.equalsIgnoreCase("em"))
      {
        start(this.mSpannableStringBuilder, new Bold(null));
      }
      else if (paramString.equalsIgnoreCase("b"))
      {
        start(this.mSpannableStringBuilder, new Bold(null));
      }
      else if (paramString.equalsIgnoreCase("strong"))
      {
        start(this.mSpannableStringBuilder, new Italic(null));
      }
      else if (paramString.equalsIgnoreCase("cite"))
      {
        start(this.mSpannableStringBuilder, new Italic(null));
      }
      else if (paramString.equalsIgnoreCase("dfn"))
      {
        start(this.mSpannableStringBuilder, new Italic(null));
      }
      else if (paramString.equalsIgnoreCase("i"))
      {
        start(this.mSpannableStringBuilder, new Italic(null));
      }
      else if (paramString.equalsIgnoreCase("big"))
      {
        start(this.mSpannableStringBuilder, new Big(null));
      }
      else if (paramString.equalsIgnoreCase("small"))
      {
        start(this.mSpannableStringBuilder, new Small(null));
      }
      else if (paramString.equalsIgnoreCase("font"))
      {
        startFont(this.mSpannableStringBuilder, paramString, paramAttributes);
      }
      else if (paramString.equalsIgnoreCase("blockquote"))
      {
        handleP(this.mSpannableStringBuilder);
        start(this.mSpannableStringBuilder, new Blockquote(null));
      }
      else if (paramString.equalsIgnoreCase("tt"))
      {
        start(this.mSpannableStringBuilder, new Monospace(null));
      }
      else if (paramString.equalsIgnoreCase("a"))
      {
        startA(this.mSpannableStringBuilder, paramString, paramAttributes);
      }
      else if (paramString.equalsIgnoreCase("u"))
      {
        start(this.mSpannableStringBuilder, new Underline(null));
      }
      else if (paramString.equalsIgnoreCase("sup"))
      {
        start(this.mSpannableStringBuilder, new Super(null));
      }
      else if (paramString.equalsIgnoreCase("sub"))
      {
        start(this.mSpannableStringBuilder, new Sub(null));
      }
      else if (paramString.equalsIgnoreCase("ul"))
      {
        handleP(this.mSpannableStringBuilder);
        start(this.mSpannableStringBuilder, new UlBullet(null));
      }
      else if (paramString.equalsIgnoreCase("ol"))
      {
        handleP(this.mSpannableStringBuilder);
        start(this.mSpannableStringBuilder, new OlBullet());
      }
      else if (paramString.equalsIgnoreCase("li"))
      {
        startLi(this.mSpannableStringBuilder);
      }
      else if ((paramString.length() == 2) && (Character.toLowerCase(paramString.charAt(0)) == 'h') && (paramString.charAt(1) >= '1') && (paramString.charAt(1) <= '6'))
      {
        handleP(this.mSpannableStringBuilder);
        start(this.mSpannableStringBuilder, new Header(paramString.charAt(1) - '1'));
      }
      else if (paramString.equalsIgnoreCase("img"))
      {
        startImg(this.mSpannableStringBuilder, paramAttributes, this.mImageGetter);
      }
      else if (paramString.equalsIgnoreCase("audio"))
      {
        startAudio(this.mSpannableStringBuilder, paramAttributes);
      }
      else if (paramString.equalsIgnoreCase("sign"))
      {
        startSign(this.mSpannableStringBuilder);
      }
      else if (paramString.equalsIgnoreCase("style"))
      {
        startSoloStyle(this.mSpannableStringBuilder);
      }
      else if (paramString.equalsIgnoreCase("title"))
      {
        startTitle(this.mSpannableStringBuilder);
      }
      else if (paramString.equalsIgnoreCase("script"))
      {
        startSoloScript(this.mSpannableStringBuilder);
      }
    }
  }
  
  private static void removeTag(SpannableStringBuilder paramSpannableStringBuilder, Class<?> paramClass)
  {
    paramSpannableStringBuilder.removeSpan(getLast(paramSpannableStringBuilder, paramClass));
  }
  
  private static int safeParseInt(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  private static void start(SpannableStringBuilder paramSpannableStringBuilder, Object paramObject)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(paramObject, i, i, 17);
  }
  
  private static void startA(SpannableStringBuilder paramSpannableStringBuilder, String paramString, Attributes paramAttributes)
  {
    String str = paramAttributes.getValue("", "href");
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(new Href(paramString, paramAttributes, str), i, i, 17);
  }
  
  private static void startAudio(SpannableStringBuilder paramSpannableStringBuilder, Attributes paramAttributes)
  {
    String str1 = paramAttributes.getValue("", "src");
    String str2 = paramAttributes.getValue("", "qmtitle");
    String str3 = paramAttributes.getValue("", "qmsize");
    paramAttributes.getValue("", "class");
    paramAttributes.getValue("", "controls");
    paramAttributes.getValue("", "preload");
    paramAttributes.getValue("", "qmduration");
    paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append("audio:name=" + str2 + ",size=" + StringExtention.sizeStrToLong(str3) + ",src=" + str1 + ";");
  }
  
  private static void startFont(SpannableStringBuilder paramSpannableStringBuilder, String paramString, Attributes paramAttributes)
  {
    int i = 2;
    paramString = paramAttributes.getValue("", "color");
    String str = paramAttributes.getValue("", "face");
    paramAttributes = paramAttributes.getValue("", "size");
    int j;
    if (paramAttributes != null)
    {
      j = safeParseInt(paramAttributes, 0);
      if (j >= 2) {}
    }
    for (i = (int)(i * 6 * QMUIKit.DENSITY);; i = -1)
    {
      j = paramSpannableStringBuilder.length();
      paramSpannableStringBuilder.setSpan(new Font(paramString, null, str, i), j, j, 17);
      return;
      if (j > 7)
      {
        i = 7;
        break;
      }
      i = j;
      break;
    }
  }
  
  private static void startImg(SpannableStringBuilder paramSpannableStringBuilder, Attributes paramAttributes, Html.ImageGetter paramImageGetter)
  {
    paramAttributes = paramAttributes.getValue("", "src");
    paramImageGetter = Resources.getSystem().getDrawable(17301606);
    paramImageGetter.setBounds(0, 0, paramImageGetter.getIntrinsicWidth(), paramImageGetter.getIntrinsicHeight());
    paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append("image:" + paramAttributes + ";");
  }
  
  private static void startLi(SpannableStringBuilder paramSpannableStringBuilder)
  {
    handleP(paramSpannableStringBuilder);
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(new LiBullet(null), i, i, 17);
  }
  
  private void startSign(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(new QMSignSpan(QMApplicationContext.sharedInstance(), 2131756053), i, i, 17);
  }
  
  private void startSoloScript(SpannableStringBuilder paramSpannableStringBuilder)
  {
    SoloScript localSoloScript = new SoloScript();
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(localSoloScript, i, i, 17);
  }
  
  private void startSoloStyle(SpannableStringBuilder paramSpannableStringBuilder)
  {
    SoloStyle localSoloStyle = new SoloStyle();
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(localSoloStyle, i, i, 17);
  }
  
  private void startStyle(SpannableStringBuilder paramSpannableStringBuilder, String paramString, Attributes paramAttributes)
  {
    Style localStyle = new Style();
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(localStyle, i, i, 17);
    if (paramAttributes == null) {}
    do
    {
      return;
      paramAttributes = paramAttributes.getValue("", "style");
    } while ((paramAttributes == null) || (paramAttributes.equals("")));
    paramSpannableStringBuilder = null;
    paramString = null;
    String[] arrayOfString = paramAttributes.split(";");
    int m = arrayOfString.length;
    int j = 0;
    i = -1;
    paramAttributes = null;
    for (;;)
    {
      if (j < m)
      {
        Object localObject1 = arrayOfString[j].trim().split(":");
        k = i;
        localAttributes = paramAttributes;
        localObject3 = paramString;
        localObject2 = paramSpannableStringBuilder;
        if (localObject1.length != 2) {
          break label379;
        }
        String str2 = localObject1[0].trim();
        localObject1 = localObject1[1].trim();
        k = i;
        localAttributes = paramAttributes;
        localObject3 = paramString;
        localObject2 = paramSpannableStringBuilder;
        if (str2.length() <= 0) {
          break label379;
        }
        k = i;
        localAttributes = paramAttributes;
        localObject3 = paramString;
        localObject2 = paramSpannableStringBuilder;
        if (((String)localObject1).length() <= 0) {
          break label379;
        }
        try
        {
          if ("color".equalsIgnoreCase(str2))
          {
            paramSpannableStringBuilder = paramString;
            paramString = (String)localObject1;
          }
          else if ("background-color".equalsIgnoreCase(str2))
          {
            paramString = paramSpannableStringBuilder;
            paramSpannableStringBuilder = (SpannableStringBuilder)localObject1;
          }
          else if ("font-family".equalsIgnoreCase(str2))
          {
            paramAttributes = (Attributes)localObject1;
            localObject1 = paramSpannableStringBuilder;
            paramSpannableStringBuilder = paramString;
            paramString = (String)localObject1;
          }
          else
          {
            boolean bool = "font-size".equalsIgnoreCase(str2);
            if (bool)
            {
              i = 0;
              localObject1 = paramSpannableStringBuilder;
              paramSpannableStringBuilder = paramString;
              paramString = (String)localObject1;
            }
          }
        }
        catch (Exception localException)
        {
          this.bAbleAnalyseHtml = false;
          k = i;
          localAttributes = paramAttributes;
          localObject3 = paramString;
          localObject2 = paramSpannableStringBuilder;
          break label379;
        }
      }
      else
      {
        if ((paramSpannableStringBuilder == null) && (paramString == null) && (paramAttributes == null) && (i < 0)) {
          break;
        }
        j = i;
        if (i < 16) {
          j = 16;
        }
        localStyle.font = new Font(paramSpannableStringBuilder, paramString, paramAttributes, (int)(j * QMUIKit.DENSITY));
        return;
      }
      String str1 = paramString;
      paramString = paramSpannableStringBuilder;
      paramSpannableStringBuilder = str1;
      Object localObject2 = paramString;
      Object localObject3 = paramSpannableStringBuilder;
      Attributes localAttributes = paramAttributes;
      int k = i;
      label379:
      j += 1;
      i = k;
      paramAttributes = localAttributes;
      paramString = (String)localObject3;
      paramSpannableStringBuilder = (SpannableStringBuilder)localObject2;
    }
  }
  
  private void startTitle(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Title localTitle = new Title();
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.setSpan(localTitle, i, i, 17);
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    if (j < paramInt2)
    {
      char c = paramArrayOfChar[(j + paramInt1)];
      int i;
      if ((c == ' ') || (c == '\n'))
      {
        i = localStringBuilder.length();
        if (i == 0)
        {
          i = this.mSpannableStringBuilder.length();
          if (i == 0)
          {
            i = 10;
            label70:
            if ((i != 32) && (i != 10)) {
              localStringBuilder.append(' ');
            }
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = this.mSpannableStringBuilder.charAt(i - 1);
        break label70;
        i = localStringBuilder.charAt(i - 1);
        break label70;
        localStringBuilder.append(c);
      }
    }
    this.mSpannableStringBuilder.append(localStringBuilder);
  }
  
  public void endDocument()
    throws SAXException
  {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    handleEndTag(paramString2);
  }
  
  public void endPrefixMapping(String paramString)
    throws SAXException
  {}
  
  public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {}
  
  public Spanned looseConvert()
  {
    this.mSpannableStringBuilder = new SpannableStringBuilder();
    for (;;)
    {
      int i;
      try
      {
        Object localObject = getXMLReader();
        ((XMLReader)localObject).setContentHandler(this);
        ((XMLReader)localObject).parse(new InputSource(new StringReader(this.mSource)));
        localObject = this.mSpannableStringBuilder.getSpans(0, this.mSpannableStringBuilder.length(), ParagraphStyle.class);
        i = 0;
        if (i < localObject.length)
        {
          int m = this.mSpannableStringBuilder.getSpanStart(localObject[i]);
          int k = this.mSpannableStringBuilder.getSpanEnd(localObject[i]);
          int j = k;
          if (k - 2 >= 0)
          {
            j = k;
            if (this.mSpannableStringBuilder.charAt(k - 1) == '\n')
            {
              j = k;
              if (this.mSpannableStringBuilder.charAt(k - 2) == '\n') {
                j = k - 1;
              }
            }
          }
          if (j == m) {
            this.mSpannableStringBuilder.removeSpan(localObject[i]);
          } else {
            this.mSpannableStringBuilder.setSpan(localObject[i], m, j, 51);
          }
        }
      }
      catch (SAXException localSAXException)
      {
        QMLog.log(6, "HtmlToSpannedConverter", "Exception in looseConvent", localSAXException);
        this.mSpannableStringBuilder = null;
        return this.mSpannableStringBuilder;
      }
      catch (IOException localIOException)
      {
        QMLog.log(6, "HtmlToSpannedConverter", "Exception in looseConvent", localIOException);
        localIOException.printStackTrace();
        continue;
      }
      i += 1;
    }
  }
  
  public void processingInstruction(String paramString1, String paramString2)
    throws SAXException
  {}
  
  public void setDocumentLocator(Locator paramLocator) {}
  
  public void skippedEntity(String paramString)
    throws SAXException
  {}
  
  public void startDocument()
    throws SAXException
  {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    handleStartTag(paramString2, paramAttributes);
  }
  
  public void startPrefixMapping(String paramString1, String paramString2)
    throws SAXException
  {}
  
  public static class BaseOriginalTag {}
  
  static class Big
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class Blockquote
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class Bold
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class Bullet
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class Font
    extends HtmlToSpannedConverter.BaseOriginalTag
  {
    public static final long COLOR_MASK = 4294967295L;
    public final long mBackgroundColor;
    public final long mColor;
    public final String mFace;
    public int mSize;
    
    public Font(long paramLong1, long paramLong2, String paramString, int paramInt)
    {
      this.mColor = paramLong1;
      this.mBackgroundColor = paramLong2;
      String str = paramString;
      if (paramString != null)
      {
        paramString = paramString.trim();
        str = paramString;
        if (paramString.startsWith("'"))
        {
          str = paramString;
          if (paramString.endsWith("'")) {
            str = paramString.substring(1, paramString.length() - 1);
          }
        }
      }
      this.mFace = str;
      this.mSize = paramInt;
    }
    
    public Font(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this(HtmlToSpannedConverter.getHtmlColor(paramString1), HtmlToSpannedConverter.getHtmlColor(paramString2), paramString3, paramInt);
    }
  }
  
  static class HTMLSchema
  {
    private static final String CLASS_NAME = "android.text.Html$HtmlParser";
    private static final String SCHEMA_FIELD = "schema";
    private static Object schema = ;
    
    static
    {
      if (schema == null) {
        schema = getInjectSchema();
      }
    }
    
    private static Object getHackSchema()
    {
      Object localObject2 = null;
      Object localObject1 = Html.class.getDeclaredClasses();
      int j = localObject1.length;
      int i = 0;
      Field localField;
      if (i < j)
      {
        localField = localObject1[i];
        if (!localField.getName().endsWith("android.text.Html$HtmlParser")) {}
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (localField != null) {}
        try
        {
          localField = localField.getDeclaredField("schema");
          localObject1 = localObject2;
          if (localField != null)
          {
            localField.setAccessible(true);
            localObject1 = localField.get(null);
          }
          return localObject1;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          QMLog.log(6, "HtmlToSpannedConverter", "failed to get field android.text.Html$HtmlParser.schema");
          return null;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          QMLog.log(6, "HtmlToSpannedConverter", "failed to access field android.text.Html$HtmlParser.schema");
          return null;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          QMLog.log(6, "HtmlToSpannedConverter", "failed to get object in field android.text.Html$HtmlParser.schema");
          return null;
        }
        catch (Exception localException)
        {
          QMLog.log(6, "HtmlToSpannedConverter", "failed to get field android.text.Html$HtmlParser.schema");
          return null;
        }
        i += 1;
        break;
        localField = null;
      }
    }
    
    private static Object getInjectSchema()
    {
      try
      {
        Object localObject = Class.forName("org.ccil.cowan.tagsoup.HTMLSchema").newInstance();
        return localObject;
      }
      catch (InstantiationException localInstantiationException)
      {
        QMLog.log(6, "HtmlToSpannedConverter", "failed to initialize org.ccil.cowan.tagsoup.HTMLSchema");
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QMLog.log(6, "HtmlToSpannedConverter", "failed to access org.ccil.cowan.tagsoup.HTMLSchema");
        return null;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        QMLog.log(6, "HtmlToSpannedConverter", "class org.ccil.cowan.tagsoup.HTMLSchema not found.");
      }
      return null;
    }
    
    public static Object getSchema()
    {
      return schema;
    }
  }
  
  static class Header
    extends HtmlToSpannedConverter.BaseOriginalTag
  {
    private final int mLevel;
    
    public Header(int paramInt)
    {
      this.mLevel = paramInt;
    }
  }
  
  static class Href
    extends HtmlToSpannedConverter.BaseOriginalTag
  {
    public final String mHref;
    
    public Href(String paramString1, Attributes paramAttributes, String paramString2)
    {
      this.mHref = paramString2;
    }
  }
  
  static class Italic
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class LiBullet
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class Monospace
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class OlBullet
    extends HtmlToSpannedConverter.Bullet
  {
    private static int groupIndex = 0;
    private final int mGroupIndex;
    
    public OlBullet()
    {
      super();
      int i = groupIndex + 1;
      groupIndex = i;
      this.mGroupIndex = i;
    }
    
    public int getGroupIndex()
    {
      return this.mGroupIndex;
    }
  }
  
  static class Small
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  public static class SoloScript
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  public static class SoloStyle
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  public static class Style
    extends HtmlToSpannedConverter.BaseOriginalTag
  {
    public HtmlToSpannedConverter.Font font = null;
  }
  
  static class Sub
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class Super
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  public static class Title
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
  
  static class UlBullet
    extends HtmlToSpannedConverter.Bullet
  {
    private UlBullet()
    {
      super();
    }
  }
  
  static class Underline
    extends HtmlToSpannedConverter.BaseOriginalTag
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.HtmlToSpannedConverter
 * JD-Core Version:    0.7.0.1
 */