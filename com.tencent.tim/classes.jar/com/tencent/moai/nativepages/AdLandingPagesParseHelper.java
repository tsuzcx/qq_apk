package com.tencent.moai.nativepages;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.moai.nativepages.model.AdLandingPageComponentBtnInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentDownloadApkBtnInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentFrameLayoutInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentGroup;
import com.tencent.moai.nativepages.model.AdLandingPageComponentGroupList;
import com.tencent.moai.nativepages.model.AdLandingPageComponentH5Info;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentLinearLayoutInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPanoramaImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPureImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentSightVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentStreamVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentTextInfo;
import com.tencent.moai.nativepages.model.AdLandingPageInfo;
import com.tencent.moai.nativepages.util.StringUtil;
import com.tencent.moai.nativepages.util.UIUtil;
import com.tencent.moai.nativepages.util.XmlParser;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdLandingPagesParseHelper
{
  public static final int DEFAULT_SIZE_TYPE_POINT = 0;
  private static final int NODE_TYPE_CANVAS = 0;
  private static final int NODE_TYPE_COMP = 2;
  private static final int NODE_TYPE_PAGE = 1;
  private static final int NODE_TYPE_SUBTYPE = 3;
  private static final int NODE_TYPE_UNKNOWN = -1;
  public static final int SIZE_TYPE_REM = 1;
  private static final String TAG = "AdLandingPagesParseHelper";
  public static int kDefaultBasicRootFontSize = 10;
  public static int kDefaultBasicWidth = 750;
  private static Set<TypeTriple> validTypes = null;
  
  public static LinkedList<AdLandingPageInfo> getADLandingPageInfos(String paramString1, String paramString2)
  {
    LinkedList localLinkedList = new LinkedList();
    if (TextUtils.isEmpty(paramString1)) {
      return localLinkedList;
    }
    paramString1 = replaceDynamicValue(paramString1, "");
    Map localMap = XmlParser.parseXml(paramString1, paramString2, null);
    if (localMap == null)
    {
      Log.w("AdLandingPagesParseHelper", " parse ad landing pages xml is error ," + paramString1);
      return localLinkedList;
    }
    int i1 = StringUtil.safeParseInt((String)localMap.get("." + paramString2 + ".adCanvasInfo.sizeType"));
    int i = StringUtil.safeParseInt((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicRootFontSize"));
    int k = StringUtil.safeParseInt((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (i1 == 1)) {
      i = kDefaultBasicRootFontSize;
    }
    for (;;)
    {
      int j = k;
      if (k == 0)
      {
        j = k;
        if (i1 == 1) {
          j = kDefaultBasicWidth;
        }
      }
      if ((!StringUtil.isNullOrNil(paramString2)) && (!".adCanvasInfo.PageList.Page".equals("adCanvasInfo"))) {}
      for (paramString1 = "." + paramString2 + ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page")
      {
        k = 0;
        label270:
        AdLandingPageInfo localAdLandingPageInfo;
        boolean bool;
        label395:
        Object localObject;
        if (k == 0)
        {
          paramString2 = paramString1;
          localAdLandingPageInfo = new AdLandingPageInfo();
          localAdLandingPageInfo.backgroundCoverUrl = StringUtil.nullAs((String)localMap.get(paramString2 + ".backgroundCover"), "");
          localAdLandingPageInfo.backgroundColor = StringUtil.nullAs((String)localMap.get(paramString2 + ".backgroundColor"), "");
          if (StringUtil.safeParseInt((String)localMap.get(paramString2 + ".backgroundCover.$isAddBlur")) <= 0) {
            break label509;
          }
          bool = true;
          localAdLandingPageInfo.isNeedBackgroundBlur = bool;
          localAdLandingPageInfo.id = k;
          localObject = paramString2 + ".if";
          if (!localMap.containsKey(localObject)) {
            break label521;
          }
          if (!"1".equals(localMap.get(localObject))) {
            break label515;
          }
          bool = true;
          label462:
          localAdLandingPageInfo.ifCondition = bool;
          label469:
          if (localAdLandingPageInfo.ifCondition) {
            break label530;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          paramString2 = paramString1 + k;
          break label270;
          label509:
          bool = false;
          break label395;
          label515:
          bool = false;
          break label462;
          label521:
          localAdLandingPageInfo.ifCondition = true;
          break label469;
          label530:
          String str = paramString2 + ".componentItemList.componentItem";
          int m = 0;
          for (;;)
          {
            if (m == 0) {
              paramString2 = str;
            }
            try
            {
              if (!TextUtils.isEmpty(localAdLandingPageInfo.backgroundColor)) {}
              for (int n = Color.parseColor(localAdLandingPageInfo.backgroundColor);; n = 0)
              {
                localObject = getAdLandingPageComponentInfo(localMap, i1, i, j, n, paramString2);
                if (localObject != null) {
                  break label669;
                }
                if (localAdLandingPageInfo.componetInfos.size() != 0) {
                  break label746;
                }
                return localLinkedList;
                paramString2 = str + m;
                break;
              }
            }
            catch (Exception localException)
            {
              AdLandingPageComponentInfo localAdLandingPageComponentInfo;
              for (;;)
              {
                localException.printStackTrace();
                localAdLandingPageComponentInfo = getAdLandingPageComponentInfo(localMap, i1, i, j, 0, paramString2);
              }
              label669:
              if (localAdLandingPageComponentInfo.ifCondition)
              {
                parseBaseInfo(localAdLandingPageComponentInfo, localMap, paramString2, i1, j, i);
                localAdLandingPageInfo.componetInfos.add(localAdLandingPageComponentInfo);
              }
              for (;;)
              {
                m += 1;
                break;
                Log.i("AdLandingPagesParseHelper", "comp " + localAdLandingPageComponentInfo.toString() + " ifCondition is false");
              }
              label746:
              localLinkedList.add(localAdLandingPageInfo);
            }
          }
        }
      }
    }
  }
  
  private static AdLandingPageComponentGroup getAdLandingPageComponentGroup(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AdLandingPageComponentGroup localAdLandingPageComponentGroup = new AdLandingPageComponentGroup();
    try
    {
      i = Color.parseColor((String)paramMap.get(paramString + ".bgColorTheme"));
      localAdLandingPageComponentGroup.backgroundColor = ((int)(StringUtil.getDouble((String)paramMap.get(paramString + ".bgColorAlpha"), 0.0D) * 255.0D) << 24 | i & 0xFFFFFF);
      paramString = paramString + ".componentGroupList";
      str = paramString + ".componentItem";
      i = 0;
      if (i == 0)
      {
        paramString = str;
        int j = StringUtil.safeParseInt((String)paramMap.get(paramString + ".type"));
        AdLandingPageComponentInfo localAdLandingPageComponentInfo = null;
        if (isBaseComponentInfoType(j)) {
          localAdLandingPageComponentInfo = getBaseComponentInfo(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        }
        if (localAdLandingPageComponentInfo != null) {
          break label257;
        }
        return localAdLandingPageComponentGroup;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        String str;
        localException.printStackTrace();
        localAdLandingPageComponentGroup.backgroundColor = Color.argb(51, 0, 0, 0);
        continue;
        paramString = str + i;
        continue;
        label257:
        if (localException.ifCondition) {
          localAdLandingPageComponentGroup.adLandingPageComponentInfos.add(localException);
        }
        i += 1;
      }
    }
  }
  
  private static AdLandingPageComponentGroupList getAdLandingPageComponentGroupList(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AdLandingPageComponentGroupList localAdLandingPageComponentGroupList = new AdLandingPageComponentGroupList();
    parseBaseInfo(localAdLandingPageComponentGroupList, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localAdLandingPageComponentGroupList.adPageGroupListCtrType = StringUtil.safeParseInt((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    String str1;
    int i;
    if (StringUtil.safeParseInt((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localAdLandingPageComponentGroupList.isFullScreen = bool;
      str1 = paramString + ".componentGroupList.componentGroup";
      i = 0;
    }
    for (;;)
    {
      label134:
      AdLandingPageComponentGroup localAdLandingPageComponentGroup;
      String str2;
      int j;
      if (i == 0)
      {
        paramString = str1;
        localAdLandingPageComponentGroup = new AdLandingPageComponentGroup();
        str2 = paramString + ".componentItem";
        j = 0;
      }
      for (;;)
      {
        if (j == 0) {}
        AdLandingPageComponentInfo localAdLandingPageComponentInfo;
        for (paramString = str2;; paramString = str2 + j)
        {
          int k = StringUtil.safeParseInt((String)paramMap.get(paramString + ".type"));
          localAdLandingPageComponentInfo = null;
          if (isBaseComponentInfoType(k)) {
            localAdLandingPageComponentInfo = getBaseComponentInfo(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
          }
          if (localAdLandingPageComponentInfo != null) {
            break label305;
          }
          if (localAdLandingPageComponentGroup.adLandingPageComponentInfos.size() != 0) {
            break label333;
          }
          return localAdLandingPageComponentGroupList;
          bool = false;
          break;
          paramString = str1 + i;
          break label134;
        }
        label305:
        if (localAdLandingPageComponentInfo.ifCondition) {
          localAdLandingPageComponentGroup.adLandingPageComponentInfos.add(localAdLandingPageComponentInfo);
        }
        j += 1;
      }
      label333:
      localAdLandingPageComponentGroupList.adLandingPageComponentInfos.add(localAdLandingPageComponentGroup);
      i += 1;
    }
  }
  
  private static AdLandingPageComponentInfo getAdLandingPageComponentInfo(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    int i = StringUtil.safeParseInt((String)paramMap.get(paramString + ".type"));
    if (isBaseComponentInfoType(i)) {
      return getBaseComponentInfo(paramMap, paramString, paramInt1, paramInt3, paramInt2, paramInt4);
    }
    if (isComponentGroupListType(i)) {
      return getAdLandingPageComponentGroupList(paramMap, paramString, paramInt1, paramInt3, paramInt2, paramInt4);
    }
    if (isComponentLinearLayoutType(i)) {
      return getAdLandingPageLinearLayoutComponent(paramMap, paramString, paramInt1, paramInt3, paramInt2, paramInt4);
    }
    Log.e("AdLandingPagesParseHelper", "the type" + i + " is not client known type");
    return null;
  }
  
  private static List<AdLandingPageComponentInfo> getAdLandingPageLayoutItems(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = str;; paramString = str + i)
    {
      paramString = getAdLandingPageComponentInfo(paramMap, paramInt1, paramInt3, paramInt2, paramInt4, paramString);
      if (paramString != null) {
        break;
      }
      return localArrayList;
    }
    if (paramString.ifCondition) {
      localArrayList.add(paramString);
    }
    for (;;)
    {
      i += 1;
      break;
      Log.i("AdLandingPagesParseHelper", "comp " + paramString.toString() + " ifCondition is false");
    }
  }
  
  private static AdLandingPageComponentInfo getAdLandingPageLinearLayoutComponent(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AdLandingPageComponentLinearLayoutInfo localAdLandingPageComponentLinearLayoutInfo = new AdLandingPageComponentLinearLayoutInfo();
    localAdLandingPageComponentLinearLayoutInfo.linearLayoutOrientation = StringUtil.safeParseInt((String)paramMap.get(paramString + ".subType"));
    parseBaseInfo(localAdLandingPageComponentLinearLayoutInfo, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    String str2 = paramString + ".layoutItems.componentItem";
    int i = 0;
    for (;;)
    {
      String str1;
      int j;
      if (i == 0)
      {
        str1 = str2;
        j = StringUtil.safeParseInt((String)paramMap.get(str1 + ".type"));
        paramString = null;
        if (!isBaseComponentInfoType(j)) {
          break label180;
        }
        paramString = getBaseComponentInfo(paramMap, str1, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      for (;;)
      {
        if (paramString != null) {
          break label204;
        }
        return localAdLandingPageComponentLinearLayoutInfo;
        str1 = str2 + i;
        break;
        label180:
        if (isComponentLinearLayoutType(j)) {
          paramString = getAdLandingPageLinearLayoutComponent(paramMap, str1, paramInt1, paramInt2, paramInt3, paramInt4);
        }
      }
      label204:
      if (paramString.ifCondition) {
        localAdLandingPageComponentLinearLayoutInfo.componentList.add(paramString);
      }
      i += 1;
    }
  }
  
  private static AdLandingPageComponentInfo getBaseComponentInfo(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    int i = StringUtil.safeParseInt((String)paramMap.get(paramString + ".type"));
    int j = StringUtil.safeParseInt((String)paramMap.get(paramString + ".subType"));
    Object localObject = null;
    switch (i)
    {
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((AdLandingPageComponentInfo)localObject).isCloseToWhite = isCloseToWhite(paramInt4);
        ((AdLandingPageComponentInfo)localObject).type = i;
        ((AdLandingPageComponentInfo)localObject).subType = j;
        parseBaseInfo((AdLandingPageComponentInfo)localObject, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      }
      return localObject;
      localObject = new AdLandingPageComponentTextInfo();
      ((AdLandingPageComponentTextInfo)localObject).ComponentType = i;
      ((AdLandingPageComponentTextInfo)localObject).subType = j;
      ((AdLandingPageComponentTextInfo)localObject).wordingTitle = StringUtil.nullAs((String)paramMap.get(paramString + ".content"), "");
      ((AdLandingPageComponentTextInfo)localObject).textAlignment = StringUtil.safeParseInt((String)paramMap.get(paramString + ".textAlignment"));
      ((AdLandingPageComponentTextInfo)localObject).textColor = StringUtil.nullAs((String)paramMap.get(paramString + ".fontColor"), "");
      ((AdLandingPageComponentTextInfo)localObject).textSize = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((StringUtil.safeParseInt((String)paramMap.get(paramString + ".showType")) & AdLandingPageComponentTextInfo.TEXT_FONT_TYPE_BOLD) > 0)
      {
        bool1 = true;
        label440:
        ((AdLandingPageComponentTextInfo)localObject).textBolded = bool1;
        if ((StringUtil.safeParseInt((String)paramMap.get(paramString + ".showType")) & AdLandingPageComponentTextInfo.TEXT_FONT_TYPE_ITALIC) <= 0) {
          break label592;
        }
        bool1 = true;
        label489:
        ((AdLandingPageComponentTextInfo)localObject).textItaliced = bool1;
        if ((StringUtil.safeParseInt((String)paramMap.get(paramString + ".showType")) & AdLandingPageComponentTextInfo.TEXT_FONT_TYPE_UNDERLINE) <= 0) {
          break label598;
        }
      }
      label592:
      label598:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((AdLandingPageComponentTextInfo)localObject).textUnderlined = bool1;
        ((AdLandingPageComponentTextInfo)localObject).maxLines = StringUtil.safeParseInt((String)paramMap.get(paramString + ".maxLines"));
        break;
        bool1 = false;
        break label440;
        bool1 = false;
        break label489;
      }
      if (j == 2)
      {
        localObject = new AdLandingPageComponentDownloadApkBtnInfo();
        ((AdLandingPageComponentDownloadApkBtnInfo)localObject).appid = ((String)paramMap.get(paramString + ".appid"));
        ((AdLandingPageComponentDownloadApkBtnInfo)localObject).channelId = ((String)paramMap.get(paramString + ".channelId"));
        ((AdLandingPageComponentDownloadApkBtnInfo)localObject).pkg = ((String)paramMap.get(paramString + ".pkg"));
        ((AdLandingPageComponentDownloadApkBtnInfo)localObject).supportPlatform = StringUtil.safeParseInt((String)paramMap.get(paramString + ".platform"));
        ((AdLandingPageComponentDownloadApkBtnInfo)localObject).unSupportWarning = ((String)paramMap.get(paramString + ".warningAndroid"));
      }
      for (;;)
      {
        ((AdLandingPageComponentBtnInfo)localObject).ComponentType = i;
        ((AdLandingPageComponentBtnInfo)localObject).subType = j;
        ((AdLandingPageComponentBtnInfo)localObject).title = StringUtil.nullAs((String)paramMap.get(paramString + ".btnTitle"), "");
        ((AdLandingPageComponentBtnInfo)localObject).btnType = StringUtil.safeParseInt((String)paramMap.get(paramString + ".btnType"));
        ((AdLandingPageComponentBtnInfo)localObject).handleUrl = StringUtil.nullAs((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((AdLandingPageComponentBtnInfo)localObject).handleJumpedAppId = StringUtil.nullAs((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((AdLandingPageComponentBtnInfo)localObject).fontColor = StringUtil.nullAs((String)paramMap.get(paramString + ".fontColor"), "");
        ((AdLandingPageComponentBtnInfo)localObject).fontSize = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((AdLandingPageComponentBtnInfo)localObject).textAlignment = StringUtil.safeParseInt((String)paramMap.get(paramString + ".btnAlignment"));
        ((AdLandingPageComponentBtnInfo)localObject).boardSize = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((AdLandingPageComponentBtnInfo)localObject).height = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((AdLandingPageComponentBtnInfo)localObject).btnBgColor = StringUtil.nullAs((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((AdLandingPageComponentBtnInfo)localObject).btnBorderColor = StringUtil.nullAs((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((AdLandingPageComponentBtnInfo)localObject).btnBackgroundImg = StringUtil.nullAs((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        break;
        localObject = new AdLandingPageComponentBtnInfo();
      }
      localObject = new AdLandingPageComponentPureImageInfo();
      ((AdLandingPageComponentPureImageInfo)localObject).ComponentType = i;
      ((AdLandingPageComponentPureImageInfo)localObject).subType = j;
      ((AdLandingPageComponentPureImageInfo)localObject).imgUrl = StringUtil.nullAs((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((AdLandingPageComponentPureImageInfo)localObject).width = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((AdLandingPageComponentPureImageInfo)localObject).height = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((AdLandingPageComponentPureImageInfo)localObject).bFullScreen = false;
      continue;
      localObject = new AdLandingPageComponentPureImageInfo();
      ((AdLandingPageComponentPureImageInfo)localObject).ComponentType = i;
      ((AdLandingPageComponentPureImageInfo)localObject).subType = j;
      ((AdLandingPageComponentPureImageInfo)localObject).imgUrl = StringUtil.nullAs((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((AdLandingPageComponentPureImageInfo)localObject).bFullScreen = true;
      continue;
      localObject = new AdLandingPageComponentPanoramaImageInfo();
      ((AdLandingPageComponentPanoramaImageInfo)localObject).ComponentType = i;
      ((AdLandingPageComponentPanoramaImageInfo)localObject).subType = j;
      ((AdLandingPageComponentPanoramaImageInfo)localObject).imgUrl = StringUtil.nullAs((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((AdLandingPageComponentPanoramaImageInfo)localObject).width = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((AdLandingPageComponentPanoramaImageInfo)localObject).height = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject = new AdLandingPageComponentSightVideoInfo();
      ((AdLandingPageComponentSightVideoInfo)localObject).ComponentType = i;
      ((AdLandingPageComponentSightVideoInfo)localObject).subType = j;
      ((AdLandingPageComponentSightVideoInfo)localObject).sightVideoUrl = StringUtil.nullAs((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((AdLandingPageComponentSightVideoInfo)localObject).sightThumbUrl = StringUtil.nullAs((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((AdLandingPageComponentSightVideoInfo)localObject).width = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((AdLandingPageComponentSightVideoInfo)localObject).height = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((AdLandingPageComponentSightVideoInfo)localObject).sightVideoDisplayType = StringUtil.safeParseInt((String)paramMap.get(paramString + ".sightDisplayType"));
      continue;
      localObject = new AdLandingPageComponentStreamVideoInfo();
      ((AdLandingPageComponentStreamVideoInfo)localObject).ComponentType = i;
      ((AdLandingPageComponentStreamVideoInfo)localObject).subType = j;
      ((AdLandingPageComponentStreamVideoInfo)localObject).streamVideoUrl = StringUtil.nullAs((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((AdLandingPageComponentStreamVideoInfo)localObject).streamDisplaySound = StringUtil.safeParseInt((String)paramMap.get(paramString + ".streamDisplaySound"));
      ((AdLandingPageComponentStreamVideoInfo)localObject).streamVideoThumb = StringUtil.nullAs((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((AdLandingPageComponentStreamVideoInfo)localObject).width = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((AdLandingPageComponentStreamVideoInfo)localObject).height = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((AdLandingPageComponentStreamVideoInfo)localObject).streamVideoDisplayType = StringUtil.safeParseInt((String)paramMap.get(paramString + ".streamDisplayType"));
      continue;
      localObject = new AdLandingPageComponentH5Info();
      ((AdLandingPageComponentH5Info)localObject).ComponentType = i;
      ((AdLandingPageComponentH5Info)localObject).subType = j;
      ((AdLandingPageComponentH5Info)localObject).h5Url = StringUtil.nullAs((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      localObject = getAdLandingPageComponentGroup(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      List localList = getAdLandingPageLayoutItems(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = new AdLandingPageComponentFrameLayoutInfo();
      ((AdLandingPageComponentFrameLayoutInfo)localObject).children = localList;
    }
  }
  
  public static float getPointsSizeFromXmlData(double paramDouble, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return (float)paramDouble;
    }
    if (paramInt2 == 0) {
      return (float)paramDouble;
    }
    paramInt1 = Resources.getSystem().getDisplayMetrics().widthPixels;
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    return UIUtil.safeParseIntPxFromFloat(paramInt1 * (f1 * f2) / paramInt2);
  }
  
  public static boolean isBaseComponentInfoType(int paramInt)
  {
    return (paramInt != 101) && (paramInt != 103);
  }
  
  private static boolean isCloseToWhite(int paramInt)
  {
    paramInt |= 0xFF000000;
    return paramInt + 16777216 > -1 - paramInt;
  }
  
  public static boolean isComponentGroupListType(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean isComponentLinearLayoutType(int paramInt)
  {
    return paramInt == 103;
  }
  
  private static void parseBaseInfo(AdLandingPageComponentInfo paramAdLandingPageComponentInfo, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    paramAdLandingPageComponentInfo.ComponentType = StringUtil.safeParseInt((String)paramMap.get(paramString + ".type"));
    paramAdLandingPageComponentInfo.type = paramAdLandingPageComponentInfo.ComponentType;
    paramAdLandingPageComponentInfo.cId = StringUtil.nullAs((String)paramMap.get(paramString + ".id"), "");
    paramAdLandingPageComponentInfo.paddingTop = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    paramAdLandingPageComponentInfo.paddingBottom = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    paramAdLandingPageComponentInfo.paddingLeft = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    paramAdLandingPageComponentInfo.paddingRight = getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    paramAdLandingPageComponentInfo.subType = StringUtil.safeParseInt((String)paramMap.get(paramString + ".subType"));
    String str1 = paramString + ".if";
    boolean bool1;
    label357:
    double d;
    if (paramMap.containsKey(str1)) {
      if ("1".equals(paramMap.get(str1)))
      {
        bool1 = true;
        paramAdLandingPageComponentInfo.ifCondition = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label655;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label649;
        }
        bool1 = bool2;
        label410:
        paramAdLandingPageComponentInfo.noReport = bool1;
        label416:
        str1 = StringUtil.nullAs((String)paramMap.get(paramString + ".layoutWidth"), "");
        String str2 = StringUtil.nullAs((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label680;
        }
        d = StringUtil.safeParseDouble(str1);
        if (d >= 0.0D) {
          break label663;
        }
        paramAdLandingPageComponentInfo.layoutWidth = ((float)d);
        label518:
        if (TextUtils.isEmpty(str2)) {
          break label707;
        }
        d = StringUtil.safeParseDouble(str2);
        if (d >= 0.0D) {
          break label690;
        }
        paramAdLandingPageComponentInfo.layoutHeight = ((float)d);
        label548:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        paramMap = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label717;
        }
      }
    }
    label649:
    label655:
    label663:
    label680:
    label690:
    label707:
    label717:
    for (paramAdLandingPageComponentInfo.verticalAlignment = -1;; paramAdLandingPageComponentInfo.verticalAlignment = StringUtil.safeParseInt(str1))
    {
      if (!TextUtils.isEmpty(paramMap)) {
        break label729;
      }
      paramAdLandingPageComponentInfo.horizontalAlignment = -1;
      return;
      bool1 = false;
      break;
      paramAdLandingPageComponentInfo.ifCondition = true;
      break label357;
      bool1 = false;
      break label410;
      paramAdLandingPageComponentInfo.noReport = false;
      break label416;
      paramAdLandingPageComponentInfo.layoutWidth = getPointsSizeFromXmlData(d, paramInt1, paramInt2, paramInt3);
      break label518;
      paramAdLandingPageComponentInfo.layoutWidth = 2.147484E+009F;
      break label518;
      paramAdLandingPageComponentInfo.layoutHeight = getPointsSizeFromXmlData(d, paramInt1, paramInt2, paramInt3);
      break label548;
      paramAdLandingPageComponentInfo.layoutHeight = 2.147484E+009F;
      break label548;
    }
    label729:
    paramAdLandingPageComponentInfo.horizontalAlignment = StringUtil.safeParseInt(paramMap);
  }
  
  private static String replaceDynamicValue(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    return paramString1.replaceAll("\\{\\{.*?\\}\\}", paramString2);
  }
  
  static class TypeTriple
  {
    private int compType;
    private int nodeType;
    private int subCompType;
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof TypeTriple))
      {
        paramObject = (TypeTriple)paramObject;
        bool1 = bool2;
        if (paramObject.nodeType == this.nodeType)
        {
          bool1 = bool2;
          if (paramObject.compType == this.compType)
          {
            bool1 = bool2;
            if (paramObject.subCompType == this.subCompType) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return this.nodeType + this.compType + this.subCompType;
    }
    
    public String toString()
    {
      return "[nodeType=" + this.nodeType + ",compType=" + this.compType + ",subCompType=" + this.subCompType + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesParseHelper
 * JD-Core Version:    0.7.0.1
 */