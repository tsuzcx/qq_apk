package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import aacm;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.FileUtil;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class g
{
  public static final String a = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/miniapp/";
  private static volatile g b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public static g a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new g();
      }
      return b;
    }
    finally {}
  }
  
  public static String a(ApkgConfig paramApkgConfig)
  {
    if ((paramApkgConfig == null) || (TextUtils.isEmpty(paramApkgConfig.mini_appid))) {
      return "";
    }
    if (paramApkgConfig.getRuntimeType() == 1) {
      return a + paramApkgConfig.mini_appid + "_debug" + MD5.toMD5(paramApkgConfig.qq_qr_code);
    }
    return a + MD5.toMD5(paramApkgConfig.mini_appid) + "_" + paramApkgConfig.mini_version;
  }
  
  public static String a(File paramFile, String paramString)
  {
    return QWalletHelper.desDecrypt(c.a(paramFile), paramString, paramString);
  }
  
  private void a(MiniAppConfig paramMiniAppConfig, c paramc)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {}
    String str;
    Object localObject;
    label203:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = paramMiniAppConfig.config.apkg_url;
            long l = paramMiniAppConfig.config.mini_version;
            if (QLog.isColorLevel()) {
              QLog.d("ApkgManager", 2, "getApkgInfoByConfig version:" + l);
            }
            if (l != -1L) {
              break label203;
            }
            str = a(paramMiniAppConfig.config);
            if (!new File(str).exists()) {
              break;
            }
            paramMiniAppConfig = f.a(str, paramMiniAppConfig);
          } while (paramc == null);
          paramc.a(paramMiniAppConfig);
          return;
          localObject = c.a(paramMiniAppConfig.config.mini_appid + ".wxapkg");
          boolean bool = false;
          if (localObject != null)
          {
            bool = c.a(((File)localObject).getAbsolutePath(), str);
            FileUtil.delete((File)localObject);
          }
          if (!bool) {
            break;
          }
          paramMiniAppConfig = f.a(str, paramMiniAppConfig);
        } while (paramc == null);
        paramc.a(paramMiniAppConfig);
        return;
      } while (paramc == null);
      paramc.a(null);
      return;
      localObject = a(paramMiniAppConfig.config);
      if (!new File((String)localObject).exists()) {
        break;
      }
      paramMiniAppConfig = f.a((String)localObject, paramMiniAppConfig);
    } while (paramc == null);
    paramc.a(paramMiniAppConfig);
    return;
    aacm localaacm = aacm.a(BaseApplicationImpl.getApplication().getRuntime());
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.headers = new LinkedList();
    localDownloadParam.url = (str + "?sign=" + URLEncoder.encode(paramMiniAppConfig.config.cos_sign));
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "begin download apkg:" + localDownloadParam);
    }
    localaacm.a(localDownloadParam, new l(this, (String)localObject, paramMiniAppConfig, paramc));
  }
  
  private void a(d paramd, int paramInt, f paramf, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "onInitApkgInfo :" + paramInt + "|" + paramString);
    }
    if (paramd != null) {
      paramd.onInitApkgInfo(paramInt, paramf);
    }
  }
  
  private void b(MiniAppConfig paramMiniAppConfig, d paramd)
  {
    a(paramMiniAppConfig, new k(this, paramd, System.currentTimeMillis()));
  }
  
  public void a(MiniAppConfig paramMiniAppConfig, d paramd)
  {
    if (!f())
    {
      b localb = new b();
      h localh = new h(this, 1, paramMiniAppConfig);
      paramMiniAppConfig = new j(this, 2, paramMiniAppConfig);
      localb.a(localh);
      localb.a(paramMiniAppConfig);
      localb.a(paramd);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "initApkgByConfig - base lib is ready");
    }
    b(paramMiniAppConfig, paramd);
  }
  
  public void a(f paramf, String paramString, d paramd)
  {
    String str2 = paramf.d(paramString);
    String str1 = "";
    if (paramf.f.config.sub_apkg_urls != null) {
      str1 = (String)paramf.f.config.sub_apkg_urls.get(str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 1, "downloadSubPack | downPage=" + paramString + "subPackDownloadUrl=" + str1);
    }
    if (!TextUtils.isEmpty(str1))
    {
      aacm.a(BaseApplicationImpl.getApplication().getRuntime()).c(str1, new m(this, paramf, str2, paramd));
      return;
    }
    paramd.onInitApkgInfo(1, null);
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    if (this.f == null) {
      this.f = c.a(BaseApplicationImpl.getApplication(), "qvip_pay_miniapp_page_frame.html");
    }
    return this.f;
  }
  
  public boolean f()
  {
    return (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.e));
  }
  
  public static abstract class a
  {
    public int c;
    
    a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public abstract void a(g.d paramd);
  }
  
  public static final class b
  {
    int a = 0;
    boolean b = false;
    boolean c = false;
    byte[] d = new byte[0];
    List e = new LinkedList();
    int f = 1;
    int g = 1;
    f h = null;
    private g.d i;
    
    private void a(int paramInt)
    {
      int j = 0;
      for (;;)
      {
        synchronized (this.d)
        {
          if (this.c) {
            return;
          }
          this.a |= paramInt;
          if (this.a == 3) {
            break label111;
          }
          if (this.b)
          {
            break label111;
            if (paramInt != 0) {
              this.c = true;
            }
            if (paramInt == 0) {
              break label110;
            }
            if ((this.g == 0) && (this.f == 0))
            {
              paramInt = j;
              this.i.onInitApkgInfo(paramInt, this.h);
            }
          }
          else
          {
            paramInt = 0;
          }
        }
        paramInt = 1;
        continue;
        label110:
        return;
        label111:
        paramInt = 1;
      }
    }
    
    public void a(g.a parama)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        g.a locala = (g.a)localIterator.next();
        if (parama.c == locala.c) {
          return;
        }
      }
      this.e.add(parama);
    }
    
    public void a(g.d paramd)
    {
      if (paramd == null) {}
      for (;;)
      {
        return;
        this.i = paramd;
        if (this.e.size() == 0)
        {
          this.i.onInitApkgInfo(1, null);
          return;
        }
        paramd = this.e.iterator();
        while (paramd.hasNext()) {
          ThreadManager.excute(new n(this, (g.a)paramd.next()), 16, null, false);
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(f paramf);
  }
  
  public static abstract interface d
  {
    public abstract void onInitApkgInfo(int paramInt, f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.g
 * JD-Core Version:    0.7.0.1
 */