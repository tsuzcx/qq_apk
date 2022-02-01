package com.tencent.mobileqq.richstatus;

import acff;
import acfp;
import amhj;
import amhm;
import android.os.Bundle;
import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import ld;
import mqq.os.MqqHandler;

public class StatusManager$3$1
  implements Runnable
{
  public StatusManager$3$1(amhm paramamhm, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject3 = (acff)amhj.a(this.a.e).getManager(51);
    Object localObject2;
    int i;
    int j;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject2 = ((acff)localObject3).a(amhj.a(this.a.e).getAccount());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = amhj.a(this.a.e).getAccount();
      }
      if (this.val$isSuccess)
      {
        i = this.val$bundle.getInt("k_source", 0);
        localObject2 = this.val$bundle.getByteArray("k_rspbody");
        if (localObject2 != null)
        {
          localObject2 = ByteBuffer.wrap((byte[])localObject2);
          ((ByteBuffer)localObject2).get();
          j = ((ByteBuffer)localObject2).getInt();
          localObject4 = new byte[((ByteBuffer)localObject2).getShort()];
          ((ByteBuffer)localObject2).get((byte[])localObject4);
          if (((ExtensionInfo)localObject1).timestamp != j)
          {
            ((ExtensionInfo)localObject1).setRichBuffer((byte[])localObject4, j);
            localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
            if ((i != 1) || (this.val$bundle.getInt("ret", 0) != 65535)) {
              break label659;
            }
            ((RichStatus)localObject2).fontId = 0;
            ((RichStatus)localObject2).fontType = 0;
            ((acff)localObject3).a((ExtensionInfo)localObject1);
          }
        }
      }
      localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
      if (this.val$isSuccess)
      {
        if (((RichStatus)localObject2).tplId != 0) {
          break label771;
        }
        localObject1 = "1";
        label243:
        anot.a(null, "CliOper", "", "", "signiture", "set_clk_save_succ", 0, 0, (String)localObject1, "", "", "");
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      i = 100;
      localObject2 = new TipsInfo();
      if ((this.val$bundle != null) && (this.val$bundle.getInt("k_source", 0) == 1)) {
        ((TipsInfo)localObject2).errorDesc = this.val$bundle.getString("errorDesc");
      }
      j = i;
      int k;
      label366:
      String str1;
      String str2;
      if (!this.val$isSuccess)
      {
        j = i;
        if (this.val$bundle != null)
        {
          j = this.val$bundle.getInt("k_auth_code", -1);
          k = this.val$bundle.getInt("cRet", 0);
          if (k != 2) {
            break label778;
          }
          i = 103;
          if ((TextUtils.isEmpty(((TipsInfo)localObject2).errorDesc)) && (this.val$bundle.containsKey("errorDesc"))) {
            ((TipsInfo)localObject2).errorDesc = this.val$bundle.getString("errorDesc");
          }
          boolean bool = this.val$bundle.getBoolean("valid");
          ((TipsInfo)localObject2).authAppid = this.val$bundle.getInt("authAppid");
          j = i;
          if (bool)
          {
            j = this.val$bundle.getInt("type", -1);
            localObject3 = this.val$bundle.getString("titleWording");
            localObject4 = this.val$bundle.getString("wording");
            str1 = this.val$bundle.getString("rightBtnWording");
            str2 = this.val$bundle.getString("leftBtnWording");
            String str3 = this.val$bundle.getString("vipType");
            k = this.val$bundle.getInt("vipMonth");
            String str4 = this.val$bundle.getString("url");
            ((TipsInfo)localObject2).ret = this.val$bundle.getInt("ret");
            ((TipsInfo)localObject2).type = j;
            ((TipsInfo)localObject2).titleWording = ((String)localObject3);
            ((TipsInfo)localObject2).wording = ((String)localObject4);
            ((TipsInfo)localObject2).rightBtnWording = str1;
            ((TipsInfo)localObject2).leftBtnWording = str2;
            ((TipsInfo)localObject2).vipType = str3;
            ((TipsInfo)localObject2).vipMonth = k;
            ((TipsInfo)localObject2).url = str4;
            switch (j)
            {
            default: 
              j = i;
            }
          }
        }
      }
      for (;;)
      {
        amhj.a(this.a.e, null);
        ThreadManager.getUIHandler().post(new StatusManager.3.1.1(this, j, (RichStatus)localObject1, (TipsInfo)localObject2));
        ld.a().a(j, (RichStatus)localObject1, (TipsInfo)localObject2, 0);
        return;
        label659:
        if (amhj.a(this.a.e) == null) {
          break;
        }
        ((RichStatus)localObject2).fontId = amhj.a(this.a.e).fontId;
        ((RichStatus)localObject2).fontType = amhj.a(this.a.e).fontType;
        if ((amhj.a(this.a.e).mStickerInfos == null) || (amhj.a(this.a.e).mStickerInfos.size() <= 0)) {
          break;
        }
        ((RichStatus)localObject2).mStickerInfos = new ArrayList(amhj.a(this.a.e).mStickerInfos);
        break;
        label771:
        localObject1 = "0";
        break label243;
        label778:
        i = k;
        if (k != 0) {
          break label366;
        }
        i = j;
        break label366;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          ((TipsInfo)localObject2).titleWording = acfp.m(2131714787);
        }
        if (TextUtils.isEmpty(str2)) {
          ((TipsInfo)localObject2).leftBtnWording = acfp.m(2131714785);
        }
        j = i;
        if (TextUtils.isEmpty(str1))
        {
          ((TipsInfo)localObject2).rightBtnWording = acfp.m(2131714789);
          j = i;
          continue;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ((TipsInfo)localObject2).titleWording = acfp.m(2131714786);
          }
          if (TextUtils.isEmpty(str2)) {
            ((TipsInfo)localObject2).leftBtnWording = acfp.m(2131714788);
          }
          j = i;
          if (TextUtils.isEmpty(str1))
          {
            ((TipsInfo)localObject2).rightBtnWording = acfp.m(2131714790);
            j = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.1
 * JD-Core Version:    0.7.0.1
 */