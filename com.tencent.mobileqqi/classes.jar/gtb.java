import android.os.Bundle;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.LocationAdapter;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyLBSApiPOI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gtb
  implements HttpWebCgiAsyncTask.Callback
{
  public gtb(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.a.b(false);
    if (paramJSONObject != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = this.a;
        if (TroopBarUtils.a(paramJSONObject, "isend") != 1) {
          break label400;
        }
        bool = true;
        ((TroopBarPublishLocationSelectActivity)localObject).a(bool);
        localObject = paramJSONObject.getJSONArray("poilist");
        if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
          this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if ((paramBundle != null) && (paramBundle.getBoolean("refresh_all_poi"))) {
          this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label395;
        }
        this.a.jdField_a_of_type_JavaUtilArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyLBSApiPOI);
      }
      catch (JSONException paramBundle)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          break label257;
        }
        QLog.d("TroopBar", 2, paramBundle.toString());
      }
      if (paramInt < ((JSONArray)localObject).length())
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarUtils.MyLBSApiPOI(((JSONArray)localObject).getJSONObject(paramInt)));
        paramInt += 1;
      }
      else
      {
        localObject = this.a;
        if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 1)
        {
          paramBundle = (TroopBarUtils.MyLBSApiPOI)this.a.jdField_a_of_type_JavaUtilArrayList.get(1);
          ((TroopBarPublishLocationSelectActivity)localObject).b = paramBundle;
          this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter.notifyDataSetChanged();
          return;
          label257:
          if (TroopBarUtils.a(paramJSONObject, "isend") == 1) {
            break;
          }
          paramInt = TroopBarUtils.a(paramJSONObject, "retcode");
          if (paramInt == 0) {
            break label324;
          }
          QQToast.a(this.a, 1, this.a.getString(2131560704, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.d());
          return;
        }
        paramBundle = null;
        continue;
        label324:
        paramInt = TroopBarUtils.a(paramJSONObject, "errno");
        QQToast.a(this.a, 1, this.a.getString(2131560704, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.d());
        return;
        QQToast.a(this.a, 1, 2131560703, 0).b(this.a.d());
        return;
        label395:
        paramInt = 0;
        continue;
        label400:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gtb
 * JD-Core Version:    0.7.0.1
 */