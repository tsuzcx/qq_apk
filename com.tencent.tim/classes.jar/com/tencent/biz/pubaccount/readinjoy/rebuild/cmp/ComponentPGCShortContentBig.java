package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import apmj;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.o;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kwz;
import kxm;
import kxv;
import kxz;
import kys;
import lfu;
import lfv;
import lie;
import lrm;
import mas;
import mcu;
import mqq.os.MqqHandler;
import ndi;
import wja;

public class ComponentPGCShortContentBig
  extends ComponentContentBig
  implements View.OnClickListener
{
  public static int aQq = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
  public static String agf = "";
  private lfu a;
  private int aQr;
  private int aQs;
  private int aQt;
  private int aQu = 0;
  private FrameLayout aj;
  private boolean alW;
  private ViewGroup.LayoutParams c;
  private int imageHeight;
  private int imageWidth;
  private boolean isGif;
  private float js;
  private float jt;
  private float ju;
  private float jv;
  private float jw;
  private float jx;
  private int mScreenWidth;
  
  public ComponentPGCShortContentBig(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ComponentPGCShortContentBig(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentPGCShortContentBig(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean Dn()
  {
    if ((this.jdField_a_of_type_Lfu instanceof VideoView))
    {
      int i = ((VideoView)this.jdField_a_of_type_Lfu).getCurrentState();
      return (i != 5) && (i != 7) && (i != 6);
    }
    return false;
  }
  
  private boolean Do()
  {
    boolean bool = true;
    if ((this.js == 0.0F) || (this.jt == 0.0F) || (this.ju == 0.0F) || (this.jv == 0.0F) || (this.jw == 0.0F) || (this.jx == 0.0F) || (this.aQu == 0)) {
      return false;
    }
    long l;
    if ((this.jdField_a_of_type_Mas != null) && (this.jdField_a_of_type_Mas.a != null) && (this.jdField_a_of_type_Mas.a.a() != null)) {
      l = this.jdField_a_of_type_Mas.a.a().mChannelID;
    }
    while (this.aQu == 1) {
      if ((l == 0L) || (l == kys.getChannelId()))
      {
        return true;
        l = -1L;
      }
      else
      {
        return false;
      }
    }
    if (this.aQu == 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private String H(String paramString, int paramInt)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.contains("qpic.cn/qq_public"));
    return paramString.replaceAll("/\\d+($|\\?)", "/" + paramInt + "$1");
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramFloat1 /= paramFloat2;
    if (paramFloat1 < 0.667D)
    {
      paramLayoutParams.width = (paramInt * 2 / 3);
      paramLayoutParams.height = paramInt;
      return;
    }
    if ((0.667D <= paramFloat1) && (paramFloat1 <= 1.5D))
    {
      paramLayoutParams.width = ((int)(paramFloat1 * paramInt));
      paramLayoutParams.height = paramInt;
      nx("");
      return;
    }
    paramLayoutParams.width = ((int)(paramInt * 1.5D));
    paramLayoutParams.height = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramFloat1 /= paramFloat2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
    {
      if (paramFloat1 < 0.455D)
      {
        paramLayoutParams.width = paramInt2;
        paramLayoutParams.height = paramInt1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    if ((0.455D <= paramFloat1) && (paramFloat1 <= 0.7441D))
    {
      paramLayoutParams.width = paramInt2;
      paramLayoutParams.height = paramInt1;
      if (this.isGif)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    if ((0.7441D <= paramFloat1) && (paramFloat1 <= 1.3439D))
    {
      paramLayoutParams.width = paramInt1;
      paramLayoutParams.height = paramInt1;
      if (this.isGif)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    if ((1.3439D <= paramFloat1) && (paramFloat1 <= 2.2D))
    {
      paramLayoutParams.width = paramInt1;
      paramLayoutParams.height = paramInt2;
      if (this.isGif)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    paramLayoutParams.width = paramInt1;
    paramLayoutParams.height = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
  }
  
  private void a(int paramInt, SocializeFeedsInfo.n paramn)
  {
    if ((paramInt != this.aQr) || (this.aQt == 0))
    {
      if ((paramInt != this.aQr) || (!a(paramn)))
      {
        QLog.d("ComponentPGCShortContentBig", 2, "recreate video");
        if (this.jdField_a_of_type_Lfu != null)
        {
          QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "reset destroy");
          this.jdField_a_of_type_Lfu.aLU();
        }
        this.jdField_a_of_type_Lfu = lfv.a(paramInt, BaseApplicationImpl.getContext());
        if (paramInt == 1) {
          ((VideoView)this.jdField_a_of_type_Lfu).setUseVid(false);
        }
        if ((this.jdField_a_of_type_Lfu instanceof View))
        {
          this.aj.removeAllViews();
          if (this.c == null) {
            this.c = new ViewGroup.LayoutParams(-2, -2);
          }
          this.aj.addView((View)this.jdField_a_of_type_Lfu, this.c);
        }
        this.aQr = paramInt;
      }
    }
    else {
      return;
    }
    QLog.d("ComponentPGCShortContentBig", 1, "reuse video");
  }
  
  private void a(SocializeFeedsInfo.o paramo)
  {
    if ((paramo != null) && (this.jdField_a_of_type_Lfu != null))
    {
      this.jdField_a_of_type_Lfu.setMediaPlayVid(paramo.vid);
      this.jdField_a_of_type_Lfu.setMediaPlayUrl(null);
      this.jdField_a_of_type_Lfu.setMediaCoverUrl(paramo.pic_url);
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "set url " + null);
      if ((this.jdField_a_of_type_Lfu instanceof MediaVideoView))
      {
        kxz localkxz = kxv.a(paramo.vid);
        if ((localkxz == null) || (!localkxz.q(System.currentTimeMillis() / 1000L, 3600L))) {
          break label130;
        }
        nw(localkxz.url);
        QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "url hit");
      }
    }
    return;
    label130:
    QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "request url by vid " + paramo.vid);
    paramo = new mcu(this, paramo);
    ThreadManager.getFileThreadHandler().post(new ComponentPGCShortContentBig.2(this, paramo));
  }
  
  private boolean a(SocializeFeedsInfo.n paramn)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Lfu instanceof VideoView))
    {
      VideoView localVideoView = (VideoView)this.jdField_a_of_type_Lfu;
      return (paramn != null) && (paramn.b != null) && (paramn.b.vid != null) && (paramn.b.vid.equals(localVideoView.getVideoVid()));
    }
    if ((this.jdField_a_of_type_Lfu instanceof GifView))
    {
      if (!((GifView)this.jdField_a_of_type_Lfu).isPlaying()) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  private void aOA()
  {
    Context localContext = getContext();
    if ((this.jdField_a_of_type_Mas != null) && (this.jdField_a_of_type_Mas.a != null)) {}
    for (ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();; localArticleInfo = null)
    {
      lrm.b(localContext, localArticleInfo);
      return;
    }
  }
  
  private void aOa()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Mas == null) || (this.jdField_a_of_type_Mas.a == null) || (this.jdField_a_of_type_Mas.a.a() == null)) {
      return;
    }
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
    String str2 = n(localArticleInfo);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.contains("https")) {
        str1 = str2.replaceFirst("https", "http");
      }
    }
    localArrayList.add(str1);
    if ((aQq == 2) && (this.isGif)) {
      if (this.alW) {
        if (Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 0) {
          apmj.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
        }
      }
    }
    for (;;)
    {
      QLog.d("ComponentPGCShortContentBig", 1, "[showPicture] isGif " + this.isGif + ", urls : " + localArrayList);
      try
      {
        localArticleInfo.click_area = 9;
        kxm.b(this.jdField_a_of_type_Mas.a.b().getVafContext().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentPGCShortContentBig", 2, localNullPointerException.getLocalizedMessage());
        return;
      }
      aOA();
      continue;
      if (this.jdField_a_of_type_Lfu != null) {
        this.jdField_a_of_type_Lfu.aLR();
      }
      this.alW = true;
      continue;
      apmj.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
    }
  }
  
  private void aOs()
  {
    this.aQs = Aladdin.getConfig(205).getIntegerFromString("shortcontent_gif_video_type", 0);
    this.aQt = Aladdin.getConfig(212).getIntegerFromString("shortcontent_video_reuse", 0);
  }
  
  private void aOt()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(269);
    if (localAladdinConfig != null)
    {
      agf = localAladdinConfig.getString("shortcontent_report_key", "");
      this.js = localAladdinConfig.getFloatFromString("shortcontent_x_multipler", 0.0F);
      this.jt = localAladdinConfig.getFloatFromString("shortcontent_divisor", 0.0F);
      this.ju = localAladdinConfig.getFloatFromString("shortcontent_long_multiplier", 0.0F);
      this.jv = localAladdinConfig.getFloatFromString("shortcontent_width_multiplier", 0.0F);
      this.jw = localAladdinConfig.getFloatFromString("shortcontent_long_ratio", 0.0F);
      this.jx = localAladdinConfig.getFloatFromString("shortcontent_width_ratio", 0.0F);
      this.aQu = localAladdinConfig.getIntegerFromString("shortcontent_channel", 0);
    }
  }
  
  private void aOv()
  {
    if (this.jdField_a_of_type_Lfu != null)
    {
      String str1 = a(this.jdField_a_of_type_Mas.a).toString();
      String str2 = d(str1, this.v.getMeasuredWidth(), this.v.getMeasuredHeight());
      this.jdField_a_of_type_Lfu.setMediaCoverUrl(str2);
      this.jdField_a_of_type_Lfu.setMediaPlayUrl(str1);
    }
  }
  
  public static void aOw()
  {
    aQq = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
  }
  
  private void aOx()
  {
    if ((this.jdField_a_of_type_Mas == null) || (this.jdField_a_of_type_Mas.a == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Mas != null) && (this.jdField_a_of_type_Mas.a != null) && (this.jdField_a_of_type_Mas.a.a() != null) && (this.jdField_a_of_type_Mas.a.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Mas.a.a().mSocialFeedInfo.a != null) && (this.jdField_a_of_type_Mas.a.a().mSocialFeedInfo.a.kY != null)) {}
    for (ArrayList localArrayList = this.jdField_a_of_type_Mas.a.a().mSocialFeedInfo.a.kY;; localArrayList = null)
    {
      this.isGif = false;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.imageWidth = ((SocializeFeedsInfo.n)localArrayList.get(0)).pic_width;
        this.imageHeight = ((SocializeFeedsInfo.n)localArrayList.get(0)).pic_height;
        if (((SocializeFeedsInfo.n)localArrayList.get(0)).aSX == 1)
        {
          this.isGif = true;
          this.jdField_a_of_type_Mas.a().a().isShowGif = this.isGif;
          this.c = this.v.getLayoutParams();
          if (!Do()) {
            break label436;
          }
          QLog.d("ComponentPGCShortContentBig", 2, "configOptimizedImageLayoutParams");
          aOy();
        }
      }
      for (;;)
      {
        QLog.d("ComponentPGCSingleImage", 2, "imageParams.width is " + this.c.width + "; imageParams.height is " + this.c.height);
        this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.v.setLayoutParams(this.c);
        this.v.setPadding(0, 0, 0, 0);
        ((View)this.jdField_a_of_type_Lfu).setLayoutParams(this.c);
        ((View)this.jdField_a_of_type_Lfu).setPadding(0, 0, 0, 0);
        return;
        if (!this.jdField_a_of_type_Mas.a.a().isUseGif) {
          break;
        }
        this.isGif = true;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ComponentPGCShortContentBig", 2, "pgc pic info is null");
        }
        if (!this.jdField_a_of_type_Mas.a.a().isUseGif) {
          break;
        }
        this.isGif = true;
        break;
        label436:
        QLog.d("ComponentPGCShortContentBig", 2, "configDefaultdImageLayoutParams");
        aOz();
      }
    }
  }
  
  private void aOy()
  {
    int i = wja.dp2px(12.0F, getResources());
    int j = wja.dp2px(4.5F, getResources());
    i = (int)((this.mScreenWidth - (i * this.js + j)) / this.jt);
    this.c.height = i;
    if (this.imageWidth == 0)
    {
      this.c.width = i;
      nx("");
    }
    float f;
    do
    {
      return;
      f = this.imageHeight / this.imageWidth;
      if ((f >= this.jx) && (f <= this.jw))
      {
        this.c.width = ((int)(i / f));
        nx("");
        return;
      }
      if (f > this.jw)
      {
        this.c.width = ((int)(i * this.ju));
        return;
      }
    } while (f >= this.jx);
    this.c.width = ((int)(i * this.jv));
  }
  
  private void aOz()
  {
    int j = wja.dp2px(12.0F, getResources());
    int k = wja.dp2px(4.5F, getResources());
    int i = (this.mScreenWidth - (j * 2 + k * 2)) / 3 * 2 + k;
    j = (this.mScreenWidth - (j * 2 + k)) / 2;
    if ((this.imageWidth == 0) || (this.imageHeight == 0))
    {
      this.imageHeight = i;
      this.imageWidth = i;
    }
    if (this.jdField_a_of_type_Mas.a.a().mChannelID == 0L)
    {
      a(kwz.a(this.mScreenWidth, getResources()), this.imageWidth, this.imageHeight, this.c);
      return;
    }
    a(i, j, this.imageWidth, this.imageHeight, this.c);
  }
  
  private String d(String paramString, int paramInt1, int paramInt2)
  {
    int k = 0;
    int j = 0;
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.contains("qpic.cn/qq_public")) {
        break label31;
      }
      localObject = paramString;
    }
    label31:
    int i;
    String str;
    double[] arrayOfDouble1;
    String[] arrayOfString1;
    double[] arrayOfDouble2;
    String[] arrayOfString2;
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = new int[5];
          Object tmp38_36 = localObject;
          tmp38_36[0] = '´';
          Object tmp44_38 = tmp38_36;
          tmp44_38[1] = 'È';
          Object tmp50_44 = tmp44_38;
          tmp50_44[2] = 320;
          Object tmp56_50 = tmp50_44;
          tmp56_50[3] = 600;
          Object tmp62_56 = tmp56_50;
          tmp62_56[4] = 900;
          tmp62_56;
          i = 0;
          str = paramString;
          if (i < localObject.length)
          {
            if (paramInt1 - 20 > localObject[i]) {
              break label622;
            }
            str = H(paramString, localObject[i]);
          }
          arrayOfDouble1 = new double[15];
          double[] tmp115_113 = arrayOfDouble1;
          tmp115_113[0] = 0.62105D;
          double[] tmp121_115 = tmp115_113;
          tmp121_115[1] = 0.83158D;
          double[] tmp127_121 = tmp121_115;
          tmp127_121[2] = 0.93684D;
          double[] tmp133_127 = tmp127_121;
          tmp133_127[3] = 1.0D;
          double[] tmp137_133 = tmp133_127;
          tmp137_133[4] = 1.1049D;
          double[] tmp143_137 = tmp137_133;
          tmp143_137[5] = 1.11579D;
          double[] tmp149_143 = tmp143_137;
          tmp149_143[6] = 1.24476D;
          double[] tmp156_149 = tmp149_143;
          tmp156_149[7] = 1.25263D;
          double[] tmp163_156 = tmp156_149;
          tmp163_156[8] = 1.30526D;
          double[] tmp170_163 = tmp163_156;
          tmp170_163[9] = 1.66434D;
          double[] tmp177_170 = tmp170_163;
          tmp177_170[10] = 1.67368D;
          double[] tmp184_177 = tmp177_170;
          tmp184_177[11] = 1.80723D;
          double[] tmp191_184 = tmp184_177;
          tmp191_184[12] = 1.88421D;
          double[] tmp198_191 = tmp191_184;
          tmp198_191[13] = 2.5035D;
          double[] tmp205_198 = tmp198_191;
          tmp205_198[14] = 2.51579D;
          tmp205_198;
          arrayOfString1 = new String[15];
          arrayOfString1[0] = "59_95";
          arrayOfString1[1] = "79_95";
          arrayOfString1[2] = "89_95";
          arrayOfString1[3] = "280_280";
          arrayOfString1[4] = "158_143";
          arrayOfString1[5] = "212_190";
          arrayOfString1[6] = "178_143";
          arrayOfString1[7] = "119_95";
          arrayOfString1[8] = "248_190";
          arrayOfString1[9] = "238_143";
          arrayOfString1[10] = "159_95";
          arrayOfString1[11] = "750_415";
          arrayOfString1[12] = "179_95";
          arrayOfString1[13] = "358_143";
          arrayOfString1[14] = "239_95";
          arrayOfDouble2 = new double[5];
          double[] tmp341_339 = arrayOfDouble2;
          tmp341_339[0] = 0.5625D;
          double[] tmp347_341 = tmp341_339;
          tmp347_341[1] = 0.75D;
          double[] tmp353_347 = tmp347_341;
          tmp353_347[2] = 1.0D;
          double[] tmp357_353 = tmp353_347;
          tmp357_353[3] = 1.33333D;
          double[] tmp363_357 = tmp357_353;
          tmp363_357[4] = 1.77777D;
          tmp363_357;
          arrayOfString2 = new String[5];
          arrayOfString2[0] = "90_160";
          arrayOfString2[1] = "30_40";
          arrayOfString2[2] = "280_280";
          arrayOfString2[3] = "40_30";
          arrayOfString2[4] = "160_90";
          if (str.contains("_open")) {
            break;
          }
          localObject = str;
        } while (!str.contains("_vsmcut"));
        localObject = str;
      } while (str.contains("_open_"));
      localObject = str;
    } while (str.contains("_vsmcut_"));
    double d = paramInt1 / paramInt2;
    paramString = "";
    if (str.contains("_open"))
    {
      if (d < arrayOfDouble1[0]) {
        paramString = arrayOfString1[0];
      }
      paramInt1 = j;
      if (d > arrayOfDouble1[(arrayOfDouble1.length - 1)])
      {
        paramString = arrayOfString1[(arrayOfString1.length - 1)];
        paramInt1 = j;
      }
      for (;;)
      {
        localObject = paramString;
        if (paramInt1 < arrayOfDouble1.length - 1)
        {
          if ((d < arrayOfDouble1[paramInt1]) || (d >= arrayOfDouble1[(paramInt1 + 1)])) {
            break label642;
          }
          if (d - arrayOfDouble1[paramInt1] >= arrayOfDouble1[(paramInt1 + 1)] - d) {
            break label631;
          }
        }
        label622:
        label631:
        for (localObject = arrayOfString1[paramInt1];; localObject = arrayOfString1[(paramInt1 + 1)])
        {
          return str.replace("_open", "_open_" + (String)localObject);
          i += 1;
          break;
        }
        label642:
        paramInt1 += 1;
      }
    }
    if (d < arrayOfDouble2[0]) {
      paramString = arrayOfString2[0];
    }
    paramInt1 = k;
    if (d > arrayOfDouble2[(arrayOfDouble2.length - 1)])
    {
      paramString = arrayOfString2[(arrayOfString2.length - 1)];
      paramInt1 = k;
    }
    for (;;)
    {
      localObject = paramString;
      if (paramInt1 < arrayOfDouble2.length - 1)
      {
        if ((d < arrayOfDouble2[paramInt1]) || (d >= arrayOfDouble2[(paramInt1 + 1)])) {
          break label794;
        }
        if (d - arrayOfDouble2[paramInt1] >= arrayOfDouble2[(paramInt1 + 1)] - d) {
          break label783;
        }
      }
      label783:
      for (localObject = arrayOfString2[paramInt1];; localObject = arrayOfString2[(paramInt1 + 1)]) {
        return str.replace("_vsmcut", "_vsmcut_" + (String)localObject);
      }
      label794:
      paramInt1 += 1;
    }
  }
  
  private void h(lie paramlie)
  {
    if (paramlie != null)
    {
      paramlie = paramlie.a();
      if (paramlie != null)
      {
        if ((paramlie.mSocialFeedInfo == null) || (paramlie.mSocialFeedInfo.a == null) || (paramlie.mSocialFeedInfo.a.kY == null) || (paramlie.mSocialFeedInfo.a.kY.size() <= 0)) {
          break label142;
        }
        paramlie = (SocializeFeedsInfo.n)paramlie.mSocialFeedInfo.a.kY.get(0);
        if ((paramlie.b == null) || (this.aQs != 1)) {
          break label129;
        }
        a(1, paramlie);
        a(paramlie.b);
      }
    }
    for (;;)
    {
      this.v.setVisibility(8);
      ((View)this.jdField_a_of_type_Lfu).setVisibility(0);
      return;
      label129:
      a(0, paramlie);
      aOv();
      continue;
      label142:
      aOv();
    }
  }
  
  private void init()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mScreenWidth = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    aOs();
    aOt();
  }
  
  private String n(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.kY != null) && (paramArticleInfo.mSocialFeedInfo.a.kY.size() > 0))
    {
      localObject1 = (SocializeFeedsInfo.n)paramArticleInfo.mSocialFeedInfo.a.kY.get(0);
      if (TextUtils.isEmpty(((SocializeFeedsInfo.n)localObject1).pic_url)) {}
    }
    for (Object localObject1 = ((SocializeFeedsInfo.n)localObject1).pic_url;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if ((!TextUtils.isEmpty(paramArticleInfo.gifCoverUrl)) && (this.isGif)) {
          localObject2 = paramArticleInfo.gifCoverUrl;
        }
      }
      else {
        return localObject2;
      }
      return paramArticleInfo.mFirstPagePicUrl;
    }
  }
  
  private void nw(String paramString)
  {
    if ((this.jdField_a_of_type_Lfu != null) && ((this.jdField_a_of_type_Lfu instanceof VideoView)))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "set url " + paramString);
      ((MediaVideoView)this.jdField_a_of_type_Lfu).setVideoUrl(paramString);
      if (Dn()) {
        ((MediaVideoView)this.jdField_a_of_type_Lfu).pc();
      }
      if (((MediaVideoView)this.jdField_a_of_type_Lfu).getAction() == 3) {
        ((MediaVideoView)this.jdField_a_of_type_Lfu).kH();
      }
    }
  }
  
  private void nx(String paramString)
  {
    int i = 0;
    if (this.isGif)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      return;
    }
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      localKanDianRoundCornerTextView.setVisibility(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(paramString);
      return;
      i = 4;
    }
  }
  
  public void P(Object paramObject)
  {
    aOw();
    super.P(paramObject);
  }
  
  protected URL a(lie paramlie)
  {
    paramlie = paramlie.a();
    try
    {
      if (!TextUtils.isEmpty(n(paramlie))) {
        return new URL(n(paramlie));
      }
      URL localURL = paramlie.mSinglePicture;
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QLog.e("ComponentPGCShortContentBig", 1, localMalformedURLException.getMessage());
    }
    return paramlie.mSinglePicture;
  }
  
  protected void a(lie paramlie, ArticleInfo paramArticleInfo) {}
  
  public void aNf()
  {
    aOx();
  }
  
  public void aOu()
  {
    if ((this.jdField_a_of_type_Lfu != null) && (this.isGif))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "destroy play");
      this.jdField_a_of_type_Lfu.aLU();
    }
  }
  
  protected void c(lie paramlie)
  {
    this.alW = false;
    if (this.isGif) {
      h(paramlie);
    }
    for (;;)
    {
      ((View)this.jdField_a_of_type_Lfu).setClickable(true);
      ((View)this.jdField_a_of_type_Lfu).setOnClickListener(this);
      this.v.setClickable(true);
      this.v.setOnClickListener(this);
      return;
      ((View)this.jdField_a_of_type_Lfu).setVisibility(8);
      this.v.setVisibility(0);
      kwz.a(this.v, a(paramlie), getContext());
    }
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.aj = ((FrameLayout)paramView.findViewById(2131367197));
    this.aQr = -1;
    a(0, null);
  }
  
  protected int getLayoutId()
  {
    return 2131560302;
  }
  
  public boolean kH()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lfu != null)
    {
      bool1 = bool2;
      if (this.isGif)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Lfu.isPlaying())
        {
          bool1 = bool2;
          if (aQq == 3)
          {
            if (!(this.jdField_a_of_type_Lfu instanceof VideoView)) {
              break label66;
            }
            bool1 = ((VideoView)this.jdField_a_of_type_Lfu).kH();
          }
        }
      }
    }
    return bool1;
    label66:
    this.jdField_a_of_type_Lfu.aLR();
    return false;
  }
  
  protected int oK()
  {
    return 9;
  }
  
  public void onClick(View paramView)
  {
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 0) || (aQq == 2)) {
      aOa();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        this.jdField_a_of_type_Mas.a.a().click_area = oK();
        aOA();
        kxm.b(this.jdField_a_of_type_Mas.a.b().getVafContext().getContext(), this.jdField_a_of_type_Mas.a.a(), (int)this.jdField_a_of_type_Mas.a.a().mChannelID);
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentPGCShortContentBig", 2, localNullPointerException.getLocalizedMessage());
      }
    }
  }
  
  public void pausePlay()
  {
    if ((this.jdField_a_of_type_Lfu != null) && (this.isGif)) {
      this.jdField_a_of_type_Lfu.aLT();
    }
  }
  
  public void stopPlay()
  {
    if ((this.jdField_a_of_type_Lfu != null) && (this.isGif)) {
      this.jdField_a_of_type_Lfu.aLS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig
 * JD-Core Version:    0.7.0.1
 */