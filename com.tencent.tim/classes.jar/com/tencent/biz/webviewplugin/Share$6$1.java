package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import aqmf;
import aqzv;
import ardm.o;
import arhz;
import arts;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;
import svi;

class Share$6$1
  implements Runnable
{
  Share$6$1(Share.6 param6, String paramString) {}
  
  public void run()
  {
    Object localObject = (aqzv)this.a.this$0.ds.get();
    String str1;
    String str2;
    if ((localObject != null) && ((localObject instanceof ardm.o)) && (((ardm.o)localObject).mc()) && (!this.a.this$0.activity.isFinishing()))
    {
      if ((this.a.this$0.s != null) && (this.a.this$0.s.isShowing())) {
        this.a.this$0.s.dismiss();
      }
      str1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.a.aHq });
      str2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { this.a.aHq });
      if (!TextUtils.isEmpty(this.aHt)) {
        break label431;
      }
    }
    label431:
    for (localObject = this.a.val$imageUrl;; localObject = this.aHt)
    {
      String str3 = String.format(this.a.this$0.activity.getResources().getString(2131698632), new Object[] { this.a.val$title });
      aqmf.a(this.a.this$0.activity, 1001, 146, "struct_msg_from_h5", this.a.aHq, (String)localObject, this.a.val$title, this.a.aHr, str3, this.a.val$targetUrl, "web", null, null, null, "plugin", null, str1, str2, "https://url.cn/JS8oE7", this.a.aHs, null);
      int j = 0;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        j = 1;
      }
      int i = j;
      if (TextUtils.isEmpty(this.a.aHr)) {
        i = j | 0x2;
      }
      j = i;
      if (TextUtils.isEmpty(this.a.val$title)) {
        j = i | 0x4;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "14");
      ((Bundle)localObject).putString("intext_3", "1");
      ((Bundle)localObject).putString("intext_2", "" + j);
      ((Bundle)localObject).putString("stringext_1", "" + this.a.val$targetUrl);
      arts.a().a((Bundle)localObject, "", this.a.this$0.c.getAccount(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.6.1
 * JD-Core Version:    0.7.0.1
 */