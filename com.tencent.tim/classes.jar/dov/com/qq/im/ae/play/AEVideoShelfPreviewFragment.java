package dov.com.qq.im.ae.play;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.ColorDrawable;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import arht;
import aurs;
import awtn;
import awtn.d.b;
import axcg;
import axhr;
import axhs;
import axht;
import axim;
import axiw;
import axiy;
import ayja;
import azbq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView;
import cooperation.qzone.QzoneFeedsPluginProxyActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import rox;
import vnk;
import wja;

public class AEVideoShelfPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, IVideoShelfPlayerListener, vnk
{
  private static final String TAG = AEVideoShelfPreviewFragment.class.getSimpleName();
  private static PowerManager.WakeLock wakeLock;
  private View MF;
  private View MG;
  private VideoShelfEngine jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine;
  private VideoShelfPlayView jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView;
  private long aBQ;
  private long aBR;
  private TextView ahe;
  arht b;
  private String cUi;
  private String cUq;
  private String cUs;
  private String cUx;
  private ArrayList<String> dQ;
  private double dr;
  private double ds;
  private boolean duD;
  private boolean duE;
  private boolean duF;
  private boolean duG;
  private boolean duH;
  private boolean duI = true;
  private boolean duJ;
  private volatile boolean duK;
  private int eEV;
  private int eEX;
  private int eEY;
  private Button editButton;
  private String mAudioPath;
  private Dialog mDialog;
  private String mInputVideo;
  private Timer mTimer;
  private String mVideoPath;
  private HashMap<String, int[]> rb;
  private int status = 0;
  
  private arht a()
  {
    arht localarht = new arht(getActivity());
    localarht.YE(wja.dp2px(50.0F, getActivity().getResources()));
    localarht.setDrawImageFillView(true);
    localarht.setShowStroke(false);
    localarht.setTextColor(-1);
    localarht.setBackgroundColor(0);
    localarht.setProgressColor(-15550475);
    localarht.setProgressStrokeWidth(3);
    localarht.dbf = true;
    localarht.mAnimationStep = 2;
    localarht.TM(true);
    localarht.a(new axht(this));
    return localarht;
  }
  
  private boolean aA(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView == null))
    {
      axiy.w(TAG, "pagFileInit error");
      return false;
    }
    this.mInputVideo = paramIntent.getStringExtra("pagFilePath");
    this.mAudioPath = paramIntent.getStringExtra("audioFilePath");
    if (paramIntent.getBooleanExtra("isFromAsset", false))
    {
      if (!TextUtils.isEmpty(this.mAudioPath)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setAudioPathFromAsset(this.mAudioPath, getActivity().getAssets());
      }
      if (!TextUtils.isEmpty(this.mInputVideo)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setVideoFilePathFromAsset(this.mInputVideo, getActivity().getAssets());
      }
    }
    for (;;)
    {
      Object localObject = paramIntent.getExtras();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getSerializable("nodeImgList");
        if ((localObject instanceof HashMap))
        {
          this.rb = ((HashMap)localObject);
          this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setParam("imgGroup", new Object[] { this.rb });
        }
      }
      this.eEX = paramIntent.getIntExtra("videoOutWidth", 540);
      this.eEY = paramIntent.getIntExtra("videoOutHeight", 960);
      return true;
      axiy.w(TAG, "pagFileInit Asset Path error");
      return false;
      if (!TextUtils.isEmpty(this.mAudioPath)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setAudioPath(this.mAudioPath);
      }
      if (TextUtils.isEmpty(this.mInputVideo)) {
        break;
      }
      this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setVideoFilePath(this.mInputVideo);
    }
    axiy.w(TAG, "pagFileInit not Asset Path error");
    return false;
  }
  
  public static void ad(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(536870922, TAG);
      wakeLock.acquire();
      axiy.i(TAG, "keepScreenOn!");
      return;
    }
    if (wakeLock != null)
    {
      wakeLock.release();
      wakeLock = null;
    }
    axiy.i(TAG, "keepScreenOff!");
  }
  
  public static Bitmap c(String paramString, int paramInt1, int paramInt2)
  {
    paramString = ThumbnailUtils.createVideoThumbnail(paramString, paramInt2);
    paramInt2 = paramString.getWidth();
    int i = paramString.getHeight();
    if (paramInt2 > paramInt1)
    {
      i = (int)(1.0D * i * paramInt1 / paramInt2);
      paramInt2 = paramInt1;
    }
    for (paramInt1 = i;; paramInt1 = i) {
      return ThumbnailUtils.extractThumbnail(paramString, paramInt2, paramInt1, 2);
    }
  }
  
  private void dismissProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
  }
  
  private void eJM()
  {
    if (2 == this.status)
    {
      pauseVideo();
      return;
    }
    rp();
  }
  
  private void eKh()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null) {}
      try
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine = new VideoShelfEngine(false);
        Object localObject = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine;
        if (localObject != null)
        {
          localObject = this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.getPlayer();
          if ((localObject instanceof PagShelfPlayer))
          {
            localObject = (PagShelfPlayer)localObject;
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setSrcPath(this.mInputVideo);
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setParam("PagVideoShelfProcessor_4", this.rb);
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setOutputVideoPath(ShortVideoUtils.zL());
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.setCallback(new a(this));
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.save(this.eEX, this.eEY);
            this.duE = true;
            return;
          }
        }
      }
      catch (PagNotSupportSystemException localPagNotSupportSystemException)
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine = null;
        axiy.e(TAG, localPagNotSupportSystemException.getMessage());
        aurs.runOnUiThread(new AEVideoShelfPreviewFragment.11(this), 2000L);
      }
    }
  }
  
  private void eKk()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine == null) {
      return;
    }
    Object localObject1 = new File(this.mAudioPath);
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = AEVideoShelfEditFragment.bn(BaseApplicationImpl.getContext());; bool = true)
    {
      label76:
      String str;
      StringBuilder localStringBuilder;
      if ((((File)localObject1).exists()) && (this.mAudioPath != null) && (this.mAudioPath.toLowerCase().endsWith(".m4a")))
      {
        if (!bool) {
          break label263;
        }
        localObject1 = awtn.sx(awtn.getCameraPath());
        str = TAG;
        localStringBuilder = new StringBuilder().append("outputDir: ").append((String)localObject1);
        if (!new File((String)localObject1).exists()) {
          break label292;
        }
      }
      label263:
      label292:
      for (Object localObject2 = " exist";; localObject2 = " not exist")
      {
        axiy.i(str, (String)localObject2);
        this.mTimer = new Timer();
        this.mTimer.schedule(new AEVideoShelfPreviewFragment.7(this), 0L, 200L);
        if (azbq.c(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath(), this.mAudioPath, (String)localObject1, 0) == 0)
        {
          localObject2 = new File(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath());
          if (((File)localObject2).exists())
          {
            axiy.i(TAG, "finishAudioVideoMerge done");
            ((File)localObject2).delete();
          }
          this.mVideoPath = ((String)localObject1);
        }
        this.mTimer.cancel();
        this.mTimer = null;
        if ((!bool) || (this.mVideoPath == null)) {
          break;
        }
        rox.a(BaseApplication.getContext(), new File(this.mVideoPath));
        return;
        localObject1 = awtn.sx(awtn.d.b.cTe + File.separator);
        break label76;
      }
    }
  }
  
  private void eKl()
  {
    if (this.eEV == 2)
    {
      getActivity().finish();
      return;
    }
    AEVideoShelfEditFragment.a(getActivity(), 22, this.cUx, this.cUi, this.cUq, this.dQ, 3);
  }
  
  private void eKm()
  {
    aurs.runOnUiThread(new AEVideoShelfPreviewFragment.6(this));
  }
  
  private void ew(Intent paramIntent)
  {
    VideoShelfPlayView localVideoShelfPlayView;
    if (this.duJ)
    {
      this.editButton.setVisibility(0);
      if (this.eEV == 2) {
        this.editButton.setVisibility(8);
      }
      localVideoShelfPlayView = this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView;
      if (this.duG) {
        break label95;
      }
    }
    boolean bool2;
    label95:
    for (boolean bool1 = true;; bool1 = false)
    {
      localVideoShelfPlayView.setVideoType(bool1);
      this.duD = false;
      if (!this.duG) {
        break label100;
      }
      bool2 = aA(paramIntent);
      if (bool2) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.start();
      }
      return;
      this.editButton.setVisibility(8);
      break;
    }
    label100:
    this.mInputVideo = paramIntent.getStringExtra("FinalVideoPath");
    if (!TextUtils.isEmpty(this.mInputVideo)) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setVideoFilePath(this.mInputVideo);
      this.duD = true;
      this.mVideoPath = this.mInputVideo;
      bool2 = bool1;
      break;
    }
  }
  
  public static void i(Context paramContext, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("jump_in_from", paramInt);
    PublicFragmentActivity.b.start(paramContext, paramIntent, PublicFragmentActivityForPeak.class, AEVideoShelfPreviewFragment.class);
  }
  
  @TargetApi(14)
  private void iZ()
  {
    this.mDialog = new ReportDialog(getActivity());
    Object localObject = this.mDialog.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject).setDimAmount(0.0F);
      }
    }
    this.mDialog.requestWindowFeature(1);
    this.mDialog.setContentView(2131562035);
    localObject = (ImageView)this.mDialog.findViewById(2131373659);
    this.b = a();
    ((ImageView)localObject).setImageDrawable(this.b);
    ((TextView)this.mDialog.findViewById(2131371989)).setText(2131690013);
    this.mDialog.setCancelable(true);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setOnCancelListener(new axhs(this));
    this.b.setProgress(0);
  }
  
  private void initData(Intent paramIntent)
  {
    this.duI = true;
    this.eEV = paramIntent.getIntExtra("jump_in_from", 0);
    this.cUx = paramIntent.getStringExtra("MaterialPath");
    this.cUq = paramIntent.getStringExtra("MaterialName");
    this.cUi = paramIntent.getStringExtra("MaterialId");
    if (TextUtils.isEmpty(this.cUs)) {
      this.cUs = paramIntent.getStringExtra("loc_play_show_take_same_name");
    }
    getActivity().getIntent().putExtra("key_camera_material_name", this.cUs);
    this.dQ = paramIntent.getStringArrayListExtra("PhotoList");
    this.duH = paramIntent.getBooleanExtra("from", true);
    this.duJ = paramIntent.getBooleanExtra("isNeedEditButton", false);
    this.duG = paramIntent.getBooleanExtra("usePagPreview", false);
  }
  
  private void initView()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getActivity().getWindow();
      if (localObject != null) {
        ((Window)localObject).setStatusBarColor(-16777216);
      }
    }
    this.ahe = ((TextView)getActivity().findViewById(2131373408));
    this.ahe.setText("0(fps)");
    this.ahe.setTextColor(-65536);
    this.MF = getActivity().findViewById(2131381578);
    this.MF.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView = ((VideoShelfPlayView)this.MF.findViewById(2131381588));
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setOnPlayerListener(this);
    this.MG = this.MF.findViewById(2131373366);
    this.editButton = ((Button)getActivity().findViewById(2131366209));
    this.editButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.getViewTreeObserver().addOnGlobalLayoutListener(new axhr(this));
    getActivity().findViewById(2131363222).setOnClickListener(this);
    Object localObject = (TextView)getActivity().findViewById(2131363974);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setText(2131690000);
    iZ();
  }
  
  private void onCancelCompleted()
  {
    axiy.i(TAG, "Merge Video step onCancelCompleted");
    this.aBR = 0L;
    this.duE = false;
    this.duF = false;
    Object localObject = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.getOutputVideoPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        ((File)localObject).delete();
        axiy.i(TAG, "onCancelCompleted---delete temp video because user cancel");
      }
    }
    aurs.runOnUiThread(new AEVideoShelfPreviewFragment.10(this));
    this.duD = false;
  }
  
  private void onError(int paramInt1, int paramInt2, String paramString)
  {
    axiy.w(TAG, "Merge Video step onError");
    this.aBR = 0L;
    onError(paramInt1, paramString, null);
    this.duE = false;
    ad(getActivity(), false);
  }
  
  private void onProgress(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.aBQ > 200L)
    {
      aurs.runOnUiThread(new AEVideoShelfPreviewFragment.9(this, paramInt));
      this.aBQ = l;
    }
  }
  
  private void onStartGenerate()
  {
    axiy.i(TAG, "Merge Video step onStartGenerate");
    this.aBR = System.currentTimeMillis();
    aurs.runOnUiThread(new AEVideoShelfPreviewFragment.8(this));
  }
  
  private void pauseVideo()
  {
    this.status = 1;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.pause();
    this.MG.setVisibility(0);
    this.ahe.setText("0(fps)");
  }
  
  private void rp()
  {
    this.status = 2;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.resume();
    this.MG.setVisibility(8);
  }
  
  private void showProgressDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.show();
    }
  }
  
  private void updateProgress(int paramInt)
  {
    if (this.b == null) {
      return;
    }
    this.b.stopAnimating();
    this.b.setProgress(paramInt);
    this.b.setShowText(true);
    this.b.setShowImage(false);
    this.b.setText(paramInt + "%");
  }
  
  public String getThumbPath()
  {
    Bitmap localBitmap = c(this.mVideoPath, 300, 1);
    Object localObject = new File(awtn.d.b.cTd);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = awtn.d.b.cTd + File.separator + Md5Utils.getMD5(this.mVideoPath) + ".jpg";
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(new File((String)localObject));
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.close();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
    return null;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 22) {
      if (paramInt2 == -1)
      {
        initData(paramIntent);
        ew(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 21);
      axim.a().acI(this.cUi);
    } while (paramInt2 != -1);
    if ((axcg.G(getActivity())) || (axcg.at(getActivity().getIntent()))) {}
    for (paramIntent = new Intent(getActivity(), QzoneFeedsPluginProxyActivity.class);; paramIntent = new Intent(getActivity(), SplashActivity.class))
    {
      paramIntent.addFlags(67108864);
      paramIntent.addFlags(536870912);
      startActivity(paramIntent);
      return;
    }
  }
  
  public void onBackPressed()
  {
    getActivity().finish();
    axim.a().eKC();
  }
  
  public void onChangVideoSize(int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (axiw.Y(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363222: 
        onBackPressed();
        break;
      case 2131381578: 
        eJM();
        break;
      case 2131363974: 
        if (!this.duD)
        {
          pauseVideo();
          this.duF = true;
          if (!this.duE) {
            eKh();
          } else {
            eKm();
          }
        }
        else
        {
          ayja.a(getActivity(), this.mVideoPath, getThumbPath(), axcg.G(getActivity()), "caller_aecamera");
        }
        break;
      case 2131366209: 
        eKl();
        axim.a().eKD();
      }
    }
  }
  
  public void onCompletion()
  {
    if (this.aBR > 0L) {}
    for (long l = System.currentTimeMillis() - this.aBR;; l = 0L)
    {
      this.aBR = 0L;
      eKk();
      aurs.runOnUiThread(new AEVideoShelfPreviewFragment.5(this, l));
      this.duE = false;
      this.duD = true;
      axiy.i(TAG, "Merge Video step onCompletion");
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558559, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.rb != null) {
      this.rb.clear();
    }
    if (this.dQ != null) {
      this.dQ.clear();
    }
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.setOnPlayerListener(null);
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.stop();
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView = null;
    ad(getActivity(), false);
    super.onDestroy();
  }
  
  public boolean onError(int paramInt, String paramString, Object paramObject)
  {
    int i = 1;
    if (-3 == paramInt) {
      return true;
    }
    paramObject = null;
    long l2 = -1L;
    if (this.mInputVideo != null) {
      paramObject = new File(this.mInputVideo);
    }
    long l1 = l2;
    if (paramObject != null)
    {
      l1 = l2;
      if (paramObject.exists())
      {
        l1 = l2;
        if (paramObject.isFile()) {
          l1 = paramObject.length();
        }
      }
    }
    if (this.mInputVideo == null) {}
    for (;;)
    {
      axiy.e(TAG, "Fun video videoShelfPlayView onError: what: " + paramInt + ", extra: " + paramString + ", FilePath: " + this.mInputVideo + ", FileSize: " + l1 + " dirInfo: " + i);
      return false;
      if (this.mInputVideo.contains(File.separator))
      {
        paramObject = this.mInputVideo.substring(0, this.mInputVideo.lastIndexOf(File.separator));
        if (new File(paramObject).exists())
        {
          if (DeviceUtils.canWriteFile(paramObject, false)) {
            i = 0;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public void onPause()
  {
    Log.i("VideoShelfPlayView", "onPause...");
    pauseVideo();
    if ((this.duE) || (!this.duD))
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine != null) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelVideoShelfEngine.cancelSave();
      }
      this.duE = false;
      this.duF = false;
    }
    super.onPause();
  }
  
  public void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer)
  {
    if (paramIVideoShelfPlayer == null) {
      return;
    }
    paramIVideoShelfPlayer.setLooping(true);
    this.status = 2;
  }
  
  public void onResume()
  {
    Log.i("VideoShelfPlayView", "onResume...");
    super.onResume();
    this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.flush();
    if (this.duI)
    {
      if ((2 == this.status) || (1 == this.status)) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfUiVideoShelfPlayView.postDelayed(new AEVideoShelfPreviewFragment.4(this), 200L);
      }
      this.duI = false;
    }
  }
  
  public void onUpdateRate(long paramLong)
  {
    this.ahe.setText(paramLong + "(fps)");
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initView();
    paramView = getActivity().getIntent();
    if (paramView == null) {
      return;
    }
    initData(paramView);
    ew(paramView);
  }
  
  static class a
    implements VideoShelfEngine.Callback
  {
    private WeakReference<AEVideoShelfPreviewFragment> mRef;
    
    public a(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment)
    {
      this.mRef = new WeakReference(paramAEVideoShelfPreviewFragment);
    }
    
    public void onCancelCompleted()
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        AEVideoShelfPreviewFragment.e((AEVideoShelfPreviewFragment)this.mRef.get());
      }
    }
    
    public void onCompleted()
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        ((AEVideoShelfPreviewFragment)this.mRef.get()).onCompletion();
      }
    }
    
    public void onError(int paramInt1, int paramInt2, String paramString)
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        AEVideoShelfPreviewFragment.a((AEVideoShelfPreviewFragment)this.mRef.get(), paramInt1, paramInt2, paramString);
      }
    }
    
    public void onProgress(int paramInt)
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        AEVideoShelfPreviewFragment.b((AEVideoShelfPreviewFragment)this.mRef.get(), paramInt);
      }
    }
    
    public void onStartGenerate()
    {
      if ((this.mRef != null) && (this.mRef.get() != null)) {
        AEVideoShelfPreviewFragment.d((AEVideoShelfPreviewFragment)this.mRef.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment
 * JD-Core Version:    0.7.0.1
 */