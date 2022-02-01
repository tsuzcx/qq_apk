package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.action.GetJsRuntimeListener;
import com.tencent.qqmini.miniapp.widget.CoverTextView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class TextViewJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_TEXTVIEW = "insertTextView";
  private static final String EVENT_REMOVE_TEXTVIEW = "removeTextView";
  private static final String EVENT_UPDATE_TEXTVIEW = "updateTextView";
  private static final String TAG = "TextViewJsPlugin";
  protected float density;
  private boolean needSetPadding = WnsConfig.getConfig("qqminiapp", "miniappcovertextviewpadding", true);
  
  private boolean insertTextView(JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    int i = paramJSONObject.optInt("viewId");
    int j = paramJSONObject.optInt("parentId");
    String str = paramJSONObject.optString("data");
    boolean bool2 = paramJSONObject.optBoolean("gesture");
    boolean bool3 = paramJSONObject.optBoolean("fixed", false);
    CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(i);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverTextView(this.mContext);
      ((CoverView)localObject).setData(str, bool2, GetJsRuntimeListener.get(this.mMiniAppContext));
      ((CoverView)localObject).setContentDescription(i + "_" + j);
      ((CoverView)localObject).setParentId(j);
      ((CoverView)localObject).setFixed(bool3);
      bool1 = CoverViewAction.obtain(this.mMiniAppContext).add(j, i, (CoverView)localObject, bool3);
    }
    if ((localObject instanceof CoverTextView)) {
      updateTextView((CoverTextView)localObject, paramJSONObject);
    }
    return bool1;
  }
  
  private void updateTextView(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optJSONObject("style");
    Object localObject2;
    if (localObject1 != null)
    {
      if (!((JSONObject)localObject1).has("bgColor")) {
        break label731;
      }
      localObject2 = ColorUtils.getActualColor(((JSONObject)localObject1).optString("bgColor"));
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label731;
      }
    }
    label549:
    label709:
    label717:
    label731:
    for (int i = Color.parseColor((String)localObject2);; i = 0)
    {
      if (((JSONObject)localObject1).has("borderColor"))
      {
        localObject2 = ColorUtils.getActualColor(((JSONObject)localObject1).optString("borderColor"));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
      for (int j = Color.parseColor((String)localObject2);; j = 0)
      {
        paramCoverTextView.setAlpha((float)((JSONObject)localObject1).optDouble("opacity", 0.0D));
        paramCoverTextView.setBackgroundColor(i);
        paramCoverTextView.setScaleX((float)((JSONObject)localObject1).optDouble("scaleX", 1.0D));
        paramCoverTextView.setScaleY((float)((JSONObject)localObject1).optDouble("scaleY", 1.0D));
        localObject2 = ((JSONObject)localObject1).optJSONArray("padding");
        if (localObject2 != null) {
          paramCoverTextView.setPadding(((JSONArray)localObject2).optInt(3), ((JSONArray)localObject2).optInt(0), ((JSONArray)localObject2).optInt(1), ((JSONArray)localObject2).optInt(2));
        }
        paramCoverTextView.setBorder(((JSONObject)localObject1).optInt("borderWidth", 0), j, (float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D), i);
        paramCoverTextView.setAlpha((float)((JSONObject)localObject1).optDouble("opacity", 0.0D));
        paramCoverTextView.setBorderRadius((float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D) * this.density);
        paramCoverTextView.setClickable(paramJSONObject.optBoolean("clickable"));
        paramCoverTextView.setIncludeFontPadding(false);
        localObject1 = paramJSONObject.optJSONObject("position");
        if (localObject1 != null)
        {
          i = (int)(this.density * ((JSONObject)localObject1).optInt("width") + 0.5F);
          j = (int)(this.density * ((JSONObject)localObject1).optInt("height") + 0.5F);
          int k = (int)(this.density * ((JSONObject)localObject1).optInt("left") + 0.5F);
          float f = this.density;
          int m = (int)(((JSONObject)localObject1).optInt("top") * f + 0.5F);
          localObject1 = new FrameLayout.LayoutParams(i, j);
          ((FrameLayout.LayoutParams)localObject1).leftMargin = k;
          ((FrameLayout.LayoutParams)localObject1).topMargin = m;
          paramCoverTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        paramJSONObject = paramJSONObject.optJSONObject("label");
        if (paramJSONObject != null)
        {
          if (!StringUtil.isEmpty(paramJSONObject.optString("color")))
          {
            localObject1 = ColorUtils.getActualColor(paramJSONObject.optString("color"));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              paramCoverTextView.setTextColor(Color.parseColor((String)localObject1));
            }
          }
          i = paramJSONObject.optInt("fontSize", 0);
          if (i > 0) {
            paramCoverTextView.setTextSize(0, DisplayUtil.dip2px(this.mContext, i));
          }
          localObject1 = paramJSONObject.optString("textAlign");
          if (!"left".equals(localObject1)) {
            break label670;
          }
          paramCoverTextView.setGravity(3);
          localObject1 = paramJSONObject.optString("content");
          if (!StringUtil.isEmpty((String)localObject1)) {
            paramCoverTextView.setText((String)localObject1);
          }
          if ("bold".equals(paramJSONObject.optString("fontWeight"))) {
            paramCoverTextView.setTypeface(Typeface.defaultFromStyle(1));
          }
          if (!"nowrap".equals(paramJSONObject.optString("whiteSpace", "nowrap"))) {
            break label709;
          }
          paramCoverTextView.setSingleLine(true);
          if (!"ellipsis".equals(paramJSONObject.optString("lineBreak", "clip"))) {
            break label717;
          }
          paramCoverTextView.setEllipsize(TextUtils.TruncateAt.END);
        }
        for (;;)
        {
          i = paramJSONObject.optInt("lineHeight", 0);
          if (i > 0)
          {
            i = DisplayUtil.dip2px(this.mContext, i) - paramCoverTextView.getTextView().getLineHeight();
            if (i != 0)
            {
              paramCoverTextView.setLineSpacing(i, 1.0F);
              if ((this.needSetPadding) && (Build.MANUFACTURER.equals("Xiaomi")) && (i < 0)) {
                paramCoverTextView.getTextView().setPadding(0, (int)(i / DisplayUtil.getDensity(this.mContext)), 0, 0);
              }
            }
          }
          return;
          if ("center".equals(localObject1))
          {
            paramCoverTextView.setGravity(17);
            break;
          }
          if (!"right".equals(localObject1)) {
            break;
          }
          paramCoverTextView.setGravity(5);
          break;
          paramCoverTextView.setSingleLine(false);
          break label549;
          paramCoverTextView.setEllipsize(null);
        }
      }
    }
  }
  
  private boolean updateTextView(JSONObject paramJSONObject)
  {
    CoverView localCoverView = CoverViewAction.obtain(this.mMiniAppContext).get(paramJSONObject.optInt("viewId"));
    if ((localCoverView instanceof CoverTextView))
    {
      updateTextView((CoverTextView)localCoverView, paramJSONObject);
      return true;
    }
    return false;
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.density = DisplayUtil.getDensity(this.mContext);
  }
  
  @JsEvent({"insertTextView"})
  public void setEventInsertTextview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new TextViewJsPlugin.1(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TextViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"removeTextView"})
  public void setEventRemoveTextview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new TextViewJsPlugin.3(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TextViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"updateTextView"})
  public void setEventUpdateTextview(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new TextViewJsPlugin.2(this, new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TextViewJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */