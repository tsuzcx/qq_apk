package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;
import com.tencent.token.eq;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import java.util.ArrayList;

class vt
  extends cb
{
  vt(RealNameStep0VerifyMobileActivity paramRealNameStep0VerifyMobileActivity)
  {
    super(paramRealNameStep0VerifyMobileActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    Object localObject;
    do
    {
      return;
      h.c("utils mbinfo: " + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3010: 
        if (paramMessage.arg1 != 0) {
          break label675;
        }
        this.a.dismissDialog();
        localObject = eq.a().c();
      }
    } while ((localObject == null) || (((MbInfoResult)localObject).mMbInfoItems == null));
    int i = 0;
    while (i < ((MbInfoResult)localObject).mMbInfoItems.size())
    {
      paramMessage = (MbInfoResult.MbInfoItem)((MbInfoResult)localObject).mMbInfoItems.get(i);
      if (paramMessage.mId == 51)
      {
        h.a("setting item: name=" + paramMessage.mName + ", desc=" + paramMessage.mDesc + ", value =" + paramMessage.mValue + ", content=" + paramMessage.mContent);
        if (paramMessage.mDetail.mBtnType == 1)
        {
          localObject = new Intent(this.a, UtilsModSetMobileStep1Activity.class);
          ((Intent)localObject).putExtra("title", this.a.getResources().getString(2131231428) + paramMessage.mName);
          ((Intent)localObject).putExtra("op_type", 1);
          ((Intent)localObject).putExtra("position", i);
          this.a.startActivity((Intent)localObject);
          return;
          this.a.dismissDialog();
          if (paramMessage.arg1 == 0)
          {
            paramMessage = new Intent(this.a, RealNameStep0VerifyMobileDownActivity.class);
            paramMessage.putExtra("realname_mobile", RealNameStep0VerifyMobileActivity.access$000(this.a));
            paramMessage.putExtra("real_uin", RealNameStep0VerifyMobileActivity.access$100(this.a));
            paramMessage.putExtra("scene_id", RealNameStep0VerifyMobileActivity.access$200(this.a));
            paramMessage.putExtra("zzb_recommend_view", this.a.isFromRecommView);
            if (1003 == RealNameStep0VerifyMobileActivity.access$200(this.a))
            {
              paramMessage.putExtra("source_id", RealNameStep0VerifyMobileActivity.access$300(this.a));
              paramMessage.putExtra("mFrontPath", this.a.mFrontPath);
              paramMessage.putExtra("mBackPath", this.a.mBackPath);
              paramMessage.putExtra("mFaceData", this.a.mFaceData);
              paramMessage.putExtra("frontphotoinfo", this.a.frontphotoinfo);
              paramMessage.putExtra("backphotoinfo", this.a.backphotoinfo);
              paramMessage.putExtra("canchange_uin", RealNameStep0VerifyMobileActivity.access$400(this.a));
              paramMessage.putExtra("result", RealNameStep0VerifyMobileActivity.access$500(this.a));
            }
            for (;;)
            {
              paramMessage.putExtra("ish5zzb", this.a.ish5zzb);
              if (RealNameStep0VerifyMobileActivity.access$700(this.a)) {
                paramMessage.putExtra("not_showLockVerify", true);
              }
              this.a.startActivity(paramMessage);
              return;
              paramMessage.putExtra("realname_result", RealNameStep0VerifyMobileActivity.access$600(this.a));
            }
          }
          if (paramMessage.arg1 == 124)
          {
            paramMessage = (f)paramMessage.obj;
            f.a(this.a.getResources(), paramMessage);
            this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, new vu(this));
            return;
          }
          paramMessage = (f)paramMessage.obj;
          f.a(this.a.getResources(), paramMessage);
          this.a.showUserDialog(paramMessage.c);
          return;
        }
        paramMessage = new Intent(this.a, UtilsMbInfoItemActivity.class);
        paramMessage.putExtra("position", i);
        this.a.startActivity(paramMessage);
        return;
      }
      i += 1;
    }
    label675:
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vt
 * JD-Core Version:    0.7.0.1
 */