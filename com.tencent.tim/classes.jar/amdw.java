import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.debug.io.tools.VersionUtils;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.4;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.5;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.7;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.IBrowserViewHolder;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.DragGallery;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class amdw
  extends amdo
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public TextView Bu;
  public TextView Bv;
  private View Gv;
  public TextView Kl;
  public TextView Ko;
  private arlq a;
  public ImageButton aE;
  public ImageButton am;
  public amcy b;
  public GalleryUrlImageView b;
  public String bZM;
  private String bZN = "";
  public ImageView closeBtn;
  private long currentPositionMs = -1L;
  public RelativeLayout hP;
  public RelativeLayout hQ;
  public ImageView jO;
  public SeekBar l;
  public RelativeLayout lN;
  public RelativeLayout lO;
  public SeekBar m;
  private ImageView mCenterPlayBtn;
  private LinearLayout mErrLayout;
  public BaseVideoView mVideoView;
  public int midScreenWidth;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> zj;
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> zk = new ArrayList();
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> zl = new ArrayList();
  
  public amdw(Activity paramActivity, amcy paramamcy)
  {
    super(paramActivity, paramamcy);
    this.jdField_b_of_type_Amcy = paramamcy;
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
    boolean bool;
    if (!paramztn.btf)
    {
      bool = true;
      localVideoPlayParam.mIsLocal = bool;
      if (localVideoPlayParam.mIsLocal) {
        break label121;
      }
      localVideoPlayParam.mSavePath = paramztn.mBundle.getString("savepath");
      localVideoPlayParam.mFileID = paramztn.mBundle.getString("fileid");
      localVideoPlayParam.mUrls = paramztn.cJ;
      localVideoPlayParam.mCookies = paramztn.mCookies;
      updateStatus(1);
    }
    for (;;)
    {
      localVideoPlayParam.mIsMute = paramztn.isMute;
      localVideoPlayParam.mSceneId = 109;
      localVideoPlayParam.mSceneName = allh.eO(109);
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      a(localVideoPlayParam);
      return localVideoPlayParam;
      bool = false;
      break;
      label121:
      localVideoPlayParam.mVideoPath = paramztn.playUrl;
    }
  }
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    String str1 = null;
    AIOFileVideoData localAIOFileVideoData = b();
    if (paramInt1 == 2)
    {
      ztn localztn = new amcp().a(localAIOFileVideoData, localAIOFileVideoData.isMutePlay);
      if ((localztn != null) && (localztn.cJ != null) && (!auqc.isEmpty(localztn.mDomain)))
      {
        String[] arrayOfString = localztn.cJ;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (!auqc.isEmpty(str2)) {
            aopd.a().X(localztn.mDomain, aopd.getHostFromUrl(str2), 1005);
          }
          i += 1;
        }
        xuk.a().clearCache();
      }
    }
    if (paramInt1 == 1) {
      str1 = this.mContext.getString(2131720258);
    }
    if (localAIOFileVideoData != null) {
      if (str1 == null) {
        break label275;
      }
    }
    for (;;)
    {
      localAIOFileVideoData.strErr = str1;
      localAIOFileVideoData.dBG += 1;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 2, "handlePlayError, videoData.mPlayErrTimes = " + localAIOFileVideoData.dBG);
      if ((!alli.a(paramInt2, paramVideoPlayParam)) || (this.mVideoView == null) || (localAIOFileVideoData == null) || (localAIOFileVideoData.dBG >= 2)) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 2, "handlePlayError, auto replay video.");
      ThreadManager.getUIHandler().post(new AIOFileVideoView.4(this, localAIOFileVideoData));
      return;
      label275:
      str1 = this.mContext.getString(2131720261);
    }
    ThreadManager.getUIHandler().post(new AIOFileVideoView.5(this));
  }
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new amdy(this, paramVideoPlayParam);
  }
  
  private boolean a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    if ((paramAIOFileVideoData.retCode == -7003L) || (paramAIOFileVideoData.retCode == -6101L) || (paramAIOFileVideoData.retCode == -103L) || (paramAIOFileVideoData.retCode == -301L)) {
      paramBoolean = true;
    }
    return paramBoolean;
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
    //   10: invokestatic 380	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   13: ifeq +12 -> 25
    //   16: ldc 254
    //   18: iconst_0
    //   19: ldc_w 382
    //   22: invokestatic 385	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: return
    //   26: invokestatic 391	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   29: invokevirtual 395	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   32: invokevirtual 400	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: astore_3
    //   36: new 397	java/io/File
    //   39: dup
    //   40: new 256	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   47: aload_3
    //   48: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 403	java/io/File:separator	Ljava/lang/String;
    //   54: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 405
    //   60: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 408	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 411	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_3
    //   78: invokevirtual 414	java/io/File:createNewFile	()Z
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 400	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: putfield 66	amdw:bZN	Ljava/lang/String;
    //   90: invokestatic 380	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   93: ifeq +32 -> 125
    //   96: ldc 254
    //   98: iconst_0
    //   99: new 256	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 416
    //   109: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 66	amdw:bZN	Ljava/lang/String;
    //   116: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 385	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 66	amdw:bZN	Ljava/lang/String;
    //   130: invokestatic 421	aueh:f	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   133: pop
    //   134: new 68	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 71	java/util/ArrayList:<init>	()V
    //   141: astore 6
    //   143: new 423	android/util/SparseArray
    //   146: dup
    //   147: iconst_2
    //   148: invokespecial 425	android/util/SparseArray:<init>	(I)V
    //   151: astore 7
    //   153: aload_1
    //   154: iconst_1
    //   155: iconst_3
    //   156: aload 7
    //   158: invokestatic 430	rvx:a	(Landroid/graphics/Bitmap;ZILandroid/util/SparseArray;)I
    //   161: istore_2
    //   162: iload_2
    //   163: invokestatic 434	rvx:fa	(I)Z
    //   166: ifeq +98 -> 264
    //   169: invokestatic 380	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   172: ifeq +12 -> 184
    //   175: ldc 254
    //   177: iconst_0
    //   178: ldc_w 436
    //   181: invokestatic 385	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 7
    //   186: iconst_1
    //   187: invokevirtual 440	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   190: astore_1
    //   191: aload_1
    //   192: instanceof 442
    //   195: ifeq +242 -> 437
    //   198: aload_1
    //   199: checkcast 442	android/util/Pair
    //   202: astore_3
    //   203: new 444	org/json/JSONObject
    //   206: dup
    //   207: invokespecial 445	org/json/JSONObject:<init>	()V
    //   210: astore_1
    //   211: aload_1
    //   212: ldc_w 447
    //   215: aload_3
    //   216: getfield 451	android/util/Pair:second	Ljava/lang/Object;
    //   219: invokestatic 457	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokevirtual 460	java/lang/String:trim	()Ljava/lang/String;
    //   225: invokevirtual 464	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload_1
    //   230: ldc_w 466
    //   233: aload_3
    //   234: getfield 469	android/util/Pair:first	Ljava/lang/Object;
    //   237: invokestatic 457	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 460	java/lang/String:trim	()Ljava/lang/String;
    //   243: invokevirtual 464	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload_1
    //   248: ifnonnull +136 -> 384
    //   251: ldc 64
    //   253: astore_1
    //   254: bipush 126
    //   256: aload 6
    //   258: aload_1
    //   259: iconst_0
    //   260: invokestatic 474	aqly:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   263: pop
    //   264: iload_2
    //   265: invokestatic 477	rvx:fb	(I)Z
    //   268: ifeq +74 -> 342
    //   271: invokestatic 380	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   274: ifeq +12 -> 286
    //   277: ldc 254
    //   279: iconst_0
    //   280: ldc_w 479
    //   283: invokestatic 385	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload 7
    //   288: iconst_2
    //   289: invokevirtual 440	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   292: astore_3
    //   293: aload 5
    //   295: astore_1
    //   296: aload_3
    //   297: instanceof 453
    //   300: ifeq +25 -> 325
    //   303: aload_3
    //   304: checkcast 453	java/lang/String
    //   307: astore_3
    //   308: new 444	org/json/JSONObject
    //   311: dup
    //   312: invokespecial 445	org/json/JSONObject:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: ldc_w 481
    //   320: aload_3
    //   321: invokevirtual 464	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload_1
    //   326: ifnonnull +77 -> 403
    //   329: ldc 64
    //   331: astore_1
    //   332: bipush 127
    //   334: aload 6
    //   336: aload_1
    //   337: iconst_0
    //   338: invokestatic 474	aqly:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   341: pop
    //   342: aload 6
    //   344: invokevirtual 483	java/util/ArrayList:isEmpty	()Z
    //   347: ifeq +64 -> 411
    //   350: invokestatic 380	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   353: ifeq -328 -> 25
    //   356: ldc 254
    //   358: iconst_0
    //   359: ldc_w 485
    //   362: invokestatic 385	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: return
    //   366: astore_3
    //   367: aload_3
    //   368: invokevirtual 488	java/io/IOException:printStackTrace	()V
    //   371: goto -237 -> 134
    //   374: astore_3
    //   375: aconst_null
    //   376: astore_1
    //   377: aload_3
    //   378: invokevirtual 489	org/json/JSONException:printStackTrace	()V
    //   381: goto -134 -> 247
    //   384: aload_1
    //   385: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   388: astore_1
    //   389: goto -135 -> 254
    //   392: astore_3
    //   393: aload 4
    //   395: astore_1
    //   396: aload_3
    //   397: invokevirtual 489	org/json/JSONException:printStackTrace	()V
    //   400: goto -75 -> 325
    //   403: aload_1
    //   404: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   407: astore_1
    //   408: goto -76 -> 332
    //   411: invokestatic 291	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   414: new 492	com/tencent/mobileqq/richmediabrowser/view/AIOFileVideoView$6
    //   417: dup
    //   418: aload_0
    //   419: aload 6
    //   421: invokespecial 495	com/tencent/mobileqq/richmediabrowser/view/AIOFileVideoView$6:<init>	(Lamdw;Ljava/util/ArrayList;)V
    //   424: invokevirtual 302	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
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
    //   0	442	0	this	amdw
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
  
  private boolean avL()
  {
    return (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder());
  }
  
  private boolean ax(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcy.getSelectedItem();
      if ((localRichMediaBrowserInfo == null) || (!(localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData))) {
        break label74;
      }
      if (!aqhq.fileExistsAndNotEmpty(((AIOFileVideoData)localRichMediaBrowserInfo.baseData).mFilePath)) {
        return false;
      }
      this.am.setVisibility(0);
    }
    label74:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      this.am.setVisibility(4);
    }
  }
  
  private void bS(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "tryPlayVideo, position = " + paramInt);
    }
    Object localObject = this.jdField_b_of_type_Amcy.getItem(paramInt);
    amcp localamcp;
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 103))
    {
      localObject = (AIOFileVideoData)((RichMediaBrowserInfo)localObject).baseData;
      if (QLog.isColorLevel()) {
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, String.format("tryPlayVideo, position:%d , msgId:%s request:%b ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(((AIOFileVideoData)localObject).msgId), Boolean.valueOf(((AIOFileVideoData)localObject).bis) }));
      }
      ((AIOFileVideoData)localObject).isAutoPlay = paramBoolean;
      localamcp = new amcp();
      if ((localamcp.a((AIOFileVideoData)localObject)) || (((AIOFileVideoData)localObject).bis)) {
        break label196;
      }
      localamcp.a((AIOFileVideoData)localObject, (amcl)RichMediaBrowserManager.getInstance().getProvider());
      this.jdField_b_of_type_Amcy.a((AIOFileVideoData)localObject);
      this.jdField_b_of_type_Amcy.P(((AIOFileVideoData)localObject).msgId, ((AIOFileVideoData)localObject).subId, 4);
      updateUI();
    }
    label196:
    do
    {
      return;
      f(localamcp.a((AIOFileVideoData)localObject, ((AIOFileVideoData)localObject).isMutePlay));
    } while ((!((AIOFileVideoData)localObject).bit) || (((AIOFileVideoData)localObject).downloadUrl == null));
    updateStatus(5);
  }
  
  private void dMU()
  {
    AIOFileVideoData localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
    if ((localAIOFileVideoData == null) || (!aqhq.fileExistsAndNotEmpty(localAIOFileVideoData.mFilePath))) {}
    do
    {
      return;
      if (this.a != null) {
        this.a.destory();
      }
      long l1 = this.mVideoView.getCurPlayingPos();
      this.a = new arlq(this.mContext);
      this.a.w(localAIOFileVideoData.mFilePath, localAIOFileVideoData.msgId, l1);
      if (aqhq.fileExistsAndNotEmpty(localAIOFileVideoData.bN)) {
        this.a.aR(localAIOFileVideoData.bN, localAIOFileVideoData.width, localAIOFileVideoData.height);
      }
    } while ((localAIOFileVideoData.width > localAIOFileVideoData.height) && (!this.a.q(localAIOFileVideoData.istroop, localAIOFileVideoData.width, localAIOFileVideoData.height)));
    this.jdField_b_of_type_Amcy.back();
  }
  
  private Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 0, "drawable2Bitmap, drawable is null");
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
  
  private String eT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefine";
    case 0: 
      return "Nomal";
    case 3: 
      return "Buffering";
    case 1: 
      return "Downloading";
    case 7: 
      return "Error";
    case 4: 
      return "Get URL";
    case 6: 
      return "Pause";
    case 5: 
      return "Playing";
    }
    return "Saving";
  }
  
  private void f(AIOFileVideoData paramAIOFileVideoData)
  {
    if (!CheckPermission.isHasStoragePermission(this.mContext))
    {
      CheckPermission.requestStorePermission(this.mContext, null);
      return;
    }
    if (new amcp().a(paramAIOFileVideoData))
    {
      ahav.by(this.mContext, paramAIOFileVideoData.mFilePath);
      return;
    }
    Bundle localBundle = new Bundle();
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().onFileVideoStatusChange(paramAIOFileVideoData.msgId, 13, localBundle);
    }
    paramAIOFileVideoData.aZm = true;
    aT(paramAIOFileVideoData.msgId, paramAIOFileVideoData.subId);
    updateUI();
  }
  
  private void f(ztn paramztn)
  {
    this.jdField_b_of_type_Amcy.P(paramztn.id, paramztn.subid, 5);
    updateUI();
    paramztn = a(paramztn);
    if (this.mVideoView != null)
    {
      this.mVideoView.setVideoParam(paramztn);
      this.mVideoView.play();
    }
  }
  
  private int iX(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      return 3;
    }
    return 9;
  }
  
  private void pauseVideo()
  {
    if (this.mVideoView != null) {
      this.mVideoView.pause();
    }
    abandonAudioFocus();
    if (this.jdField_b_of_type_Amcy.le(this.jdField_b_of_type_Amcy.getCurrentPosition())) {
      this.jdField_b_of_type_Amcy.OK(true);
    }
  }
  
  private void updateStatus(int paramInt)
  {
    AIOFileVideoData localAIOFileVideoData = b();
    if (localAIOFileVideoData != null) {
      this.jdField_b_of_type_Amcy.P(localAIOFileVideoData.msgId, localAIOFileVideoData.subId, paramInt);
    }
  }
  
  public void OR(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doEnterImmersion, isClick = ").append(paramBoolean).append(" ,  isShowingDanmaku =");
      if (this.jdField_b_of_type_Amcy.a() == null) {
        break label88;
      }
    }
    label88:
    for (boolean bool = this.jdField_b_of_type_Amcy.a().agC();; bool = false)
    {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, bool);
      super.OR(paramBoolean);
      if (!paramBoolean) {
        break;
      }
      showContentView(false);
      this.jdField_b_of_type_Amcy.OL(false);
      return;
    }
    if ((this.jdField_b_of_type_Amcy.a() != null) && (this.jdField_b_of_type_Amcy.a().agC()))
    {
      this.jdField_b_of_type_Amcy.a().cCe = false;
      this.jdField_b_of_type_Amcy.dMv();
      OX(false);
      return;
    }
    showContentView(false);
  }
  
  public void OV(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.lO != null)
    {
      localRelativeLayout = this.lO;
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
  
  public void OW(boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.hP != null)
    {
      localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      localLayoutParams = (RelativeLayout.LayoutParams)this.hP.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      if (paramBoolean) {
        localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 49.0F, localDisplayMetrics));
      }
    }
    else
    {
      return;
    }
    localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 10.0F, localDisplayMetrics));
  }
  
  public boolean SH()
  {
    if (super.SH())
    {
      AIOFileVideoData localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
      if ((localAIOFileVideoData != null) && (!amcj.a().avB()) && (!TextUtils.isEmpty(localAIOFileVideoData.mFilePath))) {
        return true;
      }
    }
    return false;
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2, Bundle paramBundle)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "setVideoDrawableWithUrls position = " + paramInt1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcy.getItem(paramInt1);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {}
    boolean bool;
    for (;;)
    {
      return;
      if (localRichMediaBrowserInfo.baseData.getType() == 103)
      {
        paramString2 = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
        paramString2.bundle = paramBundle;
        paramMessageForShortVideo = new amcp();
        if (paramString2.bis)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "fileVideo is playing:" + paramString2.id);
          return;
        }
        paramString2.bis = true;
        if ("I:E".equals(paramString1)) {
          try
          {
            paramString2.retCode = Long.parseLong(paramArrayOfString[0]);
            paramString1 = paramArrayOfString[1];
            ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).strErr = paramString1;
            this.jdField_b_of_type_Amcy.P(paramString2.msgId, paramString2.subId, 7);
            if (paramString2.retCode == -134L)
            {
              paramString1 = this.mContext.getString(2131720270);
              bool = true;
              if (bool)
              {
                paramString1 = aqha.a(this.mContext, 230, "", paramString1, null, acfp.m(2131702230), new amdx(this), null);
                if (paramString1.isShowing()) {
                  continue;
                }
                paramString1.show();
                return;
              }
            }
          }
          catch (NumberFormatException paramString1)
          {
            paramString2.retCode = -1L;
            paramString2.retMsg = paramArrayOfString[1];
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Amcy.P(paramString2.msgId, paramString2.subId, 0);
      paramString1 = paramMessageForShortVideo.a(paramString2, paramString2.isMutePlay);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "setVideoDrawableWithUrls autoPlay id = " + paramString2.id);
      this.jdField_b_of_type_Amcy.P(paramString2.msgId, paramString2.subId, 5);
      f(paramString1);
      return;
      bool = a(paramString2, false);
      break;
      paramString2.downloadUrl = paramArrayOfString[0];
      paramString2.zi = paramBundle.getStringArrayList("cookies");
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.jdField_b_of_type_Amcy.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_b_of_type_Amcy.getSelectedIndex(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    if ((this.mContext != null) && (this.mContext.getIntent() != null)) {
      this.mContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
    }
    this.zk.clear();
    this.zl.clear();
    aqly.a(2, this.zk);
    aqly.a(27, this.zk);
    aqly.a(39, this.zl);
    aqly.a(6, this.zl);
    if ((amcj.a().avF()) && (!TextUtils.isEmpty(amcj.a().yO()))) {
      aqly.a(54, this.zl);
    }
    if (this.mVideoView.isPlaying())
    {
      long l1 = this.mVideoView.getCurPlayingPos();
      this.mVideoView.captureCurFrame(l1, 0, 0);
    }
    for (;;)
    {
      this.zj = this.zl;
      this.bZM = null;
      e(paramAIOFileVideoData);
      paramAIOFileVideoData = this.jdField_b_of_type_Amcy.a(paramAIOFileVideoData, this.mContext);
      if (paramAIOFileVideoData != null) {
        this.d.setIntentForStartForwardRecentActivity(paramAIOFileVideoData);
      }
      this.d.setActionSheetItems(this.zk, this.zl);
      this.d.show();
      return;
      if (this.m.getProgress() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOFileVideoView<FileAssistant>XOXO", 0, "showActionSheet, captureCurFrame, from:" + paramInt + ", pos:" + this.currentPositionMs);
        }
        this.mVideoView.captureCurFrame(this.currentPositionMs, 0, 0);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOFileVideoView<FileAssistant>XOXO", 0, "showActionSheet, video is not playing, recognize thumbnail");
        }
        ThreadManager.getSubThreadHandler().post(new AIOFileVideoView.7(this));
      }
    }
  }
  
  public void aT(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Amcy.P(paramLong, paramInt, 2);
  }
  
  public boolean ap(MotionEvent paramMotionEvent)
  {
    if (this.mCenterPlayBtn == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "onItemClick, mCenterPlayBtn is null.");
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
          QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "onItemClick, event.getRawX() = " + paramMotionEvent.getRawX() + " , event.getRawY() = " + paramMotionEvent.getRawY() + " , mCenterPlayBtn left = " + this.mCenterPlayBtn.getLeft() + " , top = " + this.mCenterPlayBtn.getTop() + " , right = " + this.mCenterPlayBtn.getRight() + ", bottom = " + this.mCenterPlayBtn.getBottom());
        }
      } while (!new Rect(this.mCenterPlayBtn.getLeft(), this.mCenterPlayBtn.getTop(), this.mCenterPlayBtn.getRight(), this.mCenterPlayBtn.getBottom()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      if (QLog.isColorLevel()) {
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "onItemClick, playbtn contains event");
      }
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "onItemClick, mCenterPlayBtn is not visible.");
    return false;
  }
  
  public AIOFileVideoData b()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcy.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
      return (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.midScreenWidth = (anmk.getScreenWidth(this.mContext) / 2);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public boolean c(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.c(paramRichMediaBrowserInfo);
  }
  
  public void dMN()
  {
    OX(true);
  }
  
  public void dMT()
  {
    bS(this.jdField_b_of_type_Amcy.getCurrentPosition(), true);
  }
  
  public void e(AIOFileVideoData paramAIOFileVideoData)
  {
    this.d.setItemClickListenerV2(new amdz(this, paramAIOFileVideoData));
  }
  
  public void fG(long paramLong)
  {
    super.fG(paramLong);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcy.getSelectedItem();
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null) || (localRichMediaBrowserInfo.baseData.getType() != 103)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onRevokeMsg exp!");
    }
    while ((this.mVideoView == null) || (!this.mVideoView.isPlaying())) {
      return;
    }
    this.mVideoView.pause();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mVideoView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "mVideoView != null, releasePlayer.");
      }
      this.mVideoView.releasePlayer(false);
    }
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof amdw.a)))
    {
      this.lN = ((RelativeLayout)paramView);
      this.mVideoView = ((amdw.a)paramView.getTag()).c;
    }
    for (;;)
    {
      return this.lN;
      this.lN = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558656, paramViewGroup, false));
      this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView = ((GalleryUrlImageView)this.lN.findViewById(2131373580));
      this.mVideoView = ((BaseVideoView)allg.createBaseVideoView(this.mContext, 0L, null, this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView));
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      paramView.addRule(13);
      if (this.mVideoView != null) {
        ((RelativeLayout)this.lN.findViewById(2131381636)).addView(this.mVideoView, paramView);
      }
      initContentView();
    }
  }
  
  public void initContentView()
  {
    if (this.lN != null)
    {
      this.contentView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559359, null));
      this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView = ((GalleryUrlImageView)this.lN.findViewById(2131373580));
      Object localObject = (RelativeLayout)this.contentView.findViewById(2131372727);
      this.lO = ((RelativeLayout)this.contentView.findViewById(2131372454));
      this.m = ((SeekBar)this.lO.findViewById(2131377914));
      this.jO = ((ImageView)this.lO.findViewById(2131372728));
      this.Bv = ((TextView)this.lO.findViewById(2131373666));
      this.Bu = ((TextView)this.lO.findViewById(2131380108));
      this.lO.setVisibility(8);
      this.jO.setOnClickListener(this);
      this.m.setMax(10000);
      this.m.setOnSeekBarChangeListener(this);
      this.am = ((ImageButton)this.contentView.findViewById(2131374886));
      this.am.setContentDescription(acfp.m(2131702193));
      this.am.setOnClickListener(this);
      this.hP = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131381314));
      this.l = ((SeekBar)this.hP.findViewById(2131381316));
      this.l.setMax(10000);
      this.Kl = ((TextView)this.hP.findViewById(2131381315));
      this.closeBtn = ((ImageView)this.hP.findViewById(2131364678));
      this.hP.setVisibility(8);
      this.closeBtn.setOnClickListener(this);
      this.hQ = ((RelativeLayout)this.contentView.findViewById(2131364065));
      this.Ko = ((TextView)this.contentView.findViewById(2131376618));
      this.Ko.setVisibility(8);
      this.aD = ((ImageButton)this.contentView.findViewById(2131374885));
      if (this.aD != null) {
        this.aD.setOnClickListener(this);
      }
      this.an = ((ImageButton)this.contentView.findViewById(2131374887));
      if (this.an != null) {
        this.an.setOnClickListener(this);
      }
      this.aE = ((ImageButton)this.contentView.findViewById(2131374893));
      this.aE.setOnClickListener(this);
      this.Gv = this.contentView.findViewById(2131381836);
      this.lN.findViewById(2131373579).setOnClickListener(this);
      this.k = ((ImageButton)this.contentView.findViewById(2131374888));
      this.k.setOnClickListener(this);
      this.mCenterPlayBtn = ((ImageView)this.lN.findViewById(2131373579));
      this.mCenterPlayBtn.bringToFront();
      this.mCenterPlayBtn.setOnClickListener(this);
      this.mErrLayout = ((LinearLayout)this.lN.findViewById(2131373581));
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
      AIOFileVideoData localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
      if ((this.mVideoView != null) && (this.mVideoView.isPlaying())) {
        pauseVideo();
      }
      for (;;)
      {
        this.jdField_b_of_type_Amcy.dMy();
        dMO();
        break;
        new amcp().b(localAIOFileVideoData, this.mContext, this);
      }
      localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
      amcp localamcp = new amcp();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onItemClick id = " + localAIOFileVideoData.id);
      if (localamcp.a(localAIOFileVideoData)) {
        this.jdField_b_of_type_Amcy.P(localAIOFileVideoData.msgId, localAIOFileVideoData.subId, 5);
      }
      for (;;)
      {
        bS(this.jdField_b_of_type_Amcy.getCurrentPosition(), false);
        dMP();
        updateUI();
        break;
        this.jdField_b_of_type_Amcy.P(localAIOFileVideoData.msgId, localAIOFileVideoData.subId, 1);
      }
      localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
      if (localAIOFileVideoData != null)
      {
        localAIOFileVideoData.isCancel = true;
        this.jdField_b_of_type_Amcy.P(localAIOFileVideoData.msgId, localAIOFileVideoData.subId, 0);
        this.jdField_b_of_type_Amcy.b(localAIOFileVideoData);
        this.jdField_b_of_type_Amcy.back();
        continue;
        dMU();
        this.jdField_b_of_type_Amcy.dMA();
        continue;
        dML();
        continue;
        dMK();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "onClick qq_gallery_danmaku_view ");
        }
        localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
        if (localAIOFileVideoData != null)
        {
          long l1 = this.mVideoView.getCurPlayingPos();
          MiniChatActivity.a(this.mContext, amcj.a().Iz(), amcj.a().yM(), false, 26, localAIOFileVideoData.shmsgseq, l1);
        }
        this.jdField_b_of_type_Amcy.dMB();
        continue;
        if (this.basePresenter != null) {
          this.basePresenter.back();
        }
      }
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mVideoView != null)
    {
      this.mVideoView.releasePlayer(false);
      this.jdField_b_of_type_Amcy.c(b());
    }
    this.jdField_b_of_type_Amcy.getSelectedItem();
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    showContentView(false);
  }
  
  public void onExitAnimationStart() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_b_of_type_Amcy.getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.baseData == null)) {}
    do
    {
      do
      {
        return;
      } while (paramAdapterView.baseData.getType() != 103);
      if (!ap(((DragGallery)this.jdField_b_of_type_Amcy.getGallery()).getSingleTapConfirmedEvent())) {
        break;
      }
    } while (((AIOFileVideoData)paramAdapterView.baseData).status == 2);
    bS(paramInt, false);
    return;
    if (this.jdField_b_of_type_Amcy.avH())
    {
      if (this.jdField_b_of_type_Amcy.a().cCe)
      {
        this.jdField_b_of_type_Amcy.a().cCe = false;
        this.jdField_b_of_type_Amcy.a().dMm();
        dMM();
      }
      for (;;)
      {
        this.jdField_b_of_type_Amcy.a().dMr();
        return;
        this.jdField_b_of_type_Amcy.a().dMn();
        this.jdField_b_of_type_Amcy.a().cCe = true;
        OR(true);
      }
    }
    this.jdField_b_of_type_Amcy.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    wj(paramInt);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onItemSelected position = " + paramInt);
    paramAdapterView = this.jdField_b_of_type_Amcy.getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.baseData == null)) {}
    while (paramAdapterView.baseData.getType() != 103) {
      return;
    }
    paramView = (AIOFileVideoData)paramAdapterView.baseData;
    amcp localamcp = new amcp();
    if ((paramView.isAutoPlay) && (localamcp.a(paramView)))
    {
      bS(paramInt, true);
      return;
    }
    this.jdField_b_of_type_Amcy.P(paramView.msgId, paramView.subId, 0);
    if (paramAdapterView.isEnterImage) {
      paramView.biv = true;
    }
    if (RichMediaBrowserManager.getInstance().getProvider() != null)
    {
      if (paramView.isAutoPlay)
      {
        this.jdField_b_of_type_Amcy.P(paramView.msgId, paramView.subId, 1);
        localamcp.a(paramView, (amcl)RichMediaBrowserManager.getInstance().getProvider());
      }
      if ((!aqhq.fileExistsAndNotEmpty(paramView.mFilePath)) && (this.jdField_b_of_type_Amcy.le(this.jdField_b_of_type_Amcy.getCurrentPosition()))) {
        this.jdField_b_of_type_Amcy.OK(false);
      }
      updateUI();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "FileVideo_AP onItemSelected needUrl return");
      return;
    }
    if ((this.jdField_b_of_type_Amcy.lg(paramInt)) && (paramAdapterView.isEnterImage)) {
      f(localamcp.a(paramView, paramView.isMutePlay));
    }
    if ((!aqhq.fileExistsAndNotEmpty(paramView.mFilePath)) && (this.jdField_b_of_type_Amcy.le(this.jdField_b_of_type_Amcy.getCurrentPosition()))) {
      this.jdField_b_of_type_Amcy.OK(false);
    }
    this.zj = null;
    this.bZM = null;
    updateUI();
  }
  
  public void onPause()
  {
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
      }
      this.jdField_b_of_type_Amcy.dMz();
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onResume");
    if ((this.jdField_b_of_type_Amcy.lg(this.jdField_b_of_type_Amcy.getCurrentPosition())) && (this.mVideoView != null))
    {
      AIOFileVideoData localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
      if ((localAIOFileVideoData != null) && (localAIOFileVideoData.status == 6)) {
        this.mVideoView.resume();
      }
    }
  }
  
  public void onScrollHalfScreenWidth()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "onScrollHalfScreenWidth");
    }
    super.onScrollHalfScreenWidth();
    if ((this.mVideoView != null) && (this.mVideoView.mIsPlayVideo))
    {
      this.mVideoView.pause();
      this.jdField_b_of_type_Amcy.c(b());
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    if (this.mVideoView != null)
    {
      this.mVideoView.releasePlayer(true);
      this.jdField_b_of_type_Amcy.c(b());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onStopTrackingTouch");
    if ((this.jdField_b_of_type_Amcy.a() != null) && (this.jdField_b_of_type_Amcy.le(this.jdField_b_of_type_Amcy.getCurrentPosition())) && (paramSeekBar != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "seek danmaku");
      this.jdField_b_of_type_Amcy.a().seek(paramSeekBar.getProgress());
      AIOFileVideoData localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
      if (localAIOFileVideoData != null) {
        this.jdField_b_of_type_Amcy.a().jJ(amch.a(localAIOFileVideoData.shmsgseq, paramSeekBar.getProgress(), this.jdField_b_of_type_Amcy.a(), this.jdField_b_of_type_Amcy.gM));
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void showActionSheet(int paramInt)
  {
    super.showActionSheet(paramInt);
    AIOFileVideoData localAIOFileVideoData = this.jdField_b_of_type_Amcy.a();
    if (localAIOFileVideoData != null) {
      a(localAIOFileVideoData, paramInt);
    }
  }
  
  public void updateUI()
  {
    int i = 8;
    super.updateUI();
    Object localObject1 = this.jdField_b_of_type_Amcy.a();
    if (localObject1 != null)
    {
      OP(SH());
      OQ(c(this.jdField_b_of_type_Amcy.getSelectedItem()));
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "updateUI id = " + ((AIOFileVideoData)localObject1).id + ", status = " + ((AIOFileVideoData)localObject1).yQ());
    }
    float f;
    switch (((AIOFileVideoData)localObject1).status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "updateUI status is error, status = " + ((AIOFileVideoData)localObject1).status);
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 5: 
      do
      {
        return;
        this.jdField_b_of_type_Amcy.onLoadFinish(this.jdField_b_of_type_Amcy.getSelectedIndex(), true);
        OV(false);
        localObject2 = this.mContext.getString(2131694118) + "(" + aueh.g(((AIOFileVideoData)localObject1).aix) + "/" + aueh.g(((AIOFileVideoData)localObject1).size) + ")";
        this.Kl.setText((CharSequence)localObject2);
        f = (float)((AIOFileVideoData)localObject1).aix / (float)((AIOFileVideoData)localObject1).size;
        this.l.setProgress((int)(f * 100.0F) * 100);
        zA(true);
        OQ(false);
        this.hQ.setVisibility(8);
        this.mErrLayout.setVisibility(8);
        this.mCenterPlayBtn.setVisibility(8);
        ax(false);
        return;
        this.jdField_b_of_type_Amcy.onLoadFinish(this.jdField_b_of_type_Amcy.getSelectedIndex(), true);
        f = (float)((AIOFileVideoData)localObject1).aix / (float)((AIOFileVideoData)localObject1).size * 100.0F;
        localObject1 = new DecimalFormat("0.00").format(f);
        this.Kl.setText(acfp.m(2131702199) + (String)localObject1 + "%");
        this.l.setProgress((int)f * 100);
        this.hQ.setVisibility(8);
        OV(false);
        zA(true);
        OQ(false);
        this.mErrLayout.setVisibility(8);
        this.mCenterPlayBtn.setVisibility(8);
        ax(false);
        return;
        localObject1 = this.mContext.getString(2131694118) + "(0/" + aueh.g(((AIOFileVideoData)localObject1).size) + ")";
        this.Kl.setText((CharSequence)localObject1);
        this.l.setProgress(0);
        zA(true);
        this.hQ.setVisibility(8);
        OV(false);
        this.mErrLayout.setVisibility(8);
        this.mCenterPlayBtn.setVisibility(8);
        OQ(false);
        ax(false);
        return;
        if (this.mVideoView.isPlaying())
        {
          this.hQ.setVisibility(0);
          this.jdField_b_of_type_Amcy.onLoadFinish(this.jdField_b_of_type_Amcy.getSelectedIndex(), true);
          if (!((AIOFileVideoData)localObject1).bit) {
            break label705;
          }
          OV(true);
          zA(false);
        }
        for (;;)
        {
          this.mCenterPlayBtn.setVisibility(8);
          this.mErrLayout.setVisibility(8);
          ax(true);
          return;
          this.hQ.setVisibility(8);
          break;
          zA(true);
          OV(false);
          OQ(false);
        }
        this.jdField_b_of_type_Amcy.onLoadFinish(this.jdField_b_of_type_Amcy.getSelectedIndex(), true);
        OV(true);
        zA(false);
        this.hQ.setVisibility(8);
        this.mErrLayout.setVisibility(8);
        this.mCenterPlayBtn.setVisibility(8);
        this.jO.setImageResource(2130847021);
        ax(true);
        this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setVisibility(8);
      } while (this.mVideoView == null);
      long l1 = this.mVideoView.getVideoDurationMs();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "videoDuration = " + l1);
      this.Bu.setText(ShortVideoUtils.stringForTime(l1));
      this.Bv.setText(ShortVideoUtils.stringForTime(0L));
      return;
    case 6: 
      this.jdField_b_of_type_Amcy.onLoadFinish(this.jdField_b_of_type_Amcy.getSelectedIndex(), true);
      OV(true);
      zA(false);
      this.hQ.setVisibility(8);
      this.mErrLayout.setVisibility(8);
      this.mCenterPlayBtn.setVisibility(0);
      this.jO.setImageResource(2130847020);
      ax(true);
      return;
    case 7: 
      label705:
      this.jdField_b_of_type_Amcy.onLoadFinish(this.jdField_b_of_type_Amcy.getSelectedIndex(), true);
      OV(false);
      if (((AIOFileVideoData)localObject1).bit) {
        zA(false);
      }
      for (;;)
      {
        this.hQ.setVisibility(8);
        this.mErrLayout.setVisibility(0);
        this.mCenterPlayBtn.setVisibility(8);
        this.jO.setImageResource(2130847020);
        ax(false);
        return;
        localObject2 = this.mContext.getString(2131694118) + "(" + aueh.g(((AIOFileVideoData)localObject1).aix) + "/" + aueh.g(((AIOFileVideoData)localObject1).size) + ")";
        this.Kl.setText((CharSequence)localObject2);
        f = (float)((AIOFileVideoData)localObject1).aix / (float)((AIOFileVideoData)localObject1).size;
        this.l.setProgress((int)(f * 100.0F) * 100);
        zA(true);
      }
    }
    this.jdField_b_of_type_Amcy.onLoadFinish(this.jdField_b_of_type_Amcy.getSelectedIndex(), true);
    OV(false);
    zA(false);
    this.hQ.setVisibility(8);
    this.mErrLayout.setVisibility(8);
    Object localObject2 = this.mCenterPlayBtn;
    if (((AIOFileVideoData)localObject1).isAutoPlay)
    {
      ((ImageView)localObject2).setVisibility(i);
      this.jO.setImageResource(2130847020);
      this.Bv.setText(ShortVideoUtils.stringForTime(0L));
      this.m.setProgress(0);
      if (!((AIOFileVideoData)localObject1).bit) {
        break label1248;
      }
      ax(true);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setVisibility(0);
      return;
      i = 0;
      break;
      label1248:
      ax(false);
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_b_of_type_Amcy.getItem(paramInt);
    if ((localObject1 == null) || (((RichMediaBrowserInfo)localObject1).baseData == null) || (paramView == null)) {
      return;
    }
    BaseVideoView localBaseVideoView;
    if ((paramView.getTag() instanceof amdw.a))
    {
      localBaseVideoView = ((amdw.a)paramView.getTag()).c;
      if (((RichMediaBrowserInfo)localObject1).baseData.getType() == 103)
      {
        Object localObject2 = (AIOFileVideoData)((RichMediaBrowserInfo)localObject1).baseData;
        amcp localamcp = new amcp();
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        localObject2 = localamcp.a((AIOFileVideoData)localObject2);
        if (localObject2 == null) {
          break label196;
        }
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1) {
          break label172;
        }
        localBaseVideoView.setCoverDrawable((Drawable)localObject1);
        this.jdField_b_of_type_Amcy.onLoadFinish(paramInt, true);
        this.jdField_b_of_type_Amcy.a().dLE();
      }
    }
    for (;;)
    {
      super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
      return;
      label172:
      ((URLDrawable)localObject1).setTag(Integer.valueOf(1));
      ((URLDrawable)localObject1).startDownload();
      localBaseVideoView.setCoverDrawable((Drawable)localObject1);
      break;
      label196:
      localBaseVideoView.setCoverDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158));
      this.jdField_b_of_type_Amcy.onLoadFinish(paramInt, true);
    }
  }
  
  public void wj(int paramInt)
  {
    super.wj(paramInt);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_b_of_type_Amcy.getItem(paramInt);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {
      return;
    }
    Object localObject;
    AIOFileVideoData localAIOFileVideoData;
    amcp localamcp;
    if (localRichMediaBrowserInfo.baseData.getType() == 103)
    {
      localObject = this.jdField_b_of_type_Amcy.a();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null) || (((RichMediaBrowserInfo)localObject).baseData.getType() != 103) || (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).msgId != ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).msgId) || (((RichMediaBrowserInfo)localObject).isReport)) {
        break label300;
      }
      anot.a(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      ((RichMediaBrowserInfo)localObject).isReport = true;
      localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      localamcp = new amcp();
      localObject = (Drawable)this.jdField_b_of_type_Amcy.mActiveDrawable.get(Integer.valueOf(paramInt));
      if (!localamcp.c(localAIOFileVideoData)) {
        break label330;
      }
    }
    for (;;)
    {
      this.lN.setTag(2131296433, Boolean.valueOf(true));
      this.lN.setId(2131374853);
      this.lN.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setImageDrawable((Drawable)localObject);
      this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setContentDescription(this.mContext.getString(2131692634));
      if (localamcp.c(localAIOFileVideoData)) {
        this.jdField_b_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setImageDrawable(null);
      }
      if (localRichMediaBrowserInfo.isEnterImage) {
        localAIOFileVideoData.biv = true;
      }
      localObject = new amdw.a();
      ((amdw.a)localObject).c = this.mVideoView;
      this.lN.setTag(localObject);
      return;
      label300:
      anot.a(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
      break;
      label330:
      if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 1)) {
        break label357;
      }
      this.jdField_b_of_type_Amcy.onLoadFinish(paramInt, true);
    }
    label357:
    if (!TextUtils.isEmpty(localAIOFileVideoData.bN))
    {
      File localFile = new File(localAIOFileVideoData.bN);
      if (!localFile.exists()) {
        break label483;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.mScreenWidthPx;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.mScreenHeightPx;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      localObject = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(Integer.valueOf(1));
      this.jdField_b_of_type_Amcy.mActiveDrawable.put(Integer.valueOf(paramInt), (URLDrawable)localObject);
    }
    label483:
    for (;;)
    {
      break;
      localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158);
      break;
    }
  }
  
  public void zA(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.hP != null)
    {
      localRelativeLayout = this.hP;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      OW(SH());
      return;
    }
  }
  
  public class a
    extends IBrowserViewHolder
  {
    public BaseVideoView c;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdw
 * JD-Core Version:    0.7.0.1
 */