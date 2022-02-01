package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import nle;
import org.json.JSONException;
import org.json.JSONObject;

public class WebFastAdapter$7
  implements Runnable
{
  public WebFastAdapter$7(nle paramnle, List paramList) {}
  
  public void run()
  {
    Iterator localIterator1 = this.bD.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator1.next();
      Iterator localIterator2 = this.this$0.bi().iterator();
      while (localIterator2.hasNext())
      {
        Object localObject = (BaseData)localIterator2.next();
        if ((localObject instanceof ProteusItemData))
        {
          localObject = ((ProteusItemData)localObject).aD;
          if (localObject != null)
          {
            String str = ((JSONObject)localObject).optString("kd_ug_download_url");
            if ((!TextUtils.isEmpty(str)) && (str.equals(localDownloadInfo.urlStr)))
            {
              int j = i;
              try
              {
                if (((JSONObject)localObject).opt("id_recommend_category_txt") != null)
                {
                  int k = 1;
                  i = 1;
                  j = k;
                  localObject = ((JSONObject)localObject).getJSONObject("id_recommend_category_txt");
                  j = k;
                  ((JSONObject)localObject).put("text", "下载中..." + localDownloadInfo.progress + "%");
                  j = k;
                  ((JSONObject)localObject).put("label_ug_progress_progress", localDownloadInfo.progress);
                }
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
                i = j;
              }
            }
          }
        }
      }
    }
    if (i != 0) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.7
 * JD-Core Version:    0.7.0.1
 */