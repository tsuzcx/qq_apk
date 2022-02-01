package com.tencent.mobileqq.dinifly.model;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.Log;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.LottieResult;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.parser.LayerParser;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class FileCompositionLoader
  extends CompositionLoader<InputStream>
{
  private MQLruCache<String, Object> imageCache;
  private final OnCompositionLoadedListener loadedListener;
  private LottieDrawable lottieDrawable;
  private Bundle userData;
  
  public FileCompositionLoader(Resources paramResources, OnCompositionLoadedListener paramOnCompositionLoadedListener, Bundle paramBundle, LottieDrawable paramLottieDrawable, MQLruCache<String, Object> paramMQLruCache)
  {
    this.loadedListener = paramOnCompositionLoadedListener;
    this.userData = paramBundle;
    this.lottieDrawable = paramLottieDrawable;
    this.imageCache = paramMQLruCache;
  }
  
  protected LottieComposition doInBackground(InputStream... paramVarArgs)
  {
    try
    {
      paramVarArgs = (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(paramVarArgs[0], null).getValue();
      if ((this.userData != null) && (paramVarArgs != null) && (paramVarArgs.images != null))
      {
        String str1 = this.userData.getString("key");
        String str2 = this.userData.getString("path");
        Iterator localIterator = paramVarArgs.images.entrySet().iterator();
        Log.v("DiniFlyAnimationView", str2);
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          String str3 = str1 + ((Map.Entry)localObject).getKey();
          ((LottieImageAsset)((Map.Entry)localObject).getValue()).setKey(str3);
          localObject = str2 + ((LottieImageAsset)((Map.Entry)localObject).getValue()).getFileName();
          LottieImageAsset.decodeBitmapIntoCache(this.imageCache, str3, (String)localObject);
        }
      }
    }
    catch (AssertionError paramVarArgs)
    {
      for (;;)
      {
        if (this.userData != null) {
          Log.w("FileCompositionLoader", this.userData.getString("path"));
        }
        paramVarArgs.printStackTrace();
        paramVarArgs = null;
      }
      paramVarArgs.compositionLayer = new CompositionLayer(this.lottieDrawable, LayerParser.parse(paramVarArgs), paramVarArgs.getLayers(), paramVarArgs);
    }
    return paramVarArgs;
  }
  
  protected void onPostExecute(LottieComposition paramLottieComposition)
  {
    if ((this.loadedListener != null) && (paramLottieComposition != null)) {
      this.loadedListener.onCompositionLoaded(paramLottieComposition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.FileCompositionLoader
 * JD-Core Version:    0.7.0.1
 */