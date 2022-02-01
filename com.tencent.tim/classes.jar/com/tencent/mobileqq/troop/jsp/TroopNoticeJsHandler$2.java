package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import apmj;
import avpg;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;
import ndi;

public final class TroopNoticeJsHandler$2
  implements Runnable
{
  public TroopNoticeJsHandler$2(Activity paramActivity, int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, boolean[] paramArrayOfBoolean, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArrayList paramArrayList3, ArrayList paramArrayList4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.val$activity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", this.val$index);
    localBundle.putStringArrayList("seqNum", this.Ca);
    if (this.Cb != null) {
      localBundle.putStringArrayList("descs", this.Cb);
    }
    if (this.x != null) {
      localBundle.putBooleanArray("likes", this.x);
    }
    if ((this.b != null) && (this.b.isReport)) {
      localBundle.putString("PublicAccountShowPictureReport", this.b.toString());
    }
    if (this.Cc != null) {
      localBundle.putStringArrayList("origin_list", this.Cc);
    }
    if (this.Cd != null) {
      localBundle.putStringArrayList("origin_size_list", this.Cd);
    }
    localBundle.putBoolean("needBottomBar", this.cRl);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", this.cRm);
    localBundle.putBoolean("is_need_to_aio", this.cRn);
    if (this.d != null)
    {
      localBundle.putBoolean("is_grid_image_report", true);
      ndi.a(this.d, "", this.val$index, localBundle);
    }
    if (!TextUtils.isEmpty(this.cqa)) {
      localBundle.putString("src_id", this.cqa);
    }
    if (!TextUtils.isEmpty(this.SQ)) {
      localBundle.putString("str_data_extra", this.SQ);
    }
    localIntent.putExtras(localBundle);
    if ((this.Ca != null) && (this.Ca.size() > apmj.access$000()))
    {
      avpg.b(localIntent, this.val$activity);
      localIntent = new Intent(this.val$activity, TroopAvatarWallPreviewActivity.class);
      localIntent.putExtra("save_intent_to_file", true);
      this.val$activity.startActivityForResult(localIntent, this.dUX);
      return;
    }
    this.val$activity.startActivityForResult(localIntent, this.dUX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.2
 * JD-Core Version:    0.7.0.1
 */