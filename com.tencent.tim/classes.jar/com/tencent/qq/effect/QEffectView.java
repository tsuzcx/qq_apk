package com.tencent.qq.effect;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qq.effect.engine.Layout;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.engine.QEffectEngine;
import com.tencent.qq.effect.engine.QEffectEngine.JsonConvert;
import com.tencent.qq.effect.engine.QEffectProto;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class QEffectView
  extends FrameLayout
{
  private String TAG = "QEffectView";
  private Context mContext;
  private String mDefImg;
  private IQEffect mIQEffect;
  private SparseArray<WeakReference<IQEffect>> mIQEffectViewMap;
  private SparseArray<Object> mOptions = new SparseArray();
  private String mSrc;
  
  public QEffectView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public QEffectView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public QEffectView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  private void loadEffectViews(List<QEffectData> paramList)
  {
    if (this.mIQEffectViewMap == null) {
      this.mIQEffectViewMap = new SparseArray();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QEffectData localQEffectData = (QEffectData)paramList.next();
      if ((localQEffectData.support == 0) || (localQEffectData.support == 109))
      {
        IQEffect localIQEffect = QEffectEngine.getInstance().getEffectView(this.mContext, localQEffectData.type);
        if (!(localIQEffect instanceof View))
        {
          Log.e(this.TAG, " effect is null, module mame is png, src:" + localQEffectData.src);
        }
        else
        {
          FrameLayout.LayoutParams localLayoutParams = Layout.getLayoutParams(getContext(), localQEffectData, getWidth(), getHeight());
          ((View)localIQEffect).setId(localQEffectData.effectId);
          addView((View)localIQEffect, localLayoutParams);
          if (this.mIQEffectViewMap.get(localQEffectData.effectId) != null) {
            Log.e(this.TAG, " ID duplicate, please check ID:" + localQEffectData.effectId);
          }
          this.mIQEffectViewMap.put(localQEffectData.effectId, new WeakReference(localIQEffect));
          QEffectEngine.getInstance().load(this.mContext, this, localIQEffect, localQEffectData);
          QEffectEngine.getInstance().onAttachedToWindow(localIQEffect);
        }
      }
    }
  }
  
  public void clear()
  {
    this.mSrc = null;
    if (this.mIQEffect != null)
    {
      QEffectEngine.getInstance().onDetachedFromWindow(this.mIQEffect);
      removeView((View)this.mIQEffect);
      ((View)this.mIQEffect).destroyDrawingCache();
    }
    if (this.mIQEffectViewMap != null)
    {
      int i = 0;
      while (i < this.mIQEffectViewMap.size())
      {
        WeakReference localWeakReference = (WeakReference)this.mIQEffectViewMap.valueAt(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          ((IQEffect)localWeakReference.get()).stop();
          ((View)localWeakReference.get()).setBackgroundResource(0);
          removeView((View)localWeakReference.get());
          QEffectEngine.getInstance().onDetachedFromWindow((IQEffect)localWeakReference.get());
        }
        i += 1;
      }
      this.mIQEffectViewMap.clear();
    }
    removeAllViews();
  }
  
  public IQEffect findById(int paramInt)
  {
    WeakReference localWeakReference = (WeakReference)this.mIQEffectViewMap.get(paramInt);
    if (localWeakReference != null) {
      return (IQEffect)localWeakReference.get();
    }
    return null;
  }
  
  public Object getExtOptions(int paramInt)
  {
    return this.mOptions.get(paramInt);
  }
  
  public IQEffect getQEffectImpl()
  {
    return this.mIQEffect;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mOptions.clear();
    clear();
  }
  
  public void pause()
  {
    QEffectEngine.getInstance().getGravitySensor().pause();
    if (this.mIQEffect != null) {
      this.mIQEffect.pause();
    }
    if (this.mIQEffectViewMap != null)
    {
      int i = 0;
      while (i < this.mIQEffectViewMap.size())
      {
        WeakReference localWeakReference = (WeakReference)this.mIQEffectViewMap.valueAt(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((IQEffect)localWeakReference.get()).pause();
        }
        i += 1;
      }
    }
  }
  
  public void resume()
  {
    QEffectEngine.getInstance().getGravitySensor().resume();
    if (this.mIQEffect != null) {
      this.mIQEffect.resume();
    }
    if (this.mIQEffectViewMap != null)
    {
      int i = 0;
      while (i < this.mIQEffectViewMap.size())
      {
        WeakReference localWeakReference = (WeakReference)this.mIQEffectViewMap.valueAt(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((IQEffect)localWeakReference.get()).resume();
        }
        i += 1;
      }
    }
  }
  
  public void setExtOptions(int paramInt, Object paramObject)
  {
    this.mOptions.put(paramInt, paramObject);
  }
  
  public void setSrc(int paramInt)
  {
    setSrc(paramInt, null);
  }
  
  public void setSrc(int paramInt, String paramString)
  {
    setSrc(Integer.valueOf(paramInt), QEffectEngine.getInstance().getFileType(paramString), 3);
  }
  
  public void setSrc(QEffectData paramQEffectData)
  {
    clear();
    this.mIQEffect = QEffectEngine.getInstance().getEffectView(this.mContext, paramQEffectData.type);
    if (!(this.mIQEffect instanceof View)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = Layout.getLayoutParams(getContext(), paramQEffectData, getWidth(), getHeight());
    addView((View)this.mIQEffect, localLayoutParams);
    new DataLoadTask().execute(new QEffectData[] { paramQEffectData });
  }
  
  public void setSrc(Object paramObject, int paramInt1, int paramInt2)
  {
    clear();
    if ((paramInt1 == 6) && ((paramObject instanceof String)))
    {
      new QEFileAsyncTask().execute(new String[] { (String)paramObject });
      return;
    }
    if (QEffectEngine.getInstance() == null)
    {
      Log.e(this.TAG, " setSrc engine is null");
      return;
    }
    if (this.mIQEffect != null)
    {
      removeView((View)this.mIQEffect);
      this.mIQEffect = null;
    }
    this.mIQEffect = QEffectEngine.getInstance().getEffectView(this.mContext, paramInt1);
    if (!(this.mIQEffect instanceof View))
    {
      Log.e(this.TAG, " effect is null, module mame is png, src:" + paramObject);
      return;
    }
    QEffectData localQEffectData = new QEffectData();
    localQEffectData.type = paramInt1;
    localQEffectData.resType = paramInt2;
    localQEffectData.h = -1.0F;
    localQEffectData.w = -1.0F;
    if ((paramInt2 == 3) && ((paramObject instanceof Integer))) {
      localQEffectData.resId = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      setSrc(localQEffectData);
      return;
      localQEffectData.src = ((String)paramObject);
    }
  }
  
  public void setSrc(String paramString)
  {
    setSrc(paramString, null);
  }
  
  public void setSrc(String paramString1, String paramString2)
  {
    if (paramString1.equals(this.mSrc))
    {
      Log.e(this.TAG, " src重复设置，这次不会生效:" + paramString1);
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = QEffectUtils.getFileType(paramString1);
    }
    if (str == null)
    {
      Log.e(this.TAG, " setSrc fileType is null src:" + paramString1);
      return;
    }
    int i = QEffectUtils.getFileLoadType(paramString1);
    setSrc(paramString1, QEffectEngine.getInstance().getFileType(str), i);
    this.mSrc = paramString1;
  }
  
  class DataLoadTask
    extends AsyncTask<QEffectData, Void, QEffectData>
  {
    DataLoadTask() {}
    
    protected QEffectData doInBackground(QEffectData... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      if (paramVarArgs.resType == 1)
      {
        if (!new File(paramVarArgs.src).exists())
        {
          paramVarArgs.src = null;
          return null;
        }
        if (paramVarArgs.type != 3) {
          break label55;
        }
        BaseQEffectLoad.analyzeLottieData(paramVarArgs, paramVarArgs.src);
      }
      for (;;)
      {
        return paramVarArgs;
        label55:
        if (paramVarArgs.type == 7) {
          BaseQEffectLoad.analyzeGLSLData(paramVarArgs, paramVarArgs.src, paramVarArgs.src);
        }
      }
    }
    
    protected void onPostExecute(QEffectData paramQEffectData)
    {
      if (paramQEffectData != null)
      {
        QEffectEngine.getInstance().load(QEffectView.this.mContext, QEffectView.this, QEffectView.this.mIQEffect, paramQEffectData);
        QEffectEngine.getInstance().onAttachedToWindow(QEffectView.this.mIQEffect);
      }
    }
  }
  
  class QEFileAsyncTask
    extends AsyncTask<String, Void, List<QEffectData>>
  {
    QEFileAsyncTask() {}
    
    protected List<QEffectData> doInBackground(String... paramVarArgs)
    {
      Object localObject1 = paramVarArgs[0];
      Object localObject2 = new File((String)localObject1);
      paramVarArgs = QEffectEngine.getInstance().getCacheFileDir(QEffectView.this.mContext);
      label387:
      label414:
      label444:
      for (;;)
      {
        QEffectData localQEffectData;
        String str;
        try
        {
          if (!((File)localObject2).exists()) {
            return null;
          }
          if (((File)localObject2).isDirectory())
          {
            localObject2 = (String)localObject1 + "/main.json";
            paramVarArgs = (String[])localObject1;
            localObject1 = localObject2;
            localObject1 = QEffectUtils.readFile((String)localObject1);
            localObject2 = QEffectEngine.getInstance().getJsonConvert();
            if (localObject2 == null) {
              return null;
            }
          }
          else
          {
            if ((((File)localObject2).isFile()) && (((File)localObject2).getName().equals("main.json")))
            {
              paramVarArgs = ((File)localObject2).getAbsolutePath().replace("/main.json", "");
              continue;
            }
            paramVarArgs = paramVarArgs + "/" + ((File)localObject2).getName();
            localObject1 = new File(paramVarArgs);
            if (!((File)localObject1).exists()) {
              ((File)localObject1).mkdir();
            }
            QEffectUtils.upZipFile((File)localObject2, paramVarArgs);
            localObject1 = paramVarArgs + "/main.json";
            continue;
          }
          localObject1 = (QEffectProto)((QEffectEngine.JsonConvert)localObject2).parseObject((String)localObject1, QEffectProto.class);
          if ((((QEffectProto)localObject1).minVer < 1) || (((QEffectProto)localObject1).eles == null) || (((QEffectProto)localObject1).eles.size() == 0))
          {
            QEffectView.access$102(QEffectView.this, paramVarArgs + "/" + ((QEffectProto)localObject1).defImg);
            return null;
          }
          localObject2 = ((QEffectProto)localObject1).eles.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localQEffectData = (QEffectData)((Iterator)localObject2).next();
          if (localQEffectData.resType != 1) {
            break label387;
          }
          str = paramVarArgs + "/" + localQEffectData.src;
          if (!new File(str).exists())
          {
            localQEffectData.src = null;
            continue;
          }
          if (localQEffectData.type != 3) {
            break label414;
          }
        }
        catch (IOException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          return null;
        }
        BaseQEffectLoad.analyzeLottieData(localQEffectData, str);
        for (;;)
        {
          if (!localQEffectData.gravity) {
            break label444;
          }
          QEffectEngine.getInstance().getGravitySensor().init(QEffectView.this.mContext);
          break;
          if (localQEffectData.type == 7) {
            BaseQEffectLoad.analyzeGLSLData(localQEffectData, paramVarArgs, str);
          } else {
            localQEffectData.src = str;
          }
        }
      }
      return ((QEffectProto)localObject1).eles;
    }
    
    protected void onPostExecute(List<QEffectData> paramList)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        QEffectView.this.loadEffectViews(paramList);
      }
      while (QEffectView.this.mDefImg == null) {
        return;
      }
      QEffectView.this.setSrc(QEffectView.this.mDefImg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.QEffectView
 * JD-Core Version:    0.7.0.1
 */