import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.2.1;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.ViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.d;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class noa
  extends lce
{
  public noa(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void as(int paramInt, String paramString)
  {
    this.a.aZG();
    if (paramInt != 0) {
      return;
    }
    awit.H("readinjoy_follow_subscribed_list_data_key", paramString);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyDiandianHeaderController", 1, "from server data is empty !");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      ThreadManager.getUIHandler().post(new ReadInJoyDiandianHeaderController.2.1(this, paramString));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void i(boolean paramBoolean, List<DiandianTopConfig> paramList)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (ReadInJoyDiandianHeaderController.a(this.a).isVisible())) {
      ReadInJoyDiandianHeaderController.a(this.a).setVisibility(8);
    }
    int i;
    label227:
    do
    {
      return;
      ReadInJoyDiandianHeaderController.a(this.a).setVisibility(0);
      ReadInJoyDiandianHeaderController.a(this.a, false);
      ReadInJoyDiandianHeaderController.a(this.a).clear();
      ReadInJoyDiandianHeaderController.b(this.a).clear();
      ReadInJoyDiandianHeaderController.b(this.a).addAll(paramList);
      int j;
      if (ReadInJoyDiandianHeaderController.b(this.a).size() % 2 == 0)
      {
        i = ReadInJoyDiandianHeaderController.b(this.a).size() / 2;
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label476;
        }
        Object localObject = new MeasureGridView(this.a.mContext);
        paramList = new ReadInJoyDiandianHeaderController.d(this.a, ReadInJoyDiandianHeaderController.b(this.a), j);
        ((MeasureGridView)localObject).setNumColumns(2);
        ((MeasureGridView)localObject).setAdapter(paramList);
        ((MeasureGridView)localObject).setSelector(new ColorDrawable(0));
        ReadInJoyDiandianHeaderController.a(this.a).add(localObject);
        if (j == 0)
        {
          int k = 0;
          if (k < paramList.getCount())
          {
            localObject = (DiandianTopConfig)paramList.getItem(k);
            if ((localObject != null) && (!((DiandianTopConfig)localObject).hasExposeReported)) {}
            for (;;)
            {
              try
              {
                localJSONObject = new JSONObject();
                localJSONObject.put("folder_status", kxm.aMw);
                if (((DiandianTopConfig)localObject).type != 5) {
                  continue;
                }
                localJSONObject.put("list_URL", ((DiandianTopConfig)localObject).jumpUrl);
                localJSONObject.put("type", ((DiandianTopConfig)localObject).type);
                kbp.a(null, "", "0X80092FC", "0X80092FC", 0, 0, ReadInJoyDiandianHeaderController.b(this.a).size() + "", "1", ((DiandianTopConfig)localObject).topicId + "", localJSONObject.toString(), false);
                ((DiandianTopConfig)localObject).hasExposeReported = true;
                paramList.a(k, (DiandianTopConfig)localObject);
              }
              catch (JSONException localJSONException)
              {
                JSONObject localJSONObject;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("ReadInJoyDiandianHeaderController", 2, localJSONException.toString());
                continue;
              }
              k += 1;
              break label227;
              i = ReadInJoyDiandianHeaderController.b(this.a).size() / 2 + 1;
              break;
              localJSONObject.put("list_URL", "0");
            }
          }
        }
        j += 1;
      }
      ReadInJoyDiandianHeaderController.a(this.a).add(ReadInJoyDiandianHeaderController.a(this.a));
    } while (i <= 1);
    label476:
    this.a.baC = 1;
    ReadInJoyDiandianHeaderController.a(this.a).setCurrentItem(this.a.baC, false);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     noa
 * JD-Core Version:    0.7.0.1
 */