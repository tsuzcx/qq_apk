package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.du;
import com.tencent.token.eq;
import com.tencent.token.er;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

class zj
  extends Handler
{
  zj(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      if (this.a == null) {
        break label2219;
      }
      if ((this.a != null) && (this.a.isFinishing())) {
        return;
      }
      h.c("msg what=" + paramMessage.what + "starttime=" + SmsContentTipActivity.access$000(this.a));
      switch (paramMessage.what)
      {
      case 3: 
        if (!SmsContentTipActivity.access$000(this.a)) {
          break label2219;
        }
        if ((SmsContentTipActivity.access$1200(this.a) == 0) || (SmsContentTipActivity.access$1200(this.a) == 7))
        {
          SmsContentTipActivity.access$102(this.a, 0);
          postDelayed(this.a.mBindRunnable, 10000L);
          return;
        }
        break;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      return;
    }
    Object localObject1;
    if ((SmsContentTipActivity.access$1200(this.a) == 3) || (SmsContentTipActivity.access$1200(this.a) == 4))
    {
      paramMessage = cp.a(RqdApplication.l());
      localObject1 = paramMessage.b(Long.parseLong(SmsContentTipActivity.access$300(this.a)));
      h.a("mailprotect data=" + localObject1);
      if ((localObject1 != null) && (localObject1.length > 0) && (!paramMessage.b("" + SmsContentTipActivity.access$300(this.a), 523005419L)))
      {
        SmsContentTipActivity.access$802(this.a, w.a((byte[])localObject1));
        SmsContentTipActivity.access$1300(this.a);
        return;
      }
      cp.a(RqdApplication.l()).a("" + SmsContentTipActivity.access$300(this.a), this.a.mHandler, 523005419L, 64);
      return;
    }
    if (SmsContentTipActivity.access$1200(this.a) == 6)
    {
      SmsContentTipActivity.access$1002(this.a, 0);
      postDelayed(this.a.mUnBindRunnable, 10000L);
      return;
    }
    if (SmsContentTipActivity.access$1200(this.a) == 8)
    {
      SmsContentTipActivity.access$102(this.a, 0);
      postDelayed(this.a.mBindRunnable, 10000L);
      return;
      if (SmsContentTipActivity.access$000(this.a))
      {
        h.c("removeTimeTask SendSmsFail");
        this.a.removeTimeTask();
        return;
        this.a.dismissDialog();
        h.c("removeTimeTask BindUinToSeqSuccess");
        this.a.removeTimeTask();
        SmsContentTipActivity.access$1400(this.a);
        return;
        if (SmsContentTipActivity.access$000(this.a))
        {
          paramMessage = paramMessage.getData();
          int i = paramMessage.getInt("errCode");
          paramMessage = paramMessage.getString("error");
          if ((1 == i) && (SmsContentTipActivity.access$100(this.a) < 4))
          {
            postDelayed(this.a.mBindRunnable, 10000L);
            return;
          }
          this.a.dismissDialog();
          h.c("removeTimeTask BindUinToSeqFail");
          this.a.removeTimeTask();
          SmsContentTipActivity.access$1500(this.a).setVisibility(0);
          SmsContentTipActivity.access$1500(this.a).setText(paramMessage);
          SmsContentTipActivity.access$1600(this.a);
          return;
          this.a.dismissDialog();
          h.c("removeTimeTask HttpError");
          this.a.removeTimeTask();
          SmsContentTipActivity.access$1500(this.a).setVisibility(0);
          SmsContentTipActivity.access$1500(this.a).setText(this.a.getString(2131231451));
          SmsContentTipActivity.access$1600(this.a);
          return;
          i = paramMessage.getData().getInt("serTime");
          long l = System.currentTimeMillis();
          l = i * 1000L - l;
          cx.c().a(l);
          h.b("set time plus: " + l);
          return;
          if (paramMessage.arg1 == 0)
          {
            if (SmsContentTipActivity.access$1200(this.a) == 0)
            {
              cw.a().c(Long.parseLong(SmsContentTipActivity.access$300(this.a)), SmsContentTipActivity.access$1700(this.a).f(), "", "", this.a.mHandler);
              return;
            }
            if (SmsContentTipActivity.access$1200(this.a) == 6)
            {
              cw.a().a(SmsContentTipActivity.access$1100(this.a).mUin, SmsContentTipActivity.access$1100(this.a).mRealUin, 1, this.a.mHandler);
              return;
            }
            if (SmsContentTipActivity.access$1200(this.a) == 7)
            {
              paramMessage = new Intent(this.a, VryMobileForStrategyActivity.class);
              paramMessage.putExtra("succ", true);
              paramMessage.setFlags(67108864);
              this.a.startActivity(paramMessage);
              this.a.finish();
              return;
            }
            if (SmsContentTipActivity.access$1200(this.a) == 8)
            {
              if (!SmsContentTipActivity.access$200(this.a).a(Integer.valueOf(SmsContentTipActivity.access$1800(this.a))))
              {
                abi.a().a(this.a, SmsContentTipActivity.access$1900(this.a), SmsContentTipActivity.access$200(this.a), SmsContentTipActivity.access$200(this.a).a(SmsContentTipActivity.access$1800(this.a)), false, this.a.mHandler);
                return;
              }
              if (SmsContentTipActivity.access$1900(this.a).b())
              {
                cw.a().b(SmsContentTipActivity.access$2000(this.a).mRealUin, SmsContentTipActivity.access$200(this.a).a(), SmsContentTipActivity.access$600(this.a), SmsContentTipActivity.access$700(this.a), this.a.mHandler);
                return;
              }
              this.a.dismissDialog();
            }
          }
          else
          {
            paramMessage = (f)paramMessage.obj;
            f.a(this.a.getResources(), paramMessage);
            if (((SmsContentTipActivity.access$1200(this.a) == 0) || (SmsContentTipActivity.access$1200(this.a) == 8)) && (paramMessage.a == 146) && (SmsContentTipActivity.access$100(this.a) < 4))
            {
              postDelayed(this.a.mBindRunnable, 10000L);
              return;
            }
            if ((SmsContentTipActivity.access$1200(this.a) == 6) && (paramMessage.a == 146) && (SmsContentTipActivity.access$1000(this.a) < 4))
            {
              postDelayed(this.a.mUnBindRunnable, 10000L);
              return;
            }
            this.a.removeTimeTask();
            SmsContentTipActivity.access$1500(this.a).setVisibility(0);
            SmsContentTipActivity.access$1500(this.a).setText(paramMessage.c);
            SmsContentTipActivity.access$1600(this.a);
            return;
            this.a.dismissDialog();
            this.a.removeTimeTask();
            SmsContentTipActivity.access$1600(this.a);
            if (paramMessage.arg1 == 0)
            {
              SmsContentTipActivity.access$2102(this.a, true);
              do.a().b(SmsContentTipActivity.access$1100(this.a));
              do.a().n();
              do.a().b();
              du.a().f.a(SmsContentTipActivity.access$1100(this.a).mUin);
              ds.a().f.a(SmsContentTipActivity.access$1100(this.a).mUin);
              AccountPageActivity.mNeedRefreshEval = true;
              this.a.showUserDialog(0, this.a.getString(2131230763) + Long.toString(SmsContentTipActivity.access$1100(this.a).mRealUin) + this.a.getString(2131231511), 2131230897, SmsContentTipActivity.access$2200(this.a), SmsContentTipActivity.access$2300(this.a));
              return;
            }
            paramMessage = (f)paramMessage.obj;
            f.a(this.a.getResources(), paramMessage);
            SmsContentTipActivity.access$2400(this.a, paramMessage.c);
            return;
            this.a.dismissDialog();
            this.a.removeTimeTask();
            if (paramMessage.arg1 == 0)
            {
              SmsContentTipActivity.access$1400(this.a);
              return;
            }
            paramMessage = (f)paramMessage.obj;
            f.a(this.a.getResources(), paramMessage);
            h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
            SmsContentTipActivity.access$1500(this.a).setVisibility(0);
            SmsContentTipActivity.access$1500(this.a).setText(paramMessage.c);
            SmsContentTipActivity.access$1600(this.a);
            return;
            this.a.removeTimeTask();
            SmsContentTipActivity.access$2502(this.a, false);
            Object localObject4;
            if (paramMessage.arg1 == 0)
            {
              this.a.dismissDialog();
              this.a.setContentView(2130968810);
              this.a.mBackArrow.setVisibility(4);
              SmsContentTipActivity.access$2602(this.a, true);
              if ((SmsContentTipActivity.access$2700(this.a) != null) && (SmsContentTipActivity.access$2700(this.a).length() > 0)) {
                this.a.setTitle(SmsContentTipActivity.access$2700(this.a));
              }
              Object localObject5 = (JSONObject)paramMessage.obj;
              localObject1 = null;
              localObject4 = null;
              paramMessage = (Message)localObject4;
              try
              {
                localObject2 = ((JSONObject)localObject5).getString("info");
                paramMessage = (Message)localObject4;
                localObject1 = localObject2;
                localObject4 = ((JSONObject)localObject5).getString("time1");
                paramMessage = (Message)localObject4;
                localObject1 = localObject2;
                localObject5 = ((JSONObject)localObject5).getString("time2");
                localObject1 = localObject4;
                paramMessage = (Message)localObject5;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  localJSONException.printStackTrace();
                  localObject4 = paramMessage;
                  paramMessage = null;
                  Object localObject3 = localObject1;
                  localObject1 = localObject4;
                  continue;
                  ((TextView)this.a.findViewById(2131559421)).setText(2131231584);
                  if ((localObject1 != null) && (paramMessage != null) && (((String)localObject1).length() > 0) && (paramMessage.length() > 0))
                  {
                    ((View)localObject3).setVisibility(0);
                    localObject3 = (TextView)this.a.findViewById(2131559425);
                    localObject4 = (TextView)this.a.findViewById(2131559427);
                    ((TextView)localObject3).setText((CharSequence)localObject1);
                    ((TextView)localObject4).setText(paramMessage);
                  }
                  else
                  {
                    ((View)localObject3).setVisibility(8);
                  }
                }
              }
              if ((localObject2 != null) && (((String)localObject2).length() > 0))
              {
                localObject4 = (TextView)this.a.findViewById(2131559422);
                ((TextView)localObject4).setText((CharSequence)localObject2);
                ((TextView)localObject4).setVisibility(0);
              }
              this.a.findViewById(2131559428).setOnClickListener(new zk(this));
              localObject2 = this.a.findViewById(2131559423);
              if (SmsContentTipActivity.access$500(this.a) == 1)
              {
                ((TextView)this.a.findViewById(2131559421)).setText(2131231590);
                ((View)localObject2).setVisibility(8);
                this.a.findViewById(2131559422).setVisibility(8);
                eq.a().b();
                AccountPageActivity.mNeedRefreshEval = true;
                return;
              }
            }
            paramMessage = (f)paramMessage.obj;
            if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
              f.a(this.a.getResources(), paramMessage);
            }
            if ((paramMessage.a == 146) && (SmsContentTipActivity.access$900(this.a) < 4))
            {
              postDelayed(this.a.mSetModMobileRunnable, 10000L);
              SmsContentTipActivity.access$2502(this.a, true);
              return;
            }
            SmsContentTipActivity.access$1500(this.a).setVisibility(0);
            SmsContentTipActivity.access$1500(this.a).setText(paramMessage.c);
            SmsContentTipActivity.access$1600(this.a);
            return;
            localObject1 = (byte[])paramMessage.obj;
            if ((paramMessage.arg1 == 0) && (localObject1 != null) && (localObject1.length > 0)) {
              SmsContentTipActivity.access$802(this.a, w.a((byte[])localObject1));
            }
            SmsContentTipActivity.access$1300(this.a);
            return;
            SmsContentTipActivity.access$1300(this.a);
          }
        }
      }
    }
    label2219:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zj
 * JD-Core Version:    0.7.0.1
 */