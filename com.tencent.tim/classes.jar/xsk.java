import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.15;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.2;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.20;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.21;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.27;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.3;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.31;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.4;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.a;
import com.tencent.mobileqq.activity.photo.ProGallery.b;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class xsk
  extends sxi
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, ausj.e, ProGallery.a, INetInfoHandler, xsi.a, ztj.b, ztk.a
{
  long Jw = 0L;
  TextView Kk;
  public TextView Kl;
  public TextView Km;
  TextView Kn;
  public TextView Ko;
  String QE;
  anjo jdField_a_of_type_Anjo;
  arlq jdField_a_of_type_Arlq;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  xsk.a jdField_a_of_type_Xsk$a;
  protected xsk.b a;
  public xuh a;
  public boolean aGH;
  String aRJ;
  String aWe;
  String aWf;
  String aWg;
  ImageButton al;
  ImageButton am;
  ImageButton an;
  private aduk jdField_b_of_type_Aduk;
  arht jdField_b_of_type_Arht;
  public AIOGalleryAdapter b;
  public final MqqHandler b;
  public xto b;
  private int bFu;
  final int bWL = -3321;
  int bWM;
  final int bWN = -2147483648;
  int bWO;
  int bWP = 1;
  int bWQ = 0;
  protected int bWR = -1;
  int bWS;
  boolean biF = false;
  boolean biG = false;
  boolean biH = false;
  boolean biI = false;
  boolean biJ;
  boolean biK = false;
  boolean biL;
  boolean biM;
  boolean biN = false;
  boolean biO;
  boolean biP = false;
  boolean biQ = false;
  boolean biR = true;
  protected boolean biS;
  boolean biT = false;
  boolean biU;
  public int bpE = 5;
  AIORichMediaData c;
  public ShareActionSheetBuilder c;
  public ztk c;
  ImageView closeBtn;
  boolean ed = false;
  public final Runnable et = new AIOGalleryScene.2(this);
  public final Runnable eu = new AIOGalleryScene.3(this);
  MessageQueue.IdleHandler f = new xte(this);
  RelativeLayout hP;
  RelativeLayout hQ;
  public LinearLayout hi;
  boolean isLoading = false;
  ImageButton k;
  public SeekBar l;
  public SeekBar m;
  int mCurType;
  private Dialog mDialog;
  public String mFilePath;
  String mFriendUin;
  public boolean mIsMute;
  int midScreenWidth;
  private String nickName;
  public int progress;
  ImageView tN;
  
  public xsk(Activity paramActivity, sxm paramsxm, xuh paramxuh, String paramString)
  {
    super(paramActivity, paramsxm);
    this.jdField_c_of_type_Ztk = new ztl();
    this.jdField_a_of_type_Xsk$b = new xsk.b();
    this.jdField_b_of_type_MqqOsMqqHandler = new xtf(this);
    this.jdField_b_of_type_Xto = ((xto)paramsxm);
    this.jdField_a_of_type_Xuh = paramxuh;
    ((ztl)this.jdField_c_of_type_Ztk).a(paramxuh);
    this.aWf = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.aWf = axol.getAppInterface().getCurrentAccountUin();
    }
    paramsxm = (PeakAppInterface)((PeakActivity)paramActivity).getAppRuntime();
    if (paramsxm != null) {
      ((achu)paramsxm.getBusinessHandler(2)).dP(paramActivity);
    }
  }
  
  private void Ds(int paramInt)
  {
    if (!this.biH)
    {
      if (!this.jdField_b_of_type_Xto.SL()) {
        break label22;
      }
      notifyImageModelDataChanged();
    }
    for (;;)
    {
      return;
      label22:
      int i = this.jdField_b_of_type_Xto.getCount();
      if (this.biM)
      {
        if (i - paramInt <= 0) {
          break label156;
        }
        if (paramInt > i - 25) {
          paramInt = 1;
        }
      }
      while ((i != 1) && (paramInt != 0) && (!this.isLoading) && (this.bFu != i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "[onItemSelected] loadMedias: mLastLoadCount=" + this.bFu);
        }
        this.bFu = this.jdField_b_of_type_Xto.getCount();
        this.jdField_a_of_type_Xuh.loadMedias(0);
        return;
        paramInt = 0;
        continue;
        if (paramInt < 25)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
          continue;
          label156:
          paramInt = 0;
        }
      }
    }
  }
  
  private void Dt(int paramInt)
  {
    xuf localxuf = this.jdField_b_of_type_Xto.a(paramInt);
    if ((localxuf != null) && ((localxuf.e instanceof AIOFilePicData)))
    {
      this.Kk.setText(String.format(Locale.CHINA, this.mContext.getString(2131697154), new Object[] { ahbj.g(localxuf.e.size) }));
      if (localxuf.e.size <= agmx.fL()) {
        break label202;
      }
      gm(true);
      this.jdField_b_of_type_ComTencentWidgetGallery.enableDoubleTap(false);
      this.jdField_b_of_type_ComTencentWidgetGallery.enableScaleGesture(false);
    }
    for (;;)
    {
      if ((localxuf != null) && ((localxuf.e instanceof AIOImageData)) && (((AIOImageData)localxuf.e).istroop == 1))
      {
        this.Kk.setText(String.format(Locale.CHINA, this.mContext.getString(2131697154), new Object[] { ahbj.g(localxuf.e.size) }));
        if (localxuf.e.size <= agmx.fL()) {
          break;
        }
        gm(true);
        this.jdField_b_of_type_ComTencentWidgetGallery.enableDoubleTap(false);
        this.jdField_b_of_type_ComTencentWidgetGallery.enableScaleGesture(false);
      }
      return;
      label202:
      gm(true);
    }
    gm(true);
  }
  
  private void U(long paramLong1, long paramLong2)
  {
    xuf localxuf = this.jdField_b_of_type_Xto.c();
    if (!AIOFilePicData.class.isInstance(localxuf.e)) {}
    AIOFilePicData localAIOFilePicData;
    do
    {
      return;
      localAIOFilePicData = (AIOFilePicData)localxuf.e;
      localAIOFilePicData.bir = true;
      if (this.jdField_a_of_type_Xsk$a == null)
      {
        this.jdField_a_of_type_Xsk$a = new xsk.a();
        this.jdField_a_of_type_Xsk$a.id = localxuf.e.id;
        this.jdField_a_of_type_Xsk$a.subId = localxuf.e.subId;
      }
    } while ((localAIOFilePicData.id != paramLong1) || (this.l == null));
    zA(true);
    this.jdField_b_of_type_Xto.c().progress = this.progress;
    this.Kl.setText(acfp.m(2131702228) + ahbj.g((paramLong2 * (this.progress / 10000.0D))) + "/" + ahbj.g(paramLong2) + ")");
    this.l.setProgress(this.progress);
  }
  
  private arht a(Context paramContext)
  {
    arht localarht = new arht(paramContext);
    localarht.YE(wja.dp2px(50.0F, paramContext.getResources()));
    localarht.setDrawImageFillView(true);
    localarht.setShowStroke(false);
    localarht.setTextColor(-1);
    localarht.setBackgroundColor(0);
    localarht.setProgressColor(-15550475);
    localarht.setProgressStrokeWidth(3);
    localarht.dbf = true;
    localarht.mAnimationStep = 2;
    localarht.TM(true);
    localarht.a(new xta(this));
    return localarht;
  }
  
  private File a(AIORichMediaData paramAIORichMediaData)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((paramAIORichMediaData instanceof AIOImageData))
    {
      localObject1 = paramAIORichMediaData.c(4);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramAIORichMediaData.c(2);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramAIORichMediaData.c(1);
      }
    }
    do
    {
      do
      {
        return localObject1;
      } while (!(paramAIORichMediaData instanceof AIOFilePicData));
      localObject1 = paramAIORichMediaData.c(20);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramAIORichMediaData.c(18);
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    return paramAIORichMediaData.c(16);
  }
  
  private <T extends xuf> T a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_b_of_type_Xto.be().iterator();
    while (localIterator.hasNext())
    {
      xuf localxuf = (xuf)localIterator.next();
      if ((localxuf.e.id == paramLong1) && (localxuf.e.subId == paramLong2)) {
        return localxuf;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.mContext.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = paramString;
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.mContext.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = "";
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, int paramInt4)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.mContext.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = "";
    localActionSheetItem.firstLineCount = paramInt4;
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    Object localObject = this.jdField_b_of_type_Xto.c().e;
    if ((((AIORichMediaData)localObject).id == paramLong1) && (((AIORichMediaData)localObject).subId == paramInt1))
    {
      this.jdField_b_of_type_Xto.c().progress = paramInt3;
      this.Kl.setText(acfp.m(2131702195) + ahbj.g((paramLong2 * (paramInt3 / 10000.0D))) + "/" + ahbj.g(paramLong2) + ")");
      this.l.setProgress(paramInt3);
    }
    do
    {
      return;
      localObject = a(paramLong1, paramInt1);
    } while (localObject == null);
    ((xuf)localObject).progress = paramInt3;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    long l1;
    Bundle localBundle;
    Intent localIntent;
    label185:
    int i;
    boolean bool1;
    label213:
    boolean bool3;
    if ((paramInt2 == 1) || (paramInt2 == 3000))
    {
      l1 = paramLong2;
      localObject = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "jumpToTargetAIOPosition, className = " + (String)localObject + ", time = " + paramLong1 + " , shmsgseq = " + paramLong2 + ", isEmotion = " + paramBoolean);
      }
      localBundle = new Bundle();
      localBundle.putBoolean("need_jump_to_msg", true);
      localBundle.putLong("searched_timeorseq", l1);
      localBundle.putLong("searched_time", paramLong1);
      localBundle.putLong("target_shmsgseq", paramLong2);
      localBundle.putBoolean("searched_update_session", true);
      localIntent = new Intent();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label396;
      }
      localIntent.setClassName(paramActivity, (String)localObject);
      i = paramActivity.getIntent().getIntExtra("extra.EXTRA_ENTRANCE", -1);
      if ((i != 2) && (i != 3)) {
        break label409;
      }
      bool1 = true;
      bool3 = paramActivity.getIntent().getBooleanExtra("from_chat_history", false);
      if (!paramBoolean) {
        break label415;
      }
    }
    label396:
    label409:
    label415:
    for (boolean bool2 = bool3;; bool2 = bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "jumpToTargetAIOPosition, isFromHistory = " + bool2 + ", isEmotion = " + paramBoolean + ", sourceEntrance = " + i + ", fromHistory_picAndVideo = " + bool1 + ", fromHistory_emotion = " + bool3);
      }
      if (!bool2) {
        break label458;
      }
      paramInt1 = paramActivity.getIntent().getIntExtra("FromChatHistoryTab", 0);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "jumpToTargetAIOPosition, fromType = " + paramInt1);
      }
      if ((paramInt1 != 2) && (paramInt1 != 4)) {
        break label438;
      }
      if (paramInt2 != 1) {
        break label422;
      }
      ChatHistoryBubbleListForTroopFragment.a(paramActivity, paramString2, paramLong2, -1, 0);
      return;
      l1 = paramLong1;
      break;
      localIntent.setClass(paramActivity, SplashActivity.class);
      break label185;
      bool1 = false;
      break label213;
    }
    label422:
    ChatHistoryActivity.a(paramActivity, paramString1, paramInt2, "", paramLong1, paramLong2, 0);
    return;
    label438:
    localIntent.putExtras(localBundle);
    paramActivity.setResult(-1, localIntent);
    paramActivity.finish();
    return;
    label458:
    Object localObject = wja.a(localIntent, null);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("uin", paramString1);
    ((Intent)localObject).putExtra("uintype", paramInt1);
    ((Intent)localObject).putExtra("troop_uin", paramString2);
    ((Intent)localObject).addFlags(603979776);
    ((Intent)localObject).putExtra("entrance", 1);
    paramActivity.startActivity((Intent)localObject);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if ((this.mContext == null) || (this.mContext.isFinishing())) {
      return;
    }
    Object localObject3 = this.jdField_b_of_type_ComTencentWidgetGallery.getSelectedView();
    SparseArray localSparseArray = new SparseArray(2);
    Object localObject1 = null;
    int j;
    int i;
    label92:
    Rect localRect;
    if ((localObject3 instanceof AIOGalleryAdapter.GalleryImageStruct))
    {
      localObject1 = (AIOGalleryAdapter.GalleryImageStruct)localObject3;
      j = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getWidth();
      int n = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getHeight();
      if (j >= n * 2)
      {
        i = 1;
        if (n < j * 2) {
          break label321;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label349;
        }
        localObject3 = new Matrix();
        ((Matrix)localObject3).set(this.jdField_b_of_type_ComTencentWidgetGallery.getChildMatrix((View)localObject1));
        localRect = new Rect(((AIOGalleryAdapter.GalleryImageStruct)localObject1).getLeft(), ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getTop(), ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getRight(), ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getBottom());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).getRegionBmp(localRect, (Matrix)localObject3, this.jdField_b_of_type_ComTencentWidgetGallery.getWidth(), this.jdField_b_of_type_ComTencentWidgetGallery.getHeight());
        if (localObject1 == null) {
          break label355;
        }
        i = rvx.a((Bitmap)localObject1, true, 3, localSparseArray) | 0x0;
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i) }));
        }
        if (localObject1 == null)
        {
          j = rvx.a(paramUri, this.mContext, 3, localSparseArray);
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(j) }));
            i = j;
          }
        }
        ThreadManager.getUIHandler().post(new AIOGalleryScene.21(this, i, localSparseArray, paramArrayList));
        if (i > 0) {
          this.aWg = paramUri.getPath();
        }
        adjv.Ld(i);
        return;
      }
      catch (Throwable localThrowable)
      {
        label321:
        if (!QLog.isColorLevel()) {
          break label349;
        }
        QLog.i("AIOGalleryScene", 2, localThrowable.getMessage(), localThrowable);
      }
      i = 0;
      break;
      j = 0;
      break label92;
      label349:
      Object localObject2 = null;
      continue;
      label355:
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private void a(ausj paramausj, AIOImageData paramAIOImageData, File paramFile1, File paramFile2)
  {
    if ((top.eD(this.mCurType) == 1032) && (paramFile1 != null)) {
      paramausj.addButton(2131694762);
    }
    paramausj.addCancelButton(2131721058);
    paramausj.a(new xsr(this, paramausj, paramAIOImageData, paramFile2));
    paramausj.show();
    paramausj.a(this);
  }
  
  private void a(AIOFilePicData paramAIOFilePicData)
  {
    this.al.setVisibility(0);
    if (paramAIOFilePicData.mFileSize > 10485760)
    {
      this.al.setEnabled(false);
      if (!ahbj.fileExistsAndNotEmpty(paramAIOFilePicData.aVY)) {
        break label134;
      }
      this.Kk.setVisibility(8);
      label47:
      if (!this.aOa) {
        break label145;
      }
      this.an.setVisibility(8);
    }
    for (;;)
    {
      if (paramAIOFilePicData.bir)
      {
        gm(false);
        this.an.setVisibility(8);
        this.al.setVisibility(8);
      }
      return;
      if ((paramAIOFilePicData.c(18) != null) || (paramAIOFilePicData.c(20) != null))
      {
        this.al.setEnabled(true);
        break;
      }
      this.al.setEnabled(false);
      break;
      label134:
      this.Kk.setVisibility(0);
      break label47;
      label145:
      this.an.setVisibility(0);
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_c_of_type_Ztk.bB(8, "");
    this.an.setVisibility(8);
    ax(true);
    if ((paramAIOFileVideoData.bit) || (paramAIOFileVideoData.SF()))
    {
      this.an.setVisibility(0);
      this.hP.setVisibility(8);
      this.hi.setVisibility(0);
    }
    if (paramAIOFileVideoData.hasError())
    {
      this.jdField_c_of_type_Ztk.bB(0, paramAIOFileVideoData.pw());
      this.hi.setVisibility(8);
    }
    if (paramAIOFileVideoData.biu)
    {
      this.hi.setVisibility(8);
      if (paramAIOFileVideoData.SF()) {
        break label178;
      }
      this.jdField_c_of_type_Ztk.Fz(8);
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_Xto.c().a.bjw)
      {
        this.hi.setVisibility(8);
        this.hP.setVisibility(8);
      }
      if (this.bWR == 3) {
        this.an.setVisibility(8);
      }
      return;
      label178:
      this.jdField_c_of_type_Ztk.Fz(0);
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131694181, 2130840526, 59, localArrayList1);
    a(2131694190, 2130840535, 53, localArrayList1);
    anot.a(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131694183, 2130845179, 67, localArrayList1);
    a(2131694192, 2130840536, 58, localArrayList1);
    a(2131694180, 2130840525, 57, localArrayList1);
    if ((this.mCurType != -1) && (!TextUtils.isEmpty(this.mFriendUin)) && (this.biR)) {
      a(2131694194, 2130840537, 54, localArrayList2);
    }
    if (ahbj.fileExistsAndNotEmpty(paramAIOFileVideoData.mFilePath)) {
      a(2131694187, 2130840531, 64, localArrayList2, 5);
    }
    a(paramAIOFileVideoData, null, false);
    paramAIOFileVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIOFileVideoData);
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIOImageData paramAIOImageData, int paramInt, xuf paramxuf)
  {
    if ((paramAIOImageData.istroop == 1) && (paramAIOImageData.bjg))
    {
      Object localObject = paramAIOImageData.c(4);
      paramxuf = (xuf)localObject;
      if (localObject == null) {
        paramxuf = paramAIOImageData.c(2);
      }
      localObject = paramxuf;
      if (paramxuf == null) {
        localObject = paramAIOImageData.c(1);
      }
      if ((localObject == null) && (this.biT)) {
        return;
      }
      a(paramAIOImageData, (File)localObject, paramInt);
      return;
    }
    f(paramxuf);
  }
  
  private void a(AIOImageData paramAIOImageData, xuf paramxuf)
  {
    this.hi.setVisibility(8);
    this.hP.setVisibility(8);
    this.hQ.setVisibility(8);
    ax(false);
    int i = this.jdField_a_of_type_Xuh.getSaveFileProgress(paramAIOImageData.id, paramAIOImageData.subId);
    if (paramxuf.a.bjs)
    {
      this.Kk.setVisibility(8);
      this.an.setVisibility(8);
      this.al.setVisibility(8);
      this.l.setProgress(0);
      this.Kl.setText(acfp.m(2131702203) + paramxuf.a.progress + "%");
      this.hP.setVisibility(0);
      if ((paramAIOImageData.EP == 3) && (AIOImageData.class.isInstance(paramAIOImageData))) {
        break label451;
      }
    }
    label365:
    do
    {
      do
      {
        return;
        if (paramxuf.a.bju)
        {
          this.Kk.setVisibility(8);
          this.an.setVisibility(8);
          this.al.setVisibility(8);
          this.l.setProgress(0);
          this.Kl.setText(acfp.m(2131702191));
          this.hP.setVisibility(0);
          paramxuf.a.bju = false;
          break;
        }
        if ((i != -1) && (!paramxuf.a.bjv))
        {
          this.Kk.setVisibility(8);
          this.an.setVisibility(8);
          this.al.setVisibility(8);
          this.l.setProgress((int)(i / 100.0D * 10000.0D));
          this.Kl.setText(acfp.m(2131702204) + i + "%");
          this.hP.setVisibility(0);
          break;
        }
        if (this.aOa)
        {
          this.an.setVisibility(8);
          if ((!paramAIOImageData.gF(4)) || (paramAIOImageData.c(4) != null)) {
            break label432;
          }
          gm(true);
        }
        for (;;)
        {
          this.al.setVisibility(0);
          if ((paramAIOImageData.c(2) == null) && (paramAIOImageData.c(4) == null)) {
            break label440;
          }
          this.al.setEnabled(true);
          break;
          this.an.setVisibility(0);
          break label365;
          gm(false);
        }
        this.al.setEnabled(false);
        break;
      } while (!paramAIOImageData.bje);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "troop show pic file, file is progressive");
      }
      this.Kk.setVisibility(8);
      this.an.setVisibility(8);
      this.al.setVisibility(8);
      this.l.setProgress(0);
      this.Kl.setText(acfp.m(2131702234) + paramxuf.a.progress + "%");
      this.hP.setVisibility(0);
    } while (this.jdField_a_of_type_Xsk$a != null);
    label432:
    label440:
    label451:
    this.jdField_a_of_type_Xsk$a = new xsk.a();
    this.jdField_a_of_type_Xsk$a.id = paramAIOImageData.id;
    this.jdField_a_of_type_Xsk$a.subId = paramAIOImageData.subId;
    this.jdField_b_of_type_Xto.c().a.bjs = true;
    paramAIOImageData.bje = false;
  }
  
  private void a(AIOImageData paramAIOImageData, xuf paramxuf, File paramFile)
  {
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new xti(this, paramAIOImageData, paramxuf, paramFile));
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new xsm(this));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile)
  {
    if (AIOFilePicData.class.isInstance(paramAIORichMediaData)) {
      xtm.a(this.mContext, paramFile, Utils.Crc64String(paramFile.getAbsolutePath()));
    }
    do
    {
      return;
      if (AIOFileVideoData.class.isInstance(paramAIORichMediaData))
      {
        paramFile = new Bundle();
        float f1 = 0.0F;
        if (ztl.class.isInstance(this.jdField_c_of_type_Ztk)) {
          f1 = ((ztl)this.jdField_c_of_type_Ztk).g(paramAIORichMediaData.id);
        }
        paramFile.putFloat("progress", f1);
        this.jdField_a_of_type_Xuh.onFileVideoStatusChange(paramAIORichMediaData.id, 13, paramFile);
        ((AIOFileVideoData)paramAIORichMediaData).biu = true;
        this.jdField_c_of_type_Ztk.pause();
        updateUI();
        return;
      }
    } while (!AIOImageData.class.isInstance(paramAIORichMediaData));
    if ((paramFile != null) && (paramFile.exists()))
    {
      xtm.a(this.mContext, paramFile, Utils.Crc64String(paramFile.getAbsolutePath()));
      return;
    }
    QLog.i("AIOGalleryScene", 1, "menu item click, troop file action AIOGallerysence, but file is null");
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131694181, 2130840526, 59, localArrayList1);
    if ((PicShareToWX.a().isEnable()) && (PicShareToWX.a().A(paramFile))) {
      a(2131694191, 2130847679, 69, localArrayList1);
    }
    a(2131694190, 2130840535, 53, localArrayList1);
    anot.a(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131694183, 2130845179, 67, localArrayList1);
    a(2131694192, 2130840536, 58, localArrayList1);
    a(2131694180, 2130840525, 57, localArrayList1);
    if ((this.mCurType != -1) && (!TextUtils.isEmpty(this.mFriendUin)) && (this.biR)) {
      a(2131694194, 2130840537, 54, localArrayList2);
    }
    if (this.biI) {
      a(2131694186, 2130840530, 52, localArrayList2, 2);
    }
    ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.20(this, paramFile, localArrayList2));
    a(paramAIORichMediaData, paramFile, true);
    paramAIORichMediaData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIORichMediaData);
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, boolean paramBoolean)
  {
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new xsv(this, paramAIORichMediaData, paramBoolean, paramFile));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString);
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
      a(this.aWg, paramAIORichMediaData.istroop, paramAIORichMediaData.bjg, paramAIORichMediaData.send_uin, paramAIORichMediaData.md5, paramAIORichMediaData.aWj, paramAIORichMediaData.uuid, 2, localIntent);
    }
    while (!AIOFilePicData.class.isInstance(paramAIORichMediaData)) {
      return;
    }
    paramString = (AIOFilePicData)paramAIORichMediaData;
    if (aqiu.ms(paramString.issend)) {}
    for (paramAIORichMediaData = this.aWf;; paramAIORichMediaData = this.mFriendUin)
    {
      a(this.aWg, paramString.peerType, true, paramAIORichMediaData, null, null, paramString.aWa, 2, localIntent);
      return;
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (this.jdField_a_of_type_Xuh.asBinder().pingBinder())
    {
      paramAIOShortVideoData = this.jdField_a_of_type_Xuh.getForwardData(paramAIOShortVideoData.id, paramAIOShortVideoData.subId, this.mCurType);
      if (paramAIOShortVideoData != null)
      {
        paramAIOShortVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_b_of_type_Xto.c() != null)
        {
          Object localObject = this.jdField_b_of_type_Xto.c().e;
          if ((localObject instanceof AIOShortVideoData))
          {
            localObject = (AIOShortVideoData)localObject;
            int i = ((AIOShortVideoData)localObject).redBagType;
            AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
            if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOShortVideoData)localObject).senderUin)))
            {
              paramAIOShortVideoData.putExtra("param_key_redbag_type", i);
              paramAIOShortVideoData.putExtra("param_key_redbag_video_id", ((AIOShortVideoData)localObject).shortVideoId);
              paramAIOShortVideoData.putExtra("from_session_uin", ((AIOShortVideoData)localObject).friendUin);
            }
            if (((AIOShortVideoData)localObject).specialVideoType == 2) {
              paramAIOShortVideoData.putExtra("special_video_type", ((AIOShortVideoData)localObject).specialVideoType);
            }
          }
        }
        ahgq.P(this.mContext, paramAIOShortVideoData);
      }
    }
    if (this.biF) {
      ajlg.report("0X8009ABC");
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, xuf paramxuf)
  {
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new xss(this, paramAIOShortVideoData, paramFile, paramInt, paramxuf));
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new xst(this));
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, xuf paramxuf)
  {
    if (paramAIOShortVideoData != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveVideo");
      }
      this.jdField_a_of_type_Xuh.downloadMedia(paramAIOShortVideoData.id, paramAIOShortVideoData.subId, 256);
    }
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, File paramFile1, AIOImageData paramAIOImageData, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, File paramFile2)
  {
    if (this.biJ)
    {
      a(2131694178, 2130840521, 48, paramArrayList1);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((this.mCurType != 1037) && (top.eD(this.mCurType) != 1044)) {
      a(2131694181, 2130840526, 49, paramArrayList1);
    }
    if ((PicShareToWX.a().isEnable()) && (PicShareToWX.a().A(paramFile1))) {
      a(2131694191, 2130847679, 69, paramArrayList1);
    }
    if (!ahwy.a().aoe()) {
      a(2131694190, 2130840535, 53, paramArrayList1);
    }
    if (!this.biJ) {
      a(2131694180, 2130840525, 57, paramArrayList1);
    }
    a(2131694192, 2130840536, 58, paramArrayList1);
    if ((this.mCurType != 1037) && (top.eD(this.mCurType) != 1044))
    {
      if ((this.mCurType != -1) && (!TextUtils.isEmpty(this.mFriendUin)) && (this.biR)) {
        a(2131694194, 2130840537, 54, paramArrayList2, 3);
      }
      if (this.biI) {
        a(2131694186, 2130840530, 52, paramArrayList2, 2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.15(this, paramFile2, paramArrayList2));
    }
  }
  
  private void a(xuf paramxuf, File paramFile)
  {
    try
    {
      paramxuf = this.jdField_a_of_type_Xuh.getFavorateParams(paramxuf.e.id, paramxuf.e.subId);
      if (paramxuf == null) {
        aviz.b(paramFile.getAbsolutePath()).b(this.mContext, this.aWf);
      }
      for (;;)
      {
        avjg.a(null, 40, 3);
        return;
        new aviz(paramxuf).b(this.mContext, this.aWf);
      }
      return;
    }
    catch (RemoteException paramxuf)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryScene", 2, "", paramxuf);
      }
      QQToast.a(this.mContext.getApplicationContext(), this.mContext.getString(2131694176), 0).show();
    }
  }
  
  private void a(xuf paramxuf, String paramString1, String[] paramArrayOfString, String paramString2, View paramView)
  {
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramxuf.e;
    if (localAIOFileVideoData.bis) {
      QLog.i("VideoPlayControllerForFile", 1, "filevideo is playing:" + paramxuf.e.id);
    }
    int i;
    for (;;)
    {
      return;
      localAIOFileVideoData.bis = true;
      if ("I:E".equals(paramString1)) {
        try
        {
          localAIOFileVideoData.retCode = Long.parseLong(paramArrayOfString[0]);
          paramString1 = paramArrayOfString[1];
          localAIOFileVideoData.ya(paramString1);
          i = 0;
          if (localAIOFileVideoData.retCode == -134L)
          {
            paramxuf = this.mContext.getString(2131720270);
            i = 1;
            label117:
            if (i != 0)
            {
              paramxuf = aqha.a(this.mContext, 230, "", paramxuf, null, acfp.m(2131702205), new xtb(this), null);
              if (paramxuf.isShowing()) {
                continue;
              }
              paramxuf.show();
              return;
            }
          }
        }
        catch (NumberFormatException paramxuf)
        {
          localAIOFileVideoData.retCode = -1L;
          localAIOFileVideoData.retMsg = paramArrayOfString[1];
        }
      }
    }
    for (;;)
    {
      paramxuf = localAIOFileVideoData.a(this.mIsMute);
      this.jdField_c_of_type_Ztk.a(paramView, paramxuf);
      if ((!AIOGalleryActivity.class.isInstance(this.mContext)) || (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.bx(localAIOFileVideoData.id))) {
        break;
      }
      ((AIOGalleryActivity)this.mContext).biA = true;
      this.jdField_c_of_type_Ztk.crM();
      this.jdField_c_of_type_Ztk.aNX();
      this.mIsMute = false;
      return;
      if (localAIOFileVideoData.retCode != -7003L)
      {
        long l1 = localAIOFileVideoData.retCode;
        paramxuf = paramString1;
        if (l1 != -6101L) {
          break label117;
        }
      }
      i = 1;
      paramxuf = paramString1;
      break label117;
      localAIOFileVideoData.downloadUrl = paramArrayOfString[0];
      localAIOFileVideoData.aWb = paramString1;
      localAIOFileVideoData.cookie = paramString2;
    }
  }
  
  private void a(xuf paramxuf, boolean paramBoolean)
  {
    if (((paramxuf.e instanceof AIOImageData)) && (paramBoolean)) {
      this.jdField_a_of_type_Xuh.cancelDownloadMedia(paramxuf.e.id, paramxuf.e.subId, 24);
    }
  }
  
  private void a(xuf paramxuf, String[] paramArrayOfString, String paramString, View paramView, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "carverW notifyVideoUrl setShortVideoDrawableWithUrls ,AIOShortVideoData id=" + paramxuf.e.id);
    }
    xuk.a().a(paramxuf.e.id, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt, paramString);
    paramString = new ztn();
    paramString.btf = true;
    paramString.cJ = paramArrayOfString;
    paramString.l = paramMessageForShortVideo;
    paramString.fileType = paramInt;
    paramString.id = paramxuf.e.id;
    paramString.subid = paramxuf.e.subId;
    paramArrayOfString = new File(((AIOShortVideoData)paramxuf.e).aWp);
    if (paramArrayOfString.exists())
    {
      paramString.ap = paramArrayOfString.length();
      if (this.mIsMute)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, dataOfBubble.id =  " + this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.id + ", msg.uniseq = " + paramMessageForShortVideo.uniseq + ", mIsmute = " + this.mIsMute);
        }
        if ((this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.id == paramMessageForShortVideo.uniseq))
        {
          paramString.isMute = true;
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, set playMedioInfo.isMute =  " + this.mIsMute);
          }
        }
      }
      this.jdField_c_of_type_Ztk.a(paramView, paramString);
      paramArrayOfString = (AIOShortVideoData)paramxuf.e;
      if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.bx(((AIOShortVideoData)paramxuf.e).uniseq)) {
        break label405;
      }
      this.jdField_c_of_type_Ztk.aNX();
      this.jdField_c_of_type_Ztk.a((AIOShortVideoData)paramxuf.e, false, false);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Xuh != null) && (paramArrayOfString.c(0) == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, get THUMB");
        }
        this.jdField_a_of_type_Xuh.downloadMedia(paramArrayOfString.id, paramArrayOfString.subId, 0);
      }
      return;
      paramString.ap = 0L;
      break;
      label405:
      this.jdField_c_of_type_Ztk.a((AIOShortVideoData)paramxuf.e, false, true);
    }
  }
  
  private void ae(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_Xto.be();
    int i = 0;
    for (;;)
    {
      if (i < ((List)localObject).size())
      {
        xuf localxuf = (xuf)((List)localObject).get(i);
        if (localxuf.e.id != paramLong) {
          break label144;
        }
        localxuf.progress = this.progress;
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onLoadProgressUpdate(i, this.progress / 100);
        if (paramBoolean)
        {
          int j = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          int n = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
          if ((i >= j) && (i <= n + j - 1))
          {
            localObject = this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(i - j);
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(i, (View)localObject, paramBoolean);
          }
        }
      }
      return;
      label144:
      i += 1;
    }
  }
  
  private void ai(long paramLong, int paramInt)
  {
    Object localObject = this.jdField_b_of_type_Xto.c().e;
    if ((((AIORichMediaData)localObject).id == paramLong) && (((AIORichMediaData)localObject).subId == paramInt)) {
      if ((this.l != null) && (this.Kl != null))
      {
        this.Kl.setText(acfp.m(2131702201) + this.progress / 100.0D + "%");
        this.l.setProgress(this.progress);
      }
    }
    do
    {
      return;
      localObject = a(paramLong, paramInt);
    } while (localObject == null);
    ((xuf)localObject).a.progress = this.progress;
  }
  
  private boolean ax(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      xuf localxuf = this.jdField_b_of_type_Xto.c();
      if ((localxuf != null) && ((localxuf.e instanceof AIOShortVideoData)))
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a((AIOShortVideoData)localxuf.e) != null))
        {
          this.am.setVisibility(0);
          return true;
        }
      }
      else if ((localxuf != null) && ((localxuf.e instanceof AIOFileVideoData)) && (rox.fileExistsAndNotEmpty(((AIOFileVideoData)localxuf.e).mFilePath)))
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
  
  private void b(int paramInt, File paramFile)
  {
    Object localObject1;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        anot.a(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
      }
      localObject1 = (PeakActivity)this.mContext;
      if (this.mContext.getIntent() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "save video failed, intent is null");
      }
      QQToast.a((Context)localObject1, 1, acfp.m(2131702211), 0).show();
      return;
      localObject1 = "0X8007A24";
      continue;
      localObject1 = "0X8007A25";
    }
    NativeVideoImage.pauseAll();
    paramInt = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
    int j = this.jdField_b_of_type_Xto.getSelectedIndex();
    if ((j >= paramInt) && (j <= i + paramInt - 1))
    {
      localObject2 = this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(j - paramInt);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject2)) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(j, (AIOGalleryAdapter.GalleryImageStruct)localObject2);
      }
    }
    Object localObject2 = ShortVideoUtils.zL();
    a((Activity)localObject1, acfp.m(2131702210), false, 0);
    if (rox.saveVideoToAlbum(BaseApplication.getContext(), paramFile.getAbsolutePath(), (String)localObject2)) {
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10000);
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
    }
  }
  
  private void b(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    Object localObject2 = paramAIOFilePicData.c(20);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramAIOFilePicData.c(18);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramAIOFilePicData.c(16);
    }
    if ((localObject2 == null) && (this.biT)) {
      return;
    }
    a(paramAIOFilePicData, (File)localObject2, paramInt);
  }
  
  private void b(AIOImageData paramAIOImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "action sheet add to favorite.");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_md5", paramAIOImageData.md5);
    paramAIOImageData = new xsn(this);
    QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", localBundle, paramAIOImageData);
    if (this.biJ) {
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void b(AIOImageData paramAIOImageData, xuf paramxuf)
  {
    if (paramAIOImageData != null)
    {
      this.jdField_a_of_type_Xsk$a = new xsk.a();
      this.jdField_a_of_type_Xsk$a.id = paramAIOImageData.id;
      this.jdField_a_of_type_Xsk$a.subId = paramAIOImageData.subId;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveOriginalImage");
      }
      this.jdField_a_of_type_Xuh.downloadMedia(this.jdField_a_of_type_Xsk$a.id, this.jdField_a_of_type_Xsk$a.subId, 24);
    }
  }
  
  private void b(AIOImageData paramAIOImageData, xuf paramxuf, File paramFile)
  {
    reportData("Pic_save", 0);
    if ((paramAIOImageData.c(4) == null) && (paramAIOImageData.gF(4)) && (AppNetConnInfo.isNetSupport())) {
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOImageData.size > 29360128L)) {
        a(1, paramAIOImageData, paramxuf);
      }
    }
    for (;;)
    {
      reportData(paramFile.getAbsolutePath(), 55);
      if (this.biJ) {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
      }
      if (this.biF) {
        ajlg.report("0X8009ABB");
      }
      return;
      b(paramAIOImageData, paramxuf);
      paramxuf.a.bju = true;
      updateUI();
      continue;
      xtm.a(this.mContext, paramFile, Utils.Crc64String(paramFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
    }
  }
  
  private void b(AIORichMediaData paramAIORichMediaData)
  {
    Intent localIntent1;
    if (this.jdField_a_of_type_Xuh.asBinder().pingBinder())
    {
      localIntent1 = this.jdField_a_of_type_Xuh.getForwardData(paramAIORichMediaData.id, paramAIORichMediaData.subId, 0);
      if (localIntent1 == null) {
        QLog.w("AIOGalleryScene", 1, "getForwardData return null from main process");
      }
    }
    else
    {
      return;
    }
    localIntent1.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    if (paramAIORichMediaData.istroop == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      localIntent1.putExtra("filepictest", true);
      paramAIORichMediaData = (ForwardFileInfo)localIntent1.getParcelableExtra("fileinfo");
      String str1 = localIntent1.getStringExtra("forward_filepath");
      boolean bool1 = localIntent1.getBooleanExtra("k_favorites", false);
      String str2 = localIntent1.getStringExtra("forward_text");
      boolean bool2 = localIntent1.getBooleanExtra("isFromShare", false);
      i = localIntent1.getIntExtra("forward_type", 0);
      Intent localIntent2 = new Intent();
      localIntent2.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", i);
      localBundle.putParcelable("fileinfo", paramAIORichMediaData);
      localBundle.putBoolean("not_forward", true);
      localIntent2.putExtras(localBundle);
      localIntent2.putExtra("forward_filepath", str1);
      localIntent2.putExtra("forward_text", str2);
      localIntent2.putExtra("k_favorites", bool1);
      localIntent2.putExtra("isFromShare", bool2);
      if (AIOFilePicData.class.isInstance(localIntent1))
      {
        localIntent2.putExtra("isPic", true);
        localIntent2.putExtra("direct_send_if_dataline_forward", true);
      }
      ahgq.f(this.mContext, localIntent1, 103);
      return;
    }
    ahgq.f(this.mContext, localIntent1, 21);
  }
  
  private void b(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString);
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
      a(this.aWg, paramAIORichMediaData.istroop, paramAIORichMediaData.bjg, paramAIORichMediaData.send_uin, paramAIORichMediaData.md5, paramAIORichMediaData.aWj, paramAIORichMediaData.uuid, 1, localIntent);
    }
    while (!AIOFilePicData.class.isInstance(paramAIORichMediaData))
    {
      anot.a(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
      return;
    }
    paramString = (AIOFilePicData)paramAIORichMediaData;
    if (aqiu.ms(paramString.issend)) {}
    for (paramAIORichMediaData = this.aWf;; paramAIORichMediaData = this.mFriendUin)
    {
      a(this.aWg, paramString.peerType, true, paramAIORichMediaData, null, null, paramString.aWa, 1, localIntent);
      break;
    }
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + paramAIOShortVideoData.aWp), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.mContext.startActivity(localIntent);
    int i = paramAIOShortVideoData.istroop;
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
  
  private void b(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.c(1);
    xuf localxuf = this.jdField_b_of_type_Xto.c();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if ((localFile != null) && (localFile.exists()))
    {
      long l1 = localFile.length();
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "showActionSheetForShortVideo, file.getPath()=" + localFile.getPath() + ", mTransferredSize = " + l1 + ", data.size = " + paramAIOShortVideoData.size);
      }
      if (l1 >= paramAIOShortVideoData.size) {}
    }
    for (i = 1;; i = 1)
    {
      if ((paramAIOShortVideoData.mBusiType != 1) || (i == 0)) {
        a(2131694181, 2130840526, 59, localArrayList1);
      }
      if ((VersionUtils.isIceScreamSandwich()) && ((paramAIOShortVideoData.mBusiType != 1) || (i == 0))) {
        a(2131694190, 2130840535, 61, localArrayList1);
      }
      if (i == 0)
      {
        a(2131694180, 2130840525, 63, localArrayList1);
        a(2131694192, 2130840536, 58, localArrayList1);
      }
      if ((this.mCurType != -1) && (!TextUtils.isEmpty(this.mFriendUin)) && (this.biR)) {
        a(2131694194, 2130840537, 62, localArrayList2);
      }
      if (i == 0) {
        a(2131694187, 2130840531, 64, localArrayList2, 5);
      }
      a(paramAIOShortVideoData, localFile, paramInt, localxuf);
      paramAIOShortVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIOShortVideoData);
      this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
      }
    }
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, xuf paramxuf)
  {
    if (paramAIOShortVideoData.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "video file is expired");
      }
      QQToast.a(this.mContext, 1, acfp.m(2131702212), 0).show();
      return;
    }
    if (paramAIOShortVideoData.mBusiType == 1)
    {
      b(paramInt, paramFile);
      return;
    }
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOShortVideoData.size))
    {
      paramAIOShortVideoData = new StringBuilder().append(paramFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramFile.getAbsolutePath(), this.jdField_b_of_type_MqqOsMqqHandler, paramAIOShortVideoData, false));
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
      return;
    }
    if ((!AppNetConnInfo.isWifiConn()) && (paramAIOShortVideoData.size > 29360128L))
    {
      a(3, paramAIOShortVideoData, paramxuf);
      return;
    }
    a(paramAIOShortVideoData, paramxuf);
    paramxuf.a.biW = true;
    updateUI();
  }
  
  public static void b(xuf paramxuf, Activity paramActivity, int paramInt)
  {
    if (!AIOImageData.class.isInstance(paramxuf.e)) {
      return;
    }
    AIOImageData localAIOImageData = (AIOImageData)paramxuf.e;
    File localFile = localAIOImageData.c(4);
    if (localFile == null) {
      localFile = localAIOImageData.c(2);
    }
    for (int i = 0;; i = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.cH(1));
      paramxuf = paramxuf.e;
      if (i != 0) {}
      for (int j = 4;; j = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", paramxuf.cH(j));
        if (paramActivity.getIntent().getBooleanExtra("image_share_by_server", false))
        {
          paramxuf = Long.toString(paramActivity.getIntent().getLongExtra("appid", 0L));
          j = paramActivity.getIntent().getIntExtra("curType", 0);
          localBundle.putBoolean("key_forward_image_share", true);
          localBundle.putString("key_forward_image_share_appid", paramxuf);
          localBundle.putInt("key_forward_image_share_uin_type", j);
        }
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (i != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
          if (localAIOImageData.EP == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramxuf = new Intent();
          paramxuf.putExtras(localBundle);
          ahgq.f(paramActivity, paramxuf, paramInt);
          return;
        }
        catch (NullPointerException paramxuf) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,NullPointerException: " + paramxuf);
      return;
    }
  }
  
  private int bN(String paramString)
  {
    int i = 4;
    switch (this.bWR)
    {
    case 4: 
    default: 
      i = -1;
    case 1: 
    case 3: 
    case 2: 
      do
      {
        do
        {
          return i;
          return 1;
        } while ("0X8009EFC".equals(paramString));
        if (!"0X8009EFD".equals(paramString)) {
          break;
        }
        return -1;
        if ("0X8009EFC".equals(paramString)) {
          return 5;
        }
      } while ("0X8009EFD".equals(paramString));
    }
    do
    {
      return -1;
      if ("0X8009EFC".equals(paramString)) {
        return 6;
      }
    } while (!"0X8009EFD".equals(paramString));
    return 5;
  }
  
  private void c(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AIORichMediaData localAIORichMediaData = this.jdField_b_of_type_Xto.c().e;
    if ((localAIORichMediaData.id == paramLong) && (localAIORichMediaData.subId == paramInt1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "save pic result = " + paramInt3 + ", resultStr = " + paramString);
      }
      if (paramInt3 == 1)
      {
        QQToast.a(this.mContext, this.mContext.getString(2131718933), 0).show();
        updateUI();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Xsk$a != null) && (this.jdField_a_of_type_Xsk$a.id == paramLong) && (this.jdField_a_of_type_Xsk$a.subId == paramInt1)) {
        this.jdField_a_of_type_Xsk$a = null;
      }
      return;
      QQToast.a(this.mContext, this.mContext.getString(2131718929), 0).show();
      break;
      paramString = a(paramLong, paramInt1);
      if (paramString != null) {
        paramString.a.bju = false;
      }
    }
  }
  
  private void c(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    xto localxto = this.jdField_b_of_type_Xto;
    if (paramInt3 == 1)
    {
      paramInt2 = localxto.a(paramLong, paramInt1, paramInt2, paramString, false);
      int i = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
      int j = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
      if ((paramInt2 >= i) && (paramInt2 <= j + i - 1))
      {
        paramString = this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - i);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.updateView(paramInt2, paramString, paramBoolean);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt2);
      }
      paramInt2 = 0;
      label127:
      if (paramInt2 >= this.jdField_b_of_type_Xto.getCount()) {
        return;
      }
      paramString = this.jdField_b_of_type_Xto.a(paramInt2);
      if (paramString != null) {
        break label172;
      }
    }
    for (;;)
    {
      paramInt2 += 1;
      break label127;
      paramString = "I:E";
      break;
      label172:
      if ((paramString.e.id == paramLong) && (paramString.e.subId == paramInt1) && (paramInt3 == 1) && (AIOImageData.class.isInstance(paramString.e)))
      {
        paramString = (AIOImageData)paramString.e;
        if ((!paramString.bjf) && (new File(paramString.aVW + "_hd").exists())) {
          paramString.aVW += "_hd";
        }
      }
    }
  }
  
  private void c(AIOImageData paramAIOImageData)
  {
    if (LocalMultiProcConfig.getInt4Uin(this.aWf + "__qzone_pic_permission__" + this.QE, -1, Long.valueOf(this.aWf).longValue()) == 0)
    {
      paramAIOImageData = new aqju(this.mContext, 2131756467);
      paramAIOImageData.setContentView(2131559151);
      paramAIOImageData.setTitle(this.mContext.getString(2131699885));
      paramAIOImageData.setMessage(this.mContext.getString(2131699883));
      paramAIOImageData.setNegativeButton(this.mContext.getString(2131699884), new xso(this));
      paramAIOImageData.setCanceledOnTouchOutside(false);
      paramAIOImageData.setCancelable(false);
      paramAIOImageData.show();
      QZoneClickReport.startReportImediately(this.aWf, "40", "1");
      return;
    }
    reportData("Pic_Forward_Grpalbum", 0);
    xtm.a(this.mContext, this.aWf, this.QE, this.aRJ, paramAIOImageData.aVW, paramAIOImageData.uuid, paramAIOImageData.timestamp, -1);
  }
  
  private void c(AIORichMediaData paramAIORichMediaData)
  {
    if (LocalMultiProcConfig.getInt4Uin(this.aWf + "__qzone_pic_permission__" + this.QE, -1, Long.valueOf(this.aWf).longValue()) == 0)
    {
      paramAIORichMediaData = new aqju(this.mContext, 2131756467);
      paramAIORichMediaData.setContentView(2131559151);
      paramAIORichMediaData.setTitle(this.mContext.getString(2131699885));
      paramAIORichMediaData.setMessage(this.mContext.getString(2131699883));
      paramAIORichMediaData.setNegativeButton(this.mContext.getString(2131699884), new xsw(this));
      paramAIORichMediaData.setCanceledOnTouchOutside(false);
      paramAIORichMediaData.setCancelable(false);
      paramAIORichMediaData.show();
      QZoneClickReport.startReportImediately(this.aWf, "40", "1");
      return;
    }
    paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
    reportData("Pic_Forward_Grpalbum", 0);
    xtm.a(this.mContext, this.aWf, this.QE, this.aRJ, paramAIORichMediaData.aVW, paramAIORichMediaData.uuid, paramAIORichMediaData.timestamp, -1);
  }
  
  private void c(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    xuf localxuf = this.jdField_b_of_type_Xto.a(paramInt);
    if (localxuf != null)
    {
      b(localxuf);
      if ((localxuf.e.gF(4)) || (localxuf.e.gF(20)))
      {
        if (localxuf.e.size <= 0L) {
          break label165;
        }
        this.Kk.setText(String.format(Locale.CHINA, this.mContext.getString(2131697154), new Object[] { ahbj.g(localxuf.e.size) }));
      }
    }
    for (;;)
    {
      gm(true);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = getRootView().findViewById(2131367844);
        if (paramAdapterView != null)
        {
          if (paramAdapterView.getAnimation() != null)
          {
            paramAdapterView.getAnimation().cancel();
            paramAdapterView.setAnimation(null);
          }
          paramAdapterView.setVisibility(4);
        }
      }
      return;
      label165:
      this.Kk.setText(2131697151);
    }
  }
  
  private void c(xuf paramxuf)
  {
    this.al.setVisibility(8);
    this.Kk.setVisibility(8);
    this.hQ.setVisibility(8);
    ax(true);
    AIOShortVideoData localAIOShortVideoData;
    int i;
    if (this.aOa)
    {
      this.an.setVisibility(8);
      localAIOShortVideoData = (AIOShortVideoData)this.jdField_b_of_type_Xto.c().e;
      if (localAIOShortVideoData.mBusiType != 0) {
        break label511;
      }
      this.hQ.setVisibility(8);
      i = this.jdField_a_of_type_Xuh.getSaveFileProgress(localAIOShortVideoData.id, localAIOShortVideoData.subId);
      this.jdField_c_of_type_Ztk.bB(8, "");
      if (!paramxuf.a.biW) {
        break label202;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoSaving");
      }
      paramxuf.a.biW = false;
      this.l.setProgress(0);
      this.Kl.setText(acfp.m(2131702227));
      this.an.setVisibility(8);
      this.hP.setVisibility(0);
      this.hi.setVisibility(8);
    }
    label202:
    label511:
    do
    {
      do
      {
        do
        {
          return;
          this.an.setVisibility(0);
          break;
          if (i != -1)
          {
            this.l.setProgress((int)(i / 100.0D * 10000.0D));
            this.an.setVisibility(8);
            this.hP.setVisibility(0);
            this.hi.setVisibility(8);
            return;
          }
          if (paramxuf.a.bjt)
          {
            if (QLog.isColorLevel()) {
              QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoBuffering");
            }
            this.hP.setVisibility(8);
            this.hQ.setVisibility(0);
            this.hi.setVisibility(0);
            return;
          }
          if (paramxuf.a.bjw) {
            break label437;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.hasEnterPlaying longVideoDownloading=" + paramxuf.a.bjx + " selectedItem.state=" + paramxuf.a + " longVideoGetUrl=" + paramxuf.a.bjz);
          }
          this.hP.setVisibility(8);
          this.hi.setVisibility(8);
          if (paramxuf.a.bjx) {
            this.hQ.setVisibility(0);
          }
        } while (!paramxuf.a.bjz);
        this.hQ.setVisibility(0);
        return;
        if (paramxuf.a.bjA)
        {
          this.jdField_c_of_type_Ztk.bB(0, localAIOShortVideoData.pw());
          this.hi.setVisibility(8);
          paramxuf.a.bjA = false;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.else");
        }
        this.hP.setVisibility(8);
        this.hi.setVisibility(0);
        return;
      } while (localAIOShortVideoData.mBusiType != 1);
      if (this.jdField_a_of_type_Xsk$b.biX)
      {
        this.hP.setVisibility(0);
        this.hi.setVisibility(8);
        return;
      }
      if (paramxuf.a.bjw) {
        break label594;
      }
      this.hP.setVisibility(8);
      this.hi.setVisibility(8);
    } while (!paramxuf.a.bjy);
    label437:
    this.hQ.setVisibility(0);
    return;
    label594:
    this.hP.setVisibility(8);
    this.hi.setVisibility(0);
  }
  
  private void ceC()
  {
    Object localObject = this.jdField_b_of_type_Xto.c();
    if ((localObject != null) && (this.jdField_a_of_type_Xuh.asBinder().pingBinder()))
    {
      this.jdField_a_of_type_Xsk$a = new xsk.a();
      this.jdField_a_of_type_Xsk$a.id = ((xuf)localObject).e.id;
      this.jdField_a_of_type_Xsk$a.subId = ((xuf)localObject).e.subId;
      if (!AIOImageData.class.isInstance(((xuf)localObject).e)) {
        break label119;
      }
      ((xuf)localObject).a.bjs = true;
      updateUI();
      this.jdField_a_of_type_Xuh.downloadMedia(this.jdField_a_of_type_Xsk$a.id, this.jdField_a_of_type_Xsk$a.subId, 4);
    }
    label119:
    while (!AIOFilePicData.class.isInstance(((xuf)localObject).e)) {
      return;
    }
    if (!aqiw.isNetSupport(this.mContext))
    {
      QQToast.a(this.mContext, this.mContext.getString(2131695432), 0).show();
      this.jdField_a_of_type_Xsk$a = null;
      updateUI();
      return;
    }
    localObject = (AIOFilePicData)((xuf)localObject).e;
    if (((AIOFilePicData)localObject).bip)
    {
      QQToast.a(this.mContext, this.mContext.getString(2131694128), 0).show();
      updateUI();
      this.jdField_a_of_type_Xsk$a = null;
      return;
    }
    if (((AIOFilePicData)localObject).biq) {
      updateUI();
    }
    long l1 = agmx.fJ();
    if ((((AIOFilePicData)localObject).mFileSize > l1) && (ahav.amK())) {
      try
      {
        ahav.b(false, this.mContext, new xsl(this));
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
    }
    zA(true);
    this.jdField_a_of_type_Xuh.downloadMedia(this.jdField_a_of_type_Xsk$a.id, this.jdField_a_of_type_Xsk$a.subId, 20);
    this.jdField_b_of_type_ComTencentWidgetGallery.enableDoubleTap(true);
    this.jdField_b_of_type_ComTencentWidgetGallery.enableScaleGesture(true);
  }
  
  private void ceD()
  {
    if (this.jdField_c_of_type_Ztk != null)
    {
      localObject = this.jdField_b_of_type_Xto.c();
      if (localObject != null)
      {
        if (!AIOImageData.class.isInstance(((xuf)localObject).e)) {
          break label131;
        }
        localAIOImageData = (AIOImageData)((xuf)localObject).e;
        if (!((xuf)localObject).a.bjs) {
          break label94;
        }
        if (this.jdField_a_of_type_Xuh != null) {
          this.jdField_a_of_type_Xuh.cancelDownloadMedia(this.jdField_a_of_type_Xsk$a.id, this.jdField_a_of_type_Xsk$a.subId, 4);
        }
        ((xuf)localObject).a.bjs = false;
        updateUI();
      }
    }
    label94:
    while (!AIOFilePicData.class.isInstance(((xuf)localObject).e)) {
      for (;;)
      {
        AIOImageData localAIOImageData;
        return;
        if (this.jdField_a_of_type_Xuh != null) {
          this.jdField_a_of_type_Xuh.cancelDownloadMedia(localAIOImageData.id, localAIOImageData.subId, 24);
        }
        ((xuf)localObject).a.bjv = true;
      }
    }
    label131:
    Object localObject = (AIOFilePicData)((xuf)localObject).e;
    if (this.jdField_a_of_type_Xuh != null) {
      this.jdField_a_of_type_Xuh.cancelDownloadMedia(((AIOFilePicData)localObject).id, ((AIOFilePicData)localObject).subId, 24);
    }
    ((AIOFilePicData)localObject).bir = false;
    zA(false);
    updateUI();
  }
  
  private void ceE()
  {
    Object localObject = this.jdField_b_of_type_Xto.c();
    long l1;
    if (this.jdField_c_of_type_Ztk != null)
    {
      l1 = this.jdField_c_of_type_Ztk.getProgress();
      if ((localObject == null) || (!(((xuf)localObject).e instanceof AIOShortVideoData))) {
        break label177;
      }
      localObject = (AIOShortVideoData)((xuf)localObject).e;
      if (this.jdField_a_of_type_Arlq != null) {
        this.jdField_a_of_type_Arlq.destory();
      }
      this.jdField_a_of_type_Arlq = new arlq(this.mContext);
      ztn localztn = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a((AIOShortVideoData)localObject);
      if (localztn == null) {
        break label166;
      }
      this.jdField_a_of_type_Arlq.a(localztn, ((AIOShortVideoData)localObject).uniseq, l1);
      this.jdField_a_of_type_Arlq.aR(((AIOShortVideoData)localObject).aWo, ((AIOShortVideoData)localObject).width, ((AIOShortVideoData)localObject).height);
      if ((((AIOShortVideoData)localObject).width <= ((AIOShortVideoData)localObject).height) || (this.jdField_a_of_type_Arlq.q(((AIOShortVideoData)localObject).istroop, ((AIOShortVideoData)localObject).width, ((AIOShortVideoData)localObject).height))) {
        back();
      }
    }
    label166:
    label177:
    do
    {
      do
      {
        do
        {
          return;
          l1 = 0L;
          break;
          QLog.d("AIOGalleryScene", 1, "Failed to floating, videoPlayMedioInfo is null");
          return;
        } while ((localObject == null) || (!(((xuf)localObject).e instanceof AIOFileVideoData)));
        localObject = (AIOFileVideoData)((xuf)localObject).e;
      } while (!rox.fileExistsAndNotEmpty(((AIOFileVideoData)localObject).mFilePath));
      if (this.jdField_a_of_type_Arlq != null) {
        this.jdField_a_of_type_Arlq.destory();
      }
      this.jdField_a_of_type_Arlq = new arlq(this.mContext);
      this.jdField_a_of_type_Arlq.w(((AIOFileVideoData)localObject).mFilePath, ((AIOFileVideoData)localObject).id, l1);
      if (aqhq.fileExistsAndNotEmpty(((AIOFileVideoData)localObject).bN)) {
        this.jdField_a_of_type_Arlq.aR(((AIOFileVideoData)localObject).bN, ((AIOFileVideoData)localObject).width, ((AIOFileVideoData)localObject).height);
      }
    } while ((((AIOFileVideoData)localObject).width > ((AIOFileVideoData)localObject).height) && (!this.jdField_a_of_type_Arlq.q(((AIOFileVideoData)localObject).istroop, ((AIOFileVideoData)localObject).width, ((AIOFileVideoData)localObject).height)));
    back();
  }
  
  private void ceF()
  {
    this.am = new ImageButton(this.mContext);
    this.am.setContentDescription(acfp.m(2131702192));
    this.am.setId(2131374886);
    this.am.setImageResource(2130847112);
    this.am.setBackgroundDrawable(null);
    this.am.setPadding(32, 12, 32, 12);
    Object localObject = this.mContext.getResources().getDisplayMetrics();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.topMargin = ((int)TypedValue.applyDimension(1, 10.0F, (DisplayMetrics)localObject));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 24.0F, (DisplayMetrics)localObject));
    localObject = (AIORichMediaData)this.mContext.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE");
    this.mRoot.addView(this.am, localLayoutParams);
    this.am.setOnClickListener(this);
    ax(false);
  }
  
  private void ceG()
  {
    Object localObject = "";
    Activity localActivity;
    int i;
    switch (this.mCurType)
    {
    default: 
      localActivity = this.mContext;
      i = this.mCurType;
      if (!TextUtils.isEmpty(this.nickName)) {
        break;
      }
    }
    for (String str = this.mFriendUin;; str = this.nickName)
    {
      MiniChatActivity.a(localActivity, i, (String)localObject, str);
      return;
      localObject = this.mFriendUin;
      break;
      str = this.QE;
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      localObject = this.mFriendUin;
      break;
      str = this.QE;
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      localObject = this.mFriendUin;
      break;
    }
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    xto localxto = this.jdField_b_of_type_Xto;
    if (paramInt3 == 1) {}
    for (String str = paramString;; str = "I:E")
    {
      localxto.a(paramLong, paramInt1, paramInt2, str, false);
      QLog.d("AIOGalleryScene", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
      if (paramInt3 != 1) {
        break label290;
      }
      paramString = this.jdField_b_of_type_Xto.c();
      if ((paramString != null) && (paramString.e != null) && (AIOFilePicData.class.isInstance(paramString.e))) {
        ((AIOFilePicData)paramString.e).bir = false;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mPlayGifImage = true;
      paramString.mUseExifOrientation = false;
      str = this.jdField_b_of_type_Xto.c().e.cH(20);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      QLog.e("AIOGalleryScene", 1, "null url");
      return;
    }
    paramString = URLDrawable.getDrawable(str, paramString);
    switch (paramString.getStatus())
    {
    }
    for (;;)
    {
      paramString.setTag(Integer.valueOf(1));
      paramString.setURLDrawableListener(this.jdField_a_of_type_Xsk$a);
      paramString.startDownload();
      this.jdField_a_of_type_Xsk$a.p = paramString;
      return;
      this.jdField_a_of_type_Xsk$a.onLoadSuccessed(paramString);
      return;
      this.jdField_a_of_type_Xsk$a.onLoadFialed(paramString, null);
      return;
      this.jdField_a_of_type_Xsk$a.onLoadCanceled(paramString);
    }
    label290:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.mContext.getString(2131694128).equals(paramString)) {
        break label349;
      }
      QQToast.a(this.mContext, paramString, 0).show();
    }
    for (;;)
    {
      zA(false);
      gm(true);
      this.jdField_a_of_type_Xsk$a = null;
      return;
      label349:
      QQToast.a(this.mContext, this.mContext.getString(2131697153), 0).show();
    }
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    xto localxto;
    String str;
    if ((this.jdField_a_of_type_Xsk$a != null) && (this.jdField_a_of_type_Xsk$a.id == paramLong) && (this.jdField_a_of_type_Xsk$a.subId == paramInt1))
    {
      localxto = this.jdField_b_of_type_Xto;
      if (paramInt3 != 1) {
        break label109;
      }
      str = paramString;
    }
    for (;;)
    {
      localxto.a(paramLong, paramInt1, paramInt2, str, false);
      if (paramInt3 != 1) {
        break label279;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mPlayGifImage = true;
      paramString.mUseExifOrientation = false;
      try
      {
        paramString = URLDrawable.getDrawable(this.jdField_b_of_type_Xto.c().e.cH(4), paramString);
        if (paramString == null)
        {
          return;
          label109:
          str = "I:E";
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
        switch (paramString.getStatus())
        {
        }
      }
    }
    paramString.setTag(Integer.valueOf(1));
    paramString.setURLDrawableListener(this.jdField_a_of_type_Xsk$a);
    paramString.startDownload();
    this.jdField_a_of_type_Xsk$a.p = paramString;
    label192:
    paramString = this.jdField_b_of_type_Xto.c().e;
    if ((paramString.id == paramLong) && (paramString.subId == paramInt1)) {
      this.jdField_b_of_type_Xto.c().a.bjs = false;
    }
    for (;;)
    {
      updateUI();
      return;
      this.jdField_a_of_type_Xsk$a.onLoadSuccessed(paramString);
      break label192;
      this.jdField_a_of_type_Xsk$a.onLoadFialed(paramString, null);
      break label192;
      this.jdField_a_of_type_Xsk$a.onLoadCanceled(paramString);
      break;
      label279:
      if (!"TroopFileError".equals(paramString)) {
        QQToast.a(this.mContext, this.mContext.getString(2131697153), 0).show();
      }
      this.jdField_a_of_type_Xsk$a = null;
      break label192;
      paramString = a(paramLong, paramInt1);
      if (paramString != null)
      {
        paramString.progress = 0;
        paramString.a.bjs = false;
      }
    }
  }
  
  private void d(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_Xto.be();
    int i = 0;
    for (;;)
    {
      if (i < ((List)localObject).size())
      {
        xuf localxuf = (xuf)((List)localObject).get(i);
        if ((localxuf.e.id != paramLong) || (localxuf.e.subId != paramInt)) {
          break label154;
        }
        localxuf.progress = this.progress;
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onLoadProgressUpdate(i, this.progress / 100);
        if (paramBoolean)
        {
          paramInt = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          int j = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
          if ((i >= paramInt) && (i <= j + paramInt - 1))
          {
            localObject = this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(i - paramInt);
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(i, (View)localObject, paramBoolean);
          }
        }
      }
      return;
      label154:
      i += 1;
    }
  }
  
  private void d(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.mContext != null) && (!this.mContext.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOGalleryScene", 2, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  private void d(AIOImageData paramAIOImageData)
  {
    if (this.biJ)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "action sheet share weiyun.");
      }
      localBundle = new Bundle();
      localBundle.putString("pic_md5", paramAIOImageData.md5);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", localBundle, null);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
    }
    while ((paramAIOImageData.id <= 0L) || (!this.jdField_a_of_type_Xuh.asBinder().pingBinder()))
    {
      Bundle localBundle;
      return;
    }
    this.jdField_a_of_type_Xuh.saveToWeiyun(paramAIOImageData.id);
    QQToast.a(this.mContext, this.mContext.getString(2131694101), 0).show();
  }
  
  private void d(xuf paramxuf)
  {
    if (paramxuf == null) {}
    do
    {
      return;
      if (AIOShortVideoData.class.isInstance(paramxuf.e))
      {
        AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramxuf.e;
        if (localAIOShortVideoData.mBusiType == 0)
        {
          paramxuf.a.bjx = false;
          paramxuf.a.bjt = false;
        }
        for (;;)
        {
          this.m.setProgress(0);
          this.Km.setText(ShortVideoUtils.stringForTime(0L));
          paramxuf.a.bjw = false;
          return;
          this.Kn.setText(ShortVideoUtils.stringForTime(localAIOShortVideoData.bqB * 1000));
          paramxuf.a.bjy = false;
        }
      }
      if ((paramxuf.e instanceof AIOFileVideoData))
      {
        this.m.setProgress(0);
        paramxuf.a.bjw = false;
        return;
      }
    } while (this.jdField_b_of_type_MqqOsMqqHandler == null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.eu);
  }
  
  private void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    xto localxto = this.jdField_b_of_type_Xto;
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramInt1 = localxto.a(paramLong, paramInt1, paramInt2, paramString, false);
      paramInt2 = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
      paramInt3 = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
      if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
      {
        paramString = this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.updateView(paramInt1, paramString, paramBoolean);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
      }
      return;
      paramString = "I:E";
    }
  }
  
  private void e(xuf paramxuf)
  {
    reportData("Pic_Forward_Contacts", 0);
    a(paramxuf, this.mContext, 0);
    if (this.biJ) {
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
    }
    if (this.biF) {
      ajlg.report("0X8009ABA");
    }
  }
  
  private void f(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    xto localxto = this.jdField_b_of_type_Xto;
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramInt1 = localxto.a(paramLong, paramInt1, paramInt2, paramString, false);
      paramInt2 = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
      int i = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
      if ((paramInt1 >= paramInt2) && (paramInt1 <= i + paramInt2 - 1))
      {
        paramString = this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.updateView(paramInt1, paramString, paramBoolean);
        if (paramInt3 == 2)
        {
          zA(false);
          gm(true);
          this.jdField_a_of_type_Xsk$a = null;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
      }
      return;
      paramString = "I:E";
    }
  }
  
  private void f(xuf paramxuf)
  {
    AIOImageData localAIOImageData = (AIOImageData)paramxuf.e;
    Object localObject2 = localAIOImageData.c(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localAIOImageData.c(2);
    }
    if ((localObject1 == null) && (this.biT)) {
      return;
    }
    if (localObject1 != null) {
      this.mFilePath = ((File)localObject1).getPath();
    }
    localObject2 = ausj.d(this.mContext);
    if ((!a((ausj)localObject2, localAIOImageData)) && (top.eD(this.mCurType) != 1032))
    {
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if (localObject1 != null) {
        if (!this.biF) {
          a((ArrayList)localObject2, (File)localObject1, localAIOImageData, localArrayList, (File)localObject1);
        }
      }
      for (;;)
      {
        if ((localAIOImageData.imageBizType == 4) && (!localAIOImageData.isSend)) {
          a(2131694761, 2130847541, 66, (ArrayList)localObject2);
        }
        a(localAIOImageData, paramxuf, (File)localObject1);
        paramxuf = (List[])new ArrayList[] { localObject2, localArrayList };
        this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramxuf);
        this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
        a(2131694752, 2130840526, 49, (ArrayList)localObject2);
        a(2131694762, 2130840535, 53, (ArrayList)localObject2);
        continue;
        if ((!this.biF) && (this.mCurType != 1037) && (top.eD(this.mCurType) != 1044) && (this.mCurType != -1) && (!TextUtils.isEmpty(this.mFriendUin)) && (this.biR)) {
          a(2131694194, 2130840537, 54, localArrayList, 3);
        }
      }
    }
    a((ausj)localObject2, localAIOImageData, (File)localObject1, (File)localObject1);
  }
  
  private int fk(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if ((paramInt == 1004) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010) || (paramInt == 1011) || (paramInt == 1020) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1025) || (paramInt == 1036) || (paramInt == 10002) || (paramInt == 10003) || (paramInt == 10004)) {
      return 3;
    }
    return 4;
  }
  
  private void fz(View paramView)
  {
    paramView = (ImageView)paramView;
    if ((this.jdField_b_of_type_Xto.c().e instanceof AIOShortVideoData)) {
      if ((((AIOShortVideoData)this.jdField_b_of_type_Xto.c().e).mBusiType == 0) && (this.jdField_c_of_type_Ztk != null))
      {
        this.jdField_c_of_type_Ztk.aNX();
        if (!this.jdField_c_of_type_Ztk.VL()) {
          break label87;
        }
        paramView.setImageResource(2130847021);
        this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.eu, 100L);
      }
    }
    label87:
    while ((!(this.jdField_b_of_type_Xto.c().e instanceof AIOFileVideoData)) || (this.jdField_c_of_type_Ztk == null)) {
      for (;;)
      {
        return;
        paramView.setImageResource(2130847020);
      }
    }
    this.jdField_c_of_type_Ztk.aNX();
    if (this.jdField_c_of_type_Ztk.VL()) {
      paramView.setImageResource(2130847021);
    }
    for (;;)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.eu, 100L);
      return;
      paramView.setImageResource(2130847020);
    }
  }
  
  private int getCurType()
  {
    switch (this.mCurType)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  private void i(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    if (i < this.jdField_b_of_type_Xto.getCount())
    {
      xuf localxuf = this.jdField_b_of_type_Xto.a(i);
      if ((localxuf == null) || (localxuf.e == null) || (!AIOFileVideoData.class.isInstance(localxuf.e))) {}
      AIOFileVideoData localAIOFileVideoData;
      do
      {
        i += 1;
        break;
        localAIOFileVideoData = (AIOFileVideoData)localxuf.e;
      } while (localxuf.e.id != paramLong);
      if (paramInt == 1)
      {
        localAIOFileVideoData.bit = true;
        localAIOFileVideoData.biu = false;
        localAIOFileVideoData.mFilePath = paramString;
      }
      for (;;)
      {
        updateUI();
        if (this.jdField_b_of_type_Xto.c() != localxuf) {
          break;
        }
        this.jdField_c_of_type_Ztk.Fz(0);
        break;
        if (paramInt == 2) {
          localAIOFileVideoData.bit = false;
        }
      }
    }
  }
  
  public static void l(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = wja.a(new Intent(paramActivity, SplashActivity.class), null);
    paramBundle = new Bundle(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    String str = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    PhotoUtils.a(paramActivity, localIntent, localArrayList, paramBundle.getInt("PhotoConst.SEND_SIZE_SPEC", 0), true);
  }
  
  private int sZ()
  {
    Object localObject = this.jdField_b_of_type_Xto.c().e;
    if (localObject != null)
    {
      if ((localObject instanceof AIOFilePicData)) {
        return 2;
      }
      if ((localObject instanceof AIOImageData))
      {
        if (!((AIOImageData)localObject).bjg) {
          return 1;
        }
        return 5;
      }
      if ((localObject instanceof AIOShortVideoData))
      {
        localObject = (AIOShortVideoData)localObject;
        if (((AIOShortVideoData)localObject).mBusiType == 0) {
          return 4;
        }
        if (((AIOShortVideoData)localObject).mBusiType == 1) {
          return 3;
        }
      }
      else if ((localObject instanceof AIOFileVideoData))
      {
        return 5;
      }
    }
    return -1;
  }
  
  private void startPlay()
  {
    int i = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int j = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
    int n = this.jdField_b_of_type_Xto.getSelectedIndex();
    if ((n >= i) && (n <= j + i - 1))
    {
      Object localObject = this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(n - i);
      if ((AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject)) && ((((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable() instanceof URLDrawable)))
      {
        localObject = ((URLDrawable)((AIOGalleryAdapter.GalleryImageStruct)localObject).getDrawable()).getCurrDrawable();
        if ((localObject != null) && ((localObject instanceof VideoDrawable))) {
          ((VideoDrawable)localObject).resetAndPlayAudioCircle();
        }
      }
    }
  }
  
  private int wr()
  {
    if (this.bWR == 1) {
      return 1;
    }
    if (this.bWR == 2) {
      return 5;
    }
    if (this.bWR == 3) {
      return 4;
    }
    if (this.biF) {
      return 6;
    }
    return 0;
  }
  
  private void zz(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131561700, null);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    if (paramBoolean) {
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131374887);
    }
    for (;;)
    {
      this.mRoot.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.hi = ((LinearLayout)localRelativeLayout.findViewById(2131372454));
      this.m = ((SeekBar)this.hi.findViewById(2131377914));
      localObject = (ImageView)this.hi.findViewById(2131372728);
      this.Km = ((TextView)this.hi.findViewById(2131373666));
      this.Kn = ((TextView)this.hi.findViewById(2131380108));
      ((ImageView)localObject).setOnClickListener(this);
      this.m.setMax(10000);
      this.m.setOnSeekBarChangeListener(this);
      this.hP = ((RelativeLayout)localRelativeLayout.findViewById(2131381314));
      this.l = ((SeekBar)this.hP.findViewById(2131381316));
      this.l.setMax(10000);
      this.Kl = ((TextView)this.hP.findViewById(2131381315));
      this.closeBtn = ((ImageView)this.hP.findViewById(2131364678));
      this.closeBtn.setOnClickListener(this);
      this.hQ = ((RelativeLayout)localRelativeLayout.findViewById(2131364065));
      this.Ko = ((TextView)localRelativeLayout.findViewById(2131376618));
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    }
  }
  
  public boolean SH()
  {
    if (top.eD(this.mCurType) == 1032) {}
    label231:
    label232:
    for (;;)
    {
      return false;
      if ((this.mCurType != 1037) && (top.eD(this.mCurType) != 1044) && (!this.biF) && (this.jdField_b_of_type_Xto != null))
      {
        Object localObject = this.jdField_b_of_type_Xto.c();
        if (AIOImageData.class.isInstance(((xuf)localObject).e))
        {
          AIOImageData localAIOImageData = (AIOImageData)((xuf)localObject).e;
          localObject = localAIOImageData.c(4);
          if (localObject != null) {
            break label231;
          }
          localObject = localAIOImageData.c(2);
        }
        for (;;)
        {
          if ((localObject == null) && (this.biT)) {
            break label232;
          }
          if ((!this.biT) && (!this.biF)) {}
          for (boolean bool = true;; bool = false)
          {
            return bool;
            if (AIOShortVideoData.class.isInstance(((xuf)localObject).e))
            {
              localObject = ((AIOShortVideoData)((xuf)localObject).e).c(1);
              if ((localObject == null) || (!((File)localObject).exists())) {
                break;
              }
              return true;
            }
            if (AIOFilePicData.class.isInstance(((xuf)localObject).e))
            {
              if (this.biF) {
                break;
              }
              return true;
            }
            if (!AIOFileVideoData.class.isInstance(((xuf)localObject).e)) {
              break;
            }
            localObject = (AIOFileVideoData)((xuf)localObject).e;
            if ((this.biF) || (TextUtils.isEmpty(((AIOFileVideoData)localObject).mFilePath))) {
              break;
            }
            return true;
          }
        }
      }
    }
  }
  
  boolean SI()
  {
    return false;
  }
  
  boolean SJ()
  {
    return false;
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    boolean bool1 = true;
    if (this.mContext.getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) {}
    for (int i = 1; this.biH; i = 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_Xuh, true, i);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_c_of_type_Ztk);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a = new xsx(this);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_b_of_type_Xto);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.biD = this.mIsMute;
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(new xsy(this));
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
    }
    boolean bool2 = this.mContext.getIntent().getExtras().getBoolean("is_one_item", false);
    if (this.bWR == 4) {}
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_Xuh, bool1, i);
      break;
      bool1 = bool2;
    }
  }
  
  public void a(int paramInt1, View paramView, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "carverW notifyVideoUrl setShortVideoDrawableWithUrls ,position = " + paramInt1);
    }
    xuf localxuf = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1);
    if (localxuf == null) {}
    do
    {
      return;
      if (AIOShortVideoData.class.isInstance(localxuf.e))
      {
        a(localxuf, paramArrayOfString, paramString2, paramView, paramMessageForShortVideo, paramInt2);
        return;
      }
    } while (!AIOFileVideoData.class.isInstance(localxuf.e));
    a(localxuf, paramString1, paramArrayOfString, paramString2, paramView);
  }
  
  public void a(int paramInt, Object paramObject, xuf paramxuf)
  {
    d(aqha.a(this.mContext, 230, this.mContext.getString(2131718936), this.mContext.getString(2131718935), new xsp(this, paramInt, paramObject, paramxuf), new xsq(this)));
  }
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    this.mContext.runOnUiThread(new AIOGalleryScene.4(this, paramLong, paramFloat, paramString));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    paramInt1 = this.jdField_b_of_type_Xto.a(paramLong, paramInt1, paramInt2, paramString1, false);
    paramInt2 = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
    if (QLog.isDevelopLevel()) {
      QLog.d("AIOGalleryScene", 2, " carverW notifyVideoUrl(): Gallery position is " + paramInt1 + ", first = " + paramInt2 + ", count = " + i);
    }
    if ((paramInt1 >= paramInt2) && (paramInt1 <= i + paramInt2 - 1)) {
      a(paramInt1, this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
    }
  }
  
  @TargetApi(14)
  public void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.mDialog == null)
    {
      this.mDialog = new ReportDialog(paramActivity);
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
      this.jdField_b_of_type_Arht = a(paramActivity);
      ((ImageView)localObject).setImageDrawable(this.jdField_b_of_type_Arht);
    }
    ((TextView)this.mDialog.findViewById(2131371989)).setText(paramString);
    this.mDialog.setCancelable(paramBoolean);
    this.mDialog.setCanceledOnTouchOutside(paramBoolean);
    if (!paramBoolean) {
      this.mDialog.setOnKeyListener(new xsz(this));
    }
    this.jdField_b_of_type_Arht.setProgress(0);
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new AIOGalleryScene.27(this), paramInt);
  }
  
  void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(this.mContext, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("detectType", paramInt2);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    paramString1 = null;
    paramIntent = null;
    paramInt2 = 0;
    switch (paramInt1)
    {
    default: 
      if (paramBoolean) {
        paramInt1 = 3;
      }
      break;
    }
    try
    {
      if (!TextUtils.equals(paramString2, this.aWf)) {
        break label259;
      }
      paramIntent = this.mFriendUin;
      label132:
      if (TextUtils.isEmpty(paramString4)) {
        break label292;
      }
      i = aoji.KI();
      if (paramInt2 == 0) {
        break label623;
      }
      str = "gchat.qpic.cn";
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        int i;
        label259:
        label292:
        QLog.e("AIOGalleryScene", 1, "onQRDecodeSucceed error:" + paramString1.getMessage());
        continue;
        continue;
        String str = "c2cpicdw.qpic.cn";
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
        continue;
        paramString1 = null;
      }
    }
    if (!TextUtils.isEmpty(str)) {
      if (i != 80) {
        paramString1 = str + ":" + i + paramString4;
      } else {
        for (;;)
        {
          localIntent.putExtra("report_params", rvx.a(paramString3, paramString1, paramString5, paramString2, paramIntent, paramInt1));
          this.mContext.startActivity(localIntent);
          return;
          if (paramBoolean)
          {
            paramInt1 = 4;
            break label132;
          }
          paramInt1 = 2;
          paramInt2 = 1;
          break label132;
          paramInt1 = 1;
          break;
          paramIntent = this.aWf;
          break label132;
          paramString1 = str + paramString4;
          break label620;
          if (TextUtils.isEmpty(paramString5)) {
            break label631;
          }
          switch (paramInt1)
          {
          case 2: 
            paramString1 = "gchat.qpic.cn/gchatpic_new";
            if (!TextUtils.isEmpty(paramString2)) {
              paramString1 = "gchat.qpic.cn/gchatpic_new" + "/" + paramString2;
            }
            if (paramString5.startsWith("/")) {
              paramString1 = paramString1 + "0-0-" + paramString5.replace(".jpg", "") + "/0";
            } else {
              paramString1 = paramString1 + "/0-0-" + paramString5.replace(".jpg", "") + "/0";
            }
            break;
          case 1: 
            paramString1 = "c2cpicdw.qpic.cn/offpic_new";
            if (!TextUtils.isEmpty(paramString2)) {
              paramString1 = "c2cpicdw.qpic.cn/offpic_new" + "/" + paramString2;
            }
            if (paramString5.startsWith("/")) {
              paramString1 = paramString1 + paramString5 + "/0";
            } else {
              paramString1 = paramString1 + "/" + paramString5 + "/0";
            }
            break;
          }
        }
      }
    }
  }
  
  protected void a(xuf paramxuf, Activity paramActivity, int paramInt)
  {
    b(paramxuf, this.mContext, 0);
  }
  
  public void a(ztn paramztn)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayStart, id : ");
      if (paramztn != null) {
        break label78;
      }
    }
    label78:
    for (String str = "null";; str = paramztn.id + "")
    {
      QLog.d("AIOGalleryScene", 2, str);
      if ((paramztn == null) || (!paramztn.btg) || (!paramztn.btf)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "Filevideo onPlayStart igon playProgress");
      }
      return;
    }
    this.jdField_b_of_type_MqqOsMqqHandler.post(this.et);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.eu);
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.eu, 100L);
    this.jdField_b_of_type_Xto.c().a.bjw = true;
    updateUI();
  }
  
  public void a(ztn paramztn, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("[TVKInfo] onEndBuffering, id : ");
      if (paramztn == null)
      {
        localObject1 = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject1);
      }
    }
    else
    {
      localObject1 = this.jdField_b_of_type_Xto.c();
      if ((localObject1 != null) && (((xuf)localObject1).e != null) && (paramztn != null)) {
        break label96;
      }
    }
    label96:
    do
    {
      return;
      localObject1 = paramztn.id + "";
      break;
      localObject2 = a(paramztn.id, paramztn.subid);
      if (localObject2 != null) {
        ((xuf)localObject2).a.bjt = false;
      }
    } while (((xuf)localObject1).e.id != paramztn.id);
    updateUI();
  }
  
  public void a(ztn paramztn, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onError , id : ");
      if (paramztn == null)
      {
        localObject = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject);
      }
    }
    else
    {
      if (paramztn != null) {
        break label80;
      }
    }
    label80:
    label231:
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
              localObject = paramztn.id + "";
              break;
              localObject = this.jdField_b_of_type_Xto.c();
            } while (((xuf)localObject).e.id != paramztn.id);
            if (!paramztn.btg) {
              break label231;
            }
          } while (!AIOFileVideoData.class.isInstance(((xuf)localObject).e));
          paramString = myh.s(paramInt1, paramInt2);
          localObject = (AIOFileVideoData)((xuf)localObject).e;
        } while (((AIOFileVideoData)localObject).isCancel);
        ((AIOFileVideoData)localObject).ya(paramString);
        paramString = new Bundle();
        float f1 = 0.0F;
        if (ztl.class.isInstance(this.jdField_c_of_type_Ztk)) {
          f1 = ((ztl)this.jdField_c_of_type_Ztk).g(paramztn.id);
        }
        paramString.putFloat("progress", f1);
        this.jdField_a_of_type_Xuh.onFileVideoStatusChange(((AIOFileVideoData)localObject).id, 10, paramString);
        updateUI();
        return;
        paramztn = a(paramztn.id, paramztn.subid);
      } while (paramztn == null);
      paramztn.a.bjA = true;
    } while (!AIOShortVideoData.class.isInstance(((xuf)localObject).e));
    ((AIOShortVideoData)((xuf)localObject).e).ya(paramString);
    updateUI();
  }
  
  public void a(ztn paramztn, long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onDurationReady , id : ");
      if (paramztn != null) {
        break label57;
      }
    }
    label57:
    for (paramztn = "null";; paramztn = paramztn.id + "")
    {
      QLog.d("AIOGalleryScene", 2, paramztn);
      this.Kn.setText(ShortVideoUtils.stringForTime(paramLong));
      return;
    }
  }
  
  public void a(ztn paramztn, boolean paramBoolean)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onGetUrl, id : ");
      if (paramztn == null)
      {
        str = "null";
        QLog.d("AIOGalleryScene", 2, str + " isStart=" + paramBoolean);
      }
    }
    else
    {
      if (paramztn != null) {
        break label87;
      }
    }
    label87:
    do
    {
      do
      {
        return;
        str = paramztn.id + "";
        break;
        paramztn = a(paramztn.id, paramztn.subid);
      } while (paramztn == null);
      paramztn.a.bjz = paramBoolean;
    } while (paramztn.a.bjw);
    this.Ko.setText("");
    updateUI();
  }
  
  boolean a(ausj paramausj, AIOImageData paramAIOImageData)
  {
    return false;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    anot.a(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (this.bWR == 4) {
      return true;
    }
    try
    {
      if (!AIODevLittleVideoData.class.isInstance(this.jdField_b_of_type_Xto.c().e)) {
        showActionSheet(1);
      }
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
        }
      }
    }
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    return false;
  }
  
  public void adc()
  {
    this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new AIOGalleryScene.28(this), 1000L);
  }
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if (paramInt2 == 2) {
      d(paramLong1, paramInt1, paramBoolean);
    }
    do
    {
      Object localObject;
      do
      {
        for (;;)
        {
          return;
          if (paramInt2 == 24)
          {
            ai(paramLong1, paramInt1);
            return;
          }
          if (paramInt2 == 4)
          {
            a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2);
            return;
          }
          if (paramInt2 != 1) {
            break;
          }
          localObject = this.jdField_b_of_type_Xto.be();
          paramInt1 = 0;
          while (paramInt1 < ((List)localObject).size())
          {
            xuf localxuf = (xuf)((List)localObject).get(paramInt1);
            if (localxuf.e.id == paramLong1)
            {
              localxuf.progress = paramInt3;
              this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onLoadProgressUpdate(paramInt1, paramInt3 / 100);
              return;
            }
            paramInt1 += 1;
          }
        }
        if (paramInt2 != 256) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "save video progress : " + paramInt3);
        }
        localObject = this.jdField_b_of_type_Xto.c().e;
      } while ((((AIORichMediaData)localObject).id != paramLong1) || (((AIORichMediaData)localObject).subId != paramInt1));
      this.Kl.setText(acfp.m(2131702226) + paramInt3 + "%");
      this.l.setProgress((int)(paramInt3 / 100.0D * 10000.0D));
      return;
      if (paramInt2 == 18)
      {
        ae(paramLong1, paramBoolean);
        return;
      }
    } while (paramInt2 != 20);
    U(paramLong1, paramLong2);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 2) {
      c(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
    }
    do
    {
      return;
      if (paramInt2 == 24)
      {
        c(paramLong, paramInt1, paramInt2, paramInt3, paramString);
        return;
      }
      if (paramInt2 == 4)
      {
        d(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        return;
      }
      if (paramInt2 == 256)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "save video result resultStr = " + paramString);
        }
        if (paramInt3 == 1) {
          QQToast.a(this.mContext, this.mContext.getString(2131718933), 0).show();
        }
        for (;;)
        {
          this.jdField_a_of_type_Xsk$b.biW = false;
          updateUI();
          return;
          QQToast.a(this.mContext, this.mContext.getString(2131718929), 0).show();
        }
      }
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        e(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        return;
      }
      if (paramInt2 == 18)
      {
        f(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        return;
      }
      if ((paramInt2 == 20) && (this.jdField_a_of_type_Xsk$a != null) && (this.jdField_a_of_type_Xsk$a.id == paramLong))
      {
        d(paramLong, paramInt1, paramInt2, paramInt3, paramString);
        return;
      }
    } while (paramInt2 != 269484034);
    i(paramLong, paramInt3, paramString);
  }
  
  public void b(ztn paramztn)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayPause , id : ");
      if (paramztn != null) {
        break label56;
      }
    }
    label56:
    for (paramztn = "null";; paramztn = paramztn.id + "")
    {
      QLog.d("AIOGalleryScene", 2, paramztn);
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.et);
      return;
    }
  }
  
  public void b(ztn paramztn, int paramInt)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[TVKInfo] onDownloading, id : ");
      if (paramztn == null)
      {
        str = "null";
        QLog.d("AIOGalleryScene", 2, str);
      }
    }
    else
    {
      if (paramztn != null) {
        break label77;
      }
    }
    label77:
    do
    {
      do
      {
        return;
        str = paramztn.id + "";
        break;
        paramztn = a(paramztn.id, paramztn.subid);
      } while (paramztn == null);
      paramztn.a.bjx = true;
    } while (paramztn.a.bjw);
    this.Ko.setText("");
    updateUI();
  }
  
  boolean b(xuf paramxuf)
  {
    return false;
  }
  
  public void bBN()
  {
    super.bBN();
    xuf localxuf = this.jdField_b_of_type_Xto.d();
    if (localxuf != null) {
      localxuf.bjr = false;
    }
  }
  
  public void bBO()
  {
    super.bBO();
    xuf localxuf = this.jdField_b_of_type_Xto.d();
    if (localxuf != null) {
      localxuf.bjr = false;
    }
    this.bWR = 3;
    this.biS = true;
    if ((this.mContext instanceof AIOGalleryActivity))
    {
      ((AIOGalleryActivity)this.mContext).biz = false;
      ((AIOGalleryActivity)this.mContext).Jt = -1L;
    }
  }
  
  public boolean back()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Xto != null)
    {
      if (this.jdField_b_of_type_Xto.c() != null) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      return bool1;
      Object localObject = this.jdField_b_of_type_Xto.c().e;
      if ((localObject != null) && (AIOImageData.class.isInstance(localObject)) && (this.jdField_b_of_type_Xto.c().a != null) && (this.jdField_b_of_type_Xto.c().a.bjs))
      {
        if (this.jdField_a_of_type_Xsk$a != null) {
          this.jdField_a_of_type_Xuh.cancelDownloadMedia(this.jdField_a_of_type_Xsk$a.id, this.jdField_a_of_type_Xsk$a.subId, 4);
        }
        this.jdField_b_of_type_Xto.c().a.bjs = false;
        updateUI();
        return true;
      }
      gm(false);
      bool2 = super.back();
      ceI();
      localObject = getRootView().findViewById(2131367844);
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      if (this.biL)
      {
        localObject = this.jdField_b_of_type_Xto.c();
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((xuf)localObject).e);
          this.mContext.setResult(-1, localIntent);
        }
      }
      bool1 = bool2;
    } while (!this.biO);
    this.mContext.setResult(-1, this.mContext.getIntent());
    return bool2;
  }
  
  public void c(ztn paramztn)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[TVKInfo] onPlayFinish , id : ");
      if (paramztn != null) {
        break label88;
      }
    }
    label88:
    for (paramztn = "null";; paramztn = paramztn.id + "")
    {
      QLog.d("AIOGalleryScene", 2, paramztn);
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.eu);
      this.jdField_b_of_type_MqqOsMqqHandler.post(this.et);
      this.jdField_b_of_type_Xto.c();
      this.m.setProgress(100);
      updateUI();
      return;
    }
  }
  
  protected void ceH()
  {
    if (this.bWR == 2) {}
    for (int i = 1; this.biL; i = 0)
    {
      this.biN = true;
      this.mContext.onBackPressed();
      return;
    }
    Intent localIntent = new Intent(this.mContext, ChatHistoryActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.mFriendUin);
    localIntent.putExtra("SissionUin", this.mFriendUin);
    localIntent.putExtra("uintype", this.mCurType);
    localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
    localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((xuf)this.jdField_a_of_type_Sxm.a()).e);
    localIntent.putExtra("leftViewText", this.mContext.getString(2131721059));
    this.mContext.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
    if (i == 0) {
      this.mContext.finish();
    }
    this.mContext.startActivity(localIntent);
    this.mContext.overridePendingTransition(2130772362, 2130772302);
  }
  
  public void ceI()
  {
    if ((this.jdField_b_of_type_ComTencentWidgetGallery == null) || (this.jdField_b_of_type_Xto == null)) {}
    do
    {
      int i;
      int j;
      int n;
      do
      {
        return;
        i = this.jdField_b_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
        j = this.jdField_b_of_type_ComTencentWidgetGallery.getChildCount();
        n = this.jdField_b_of_type_Xto.getSelectedIndex();
      } while ((n < i) || (n > j + i - 1));
      View localView = this.jdField_b_of_type_ComTencentWidgetGallery.getChildAt(n - i);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localView))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(n, (AIOGalleryAdapter.GalleryImageStruct)localView);
        return;
      }
    } while (this.jdField_c_of_type_Ztk == null);
    this.jdField_c_of_type_Ztk.stopPlayAudio();
  }
  
  void ceJ()
  {
    Object localObject;
    try
    {
      localObject = this.jdField_b_of_type_Xto.c().e;
      if (((localObject instanceof AIOImageData)) || ((localObject instanceof AIOFilePicData)))
      {
        File localFile = a((AIORichMediaData)localObject);
        if (localFile != null) {}
      }
      else
      {
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
      return;
    }
    this.mFilePath = localNullPointerException.getAbsolutePath();
    int i = 99;
    int j;
    boolean bool;
    int n;
    Intent localIntent;
    switch (this.bWR)
    {
    default: 
      j = 0;
      bool = false;
      n = 0;
      localIntent = EditPicActivity.a(this.mContext, localNullPointerException.getAbsolutePath(), true, true, true, true, true, 2, i, 7);
      localIntent.putExtra("uintype", this.mCurType);
      localIntent.putExtra("open_chatfragment", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
      localIntent.putExtra("key_enable_edit_title_bar", true);
      if (bool) {
        localIntent.putExtra("key_help_forward_pic", bool);
      }
      if (j != 0) {
        localIntent.putExtra("key_allow_multiple_forward_from_limit", false);
      }
      if ((localObject instanceof AIOFilePicData))
      {
        if (this.jdField_a_of_type_Xuh.asBinder().pingBinder())
        {
          localObject = this.jdField_a_of_type_Xuh.getForwardData(((AIORichMediaData)localObject).id, ((AIORichMediaData)localObject).subId, this.mCurType);
          if (localObject != null)
          {
            ((Intent)localObject).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
            localObject = (ForwardFileInfo)((Intent)localObject).getParcelableExtra("fileinfo");
            if (localObject != null) {
              localIntent.putExtra("fileinfo", (Parcelable)localObject);
            }
          }
        }
        localIntent.putExtra("not_forward", true);
      }
      if (n != 0) {
        this.mContext.startActivityForResult(localIntent, n);
      }
      break;
    }
    for (;;)
    {
      this.mContext.overridePendingTransition(2130772077, 2130772079);
      anot.a(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
      return;
      anot.a(null, "dc00898", "", "", "0X800A187", "0X800A187", 0, 0, "", "", "", "");
      j = 0;
      bool = true;
      i = 125;
      n = 19002;
      break;
      i = 126;
      j = 1;
      bool = true;
      n = 19000;
      break;
      i = 127;
      j = 1;
      bool = true;
      n = 19000;
      break;
      i = 128;
      j = 1;
      bool = true;
      n = 19000;
      break;
      i = 129;
      j = 1;
      bool = true;
      n = 19000;
      break;
      i = 130;
      j = 0;
      bool = true;
      n = 19000;
      break;
      this.mContext.startActivity(localIntent);
    }
  }
  
  public void ceK()
  {
    if ((this.jdField_c_of_type_Ztk != null) && (this.jdField_c_of_type_Ztk.a != null) && (this.jdField_c_of_type_Ztk.a.btf) && (this.jdField_c_of_type_Ztk.VL()))
    {
      this.jdField_c_of_type_Ztk.setDownloadNetworkChange(2);
      Object localObject = this.mContext.getString(2131720253);
      localObject = aqha.a(this.mContext, 230, null, (String)localObject, 2131696322, 2131721952, new xtc(this), new xtd(this));
      if (this.jdField_c_of_type_Ztk != null) {
        this.jdField_c_of_type_Ztk.pause();
      }
      d((Dialog)localObject);
    }
  }
  
  public void clearShortVideo()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.clearTheOuchCache();
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131561546, null);
  }
  
  public void d(ztn paramztn)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("[TVKInfo] onBuffering, id : ");
      if (paramztn == null)
      {
        localObject1 = "null";
        QLog.d("AIOGalleryScene", 2, (String)localObject1);
      }
    }
    else
    {
      localObject1 = this.jdField_b_of_type_Xto.c();
      if ((localObject1 != null) && (((xuf)localObject1).e != null) && (paramztn != null)) {
        break label94;
      }
    }
    label94:
    do
    {
      return;
      localObject1 = paramztn.id + "";
      break;
      localObject2 = a(paramztn.id, paramztn.subid);
      if (localObject2 != null) {
        ((xuf)localObject2).a.bjt = true;
      }
    } while ((((xuf)localObject1).e.id != paramztn.id) || (((xuf)localObject1).e.subId != paramztn.subid));
    updateUI();
  }
  
  public void dismissProgressDialog()
  {
    this.aGH = true;
    if (this.mDialog != null) {}
    try
    {
      this.mDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AIOGalleryScene", 2, localException, new Object[0]);
    }
  }
  
  public void fG(long paramLong)
  {
    boolean bool = true;
    int i;
    if ((this.jdField_a_of_type_Sxz != null) && (this.jdField_a_of_type_Sxz.a() == this))
    {
      i = 1;
      if (i != 0) {
        break label49;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "onRevokeMsg not currentScene!");
      }
    }
    label49:
    xuf localxuf;
    do
    {
      return;
      i = 0;
      break;
      localxuf = this.jdField_b_of_type_Xto.c();
      if ((localxuf != null) && (localxuf.e != null)) {
        break label88;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AIOGalleryScene", 2, "onRevokeMsg exp!");
    return;
    label88:
    if ((this.biF) && (this.Jw == paramLong)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + paramLong + ", selectItem seq:" + localxuf.e.id + ", isFromMultiMsg:" + this.biF + ", OriSeq:" + this.Jw);
      }
      if ((this.jdField_a_of_type_Xuh != null) && (!bool)) {
        this.jdField_a_of_type_Xuh.gc(paramLong);
      }
      this.mContext.runOnUiThread(new AIOGalleryScene.31(this, paramLong, localxuf, bool));
      return;
      bool = false;
    }
  }
  
  public void gm(boolean paramBoolean)
  {
    this.biU = paramBoolean;
    if (this.Kk != null)
    {
      if (this.biU) {
        this.Kk.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.Kk.setVisibility(4);
  }
  
  @TargetApi(11)
  public void ie()
  {
    if ((this.biT) || (this.isLoading) || (this.ed)) {
      this.jdField_b_of_type_ComTencentWidgetGallery.setSelection(this.jdField_b_of_type_Xto.getSelectedIndex());
    }
  }
  
  public void initData()
  {
    Bundle localBundle = this.mContext.getIntent().getExtras();
    Object localObject = (AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE");
    if ((localObject instanceof AIOShortVideoData))
    {
      int i = this.mContext.getIntent().getIntExtra("forward_source_uin_type", -1);
      if (i != -1) {
        ((AIOShortVideoData)localObject).istroop = i;
      }
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = ((AIORichMediaData)localObject);
    localObject = new xuf((AIORichMediaData)localObject);
    this.jdField_b_of_type_Xto.g((xuf)localObject);
    this.mIsMute = localBundle.getBoolean("muate_play");
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "initData , mIsMute = " + this.mIsMute);
    }
    ((xuf)localObject).bn = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.bWM = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
    this.biT = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.bWO = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
    this.biP = localBundle.getBoolean("extra.IS_HOT_CHAT", false);
    this.biQ = localBundle.getBoolean("extra.IS_SAVING_FILE", false);
    this.bWQ = localBundle.getInt("extra.SAVE_FILE_PROGRESS", 0);
    this.biK = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.QE = localBundle.getString("extra.GROUP_UIN");
    if (this.biK)
    {
      this.aRJ = localBundle.getString("extra.GROUP_CODE");
      if (((this.QE == null) || (this.aRJ == null) || (this.aWf == null)) && (QLog.isColorLevel())) {
        QLog.i("AIOGalleryScene", 2, "mGroupUin=" + this.QE + ", mGroupCode=" + this.aRJ + ", mMyUin=" + this.aWf);
      }
    }
    this.bWP = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.biH = localBundle.getBoolean("extra.IS_APOLLO");
    this.biF = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
    this.Jw = localBundle.getLong("key_multi_forward_seq", 0L);
    this.biG = localBundle.getBoolean("extra.IS_RECEIPT_MSG");
    this.mCurType = localBundle.getInt("forward_source_uin_type", -1);
    this.mFriendUin = localBundle.getString("uin");
    this.biL = localBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", false);
    if (this.biL)
    {
      this.jdField_b_of_type_Xto.setReverse(true);
      this.biM = true;
      if (!TextUtils.isEmpty(localBundle.getString("babyq_video_type"))) {
        break label570;
      }
    }
    label570:
    for (boolean bool = false;; bool = true)
    {
      this.biO = bool;
      this.biI = localBundle.getBoolean("extra.OCR", false);
      this.aWe = localBundle.getString("extra.OCR_TEXT");
      if (TextUtils.isEmpty(this.aWe)) {
        this.aWe = this.mContext.getString(2131694758);
      }
      this.biJ = localBundle.getBoolean("group.emo.big.preview", false);
      this.bWR = localBundle.getInt("extra.EXTRA_ENTRANCE");
      this.biR = localBundle.getBoolean("is_ReplyMsg_From_Same_Session", true);
      return;
      ((xuf)localObject).isImgCenterCropMode = false;
      break;
    }
  }
  
  protected boolean needEnterRectAnimation()
  {
    boolean bool = true;
    if (this.bWM == 1) {
      bool = false;
    }
    return bool;
  }
  
  protected boolean needExitRectAnimation()
  {
    if (((this.bWM == -3321) || (this.bWM == 1)) && (!this.biL)) {
      return false;
    }
    if (this.bWO == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    for (int i = localRunningAppProcessInfo.pid;; i = -2147483648) {
      return i == this.bWO;
    }
  }
  
  public boolean needShowPageView()
  {
    return false;
  }
  
  public void notifyImageModelDataChanged()
  {
    if (this.biH) {
      return;
    }
    if (this.jdField_b_of_type_Xto.ws() == 0)
    {
      akxp.Nu(false);
      QQToast.a(this.mContext, 2131694320, 0).show();
      this.mContext.finish();
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged(true);
      this.isLoading = false;
      this.ed = true;
      int i = this.jdField_b_of_type_Xto.getSelectedIndex();
      if (i == this.jdField_b_of_type_ComTencentWidgetGallery.getSelectedItemPosition()) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetGallery.setSelection(i);
      return;
      akxp.Nu(true);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      l(this.mContext, paramIntent.getExtras());
      if (this.mCurType == 9501) {
        this.mContext.finish();
      }
    }
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 == 10001))
      {
        QQToast.a(this.mContext, 2131720247, 0).show();
        return;
      }
    } while ((paramInt1 != 10002) || (this.jdField_a_of_type_Anjo == null));
    this.jdField_a_of_type_Anjo.Va(paramInt2);
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
      ceC();
      continue;
      anot.a(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
      showActionSheet(2);
      continue;
      ceG();
      continue;
      ceH();
      anot.a(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", sZ(), getCurType(), "" + bN("0X8009EFD"), "", "", "");
      continue;
      ceJ();
      anot.a(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", sZ(), getCurType(), "" + bN("0X8009EFC"), "", "", "");
      continue;
      xuf localxuf = this.jdField_b_of_type_Xto.c();
      if ((localxuf != null) && (localxuf.e != null) && ((localxuf.e instanceof AIOFilePicData)))
      {
        if (this.jdField_a_of_type_Xsk$a != null)
        {
          back();
          back();
        }
      }
      else if ((localxuf != null) && (localxuf.e != null) && ((localxuf.e instanceof AIOImageData)) && (((AIOImageData)localxuf.e).EP == 3) && (this.jdField_a_of_type_Xsk$a != null))
      {
        back();
        back();
        continue;
        fz(paramView);
        continue;
        ceD();
        continue;
        ceE();
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    ayxa.enableNotch(this.mContext);
    super.onCreate(paramViewGroup);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, this);
    this.mRoot = ((RelativeLayout)getRootView());
    this.jdField_a_of_type_Anjo = anjo.a(axol.getAppInterface());
    if (this.jdField_a_of_type_Anjo != null) {
      this.tN = this.jdField_a_of_type_Anjo.a(this.mContext, this.mRoot, this.aWf);
    }
    this.tN.setVisibility(4);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    paramViewGroup = this.mContext.getResources().getDisplayMetrics();
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, paramViewGroup));
    int i = (int)TypedValue.applyDimension(1, 5.0F, paramViewGroup);
    this.Kk = new TextView(this.mContext);
    this.Kk.setId(2131374892);
    this.Kk.setTextColor(this.mContext.getResources().getColorStateList(2131165412));
    this.Kk.setTextSize(1, 14.0F);
    this.Kk.setShadowLayer(2.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131165587));
    this.Kk.setText(2131697151);
    this.Kk.setContentDescription(this.mContext.getString(2131697151));
    this.Kk.setPadding(i, i, i, i);
    this.Kk.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130844427));
    this.mRoot.addView(this.Kk, localLayoutParams);
    this.Kk.setVisibility(4);
    this.an = new ImageButton(this.mContext);
    this.an.setContentDescription(acfp.m(2131702229));
    this.an.setId(2131374887);
    this.an.setImageResource(2130838128);
    this.an.setBackgroundDrawable(null);
    this.an.setPadding(0, 0, 0, 0);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 25.0F, paramViewGroup));
    boolean bool;
    if ((SH()) && (!(this.mContext.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)))
    {
      i = 1;
      if ((i == 0) || (this.bWR == 3)) {
        break label1138;
      }
      bool = true;
      label485:
      if (bool) {
        this.mRoot.addView(this.an, localLayoutParams);
      }
      this.an.setOnClickListener(this);
      this.an.setVisibility(4);
      this.k = new ImageButton(this.mContext);
      this.k.setContentDescription(acfp.m(2131702224));
      this.k.setId(2131374888);
      this.k.setImageResource(2130838126);
      this.k.setBackgroundDrawable(null);
      this.k.setPadding(0, 0, 0, 0);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.topMargin = ((int)TypedValue.applyDimension(1, 10.0F, paramViewGroup));
      localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 24.0F, paramViewGroup));
      Bundle localBundle = this.mContext.getIntent().getExtras();
      if (!((AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)) {
        this.mRoot.addView(this.k, localLayoutParams);
      }
      this.k.setOnClickListener(this);
      this.bWR = localBundle.getInt("extra.EXTRA_ENTRANCE");
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "editPhotoBtn mContext.getIntent().getBooleanExtra: " + this.mContext.getIntent().getBooleanExtra("extra.FROM_AIO", false));
      }
      this.al = new ImageButton(this.mContext);
      if ((!this.mContext.getIntent().getBooleanExtra("extra.FROM_AIO", false)) && (this.bWR != 3) && (this.bWR != 2)) {
        break label1143;
      }
      i = 1;
      label800:
      if (((i != 0) || ((this.bWR == 4) && (localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) && (top.eD(this.mCurType) != 1032) && (this.mCurType != 1037) && (top.eD(this.mCurType) != 1044))
      {
        this.al.setContentDescription(acfp.m(2131702220));
        this.al.setImageResource(2130838121);
        this.al.setBackgroundDrawable(null);
        this.al.setEnabled(false);
        this.al.setId(2131374889);
        this.al.setPadding(0, 0, 0, 0);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.alignWithParent = true;
        if (!bool) {
          break label1148;
        }
        localLayoutParams.addRule(0, 2131374887);
      }
    }
    for (;;)
    {
      localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
      localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 20.0F, paramViewGroup));
      this.mRoot.addView(this.al, localLayoutParams);
      this.al.setOnClickListener(this);
      this.al.setVisibility(4);
      zz(bool);
      ceF();
      this.Kk.setOnClickListener(this);
      if ((ProGallery.b.class.isInstance(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (ProGallery.class.isInstance(this.jdField_b_of_type_ComTencentWidgetGallery))) {
        ((ProGallery)this.jdField_b_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
      }
      this.jdField_c_of_type_Ztk.a(this);
      this.jdField_c_of_type_Ztk.b(this);
      this.jdField_c_of_type_Ztk.setEntrance(this.bWR);
      ((ProGallery)this.jdField_b_of_type_ComTencentWidgetGallery).setGestureListener(this);
      this.midScreenWidth = (anmk.getScreenWidth(this.mContext) / 2);
      xsi.a().a(this);
      return;
      i = 0;
      break;
      label1138:
      bool = false;
      break label485;
      label1143:
      i = 0;
      break label800;
      label1148:
      localLayoutParams.addRule(11, -1);
    }
  }
  
  public void onDestroy()
  {
    xuf localxuf = this.jdField_b_of_type_Xto.c();
    if ((localxuf != null) && (AIOShortVideoData.class.isInstance(localxuf.e)) && (((AIOShortVideoData)localxuf.e).mBusiType == 0) && (this.jdField_c_of_type_Ztk != null)) {
      this.jdField_c_of_type_Ztk.onDestory();
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    super.onDestroy();
    if (this.bWS > 0) {
      anot.a(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, "" + this.bWS, "", "", "");
    }
    xsi.a().b(this);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.destory();
    }
    this.jdField_a_of_type_Anjo = null;
    if (this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(null);
      this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.eu);
    }
    xuk.a().clearCache();
    if (this.jdField_b_of_type_Aduk != null) {
      this.jdField_b_of_type_Aduk.destroy();
    }
  }
  
  public void onDismissOperations()
  {
    updateSystemUIVisablity();
  }
  
  public void onEnterAnimationEnd()
  {
    ie();
    xuf localxuf = this.jdField_b_of_type_Xto.d();
    if (localxuf != null) {
      localxuf.bjr = true;
    }
    if (!SI()) {
      this.k.setVisibility(0);
    }
    if (this.bWR == 4) {
      this.k.setVisibility(8);
    }
    this.jdField_a_of_type_Xsk$b.biY = false;
    updateUI();
    Looper.myQueue().addIdleHandler(this.f);
  }
  
  public void onEnterAnimationStart()
  {
    this.jdField_a_of_type_Xsk$b.biY = true;
    updateUI();
    if (!SJ()) {
      this.k.setVisibility(4);
    }
    if (this.an != null) {
      this.an.setVisibility(4);
    }
  }
  
  public void onExitAnimationEnd()
  {
    if (this.biN)
    {
      this.biN = false;
      Intent localIntent = new Intent(this.mContext, ChatHistoryFileActivity.class);
      localIntent.addFlags(603979776);
      xuf localxuf = this.jdField_b_of_type_Xto.c();
      if (localxuf != null) {
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localxuf.e);
      }
      localIntent.putExtra("tab_tab_type", 0);
      localIntent.putExtra("uin", this.mFriendUin);
      localIntent.putExtra("uintype", this.mCurType);
      localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
      localIntent.putExtra("leftViewText", this.mContext.getString(2131721059));
      this.mContext.startActivity(localIntent);
      this.mContext.overridePendingTransition(0, 0);
    }
  }
  
  public void onExitAnimationStart()
  {
    if (!SJ()) {
      this.k.setVisibility(4);
    }
    if (this.al != null) {
      this.al.setVisibility(4);
    }
    if (this.an != null) {
      this.an.setVisibility(4);
    }
    if (this.jdField_a_of_type_Anjo != null) {
      this.jdField_a_of_type_Anjo.dQW();
    }
    this.jdField_a_of_type_Xsk$b.bja = true;
    updateUI();
  }
  
  public void onFinish()
  {
    ceI();
    if (this.jdField_c_of_type_Ztk != null) {
      this.jdField_c_of_type_Ztk.crN();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onItemClick");
    }
    paramAdapterView = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.e == null)) {
      QLog.e("AIOGalleryScene", 1, "there data is null, position:" + paramInt);
    }
    label262:
    label312:
    for (;;)
    {
      return;
      if ((AIOImageData.class.isInstance(paramAdapterView.e)) || (AIOFilePicData.class.isInstance(paramAdapterView.e))) {
        back();
      }
      MotionEvent localMotionEvent = ((DragGallery)this.jdField_b_of_type_ComTencentWidgetGallery).getSingleTapConfirmedEvent();
      if (AIOShortVideoData.class.isInstance(paramAdapterView.e))
      {
        if (((AIOShortVideoData)paramAdapterView.e).mBusiType == 0) {
          break label262;
        }
        if (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)) {
          break label254;
        }
        AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)paramView;
        if (!localGalleryImageStruct.T(localMotionEvent)) {
          break label246;
        }
        localGalleryImageStruct.rr(paramInt);
      }
      for (;;)
      {
        if ((!AIOFileVideoData.class.isInstance(paramAdapterView.e)) || (this.jdField_c_of_type_Ztk == null)) {
          break label312;
        }
        if ((localMotionEvent == null) || (this.jdField_c_of_type_Ztk == null) || (!this.jdField_c_of_type_Ztk.T(localMotionEvent))) {
          break label314;
        }
        paramAdapterView = (AIOFileVideoData)paramAdapterView.e;
        paramAdapterView.a(paramView, this.jdField_c_of_type_Ztk);
        paramAdapterView.biu = false;
        if (TextUtils.isEmpty(paramAdapterView.mFilePath)) {
          break;
        }
        updateUI();
        return;
        label246:
        back();
        continue;
        label254:
        back();
        continue;
        if ((this.jdField_c_of_type_Ztk != null) && (localMotionEvent != null) && (this.jdField_c_of_type_Ztk.T(localMotionEvent)))
        {
          if (!this.jdField_a_of_type_Xsk$b.biW) {
            this.jdField_c_of_type_Ztk.aNX();
          }
        }
        else {
          back();
        }
      }
    }
    label314:
    back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    Ds(paramInt);
    gm(false);
    this.jdField_b_of_type_ComTencentWidgetGallery.enableDoubleTap(true);
    this.jdField_b_of_type_ComTencentWidgetGallery.enableScaleGesture(true);
    AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct;
    Drawable localDrawable;
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      localDrawable = localGalleryImageStruct.getDrawable();
      if ((!localGalleryImageStruct.isOriginalImage()) && (localDrawable != null) && ((localDrawable instanceof URLDrawable))) {
        c(paramAdapterView, paramView, paramInt, paramLong);
      }
    }
    else
    {
      zA(false);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = getRootView().findViewById(2131367844);
        if (paramAdapterView != null)
        {
          if (paramAdapterView.getAnimation() != null)
          {
            paramAdapterView.getAnimation().cancel();
            paramAdapterView.setAnimation(null);
          }
          paramAdapterView.setVisibility(4);
        }
      }
      paramAdapterView = this.jdField_b_of_type_Xto.a(paramInt);
      if (paramAdapterView != null) {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(paramAdapterView.getThumbRect());
      }
      if (paramAdapterView != null)
      {
        if ((!(paramAdapterView.e instanceof AIOFilePicData)) || (!((AIOFilePicData)paramAdapterView.e).bir)) {
          break label303;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onLoadStart(paramInt, -1);
          ((AIOFilePicData)paramAdapterView.e).bir = false;
        }
      }
    }
    for (;;)
    {
      d(paramAdapterView);
      updateUI();
      if ((paramAdapterView != null) && (this.jdField_a_of_type_Anjo != null))
      {
        if (!(paramAdapterView.e instanceof AIOShortVideoData)) {
          break label333;
        }
        this.jdField_a_of_type_Anjo.c((AIOShortVideoData)paramAdapterView.e);
      }
      return;
      if ((localGalleryImageStruct.isOriginalImage()) || (localDrawable == null) || (!(localDrawable instanceof SkinnableBitmapDrawable))) {
        break;
      }
      Dt(paramInt);
      break;
      label303:
      if ((paramAdapterView.e instanceof AIOFileVideoData))
      {
        zA(false);
        this.jdField_b_of_type_MqqOsMqqHandler.post(this.et);
      }
    }
    label333:
    this.jdField_a_of_type_Anjo.c(null);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {
      try
      {
        if (!AIODevLittleVideoData.class.isInstance(this.jdField_b_of_type_Xto.c().e)) {
          showActionSheet(3);
        }
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
          }
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetMobile2None");
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetMobile2Wifi s=" + paramString);
    }
    if (this.jdField_c_of_type_Ztk != null) {
      this.jdField_c_of_type_Ztk.setDownloadNetworkChange(1);
    }
    xuk.a().clearCache();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetNone2Mobile s=" + paramString);
    }
    ceK();
    xuk.a().clearCache();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetNone2Wifi s=" + paramString);
    }
    xuk.a().clearCache();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetWifi2Mobile s=" + paramString);
    }
    ceK();
    xuk.a().clearCache();
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetWifi2None");
    }
  }
  
  public void onPause() {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramSeekBar = this.jdField_b_of_type_Xto.c().e;
      if (!(paramSeekBar instanceof AIOShortVideoData)) {
        break label76;
      }
      paramSeekBar = (AIOShortVideoData)paramSeekBar;
      if (paramSeekBar.mBusiType != 0) {
        break label67;
      }
      if (this.jdField_c_of_type_Ztk != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_c_of_type_Ztk.getDuration());
        this.jdField_c_of_type_Ztk.seek(paramInt);
      }
    }
    label67:
    label76:
    while ((!AIOFileVideoData.class.isInstance(paramSeekBar)) || (this.jdField_c_of_type_Ztk == null))
    {
      do
      {
        return;
      } while (paramSeekBar.mBusiType != 1);
      return;
    }
    paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_c_of_type_Ztk.getDuration());
    this.jdField_c_of_type_Ztk.seek(paramInt);
  }
  
  public void onResume()
  {
    updateSystemUIVisablity();
    if (this.jdField_c_of_type_Ztk != null) {
      this.jdField_c_of_type_Ztk.onResume();
    }
  }
  
  public void onRotateFinished(View paramView, int paramInt1, int paramInt2) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("onScroll", 2, "distanceX=" + paramFloat1 + " x1=" + paramMotionEvent1.getRawX() + " x2=" + paramMotionEvent2.getRawX() + " x2-x1=" + (paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX()) + " alldis=");
    }
    if (Math.abs(paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX()) > this.midScreenWidth) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onScrollHalfScreenWidth();
    }
    return false;
  }
  
  public void onScrollEnd(int paramInt)
  {
    super.onScrollEnd(paramInt);
    this.jdField_a_of_type_Xsk$b.scrolling = false;
    updateUI();
  }
  
  public void onScrollStart(int paramInt)
  {
    super.onScrollStart(paramInt);
    this.jdField_a_of_type_Xsk$b.scrolling = true;
    updateUI();
  }
  
  public void onSeekComplete() {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onStop");
    }
    super.onStop();
    clearShortVideo();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_c_of_type_Ztk != null) {
      this.jdField_c_of_type_Ztk.crv();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  void reportData(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Xuh != null) {
      this.jdField_a_of_type_Xuh.reportData(paramString, paramInt);
    }
  }
  
  void showActionSheet(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.mContext);
      this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.mContext.getString(2131694193));
    }
    this.jdField_c_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(new xsu(this));
    xuf localxuf = this.jdField_b_of_type_Xto.c();
    Object localObject;
    int i;
    if (AIOImageData.class.isInstance(localxuf.e))
    {
      localObject = (AIOImageData)localxuf.e;
      a((AIOImageData)localObject, paramInt, localxuf);
      if ((((AIOImageData)localObject).istroop != 1) || (!((AIOImageData)localObject).bjg)) {
        break label326;
      }
      i = 2;
    }
    for (;;)
    {
      int j = fk(localxuf.e.istroop);
      int n = wr();
      if (paramInt == 2)
      {
        paramInt = 1;
        label141:
        anot.a(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", i, 0, String.valueOf(j), String.valueOf(n), String.valueOf(paramInt), "");
        return;
        if (AIOShortVideoData.class.isInstance(localxuf.e))
        {
          localObject = (AIOShortVideoData)localxuf.e;
          if (((AIOShortVideoData)localObject).mBusiType == 0) {
            i = 4;
          }
        }
      }
      for (;;)
      {
        b((AIOShortVideoData)localObject, paramInt);
        break;
        if (((AIOShortVideoData)localObject).mBusiType == 1)
        {
          i = 3;
          continue;
          if (AIOFilePicData.class.isInstance(localxuf.e))
          {
            b((AIOFilePicData)localxuf.e, paramInt);
            i = 2;
            break;
          }
          if (AIOFileVideoData.class.isInstance(localxuf.e))
          {
            i = 5;
            a((AIOFileVideoData)localxuf.e, paramInt);
            break;
            if (paramInt == 1)
            {
              paramInt = 2;
              break label141;
            }
            paramInt = 0;
            break label141;
          }
          i = 0;
          break;
        }
        i = 0;
      }
      label326:
      i = 1;
    }
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.jdField_b_of_type_Arht == null) {
      return;
    }
    this.jdField_b_of_type_Arht.stopAnimating();
    this.jdField_b_of_type_Arht.setProgress(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("AIOGalleryScene", 2, "[setProgress] current:" + this.jdField_b_of_type_Arht.getProgress() + ", progress:" + paramInt);
    }
    this.jdField_b_of_type_Arht.setShowText(true);
    this.jdField_b_of_type_Arht.setShowImage(false);
    this.jdField_b_of_type_Arht.setText(String.valueOf(paramInt) + "%");
  }
  
  protected void updateSystemUIVisablity()
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (int i = 4356;; i = 4)
    {
      this.mRoot.setSystemUiVisibility(i);
      return;
    }
  }
  
  public void updateUI()
  {
    if ((this.jdField_a_of_type_Xsk$b.scrolling) || (this.jdField_a_of_type_Xsk$b.biY) || (this.jdField_a_of_type_Xsk$b.biZ) || (this.jdField_a_of_type_Xsk$b.bja))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryScene", 2, "updateUI selectedItem all gone");
      }
      this.hi.setVisibility(8);
      this.hP.setVisibility(8);
      this.al.setVisibility(8);
      this.Kk.setVisibility(8);
      this.hQ.setVisibility(8);
      ax(false);
    }
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_Xto.c().e instanceof AIOShortVideoData)) {
        c(this.jdField_b_of_type_Xto.c());
      }
      while ((this.bWR == 4) || (top.eD(this.mCurType) == 1032))
      {
        this.an.setVisibility(8);
        return;
        if ((this.jdField_b_of_type_Xto.c().e instanceof AIOImageData)) {
          a((AIOImageData)this.jdField_b_of_type_Xto.c().e, this.jdField_b_of_type_Xto.c());
        } else if ((this.jdField_b_of_type_Xto.c().e instanceof AIOFilePicData)) {
          a((AIOFilePicData)this.jdField_b_of_type_Xto.c().e);
        } else if ((this.jdField_b_of_type_Xto.c().e instanceof AIOFileVideoData)) {
          a((AIOFileVideoData)this.jdField_b_of_type_Xto.c().e);
        }
      }
    }
  }
  
  public void zA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "showLoadPanel : " + paramBoolean);
    }
    if (this.hP == null) {
      return;
    }
    if (paramBoolean)
    {
      this.hP.setVisibility(0);
      gm(false);
      this.an.setVisibility(8);
      this.al.setVisibility(8);
      this.hi.setVisibility(8);
      return;
    }
    this.hP.setVisibility(8);
  }
  
  final class a
    implements URLDrawable.URLDrawableListener
  {
    long id;
    URLDrawable p;
    int subId;
    
    a() {}
    
    public void onLoadCanceled(URLDrawable paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadCanceled URL():" + paramURLDrawable.getURL());
      }
      xsk.this.zA(false);
      xsk.this.a = null;
    }
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadFialed URL():" + paramURLDrawable.getURL());
      }
      QQToast.a(xsk.b(xsk.this), xsk.c(xsk.this).getString(2131697153), 0).show();
      xsk.this.gm(true);
      xsk.this.zA(false);
      xsk.this.a = null;
    }
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadSuccessed URL():" + paramURLDrawable.getURL());
      }
      xsk.this.gm(false);
      xsk.this.zA(false);
      xsk.this.jdField_b_of_type_Xto.f.orientation = paramURLDrawable.getExifOrientation();
      xsk.this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.updateCache(paramURLDrawable, xsk.c(xsk.this).getSelectedItemPosition());
      xsk.this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged();
      xsk.d(xsk.this).reset();
      xsk.this.a = null;
    }
  }
  
  public class b
  {
    boolean biW = false;
    boolean biX = false;
    boolean biY = false;
    boolean biZ = false;
    boolean bja = false;
    boolean scrolling = false;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsk
 * JD-Core Version:    0.7.0.1
 */