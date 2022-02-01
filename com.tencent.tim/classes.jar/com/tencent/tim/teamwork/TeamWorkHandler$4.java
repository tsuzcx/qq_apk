package com.tencent.tim.teamwork;

import android.text.TextUtils;
import aulh;
import aulh.a;
import aulk;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class TeamWorkHandler$4
  implements Runnable
{
  public TeamWorkHandler$4(AppInterface paramAppInterface, String paramString, aulh.a parama) {}
  
  public void run()
  {
    if (this.b == null) {
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkHandler", 2, "getStorageSize: teamId " + this.cIA);
      }
      if (!TextUtils.isEmpty(this.cIA)) {
        ((JSONObject)localObject).put("team_id", this.cIA);
      }
      localObject = UUID.randomUUID().toString().replace("-", "");
      aulh.b(aulk.a("xsrf=" + (String)localObject, this.b.getCurrentAccountUin(), "https://docs.qq.com/cgi-bin/online_docs/storage", "docs.qq.com", "TOK=" + (String)localObject, false), this.a);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkHandler.4
 * JD-Core Version:    0.7.0.1
 */