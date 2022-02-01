import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ahgm
  extends ahjc
{
  public ahgm(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void dnu()
  {
    String str1 = this.bf.getString("forward_ark_app_name");
    String str2 = this.bf.getString("forward_ark_h5_from_normal");
    String str3 = this.bf.getString("forward_ark_app_view");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      adnq.a(str1, str3, str2, new ahgn(this));
    }
  }
  
  protected boolean a(aqju paramaqju)
  {
    if ((this.bf.getBoolean("is_ark_display_share")) && (this.bf.getBoolean("forward_ark_from_h5_parse_meta_success"))) {}
    for (;;)
    {
      return true;
      super.a(paramaqju);
    }
  }
  
  public boolean anj()
  {
    dnu();
    dnF();
    return super.anj();
  }
  
  protected boolean anm()
  {
    int i = this.bf.getInt("uintype");
    boolean bool = g(this.bf.getString("uin"), this.bf.getString("troop_uin"), i);
    this.mActivity.finish();
    return bool;
  }
  
  protected void dnv()
  {
    boolean bool1 = this.bf.getBoolean("forward_ark_from_h5_success");
    boolean bool2 = this.bf.getBoolean("forward_ark_from_h5_parse_meta_success");
    QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 1, new Object[] { "ShareArkFromH5 before sendArkMag isUrlLegal=", Boolean.valueOf(bool1), ", isMetaLegal=", Boolean.valueOf(bool2) });
    if (anq())
    {
      Iterator localIterator;
      if ((bool1) && (bool2))
      {
        ccu();
        localIterator = fg().iterator();
      }
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        g(localResultRecord.uin, localResultRecord.QD, localResultRecord.lk());
        continue;
        super.dnv();
      }
      return;
    }
    if ((bool1) && (bool2))
    {
      ccu();
      anm();
      return;
    }
    super.dnv();
  }
  
  protected boolean g(String paramString1, String paramString2, int paramInt)
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
    paramString2 = ArkAppCacheMgr.getApplicationFromManifest((String)localObject1, "0.0.0.1");
    paramString1 = null;
    if (paramString2 != null) {
      if (paramString2.containsKey("desc"))
      {
        paramString1 = (String)paramString2.get("desc");
        if (!paramString2.containsKey("version")) {
          break label276;
        }
        paramString2 = (String)paramString2.get("version");
      }
    }
    for (;;)
    {
      label188:
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = (String)localObject1;
      }
      for (;;)
      {
        String str3 = String.format(acfp.m(2131706435), new Object[] { paramString1 });
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (this.bf.getBoolean("forward_ark_app_direct")) {
            arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
          }
          return false;
          paramString1 = "";
          break;
          label276:
          paramString2 = "0.0.0.1";
          break label188;
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
            ujt.a(this.app, localSessionInfo, paramString1);
            return true;
          }
          paramString1 = paramString2;
        }
      }
      paramString2 = "0.0.0.1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgm
 * JD-Core Version:    0.7.0.1
 */