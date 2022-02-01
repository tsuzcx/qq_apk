package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusParserWithHotReload
  extends ProteusParser
{
  private static final String BROADCAST_ACTION = "com.tencent.proteus.ReloadBroadcast";
  private static final String PROTEUS_DEBUG_FOLDER = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ProteusDebug/";
  private static final String SPLIT_FLAG = "^#^";
  private static final String TAG = "ProteusParserHotReload";
  private HashMap<String, ArrayList<String>> mComplementMap = new HashMap();
  private ArrayList<IHotReloadChangedObserver> mHotReloadChangedObservers = new ArrayList();
  private HashMap<String, String> mHotReloadMap = new HashMap();
  private boolean mIsSupportHotReload = false;
  private HashMap<String, ComplementFileStringLoader> mPathMap = new HashMap();
  private HashMap<String, String> mTemplateBeanToStyleMap = new HashMap();
  
  private void createViewTemplateFromFile(Context paramContext, BaseTemplateFactory paramBaseTemplateFactory, String paramString1, ComplementFileStringLoader paramComplementFileStringLoader, String paramString2, String paramString3, String paramString4)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString1);
    paramString1 = "";
    try
    {
      paramContext = getJsonStringFromFile(paramContext, paramString4);
      parseAndCreateViewTemplate(paramBaseTemplateFactory, localJSONObject, paramComplementFileStringLoader, paramString2, paramString3, paramContext);
      return;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = paramString1;
      }
    }
  }
  
  public static ProteusParserWithHotReload getInstance()
  {
    return SingletonInstance.instance;
  }
  
  private void initHotReloadMap()
  {
    if (!this.mIsSupportHotReload) {}
    for (;;)
    {
      return;
      File[] arrayOfFile = new File(PROTEUS_DEBUG_FOLDER).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          String str1 = arrayOfFile[i].getName();
          String str2 = str1.replace("^#^", "/");
          this.mHotReloadMap.put(str2, str1);
          i += 1;
        }
      }
    }
  }
  
  private JSONObject maybeIncludeComponent(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, String paramString1, String paramString2)
    throws JSONException
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject.has("$includeComponet"))
    {
      if (paramComplementFileStringLoader == null) {
        break label284;
      }
      paramComplementFileStringLoader = paramComplementFileStringLoader.loadFileAsString(paramJSONObject.getString("$includeComponet"));
      localObject = paramComplementFileStringLoader;
      if (this.mIsSupportHotReload)
      {
        paramString2 = paramString2 + "/" + paramJSONObject.getString("$includeComponet");
        paramJSONObject = paramComplementFileStringLoader;
        if (!this.mHotReloadMap.containsKey(paramString2)) {}
      }
    }
    try
    {
      paramJSONObject = readInputStreamAsString(new FileInputStream(new File(PROTEUS_DEBUG_FOLDER + (String)this.mHotReloadMap.get(paramString2))));
      localObject = paramJSONObject;
      if (this.mComplementMap != null)
      {
        if (this.mComplementMap.get(paramString2) == null)
        {
          paramComplementFileStringLoader = new ArrayList();
          this.mComplementMap.put(paramString2, paramComplementFileStringLoader);
        }
        localObject = paramJSONObject;
        if (!((ArrayList)this.mComplementMap.get(paramString2)).contains(paramString1))
        {
          ((ArrayList)this.mComplementMap.get(paramString2)).add(paramString1);
          localObject = paramJSONObject;
        }
      }
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
    }
    catch (FileNotFoundException paramJSONObject)
    {
      for (;;)
      {
        LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload file not found error: " + PROTEUS_DEBUG_FOLDER + (String)this.mHotReloadMap.get(paramString2));
        paramJSONObject = paramComplementFileStringLoader;
      }
    }
    label284:
    return null;
  }
  
  private void parseAndCreateViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    int i = paramBaseTemplateFactory.getTemplateId();
    String str = getStyleId(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(str);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramBaseTemplateFactory.createTemplate(i, str, parseItemView(paramJSONObject, paramComplementFileStringLoader, paramString1, paramString2, paramString3, localArrayList2, localArrayList1), getTemplateGloabalVar(localArrayList2, localArrayList1));
      return;
    }
    catch (IllegalArgumentException paramBaseTemplateFactory)
    {
      throw new IllegalArgumentException("问题源:" + str + paramBaseTemplateFactory.getMessage());
    }
  }
  
  private void parseAttr(JSONObject paramJSONObject, ViewBean paramViewBean, String paramString, ArrayList<String> paramArrayList)
    throws JSONException
  {
    Iterator localIterator = paramJSONObject.keys();
    Object localObject = new ArrayMap();
    System.currentTimeMillis();
    parseDataMap((Map)localObject, paramString);
    paramString = (Map)((Map)localObject).get(paramViewBean.viewId);
    if (paramString != null)
    {
      paramString = paramString.entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        putStyleMapValueKey(paramViewBean.valueBean, (String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      localObject = paramJSONObject.get(paramString);
      dealMethod(paramViewBean.valueBean, paramString, localObject, new ProteusParserWithHotReload.1(this, paramViewBean, paramString, localObject, paramArrayList));
    }
  }
  
  private void parseDataMap(Map<String, Map<String, String>> paramMap, String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = new JSONObject(paramString).getJSONObject("data_map");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramMap.put(str, getKeyValue(paramString.getJSONObject(str)));
      }
    }
  }
  
  private ViewBean parseItemView(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
    throws JSONException
  {
    ViewBean localViewBean = new ViewBean();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get((String)localObject1);
      if (paramJSONObject.has("view_id")) {
        localViewBean.viewId = paramJSONObject.getString("view_id");
      }
      for (;;)
      {
        if (((String)localObject1).equals("view_type"))
        {
          localObject1 = paramJSONObject.getString("view_type");
          if ((TextUtils.equals((CharSequence)localObject1, "cell")) || (TextUtils.equals((CharSequence)localObject1, "container")))
          {
            if (TextUtils.equals("layout_relative", paramJSONObject.optString("layout_type")))
            {
              localViewBean.viewType = "RelativeLayout";
              break;
              localViewBean.viewId = ("$default_view_id" + defaultId.getAndIncrement());
              continue;
            }
            localViewBean.viewType = "LinearLayout";
            break;
          }
          if (TextUtils.equals((CharSequence)localObject1, "UIView"))
          {
            if (paramJSONObject.optJSONArray("subviews") != null)
            {
              if (TextUtils.equals("layout_relative", paramJSONObject.optString("layout_type")))
              {
                localViewBean.viewType = "NativeRelativeLayout";
                break;
              }
              localViewBean.viewType = "NativeLinearLayout";
              break;
            }
            localViewBean.viewType = "NativeLinearLayout";
            break;
          }
          localViewBean.viewType = ((String)localObject1);
          break;
        }
      }
      if (!((String)localObject1).equals("view_id")) {
        if (((String)localObject1).equals("subviews"))
        {
          localObject1 = paramJSONObject.getJSONArray((String)localObject1);
          localObject2 = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            JSONObject localJSONObject = maybeIncludeComponent(((JSONArray)localObject1).getJSONObject(i), paramComplementFileStringLoader, paramString1, paramString2);
            if (localJSONObject != null) {
              ((List)localObject2).add(parseItemView(localJSONObject, paramComplementFileStringLoader, paramString1, paramString2, paramString3, paramArrayList1, paramArrayList2));
            }
            i += 1;
          }
          localViewBean.children = new ViewBean[((List)localObject2).size()];
          ((List)localObject2).toArray(localViewBean.children);
        }
        else if (((String)localObject1).equals("attributes"))
        {
          parseAttr(paramJSONObject.getJSONObject((String)localObject1), localViewBean, paramString3, paramArrayList2);
        }
        else if (((String)localObject1).equals("data_attributes"))
        {
          parseDataAttr(paramJSONObject.getJSONObject((String)localObject1), localViewBean, paramArrayList2);
        }
        else if (((String)localObject1).equals("$includeGlobalVariable"))
        {
          parseIncludeGlobalFile(localObject2, paramComplementFileStringLoader, paramArrayList1);
        }
        else
        {
          parseLayoutParams((String)localObject1, localObject2, localViewBean.valueBean);
        }
      }
    }
    return localViewBean;
  }
  
  private String readInputStreamAsString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          Log.e("ProteusParserHotReload", "readInputStreamAsString: fail to close InputStream", paramInputStream);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      Log.d("ProteusParserHotReload", "fail to read string from input stream");
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            Log.e("ProteusParserHotReload", "readInputStreamAsString: fail to close InputStream", paramInputStream);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          Log.e("ProteusParserHotReload", "readInputStreamAsString: fail to close InputStream", paramInputStream);
        }
      }
    }
    finally {}
  }
  
  public void addHotReloadChangedObserver(IHotReloadChangedObserver paramIHotReloadChangedObserver)
  {
    this.mHotReloadChangedObservers.add(paramIHotReloadChangedObserver);
  }
  
  public void createViewTempFromAssets(Context paramContext, BaseTemplateFactory paramBaseTemplateFactory, ComplementFileStringLoader paramComplementFileStringLoader, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = getJsonStringFromFile(paramContext, paramString1);
      if (this.mIsSupportHotReload)
      {
        this.mPathMap.put(paramString1, paramComplementFileStringLoader);
        this.mTemplateBeanToStyleMap.put(paramString1, paramString3);
      }
      createViewTemplateFromFile(paramContext, paramBaseTemplateFactory, str, paramComplementFileStringLoader, paramString1, paramString2, paramString3);
      return;
    }
    catch (IOException paramContext)
    {
      Log.e("ProteusParserHotReload", "Fail to create view template from assets " + paramString1 + " " + paramContext.toString());
      return;
    }
    catch (JSONException paramContext)
    {
      Log.e("ProteusParserHotReload", "Json error: " + paramContext.toString());
    }
  }
  
  @Deprecated
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, String paramString, ComplementFileStringLoader paramComplementFileStringLoader)
    throws JSONException
  {
    super.createViewTemplate(paramBaseTemplateFactory, paramString, paramComplementFileStringLoader);
  }
  
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, String paramString1, ComplementFileStringLoader paramComplementFileStringLoader, String paramString2)
    throws JSONException
  {
    createViewTemplate(paramBaseTemplateFactory, new JSONObject(paramString1), paramComplementFileStringLoader, paramString2);
  }
  
  @Deprecated
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
    throws JSONException
  {
    super.createViewTemplate(paramBaseTemplateFactory, paramJSONObject, paramComplementFileStringLoader);
  }
  
  public void createViewTemplate(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader, String paramString)
    throws JSONException
  {
    parseAndCreateViewTemplate(paramBaseTemplateFactory, paramJSONObject, paramComplementFileStringLoader, "", "", paramString);
  }
  
  public void createViewTemplateFromFile(Context paramContext, BaseTemplateFactory paramBaseTemplateFactory, String paramString)
    throws JSONException, IOException
  {
    createViewTemplateFromFile(paramContext, paramBaseTemplateFactory, getJsonStringFromFile(paramContext, paramString), (ComplementFileStringLoader)this.mPathMap.get(paramString), paramString, paramString.substring(0, paramString.lastIndexOf("/")), (String)this.mTemplateBeanToStyleMap.get(paramString));
  }
  
  public void finishHotReload()
  {
    if (!this.mIsSupportHotReload) {}
    for (;;)
    {
      return;
      File[] arrayOfFile = new File(PROTEUS_DEBUG_FOLDER).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          arrayOfFile[i].deleteOnExit();
          i += 1;
        }
      }
    }
  }
  
  public String getJsonStringFromFile(Context paramContext, String paramString)
    throws IOException
  {
    if (!this.mIsSupportHotReload) {
      return readInputStreamAsString(paramContext.getAssets().open(paramString));
    }
    if ((paramContext == null) || (paramString == null)) {
      return "";
    }
    if ((this.mHotReloadMap != null) && (this.mHotReloadMap.containsKey(paramString)))
    {
      paramContext = (String)this.mHotReloadMap.get(paramString);
      return readInputStreamAsString(new FileInputStream(new File(PROTEUS_DEBUG_FOLDER + paramContext)));
    }
    return readInputStreamAsString(paramContext.getAssets().open(paramString));
  }
  
  public TemplateBean getTemplateBeanFromJson(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject)
    throws JSONException
  {
    if ((paramJSONObject == null) || (paramBaseTemplateFactory == null)) {
      return null;
    }
    String str = paramJSONObject.getString("style_ID");
    paramBaseTemplateFactory = paramBaseTemplateFactory.getTemplate(str);
    if (paramBaseTemplateFactory == null)
    {
      LogUtil.QLog.e("readinjoy.proteus", 2, "proteus error : there is not Template: " + str);
      return null;
    }
    paramBaseTemplateFactory.bindData(paramJSONObject);
    return paramBaseTemplateFactory;
  }
  
  public void initHotReload(Context paramContext)
  {
    this.mIsSupportHotReload = true;
    ProteusBroadCastReceiver localProteusBroadCastReceiver = new ProteusBroadCastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.proteus.ReloadBroadcast");
    paramContext.registerReceiver(localProteusBroadCastReceiver, localIntentFilter);
    paramContext = new File(PROTEUS_DEBUG_FOLDER);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    initHotReloadMap();
  }
  
  public boolean isSupportHotReload()
  {
    return this.mIsSupportHotReload;
  }
  
  @Deprecated
  public void parseDataMap(String paramString)
    throws JSONException
  {
    super.parseDataMap(paramString);
  }
  
  public void removeHotReloadChangedObserver(IHotReloadChangedObserver paramIHotReloadChangedObserver)
  {
    this.mHotReloadChangedObservers.remove(paramIHotReloadChangedObserver);
  }
  
  public static abstract interface IHotReloadChangedObserver
  {
    public abstract void onHotReloadChanged(Context paramContext, String paramString1, String paramString2);
  }
  
  class ProteusBroadCastReceiver
    extends BroadcastReceiver
  {
    ProteusBroadCastReceiver() {}
    
    private void getNewPathAndHotReload(Context paramContext, String paramString, ArrayList<String> paramArrayList)
    {
      Object localObject = paramString.replace("^#^", "/");
      ProteusParserWithHotReload.this.mHotReloadMap.put(localObject, paramString);
      if (((String)localObject).endsWith("style_map.geojson")) {}
      do
      {
        for (;;)
        {
          return;
          if (!ProteusParserWithHotReload.this.mComplementMap.containsKey(localObject)) {
            break;
          }
          localObject = ((ArrayList)ProteusParserWithHotReload.this.mComplementMap.get(localObject)).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (!paramArrayList.contains(str))
            {
              paramArrayList.add(str);
              try
              {
                hotReloadByFilePath(paramContext, str);
              }
              catch (JSONException localJSONException)
              {
                LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload json error: " + localJSONException.toString());
              }
              catch (IOException localIOException)
              {
                LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload file not found error: " + ProteusParserWithHotReload.PROTEUS_DEBUG_FOLDER + paramString);
              }
            }
          }
        }
      } while (paramArrayList.contains(localObject));
      paramArrayList.add(localObject);
      try
      {
        hotReloadByFilePath(paramContext, (String)localObject);
        return;
      }
      catch (JSONException paramContext)
      {
        LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload json error: " + paramContext.toString());
        return;
      }
      catch (IOException paramContext)
      {
        LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload file not found error: " + ProteusParserWithHotReload.PROTEUS_DEBUG_FOLDER + paramString);
      }
    }
    
    private void hotReloadByFilePath(Context paramContext, String paramString)
      throws JSONException, IOException
    {
      Object localObject = new JSONObject(ProteusParserWithHotReload.this.getJsonStringFromFile(paramContext, paramString));
      if (((JSONObject)localObject).keys().hasNext()) {}
      for (localObject = (String)((JSONObject)localObject).keys().next();; localObject = "")
      {
        int i = 0;
        while (i < ProteusParserWithHotReload.this.mHotReloadChangedObservers.size())
        {
          ((ProteusParserWithHotReload.IHotReloadChangedObserver)ProteusParserWithHotReload.this.mHotReloadChangedObservers.get(i)).onHotReloadChanged(paramContext, (String)localObject, paramString);
          i += 1;
        }
      }
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (!ProteusParserWithHotReload.this.mIsSupportHotReload) {}
      for (;;)
      {
        return;
        paramIntent = paramIntent.getStringExtra("file_path").split(";");
        ArrayList localArrayList = new ArrayList();
        int j = paramIntent.length;
        int i = 0;
        while (i < j)
        {
          getNewPathAndHotReload(paramContext, paramIntent[i], localArrayList);
          i += 1;
        }
      }
    }
  }
  
  static class SingletonInstance
  {
    private static final ProteusParserWithHotReload instance = new ProteusParserWithHotReload(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload
 * JD-Core Version:    0.7.0.1
 */