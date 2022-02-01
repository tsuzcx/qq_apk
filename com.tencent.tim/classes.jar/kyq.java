import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class kyq
  implements AladdinConfigHandler
{
  public static final SimpleDateFormat m = new SimpleDateFormat("yyyy-MM-dd");
  
  public static boolean Bi()
  {
    if (((Integer)awit.f("readinjoy_comment_guide_pic_button_should_show", Integer.valueOf(-1))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("CommentGuideConfigHandler", 1, "isShow = " + bool);
      return bool;
    }
  }
  
  public static boolean Bj()
  {
    boolean bool1;
    if (((Integer)awit.f("readinjoy_comment_guide_should_show", Integer.valueOf(-1))).intValue() == 1)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        int i = ((Integer)awit.f("readinjoy_comment_guide_max_show_count", Integer.valueOf(3))).intValue();
        int j = oa();
        QLog.d("CommentGuideConfigHandler", 1, "count = " + i + "  todayNum : " + j);
        if (j >= i) {
          break label126;
        }
        qa(j + 1);
      }
    }
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("CommentGuideConfigHandler", 1, "isShow = " + bool2);
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public static TemplateBean a(VafContext paramVafContext)
  {
    if (paramVafContext == null)
    {
      npi localnpi = npi.a("comment_feeds", true);
      paramVafContext = localnpi;
      if (localnpi == null) {
        return null;
      }
    }
    else
    {
      paramVafContext = (npi)paramVafContext.getTemplateFactory();
    }
    if (paramVafContext != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = paramVafContext.getTemplateBean(y());
        return paramVafContext;
      }
      catch (JSONException paramVafContext)
      {
        QLog.d("CommentGuideConfigHandler", 1, "getTemplateBean ", paramVafContext);
      }
      paramVafContext = null;
    }
    return null;
  }
  
  public static String eD(String paramString)
  {
    String str2 = (String)awit.f("readinjoy_comment_guide_base_jump_url", "");
    QLog.d("CommentGuideConfigHandler", 1, "jump = " + str2);
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    String str3;
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (TextUtils.isEmpty(paramString));
      str3 = (String)aurr.getArgumentsFromURL(str2).get("appSchema");
      str1 = str2;
    } while (TextUtils.isEmpty(str3));
    try
    {
      str1 = URLDecoder.decode(str3, "UTF-8");
      paramString = str1 + "&rowkey=" + paramString;
      paramString = aurr.addParameter(aurr.deleteParameter(str2, "appSchema"), "appSchema", paramString);
      QLog.d("CommentGuideConfigHandler", 1, "getJumpUrl : " + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.d("CommentGuideConfigHandler", 1, "getJumpUrl ", paramString);
    }
    return str2;
  }
  
  public static String getDateString(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return m.format(localDate);
  }
  
  public static String iZ()
  {
    String str = (String)awit.f("readinjoy_comment_guide_wording", "");
    QLog.d("CommentGuideConfigHandler", 1, "wording = " + str);
    return str;
  }
  
  public static int oa()
  {
    String[] arrayOfString = ((String)awit.f("readinjoy_comment_guide_show_num_one_day", "0_0")).split("_");
    if ((arrayOfString != null) && (arrayOfString.length >= 2) && (getDateString(System.currentTimeMillis()).equals(arrayOfString[0]))) {
      return Integer.valueOf(arrayOfString[1]).intValue();
    }
    return 0;
  }
  
  public static void qa(int paramInt)
  {
    String str = getDateString(System.currentTimeMillis());
    awit.H("readinjoy_comment_guide_show_num_one_day", str + "_" + paramInt);
  }
  
  public static JSONObject y()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("style_ID", "ReadInJoy_comment_pop_guide");
      localJSONObject.put("guide_image", awit.f("readinjoy_comment_guide_image_url", "readinjoy_comment_guide_big_bg"));
      localJSONObject.put("guide_wording", iZ());
      localJSONObject.put("dismiss_button_image", "readinjoy_comment_guide_close");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("CommentGuideConfigHandler", 1, "getGuidePopupWindowData ", localJSONException);
    }
    return localJSONObject;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("CommentGuideConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = kye.i(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("CommentGuideConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "should_show")) {
        awit.H("readinjoy_comment_guide_should_show", Integer.valueOf(Integer.valueOf(str2).intValue()));
      } else if (TextUtils.equals(str1, "wording")) {
        awit.H("readinjoy_comment_guide_wording", str2);
      } else if (TextUtils.equals(str1, "image_url")) {
        awit.H("readinjoy_comment_guide_image_url", str2);
      } else if (TextUtils.equals(str1, "base_jump_url")) {
        awit.H("readinjoy_comment_guide_base_jump_url", str2);
      } else if (TextUtils.equals(str1, "max_show_count")) {
        awit.H("readinjoy_comment_guide_max_show_count", Integer.valueOf(Integer.valueOf(str2).intValue()));
      } else if (TextUtils.equals(str1, "pic_button_should_show")) {
        awit.H("readinjoy_comment_guide_pic_button_should_show", Integer.valueOf(Integer.valueOf(str2).intValue()));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("CommentGuideConfigHandler", 1, "[onWipeConfig]");
    awit.H("readinjoy_comment_guide_should_show", Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyq
 * JD-Core Version:    0.7.0.1
 */