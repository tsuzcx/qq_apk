package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acfp;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.DateUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.DatePickerView;
import com.tencent.mobileqq.mini.widget.MutiPickerView;
import com.tencent.mobileqq.mini.widget.ToastView;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.NavigatorBarForMiniGame;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class UIJsPlugin
  extends BaseJsPlugin
{
  private static final int DEFAULT_TYPE = 0;
  private static final String EVENT_DISABLE_SROLL_BOUNCE = "disableScrollBounce";
  private static final String EVENT_GET_MENU_BUTTON_RECT = "getMenuButtonBoundingClientRect";
  private static final String EVENT_GET_REGION_DATA = "getRegionData";
  private static final String EVENT_HIDE_HOME_BUTTON = "hideHomeButton";
  public static final String EVENT_HIDE_LOADING = "hideLoading";
  private static final String EVENT_HIDE_MINIAIO_ENTRANCE = "hideMiniAIOEntrance";
  public static final String EVENT_HIDE_TOAST = "hideToast";
  private static final String EVENT_INSERT_IMAGEVIEW = "insertImageView";
  private static final String EVENT_INSERT_SCROLLVIEW = "insertScrollView";
  private static final String EVENT_INSERT_TEXTAREA = "insertTextArea";
  private static final String EVENT_INSERT_TEXTVIEW = "insertTextView";
  private static final String EVENT_PAGE_SCROLL_TO = "scrollWebviewTo";
  private static final String EVENT_REMOVE_IMAGEVIEW = "removeImageView";
  private static final String EVENT_REMOVE_SCROLLVIEW = "removeScrollView";
  private static final String EVENT_REMOVE_TEXTAREA = "removeTextArea";
  private static final String EVENT_REMOVE_TEXTVIEW = "removeTextView";
  private static final String EVENT_SET_BACKGROUD_COLOR = "setBackgroundColor";
  private static final String EVENT_SET_BACKGROUD_TEXT_STYLE = "setBackgroundTextStyle";
  public static final String EVENT_SHOW_ACTION_SHEET = "showActionSheet";
  private static final String EVENT_SHOW_DATA_PICKER_VIEW = "showDatePickerView";
  public static final String EVENT_SHOW_LOADING = "showLoading";
  private static final String EVENT_SHOW_MINIAIO_ENTRANCE = "showMiniAIOEntrance";
  public static final String EVENT_SHOW_MODAL = "showModal";
  private static final String EVENT_SHOW_MUTI_PICKER_VIEW = "showMultiPickerView";
  private static final String EVENT_SHOW_PICKER_VIEW = "showPickerView";
  public static final String EVENT_SHOW_TOAST = "showToast";
  private static final String EVENT_START_PULLDOWN_REFRESH = "startPullDownRefresh";
  private static final String EVENT_STOP_PULLDOWN_REFRESH = "stopPullDownRefresh";
  private static final String EVENT_UPDATA_SCROLLVIEW = "updateScrollView";
  private static final String EVENT_UPDATE_IMAGEVIEW = "updateImageView";
  private static final String EVENT_UPDATE_MULTI_PICKER_VIEW = "updateMultiPickerView";
  private static final String EVENT_UPDATE_TEXTAREA = "updateTextArea";
  private static final String EVENT_UPDATE_TEXTVIEW = "updateTextView";
  private static final Set<String> S_EVENT_MAP = new UIJsPlugin.1();
  public static final String TAG = "[mini] UIJsPlugin";
  private final int SHARE_PANEL_TYPE = 1;
  AbsAppBrandPage lastPage = null;
  private int menuButtonHeight = 30;
  private Rect menuButtonRect = new Rect(267, 34, 347, 64);
  private int menuButtonWidth = 80;
  private MutiPickerView mutiPickerView;
  private QQToast toast;
  private ToastView toastView;
  
  private String getMenuButtonDefaultValue()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("width", 80);
      ((JSONObject)localObject).put("height", 30);
      ((JSONObject)localObject).put("top", 34);
      ((JSONObject)localObject).put("right", 347);
      ((JSONObject)localObject).put("bottom", 64);
      ((JSONObject)localObject).put("left", 267);
      QLog.d("[mini] UIJsPlugin", 1, "getMenuButtonDefaultValue : " + ((JSONObject)localObject).toString());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("[mini] UIJsPlugin", 1, "getDefaultValue error.", localJSONException);
    }
    return "";
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[mini] UIJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    }
    if ("showToast".equals(paramString1)) {}
    int i;
    int j;
    int k;
    for (;;)
    {
      Object localObject5;
      boolean bool;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString2);
        localObject5 = localJSONObject1.optString("title", "");
        i = localJSONObject1.optInt("duration", 1500);
        bool = localJSONObject1.optBoolean("mask", false);
        AppBrandTask.runTaskOnUiThread(new UIJsPlugin.2(this, paramJsRuntime, localJSONObject1.optString("icon", "success"), localJSONObject1.optString("image", ""), (String)localObject5, i, bool, paramString1, paramInt));
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
      catch (JSONException localJSONException1)
      {
        QLog.e("[mini] UIJsPlugin", 2, localJSONException1, new Object[0]);
        continue;
      }
      if ("showLoading".equals(paramString1))
      {
        try
        {
          JSONObject localJSONObject2 = new JSONObject(paramString2);
          AppBrandTask.runTaskOnUiThread(new UIJsPlugin.3(this, paramJsRuntime, localJSONObject2.optString("title", ""), localJSONObject2.optBoolean("mask", false), paramString1, paramInt));
        }
        catch (JSONException localJSONException2) {}
        if (QLog.isColorLevel()) {
          QLog.e("[mini] UIJsPlugin", 2, localJSONException2, new Object[0]);
        }
      }
      else if (("hideToast".equals(paramString1)) || ("hideLoading".equals(paramString1)))
      {
        AppBrandTask.runTaskOnUiThread(new UIJsPlugin.4(this, paramJsRuntime, paramString1, paramInt));
      }
      else if ("showPickerView".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new UIJsPlugin.5(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
      else if ("showMultiPickerView".equals(paramString1))
      {
        AppBrandTask.runTaskOnUiThread(new UIJsPlugin.6(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
      else if ("getRegionData".equals(paramString1))
      {
        JSONObject localJSONObject3 = new JSONObject();
        try
        {
          localJSONObject3.put("data", FileUtils.readFileFromAssets("mini/region"));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, localJSONObject3, paramInt);
        }
        catch (JSONException localJSONException3)
        {
          QLog.e("[mini] UIJsPlugin", 2, "getRegionData exception: ", localJSONException3);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
        }
      }
      else
      {
        Object localObject7;
        Object localObject6;
        if ("showDatePickerView".equals(paramString1))
        {
          try
          {
            localObject7 = new JSONObject(paramString2);
            localObject6 = ((JSONObject)localObject7).optJSONObject("range");
            localObject5 = ((JSONObject)localObject7).optString("current");
            Object localObject1 = localObject5;
            if (TextUtils.isEmpty((CharSequence)localObject5))
            {
              localObject1 = Calendar.getInstance();
              i = ((Calendar)localObject1).get(1);
              j = ((Calendar)localObject1).get(2);
              k = ((Calendar)localObject1).get(5);
              localObject1 = i + "-" + (j + 1) + "" + k;
            }
            localObject5 = ((JSONObject)localObject7).optString("mode");
            localObject7 = ((JSONObject)localObject7).optString("fields");
            if (!"date".equals(localObject5)) {
              break label648;
            }
            localObject1 = DateUtils.getSmartDateByTime((String)localObject1);
            if (localObject1 == null)
            {
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
              return "";
            }
            AppBrandTask.runTaskOnUiThread(new UIJsPlugin.7(this, (Date)localObject1, (String)localObject7, paramJsRuntime, paramString1, paramInt, (JSONObject)localObject6));
          }
          catch (JSONException localJSONException4)
          {
            QLog.e("[mini] UIJsPlugin", 2, localJSONException4, new Object[0]);
          }
          continue;
          label648:
          if ("time".equals(localObject5)) {
            AppBrandTask.runTaskOnUiThread(new UIJsPlugin.8(this, DateUtils.getTimeByStrTime(localJSONException4), paramJsRuntime, paramString1, paramInt, (JSONObject)localObject6));
          }
        }
        else if ("startPullDownRefresh".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new UIJsPlugin.9(this, paramString1, paramJsRuntime, paramInt));
        }
        else if ("stopPullDownRefresh".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new UIJsPlugin.10(this, paramJsRuntime, paramString1, paramInt));
        }
        else if ("disableScrollBounce".equals(paramString1))
        {
          try
          {
            JSONObject localJSONObject4 = new JSONObject(paramString2);
            if (!localJSONObject4.has("disable")) {
              continue;
            }
            AppBrandTask.runTaskOnUiThread(new UIJsPlugin.11(this, localJSONObject4.optBoolean("disable", false), paramJsRuntime, paramString1, paramInt));
          }
          catch (Exception localException1)
          {
            QLog.e("[mini] UIJsPlugin", 2, "EVENT_DISABLE_SROLL_BOUNCE error," + localException1);
          }
        }
        else
        {
          Object localObject8;
          if ("showModal".equals(paramString1))
          {
            try
            {
              JSONObject localJSONObject5 = new JSONObject(paramString2);
              localObject5 = localJSONObject5.optString("title", "");
              localObject6 = localJSONObject5.optString("content", "");
              bool = localJSONObject5.optBoolean("showCancel", true);
              localObject7 = localJSONObject5.optString("cancelText", acfp.m(2131716201));
              localObject8 = localJSONObject5.optString("cancelColor", "#000000");
              AppBrandTask.runTaskOnUiThread(new UIJsPlugin.12(this, (String)localObject5, (String)localObject6, localJSONObject5.optString("confirmText", acfp.m(2131716200)), localJSONObject5.optString("confirmColor", "#3CC51F"), paramJsRuntime, paramString1, paramInt, bool, (String)localObject7, (String)localObject8));
            }
            catch (JSONException localJSONException5)
            {
              QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException5);
            }
          }
          else if ("showActionSheet".equals(paramString1))
          {
            AppBrandTask.runTaskOnUiThread(new UIJsPlugin.13(this, paramString2, paramJsRuntime, paramString1, paramInt));
          }
          else if ("setBackgroundColor".equals(paramString1))
          {
            AppBrandTask.runTaskOnUiThread(new UIJsPlugin.14(this, paramString2, paramJsRuntime, paramString1, paramInt));
          }
          else if ("setBackgroundTextStyle".equals(paramString1))
          {
            AppBrandTask.runTaskOnUiThread(new UIJsPlugin.15(this, paramString2, paramString1, paramJsRuntime, paramInt));
          }
          else
          {
            if ("insertHTMLWebView".equals(paramString1))
            {
              AppBrandTask.runTaskOnUiThread(new UIJsPlugin.16(this, paramString2, paramJsRuntime, paramString1, paramInt));
              return "";
            }
            if ("updateHTMLWebView".equals(paramString1))
            {
              AppBrandTask.runTaskOnUiThread(new UIJsPlugin.17(this, paramString2, paramJsRuntime, paramString1, paramInt));
              return "";
            }
            if ("removeHTMLWebView".equals(paramString1))
            {
              AppBrandTask.runTaskOnUiThread(new UIJsPlugin.18(this, paramString2, paramJsRuntime, paramString1, paramInt));
            }
            else
            {
              JSONObject localJSONObject9;
              label1369:
              Boolean localBoolean2;
              if ("insertImageView".equals(paramString1)) {
                for (;;)
                {
                  try
                  {
                    localObject8 = new JSONObject(paramString2);
                    i = ((JSONObject)localObject8).optInt("viewId");
                    j = ((JSONObject)localObject8).optInt("parentId");
                    localObject5 = ((JSONObject)localObject8).optString("iconPath");
                    localObject6 = ((JSONObject)localObject8).optString("data");
                    localObject7 = ((JSONObject)localObject8).optJSONObject("position");
                    if (!((JSONObject)localObject8).has("clickable")) {
                      break label1369;
                    }
                    Boolean localBoolean1 = Boolean.valueOf(((JSONObject)localObject8).optBoolean("clickable"));
                    localJSONObject9 = ((JSONObject)localObject8).optJSONObject("style");
                    bool = ((JSONObject)localObject8).optBoolean("fixed", false);
                    localObject8 = new JSONObject();
                    ((JSONObject)localObject8).put("viewId", i);
                    AppBrandTask.runTaskOnUiThread(new UIJsPlugin.19(this, paramJsRuntime, (JSONObject)localObject7, (String)localObject6, j, i, (String)localObject5, localBoolean1, localJSONObject9, bool, paramString1, (JSONObject)localObject8, paramInt));
                  }
                  catch (JSONException localJSONException6)
                  {
                    QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException6);
                  }
                  break;
                  localBoolean2 = null;
                }
              }
              label1553:
              Object localObject2;
              if ("updateImageView".equals(paramString1)) {
                for (;;)
                {
                  try
                  {
                    localObject7 = new JSONObject(paramString2);
                    i = ((JSONObject)localObject7).optInt("viewId");
                    localObject5 = ((JSONObject)localObject7).optString("iconPath");
                    localObject6 = ((JSONObject)localObject7).optJSONObject("position");
                    if (!((JSONObject)localObject7).has("clickable")) {
                      break label1553;
                    }
                    localBoolean2 = Boolean.valueOf(((JSONObject)localObject7).optBoolean("clickable"));
                    localObject8 = ((JSONObject)localObject7).optJSONObject("style");
                    localObject7 = ((JSONObject)localObject7).optString("data");
                    localJSONObject9 = new JSONObject();
                    localJSONObject9.put("viewId", i);
                    AppBrandTask.runTaskOnUiThread(new UIJsPlugin.20(this, paramJsRuntime, (JSONObject)localObject6, (String)localObject7, i, (String)localObject5, localBoolean2, (JSONObject)localObject8, paramString1, localJSONObject9, paramInt));
                  }
                  catch (JSONException localJSONException7)
                  {
                    QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException7);
                  }
                  break;
                  localObject2 = null;
                }
              }
              label1769:
              JSONObject localJSONObject6;
              if ("scrollWebviewTo".equals(paramString1)) {
                for (;;)
                {
                  try
                  {
                    localObject2 = new JSONObject(paramString2);
                    long l = ((JSONObject)localObject2).optLong("duration", 300L);
                    float f = DisplayUtil.getDensity(this.jsPluginEngine.getActivityContext());
                    i = (int)(((JSONObject)localObject2).optInt("scrollTop") * f + 0.5F);
                    localObject2 = ((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId());
                    if (localObject2 == null) {
                      break label1769;
                    }
                    localObject2 = ((AbsAppBrandPage)localObject2).getCurrentPageWebview();
                    if (localObject2 == null) {
                      break;
                    }
                    localObject5 = ValueAnimator.ofInt(new int[] { ((PageWebview)localObject2).getView().getScrollY(), i }).setDuration(l);
                    ((ValueAnimator)localObject5).addUpdateListener(new UIJsPlugin.21(this, (PageWebview)localObject2));
                    ((Animator)localObject5).addListener(new UIJsPlugin.22(this, paramJsRuntime, paramString1, paramInt));
                    ((Animator)localObject5).start();
                  }
                  catch (Exception localException2)
                  {
                    MiniLog.e("[mini] UIJsPlugin", 4, localException2.getMessage(), localException2, new Object[0]);
                    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
                  }
                  break;
                  localJSONObject6 = null;
                }
              }
              if ("insertTextArea".equals(paramString1))
              {
                try
                {
                  localJSONObject6 = new JSONObject(paramString2);
                  i = localJSONObject6.optInt("inputId");
                  localObject5 = new JSONObject();
                  ((JSONObject)localObject5).put("inputId", i);
                  localObject6 = localJSONObject6.optString("data");
                  if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                    ((JSONObject)localObject5).put("data", localObject6);
                  }
                  AppBrandTask.runTaskOnUiThread(new UIJsPlugin.23(this, paramJsRuntime, i, localJSONObject6, paramString1, (JSONObject)localObject5, paramInt));
                }
                catch (JSONException localJSONException8)
                {
                  QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException8);
                }
              }
              else if ("removeTextArea".equals(paramString1))
              {
                try
                {
                  i = new JSONObject(paramString2).optInt("inputId");
                  JSONObject localJSONObject7 = new JSONObject();
                  localJSONObject7.put("inputId", i);
                  AppBrandTask.runTaskOnUiThread(new UIJsPlugin.24(this, paramJsRuntime, i, paramString1, localJSONObject7, paramInt));
                }
                catch (JSONException localJSONException9)
                {
                  QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException9);
                }
              }
              else if ("updateTextArea".equals(paramString1))
              {
                try
                {
                  JSONObject localJSONObject8 = new JSONObject(paramString2);
                  i = localJSONObject8.optInt("inputId");
                  localObject5 = new JSONObject();
                  ((JSONObject)localObject5).put("inputId", i);
                  localObject6 = localJSONObject8.optString("data");
                  if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                    ((JSONObject)localObject5).put("data", localObject6);
                  }
                  AppBrandTask.runTaskOnUiThread(new UIJsPlugin.25(this, paramJsRuntime, localJSONObject8, paramString1, (JSONObject)localObject5, paramInt));
                }
                catch (JSONException localJSONException10)
                {
                  QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException10);
                }
              }
              else if ("insertTextView".equals(paramString1))
              {
                try
                {
                  AppBrandTask.runTaskOnUiThread(new UIJsPlugin.26(this, paramJsRuntime, new JSONObject(paramString2), paramString1, paramInt));
                }
                catch (JSONException localJSONException11)
                {
                  QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException11);
                }
              }
              else if ("updateTextView".equals(paramString1))
              {
                try
                {
                  AppBrandTask.runTaskOnUiThread(new UIJsPlugin.27(this, paramJsRuntime, new JSONObject(paramString2), paramString1, paramInt));
                }
                catch (JSONException localJSONException12)
                {
                  QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException12);
                }
              }
              else if ("removeTextView".equals(paramString1))
              {
                try
                {
                  AppBrandTask.runTaskOnUiThread(new UIJsPlugin.28(this, paramJsRuntime, new JSONObject(paramString2), paramString1, paramInt));
                }
                catch (JSONException localJSONException13)
                {
                  QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException13);
                }
              }
              else
              {
                if (!"removeImageView".equals(paramString1)) {
                  break;
                }
                try
                {
                  AppBrandTask.runTaskOnUiThread(new UIJsPlugin.29(this, paramJsRuntime, new JSONObject(paramString2), paramString1, paramInt));
                }
                catch (JSONException localJSONException14)
                {
                  QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException14);
                }
              }
            }
          }
        }
      }
    }
    if ("getMenuButtonBoundingClientRect".equals(paramString1)) {}
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              try
              {
                if (this.isGameRuntime)
                {
                  localObject3 = getGameBrandRuntime();
                  if ((localObject3 == null) || (!(((GameBrandRuntime)localObject3).activity instanceof GameActivity))) {
                    break label3341;
                  }
                  localObject3 = ((GameActivity)((GameBrandRuntime)localObject3).activity).getNavBar();
                  if (localObject3 == null) {
                    break label3341;
                  }
                  localObject3 = ((NavigatorBarForMiniGame)localObject3).getCapsuleButton();
                  if (localObject3 == null) {
                    break label2977;
                  }
                  i = (int)(((View)localObject3).getWidth() / DisplayUtil.getDensity(this.jsPluginEngine.getActivityContext()));
                  j = (int)(((View)localObject3).getHeight() / DisplayUtil.getDensity(this.jsPluginEngine.getActivityContext()));
                  k = (int)(((View)localObject3).getLeft() / DisplayUtil.getDensity(this.jsPluginEngine.getActivityContext()));
                  int m = (int)(((View)localObject3).getTop() / DisplayUtil.getDensity(this.jsPluginEngine.getActivityContext()));
                  int n = (int)(((View)localObject3).getRight() / DisplayUtil.getDensity(this.jsPluginEngine.getActivityContext()));
                  int i1 = (int)(((View)localObject3).getBottom() / DisplayUtil.getDensity(this.jsPluginEngine.getActivityContext()));
                  if (i != 0)
                  {
                    this.menuButtonWidth = i;
                    this.menuButtonHeight = j;
                    this.menuButtonRect = new Rect(k, m, n, i1);
                  }
                }
                try
                {
                  localObject3 = new JSONObject();
                  ((JSONObject)localObject3).put("width", this.menuButtonWidth);
                  ((JSONObject)localObject3).put("height", this.menuButtonHeight);
                  ((JSONObject)localObject3).put("top", this.menuButtonRect.top);
                  ((JSONObject)localObject3).put("right", this.menuButtonRect.right);
                  ((JSONObject)localObject3).put("bottom", this.menuButtonRect.bottom);
                  ((JSONObject)localObject3).put("left", this.menuButtonRect.left);
                  QLog.d("[mini] UIJsPlugin", 1, "");
                  this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject3, paramInt);
                  QLog.d("[mini] UIJsPlugin", 1, "getMenuButtonBoundingClientRect : " + ((JSONObject)localObject3).toString());
                  localObject3 = ((JSONObject)localObject3).toString();
                  return localObject3;
                }
                catch (JSONException localJSONException15)
                {
                  QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException15);
                }
                Object localObject3 = ((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getCurrentPage();
                if (localObject3 != null)
                {
                  localObject3 = ((AbsAppBrandPage)localObject3).getNavBar();
                  if (localObject3 != null) {
                    localObject3 = ((NavigationBar)localObject3).getCapsuleButton();
                  }
                }
                else
                {
                  QLog.e("[mini] UIJsPlugin", 1, "EVENT_GET_MENU_BUTTON_RECT page is null.");
                  this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, " page is null", paramInt);
                  return getMenuButtonDefaultValue();
                }
                QLog.e("[mini] UIJsPlugin", 1, "EVENT_GET_MENU_BUTTON_RECT navBar is null.");
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "navBar is null", paramInt);
                return getMenuButtonDefaultValue();
              }
              catch (Exception localException3)
              {
                QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localException3);
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "exception", paramInt);
              }
              break;
              break;
              label2977:
              QLog.e("[mini] UIJsPlugin", 1, "EVENT_GET_MENU_BUTTON_RECT menuButtonCantainer is null.");
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "json error", paramInt);
              String str = getMenuButtonDefaultValue();
              return str;
              if ("updateMultiPickerView".equals(paramString1))
              {
                AppBrandTask.runTaskOnUiThread(new UIJsPlugin.30(this, paramString2, paramJsRuntime, paramString1, paramInt));
                break;
              }
              if (!"insertScrollView".equals(paramString1)) {
                break label3106;
              }
              try
              {
                AppBrandTask.runTaskOnUiThread(new UIJsPlugin.31(this, paramJsRuntime, new JSONObject(paramString2), paramString1, paramInt));
              }
              catch (JSONException localJSONException16)
              {
                QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException16);
              }
            }
            break;
            label3106:
            if (!"updateScrollView".equals(paramString1)) {
              break label3174;
            }
            try
            {
              AppBrandTask.runTaskOnUiThread(new UIJsPlugin.32(this, paramJsRuntime, new JSONObject(paramString2), paramString1, paramInt));
            }
            catch (JSONException localJSONException17)
            {
              QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException17);
            }
          }
          break;
          label3174:
          if (!"removeScrollView".equals(paramString1)) {
            break label3242;
          }
          try
          {
            AppBrandTask.runTaskOnUiThread(new UIJsPlugin.33(this, paramJsRuntime, new JSONObject(paramString2), paramString1, paramInt));
          }
          catch (JSONException localJSONException18)
          {
            QLog.e("[mini] UIJsPlugin", 1, paramString1 + " error.", localJSONException18);
          }
        }
        break;
        label3242:
        if ("hideHomeButton".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new UIJsPlugin.34(this, paramJsRuntime, paramString1, paramInt));
          break;
        }
        if (!"showMiniAIOEntrance".equals(paramString1)) {
          break label3314;
        }
        try
        {
          AppBrandTask.runTaskOnUiThread(new UIJsPlugin.35(this, new JSONObject(paramString2), paramJsRuntime, paramString1, paramInt));
        }
        catch (JSONException localJSONException19)
        {
          localJSONException19.printStackTrace();
        }
      }
      break;
      label3314:
      if (!"hideMiniAIOEntrance".equals(paramString1)) {
        break;
      }
      AppBrandTask.runTaskOnUiThread(new UIJsPlugin.36(this, paramJsRuntime, paramString1, paramInt));
      break;
      label3341:
      Object localObject4 = null;
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  protected void updateDataPickerFields(DatePickerView paramDatePickerView, String paramString)
  {
    if (paramDatePickerView == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        paramDatePickerView.setYearVisible(0);
        paramDatePickerView.setMonthOfYearVisible(0);
        paramDatePickerView.setDayOfMonthVisible(0);
        return;
      }
      if (paramString.equals("year"))
      {
        paramDatePickerView.setYearVisible(0);
        paramDatePickerView.setMonthOfYearVisible(8);
        paramDatePickerView.setDayOfMonthVisible(8);
        return;
      }
      if (paramString.equals("month"))
      {
        paramDatePickerView.setYearVisible(0);
        paramDatePickerView.setMonthOfYearVisible(0);
        paramDatePickerView.setDayOfMonthVisible(8);
        return;
      }
    } while (!paramString.equals("day"));
    paramDatePickerView.setYearVisible(0);
    paramDatePickerView.setMonthOfYearVisible(0);
    paramDatePickerView.setDayOfMonthVisible(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin
 * JD-Core Version:    0.7.0.1
 */