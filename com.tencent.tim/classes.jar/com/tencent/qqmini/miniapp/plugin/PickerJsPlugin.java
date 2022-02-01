package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.util.DateUtils;
import com.tencent.qqmini.miniapp.widget.DatePickerView;
import com.tencent.qqmini.miniapp.widget.MutiPickerView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class PickerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PickerJsPlugin";
  private MutiPickerView mutiPickerView;
  
  @JsEvent({"showDatePickerView"})
  public void handleShowDatePickerView(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject;
    String str;
    try
    {
      Object localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      localJSONObject = ((JSONObject)localObject2).optJSONObject("range");
      str = ((JSONObject)localObject2).optString("current");
      Object localObject1 = str;
      if (TextUtils.isEmpty(str))
      {
        localObject1 = Calendar.getInstance();
        int i = ((Calendar)localObject1).get(1);
        int j = ((Calendar)localObject1).get(2);
        int k = ((Calendar)localObject1).get(5);
        localObject1 = i + "-" + (j + 1) + "" + k;
      }
      str = ((JSONObject)localObject2).optString("mode");
      localObject2 = ((JSONObject)localObject2).optString("fields");
      if ("date".equals(str))
      {
        localObject1 = DateUtils.getSmartDateByTime((String)localObject1);
        if (localObject1 == null)
        {
          paramRequestEvent.fail();
          return;
        }
        AppBrandTask.runTaskOnUiThread(new PickerJsPlugin.3(this, (Date)localObject1, (String)localObject2, paramRequestEvent, localJSONObject));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showDatePickerView error.", localJSONException);
      paramRequestEvent.fail();
      return;
    }
    if ("time".equals(str)) {
      AppBrandTask.runTaskOnUiThread(new PickerJsPlugin.4(this, DateUtils.getTimeByStrTime(localJSONException), paramRequestEvent, localJSONObject));
    }
  }
  
  @JsEvent({"showMultiPickerView"})
  public void handleShowMultiPickerView(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      int[] arrayOfInt = JSONUtil.jsonArrayToIntArray(localJSONObject.optJSONArray("current"));
      AppBrandTask.runTaskOnUiThread(new PickerJsPlugin.2(this, JSONUtil.jsonArrayToMutiStringArray(localJSONObject, "array"), arrayOfInt, paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showMultiPickerView error.", localJSONException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"showPickerView"})
  public void handleShowPickerView(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      AppBrandTask.runTaskOnUiThread(new PickerJsPlugin.1(this, localJSONObject.optJSONArray("array"), localJSONObject.optInt("current", 0), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showPickerView error.", localJSONException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"updateMultiPickerView"})
  public void handleUpdateMultiPickerView(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      AppBrandTask.runTaskOnUiThread(new PickerJsPlugin.5(this, localJSONObject.optInt("column"), localJSONObject.optInt("current"), localJSONObject.optJSONArray("array"), paramRequestEvent));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PickerJsPlugin", "updateMultiPickerView error.", localException);
      paramRequestEvent.fail();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin
 * JD-Core Version:    0.7.0.1
 */