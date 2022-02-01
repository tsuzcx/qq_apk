import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.screendetect.ScreenShotFragment.b;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import org.json.JSONException;
import org.json.JSONObject;

public class ltm
  implements AdapterView.c
{
  public ltm(NativeShareView paramNativeShareView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeShareView", 2, "OnItemClickListener : position = " + paramInt + ", view = " + paramView + ", id = " + paramLong);
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (NativeShareView.a(this.b) != null) {
      NativeShareView.a(this.b).run();
    }
    int i = ((ScreenShotFragment.b)paramAdapterView).b.action;
    paramInt = 0;
    switch (i)
    {
    }
    for (;;)
    {
      paramAdapterView = new JSONObject();
      try
      {
        paramAdapterView.put("channel_type", paramInt);
        kbp.a(null, "", "0X800A3BE", "0X800A3BE", 0, 0, "", "", "", paramAdapterView.toString(), false);
        return;
        paramInt = 6;
        oeg.co(NativeShareView.a(this.b));
        continue;
        oeg.aU((Activity)NativeShareView.a(this.b));
        paramInt = 1;
        continue;
        oeg.b((BaseActivity)NativeShareView.a(this.b));
        paramInt = 2;
        continue;
        oeg.aV((Activity)NativeShareView.a(this.b));
        paramInt = 3;
        continue;
        oeg.aW((Activity)NativeShareView.a(this.b));
        paramInt = 4;
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          QLog.e("NativeShareView", 1, paramView, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltm
 * JD-Core Version:    0.7.0.1
 */