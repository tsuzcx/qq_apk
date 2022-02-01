package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.List;
import kfq;
import mqq.os.MqqHandler;
import nle;
import org.json.JSONException;
import org.json.JSONObject;

public class WebFastAdapter$9
  implements Runnable
{
  public WebFastAdapter$9(nle paramnle) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.bi().iterator();
    int i = 0;
    label283:
    label285:
    for (;;)
    {
      int k;
      if (localIterator.hasNext())
      {
        Object localObject1 = (BaseData)localIterator.next();
        int j = i;
        if ((localObject1 instanceof ProteusItemData))
        {
          JSONObject localJSONObject = ((ProteusItemData)localObject1).aD;
          k = i;
          if (localJSONObject != null)
          {
            j = i;
            k = i;
            try
            {
              if (localJSONObject.opt("id_recommend_category_txt") == null) {
                break label283;
              }
              j = i;
              k = i;
              if (localJSONObject.opt("kd_ug_download_url") == null) {
                break label283;
              }
              Object localObject3;
              if (i == 0)
              {
                str = "";
                j = i;
                localObject3 = localJSONObject.opt("card_info");
                localObject1 = str;
                if (localObject3 == null) {}
              }
              try
              {
                localObject3 = localJSONObject.getJSONObject("card_info");
                localObject1 = str;
                if (((JSONObject)localObject3).opt("rowKey") != null) {
                  localObject1 = ((JSONObject)localObject3).getString("rowKey");
                }
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  j = i;
                  localJSONException1.printStackTrace();
                  Object localObject2 = str;
                }
              }
              j = i;
              kfq.ma(kfq.o("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject1, "19"));
              j = i;
              kfq.ma(kfq.o("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject1, "106"));
              j = i;
              ThreadManager.getUIHandler().postDelayed(new WebFastAdapter.9.1(this), 200L);
              k = 1;
              i = 1;
              j = i;
              localObject1 = localJSONObject.getJSONObject("id_recommend_category_txt");
              j = i;
              ((JSONObject)localObject1).put("text", "前往快报阅读");
              j = i;
              ((JSONObject)localObject1).put("label_ug_progress_progress", 100);
            }
            catch (JSONException localJSONException2)
            {
              String str;
              localJSONException2.printStackTrace();
            }
          }
        }
        else
        {
          i = j;
          break label285;
        }
      }
      else
      {
        if (i != 0) {
          this.this$0.notifyDataSetChanged();
        }
        return;
      }
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.9
 * JD-Core Version:    0.7.0.1
 */