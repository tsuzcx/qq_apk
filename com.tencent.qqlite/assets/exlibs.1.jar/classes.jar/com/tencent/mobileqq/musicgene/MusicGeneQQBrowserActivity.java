package com.tencent.mobileqq.musicgene;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import dyu;

public class MusicGeneQQBrowserActivity
  extends QQBrowserActivity
{
  private static final String jdField_a_of_type_JavaLangString = MusicGeneQQBrowserActivity.class.getSimpleName();
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dyu(this);
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    paramString6 = new AbsShareMsg.Builder(StructMsgForAudioShare.class).c(2).a("最近在听 的分享").a();
    paramString6.mContentSrc = paramString3;
    paramString6.mContentTitle = paramString5;
    paramString6.mContentCover = paramString1;
    paramString6.mContentSummary = paramString4;
    paramString6.mMsgUrl = paramString2;
    paramString6.mSourceName = "QQ音乐";
    paramString6.mSourceAction = "app";
    paramString6.mSourceAppid = paramLong;
    paramString2 = StructMsgElementFactory.a(2);
    paramString2.a(paramString1, paramString5, paramString4);
    paramString6.addItem(paramString2);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 11);
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.putInt("req_type", 2);
    }
    for (;;)
    {
      paramString1.putString("app_name", "最近在听");
      paramString1.putString("detail_url", paramString6.mMsgUrl);
      paramString1.putString("audio_url", paramString6.mContentSrc);
      paramString1.putString("image_url_remote", paramString6.mContentCover);
      paramString1.putString("title", paramString6.mContentTitle);
      paramString1.putString("desc", paramString6.mContentSummary);
      paramString1.putString("struct_share_key_source_icon", paramString6.mSourceIcon);
      paramString1.putString("struct_share_key_source_action", paramString6.mSourceAction);
      paramString1.putString("struct_share_key_source_a_action_data", paramString6.mSource_A_ActionData);
      paramString1.putLong("req_share_id", paramString6.mSourceAppid);
      paramString1.putString("brief_key", paramString6.mMsgBrief);
      paramString1.putBoolean("k_send", false);
      paramString1.putBoolean("k_qzone", false);
      paramString1.putBoolean("k_favorites", false);
      paramString1.putBoolean("k_dataline", false);
      paramString2 = new Intent(this, ForwardRecentActivity.class);
      paramString2.putExtra("refuse_show_share_result_dialog", true);
      paramString2.putExtras(paramString1);
      super.startActivity(paramString2);
      return;
      paramString1.putInt("req_type", 1);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.a(false);
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      u();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnStart()
  {
    try
    {
      super.doOnStart();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("BROAD_CAST_SHARE_MUSIC_GENE");
      localIntentFilter.addAction("BROAD_CAST_SHARE_SONG");
      localIntentFilter.addAction("BROAD_CAST_UPDATE_TITLE");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.music.data.permission", null);
      return;
    }
    catch (Exception localException)
    {
      Log.e(jdField_a_of_type_JavaLangString, localException.getMessage());
    }
  }
  
  protected void doOnStop()
  {
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      super.doOnStop();
      return;
    }
    catch (Exception localException)
    {
      Log.e(jdField_a_of_type_JavaLangString, localException.getMessage());
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */