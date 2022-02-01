import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ahju
  extends ahgq
{
  public ahju(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean a(aqju paramaqju)
  {
    if (!this.bf.getBoolean("is_ark_display_share")) {
      super.a(paramaqju);
    }
    return true;
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType())))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public boolean anj()
  {
    super.anj();
    if (this.bf.getBoolean("forward_ark_app_direct"))
    {
      anm();
      this.mActivity.finish();
    }
    return true;
  }
  
  protected boolean anl()
  {
    if (anq())
    {
      Iterator localIterator = fg().iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        j(localResultRecord.uin, localResultRecord.lk(), localResultRecord.QD);
      }
      return super.anl();
    }
    anm();
    return super.anl();
  }
  
  protected boolean anm()
  {
    int i = this.bf.getInt("uintype");
    return j(this.bf.getString("uin"), i, this.bf.getString("troop_uin"));
  }
  
  protected void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  protected boolean j(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.cZ = paramInt;
    localSessionInfo.aTl = paramString1;
    localSessionInfo.troopUin = paramString2;
    if ((localSessionInfo.cZ < 0) || (TextUtils.isEmpty(localSessionInfo.aTl)))
    {
      if (this.bf.getBoolean("forward_ark_app_direct")) {
        arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    Object localObject1 = this.bf.getString("forward_ark_app_name");
    Object localObject2 = this.bf.getString("forward_ark_app_view");
    String str1 = this.bf.getString("forward_ark_app_meta");
    String str2 = this.bf.getString("forward_ark_app_config");
    String str3 = this.bf.getString("forward_ark_app_prompt");
    paramString2 = ArkAppCacheMgr.getApplicationFromManifest((String)localObject1, "0.0.0.1");
    paramString1 = null;
    if (paramString2 != null) {
      if (paramString2.containsKey("desc"))
      {
        paramString1 = (String)paramString2.get("desc");
        if (!paramString2.containsKey("version")) {
          break label269;
        }
        paramString2 = (String)paramString2.get("version");
      }
    }
    for (;;)
    {
      label199:
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = (String)localObject1;
      }
      for (;;)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (this.bf.getBoolean("forward_ark_app_direct")) {
            arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
          }
          return false;
          paramString1 = "";
          break;
          label269:
          paramString2 = "0.0.0.1";
          break label199;
        }
        if (this.bf.getBoolean("forward_ark_app_direct")) {
          arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
        }
        paramString1 = new ArkAppMessage(str3, (String)localObject1, paramString1, (String)localObject2, paramString2, str1, str2, "");
        paramString2 = (ArkAppMessage)adqq.a(2, (String)localObject1, this.bf, paramString1);
        if (paramString2 == null) {}
        for (;;)
        {
          localObject1 = anre.a(this.bf);
          paramString2 = this.bf.getString("forward_appId_ark_from_sdk");
          localObject2 = this.bf.getString("struct_share_key_source_name");
          str1 = this.bf.getString("struct_share_key_source_action_data");
          str2 = this.bf.getString("struct_share_key_source_a_action_data_from_h5");
          str3 = this.bf.getString("struct_share_key_source_url");
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1.appId = paramString2;
            paramString1.mSourceName = ((String)localObject2);
            paramString1.mSourceActionData = str1;
            paramString1.mSource_A_ActionData = str2;
            paramString1.mSourceUrl = str3;
          }
          if (localObject1 != null) {
            switch (localSessionInfo.cZ)
            {
            }
          }
          for (paramString2 = this.app.getCurrentAccountUin();; paramString2 = localSessionInfo.troopUin)
          {
            localObject2 = this.app;
            str1 = this.app.getCurrentAccountUin();
            str2 = localSessionInfo.aTl;
            paramInt = localSessionInfo.cZ;
            int i = amzo.seq;
            amzo.seq = i + 1;
            paramString1.containStructMsg = anbi.a((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, (AbsStructMsg)localObject1);
            paramInt = this.bf.getInt("KEY_MSG_FORWARD_ID");
            ujt.a(this.app, localSessionInfo, paramString1, paramInt);
            return true;
          }
          paramString1 = paramString2;
        }
      }
      paramString2 = "0.0.0.1";
    }
  }
  
  public String wn()
  {
    if (TextUtils.isEmpty(this.bKu))
    {
      this.bKu = this.bf.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.bKu)) {
        this.bKu = this.bf.getString("forward_ark_app_desc");
      }
    }
    return this.bKu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahju
 * JD-Core Version:    0.7.0.1
 */