package com.tencent.mobileqq.activity.activateFriend;

import acfp;
import ahgg.a;
import ahgq;
import ahix;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import anot;
import anqv;
import anrd;
import ansk;
import anux;
import aqgv;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;

public class ActivateFriendShareFragment
  extends PublicBaseFragment
{
  private Activity activity;
  QQAppInterface app;
  private String content;
  private String friendUin;
  private String jumpUrl;
  private long timestamp;
  
  private void bYd()
  {
    ahgq localahgq = ahix.a(s(), this.app, this.activity);
    localahgq.dnt();
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", 0);
    localBundle.putString("uin", this.friendUin);
    localBundle.putString("uinname", aqgv.D(this.app, this.friendUin));
    localahgq.H(ahgg.a.R.intValue(), localBundle);
  }
  
  private Intent s()
  {
    Intent localIntent = new Intent();
    Object localObject = this.jumpUrl;
    localObject = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(97).a(acfp.m(2131701988) + this.content).a("web", (String)localObject, (String)localObject, (String)localObject, (String)localObject).a();
    anqv localanqv = anrd.a(27);
    localanqv.dMi = 1;
    localanqv.a(new StructMsgItemTitle(this.content));
    localanqv.a(new anux(String.valueOf(this.timestamp)));
    localanqv.a(new ansk(1, this.app.getCurrentAccountUin(), ""));
    localanqv.a(new ansk(1, this.friendUin, ""));
    ((AbsShareMsg)localObject).addItem(localanqv);
    ((AbsShareMsg)localObject).mCompatibleText = acfp.m(2131701987);
    localIntent.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("uin", this.friendUin);
    localIntent.putExtra("emoInputType", 2);
    anot.a(this.app, "dc00898", "", "", "0X8007AD9", "0X8007AD9", 1, 0, "", "", "", "");
    return localIntent;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = this.activity.getIntent();
    this.friendUin = paramBundle.getStringExtra("friend_uin");
    this.content = paramBundle.getStringExtra("content");
    this.timestamp = paramBundle.getLongExtra("timestamp", System.currentTimeMillis());
    this.jumpUrl = paramBundle.getStringExtra("jumpUrl");
    bYd();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.activity = getActivity();
    if ((getActivity().getAppInterface() instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)getActivity().getAppInterface());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriendShareFragment", 0, "onWindowFocusChanged: isFocused=" + paramBoolean);
    }
    if (paramBoolean) {
      this.activity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendShareFragment
 * JD-Core Version:    0.7.0.1
 */