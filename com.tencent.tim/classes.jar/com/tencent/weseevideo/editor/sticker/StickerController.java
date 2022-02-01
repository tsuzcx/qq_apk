package com.tencent.weseevideo.editor.sticker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavcut.session.callback.StickerStateCallback;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavsticker.core.ITAVStickerContextObserver;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.weseevideo.editor.sticker.view.WsStickerContentView;
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.jetbrains.annotations.Nullable;

public class StickerController
  implements ITAVStickerContextObserver, VideoRenderChainManager.IStickerContextInterface, IStickerEventListener
{
  private static final String TAG = StickerController.class.getSimpleName();
  private Context ctx;
  private int dataChangedCount = 0;
  private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
  private Set<TAVStickerOperationMode> operations;
  private WsStickerContentView stickerContentView;
  private TAVStickerContext stickerContext;
  private StickerEditViewIconConfig stickerEditViewIconConfig;
  private StickerOperationCallback stickerOperationCallback;
  private StickerStateCallback stickerStateCallback;
  
  public StickerController(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StickerController(Context paramContext, @Nullable StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    this.ctx = paramContext;
    this.stickerEditViewIconConfig = paramStickerEditViewIconConfig;
    this.stickerContentView = new WsStickerContentView(paramContext);
    init();
  }
  
  private Pair<Float, Float> calcStickerCenterPosition(float paramFloat1, float paramFloat2)
  {
    Pair localPair = new Pair(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
    if ((this.stickerContext == null) || (this.stickerContext.getStickers() == null)) {
      localObject = localPair;
    }
    Iterator localIterator;
    do
    {
      return localObject;
      localIterator = this.stickerContext.getStickers().iterator();
      localObject = localPair;
    } while (!localIterator.hasNext());
    Object localObject = (TAVSticker)localIterator.next();
    if ((Math.abs(((TAVSticker)localObject).getCenterX() - ((Float)localPair.first).floatValue()) < 0.01F) && (Math.abs(((TAVSticker)localObject).getCenterY() - ((Float)localPair.second).floatValue()) < 0.01F)) {
      localPair = new Pair(Float.valueOf(((Float)localPair.first).floatValue() + 0.02F), Float.valueOf(((Float)localPair.second).floatValue() + 0.02F));
    }
    for (;;)
    {
      break;
    }
  }
  
  private void configure(TAVStickerContext paramTAVStickerContext)
  {
    paramTAVStickerContext.setTavStickerContentView(this.stickerContentView);
    paramTAVStickerContext.setTavStickerContextDataSource(new StickerController.1(this));
    paramTAVStickerContext.setOnTouchStickerOutsideListener(new StickerController.2(this, paramTAVStickerContext));
    paramTAVStickerContext.registerObserver(this);
  }
  
  private void deleteSticker(TAVStickerContext paramTAVStickerContext, TAVSticker paramTAVSticker)
  {
    if (paramTAVStickerContext == null) {
      return;
    }
    paramTAVStickerContext.removeSticker(paramTAVSticker);
  }
  
  private void init()
  {
    this.operations = new HashSet();
    this.operations.add(TAVStickerOperationMode.OP_DRAG);
    this.operations.add(TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE);
    this.operations.add(TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE);
    StickerEventDispatcher.getInstance().addStickerEventListener(this);
  }
  
  public void addSticker(TAVSticker paramTAVSticker)
  {
    if (this.stickerContext == null) {
      return;
    }
    Pair localPair = calcStickerCenterPosition(paramTAVSticker.getCenterX(), paramTAVSticker.getCenterY());
    paramTAVSticker.setCenterX(((Float)localPair.first).floatValue());
    paramTAVSticker.setCenterY(((Float)localPair.second).floatValue());
    HandlerUtils.getMainHandler().post(new StickerController.3(this, paramTAVSticker));
  }
  
  public void alignStickers(long paramLong) {}
  
  public TAVStickerContext createStickerContext()
  {
    if (this.stickerContext != null) {
      return this.stickerContext;
    }
    TAVStickerContext localTAVStickerContext = new TAVStickerContext(this.ctx);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      configure(localTAVStickerContext);
      this.stickerContext = localTAVStickerContext;
      return localTAVStickerContext;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    HandlerUtils.getMainHandler().post(new StickerController.4(this, localTAVStickerContext, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
      return localTAVStickerContext;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return localTAVStickerContext;
    }
    finally
    {
      localCountDownLatch.countDown();
    }
  }
  
  public void destroy()
  {
    releaseStickerContext();
    StickerEventDispatcher.getInstance().removeStickerEventListener(this);
  }
  
  public TAVSticker getCurrentSticker()
  {
    return this.stickerContext.getCurrentSticker();
  }
  
  public TAVStickerContext getStickerContext()
  {
    return this.stickerContext;
  }
  
  public void onCurrentStickerStateChanged(TAVStickerContext paramTAVStickerContext, boolean paramBoolean)
  {
    TLog.d(TAG, "onCurrentStickerStateChanged -> isActive : $isActive");
  }
  
  public void onStickerActive(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerActive");
    if (this.stickerStateCallback != null) {
      this.stickerStateCallback.onStickerActive();
    }
  }
  
  public void onStickerAdd(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerAdd");
    if (this.stickerStateCallback != null) {
      this.stickerStateCallback.onStickerAdd(paramTAVStickerContext, paramTAVStickerEditView);
    }
  }
  
  public void onStickerDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    TLog.d(TAG, "onStickerDataChanged -> operationMode : $operationMode, centerX : $centerX, cneterY : $centerY, scale : $scale, rotate : $rotate");
    if ((this.dataChangedCount == 0) && (this.operations.contains(paramTAVStickerOperationMode)))
    {
      HandlerUtils.getMainHandler().postDelayed(new StickerController.5(this), 10L);
      this.dataChangedCount += 1;
    }
    this.operationMode = paramTAVStickerOperationMode;
  }
  
  public void onStickerListChanged(TAVStickerContext paramTAVStickerContext)
  {
    TLog.d(TAG, "onStickerListChanged");
  }
  
  public void onStickerRemove(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerRemove");
  }
  
  public void onStickerResign(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView)
  {
    TLog.d(TAG, "onStickerResign");
  }
  
  public void onStickerStatusChanged(TAVSticker paramTAVSticker, boolean paramBoolean1, boolean paramBoolean2)
  {
    TLog.d(TAG, "onStickerStatusChanged");
    if ((!paramBoolean1) && (this.dataChangedCount > 0) && (this.operations.contains(this.operationMode)) && (this.stickerStateCallback != null)) {
      this.stickerStateCallback.onStatusChanged(false);
    }
    this.dataChangedCount = 0;
  }
  
  public void releaseStickerContext()
  {
    if (this.stickerContext != null)
    {
      this.stickerContext.unRegisterObserver(this);
      this.stickerContext.release();
    }
    this.stickerContext = null;
  }
  
  public void resignCurrentSticker()
  {
    if (this.stickerContext != null) {
      this.stickerContext.resignCurrentSticker();
    }
  }
  
  public void restoreSticker(List<StickerModel> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StickerModel localStickerModel = (StickerModel)paramList.next();
      if (this.stickerContext != null) {
        this.stickerContext.loadSticker(StickerUtil.stickerModel2TavSticker(localStickerModel), false);
      }
    }
  }
  
  public void setStickerContainer(ViewGroup paramViewGroup)
  {
    paramViewGroup.removeView(this.stickerContentView);
    if (this.stickerContext != null) {
      this.stickerContext.setStickerContainer(paramViewGroup);
    }
  }
  
  public void setStickerOperationCallback(StickerOperationCallback paramStickerOperationCallback)
  {
    this.stickerOperationCallback = paramStickerOperationCallback;
  }
  
  public void setStickerStateCallback(StickerStateCallback paramStickerStateCallback)
  {
    this.stickerStateCallback = paramStickerStateCallback;
  }
  
  public TAVSticker updateTextSticker(TextEditorData paramTextEditorData)
  {
    Object localObject1;
    try
    {
      localObject1 = this.stickerContext.getStickers().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (TAVSticker)((Iterator)localObject1).next();
        if (((TAVSticker)localObject2).getStickerId().equals(paramTextEditorData.getStickerId()))
        {
          this.stickerContext.removeSticker((TAVSticker)localObject2);
          localObject1 = new TAVSticker();
          ((TAVSticker)localObject1).setStickerId(paramTextEditorData.getStickerId());
          ((TAVSticker)localObject1).setFilePath(((TAVSticker)localObject2).getFilePath());
          ((TAVSticker)localObject1).setAssetFilePath(((TAVSticker)localObject2).getAssetFilePath());
          ((TAVSticker)localObject1).setLayerIndex(((TAVSticker)localObject2).getLayerIndex());
          ((TAVSticker)localObject1).setScale(((TAVSticker)localObject2).getScale());
          ((TAVSticker)localObject1).setRotate(((TAVSticker)localObject2).getRotate());
          ((TAVSticker)localObject1).setCenterX(((TAVSticker)localObject2).getCenterX());
          ((TAVSticker)localObject1).setCenterY(((TAVSticker)localObject2).getCenterY());
          ((TAVSticker)localObject1).setEditable(((TAVSticker)localObject2).isEditable());
          ((TAVSticker)localObject1).setMinScale(((TAVSticker)localObject2).getMinScale());
          ((TAVSticker)localObject1).setMaxScale(((TAVSticker)localObject2).getMaxScale());
          ((TAVSticker)localObject1).setTimeRange(((TAVSticker)localObject2).getTimeRange());
          localObject2 = ((TAVSticker)localObject2).getStickerTextItems().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)((Iterator)localObject2).next();
            ((TAVSticker)localObject1).getStickerTextItems().add(localTAVStickerTextItem);
          }
        }
      }
      return null;
    }
    catch (StickerInitializationException paramTextEditorData)
    {
      Logger.e(paramTextEditorData);
    }
    if (!((TAVSticker)localObject1).getStickerTextItems().isEmpty())
    {
      ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(0)).setText(paramTextEditorData.getContent());
      ((TAVStickerTextItem)((TAVSticker)localObject1).getStickerTextItems().get(0)).setTextColor(paramTextEditorData.getTextColor());
    }
    ((TAVSticker)localObject1).init();
    this.stickerContext.loadSticker((TAVSticker)localObject1);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController
 * JD-Core Version:    0.7.0.1
 */