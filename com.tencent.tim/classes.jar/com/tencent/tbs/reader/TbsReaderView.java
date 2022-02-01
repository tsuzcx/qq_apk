package com.tencent.tbs.reader;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class TbsReaderView
  extends FrameLayout
  implements ITbsReaderCallback
{
  public static final String FILE_READER_BG_CONTENT_COLOR = "file_reader_bg_content_color";
  public static final String FILE_READER_DOWNLOAD_TYPE = "file_reader_download_type";
  public static final String FILE_READER_HIDE_TOOLBAR = "file_reader_tool_bar_hide";
  public static final String FILE_READER_UI_STYLE = "style";
  public static final int FILE_READER_UI_STYLE_QQ = 2;
  public static final String IS_BAR_ANIMATING = "is_bar_animating";
  public static final String IS_BAR_SHOWING = "is_bar_show";
  public static final String IS_INTO_DOWNLOADING = "into_downloading";
  public static final String KEY_FILE_PATH = "filePath";
  public static final String KEY_TEMP_PATH = "tempPath";
  public static final int READER_TYPE_DOWNLOAD_CUSTOM = 1;
  public static final int READER_TYPE_DOWNLOAD_DEFAULT = 0;
  public static final int READER_TYPE_ID_TOOLBAR_CLICK = 2;
  public static final int READER_TYPE_ID_TOOLBAR_CLICK_DOWNLOAD_QB = 5;
  public static final int READER_TYPE_ID_TOOLBAR_CLICK_SHOW_DIALOG = 4;
  public static final int READER_TYPE_ID_TOOLBAR_CLICK_TO_QB = 3;
  public static final int READER_TYPE_ID_TOOLBAR_GET_VIEW = 7;
  public static final int READER_TYPE_ID_TOOLBAR_OPEN_QB = 6;
  public static final int READER_TYPE_ID_TOOLBAR_SHOW = 1;
  public static final String TAG = "TbsReaderView";
  static boolean gInitSdk = false;
  public static String gReaderPackName = "";
  public static String gReaderPackVersion = "";
  ReaderCallback mCallBack = null;
  Context mContext = null;
  ReaderPluginPreLoad mPluginPreload = null;
  ReaderCallback mReaderCallback = null;
  TbsReaderManager mReaderManager = null;
  
  public TbsReaderView(Context paramContext, ReaderCallback paramReaderCallback)
    throws RuntimeException
  {
    super(paramContext);
    if (!(paramContext instanceof Activity)) {
      throw new RuntimeException("error: unexpect context(none Activity)");
    }
    this.mCallBack = paramReaderCallback;
    this.mContext = paramContext;
  }
  
  public static Drawable getResDrawable(Context paramContext, int paramInt)
  {
    return null;
  }
  
  public static String getResString(Context paramContext, int paramInt)
  {
    return "";
  }
  
  public static boolean initSDK(Context paramContext)
  {
    if (!gInitSdk) {
      gInitSdk = TbsFileInterfaceImpl.initEngine(paramContext.getApplicationContext());
    }
    Log.d("TbsReaderView", "gInitSdk:" + gInitSdk);
    return gInitSdk;
  }
  
  public static boolean isSupportExt(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (initSDK(paramContext)) {
      bool = TbsFileInterfaceImpl.canOpenFile(paramString);
    }
    return bool;
  }
  
  public void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if (this.mReaderManager != null) {
      this.mReaderManager.doAction(paramInteger, paramObject1, paramObject2);
    }
  }
  
  public boolean downloadPlugin(String paramString)
  {
    if (this.mReaderManager == null) {
      Log.e("TbsReaderView", "downloadPlugin failed!");
    }
    do
    {
      return false;
      if (this.mPluginPreload == null) {
        this.mPluginPreload = this.mReaderManager.getPluginPre(this.mContext);
      }
    } while (this.mPluginPreload.downloadPlugin(this.mContext, paramString) != 0);
    return true;
  }
  
  boolean initWizard()
  {
    try
    {
      if (this.mReaderManager == null) {
        this.mReaderManager = new TbsReaderManager();
      }
      boolean bool = this.mReaderManager.initReader(getContext(), this);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("TbsReaderView", "Unexpect null object!");
    }
    return false;
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    Log.d("TbsReaderView", "onCallBackAction:" + paramInteger);
    if (this.mCallBack != null) {
      this.mCallBack.onCallBackAction(paramInteger, paramObject1, paramObject2);
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    if (this.mReaderManager != null) {
      this.mReaderManager.onSizeChanged(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
  }
  
  public void onStop()
  {
    if (this.mPluginPreload != null) {
      this.mPluginPreload.destroy();
    }
    this.mPluginPreload = null;
    if (this.mReaderManager != null)
    {
      this.mReaderManager.destroy();
      this.mReaderManager = null;
    }
    this.mContext = null;
    gInitSdk = false;
  }
  
  public int openFile(Bundle paramBundle)
  {
    int i;
    if ((this.mReaderManager == null) || (paramBundle == null))
    {
      Log.e("TbsReaderView", "init failed!");
      i = -1;
    }
    int j;
    do
    {
      return i;
      if (!paramBundle.containsKey("file_reader_top_bar_hide")) {
        paramBundle.putBoolean("file_reader_top_bar_hide", true);
      }
      paramBundle.putInt("windowType", TbsFileInterfaceImpl.FILE_READER_WINDOW_TYPE_VIEW);
      j = this.mReaderManager.openFileReader(getContext(), paramBundle, this, this);
      i = j;
    } while (j == 0);
    Log.e("TbsReaderView", "OpenFile failed!");
    return j;
  }
  
  public boolean preOpen(String paramString, boolean paramBoolean)
  {
    boolean bool1;
    if (!isSupportExt(this.mContext, paramString))
    {
      Log.e("TbsReaderView", "not supported by:" + paramString);
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return bool1;
          bool2 = initSDK(this.mContext);
          bool1 = bool2;
        } while (!bool2);
        bool2 = initWizard();
        bool1 = bool2;
      } while (!paramBoolean);
      bool1 = bool2;
    } while (!bool2);
    downloadPlugin(paramString);
    return bool2;
  }
  
  public void userStatistics(String paramString)
  {
    if (this.mReaderManager != null) {
      this.mReaderManager.doAction(Integer.valueOf(6002), paramString, null);
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
    public static final int READER_CUSTOM_QQ_EVENT = 6001;
    public static final int READER_GET_TITLE_BAR_HEIGHT = 5045;
    public static final int READER_OPEN_QQ_FILE_LIST = 5031;
    public static final int READER_PDF_LIST = 5008;
    public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
    public static final int READER_PLUGIN_CANLOAD = 5013;
    public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
    public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
    public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
    public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
    public static final int READER_PLUGIN_COMMAND_USER_STATICS = 6002;
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
    public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
    public static final int READER_PPT_PLAY_MODEL = 5009;
    public static final int READER_SEARCH_IN_DOCUMENT = 5026;
    public static final int READER_TOAST = 5005;
    public static final int READER_TXT_READING_MODEL = 5010;
    public static final int SEARCH_SELECT_TEXT = 5004;
    public static final int SET_EXTRA_INFO = 58;
    public static final int SHOW_BAR = 5002;
    public static final int SHOW_DIALOG = 5006;
    
    public abstract void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsReaderView
 * JD-Core Version:    0.7.0.1
 */