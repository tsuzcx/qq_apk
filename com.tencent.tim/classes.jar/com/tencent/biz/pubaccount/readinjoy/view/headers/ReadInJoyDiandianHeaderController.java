package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqbn;
import aqcx;
import axyb;
import com.tencent.biz.pubaccount.readinjoy.model.CommunityConfigInfo;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kbp;
import kgr;
import kxm;
import lcc;
import lce;
import lgp;
import nny;
import nnz;
import noa;
import nob;
import noc;
import noe;
import nsn;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xc90.RspBody;

public class ReadInJoyDiandianHeaderController
  extends nny
{
  private ViewPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter;
  public a a;
  private RollViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager;
  public String amV;
  public String amW;
  public String amX;
  public String amY;
  private Set<Long> ao = new HashSet();
  private FrameLayout ar;
  private boolean atF;
  private boolean atG;
  private kgr b;
  public int baC;
  public DisableSlideHorizontalListView c;
  public ColorDrawable d = new ColorDrawable(Color.parseColor("#e7e7e7"));
  public RelativeLayout fr;
  private List<DiandianTopConfig> kt = new ArrayList();
  private List<MeasureGridView> ku = new ArrayList();
  private List<Long> kv = new ArrayList();
  public List<CommunityConfigInfo> kw;
  private View[] m;
  public Context mContext;
  public Handler mHandler = new nnz(this, Looper.getMainLooper());
  private boolean mIsStop = true;
  private lce mObserver = new noa(this);
  private View mS;
  private View mT;
  protected View mU;
  public TextView tA;
  public TextView tz;
  
  public ReadInJoyDiandianHeaderController(Context paramContext)
  {
    this.mContext = paramContext;
    this.mS = LayoutInflater.from(paramContext).inflate(2131560353, null);
    this.mT = this.mS.findViewById(2131380074);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager = ((RollViewPager)this.mS.findViewById(2131381929));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter = new ViewPagerAdapter();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnPageChangeListener(new RollerChangeListener());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnTouchStateChangeListener(new nob(this));
    this.fr = ((RelativeLayout)this.mS.findViewById(2131365103));
    this.fr.setVisibility(8);
    this.tz = ((TextView)this.mS.findViewById(2131365106));
    this.tA = ((TextView)this.mS.findViewById(2131371941));
    this.c = ((DisableSlideHorizontalListView)this.mS.findViewById(2131365104));
    axyb localaxyb = new axyb(this.mContext, new LinearInterpolator());
    localaxyb.setScrollDuration(600);
    localaxyb.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager);
    this.mU = this.mS.findViewById(2131368452);
    lcc.a().b(this.mObserver);
    this.ar = ((FrameLayout)this.mS.findViewById(2131378967));
    this.b = new kgr((Activity)paramContext, this.ar);
  }
  
  private View getView(int paramInt)
  {
    MeasureGridView localMeasureGridView = new MeasureGridView(this.mContext);
    localMeasureGridView.setSelector(new ColorDrawable(0));
    d locald = new d(this.kt, paramInt);
    localMeasureGridView.setNumColumns(2);
    localMeasureGridView.setAdapter(locald);
    return localMeasureGridView;
  }
  
  private void refreshUI()
  {
    lgp.a().aMc();
  }
  
  public void aCG() {}
  
  public void aZG()
  {
    lgp.a().a(this.kv, new noc(this));
    if (this.ao.size() != 0)
    {
      kbp.a(null, "", "0X8009B9E", "0X8009B9E", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", this.ao.size() + "", "", false);
      this.ao.clear();
    }
  }
  
  public void e(ListView paramListView)
  {
    paramListView.addHeaderView(this.mS, 2);
    refreshUI();
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
  }
  
  public void onPause()
  {
    super.onPause();
    stop();
  }
  
  public void onRefresh()
  {
    this.c.setOnScrollStateChangedListener(new noe(this));
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void start()
  {
    this.mIsStop = false;
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 3000L);
  }
  
  public void stop()
  {
    this.mIsStop = true;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public class RollerChangeListener
    extends ViewPager.SimpleOnPageChangeListener
  {
    int baD = 0;
    
    protected RollerChangeListener() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      int j = 1;
      if (paramInt != 0) {}
      label137:
      for (;;)
      {
        return;
        int i = ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).getCurrentItem();
        ReadInJoyDiandianHeaderController.this.baC = i;
        int k = ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).getCount();
        if (k > 1)
        {
          if (i == 1)
          {
            ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).instantiateItem(null, k - 3);
            if (i != 0) {
              break label124;
            }
            paramInt = k - 3;
          }
          for (;;)
          {
            if (i == paramInt) {
              break label137;
            }
            ReadInJoyDiandianHeaderController.this.baC = paramInt;
            ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).setCurrentItem(paramInt, false);
            return;
            if (i != k - 3) {
              break;
            }
            ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).instantiateItem(null, 1);
            break;
            label124:
            paramInt = j;
            if (i != k - 2) {
              paramInt = i;
            }
          }
        }
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    
    public void onPageSelected(int paramInt)
    {
      int i = ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).getRealPosition(paramInt);
      if ((this.baD != i) && (ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this))) {
        kbp.a(null, "", "0X8009826", "0X8009826", 0, 0, "", "", "", "", false);
      }
      if ((i >= 0) && (this.baD >= 0)) {
        this.baD = i;
      }
      ReadInJoyDiandianHeaderController.d locald;
      if (ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).get(i) != null)
      {
        locald = (ReadInJoyDiandianHeaderController.d)((MeasureGridView)ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).get(i)).getAdapter();
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < locald.getCount())
        {
          DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)locald.getItem(paramInt);
          if ((localDiandianTopConfig != null) && (!localDiandianTopConfig.hasExposeReported)) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("folder_status", kxm.aMw);
              if (localDiandianTopConfig.type == 5) {
                localJSONObject.put("list_URL", localDiandianTopConfig.jumpUrl);
              }
              for (;;)
              {
                localJSONObject.put("type", localDiandianTopConfig.type);
                kbp.a(null, "", "0X80092FC", "0X80092FC", 0, 0, ReadInJoyDiandianHeaderController.b(ReadInJoyDiandianHeaderController.this).size() + "", i + 1 + "", localDiandianTopConfig.topicId + "", localJSONObject.toString(), false);
                localDiandianTopConfig.hasExposeReported = true;
                locald.a(paramInt, localDiandianTopConfig);
                break;
                localJSONObject.put("list_URL", "0");
              }
              QLog.e("ReadInJoyDiandianHeaderController", 2, localJSONException.toString());
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                break label339;
              }
            }
          }
        }
        else
        {
          return;
        }
        label339:
        paramInt += 1;
      }
    }
  }
  
  public class ViewPagerAdapter
    extends PagerAdapter
    implements nsn
  {
    private List<MeasureGridView> ku = new ArrayList();
    
    ViewPagerAdapter() {}
    
    public void add(List<MeasureGridView> paramList)
    {
      if (this.ku.size() > 0) {
        this.ku.clear();
      }
      this.ku.addAll(paramList);
      ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this, new View[getCount()]);
      notifyDataSetChanged();
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      QLog.d("ReadInJoyDiandianHeaderController", 2, "destroyItem position : " + paramInt + " object: " + paramObject);
      paramViewGroup.removeView((View)paramObject);
      if (paramInt < ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).length) {
        ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt] = null;
      }
    }
    
    public int getCount()
    {
      int i = ju();
      if (i <= 1) {
        return i;
      }
      return i + 3;
    }
    
    public int getItemPosition(Object paramObject)
    {
      paramObject = (MeasureGridView)paramObject;
      int i = this.ku.indexOf(paramObject);
      if (i >= 0) {
        return i;
      }
      return -2;
    }
    
    public float getPageWidth(int paramInt)
    {
      return 0.95F;
    }
    
    public int getRealPosition(int paramInt)
    {
      int j = ju();
      int i = 0;
      if (j > 1)
      {
        if (paramInt == 0) {
          i = j - 1;
        }
      }
      else {
        return i;
      }
      if (paramInt > j) {
        return paramInt - j - 1;
      }
      return paramInt - 1;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject1 = null;
      QLog.d("ReadInJoyDiandianHeaderController", 2, "instantiateItem " + paramViewGroup + "  " + paramInt);
      int i = ju();
      Object localObject2;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyDiandianHeaderController", 2, "data list count is 0");
          localObject2 = localObject1;
        }
      }
      do
      {
        return localObject2;
        if ((i > 1) && ((paramInt == 1) || (paramInt == i) || (paramInt == i + 1))) {
          if (paramViewGroup == null)
          {
            if (ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt] != null) {
              return ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt];
            }
          }
          else
          {
            if ((ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt] == null) || (ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt].getParent() != null)) {
              ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt] = ((View)instantiateItem(null, paramInt));
            }
            paramViewGroup.addView(ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt]);
            return ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt];
          }
        }
        i = getRealPosition(paramInt);
        localObject2 = (View)this.ku.get(i);
        localObject1 = localObject2;
        if (((View)localObject2).getParent() != null) {
          localObject1 = ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this, i);
        }
        ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this)[paramInt] = localObject1;
        QLog.d("ReadInJoyDiandianHeaderController", 2, "childs " + paramInt);
        localObject2 = localObject1;
      } while (paramViewGroup == null);
      paramViewGroup.addView((View)localObject1);
      return localObject1;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public int ju()
    {
      if (this.ku == null) {
        return 0;
      }
      return this.ku.size();
    }
  }
  
  public class a
    extends BaseAdapter
  {
    int AS;
    List<CommunityConfigInfo> jl;
    
    public a()
    {
      Object localObject;
      this.jl = localObject;
    }
    
    public int getCount()
    {
      return this.jl.size() + 1;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.jl != null) && (paramInt < getCount() - 1) && (paramInt >= 0)) {
        return this.jl.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ReadInJoyDiandianHeaderController.c localc;
      if (paramView == null)
      {
        localc = new ReadInJoyDiandianHeaderController.c(null);
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560352, null);
        localc.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131368923));
        localc.nameView = ((TextView)paramView.findViewById(2131365105));
        localc.tB = ((TextView)paramView.findViewById(2131365472));
        localc.kP = ((ImageView)paramView.findViewById(2131370134));
        localc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$e = new ReadInJoyDiandianHeaderController.e(ReadInJoyDiandianHeaderController.this, null);
        paramView.setTag(localc);
        paramView.setOnClickListener(localc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$e);
        localc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$e.position = paramInt;
        if (paramInt >= this.jl.size()) {
          break label557;
        }
        CommunityConfigInfo localCommunityConfigInfo = (CommunityConfigInfo)this.jl.get(paramInt);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ReadInJoyDiandianHeaderController.this.d;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ReadInJoyDiandianHeaderController.this.d;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aqcx.dip2px(paramView.getContext(), 60.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aqcx.dip2px(paramView.getContext(), 60.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        if (TextUtils.isEmpty(localCommunityConfigInfo.picUrl)) {
          break label495;
        }
        localObject = URLDrawable.getDrawable(localCommunityConfigInfo.picUrl, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTag(aqbn.e(aqcx.dip2px(paramView.getContext(), 60.0F), aqcx.dip2px(paramView.getContext(), 60.0F)));
        localc.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable((Drawable)localObject);
        localc.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(aqcx.dip2px(paramView.getContext(), 2.0F));
        if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
          ((URLDrawable)localObject).restartDownload();
        }
        label313:
        if (localCommunityConfigInfo.dynamicCount <= 0) {
          break label513;
        }
        localc.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#7F000000"));
        int i = localCommunityConfigInfo.dynamicCount;
        localc.tB.setText(i + "");
        localObject = Typeface.create(Typeface.createFromAsset(paramView.getContext().getAssets(), "qzone_din.ttf"), 0);
        localc.tB.setTypeface((Typeface)localObject);
        localc.tB.setVisibility(0);
        label406:
        localc.nameView.setText(localCommunityConfigInfo.name);
        localc.kP.setVisibility(8);
        ReadInJoyDiandianHeaderController.a(ReadInJoyDiandianHeaderController.this).add(Long.valueOf(localCommunityConfigInfo.bid));
        if (this.AS <= paramInt) {
          break label540;
        }
        ReadInJoyDiandianHeaderController.b(ReadInJoyDiandianHeaderController.this, false);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localc = (ReadInJoyDiandianHeaderController.c)paramView.getTag();
        break;
        label495:
        localc.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(ReadInJoyDiandianHeaderController.this.d);
        break label313;
        label513:
        localc.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#00000000"));
        localc.tB.setVisibility(8);
        break label406;
        label540:
        ReadInJoyDiandianHeaderController.b(ReadInJoyDiandianHeaderController.this, true);
        this.AS = paramInt;
        continue;
        label557:
        localc.kP.setVisibility(0);
        localc.tB.setVisibility(8);
        localc.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(Color.parseColor("#F2F2F2"));
        kbp.a(null, "", "0X8009BA2", "0X8009BA2", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", "", "", false);
      }
    }
  }
  
  public abstract class b
  {
    public b() {}
    
    public void a(boolean paramBoolean, int paramInt, oidb_0xc90.RspBody paramRspBody) {}
  }
  
  static class c
  {
    ReadInJoyDiandianHeaderController.e jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$e;
    SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
    ImageView kP;
    TextView nameView;
    TextView tB;
  }
  
  public class d
    extends BaseAdapter
  {
    private List<DiandianTopConfig> jl = new ArrayList();
    private int p;
    
    public d(int paramInt)
    {
      this.p = i;
      int j = i * 2;
      int i = j;
      while ((i < paramInt.size()) && (i < j + 2))
      {
        this.jl.add(paramInt.get(i));
        i += 1;
      }
    }
    
    public Object a(int paramInt, DiandianTopConfig paramDiandianTopConfig)
    {
      return this.jl.set(paramInt, paramDiandianTopConfig);
    }
    
    public int getCount()
    {
      return this.jl.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.jl.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    /* Error */
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:jl	Ljava/util/List;
      //   4: iload_1
      //   5: invokeinterface 38 2 0
      //   10: checkcast 62	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig
      //   13: astore 5
      //   15: aload_2
      //   16: ifnonnull +414 -> 430
      //   19: new 64	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g
      //   22: dup
      //   23: aconst_null
      //   24: invokespecial 67	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:<init>	(Lnnz;)V
      //   27: astore 4
      //   29: aload_3
      //   30: invokevirtual 73	android/view/ViewGroup:getContext	()Landroid/content/Context;
      //   33: invokestatic 79	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   36: ldc 80
      //   38: aconst_null
      //   39: invokevirtual 84	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
      //   42: astore_2
      //   43: aload 4
      //   45: aload_2
      //   46: ldc 85
      //   48: invokevirtual 91	android/view/View:findViewById	(I)Landroid/view/View;
      //   51: checkcast 93	com/tencent/image/URLImageView
      //   54: putfield 96	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:I	Lcom/tencent/image/URLImageView;
      //   57: aload 4
      //   59: aload_2
      //   60: ldc 97
      //   62: invokevirtual 91	android/view/View:findViewById	(I)Landroid/view/View;
      //   65: checkcast 99	android/widget/TextView
      //   68: putfield 103	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:tC	Landroid/widget/TextView;
      //   71: aload 4
      //   73: aload_2
      //   74: ldc 104
      //   76: invokevirtual 91	android/view/View:findViewById	(I)Landroid/view/View;
      //   79: checkcast 99	android/widget/TextView
      //   82: putfield 107	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:titleView	Landroid/widget/TextView;
      //   85: aload 4
      //   87: aload_2
      //   88: ldc 108
      //   90: invokevirtual 91	android/view/View:findViewById	(I)Landroid/view/View;
      //   93: checkcast 99	android/widget/TextView
      //   96: putfield 111	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:tD	Landroid/widget/TextView;
      //   99: aload 4
      //   101: new 113	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$f
      //   104: dup
      //   105: aload_0
      //   106: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
      //   109: aconst_null
      //   110: invokespecial 116	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$f:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;Lnnz;)V
      //   113: putfield 119	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$f;
      //   116: aload_2
      //   117: aload 4
      //   119: invokevirtual 123	android/view/View:setTag	(Ljava/lang/Object;)V
      //   122: aload_2
      //   123: aload 4
      //   125: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$f;
      //   128: invokevirtual 127	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   131: aload 4
      //   133: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$f;
      //   136: aload_0
      //   137: getfield 28	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:p	I
      //   140: iconst_2
      //   141: imul
      //   142: iload_1
      //   143: iadd
      //   144: putfield 130	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$f:position	I
      //   147: invokestatic 136	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
      //   150: astore 6
      //   152: aload 6
      //   154: aload_0
      //   155: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
      //   158: getfield 139	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:d	Landroid/graphics/drawable/ColorDrawable;
      //   161: putfield 143	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
      //   164: aload 6
      //   166: aload_0
      //   167: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
      //   170: getfield 139	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:d	Landroid/graphics/drawable/ColorDrawable;
      //   173: putfield 146	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
      //   176: aload 6
      //   178: iconst_1
      //   179: putfield 150	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
      //   182: aload 5
      //   184: getfield 154	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:picUrl	Ljava/lang/String;
      //   187: aload 6
      //   189: invokestatic 160	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
      //   192: astore 6
      //   194: aload 6
      //   196: aload_2
      //   197: invokevirtual 161	android/view/View:getContext	()Landroid/content/Context;
      //   200: ldc 162
      //   202: invokestatic 168	aqcx:dip2px	(Landroid/content/Context;F)I
      //   205: aload_2
      //   206: invokevirtual 161	android/view/View:getContext	()Landroid/content/Context;
      //   209: ldc 162
      //   211: invokestatic 168	aqcx:dip2px	(Landroid/content/Context;F)I
      //   214: invokestatic 174	aqbn:e	(II)[I
      //   217: invokevirtual 175	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
      //   220: aload 4
      //   222: getfield 96	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:I	Lcom/tencent/image/URLImageView;
      //   225: aload 6
      //   227: invokevirtual 179	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
      //   230: aload 6
      //   232: invokevirtual 182	com/tencent/image/URLDrawable:getStatus	()I
      //   235: iconst_1
      //   236: if_icmpeq +16 -> 252
      //   239: aload 6
      //   241: invokevirtual 182	com/tencent/image/URLDrawable:getStatus	()I
      //   244: ifeq +8 -> 252
      //   247: aload 6
      //   249: invokevirtual 185	com/tencent/image/URLDrawable:restartDownload	()V
      //   252: aload 5
      //   254: getfield 188	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:type	I
      //   257: iconst_3
      //   258: if_icmpne +184 -> 442
      //   261: aload 4
      //   263: getfield 103	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:tC	Landroid/widget/TextView;
      //   266: iconst_0
      //   267: invokevirtual 192	android/widget/TextView:setVisibility	(I)V
      //   270: aload 4
      //   272: getfield 107	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:titleView	Landroid/widget/TextView;
      //   275: aload 5
      //   277: getfield 195	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:title	Ljava/lang/String;
      //   280: invokevirtual 199	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   283: aload 5
      //   285: getfield 202	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
      //   288: invokestatic 208	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   291: ifne +234 -> 525
      //   294: aload 4
      //   296: getfield 111	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:tD	Landroid/widget/TextView;
      //   299: aload 5
      //   301: getfield 202	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
      //   304: invokestatic 214	android/graphics/Color:parseColor	(Ljava/lang/String;)I
      //   307: invokevirtual 217	android/widget/TextView:setTextColor	(I)V
      //   310: aload 4
      //   312: getfield 111	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:tD	Landroid/widget/TextView;
      //   315: aload 5
      //   317: getfield 220	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitle	Ljava/lang/String;
      //   320: invokevirtual 199	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   323: aload_0
      //   324: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
      //   327: invokestatic 224	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:c	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;)Z
      //   330: ifne +84 -> 414
      //   333: new 226	org/json/JSONObject
      //   336: dup
      //   337: invokespecial 227	org/json/JSONObject:<init>	()V
      //   340: astore 4
      //   342: aload 4
      //   344: ldc 229
      //   346: getstatic 234	kxm:aMw	I
      //   349: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
      //   352: pop
      //   353: aconst_null
      //   354: ldc 240
      //   356: ldc 242
      //   358: ldc 242
      //   360: iconst_0
      //   361: iconst_0
      //   362: new 244	java/lang/StringBuilder
      //   365: dup
      //   366: invokespecial 245	java/lang/StringBuilder:<init>	()V
      //   369: aload_0
      //   370: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
      //   373: invokestatic 249	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:b	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;)Ljava/util/List;
      //   376: invokeinterface 34 1 0
      //   381: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   384: ldc 240
      //   386: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   389: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   392: ldc 240
      //   394: ldc 240
      //   396: aload 4
      //   398: invokevirtual 261	org/json/JSONObject:toString	()Ljava/lang/String;
      //   401: iconst_0
      //   402: invokestatic 266	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
      //   405: aload_0
      //   406: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:a	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
      //   409: iconst_1
      //   410: invokestatic 269	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;Z)Z
      //   413: pop
      //   414: invokestatic 275	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
      //   417: iload_1
      //   418: aload_2
      //   419: aload_3
      //   420: aload_0
      //   421: iload_1
      //   422: invokevirtual 277	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$d:getItemId	(I)J
      //   425: invokevirtual 281	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
      //   428: aload_2
      //   429: areturn
      //   430: aload_2
      //   431: invokevirtual 285	android/view/View:getTag	()Ljava/lang/Object;
      //   434: checkcast 64	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g
      //   437: astore 4
      //   439: goto -308 -> 131
      //   442: aload 4
      //   444: getfield 103	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:tC	Landroid/widget/TextView;
      //   447: bipush 8
      //   449: invokevirtual 192	android/widget/TextView:setVisibility	(I)V
      //   452: goto -182 -> 270
      //   455: astore 6
      //   457: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   460: ifeq +48 -> 508
      //   463: ldc_w 293
      //   466: iconst_2
      //   467: new 244	java/lang/StringBuilder
      //   470: dup
      //   471: invokespecial 245	java/lang/StringBuilder:<init>	()V
      //   474: ldc_w 295
      //   477: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   480: aload 5
      //   482: getfield 202	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
      //   485: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   488: ldc_w 297
      //   491: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   494: aload 6
      //   496: invokevirtual 298	java/lang/Exception:toString	()Ljava/lang/String;
      //   499: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   502: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   505: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   508: aload 4
      //   510: getfield 111	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:tD	Landroid/widget/TextView;
      //   513: ldc_w 303
      //   516: invokestatic 214	android/graphics/Color:parseColor	(Ljava/lang/String;)I
      //   519: invokevirtual 217	android/widget/TextView:setTextColor	(I)V
      //   522: goto -212 -> 310
      //   525: aload 4
      //   527: getfield 111	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$g:tD	Landroid/widget/TextView;
      //   530: ldc_w 303
      //   533: invokestatic 214	android/graphics/Color:parseColor	(Ljava/lang/String;)I
      //   536: invokevirtual 217	android/widget/TextView:setTextColor	(I)V
      //   539: goto -229 -> 310
      //   542: astore 4
      //   544: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   547: ifeq -133 -> 414
      //   550: ldc_w 293
      //   553: iconst_2
      //   554: aload 4
      //   556: invokevirtual 304	org/json/JSONException:toString	()Ljava/lang/String;
      //   559: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   562: goto -148 -> 414
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	565	0	this	d
      //   0	565	1	paramInt	int
      //   0	565	2	paramView	View
      //   0	565	3	paramViewGroup	ViewGroup
      //   27	499	4	localObject1	Object
      //   542	13	4	localJSONException	JSONException
      //   13	468	5	localDiandianTopConfig	DiandianTopConfig
      //   150	98	6	localObject2	Object
      //   455	40	6	localException	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   294	310	455	java/lang/Exception
      //   333	414	542	org/json/JSONException
    }
  }
  
  class e
    implements View.OnClickListener
  {
    public int position;
    
    private e() {}
    
    public void onClick(View paramView)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      String str;
      if (this.position != ReadInJoyDiandianHeaderController.this.kw.size())
      {
        CommunityConfigInfo localCommunityConfigInfo = (CommunityConfigInfo)ReadInJoyDiandianHeaderController.this.kw.get(this.position);
        str = localCommunityConfigInfo.jumpUrl;
        paramView.postDelayed(new ReadInJoyDiandianHeaderController.OnCommunityItemListener.1(this, paramView), 300L);
        kbp.a(null, "", "0X8009B9F", "0X8009B9F", 0, 0, localQQAppInterface.getCurrentAccountUin(), localCommunityConfigInfo.bid + "", this.position + 1 + "", "", false);
      }
      for (;;)
      {
        kxm.aJ(paramView.getContext(), str);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str = ReadInJoyDiandianHeaderController.this.amY;
        kbp.a(null, "", "0X8009BA3", "0X8009BA3", 0, 0, localQQAppInterface.getCurrentAccountUin(), "", "", "", false);
      }
    }
  }
  
  class f
    implements View.OnClickListener
  {
    public int position;
    
    private f() {}
    
    public void onClick(View paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDiandianHeaderController", 2, "onItemClick: " + this.position);
      }
      DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)ReadInJoyDiandianHeaderController.b(ReadInJoyDiandianHeaderController.this).get(this.position);
      kxm.aJ(paramView.getContext(), localDiandianTopConfig.jumpUrl);
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("folder_status", kxm.aMw);
          if (localDiandianTopConfig.type != 5) {
            continue;
          }
          localJSONObject.put("list_URL", localDiandianTopConfig.jumpUrl);
          localJSONObject.put("type", localDiandianTopConfig.type);
          kbp.a(null, "", "0X80092FD", "0X80092FD", 0, 0, ReadInJoyDiandianHeaderController.b(ReadInJoyDiandianHeaderController.this).size() + "", this.position + 1 + "", localDiandianTopConfig.topicId + "", localJSONObject.toString(), false);
        }
        catch (JSONException localJSONException)
        {
          JSONObject localJSONObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoyDiandianHeaderController", 2, localJSONException.toString());
          continue;
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localJSONObject.put("list_URL", "0");
      }
    }
  }
  
  static class g
  {
    URLImageView I;
    ReadInJoyDiandianHeaderController.f a;
    TextView tC;
    TextView tD;
    TextView titleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController
 * JD-Core Version:    0.7.0.1
 */