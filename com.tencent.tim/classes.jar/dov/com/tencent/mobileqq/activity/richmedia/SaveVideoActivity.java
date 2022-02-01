package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import anpc;
import aqhq;
import axcg;
import axol;
import ayuw;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import pog;
import rma;
import rop;
import rox;
import rqa;
import rqi;

public class SaveVideoActivity
  extends FlowActivity
{
  private static rqa jdField_a_of_type_Rqa;
  private static boolean dAX;
  private a jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a;
  private boolean backPressed;
  private int requestCode;
  
  public static Intent a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new Intent(paramContext, SaveVideoActivity.class);
    paramContext.putExtra("fakeId", paramString);
    paramContext.putExtra("sv_total_frame_count", paramInt2);
    paramContext.putExtra("sv_total_record_time", paramInt1);
    paramContext.putExtra("save_video_businessid", paramInt3);
    return paramContext;
  }
  
  private static PublishVideoEntry a(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      if (paramAppInterface == null) {
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
      }
      paramAppInterface = new QQStoryEntityManagerFactory(paramAppInterface);
      paramAppInterface.verifyAuthentication();
      paramAppInterface = ShortVideoRealItemBuilder.a(paramAppInterface.createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[] { paramString });
    } while ((paramAppInterface == null) || (paramAppInterface.size() <= 0));
    return (PublishVideoEntry)paramAppInterface.get(0);
  }
  
  private static void a(AppInterface paramAppInterface, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry == null) {
      return;
    }
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    if (paramAppInterface == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    paramAppInterface = new QQStoryEntityManagerFactory(paramAppInterface);
    paramAppInterface.verifyAuthentication();
    paramAppInterface.createEntityManager().remove(paramPublishVideoEntry);
  }
  
  protected void K(ViewGroup paramViewGroup) {}
  
  public void onBackPressed()
  {
    if (this.backPressed) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    aniq.dHk = paramBundle.getIntExtra("sv_total_frame_count", 0);
    aniq.bQi = paramBundle.getIntExtra("sv_total_record_time", 0);
    this.requestCode = paramBundle.getIntExtra("requestCode", -1);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a = new a(this, axol.getAppInterface());
    a.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a, paramBundle.getBooleanExtra("mediacodec_encode_enable", false));
    a.b(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a, paramBundle.getBooleanExtra("video_edit_flag", false));
    a.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a, paramBundle.getIntExtra("save_video_businessid", -1));
    Utils.executeAsyncTaskOnSerialExcuter(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a, new Void[] { (Void)null });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.backPressed = true;
      if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a != null) && (!isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "cancel save video");
        }
        if (rma.a().tG() == 22)
        {
          if (this.requestCode != 111) {
            break label123;
          }
          LpReportInfo_pf00064.allReport(680, 12, 2);
        }
      }
    }
    for (;;)
    {
      a.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a).set(true);
      setResult(0, getIntent());
      if (getIntent() != null) {
        ThreadManager.postImmediately(new SaveVideoActivity.1(this, getIntent().getStringExtra("fakeId")), null, true);
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
      label123:
      if (this.requestCode == 222) {
        LpReportInfo_pf00064.allReport(680, 13, 2);
      }
    }
  }
  
  public static class a
    extends AsyncTask<Void, Void, Void>
  {
    private WeakReference<AppInterface> bV;
    private String cXW;
    private boolean dAY;
    private boolean dAZ;
    double dz;
    private int eMR = -1;
    private AtomicBoolean eS = new AtomicBoolean(false);
    private String fakeId;
    private WeakReference<PeakActivity> ju;
    
    a(PeakActivity paramPeakActivity, AppInterface paramAppInterface)
    {
      this.ju = new WeakReference(paramPeakActivity);
      this.bV = new WeakReference(paramAppInterface);
    }
    
    private String a(PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.ju.get() == null) {
        return null;
      }
      Object localObject1 = (Context)this.ju.get();
      for (;;)
      {
        try
        {
          str = dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.sV(paramPublishVideoEntry.mLocalRawVideoDir);
          File localFile = new File(str);
          localFile.getParentFile().mkdirs();
          localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2130846913);
          if ((TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) || (!paramBoolean)) {
            break label422;
          }
          i = 1;
          if (i != 0)
          {
            paramPublishVideoEntry = BitmapFactory.decodeFile(paramPublishVideoEntry.doodlePath);
            localObject2 = Bitmap.createScaledBitmap(paramPublishVideoEntry, paramInt1, paramInt2, true);
            if (paramPublishVideoEntry != localObject2) {
              paramPublishVideoEntry.recycle();
            }
            localBitmap = Bitmap.createBitmap(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
            Canvas localCanvas = new Canvas(localBitmap);
            localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, null);
            if (paramInt1 == 576) {
              break label428;
            }
            f = paramInt1 / 576.0F;
            paramPublishVideoEntry = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
            localCanvas.drawBitmap(paramPublishVideoEntry, 20.0F, ((Bitmap)localObject2).getHeight() - 20 - paramPublishVideoEntry.getHeight(), null);
            paramPublishVideoEntry.recycle();
            paramPublishVideoEntry = localBitmap;
            if (rop.a(paramPublishVideoEntry, Bitmap.CompressFormat.PNG, 100, localFile.getAbsolutePath())) {
              continue;
            }
            rop.f(paramPublishVideoEntry);
            if (((Bitmap)localObject1).isRecycled()) {
              break label420;
            }
            rop.f((Bitmap)localObject1);
            break label420;
          }
          localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          localObject2 = new Canvas(localBitmap);
          if (paramInt1 == 576) {
            continue;
          }
          float f = paramInt1 / 576.0F;
          paramPublishVideoEntry = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
        }
        catch (OutOfMemoryError paramPublishVideoEntry)
        {
          String str;
          Object localObject2;
          Bitmap localBitmap;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("SaveVideoActivity", 2, paramPublishVideoEntry, new Object[0]);
          return null;
          paramPublishVideoEntry = (PublishVideoEntry)localObject1;
          continue;
          rop.f(paramPublishVideoEntry);
          if (((Bitmap)localObject1).isRecycled()) {
            continue;
          }
          rop.f((Bitmap)localObject1);
          return str;
        }
        catch (Exception paramPublishVideoEntry)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("SaveVideoActivity", 2, paramPublishVideoEntry, new Object[0]);
          continue;
        }
        ((Canvas)localObject2).drawBitmap(paramPublishVideoEntry, 20.0F, paramInt2 - 20 - paramPublishVideoEntry.getHeight(), null);
        paramPublishVideoEntry.recycle();
        paramPublishVideoEntry = localBitmap;
        continue;
        label420:
        return null;
        label422:
        int i = 0;
        continue;
        label428:
        paramPublishVideoEntry = (PublishVideoEntry)localObject1;
      }
    }
    
    private void a(int paramInt, PublishVideoEntry paramPublishVideoEntry)
    {
      if ((this.bV.get() != null) && (this.ju.get() != null) && (!((PeakActivity)this.ju.get()).isFinishing()))
      {
        Activity localActivity = (Activity)this.ju.get();
        SaveVideoActivity.b((AppInterface)this.bV.get(), paramPublishVideoEntry);
        localActivity.setResult(mf(paramInt), localActivity.getIntent());
        localActivity.finish();
        if (mf(paramInt) == -1) {
          afa(this.eMR);
        }
      }
    }
    
    private void a(PeakActivity paramPeakActivity, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
    {
      this.cXW = com.tencent.mobileqq.shortvideo.ShortVideoUtils.zL();
      if (SaveVideoActivity.a() == null) {
        SaveVideoActivity.a(rqa.a(paramPeakActivity.getApplicationContext()));
      }
      if (SaveVideoActivity.a().LT()) {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "generate files mFFmpeg is running!");
        }
      }
      do
      {
        return;
        try
        {
          if (axcg.au(paramPeakActivity.getIntent()))
          {
            this.cXW = MiniAppFileManager.getInstance().getTmpPathFromOut(paramString1, bV((Context)this.ju.get()));
            paramPeakActivity = MiniAppFileManager.getInstance().getTmpPathFromOut(paramPublishVideoEntry.thumbPath, bV((Context)this.ju.get()));
            paramPublishVideoEntry.miniThumbPath = paramPeakActivity;
            aqhq.copyFile(paramPublishVideoEntry.thumbPath, paramPeakActivity);
          }
          paramPeakActivity = new a(paramPublishVideoEntry, paramString1, this.cXW);
          SaveVideoActivity.a().sH(this.cXW);
          SaveVideoActivity.a().a(paramString2, paramString1, this.cXW, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, paramPeakActivity);
          return;
        }
        catch (Exception paramPeakActivity) {}
      } while (!QLog.isColorLevel());
      QLog.d("SaveVideoActivity", 2, "generate files save alum:" + paramPeakActivity);
    }
    
    private boolean aRe()
    {
      if (this.eS.get())
      {
        if ((this.ju.get() != null) && (this.bV.get() != null)) {
          a(0, SaveVideoActivity.b((AppInterface)this.bV.get(), this.fakeId));
        }
        return true;
      }
      return false;
    }
    
    /* Error */
    private void aac()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 48	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:ju	Ljava/lang/ref/WeakReference;
      //   4: invokevirtual 62	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   7: ifnull +13 -> 20
      //   10: aload_0
      //   11: getfield 50	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:bV	Ljava/lang/ref/WeakReference;
      //   14: invokevirtual 62	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   17: ifnonnull +4 -> 21
      //   20: return
      //   21: aload_0
      //   22: invokespecial 337	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:aRe	()Z
      //   25: ifne -5 -> 20
      //   28: aload_0
      //   29: getfield 48	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:ju	Ljava/lang/ref/WeakReference;
      //   32: invokevirtual 62	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   35: checkcast 188	com/tencent/mobileqq/activity/aio/photo/PeakActivity
      //   38: astore 13
      //   40: aload_0
      //   41: getfield 50	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:bV	Ljava/lang/ref/WeakReference;
      //   44: invokevirtual 62	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   47: checkcast 195	com/tencent/common/app/AppInterface
      //   50: astore 12
      //   52: aload 13
      //   54: invokevirtual 251	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
      //   57: astore 11
      //   59: aload 11
      //   61: ifnull -41 -> 20
      //   64: aload_0
      //   65: aload 11
      //   67: ldc_w 338
      //   70: invokevirtual 343	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
      //   73: putfield 327	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:fakeId	Ljava/lang/String;
      //   76: aload 12
      //   78: aload_0
      //   79: getfield 327	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:fakeId	Ljava/lang/String;
      //   82: invokestatic 330	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity:b	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
      //   85: astore 14
      //   87: aload 14
      //   89: ifnonnull +20 -> 109
      //   92: aload 13
      //   94: iconst_1
      //   95: aload 13
      //   97: invokevirtual 251	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
      //   100: invokevirtual 344	com/tencent/mobileqq/activity/aio/photo/PeakActivity:setResult	(ILandroid/content/Intent;)V
      //   103: aload 13
      //   105: invokevirtual 345	com/tencent/mobileqq/activity/aio/photo/PeakActivity:finish	()V
      //   108: return
      //   109: aload 11
      //   111: ldc_w 347
      //   114: iconst_m1
      //   115: invokevirtual 351	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
      //   118: bipush 22
      //   120: if_icmpne +63 -> 183
      //   123: iconst_1
      //   124: istore_1
      //   125: aconst_null
      //   126: astore 11
      //   128: aload_0
      //   129: getfield 353	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:dAZ	Z
      //   132: ifeq +62 -> 194
      //   135: aload 14
      //   137: getfield 291	com/tencent/biz/qqstory/database/PublishVideoEntry:videoWidth	I
      //   140: istore_2
      //   141: aload 14
      //   143: getfield 294	com/tencent/biz/qqstory/database/PublishVideoEntry:videoHeight	I
      //   146: istore_3
      //   147: iload_1
      //   148: ifne +40 -> 188
      //   151: iconst_1
      //   152: istore 4
      //   154: aload_0
      //   155: aload 14
      //   157: iload_2
      //   158: iload_3
      //   159: iload 4
      //   161: invokespecial 355	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:a	(Lcom/tencent/biz/qqstory/database/PublishVideoEntry;IIZ)Ljava/lang/String;
      //   164: astore 12
      //   166: aload 12
      //   168: astore 11
      //   170: aload 12
      //   172: ifnonnull +22 -> 194
      //   175: aload_0
      //   176: iconst_1
      //   177: aload 14
      //   179: invokespecial 316	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
      //   182: return
      //   183: iconst_0
      //   184: istore_1
      //   185: goto -60 -> 125
      //   188: iconst_0
      //   189: istore 4
      //   191: goto -37 -> 154
      //   194: aload_0
      //   195: invokespecial 337	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:aRe	()Z
      //   198: ifne -178 -> 20
      //   201: invokestatic 360	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
      //   204: astore 12
      //   206: invokestatic 365	azbb:a	()Lazbb;
      //   209: invokevirtual 368	azbb:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
      //   212: invokevirtual 373	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
      //   215: pop
      //   216: ldc 177
      //   218: ldc_w 375
      //   221: invokestatic 380	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   224: aload_0
      //   225: invokespecial 337	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:aRe	()Z
      //   228: ifne -208 -> 20
      //   231: invokestatic 385	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
      //   234: ifeq +176 -> 410
      //   237: lconst_0
      //   238: lstore 7
      //   240: aload 12
      //   242: getfield 388	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   245: astore 15
      //   247: aload 15
      //   249: monitorenter
      //   250: aload 12
      //   252: getfield 388	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   255: invokevirtual 325	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   258: istore 4
      //   260: lload 7
      //   262: lstore 5
      //   264: iload 4
      //   266: ifne +85 -> 351
      //   269: lload 7
      //   271: lstore 5
      //   273: ldc 177
      //   275: ldc_w 390
      //   278: invokestatic 380	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   281: lload 7
      //   283: lstore 5
      //   285: invokestatic 396	android/os/SystemClock:elapsedRealtime	()J
      //   288: lstore 9
      //   290: lload 7
      //   292: lstore 5
      //   294: aload 12
      //   296: getfield 388	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   299: ldc2_w 397
      //   302: invokevirtual 402	java/lang/Object:wait	(J)V
      //   305: lload 7
      //   307: lstore 5
      //   309: invokestatic 396	android/os/SystemClock:elapsedRealtime	()J
      //   312: lload 9
      //   314: lsub
      //   315: lstore 7
      //   317: lload 7
      //   319: lstore 5
      //   321: ldc 177
      //   323: new 299	java/lang/StringBuilder
      //   326: dup
      //   327: invokespecial 300	java/lang/StringBuilder:<init>	()V
      //   330: ldc_w 404
      //   333: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   336: lload 7
      //   338: invokevirtual 407	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   341: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   344: invokestatic 380	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   347: lload 7
      //   349: lstore 5
      //   351: aload 15
      //   353: monitorexit
      //   354: ldc 177
      //   356: ldc_w 409
      //   359: invokestatic 380	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   362: lload 5
      //   364: ldc2_w 410
      //   367: lcmp
      //   368: ifge +42 -> 410
      //   371: bipush 20
      //   373: lload 5
      //   375: l2i
      //   376: isub
      //   377: istore_2
      //   378: iload_2
      //   379: istore_1
      //   380: iload_2
      //   381: bipush 10
      //   383: if_icmpge +6 -> 389
      //   386: bipush 10
      //   388: istore_1
      //   389: ldc 177
      //   391: ldc_w 413
      //   394: iload_1
      //   395: invokestatic 419	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   398: invokestatic 422	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
      //   401: iload_1
      //   402: i2l
      //   403: lstore 5
      //   405: lload 5
      //   407: invokestatic 427	java/lang/Thread:sleep	(J)V
      //   410: aload_0
      //   411: invokespecial 337	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:aRe	()Z
      //   414: ifne -394 -> 20
      //   417: aload 14
      //   419: getfield 430	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
      //   422: ifeq +11 -> 433
      //   425: aload 14
      //   427: getfield 430	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
      //   430: putstatic 435	aniq:bsT	I
      //   433: aload 14
      //   435: getfield 438	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
      //   438: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   441: ifne +347 -> 788
      //   444: aload 14
      //   446: getfield 438	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
      //   449: invokestatic 442	aqhq:fileExists	(Ljava/lang/String;)Z
      //   452: ifeq +336 -> 788
      //   455: iconst_1
      //   456: istore_1
      //   457: new 77	java/io/File
      //   460: dup
      //   461: aload 14
      //   463: getfield 69	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
      //   466: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   469: astore 15
      //   471: aload 15
      //   473: invokestatic 446	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:C	(Ljava/io/File;)Ljava/lang/String;
      //   476: astore 12
      //   478: aload 12
      //   480: ifnull +28 -> 508
      //   483: new 77	java/io/File
      //   486: dup
      //   487: aload 12
      //   489: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   492: invokevirtual 449	java/io/File:getParent	()Ljava/lang/String;
      //   495: astore 16
      //   497: aload 16
      //   499: ifnull +9 -> 508
      //   502: aload 16
      //   504: invokestatic 454	rox:checkDirAndCreate	(Ljava/lang/String;)Z
      //   507: pop
      //   508: invokestatic 459	java/lang/System:currentTimeMillis	()J
      //   511: lstore 5
      //   513: new 461	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
      //   516: dup
      //   517: aconst_null
      //   518: aconst_null
      //   519: aload 14
      //   521: getfield 69	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
      //   524: aload 12
      //   526: aconst_null
      //   527: invokespecial 464	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   530: astore 16
      //   532: aload 16
      //   534: iconst_0
      //   535: invokevirtual 467	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PW	(Z)V
      //   538: aload 16
      //   540: iconst_0
      //   541: invokevirtual 470	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:CN	(Z)V
      //   544: aload 16
      //   546: aload 14
      //   548: getfield 473	com/tencent/biz/qqstory/database/PublishVideoEntry:isMuteRecordVoice	Z
      //   551: invokevirtual 476	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:PY	(Z)V
      //   554: aload 14
      //   556: getfield 480	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
      //   559: ifnull +18 -> 577
      //   562: aload 16
      //   564: aload 14
      //   566: getfield 480	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
      //   569: aload 14
      //   571: getfield 483	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicSize	I
      //   574: invokevirtual 487	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:q	([BI)V
      //   577: aload 16
      //   579: invokevirtual 490	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
      //   582: aload 16
      //   584: getfield 493	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:errorCode	I
      //   587: istore_2
      //   588: aload_0
      //   589: invokestatic 459	java/lang/System:currentTimeMillis	()J
      //   592: lload 5
      //   594: lsub
      //   595: l2d
      //   596: ldc2_w 494
      //   599: ddiv
      //   600: putfield 497	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:dz	D
      //   603: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   606: ifeq +49 -> 655
      //   609: ldc 177
      //   611: iconst_2
      //   612: new 299	java/lang/StringBuilder
      //   615: dup
      //   616: invokespecial 300	java/lang/StringBuilder:<init>	()V
      //   619: ldc_w 499
      //   622: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   625: invokestatic 459	java/lang/System:currentTimeMillis	()J
      //   628: lload 5
      //   630: lsub
      //   631: l2d
      //   632: ldc2_w 494
      //   635: ddiv
      //   636: invokevirtual 502	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   639: ldc_w 504
      //   642: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   645: iload_2
      //   646: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   649: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   652: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   655: aload_0
      //   656: invokespecial 337	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:aRe	()Z
      //   659: ifne -639 -> 20
      //   662: iload_2
      //   663: ifeq +130 -> 793
      //   666: aload 13
      //   668: invokevirtual 251	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
      //   671: ldc_w 509
      //   674: iload_2
      //   675: invokevirtual 513	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   678: pop
      //   679: aload_0
      //   680: iconst_1
      //   681: aload 14
      //   683: invokespecial 316	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
      //   686: return
      //   687: astore 15
      //   689: ldc 177
      //   691: ldc_w 515
      //   694: aload 15
      //   696: invokestatic 518	ram:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   699: invokestatic 385	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
      //   702: ifeq -478 -> 224
      //   705: aload 12
      //   707: getfield 388	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   710: astore 15
      //   712: aload 15
      //   714: monitorenter
      //   715: aload 12
      //   717: getfield 388	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   720: iconst_1
      //   721: invokevirtual 521	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   724: aload 12
      //   726: getfield 388	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   729: invokevirtual 524	java/lang/Object:notifyAll	()V
      //   732: aload 15
      //   734: monitorexit
      //   735: goto -511 -> 224
      //   738: astore 11
      //   740: aload 15
      //   742: monitorexit
      //   743: aload 11
      //   745: athrow
      //   746: astore 12
      //   748: ldc 177
      //   750: new 299	java/lang/StringBuilder
      //   753: dup
      //   754: invokespecial 300	java/lang/StringBuilder:<init>	()V
      //   757: ldc_w 526
      //   760: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   763: aload 12
      //   765: invokevirtual 529	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   768: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   771: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   774: invokestatic 380	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   777: goto -426 -> 351
      //   780: astore 11
      //   782: aload 15
      //   784: monitorexit
      //   785: aload 11
      //   787: athrow
      //   788: iconst_0
      //   789: istore_1
      //   790: goto -333 -> 457
      //   793: iload_1
      //   794: ifeq +74 -> 868
      //   797: aload 15
      //   799: invokestatic 532	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:u	(Ljava/io/File;)Ljava/lang/String;
      //   802: astore 15
      //   804: aload 12
      //   806: invokestatic 536	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDurationOfVideo	(Ljava/lang/String;)J
      //   809: lstore 5
      //   811: iconst_1
      //   812: aload 13
      //   814: aload 12
      //   816: aload 14
      //   818: getfield 438	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
      //   821: aload 14
      //   823: getfield 539	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicOffset	I
      //   826: lload 5
      //   828: l2i
      //   829: aload 15
      //   831: new 541	ayux
      //   834: dup
      //   835: aload_0
      //   836: aload 12
      //   838: aload 13
      //   840: aload 15
      //   842: aload 11
      //   844: aload 14
      //   846: invokespecial 544	ayux:<init>	(Ldov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a;Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/PeakActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
      //   849: invokestatic 549	rqj:a	(ZLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lrpz;)V
      //   852: return
      //   853: astore 11
      //   855: aload 11
      //   857: invokevirtual 552	java/lang/Exception:printStackTrace	()V
      //   860: aload_0
      //   861: iconst_1
      //   862: aload 14
      //   864: invokespecial 316	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
      //   867: return
      //   868: aload_0
      //   869: aload 13
      //   871: aload 12
      //   873: aload 11
      //   875: aload 14
      //   877: invokespecial 319	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity$a:a	(Lcom/tencent/mobileqq/activity/aio/photo/PeakActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
      //   880: return
      //   881: astore 12
      //   883: goto -473 -> 410
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	886	0	this	a
      //   124	670	1	i	int
      //   140	535	2	j	int
      //   146	13	3	k	int
      //   152	113	4	bool	boolean
      //   262	565	5	l1	long
      //   238	110	7	l2	long
      //   288	25	9	l3	long
      //   57	112	11	localObject1	Object
      //   738	6	11	localObject2	Object
      //   780	63	11	str	String
      //   853	21	11	localException	Exception
      //   50	675	12	localObject3	Object
      //   746	126	12	localInterruptedException1	java.lang.InterruptedException
      //   881	1	12	localInterruptedException2	java.lang.InterruptedException
      //   38	832	13	localPeakActivity	PeakActivity
      //   85	791	14	localPublishVideoEntry	PublishVideoEntry
      //   245	227	15	localObject4	Object
      //   687	8	15	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
      //   495	88	16	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   206	224	687	java/lang/UnsatisfiedLinkError
      //   715	735	738	finally
      //   740	743	738	finally
      //   273	281	746	java/lang/InterruptedException
      //   285	290	746	java/lang/InterruptedException
      //   294	305	746	java/lang/InterruptedException
      //   309	317	746	java/lang/InterruptedException
      //   321	347	746	java/lang/InterruptedException
      //   250	260	780	finally
      //   273	281	780	finally
      //   285	290	780	finally
      //   294	305	780	finally
      //   309	317	780	finally
      //   321	347	780	finally
      //   351	354	780	finally
      //   748	777	780	finally
      //   782	785	780	finally
      //   797	852	853	java/lang/Exception
      //   405	410	881	java/lang/InterruptedException
    }
    
    private void afa(int paramInt)
    {
      if ((this.ju.get() == null) || (TextUtils.isEmpty(this.cXW))) {}
      while (new File(this.cXW).exists()) {
        return;
      }
    }
    
    private String bV(Context paramContext)
    {
      if (paramContext != null) {
        return paramContext.getSharedPreferences("mini_launch_ae_tag", 0).getString("mini_launch_ae_app_id", "");
      }
      return "";
    }
    
    private void eTN()
    {
      if ((this.ju.get() == null) || (this.bV.get() == null)) {}
      PeakActivity localPeakActivity;
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return;
          } while (aRe());
          localPeakActivity = (PeakActivity)this.ju.get();
          localObject1 = (AppInterface)this.bV.get();
          localObject2 = localPeakActivity.getIntent();
        } while (localObject2 == null);
        this.fakeId = ((Intent)localObject2).getStringExtra("fakeId");
        localObject2 = SaveVideoActivity.b((AppInterface)localObject1, this.fakeId);
        if (localObject2 == null)
        {
          localPeakActivity.setResult(1, localPeakActivity.getIntent());
          localPeakActivity.finish();
          return;
        }
      } while (aRe());
      Object localObject1 = ((PublishVideoEntry)localObject2).mLocalRawVideoDir;
      Object localObject3 = new File(((PublishVideoEntry)localObject2).mLocalRawVideoDir);
      if (((File)localObject3).isFile()) {
        localObject1 = ((File)localObject3).getParent();
      }
      localObject1 = dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.C(new File((String)localObject1));
      if (localObject1 != null)
      {
        localObject3 = new File((String)localObject1).getParent();
        if (localObject3 != null) {
          rox.checkDirAndCreate((String)localObject3);
        }
      }
      new pog().a((PublishVideoEntry)localObject2, (String)localObject1, false, true, new ayuw(this, localPeakActivity, (String)localObject1, null, (PublishVideoEntry)localObject2));
    }
    
    private int mf(int paramInt)
    {
      if (this.eS.get()) {
        paramInt = 0;
      }
      return paramInt;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      if (this.dAY) {
        eTN();
      }
      for (;;)
      {
        return null;
        aac();
      }
    }
    
    class a
      implements rqi
    {
      String Kc;
      PublishVideoEntry g;
      long mStartTime;
      String sourcePath;
      
      a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
      {
        this.g = paramPublishVideoEntry;
        this.sourcePath = paramString1;
        this.Kc = paramString2;
        this.mStartTime = System.currentTimeMillis();
      }
      
      public void onFailure(String paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "generate files|third step fail:" + paramString + ",videoFinalPath= " + this.Kc);
        }
      }
      
      public void onFinish(boolean paramBoolean)
      {
        double d = (System.currentTimeMillis() - this.mStartTime) / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "generate files|third step cost:" + d + ",videoFinalPath= " + this.Kc);
        }
        Object localObject = new HashMap();
        ((HashMap)localObject).put("generate_video_cost", SaveVideoActivity.a.this.dz + "");
        ((HashMap)localObject).put("watermark_cost", d + "");
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "qq_ptv_save_time", true, 0L, 0L, (HashMap)localObject, null);
        aqhq.deleteFile(this.sourcePath);
        SaveVideoActivity.B(false);
        int i;
        Intent localIntent;
        if (SaveVideoActivity.a.a(SaveVideoActivity.a.this).get() != null)
        {
          localObject = (Activity)SaveVideoActivity.a.a(SaveVideoActivity.a.this).get();
          if (SaveVideoActivity.a.b(SaveVideoActivity.a.this).get() != null) {
            SaveVideoActivity.b((AppInterface)SaveVideoActivity.a.b(SaveVideoActivity.a.this).get(), this.g);
          }
          if (!paramBoolean) {
            break label340;
          }
          i = SaveVideoActivity.a.b(SaveVideoActivity.a.this, -1);
          if (!axcg.au(((Activity)localObject).getIntent())) {
            break label353;
          }
          localIntent = new Intent();
          if (paramBoolean)
          {
            localIntent.setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
            localIntent.putExtra("file_path", this.Kc);
            localIntent.putExtra("video_thumb_path", this.g.miniThumbPath);
            localIntent.putExtra("video_duration", this.g.videoDuration);
            localIntent.putExtra("is_video", true);
          }
          ((Activity)localObject).sendBroadcast(localIntent);
          ((Activity)localObject).setResult(i, ((Activity)localObject).getIntent());
          ((Activity)localObject).finish();
        }
        label340:
        label353:
        do
        {
          return;
          i = SaveVideoActivity.a.b(SaveVideoActivity.a.this, 1);
          break;
          localIntent = ((Activity)localObject).getIntent();
          if (paramBoolean) {
            localIntent.putExtra("key_video_save_path", this.Kc);
          }
          ((Activity)localObject).setResult(i, ((Activity)localObject).getIntent());
          ((Activity)localObject).finish();
        } while (i != -1);
        SaveVideoActivity.a.a(SaveVideoActivity.a.this, SaveVideoActivity.a.a(SaveVideoActivity.a.this));
      }
      
      public void onProgress(String paramString) {}
      
      public void onStart()
      {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack：onStart videoFinalPath= " + this.Kc);
        }
        SaveVideoActivity.B(true);
      }
      
      public void onSuccess(String paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack|onSuccess videoFinalPath= " + this.Kc);
        }
        rox.a(BaseApplication.getContext(), new File(this.Kc));
        aqhq.deleteFile(new File(this.sourcePath).getParent());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity
 * JD-Core Version:    0.7.0.1
 */