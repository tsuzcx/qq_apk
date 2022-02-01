import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.PromptDialogActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_StartGameMessage;

class ahvq
  implements ahvn.a
{
  ahvq(ahvn paramahvn, long paramLong1, SubMsgType0xaa.GameTeam_StartGameMessage paramGameTeam_StartGameMessage, long paramLong2, boolean paramBoolean) {}
  
  public void Gk(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ahvn.a(this.this$0).get();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getJSONObject("result").getJSONArray("team_list");
        if (paramString.length() <= 0) {
          continue;
        }
        paramString = paramString.getJSONObject(0);
        int i;
        int j;
        boolean bool;
        label426:
        return;
      }
      catch (JSONException paramString)
      {
        try
        {
          i = paramString.getInt("expire");
          j = i;
          if (i <= 0) {
            j = ahvn.dbv;
          }
          i = paramString.getInt("status");
          if (QLog.isColorLevel()) {
            QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, getTeamContext finished, deltaTime = " + this.aba + ", expire = " + j + ", status = " + i);
          }
          if (this.aba < j)
          {
            paramString = paramString.getJSONObject("leader");
            bool = localQQAppInterface.getCurrentAccountUin().equals(paramString.getString("uin"));
            if ((i > 0) && (i < 5))
            {
              paramString = new Intent(localQQAppInterface.getApp().getApplicationContext(), PromptDialogActivity.class);
              paramString.addFlags(268435456);
              paramString.putExtra("title", this.a.str_title.get());
              paramString.putExtra("summary", this.a.str_summary.get());
              paramString.putExtra("picUrl", this.a.str_picUrl.get());
              paramString.putExtra("appid", this.a.str_appid.get());
              paramString.putExtra("packageName", this.a.str_packageName.get());
              paramString.putExtra("gamedata", this.a.str_gamedata.get());
              paramString.putExtra("leader", bool);
              paramString.putExtra("createMsgTime", this.xN);
              localQQAppInterface.getApp().startActivity(paramString);
              if (!this.civ) {
                break label426;
              }
              arts.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2044", "0", false);
              return;
              paramString = paramString;
              if (QLog.isColorLevel()) {
                QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, getTeamContext finished, parse json error e = " + paramString);
              }
            }
          }
          if (this.civ)
          {
            arts.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2044", "1", false);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            i = 0;
          }
          arts.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2043", "0", false);
          return;
        }
        arts.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2043", "1", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvq
 * JD-Core Version:    0.7.0.1
 */