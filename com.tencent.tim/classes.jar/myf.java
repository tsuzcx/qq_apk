import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class myf
  extends msc
{
  myf(mye parammye) {}
  
  public void a(myi parammyi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    if (mye.a(this.this$0) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "onCompletion return for mVideoPlayerWrapper is null");
      }
      return;
    }
    long l = mye.a(this.this$0).c(true);
    mye.a(this.this$0, mye.a(this.this$0));
    mye.b(this.this$0, mye.a(this.this$0));
    mye.b localb;
    myp localmyp;
    int i;
    int j;
    boolean bool;
    if (mye.a(this.this$0) != null)
    {
      localb = mye.a(this.this$0);
      localmyp = mye.a(this.this$0);
      localb.c.playDuration = l;
      localb.xb = this.this$0.cZ();
      if ((localb.c.playDuration == 0L) && (localb.c.vt == 0L) && (localb.c.vs != 0L)) {
        localb.c.vt = (SystemClock.uptimeMillis() - localb.c.vs);
      }
      localb.c.jB = ((float)localb.c.playDuration / localb.videoDuration);
      localb.c.success = true;
      localb.c.isCompleted = true;
      localb.c.vD = parammyi.dd();
      localb.c.secondBufferCount = parammyi.qf();
      localb.c.videoFormat = parammyi.qg();
      localb.c.amD = parammyi.aqr;
      localb.c.mFileSize = parammyi.mFileSize;
      localb.c.vF = parammyi.vF;
      localb.c.vG = parammyi.df();
      localb.c.vH = parammyi.qh();
      localb.c.ahx = parammyi.ky();
      localb.c.vJ = parammyi.dh();
      localb.c.vK = parammyi.dg();
      localb.c.aSq = this.this$0.getVideoWidth();
      localb.c.aSr = this.this$0.getVideoHeight();
      if (mye.b(this.this$0) == null) {
        break label905;
      }
      parammyi = localb.c;
      i = mye.b(this.this$0).position;
      j = localb.position;
      if (localb.IH != 3) {
        break label899;
      }
      bool = true;
    }
    label899:
    label905:
    for (parammyi.aSw = kxm.b(i, j, bool);; localb.c.aSw = -1)
    {
      localb.c.IH = localb.IH;
      mye.a(this.this$0, localb);
      kxm.a(mye.a(this.this$0).getApplicationContext(), kxm.getAccount(), true, localb.c.u());
      kbx.a(localb.c);
      kxm.a(true, localb.c.aiJ, localb.c.videoFormat, localb.c.busiType, localb.c.vt, 56, localb.c.errCode, localb.c.rowkey);
      if (localb.c.playDuration > 0L)
      {
        new JSONObject();
        ThreadManager.post(new VideoPlayManager.1.3(this, localb, localmyp), 5, null, true);
      }
      anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localb.videoVid);
      parammyi = localb.d;
      if ((parammyi != null) && (knd.dh((int)parammyi.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(parammyi)) && (localb.aqp))
      {
        i = (int)l;
        jzk.a(new kku.a().a(mye.a(this.this$0)).a(jzk.aEO).b(jzk.aFB).a((AdvertisementInfo)parammyi).a(jzk.a(((AdvertisementInfo)parammyi).adbt, i, ((AdvertisementInfo)parammyi).getAdbf(), 1, ((AdvertisementInfo)parammyi).adpa, ((AdvertisementInfo)parammyi).adpb, parammyi.mVideoDuration, 1, 0)).a());
      }
      parammyi = localb.d;
      if ((parammyi != null) && (parammyi.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(parammyi))) {
        jzk.a(new kku.a().a(mye.a(this.this$0)).a(jzk.aEO).b(jzk.aFx).a((AdvertisementInfo)parammyi).a(jzk.a(((AdvertisementInfo)parammyi).adbt, parammyi.mVideoDuration * 1000, ((AdvertisementInfo)parammyi).getAdbf(), 1, ((AdvertisementInfo)parammyi).adpa, ((AdvertisementInfo)parammyi).adpb, parammyi.mVideoDuration, jzk.aGs, 0)).a());
      }
      mye.a(this.this$0).post(new VideoPlayManager.1.4(this));
      return;
      bool = false;
      break;
    }
  }
  
  public void a(myi parammyi, Object paramObject)
  {
    paramObject = mye.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + mye.a(this.this$0) + "   mVisable:" + mye.b(this.this$0));
    }
    if (!mye.a(this.this$0)) {}
    do
    {
      for (;;)
      {
        return;
        mye.a(this.this$0, false);
        if ((mye.a(this.this$0) != parammyi) || (paramObject == null)) {
          break;
        }
        mye.a(this.this$0).a(mye.a(this.this$0), paramObject);
        mye.a(this.this$0).ad(paramObject.position, true);
        if ((paramObject.c != null) && (paramObject.c.vt == 0L))
        {
          paramObject.c.vt = (SystemClock.uptimeMillis() - paramObject.c.vs);
          mhu localmhu = paramObject.c;
          localmhu.vv += paramObject.c.vt;
          localmhu = paramObject.c;
          localmhu.bufferCount += 1;
          if (((parammyi.getPlayDetailsTime() == null) || (paramObject.c == null)) || ((paramObject.c != null) && (QLog.isColorLevel()))) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.c.vt);
          }
        }
        mye.a(this.this$0, paramObject, mye.a(this.this$0), 2, null);
        if ((mzj.av(mye.a(this.this$0))) || (!GesturePWDUtils.isAppOnForeground(mye.a(this.this$0))) || (mye.a(this.this$0) == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(mye.a(this.this$0)));
          }
          mye.a(this.this$0).post(new VideoPlayManager.1.1(this));
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video", 2, "");
          return;
          parammyi.start();
          mye.a(this.this$0, paramObject, mye.a(this.this$0), 3, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  public void a(myi parammyi, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((mye.a(this.this$0) != null) && (mye.a(this.this$0).c != null)) {
      mye.a(this.this$0).c.ahz = paramString;
    }
    mzz.a().a(parammyi, mye.a(this.this$0).videoDuration, parammyi.getFileSize());
  }
  
  public void a(myi parammyi, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (mye.a(this.this$0).size() >= 10)
    {
      parammyi = (Pair)mye.a(this.this$0).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + parammyi.first);
      }
    }
    if (paramBoolean) {
      mye.a(this.this$0).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((myi)mye.a(this.this$0).get(Integer.valueOf(paramInt2))).destory();
  }
  
  public boolean a(myi parammyi, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(mye.TAG, 2, "video play has error ! " + paramObject);
      }
      this.this$0.f = mye.a(this.this$0);
      if (mye.a(this.this$0) != null) {
        ocp.e(mye.a(this.this$0).akK, mye.a(this.this$0).videoVid, 1, paramInt2);
      }
      if (parammyi == mye.a(this.this$0)) {
        mye.a(this.this$0).post(new VideoPlayManager.1.5(this, paramInt1, paramInt2, paramString, parammyi));
      }
      return true;
    }
  }
  
  /* Error */
  public boolean a(myi parammyi, int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 10	myf:this$0	Lmye;
    //   5: invokestatic 35	mye:a	(Lmye;)Lmyi;
    //   8: if_acmpne +63 -> 71
    //   11: aload_0
    //   12: getfield 10	myf:this$0	Lmye;
    //   15: invokevirtual 569	mye:qc	()I
    //   18: iconst_5
    //   19: if_icmpne +54 -> 73
    //   22: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +46 -> 71
    //   28: getstatic 544	mye:TAG	Ljava/lang/String;
    //   31: iconst_2
    //   32: new 363	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 571
    //   42: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_2
    //   46: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 573
    //   52: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: ldc_w 575
    //   62: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_0
    //   72: ireturn
    //   73: iload_2
    //   74: lookupswitch	default:+74->148, 28:+76->150, 39:+549->623, 40:+347->421, 41:+628->702, 42:+683->757, 112:+138->212, 113:+205->279, 208:+825->899
    //   149: ireturn
    //   150: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +13 -> 166
    //   156: getstatic 544	mye:TAG	Ljava/lang/String;
    //   159: iconst_2
    //   160: ldc_w 577
    //   163: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: getfield 10	myf:this$0	Lmye;
    //   170: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   173: ifnull -102 -> 71
    //   176: aload_0
    //   177: getfield 10	myf:this$0	Lmye;
    //   180: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   183: getfield 63	mye$b:c	Lmhu;
    //   186: ifnull -115 -> 71
    //   189: aload_0
    //   190: getfield 10	myf:this$0	Lmye;
    //   193: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   196: getfield 63	mye$b:c	Lmhu;
    //   199: astore_1
    //   200: aload_1
    //   201: aload_1
    //   202: getfield 580	mhu:aSt	I
    //   205: iconst_1
    //   206: iadd
    //   207: putfield 580	mhu:aSt	I
    //   210: iconst_0
    //   211: ireturn
    //   212: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +13 -> 228
    //   218: getstatic 544	mye:TAG	Ljava/lang/String;
    //   221: iconst_2
    //   222: ldc_w 582
    //   225: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: getfield 10	myf:this$0	Lmye;
    //   232: aload_0
    //   233: getfield 10	myf:this$0	Lmye;
    //   236: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   239: aload_0
    //   240: getfield 10	myf:this$0	Lmye;
    //   243: invokestatic 35	mye:a	(Lmye;)Lmyi;
    //   246: iconst_4
    //   247: aconst_null
    //   248: invokestatic 421	mye:a	(Lmye;Lmye$b;Lmyi;ILjava/lang/Object;)V
    //   251: aload_0
    //   252: getfield 10	myf:this$0	Lmye;
    //   255: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   258: ifnull -187 -> 71
    //   261: aload_0
    //   262: getfield 10	myf:this$0	Lmye;
    //   265: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   268: getfield 63	mye$b:c	Lmhu;
    //   271: invokestatic 87	android/os/SystemClock:uptimeMillis	()J
    //   274: putfield 585	mhu:vu	J
    //   277: iconst_0
    //   278: ireturn
    //   279: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +36 -> 318
    //   285: getstatic 544	mye:TAG	Ljava/lang/String;
    //   288: iconst_2
    //   289: new 363	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 587
    //   299: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: getfield 10	myf:this$0	Lmye;
    //   306: invokevirtual 590	mye:isPause	()Z
    //   309: invokevirtual 376	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   312: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload_0
    //   319: getfield 10	myf:this$0	Lmye;
    //   322: invokevirtual 590	mye:isPause	()Z
    //   325: ifne +26 -> 351
    //   328: aload_0
    //   329: getfield 10	myf:this$0	Lmye;
    //   332: aload_0
    //   333: getfield 10	myf:this$0	Lmye;
    //   336: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   339: aload_0
    //   340: getfield 10	myf:this$0	Lmye;
    //   343: invokestatic 35	mye:a	(Lmye;)Lmyi;
    //   346: iconst_3
    //   347: aconst_null
    //   348: invokestatic 421	mye:a	(Lmye;Lmye$b;Lmyi;ILjava/lang/Object;)V
    //   351: aload_0
    //   352: getfield 10	myf:this$0	Lmye;
    //   355: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   358: ifnull -287 -> 71
    //   361: aload_0
    //   362: getfield 10	myf:this$0	Lmye;
    //   365: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   368: getfield 63	mye$b:c	Lmhu;
    //   371: astore_1
    //   372: aload_1
    //   373: aload_1
    //   374: getfield 406	mhu:vv	J
    //   377: invokestatic 87	android/os/SystemClock:uptimeMillis	()J
    //   380: aload_0
    //   381: getfield 10	myf:this$0	Lmye;
    //   384: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   387: getfield 63	mye$b:c	Lmhu;
    //   390: getfield 585	mhu:vu	J
    //   393: lsub
    //   394: ladd
    //   395: putfield 406	mhu:vv	J
    //   398: aload_0
    //   399: getfield 10	myf:this$0	Lmye;
    //   402: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   405: getfield 63	mye$b:c	Lmhu;
    //   408: astore_1
    //   409: aload_1
    //   410: aload_1
    //   411: getfield 409	mhu:bufferCount	I
    //   414: iconst_1
    //   415: iadd
    //   416: putfield 409	mhu:bufferCount	I
    //   419: iconst_0
    //   420: ireturn
    //   421: new 240	org/json/JSONObject
    //   424: dup
    //   425: aload_3
    //   426: checkcast 592	java/lang/String
    //   429: invokespecial 595	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   432: astore_1
    //   433: aload_1
    //   434: ldc_w 597
    //   437: iconst_0
    //   438: invokevirtual 601	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   441: istore_2
    //   442: aload_1
    //   443: ldc_w 603
    //   446: iconst_1
    //   447: invokevirtual 601	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   450: istore 4
    //   452: aload_0
    //   453: getfield 10	myf:this$0	Lmye;
    //   456: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   459: ifnull -388 -> 71
    //   462: aload_0
    //   463: getfield 10	myf:this$0	Lmye;
    //   466: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   469: getfield 63	mye$b:c	Lmhu;
    //   472: ifnull -401 -> 71
    //   475: iload 4
    //   477: ifle +25 -> 502
    //   480: aload_0
    //   481: getfield 10	myf:this$0	Lmye;
    //   484: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   487: getfield 63	mye$b:c	Lmhu;
    //   490: astore_1
    //   491: aload_1
    //   492: aload_1
    //   493: getfield 606	mhu:skipFramesTotalCount	I
    //   496: iload 4
    //   498: iadd
    //   499: putfield 606	mhu:skipFramesTotalCount	I
    //   502: aload_0
    //   503: getfield 10	myf:this$0	Lmye;
    //   506: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   509: getfield 63	mye$b:c	Lmhu;
    //   512: astore_1
    //   513: aload_1
    //   514: aload_1
    //   515: getfield 609	mhu:aSu	I
    //   518: iload 4
    //   520: iadd
    //   521: putfield 609	mhu:aSu	I
    //   524: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq -456 -> 71
    //   530: getstatic 544	mye:TAG	Ljava/lang/String;
    //   533: iconst_2
    //   534: new 363	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 611
    //   544: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: iload_2
    //   548: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: ldc_w 613
    //   554: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: iload 4
    //   559: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   562: ldc_w 615
    //   565: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_0
    //   569: getfield 10	myf:this$0	Lmye;
    //   572: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   575: getfield 63	mye$b:c	Lmhu;
    //   578: getfield 606	mhu:skipFramesTotalCount	I
    //   581: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   584: ldc_w 617
    //   587: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_0
    //   591: getfield 10	myf:this$0	Lmye;
    //   594: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   597: getfield 63	mye$b:c	Lmhu;
    //   600: getfield 609	mhu:aSu	I
    //   603: invokevirtual 475	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: iconst_0
    //   613: ireturn
    //   614: astore_1
    //   615: iconst_0
    //   616: istore_2
    //   617: iconst_0
    //   618: istore 4
    //   620: goto -168 -> 452
    //   623: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +13 -> 639
    //   629: getstatic 544	mye:TAG	Ljava/lang/String;
    //   632: iconst_2
    //   633: ldc_w 619
    //   636: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: aload_0
    //   640: getfield 10	myf:this$0	Lmye;
    //   643: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   646: ifnull -575 -> 71
    //   649: aload_0
    //   650: getfield 10	myf:this$0	Lmye;
    //   653: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   656: getfield 63	mye$b:c	Lmhu;
    //   659: ifnull -588 -> 71
    //   662: aload_0
    //   663: getfield 10	myf:this$0	Lmye;
    //   666: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   669: getfield 63	mye$b:c	Lmhu;
    //   672: iconst_1
    //   673: putfield 622	mhu:amE	Z
    //   676: aload_3
    //   677: instanceof 592
    //   680: ifeq -609 -> 71
    //   683: aload_0
    //   684: getfield 10	myf:this$0	Lmye;
    //   687: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   690: getfield 63	mye$b:c	Lmhu;
    //   693: aload_3
    //   694: checkcast 592	java/lang/String
    //   697: putfield 625	mhu:ahy	Ljava/lang/String;
    //   700: iconst_0
    //   701: ireturn
    //   702: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq +13 -> 718
    //   708: getstatic 544	mye:TAG	Ljava/lang/String;
    //   711: iconst_2
    //   712: ldc_w 627
    //   715: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload_0
    //   719: getfield 10	myf:this$0	Lmye;
    //   722: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   725: ifnull -654 -> 71
    //   728: aload_0
    //   729: getfield 10	myf:this$0	Lmye;
    //   732: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   735: getfield 63	mye$b:c	Lmhu;
    //   738: ifnull -667 -> 71
    //   741: aload_0
    //   742: getfield 10	myf:this$0	Lmye;
    //   745: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   748: getfield 63	mye$b:c	Lmhu;
    //   751: iconst_1
    //   752: putfield 630	mhu:amF	Z
    //   755: iconst_0
    //   756: ireturn
    //   757: aload_3
    //   758: ifnull -687 -> 71
    //   761: aload_3
    //   762: checkcast 592	java/lang/String
    //   765: ldc_w 632
    //   768: iconst_2
    //   769: invokevirtual 636	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   772: astore_1
    //   773: aload_1
    //   774: ifnull -703 -> 71
    //   777: aload_1
    //   778: arraylength
    //   779: iconst_2
    //   780: if_icmpne -709 -> 71
    //   783: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq +60 -> 846
    //   789: ldc_w 638
    //   792: iconst_2
    //   793: new 363	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 640
    //   803: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_0
    //   807: getfield 10	myf:this$0	Lmye;
    //   810: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   813: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   816: ldc_w 642
    //   819: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload_1
    //   823: iconst_0
    //   824: aaload
    //   825: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: ldc_w 644
    //   831: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload_1
    //   835: iconst_1
    //   836: aaload
    //   837: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: ldc_w 646
    //   849: aload_1
    //   850: iconst_0
    //   851: aaload
    //   852: invokevirtual 649	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   855: ifeq -784 -> 71
    //   858: aload_0
    //   859: getfield 10	myf:this$0	Lmye;
    //   862: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   865: ifnull -794 -> 71
    //   868: aload_0
    //   869: getfield 10	myf:this$0	Lmye;
    //   872: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   875: getfield 63	mye$b:c	Lmhu;
    //   878: ifnull -807 -> 71
    //   881: aload_0
    //   882: getfield 10	myf:this$0	Lmye;
    //   885: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   888: getfield 63	mye$b:c	Lmhu;
    //   891: aload_1
    //   892: iconst_1
    //   893: aaload
    //   894: putfield 652	mhu:ahC	Ljava/lang/String;
    //   897: iconst_0
    //   898: ireturn
    //   899: aload_0
    //   900: getfield 10	myf:this$0	Lmye;
    //   903: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   906: ifnull -835 -> 71
    //   909: aload_0
    //   910: getfield 10	myf:this$0	Lmye;
    //   913: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   916: getfield 63	mye$b:c	Lmhu;
    //   919: ifnull -848 -> 71
    //   922: getstatic 657	mrs:a	Lmrs$a;
    //   925: aload_3
    //   926: aload_0
    //   927: getfield 10	myf:this$0	Lmye;
    //   930: invokestatic 49	mye:a	(Lmye;)Lmye$b;
    //   933: getfield 63	mye$b:c	Lmhu;
    //   936: invokevirtual 662	mrs$a:a	(Ljava/lang/Object;Lmhu;)V
    //   939: iconst_0
    //   940: ireturn
    //   941: astore_1
    //   942: goto -325 -> 617
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	945	0	this	myf
    //   0	945	1	parammyi	myi
    //   0	945	2	paramInt	int
    //   0	945	3	paramObject	Object
    //   450	169	4	i	int
    // Exception table:
    //   from	to	target	type
    //   421	442	614	java/lang/Exception
    //   442	452	941	java/lang/Exception
  }
  
  public void b(myi parammyi)
  {
    if (QLog.isColorLevel()) {
      QLog.d(mye.TAG, 2, "onSeekComplete(): video seek complete ! curPlayState:" + myh.bA(this.this$0.qc()));
    }
    if ((parammyi == mye.a(this.this$0)) && (this.this$0.qc() != 5)) {
      mye.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myf
 * JD-Core Version:    0.7.0.1
 */