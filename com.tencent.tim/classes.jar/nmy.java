import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class nmy
{
  public static void a(List<BaseData> paramList, float paramFloat)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramFloat = Utils.px2dp(paramFloat);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (BaseData)paramList.next();
        try
        {
          if ((localObject instanceof ProteusItemData))
          {
            localObject = (ProteusItemData)localObject;
            if ((((ProteusItemData)localObject).mModuleType == 1) && (((ProteusItemData)localObject).bad == 1)) {
              ((ProteusItemData)localObject).aD.put("attribute_text_size", String.valueOf(paramFloat));
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public static void db(List<BaseData> paramList)
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
    } while ((((ProteusItemData)localObject).mModuleType != 1) || (((ProteusItemData)localObject).ats));
    if (((ProteusItemData)localObject).aD != null) {}
    for (paramList = ((ProteusItemData)localObject).aD.toString();; paramList = "data error!!")
    {
      oi(paramList);
      return;
    }
  }
  
  public static boolean e(BaseData paramBaseData)
  {
    if ((paramBaseData.type == 26) && ((paramBaseData instanceof ProteusItemData)) && (((ProteusItemData)paramBaseData).mModuleType == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramBaseData.type == 18) || (paramBaseData.type == 22) || (paramBaseData.type == 0)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static float getTextSize()
  {
    float f = ((Float)awit.f("readinjoy_font_size_sp", Float.valueOf(-1.0F))).floatValue();
    if (f == -1.0F) {
      return 16.0F;
    }
    return Utils.px2dp(f);
  }
  
  private static void oi(String paramString)
  {
    QLog.e("FastWebPTSUtils", 1, "errorUrl!! detail:" + paramString);
    throw new IllegalArgumentException(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmy
 * JD-Core Version:    0.7.0.1
 */