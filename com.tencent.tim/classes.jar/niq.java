import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class niq
  implements View.OnClickListener
{
  public niq(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("selectedGrade", kxm.i());
      localBundle.putString("param", localJSONObject.toString());
      kxm.a(this.this$0.a(), "https://viola.qq.com/js/grade.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bid=3740&v_bundleName=grade", localBundle);
      kxm.mF("0X800AF06");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyTabFrame", 1, "clickGradeListener error! e= " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     niq
 * JD-Core Version:    0.7.0.1
 */