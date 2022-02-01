import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class tjg
{
  public static float a()
  {
    return 16.0F;
  }
  
  public static int a(Context paramContext)
  {
    int j = 0;
    int i = j;
    if (paramContext != null)
    {
      paramContext = paramContext.getResources();
      i = j;
      if (paramContext != null) {
        i = paramContext.getDisplayMetrics().widthPixels;
      }
    }
    return i;
  }
  
  public static int a(String paramString, Map<Long, rpf> paramMap)
  {
    if ((paramMap != null) && (!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString)))
    {
      paramString = (rpf)paramMap.get(Long.valueOf(paramString));
      if (paramString != null)
      {
        if (paramString.a()) {
          return 1;
        }
        return 0;
      }
    }
    return -1;
  }
  
  protected static int a(List<BaseData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if ((paramList.get(i) instanceof AuthorData)) {
          return i;
        }
        i += 1;
      }
    }
    return 2147483647;
  }
  
  public static Float a()
  {
    return (Float)bmhv.a("readinjoy_font_size_ratio_sp", Float.valueOf(1.0F));
  }
  
  public static String a()
  {
    return String.valueOf(a().floatValue());
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, String paramString, FastWebArticleInfo paramFastWebArticleInfo, boolean paramBoolean)
  {
    int i = 1;
    if ((paramContext == null) || (paramArticleInfo == null) || (TextUtils.isEmpty(paramString)) || (paramFastWebArticleInfo == null)) {
      return;
    }
    String str = uvs.a(paramArticleInfo, pjj.k + bhcu.encodeToString(String.valueOf(paramString).getBytes(), 2), uvs.d);
    QLog.d("FastWebPTSUtils", 1, "jump2SelfPage: " + str);
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramString), null);
    paramString = b(paramContext, paramArticleInfo, paramFastWebArticleInfo, paramArticleInfo.mChannelID);
    if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isLiving()))
    {
      pkh.a(paramContext, localReadInJoyUserInfo.getLiveUrl());
      pjc.a(paramString, "live_circle_from_page", Integer.valueOf(1));
      paramContext = "0X800B17E";
      tkj.a(paramArticleInfo, "", paramString.toString());
      tkj.a(paramArticleInfo, paramContext, paramString.toString());
      return;
    }
    pkh.a(paramContext, str);
    if (paramBoolean) {}
    for (;;)
    {
      pjc.a(paramString, "is_intensify", Integer.valueOf(i));
      paramContext = "0X800898A";
      break;
      i = 0;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, long paramLong, String paramString, boolean paramBoolean)
  {
    if ((paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        uvs.a(paramArticleInfo, uvs.d, paramBoolean);
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        qia localqia = pvj.a().a();
        localObject = ((QQAppInterface)localObject).getAccount();
        paramFastWebArticleInfo = new tjh(paramArticleInfo, paramFastWebArticleInfo, paramBoolean);
        if (ppe.g(paramArticleInfo))
        {
          i = 2;
          localqia.a((String)localObject, paramLong, true, paramString, paramFastWebArticleInfo, i);
          return;
        }
      }
      catch (Exception paramArticleInfo)
      {
        QLog.d("FastWebPTSUtils", 1, "followButtonClick error! msg=" + paramArticleInfo);
        return;
      }
      int i = 1;
    }
  }
  
  public static void a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusItemData)) {
      a(((ProteusItemData)paramBaseData).c);
    }
  }
  
  private static void a(String paramString)
  {
    QLog.e("FastWebPTSUtils", 1, "errorUrl!! detail:" + paramString);
    throw new IllegalArgumentException(paramString);
  }
  
  public static void a(List<BaseData> paramList)
  {
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        while (!paramList.hasNext()) {
          paramList = paramList.iterator();
        }
        localObject = (BaseData)paramList.next();
      } while (!(localObject instanceof ProteusItemData));
      localObject = (ProteusItemData)localObject;
    } while ((((ProteusItemData)localObject).v != 1) || (((ProteusItemData)localObject).e));
    if (((ProteusItemData)localObject).c != null) {}
    for (paramList = ((ProteusItemData)localObject).c.toString();; paramList = "data error!!")
    {
      a(paramList);
      return;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject.put("attribute_text_size_ratio", a());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebPTSUtils", 1, "addTextSizeRatio error! msg=" + paramJSONObject);
    }
  }
  
  public static boolean a(int paramInt, List<BaseData> paramList)
  {
    int j = a(paramList);
    int i;
    if (Aladdin.getConfig(374).getIntegerFromString("should_show_navbar_account_info", 0) == 1) {
      i = 1;
    }
    while (i != 0) {
      if (paramInt > j)
      {
        return true;
        i = 0;
      }
      else
      {
        return false;
      }
    }
    return false;
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    if ((paramBaseData.r == 26) && ((paramBaseData instanceof ProteusItemData)) && (((ProteusItemData)paramBaseData).v == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramBaseData.r == 18) || (paramBaseData.r == 22) || (paramBaseData.r == 0)) {
        bool = true;
      }
      return bool;
    }
  }
  
  private static JSONObject b(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, long paramLong)
  {
    int i = (int)paramLong;
    if (paramFastWebArticleInfo.c()) {}
    for (paramFastWebArticleInfo = "2";; paramFastWebArticleInfo = "1") {
      return pqf.a(paramContext, paramArticleInfo, i, paramFastWebArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tjg
 * JD-Core Version:    0.7.0.1
 */