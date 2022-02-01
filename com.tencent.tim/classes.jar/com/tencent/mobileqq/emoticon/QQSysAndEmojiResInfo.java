package com.tencent.mobileqq.emoticon;

import afkv;
import afkw;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class QQSysAndEmojiResInfo
{
  private static JSONObject bw;
  protected afkw a;
  protected Drawable ev;
  protected HashMap<Integer, QQEmoConfigItem> kn;
  protected HashMap<Integer, Integer> ko;
  protected HashMap<String, String> kp;
  protected HashMap<String, Integer> kq;
  protected ArrayList<Integer> wi;
  
  public QQSysAndEmojiResInfo()
  {
    cZW();
  }
  
  public static void HY(String paramString)
  {
    bw = null;
    try
    {
      long l = System.currentTimeMillis();
      paramString = new File(paramString + "face_config.json");
      if (paramString.exists()) {
        paramString = aqhq.readFileContent(paramString);
      }
      while ((paramString != null) && (paramString.length() > 0))
      {
        bw = new JSONObject(paramString);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "getFaceConfigJson len:", Integer.valueOf(bw.length()), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
        return;
        paramString = aqhq.py("face_config.json");
        QLog.d("QQSysAndEmojiBaseInfo", 1, "getFaceConfigJson not exist!");
        ThreadManager.getSubThreadHandler().post(new QQSysAndEmojiResInfo.1());
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public abstract int Da();
  
  public int Dc()
  {
    int i = 0;
    if (this.kn != null) {
      i = this.kn.size();
    }
    return i;
  }
  
  public void MA(int paramInt)
  {
    if (this.a == null) {
      cZX();
    }
    this.a.MB(paramInt);
  }
  
  public JSONObject Z()
  {
    if (bw == null) {
      HY(afkv.ux());
    }
    return bw;
  }
  
  protected Drawable a(URL paramURL, Drawable paramDrawable, boolean paramBoolean, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramDrawable == null) {
      if (this.ev != null) {}
    }
    for (;;)
    {
      try
      {
        this.ev = BaseApplicationImpl.getContext().getResources().getDrawable(2130838105);
        localURLDrawableOptions.mLoadingDrawable = this.ev;
        localURLDrawableOptions.mFailedDrawable = this.ev;
        localURLDrawableOptions.mPlayGifImage = paramBoolean;
        paramURL = b(paramURL, localURLDrawableOptions);
        if ((paramURL != null) && (!TextUtils.isEmpty(paramString))) {
          paramURL.addHeader("emoId", paramString);
        }
        return paramURL;
      }
      catch (Exception paramDrawable)
      {
        this.ev = new ColorDrawable();
        QLog.e("QQSysAndEmojiBaseInfo", 1, "getDrawable exception e: = " + paramDrawable.getMessage());
        continue;
      }
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
    }
  }
  
  public boolean a(QQEmoConfigItem paramQQEmoConfigItem)
  {
    return "1".equals(paramQQEmoConfigItem.QHide);
  }
  
  protected URLDrawable b(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    return URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
  }
  
  public int cM(String paramString)
  {
    if ((this.kq != null) && (this.kq.containsKey(paramString))) {
      return ((Integer)this.kq.get(paramString)).intValue();
    }
    return -1;
  }
  
  public ArrayList<Integer> cV()
  {
    ArrayList localArrayList = null;
    if (this.wi != null)
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(this.wi);
    }
    return localArrayList;
  }
  
  public abstract void cZW();
  
  public abstract void cZX();
  
  public abstract void cZY();
  
  public void cZZ()
  {
    if (this.a != null) {
      this.a.dab();
    }
  }
  
  public abstract String dY(int paramInt);
  
  public abstract Drawable getDrawable(int paramInt);
  
  public abstract void hL(int paramInt1, int paramInt2);
  
  public abstract int hh(int paramInt);
  
  public int hk(int paramInt)
  {
    if ((this.ko != null) && (this.ko.containsKey(Integer.valueOf(paramInt)))) {
      return ((Integer)this.ko.get(Integer.valueOf(paramInt))).intValue();
    }
    return -1;
  }
  
  protected void i(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof URLDrawable))
    {
      paramDrawable = (URLDrawable)paramDrawable;
      if ((paramDrawable.getStatus() == 1) || (paramDrawable.getStatus() == 0)) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "reloadDrawable restartDownload:", Integer.valueOf(paramInt) });
      }
      paramDrawable.addHeader("emoId", Integer.toString(paramInt));
      paramDrawable.restartDownload();
    }
    label71:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "reloadDrawable do nothing:", Integer.valueOf(paramInt) });
  }
  
  public abstract boolean jk(int paramInt);
  
  public boolean jn(int paramInt)
  {
    if (this.kn == null) {
      return false;
    }
    if (this.kn.containsKey(Integer.valueOf(paramInt))) {
      return a((QQEmoConfigItem)this.kn.get(Integer.valueOf(paramInt)));
    }
    return true;
  }
  
  public String kF(String paramString)
  {
    if ((this.kp != null) && (this.kp.containsKey(paramString))) {
      return (String)this.kp.get(paramString);
    }
    return null;
  }
  
  public static class QQEmoConfigItem
  {
    public String AQLid;
    public String EMCode;
    public String QCid;
    public String QDes;
    public String QHide;
    public String QSid;
    public String isCMEmoji;
    public String isStatic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
 * JD-Core Version:    0.7.0.1
 */