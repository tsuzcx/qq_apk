package com.tencent.mobileqq.dinifly;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.WorkerThread;
import android.support.v4.util.MQLruCache;
import android.support.v4.util.SparseArrayCompat;
import android.util.JsonReader;
import android.util.Log;
import android.util.LongSparseArray;
import com.tencent.mobileqq.dinifly.model.FileCompositionLoader;
import com.tencent.mobileqq.dinifly.model.Font;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.JsonCompositionLoader;
import com.tencent.mobileqq.dinifly.model.Marker;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.model.layer.Layer;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class LottieComposition
{
  private Rect bounds;
  private SparseArrayCompat<FontCharacter> characters;
  public CompositionLayer compositionLayer;
  private float endFrame;
  private Map<String, Font> fonts;
  private float frameRate;
  private boolean hasDashPattern;
  public Map<String, LottieImageAsset> images;
  public LayerInfo layerInfo = new LayerInfo();
  private LongSparseArray<Layer> layerMap;
  private List<Layer> layers;
  private List<Marker> markers;
  private int maskAndMatteCount = 0;
  private final PerformanceTracker performanceTracker = new PerformanceTracker();
  private Map<String, List<Layer>> precomps;
  private float startFrame;
  private final HashSet<String> warnings = new HashSet();
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void addWarning(String paramString)
  {
    Log.w("LOTTIE", paramString);
    this.warnings.add(paramString);
  }
  
  public Rect getBounds()
  {
    return this.bounds;
  }
  
  public SparseArrayCompat<FontCharacter> getCharacters()
  {
    return this.characters;
  }
  
  public long getDuration()
  {
    return (getDurationFrames() / this.frameRate * 1000.0F);
  }
  
  public float getDurationFrames()
  {
    return this.endFrame - this.startFrame;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public float getEndFrame()
  {
    return this.endFrame;
  }
  
  public Map<String, Font> getFonts()
  {
    return this.fonts;
  }
  
  public float getFrameRate()
  {
    return this.frameRate;
  }
  
  public Map<String, LottieImageAsset> getImages()
  {
    return this.images;
  }
  
  public List<Layer> getLayers()
  {
    return this.layers;
  }
  
  @Nullable
  public Marker getMarker(String paramString)
  {
    this.markers.size();
    int i = 0;
    while (i < this.markers.size())
    {
      Marker localMarker = (Marker)this.markers.get(i);
      if (localMarker.matchesName(paramString)) {
        return localMarker;
      }
      i += 1;
    }
    return null;
  }
  
  public List<Marker> getMarkers()
  {
    return this.markers;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public int getMaskAndMatteCount()
  {
    return this.maskAndMatteCount;
  }
  
  public PerformanceTracker getPerformanceTracker()
  {
    return this.performanceTracker;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public List<Layer> getPrecomps(String paramString)
  {
    return (List)this.precomps.get(paramString);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public float getStartFrame()
  {
    return this.startFrame;
  }
  
  public ArrayList<String> getWarnings()
  {
    return new ArrayList(Arrays.asList(this.warnings.toArray(new String[this.warnings.size()])));
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public boolean hasDashPattern()
  {
    return this.hasDashPattern;
  }
  
  public boolean hasImages()
  {
    return !this.images.isEmpty();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void incrementMatteOrMaskCount(int paramInt)
  {
    this.maskAndMatteCount += paramInt;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void init(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray, Map<String, List<Layer>> paramMap, Map<String, LottieImageAsset> paramMap1, SparseArrayCompat<FontCharacter> paramSparseArrayCompat, Map<String, Font> paramMap2, List<Marker> paramList1)
  {
    this.bounds = paramRect;
    this.startFrame = paramFloat1;
    this.endFrame = paramFloat2;
    this.frameRate = paramFloat3;
    this.layers = paramList;
    this.layerMap = paramLongSparseArray;
    this.precomps = paramMap;
    this.images = paramMap1;
    this.characters = paramSparseArrayCompat;
    this.fonts = paramMap2;
    this.markers = paramList1;
  }
  
  @RequiresApi(api=16)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public Layer layerModelForId(long paramLong)
  {
    return (Layer)this.layerMap.get(paramLong);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void setHasDashPattern(boolean paramBoolean)
  {
    this.hasDashPattern = paramBoolean;
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.performanceTracker.setEnabled(paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LottieComposition:\n");
    Iterator localIterator = this.layers.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Layer)localIterator.next()).toString("\t"));
    }
    return localStringBuilder.toString();
  }
  
  class BitmapLoaderAsyncTask
    extends AsyncTask<InputStream, Void, LottieComposition>
  {
    BitmapLoaderAsyncTask() {}
    
    protected LottieComposition doInBackground(InputStream... paramVarArgs)
    {
      return null;
    }
    
    protected void onPostExecute(LottieComposition paramLottieComposition) {}
  }
  
  @Deprecated
  public static class Factory
  {
    public static final String KEY_CACHE_PREFIX = "key";
    public static final String KEY_PATH_PREFIX = "path";
    
    @Deprecated
    public static Cancellable fromAssetFileName(Context paramContext, String paramString, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      paramOnCompositionLoadedListener = new ListenerAdapter(paramOnCompositionLoadedListener);
      LottieCompositionFactory.fromAsset(paramContext, paramString).addListener(paramOnCompositionLoadedListener);
      return paramOnCompositionLoadedListener;
    }
    
    @Deprecated
    @Nullable
    @WorkerThread
    public static LottieComposition fromFileSync(Context paramContext, String paramString)
    {
      return (LottieComposition)LottieCompositionFactory.fromAssetSync(paramContext, paramString).getValue();
    }
    
    @Deprecated
    public static Cancellable fromInputStream(Context paramContext, InputStream paramInputStream, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      paramContext = new ListenerAdapter(paramOnCompositionLoadedListener);
      LottieCompositionFactory.fromJsonInputStream(paramInputStream, null).addListener(paramContext);
      return paramContext;
    }
    
    @Deprecated
    @Nullable
    @WorkerThread
    public static LottieComposition fromInputStreamSync(InputStream paramInputStream)
    {
      return (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(paramInputStream, null).getValue();
    }
    
    @Deprecated
    @Nullable
    @WorkerThread
    public static LottieComposition fromInputStreamSync(InputStream paramInputStream, boolean paramBoolean)
    {
      if (paramBoolean) {
        Log.w("LOTTIE", "Lottie now auto-closes input stream!");
      }
      return (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(paramInputStream, null).getValue();
    }
    
    public static Cancellable fromInputStreamWithCacheBitmap(Context paramContext, InputStream paramInputStream, LottieDrawable paramLottieDrawable, OnCompositionLoadedListener paramOnCompositionLoadedListener, Bundle paramBundle, MQLruCache<String, Object> paramMQLruCache)
    {
      paramContext = new FileCompositionLoader(paramContext.getResources(), paramOnCompositionLoadedListener, paramBundle, paramLottieDrawable, paramMQLruCache);
      paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[] { paramInputStream });
      return paramContext;
    }
    
    public static Cancellable fromJson(Resources paramResources, JSONObject paramJSONObject, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      paramResources = new JsonCompositionLoader(paramResources, paramOnCompositionLoadedListener);
      paramResources.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
      return paramResources;
    }
    
    @Deprecated
    public static Cancellable fromJsonReader(JsonReader paramJsonReader, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      paramOnCompositionLoadedListener = new ListenerAdapter(paramOnCompositionLoadedListener);
      LottieCompositionFactory.fromJsonReader(paramJsonReader, null).addListener(paramOnCompositionLoadedListener);
      return paramOnCompositionLoadedListener;
    }
    
    @Deprecated
    public static Cancellable fromJsonString(String paramString, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      paramOnCompositionLoadedListener = new ListenerAdapter(paramOnCompositionLoadedListener);
      LottieCompositionFactory.fromJsonString(paramString, null).addListener(paramOnCompositionLoadedListener);
      return paramOnCompositionLoadedListener;
    }
    
    @Deprecated
    @Nullable
    @WorkerThread
    public static LottieComposition fromJsonSync(Resources paramResources, JSONObject paramJSONObject)
    {
      return (LottieComposition)LottieCompositionFactory.fromJsonSync(paramJSONObject, null).getValue();
    }
    
    @Deprecated
    @Nullable
    @WorkerThread
    public static LottieComposition fromJsonSync(JsonReader paramJsonReader)
      throws IOException
    {
      return (LottieComposition)LottieCompositionFactory.fromJsonReaderSync(paramJsonReader, null).getValue();
    }
    
    @Deprecated
    @Nullable
    @WorkerThread
    public static LottieComposition fromJsonSync(String paramString)
    {
      return (LottieComposition)LottieCompositionFactory.fromJsonStringSync(paramString, null).getValue();
    }
    
    @Deprecated
    public static Cancellable fromRawFile(Context paramContext, @RawRes int paramInt, OnCompositionLoadedListener paramOnCompositionLoadedListener)
    {
      paramOnCompositionLoadedListener = new ListenerAdapter(paramOnCompositionLoadedListener);
      LottieCompositionFactory.fromRawRes(paramContext, paramInt).addListener(paramOnCompositionLoadedListener);
      return paramOnCompositionLoadedListener;
    }
    
    public static final class ListenerAdapter
      implements Cancellable, LottieListener<LottieComposition>
    {
      private boolean cancelled = false;
      private final OnCompositionLoadedListener listener;
      
      public ListenerAdapter(OnCompositionLoadedListener paramOnCompositionLoadedListener)
      {
        this.listener = paramOnCompositionLoadedListener;
      }
      
      public void cancel()
      {
        this.cancelled = true;
      }
      
      public void onResult(LottieComposition paramLottieComposition)
      {
        if (this.cancelled) {
          return;
        }
        this.listener.onCompositionLoaded(paramLottieComposition);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieComposition
 * JD-Core Version:    0.7.0.1
 */