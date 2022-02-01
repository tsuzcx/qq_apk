package com.tencent.mobileqq.theme.diy;

import acbn;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import aqcu;
import aqho;
import aqhu;
import aqul;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class ThemeDiyStyleLogic
{
  static final String BUNDLE_KEY_INDEX = "index";
  static final String BUNDLE_KEY_PATH = "path";
  static final String BUNDLE_KEY_THEME_INDEX = "themeIndex";
  static final String BUNDLE_OPERATE_BACK_CODE = "operateBackCode";
  static final String BUNDLE_OPERATE_NEXT = "nextOperate";
  static final String BUNDLE_OPERATE_NOW = "nowOperate";
  private static String DIR_DIY;
  public static final int OPERATE_CODE_GO_ERROR = 8;
  public static final int OPERATE_CODE_GO_OFF = 6;
  public static final int OPERATE_CODE_GO_ON = 4;
  public static final int OPERATE_CODE_GO_WAIT = 2;
  public static final int OPERATE_CODE_NONE = 0;
  public static final int OPERATE_KEY_DEAL_BG = 14;
  public static final int OPERATE_KEY_DOWN_BG = 13;
  public static final int OPERATE_KEY_PREPARE = 11;
  public static final int OPERATE_KEY_SAVE = 10;
  public static final int OPERATE_KEY_SAVE_SERVER = 16;
  public static final int OPERATE_KEY_SWITCH_THEME = 15;
  public static final int OPERATE_KEY_UPDATE_PAGE = 18;
  public static final String SPLIT_KEY = "__";
  static final String TAG = "ThemeDiyStyleLogic";
  QQAppInterface app;
  Context mContext;
  public HashMap<Integer, String> reportMap = new HashMap();
  public a saveDealCallBack;
  public int styleState;
  
  public ThemeDiyStyleLogic(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
  }
  
  private static void checkDIYDir()
  {
    ThreadManager.getFileThreadHandler().post(new ThemeDiyStyleLogic.1());
  }
  
  public static String getDataDIYDir()
  {
    String str;
    if (DIR_DIY == null)
    {
      str = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath();
      if (!str.endsWith(File.separator)) {
        break label55;
      }
    }
    label55:
    for (DIR_DIY = str + "custom_background/";; DIR_DIY = str + File.separator + "custom_background/")
    {
      checkDIYDir();
      return DIR_DIY;
    }
  }
  
  public static String getDealFileName(ResData paramResData, int paramInt)
  {
    if (paramResData == null) {
      return null;
    }
    return paramInt + "__" + paramResData.id + "__" + paramResData.name;
  }
  
  public static String getDiyVFSPath(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith(acbn.SDCARD_PATH + "custom_background/")) {
        str = aqul.getSDKPrivatePath(paramString);
      }
    }
    return str;
  }
  
  public static String getDownFileName(ResData paramResData)
  {
    if (paramResData == null) {
      return "__99__" + System.currentTimeMillis() + ".jpg";
    }
    return "__" + paramResData.id + "__" + paramResData.name;
  }
  
  public static String getSdcardDIYDir()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "custom_background/");
  }
  
  static ThemeUtil.ThemeInfo getThemeInfoByDensity(Context paramContext, ResSuitData.StyleSuit paramStyleSuit)
  {
    if (paramStyleSuit != null)
    {
      if (paramStyleSuit.themeInfo != null) {
        return paramStyleSuit.themeInfo;
      }
      QLog.d("ThemeDiyStyleLogic", 1, "getThemeInfoByDensity resItem.themeJson == null");
      Object localObject2 = ThemeUtil.getThemeInfo(paramContext, paramStyleSuit.id);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ThemeUtil.ThemeInfo();
        ((ThemeUtil.ThemeInfo)localObject1).themeId = paramStyleSuit.id;
      }
      ((ThemeUtil.ThemeInfo)localObject1).downloadUrl = DIYThemeUtils.getResData(null, paramStyleSuit, 207, paramStyleSuit.zipUrl).url;
      ((ThemeUtil.ThemeInfo)localObject1).size = paramStyleSuit.zipSize;
      ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme = false;
      if ("999".equals(paramStyleSuit.id)) {}
      for (localObject2 = "20000000";; localObject2 = paramStyleSuit.zipVersion)
      {
        ((ThemeUtil.ThemeInfo)localObject1).version = ((String)localObject2);
        paramStyleSuit.themeInfo = ((ThemeUtil.ThemeInfo)localObject1);
        ThemeUtil.setThemeInfo(paramContext, (ThemeUtil.ThemeInfo)localObject1);
        return localObject1;
      }
    }
    QLog.e("ThemeDiyStyleLogic", 1, "getThemeInfoByDensity error resItem == null");
    return null;
  }
  
  public static boolean isNeedDealDarkBri(ThemeDIYData paramThemeDIYData, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramThemeDIYData != null) && (paramThemeDIYData.dealInt != 0) && ((paramInt != 0) || (paramThemeDIYData.position != 0)))
    {
      bool1 = bool2;
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramThemeDIYData.position != 1) {}
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  private static void iteratorPath(File paramFile, List<File> paramList)
  {
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramFile[i];
        if (localObject.isFile()) {
          paramList.add(localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localObject.isDirectory()) {
            iteratorPath(localObject, paramList);
          }
        }
      }
    }
  }
  
  public int dealDarkBrightness(ThemeDIYData paramThemeDIYData, Bundle paramBundle)
  {
    if ((paramThemeDIYData != null) && (paramThemeDIYData.tryOnBgBigOrgRD != null))
    {
      if (paramThemeDIYData.tryOnBgBigOrgRD.state == 5) {
        return 4;
      }
      if (paramThemeDIYData.tryOnBgBigOrgRD.state == 2)
      {
        if (isNeedDealDarkBri(paramThemeDIYData, paramBundle.getInt("themeIndex")))
        {
          paramThemeDIYData.tryOnBgBigOrgRD.state = 5;
          return 4;
        }
        paramBundle = getDealFileName(paramThemeDIYData.tryOnBgBigOrgRD, paramThemeDIYData.position);
        if (new File(paramThemeDIYData.tryOnBgBigOrgRD.path, paramBundle).exists())
        {
          paramThemeDIYData.tryOnBgBigOrgRD.state = 5;
          return 4;
        }
        String str = paramThemeDIYData.tryOnBgBigOrgRD.path + getDownFileName(paramThemeDIYData.tryOnBgBigOrgRD);
        Bundle localBundle = new Bundle();
        localBundle.putInt("nowOperate", 11);
        new DarkBrightnessTask(this.mContext, this.app, str, paramBundle, paramThemeDIYData, localBundle, this.saveDealCallBack).execute(new Object[0]);
      }
      return 2;
    }
    return 8;
  }
  
  public static class DarkBrightnessTask
    extends AsyncTask<Object, Object, Integer>
  {
    public QQAppInterface app;
    Bundle bundle;
    Context ctx;
    ThemeDIYData data;
    ThemeDiyStyleLogic.a dealPicCallBack;
    String orgSrc;
    String saveSrc;
    
    public DarkBrightnessTask(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ThemeDIYData paramThemeDIYData, Bundle paramBundle, ThemeDiyStyleLogic.a parama)
    {
      this.ctx = paramContext;
      this.app = paramQQAppInterface;
      this.orgSrc = paramString1;
      this.data = paramThemeDIYData;
      this.bundle = paramBundle;
      this.saveSrc = paramString2;
      this.dealPicCallBack = parama;
      if ((paramThemeDIYData != null) && (paramThemeDIYData.tryOnBgBigOrgRD != null)) {
        paramThemeDIYData.tryOnBgBigOrgRD.state = 4;
      }
    }
    
    protected Integer doInBackground(Object... paramVarArgs)
    {
      if (this.data == null) {
        return Integer.valueOf(0);
      }
      if (this.data.tryOnBgBigOrgRD == null)
      {
        this.saveSrc = this.orgSrc;
        if (QLog.isColorLevel()) {
          QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.doInBackground, params = null, orgSrc = " + this.orgSrc);
        }
        return Integer.valueOf(1);
      }
      paramVarArgs = new BitmapFactory.Options();
      paramVarArgs.inPreferredConfig = Bitmap.Config.RGB_565;
      Bitmap localBitmap = aqcu.decodeFile(this.orgSrc, paramVarArgs);
      if (localBitmap == null) {
        return Integer.valueOf(0);
      }
      float f = 0.75F;
      int i = this.data.dealInt;
      int j = localBitmap.getWidth();
      i = localBitmap.getHeight();
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.doInBackground, orgSrc = " + this.orgSrc);
      }
      Object localObject;
      int k;
      int m;
      if ((this.data.tryOnBgBigOrgRD.index != 0) && ((this.ctx instanceof Activity)))
      {
        paramVarArgs = (Activity)this.ctx;
        localObject = new Rect();
        paramVarArgs.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
        k = ((Rect)localObject).width() * 3 / 4;
        m = ((Rect)localObject).height() * 3 / 4;
        if (m * 1.0F / k >= i * 1.0F / j)
        {
          j = k * i / m;
          if (j <= localBitmap.getWidth()) {
            break label610;
          }
          j = localBitmap.getWidth();
          f = j * 1.0F / ((Rect)localObject).width();
        }
      }
      for (;;)
      {
        if (this.data.position != 0)
        {
          k = (int)(aqho.convertDpToPixel(this.ctx, 113.0F) * f);
          m = (int)(f * aqho.convertDpToPixel(this.ctx, 51.0F));
          i -= k;
        }
        for (;;)
        {
          try
          {
            localObject = localBitmap.getConfig();
            paramVarArgs = (Object[])localObject;
            if (localObject == null) {
              paramVarArgs = Bitmap.Config.RGB_565;
            }
            paramVarArgs = Bitmap.createBitmap(j, i, paramVarArgs);
            localObject = new Canvas(paramVarArgs);
            Paint localPaint = new Paint();
            localPaint.setAntiAlias(true);
            ((Canvas)localObject).drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
            localPaint.setColor(this.app.getApp().getResources().getColor(this.data.orgMarkColor));
            ((Canvas)localObject).drawRect(0.0F, 0.0F, j, i, localPaint);
            aqhu.saveBitmapToFile(paramVarArgs, new File(this.saveSrc));
            return Integer.valueOf(1);
          }
          catch (OutOfMemoryError paramVarArgs)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask OOM " + paramVarArgs.getMessage());
            return Integer.valueOf(0);
          }
          catch (IOException paramVarArgs)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask ioError " + paramVarArgs.getMessage());
            continue;
          }
          catch (Exception paramVarArgs)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask Error  " + paramVarArgs.getMessage());
            continue;
          }
          i = j * m / k;
          if (i <= localBitmap.getHeight()) {
            break label607;
          }
          i = localBitmap.getWidth();
          break;
        }
        label607:
        break;
        label610:
        break;
      }
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      if (paramInteger.intValue() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is ok");
        }
        if (this.dealPicCallBack != null) {
          this.dealPicCallBack.callback(14, 4, this.bundle, this.data.tryOnBgBigOrgRD);
        }
      }
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is error");
        }
      } while (this.dealPicCallBack == null);
      this.dealPicCallBack.callback(14, 8, this.bundle, this.data.tryOnBgBigOrgRD);
    }
  }
  
  public static abstract interface a
  {
    public abstract int callback(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic
 * JD-Core Version:    0.7.0.1
 */