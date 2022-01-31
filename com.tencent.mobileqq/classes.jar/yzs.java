import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameView;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import org.json.JSONObject;

public class yzs
  implements ActionSheet.OnButtonClickListener
{
  public yzs(ApolloGameActivity paramApolloGameActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ApolloGameActivity.a(this.a).dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((ApolloGameActivity.a(this.a) != null) && (ApolloGameActivity.a(this.a).a()))
      {
        QLog.d("cmgame_process.ApolloGameActivity", 1, "pack up game");
        this.a.onBackEvent();
        if (ApolloGameActivity.a(this.a) != null) {
          ApolloGameActivity.a(this.a).b();
        }
        if ((ApolloGameActivity.a(this.a) == null) || ((ApolloGameActivity.a(this.a).enter != 0) && (ApolloGameActivity.a(this.a).enter != 1) && (ApolloGameActivity.a(this.a).enter != 7))) {
          break label763;
        }
      }
      break;
    }
    label175:
    label763:
    for (paramInt = 0;; paramInt = 1)
    {
      int i;
      if (ApolloGameActivity.a(this.a) != null)
      {
        i = ApolloGameActivity.a(this.a).enter;
        if ((ApolloGameActivity.a(this.a) == null) || (ApolloGameActivity.a(this.a).game == null)) {
          break label251;
        }
      }
      label251:
      for (paramView = String.valueOf(ApolloGameActivity.a(this.a).game.gameId);; paramView = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "miniature_game", i, paramInt, new String[] { paramView });
        return;
        this.a.finish();
        break;
        i = 0;
        break label175;
      }
      if ((ApolloGameActivity.a(this.a) != null) && (ApolloGameActivity.a(this.a).a()) && (ApolloGameActivity.a(this.a) != null) && (ApolloGameActivity.a(this.a).game != null)) {}
      try
      {
        paramView = new JSONObject();
        paramView.put("gameId", ApolloGameActivity.a(this.a).game.gameId);
        paramView.put("isSelectFriend", 1);
        paramView.put("gameMode", ApolloGameActivity.a(this.a).gameMode);
        paramView.put("roomId", ApolloGameActivity.a(this.a).roomId);
        ApolloGameActivity.a(this.a).a(paramView.toString());
        if (ApolloGameActivity.a(this.a) != null) {
          ApolloGameActivity.a(this.a).c();
        }
        if ((ApolloGameActivity.a(this.a) != null) && (ApolloGameActivity.a(this.a).game != null))
        {
          paramView = String.valueOf(ApolloGameActivity.a(this.a).game.gameId);
          VipUtils.a(null, "cmshow", "Apollo", "clk_share", 0, 0, new String[] { paramView });
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          QLog.e("cmgame_process.ApolloGameActivity", 1, "share game error, e=", paramView);
          continue;
          paramView = "";
        }
      }
      if (ApolloGameActivity.a(this.a) != null)
      {
        paramInt = ApolloGameActivity.a(this.a).enter;
        label508:
        if ((ApolloGameActivity.a(this.a) == null) || (ApolloGameActivity.a(this.a).game == null)) {
          break label652;
        }
      }
      for (paramView = String.valueOf(ApolloGameActivity.a(this.a).game.gameId);; paramView = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "about_game", paramInt, 0, new String[] { paramView });
        paramView = new Intent();
        paramView.putExtra("extra_key_gameData", ApolloGameActivity.a(this.a).game);
        paramView.putExtra("extra_key_game_enter", ApolloGameActivity.a(this.a).enter);
        PublicFragmentActivity.a(this.a.getActivity(), paramView, ApolloGameInfoFragment.class, 10000);
        if (ApolloGameActivity.a(this.a) == null) {
          break;
        }
        ApolloGameActivity.a(this.a).e();
        return;
        paramInt = 0;
        break label508;
      }
      if ((ApolloGameActivity.a(this.a) == null) || (ApolloGameActivity.a(this.a).game == null)) {
        break;
      }
      ApolloGameUtil.a(this.a, ApolloGameActivity.a(this.a).game.gameId, ApolloGameActivity.a(this.a).game.name, ApolloGameActivity.a(this.a).game.logoUrl);
      VipUtils.a(null, "cmshow", "Apollo", "clk_create_shortcut", 0, 0, new String[] { String.valueOf(ApolloGameActivity.a(this.a).game.gameId) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzs
 * JD-Core Version:    0.7.0.1
 */