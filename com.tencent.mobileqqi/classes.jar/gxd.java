import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity.MyBarListAdapter;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gxd
  implements HttpWebCgiAsyncTask.Callback
{
  public gxd(TroopBarPublishBarSelectActivity paramTroopBarPublishBarSelectActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {
      try
      {
        this.a.a(true);
        paramBundle = paramJSONObject.getJSONArray("mybars");
        if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
          this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        for (;;)
        {
          this.a.b = paramBundle.length();
          paramInt = 0;
          while (paramInt < this.a.b)
          {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarUtils.MyBar(paramBundle.getJSONObject(paramInt)));
            paramInt += 1;
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        this.a.b(false);
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramBundle.toString());
        }
        if (TroopBarUtils.a(paramJSONObject, "isend") != 1)
        {
          paramInt = TroopBarUtils.a(paramJSONObject, "retcode");
          if (paramInt == 0) {
            break label267;
          }
          QQToast.a(this.a, 1, this.a.getString(2131560704, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.d());
        }
      }
    }
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131560721, new Object[] { Integer.valueOf(this.a.b) }));
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter.notifyDataSetChanged();
      continue;
      label267:
      paramInt = TroopBarUtils.a(paramJSONObject, "errno");
      QQToast.a(this.a, 1, this.a.getString(2131560704, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.d());
      continue;
      QQToast.a(this.a, 1, 2131560703, 0).b(this.a.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxd
 * JD-Core Version:    0.7.0.1
 */