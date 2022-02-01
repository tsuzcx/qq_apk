package com.tencent.mobileqq.forward;

import aghw;
import ahjq;
import amzo;
import anbi;
import android.content.Intent;
import android.os.Bundle;
import anfr;
import anfw;
import angi;
import anre;
import avja;
import avjg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import ujt;
import wte;

public class ForwardQFavBatchOption$1
  implements Runnable
{
  public ForwardQFavBatchOption$1(ahjq paramahjq, Bundle paramBundle, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, Intent paramIntent) {}
  
  public void run()
  {
    int m = this.val$bundle.getInt("qfavType");
    int k;
    int i;
    boolean bool;
    Object localObject1;
    int n;
    Object localObject2;
    int j;
    switch (m)
    {
    case 4: 
    default: 
      return;
    case 6: 
    case 8: 
      this.val$bundle.putString("struct_share_key_source_icon", BaseApplicationImpl.getContext().getString(2131693431));
      this.val$bundle.putString("app_name", BaseApplicationImpl.getContext().getString(2131693429));
      this.val$bundle.putString("struct_share_key_source_action", "plugin");
      this.val$bundle.putString("struct_share_key_source_action_data", "qqfav://operation/2");
      this.val$bundle.putInt("req_type", 133);
      k = 0;
      i = 0;
      bool = this.val$bundle.getBoolean("bFriendCard", false);
      localObject1 = this.val$bundle.getByteArray("sBizDataList");
      if (m == 6)
      {
        n = this.val$bundle.getInt("nLinkType");
        if ((n == 4) || (n == 5))
        {
          localObject2 = new ArkAppMessage();
          ((ArkAppMessage)localObject2).fromAppXml(new String((byte[])localObject1));
          localObject2 = anbi.a(this.this$0.app, this.val$uin, this.bKF, this.val$type, (ArkAppMessage)localObject2);
          wte.a().i(((MessageForArkApp)localObject2).uniseq, ((MessageForArkApp)localObject2).uniseq, this.bES);
          this.this$0.app.b().a((MessageRecord)localObject2, null);
          j = 1;
          label274:
          k = j;
          j = i;
          i = k;
        }
      }
      break;
    }
    for (;;)
    {
      k = i;
      if (i == 0)
      {
        k = i;
        if (j != 0)
        {
          k = i;
          if (localObject1 != null)
          {
            localObject1 = anre.a((byte[])localObject1, 0);
            k = i;
            if (localObject1 != null)
            {
              localObject2 = this.this$0.app;
              str1 = this.val$selfUin;
              str2 = this.val$uin;
              str3 = this.bKF;
              i = this.val$type;
              j = amzo.seq;
              amzo.seq = j + 1;
              localObject2 = anbi.a((QQAppInterface)localObject2, str1, str2, str3, i, j, (AbsStructMsg)localObject1);
              wte.a().i(((MessageForStructing)localObject2).uniseq, ((AbsStructMsg)localObject1).uniseq, this.bES);
              this.this$0.app.b().a((MessageRecord)localObject2, null);
              k = 1;
            }
          }
        }
      }
      if (k == 0)
      {
        localObject1 = anre.a(this.val$bundle);
        localObject2 = this.this$0.app;
        str1 = this.val$selfUin;
        str2 = this.val$uin;
        str3 = this.bKF;
        i = this.val$type;
        j = amzo.seq;
        amzo.seq = j + 1;
        localObject2 = anbi.a((QQAppInterface)localObject2, str1, str2, str3, i, j, (AbsStructMsg)localObject1);
        wte.a().i(((MessageForStructing)localObject2).uniseq, ((AbsStructMsg)localObject1).uniseq, this.bES);
        this.this$0.app.b().a((MessageRecord)localObject2, null);
      }
      if (m == 8)
      {
        avjg.a(this.this$0.app, "User_Forward", 8, 0, this.cZY);
        return;
        if (n != 6)
        {
          j = k;
          if (n != 7) {
            break label274;
          }
        }
        i = 1;
        j = k;
        break label274;
        if ((!bool) || (localObject1 == null)) {
          break label1159;
        }
        i = 0;
        j = 1;
        continue;
      }
      avjg.a(this.this$0.app, "User_Forward", 2, 0, this.cZY);
      return;
      localObject2 = this.val$bundle.getString("text");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = anbi.a(this.this$0.app, this.val$selfUin, this.val$uin, this.bKF, this.val$type, (byte)1, (byte)0, (short)0, (String)localObject1);
      if (this.this$0.app.b() != null) {
        this.this$0.app.b().a((MessageRecord)localObject1, null);
      }
      avjg.a(this.this$0.app, "User_Forward", 1, 0, this.cZY);
      return;
      localObject2 = this.val$bundle.getString("forward_filepath");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ThreadManager.post(new ForwardQFavBatchOption.1.1(this, (String)localObject1), 8, null, false);
      avjg.a(this.this$0.app, "User_Forward", 3, 0, this.cZY);
      return;
      localObject1 = new SessionInfo();
      ((SessionInfo)localObject1).aTl = this.val$uin;
      ((SessionInfo)localObject1).aTn = this.bKG;
      ((SessionInfo)localObject1).cZ = this.val$type;
      ((SessionInfo)localObject1).troopUin = this.bKF;
      localObject2 = this.val$bundle.getString("lat");
      String str1 = this.val$bundle.getString("lon");
      String str2 = this.val$bundle.getString("title");
      String str3 = this.val$bundle.getString("address");
      this.this$0.bf.putInt("isArk", 1);
      ujt.a(this.this$0.mActivity, this.this$0.app, (SessionInfo)localObject1, (String)localObject2, str1, str3, str2, str3, null, "", "", "", this.this$0.bf);
      avjg.a(this.this$0.app, "User_Forward", 7, 0, this.cZY);
      return;
      localObject1 = anfr.a(3, 2);
      this.aa.putExtras(this.val$bundle);
      localObject2 = anfr.a(2, this.aa, (angi)localObject1);
      ((anfw)localObject2).peerUin = this.this$0.bf.getString("uin");
      ((anfw)localObject2).bUG = this.this$0.bf.getString("troop_uin");
      ((anfw)localObject2).uinType = this.this$0.bf.getInt("uintype");
      ((anfw)localObject2).dFl = 2;
      ((angi)localObject1).b((anfw)localObject2);
      anfr.a((angi)localObject1, this.this$0.app);
      avjg.a(this.this$0.app, "User_Forward", 5, 0, this.cZY);
      return;
      localObject1 = this.this$0.bf.getString("uin");
      i = this.this$0.bf.getInt("uintype");
      localObject2 = avja.a(this.val$bundle, this.this$0.bf.getString("uin"), this.this$0.bf.getInt("uintype"));
      if (localObject2 == null) {
        break;
      }
      this.this$0.app.a().a((FileManagerEntity)localObject2, (String)localObject1, i, this.bES);
      return;
      label1159:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption.1
 * JD-Core Version:    0.7.0.1
 */