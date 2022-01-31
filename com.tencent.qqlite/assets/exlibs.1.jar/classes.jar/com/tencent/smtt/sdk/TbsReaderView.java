package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;

public class TbsReaderView
  extends FrameLayout
{
  public static final String IS_BAR_ANIMATING = "is_bar_animating";
  public static final String IS_BAR_SHOWING = "is_bar_show";
  public static final String IS_INTO_DOWNLOADING = "into_downloading";
  public static final String KEY_FILE_PATH = "filePath";
  public static final String KEY_TEMP_PATH = "tempPath";
  public static final int READER_CHANNEL_DOC_ID = 10965;
  public static final int READER_CHANNEL_PDF_ID = 10834;
  public static final int READER_CHANNEL_PPT_ID = 10833;
  public static final int READER_CHANNEL_TXT_ID = 10835;
  public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
  public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
  public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
  public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
  public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
  public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
  public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
  public static final String TAG = "TbsReaderView";
  static boolean gInitSdk = false;
  public static String gReaderPackName = "";
  public static String gReaderPackVersion = "";
  ReaderCallback mCallBack = null;
  Context mContext = null;
  ReaderCallback mReaderCallback = null;
  Object mTbsReader = null;
  ReaderWizard mWizard = null;
  
  public TbsReaderView(Context paramContext, ReaderCallback paramReaderCallback)
    throws RuntimeException
  {
    super(paramContext.getApplicationContext());
    if (!(paramContext instanceof Activity)) {
      throw new RuntimeException("error: unexpect context(none Activity)");
    }
    this.mCallBack = paramReaderCallback;
    this.mContext = paramContext;
    this.mReaderCallback = new ReaderCallback()
    {
      public void onCallBackAction(Integer paramAnonymousInteger, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        int i = 0;
        switch (paramAnonymousInteger.intValue())
        {
        }
        for (;;)
        {
          if ((TbsReaderView.this.mCallBack != null) && (i == 0)) {
            TbsReaderView.this.mCallBack.onCallBackAction(paramAnonymousInteger, paramAnonymousObject1, paramAnonymousObject2);
          }
          return;
          Object localObject;
          if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.mContext))
          {
            paramAnonymousInteger = Integer.valueOf(5011);
            localObject = TbsReaderView.getResString(TbsReaderView.this.mContext, 5023);
            paramAnonymousObject1 = new Bundle();
            paramAnonymousObject1.putString("tip", (String)localObject);
            paramAnonymousObject1.putString("statistics", "AHNG812");
            paramAnonymousObject1.putInt("channel_id", 10834);
            TbsReaderView.this.userStatistics("AHNG811");
          }
          else
          {
            Bundle localBundle = null;
            localObject = "";
            if (paramAnonymousObject1 != null)
            {
              localBundle = (Bundle)paramAnonymousObject1;
              localObject = localBundle.getString("docpath");
            }
            QbSdk.startQBForDoc(TbsReaderView.this.mContext, (String)localObject, 4, 0, "pdf", localBundle);
            TbsReaderView.this.userStatistics("AHNG813");
            i = 1;
            continue;
            if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.mContext))
            {
              paramAnonymousInteger = Integer.valueOf(5011);
              localObject = TbsReaderView.getResString(TbsReaderView.this.mContext, 5021);
              paramAnonymousObject1 = new Bundle();
              paramAnonymousObject1.putString("tip", (String)localObject);
              paramAnonymousObject1.putString("statistics", "AHNG808");
              paramAnonymousObject1.putInt("channel_id", 10833);
              TbsReaderView.this.userStatistics("AHNG807");
            }
            else
            {
              localBundle = null;
              localObject = "";
              if (paramAnonymousObject1 != null)
              {
                localBundle = (Bundle)paramAnonymousObject1;
                localObject = localBundle.getString("docpath");
              }
              QbSdk.startQBForDoc(TbsReaderView.this.mContext, (String)localObject, 4, 0, "", localBundle);
              TbsReaderView.this.userStatistics("AHNG809");
              i = 1;
              continue;
              if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.mContext))
              {
                paramAnonymousInteger = Integer.valueOf(5011);
                localObject = TbsReaderView.getResString(TbsReaderView.this.mContext, 5022);
                paramAnonymousObject1 = new Bundle();
                paramAnonymousObject1.putString("tip", (String)localObject);
                paramAnonymousObject1.putString("statistics", "AHNG816");
                paramAnonymousObject1.putInt("channel_id", 10835);
                TbsReaderView.this.userStatistics("AHNG815");
              }
              else
              {
                localBundle = null;
                localObject = "";
                if (paramAnonymousObject1 != null)
                {
                  localBundle = (Bundle)paramAnonymousObject1;
                  localObject = localBundle.getString("docpath");
                }
                QbSdk.startQBForDoc(TbsReaderView.this.mContext, (String)localObject, 4, 0, "txt", localBundle);
                i = 1;
                continue;
                if (!MttLoader.isBrowserInstalledEx(TbsReaderView.this.mContext))
                {
                  paramAnonymousInteger = Integer.valueOf(5011);
                  localObject = TbsReaderView.getResString(TbsReaderView.this.mContext, 5029);
                  paramAnonymousObject1 = new Bundle();
                  paramAnonymousObject1.putString("tip", (String)localObject);
                  paramAnonymousObject1.putString("statistics", "AHNG828");
                  paramAnonymousObject1.putInt("channel_id", 10965);
                  TbsReaderView.this.userStatistics("AHNG827");
                }
                else
                {
                  localBundle = null;
                  localObject = "";
                  if (paramAnonymousObject1 != null)
                  {
                    localBundle = (Bundle)paramAnonymousObject1;
                    localObject = localBundle.getString("docpath");
                  }
                  QbSdk.startQBForDoc(TbsReaderView.this.mContext, (String)localObject, 4, 0, "doc", localBundle);
                  TbsReaderView.this.userStatistics("AHNG829");
                  i = 1;
                  continue;
                  if (paramAnonymousObject1 != null)
                  {
                    localObject = (Bundle)paramAnonymousObject1;
                    TbsReaderView.gReaderPackName = ((Bundle)localObject).getString("name");
                    TbsReaderView.gReaderPackVersion = ((Bundle)localObject).getString("version");
                  }
                  i = 1;
                }
              }
            }
          }
        }
      }
    };
  }
  
  public static Drawable getResDrawable(Context paramContext, int paramInt)
  {
    Drawable localDrawable = null;
    if (initSDK(paramContext)) {
      localDrawable = ReaderWizard.getResDrawable(paramInt);
    }
    return localDrawable;
  }
  
  public static String getResString(Context paramContext, int paramInt)
  {
    String str = "";
    if (initSDK(paramContext)) {
      str = ReaderWizard.getResString(paramInt);
    }
    return str;
  }
  
  static boolean initSDK(Context paramContext)
  {
    boolean bool = true;
    if (!gInitSdk)
    {
      SDKEngine.getInstance(true).init(paramContext.getApplicationContext(), true);
      if (SDKEngine.getInstance(false).wizardForReaderView() == null) {
        break label38;
      }
    }
    for (;;)
    {
      gInitSdk = bool;
      return gInitSdk;
      label38:
      bool = false;
    }
  }
  
  public static boolean isSupportExt(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (initSDK(paramContext))
    {
      if ((ReaderWizard.isSupportCurrentPlatform(paramContext)) && (ReaderWizard.isSupportExt(paramString))) {
        bool = true;
      }
    }
    else {
      return bool;
    }
    return false;
  }
  
  public void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if ((this.mWizard != null) && (this.mTbsReader != null)) {
      this.mWizard.doCommand(this.mTbsReader, paramInteger, paramObject1, paramObject2);
    }
  }
  
  public boolean downloadPlugin(String paramString)
  {
    if (this.mTbsReader == null)
    {
      Log.e("TbsReaderView", "downloadPlugin failed!");
      return false;
    }
    return this.mWizard.checkPlugin(this.mTbsReader, this.mContext, paramString, true);
  }
  
  boolean initWizard()
  {
    boolean bool = false;
    try
    {
      if (this.mWizard == null) {
        this.mWizard = new ReaderWizard(this.mReaderCallback);
      }
      if (this.mTbsReader == null) {
        this.mTbsReader = this.mWizard.getTbsReader();
      }
      if (this.mTbsReader != null) {
        bool = this.mWizard.initTbsReader(this.mTbsReader, this.mContext);
      }
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("TbsReaderView", "Unexpect null object!");
    }
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    if ((this.mWizard != null) && (this.mTbsReader != null)) {
      this.mWizard.onSizeChanged(this.mTbsReader, paramInt1, paramInt2);
    }
  }
  
  public void onStop()
  {
    if (this.mWizard != null)
    {
      this.mWizard.destroy(this.mTbsReader);
      this.mTbsReader = null;
    }
    this.mContext = null;
    gInitSdk = false;
  }
  
  public void openFile(Bundle paramBundle)
  {
    boolean bool2 = true;
    if ((this.mTbsReader == null) || (paramBundle == null))
    {
      Log.e("TbsReaderView", "init failed!");
      return;
    }
    boolean bool3 = MttLoader.isBrowserInstalledEx(this.mContext);
    if (!MttLoader.isBrowserInstalled(this.mContext))
    {
      bool1 = true;
      label43:
      paramBundle.putBoolean("browser6.0", bool3 | bool1);
      bool3 = MttLoader.isGreatBrowserVer(this.mContext, 6101625L, 610000L);
      if (MttLoader.isBrowserInstalled(this.mContext)) {
        break label126;
      }
    }
    label126:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBundle.putBoolean("browser6.1", bool3 | bool1);
      if (this.mWizard.openFile(this.mTbsReader, this.mContext, paramBundle, this)) {
        break;
      }
      Log.e("TbsReaderView", "OpenFile failed!");
      return;
      bool1 = false;
      break label43;
    }
  }
  
  public boolean preOpen(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (!isSupportExt(this.mContext, paramString))
    {
      Log.e("TbsReaderView", "not supported by:" + paramString);
      return false;
    }
    boolean bool3 = initSDK(this.mContext);
    boolean bool1 = bool3;
    if (bool3)
    {
      bool3 = initWizard();
      bool1 = bool3;
      if (paramBoolean)
      {
        bool1 = bool3;
        if (bool3)
        {
          paramBoolean = bool2;
          if (Apn.getApnType(this.mContext) == 3) {
            paramBoolean = true;
          }
          bool1 = this.mWizard.checkPlugin(this.mTbsReader, this.mContext, paramString, paramBoolean);
        }
      }
    }
    return bool1;
  }
  
  public void userStatistics(String paramString)
  {
    if (this.mWizard != null) {
      this.mWizard.userStatistics(this.mTbsReader, paramString);
    }
  }
  
  public static abstract interface ReaderCallback
  {
    public static final int COPY_SELECT_TEXT = 5003;
    public static final int GET_BAR_ANIMATING = 5000;
    public static final int GET_BAR_ISSHOWING = 5024;
    public static final int HIDDEN_BAR = 5001;
    public static final int INSTALL_QB = 5011;
    public static final int NOTIFY_CANDISPLAY = 12;
    public static final int NOTIFY_ERRORCODE = 19;
    public static final int READER_OPEN_QQ_FILE_LIST = 5031;
    public static final int READER_PDF_LIST = 5008;
    public static final int READER_PLUGIN_CANLOAD = 5013;
    public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
    public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
    public static final int READER_PLUGIN_DOWNLOADING = 5014;
    public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
    public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
    public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
    public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
    public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
    public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
    public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
    public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
    public static final int READER_PLUGIN_SO_ERR = 5025;
    public static final int READER_PLUGIN_SO_INTO_START = 5027;
    public static final int READER_PLUGIN_SO_PROGRESS = 5028;
    public static final int READER_PLUGIN_SO_VERSION = 5030;
    public static final int READER_PLUGIN_STATUS = 5012;
    public static final int READER_PPT_PLAY_MODEL = 5009;
    public static final int READER_SEARCH_IN_DOCUMENT = 5026;
    public static final int READER_TOAST = 5005;
    public static final int READER_TXT_READING_MODEL = 5010;
    public static final int SEARCH_SELECT_TEXT = 5004;
    public static final int SHOW_BAR = 5002;
    public static final int SHOW_DIALOG = 5006;
    
    public abstract void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderView
 * JD-Core Version:    0.7.0.1
 */