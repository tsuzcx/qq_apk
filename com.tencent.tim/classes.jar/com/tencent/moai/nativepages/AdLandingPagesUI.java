package com.tencent.moai.nativepages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.moai.nativepages.component.ALLandingAutoPlay;
import com.tencent.moai.nativepages.component.ALLandingAutoPlayListener;
import com.tencent.moai.nativepages.component.AdLandingPageBaseComp;
import com.tencent.moai.nativepages.component.AdLandingPageSightVideo;
import com.tencent.moai.nativepages.component.AdLandingPageStreamVideo;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPanoramaImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPureImageInfo;
import com.tencent.moai.nativepages.model.AdLandingPageComponentSightVideoInfo;
import com.tencent.moai.nativepages.model.AdLandingPageDownIconInfo;
import com.tencent.moai.nativepages.model.AdLandingPageInfo;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.moai.nativepages.util.LogUtil;
import com.tencent.moai.nativepages.util.StringUtil;
import com.tencent.moai.nativepages.util.Threads;
import com.tencent.moai.nativepages.util.UIUtil;
import com.tencent.moai.nativepages.util.XmlParser;
import com.tencent.moai.nativepages.view.PagesScrollView;
import com.tencent.moai.nativepages.view.PagesScrollView.SwipeBackListener;
import com.tencent.moai.nativepages.view.PagesScrollViewListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class AdLandingPagesUI
  extends Activity
  implements PagesScrollViewListener
{
  public static final String ARG_LANDING_PAGE_XML = "ARG_LANDING_PAGE_XML";
  public static final String ARG_LANDING_PAGE_XML_PREFIX = "ARG_LANDING_PAGE_XML_PREFIX";
  private static final String TAG = "SnsAdNativeLandingPagesUI";
  private static final float interpolator = 1.2F;
  private AdLandingPagesPreviewAnimation adLandingPagesPreviewAnimation;
  private ALLandingAutoPlayListener autoPlayListener = new AdLandingPagesUI.1(this);
  private boolean bFirstAppearedCallBack = false;
  private boolean bNeedEnterAndExitAnimation = false;
  private final Map<String, Bitmap> bitmapCache = new WeakHashMap();
  private boolean cancelPageChangedInExitAnimation = false;
  private ImageView closeBtn;
  private ImageView closeMaskIv;
  private LinkedList<AdLandingPageBaseComp> componentList = new LinkedList();
  private int controlledSmoothedOly = -1;
  private int controlledSmoothedy = -1;
  protected int disableShareBitSet;
  private int downIconFirstAnimationDuration = 600;
  private int downIconSecondAnimationDuration = 700;
  private int downIconThirdAnimationDuration = 250;
  private ImageView firstPageDirectionBtn;
  private ImageView galleryBg;
  private LinkedList<AdLandingPageInfo> landingPages = new LinkedList();
  private String landingPagesXml;
  private String landingPagesXmlPrex;
  private int lastScrolledPage = 0;
  private LinkedList<View> mViewPages = new LinkedList();
  private ImageView moreBtn;
  private Map<Integer, CompRenderer> pageCompMap = new HashMap();
  private AdLandingPageDownIconInfo pageDownIconInfo;
  private SparseArray<View> pageReuse = new SparseArray();
  private long pageUIApplearTime = 0L;
  private LinearLayout pagesLinearLayout;
  private Bundle savedInstanceState;
  private PagesScrollView scrollView;
  protected String shareDesc;
  protected String shareTitle;
  protected String shareUrl;
  protected String sharethumbUrl;
  private int startedScrollY;
  private int thumbnailHeight = 0;
  private int thumbnailLeft = 0;
  private int thumbnailTop = 0;
  private int thumbnailWidth = 0;
  
  private void beginStartDownAnimation(ViewHolder paramViewHolder)
  {
    paramViewHolder.nextBtn.clearAnimation();
    if (paramViewHolder.nextBtnAnimationCount > 0) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
    localAlphaAnimation.setDuration(this.downIconFirstAnimationDuration);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
    localAlphaAnimation.setStartOffset(this.downIconFirstAnimationDuration);
    localAlphaAnimation.setAnimationListener(new AdLandingPagesUI.15(this, paramViewHolder));
    if ((this.pageDownIconInfo != null) && (!this.pageDownIconInfo.equals(paramViewHolder.nextBtn.getTag())))
    {
      paramViewHolder.nextBtn.setTag(this.pageDownIconInfo);
      AdLandingPagesDownloadResourceHelper.downloadImgForAdLandingPages(this.pageDownIconInfo.iconUrl, new AdLandingPagesUI.16(this, paramViewHolder, localAlphaAnimation));
      return;
    }
    paramViewHolder.nextBtn.startAnimation(localAlphaAnimation);
  }
  
  private void beginStartFirstPageDirectionAnimation()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
    localAlphaAnimation.setDuration(this.downIconFirstAnimationDuration);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
    localAlphaAnimation.setStartOffset(this.downIconFirstAnimationDuration);
    localAlphaAnimation.setAnimationListener(new AdLandingPagesUI.12(this));
    if ((this.pageDownIconInfo != null) && (!this.pageDownIconInfo.equals(this.firstPageDirectionBtn.getTag())))
    {
      this.firstPageDirectionBtn.setTag(this.pageDownIconInfo);
      AdLandingPagesDownloadResourceHelper.downloadImgForAdLandingPages(this.pageDownIconInfo.iconUrl, new AdLandingPagesUI.13(this, localAlphaAnimation));
      return;
    }
    this.firstPageDirectionBtn.startAnimation(localAlphaAnimation);
  }
  
  private void clearControlledSmoothInfo()
  {
    this.controlledSmoothedOly = -1;
    this.controlledSmoothedy = -1;
    this.scrollView.setOnTouchListener(new AdLandingPagesUI.11(this));
  }
  
  private void componentDisappearChanged()
  {
    componentDisappearChanged(-1);
  }
  
  private void componentDisappearChanged(int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = this.scrollView.getScrollY();
    }
    this.scrollView.getScrollY();
    Iterator localIterator = this.componentList.iterator();
    int m = 0;
    AdLandingPageBaseComp localAdLandingPageBaseComp;
    View localView;
    int k;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localAdLandingPageBaseComp = (AdLandingPageBaseComp)localIterator.next();
        localView = localAdLandingPageBaseComp.getView();
        if (localView != null)
        {
          int[] arrayOfInt = new int[2];
          localView.getLocationOnScreen(arrayOfInt);
          paramInt = m;
          if (this.componentList.getFirst() != null)
          {
            paramInt = m;
            if (this.componentList.getFirst() == localAdLandingPageBaseComp) {
              paramInt = arrayOfInt[1];
            }
          }
          k = arrayOfInt[1] - paramInt + 1;
          if (i > k)
          {
            j = i;
            label132:
            if (this.scrollView.getMeasuredHeight() + i <= localView.getMeasuredHeight() + k) {
              break label248;
            }
            k += localView.getMeasuredHeight();
            label162:
            if (k - j < 2) {
              break label284;
            }
          }
        }
      }
    }
    label284:
    for (m = 1;; m = 0)
    {
      if ((localAdLandingPageBaseComp.getViewAppeared()) && (m == 0)) {
        localAdLandingPageBaseComp.viewWillDisappear();
      }
      for (;;)
      {
        if ((m == 0) && (!(localAdLandingPageBaseComp instanceof AdLandingPageStreamVideo)))
        {
          m = paramInt;
          if (!(localAdLandingPageBaseComp instanceof AdLandingPageSightVideo)) {
            break;
          }
        }
        localAdLandingPageBaseComp.viewAppeared(k - j, localView.getMeasuredHeight(), this.scrollView.getMeasuredHeight());
        m = paramInt;
        break;
        j = k;
        break label132;
        label248:
        k = this.scrollView.getMeasuredHeight() + i;
        break label162;
        if ((!localAdLandingPageBaseComp.getViewAppeared()) && (m != 0)) {
          localAdLandingPageBaseComp.viewWillAppear();
        }
      }
      return;
    }
  }
  
  private void controlCurrentPageDicretionDownAnimation(int paramInt)
  {
    Iterator localIterator1 = this.mViewPages.iterator();
    int j = 0;
    View localView1;
    ViewHolder localViewHolder;
    Object localObject;
    int i;
    AdLandingPageBaseComp localAdLandingPageBaseComp;
    View localView2;
    int[] arrayOfInt;
    if (localIterator1.hasNext())
    {
      localView1 = (View)localIterator1.next();
      if ((localView1.getTag() instanceof ViewHolder))
      {
        localViewHolder = (ViewHolder)localView1.getTag();
        if ((paramInt > localView1.getMeasuredHeight() + j - localViewHolder.nextBtn.getHeight()) || (this.scrollView.getMeasuredHeight() + paramInt < localView1.getMeasuredHeight() + j)) {
          break label381;
        }
        if (!localViewHolder.isNextBtnDoingAnimation)
        {
          localObject = null;
          Iterator localIterator2 = this.componentList.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            localAdLandingPageBaseComp = (AdLandingPageBaseComp)localIterator2.next();
            localView2 = localAdLandingPageBaseComp.getView();
            arrayOfInt = new int[2];
            localView2.getLocationOnScreen(arrayOfInt);
            if ((this.componentList.getFirst() == null) || (this.componentList.getFirst() != localAdLandingPageBaseComp)) {
              break label411;
            }
            i = arrayOfInt[1];
          }
        }
      }
    }
    label408:
    label411:
    for (;;)
    {
      int k = arrayOfInt[1] - i;
      if (localView2.getMeasuredHeight() + k > localView1.getMeasuredHeight() + j)
      {
        if ((localObject == null) || ((!(localObject instanceof AdLandingPageStreamVideo)) && (!(localObject instanceof AdLandingPageSightVideo)))) {
          break label360;
        }
        beginStartDownAnimation(localViewHolder);
        label236:
        j = localView1.getMeasuredHeight() + j;
        break;
      }
      if (isComponentInScreenWithEdgeJudge(paramInt, this.scrollView.getMeasuredHeight(), k, localView2.getMeasuredHeight(), false, false)) {
        if ((paramInt <= j) || (this.scrollView.getMeasuredHeight() + paramInt > localView2.getMeasuredHeight() + k))
        {
          k = localView2.getMeasuredHeight() + k;
          label306:
          if ((k > localView1.getMeasuredHeight() + j) || (k < localView1.getMeasuredHeight() + j - localViewHolder.nextBtn.getHeight())) {
            break label408;
          }
          localObject = localAdLandingPageBaseComp;
        }
      }
      for (;;)
      {
        break;
        k = this.scrollView.getMeasuredHeight() + paramInt;
        break label306;
        label360:
        if (this.mViewPages.getLast() == localView1) {
          break label236;
        }
        beginStartDownAnimation(localViewHolder);
        break label236;
        label381:
        localViewHolder.isNextBtnDoingAnimation = false;
        localViewHolder.nextBtn.setVisibility(4);
        localViewHolder.nextBtn.clearAnimation();
        break label236;
        return;
      }
    }
  }
  
  public static Intent createIntent(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(NativePageManager.getInstance().getContext(), AdLandingPagesUI.class);
    localIntent.putExtra("ARG_LANDING_PAGE_XML", paramString1);
    localIntent.putExtra("ARG_LANDING_PAGE_XML_PREFIX", paramString2);
    return localIntent;
  }
  
  private void initData()
  {
    this.landingPagesXml = getIntent().getStringExtra("ARG_LANDING_PAGE_XML");
    this.landingPagesXmlPrex = getIntent().getStringExtra("ARG_LANDING_PAGE_XML_PREFIX");
    if ((this.landingPagesXmlPrex == null) || ("".equals(this.landingPagesXmlPrex))) {
      this.landingPagesXmlPrex = "adxml";
    }
    Object localObject = XmlParser.parseXml(this.landingPagesXml, this.landingPagesXmlPrex, null);
    if (localObject == null)
    {
      LogUtil.kvlog(6, "SnsAdNativeLandingPagesUI", "PARSE_XML_FAIL_EVENT");
      finish();
    }
    do
    {
      do
      {
        do
        {
          return;
          this.shareTitle = StringUtil.nullAs((String)((Map)localObject).get("." + this.landingPagesXmlPrex + ".adCanvasInfo.shareTitle"), "");
          this.shareUrl = StringUtil.nullAs((String)((Map)localObject).get("." + this.landingPagesXmlPrex + ".adCanvasInfo.shareWebUrl"), "");
          this.shareDesc = StringUtil.nullAs((String)((Map)localObject).get("." + this.landingPagesXmlPrex + ".adCanvasInfo.shareDesc"), "");
          this.disableShareBitSet = StringUtil.safeParseInt(StringUtil.nullAs((String)((Map)localObject).get("." + this.landingPagesXmlPrex + ".adCanvasInfo.disableShareBitSet"), ""));
          parseAdLandingPageDownIconInfo((Map)localObject, "." + this.landingPagesXmlPrex);
          this.landingPages = AdLandingPagesParseHelper.getADLandingPageInfos(this.landingPagesXml, this.landingPagesXmlPrex);
        } while (this.landingPages.size() <= 0);
        localObject = (AdLandingPageInfo)this.landingPages.get(0);
      } while (((AdLandingPageInfo)localObject).componetInfos.size() <= 0);
      localObject = (AdLandingPageComponentInfo)((AdLandingPageInfo)localObject).componetInfos.get(0);
      if ((localObject instanceof AdLandingPageComponentPureImageInfo))
      {
        this.sharethumbUrl = ((AdLandingPageComponentPureImageInfo)localObject).imgUrl;
        return;
      }
      if ((localObject instanceof AdLandingPageComponentPanoramaImageInfo))
      {
        this.sharethumbUrl = ((AdLandingPageComponentPanoramaImageInfo)localObject).imgUrl;
        return;
      }
    } while (!(localObject instanceof AdLandingPageComponentSightVideoInfo));
    this.sharethumbUrl = ((AdLandingPageComponentSightVideoInfo)localObject).sightThumbUrl;
  }
  
  private void initView()
  {
    this.pagesLinearLayout = ((LinearLayout)findViewById(2131372831));
    this.scrollView = ((PagesScrollView)findViewById(2131372825));
    this.galleryBg = ((ImageView)findViewById(2131367835));
    this.closeMaskIv = ((ImageView)findViewById(2131378529));
    this.closeBtn = ((ImageView)findViewById(2131378528));
    this.closeBtn.setOnClickListener(new AdLandingPagesUI.3(this));
    this.moreBtn = ((ImageView)findViewById(2131378540));
    this.moreBtn.setOnClickListener(new AdLandingPagesUI.4(this));
    this.firstPageDirectionBtn = ((ImageView)findViewById(2131378542));
    if ((this.landingPages == null) || (this.landingPages.size() == 0))
    {
      Log.e("SnsAdNativeLandingPagesUI", "landingPages is null");
      return;
    }
    loadLandingPages();
    Object localObject = (WindowManager)getSystemService("window");
    ((WindowManager)localObject).getDefaultDisplay().getWidth();
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight();
    this.adLandingPagesPreviewAnimation = new AdLandingPagesPreviewAnimation(getBaseContext());
    this.scrollView.setScrollViewListener(this);
    this.scrollView.startScrollerTask();
    localObject = ((AdLandingPageBaseComp)this.componentList.getFirst()).getView();
    ViewTreeObserver localViewTreeObserver = this.scrollView.getViewTreeObserver();
    localViewTreeObserver.addOnGlobalLayoutListener(new AdLandingPagesUI.5(this, i));
    if ((localObject != null) && (this.bNeedEnterAndExitAnimation))
    {
      this.adLandingPagesPreviewAnimation.setAnimationParam(this.thumbnailLeft, this.thumbnailTop, this.thumbnailWidth, this.thumbnailHeight);
      this.closeBtn.setVisibility(8);
      this.moreBtn.setVisibility(8);
      if (this.savedInstanceState == null) {
        localViewTreeObserver.addOnPreDrawListener(new AdLandingPagesUI.6(this, i, (View)localObject));
      }
    }
    for (;;)
    {
      componentDisappearChanged();
      return;
      this.scrollView.post(new AdLandingPagesUI.7(this));
      getWindow().setFlags(1024, 1024);
      setRequestedOrientation(1);
    }
  }
  
  private boolean isComponentInScreenWithEdgeJudge(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt3 + paramInt4 < paramInt1) || (paramInt3 > paramInt1 + paramInt2)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        return true;
        if (paramInt3 + paramInt4 == paramInt1)
        {
          if (paramBoolean1)
          {
            paramInt1 = 0;
            continue;
          }
          paramInt1 = 1;
          continue;
        }
        if (paramInt3 == paramInt1 + paramInt2)
        {
          if (paramBoolean2)
          {
            paramInt1 = 0;
            continue;
          }
          paramInt1 = 1;
        }
      }
      else
      {
        return false;
      }
      paramInt1 = 0;
    }
  }
  
  private boolean isControlledSmooth(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.controlledSmoothedy == -1) {}
    while (this.controlledSmoothedy < 0) {
      return false;
    }
    return true;
  }
  
  private void loadLandingPages()
  {
    Object localObject1 = (WindowManager)getSystemService("window");
    int m = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int n = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    this.mViewPages.clear();
    this.componentList.clear();
    LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
    int i = 0;
    if (i < this.landingPages.size())
    {
      AdLandingPageInfo localAdLandingPageInfo = (AdLandingPageInfo)this.landingPages.get(i);
      if (!localAdLandingPageInfo.ifCondition) {}
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (View)this.pageReuse.get(localAdLandingPageInfo.id);
        ViewHolder localViewHolder;
        label152:
        int k;
        Object localObject3;
        int j;
        if (localObject1 != null)
        {
          this.pagesLinearLayout.removeView((View)localObject1);
          if (((View)localObject1).getTag() == null) {
            break label326;
          }
          localViewHolder = (ViewHolder)((View)localObject1).getTag();
          k = 0;
          if ((localAdLandingPageInfo.backgroundCoverUrl == null) || (localAdLandingPageInfo.backgroundCoverUrl.length() <= 0)) {
            break label438;
          }
          localObject2 = localAdLandingPageInfo.backgroundCoverUrl;
          localObject3 = localViewHolder.bgIv;
          if (!this.bitmapCache.containsKey(localObject2)) {
            break label412;
          }
          ((ImageView)localObject3).setImageBitmap((Bitmap)this.bitmapCache.get(localObject2));
          j = k;
          label222:
          k = 0;
          label224:
          if (k >= localAdLandingPageInfo.componetInfos.size()) {
            break label672;
          }
          localObject2 = (AdLandingPageComponentInfo)localAdLandingPageInfo.componetInfos.get(k);
          if (!AdLandingPagesParseHelper.isBaseComponentInfoType(((AdLandingPageComponentInfo)localObject2).type)) {
            break label611;
          }
          localObject2 = AdLandingPagesLayoutHelper.LayoutBaseComponent(this, (AdLandingPageComponentInfo)localObject2, localViewHolder.linearLayout, localLayoutInflater, m, n, j);
          if ((localObject2 instanceof ALLandingAutoPlay)) {
            ((ALLandingAutoPlay)localObject2).setALLandingAutoPlayListener(this.autoPlayListener, k, false);
          }
        }
        for (;;)
        {
          k += 1;
          break label224;
          localObject1 = localLayoutInflater.inflate(2131558527, null);
          break;
          label326:
          localViewHolder = new ViewHolder(null);
          localViewHolder.bgIv = ((ImageView)((View)localObject1).findViewById(2131378527));
          localViewHolder.linearLayout = ((LinearLayout)((View)localObject1).findViewById(2131378541));
          localViewHolder.nextBtn = ((ImageView)((View)localObject1).findViewById(2131378543));
          localViewHolder.linearLayout.removeAllViewsInLayout();
          localViewHolder.linearLayout.setMinimumHeight(n);
          ((View)localObject1).setTag(localViewHolder);
          break label152;
          label412:
          AdLandingPagesDownloadResourceHelper.downloadImgForAdLandingPages((String)localObject2, new AdLandingPagesUI.8(this, localAdLandingPageInfo, localViewHolder, (View)localObject1, (ImageView)localObject3));
          j = k;
          break label222;
          label438:
          j = k;
          if (localAdLandingPageInfo.backgroundColor == null) {
            break label222;
          }
          j = k;
          if (localAdLandingPageInfo.backgroundColor.length() <= 0) {
            break label222;
          }
          k = Color.parseColor(localAdLandingPageInfo.backgroundColor);
          localViewHolder.bgIv.setVisibility(8);
          localViewHolder.bgIv.setBackgroundColor(k);
          localViewHolder.linearLayout.setBackgroundColor(k);
          ((View)localObject1).setBackgroundColor(k);
          if (k + 16777216 <= -1 - k)
          {
            localViewHolder.nextBtn.setImageDrawable(UIUtil.getDrawable(this, 2130842302));
            j = k;
            if (this.landingPages.getFirst() != localAdLandingPageInfo) {
              break label222;
            }
            this.firstPageDirectionBtn.setImageDrawable(UIUtil.getDrawable(this, 2130842302));
            j = k;
            break label222;
          }
          localViewHolder.nextBtn.setImageDrawable(UIUtil.getDrawable(this, 2130842301));
          j = k;
          if (this.landingPages.getFirst() != localAdLandingPageInfo) {
            break label222;
          }
          this.firstPageDirectionBtn.setImageDrawable(UIUtil.getDrawable(this, 2130842301));
          j = k;
          break label222;
          label611:
          if (AdLandingPagesParseHelper.isComponentGroupListType(((AdLandingPageComponentInfo)localObject2).type))
          {
            localObject2 = AdLandingPagesLayoutHelper.LayoutBaseComponent(getBaseContext(), (AdLandingPageComponentInfo)localObject2, localViewHolder.linearLayout, localLayoutInflater, m, n, j);
            if ((localObject2 instanceof ALLandingAutoPlay)) {
              ((ALLandingAutoPlay)localObject2).setALLandingAutoPlayListener(this.autoPlayListener, k, false);
            }
          }
        }
        label672:
        Object localObject2 = (CompRenderer)this.pageCompMap.get(Integer.valueOf(i));
        if (localObject2 == null)
        {
          localObject2 = new CompRenderer(localAdLandingPageInfo.componetInfos, this, j, localViewHolder.linearLayout);
          ((CompRenderer)localObject2).layout();
          this.pageCompMap.put(Integer.valueOf(i), localObject2);
        }
        for (;;)
        {
          localObject2 = ((CompRenderer)localObject2).getAllComp().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AdLandingPageBaseComp)((Iterator)localObject2).next();
            if ((localObject3 instanceof ALLandingAutoPlay)) {
              ((ALLandingAutoPlay)localObject3).setALLandingAutoPlayListener(this.autoPlayListener, this.componentList.size(), false);
            }
            this.componentList.add(localObject3);
          }
          ((CompRenderer)localObject2).notify(localAdLandingPageInfo.componetInfos);
        }
        if ((!this.componentList.isEmpty()) && (this.componentList.getLast() != null) && (((this.componentList.getLast() instanceof AdLandingPageStreamVideo)) || ((this.componentList.getLast() instanceof AdLandingPageSightVideo))))
        {
          localViewHolder.nextBtn.clearAnimation();
          localViewHolder.nextBtn.setVisibility(8);
          localViewHolder.nextBtn.setAlpha(0.0F);
        }
        if (this.landingPages.getLast() == localAdLandingPageInfo) {
          localViewHolder.nextBtn.setVisibility(8);
        }
        this.pagesLinearLayout.addView((View)localObject1);
        this.mViewPages.add(localObject1);
        this.pageReuse.put(localAdLandingPageInfo.id, localObject1);
      }
    }
  }
  
  private void parseAdLandingPageDownIconInfo(Map<String, String> paramMap, String paramString)
  {
    String str = (String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
    if (TextUtils.isEmpty(str))
    {
      this.pageDownIconInfo = null;
      return;
    }
    if (this.pageDownIconInfo == null) {
      this.pageDownIconInfo = new AdLandingPageDownIconInfo();
    }
    int m = StringUtil.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.sizeType"));
    int j = StringUtil.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.basicRootFontSize"));
    int k = StringUtil.safeParseInt((String)paramMap.get(paramString + ".adCanvasInfo.basicWidth"));
    int i = j;
    if (j == 0)
    {
      i = j;
      if (m == 1) {
        i = AdLandingPagesParseHelper.kDefaultBasicRootFontSize;
      }
    }
    j = k;
    if (k == 0)
    {
      j = k;
      if (m == 1) {
        j = AdLandingPagesParseHelper.kDefaultBasicWidth;
      }
    }
    this.pageDownIconInfo.iconUrl = str;
    this.pageDownIconInfo.paddingBottom = AdLandingPagesParseHelper.getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), m, j, i);
    this.pageDownIconInfo.width = AdLandingPagesParseHelper.getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), m, j, i);
    this.pageDownIconInfo.height = AdLandingPagesParseHelper.getPointsSizeFromXmlData(StringUtil.safeParseDouble((String)paramMap.get(paramString + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), m, j, i);
  }
  
  private void runExitAnimation()
  {
    this.cancelPageChangedInExitAnimation = true;
    Object localObject = this.componentList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AdLandingPageBaseComp)((Iterator)localObject).next()).viewWillDestroy();
    }
    if (!this.bNeedEnterAndExitAnimation)
    {
      finish();
      return;
    }
    this.scrollView.scrollTo(0, 0);
    if ((this.componentList != null) && (!this.componentList.isEmpty()) && (this.componentList.getFirst() != null))
    {
      localObject = ((AdLandingPageBaseComp)this.componentList.getFirst()).getView();
      this.adLandingPagesPreviewAnimation.setAnimationParam(this.thumbnailLeft, this.thumbnailTop, this.thumbnailWidth, this.thumbnailHeight);
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.componentList.iterator();
      while (localIterator.hasNext())
      {
        AdLandingPageBaseComp localAdLandingPageBaseComp = (AdLandingPageBaseComp)localIterator.next();
        if ((this.componentList.indexOf(localAdLandingPageBaseComp) != 0) && (localAdLandingPageBaseComp.getView() != null)) {
          localLinkedList.add(localAdLandingPageBaseComp.getView());
        }
      }
      Threads.runOnMainThread(new AdLandingPagesUI.18(this, (View)localObject, localLinkedList), 10);
      return;
    }
    finish();
    overridePendingTransition(0, 0);
  }
  
  private void setPageDownIcon(String paramString, ImageView paramImageView)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    if (Float.compare(this.pageDownIconInfo.width, 0.0F) > 0)
    {
      localLayoutParams.width = ((int)this.pageDownIconInfo.width);
      if (Float.compare(this.pageDownIconInfo.height, 0.0F) <= 0) {
        break label98;
      }
    }
    label98:
    for (localLayoutParams.height = ((int)this.pageDownIconInfo.height);; localLayoutParams.height = -2)
    {
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin = ((int)this.pageDownIconInfo.paddingBottom);
      }
      paramImageView.setImageBitmap(paramString);
      return;
      localLayoutParams.width = -1;
      break;
    }
  }
  
  private void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.controlledSmoothedOly != -1) {
      return;
    }
    this.controlledSmoothedy = paramInt2;
    this.controlledSmoothedOly = paramInt4;
    this.scrollView.smoothScrollTo(paramInt1, paramInt2);
    componentDisappearChanged(paramInt2);
    this.scrollView.setOnTouchListener(new AdLandingPagesUI.9(this));
    this.startedScrollY = paramInt2;
    Threads.runOnMainThread(new AdLandingPagesUI.10(this, this.controlledSmoothedy), 250);
  }
  
  private void startDownAnimation(ViewHolder paramViewHolder)
  {
    if (!paramViewHolder.isNextBtnDoingAnimation) {
      return;
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -10.0F);
    ((TranslateAnimation)localObject).setDuration(this.downIconSecondAnimationDuration);
    ((TranslateAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.8F, 0.3F);
    ((AlphaAnimation)localObject).setDuration(this.downIconSecondAnimationDuration);
    ((AlphaAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(new AdLandingPagesUI.17(this, paramViewHolder));
    paramViewHolder.nextBtn.startAnimation(localAnimationSet);
  }
  
  private void startFirstPageDirectionAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -10.0F);
    ((TranslateAnimation)localObject).setDuration(this.downIconSecondAnimationDuration);
    ((TranslateAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.8F, 0.3F);
    ((AlphaAnimation)localObject).setDuration(this.downIconSecondAnimationDuration);
    ((AlphaAnimation)localObject).setInterpolator(new DecelerateInterpolator(1.2F));
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(new AdLandingPagesUI.14(this));
    this.firstPageDirectionBtn.startAnimation(localAnimationSet);
  }
  
  public abstract void more();
  
  public void onBackPressed()
  {
    runExitAnimation();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    UIUtil.fullScreen(this);
    this.savedInstanceState = paramBundle;
    setContentView(2131563100);
    initData();
    initView();
    this.pageUIApplearTime = System.currentTimeMillis();
    setSwipeBackListener(new AdLandingPagesUI.2(this));
  }
  
  protected void onDestroy()
  {
    Iterator localIterator = this.componentList.iterator();
    while (localIterator.hasNext()) {
      ((AdLandingPageBaseComp)localIterator.next()).viewWillDestroy();
    }
    this.componentList.clear();
    super.onDestroy();
    DataUtil.collect("", "Event_Native_AD_Stay_Time", System.currentTimeMillis() - this.pageUIApplearTime);
    DataUtil.collect("", "Event_Native_AD_Module_Count", this.landingPages.size());
  }
  
  protected void onPause()
  {
    super.onPause();
    Iterator localIterator = this.componentList.iterator();
    while (localIterator.hasNext())
    {
      AdLandingPageBaseComp localAdLandingPageBaseComp = (AdLandingPageBaseComp)localIterator.next();
      if (localAdLandingPageBaseComp.getViewAppeared()) {
        localAdLandingPageBaseComp.viewWillDisappear();
      }
    }
    this.scrollView.stopScrollerTask();
  }
  
  protected void onResume()
  {
    super.onResume();
    componentDisappearChanged();
    this.scrollView.startScrollerTask();
  }
  
  public void onScrollChanged(PagesScrollView paramPagesScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.cancelPageChangedInExitAnimation) {}
    do
    {
      return;
      this.firstPageDirectionBtn.setVisibility(8);
      this.firstPageDirectionBtn.setAlpha(0.0F);
      controlCurrentPageDicretionDownAnimation(paramInt2);
    } while (isControlledSmooth(paramInt1, paramInt2, paramInt3, paramInt4));
    int j = this.startedScrollY;
    int k;
    int i;
    if (paramInt2 > j)
    {
      k = this.lastScrolledPage;
      paramInt1 = 0;
      paramInt4 = 0;
      while ((paramInt1 < this.mViewPages.size()) && (paramInt1 <= this.lastScrolledPage))
      {
        paramInt4 += ((View)this.mViewPages.get(paramInt1)).getMeasuredHeight();
        paramInt1 += 1;
      }
      paramInt1 = 0;
      i = 0;
      label116:
      if (paramInt1 >= this.mViewPages.size()) {
        break label477;
      }
      if ((((View)this.mViewPages.get(paramInt1)).getMeasuredHeight() + i < paramPagesScrollView.getMeasuredHeight() + paramInt2) || (paramPagesScrollView.getMeasuredHeight() + paramInt2 <= i)) {}
    }
    for (;;)
    {
      if (paramInt1 > k)
      {
        if ((j == paramInt4 - paramPagesScrollView.getMeasuredHeight()) && (paramInt2 - j >= 300))
        {
          smoothScrollTo(0, paramInt4, paramInt3, j);
          this.lastScrolledPage += 1;
          return;
          i += ((View)this.mViewPages.get(paramInt1)).getMeasuredHeight();
          paramInt1 += 1;
          break label116;
        }
        smoothScrollTo(0, paramInt4 - paramPagesScrollView.getMeasuredHeight(), paramInt3, j);
        return;
      }
      this.startedScrollY = paramInt2;
      componentDisappearChanged(paramInt2);
      return;
      if (paramInt2 >= j) {
        break;
      }
      k = this.lastScrolledPage;
      paramInt1 = 0;
      paramInt4 = 0;
      while ((paramInt1 < this.mViewPages.size()) && (paramInt1 < this.lastScrolledPage))
      {
        paramInt4 += ((View)this.mViewPages.get(paramInt1)).getMeasuredHeight();
        paramInt1 += 1;
      }
      paramInt1 = 0;
      i = 0;
      if (paramInt1 < this.mViewPages.size()) {
        if ((((View)this.mViewPages.get(paramInt1)).getMeasuredHeight() + i <= paramInt2) || (paramInt2 < i)) {}
      }
      for (;;)
      {
        if (paramInt1 < k)
        {
          if ((j == paramInt4) && (j - paramInt2 >= 300))
          {
            smoothScrollTo(0, paramInt4 - paramPagesScrollView.getMeasuredHeight(), paramInt3, j);
            this.lastScrolledPage -= 1;
            return;
            i += ((View)this.mViewPages.get(paramInt1)).getMeasuredHeight();
            paramInt1 += 1;
            break;
          }
          smoothScrollTo(0, paramInt4, paramInt3, j);
          return;
        }
        this.startedScrollY = paramInt2;
        componentDisappearChanged(paramInt2);
        return;
        paramInt1 = 0;
      }
      label477:
      paramInt1 = 0;
    }
  }
  
  public void onScrollStarted(int paramInt)
  {
    clearControlledSmoothInfo();
  }
  
  public void onScrollStopped(int paramInt1, int paramInt2)
  {
    clearControlledSmoothInfo();
  }
  
  protected void setSwipeBackListener(PagesScrollView.SwipeBackListener paramSwipeBackListener)
  {
    this.scrollView.setSwipeBackListener(paramSwipeBackListener);
  }
  
  static class ViewHolder
  {
    public ImageView bgIv = null;
    public boolean isNextBtnDoingAnimation = false;
    public LinearLayout linearLayout = null;
    public ImageView nextBtn = null;
    public int nextBtnAnimationCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI
 * JD-Core Version:    0.7.0.1
 */