import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.element.ColorElement;
import common.config.service.QzoneConfig;
import java.util.regex.Pattern;

public class vik
{
  public static int a;
  public static final Pattern a;
  public static final Pattern b = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  public static final Pattern c = Pattern.compile("\\{url:(.*?),text:(.*?),color:(.*?)\\}");
  public static final Pattern d = Pattern.compile("\\{url:.*?,text:.*?\\}");
  public static final Pattern e = Pattern.compile("\\<uin:.*?,nick(name)?:.*?\\>");
  public static final Pattern f = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  public static final Pattern g = Pattern.compile("\\{img:.*?,w:\\d+,h:\\d+\\}");
  public static final Pattern h = Pattern.compile("\\{img:.*?,w:\\d+,h:.+?\\}");
  
  static
  {
    jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "RichTextNeedDecode", 0);
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("<uin:.*?,nickname:.*?>");
  }
  
  public static ColorElement a(String paramString)
  {
    i = paramString.indexOf("text:") + "text:".length();
    int n = paramString.indexOf(",color:");
    if ((i == -1) || (n == -1)) {
      return new ColorElement();
    }
    ColorElement localColorElement = new ColorElement();
    localColorElement.text = paramString.substring(i, n);
    j = paramString.indexOf(",useDefaultFont:");
    k = paramString.indexOf(",useSuperFont:");
    int m = paramString.indexOf(",fontName:");
    i = paramString.length() - 1;
    if (j != -1) {}
    try
    {
      if (paramString.charAt(",useDefaultFont:".length() + j) == '1') {
        localColorElement.useDefaultFont = true;
      }
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        i = j;
        continue;
        j = k;
      }
    }
    if (k != -1)
    {
      if (j == -1) {
        break label362;
      }
      i = j;
    }
    try
    {
      if (paramString.charAt(",useSuperFont:".length() + k) == '0')
      {
        localColorElement.useSuperFont = false;
        i = j;
      }
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        i = j;
      }
    }
    k = i;
    try
    {
      int i1 = paramString.indexOf(",bold:");
      j = i;
      if (i1 >= 0)
      {
        k = i;
        j = Math.min(i1, i);
      }
      i = j;
      k = j;
      if (paramString.charAt(i1 + ",bold:".length()) == '1')
      {
        k = j;
        localColorElement.isBold = true;
        i = j;
      }
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        i = k;
      }
    }
    j = i;
    if (m != -1) {}
    for (;;)
    {
      try
      {
        str = paramString.substring(",fontName:".length() + m, i);
        if (!TextUtils.isEmpty(str))
        {
          str = str.trim();
          localColorElement.fontFamilyUrl = ("https://downv6.qq.com/video_story/qcircle/ttf/" + str + ".ttf");
        }
        j = m;
      }
      catch (Exception localException2)
      {
        String str;
        j = i;
        continue;
      }
      try
      {
        str = paramString.substring(",color:".length() + n, j);
        paramString = str;
        if (!TextUtils.isEmpty(str))
        {
          paramString = str;
          if (!str.startsWith("#")) {
            paramString = "#" + str;
          }
        }
        localColorElement.color = Color.parseColor(paramString);
      }
      catch (Exception paramString) {}
    }
    return localColorElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vik
 * JD-Core Version:    0.7.0.1
 */