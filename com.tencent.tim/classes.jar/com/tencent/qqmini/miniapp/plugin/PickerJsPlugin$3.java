package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.util.DateUtils;
import com.tencent.qqmini.miniapp.widget.DatePickerView;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$3
  implements Runnable
{
  PickerJsPlugin$3(PickerJsPlugin paramPickerJsPlugin, Date paramDate, String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject) {}
  
  public void run()
  {
    DatePickerView localDatePickerView = new DatePickerView(PickerJsPlugin.access$400(this.this$0).getAttachedActivity());
    int i = DateUtils.getYearByDateStr(this.val$date);
    int j = DateUtils.getMonthByDateStr(this.val$date);
    int k = DateUtils.getDayByDateStr(this.val$date);
    localDatePickerView.init(i, j, k, new PickerJsPlugin.3.1(this));
    String str = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty(str)) {
      localDatePickerView.setMinDate(DateUtils.dateToLong(str));
    }
    str = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty(str)) {
      localDatePickerView.setMaxDate(DateUtils.dateToLong(str));
    }
    localDatePickerView.updateDate(i, j, k);
    this.this$0.updateDataPickerFields(localDatePickerView, this.val$fields);
    localDatePickerView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */