package com.tencent.open.downloadnew.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aroi;
import arub;
import arxn;
import aryv;
import aryy;
import arzk;
import asad;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.downloadnew.DownloadInfo;

class DownloadReceiver$1
  implements Runnable
{
  DownloadReceiver$1(DownloadReceiver paramDownloadReceiver, String paramString1, String paramString2, NoticeParam paramNoticeParam, String paramString3, String paramString4, Context paramContext) {}
  
  public void run()
  {
    Object localObject2 = aryy.a().c(this.val$appid);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = aryy.a().f(this.cDQ);
    }
    boolean bool;
    if (localObject1 == null) {
      if ((this.b.packName != null) && (!this.b.packName.trim().equals("")))
      {
        bool = true;
        localObject2 = new DownloadInfo(this.val$appid, this.b.cDW, this.b.packName, this.b.title, this.b.via, this.b.as, "biz_src_yyb", bool);
        if (!(asad.cDS + "." + this.cCH).equals(this.val$action)) {
          break label341;
        }
        localObject1 = aryy.a().c(this.val$appid);
        if ((localObject1 != null) && ((((DownloadInfo)localObject1).getState() == 2) || (((DownloadInfo)localObject1).getState() == 20)))
        {
          ((DownloadInfo)localObject2).setState(3);
          aryy.a().b(3, (DownloadInfo)localObject2);
        }
        aryy.a().fw(((DownloadInfo)localObject2).appId);
      }
    }
    label230:
    label253:
    do
    {
      return;
      bool = false;
      break;
      if (TextUtils.isEmpty(((DownloadInfo)localObject1).urlStr))
      {
        localObject2 = this.b.cDW;
        ((DownloadInfo)localObject1).urlStr = ((String)localObject2);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject1).packageName)) {
          break label317;
        }
        localObject2 = this.b.packName;
        ((DownloadInfo)localObject1).packageName = ((String)localObject2);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject1).via)) {
          break label325;
        }
        localObject2 = this.b.via;
        ((DownloadInfo)localObject1).via = ((String)localObject2);
        if (!TextUtils.isEmpty(((DownloadInfo)localObject1).pushTitle)) {
          break label333;
        }
      }
      for (localObject2 = this.b.title;; localObject2 = ((DownloadInfo)localObject1).pushTitle)
      {
        ((DownloadInfo)localObject1).pushTitle = ((String)localObject2);
        localObject2 = localObject1;
        break;
        localObject2 = ((DownloadInfo)localObject1).urlStr;
        break label230;
        localObject2 = ((DownloadInfo)localObject1).packageName;
        break label253;
        localObject2 = ((DownloadInfo)localObject1).via;
        break label276;
      }
      if ((asad.cDR + "." + this.cCH).equals(this.val$action))
      {
        aryy.a().b((DownloadInfo)localObject2);
        return;
      }
      if ((asad.cDT + "." + this.cCH).equals(this.val$action))
      {
        aryy.a().b((DownloadInfo)localObject2);
        return;
      }
      if ((asad.ACTION_DOWNLOAD_COMPLETE + "." + this.cCH).equals(this.val$action))
      {
        arxn.d(this.val$context, aryy.a().qz(this.val$appid), aryy.a().qK(this.val$appid), ((DownloadInfo)localObject2).qH("big_brother_ref_source_key"));
        arub.a().a(100, (DownloadInfo)localObject2);
        return;
      }
    } while (!(asad.cDV + "." + this.cCH).equals(this.val$action));
    label276:
    label317:
    label325:
    label333:
    label341:
    if ((arzk.a().aHy()) && (localObject2 != null) && (((DownloadInfo)localObject2).downloadType == 1))
    {
      if (this.b.as == null) {}
      for (localObject1 = new Bundle();; localObject1 = this.b.as.getExtras())
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Bundle();
        }
        ((Bundle)localObject3).putString(aryv.PARAM_SNG_APPID, ((DownloadInfo)localObject2).appId);
        ((Bundle)localObject3).putString(aryv.PARAM_TASK_APPID, ((DownloadInfo)localObject2).cDG);
        ((Bundle)localObject3).putString(aryv.PARAM_TASK_APK_ID, ((DownloadInfo)localObject2).cCL);
        ((Bundle)localObject3).putString(aryv.PARAM_TASK_PACKNAME, ((DownloadInfo)localObject2).packageName);
        ((Bundle)localObject3).putInt(aryv.PARAM_TASK_VERSION, ((DownloadInfo)localObject2).versionCode);
        arzk.a().a(this.val$context.getApplicationContext(), (Bundle)localObject3, true, true);
        return;
      }
    }
    Object localObject3 = new Intent();
    if (this.b.as == null) {}
    for (localObject1 = new Bundle();; localObject1 = this.b.as.getExtras())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Intent)localObject3).putExtras((Bundle)localObject2);
      ((Intent)localObject3).setClass(aroi.a().getContext(), QZoneAppListActivity.class);
      ((Intent)localObject3).putExtra("goto_type", 2);
      ((Intent)localObject3).addFlags(872415232);
      this.val$context.startActivity((Intent)localObject3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadReceiver.1
 * JD-Core Version:    0.7.0.1
 */