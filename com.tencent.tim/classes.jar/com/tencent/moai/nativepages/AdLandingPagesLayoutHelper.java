package com.tencent.moai.nativepages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.moai.nativepages.component.AdLandingPageBaseComp;
import com.tencent.moai.nativepages.component.AdLandingPageBtn;
import com.tencent.moai.nativepages.component.AdLandingPageBtnDownloadApk;
import com.tencent.moai.nativepages.component.AdLandingPageBtnOpenApp;
import com.tencent.moai.nativepages.component.AdLandingPageFrameLayout;
import com.tencent.moai.nativepages.component.AdLandingPageGroupList;
import com.tencent.moai.nativepages.component.AdLandingPageH5;
import com.tencent.moai.nativepages.component.AdLandingPageImageCircle;
import com.tencent.moai.nativepages.component.AdLandingPageImagePanorama;
import com.tencent.moai.nativepages.component.AdLandingPageImagePure;
import com.tencent.moai.nativepages.component.AdLandingPageLinearLayout;
import com.tencent.moai.nativepages.component.AdLandingPageSightVideo;
import com.tencent.moai.nativepages.component.AdLandingPageStreamVideo;
import com.tencent.moai.nativepages.component.AdLandingPageText;
import com.tencent.moai.nativepages.model.AdLandingPageComponentBtnInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentDownloadApkBtnInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentFrameLayoutInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentGroupList;
import com.tencent.moai.nativepages.model.AdLandingPageComponentH5Info;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentLinearLayoutInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPanoramaImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPureImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentSightVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentStreamVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentTextInfo;

public class AdLandingPagesLayoutHelper
{
  public final String TAG = "SnsAdNativeLandingPagesLayoutHelper";
  
  public static AdLandingPageBaseComp LayoutBaseComponent(Context paramContext, AdLandingPageComponentInfo paramAdLandingPageComponentInfo, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, int paramInt1, int paramInt2, int paramInt3)
  {
    paramLayoutInflater = null;
    switch (paramAdLandingPageComponentInfo.type)
    {
    }
    while (paramLayoutInflater != null)
    {
      return paramLayoutInflater;
      paramLayoutInflater = new AdLandingPageText(paramContext, (AdLandingPageComponentTextInfo)paramAdLandingPageComponentInfo, paramViewGroup);
      continue;
      if (paramAdLandingPageComponentInfo.subType == 2)
      {
        paramLayoutInflater = new AdLandingPageBtnDownloadApk(paramContext, (AdLandingPageComponentDownloadApkBtnInfo)paramAdLandingPageComponentInfo, paramViewGroup);
        paramLayoutInflater.setBackgroundColor(paramInt3);
      }
      else if (paramAdLandingPageComponentInfo.subType == 6)
      {
        paramLayoutInflater = new AdLandingPageBtnOpenApp(paramContext, (AdLandingPageComponentBtnInfo)paramAdLandingPageComponentInfo, paramViewGroup);
        paramLayoutInflater.setBackgroundColor(paramInt3);
      }
      else
      {
        paramLayoutInflater = new AdLandingPageBtn(paramContext, (AdLandingPageComponentBtnInfo)paramAdLandingPageComponentInfo, paramViewGroup);
        paramLayoutInflater.setBackgroundColor(paramInt3);
        continue;
        switch (paramAdLandingPageComponentInfo.subType)
        {
        default: 
          break;
        case 0: 
          paramLayoutInflater = new AdLandingPageImagePure(paramContext, (AdLandingPageComponentPureImageInfo)paramAdLandingPageComponentInfo, paramViewGroup);
          paramLayoutInflater.setBackgroundColor(paramInt3);
          break;
        case 1: 
          paramLayoutInflater = new AdLandingPageImageCircle(paramContext, (AdLandingPageComponentPureImageInfo)paramAdLandingPageComponentInfo, paramViewGroup);
          paramLayoutInflater.setBackgroundColor(paramInt3);
          continue;
          paramLayoutInflater = new AdLandingPageImagePanorama(paramContext, (AdLandingPageComponentPanoramaImageInfo)paramAdLandingPageComponentInfo, paramViewGroup);
          continue;
          paramLayoutInflater = new AdLandingPageImagePure(paramContext, (AdLandingPageComponentPureImageInfo)paramAdLandingPageComponentInfo, paramViewGroup);
          continue;
          paramLayoutInflater = new AdLandingPageSightVideo(paramContext, (AdLandingPageComponentSightVideoInfo)paramAdLandingPageComponentInfo, paramViewGroup);
          continue;
          paramLayoutInflater = new AdLandingPageStreamVideo(paramContext, (AdLandingPageComponentStreamVideoInfo)paramAdLandingPageComponentInfo, paramViewGroup);
          continue;
          paramLayoutInflater = new AdLandingPageH5(paramContext, (AdLandingPageComponentH5Info)paramAdLandingPageComponentInfo, paramViewGroup);
          continue;
          paramLayoutInflater = new AdLandingPageGroupList(paramContext, (AdLandingPageComponentGroupList)paramAdLandingPageComponentInfo, paramViewGroup);
          continue;
          paramLayoutInflater = new AdLandingPageLinearLayout(paramContext, (AdLandingPageComponentLinearLayoutInfo)paramAdLandingPageComponentInfo, paramViewGroup);
          continue;
          paramLayoutInflater = new AdLandingPageFrameLayout(paramContext, (AdLandingPageComponentFrameLayoutInfo)paramAdLandingPageComponentInfo, paramViewGroup);
        }
      }
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentTextInfo))
    {
      paramContext = new AdLandingPageText(paramContext, (AdLandingPageComponentTextInfo)paramAdLandingPageComponentInfo, paramViewGroup);
      paramContext.setBackgroundColor(paramInt3);
      return paramContext;
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentBtnInfo))
    {
      paramContext = new AdLandingPageBtn(paramContext, (AdLandingPageComponentBtnInfo)paramAdLandingPageComponentInfo, paramViewGroup);
      paramContext.setBackgroundColor(paramInt3);
      return paramContext;
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentPureImageInfo)) {
      return new AdLandingPageImagePure(paramContext, (AdLandingPageComponentPureImageInfo)paramAdLandingPageComponentInfo, paramViewGroup);
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentPanoramaImageInfo)) {
      return new AdLandingPageImagePanorama(paramContext, (AdLandingPageComponentPanoramaImageInfo)paramAdLandingPageComponentInfo, paramViewGroup);
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentSightVideoInfo)) {
      return new AdLandingPageSightVideo(paramContext, (AdLandingPageComponentSightVideoInfo)paramAdLandingPageComponentInfo, paramViewGroup);
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentStreamVideoInfo)) {
      return new AdLandingPageStreamVideo(paramContext, (AdLandingPageComponentStreamVideoInfo)paramAdLandingPageComponentInfo, paramViewGroup);
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentH5Info)) {
      return new AdLandingPageH5(paramContext, (AdLandingPageComponentH5Info)paramAdLandingPageComponentInfo, paramViewGroup);
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentGroupList)) {
      return new AdLandingPageGroupList(paramContext, (AdLandingPageComponentGroupList)paramAdLandingPageComponentInfo, paramViewGroup);
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentLinearLayoutInfo)) {
      return new AdLandingPageLinearLayout(paramContext, (AdLandingPageComponentLinearLayoutInfo)paramAdLandingPageComponentInfo, paramViewGroup);
    }
    if ((paramAdLandingPageComponentInfo instanceof AdLandingPageComponentFrameLayoutInfo)) {
      return new AdLandingPageFrameLayout(paramContext, (AdLandingPageComponentFrameLayoutInfo)paramAdLandingPageComponentInfo, paramViewGroup);
    }
    return new AdLandingPageBaseComp(paramContext, paramAdLandingPageComponentInfo, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesLayoutHelper
 * JD-Core Version:    0.7.0.1
 */