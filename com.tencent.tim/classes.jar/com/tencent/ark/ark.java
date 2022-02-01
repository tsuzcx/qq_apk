package com.tencent.ark;

import android.graphics.Bitmap;
import java.util.Locale;
import java.util.Map;

public class ark
{
  public static final int APP_APPLICATION_NULL = 0;
  public static final int APP_INPUTMENU_COPYPASTE = 2;
  public static final int APP_INPUTMENU_PASTEONLY = 0;
  public static final int APP_INPUTMENU_SELECTPASTE = 1;
  public static final int APP_INPUTTYPE_DECIMAL = 4;
  public static final int APP_INPUTTYPE_EMAIL = 3;
  public static final int APP_INPUTTYPE_NUMBER = 2;
  public static final int APP_INPUTTYPE_PASSWORD = 1;
  public static final int APP_INPUTTYPE_TELEPHONE = 5;
  public static final int APP_INPUTTYPE_TEXT = 0;
  public static final int APP_MINVER_HIGHER = 3;
  public static final int APP_SCRIPT_TYPE_JAVASCRIPT = 2;
  public static final int APP_SCRIPT_TYPE_LUA = 1;
  public static final int APP_SCRIPT_TYPE_NULL = 0;
  public static final String APP_SPECIFIC_APPNAME = "appName";
  public static final String APP_SPECIFIC_APPPATH = "appPath";
  public static final int APP_TARGETVER_LOWER = 2;
  public static final int APP_URLCHECKING_LIST_TYPE_BLACK = 1;
  public static final int APP_URLCHECKING_LIST_TYPE_WHITE = 0;
  public static final int APP_VER_ERROR = 0;
  public static final int APP_VER_MATCH = 1;
  public static final String ARKMETADATA_JSON = "json";
  public static final String ARKMETADATA_XML = "xml";
  public static final int BORDER_RECTANGLE = 0;
  public static final int BORDER_ROUND_CORNER = 1;
  public static final int BORDER_ROUND_CORNER_WITH_HORN = 2;
  public static final int BORDER_ROUND_CORNER_WITH_MULTI_RADIUS = 3;
  public static final int VariantType_Bool = 2;
  public static final int VariantType_Double = 4;
  public static final int VariantType_Int32 = 3;
  public static final int VariantType_None = 0;
  public static final int VariantType_Null = 1;
  public static final int VariantType_Object = 6;
  public static final int VariantType_String = 5;
  
  public static final native void MediaSetStub(PlayerStubFactory paramPlayerStubFactory);
  
  public static final native void PlayerBufferingChange(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public static final native void PlayerStateChange(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public static final native void PlayerUpdateFrame(long paramLong1, long paramLong2, ark.PlayerStub.FrameInfo paramFrameInfo);
  
  public static final native void SetEnvironmentManager(ArkEnvironmentManager paramArkEnvironmentManager);
  
  public static final native void SetUseAndroidHTTP(boolean paramBoolean);
  
  public static final native void arkApplicationSetConfig(Application paramApplication, String paramString);
  
  public static final long arkGetARMv7LibCRC32()
  {
    return 475595046L;
  }
  
  public static final int arkGetARMv7LibSize()
  {
    return 3498536;
  }
  
  public static final native Container arkGetContainer(long paramLong);
  
  public static final int arkGetMaxTouchPoints()
  {
    return 8;
  }
  
  public static final int arkGetMinPlatformVersion()
  {
    return 2;
  }
  
  public static final native float arkGetPixelScale();
  
  public static final int arkGetPlatformBuildNumber()
  {
    return 240215857;
  }
  
  public static final int arkGetPlatformVersion()
  {
    return 32;
  }
  
  public static final long arkGetPngARMv7LibCRC32()
  {
    return 199180749L;
  }
  
  public static final int arkGetPngARMv7LibSize()
  {
    return 79992;
  }
  
  public static final native void arkHTTPSetDefaultHttpProxy(String paramString, int paramInt);
  
  public static final native int arkHTTPSetDownloadDirectory(String paramString);
  
  public static final native int arkHTTPShutdown();
  
  public static final native int arkHTTPStartup();
  
  public static final native boolean arkNotify(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static final native void arkSetAndroid9EmojiFeatureSupport(boolean paramBoolean);
  
  public static final native void arkSetLibraryPath(String paramString1, String paramString2);
  
  public static final native void arkSetPixelScale(float paramFloat);
  
  public static final native void arkSetScreenSize(float paramFloat1, float paramFloat2);
  
  public static final native void arkSetStoragePath(String paramString1, String paramString2);
  
  public static final long getArkSOArm64CRC()
  {
    return 1338912725L;
  }
  
  public static final int getArkSOArm64Size()
  {
    return 5378688;
  }
  
  public static final long getPngArm64CRC()
  {
    return 273271347L;
  }
  
  public static final int getPngArm64Size()
  {
    return 110184;
  }
  
  public static class Application
    extends ark.NativeObject
  {
    public static final native Application Create(String paramString1, String paramString2);
    
    public static native void EnableScriptLeakCheck(boolean paramBoolean);
    
    public static native boolean JSCLoaded();
    
    public native boolean CheckPermissions(String paramString);
    
    public native boolean CheckShareUrlLegality(String paramString);
    
    public native boolean CheckUrlLegality(String paramString);
    
    public native int CheckVersion();
    
    public native boolean CopyIconToBitmap(Bitmap paramBitmap);
    
    public native String GetActionSet();
    
    public native String GetDescription();
    
    public native String GetEngineResPath();
    
    public native String GetID();
    
    public native int GetIconHeight();
    
    public native int GetIconWidth();
    
    public native String GetLauncher();
    
    public native int GetScriptType();
    
    public native String GetSpecific(String paramString);
    
    public native String GetSystemPathFromLocal(String paramString);
    
    public native String GetUrlWhiteList();
    
    public native String GetVersion();
    
    public native void IncreaseGraphicMemSize(long paramLong);
    
    public native boolean Load(String paramString1, String paramString2, String paramString3);
    
    public native void Release();
    
    public native boolean Run(ark.ApplicationCallback paramApplicationCallback, String paramString);
    
    public native void SetForeground(boolean paramBoolean);
    
    public native boolean SetSpecific(String paramString1, String paramString2);
  }
  
  public static abstract interface ApplicationCallback
  {
    public abstract void AppCreate(ark.Application paramApplication);
    
    public abstract void AppDestroy(ark.Application paramApplication);
    
    public abstract boolean CheckUrlLegalityCallback(ark.Application paramApplication, String paramString);
    
    public abstract void OutputScriptError(String paramString1, String paramString2);
    
    public abstract void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication);
  }
  
  public static class Container
    extends ark.NativeObject
  {
    public Container()
    {
      this.mNative = newNativeObject(this);
    }
    
    private static final native void deleteNativeObject(long paramLong);
    
    private static final native long newNativeObject(Container paramContainer);
    
    public native boolean ActivateRootView();
    
    public native boolean AttachBitmap(Bitmap paramBitmap);
    
    public native boolean CheckShare();
    
    public native boolean CreateHardwareBitmap(int paramInt1, int paramInt2);
    
    public native boolean CreateRootView(ark.Application paramApplication, String paramString);
    
    public native boolean DeactivateRootView();
    
    public void DeletePtr()
    {
      deleteNativeObject(this.mNative);
      this.mNative = 0L;
    }
    
    public native void DestroyHardwareBitmap();
    
    public native void DetachBitmap(Bitmap paramBitmap);
    
    public native long GetViewHandle();
    
    public native boolean GetViewOpaque();
    
    public native String GetViewShare();
    
    public native boolean InputCanRedo();
    
    public native boolean InputCanUndo();
    
    public native boolean InputDeleteBackward();
    
    public native String InputGetSelectText();
    
    public native boolean InputInsertText(String paramString);
    
    public native boolean InputIsFocused();
    
    public native boolean InputRedo();
    
    public native boolean InputSelect();
    
    public native boolean InputSelectAll();
    
    public native boolean InputSetCaretHolderSize(int paramInt1, int paramInt2);
    
    public native boolean InputSetSelectHolderSize(int paramInt1, int paramInt2);
    
    public native boolean InputUndo();
    
    public native boolean InvalidSurface();
    
    public native boolean Paint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public native void SetBorderHornLeft(boolean paramBoolean);
    
    public native void SetBorderRadius(float paramFloat);
    
    public native void SetBorderRadiusTop(float paramFloat);
    
    public native void SetBorderType(int paramInt);
    
    public native void SetContainerCallback(ark.ContainerCallback paramContainerCallback);
    
    public native void SetContextHolder(EGLContextHolder paramEGLContextHolder);
    
    public native void SetDisableGPURasterization(boolean paramBoolean);
    
    public native void SetDisableGPURendering(boolean paramBoolean);
    
    public native void SetID(String paramString);
    
    public native void SetMetadata(String paramString1, String paramString2);
    
    public native void SetShowFps(boolean paramBoolean);
    
    public native void SetSize(int paramInt1, int paramInt2);
    
    public native void TouchCancel(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt);
    
    public native void TouchEnd(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt);
    
    public native void TouchMove(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt);
    
    public native void TouchStart(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt);
    
    public native void ViewEvent(String paramString1, String paramString2);
  }
  
  public static abstract interface ContainerCallback
  {
    public abstract void InputFocusChanged(boolean paramBoolean1, boolean paramBoolean2, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void InputMenuChanged(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void InputSelectChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void SyncRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void Update(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  }
  
  public static abstract interface ModuleCallbackWrapper
  {
    public abstract void Destruct();
    
    public abstract String GetTypeName();
    
    public abstract boolean HasMenthod(String paramString);
    
    public abstract boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper);
  }
  
  public static class ModuleRegister
    extends ark.NativeObject
  {
    public native boolean RegCallbackWrapper(ark.ModuleCallbackWrapper paramModuleCallbackWrapper);
  }
  
  public static class NativeObject
  {
    protected long mNative = 0L;
    
    protected void finalize()
      throws Throwable
    {
      if (this.mNative != 0L) {
        ArkEnvironmentManager.getInstance().logE("ark.leak", String.format(Locale.CHINA, "leak.obj.ark.%s.%h!!", new Object[] { getClass().getSimpleName(), this }));
      }
      super.finalize();
    }
  }
  
  public static abstract interface PlayerStub
  {
    public static final int ERROR_NETWORK = -3;
    public static final int ERROR_NO_RESOURCE = -5;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORT_HARDWARE = -4;
    public static final int ERROR_UNSUPPORT_MEDIA = -2;
    public static final int STATE_ERROR = 6;
    public static final int STATE_LOAD = 2;
    public static final int STATE_LOADING = 1;
    public static final int STATE_PAUSE = 4;
    public static final int STATE_PLAY = 3;
    public static final int STATE_START = 0;
    public static final int STATE_STOP = 5;
    public static final int TYPE_AUDIO = 1;
    public static final int TYPE_VIDEO = 0;
    
    public abstract void Destroy();
    
    public abstract double GetBufferedTime();
    
    public abstract double GetCurrentTime();
    
    public abstract int GetErrorCode();
    
    public abstract MediaInfo GetMediaInfo();
    
    public abstract boolean Load(String paramString);
    
    public abstract boolean Pause();
    
    public abstract boolean Play();
    
    public abstract boolean Resume();
    
    public abstract boolean Seek(double paramDouble);
    
    public abstract void SetBufferingCallback(long paramLong1, long paramLong2);
    
    public abstract void SetFrameCallback(long paramLong1, long paramLong2);
    
    public abstract void SetOutputSizeHint(int paramInt1, int paramInt2);
    
    public abstract void SetStateCallback(long paramLong1, long paramLong2);
    
    public abstract boolean SetVolume(float paramFloat);
    
    public abstract boolean Stop();
    
    public abstract boolean VideoPreviewSupported();
    
    public static final class FrameInfo
    {
      public int height;
      public int texture;
      public int width;
    }
    
    public static final class MediaInfo
    {
      public double duration;
      public int framerate;
      public int height;
      public boolean islive;
      public int pixelbits;
      public int state;
      public int type;
      public int width;
    }
  }
  
  public static abstract interface PlayerStubFactory
  {
    public abstract ark.PlayerStub CreateStub();
  }
  
  public static abstract interface RuntimeClassCallbackWrapper
  {
    public abstract boolean Destruct();
    
    public abstract boolean HasMethod(String paramString);
    
    public abstract boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper);
    
    public abstract boolean IsModule();
  }
  
  public static class VariantWrapper
    extends ark.NativeObject
  {
    public native VariantWrapper Copy();
    
    public native VariantWrapper Create();
    
    public native boolean CreateObject(String paramString, ark.RuntimeClassCallbackWrapper paramRuntimeClassCallbackWrapper);
    
    public native boolean GetBool();
    
    public native double GetDouble();
    
    public native int GetInt();
    
    public native String GetString();
    
    public native String GetTableAsJsonString();
    
    public native int GetType();
    
    public native long GetView();
    
    public native boolean Invoke(String paramString, VariantWrapper[] paramArrayOfVariantWrapper, VariantWrapper paramVariantWrapper);
    
    public native boolean InvokeDefault(VariantWrapper[] paramArrayOfVariantWrapper, VariantWrapper paramVariantWrapper);
    
    public native boolean IsArray();
    
    public native boolean IsFunction();
    
    public native boolean IsString();
    
    public native boolean IsTable();
    
    public native boolean IsUserObject();
    
    public native boolean IsView();
    
    public native void Reset();
    
    public native boolean SetBool(boolean paramBoolean);
    
    public native boolean SetDouble(double paramDouble);
    
    public native boolean SetInt(int paramInt);
    
    public native boolean SetMap(Map<String, String> paramMap);
    
    public native boolean SetNull();
    
    public native boolean SetString(String paramString);
    
    public native boolean SetTableAsJsonString(String paramString);
    
    public native boolean SetView(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ark
 * JD-Core Version:    0.7.0.1
 */