package com.tencent.ad.tangram.canvas.views.canvas;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.Keep;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.AdCanvasJsonManager;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
public class AdCanvasDataBuilderV2
{
  private static final String TAG = "AdCanvasDataBuilderV2";
  
  public static AdCanvasData build(Context paramContext, Ad paramAd)
  {
    if (paramAd == null)
    {
      AdLog.e("AdCanvasDataBuilderV2", "build error");
      return null;
    }
    String str = paramAd.getCanvas();
    if (TextUtils.isEmpty(str))
    {
      AdLog.e("AdCanvasDataBuilderV2", "build error");
      return null;
    }
    AdLog.i("AdCanvasDataBuilderV2", "build " + str);
    try
    {
      paramContext = getCanvasData(paramContext, paramAd, new JSONObject(str));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdCanvasDataBuilderV2", "build error", paramContext);
    }
    return null;
  }
  
  public static AdCanvasData build(Context paramContext, Ad paramAd, boolean paramBoolean)
  {
    if (paramAd == null)
    {
      AdLog.e("AdCanvasDataBuilderV2", "build error");
      return null;
    }
    String str = paramAd.getCanvas();
    if (TextUtils.isEmpty(str))
    {
      AdLog.e("AdCanvasDataBuilderV2", "build error");
      return null;
    }
    AdLog.i("AdCanvasDataBuilderV2", "build " + str);
    try
    {
      paramContext = getCanvasData(paramContext, paramAd, new JSONObject(str), paramBoolean);
      setArkFormIndex(paramContext);
      setActiveAppBtnView(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdCanvasDataBuilderV2", "build error", paramContext);
    }
    return null;
  }
  
  private static com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c getAppButtonComponent(Context paramContext, JSONObject paramJSONObject, int paramInt)
    throws Throwable
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      AdLog.e("AdCanvasDataBuilderV2", "getAppButtonComponent error");
      paramJSONObject = null;
      return paramJSONObject;
    }
    JSONObject localJSONObject = paramJSONObject.getJSONObject("config");
    com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c localc = new com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c();
    initComponent(paramJSONObject, paramInt, localc);
    localc.button.text.text = unescapeHtml(localJSONObject.getJSONObject("content").getString("text"));
    paramJSONObject = localJSONObject.getJSONObject("style");
    localc.button.text.color = getColor(paramJSONObject.getString("color"));
    localc.button.backgroundColor = getColor(paramJSONObject.getString("backgroundColor"));
    localc.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("borderRadius"));
    localc.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("fontSize"));
    int i = paramJSONObject.getInt("width");
    localc.height = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("lineHeight"));
    paramJSONObject = localJSONObject.getJSONObject("wrapper");
    String str = paramJSONObject.getString("textAlign");
    if (TextUtils.equals(str, "center")) {
      localc.gravity = 17;
    }
    for (;;)
    {
      localc.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("marginLeft"));
      localc.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("marginRight"));
      localc.width = (i * (AdUIUtils.getPhysicalScreenWidth(paramContext) - localc.paddingLeft - localc.paddingRight) / 100);
      localc.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("marginTop"));
      localc.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("marginBottom"));
      localc.isFixed = localJSONObject.getBoolean("isFixed");
      paramJSONObject = localc;
      if (!localc.isFixed) {
        break;
      }
      paramJSONObject = localJSONObject.getJSONObject("position");
      localc.toBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("toBottom"));
      localc.whiteSpace = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, paramJSONObject.getInt("whiteSpace"));
      return localc;
      if (TextUtils.equals(str, "left"))
      {
        localc.gravity = 3;
      }
      else
      {
        if (!TextUtils.equals(str, "right")) {
          break label404;
        }
        localc.gravity = 5;
      }
    }
    label404:
    throw new Exception("unknow button align");
  }
  
  private static AdCanvasComponentData getAppIconComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getAppIconComponent error");
      return null;
    }
    com.tencent.ad.tangram.canvas.views.canvas.components.appIcon.a locala = new com.tencent.ad.tangram.canvas.views.canvas.components.appIcon.a();
    initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("config");
    paramJSONObject = localJSONObject.getJSONObject("appInfo");
    localJSONObject = localJSONObject.getJSONObject("wrapper");
    int i = paramAdCanvasData.basicWidth;
    locala.logoWidth = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 64);
    locala.logoHeight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 64);
    locala.logoUrl = paramJSONObject.getString("logoUrl");
    locala.name = paramJSONObject.getString("name");
    locala.downloadCount = paramJSONObject.getLong("downloadCount");
    locala.fileSize = paramJSONObject.getLong("fileSize");
    locala.starCount = paramJSONObject.getInt("starCount");
    locala.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, localJSONObject.getInt("marginLeft"));
    locala.marginTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, localJSONObject.getInt("marginTop"));
    locala.marginRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, localJSONObject.getInt("marginRight"));
    locala.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, localJSONObject.getInt("marginBottom"));
    paramJSONObject = new com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c();
    paramJSONObject.id = ("XJAppIcon_AppBtn_" + locala.logoUrl.hashCode());
    paramJSONObject.width = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 71);
    paramJSONObject.height = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 36);
    paramJSONObject.fontColor = -1;
    paramJSONObject.gravity = 17;
    paramJSONObject.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 17);
    paramJSONObject.button.text.text = "下载";
    paramJSONObject.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, i, 16);
    paramJSONObject.button.text.color = -1;
    paramJSONObject.button.backgroundColor = getColor("#20A0FF");
    locala.adCanvasAppBtnComponentData = paramJSONObject;
    return locala;
  }
  
  private static AdCanvasComponentData getArkFormComponent(JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      AdLog.e("AdCanvasDataBuilderV2", "getArkFormComponent error");
      return null;
    }
    com.tencent.ad.tangram.canvas.views.canvas.components.form.a locala = new com.tencent.ad.tangram.canvas.views.canvas.components.form.a();
    initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
    return locala;
  }
  
  private static List<AdCanvasComponentData> getCanvasComponents(Context paramContext, Ad paramAd, JSONArray paramJSONArray, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray == null) || (paramJSONArray == JSONObject.NULL))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getCanvasComponents error");
      return localArrayList;
    }
    int i = 0;
    if (i < paramJSONArray.length())
    {
      AdCanvasComponentData localAdCanvasComponentData = getComponent(paramContext, paramAd, paramJSONArray.getJSONObject(i), paramAdCanvasData);
      if (localAdCanvasComponentData != null)
      {
        if (!(localAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a)) {
          break label92;
        }
        paramAdCanvasData.fixedButtonComponentDataList.add((com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a)localAdCanvasComponentData);
      }
      for (;;)
      {
        i += 1;
        break;
        label92:
        if ((localAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.button.a))
        {
          if (((com.tencent.ad.tangram.canvas.views.canvas.components.button.a)localAdCanvasComponentData).isFixed) {
            paramAdCanvasData.webFixedButtonComponentDataList.add((com.tencent.ad.tangram.canvas.views.canvas.components.button.a)localAdCanvasComponentData);
          } else {
            localArrayList.add(localAdCanvasComponentData);
          }
        }
        else if ((localAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.form.a))
        {
          com.tencent.ad.tangram.canvas.views.canvas.components.form.a locala = (com.tencent.ad.tangram.canvas.views.canvas.components.form.a)localAdCanvasComponentData;
          locala.index += 1;
          localArrayList.add(localAdCanvasComponentData);
        }
        else if ((localAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c))
        {
          if (((com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c)localAdCanvasComponentData).isFixed) {
            paramAdCanvasData.appFixedButtonComponentDataList.add((com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c)localAdCanvasComponentData);
          } else {
            localArrayList.add(localAdCanvasComponentData);
          }
        }
        else
        {
          localArrayList.add(localAdCanvasComponentData);
        }
      }
    }
    return localArrayList;
  }
  
  private static AdCanvasData getCanvasData(Context paramContext, Ad paramAd, JSONObject paramJSONObject)
    throws Throwable
  {
    if ((paramAd == null) || (paramJSONObject == null) || (paramJSONObject == JSONObject.NULL)) {
      AdLog.e("AdCanvasDataBuilderV2", "getCanvasData error");
    }
    AdCanvasData localAdCanvasData;
    JSONObject localJSONObject;
    do
    {
      return null;
      localAdCanvasData = new AdCanvasData();
      localAdCanvasData.ad = paramAd;
      localJSONObject = paramJSONObject.optJSONObject("content");
      if ((localJSONObject != null) && (localJSONObject != JSONObject.NULL)) {
        break;
      }
      paramJSONObject = paramJSONObject.getString("canvas_json_key");
      paramJSONObject = AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramAd, paramJSONObject, true);
    } while (TextUtils.isEmpty(paramJSONObject));
    getPageList(paramContext, paramAd, localAdCanvasData, new JSONObject(paramJSONObject).getJSONObject("content"));
    for (;;)
    {
      return localAdCanvasData;
      getPageList(paramContext, paramAd, localAdCanvasData, localJSONObject);
    }
  }
  
  private static AdCanvasData getCanvasData(Context paramContext, Ad paramAd, JSONObject paramJSONObject, boolean paramBoolean)
    throws Throwable
  {
    if ((paramAd == null) || (paramJSONObject == null) || (paramJSONObject == JSONObject.NULL)) {
      AdLog.e("AdCanvasDataBuilderV2", "getCanvasData error");
    }
    AdCanvasData localAdCanvasData;
    JSONObject localJSONObject;
    do
    {
      return null;
      localAdCanvasData = new AdCanvasData();
      localAdCanvasData.ad = paramAd;
      localAdCanvasData.setAutodownload(paramBoolean);
      localJSONObject = paramJSONObject.optJSONObject("content");
      if ((localJSONObject != null) && (localJSONObject != JSONObject.NULL)) {
        break;
      }
      paramJSONObject = paramJSONObject.getString("canvas_json_key");
      paramJSONObject = AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramAd, paramJSONObject, true);
    } while (TextUtils.isEmpty(paramJSONObject));
    getPageList(paramContext, paramAd, localAdCanvasData, new JSONObject(paramJSONObject).getJSONObject("content"));
    for (;;)
    {
      return localAdCanvasData;
      getPageList(paramContext, paramAd, localAdCanvasData, localJSONObject);
    }
  }
  
  public static int getColor(String paramString)
    throws Throwable
  {
    if (paramString.indexOf("rgb") >= 0) {
      return getRgbColor(paramString);
    }
    return Color.parseColor(paramString);
  }
  
  private static AdCanvasComponentData getComponent(Context paramContext, Ad paramAd, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getComponent error");
      localObject1 = localObject2;
    }
    String str;
    do
    {
      do
      {
        do
        {
          return localObject1;
          str = paramJSONObject.getString("type");
          localObject1 = localObject2;
        } while (TextUtils.isEmpty(str));
        if (str.equals("XJAPPH5Images")) {
          return getMulitiPictureComponent(paramContext, paramJSONObject, paramAdCanvasData);
        }
        if (str.equals("XJAppH5Button")) {
          return getAppButtonComponent(paramContext, paramJSONObject, paramAdCanvasData.basicWidth);
        }
        if (!str.equals("XJFixedButton")) {
          break;
        }
        paramContext = getFixedButtonComponent(paramContext, paramAd, paramJSONObject, paramAdCanvasData.basicWidth);
        localObject1 = paramContext;
      } while (paramContext == null);
      paramAdCanvasData.hasFixedButtonData = true;
      return paramContext;
      if (str.equals("XJWebForm")) {
        return getArkFormComponent(paramJSONObject, paramAdCanvasData);
      }
      if (str.equals("XJWebsiteH5Button")) {
        return getWebButtonComponent(paramContext, paramJSONObject, paramAdCanvasData);
      }
      if (str.equals("XJText")) {
        return getTextComponent(paramContext, paramAd, paramJSONObject, paramAdCanvasData.basicWidth);
      }
      if (str.equals("XJImages")) {
        return getWebMulitiPictureComponent(paramContext, paramJSONObject, paramAdCanvasData);
      }
      if (str.equals("XJDEFAULTImagesCarousel")) {
        return getImagesCarouselComponent(paramContext, paramJSONObject, paramAdCanvasData);
      }
      if (str.equals("XJAPPIcon")) {
        return getAppIconComponent(paramContext, paramJSONObject, paramAdCanvasData);
      }
      localObject1 = localObject2;
    } while (str.equals("XJAPPTitle"));
    throw new Exception("unknow type exception");
  }
  
  private static com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a getFixedButtonComponent(Context paramContext, Ad paramAd, JSONObject paramJSONObject, int paramInt)
    throws Throwable
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      AdLog.e("AdCanvasDataBuilderV2", "getFixedButtonComponent error");
      paramAd = null;
    }
    com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a locala;
    int i;
    label489:
    do
    {
      return paramAd;
      locala = new com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a();
      initComponent(paramJSONObject, paramInt, locala);
      paramJSONObject = paramJSONObject.getJSONObject("config");
      paramAd = paramJSONObject.getJSONObject("content");
      locala.buttonStyle = paramAd.getString("buttonStyle");
      locala.position = paramAd.getString("position");
      locala.desc = unescapeHtml(paramAd.getString("desc"));
      locala.button.text.text = unescapeHtml(paramAd.getString("text"));
      locala.imageUrl = paramAd.getString("logoUrl");
      validateUrl(locala.imageUrl);
      locala.name = unescapeHtml(paramAd.getString("name"));
      locala.fileSize = paramAd.getInt("fileSize");
      paramJSONObject = paramJSONObject.getJSONObject("style");
      locala.button.text.color = getColor(paramJSONObject.getString("color"));
      locala.button.backgroundColor = getColor(paramJSONObject.getString("backgroundColor"));
      if (!TextUtils.isEmpty(locala.buttonStyle))
      {
        if (locala.buttonStyle.equals("fixedBtn-1"))
        {
          locala.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 13);
          locala.button.text.text = "下载";
          locala.width = AdUIUtils.dp2px(81.0F, paramContext.getResources());
        }
        for (locala.height = AdUIUtils.dp2px(40.0F, paramContext.getResources());; locala.height = AdUIUtils.dp2px(40.0F, paramContext.getResources()))
        {
          if ((!TextUtils.isEmpty(locala.position)) && ((locala.position.toLowerCase().equals("top")) || (locala.position.toLowerCase().equals("bottom")))) {
            break label489;
          }
          throw new Exception("unKnow button position");
          if (!locala.buttonStyle.equals("fixedBtn-2")) {
            break;
          }
          locala.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 19);
          locala.gravity = 17;
          i = AdUIUtils.dp2px(5.0F, paramContext.getResources());
          locala.paddingTop = i;
          locala.paddingBottom = i;
          i = AdUIUtils.dp2px(7.5F, paramContext.getResources());
          locala.paddingRight = i;
          locala.paddingLeft = i;
          locala.width = (AdUIUtils.getPhysicalScreenWidth(paramContext) - locala.paddingLeft * 2);
        }
        throw new Exception("unKnow button style");
      }
      throw new Exception("unKnow button style");
      i = paramAd.optInt("bottomWhiteSpace");
      j = paramAd.optInt("topWhiteSpace");
      if (locala.position.toLowerCase().equals("top"))
      {
        locala.topWhiteSpace += AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, j);
        return locala;
      }
      paramAd = locala;
    } while (!locala.position.toLowerCase().equals("bottom"));
    int j = locala.bottomWhiteSpace;
    locala.bottomWhiteSpace = (AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, i) + j);
    return locala;
  }
  
  private static com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c getHotArea(Context paramContext, int paramInt, String paramString, JSONObject paramJSONObject, com.tencent.ad.tangram.canvas.views.canvas.components.picture.a parama)
    throws Throwable
  {
    if (parama == null) {}
    do
    {
      return null;
      paramInt = AdUIUtils.getPhysicalScreenWidth(paramContext);
      paramContext = new com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c();
      paramString = paramJSONObject.getJSONObject(paramString);
    } while (paramString == null);
    int i = parama.height + parama.paddingBottom + parama.paddingTop;
    paramContext.x = ((int)(paramString.getJSONObject("position").getInt("left") / 100.0F * paramInt));
    paramContext.y = ((int)(paramString.getJSONObject("position").getInt("top") / 100.0F * i));
    float f = paramString.getJSONObject("style").getInt("width") / 100.0F;
    paramContext.width = ((int)(paramInt * f));
    f = paramString.getJSONObject("style").getInt("height") / 100.0F;
    paramContext.height = ((int)(i * f));
    paramContext.linkType = paramString.getJSONObject("link").getString("linkType");
    paramContext.url = paramString.getJSONObject("link").optString("url");
    if (paramContext.linkType.equals("form"))
    {
      paramContext.formModId = paramString.getJSONObject("link").optString("formModId");
      paramContext.formIndex = paramString.getJSONObject("link").optInt("formId");
    }
    return paramContext;
  }
  
  private static AdCanvasComponentData getImagesCarouselComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    int i = 0;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getImagesCarouselComponent error");
      return null;
    }
    com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.a locala = new com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.a();
    initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("config");
    paramJSONObject = localJSONObject1.getJSONArray("images");
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("wrapper");
    locala.displaySpeed = ((Integer)localJSONObject1.get("displaySpeed")).intValue();
    int m = paramAdCanvasData.basicWidth;
    locala.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, localJSONObject2.getInt("marginLeft"));
    locala.marginTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, localJSONObject2.getInt("marginTop"));
    locala.marginRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, localJSONObject2.getInt("marginRight"));
    locala.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, localJSONObject2.getInt("marginBottom"));
    int j = 0;
    int k = 0;
    while (i < paramJSONObject.length())
    {
      paramAdCanvasData = new com.tencent.ad.tangram.canvas.views.canvas.components.picture.a();
      localJSONObject1 = ((JSONObject)paramJSONObject.get(i)).getJSONObject("image");
      k = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, localJSONObject1.getInt("width"));
      j = AdUIUtils.getValueDependsOnScreenWidth(paramContext, m, localJSONObject1.getInt("height"));
      paramAdCanvasData.width = k;
      paramAdCanvasData.height = j;
      paramAdCanvasData.url = localJSONObject1.getString("url");
      validateUrl(paramAdCanvasData.url);
      paramAdCanvasData.id = ("" + paramAdCanvasData.url.hashCode());
      localArrayList.add(paramAdCanvasData);
      i += 1;
    }
    locala.imageWidth = k;
    locala.imageHeight = j;
    locala.imageList = localArrayList;
    locala.width = (k * 2);
    locala.height = j;
    return locala;
  }
  
  private static com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a getMulitiPictureComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getMulitiPictureComponent error");
      return null;
    }
    com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a locala = new com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a();
    initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONObject("config").getJSONArray("images");
    int i = 0;
    if (i < paramJSONObject.length())
    {
      com.tencent.ad.tangram.canvas.views.canvas.components.picture.a locala1 = new com.tencent.ad.tangram.canvas.views.canvas.components.picture.a();
      Object localObject = (JSONObject)paramJSONObject.get(i);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("padding");
      locala1.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject.getInt("left"));
      locala1.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject.getInt("top"));
      locala1.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject.getInt("right"));
      locala1.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject.getInt("bottom"));
      locala1.floatingBarTextColor = -1;
      locala1.floatingBarBackgroundColor = Color.parseColor("#1890ff");
      localJSONObject = ((JSONObject)localObject).getJSONObject("progressBar");
      locala1.floatingBarTextColor = getColor(localJSONObject.getString("color"));
      locala1.floatingBarBackgroundColor = getColor(localJSONObject.getString("backgroundColor"));
      localJSONObject = ((JSONObject)localObject).getJSONObject("image");
      int j = localJSONObject.getInt("width");
      int k = localJSONObject.getInt("height");
      locala1.width = (AdUIUtils.getPhysicalScreenWidth(paramContext) - locala1.paddingLeft - locala1.paddingRight);
      float f = locala1.width;
      locala1.height = ((int)(k * f / j));
      locala1.url = localJSONObject.getString("url");
      validateUrl(locala1.url);
      locala1.guassianUrl = localJSONObject.optString("guassianUrl");
      locala1.id = ("" + locala1.url.hashCode());
      localJSONObject = ((JSONObject)localObject).getJSONObject("hotArea");
      if (localJSONObject.getBoolean("isSet"))
      {
        com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c[] arrayOfc = new com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c[3];
        arrayOfc[0] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea1", (JSONObject)localObject, locala1);
        arrayOfc[1] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea2", (JSONObject)localObject, locala1);
        arrayOfc[2] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea3", (JSONObject)localObject, locala1);
        localObject = new ArrayList();
        k = Integer.parseInt(localJSONObject.getString("num"));
        j = 0;
        while (j < k) {
          if (arrayOfc[j] != null)
          {
            ((ArrayList)localObject).add(arrayOfc[j]);
            j += 1;
          }
          else
          {
            throw new Exception("hot area is null");
          }
        }
      }
      for (locala1.hotAreaList = ((ArrayList)localObject);; locala1.hotAreaList = null)
      {
        localArrayList.add(locala1);
        if ((TextUtils.isEmpty(paramAdCanvasData.firstPictureComponentIdWithHotArea)) && (locala1.isHotAreaValild())) {
          paramAdCanvasData.firstPictureComponentIdWithHotArea = locala1.id;
        }
        i += 1;
        break;
      }
    }
    locala.imageList = localArrayList;
    return locala;
  }
  
  private static com.tencent.ad.tangram.canvas.views.canvas.framework.a getPage(Context paramContext, Ad paramAd, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      AdLog.e("AdCanvasDataBuilderV2", "getPage error");
      return null;
    }
    com.tencent.ad.tangram.canvas.views.canvas.framework.a locala = new com.tencent.ad.tangram.canvas.views.canvas.framework.a();
    locala.floatingBarTextColor = -1;
    locala.floatingBarBackgroundColor = Color.parseColor("#1890ff");
    Object localObject = paramJSONObject.getJSONObject("pageConfig");
    JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("config");
    String str = ((JSONObject)localObject).optString("arkFormApp");
    localObject = ((JSONObject)localObject).optString("arkFormView");
    locala.arkApp = str;
    locala.arkView = ((String)localObject);
    locala.backgroundColor = getColor(localJSONObject.getString("bgColor"));
    locala.components = getCanvasComponents(paramContext, paramAd, paramJSONObject.getJSONArray("modules"), paramAdCanvasData);
    return locala;
  }
  
  private static List<com.tencent.ad.tangram.canvas.views.canvas.framework.a> getPageList(Context paramContext, Ad paramAd, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getPageList error");
      return localArrayList;
    }
    paramContext = getPage(paramContext, paramAd, paramJSONObject, paramAdCanvasData);
    if (paramContext == null) {
      throw new Exception("getPageList error");
    }
    paramContext.hasFixedButtonData = paramAdCanvasData.hasFixedButtonData;
    localArrayList.add(paramContext);
    return localArrayList;
  }
  
  private static void getPageList(Context paramContext, Ad paramAd, AdCanvasData paramAdCanvasData, JSONObject paramJSONObject)
    throws Throwable
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("pageConfig");
    paramAdCanvasData.ad.setActionSetId(localJSONObject.getLong("actionSetId"));
    paramAdCanvasData.pageType = localJSONObject.getString("type");
    paramAdCanvasData.commonPageId = localJSONObject.getString("commonPageId");
    paramAdCanvasData.basicWidth = 375;
    paramAdCanvasData.pages = getPageList(paramContext, paramAd, paramJSONObject, paramAdCanvasData);
  }
  
  public static int getRgbColor(String paramString)
    throws Throwable
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase().replace(" ", "").replace("rgba", "").replace("rgb", "").replace("(", "").replace(")", "").split(",");
      if ((paramString != null) && (paramString.length >= 3))
      {
        if (paramString.length >= 4) {}
        for (int i = (int)(Float.parseFloat(paramString[3]) * 255.0F);; i = 255) {
          return Color.argb(i, Integer.parseInt(paramString[0]), Integer.parseInt(paramString[1]), Integer.parseInt(paramString[2]));
        }
      }
    }
    throw new Exception("color is null");
  }
  
  private static AdCanvasComponentData getTextComponent(Context paramContext, Ad paramAd, JSONObject paramJSONObject, int paramInt)
    throws Throwable
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      AdLog.e("AdCanvasDataBuilderV2", "getTextComponent error");
      return null;
    }
    if (paramAd.isAppXiJingDefault())
    {
      paramAd = new com.tencent.ad.tangram.canvas.views.canvas.components.text.a();
      initComponent(paramJSONObject, paramInt, paramAd);
      localObject1 = paramJSONObject.getJSONObject("config");
      paramJSONObject = ((JSONObject)localObject1).getJSONObject("content");
      localObject1 = ((JSONObject)localObject1).getJSONObject("style");
      paramAd.content = paramJSONObject.getString("text").replace("\\n", "\n");
      paramAd.fontSize = ((JSONObject)localObject1).getInt("fontSize");
      paramAd.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject1).getInt("marginLeft"));
      paramAd.marginTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject1).getInt("marginTop"));
      paramAd.marginRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject1).getInt("marginRight"));
      paramAd.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject1).getInt("marginBottom"));
      return paramAd;
    }
    paramAd = new com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a();
    Object localObject1 = new ArrayList();
    initComponent(paramJSONObject, paramInt, paramAd);
    paramJSONObject = paramJSONObject.getJSONObject("config");
    Object localObject2 = paramJSONObject.getJSONObject("style");
    paramAd.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject2).getInt("marginTop"));
    paramAd.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject2).getInt("marginBottom"));
    paramJSONObject = paramJSONObject.getJSONArray("images");
    paramInt = 0;
    while (paramInt < paramJSONObject.length())
    {
      localObject2 = new com.tencent.ad.tangram.canvas.views.canvas.components.picture.a();
      JSONObject localJSONObject = (JSONObject)paramJSONObject.get(paramInt);
      int i = localJSONObject.getInt("width");
      int j = localJSONObject.getInt("height");
      ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).width = (AdUIUtils.getPhysicalScreenWidth(paramContext) - ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).paddingLeft - ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).paddingRight);
      float f = ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).width;
      ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).height = ((int)(j * f / i));
      ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).url = localJSONObject.getString("url");
      validateUrl(((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).url);
      ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).id = ("" + ((com.tencent.ad.tangram.canvas.views.canvas.components.picture.a)localObject2).url.hashCode());
      ((ArrayList)localObject1).add(localObject2);
      paramInt += 1;
    }
    paramAd.imageList = ((ArrayList)localObject1);
    return paramAd;
  }
  
  private static AdCanvasComponentData getWebButtonComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      AdLog.e("AdCanvasDataBuilderV2", "getWebButtonComponent error");
      paramJSONObject = null;
      return paramJSONObject;
    }
    com.tencent.ad.tangram.canvas.views.canvas.components.button.a locala = new com.tencent.ad.tangram.canvas.views.canvas.components.button.a();
    initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("config");
    Object localObject = localJSONObject1.getJSONObject("content");
    paramJSONObject = localJSONObject1.getJSONObject("style");
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("wrapper");
    localJSONObject1 = localJSONObject1.getJSONObject("position");
    locala.button.text.text = unescapeHtml(((JSONObject)localObject).getString("text"));
    locala.linkType = ((JSONObject)localObject).getString("linkType");
    locala.actionUrl = ((JSONObject)localObject).getString("url");
    if (((JSONObject)localObject).getString("linkType").equals("form"))
    {
      locala.formIndex = ((JSONObject)localObject).getInt("formId");
      locala.formModId = ((JSONObject)localObject).getString("formModId");
    }
    locala.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject2.getInt("marginLeft"));
    locala.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject2.getInt("marginTop"));
    locala.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject2.getInt("marginRight"));
    locala.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject2.getInt("marginBottom"));
    localObject = localJSONObject2.getString("textAlign");
    if ("center".equals(localObject)) {
      locala.gravity = 17;
    }
    for (;;)
    {
      locala.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, paramJSONObject.getInt("fontSize"));
      locala.button.text.color = getColor(paramJSONObject.getString("color"));
      locala.button.backgroundColor = getColor(paramJSONObject.getString("backgroundColor"));
      locala.button.borderCornerRadius = paramJSONObject.getInt("borderRadius");
      locala.width = (paramJSONObject.getInt("width") * (AdUIUtils.getPhysicalScreenWidth(paramContext) - locala.paddingLeft - locala.paddingRight) / 100);
      locala.height = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, paramJSONObject.getInt("lineHeight"));
      locala.isFixed = localJSONObject1.optBoolean("isFixed");
      paramJSONObject = locala;
      if (!locala.isFixed) {
        break;
      }
      locala.toBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject1.getInt("toBottom"));
      int i = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject1.getInt("whiteSpace"));
      paramJSONObject = locala;
      if (i <= 0) {
        break;
      }
      locala.whiteSpace = i;
      return locala;
      if ("left".equals(localObject)) {
        locala.gravity = 3;
      } else if ("right".equals(localObject)) {
        locala.gravity = 5;
      }
    }
  }
  
  private static AdCanvasComponentData getWebMulitiPictureComponent(Context paramContext, JSONObject paramJSONObject, AdCanvasData paramAdCanvasData)
    throws Throwable
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      AdLog.e("AdCanvasDataBuilderV2", "getMulitiPictureComponent error");
      return null;
    }
    com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a locala = new com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a();
    initComponent(paramJSONObject, paramAdCanvasData.basicWidth, locala);
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONObject("config").getJSONArray("images");
    int i = 0;
    if (i < paramJSONObject.length())
    {
      com.tencent.ad.tangram.canvas.views.canvas.components.picture.a locala1 = new com.tencent.ad.tangram.canvas.views.canvas.components.picture.a();
      Object localObject = (JSONObject)paramJSONObject.get(i);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("padding");
      locala1.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject.getInt("left"));
      locala1.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject.getInt("top"));
      locala1.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject.getInt("right"));
      locala1.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramAdCanvasData.basicWidth, localJSONObject.getInt("bottom"));
      locala1.floatingBarTextColor = -1;
      locala1.floatingBarBackgroundColor = Color.parseColor("#1890ff");
      localJSONObject = ((JSONObject)localObject).getJSONObject("image");
      int j = localJSONObject.getInt("width");
      int k = localJSONObject.getInt("height");
      locala1.width = (AdUIUtils.getPhysicalScreenWidth(paramContext) - locala1.paddingLeft - locala1.paddingRight);
      float f = locala1.width;
      locala1.height = ((int)(k * f / j));
      locala1.url = localJSONObject.getString("url");
      validateUrl(locala1.url);
      locala1.guassianUrl = localJSONObject.optString("guassianUrl");
      locala1.id = ("" + locala1.url.hashCode());
      localJSONObject = ((JSONObject)localObject).getJSONObject("hotArea");
      if (localJSONObject.getBoolean("isSet"))
      {
        com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c[] arrayOfc = new com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c[3];
        arrayOfc[0] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea1", (JSONObject)localObject, locala1);
        arrayOfc[1] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea2", (JSONObject)localObject, locala1);
        arrayOfc[2] = getHotArea(paramContext, paramAdCanvasData.basicWidth, "hotArea3", (JSONObject)localObject, locala1);
        localObject = new ArrayList();
        k = Integer.parseInt(localJSONObject.getString("num"));
        j = 0;
        while (j < k) {
          if (arrayOfc[j] != null)
          {
            ((ArrayList)localObject).add(arrayOfc[j]);
            j += 1;
          }
          else
          {
            throw new Exception("hot area is null");
          }
        }
      }
      for (locala1.hotAreaList = ((ArrayList)localObject);; locala1.hotAreaList = null)
      {
        localArrayList.add(locala1);
        if ((TextUtils.isEmpty(paramAdCanvasData.firstPictureComponentIdWithHotArea)) && (locala1.isHotAreaValild())) {
          paramAdCanvasData.firstPictureComponentIdWithHotArea = locala1.id;
        }
        i += 1;
        break;
      }
    }
    locala.imageList = localArrayList;
    return locala;
  }
  
  private static void initComponent(JSONObject paramJSONObject, int paramInt, AdCanvasComponentData paramAdCanvasComponentData)
    throws Throwable
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL) || (paramAdCanvasComponentData == null))
    {
      AdLog.e("AdCanvasDataBuilderV2", "initComponent error");
      throw new Exception("initComponent error");
    }
    paramAdCanvasComponentData.id = paramJSONObject.getString("id");
  }
  
  private static void setActiveAppBtnView(AdCanvasData paramAdCanvasData)
  {
    int i = 0;
    List localList;
    if (paramAdCanvasData != null)
    {
      localList = ((com.tencent.ad.tangram.canvas.views.canvas.framework.a)paramAdCanvasData.pages.get(0)).components;
      ArrayList localArrayList = paramAdCanvasData.fixedButtonComponentDataList;
      paramAdCanvasData = paramAdCanvasData.appFixedButtonComponentDataList;
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        paramAdCanvasData = localArrayList.iterator();
      }
      while (paramAdCanvasData.hasNext())
      {
        ((com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a)paramAdCanvasData.next()).canShowProgress = true;
        continue;
        if ((paramAdCanvasData == null) || (paramAdCanvasData.size() <= 0)) {
          break label116;
        }
        if (paramAdCanvasData.get(0) != null) {
          ((com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c)paramAdCanvasData.get(0)).canShowProgress = true;
        }
      }
    }
    for (;;)
    {
      return;
      label116:
      if ((localList != null) && (localList.size() > 0)) {
        while (i < localList.size())
        {
          paramAdCanvasData = (AdCanvasComponentData)localList.get(i);
          if ((paramAdCanvasData != null) && ((paramAdCanvasData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c)))
          {
            ((com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c)paramAdCanvasData).canShowProgress = true;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  private static void setArkFormIndex(AdCanvasData paramAdCanvasData)
  {
    int i = 0;
    if (paramAdCanvasData != null)
    {
      paramAdCanvasData = ((com.tencent.ad.tangram.canvas.views.canvas.framework.a)paramAdCanvasData.pages.get(0)).components;
      int k;
      for (int j = 0; i < paramAdCanvasData.size(); j = k)
      {
        AdCanvasComponentData localAdCanvasComponentData = (AdCanvasComponentData)paramAdCanvasData.get(i);
        k = j;
        if (localAdCanvasComponentData != null)
        {
          k = j;
          if ((localAdCanvasComponentData instanceof com.tencent.ad.tangram.canvas.views.canvas.components.form.a))
          {
            ((com.tencent.ad.tangram.canvas.views.canvas.components.form.a)localAdCanvasComponentData).index = j;
            k = j + 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private static String unescapeHtml(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Spanned localSpanned;
    do
    {
      return paramString;
      localSpanned = Html.fromHtml(paramString);
    } while (localSpanned == null);
    return localSpanned.toString();
  }
  
  private static void validateUrl(String paramString)
    throws Exception
  {
    paramString = AdUriUtil.parse(paramString);
    if ((paramString == null) || ((!paramString.getScheme().equals("http")) && (!paramString.getScheme().equals("https")))) {
      throw new Exception("url type error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.AdCanvasDataBuilderV2
 * JD-Core Version:    0.7.0.1
 */