package com.tencent.biz.pubaccount.readinjoy.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import kmq;
import kmx;
import npi;
import obs;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusBannerVideoItemData
  extends AdData
{
  public boolean isShowingGuide;
  public long mXGFileSize;
  
  public ProteusBannerVideoItemData()
  {
    super(17);
  }
  
  private JSONObject t()
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (kmx.a(this)) {
      return kmq.a(localJSONObject1, this);
    }
    for (;;)
    {
      JSONObject localJSONObject2;
      try
      {
        localJSONObject1.put("style_ID", "ReadInjoy_ad_banner_video_cell");
        Object localObject;
        if (!TextUtils.isEmpty(this.title))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("text", this.title);
        }
        switch (this.bab)
        {
        case 1: 
          ((JSONObject)localObject).put("bottom_line_number", "2");
          ((JSONObject)localObject).put("text_color", "#bbbbbb");
          localJSONObject1.put("id_tv_title", localObject);
          if (!TextUtils.isEmpty(this.imgUrl))
          {
            localObject = obs.a(this.imgUrl, 4);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("image_url", ((URL)localObject).toString());
            localJSONObject1.put("id_ad_banner_bottom_imge", localJSONObject2);
          }
          localObject = new JSONObject();
          if (!TextUtils.isEmpty(this.alV))
          {
            ((JSONObject)localObject).put("text", this.alV);
            localJSONObject1.put("id_ad_dislike_button", localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProteusBannerVideoItemData", 2, "detail ad Bottom Pic adInconText:" + this.alV);
          }
          localObject = new JSONObject();
          switch (this.bab)
          {
          case 1: 
            ((JSONObject)localObject).put("bottom_background_color", "#f8f8f8");
            localJSONObject1.put("id_operate_area", localObject);
            localJSONObject1.put("id_separator", new JSONObject());
            localObject = new JSONObject();
            ((JSONObject)localObject).put("article_model", this);
            localJSONObject1.put("id_view_AdDownloadView", localObject);
            localJSONObject1.put("id_ad_title", new JSONObject());
            localJSONObject1.put("id_ad_title_rl", new JSONObject());
            localObject = null;
            if (TextUtils.isEmpty(this.alT)) {
              break label530;
            }
            localObject = this.alT;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localJSONObject2 = new JSONObject();
              localJSONObject2.put("text", localObject);
            }
            switch (this.bab)
            {
            case 1: 
              localJSONObject2.put("text_color", "#000000");
              localJSONObject1.put("id_tv_author", localJSONObject2);
              localObject = new JSONObject();
              ((JSONObject)localObject).put("article_model", this);
              localJSONObject1.put("id_ad_banner_bottom_video", localObject);
              return localJSONObject1;
            }
            break;
          }
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
      localJSONException.put("bottom_line_number", "1");
      localJSONException.put("text_color", "#a6a6a6");
      continue;
      localJSONException.put("bottom_line_number", "2");
      localJSONException.put("text_color", "#a6a6a6");
      continue;
      localJSONException.put("bottom_background_color", "#ffffff");
      localJSONException.put("bottom_border_color", "#e6e6e6");
      localJSONException.put("bottom_border_width", "0.5");
      continue;
      label530:
      if (!TextUtils.isEmpty(this.appName))
      {
        String str = this.appName;
        continue;
        localJSONObject2.put("text_color", "#262626");
        continue;
        continue;
      }
    }
  }
  
  public void aDY()
  {
    localObject3 = null;
    this.aD = t();
    try
    {
      npi localnpi = npi.a("native_article", true);
      localObject1 = localObject3;
      if (localnpi != null) {
        localObject1 = localnpi.getTemplateBean(this.aD);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        localJSONException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
    if (localObject1 != null) {
      this.mTemplateBean = ((TemplateBean)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData
 * JD-Core Version:    0.7.0.1
 */