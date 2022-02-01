package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.filter.MultiViewerFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTHairAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StickersMap
{
  private static final String TAG = "StickersMap";
  public List<String> mStickerChain;
  private List<String> mStickerOrderList = new ArrayList();
  
  public StickersMap()
  {
    setDefaultOrder();
  }
  
  private void setDefaultOrder()
  {
    this.mStickerOrderList.clear();
    this.mStickerOrderList.add("blurEffectBefore");
    this.mStickerOrderList.add("mesh");
    this.mStickerOrderList.add("fabbyStroke");
    this.mStickerOrderList.add("particle");
    this.mStickerOrderList.add("faceHeadCrop");
    this.mStickerOrderList.add("background");
    this.mStickerOrderList.add("lutBefore");
    this.mStickerOrderList.add("hairCos");
    this.mStickerOrderList.add("skySegment");
    this.mStickerOrderList.add("triggerLutBefore");
    this.mStickerOrderList.add("comicBefore");
    this.mStickerOrderList.add("styleFilterBefore");
    this.mStickerOrderList.add("stickerBefore");
    this.mStickerOrderList.add("blingbling");
    this.mStickerOrderList.add("3d");
    this.mStickerOrderList.add("filament");
    this.mStickerOrderList.add("styleChange");
    this.mStickerOrderList.add("customBefore");
    this.mStickerOrderList.add("dynamic");
    this.mStickerOrderList.add("faceSwap");
    this.mStickerOrderList.add("faceAverage");
    this.mStickerOrderList.add("phantom");
    this.mStickerOrderList.add("tdParticle");
    this.mStickerOrderList.add("comicAfter");
    this.mStickerOrderList.add("styleFilterAfter");
    this.mStickerOrderList.add("triggerLutAfter");
    this.mStickerOrderList.add("multiview");
    this.mStickerOrderList.add("filamentParticle");
    this.mStickerOrderList.add("stickerAfter");
    this.mStickerOrderList.add("customAfter");
    this.mStickerOrderList.add("lutAfter");
    this.mStickerOrderList.add("expression");
    this.mStickerOrderList.add("zoom");
    this.mStickerOrderList.add("mv");
    this.mStickerOrderList.add("blurEffectAfter");
    this.mStickerOrderList.add("mask");
    this.mStickerOrderList.add("crazyFace");
  }
  
  public Frame chainStickerFilters(AESticker paramAESticker, Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    paramAESticker.setAIAttr(paramAIAttr);
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    List localList3 = paramPTFaceAttr.getStarPoints();
    Object localObject1 = paramPTFaceAttr.getFaceActionCounter();
    int j = paramPTFaceAttr.getRotation();
    int i = paramPTFaceAttr.getRotation();
    long l = paramAESticker.getUpdateTimeStamp(paramPTFaceAttr.getTimeStamp());
    paramPTFaceAttr.setTimeStamp(l);
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    if (paramAIAttr != null)
    {
      localObject2 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (localObject2 != null)
      {
        localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
        if (localObject2 == null) {}
      }
    }
    for (Object localObject2 = ((PTHandAttr)localObject2).getHandPointList();; localObject2 = null)
    {
      Object localObject3 = new PTDetectInfo.Builder().aiAttr(paramAIAttr).triggeredExpression(localSet).handPoints((List)localObject2).faceActionCounter((Map)localObject1).handActionCounter(AIActionCounter.getActions(AEDetectorType.HAND)).faceDetector(paramPTFaceAttr.getFaceDetector()).starPoints(localList3).phoneAngle((i + 360) % 360).timestamp(l);
      localObject1 = localObject3;
      if (localList1 != null)
      {
        localObject1 = localObject3;
        if (localList1.size() > 0) {
          localObject1 = ((PTDetectInfo.Builder)localObject3).facePoints((List)localList1.get(0));
        }
      }
      if ((localList2 != null) && (localList2.size() > 0)) {
        localObject1 = ((PTDetectInfo.Builder)localObject1).faceAngles((float[])localList2.get(0));
      }
      for (;;)
      {
        localObject3 = ((PTDetectInfo.Builder)localObject1).build();
        TouchTriggerManager.getInstance().updateTouchTriggerState((PTDetectInfo)localObject3);
        TriggerStateManager.getInstance().setPTDetectInfo((PTDetectInfo)localObject3);
        TriggerStateManager.getInstance().updateAllTriggerState();
        HashMap localHashMap = new HashMap();
        if (paramAESticker == null) {
          return paramFrame;
        }
        Iterator localIterator = this.mStickerOrderList.iterator();
        localObject1 = paramFrame;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          switch (str.hashCode())
          {
          default: 
            label628:
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              break;
            case 0: 
              localObject1 = paramAESticker.renderBlurBefore((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
              break;
              if (!str.equals("blurEffectBefore")) {
                break label628;
              }
              i = 0;
              continue;
              if (!str.equals("mesh")) {
                break label628;
              }
              i = 1;
              continue;
              if (!str.equals("fabbyStroke")) {
                break label628;
              }
              i = 2;
              continue;
              if (!str.equals("particle")) {
                break label628;
              }
              i = 3;
              continue;
              if (!str.equals("faceHeadCrop")) {
                break label628;
              }
              i = 4;
              continue;
              if (!str.equals("background")) {
                break label628;
              }
              i = 5;
              continue;
              if (!str.equals("lutBefore")) {
                break label628;
              }
              i = 6;
              continue;
              if (!str.equals("hairCos")) {
                break label628;
              }
              i = 7;
              continue;
              if (!str.equals("skySegment")) {
                break label628;
              }
              i = 8;
              continue;
              if (!str.equals("comicBefore")) {
                break label628;
              }
              i = 9;
              continue;
              if (!str.equals("styleFilterBefore")) {
                break label628;
              }
              i = 10;
              continue;
              if (!str.equals("styleFilterAfter")) {
                break label628;
              }
              i = 11;
              continue;
              if (!str.equals("triggerLutBefore")) {
                break label628;
              }
              i = 12;
              continue;
              if (!str.equals("stickerBefore")) {
                break label628;
              }
              i = 13;
              continue;
              if (!str.equals("blingbling")) {
                break label628;
              }
              i = 14;
              continue;
              if (!str.equals("filament")) {
                break label628;
              }
              i = 15;
              continue;
              if (!str.equals("styleChange")) {
                break label628;
              }
              i = 16;
              continue;
              if (!str.equals("styleChild")) {
                break label628;
              }
              i = 17;
              continue;
              if (!str.equals("dynamic")) {
                break label628;
              }
              i = 18;
              continue;
              if (!str.equals("faceSwap")) {
                break label628;
              }
              i = 19;
              continue;
              if (!str.equals("faceAverage")) {
                break label628;
              }
              i = 20;
              continue;
              if (!str.equals("phantom")) {
                break label628;
              }
              i = 21;
              continue;
              if (!str.equals("tdParticle")) {
                break label628;
              }
              i = 22;
              continue;
              if (!str.equals("comicAfter")) {
                break label628;
              }
              i = 23;
              continue;
              if (!str.equals("triggerLutAfter")) {
                break label628;
              }
              i = 24;
              continue;
              if (!str.equals("multiview")) {
                break label628;
              }
              i = 25;
              continue;
              if (!str.equals("filamentParticle")) {
                break label628;
              }
              i = 26;
              continue;
              if (!str.equals("stickerAfter")) {
                break label628;
              }
              i = 27;
              continue;
              if (!str.equals("lutAfter")) {
                break label628;
              }
              i = 28;
              continue;
              if (!str.equals("expression")) {
                break label628;
              }
              i = 29;
              continue;
              if (!str.equals("zoom")) {
                break label628;
              }
              i = 30;
              continue;
              if (!str.equals("mv")) {
                break label628;
              }
              i = 31;
              continue;
              if (!str.equals("blurEffectAfter")) {
                break label628;
              }
              i = 32;
              continue;
              if (!str.equals("crazyFace")) {
                break label628;
              }
              i = 33;
            }
          }
          localObject1 = paramAESticker.processTransformRelatedFiltersPluggable(paramAESticker.renderFaceTransform((Frame)localObject1), paramPTFaceAttr, paramAIAttr, localSet);
          continue;
          localObject1 = paramAESticker.renderFabbyStrokeShake((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr);
          continue;
          paramAESticker.renderARFilter((Frame)localObject1);
          continue;
          localObject1 = paramAESticker.renderHeadCropFilter((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderBgFilter((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderEffectFilterBefore((Frame)localObject1);
          continue;
          localObject1 = paramAESticker.renderHairCos((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
          continue;
          localObject1 = paramAESticker.renderSkyFilter((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
          continue;
          localObject1 = paramAESticker.renderComicEffectBefore((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderStyleFilter(1, (Frame)localObject1);
          continue;
          localObject1 = paramAESticker.renderStyleFilter(2, (Frame)localObject1);
          continue;
          localObject1 = paramAESticker.renderEffectTriggerBefore((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderStickerBefore((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderBlingFilter((Frame)localObject1, paramPTFaceAttr, (PTDetectInfo)localObject3, localList3);
          continue;
          localObject1 = paramAESticker.renderFilament((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderRapidNet((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderStyleChild((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderDynamicFilter((Frame)localObject1, paramPTFaceAttr, paramAIAttr);
          continue;
          localObject1 = paramAESticker.renderFaceSwitchFilter((Frame)localObject1, localList1, localSet);
          continue;
          localObject1 = paramAESticker.renderCrazyFaceFilter((Frame)localObject1, localList1, localList2);
          continue;
          localObject1 = paramAESticker.renderPhantomFilter((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderParticleStatic((Frame)localObject1, (PTDetectInfo)localObject3, (List)localObject2);
          continue;
          localObject1 = paramAESticker.renderComicEffectAfter((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderEffectTriggerAfter((Frame)localObject1, paramPTFaceAttr);
          continue;
          paramAESticker.renderMultiViewer((Frame)localObject1, paramPTFaceAttr, paramAIAttr, paramPTSegAttr, localHashMap);
          continue;
          localObject1 = paramAESticker.renderFilamentParticle((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderStickerAfter((Frame)localObject1, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderEffectFilterAfter((Frame)localObject1);
          continue;
          localObject1 = paramAESticker.renderActFilter((Frame)localObject1, localList1, localList2, j, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderZoomFilter((Frame)localObject1, localHashMap);
          continue;
          localObject1 = paramAESticker.renderFabbyMVFilter(paramFrame, paramAIAttr, localHashMap, localSet, paramPTFaceAttr);
          continue;
          localObject1 = paramAESticker.renderAfterBlur((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr);
          continue;
          localObject1 = paramAESticker.renderCosFun((Frame)localObject1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
        }
        paramAESticker.clearTouchPoint();
        paramAESticker.unclockHairMaskFrame();
        return localObject1;
      }
    }
  }
  
  public Frame chainStickerFilters(MultiViewerFilter paramMultiViewerFilter, Frame paramFrame1, Frame paramFrame2, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr, PTHairAttr paramPTHairAttr)
  {
    List localList2 = paramPTFaceAttr.getAllFacePoints();
    List localList3 = paramPTFaceAttr.getAllFaceAngles();
    long l = paramPTFaceAttr.getTimeStamp();
    Object localObject1 = paramPTFaceAttr.getAllFaceAngles();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    Object localObject2 = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
    List localList1;
    if (localObject2 != null)
    {
      localList1 = ((PTHandAttr)localObject2).getHandPointList();
      localSet.add(Integer.valueOf(((PTHandAttr)localObject2).getHandType()));
    }
    for (;;)
    {
      localObject2 = AIActionCounter.getActions(AEDetectorType.HAND);
      localObject2 = new PTDetectInfo.Builder().handPoints(localList1).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).handActionCounter((Map)localObject2).triggeredExpression(localSet).timestamp(l).faceDetector(paramPTFaceAttr.getFaceDetector());
      PTDetectInfo localPTDetectInfo;
      label192:
      int i;
      if (((List)localObject1).size() > 0)
      {
        localObject1 = (float[])((List)localObject1).get(0);
        localPTDetectInfo = ((PTDetectInfo.Builder)localObject2).faceAngles((float[])localObject1).aiAttr(paramAIAttr).build();
        Iterator localIterator = this.mStickerOrderList.iterator();
        localObject2 = paramFrame1;
        localObject1 = paramFrame2;
        paramFrame2 = (Frame)localObject2;
        if (!localIterator.hasNext()) {
          break label1178;
        }
        localObject2 = (String)localIterator.next();
        paramMultiViewerFilter.setFastStickerConfig(paramFrame2, (Frame)localObject1, paramFrame1);
        paramMultiViewerFilter.updateFaceParams(paramFrame2, paramAIAttr, paramPTFaceAttr);
        switch (((String)localObject2).hashCode())
        {
        default: 
          label408:
          i = -1;
          label411:
          switch (i)
          {
          }
          break;
        }
      }
      for (;;)
      {
        break label192;
        localObject1 = null;
        break;
        if (!((String)localObject2).equals("blurEffectBefore")) {
          break label408;
        }
        i = 0;
        break label411;
        if (!((String)localObject2).equals("mesh")) {
          break label408;
        }
        i = 1;
        break label411;
        if (!((String)localObject2).equals("lutBefore")) {
          break label408;
        }
        i = 2;
        break label411;
        if (!((String)localObject2).equals("hairCos")) {
          break label408;
        }
        i = 3;
        break label411;
        if (!((String)localObject2).equals("comicBefore")) {
          break label408;
        }
        i = 4;
        break label411;
        if (!((String)localObject2).equals("triggerLutBefore")) {
          break label408;
        }
        i = 5;
        break label411;
        if (!((String)localObject2).equals("stickerBefore")) {
          break label408;
        }
        i = 6;
        break label411;
        if (!((String)localObject2).equals("styleChange")) {
          break label408;
        }
        i = 7;
        break label411;
        if (!((String)localObject2).equals("styleChild")) {
          break label408;
        }
        i = 8;
        break label411;
        if (!((String)localObject2).equals("customBefore")) {
          break label408;
        }
        i = 9;
        break label411;
        if (!((String)localObject2).equals("dynamic")) {
          break label408;
        }
        i = 10;
        break label411;
        if (!((String)localObject2).equals("faceSwap")) {
          break label408;
        }
        i = 11;
        break label411;
        if (!((String)localObject2).equals("faceAverage")) {
          break label408;
        }
        i = 12;
        break label411;
        if (!((String)localObject2).equals("phantom")) {
          break label408;
        }
        i = 13;
        break label411;
        if (!((String)localObject2).equals("tdParticle")) {
          break label408;
        }
        i = 14;
        break label411;
        if (!((String)localObject2).equals("stickerAfter")) {
          break label408;
        }
        i = 15;
        break label411;
        if (!((String)localObject2).equals("customAfter")) {
          break label408;
        }
        i = 16;
        break label411;
        if (!((String)localObject2).equals("zoom")) {
          break label408;
        }
        i = 17;
        break label411;
        if (!((String)localObject2).equals("blurEffectAfter")) {
          break label408;
        }
        i = 18;
        break label411;
        if (!((String)localObject2).equals("mask")) {
          break label408;
        }
        i = 19;
        break label411;
        if (paramMultiViewerFilter != null)
        {
          paramFrame2 = paramMultiViewerFilter.renderBlurBefore(paramFrame1, (Frame)localObject1, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
          continue;
          if (paramMultiViewerFilter != null)
          {
            paramFrame2 = paramMultiViewerFilter.renderTransform(paramFrame2, paramPTFaceAttr);
            continue;
            if (paramMultiViewerFilter != null)
            {
              paramFrame2 = paramMultiViewerFilter.renderEffectFilter(paramFrame2, (Frame)localObject1);
              continue;
              if (paramMultiViewerFilter != null)
              {
                paramFrame2 = paramMultiViewerFilter.renderHairCos(paramFrame2, paramPTFaceAttr, paramPTHairAttr);
                continue;
                if (paramMultiViewerFilter != null)
                {
                  paramFrame2 = paramMultiViewerFilter.renderComicEffectBefore(paramFrame2, paramPTFaceAttr);
                  continue;
                  if (paramMultiViewerFilter != null)
                  {
                    paramFrame2 = paramMultiViewerFilter.renderEffectTriggerBefore(paramFrame2, paramPTFaceAttr);
                    continue;
                    if (paramMultiViewerFilter != null)
                    {
                      paramFrame2 = paramMultiViewerFilter.renderStaticStickerBefore(paramFrame2, paramPTFaceAttr);
                      continue;
                      if (paramMultiViewerFilter != null)
                      {
                        paramFrame2 = paramMultiViewerFilter.renderRapidNet(paramFrame2, paramPTFaceAttr);
                        continue;
                        if (paramMultiViewerFilter != null)
                        {
                          paramFrame2 = paramMultiViewerFilter.renderStyleChild(paramFrame2, paramPTFaceAttr);
                          continue;
                          if (paramMultiViewerFilter != null)
                          {
                            paramFrame2 = paramMultiViewerFilter.renderCustomFilter(paramFrame2, 100);
                            continue;
                            if (paramMultiViewerFilter != null)
                            {
                              paramFrame2 = paramMultiViewerFilter.renderDynamicStickers(paramFrame2, paramAIAttr, paramPTFaceAttr);
                              continue;
                              if (paramMultiViewerFilter != null)
                              {
                                localObject1 = paramMultiViewerFilter.renderFaceSwitchFilter((Frame)localObject1, localList2, localSet);
                                continue;
                                if (paramMultiViewerFilter != null)
                                {
                                  localObject1 = paramMultiViewerFilter.renderCrazyFaceFilter((Frame)localObject1, localList2, localList3);
                                  continue;
                                  if (paramMultiViewerFilter != null)
                                  {
                                    localObject1 = paramMultiViewerFilter.renderPhantomFilter((Frame)localObject1, paramPTFaceAttr);
                                    continue;
                                    if (paramMultiViewerFilter != null)
                                    {
                                      localObject1 = paramMultiViewerFilter.renderParticleStatic((Frame)localObject1, localPTDetectInfo, localList1);
                                      continue;
                                      if (paramMultiViewerFilter != null)
                                      {
                                        paramFrame2 = paramMultiViewerFilter.renderStaticStickers(paramFrame2, paramPTFaceAttr);
                                        continue;
                                        if (paramMultiViewerFilter != null)
                                        {
                                          paramFrame2 = paramMultiViewerFilter.renderCustomFilter(paramFrame2, 101);
                                          continue;
                                          if (paramMultiViewerFilter != null)
                                          {
                                            paramFrame2 = paramMultiViewerFilter.renderZoomFilter(paramFrame2);
                                            continue;
                                            if (paramMultiViewerFilter != null)
                                            {
                                              paramFrame2 = paramMultiViewerFilter.renderBlurAfter(paramFrame2, paramPTFaceAttr, paramPTSegAttr);
                                              continue;
                                              if (paramMultiViewerFilter != null) {
                                                paramFrame2 = paramMultiViewerFilter.renderMaskSticker(paramFrame2, paramPTFaceAttr, paramAIAttr);
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1178:
      return paramFrame2;
      localList1 = null;
    }
  }
  
  public boolean isChangeRenderOrder()
  {
    return (this.mStickerChain != null) && (this.mStickerChain.size() > 0);
  }
  
  public void setRenderOrder(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      this.mStickerChain = paramList;
      paramList = paramList.iterator();
      int i = -1;
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        int j;
        if (i == -1)
        {
          j = this.mStickerOrderList.indexOf(str);
          if (j != -1) {
            i = j;
          }
        }
        else
        {
          j = this.mStickerOrderList.indexOf(str);
          if (j > i)
          {
            i = j;
          }
          else if (j < i)
          {
            this.mStickerOrderList.remove(j);
            this.mStickerOrderList.add(i, str);
          }
        }
      }
    }
  }
  
  public static final class StickerType
  {
    public static final String AFTERBLUR = "blurEffectAfter";
    public static final String BACKGROUND = "background";
    public static final String BLINGBLING = "blingbling";
    public static final String BLUREFFECTBEFORE = "blurEffectBefore";
    public static final String COMICAFTER = "comicAfter";
    public static final String COMICBEFORE = "comicBefore";
    public static final String COSFUN = "crazyFace";
    public static final String CUSTOMAFTER = "customAfter";
    public static final String CUSTOMBEFORE = "customBefore";
    public static final String DYNAMIC = "dynamic";
    public static final String EXPRESSION = "expression";
    public static final String FABBYMV = "mv";
    public static final String FABBYSTROKE = "fabbyStroke";
    public static final String FACEAVERAGE = "faceAverage";
    public static final String FACESWAP = "faceSwap";
    public static final String FILAMENT = "filament";
    public static final String FILAMENTPARTICLE = "filamentParticle";
    public static final String GAMEPLAY = "3d";
    public static final String HAIRCOS = "hairCos";
    public static final String HEADCROP = "faceHeadCrop";
    public static final String LUTAFTER = "lutAfter";
    public static final String LUTBEFORE = "lutBefore";
    public static final String MASK = "mask";
    public static final String MESH = "mesh";
    public static final String MULTIVIEW = "multiview";
    public static final String PARTICLE = "particle";
    public static final String PHANTOM = "phantom";
    public static final String RAPIDNET = "styleChange";
    public static final String SKY = "skySegment";
    public static final String STICKERAFTER = "stickerAfter";
    public static final String STICKERBEFORE = "stickerBefore";
    public static final String STYLECHILD = "styleChild";
    public static final String STYLE_FILTER_AFTER = "styleFilterAfter";
    public static final String STYLE_FILTER_BEFORE = "styleFilterBefore";
    public static final String TDPARTICLE = "tdParticle";
    public static final String TRIGGERLUTAFTER = "triggerLutAfter";
    public static final String TRIGGERLUTBEFORE = "triggerLutBefore";
    public static final String ZOOM = "zoom";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StickersMap
 * JD-Core Version:    0.7.0.1
 */