import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.troop.activity.TroopBarPageActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.TroopBarPostAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class gsg
  extends BroadcastReceiver
{
  public gsg(TroopBarPageActivity paramTroopBarPageActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("change_post_type".equals(str))
    {
      paramContext = (TroopBarPageEntity.TypeListEntity)paramIntent.getSerializableExtra("post_type");
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType = paramContext;
      this.a.a(paramContext);
      this.a.b(false);
      this.a.a(this.a.r, paramContext.type, 0L, true, false);
    }
    label72:
    do
    {
      do
      {
        do
        {
          break label72;
          do
          {
            return;
          } while (!"refresh_page".equals(str));
          str = paramIntent.getStringExtra("sub_action");
          if ("show_loading".equals(str))
          {
            this.a.b(true);
            return;
          }
          if ("hide_loading".equals(str))
          {
            this.a.b(false);
            return;
          }
          if (!"sign_in".equals(str)) {
            break;
          }
          try
          {
            paramIntent = new JSONObject(paramIntent.getStringExtra("broadcast_data"));
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.updateBannerDataAfterAction("sign_in", paramIntent);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.notifyDataSetChanged();
            TroopBarUtils.a(this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
            QQToast.a(paramContext, 2, this.a.getString(2131560700), 0).b(paramContext.getResources().getDimensionPixelSize(2131427376));
            this.a.b(false);
            return;
          }
          catch (JSONException paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("IphoneTitleBarActivity", 2, "BROADCAST_NAME_SIGN_IN-->JSONException");
        return;
      } while (!"follow".equals(str));
      try
      {
        paramIntent = new JSONObject(paramIntent.getStringExtra("broadcast_data"));
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.updateBannerDataAfterAction("follow", paramIntent);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.notifyDataSetChanged();
        TroopBarUtils.a(this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
        QQToast.a(paramContext, 2, this.a.getString(2131560701), 0).b(paramContext.getResources().getDimensionPixelSize(2131427376));
        this.a.b(false);
        return;
      }
      catch (JSONException paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.e("IphoneTitleBarActivity", 2, "BROADCAST_NAME_FOLLOW-->JSONException");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gsg
 * JD-Core Version:    0.7.0.1
 */