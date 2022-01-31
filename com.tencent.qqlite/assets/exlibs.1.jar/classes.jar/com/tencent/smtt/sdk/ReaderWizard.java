package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;

public class ReaderWizard
{
  private static final String TAG = "ReaderWizard";
  private static final String TBS_READER_CLASS_NAME = "com.tencent.tbs.reader.TbsReader";
  private TbsReaderView.ReaderCallback mCallBack = null;
  private DexLoader mDexLoader = null;
  
  public ReaderWizard(TbsReaderView.ReaderCallback paramReaderCallback)
  {
    this.mCallBack = paramReaderCallback;
  }
  
  private static DexLoader getDexLoader()
  {
    TbsWizard localTbsWizard = SDKEngine.getInstance(true).wizardForReaderView();
    DexLoader localDexLoader = null;
    if (localTbsWizard != null) {
      localDexLoader = localTbsWizard.dexLoader();
    }
    return localDexLoader;
  }
  
  public static Drawable getResDrawable(int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = getDexLoader();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((DexLoader)localObject3).invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      localObject1 = localObject2;
      if ((localObject3 instanceof Drawable)) {
        localObject1 = (Drawable)localObject3;
      }
    }
    return localObject1;
  }
  
  public static String getResString(int paramInt)
  {
    String str2 = "";
    Object localObject = getDexLoader();
    String str1 = str2;
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[] { Integer.class }, new Object[] { Integer.valueOf(paramInt) });
      str1 = str2;
      if ((localObject instanceof String)) {
        str1 = (String)localObject;
      }
    }
    return str1;
  }
  
  public static boolean isSupportCurrentPlatform(Context paramContext)
  {
    boolean bool2 = false;
    DexLoader localDexLoader = getDexLoader();
    boolean bool1 = bool2;
    if (localDexLoader != null)
    {
      paramContext = localDexLoader.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[] { Context.class }, new Object[] { paramContext });
      bool1 = bool2;
      if ((paramContext instanceof Boolean)) {
        bool1 = ((Boolean)paramContext).booleanValue();
      }
    }
    return bool1;
  }
  
  public static boolean isSupportExt(String paramString)
  {
    boolean bool2 = false;
    DexLoader localDexLoader = getDexLoader();
    boolean bool1 = bool2;
    if (localDexLoader != null)
    {
      paramString = localDexLoader.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[] { String.class }, new Object[] { paramString });
      bool1 = bool2;
      if ((paramString instanceof Boolean)) {
        bool1 = ((Boolean)paramString).booleanValue();
      }
    }
    return bool1;
  }
  
  public boolean checkPlugin(Object paramObject, Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.mDexLoader == null)
    {
      Log.e("ReaderWizard", "checkPlugin:Unexpect null object!");
      return false;
    }
    paramObject = this.mDexLoader.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[] { Context.class, String.class, Boolean.class }, new Object[] { paramContext, paramString, Boolean.valueOf(paramBoolean) });
    if (!(paramObject instanceof Boolean))
    {
      Log.e("ReaderWizard", "Unexpect return value type of call checkPlugin!");
      return false;
    }
    return ((Boolean)paramObject).booleanValue();
  }
  
  public void destroy(Object paramObject)
  {
    this.mCallBack = null;
    if ((this.mDexLoader == null) || (paramObject == null))
    {
      Log.e("ReaderWizard", "destroy:Unexpect null object!");
      return;
    }
    this.mDexLoader.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
  }
  
  public void doCommand(Object paramObject1, Integer paramInteger, Object paramObject2, Object paramObject3)
  {
    if (this.mDexLoader == null)
    {
      Log.e("ReaderWizard", "doCommand:Unexpect null object!");
      return;
    }
    DexLoader localDexLoader = this.mDexLoader;
    paramInteger = new Integer(paramInteger.intValue());
    localDexLoader.invokeMethod(paramObject1, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[] { Integer.class, Object.class, Object.class }, new Object[] { paramInteger, paramObject2, paramObject3 });
  }
  
  public Object getTbsReader()
  {
    return this.mDexLoader.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
  }
  
  public boolean initTbsReader(Object paramObject, Context paramContext)
  {
    if ((this.mDexLoader == null) || (paramObject == null))
    {
      Log.e("ReaderWizard", "initTbsReader:Unexpect null object!");
      return false;
    }
    DexLoader localDexLoader1 = this.mDexLoader;
    DexLoader localDexLoader2 = this.mDexLoader;
    paramObject = localDexLoader1.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "init", new Class[] { Context.class, DexLoader.class, Object.class }, new Object[] { paramContext, localDexLoader2, this });
    if (!(paramObject instanceof Boolean))
    {
      Log.e("ReaderWizard", "Unexpect return value type of call initTbsReader!");
      return false;
    }
    return ((Boolean)paramObject).booleanValue();
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if (this.mCallBack != null) {
      this.mCallBack.onCallBackAction(paramInteger, paramObject1, paramObject2);
    }
  }
  
  public void onSizeChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.mDexLoader == null)
    {
      Log.e("ReaderWizard", "onSizeChanged:Unexpect null object!");
      return;
    }
    DexLoader localDexLoader = this.mDexLoader;
    Integer localInteger1 = new Integer(paramInt1);
    Integer localInteger2 = new Integer(paramInt2);
    localDexLoader.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[] { Integer.class, Integer.class }, new Object[] { localInteger1, localInteger2 });
  }
  
  public boolean openFile(Object paramObject, Context paramContext, Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    if (this.mDexLoader == null)
    {
      Log.e("ReaderWizard", "openFile:Unexpect null object!");
      return false;
    }
    paramObject = this.mDexLoader.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[] { Context.class, Bundle.class, FrameLayout.class }, new Object[] { paramContext, paramBundle, paramFrameLayout });
    if (!(paramObject instanceof Boolean))
    {
      Log.e("ReaderWizard", "Unexpect return value type of call openFile!");
      return false;
    }
    return ((Boolean)paramObject).booleanValue();
  }
  
  public void userStatistics(Object paramObject, String paramString)
  {
    if (this.mDexLoader == null)
    {
      Log.e("ReaderWizard", "userStatistics:Unexpect null object!");
      return;
    }
    this.mDexLoader.invokeMethod(paramObject, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[] { String.class }, new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.ReaderWizard
 * JD-Core Version:    0.7.0.1
 */