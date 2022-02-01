import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class ahgo
  extends ahgq
{
  public ahgo(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.cZ = paramInt1;
    localSessionInfo.aTl = paramString1;
    localSessionInfo.troopUin = paramString2;
    if ((localSessionInfo.cZ < 0) || (TextUtils.isEmpty(localSessionInfo.aTl)))
    {
      if (this.bf.getBoolean("forward_ark_app_direct")) {
        arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    this.bf.keySet();
    paramString2 = this.bf.getString("forward_ark_app_name");
    paramString1 = this.bf.getString("forward_ark_app_view");
    Object localObject2 = this.bf.getString("forward_ark_app_desc");
    String str3 = this.bf.getString("forward_ark_app_ver");
    String str4 = this.bf.getString("forward_ark_app_prompt");
    String str5 = this.bf.getString("forward_ark_app_meta");
    String str6 = this.bf.getString("forward_ark_app_config");
    String str7 = this.bf.getString("forward_ark_app_compat");
    Object localObject1 = this.bf.getString("forward_ark_app_list");
    String str2 = this.bf.getString("forward_ark_app_text");
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
    {
      if (this.bf.getBoolean("forward_ark_app_direct")) {
        arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    if (this.bf.getBoolean("forward_ark_app_direct")) {
      arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
    }
    paramString1 = new ArkAppMessage(str4, paramString2, (String)localObject2, paramString1, str3, str5, str6, str7);
    if (!TextUtils.isEmpty(str2)) {
      paramString1.mText = str2;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        i = ((JSONArray)localObject1).length();
        paramString1.mAppList = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          str2 = ((JSONArray)localObject1).optString(paramInt1);
          if (TextUtils.isEmpty(str2)) {
            break label618;
          }
          localObject2 = new ArkAppMessage();
          ((ArkAppMessage)localObject2).fromAppXml(str2);
          paramString1.mAppList.add(localObject2);
        }
      }
      catch (Exception localException)
      {
        com.tencent.TMG.utils.QLog.e("ForwardOption.ForwardBaseOption", 1, "appList error");
      }
      paramString2 = (ArkAppMessage)adqq.a(2, paramString2, this.bf, paramString1);
      if (paramString2 == null) {}
      for (;;)
      {
        paramString2 = this.bf.getString("forward_appId_ark_from_sdk");
        String str1 = this.bf.getString("struct_share_key_source_name");
        str2 = this.bf.getString("struct_share_key_source_action_data");
        localObject2 = this.bf.getString("struct_share_key_source_a_action_data");
        str3 = this.bf.getString("struct_share_key_source_url");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1.appId = paramString2;
          paramString1.mSourceName = str1;
          paramString1.mSourceActionData = str2;
          paramString1.mSource_A_ActionData = ((String)localObject2);
          paramString1.mSourceUrl = str3;
        }
        i = this.bf.getInt("KEY_MSG_FORWARD_ID");
        paramInt1 = i;
        if (i == 0)
        {
          paramString2 = this.bf.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
          paramInt1 = i;
          if (paramString2 != null) {
            if (paramString2.length <= paramInt2) {
              break label600;
            }
          }
        }
        for (paramInt1 = paramString2[paramInt2];; paramInt1 = i)
        {
          ujt.a(this.app, localSessionInfo, paramString1, paramInt1);
          return true;
          label600:
          ArkAppCenter.r("ArkApp", "ForwardArkMsgOption.sendArkMessage, forward array has not enough length");
        }
        paramString1 = paramString2;
      }
      label618:
      paramInt1 += 1;
    }
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
    dnw();
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
      List localList = fg();
      int i = 0;
      while (i < localList.size())
      {
        ResultRecord localResultRecord = (ResultRecord)localList.get(i);
        a(localResultRecord.uin, localResultRecord.lk(), localResultRecord.QD, i);
        i += 1;
      }
      return super.anl();
    }
    anm();
    return super.anl();
  }
  
  protected boolean anm()
  {
    int i = this.bf.getInt("uintype");
    return a(this.bf.getString("uin"), i, this.bf.getString("troop_uin"), 0);
  }
  
  public boolean ann()
  {
    return true;
  }
  
  public void b(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super.b(paramQQAppInterface, paramActivity);
    adqr.c(paramQQAppInterface, this.bf.getString("forward_ark_app_name"), this.bf.getString("forward_ark_app_view"));
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
  
  protected void dnv()
  {
    super.dnv();
    int i = this.bf.getInt("uintype");
    String str1 = this.bf.getString("forward_ark_app_type");
    String str2 = this.bf.getString("forward_ark_app_title");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {}
    do
    {
      return;
      anot.a(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, 0, str1, ForwardUtils.cy(i), str2, "");
    } while (!com.tencent.qphone.base.util.QLog.isColorLevel());
    com.tencent.qphone.base.util.QLog.d("ForwardOption.ForwardBaseOption", 2, new Object[] { "ARK转发=0X800A631, type=", str1, ", uinType=", ForwardUtils.cy(i), ", title=", str2 });
  }
  
  public void dnw()
  {
    String str1 = this.bf.getString("forward_ark_app_name");
    String str2 = this.bf.getString("forward_ark_h5_from_js");
    String str3 = this.bf.getString("forward_ark_app_view");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      adnq.a(str1, str3, str2, new ahgp(this));
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
 * Qualified Name:     ahgo
 * JD-Core Version:    0.7.0.1
 */