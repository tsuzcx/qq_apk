package com.tencent.biz.pubaccount.readinjoy.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.regex.Pattern;
import kmn;
import kmx;
import knb;
import npi;
import obs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusInnerData
  extends AdData
{
  public a a;
  private int aJP = 1;
  private int aJQ = 1;
  public int aJR = -1;
  public int aJS;
  private String aaX = "";
  private boolean agh;
  
  public ProteusInnerData()
  {
    super(22);
  }
  
  private void P(JSONObject paramJSONObject)
  {
    this.aaX = paramJSONObject.optString("pop_sheet");
    try
    {
      Object localObject1 = new JSONObject(this.aaX);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("formContent").optJSONArray("items");
      paramJSONObject = ((JSONObject)localObject1).optJSONObject("formContent").optJSONObject("submitButton");
      localObject2 = ((JSONArray)localObject2).optJSONObject(0);
      int i = ((JSONObject)localObject2).optInt("regexType");
      localObject1 = ((JSONObject)localObject1).optJSONObject("formContent").getJSONObject("formRegex").getString("" + i);
      this.a = new a(((JSONObject)localObject2).optInt("regexType"), ((JSONObject)localObject2).optString("name"), ((JSONObject)localObject2).optString("placeholder"), paramJSONObject.optString("text"), (JSONObject)localObject2, Pattern.compile((String)localObject1));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private JSONObject f(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_large_pic_cell");
        if (!TextUtils.isEmpty(this.title))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("text", this.title);
          paramJSONObject.put("id_ad_title", localObject);
        }
        if (!TextUtils.isEmpty(this.imgUrl))
        {
          localObject = obs.a(this.imgUrl, 4);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("image_url", ((URL)localObject).toString());
          paramJSONObject.put("id_ad_banner_inner_imge", localJSONObject);
        }
        Object localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.alV))
        {
          ((JSONObject)localObject).put("text", this.alV);
          paramJSONObject.put("id_ad_dislike_button", localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 2, "detail ad inner largeStyle Pic adInconText:" + this.alV);
        }
        paramJSONObject.put("id_ad_banner_inner_large_root", new JSONObject());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", this);
        if (this.agh)
        {
          paramJSONObject.put("id_operate_edit_area", localObject);
          return paramJSONObject;
        }
        paramJSONObject.put("id_operate_app_area", localObject);
        paramJSONObject.put("id_view_AdDownloadView", localObject);
        localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.appName))
        {
          ((JSONObject)localObject).put("text", this.appName);
          paramJSONObject.put("id_app_name", localObject);
          return paramJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return paramJSONObject;
      }
      if (!TextUtils.isEmpty(this.alT)) {
        localJSONException.put("text", this.alT);
      }
    }
  }
  
  private JSONObject g(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_small_pic_cell");
      Object localObject;
      if (!TextUtils.isEmpty(this.title))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.title);
        paramJSONObject.put("id_inner_title", localObject);
      }
      if (!TextUtils.isEmpty(this.imgUrl))
      {
        localObject = obs.a(this.imgUrl, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_inner_small_img", localJSONObject);
      }
      if (!TextUtils.isEmpty(this.alV))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.alV);
        paramJSONObject.put("id_inner_ad_name", localObject);
      }
      if (!TextUtils.isEmpty(this.alT))
      {
        localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.alV)) {
          break label262;
        }
        ((JSONObject)localObject).put("text", knb.A(this.alT, 16));
      }
      for (;;)
      {
        paramJSONObject.put("id_inner_name", localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 2, "detail ad inner smallStyle Pic adInconText:" + this.alV);
        }
        paramJSONObject.put("id_ad_banner_inner_small_root", new JSONObject());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", this);
        if (!this.agh) {
          break;
        }
        paramJSONObject.put("id_operate_edit_area", localObject);
        return paramJSONObject;
        label262:
        ((JSONObject)localObject).put("text", knb.A(this.alT, 12));
      }
      paramJSONObject.put("id_view_AdDownloadView", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return paramJSONObject;
    }
    return paramJSONObject;
  }
  
  private JSONObject h(JSONObject paramJSONObject)
  {
    paramJSONObject = g(paramJSONObject);
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_recommend_small_pic_cell");
      return paramJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject;
  }
  
  private JSONObject i(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_soft_ad_cell");
        paramJSONObject.put("id_ad_banner_inner_small_root", new JSONObject());
        paramJSONObject.put("id_inner_main_area", new JSONObject());
        paramJSONObject.put("id_inner_button_area", new JSONObject());
        paramJSONObject.put("id_area_right_of_img", new JSONObject());
        paramJSONObject.put("id_inner_default_label", new JSONObject());
        paramJSONObject.put("id_label_article_separator_line_bottom", new JSONObject());
        paramJSONObject.put("id_inner_ad_sale_price_container", new JSONObject());
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("container_background_color", "#f7f7f7");
        paramJSONObject.put("id_ad_banner_inner_small_root", localObject1);
        if (this.aC != null)
        {
          int i = this.aC.optInt("goodsType");
          String str2 = this.aC.optString("goodsPromotionPrice", "");
          localObject2 = this.aC.optString("goodsPrice", "");
          localObject1 = this.aC.optString("goodsPromotionTxt", "");
          Object localObject4 = this.aC.optString("buttonTxt", "");
          if ((i == 1) || (!TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label783;
          }
          localObject3 = "";
          localObject1 = localObject4;
          if (TextUtils.isEmpty(str2))
          {
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject1 = localObject4;
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject4;
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  localObject1 = "文章同款";
                }
              }
            }
          }
          if (i != 1)
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("text_button", this.aC.optString("button", "购买"));
            paramJSONObject.put("id_inner_ad_button", localObject4);
            if (!TextUtils.isEmpty(str2))
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("text_price", str2);
              paramJSONObject.put("id_inner_ad_price", localObject4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("text_ad_tag", localObject2);
              paramJSONObject.put("id_inner_ad_tag", localObject4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("text_sale_price", localObject3);
              ((JSONObject)localObject4).put("sale_price_color", "#99000000");
              paramJSONObject.put("id_inner_ad_sale_price", localObject4);
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("sale_price_line_color", "#c2c2c2");
              paramJSONObject.put("id_inner_ad_sale_price_line", localObject4);
            }
            if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("text_default_color", "#99000000");
              ((JSONObject)localObject2).put("text_default", localObject1);
              paramJSONObject.put("id_inner_default_label", localObject2);
            }
            paramJSONObject.put("id_inner_ad_sale_price_container", new JSONObject());
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("title_text_color", "#000000");
            ((JSONObject)localObject1).put("text_title", this.aC.optString("goodsName", ""));
            paramJSONObject.put("id_inner_title", localObject1);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("image_url", obs.a(this.aC.optString("adImg", ""), 4).toString());
            if (!zH()) {
              break label776;
            }
            localObject1 = "8.0";
            ((JSONObject)localObject2).put("ad_icon_radius", localObject1);
            paramJSONObject.put("id_inner_small_img", localObject2);
          }
        }
        else
        {
          paramJSONObject.put("id_bottom_operation", new JSONObject());
          return paramJSONObject;
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("article_model", this);
        paramJSONObject.put("id_view_AdDownloadView", localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("text_default_color", "#99000000");
        ((JSONObject)localObject2).put("text_default", localObject1);
        paramJSONObject.put("id_inner_default_label", localObject2);
        continue;
        str1 = "2.0";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramJSONObject;
      }
      label776:
      String str1;
      continue;
      label783:
      Object localObject3 = localObject2;
      Object localObject2 = str1;
    }
  }
  
  private JSONObject t()
  {
    JSONObject localJSONObject = new JSONObject();
    if (kmx.a(this)) {
      return kmn.a(localJSONObject, this);
    }
    if (this.aJP == 2) {
      return g(localJSONObject);
    }
    if (this.aJP == 1) {
      return f(localJSONObject);
    }
    if (this.aJP == 3) {
      return h(localJSONObject);
    }
    return i(localJSONObject);
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramJSONObject, paramInt);
    if (paramJSONObject != null)
    {
      this.aaX = paramJSONObject.optString("pop_sheet");
      Object localObject = paramJSONObject.opt("soft_ad_data");
      if ((localObject instanceof JSONObject))
      {
        this.bac = ((JSONObject)localObject).optInt("open_float_switch");
        this.aaL = ((JSONObject)localObject).optString("cmsid");
        localObject = ((JSONObject)localObject).opt("soft_ad");
        if ((localObject instanceof JSONObject)) {
          this.aC = ((JSONObject)localObject);
        }
      }
      localObject = paramJSONObject.optString("inner_ad");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 1, "fillSpecialData->inner_ad:" + (String)localObject);
        }
        for (;;)
        {
          try
          {
            localObject = new JSONObject((String)localObject);
            this.aJQ = ((JSONObject)localObject).optInt("pos_type");
            this.aJR = ((JSONObject)localObject).optInt("para_pos");
            j("para_pos", Integer.valueOf(this.aJR));
            if ((((JSONObject)localObject).optInt("has_sheet") == 1) && (!this.atk))
            {
              bool = true;
              this.agh = bool;
              this.abr = ((JSONObject)localObject).optString("cash_tag");
              paramInt = ((JSONObject)localObject).optInt("style");
              i = paramInt;
            }
          }
          catch (Exception paramJSONObject)
          {
            boolean bool;
            paramInt = 0;
          }
          try
          {
            if (this.agh)
            {
              P(paramJSONObject);
              i = paramInt;
            }
            if (this.req_type == 1) {
              i = 4;
            }
            if ((this.aJQ != 2) && ((this.aJQ != 1) || (this.aJR <= 0))) {
              break label367;
            }
            if ((i == 2) || (i == 1) || (i == 3)) {
              this.aJP = i;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProteusInnerData", 1, "fillSpecialData->" + this);
            }
            return true;
          }
          catch (Exception paramJSONObject)
          {
            break label358;
          }
          bool = false;
          continue;
          label358:
          paramJSONObject.printStackTrace();
          int i = paramInt;
          continue;
          label367:
          if (i != 4) {
            break;
          }
          this.aJP = i;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ProteusInnerData", 1, "fillSpecialData->check available fail");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ProteusInnerData", 1, "fillSpecialData->inner_ad empty");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ProteusInnerData", 1, "fillSpecialData->jsonObject null");
    }
    return false;
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
  
  public String toString()
  {
    return "ProteusInnerData[formId:" + this.aJS + ",  style:" + this.aJP + ",  pos_type:" + this.aJQ + ",  para_pos:" + this.aJR + ",\n formItem:" + this.a + "]";
  }
  
  public boolean zD()
  {
    return this.aJP == 1;
  }
  
  public boolean zE()
  {
    return this.aJP == 2;
  }
  
  public boolean zF()
  {
    return this.aJP == 3;
  }
  
  public boolean zG()
  {
    return this.aJP == 4;
  }
  
  public boolean zH()
  {
    return (zG()) && (this.aC != null) && (this.aC.optInt("goodsType", -1) == 1);
  }
  
  public boolean zI()
  {
    return kmx.a(this);
  }
  
  public boolean zJ()
  {
    return this.aJQ == 2;
  }
  
  public class a
  {
    public Pattern I;
    public String aaY = "";
    public String aaZ = "";
    public JSONObject jsonObject;
    public String name = "";
    public int regexType;
    
    public a(int paramInt, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, Pattern paramPattern)
    {
      this.regexType = paramInt;
      if (!TextUtils.isEmpty(paramString1)) {
        this.name = paramString1;
      }
      if (!TextUtils.isEmpty(paramString2)) {
        this.aaY = paramString2;
      }
      if (!TextUtils.isEmpty(paramString3)) {
        this.aaZ = paramString3;
      }
      if (paramJSONObject != null) {
        this.jsonObject = paramJSONObject;
      }
      if (paramPattern != null) {
        this.I = paramPattern;
      }
    }
    
    public String toString()
    {
      return "InnerFormItem[" + this.regexType + ", " + this.name + ", " + this.aaY + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData
 * JD-Core Version:    0.7.0.1
 */