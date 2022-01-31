package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.bb;
import com.tencent.token.bd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.fn;
import com.tencent.token.fo;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import org.json.JSONException;
import org.json.JSONObject;

final class aas
  extends Handler
{
  aas(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              e.c("msg what=" + paramMessage.what + "starttime=" + SmsContentTipActivity.access$000(this.a));
              switch (paramMessage.what)
              {
              default: 
                return;
              }
            } while (!SmsContentTipActivity.access$000(this.a));
            if ((SmsContentTipActivity.access$1000(this.a) == 0) || (SmsContentTipActivity.access$1000(this.a) == 7))
            {
              SmsContentTipActivity.access$102(this.a, 0);
              postDelayed(this.a.mBindRunnable, 10000L);
              return;
            }
            if ((SmsContentTipActivity.access$1000(this.a) == 3) || (SmsContentTipActivity.access$1000(this.a) == 4))
            {
              SmsContentTipActivity.access$702(this.a, 0);
              postDelayed(this.a.mSetModMobileRunnable, 10000L);
              SmsContentTipActivity.access$1102(this.a, true);
              return;
            }
          } while (SmsContentTipActivity.access$1000(this.a) != 6);
          SmsContentTipActivity.access$802(this.a, 0);
          postDelayed(this.a.mUnBindRunnable, 10000L);
          return;
        } while (!SmsContentTipActivity.access$000(this.a));
        e.c("removeTimeTask SendSmsFail");
        this.a.removeTimeTask(1);
        return;
        this.a.dismissDialog();
        e.c("removeTimeTask BindUinToSeqSuccess");
        this.a.removeTimeTask(2);
        SmsContentTipActivity.access$1200(this.a);
        return;
      } while (!SmsContentTipActivity.access$000(this.a));
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("errCode");
      paramMessage = paramMessage.getString("error");
      if ((1 == i) && (SmsContentTipActivity.access$100(this.a) < 4))
      {
        postDelayed(this.a.mBindRunnable, 10000L);
        return;
      }
      this.a.dismissDialog();
      e.c("removeTimeTask BindUinToSeqFail");
      this.a.removeTimeTask(3);
      SmsContentTipActivity.access$1300(this.a).setVisibility(0);
      SmsContentTipActivity.access$1300(this.a).setText(paramMessage);
      SmsContentTipActivity.access$1400(this.a);
      return;
      this.a.dismissDialog();
      e.c("removeTimeTask HttpError");
      this.a.removeTimeTask(4);
      SmsContentTipActivity.access$1300(this.a).setVisibility(0);
      SmsContentTipActivity.access$1300(this.a).setText(this.a.getString(2131361881));
      SmsContentTipActivity.access$1400(this.a);
      return;
      i = paramMessage.getData().getInt("serTime");
      long l = System.currentTimeMillis();
      l = i * 1000L - l;
      ag.c().a(l);
      e.b("set time plus: " + l);
      return;
      if (paramMessage.arg1 != 0) {
        break;
      }
      if (SmsContentTipActivity.access$1000(this.a) == 0)
      {
        af.a().c(Long.parseLong(SmsContentTipActivity.access$200(this.a)), SmsContentTipActivity.access$1500(this.a).a(), "", "", this.a.mHandler);
        return;
      }
      if (SmsContentTipActivity.access$1000(this.a) == 6)
      {
        af.a().a(SmsContentTipActivity.access$900(this.a).mUin, SmsContentTipActivity.access$900(this.a).mRealUin, this.a.mHandler);
        return;
      }
    } while (SmsContentTipActivity.access$1000(this.a) != 7);
    paramMessage = new Intent(this.a, VryMobileForStrategyActivity.class);
    paramMessage.putExtra("succ", true);
    paramMessage.setFlags(67108864);
    this.a.startActivity(paramMessage);
    this.a.finish();
    return;
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    if ((SmsContentTipActivity.access$1000(this.a) == 0) && (paramMessage.a == 146) && (SmsContentTipActivity.access$100(this.a) < 4))
    {
      postDelayed(this.a.mBindRunnable, 10000L);
      return;
    }
    if ((SmsContentTipActivity.access$1000(this.a) == 6) && (paramMessage.a == 146) && (SmsContentTipActivity.access$800(this.a) < 4))
    {
      postDelayed(this.a.mUnBindRunnable, 10000L);
      return;
    }
    this.a.removeTimeTask(5);
    SmsContentTipActivity.access$1300(this.a).setVisibility(0);
    SmsContentTipActivity.access$1300(this.a).setText(paramMessage.c);
    SmsContentTipActivity.access$1400(this.a);
    return;
    this.a.dismissDialog();
    this.a.removeTimeTask(2);
    SmsContentTipActivity.access$1400(this.a);
    if (paramMessage.arg1 == 0)
    {
      SmsContentTipActivity.access$1602(this.a, true);
      ax.a().b(SmsContentTipActivity.access$900(this.a));
      ax.a().n();
      ax.a();
      ax.b();
      bd.a().f.a(SmsContentTipActivity.access$900(this.a).mUin);
      bb.a().f.a(SmsContentTipActivity.access$900(this.a).mUin);
      AccountPageActivity.mNeedRefreshEval = true;
      SettingPageActivity.mNeedRefreshMbInfo = true;
      this.a.showUserDialog(2131361904, this.a.getString(2131361841) + Long.toString(SmsContentTipActivity.access$900(this.a).mRealUin) + this.a.getString(2131361906), 2131361800, SmsContentTipActivity.access$1700(this.a), SmsContentTipActivity.access$1800(this.a));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    SmsContentTipActivity.access$1900(this.a, paramMessage.c);
    return;
    this.a.dismissDialog();
    this.a.removeTimeTask(2);
    if (paramMessage.arg1 == 0)
    {
      SmsContentTipActivity.access$1200(this.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    SmsContentTipActivity.access$1300(this.a).setVisibility(0);
    SmsContentTipActivity.access$1300(this.a).setText(paramMessage.c);
    SmsContentTipActivity.access$1400(this.a);
    return;
    this.a.removeTimeTask(1);
    SmsContentTipActivity.access$1102(this.a, false);
    Object localObject1;
    Object localObject4;
    if (paramMessage.arg1 == 0)
    {
      this.a.dismissDialog();
      this.a.setContentView(2130903247);
      this.a.mBackArrow.setVisibility(4);
      SmsContentTipActivity.access$2002(this.a, true);
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
          ((TextView)this.a.findViewById(2131297262)).setText(2131362219);
          ((View)localObject3).setVisibility(0);
          if ((localObject1 != null) && (paramMessage != null) && (localObject1.length() > 0) && (paramMessage.length() > 0))
          {
            localObject3 = (TextView)this.a.findViewById(2131297266);
            localObject4 = (TextView)this.a.findViewById(2131297268);
            ((TextView)localObject3).setText(localObject1);
            ((TextView)localObject4).setText(paramMessage);
          }
        }
      }
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        localObject4 = (TextView)this.a.findViewById(2131297263);
        ((TextView)localObject4).setText((CharSequence)localObject2);
        ((TextView)localObject4).setVisibility(0);
      }
      this.a.findViewById(2131297269).setOnClickListener(new aat(this));
      localObject2 = this.a.findViewById(2131297264);
      if (SmsContentTipActivity.access$400(this.a) == 1)
      {
        ((TextView)this.a.findViewById(2131297262)).setText(2131362218);
        ((View)localObject2).setVisibility(8);
        fn.a().b();
        AccountPageActivity.mNeedRefreshEval = true;
        SettingPageActivity.mNeedRefreshMbInfo = true;
        return;
      }
    }
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    if ((paramMessage.a == 146) && (SmsContentTipActivity.access$700(this.a) < 4))
    {
      postDelayed(this.a.mSetModMobileRunnable, 10000L);
      SmsContentTipActivity.access$1102(this.a, true);
      return;
    }
    SmsContentTipActivity.access$1300(this.a).setVisibility(0);
    SmsContentTipActivity.access$1300(this.a).setText(paramMessage.c);
    SmsContentTipActivity.access$1400(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aas
 * JD-Core Version:    0.7.0.1
 */