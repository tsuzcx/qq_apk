package com.tencent.moai.nativepages;

import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPanoramaImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPureImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentSightVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentStreamVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageInfo;
import com.tencent.moai.nativepages.util.FileUtil;
import java.util.Iterator;
import java.util.LinkedList;

public class AdLandingPagesPreDownloadHelper
{
  public static void preDownload(String paramString1, String paramString2)
  {
    paramString1 = AdLandingPagesParseHelper.getADLandingPageInfos(paramString1, paramString2);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (AdLandingPageInfo)paramString1.next();
        if ((paramString2.componetInfos != null) && (paramString2.componetInfos.size() > 0))
        {
          paramString2 = paramString2.componetInfos.iterator();
          while (paramString2.hasNext())
          {
            AdLandingPageComponentInfo localAdLandingPageComponentInfo = (AdLandingPageComponentInfo)paramString2.next();
            if (AdLandingPagesParseHelper.isBaseComponentInfoType(localAdLandingPageComponentInfo.type)) {
              if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentPanoramaImageInfo)) {
                preDownloadImage(((AdLandingPageComponentPanoramaImageInfo)localAdLandingPageComponentInfo).imgUrl);
              } else if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentPureImageInfo)) {
                preDownloadImage(((AdLandingPageComponentPureImageInfo)localAdLandingPageComponentInfo).imgUrl);
              } else if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentSightVideoInfo)) {
                preDownloadSightVideo(((AdLandingPageComponentSightVideoInfo)localAdLandingPageComponentInfo).sightVideoUrl);
              } else if ((localAdLandingPageComponentInfo instanceof AdLandingPageComponentStreamVideoInfo)) {
                preDownloadStreamVideo(((AdLandingPageComponentStreamVideoInfo)localAdLandingPageComponentInfo).streamVideoUrl);
              }
            }
          }
        }
      }
    }
  }
  
  private static void preDownloadImage(String paramString)
  {
    if (FileUtil.fileExists(AdLandingPagesDownloadResourceHelper.getPathForImg(paramString))) {
      return;
    }
    AdLandingPagesDownloadResourceHelper.downloadImgForAdLandingPages(paramString, new AdLandingPagesPreDownloadHelper.1());
  }
  
  private static void preDownloadSightVideo(String paramString)
  {
    if (FileUtil.fileExists(AdLandingPagesDownloadResourceHelper.getPathForVideo(paramString))) {
      return;
    }
    AdLandingPagesDownloadResourceHelper.downloadSightForAdLandingPages(paramString, new AdLandingPagesPreDownloadHelper.2());
  }
  
  private static void preDownloadStreamVideo(String paramString)
  {
    if (FileUtil.fileExists(AdLandingPagesDownloadResourceHelper.getPathForVideo(paramString))) {
      return;
    }
    AdLandingPagesDownloadResourceHelper.downloadStreamVideoForAdLandingPages(paramString, new AdLandingPagesPreDownloadHelper.3());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesPreDownloadHelper
 * JD-Core Version:    0.7.0.1
 */