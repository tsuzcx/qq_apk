package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;
import com.tencent.token.ea;
import com.tencent.token.fn;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.util.ArrayList;

final class bw
  extends bo
{
  bw(CheckMobileAvailableActivity paramCheckMobileAvailableActivity)
  {
    super(paramCheckMobileAvailableActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      this.a.dismissDialog();
      e.c("utils mbinfo: " + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 15: 
        this.a.dismissDialog();
        e.c("removeTimeTask HttpError");
        this.a.removeTimeTask();
        CheckMobileAvailableActivity.access$700(this.a, this.a.getString(2131361952));
        return;
      case 3019: 
        if (CheckMobileAvailableActivity.access$000(this.a))
        {
          if (paramMessage.arg1 == 0)
          {
            CheckMobileAvailableActivity.access$102(this.a, ea.c);
            if ((CheckMobileAvailableActivity.access$100(this.a) == null) || (CheckMobileAvailableActivity.access$100(this.a).length() <= 0))
            {
              this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362223), 2131361800, null);
              return;
            }
            if ((ea.d == null) || (ea.d.length() <= 0))
            {
              this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362224), 2131361800, null);
              return;
            }
            e.c("sms channel: " + CheckMobileAvailableActivity.access$100(this.a));
            paramMessage = new Intent(this.a, SmsContentTipActivity.class);
            paramMessage.putExtra("up_sms_scene_id", CheckMobileAvailableActivity.access$200(this.a));
            if ((CheckMobileAvailableActivity.access$200(this.a) == 0) || (CheckMobileAvailableActivity.access$200(this.a) == 7))
            {
              paramMessage.putExtra("intent.qquser", CheckMobileAvailableActivity.access$300(this.a));
              paramMessage.putExtra("intent.upgradedetermin", CheckMobileAvailableActivity.access$400(this.a));
              paramMessage.putExtra("scene_id", CheckMobileAvailableActivity.access$500(this.a));
            }
            for (;;)
            {
              this.a.startActivity(paramMessage);
              return;
              if (CheckMobileAvailableActivity.access$200(this.a) == 6) {
                paramMessage.putExtra("user_to_unbind", CheckMobileAvailableActivity.access$600(this.a));
              }
            }
          }
          paramMessage = (d)paramMessage.obj;
          if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
            d.a(this.a.getResources(), paramMessage);
          }
          this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
          return;
        }
        break;
      case 3010: 
        if (paramMessage.arg1 != 0) {
          break label691;
        }
        Object localObject = fn.a().c();
        if ((localObject != null) && (((MbInfoResult)localObject).mMbInfoItems != null))
        {
          int i = 0;
          while (i < ((MbInfoResult)localObject).mMbInfoItems.size())
          {
            paramMessage = (MbInfoResult.MbInfoItem)((MbInfoResult)localObject).mMbInfoItems.get(i);
            if (paramMessage.mId == 51)
            {
              e.a("setting item: name=" + paramMessage.mName + ", desc=" + paramMessage.mDesc + ", value =" + paramMessage.mValue + ", content=" + paramMessage.mContent);
              if (paramMessage.mDetail.mBtnType == 1)
              {
                localObject = new Intent(this.a, UtilsModSetMobileStep1Activity.class);
                ((Intent)localObject).putExtra("title", this.a.getResources().getString(2131361814) + paramMessage.mName);
                ((Intent)localObject).putExtra("op_type", 1);
                ((Intent)localObject).putExtra("position", i);
                this.a.startActivity((Intent)localObject);
                return;
              }
              paramMessage = new Intent(this.a, UtilsMbInfoItemActivity.class);
              paramMessage.putExtra("position", i);
              this.a.startActivity(paramMessage);
              return;
            }
            i += 1;
          }
        }
        break;
      }
    }
    label691:
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bw
 * JD-Core Version:    0.7.0.1
 */