import android.graphics.Color;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentData;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData;
import com.tencent.gdtad.views.canvas.components.fixedbutton.GdtCanvasFixedButtonComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.pictures.GdtCanvasMultiPictureComponentData;
import com.tencent.gdtad.views.canvas.components.pictures.HotArea;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ypo
{
  public static int a(String paramString)
  {
    if (paramString.indexOf("rgb") >= 0) {
      return b(paramString);
    }
    return Color.parseColor(paramString);
  }
  
  public static GdtCanvasData a(GdtAd paramGdtAd)
  {
    if (paramGdtAd == null)
    {
      yny.d("GdtCanvasDataBuilderV2", "build error");
      return null;
    }
    String str = paramGdtAd.getCanvas();
    if (TextUtils.isEmpty(str))
    {
      yny.d("GdtCanvasDataBuilderV2", "build error");
      return null;
    }
    yny.b("GdtCanvasDataBuilderV2", "build " + str);
    try
    {
      paramGdtAd = a(paramGdtAd, new JSONObject(str));
      return paramGdtAd;
    }
    catch (Throwable paramGdtAd)
    {
      yny.d("GdtCanvasDataBuilderV2", "build error", paramGdtAd);
    }
    return null;
  }
  
  private static GdtCanvasData a(GdtAd paramGdtAd, JSONObject paramJSONObject)
  {
    if ((paramGdtAd == null) || (paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yny.d("GdtCanvasDataBuilderV2", "getCanvasData error");
      return null;
    }
    GdtCanvasData localGdtCanvasData = new GdtCanvasData();
    localGdtCanvasData.ad = paramGdtAd;
    JSONObject localJSONObject = paramJSONObject.getJSONObject("content").getJSONObject("pageConfig");
    localGdtCanvasData.ad.actionSetId = localJSONObject.getLong("actionSetId");
    localGdtCanvasData.pageType = localJSONObject.getString("type");
    localGdtCanvasData.commonPageId = localJSONObject.getString("commonPageId");
    localGdtCanvasData.basicWidth = 375;
    localGdtCanvasData.pages = a(paramGdtAd, paramJSONObject, localGdtCanvasData);
    return localGdtCanvasData;
  }
  
  private static GdtCanvasData a(GdtAd paramGdtAd, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if ((paramGdtAd == null) || (paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yny.d("GdtCanvasDataBuilderV2", "getCanvasData error");
      return null;
    }
    GdtCanvasData localGdtCanvasData = new GdtCanvasData();
    localGdtCanvasData.ad = paramGdtAd;
    localGdtCanvasData.setAutodownload(paramBoolean);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("content").getJSONObject("pageConfig");
    localGdtCanvasData.ad.actionSetId = localJSONObject.getLong("actionSetId");
    localGdtCanvasData.pageType = localJSONObject.getString("type");
    localGdtCanvasData.commonPageId = localJSONObject.getString("commonPageId");
    localGdtCanvasData.basicWidth = 375;
    localGdtCanvasData.pages = a(paramGdtAd, paramJSONObject, localGdtCanvasData);
    return localGdtCanvasData;
  }
  
  public static GdtCanvasData a(GdtAd paramGdtAd, boolean paramBoolean)
  {
    if (paramGdtAd == null)
    {
      yny.d("GdtCanvasDataBuilderV2", "build error");
      return null;
    }
    String str = paramGdtAd.getCanvas();
    if (TextUtils.isEmpty(str))
    {
      yny.d("GdtCanvasDataBuilderV2", "build error");
      return null;
    }
    yny.b("GdtCanvasDataBuilderV2", "build " + str);
    try
    {
      paramGdtAd = a(paramGdtAd, new JSONObject(str), paramBoolean);
      a(paramGdtAd);
      b(paramGdtAd);
      return paramGdtAd;
    }
    catch (Throwable paramGdtAd)
    {
      yny.d("GdtCanvasDataBuilderV2", "build error", paramGdtAd);
    }
    return null;
  }
  
  private static GdtCanvasComponentData a(GdtAd paramGdtAd, JSONObject paramJSONObject, GdtCanvasData paramGdtCanvasData)
  {
    Object localObject = null;
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL)) {
      yny.d("GdtCanvasDataBuilderV2", "getComponent error");
    }
    String str;
    do
    {
      do
      {
        return localObject;
        str = paramJSONObject.getString("type");
      } while (TextUtils.isEmpty(str));
      if (str.equals("XJAPPH5Images")) {
        return a(paramJSONObject, paramGdtCanvasData);
      }
      if (str.equals("XJAppH5Button")) {
        return a(paramJSONObject, paramGdtCanvasData.basicWidth);
      }
      if (!str.equals("XJFixedButton")) {
        break;
      }
      paramGdtAd = a(paramGdtAd, paramJSONObject, paramGdtCanvasData.basicWidth);
      localObject = paramGdtAd;
    } while (paramGdtAd == null);
    paramGdtCanvasData.hasFixedButtonData = true;
    return paramGdtAd;
    if (str.equals("XJWebForm")) {
      return c(paramJSONObject, paramGdtCanvasData);
    }
    if (str.equals("XJWebsiteH5Button")) {
      return b(paramJSONObject, paramGdtCanvasData);
    }
    if (str.equals("XJText")) {
      return a(paramJSONObject, paramGdtCanvasData.basicWidth);
    }
    if (str.equals("XJImages")) {
      return a(paramJSONObject, paramGdtCanvasData);
    }
    throw new Exception("unknow type exception");
  }
  
  private static GdtCanvasComponentData a(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      yny.d("GdtCanvasDataBuilderV2", "getTextComponent error");
      return null;
    }
    GdtCanvasMultiPictureComponentData localGdtCanvasMultiPictureComponentData = new GdtCanvasMultiPictureComponentData();
    ArrayList localArrayList = new ArrayList();
    a(paramJSONObject, paramInt, localGdtCanvasMultiPictureComponentData);
    paramJSONObject = paramJSONObject.getJSONObject("config");
    Object localObject = paramJSONObject.getJSONObject("style");
    localGdtCanvasMultiPictureComponentData.paddingTop = ypk.b(paramInt, ((JSONObject)localObject).getInt("marginTop"));
    localGdtCanvasMultiPictureComponentData.paddingBottom = ypk.b(paramInt, ((JSONObject)localObject).getInt("marginBottom"));
    paramJSONObject = paramJSONObject.getJSONArray("images");
    paramInt = 0;
    while (paramInt < paramJSONObject.length())
    {
      localObject = new GdtCanvasPictureComponentData();
      JSONObject localJSONObject = (JSONObject)paramJSONObject.get(paramInt);
      int i = localJSONObject.getInt("width");
      int j = localJSONObject.getInt("height");
      ((GdtCanvasPictureComponentData)localObject).width = (ypk.c(BaseApplicationImpl.getContext()) - ((GdtCanvasPictureComponentData)localObject).paddingLeft - ((GdtCanvasPictureComponentData)localObject).paddingRight);
      float f = ((GdtCanvasPictureComponentData)localObject).width;
      ((GdtCanvasPictureComponentData)localObject).height = ((int)(j * f / i));
      ((GdtCanvasPictureComponentData)localObject).url = localJSONObject.getString("url");
      a(((GdtCanvasPictureComponentData)localObject).url);
      ((GdtCanvasPictureComponentData)localObject).id = ("" + ((GdtCanvasPictureComponentData)localObject).url.hashCode());
      localArrayList.add(localObject);
      paramInt += 1;
    }
    localGdtCanvasMultiPictureComponentData.imageList = localArrayList;
    return localGdtCanvasMultiPictureComponentData;
  }
  
  private static GdtCanvasComponentData a(JSONObject paramJSONObject, GdtCanvasData paramGdtCanvasData)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yny.d("GdtCanvasDataBuilderV2", "getMulitiPictureComponent error");
      return null;
    }
    GdtCanvasMultiPictureComponentData localGdtCanvasMultiPictureComponentData = new GdtCanvasMultiPictureComponentData();
    a(paramJSONObject, paramGdtCanvasData.basicWidth, localGdtCanvasMultiPictureComponentData);
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONObject("config").getJSONArray("images");
    int i = 0;
    if (i < paramJSONObject.length())
    {
      GdtCanvasPictureComponentData localGdtCanvasPictureComponentData = new GdtCanvasPictureComponentData();
      Object localObject = (JSONObject)paramJSONObject.get(i);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("padding");
      localGdtCanvasPictureComponentData.paddingLeft = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject.getInt("left"));
      localGdtCanvasPictureComponentData.paddingTop = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject.getInt("top"));
      localGdtCanvasPictureComponentData.paddingRight = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject.getInt("right"));
      localGdtCanvasPictureComponentData.paddingBottom = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject.getInt("bottom"));
      localGdtCanvasPictureComponentData.floatingBarTextColor = -1;
      localGdtCanvasPictureComponentData.floatingBarBackgroundColor = Color.parseColor("#1890ff");
      localJSONObject = ((JSONObject)localObject).getJSONObject("image");
      int j = localJSONObject.getInt("width");
      int k = localJSONObject.getInt("height");
      localGdtCanvasPictureComponentData.width = (ypk.c(BaseApplicationImpl.getContext()) - localGdtCanvasPictureComponentData.paddingLeft - localGdtCanvasPictureComponentData.paddingRight);
      float f = localGdtCanvasPictureComponentData.width;
      localGdtCanvasPictureComponentData.height = ((int)(k * f / j));
      localGdtCanvasPictureComponentData.url = localJSONObject.getString("url");
      a(localGdtCanvasPictureComponentData.url);
      localGdtCanvasPictureComponentData.guassianUrl = localJSONObject.optString("guassianUrl");
      localGdtCanvasPictureComponentData.id = ("" + localGdtCanvasPictureComponentData.url.hashCode());
      localJSONObject = ((JSONObject)localObject).getJSONObject("hotArea");
      if (localJSONObject.getBoolean("isSet"))
      {
        HotArea[] arrayOfHotArea = new HotArea[3];
        arrayOfHotArea[0] = a(paramGdtCanvasData.basicWidth, "hotArea1", (JSONObject)localObject, localGdtCanvasPictureComponentData);
        arrayOfHotArea[1] = a(paramGdtCanvasData.basicWidth, "hotArea2", (JSONObject)localObject, localGdtCanvasPictureComponentData);
        arrayOfHotArea[2] = a(paramGdtCanvasData.basicWidth, "hotArea3", (JSONObject)localObject, localGdtCanvasPictureComponentData);
        localObject = new ArrayList();
        k = Integer.parseInt(localJSONObject.getString("num"));
        j = 0;
        while (j < k) {
          if (arrayOfHotArea[j] != null)
          {
            ((ArrayList)localObject).add(arrayOfHotArea[j]);
            j += 1;
          }
          else
          {
            throw new Exception("hot area is null");
          }
        }
      }
      for (localGdtCanvasPictureComponentData.hotAreaList = ((ArrayList)localObject);; localGdtCanvasPictureComponentData.hotAreaList = null)
      {
        localArrayList.add(localGdtCanvasPictureComponentData);
        if ((TextUtils.isEmpty(paramGdtCanvasData.firstPictureComponentIdWithHotArea)) && (localGdtCanvasPictureComponentData.isHotAreaValild())) {
          paramGdtCanvasData.firstPictureComponentIdWithHotArea = localGdtCanvasPictureComponentData.id;
        }
        i += 1;
        break;
      }
    }
    localGdtCanvasMultiPictureComponentData.imageList = localArrayList;
    return localGdtCanvasMultiPictureComponentData;
  }
  
  private static GdtCanvasAppBtnComponentData a(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      yny.d("GdtCanvasDataBuilderV2", "getAppButtonComponent error");
      paramJSONObject = null;
      return paramJSONObject;
    }
    JSONObject localJSONObject = paramJSONObject.getJSONObject("config");
    GdtCanvasAppBtnComponentData localGdtCanvasAppBtnComponentData = new GdtCanvasAppBtnComponentData();
    a(paramJSONObject, paramInt, localGdtCanvasAppBtnComponentData);
    localGdtCanvasAppBtnComponentData.button.text.text = a(localJSONObject.getJSONObject("content").getString("text"));
    paramJSONObject = localJSONObject.getJSONObject("style");
    localGdtCanvasAppBtnComponentData.button.text.color = a(paramJSONObject.getString("color"));
    localGdtCanvasAppBtnComponentData.button.backgroundColor = a(paramJSONObject.getString("backgroundColor"));
    localGdtCanvasAppBtnComponentData.button.text.size = ypk.b(paramInt, paramJSONObject.getInt("fontSize"));
    int i = paramJSONObject.getInt("width");
    localGdtCanvasAppBtnComponentData.height = ypk.b(paramInt, paramJSONObject.getInt("lineHeight"));
    paramJSONObject = localJSONObject.getJSONObject("wrapper");
    String str = paramJSONObject.getString("textAlign");
    if (TextUtils.equals(str, "center")) {
      localGdtCanvasAppBtnComponentData.gravity = 17;
    }
    for (;;)
    {
      localGdtCanvasAppBtnComponentData.paddingLeft = ypk.b(paramInt, paramJSONObject.getInt("marginLeft"));
      localGdtCanvasAppBtnComponentData.paddingRight = ypk.b(paramInt, paramJSONObject.getInt("marginRight"));
      localGdtCanvasAppBtnComponentData.width = (i * (ypk.c(BaseApplicationImpl.getContext()) - localGdtCanvasAppBtnComponentData.paddingLeft - localGdtCanvasAppBtnComponentData.paddingRight) / 100);
      localGdtCanvasAppBtnComponentData.paddingTop = ypk.b(paramInt, paramJSONObject.getInt("marginTop"));
      localGdtCanvasAppBtnComponentData.paddingBottom = ypk.b(paramInt, paramJSONObject.getInt("marginBottom"));
      localGdtCanvasAppBtnComponentData.isFixed = localJSONObject.getBoolean("isFixed");
      paramJSONObject = localGdtCanvasAppBtnComponentData;
      if (!localGdtCanvasAppBtnComponentData.isFixed) {
        break;
      }
      paramJSONObject = localJSONObject.getJSONObject("position");
      localGdtCanvasAppBtnComponentData.toBottom = ypk.b(paramInt, paramJSONObject.getInt("toBottom"));
      localGdtCanvasAppBtnComponentData.whiteSpace = ypk.b(paramInt, paramJSONObject.getInt("whiteSpace"));
      return localGdtCanvasAppBtnComponentData;
      if (TextUtils.equals(str, "left"))
      {
        localGdtCanvasAppBtnComponentData.gravity = 3;
      }
      else
      {
        if (!TextUtils.equals(str, "right")) {
          break label373;
        }
        localGdtCanvasAppBtnComponentData.gravity = 5;
      }
    }
    label373:
    throw new Exception("unknow button align");
  }
  
  private static GdtCanvasFixedButtonComponentData a(GdtAd paramGdtAd, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      yny.d("GdtCanvasDataBuilderV2", "getFixedButtonComponent error");
      paramGdtAd = null;
    }
    GdtCanvasFixedButtonComponentData localGdtCanvasFixedButtonComponentData;
    label493:
    int i;
    do
    {
      return paramGdtAd;
      localGdtCanvasFixedButtonComponentData = new GdtCanvasFixedButtonComponentData();
      a(paramJSONObject, paramInt, localGdtCanvasFixedButtonComponentData);
      paramJSONObject = paramJSONObject.getJSONObject("config");
      paramGdtAd = paramJSONObject.getJSONObject("content");
      localGdtCanvasFixedButtonComponentData.buttonStyle = paramGdtAd.getString("buttonStyle");
      localGdtCanvasFixedButtonComponentData.position = paramGdtAd.getString("position");
      localGdtCanvasFixedButtonComponentData.desc = a(paramGdtAd.getString("desc"));
      localGdtCanvasFixedButtonComponentData.button.text.text = a(paramGdtAd.getString("text"));
      localGdtCanvasFixedButtonComponentData.imageUrl = paramGdtAd.getString("logoUrl");
      a(localGdtCanvasFixedButtonComponentData.imageUrl);
      localGdtCanvasFixedButtonComponentData.name = a(paramGdtAd.getString("name"));
      localGdtCanvasFixedButtonComponentData.fileSize = paramGdtAd.getInt("fileSize");
      paramJSONObject = paramJSONObject.getJSONObject("style");
      localGdtCanvasFixedButtonComponentData.button.text.color = a(paramJSONObject.getString("color"));
      localGdtCanvasFixedButtonComponentData.button.backgroundColor = a(paramJSONObject.getString("backgroundColor"));
      if (!TextUtils.isEmpty(localGdtCanvasFixedButtonComponentData.buttonStyle))
      {
        if (localGdtCanvasFixedButtonComponentData.buttonStyle.equals("fixedBtn-1"))
        {
          localGdtCanvasFixedButtonComponentData.button.text.size = ypk.b(paramInt, 13);
          localGdtCanvasFixedButtonComponentData.button.text.text = ajjy.a(2131639379);
          localGdtCanvasFixedButtonComponentData.width = ypk.a(81.0F, BaseApplicationImpl.getContext().getResources());
          localGdtCanvasFixedButtonComponentData.height = ypk.a(40.0F, BaseApplicationImpl.getContext().getResources());
        }
        for (;;)
        {
          if ((!TextUtils.isEmpty(localGdtCanvasFixedButtonComponentData.position)) && ((localGdtCanvasFixedButtonComponentData.position.toLowerCase().equals("top")) || (localGdtCanvasFixedButtonComponentData.position.toLowerCase().equals("bottom")))) {
            break label493;
          }
          throw new Exception("unKnow button position");
          if (!localGdtCanvasFixedButtonComponentData.buttonStyle.equals("fixedBtn-2")) {
            break;
          }
          localGdtCanvasFixedButtonComponentData.button.text.size = ypk.b(paramInt, 19);
          localGdtCanvasFixedButtonComponentData.width = ypk.c(BaseApplicationImpl.getContext());
          localGdtCanvasFixedButtonComponentData.height = ypk.a(50.0F, BaseApplicationImpl.getContext().getResources());
          localGdtCanvasFixedButtonComponentData.gravity = 17;
          paramInt = ypk.a(5.0F, BaseApplicationImpl.getContext().getResources());
          localGdtCanvasFixedButtonComponentData.paddingTop = paramInt;
          localGdtCanvasFixedButtonComponentData.paddingBottom = paramInt;
          paramInt = ypk.a(7.5F, BaseApplicationImpl.getContext().getResources());
          localGdtCanvasFixedButtonComponentData.paddingRight = paramInt;
          localGdtCanvasFixedButtonComponentData.paddingLeft = paramInt;
        }
        throw new Exception("unKnow button style");
      }
      throw new Exception("unKnow button style");
      paramInt = paramGdtAd.optInt("toBottom");
      i = paramGdtAd.optInt("whiteSpace");
      localGdtCanvasFixedButtonComponentData.toBottom = paramInt;
      paramGdtAd = localGdtCanvasFixedButtonComponentData;
    } while (i <= 0);
    localGdtCanvasFixedButtonComponentData.whiteSpace = i;
    return localGdtCanvasFixedButtonComponentData;
  }
  
  private static GdtCanvasMultiPictureComponentData a(JSONObject paramJSONObject, GdtCanvasData paramGdtCanvasData)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yny.d("GdtCanvasDataBuilderV2", "getMulitiPictureComponent error");
      return null;
    }
    GdtCanvasMultiPictureComponentData localGdtCanvasMultiPictureComponentData = new GdtCanvasMultiPictureComponentData();
    a(paramJSONObject, paramGdtCanvasData.basicWidth, localGdtCanvasMultiPictureComponentData);
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONObject("config").getJSONArray("images");
    int i = 0;
    if (i < paramJSONObject.length())
    {
      GdtCanvasPictureComponentData localGdtCanvasPictureComponentData = new GdtCanvasPictureComponentData();
      Object localObject = (JSONObject)paramJSONObject.get(i);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("padding");
      localGdtCanvasPictureComponentData.paddingLeft = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject.getInt("left"));
      localGdtCanvasPictureComponentData.paddingTop = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject.getInt("top"));
      localGdtCanvasPictureComponentData.paddingRight = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject.getInt("right"));
      localGdtCanvasPictureComponentData.paddingBottom = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject.getInt("bottom"));
      localGdtCanvasPictureComponentData.floatingBarTextColor = -1;
      localGdtCanvasPictureComponentData.floatingBarBackgroundColor = Color.parseColor("#1890ff");
      localJSONObject = ((JSONObject)localObject).getJSONObject("progressBar");
      localGdtCanvasPictureComponentData.floatingBarTextColor = a(localJSONObject.getString("color"));
      localGdtCanvasPictureComponentData.floatingBarBackgroundColor = a(localJSONObject.getString("backgroundColor"));
      localJSONObject = ((JSONObject)localObject).getJSONObject("image");
      int j = localJSONObject.getInt("width");
      int k = localJSONObject.getInt("height");
      localGdtCanvasPictureComponentData.width = (ypk.c(BaseApplicationImpl.getContext()) - localGdtCanvasPictureComponentData.paddingLeft - localGdtCanvasPictureComponentData.paddingRight);
      float f = localGdtCanvasPictureComponentData.width;
      localGdtCanvasPictureComponentData.height = ((int)(k * f / j));
      localGdtCanvasPictureComponentData.url = localJSONObject.getString("url");
      a(localGdtCanvasPictureComponentData.url);
      localGdtCanvasPictureComponentData.guassianUrl = localJSONObject.optString("guassianUrl");
      localGdtCanvasPictureComponentData.id = ("" + localGdtCanvasPictureComponentData.url.hashCode());
      localJSONObject = ((JSONObject)localObject).getJSONObject("hotArea");
      if (localJSONObject.getBoolean("isSet"))
      {
        HotArea[] arrayOfHotArea = new HotArea[3];
        arrayOfHotArea[0] = a(paramGdtCanvasData.basicWidth, "hotArea1", (JSONObject)localObject, localGdtCanvasPictureComponentData);
        arrayOfHotArea[1] = a(paramGdtCanvasData.basicWidth, "hotArea2", (JSONObject)localObject, localGdtCanvasPictureComponentData);
        arrayOfHotArea[2] = a(paramGdtCanvasData.basicWidth, "hotArea3", (JSONObject)localObject, localGdtCanvasPictureComponentData);
        localObject = new ArrayList();
        k = Integer.parseInt(localJSONObject.getString("num"));
        j = 0;
        while (j < k) {
          if (arrayOfHotArea[j] != null)
          {
            ((ArrayList)localObject).add(arrayOfHotArea[j]);
            j += 1;
          }
          else
          {
            throw new Exception("hot area is null");
          }
        }
      }
      for (localGdtCanvasPictureComponentData.hotAreaList = ((ArrayList)localObject);; localGdtCanvasPictureComponentData.hotAreaList = null)
      {
        localArrayList.add(localGdtCanvasPictureComponentData);
        if ((TextUtils.isEmpty(paramGdtCanvasData.firstPictureComponentIdWithHotArea)) && (localGdtCanvasPictureComponentData.isHotAreaValild())) {
          paramGdtCanvasData.firstPictureComponentIdWithHotArea = localGdtCanvasPictureComponentData.id;
        }
        i += 1;
        break;
      }
    }
    localGdtCanvasMultiPictureComponentData.imageList = localArrayList;
    return localGdtCanvasMultiPictureComponentData;
  }
  
  private static HotArea a(int paramInt, String paramString, JSONObject paramJSONObject, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData)
  {
    if (paramGdtCanvasPictureComponentData == null) {}
    HotArea localHotArea;
    do
    {
      return null;
      paramInt = ypk.c(BaseApplicationImpl.getContext());
      localHotArea = new HotArea();
      paramString = paramJSONObject.getJSONObject(paramString);
    } while (paramString == null);
    int i = paramGdtCanvasPictureComponentData.height + paramGdtCanvasPictureComponentData.paddingBottom + paramGdtCanvasPictureComponentData.paddingTop;
    localHotArea.x = ((int)(paramString.getJSONObject("position").getInt("left") / 100.0F * paramInt));
    localHotArea.y = ((int)(paramString.getJSONObject("position").getInt("top") / 100.0F * i));
    float f = paramString.getJSONObject("style").getInt("width") / 100.0F;
    localHotArea.width = ((int)(paramInt * f));
    f = paramString.getJSONObject("style").getInt("height") / 100.0F;
    localHotArea.height = ((int)(i * f));
    localHotArea.linkType = paramString.getJSONObject("link").getString("linkType");
    localHotArea.url = paramString.getJSONObject("link").optString("url");
    if (localHotArea.linkType.equals("form"))
    {
      localHotArea.formModId = paramString.getJSONObject("link").optString("formModId");
      localHotArea.formIndex = paramString.getJSONObject("link").optInt("formId");
    }
    return localHotArea;
  }
  
  private static GdtCanvasPageData a(GdtAd paramGdtAd, JSONObject paramJSONObject, GdtCanvasData paramGdtCanvasData)
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      yny.d("GdtCanvasDataBuilderV2", "getPage error");
      return null;
    }
    GdtCanvasPageData localGdtCanvasPageData = new GdtCanvasPageData();
    localGdtCanvasPageData.floatingBarTextColor = -1;
    localGdtCanvasPageData.floatingBarBackgroundColor = Color.parseColor("#1890ff");
    Object localObject = paramJSONObject.getJSONObject("pageConfig");
    JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("config");
    String str = ((JSONObject)localObject).optString("arkFormApp");
    localObject = ((JSONObject)localObject).optString("arkFormView");
    localGdtCanvasPageData.arkApp = str;
    localGdtCanvasPageData.arkView = ((String)localObject);
    localGdtCanvasPageData.backgroundColor = a(localJSONObject.getString("bgColor"));
    localGdtCanvasPageData.components = a(paramGdtAd, paramJSONObject.getJSONArray("modules"), paramGdtCanvasData);
    return localGdtCanvasPageData;
  }
  
  private static String a(String paramString)
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
  
  private static List<GdtCanvasComponentData> a(GdtAd paramGdtAd, JSONArray paramJSONArray, GdtCanvasData paramGdtCanvasData)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray == null) || (paramJSONArray == JSONObject.NULL))
    {
      yny.d("GdtCanvasDataBuilderV2", "getCanvasComponents error");
      return localArrayList;
    }
    int i = 0;
    if (i < paramJSONArray.length())
    {
      GdtCanvasComponentData localGdtCanvasComponentData = a(paramGdtAd, paramJSONArray.getJSONObject(i), paramGdtCanvasData);
      if (localGdtCanvasComponentData != null)
      {
        if (!(localGdtCanvasComponentData instanceof GdtCanvasFixedButtonComponentData)) {
          break label86;
        }
        paramGdtCanvasData.fixedButtonComponentDataList.add((GdtCanvasFixedButtonComponentData)localGdtCanvasComponentData);
      }
      for (;;)
      {
        i += 1;
        break;
        label86:
        if ((localGdtCanvasComponentData instanceof GdtCanvasButtonComponentData))
        {
          if (((GdtCanvasButtonComponentData)localGdtCanvasComponentData).isFixed) {
            paramGdtCanvasData.webFixedButtonComponentDataList.add((GdtCanvasButtonComponentData)localGdtCanvasComponentData);
          } else {
            localArrayList.add(localGdtCanvasComponentData);
          }
        }
        else if ((localGdtCanvasComponentData instanceof GdtCanvasFormComponentData))
        {
          GdtCanvasFormComponentData localGdtCanvasFormComponentData = (GdtCanvasFormComponentData)localGdtCanvasComponentData;
          localGdtCanvasFormComponentData.index += 1;
          localArrayList.add(localGdtCanvasComponentData);
        }
        else if ((localGdtCanvasComponentData instanceof GdtCanvasAppBtnComponentData))
        {
          if (((GdtCanvasAppBtnComponentData)localGdtCanvasComponentData).isFixed) {
            paramGdtCanvasData.appFixedButtonComponentDataList.add((GdtCanvasAppBtnComponentData)localGdtCanvasComponentData);
          } else {
            localArrayList.add(localGdtCanvasComponentData);
          }
        }
        else
        {
          localArrayList.add(localGdtCanvasComponentData);
        }
      }
    }
    return localArrayList;
  }
  
  private static List<GdtCanvasPageData> a(GdtAd paramGdtAd, JSONObject paramJSONObject, GdtCanvasData paramGdtCanvasData)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL))
    {
      yny.d("GdtCanvasDataBuilderV2", "getPageList error");
      return localArrayList;
    }
    paramGdtAd = a(paramGdtAd, paramJSONObject.getJSONObject("content"), paramGdtCanvasData);
    if (paramGdtAd == null) {
      throw new Exception("getPageList error");
    }
    paramGdtAd.hasFixedButtonData = paramGdtCanvasData.hasFixedButtonData;
    localArrayList.add(paramGdtAd);
    return localArrayList;
  }
  
  private static void a(GdtCanvasData paramGdtCanvasData)
  {
    int i = 0;
    if (paramGdtCanvasData != null)
    {
      paramGdtCanvasData = ((GdtCanvasPageData)paramGdtCanvasData.pages.get(0)).components;
      int k;
      for (int j = 0; i < paramGdtCanvasData.size(); j = k)
      {
        GdtCanvasComponentData localGdtCanvasComponentData = (GdtCanvasComponentData)paramGdtCanvasData.get(i);
        k = j;
        if (localGdtCanvasComponentData != null)
        {
          k = j;
          if ((localGdtCanvasComponentData instanceof GdtCanvasFormComponentData))
          {
            ((GdtCanvasFormComponentData)localGdtCanvasComponentData).index = j;
            k = j + 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private static void a(String paramString)
  {
    paramString = AdUriUtil.parse(paramString);
    if ((paramString == null) || ((!paramString.getScheme().equals("http")) && (!paramString.getScheme().equals("https")))) {
      throw new Exception("url type error");
    }
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt, GdtCanvasComponentData paramGdtCanvasComponentData)
  {
    if ((paramJSONObject == null) || (paramJSONObject == JSONObject.NULL) || (paramGdtCanvasComponentData == null))
    {
      yny.d("GdtCanvasDataBuilderV2", "initComponent error");
      throw new Exception("initComponent error");
    }
    paramGdtCanvasComponentData.id = paramJSONObject.getString("id");
  }
  
  public static int b(String paramString)
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
  
  private static GdtCanvasComponentData b(JSONObject paramJSONObject, GdtCanvasData paramGdtCanvasData)
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      yny.d("GdtCanvasDataBuilderV2", "getWebButtonComponent error");
      paramJSONObject = null;
      return paramJSONObject;
    }
    GdtCanvasButtonComponentData localGdtCanvasButtonComponentData = new GdtCanvasButtonComponentData();
    a(paramJSONObject, paramGdtCanvasData.basicWidth, localGdtCanvasButtonComponentData);
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("config");
    Object localObject = localJSONObject1.getJSONObject("content");
    paramJSONObject = localJSONObject1.getJSONObject("style");
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("wrapper");
    localJSONObject1 = localJSONObject1.getJSONObject("position");
    localGdtCanvasButtonComponentData.button.text.text = a(((JSONObject)localObject).getString("text"));
    localGdtCanvasButtonComponentData.linkType = ((JSONObject)localObject).getString("linkType");
    localGdtCanvasButtonComponentData.actionUrl = ((JSONObject)localObject).getString("url");
    if (((JSONObject)localObject).getString("linkType").equals("form"))
    {
      localGdtCanvasButtonComponentData.formIndex = ((JSONObject)localObject).getInt("formId");
      localGdtCanvasButtonComponentData.formModId = ((JSONObject)localObject).getString("formModId");
    }
    localGdtCanvasButtonComponentData.paddingLeft = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject2.getInt("marginLeft"));
    localGdtCanvasButtonComponentData.paddingTop = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject2.getInt("marginTop"));
    localGdtCanvasButtonComponentData.paddingRight = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject2.getInt("marginRight"));
    localGdtCanvasButtonComponentData.paddingBottom = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject2.getInt("marginBottom"));
    localObject = localJSONObject2.getString("textAlign");
    if ("center".equals(localObject)) {
      localGdtCanvasButtonComponentData.gravity = 17;
    }
    for (;;)
    {
      localGdtCanvasButtonComponentData.button.text.size = ypk.b(paramGdtCanvasData.basicWidth, paramJSONObject.getInt("fontSize"));
      localGdtCanvasButtonComponentData.button.text.color = a(paramJSONObject.getString("color"));
      localGdtCanvasButtonComponentData.button.backgroundColor = a(paramJSONObject.getString("backgroundColor"));
      localGdtCanvasButtonComponentData.button.borderCornerRadius = paramJSONObject.getInt("borderRadius");
      localGdtCanvasButtonComponentData.width = (paramJSONObject.getInt("width") * (ypk.c(BaseApplicationImpl.getContext()) - localGdtCanvasButtonComponentData.paddingLeft - localGdtCanvasButtonComponentData.paddingRight) / 100);
      localGdtCanvasButtonComponentData.height = ypk.b(paramGdtCanvasData.basicWidth, paramJSONObject.getInt("lineHeight"));
      localGdtCanvasButtonComponentData.isFixed = localJSONObject1.optBoolean("isFixed");
      paramJSONObject = localGdtCanvasButtonComponentData;
      if (!localGdtCanvasButtonComponentData.isFixed) {
        break;
      }
      localGdtCanvasButtonComponentData.toBottom = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject1.getInt("toBottom"));
      int i = ypk.b(paramGdtCanvasData.basicWidth, localJSONObject1.getInt("whiteSpace"));
      paramJSONObject = localGdtCanvasButtonComponentData;
      if (i <= 0) {
        break;
      }
      localGdtCanvasButtonComponentData.whiteSpace = i;
      return localGdtCanvasButtonComponentData;
      if ("left".equals(localObject)) {
        localGdtCanvasButtonComponentData.gravity = 3;
      } else if ("right".equals(localObject)) {
        localGdtCanvasButtonComponentData.gravity = 5;
      }
    }
  }
  
  private static void b(GdtCanvasData paramGdtCanvasData)
  {
    int i = 0;
    Object localObject;
    if (paramGdtCanvasData != null)
    {
      localObject = ((GdtCanvasPageData)paramGdtCanvasData.pages.get(0)).components;
      ArrayList localArrayList1 = paramGdtCanvasData.fixedButtonComponentDataList;
      ArrayList localArrayList2 = paramGdtCanvasData.appFixedButtonComponentDataList;
      if ((localArrayList1 != null) && (localArrayList1.size() > 0)) {
        localObject = localArrayList1.iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        ((GdtCanvasFixedButtonComponentData)((Iterator)localObject).next()).canShowProgress = paramGdtCanvasData.getAutoDownLoad();
        continue;
        if ((localArrayList2 == null) || (localArrayList2.size() <= 0)) {
          break label124;
        }
        if (localArrayList2.get(0) != null) {
          ((GdtCanvasAppBtnComponentData)localArrayList2.get(0)).canShowProgress = true;
        }
      }
    }
    for (;;)
    {
      return;
      label124:
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        while (i < ((List)localObject).size())
        {
          paramGdtCanvasData = (GdtCanvasComponentData)((List)localObject).get(i);
          if ((paramGdtCanvasData != null) && ((paramGdtCanvasData instanceof GdtCanvasAppBtnComponentData)))
          {
            ((GdtCanvasAppBtnComponentData)paramGdtCanvasData).canShowProgress = true;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  private static GdtCanvasComponentData c(JSONObject paramJSONObject, GdtCanvasData paramGdtCanvasData)
  {
    if (paramJSONObject == JSONObject.NULL)
    {
      yny.d("GdtCanvasDataBuilderV2", "getArkFormComponent error");
      return null;
    }
    GdtCanvasFormComponentData localGdtCanvasFormComponentData = new GdtCanvasFormComponentData();
    a(paramJSONObject, paramGdtCanvasData.basicWidth, localGdtCanvasFormComponentData);
    return localGdtCanvasFormComponentData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ypo
 * JD-Core Version:    0.7.0.1
 */