package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anot;
import aqhu;
import aqmj;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mfk;
import mfo;
import mfs;
import mgh;
import npy;
import nqc;
import son;

public class ReadInJoySkinAnimManager
  extends npy
{
  private b a;
  private int aRd;
  private String ant;
  private String anu;
  private String anv;
  private boolean atP;
  private volatile boolean atQ;
  private boolean atR;
  private boolean atS;
  private boolean atT = true;
  private boolean atU;
  private boolean atV;
  private boolean atW;
  private SoundPool b;
  private int baV = -2;
  private int baW = -2;
  private int baX;
  private int baY;
  private int baZ;
  private int bba = 1;
  private int bbb = -1;
  private Runnable cZ = new ReadInJoySkinAnimManager.2(this);
  private List<String> kA;
  private ArrayList<a> lN;
  private ArrayList<a> lO;
  private Context mContext;
  private int mDisplayHeight = -2;
  private int mDisplayWidth = -2;
  private boolean mIsRefreshing;
  private int mSampleSize = -2;
  private SoundPool mSoundPool;
  
  public ReadInJoySkinAnimManager(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$b = new b(this);
    boolean bool;
    mfo localmfo;
    if ((float)Runtime.getRuntime().maxMemory() <= 1.415578E+008F)
    {
      bool = true;
      this.atW = bool;
      if ((paramContext instanceof BaseActivity))
      {
        localmfo = (mfo)((BaseActivity)paramContext).app.getManager(270);
        if ((localmfo.oH() != 1) || (!localmfo.Dz())) {
          break label279;
        }
        this.kA = mgh.aY();
        this.aRd = mgh.oH();
        this.ant = mgh.jI();
        this.anu = localmfo.jL();
        this.anv = mgh.jJ();
        this.bbb = 1;
        label179:
        if (this.mDisplayHeight == -2)
        {
          this.mDisplayHeight = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getHeight() * 0.24F));
          if (this.aRd != 1) {
            break label338;
          }
          this.mDisplayWidth = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth() * 0.53F));
        }
      }
    }
    for (;;)
    {
      if (this.bba == 1)
      {
        this.bba = 2;
        ThreadManager.post(new InitResourceRunnable(this, true), 8, null, true);
      }
      return;
      bool = false;
      break;
      label279:
      this.kA = mfk.aY();
      this.aRd = mfk.oH();
      this.ant = mfk.jI();
      this.anu = ((mfs)((BaseActivity)paramContext).app.getManager(261)).jM();
      this.anv = mfk.jJ();
      this.bbb = 2;
      break label179;
      label338:
      if (this.aRd == 2)
      {
        if (localmfo.Dy()) {
          this.mDisplayWidth = ((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
        } else {
          this.mDisplayWidth = ((int)(((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth() * 1.0F));
        }
      }
      else if (this.aRd == 3) {
        this.mDisplayWidth = ((BaseActivity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      }
    }
  }
  
  private void H(Drawable paramDrawable)
  {
    SkinPullRefreshHeader localSkinPullRefreshHeader = (SkinPullRefreshHeader)this.jdField_a_of_type_Son;
    if (!this.atP) {}
    for (boolean bool = true;; bool = false)
    {
      localSkinPullRefreshHeader.a(paramDrawable, bool);
      return;
    }
  }
  
  private int X(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 > 0)
    {
      i = (int)Math.floor(7340032.0F / paramInt2);
      if (paramInt1 <= i) {}
    }
    for (paramInt1 = (int)Math.ceil(paramInt1 / i);; paramInt1 = 1)
    {
      i = paramInt1;
      if (paramInt1 <= 0)
      {
        QLog.e("ReadInJoySkinAnimManager", 1, "getSamplingRate invalid samplingRate. Here simpleBitmapSize = " + paramInt2 + " samplingRate = " + paramInt1);
        i = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "getSamplingRate simpleBitmapSize = " + paramInt2 + " samplingRate = " + i);
      }
      return i;
    }
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 <= 0) {
      return 1;
    }
    int j = paramOptions.outWidth;
    if (j > paramInt1)
    {
      int i = 2;
      int k = j / 2;
      for (;;)
      {
        j = i;
        if (k / i < paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    j = 1;
    double d = Math.sqrt(1.0D * (paramInt2 * paramInt3) / 10485760.0D);
    while (j < d) {
      j *= 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "calculateInSampleSize inSampleSize = " + j);
    }
    return j;
  }
  
  private Drawable a(String paramString1, String paramString2, String paramString3, Resources paramResources, int paramInt1, int paramInt2)
  {
    paramString2 = new StringBuilder(paramString1).append(paramString2).append("/").append(paramString3);
    if (new File(paramString2.toString()).exists())
    {
      paramString3 = new BitmapFactory.Options();
      if ((this.mSampleSize == -2) && (this.mDisplayWidth != -2))
      {
        paramString3.inJustDecodeBounds = true;
        aqhu.d(paramString2.toString(), paramString3);
        if (this.aRd == 1) {
          this.mSampleSize = a(paramString3, this.mDisplayWidth, paramInt1, paramInt2);
        }
      }
      else
      {
        if (this.mSampleSize != -2)
        {
          paramString3.inSampleSize = this.mSampleSize;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoySkinAnimManager", 1, "mSampleSize = " + this.mSampleSize);
          }
        }
        paramString3.inJustDecodeBounds = false;
        paramString3.inPreferredConfig = Bitmap.Config.ARGB_4444;
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = aqhu.d(paramString2.toString(), paramString3);
        paramString1 = paramString2;
        if (paramString1 == null) {
          break label334;
        }
        return new BitmapDrawable(paramResources, paramString1);
      }
      catch (OutOfMemoryError paramString2)
      {
        anot.a(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_oom", paramString3.inSampleSize, paramInt1, this.anu, String.valueOf(paramString3.outHeight), String.valueOf(paramString3.outWidth), null);
        QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable oom = " + paramString2 + " resFolderPath:" + paramString1);
        return null;
      }
      if (this.aRd == 2)
      {
        this.mSampleSize = a(paramString3, this.mDisplayWidth, paramInt1, paramInt2);
        break;
      }
      if (this.aRd != 3) {
        break;
      }
      this.mSampleSize = a(paramString3, this.mDisplayWidth, paramInt1, paramInt2);
      break;
      label334:
      QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable bitmap = null");
      return null;
      paramString1 = null;
    }
  }
  
  private SoundPool a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      SoundPool.Builder localBuilder = new SoundPool.Builder();
      localBuilder.setMaxStreams(1);
      localBuilder.setAudioAttributes(new AudioAttributes.Builder().build());
      return localBuilder.build();
    }
    return new SoundPool(1, 3, 0);
  }
  
  private int aP(String paramString)
  {
    int i = 0;
    paramString = new StringBuilder(this.ant).append("refreshAnimatePictures").append("/").append(paramString);
    BitmapFactory.Options localOptions;
    if (new File(paramString.toString()).exists())
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
    }
    try
    {
      paramString = aqhu.d(paramString.toString(), localOptions);
      int j = getBitmapSize(paramString);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoySkinAnimManager", 1, "getSamplingRate simpleBitmapSize = " + j);
        i = j;
      }
      return i;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable oom = " + paramString);
    }
    return 0;
  }
  
  private int aQ(String paramString)
  {
    String str = paramString.substring(0, paramString.length() - 4);
    if (str != null) {
      try
      {
        int i = Integer.parseInt(str);
        if ((i >= 0) && (i <= 100)) {
          return i;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("ReadInJoySkinAnimManager", 1, "getPNGIndex NumberFormatException pngName = " + paramString);
      }
    }
    return -2;
  }
  
  private void baa()
  {
    if (this.jdField_a_of_type_Son != null)
    {
      ((SkinPullRefreshHeader)this.jdField_a_of_type_Son).removeCallbacks(this.cZ);
      this.atU = false;
    }
  }
  
  private void bab()
  {
    if (this.lN == null)
    {
      this.lN = this.lO;
      if ((this.lN.size() > 0) && (this.jdField_a_of_type_Son != null))
      {
        if (!this.mIsRefreshing) {
          break label98;
        }
        H(((a)this.lN.get(0)).drawable);
        ((SkinPullRefreshHeader)this.jdField_a_of_type_Son).removeCallbacks(this.cZ);
        ((SkinPullRefreshHeader)this.jdField_a_of_type_Son).post(this.cZ);
      }
    }
    for (;;)
    {
      this.lO = null;
      this.bba = 3;
      return;
      label98:
      H(((a)this.lN.get(0)).drawable);
      continue;
      QLog.e("ReadInJoySkinAnimManager", 1, "setPngArray mRefreshPullDownPNGS.size = " + this.lN.size());
    }
  }
  
  private void bac()
  {
    if (this.mSoundPool == null) {
      this.mSoundPool = this.jdField_b_of_type_AndroidMediaSoundPool;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidMediaSoundPool = null;
      String str = this.anv;
      if ((str != null) && (new File(str).exists()) && (this.mSoundPool != null))
      {
        this.baX = this.mSoundPool.load(str, 0);
        long l = System.currentTimeMillis();
        this.mSoundPool.setOnLoadCompleteListener(new nqc(this, l));
      }
      return;
      QLog.e("ReadInJoySkinAnimManager", 1, "setSoundPool mRefreshPullDownPNGS.size != null");
    }
  }
  
  private void bad()
  {
    float f2 = 0.5F;
    AudioManager localAudioManager = (AudioManager)this.mContext.getSystemService("audio");
    float f1 = f2;
    if (localAudioManager != null)
    {
      float f3 = localAudioManager.getStreamVolume(3);
      i = localAudioManager.getStreamMaxVolume(3);
      f1 = f2;
      if (i != 0) {
        f1 = f3 / i;
      }
    }
    if (localAudioManager != null) {}
    for (int i = localAudioManager.getRingerMode();; i = 2)
    {
      if (i == 2) {
        this.baY = this.mSoundPool.play(this.baX, f1, f1, 0, 0, 1.0F);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "playSound volume = " + f1 + " RINGER_MODE_NORMAL = " + 2);
      }
      return;
    }
  }
  
  private int getBitmapSize(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private void pZ(boolean paramBoolean)
  {
    List localList = this.kA;
    if ((localList == null) || (localList.size() <= 0)) {
      return;
    }
    Object localObject;
    int k;
    if (paramBoolean)
    {
      if (this.anv == null) {
        break label283;
      }
      localObject = a();
      if (localObject != null)
      {
        this.jdField_b_of_type_AndroidMediaSoundPool = ((SoundPool)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$b.sendEmptyMessage(2);
      }
    }
    else
    {
      k = aP((String)localList.get(0));
      if ((!this.atW) || ((this.aRd != 1) && (this.aRd != 3))) {
        break label579;
      }
    }
    label283:
    label579:
    for (int j = X(localList.size(), k);; j = 1)
    {
      localObject = new ArrayList();
      if ((this.aRd == 1) || (this.aRd == 2) || (this.aRd == 3)) {
        anot.a(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_times", 0, 0, this.anu, null, null, null);
      }
      String str2;
      Drawable localDrawable;
      if ((this.aRd == 1) || (this.aRd == 3))
      {
        localResources = BaseApplicationImpl.getContext().getResources();
        str1 = this.ant;
        int m = localList.size();
        int i = 0;
        localIterator = localList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label367;
          }
          str2 = (String)localIterator.next();
          i += 1;
          if ((i % j != 0) && (i != m))
          {
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInJoySkinAnimManager", 1, "init soundpool failed");
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInJoySkinAnimManager", 1, "voicePath = null");
            break;
          }
          int n = aQ(str2);
          localDrawable = a(str1, "refreshAnimatePictures", str2, localResources, localList.size(), k);
          if ((n != -2) && (localDrawable != null)) {
            ((ArrayList)localObject).add(new a(str2, n, localDrawable));
          }
        }
        label367:
        Collections.sort((List)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "initResources size = " + ((ArrayList)localObject).size());
        }
        this.lO = ((ArrayList)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$b.sendEmptyMessage(1);
        return;
      }
      if (this.aRd != 2) {
        break;
      }
      Resources localResources = BaseApplicationImpl.getContext().getResources();
      String str1 = this.ant;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        localDrawable = a(str1, "refreshRandomPictures", str2, localResources, localList.size(), k);
        if (localDrawable != null) {
          ((ArrayList)localObject).add(new a(str2, 0, localDrawable));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinAnimManager", 1, "initResources size = " + ((ArrayList)localObject).size());
      }
      this.lO = ((ArrayList)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoySkinAnimManager$b.sendEmptyMessage(1);
      return;
    }
  }
  
  private void tR(int paramInt)
  {
    if (this.lN != null) {}
    for (int j = this.lN.size();; j = 0)
    {
      if ((j > 0) && (this.aRd == 1)) {
        if (paramInt >= this.mDisplayHeight) {
          paramInt = 100;
        }
      }
      for (;;)
      {
        if (paramInt == 100) {
          if (this.baV != j - 1)
          {
            this.baV = (j - 1);
            H(((a)this.lN.get(this.baV)).drawable);
          }
        }
        label342:
        for (;;)
        {
          return;
          if ((paramInt >= this.mDisplayHeight) || (paramInt <= 0) || (this.mDisplayHeight == 0)) {
            break label344;
          }
          paramInt = paramInt * 100 / this.mDisplayHeight;
          break;
          int i = 0;
          label117:
          if (i < j) {
            if (((a)this.lN.get(i)).bbc < paramInt) {}
          }
          for (;;)
          {
            if (i == this.baV) {
              break label342;
            }
            this.baV = i;
            H(((a)this.lN.get(i)).drawable);
            return;
            i += 1;
            break label117;
            if ((j > 0) && (this.aRd == 2))
            {
              if (this.baV == -2)
              {
                this.baV = ((int)Math.floor(Math.random() * j));
                this.baW = this.baV;
                H(((a)this.lN.get(this.baV)).drawable);
              }
              if (this.baV == this.baW) {
                break;
              }
              this.baV = this.baW;
              H(((a)this.lN.get(this.baV)).drawable);
              return;
            }
            if ((j <= 0) || (this.aRd != 3) || (this.atU)) {
              break;
            }
            this.atU = true;
            ((SkinPullRefreshHeader)this.jdField_a_of_type_Son).removeCallbacks(this.cZ);
            ((SkinPullRefreshHeader)this.jdField_a_of_type_Son).post(this.cZ);
            return;
            i = 0;
          }
        }
        label344:
        paramInt = 0;
      }
    }
  }
  
  private void tS(int paramInt)
  {
    boolean bool;
    if (this.atQ)
    {
      if ((paramInt < this.baZ) || (this.atR)) {
        break label99;
      }
      bool = true;
      this.atS = bool;
      if (this.atS)
      {
        AppInterface localAppInterface = ((BaseActivity)this.mContext).getAppInterface();
        if ((localAppInterface != null) && (((aqmj.aJ(this.mContext, localAppInterface.getCurrentAccountUin())) && (this.bbb == 2)) || (this.bbb == 1))) {
          bad();
        }
      }
      if (paramInt < this.baZ) {
        break label104;
      }
      this.atR = true;
    }
    label99:
    label104:
    while (paramInt >= this.baZ)
    {
      return;
      bool = false;
      break;
    }
    this.atR = false;
  }
  
  public boolean FE()
  {
    if ((this.atV) && (!this.mIsRefreshing)) {
      baa();
    }
    this.atT = true;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.FF()) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.FE()))
    {
      if (this.aRd == 3) {
        baa();
      }
      return true;
    }
    return false;
  }
  
  public void aCB()
  {
    super.aCB();
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.FF())) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.aCB();
    }
    this.mIsRefreshing = false;
    if (!this.atV) {
      baa();
    }
  }
  
  public void aWg()
  {
    if (this.mSoundPool != null) {
      this.mSoundPool.stop(this.baY);
    }
    baa();
    if ((this.lN != null) && (!this.lN.isEmpty())) {
      this.lN.clear();
    }
    this.lN = null;
    if (this.bba == 3) {
      this.bba = 1;
    }
  }
  
  public void aWh()
  {
    if (this.bba == 1)
    {
      this.bba = 2;
      ThreadManager.post(new InitResourceRunnable(this, false), 8, null, true);
    }
  }
  
  public void aXf()
  {
    if (this.jdField_a_of_type_Son == null) {
      return;
    }
    this.jdField_a_of_type_Son.S(0L);
    if ((this.jdField_a_of_type_Son instanceof SkinPullRefreshHeader)) {
      ((SkinPullRefreshHeader)this.jdField_a_of_type_Son).B(false, "");
    }
    this.jdField_a_of_type_Son.pn();
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.FF())) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_Son);
    }
    if (this.lN != null) {}
    for (int j = this.lN.size();; j = 0)
    {
      int i;
      if ((j > 0) && (this.aRd == 1))
      {
        int k = this.baZ * 100 / this.mDisplayHeight;
        i = 0;
        if (i >= j) {
          break label291;
        }
        if (((a)this.lN.get(i)).bbc < k) {}
      }
      for (;;)
      {
        this.baV = i;
        H(((a)this.lN.get(i)).drawable);
        for (;;)
        {
          this.atR = false;
          return;
          i += 1;
          break;
          if ((j > 0) && (this.aRd == 2))
          {
            this.baV = ((int)Math.floor(Math.random() * j));
            this.baW = this.baV;
            H(((a)this.lN.get(this.baV)).drawable);
          }
          else if ((j > 0) && (this.aRd == 3))
          {
            this.baV = 0;
            ((SkinPullRefreshHeader)this.jdField_a_of_type_Son).removeCallbacks(this.cZ);
            ((SkinPullRefreshHeader)this.jdField_a_of_type_Son).post(this.cZ);
          }
        }
        label291:
        i = 0;
      }
    }
  }
  
  public void aZZ()
  {
    baa();
    super.aZZ();
  }
  
  public void ag(int paramInt, boolean paramBoolean)
  {
    super.ag(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Son == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Son.pn();
      return;
    }
    this.jdField_a_of_type_Son.Q(0L);
  }
  
  public void c(SlideActiveAnimController paramSlideActiveAnimController)
  {
    super.c(paramSlideActiveAnimController);
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.FF())) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.k(this.anu, mgh.jN(), 261);
    }
  }
  
  public View d(ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    Object localObject1;
    AbsListView.LayoutParams localLayoutParams;
    int i;
    if (this.jdField_a_of_type_Son == null)
    {
      this.jdField_a_of_type_Son = ((SkinPullRefreshHeader)LayoutInflater.from(this.mContext).inflate(2131563086, paramViewGroup, false));
      if (((this.jdField_a_of_type_Son instanceof RelativeLayout)) && (this.mDisplayHeight > 0))
      {
        localObject1 = (RelativeLayout)this.jdField_a_of_type_Son;
        localLayoutParams = (AbsListView.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        paramViewGroup = null;
        if ((this.aRd != 1) && (this.aRd != 3)) {
          break label507;
        }
        paramViewGroup = "refreshAnimatePictures";
        Object localObject2 = this.kA;
        if ((localObject2 == null) || (((List)localObject2).isEmpty()) || (paramViewGroup == null)) {
          break label551;
        }
        paramViewGroup = new StringBuilder(this.ant).append(paramViewGroup).append("/").append((String)((List)localObject2).get(0));
        if (!new File(paramViewGroup.toString()).exists()) {
          break label551;
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        aqhu.d(paramViewGroup.toString(), (BitmapFactory.Options)localObject2);
        if ((this.mDisplayWidth == -2) || (((BitmapFactory.Options)localObject2).outWidth == 0)) {
          break label546;
        }
        i = ((BitmapFactory.Options)localObject2).outHeight * this.mDisplayWidth / ((BitmapFactory.Options)localObject2).outWidth;
        label227:
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "getRefreshView options.outHeight = " + ((BitmapFactory.Options)localObject2).outHeight + " options.outWidth = " + ((BitmapFactory.Options)localObject2).outWidth);
        }
      }
    }
    label291:
    label551:
    for (int j = i;; j = 0)
    {
      if (j != 0)
      {
        localLayoutParams.height = j;
        ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams);
        if (this.mDisplayWidth != -2)
        {
          paramViewGroup = (ImageView)((RelativeLayout)localObject1).findViewById(2131377039);
          localObject1 = paramViewGroup.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).width = this.mDisplayWidth;
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "getRefreshView sDisplayHeight = " + this.mDisplayHeight + " sDisplayWidth = " + this.mDisplayWidth + " refreshType = " + this.aRd);
        }
        if ((this.mContext instanceof BaseActivity))
        {
          paramViewGroup = (mfo)((BaseActivity)this.mContext).app.getManager(270);
          localObject1 = paramViewGroup.a(this.mContext, 0);
          if ((localObject1 == null) || (!((RefreshData)localObject1).isAD)) {
            break label534;
          }
          bool1 = true;
          label458:
          this.atP = bool1;
          localObject1 = (SkinPullRefreshHeader)this.jdField_a_of_type_Son;
          if ((paramViewGroup.oH() != 1) || (!this.atP)) {
            break label540;
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((SkinPullRefreshHeader)localObject1).setAdTabVisibility(bool1);
        return (View)this.jdField_a_of_type_Son;
        label507:
        if (this.aRd != 2) {
          break;
        }
        paramViewGroup = "refreshRandomPictures";
        break;
        localLayoutParams.height = this.mDisplayHeight;
        break label291;
        bool1 = false;
        break label458;
      }
      i = 0;
      break label227;
    }
  }
  
  public void dn(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Son == null) {}
    do
    {
      return;
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.FF())) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_Son, paramInt1, paramInt2);
      }
      tR(paramInt1);
      tS(paramInt1);
    } while ((!this.atT) || ((this.aRd != 2) && (this.aRd != 1) && (this.aRd != 3)));
    paramInt1 = 0;
    if (this.lN != null) {
      paramInt1 = this.lN.size();
    }
    anot.a(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "refresh_times", this.aRd, paramInt1, this.anu, null, null, null);
    String str = this.anv;
    if ((str != null) && (new File(str).exists()))
    {
      paramInt1 = 1;
      if (this.atQ) {
        paramInt1 = 2;
      }
      anot.a(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "sound_play_times", paramInt1, 0, this.anu, null, null, null);
    }
    this.atT = false;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "resource onDestroy");
    }
    if (this.mSoundPool != null)
    {
      this.mSoundPool.stop(this.baY);
      this.mSoundPool.release();
      this.mSoundPool = null;
    }
    this.atQ = false;
    this.atS = false;
    this.atR = false;
    if ((this.lN != null) && (!this.lN.isEmpty()))
    {
      this.lN.clear();
      this.lN = null;
    }
    this.bba = 1;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.aYk();
    }
    baa();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.atV = this.mIsRefreshing;
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.FF()) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void pY(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Son == null) {
      return;
    }
    this.mIsRefreshing = true;
    this.jdField_a_of_type_Son.S(0L);
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.FF())) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_Son);
    }
    int i = 0;
    if (this.lN != null) {
      i = this.lN.size();
    }
    if (i > 0)
    {
      double d = Math.random();
      this.baW = ((int)Math.floor(i * d));
    }
    super.pY(paramBoolean);
  }
  
  public int qC()
  {
    this.baZ = this.mContext.getResources().getDimensionPixelSize(2131299308);
    return this.baZ;
  }
  
  public void t(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Son == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_Son.K(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Son.tT(0);
      return;
    }
    this.jdField_a_of_type_Son.tT(2);
  }
  
  static class InitResourceRunnable
    implements Runnable
  {
    private boolean atX;
    private WeakReference<ReadInJoySkinAnimManager> cx;
    
    public InitResourceRunnable(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager, boolean paramBoolean)
    {
      this.cx = new WeakReference(paramReadInJoySkinAnimManager);
      this.atX = paramBoolean;
    }
    
    public void run()
    {
      ReadInJoySkinAnimManager localReadInJoySkinAnimManager = (ReadInJoySkinAnimManager)this.cx.get();
      if (localReadInJoySkinAnimManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "InitResourceRunnable folder = " + ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager));
        }
        ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager, this.atX);
      }
    }
  }
  
  public static class a
    implements Comparable<a>
  {
    public String anw;
    public int bbc;
    public Drawable drawable;
    
    a(String paramString, int paramInt, Drawable paramDrawable)
    {
      this.anw = paramString;
      this.bbc = paramInt;
      this.drawable = paramDrawable;
    }
    
    public int a(a parama)
    {
      if (this.bbc < parama.bbc) {
        return -1;
      }
      if (this.bbc > parama.bbc) {
        return 1;
      }
      return 0;
    }
  }
  
  static class b
    extends Handler
  {
    private WeakReference<ReadInJoySkinAnimManager> cx;
    
    public b(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager)
    {
      this.cx = new WeakReference(paramReadInJoySkinAnimManager);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ReadInJoySkinAnimManager localReadInJoySkinAnimManager = (ReadInJoySkinAnimManager)this.cx.get();
      if (localReadInJoySkinAnimManager == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager);
        return;
      }
      ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager
 * JD-Core Version:    0.7.0.1
 */