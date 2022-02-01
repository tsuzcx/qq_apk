import android.os.Bundle;
import android.util.SparseArray;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.data.TroopBarPostEntity;
import com.tencent.mobileqq.troop.activity.TroopBarPageActivity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.TroopBarPostAdapter;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gsf
  implements HttpWebCgiAsyncTask.Callback
{
  public gsf(TroopBarPageActivity paramTroopBarPageActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      if (paramBundle == null) {}
      for (bool1 = false; TroopBarUtils.a(paramJSONObject, "retcode") == 100000; bool1 = paramBundle.getBoolean("requestPageOnly"))
      {
        this.a.b(false);
        if (!this.a.jdField_b_of_type_Boolean)
        {
          this.a.jdField_b_of_type_Boolean = true;
          this.a.a(this.a.r, bool1, true);
        }
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, "requestTroopbarPage---RESULT_CODE_SIGN_ERROR");
        }
        return;
      }
      this.a.jdField_b_of_type_Boolean = false;
      paramInt = TroopBarUtils.a(paramJSONObject, "errno");
      if (paramInt == 0)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null) {}
        for (paramBundle = TroopBarUtils.a;; paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity = new TroopBarPageEntity();
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.id = this.a.r;
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType = paramBundle;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.refreshData(paramJSONObject);
          TroopBarPageActivity.a(this.a).setVisibility(0);
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.notifyDataSetChanged();
          TroopBarUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
          if ((bool1) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType == null)) {
            break;
          }
          this.a.b(false);
          this.a.a(this.a.r, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType.type, 0L, true, false);
          return;
        }
      }
      i = TroopBarUtils.a(paramJSONObject, "retcode");
      if (i != 0) {
        QQToast.a(this.a, 1, this.a.getString(2131560704, new Object[] { Integer.valueOf(i) }), 0).b(this.a.d());
      }
      for (;;)
      {
        this.a.b(false);
        return;
        QQToast.a(this.a, 1, this.a.getString(2131560704, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.d());
      }
    }
    int i = 0;
    if ((paramInt == -1001) || (paramInt == -1002)) {
      i = 1;
    }
    int j = i;
    Object localObject1;
    if (i == 0)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null) {}
      for (localObject1 = null;; localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.getTypeList())
      {
        j = i;
        if (localObject1 == null) {
          break label531;
        }
        j = 0;
        while (j < ((ArrayList)localObject1).size())
        {
          if (paramInt == ((TroopBarPageEntity.TypeListEntity)((ArrayList)localObject1).get(j)).type) {
            i = 1;
          }
          j += 1;
        }
      }
      j = i;
    }
    label531:
    if (j == 0)
    {
      this.a.b(false);
      return;
    }
    long l;
    if (paramBundle == null)
    {
      l = 0L;
      label552:
      if (paramBundle != null) {
        break label642;
      }
    }
    label642:
    for (boolean bool1 = false;; bool1 = paramBundle.getBoolean("clear_data"))
    {
      if (TroopBarUtils.a(paramJSONObject, "retcode") != 100000) {
        break label653;
      }
      this.a.b(false);
      if (!this.a.c)
      {
        this.a.c = true;
        this.a.a(this.a.r, paramInt, l, bool1, true);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("IphoneTitleBarActivity", 2, "requestPost---RESULT_CODE_SIGN_ERROR");
      return;
      l = paramBundle.getLong("start_post_index");
      break label552;
    }
    label653:
    this.a.c = false;
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramBundle = this.a;
        if (TroopBarUtils.a(paramJSONObject, "isend") != 1) {
          break label1072;
        }
        bool2 = true;
        paramBundle.c(bool2);
        localObject1 = paramJSONObject.getJSONArray("posts");
        paramBundle = new ArrayList();
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label1078;
        }
        localObject2 = new TroopBarPostEntity(((JSONArray)localObject1).getJSONObject(i));
        ((TroopBarPostEntity)localObject2).type = String.valueOf(paramInt);
        paramBundle.add(localObject2);
        i += 1;
        continue;
        this.a.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Long.valueOf(20L + l));
        if (!bool1) {
          continue;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(paramBundle);
      }
      catch (JSONException paramBundle)
      {
        Object localObject2;
        if (TroopBarUtils.a(paramJSONObject, "isend") == 1) {
          continue;
        }
        paramInt = TroopBarUtils.a(paramJSONObject, "retcode");
        if (paramInt == 0) {
          continue;
        }
        QQToast.a(this.a, 1, this.a.getString(2131560704, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.d());
        continue;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(paramBundle);
        continue;
        paramInt = TroopBarUtils.a(paramJSONObject, "errno");
        QQToast.a(this.a, 1, this.a.getString(2131560704, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.d());
        continue;
      }
      if (l == 0L)
      {
        localObject1 = SecurityUtile.b(this.a.r);
        localObject2 = SecurityUtile.b(String.valueOf(paramInt));
        TroopBarUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
        TroopBarUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, TroopBarPostEntity.class, "bid=? and type = ?", new String[] { localObject1, localObject2 });
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.notifyDataSetChanged();
      this.a.b(false);
      return;
      localObject1 = this.a.jdField_a_of_type_AndroidUtilSparseArray;
      l += 1L;
      ((SparseArray)localObject1).put(paramInt, Long.valueOf(l));
      continue;
      QQToast.a(this.a, 1, this.a.getString(2131560703), 0).b(this.a.d());
      continue;
      label1072:
      boolean bool2 = false;
      continue;
      label1078:
      if (paramInt != -1001) {
        if (paramInt != -1002) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gsf
 * JD-Core Version:    0.7.0.1
 */