package com.tencent.mobileqq.startup.step;

import aadg;
import abtn;
import abxs;
import acbn;
import acfi.a;
import aecy;
import afpf;
import ahyv;
import ahze;
import ahzs;
import aiio;
import alts;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import anmy;
import anmz;
import aohh;
import aoix;
import aoiy;
import aojb;
import aojf;
import aoke;
import aokf;
import aokg;
import aokh;
import aoki;
import aokj;
import aokk;
import aokm;
import aokn;
import aolf;
import aolr;
import aols;
import aolx;
import aoly;
import aomc;
import aoml;
import aomm;
import aomo;
import aomv;
import aomw;
import aomx;
import aomz;
import aonm;
import aons;
import aony;
import aooe;
import aoof;
import aoor;
import aoos;
import aoot;
import aqqv;
import aqul;
import avtq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.JpegExifReader;
import com.tencent.image.JpegExifReader.JpegExifReaderInterface;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.a;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.dinifly.DiniFlyLog;
import com.tencent.mobileqq.dinifly.IDiniFlyQLog;
import com.tencent.mobileqq.theme.effect.QEffectApngImageView;
import com.tencent.mobileqq.theme.effect.QEffectGifImageView;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.VasApngDownloader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.engine.QEffectEngine;
import com.tencent.qq.effect.engine.QEffectEngine.JsonConvert;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mgi;
import oay;
import obs;
import xum;
import yha;

public class InitUrlDrawable
  extends Step
{
  private static List<String> Gz = new CopyOnWriteArrayList();
  private static IDiniFlyQLog a = new anmy();
  public static aokj b;
  public static volatile boolean sInited;
  
  protected boolean doStep()
  {
    if (sInited) {
      return true;
    }
    sInited = true;
    DiniFlyLog.setLog(a);
    QEffectEngine.getInstance().setJsonConvert(new b());
    QEffectEngine.getInstance().registerLoad(new aohh());
    QEffectEngine.getInstance().registerEffect(2, "a.png", QEffectApngImageView.class);
    QEffectEngine.getInstance().registerEffect(3, "lottie", QEffectLottieImageView.class);
    QEffectEngine.getInstance().registerEffect(8, "gif", QEffectGifImageView.class);
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    URLDrawable.DEBUG = false;
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localFile = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH));
    }
    try
    {
      for (;;)
      {
        URLDrawable.init(localBaseApplicationImpl, new c(localBaseApplicationImpl));
        localFile = new File(localFile, "diskcache");
        b = new aokj(localFile);
        aoop.aW = localFile;
        JpegExifReader.initJpegExifReader(new a());
        return true;
        localFile = localBaseApplicationImpl.getCacheDir();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AutoMonitor", 1, "", localThrowable);
      }
    }
  }
  
  static class a
    implements JpegExifReader.JpegExifReaderInterface
  {
    public void doReport(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3) {}
    
    public boolean readEnableFromDPC()
    {
      try
      {
        Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_gifplay.name(), null);
        if (QLog.isColorLevel()) {
          QLog.d("JpegExifReader", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          if (localObject.length >= 9)
          {
            int i = Integer.parseInt(localObject[8]);
            if (i != 1) {
              break label81;
            }
          }
        }
      }
      catch (Exception localException)
      {
        label81:
        while (!QLog.isColorLevel()) {}
        QLog.e("JpegExifReader", 2, "read dpc", localException);
      }
      return true;
      return false;
      return true;
    }
  }
  
  public static class b
    implements QEffectEngine.JsonConvert
  {
    public <T> T parseArray(String paramString, Class paramClass)
    {
      return aiio.convertFromJSONArray(paramString, new anmz(this).getClass().getGenericSuperclass());
    }
    
    public <T> T parseObject(String paramString, Class paramClass)
    {
      return aiio.convertFromJSONObject(paramString, paramClass);
    }
  }
  
  static class c
    extends URLDrawableParams
  {
    private aoiy jdField_a_of_type_Aoiy;
    private ProtocolDownloader jdField_a_of_type_ComTencentImageProtocolDownloader;
    private ProtocolDownloader b;
    private ProtocolDownloader c;
    private ProtocolDownloader d;
    private ProtocolDownloader e;
    private ProtocolDownloader f;
    private ProtocolDownloader g;
    private ProtocolDownloader h;
    private ProtocolDownloader i;
    private ProtocolDownloader j;
    
    public c(Application paramApplication)
    {
      super();
      this.mFadeInImage = false;
      this.mUseGifAnimation = false;
      this.mMemoryCache = BaseApplicationImpl.sImageCache;
    }
    
    public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
    {
      boolean bool = true;
      if (("http".equals(paramString)) || ("https".equals(paramString)))
      {
        if (this.jdField_a_of_type_ComTencentImageProtocolDownloader == null) {
          if (BaseApplicationImpl.sProcessId != 1) {
            break label52;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentImageProtocolDownloader = new aolf(bool, paramObject);
          return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
          label52:
          bool = false;
        }
      }
      if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
      {
        if (this.f == null) {
          this.f = new aomc();
        }
        return this.f;
      }
      if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
      {
        if (this.b == null) {
          this.b = new aokf(BaseApplicationImpl.getApplication());
        }
        return this.b;
      }
      if (("lbsthumb".equals(paramString)) || ("lbsimg".equals(paramString)))
      {
        if (this.c == null) {
          this.c = new aolr(BaseApplicationImpl.getApplication());
        }
        return this.c;
      }
      if ("datalineimage".equals(paramString)) {
        return new aokg(BaseApplicationImpl.getApplication());
      }
      if ("datalineface".equals(paramString)) {
        return new aokh(BaseApplicationImpl.getApplication());
      }
      if ("emotion".equals(paramString)) {
        return new aokk(BaseApplicationImpl.getApplication());
      }
      if ("emotion_pic".equals(paramString)) {
        return new aoml(BaseApplicationImpl.getApplication());
      }
      if ("favorite".equals(paramString)) {
        return new afpf();
      }
      if ("albumthumb".equals(paramString)) {
        return new AlbumThumbDownloader();
      }
      if ("videothumb".equals(paramString)) {
        return new aoot();
      }
      if ("videocover".equals(paramString)) {
        return new aoos();
      }
      if ("pubaccountimage".equals(paramString)) {
        return new obs(BaseApplicationImpl.getApplication());
      }
      if ("location".equals(paramString)) {
        return new aoly(BaseApplicationImpl.getApplication());
      }
      if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
      {
        if (this.d == null) {
          this.d = new aolx(BaseApplicationImpl.getApplication());
        }
        return this.d;
      }
      if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
      {
        if (this.e == null) {
          this.e = new aomo();
        }
        return this.e;
      }
      if ("qzone_cover".equals(paramString)) {
        return new aomw();
      }
      if ("favimage".equals(paramString)) {
        return new aokm(BaseApplicationImpl.getApplication());
      }
      if ("fileassistantimage".equals(paramString)) {
        return new aokn(BaseApplicationImpl.getApplication());
      }
      if ("filegalleryorigimage".equals(paramString)) {
        return new aomm(BaseApplicationImpl.getApplication());
      }
      if ("troop_photo_qzone".equals(paramString)) {
        return new aomx();
      }
      if ("aiothumb".equals(paramString))
      {
        if (this.jdField_a_of_type_Aoiy == null) {
          this.jdField_a_of_type_Aoiy = new aoiy(BaseApplicationImpl.getApplication());
        }
        return this.jdField_a_of_type_Aoiy;
      }
      if ("protocol_pendant_image".equals(paramString)) {
        return new aojf();
      }
      if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
        return new xum(BaseApplicationImpl.getApplication());
      }
      if ("regionalthumb".equals(paramString)) {
        return new aomz(BaseApplicationImpl.getApplication());
      }
      if ("third_part".equals(paramString)) {
        return new aoof(BaseApplicationImpl.getApplication());
      }
      if ("gamead".equals(paramString)) {
        return new aols();
      }
      if ("shortvideothumb".equals(paramString)) {
        return new aons();
      }
      if ("shortvideoforpicthumb".equals(paramString)) {
        return new aonm();
      }
      if ("devicemsgthumb".equals(paramString)) {
        return new aoki();
      }
      if ("carrier".equals(paramString)) {
        return new aoke();
      }
      if ("aioflower".equals(paramString)) {
        return new aoix();
      }
      if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
        return new aony();
      }
      if ("themediydownloader".equals(paramString)) {
        return new aooe();
      }
      if ("vasapngdownloader".equals(paramString)) {
        return new VasApngDownloader();
      }
      if ("funny_pic".equals(paramString)) {
        return new acfi.a();
      }
      if ("redtouchpicdownloadprotoc".equals(paramString)) {
        return new alts(BaseApplicationImpl.getApplication());
      }
      if ("protocol_vas_extension_image".equals(paramString)) {
        return new aoor(BaseApplicationImpl.getApplication());
      }
      if ("apollo_pic".equals(paramString)) {
        return new abxs(BaseApplicationImpl.getApplication());
      }
      if ("apollo_gif".equals(paramString)) {
        return new ApolloItemBuilder.a();
      }
      if ("apollo_image".equals(paramString)) {
        return new abtn();
      }
      if ("hot_pic".equals(paramString))
      {
        if (this.g == null) {
          this.g = new ahyv();
        }
        return this.g;
      }
      if ("hot_pic_origin".equals(paramString)) {
        return new ahze();
      }
      if ("hot_video_preview".equals(paramString))
      {
        if (this.h == null) {
          this.h = new ahzs();
        }
        return this.h;
      }
      if ("readinjoy_skin_gif".equals(paramString)) {
        return new mgi();
      }
      if ("pubaccountimage_gifplaytime".equals(paramString)) {
        return new oay(BaseApplicationImpl.getApplication());
      }
      if ("qzonecontentboxdownloader".equals(paramString)) {
        return new avtq();
      }
      if ("qwallet_downloader".equals(paramString)) {
        return new aadg();
      }
      if ("sticker_recommended_pic".equals(paramString))
      {
        if (this.i == null) {
          this.i = new yha();
        }
        return this.i;
      }
      if ("albumthumbpreview".equals(paramString))
      {
        if (this.j == null) {
          this.j = new aojb();
        }
        return this.j;
      }
      if ("webcover".equals(paramString)) {
        return new aecy();
      }
      if ("qqsys_emoji".equals(paramString)) {
        return new aomv();
      }
      return null;
    }
    
    public String doGetLocalFilePath(String paramString)
    {
      return null;
    }
    
    public ApngSoLoader getApngSoLoader()
    {
      return aqqv.a();
    }
    
    public Drawable getDefaultLoadingDrawable()
    {
      try
      {
        Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838155);
        return localDrawable;
      }
      catch (Throwable localThrowable) {}
      return new ColorDrawable(0);
    }
    
    public Drawable getDefualtFailedDrawable()
    {
      try
      {
        Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158);
        return localDrawable;
      }
      catch (Throwable localThrowable) {}
      return new ColorDrawable(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable
 * JD-Core Version:    0.7.0.1
 */