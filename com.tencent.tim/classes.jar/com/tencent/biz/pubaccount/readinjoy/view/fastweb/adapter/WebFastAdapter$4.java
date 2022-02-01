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

public class WebFastAdapter$4
  implements Runnable
{
  public WebFastAdapter$4(nle paramnle, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.bi().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (BaseData)localIterator.next();
      int j = i;
      if ((localObject instanceof ProteusItemData))
      {
        localObject = ((ProteusItemData)localObject).aD;
        j = i;
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("kd_ug_download_url");
          if ((TextUtils.isEmpty(str)) || (!str.equals(this.a.urlStr))) {
            continue;
          }
          j = i;
        }
      }
      for (;;)
      {
        try
        {
          if (((JSONObject)localObject).opt("id_recommend_category_txt") != null)
          {
            int k = 1;
            j = 1;
            i = k;
            localObject = ((JSONObject)localObject).getJSONObject("id_recommend_category_txt");
            i = k;
            ((JSONObject)localObject).put("text", "下载中..." + this.a.progress + "%");
            i = k;
            ((JSONObject)localObject).put("label_ug_progress_progress", this.a.progress);
          }
          i = j;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          j = i;
        }
        i = j;
      }
    }
    if (i != 0) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.4
 * JD-Core Version:    0.7.0.1
 */