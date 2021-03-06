import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.4.1;
import com.tencent.mobileqq.activity.ChatSettingForTroop.4.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class uqj
  extends BroadcastReceiver
{
  public uqj(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    paramContext = paramIntent.getAction();
    int i = j;
    if (this.this$0.a != null)
    {
      i = j;
      if (this.this$0.a.isHomeworkTroop()) {
        i = 1;
      }
    }
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ("onHomeworkTroopIdentityChanged".equals(paramIntent)) {
        if (i != 0) {}
      }
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        try
        {
          Object localObject4 = new JSONObject(paramContext);
          paramContext = ((JSONObject)localObject4).optString("groupCode");
          if (TextUtils.equals(this.this$0.a.troopUin, paramContext))
          {
            paramIntent = ((JSONObject)localObject4).optString("content");
            Object localObject1 = ((JSONObject)localObject4).optString("source");
            i = ((JSONObject)localObject4).optInt("rankId", 333);
            String str = ((JSONObject)localObject4).optString("nickName");
            Object localObject2 = ((JSONObject)localObject4).optString("uin");
            Object localObject3 = ((JSONObject)localObject4).optString("course");
            localObject4 = ((JSONObject)localObject4).optString("name");
            if ("troopProfile".equals(localObject1)) {
              ThreadManager.post(new ChatSettingForTroop.4.1(this, (String)localObject2, str, i, (String)localObject3, (String)localObject4), 8, null, false);
            }
            while (QLog.isColorLevel())
            {
              QLog.d("zivonchen", 2, "mHomeworkTroopIdentityChangedReceiver troopUin = " + paramContext + ", content = " + paramIntent + ", source = " + (String)localObject1 + ", rankId = " + i + ", nickName = " + str);
              return;
              if ("join".equals(localObject1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("wyx", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver source=join. cGroupOption=", Short.valueOf(this.this$0.a.cGroupOption), ", joinType=", Integer.valueOf(ChatSettingForTroop.a(this.this$0)) });
                }
                if (ChatSettingForTroop.a(this.this$0) == 1) {
                  ChatSettingForTroop.c(this.this$0);
                } else if (ChatSettingForTroop.a(this.this$0) == 2) {
                  ChatSettingForTroop.a(this.this$0, paramIntent);
                }
              }
            }
            if ("bindGames".equals(paramIntent))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.chatopttroop", 2, "receive bind game event, data=" + paramContext);
              }
              try
              {
                paramContext = new JSONObject(paramContext);
                paramIntent = paramContext.getString("groupid");
                if ((!this.this$0.a.troopUin.equals(paramIntent)) || (paramContext.getInt("appid") > 0)) {
                  continue;
                }
                paramContext = (ViewGroup)this.this$0.p[28];
                paramContext.setVisibility(8);
                paramContext.removeAllViews();
                ThreadManager.post(new ChatSettingForTroop.4.2(this, this.this$0.a.troopUin), 5, null, false);
                return;
              }
              catch (JSONException paramContext)
              {
                QLog.e("Q.chatopttroop", 1, "parse bind game event error", paramContext);
                return;
              }
              if ("start_recomend_page".equals(paramContext))
              {
                this.this$0.finish();
                return;
              }
              if (("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER".equals(paramContext)) && (this.this$0.qC != null))
              {
                localObject1 = paramIntent.getStringExtra("troopUin");
                paramContext = paramIntent.getStringArrayListExtra("delMemberUins");
                if ((localObject1 != null) && (((String)localObject1).equals(this.this$0.a.troopUin)) && (paramContext != null))
                {
                  paramIntent = new HashSet();
                  localObject1 = paramContext.iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    str = (String)((Iterator)localObject1).next();
                    localObject2 = this.this$0.qC.iterator();
                    while (((Iterator)localObject2).hasNext())
                    {
                      localObject3 = (oidb_0x899.memberlist)((Iterator)localObject2).next();
                      if (str.equals(((oidb_0x899.memberlist)localObject3).uint64_member_uin.get() + "")) {
                        paramIntent.add(localObject3);
                      }
                    }
                  }
                  paramIntent = paramIntent.iterator();
                  while (paramIntent.hasNext())
                  {
                    localObject1 = (oidb_0x899.memberlist)paramIntent.next();
                    this.this$0.qC.remove(localObject1);
                  }
                  paramIntent = new ArrayList();
                  localObject1 = this.this$0.qC.iterator();
                  while (((Iterator)localObject1).hasNext()) {
                    paramIntent.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject1).next()).uint64_member_uin.get()));
                  }
                  if (this.this$0.b != null)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.chatopttroop", 2, "onReceive wMemberNumClient:" + this.this$0.b.wMemberNumClient + "  wMemberNum:" + this.this$0.b.wMemberNum + " delMembers.size():" + paramContext.size() + " troopUin:" + this.this$0.b.troopuin);
                    }
                    localObject1 = this.this$0.b;
                    ((TroopInfo)localObject1).wMemberNumClient -= paramContext.size();
                  }
                  paramContext = apuh.a(this.this$0.app, this.this$0.a.isMember, this.this$0.b, paramIntent);
                  if (!TextUtils.isEmpty(paramContext)) {
                    this.this$0.b.memberListToShow = paramContext;
                  }
                  this.this$0.fH(this.this$0.qC);
                  return;
                }
              }
            }
          }
        }
        catch (JSONException paramContext) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqj
 * JD-Core Version:    0.7.0.1
 */