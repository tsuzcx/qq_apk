import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class aovh
  implements BusinessObserver
{
  public aovh(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.this$0.xa(false);
    this.this$0.rightViewText.setEnabled(true);
    TroopBarPublishActivity localTroopBarPublishActivity = this.this$0;
    this.this$0.getString(2131698503);
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label748;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          break label209;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.this$0.getString(2131698504, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Object localObject;
          label167:
          label209:
          StringBuffer localStringBuffer;
          paramBundle = this.this$0.getString(2131698504, new Object[] { Integer.valueOf(9992) });
          continue;
          localStringBuffer.append("7");
          continue;
          localStringBuffer.append("8");
          continue;
          paramBundle = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid;
          continue;
          paramBundle = this.this$0.cnd;
        }
      }
      QQToast.a(localTroopBarPublishActivity, 1, paramBundle, 0).show(this.this$0.getTitleBarHeight());
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label800;
      }
      paramBundle = "0";
      aprv.report("pub_page", "fail", paramBundle, "4", TroopBarPublishActivity.b(this.this$0), "");
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
      return;
      localObject = paramBundle.getJSONObject("result");
      localStringBuffer = new StringBuffer();
      if ((this.this$0.cu != null) && (this.this$0.cu.size() > 0)) {
        localStringBuffer.append("0");
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        localStringBuffer.append("1");
      }
      if (!TextUtils.isEmpty(aprv.f(this.this$0.b))) {
        localStringBuffer.append("2");
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        localStringBuffer.append("5");
      }
      if (this.this$0.cOq) {
        if (!TextUtils.isEmpty(aprv.f(this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText)))
        {
          localStringBuffer.append("6");
          if (!TextUtils.isEmpty(this.this$0.cnd)) {
            break label713;
          }
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
            break label699;
          }
          paramBundle = "0";
          if ((this.this$0.ZZ == null) || (this.this$0.ZZ.getVisibility() != 0)) {
            break label820;
          }
        }
      }
    }
    label800:
    label820:
    for (paramInt = 2;; paramInt = 1)
    {
      anot.a(null, "P_CliOper", "Grp_tribe", "", "pub_page", "suc", paramInt, 0, paramBundle, this.this$0.cmL, localStringBuffer.toString(), "");
      this.this$0.cOn = true;
      ((JSONObject)localObject).optString("pid");
      paramBundle = ((JSONObject)localObject).optString("bid");
      if ((this.this$0.cOm) && (this.this$0.bN != null))
      {
        this.this$0.getIntent().getStringExtra("pkg_name");
        this.this$0.bN.optString("share_app_name");
        this.this$0.bN.optLong("share_app_id");
        if (TextUtils.isEmpty(paramBundle)) {
          break label724;
        }
      }
      for (;;)
      {
        aqmz.j(this.this$0.app, "share_suc", paramBundle);
        if (this.this$0.jdField_a_of_type_Aora != null) {
          this.this$0.dXk();
        }
        if ((this.this$0.jdField_a_of_type_Aorm$d != null) && (!TroopBarPublishActivity.a(this.this$0).equals("###...^_^###"))) {
          anot.a(null, "dc00899", "Grp_tribe", "", "pub_page", "sus_prefixpub", 0, 0, this.this$0.mBid, "", "", "");
        }
        paramBundle = new Intent();
        paramBundle.putExtra("result", ((JSONObject)localObject).toString());
        this.this$0.setResult(-1, paramBundle);
        this.this$0.finish();
        return;
        label699:
        label713:
        label724:
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
        {
          paramBundle = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid;
          continue;
          label748:
          paramBundle = this.this$0.getString(2131698504, new Object[] { Integer.valueOf(9991) });
          break;
          paramBundle = this.this$0.getString(2131698504, new Object[] { Integer.valueOf(9992) });
          break;
          paramBundle = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid;
          break label167;
        }
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovh
 * JD-Core Version:    0.7.0.1
 */