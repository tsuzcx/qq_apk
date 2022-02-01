import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class abqf
  implements ausj.a
{
  public abqf(CmGameFloatView paramCmGameFloatView) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    CmGameFloatView.a(this.this$0).dismiss();
    switch (CmGameFloatView.a(this.this$0).get(paramInt))
    {
    case 4: 
    case 7: 
    case 8: 
    default: 
      return;
    case 0: 
      if ((this.this$0.jdField_a_of_type_Abos != null) && (this.this$0.jdField_a_of_type_Abos.YM()))
      {
        QLog.d("cmframe_CmGameFloatView", 1, "pack up game");
        this.this$0.caS();
        if (this.this$0.jdField_a_of_type_Ablw != null) {
          this.this$0.jdField_a_of_type_Ablw.cCV();
        }
        if ((this.this$0.b == null) || ((this.this$0.b.enter != 0) && (this.this$0.b.enter != 1) && (this.this$0.b.enter != 7))) {
          break label1089;
        }
      }
      break;
    }
    label291:
    label1083:
    label1089:
    for (paramInt = 0;; paramInt = 1)
    {
      int i;
      if (this.this$0.b != null)
      {
        i = this.this$0.b.enter;
        label212:
        if (this.this$0.b == null) {
          break label291;
        }
      }
      for (paramView = String.valueOf(this.this$0.b.gameId);; paramView = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "miniature_game", i, paramInt, new String[] { paramView });
        return;
        paramView = this.this$0.jdField_a_of_type_Abos.q();
        if ((paramView == null) || (paramView.isFinishing())) {
          break;
        }
        paramView.finish();
        break;
        i = 0;
        break label212;
      }
      if ((this.this$0.jdField_a_of_type_Abos != null) && (this.this$0.jdField_a_of_type_Abos.YM()) && (this.this$0.b != null)) {}
      try
      {
        paramView = new JSONObject();
        paramView.put("gameId", this.this$0.b.gameId);
        paramView.put("isSelectFriend", 1);
        paramView.put("gameMode", this.this$0.b.gameMode);
        paramView.put("roomId", this.this$0.b.roomId);
        this.this$0.jdField_a_of_type_Abos.Cz(paramView.toString());
        if (this.this$0.jdField_a_of_type_Ablw != null) {
          this.this$0.jdField_a_of_type_Ablw.cCU();
        }
        if (this.this$0.b != null)
        {
          paramView = String.valueOf(this.this$0.b.gameId);
          VipUtils.a(null, "cmshow", "Apollo", "clk_share", 0, 0, new String[] { paramView });
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          QLog.e("cmframe_CmGameFloatView", 1, "share game error, e=", paramView);
          continue;
          paramView = "";
        }
      }
      if (this.this$0.b != null)
      {
        paramInt = this.this$0.b.enter;
        if (this.this$0.b == null) {
          break label631;
        }
      }
      label631:
      for (paramView = String.valueOf(this.this$0.b.gameId);; paramView = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "about_game", paramInt, 0, new String[] { paramView });
        paramView = new Intent();
        paramView.putExtra("extra_startcheckparam", this.this$0.b);
        PublicFragmentActivity.startForResult(this.this$0.jdField_a_of_type_Abos.q(), paramView, ApolloGameInfoFragment.class, 10000);
        if (this.this$0.jdField_a_of_type_Ablw == null) {
          break;
        }
        this.this$0.jdField_a_of_type_Ablw.cCW();
        return;
        paramInt = 0;
        break label518;
      }
      if (this.this$0.b == null) {
        break;
      }
      ApolloGameUtil.bW(this.this$0.b.gameId, null);
      VipUtils.a(null, "cmshow", "Apollo", "clk_create_shortcut", 0, 0, new String[] { String.valueOf(this.this$0.b.gameId) });
      return;
      this.this$0.cEi();
      return;
      if ((this.this$0.b == null) || (this.this$0.b.pushItem == null)) {
        break;
      }
      if (this.this$0.b.pushItem.is_show_red == 1)
      {
        this.this$0.b.pushItem.is_show_red = 0;
        CmGameFloatView.a(this.this$0).setVisibility(8);
        if (CmGameFloatView.a(this.this$0) != null) {
          CmGameFloatView.a(this.this$0).updateButton(CmGameFloatView.a(this.this$0), this.this$0.b.pushItem.content, 0);
        }
        paramView = new Bundle();
        paramView.putSerializable("CmGamePushItem", this.this$0.b.pushItem);
        QIPCClientHelper.getInstance().callServer("cm_game_module", "action_update_game_push", paramView, null);
      }
      paramView = this.this$0.b.pushItem.url;
      Activity localActivity = (Activity)this.this$0.mActivityRef.get();
      if ((!TextUtils.isEmpty(paramView)) && (localActivity != null)) {
        abmt.bp(localActivity, paramView);
      }
      for (paramInt = 0;; paramInt = 1)
      {
        VipUtils.a(null, "cmshow", "Apollo", "clk_promote", this.this$0.b.src, paramInt, new String[] { String.valueOf(this.this$0.b.gameId), this.this$0.b.pushItem.msg_id });
        return;
      }
      paramView = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
      boolean bool2 = paramView.getBoolean("game_debug_tool_switch", true);
      paramView = paramView.edit();
      if (!bool2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        paramView.putBoolean("game_debug_tool_switch", bool1).commit();
        if (this.this$0.mActivityRef == null) {
          break;
        }
        paramView = (Activity)this.this$0.mActivityRef.get();
        if ((paramView == null) || (!(paramView instanceof ApolloGameActivity))) {
          break;
        }
        paramView = (ApolloGameActivity)paramView;
        if ((bool2) || (!abkj.a(this.this$0.b))) {
          break label1083;
        }
        paramView.Ef(true);
        return;
      }
      paramView.Ef(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqf
 * JD-Core Version:    0.7.0.1
 */