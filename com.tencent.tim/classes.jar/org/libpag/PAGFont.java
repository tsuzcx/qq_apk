package org.libpag;

import android.content.res.AssetManager;
import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.extra.tools.LibraryLoadUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class PAGFont
{
  private static final String DefaultLanguage = "zh-Hans";
  private static final Pattern FILENAME_WHITESPACE_PATTERN;
  private static final String[] FallbackFontFileNames = { "/system/fonts/NotoSansCJK-Regular.ttc", "/system/fonts/NotoSansSC-Regular.otf", "/system/fonts/DroidSansFallback.ttf" };
  private static final String SystemFontConfigPath_JellyBean = "/system/etc/fallback_fonts.xml";
  private static final String SystemFontConfigPath_Lollipop = "/system/etc/fonts.xml";
  private static final String SystemFontPath = "/system/fonts/";
  private static boolean systemFontLoaded;
  public String fontFamily = "";
  public String fontStyle = "";
  
  static
  {
    FILENAME_WHITESPACE_PATTERN = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    systemFontLoaded = false;
    LibraryLoadUtils.loadLibrary("libpag");
    loadSystemFonts();
  }
  
  public PAGFont() {}
  
  public PAGFont(String paramString1, String paramString2)
  {
    this.fontFamily = paramString1;
    this.fontStyle = paramString2;
  }
  
  public static PAGFont RegisterFont(AssetManager paramAssetManager, String paramString)
  {
    return RegisterFont(paramAssetManager, paramString, 0);
  }
  
  public static native PAGFont RegisterFont(AssetManager paramAssetManager, String paramString, int paramInt);
  
  public static PAGFont RegisterFont(String paramString)
  {
    return RegisterFont(paramString, 0);
  }
  
  public static native PAGFont RegisterFont(String paramString, int paramInt);
  
  private static native PAGFont RegisterFontBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native void SetFallbackFontPaths(String[] paramArrayOfString, int[] paramArrayOfInt);
  
  private static void addFont(FontConfig paramFontConfig, ArrayList<String> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    if (paramArrayList.contains(paramFontConfig.fileName)) {}
    while (!new File(paramFontConfig.fileName).exists()) {
      return;
    }
    paramArrayList.add(paramFontConfig.fileName);
    paramArrayList1.add(Integer.valueOf(paramFontConfig.ttcIndex));
  }
  
  private static FontConfig getFontByLanguage(FontConfig[] paramArrayOfFontConfig, String paramString)
  {
    paramString = paramString.toLowerCase();
    int j = paramArrayOfFontConfig.length;
    int i = 0;
    while (i < j)
    {
      FontConfig localFontConfig = paramArrayOfFontConfig[i];
      if (localFontConfig.language.toLowerCase().equals(paramString)) {
        return localFontConfig;
      }
      i += 1;
    }
    return null;
  }
  
  static void loadSystemFonts()
  {
    int j = 0;
    if (systemFontLoaded) {}
    do
    {
      return;
      systemFontLoaded = true;
      localObject1 = new FontConfig[0];
      if (new File("/system/etc/fonts.xml").exists()) {}
      for (;;)
      {
        try
        {
          localObject2 = parseLollipop();
          localObject1 = localObject2;
        }
        catch (Exception localException1)
        {
          Object localObject2;
          Object localObject4;
          Object localObject5;
          FontConfig localFontConfig;
          localException1.printStackTrace();
          continue;
        }
        localObject3 = new ArrayList();
        localObject2 = new ArrayList();
        localObject4 = getFontByLanguage((FontConfig[])localObject1, "zh-Hans");
        if (localObject4 != null) {
          addFont((FontConfig)localObject4, (ArrayList)localObject3, (ArrayList)localObject2);
        }
        localObject4 = FallbackFontFileNames;
        k = localObject4.length;
        i = 0;
        if (i >= k) {
          break;
        }
        localObject5 = localObject4[i];
        localFontConfig = new FontConfig(null);
        localFontConfig.fileName = localObject5;
        addFont(localFontConfig, (ArrayList)localObject3, (ArrayList)localObject2);
        i += 1;
        continue;
        try
        {
          FontConfig[] arrayOfFontConfig = parseJellyBean();
          localObject1 = arrayOfFontConfig;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      int k = localObject1.length;
      i = 0;
      while (i < k)
      {
        addFont(localObject1[i], (ArrayList)localObject3, localException2);
        i += 1;
      }
    } while (((ArrayList)localObject3).isEmpty());
    Object localObject1 = new String[((ArrayList)localObject3).size()];
    ((ArrayList)localObject3).toArray((Object[])localObject1);
    Object localObject3 = new int[localException2.size()];
    Iterator localIterator = localException2.iterator();
    int i = j;
    while (localIterator.hasNext())
    {
      localObject3[i] = ((Integer)localIterator.next()).intValue();
      i += 1;
    }
    SetFallbackFontPaths((String[])localObject1, (int[])localObject3);
  }
  
  private static FontConfig[] parseJellyBean()
    throws XmlPullParserException, IOException
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("/system/etc/fallback_fonts.xml");
      try
      {
        Object localObject1 = Xml.newPullParser();
        ((XmlPullParser)localObject1).setInput(localFileInputStream, null);
        ((XmlPullParser)localObject1).nextTag();
        localObject1 = readFamiliesJellyBean((XmlPullParser)localObject1);
        return localObject1;
      }
      finally
      {
        localFileInputStream.close();
      }
      return new FontConfig[0];
    }
    catch (IOException localIOException) {}
  }
  
  private static FontConfig[] parseLollipop()
    throws XmlPullParserException, IOException
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("/system/etc/fonts.xml");
      try
      {
        Object localObject1 = Xml.newPullParser();
        ((XmlPullParser)localObject1).setInput(localFileInputStream, null);
        ((XmlPullParser)localObject1).nextTag();
        localObject1 = readFamilies((XmlPullParser)localObject1);
        return localObject1;
      }
      finally
      {
        localFileInputStream.close();
      }
      return new FontConfig[0];
    }
    catch (IOException localIOException) {}
  }
  
  private static FontConfig[] readFamilies(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramXmlPullParser.require(2, null, "familyset");
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("family")) {
          readFamily(paramXmlPullParser, localArrayList);
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    paramXmlPullParser = new FontConfig[localArrayList.size()];
    localArrayList.toArray(paramXmlPullParser);
    return paramXmlPullParser;
  }
  
  private static FontConfig[] readFamiliesJellyBean(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramXmlPullParser.require(2, null, "familyset");
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("family")) {
          while (paramXmlPullParser.next() != 3) {
            if (paramXmlPullParser.getEventType() == 2) {
              if (paramXmlPullParser.getName().equals("fileset")) {
                readFileset(paramXmlPullParser, localArrayList);
              } else {
                skip(paramXmlPullParser);
              }
            }
          }
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    paramXmlPullParser = new FontConfig[localArrayList.size()];
    localArrayList.toArray(paramXmlPullParser);
    return paramXmlPullParser;
  }
  
  private static void readFamily(XmlPullParser paramXmlPullParser, ArrayList<FontConfig> paramArrayList)
    throws XmlPullParserException, IOException
  {
    paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "lang");
    ArrayList localArrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          localArrayList.add(readFont(paramXmlPullParser));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    Object localObject = localArrayList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramXmlPullParser = (FontConfig)((Iterator)localObject).next();
    } while (paramXmlPullParser.weight != 400);
    for (;;)
    {
      localObject = paramXmlPullParser;
      if (paramXmlPullParser == null) {
        localObject = (FontConfig)localArrayList.get(0);
      }
      if (((FontConfig)localObject).fileName.isEmpty()) {
        break;
      }
      paramXmlPullParser = str;
      if (str == null) {
        paramXmlPullParser = "";
      }
      ((FontConfig)localObject).language = paramXmlPullParser;
      paramArrayList.add(localObject);
      return;
      paramXmlPullParser = null;
    }
  }
  
  private static void readFileset(XmlPullParser paramXmlPullParser, ArrayList<FontConfig> paramArrayList)
    throws XmlPullParserException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("file")) {
          localArrayList.add(readFont(paramXmlPullParser));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    Object localObject = localArrayList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramXmlPullParser = (FontConfig)((Iterator)localObject).next();
    } while (paramXmlPullParser.weight != 400);
    for (;;)
    {
      localObject = paramXmlPullParser;
      if (paramXmlPullParser == null) {
        localObject = (FontConfig)localArrayList.get(0);
      }
      if (((FontConfig)localObject).fileName.isEmpty()) {
        break;
      }
      paramArrayList.add(localObject);
      return;
      paramXmlPullParser = null;
    }
  }
  
  private static FontConfig readFont(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    FontConfig localFontConfig = new FontConfig(null);
    Object localObject = paramXmlPullParser.getAttributeValue(null, "index");
    if (localObject == null)
    {
      i = 0;
      localFontConfig.ttcIndex = i;
      localObject = paramXmlPullParser.getAttributeValue(null, "weight");
      if (localObject != null) {
        break label119;
      }
    }
    label119:
    for (int i = 400;; i = Integer.parseInt((String)localObject))
    {
      localFontConfig.weight = i;
      localObject = new StringBuilder();
      while (paramXmlPullParser.next() != 3)
      {
        if (paramXmlPullParser.getEventType() == 4) {
          ((StringBuilder)localObject).append(paramXmlPullParser.getText());
        }
        if (paramXmlPullParser.getEventType() == 2) {
          skip(paramXmlPullParser);
        }
      }
      i = Integer.parseInt((String)localObject);
      break;
    }
    localFontConfig.fileName = ("/system/fonts/" + FILENAME_WHITESPACE_PATTERN.matcher((CharSequence)localObject).replaceAll(""));
    return localFontConfig;
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = 1;
    while (i > 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 2: 
        i += 1;
        break;
      case 3: 
        i -= 1;
      }
    }
  }
  
  static class FontConfig
  {
    String fileName = "";
    String language = "";
    int ttcIndex = 0;
    int weight = 400;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.PAGFont
 * JD-Core Version:    0.7.0.1
 */