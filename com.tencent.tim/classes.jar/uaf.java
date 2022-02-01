import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class uaf
  implements AdapterView.OnItemClickListener
{
  uaf(uae paramuae, int paramInt, tzd paramtzd) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    long l;
    if (localObject1 == null)
    {
      l = paramLong;
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, l);
      return;
    }
    this.a.mShareActionSheet.dismiss();
    label104:
    int j;
    int i;
    switch (((ShareActionSheetBuilder.b)localObject1).b.action)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      j = (int)paramLong;
      if ((paramLong == 2L) || (paramLong == 3L)) {
        if (!WXShareHelper.a().isWXinstalled()) {
          i = 2131721935;
        }
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        if (i != -1)
        {
          localObject1 = BaseApplicationImpl.getContext();
          QQToast.a((Context)localObject1, ((Context)localObject1).getString(i), 0).show(this.zK);
          l = paramLong;
          break;
          paramLong = 0L;
          break label104;
          paramLong = 1L;
          break label104;
          paramLong = 3L;
          break label104;
          paramLong = 2L;
          break label104;
          paramLong = 4L;
          break label104;
          if (WXShareHelper.a().isWXsupportApi()) {
            break label358;
          }
          i = 2131721936;
          continue;
        }
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("selectChanel", j);
          ubu.a(this.b, (JSONObject)localObject1);
          l = paramLong;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("DoraemonApi.ShareModule", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
          l = paramLong;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str = localException.getMessage();
            QLog.e("DoraemonApi.ShareModule", 1, "put channel failed!");
            tzd localtzd = this.b;
            Object localObject2 = str;
            if (str == null) {
              localObject2 = "";
            }
            ubu.a(localtzd, -1, (String)localObject2);
          }
        }
      }
      label358:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uaf
 * JD-Core Version:    0.7.0.1
 */