package com.tencent.mobileqq.teamwork;

import ahgq;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import anre;
import anzo;
import aobw;
import aoiz;
import aolf;
import aqgz;
import aqhu;
import arhz;
import avpw;
import avpw.d;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import svi;

public class TeamWorkForceShare
  implements DialogInterface.OnCancelListener, anzo, ShareActionSheet.OnItemClickListener
{
  private static final String TAG = TeamWorkForceShare.class.getSimpleName();
  private String Qt;
  private arhz a;
  private WebViewPlugin b;
  private String bNX;
  private ShareActionSheet f;
  private Activity mActivity;
  private AppInterface mApp;
  private String mImageUrl;
  
  public TeamWorkForceShare(WebViewPlugin paramWebViewPlugin, JSONObject paramJSONObject)
  {
    this.b = paramWebViewPlugin;
    this.mApp = paramWebViewPlugin.mRuntime.a();
    this.mActivity = paramWebViewPlugin.mRuntime.getActivity();
    this.mImageUrl = paramJSONObject.optString("img_url");
    this.bNX = paramJSONObject.optString("callback");
  }
  
  private void dUg()
  {
    ThreadManager.post(new ImageRequestTask(this.mImageUrl, this), 8, null, true);
  }
  
  public void ag(Bitmap paramBitmap)
  {
    this.mActivity.runOnUiThread(new TeamWorkForceShare.1(this, paramBitmap));
  }
  
  public void azD()
  {
    this.a = new arhz(this.mActivity);
    this.a.show();
    dUg();
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> gq()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> gr()
  {
    return new ArrayList();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.b.onActivityResult(new Intent(), (byte)17, -1);
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (this.f.isShowing()) {
      this.f.dismiss();
    }
    int i = paramActionSheetItem.action;
    QLog.d(TAG, 1, "action = " + paramActionSheetItem.action);
    Object localObject;
    switch (i)
    {
    default: 
      return;
    case 72: 
      paramShareActionSheet = new Bundle();
      paramShareActionSheet.putInt("key_req", ForwardRecentActivity.bGS);
      paramShareActionSheet.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      paramShareActionSheet.putString("key_direct_show_uin", paramActionSheetItem.uin);
      this.b.callJs(this.bNX, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramActionSheetItem = ((QQBrowserActivity)this.mActivity).c();
      if (paramActionSheetItem == null)
      {
        QLog.d(TAG, 1, "fragment == null");
        return;
      }
      localObject = paramActionSheetItem.b();
      if (localObject == null)
      {
        QLog.d(TAG, 1, "share == null");
        return;
      }
      paramActionSheetItem = new Bundle();
      paramActionSheetItem.putBoolean("key_flag_from_plugin", true);
      paramActionSheetItem.putString("pluginName", "web_share");
      paramActionSheetItem.putString("struct_share_key_source_icon", aobw.cjU);
      paramActionSheetItem.putString("app_name", ((svi)localObject).nQ());
      paramActionSheetItem.putString("struct_share_key_source_action", "web");
      paramActionSheetItem.putString("struct_share_key_source_url", aobw.cjS);
      String str = ((svi)localObject).getShareTitle();
      paramActionSheetItem.putString("detail_url", ((svi)localObject).getShareUrl());
      paramActionSheetItem.putString("title", str);
      paramActionSheetItem.putString("desc", ((svi)localObject).nr());
      paramActionSheetItem.putString("struct_share_key_content_action", "web");
      paramActionSheetItem.putInt("forward_type", 1001);
      paramActionSheetItem.putString("image_url_remote", ((svi)localObject).nP());
      paramActionSheetItem.putInt("emoInputType", 2);
      QLog.d(TAG, 1, "title = " + str + ", desc = " + ((svi)localObject).nr() + ", url = " + ((svi)localObject).getShareUrl());
      paramActionSheetItem.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      paramActionSheetItem.putBoolean("k_back", true);
      paramActionSheetItem.putString("brief_key", this.mActivity.getString(2131698632, new Object[] { str }));
      paramActionSheetItem.putByteArray("stuctmsg_bytes", anre.a(paramActionSheetItem).getBytes());
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramActionSheetItem);
      ((Intent)localObject).putExtras(paramShareActionSheet);
      ahgq.a(this.mActivity, (Intent)localObject, ForwardRecentTranslucentActivity.class, 34322, -1, "");
      return;
    case 2: 
      this.b.callJs(this.bNX, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramActionSheetItem = ((QQBrowserActivity)this.mActivity).c();
      if (paramActionSheetItem == null)
      {
        QLog.d(TAG, 1, "fragment == null");
        return;
      }
      paramShareActionSheet = paramActionSheetItem.b();
      if (paramShareActionSheet == null)
      {
        QLog.d(TAG, 1, "share == null");
        return;
      }
      paramActionSheetItem = new Bundle();
      paramActionSheetItem.putBoolean("key_flag_from_plugin", true);
      paramActionSheetItem.putString("pluginName", "web_share");
      paramActionSheetItem.putString("struct_share_key_source_icon", aobw.cjU);
      paramActionSheetItem.putString("app_name", paramShareActionSheet.nQ());
      paramActionSheetItem.putString("struct_share_key_source_action", "web");
      paramActionSheetItem.putString("struct_share_key_source_url", aobw.cjS);
      localObject = paramShareActionSheet.getShareTitle();
      paramActionSheetItem.putString("detail_url", paramShareActionSheet.getShareUrl());
      paramActionSheetItem.putString("title", (String)localObject);
      paramActionSheetItem.putString("desc", paramShareActionSheet.nr());
      paramActionSheetItem.putString("struct_share_key_content_action", "web");
      paramActionSheetItem.putInt("forward_type", 1001);
      paramActionSheetItem.putString("image_url_remote", paramShareActionSheet.nP());
      paramActionSheetItem.putInt("emoInputType", 2);
      QLog.d(TAG, 1, "title = " + (String)localObject + ", desc = " + paramShareActionSheet.nr() + ", url = " + paramShareActionSheet.getShareUrl());
      paramActionSheetItem.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      paramActionSheetItem.putBoolean("k_back", true);
      paramActionSheetItem.putString("brief_key", this.mActivity.getString(2131698632, new Object[] { localObject }));
      paramActionSheetItem.putByteArray("stuctmsg_bytes", anre.a(paramActionSheetItem).getBytes());
      paramShareActionSheet = new Intent();
      paramShareActionSheet.putExtras(paramActionSheetItem);
      ahgq.f(this.mActivity, paramShareActionSheet, 34322);
      return;
    case 3: 
      this.b.callJs(this.bNX, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
      paramActionSheetItem = aoiz.getFilePath(this.mImageUrl);
      paramShareActionSheet = avpw.d.a();
      if (this.mApp != null)
      {
        paramShareActionSheet.cMP = this.mApp.getAccount();
        paramShareActionSheet.nickname = this.mApp.getDisplayName(0, this.mApp.getCurrentAccountUin(), null);
      }
      avpw.a(this.mActivity, paramShareActionSheet, paramActionSheetItem, BaseApplication.getContext().getString(2131693309), "", 34356);
      return;
    }
    boolean bool;
    if (i == 9)
    {
      bool = true;
      if (!bool) {
        break label1171;
      }
    }
    label1171:
    for (i = 3;; i = 4)
    {
      if (WXShareHelper.a().isWXinstalled()) {
        break label1176;
      }
      QQToast.a(this.mActivity, 2131721935, 1).show();
      QLog.d(TAG, 1, "wx not installed");
      this.b.callJs(this.bNX, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), "wx not installed" }) });
      return;
      bool = false;
      break;
    }
    label1176:
    if (!WXShareHelper.a().isWXsupportApi())
    {
      QQToast.a(this.mActivity, 2131721936, 1).show();
      QLog.d(TAG, 1, "wx version too low");
      this.b.callJs(this.bNX, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(2), "wx version too low" }) });
      return;
    }
    this.b.callJs(this.bNX, new String[] { String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), "ok" }) });
    ThreadManager.postImmediately(new TeamWorkForceShare.2(this, bool), null, true);
  }
  
  public class ImageRequestTask
    implements Runnable
  {
    private anzo a;
    private String mImageUrl;
    
    public ImageRequestTask(String paramString, anzo paramanzo)
    {
      this.mImageUrl = paramString;
      this.a = paramanzo;
    }
    
    /* Error */
    private void bdl()
    {
      // Byte code:
      //   0: new 38	aolf
      //   3: dup
      //   4: invokespecial 39	aolf:<init>	()V
      //   7: astore_3
      //   8: new 41	aobg
      //   11: dup
      //   12: aload_0
      //   13: invokespecial 44	aobg:<init>	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask;)V
      //   16: astore 4
      //   18: new 46	com/tencent/image/DownloadParams
      //   21: dup
      //   22: invokespecial 47	com/tencent/image/DownloadParams:<init>	()V
      //   25: astore 5
      //   27: aload 5
      //   29: new 49	java/net/URL
      //   32: dup
      //   33: aload_0
      //   34: getfield 24	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:mImageUrl	Ljava/lang/String;
      //   37: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
      //   40: putfield 56	com/tencent/image/DownloadParams:url	Ljava/net/URL;
      //   43: aload 5
      //   45: aload_0
      //   46: getfield 24	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:mImageUrl	Ljava/lang/String;
      //   49: putfield 59	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
      //   52: new 61	java/io/FileOutputStream
      //   55: dup
      //   56: aload_0
      //   57: getfield 24	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:mImageUrl	Ljava/lang/String;
      //   60: invokestatic 67	aoiz:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
      //   63: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   66: astore_2
      //   67: aload_2
      //   68: astore_1
      //   69: aload_3
      //   70: aload_2
      //   71: aload 5
      //   73: aload 4
      //   75: invokevirtual 71	aolf:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
      //   78: pop
      //   79: aload_2
      //   80: ifnull +7 -> 87
      //   83: aload_2
      //   84: invokevirtual 74	java/io/FileOutputStream:close	()V
      //   87: return
      //   88: astore_1
      //   89: aload_1
      //   90: invokevirtual 77	java/lang/Exception:printStackTrace	()V
      //   93: return
      //   94: astore_3
      //   95: aconst_null
      //   96: astore_2
      //   97: aload_2
      //   98: astore_1
      //   99: aload_3
      //   100: invokevirtual 77	java/lang/Exception:printStackTrace	()V
      //   103: aload_2
      //   104: astore_1
      //   105: invokestatic 81	com/tencent/mobileqq/teamwork/TeamWorkForceShare:access$100	()Ljava/lang/String;
      //   108: iconst_1
      //   109: new 83	java/lang/StringBuilder
      //   112: dup
      //   113: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   116: ldc 86
      //   118: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   121: aload_3
      //   122: invokevirtual 93	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   125: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   128: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   131: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   134: aload_2
      //   135: astore_1
      //   136: aload_0
      //   137: getfield 19	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask:this$0	Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare;
      //   140: invokestatic 105	com/tencent/mobileqq/teamwork/TeamWorkForceShare:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare;)Landroid/app/Activity;
      //   143: new 107	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$2
      //   146: dup
      //   147: aload_0
      //   148: invokespecial 108	com/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask$2:<init>	(Lcom/tencent/mobileqq/teamwork/TeamWorkForceShare$ImageRequestTask;)V
      //   151: invokevirtual 114	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   154: aload_2
      //   155: ifnull -68 -> 87
      //   158: aload_2
      //   159: invokevirtual 74	java/io/FileOutputStream:close	()V
      //   162: return
      //   163: astore_1
      //   164: aload_1
      //   165: invokevirtual 77	java/lang/Exception:printStackTrace	()V
      //   168: return
      //   169: astore_2
      //   170: aconst_null
      //   171: astore_1
      //   172: aload_1
      //   173: ifnull +7 -> 180
      //   176: aload_1
      //   177: invokevirtual 74	java/io/FileOutputStream:close	()V
      //   180: aload_2
      //   181: athrow
      //   182: astore_1
      //   183: aload_1
      //   184: invokevirtual 77	java/lang/Exception:printStackTrace	()V
      //   187: goto -7 -> 180
      //   190: astore_2
      //   191: goto -19 -> 172
      //   194: astore_3
      //   195: goto -98 -> 97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	198	0	this	ImageRequestTask
      //   68	1	1	localFileOutputStream1	java.io.FileOutputStream
      //   88	2	1	localException1	java.lang.Exception
      //   98	38	1	localFileOutputStream2	java.io.FileOutputStream
      //   163	2	1	localException2	java.lang.Exception
      //   171	6	1	localObject1	Object
      //   182	2	1	localException3	java.lang.Exception
      //   66	93	2	localFileOutputStream3	java.io.FileOutputStream
      //   169	12	2	localObject2	Object
      //   190	1	2	localObject3	Object
      //   7	63	3	localaolf	aolf
      //   94	28	3	localException4	java.lang.Exception
      //   194	1	3	localException5	java.lang.Exception
      //   16	58	4	localaobg	aobg
      //   25	47	5	localDownloadParams	com.tencent.image.DownloadParams
      // Exception table:
      //   from	to	target	type
      //   83	87	88	java/lang/Exception
      //   18	67	94	java/lang/Exception
      //   158	162	163	java/lang/Exception
      //   18	67	169	finally
      //   176	180	182	java/lang/Exception
      //   69	79	190	finally
      //   99	103	190	finally
      //   105	134	190	finally
      //   136	154	190	finally
      //   69	79	194	java/lang/Exception
    }
    
    private boolean bs(boolean paramBoolean)
    {
      Object localObject1 = null;
      if (!paramBoolean) {
        return false;
      }
      Object localObject2 = aolf.getFile(this.mImageUrl);
      if (localObject2 != null)
      {
        QLog.d(TeamWorkForceShare.access$100(), 1, "file exist");
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        try
        {
          aqhu.d(((File)localObject2).getAbsolutePath(), localOptions);
          if (localOptions.outWidth > aqgz.hK()) {
            localOptions.inSampleSize = ((int)(aqgz.hK() / localOptions.outWidth));
          }
          localOptions.inJustDecodeBounds = false;
          try
          {
            localObject2 = aqhu.d(((File)localObject2).getAbsolutePath(), localOptions);
            localObject1 = localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            for (;;)
            {
              localOutOfMemoryError1.printStackTrace();
              QLog.d(TeamWorkForceShare.access$100(), 1, "oom, url = " + this.mImageUrl);
            }
          }
          if (this.a != null) {
            this.a.ag(localObject1);
          }
          return true;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            localOutOfMemoryError2.printStackTrace();
          }
        }
      }
      if (paramBoolean)
      {
        QLog.d(TeamWorkForceShare.access$100(), 1, "file not exist, url = " + this.mImageUrl);
        if (this.a != null) {
          this.a.ag(null);
        }
      }
      return false;
    }
    
    public void run()
    {
      if (!bs(false)) {
        bdl();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare
 * JD-Core Version:    0.7.0.1
 */