package com.tencent.biz.pubaccount.readinjoy.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import jzk;
import jzp;
import kmm;
import kmo;
import kmx;
import npi;
import obs;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusBannerBigPicItemData
  extends AdData
{
  public String aaS = "";
  public String aaT = "";
  public String aaU = "";
  public String aaV = "";
  public String aaW = "";
  public boolean agg;
  public String corporate_image_name = "";
  public String store_name = "";
  public String store_url = "";
  
  public ProteusBannerBigPicItemData()
  {
    super(10);
  }
  
  private boolean a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    return (!TextUtils.isEmpty(this.title)) && (!TextUtils.isEmpty(this.imgUrl)) && (!TextUtils.isEmpty(this.appName));
  }
  
  private JSONObject t()
  {
    Object localObject4 = null;
    String str1 = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject1;
    if (kmx.b(this)) {
      localObject1 = kmo.a(localJSONObject, this);
    }
    for (;;)
    {
      return localObject1;
      if (kmx.a(this)) {
        return kmm.a(localJSONObject, this);
      }
      localObject1 = str1;
      Object localObject5;
      try
      {
        if (!a(this)) {
          continue;
        }
        if (this.agg) {
          localJSONObject.put("style_ID", "ReadInjoy_ad_banner_large_pic_location_cell");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          double d1;
          double d2;
          label133:
          label140:
          String str2;
          int i;
          label186:
          StringBuilder localStringBuilder;
          label212:
          label348:
          label763:
          long l;
          label540:
          label728:
          localJSONException.printStackTrace();
          label775:
          label810:
          break;
          localJSONObject.put("style_ID", "ReadInjoy_ad_banner_large_pic_cell");
          continue;
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
          localJSONException.put("text_color", "#262626");
        }
      }
      try
      {
        localObject5 = new double[2];
      }
      catch (Exception localException1)
      {
        Object localObject2 = null;
        break label133;
      }
      try
      {
        localObject1 = this.aaU;
        d1 = jzp.a(this.aaT, 0.0D);
        d2 = jzp.a((String)localObject1, 0.0D);
        if (d2 == 0.0D)
        {
          localObject1 = str1;
          if (d1 == 0.0D) {}
        }
        else
        {
          localObject5[0] = d1;
          localObject5[1] = d2;
          localObject1 = localObject5;
        }
      }
      catch (Exception localException2)
      {
        Object localObject3 = localObject5;
        break label133;
        label1017:
        localObject3 = "";
        localObject4 = str1;
        break label212;
        break label348;
        break label540;
        break label728;
      }
    }
    if (localObject1 == null)
    {
      d1 = 0.0D;
      localObject1 = this.aaW;
      localObject5 = this.aaS;
      str1 = this.aaV;
      str2 = this.store_url;
      i = jzp.o((String)localObject1, 3000);
      if (d1 > 0.0D) {
        break label763;
      }
      localObject1 = "";
      d1 = 0.0D;
      localStringBuilder = new StringBuilder();
      if (d1 == 0.0D) {
        break label1017;
      }
      if (d1 <= i) {
        break label775;
      }
      break label1017;
    }
    do
    {
      for (;;)
      {
        localObject5 = new JSONObject();
        ((JSONObject)localObject5).put("ad_Location", localObject1);
        ((JSONObject)localObject5).put("ad_Location_content", localObject4);
        ((JSONObject)localObject5).put("ad_url", str2);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("ad_Location", localObject5);
        localJSONObject.put("id_view_ad_locationView", localObject1);
        localJSONObject.put("id_mid_line", localObject1);
        if (!TextUtils.isEmpty(this.title))
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("text", this.title);
        }
        switch (this.bab)
        {
        case 1: 
          ((JSONObject)localObject1).put("bottom_line_number", "2");
          ((JSONObject)localObject1).put("text_color", "#bbbbbb");
          localJSONObject.put("id_tv_title", localObject1);
          if (!TextUtils.isEmpty(this.imgUrl))
          {
            localObject1 = obs.a(this.imgUrl, 4);
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("image_url", ((URL)localObject1).toString());
            localJSONObject.put("id_ad_banner_bottom_imge", localObject4);
          }
          localObject1 = new JSONObject();
          if (!TextUtils.isEmpty(this.alV))
          {
            ((JSONObject)localObject1).put("text", this.alV);
            localJSONObject.put("id_ad_dislike_button", localObject1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProteusBannerBigPicItemData", 2, "detail ad Bottom Pic adInconText:" + this.alV);
          }
          localObject1 = new JSONObject();
          switch (this.bab)
          {
          case 1: 
            ((JSONObject)localObject1).put("bottom_background_color", "#f8f8f8");
            localJSONObject.put("id_operate_area", localObject1);
            localJSONObject.put("id_separator", new JSONObject());
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("article_model", this);
            localJSONObject.put("id_view_AdDownloadView", localObject1);
            localJSONObject.put("id_ad_title", new JSONObject());
            localJSONObject.put("id_ad_title_rl", new JSONObject());
            if (TextUtils.isEmpty(this.appName)) {
              break label1037;
            }
            localObject1 = new JSONObject();
            if ((this.agg) && (this.appName.length() > 8)) {
              this.appName = this.appName.substring(0, 8).concat("...");
            }
            ((JSONObject)localObject1).put("text", this.appName);
            switch (this.bab)
            {
            case 1: 
              ((JSONObject)localObject1).put("text_color", "#000000");
              localJSONObject.put("id_tv_author", localObject1);
              break label1037;
              d1 = jzk.a((double[])localObject1, BaseApplicationImpl.getContext());
              break label140;
              d1 = Math.ceil(d1);
              localObject1 = localObject4;
              break label186;
              if (d1 >= 1000.0D) {
                break label810;
              }
              localStringBuilder.append((int)d1).append('m');
              localObject1 = localStringBuilder.toString();
              localObject4 = localObject5;
            }
            break;
          }
          break;
        }
      }
      localObject4 = localObject5;
    } while (d1 >= i);
    l = Math.round(d1 / 1000.0D);
    if (l < 1000L) {
      localStringBuilder.append(l).append("km");
    }
    for (;;)
    {
      localObject1 = localStringBuilder.toString();
      localObject4 = localObject5;
      break;
      localStringBuilder.append("999km");
    }
    label1037:
    return localJSONObject;
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData
 * JD-Core Version:    0.7.0.1
 */