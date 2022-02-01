import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.2;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.8;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.DragGallery;
import com.tencent.richmediabrowser.view.page.Gallery.LayoutParams;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class amem
  extends amdo
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public TextView Bu;
  public TextView Bv;
  private View Gv;
  public View Gw;
  public TextView Kl;
  public TextView Ko;
  private arlq a;
  public ImageButton aE;
  public long aiz;
  public ImageButton am;
  public amdc b;
  private String bZN = "";
  private boolean cCm;
  public ImageView closeBtn;
  private long currentPositionMs = -1L;
  public RelativeLayout hP;
  public RelativeLayout hQ;
  public ImageView jO;
  public LinearLayout kh;
  public SeekBar l;
  public SeekBar m;
  private ImageView mCenterPlayBtn;
  private LinearLayout mErrLayout;
  public TextView mTextView;
  public BaseVideoView mVideoView;
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> zk = new ArrayList();
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> zl = new ArrayList();
  
  public amem(Activity paramActivity, amdc paramamdc)
  {
    super(paramActivity, paramamdc);
    this.b = paramamdc;
  }
  
  private void OX(boolean paramBoolean)
  {
    View localView;
    if (this.Gv != null)
    {
      localView = this.Gv;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private VideoPlayParam a(ztn paramztn)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    MessageForShortVideo localMessageForShortVideo = paramztn.l;
    localVideoPlayParam.mSceneId = 101;
    localVideoPlayParam.mSceneName = (allh.eO(101) + "_FulScr");
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (localAIOVideoData.mBusiType == 1))
    {
      localVideoPlayParam.mSceneId = 100;
      localVideoPlayParam.mSceneName = (allh.eO(100) + "_FulScr");
    }
    if (this.b != null) {
      localVideoPlayParam.mIsMute = this.b.cD(paramztn.id);
    }
    if (!localVideoPlayParam.mIsMute) {
      acV();
    }
    if (paramztn.btf)
    {
      localVideoPlayParam.mUrls = paramztn.cJ;
      localVideoPlayParam.mSavePath = paramztn.playUrl;
      if (paramztn.btf) {
        break label332;
      }
    }
    label332:
    for (boolean bool = true;; bool = false)
    {
      localVideoPlayParam.mIsLocal = bool;
      if (localMessageForShortVideo != null)
      {
        long l1 = localMessageForShortVideo.videoFileTime * 1000;
        localVideoPlayParam.mVideoFileTimeMs = l1;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo, videoDuration = " + l1);
        this.Bu.setText(ShortVideoUtils.stringForTime(l1));
        this.Bv.setText(ShortVideoUtils.stringForTime(0L));
        localVideoPlayParam.mFileID = (localMessageForShortVideo.md5 + localMessageForShortVideo.uniseq);
        localVideoPlayParam.mFileSize = localMessageForShortVideo.videoFileSize;
      }
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      a(localVideoPlayParam);
      return localVideoPlayParam;
      localVideoPlayParam.mVideoPath = paramztn.playUrl;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    String str1 = null;
    if (paramInt1 == 2)
    {
      ztn localztn = this.b.a(a());
      if ((localztn != null) && (localztn.cJ != null) && (!aqmr.isEmpty(localztn.mDomain)))
      {
        String[] arrayOfString = localztn.cJ;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (!aqmr.isEmpty(str2)) {
            aopd.a().X(localztn.mDomain, aopd.getHostFromUrl(str2), 1005);
          }
          i += 1;
        }
        amdm.a().clearCache();
      }
    }
    if (paramInt1 == 1) {
      str1 = this.mContext.getString(2131720258);
    }
    if (paramInt2 == 14011001)
    {
      str1 = this.mContext.getString(2131718875);
      this.b.ao(5002, 0L);
    }
    alli.a(paramInt2, paramVideoPlayParam);
    ThreadManager.getUIHandler().post(new AIOVideoView.2(this, str1));
  }
  
  private void a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    HashMap localHashMap;
    if (!this.b.cC(paramLong))
    {
      long l1 = this.b.R(paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "reportForVideoStartPlayCost, id:" + paramLong + ", clickBubbleTime = " + l1);
      }
      if ((this.b != null) && (l1 > 0L))
      {
        paramLong = System.currentTimeMillis() - l1;
        localHashMap = new HashMap();
        localHashMap.put("timeCost", String.valueOf(paramLong));
        localHashMap.put("busiType", paramVideoPlayParam.mSceneName);
        if (!paramVideoPlayParam.mIsLocal) {
          break label208;
        }
      }
    }
    label208:
    for (String str = "actVideoFSPlayCost";; str = "acVideoFSPlayCost_Online")
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "report video start play cost , reportName = " + str + " , timeCost = " + paramLong + " , busiType = " + paramVideoPlayParam.mSceneName);
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str, true, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    int j = 0;
    File localFile = new amct().a(paramAIOVideoData, 1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
    this.zk.clear();
    this.zl.clear();
    long l1;
    int i;
    if ((localFile != null) && (localFile.exists()))
    {
      l1 = localFile.length();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showActionSheetForShortVideo, file.getPath()=" + localFile.getPath() + ", mTransferredSize = " + l1 + ", data.size = " + paramAIOVideoData.size);
      if (paramAIOVideoData.mBusiType == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      if ((paramAIOVideoData.mBusiType != 1) || (i == 0)) {
        j = 1;
      }
      if (j != 0) {
        aqly.a(2, this.zk);
      }
      if ((VersionUtils.isIceScreamSandwich()) && ((paramAIOVideoData.mBusiType != 1) || (i == 0))) {
        aqly.a(39, this.zl);
      }
      if (i == 0)
      {
        aqly.a(6, this.zl);
        aqly.a(3, this.zk);
        aqly.a(27, this.zk);
      }
      if ((amcj.a().avF()) && (!TextUtils.isEmpty(amcj.a().yO())) && (amcj.a().Iz() != -1)) {
        aqly.a(54, this.zl);
      }
      if (i == 0) {
        aqly.a(64, this.zk);
      }
      a(paramAIOVideoData, localFile, paramInt, localRichMediaBrowserInfo);
      if (this.mContext != null) {
        this.mContext.getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
      }
      this.d.setActionSheetItems(this.zk, this.zl);
      if (j != 0) {
        c(paramAIOVideoData);
      }
      this.d.show();
      return;
      if (l1 < paramAIOVideoData.size)
      {
        i = 1;
        continue;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.msgId, paramAIOVideoData.subId, amcj.a().Iz());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.b.getSelectedItem() != null)
        {
          Object localObject = this.b.getSelectedItem().baseData;
          if ((localObject instanceof AIOVideoData))
          {
            localObject = (AIOVideoData)localObject;
            int i = ((AIOVideoData)localObject).redBagType;
            AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
            if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOVideoData)localObject).senderUin)))
            {
              paramAIOVideoData.putExtra("param_key_redbag_type", i);
              paramAIOVideoData.putExtra("param_key_redbag_video_id", ((AIOVideoData)localObject).shortVideoId);
              paramAIOVideoData.putExtra("from_session_uin", ((AIOVideoData)localObject).friendUin);
            }
            if (((AIOVideoData)localObject).specialVideoType == 2) {
              paramAIOVideoData.putExtra("special_video_type", ((AIOVideoData)localObject).specialVideoType);
            }
            if (!TextUtils.isEmpty(((AIOVideoData)localObject).templateId))
            {
              paramAIOVideoData.putExtra("widgetinfo", ((AIOVideoData)localObject).templateId);
              paramAIOVideoData.putExtra("key_camera_material_name", ((AIOVideoData)localObject).templateName);
            }
          }
        }
        if (paramInt != 72) {
          break label310;
        }
        paramAIOVideoData.putExtra("key_req", ForwardRecentActivity.bGS);
        paramAIOVideoData.putExtra("key_direct_show_uin_type", paramActionSheetItem.uinType);
        paramAIOVideoData.putExtra("key_direct_show_uin", paramActionSheetItem.uin);
        ahgq.a(this.mContext, paramAIOVideoData, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
      }
    }
    for (;;)
    {
      if (amcj.a().avB()) {
        ajlg.report("0X8009ABC");
      }
      return;
      label310:
      ahgq.a(this.mContext, paramAIOVideoData, 100500, " biz_src_jc_video");
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new amen(this, paramVideoPlayParam);
  }
  
  private void abandonAudioFocus()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void acV()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  /* Error */
  private void af(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: ifnonnull +19 -> 26
    //   10: invokestatic 338	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   13: ifeq +12 -> 25
    //   16: ldc 196
    //   18: iconst_0
    //   19: ldc_w 694
    //   22: invokestatic 697	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: return
    //   26: invokestatic 701	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   29: invokevirtual 705	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   32: invokevirtual 708	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: astore_3
    //   36: new 439	java/io/File
    //   39: dup
    //   40: new 114	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   47: aload_3
    //   48: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 711	java/io/File:separator	Ljava/lang/String;
    //   54: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 713
    //   60: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 715	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 442	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_3
    //   78: invokevirtual 718	java/io/File:createNewFile	()Z
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 708	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: putfield 70	amem:bZN	Ljava/lang/String;
    //   90: invokestatic 338	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   93: ifeq +32 -> 125
    //   96: ldc 196
    //   98: iconst_0
    //   99: new 114	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 720
    //   109: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 70	amem:bZN	Ljava/lang/String;
    //   116: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 697	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 70	amem:bZN	Ljava/lang/String;
    //   130: invokestatic 726	ahbj:f	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   133: pop
    //   134: new 59	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 62	java/util/ArrayList:<init>	()V
    //   141: astore 6
    //   143: new 728	android/util/SparseArray
    //   146: dup
    //   147: iconst_2
    //   148: invokespecial 730	android/util/SparseArray:<init>	(I)V
    //   151: astore 7
    //   153: aload_1
    //   154: iconst_1
    //   155: iconst_3
    //   156: aload 7
    //   158: invokestatic 735	rvx:a	(Landroid/graphics/Bitmap;ZILandroid/util/SparseArray;)I
    //   161: istore_2
    //   162: iload_2
    //   163: invokestatic 739	rvx:fa	(I)Z
    //   166: ifeq +98 -> 264
    //   169: invokestatic 338	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   172: ifeq +12 -> 184
    //   175: ldc 196
    //   177: iconst_0
    //   178: ldc_w 741
    //   181: invokestatic 697	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 7
    //   186: iconst_1
    //   187: invokevirtual 745	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   190: astore_1
    //   191: aload_1
    //   192: instanceof 747
    //   195: ifeq +242 -> 437
    //   198: aload_1
    //   199: checkcast 747	android/util/Pair
    //   202: astore_3
    //   203: new 749	org/json/JSONObject
    //   206: dup
    //   207: invokespecial 750	org/json/JSONObject:<init>	()V
    //   210: astore_1
    //   211: aload_1
    //   212: ldc_w 752
    //   215: aload_3
    //   216: getfield 756	android/util/Pair:second	Ljava/lang/Object;
    //   219: invokestatic 759	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokevirtual 762	java/lang/String:trim	()Ljava/lang/String;
    //   225: invokevirtual 765	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload_1
    //   230: ldc_w 767
    //   233: aload_3
    //   234: getfield 770	android/util/Pair:first	Ljava/lang/Object;
    //   237: invokestatic 759	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 762	java/lang/String:trim	()Ljava/lang/String;
    //   243: invokevirtual 765	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload_1
    //   248: ifnonnull +136 -> 384
    //   251: ldc 68
    //   253: astore_1
    //   254: bipush 126
    //   256: aload 6
    //   258: aload_1
    //   259: iconst_0
    //   260: invokestatic 773	aqly:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   263: pop
    //   264: iload_2
    //   265: invokestatic 776	rvx:fb	(I)Z
    //   268: ifeq +74 -> 342
    //   271: invokestatic 338	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   274: ifeq +12 -> 286
    //   277: ldc 196
    //   279: iconst_0
    //   280: ldc_w 778
    //   283: invokestatic 697	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload 7
    //   288: iconst_2
    //   289: invokevirtual 745	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   292: astore_3
    //   293: aload 5
    //   295: astore_1
    //   296: aload_3
    //   297: instanceof 356
    //   300: ifeq +25 -> 325
    //   303: aload_3
    //   304: checkcast 356	java/lang/String
    //   307: astore_3
    //   308: new 749	org/json/JSONObject
    //   311: dup
    //   312: invokespecial 750	org/json/JSONObject:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: ldc_w 780
    //   320: aload_3
    //   321: invokevirtual 765	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload_1
    //   326: ifnonnull +77 -> 403
    //   329: ldc 68
    //   331: astore_1
    //   332: bipush 127
    //   334: aload 6
    //   336: aload_1
    //   337: iconst_0
    //   338: invokestatic 773	aqly:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   341: pop
    //   342: aload 6
    //   344: invokevirtual 782	java/util/ArrayList:isEmpty	()Z
    //   347: ifeq +64 -> 411
    //   350: invokestatic 338	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   353: ifeq -328 -> 25
    //   356: ldc 196
    //   358: iconst_0
    //   359: ldc_w 784
    //   362: invokestatic 697	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: return
    //   366: astore_3
    //   367: aload_3
    //   368: invokevirtual 787	java/io/IOException:printStackTrace	()V
    //   371: goto -237 -> 134
    //   374: astore_3
    //   375: aconst_null
    //   376: astore_1
    //   377: aload_3
    //   378: invokevirtual 788	org/json/JSONException:printStackTrace	()V
    //   381: goto -134 -> 247
    //   384: aload_1
    //   385: invokevirtual 789	org/json/JSONObject:toString	()Ljava/lang/String;
    //   388: astore_1
    //   389: goto -135 -> 254
    //   392: astore_3
    //   393: aload 4
    //   395: astore_1
    //   396: aload_3
    //   397: invokevirtual 788	org/json/JSONException:printStackTrace	()V
    //   400: goto -75 -> 325
    //   403: aload_1
    //   404: invokevirtual 789	org/json/JSONObject:toString	()Ljava/lang/String;
    //   407: astore_1
    //   408: goto -76 -> 332
    //   411: invokestatic 313	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   414: new 791	com/tencent/mobileqq/richmediabrowser/view/AIOVideoView$11
    //   417: dup
    //   418: aload_0
    //   419: aload 6
    //   421: invokespecial 794	com/tencent/mobileqq/richmediabrowser/view/AIOVideoView$11:<init>	(Lamem;Ljava/util/ArrayList;)V
    //   424: invokevirtual 324	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   427: pop
    //   428: return
    //   429: astore_3
    //   430: goto -34 -> 396
    //   433: astore_3
    //   434: goto -57 -> 377
    //   437: aconst_null
    //   438: astore_1
    //   439: goto -192 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	amem
    //   0	442	1	paramBitmap	Bitmap
    //   161	104	2	i	int
    //   35	286	3	localObject1	Object
    //   366	2	3	localIOException	java.io.IOException
    //   374	4	3	localJSONException1	org.json.JSONException
    //   392	5	3	localJSONException2	org.json.JSONException
    //   429	1	3	localJSONException3	org.json.JSONException
    //   433	1	3	localJSONException4	org.json.JSONException
    //   1	393	4	localObject2	Object
    //   4	290	5	localObject3	Object
    //   141	279	6	localArrayList	ArrayList
    //   151	136	7	localSparseArray	android.util.SparseArray
    // Exception table:
    //   from	to	target	type
    //   26	82	366	java/io/IOException
    //   82	125	366	java/io/IOException
    //   125	134	366	java/io/IOException
    //   203	211	374	org/json/JSONException
    //   303	316	392	org/json/JSONException
    //   316	325	429	org/json/JSONException
    //   211	247	433	org/json/JSONException
  }
  
  private boolean ax(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (this.b.a((AIOVideoData)localRichMediaBrowserInfo.baseData) != null))
      {
        this.am.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.am.setVisibility(4);
    }
    return false;
  }
  
  private void b(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (paramAIOVideoData.videoFileStatus == 5002)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
      QQToast.a(this.mContext, 1, acfp.m(2131702194), 0).show();
      return;
    }
    if (!CheckPermission.isHasStoragePermission(this.mContext))
    {
      CheckPermission.requestStorePermission(this.mContext, null);
      return;
    }
    if (paramAIOVideoData.mBusiType == 1)
    {
      this.b.b(paramInt, paramFile);
      return;
    }
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOVideoData.size))
    {
      paramAIOVideoData = new StringBuilder().append(paramFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramFile.getAbsolutePath(), this.b.b, paramAIOVideoData, false));
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      this.b.b.sendEmptyMessage(10001);
      return;
    }
    if ((!AppNetConnInfo.isWifiConn()) && (paramAIOVideoData.size > 29360128L))
    {
      a(3, paramAIOVideoData, paramRichMediaBrowserInfo);
      return;
    }
    this.b.a(paramAIOVideoData);
    this.b.P(paramAIOVideoData.msgId, paramAIOVideoData.subId, 2);
    updateUI();
    if (this.mVideoView != null) {
      this.mVideoView.pause();
    }
    this.cCm = false;
  }
  
  private void bS(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt + " , isAutoPlay = " + paramBoolean);
    }
    this.cCm = true;
    OV(true);
    this.mErrLayout.setVisibility(8);
    this.mCenterPlayBtn.setVisibility(8);
    this.jO.setImageResource(2130847021);
    ax(true);
    Object localObject1 = this.b.getItem(paramInt);
    Object localObject2;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localObject1 = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      this.b.ld(((AIOVideoData)localObject1).msgId);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt + " , aioVideoPresenter.dealVideoAutoPlay , msgId = " + ((AIOVideoData)localObject1).msgId);
      }
      localObject2 = this.b;
      long l1 = ((AIOVideoData)localObject1).msgId;
      if (paramBoolean) {
        break label319;
      }
      paramBoolean = bool;
      ((amdc)localObject2).ay(l1, paramBoolean);
      localObject2 = this.b.a((AIOVideoData)localObject1);
      if (localObject2 != null) {
        break label324;
      }
      this.b.b((AIOVideoData)localObject1);
      this.b.P(((AIOVideoData)localObject1).msgId, ((AIOVideoData)localObject1).subId, 4);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateItemStatus VIDEO_GETTING_URL , shortVideoData.msgId = " + ((AIOVideoData)localObject1).msgId + ", shortVideoData.subId = " + ((AIOVideoData)localObject1).subId);
    }
    for (;;)
    {
      updateUI();
      return;
      label319:
      paramBoolean = false;
      break;
      label324:
      f((ztn)localObject2);
      this.b.P(((AIOVideoData)localObject1).msgId, ((AIOVideoData)localObject1).subId, 5);
    }
  }
  
  private void c(AIOVideoData paramAIOVideoData)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.msgId, paramAIOVideoData.subId, amcj.a().Iz());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.b.getSelectedItem() != null)
        {
          Object localObject = this.b.getSelectedItem().baseData;
          if ((localObject instanceof AIOVideoData))
          {
            localObject = (AIOVideoData)localObject;
            int i = ((AIOVideoData)localObject).redBagType;
            AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
            if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOVideoData)localObject).senderUin)))
            {
              paramAIOVideoData.putExtra("param_key_redbag_type", i);
              paramAIOVideoData.putExtra("param_key_redbag_video_id", ((AIOVideoData)localObject).shortVideoId);
              paramAIOVideoData.putExtra("from_session_uin", ((AIOVideoData)localObject).friendUin);
            }
            if (((AIOVideoData)localObject).specialVideoType == 2) {
              paramAIOVideoData.putExtra("special_video_type", ((AIOVideoData)localObject).specialVideoType);
            }
            if (!TextUtils.isEmpty(((AIOVideoData)localObject).templateId))
            {
              paramAIOVideoData.putExtra("widgetinfo", ((AIOVideoData)localObject).templateId);
              paramAIOVideoData.putExtra("key_camera_material_name", ((AIOVideoData)localObject).templateName);
            }
          }
        }
        this.d.setIntentForStartForwardRecentActivity(paramAIOVideoData);
      }
    }
  }
  
  private void d(AIOVideoData paramAIOVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + paramAIOVideoData.aWp), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.mContext.startActivity(localIntent);
    int i = paramAIOVideoData.istroop;
    if (i == 0)
    {
      anot.a(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      return;
    }
    if (i == 3000)
    {
      anot.a(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      return;
    }
    if (i == 1)
    {
      anot.a(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      return;
    }
    anot.a(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
  }
  
  private void dMU()
  {
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      if (this.a != null) {
        this.a.destory();
      }
      if (this.mVideoView == null) {
        break label142;
      }
    }
    label142:
    for (long l1 = this.mVideoView.getCurPlayingPos();; l1 = 0L)
    {
      this.a = new arlq(this.mContext);
      ztn localztn = this.b.a(localAIOVideoData);
      if (localztn == null) {
        break;
      }
      this.a.a(localztn, localAIOVideoData.uniseq, l1);
      this.a.aR(localAIOVideoData.aWo, localAIOVideoData.width, localAIOVideoData.height);
      if ((localAIOVideoData.width <= localAIOVideoData.height) || (this.a.q(localAIOVideoData.istroop, localAIOVideoData.width, localAIOVideoData.height))) {
        this.b.back();
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
  }
  
  private void dMX()
  {
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (!TextUtils.isEmpty(localAIOVideoData.templateId)))
    {
      aywz.aa(this.mContext, localAIOVideoData.templateId);
      anot.a(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", localAIOVideoData.templateId, "");
    }
  }
  
  private Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "drawable2Bitmap, drawable is null");
      }
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  private void e(AIOVideoData paramAIOVideoData)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.msgId, paramAIOVideoData.subId, amcj.a().Iz());
      if (localIntent != null)
      {
        aviz.a(localIntent).b(this.mContext, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        avjg.a(null, 3, 0, paramAIOVideoData.istroop);
        avjg.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
      }
    }
  }
  
  private void f(ztn paramztn)
  {
    if (paramztn == null) {}
    do
    {
      return;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo id = " + paramztn.id);
      this.b.P(paramztn.id, paramztn.subid, 5);
      this.b.n(0L, 0L, amcj.a().yO());
      paramztn = a(paramztn);
    } while (this.mVideoView == null);
    this.mVideoView.setVideoParam(paramztn);
    this.mVideoView.play();
  }
  
  private void fL(String paramString, int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "0", "0", "");
      return;
      if (paramInt == 1) {
        paramInt = 2;
      } else if (paramInt == 3000) {
        paramInt = 3;
      } else if (paramInt == 6000) {
        paramInt = 4;
      } else {
        paramInt = -1;
      }
    }
  }
  
  private void pauseVideo()
  {
    if (this.mVideoView != null) {
      this.mVideoView.pause();
    }
    abandonAudioFocus();
    updateStatus(6);
    this.b.onLoadFinish(this.b.getSelectedIndex(), true);
    OV(true);
    zA(false);
    this.hQ.setVisibility(8);
    this.mErrLayout.setVisibility(8);
    this.mCenterPlayBtn.setVisibility(0);
    this.jO.setImageResource(2130847020);
    ax(true);
    if (this.b.le(this.b.getCurrentPosition())) {
      this.b.OK(true);
    }
  }
  
  private View r(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mVideoView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "mVideoView != null, releasePlayer.");
      }
      this.mVideoView.releasePlayer(false);
    }
    paramViewGroup = this.b.getItem(paramInt);
    AIOVideoData localAIOVideoData;
    if ((paramViewGroup != null) && (paramViewGroup.baseData != null) && (paramViewGroup.baseData.getType() == 101))
    {
      localAIOVideoData = (AIOVideoData)paramViewGroup.baseData;
      if ((!(paramView instanceof RelativeLayout)) || (!(paramView.getTag() instanceof amem.a))) {
        break label389;
      }
      this.galleryView = ((RelativeLayout)paramView);
      this.mVideoView = ((amem.a)paramView.getTag()).c;
      paramView = null;
      this.mCenterPlayBtn = ((ImageView)this.galleryView.findViewById(2131373579));
      this.mCenterPlayBtn.bringToFront();
      this.mErrLayout = ((LinearLayout)this.galleryView.findViewById(2131373581));
      paramViewGroup = new amct();
      this.galleryView.setTag(2131296400, Boolean.valueOf(true));
      this.galleryView.setTag(2131296433, Boolean.valueOf(true));
      Object localObject = (URLDrawable)this.b.mActiveThumbDrawable.get(Integer.valueOf(paramInt));
      if ((localObject == null) || (paramView == null)) {
        break label490;
      }
      paramView.setCoverDrawable((Drawable)localObject);
      label226:
      paramViewGroup = "0X8009EF2";
      if (localAIOVideoData.mBusiType == 1) {
        paramViewGroup = "0X8009EF1";
      }
      this.galleryView.setContentDescription(this.mContext.getString(2131692634));
      localObject = this.b.a();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null) || (((RichMediaBrowserInfo)localObject).baseData.getType() != 101) || (((AIOVideoData)((RichMediaBrowserInfo)localObject).baseData).msgId != localAIOVideoData.msgId) || (((RichMediaBrowserInfo)localObject).isReport)) {
        break label530;
      }
      anot.a(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 1, 0, "", "", "", "");
      ((RichMediaBrowserInfo)localObject).isReport = true;
    }
    for (;;)
    {
      paramViewGroup = new amem.a();
      paramViewGroup.c = paramView;
      this.galleryView.setTag(paramViewGroup);
      this.mVideoView = paramView;
      return this.galleryView;
      return null;
      label389:
      this.galleryView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558656, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.galleryView.setLayoutParams(paramView);
      paramView = new GalleryUrlImageView(this.mContext);
      paramView = (BaseVideoView)allg.createBaseVideoView(this.mContext, localAIOVideoData.msgId, null, paramView);
      paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramViewGroup.addRule(13);
      if (paramView != null) {
        this.galleryView.addView(paramView, paramViewGroup);
      }
      break;
      label490:
      if (paramViewGroup.a(localAIOVideoData, 0) == null) {
        break label226;
      }
      this.b.loadShortVideoCover(localAIOVideoData.aWo, localAIOVideoData.width, localAIOVideoData.height, paramView.getCoverImage(), paramInt);
      break label226;
      label530:
      anot.a(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 2, 0, "", "", "", "");
    }
  }
  
  private void updateStatus(int paramInt)
  {
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null) {
      this.b.P(localAIOVideoData.msgId, localAIOVideoData.subId, paramInt);
    }
  }
  
  public void OR(boolean paramBoolean)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "doEnterImmersion, isClick:" + paramBoolean + ", hasDanmaku:" + this.b.agC());
    super.OR(paramBoolean);
    if (paramBoolean)
    {
      showContentView(false);
      this.b.OL(false);
      return;
    }
    if (this.b.agC())
    {
      this.b.a().cCe = false;
      this.b.dMv();
      OX(false);
      return;
    }
    showContentView(false);
    this.b.a().dMq();
  }
  
  public void OV(boolean paramBoolean)
  {
    View localView;
    if (this.Gw != null)
    {
      localView = this.Gw;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void OY(boolean paramBoolean)
  {
    int j = 0;
    if (this.kh != null)
    {
      Object localObject = this.b.getSelectedItem();
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((RichMediaBrowserInfo)localObject).baseData != null)
          {
            i = j;
            if (!amcj.a().avE())
            {
              i = j;
              if (!amcj.a().avB())
              {
                i = j;
                if (alwy.auJ())
                {
                  i = j;
                  if (ShortVideoUtils.awO())
                  {
                    AIOVideoData localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
                    i = j;
                    if (!TextUtils.isEmpty(localAIOVideoData.templateId))
                    {
                      this.kh.setVisibility(0);
                      localObject = this.mContext.getString(2131694171);
                      if (!TextUtils.isEmpty(localAIOVideoData.templateName)) {
                        localObject = localAIOVideoData.templateName;
                      }
                      this.mTextView.setText((CharSequence)localObject);
                      if (this.aiz != localAIOVideoData.msgId)
                      {
                        anot.a(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", localAIOVideoData.templateId, "");
                        this.aiz = localAIOVideoData.msgId;
                      }
                      i = 1;
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (i == 0) {
        this.kh.setVisibility(8);
      }
    }
  }
  
  public AIOVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.b.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return (AIOVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    d(aqha.a(this.mContext, 230, this.mContext.getString(2131718936), this.mContext.getString(2131718935), new ameu(this, paramInt, paramObject), new ameo(this)));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "notifyVideoUrl ");
    this.b.a(paramLong, paramInt1, paramInt2, paramString1);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData == null) {
      return;
    }
    amdm.a().a(localAIOVideoData.msgId, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt3, paramString2);
    paramString2 = new ztn();
    paramString2.btf = true;
    paramString2.cJ = paramArrayOfString;
    paramString2.playUrl = paramString1;
    paramString2.l = paramMessageForShortVideo;
    paramString2.fileType = paramInt3;
    paramString2.id = localAIOVideoData.msgId;
    paramString2.subid = localAIOVideoData.subId;
    paramString1 = new File(localAIOVideoData.aWp);
    if (paramString1.exists()) {}
    for (paramString2.ap = paramString1.length();; paramString2.ap = 0L)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  " + paramString2.isMute);
      if (this.cCm)
      {
        OV(true);
        this.mErrLayout.setVisibility(8);
        this.mCenterPlayBtn.setVisibility(8);
        this.jO.setImageResource(2130847021);
        ax(true);
        f(paramString2);
      }
      if (new amct().a(localAIOVideoData, 0) != null) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
      if (RichMediaBrowserManager.getInstance().getProvider() == null) {
        break;
      }
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOVideoData.msgId, localAIOVideoData.subId, 0);
      return;
    }
  }
  
  public void a(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.d.setItemClickListenerV2(new ameq(this, paramAIOVideoData, paramFile, paramInt, paramRichMediaBrowserInfo));
    this.d.setCancelListener(new amer(this));
  }
  
  public boolean ap(MotionEvent paramMotionEvent)
  {
    if (this.mCenterPlayBtn == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "onItemClick, mCenterPlayBtn is null.");
      }
    }
    do
    {
      do
      {
        return false;
        if (this.mCenterPlayBtn.getVisibility() != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOVideoView", 0, "onItemClick, event.getRawX() = " + paramMotionEvent.getRawX() + " , event.getRawY() = " + paramMotionEvent.getRawY() + " , mCenterPlayBtn left = " + this.mCenterPlayBtn.getLeft() + " , top = " + this.mCenterPlayBtn.getTop() + " , right = " + this.mCenterPlayBtn.getRight() + ", bottom = " + this.mCenterPlayBtn.getBottom());
        }
      } while (!new Rect(this.mCenterPlayBtn.getLeft(), this.mCenterPlayBtn.getTop(), this.mCenterPlayBtn.getRight(), this.mCenterPlayBtn.getBottom()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "onItemClick, playbtn contains event");
      }
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("AIOVideoView", 0, "onItemClick, mCenterPlayBtn is not visible.");
    return false;
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void ceK()
  {
    if ((this.mVideoView != null) && (!this.mVideoView.isLocalPlay()) && (this.mVideoView.isPlaying()))
    {
      Object localObject = this.mContext.getString(2131720253);
      localObject = aqha.a(this.mContext, 230, null, (String)localObject, 2131696322, 2131721952, new ames(this), new amet(this));
      this.mVideoView.pause();
      d((Dialog)localObject);
    }
  }
  
  public void clearShortVideo()
  {
    clearTheOuchCache();
  }
  
  public void clearTheOuchCache()
  {
    this.b.mActiveThumbDrawable.clear();
  }
  
  public void d(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.mContext != null) && (!this.mContext.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  public void dMN()
  {
    OX(true);
  }
  
  public void fG(long paramLong)
  {
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      int i = RichMediaBrowserManager.getInstance().getProvider().getSaveFileProgress(localAIOVideoData.msgId, localAIOVideoData.subId);
      if ((i < 0) || (i >= 100)) {
        break label151;
      }
    }
    label151:
    for (boolean bool = true;; bool = false)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg isSaving:" + bool);
      if (bool)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg cancelDownloadMedia");
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(localAIOVideoData.msgId, localAIOVideoData.subId, 256);
      }
      if (this.mVideoView != null) {
        this.mVideoView.pause();
      }
      return;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "getView, position = " + paramInt);
    }
    this.cCm = false;
    initContentView();
    return r(paramInt, paramView, paramViewGroup);
  }
  
  public void initContentView()
  {
    if (this.contentView == null)
    {
      this.contentView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559359, null));
      Object localObject = (RelativeLayout)this.contentView.findViewById(2131372727);
      this.Gw = ((RelativeLayout)localObject).findViewById(2131372454);
      this.m = ((SeekBar)this.Gw.findViewById(2131377914));
      this.jO = ((ImageView)this.Gw.findViewById(2131372728));
      this.Bv = ((TextView)this.Gw.findViewById(2131373666));
      this.Bu = ((TextView)this.Gw.findViewById(2131380108));
      this.jO.setOnClickListener(this);
      this.m.setMax(10000);
      this.m.setOnSeekBarChangeListener(this);
      this.am = ((ImageButton)this.contentView.findViewById(2131374886));
      this.am.setContentDescription(acfp.m(2131702208));
      this.am.setOnClickListener(this);
      this.hP = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131381314));
      this.l = ((SeekBar)this.hP.findViewById(2131381316));
      this.l.setMax(10000);
      this.Kl = ((TextView)this.hP.findViewById(2131381315));
      this.closeBtn = ((ImageView)this.hP.findViewById(2131364678));
      this.closeBtn.setOnClickListener(this);
      this.hQ = ((RelativeLayout)this.contentView.findViewById(2131364065));
      this.Ko = ((TextView)this.contentView.findViewById(2131376618));
      this.aD = ((ImageButton)this.contentView.findViewById(2131374885));
      this.aD.setOnClickListener(this);
      this.an = ((ImageButton)this.contentView.findViewById(2131374887));
      this.an.setOnClickListener(this);
      this.aE = ((ImageButton)this.contentView.findViewById(2131374893));
      this.aE.setOnClickListener(this);
      this.kh = ((LinearLayout)this.contentView.findViewById(2131364216));
      this.mTextView = ((TextView)this.contentView.findViewById(2131364217));
      this.kh.setOnClickListener(this);
      this.kh.setVisibility(8);
      this.Gv = this.contentView.findViewById(2131381836);
      this.k = ((ImageButton)this.contentView.findViewById(2131374888));
      this.k.setOnClickListener(this);
      if (ayxa.isLiuHaiUseValid())
      {
        localObject = (RelativeLayout.LayoutParams)this.am.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ayxa.sNotchHeight;
        localObject = (RelativeLayout.LayoutParams)this.aE.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ayxa.sNotchHeight;
        localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ayxa.sNotchHeight;
      }
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.cCm)
      {
        pauseVideo();
        this.cCm = false;
      }
      for (;;)
      {
        this.b.dMy();
        this.b.a().dMn();
        this.b.a().cCe = false;
        this.b.a().dMm();
        break;
        bS(this.b.getCurrentPosition(), false);
      }
      Object localObject = this.b.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOVideoData)localObject).msgId, ((AIOVideoData)localObject).subId, 256);
        }
        this.b.P(((AIOVideoData)localObject).msgId, ((AIOVideoData)localObject).subId, 0);
        updateUI();
        continue;
        dMU();
        this.b.dMA();
        continue;
        dML();
        continue;
        dMK();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOVideoView", 0, "onClick qq_gallery_danmaku_view ");
        }
        localObject = this.b.a();
        if (localObject != null) {
          if (this.mVideoView == null) {
            break label360;
          }
        }
        label360:
        for (long l1 = this.mVideoView.getCurPlayingPos();; l1 = 0L)
        {
          MiniChatActivity.a(this.mContext, amcj.a().Iz(), amcj.a().yM(), false, 26, ((AIOVideoData)localObject).shmsgseq, l1);
          this.b.dMB();
          break;
        }
        if (this.basePresenter != null)
        {
          this.basePresenter.back();
          continue;
          if ((this.mContext instanceof AIOGalleryActivity))
          {
            localObject = (AIOGalleryActivity)this.mContext;
            if (Build.VERSION.SDK_INT >= 23)
            {
              if (!aczy.bd(this.mContext)) {
                ((AIOGalleryActivity)localObject).requestPermissions(new amep(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
              } else {
                dMX();
              }
            }
            else {
              dMX();
            }
          }
          else
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onClick, activity:" + this.mContext);
          }
        }
      }
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (paramRichMediaBrowserInfo.baseData.getType() == 101))
    {
      localObject = (AIOVideoData)paramRichMediaBrowserInfo.baseData;
      paramRichMediaBrowserInfo = new amct().a((AIOVideoData)localObject, 0);
      if (paramRichMediaBrowserInfo == null) {
        break label128;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      paramRichMediaBrowserInfo = URLDrawable.getDrawable(paramRichMediaBrowserInfo, (URLDrawable.URLDrawableOptions)localObject);
      paramRichMediaBrowserInfo.startDownload();
      this.b.mActiveThumbDrawable.put(Integer.valueOf(paramInt), paramRichMediaBrowserInfo);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onCreateView(): preload thumb, position=" + paramInt);
    }
    for (;;)
    {
      return null;
      label128:
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onCreateView downloadMedia AIOShortVideoData.TYPE_THUMB");
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().downloadMedia(((AIOVideoData)localObject).msgId, ((AIOVideoData)localObject).subId, 0);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(false);
    }
    this.cCm = false;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.b.mActiveThumbDrawable.remove(Integer.valueOf(paramInt));
  }
  
  public void onEnterAnimationEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onEnterAnimationEnd");
    }
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onEnterAnimationStart");
    }
    showContentView(false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.b.getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.baseData == null)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onItemClick data is null，position = " + paramInt);
    }
    do
    {
      do
      {
        return;
      } while (paramAdapterView.baseData.getType() != 101);
      if (!ap(((DragGallery)this.b.getGallery()).getSingleTapConfirmedEvent())) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, play button click.");
    } while (((AIOVideoData)paramAdapterView.baseData).status == 2);
    bS(paramInt, false);
    return;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, handle immersion.");
    if (this.b.avH())
    {
      if (this.b.a().cCe)
      {
        this.b.a().cCe = false;
        this.b.a().dMm();
        dMM();
      }
      for (;;)
      {
        this.b.a().dMr();
        return;
        this.b.a().dMn();
        this.b.a().cCe = true;
        OR(true);
      }
    }
    this.b.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onItemSelected, position = " + paramInt + " ,  , basePresenter.getCurrentPosition() = " + this.basePresenter.getCurrentPosition() + " ,id = " + paramLong);
    }
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if ((this.b != null) && (this.b.lg(paramInt))) {
      bS(paramInt, true);
    }
    for (;;)
    {
      this.Bv.setText(ShortVideoUtils.stringForTime(0L));
      this.m.setProgress(0);
      return;
      OV(false);
      this.mErrLayout.setVisibility(8);
      if (!this.cCm)
      {
        this.mCenterPlayBtn.setVisibility(0);
        this.jO.setImageResource(2130847020);
      }
      ax(true);
      OY(true);
    }
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPause");
    pauseVideo();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mVideoView != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.mVideoView.getVideoDurationMs());
        this.mVideoView.seekTo(paramInt);
        this.Bv.setText(ShortVideoUtils.stringForTime(paramInt));
      }
      this.b.dMz();
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
    if ((this.cCm) && (this.mVideoView != null))
    {
      this.mVideoView.resume();
      OV(true);
      this.mCenterPlayBtn.setVisibility(8);
      this.jO.setImageResource(2130847021);
      return;
    }
    OV(false);
    this.mCenterPlayBtn.setVisibility(0);
    this.jO.setImageResource(2130847020);
  }
  
  public void onScrollEnd(int paramInt)
  {
    if ((paramInt == this.b.getCurrentPosition()) && (this.b.le(paramInt)))
    {
      if ((this.mVideoView != null) && (this.mVideoView.isPlaying())) {
        this.b.cWC();
      }
    }
    else {
      return;
    }
    this.b.OK(false);
  }
  
  public void onScrollHalfScreenWidth()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onScrollHalfScreenWidth");
    }
    super.onScrollHalfScreenWidth();
    if ((this.mVideoView != null) && (this.mVideoView.mIsPlayVideo)) {
      this.mVideoView.pause();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStop");
    clearShortVideo();
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(true);
    }
    this.cCm = false;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStopTrackingTouch");
    if ((this.b.a() != null) && (this.b.le(this.b.getCurrentPosition())) && (paramSeekBar != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "seek danmaku");
      this.b.a().seek(paramSeekBar.getProgress());
      AIOVideoData localAIOVideoData = this.b.a();
      if (localAIOVideoData != null) {
        this.b.a().jJ(amch.a(localAIOVideoData.shmsgseq, paramSeekBar.getProgress(), this.b.a(), this.b.gM));
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof amem.a)))
    {
      paramView = ((amem.a)paramView.getTag()).c;
      paramRichMediaBrowserInfo = (URLDrawable)this.b.mActiveDrawable.get(Integer.valueOf(paramInt));
      if (paramRichMediaBrowserInfo != null)
      {
        paramView.setCoverDrawable(paramRichMediaBrowserInfo);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onViewDetached(): Use thumb cache replace video.");
      }
    }
    else
    {
      return;
    }
    paramView.setCoverDrawable(aoop.TRANSPARENT);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void showActionSheet(int paramInt)
  {
    super.showActionSheet(paramInt);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      if (!this.mVideoView.isPlaying()) {
        break label94;
      }
      long l1 = this.mVideoView.getCurPlayingPos();
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "showActionSheet, captureCurFrame, from:" + paramInt + ", pos:" + l1);
      }
      this.mVideoView.captureCurFrame(l1, 0, 0);
    }
    for (;;)
    {
      a(localAIOVideoData, paramInt);
      return;
      label94:
      if (this.m.getProgress() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "showActionSheet, captureCurFrame, from:" + paramInt + ", pos:" + this.currentPositionMs);
        }
        this.mVideoView.captureCurFrame(this.currentPositionMs, 0, 0);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "showActionSheet, video is not playing, recognize thumbnail");
        }
        ThreadManager.getSubThreadHandler().post(new AIOVideoView.8(this));
      }
    }
  }
  
  public void updateUI()
  {
    int i = 8;
    super.updateUI();
    AIOVideoData localAIOVideoData = a();
    OP(SH());
    OQ(c(this.b.getSelectedItem()));
    OY(true);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI id = " + localAIOVideoData.id + ", status = " + localAIOVideoData.status);
    switch (localAIOVideoData.status)
    {
    case 1: 
    case 3: 
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI status is error, status = " + localAIOVideoData.status);
      return;
    case 2: 
      this.b.onLoadFinish(this.b.getSelectedIndex(), true);
      this.Kl.setText(acfp.m(2131702235) + localAIOVideoData.progress + "%");
      this.l.setProgress(localAIOVideoData.progress * 100);
      this.hQ.setVisibility(8);
      OV(false);
      zA(true);
      this.mErrLayout.setVisibility(8);
      this.mCenterPlayBtn.setVisibility(8);
      ax(true);
      OQ(false);
      return;
    case 4: 
      this.b.onLoadStart(this.b.getSelectedIndex(), localAIOVideoData.progress);
      zA(false);
      this.hQ.setVisibility(8);
      OV(false);
      this.mErrLayout.setVisibility(8);
      this.mCenterPlayBtn.setVisibility(8);
      ax(false);
      OQ(false);
      return;
    }
    this.b.onLoadFinish(this.b.getSelectedIndex(), true);
    OV(false);
    zA(false);
    this.hQ.setVisibility(8);
    this.mErrLayout.setVisibility(8);
    ImageView localImageView = this.mCenterPlayBtn;
    if (localAIOVideoData.isAutoPlay) {}
    for (;;)
    {
      localImageView.setVisibility(i);
      this.jO.setImageResource(2130847020);
      this.Bv.setText(ShortVideoUtils.stringForTime(0L));
      this.m.setProgress(0);
      ax(true);
      return;
      i = 0;
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject2 = this.b.getItem(paramInt);
    if ((localObject2 == null) || (((RichMediaBrowserInfo)localObject2).baseData == null) || (paramView == null)) {
      return;
    }
    if ((paramView.getTag() instanceof amem.a))
    {
      Object localObject1 = ((amem.a)paramView.getTag()).c;
      if (((RichMediaBrowserInfo)localObject2).baseData.getType() == 101)
      {
        localObject2 = (AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateView loadShortVideoCover");
        this.b.loadShortVideoCover(((AIOVideoData)localObject2).aWo, ((AIOVideoData)localObject2).width, ((AIOVideoData)localObject2).height, ((BaseVideoView)localObject1).getCoverImage(), paramInt);
        if (this.cCm)
        {
          localObject1 = this.b.a((AIOVideoData)localObject2);
          if (localObject1 != null) {
            f((ztn)localObject1);
          }
        }
      }
    }
    super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
  
  public void zA(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.hP != null)
    {
      localRelativeLayout = this.hP;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public class a
  {
    public BaseVideoView c;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amem
 * JD-Core Version:    0.7.0.1
 */