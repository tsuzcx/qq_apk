package com.tencent.mobileqq.activity.aio;

import acfp;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import anot;
import anqx;
import anre;
import aurf;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import wja;

public class MessageShareActivity
  extends BaseActivity
  implements Handler.Callback, Runnable
{
  protected final MqqHandler b = new aurf(Looper.getMainLooper(), this);
  protected Bundle mExtra;
  protected Dialog pd;
  
  private void a(List<ResultRecord> paramList, Intent paramIntent, AbsStructMsg paramAbsStructMsg)
  {
    if (f(paramAbsStructMsg))
    {
      QLog.d("MessageShareActivity", 1, "onSDKShareEnd sdkLocalShare");
      ForwardUtils.a(paramList, null, this, paramIntent.getStringExtra("share_msg_input_value"));
      paramIntent.putExtra("sdk_mult_share", true);
      paramIntent.putExtra("sdk_mult_share_for_local", true);
      paramIntent.putExtra("open_chatfragment", false);
      paramIntent.putExtra("fragment_id", 1);
      startActivity(paramIntent);
    }
  }
  
  private boolean f(AbsStructMsg paramAbsStructMsg)
  {
    if (11 != this.mExtra.getInt("forward_type", -1)) {
      return false;
    }
    return ForwardUtils.e(paramAbsStructMsg);
  }
  
  public void doOnDestroy()
  {
    if (this.pd != null)
    {
      this.pd.dismiss();
      this.pd = null;
    }
    super.doOnDestroy();
  }
  
  protected void doShare()
  {
    if (this.mExtra == null) {
      throw new IllegalArgumentException();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      int i = this.mExtra.getInt("forward_type", -1);
      switch (i)
      {
      default: 
        break;
      case 2: 
      case 11: 
        long l = this.mExtra.getLong("req_share_id");
        Object localObject2 = this.mExtra.getString("pkg_name");
        paramMessage = this.mExtra.getString("detail_url");
        this.mExtra.putBoolean("isBack2Root", false);
        this.mExtra.putLong("res_share_id", l);
        this.mExtra.putString("res_pkg_name", (String)localObject2);
        this.mExtra.putString("res_detail_url", paramMessage);
        QLog.d("MessageShareActivity", 1, new Object[] { "-->handleMessage--appid = ", Long.valueOf(l), ", pkgNmae = ", localObject2 });
        paramMessage = new Intent(this, SplashActivity.class);
        paramMessage.putExtra("k_from_login", true);
        Object localObject1 = this.mExtra.getString("uin");
        int j = this.mExtra.getInt("uintype");
        l = this.mExtra.getLong("req_share_id");
        ArrayList localArrayList = this.mExtra.getParcelableArrayList("forward_multi_target");
        Object localObject3;
        if (i == 11)
        {
          localObject3 = new Intent();
          ((Intent)localObject3).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), "shareToQQ" })));
          ((Intent)localObject3).setPackage((String)localObject2);
          paramMessage.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this, 0, (Intent)localObject3, 268435456));
          localObject2 = this.mExtra.getString("video_url");
          localObject3 = this.mExtra.getString("detail_url");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
          {
            localObject2 = anqx.getDomain((String)localObject3);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              anot.a(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, anqx.jv(j) + "", "", (String)localObject2, "");
            }
          }
        }
        localObject2 = anre.a(this.mExtra);
        if ((localObject2 != null) && (this.app != null))
        {
          if (!(localObject2 instanceof StructMsgForImageShare)) {
            break label547;
          }
          ThreadManager.post(new MessageShareActivity.1(this, localArrayList, (AbsStructMsg)localObject2, (String)localObject1, j), 8, null, false);
          label462:
          paramMessage.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject2).getBytes());
          if (this.mExtra.getBoolean("share_from_aio", false)) {
            break label675;
          }
          paramMessage = wja.a(paramMessage, new int[] { 2 });
          this.mExtra.remove("share_from_aio");
          label511:
          paramMessage.putExtras(this.mExtra);
          if ((localArrayList != null) && (!localArrayList.isEmpty())) {
            break label693;
          }
          startActivity(paramMessage);
        }
        for (;;)
        {
          finish();
          break;
          label547:
          if (i == 11)
          {
            this.mExtra.putBoolean("share_send_msg_by_server", true);
            break label462;
          }
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (ResultRecord)((Iterator)localObject1).next();
              AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).lk(), ((ResultRecord)localObject3).QD);
            }
            break label462;
          }
          localObject3 = this.mExtra.getString("troop_uin");
          AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, (String)localObject1, j, (String)localObject3);
          break label462;
          label675:
          paramMessage = wja.a(paramMessage, null);
          paramMessage.putExtra("share_from_aio", true);
          break label511;
          label693:
          a(localArrayList, paramMessage, (AbsStructMsg)localObject2);
        }
        ((TextView)this.pd.findViewById(2131373180)).setText(acfp.m(2131708238));
        this.pd.findViewById(2131373179).setVisibility(4);
        this.b.sendEmptyMessageDelayed(3, 800L);
        continue;
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(new View(this));
    this.pd = new ReportDialog(this, 2131756467);
    this.pd.setCancelable(false);
    this.pd.setContentView(2131559761);
    ((TextView)this.pd.findViewById(2131373180)).setText(2131696921);
    this.mExtra = getIntent().getExtras();
    if (this.mExtra != null) {
      try
      {
        handleMessage(this.b.obtainMessage(1));
        return;
      }
      catch (IllegalArgumentException paramBundle)
      {
        do
        {
          QLog.e("MessageShareActivity", 1, paramBundle, new Object[0]);
        } while (!AppSetting.Nv());
        return;
      }
    }
    QLog.d("MessageShareActivity", 1, "getExtras() is null !!!!!");
    this.pd.show();
    handleMessage(this.b.obtainMessage(2));
  }
  
  public void run()
  {
    try
    {
      doShare();
      this.b.sendEmptyMessageDelayed(1, 333L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageShareActivity", 1, "doShare() cause exception !!!!!", localException);
      this.b.sendEmptyMessageDelayed(2, 333L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity
 * JD-Core Version:    0.7.0.1
 */