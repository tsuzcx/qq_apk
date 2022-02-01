package com.tencent.biz.qqstory.takevideo;

import acfp;
import alzf;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqgz;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import prw;
import prw.a;
import psd;
import psr;
import psx;
import ram;
import rar;
import ras;
import rbb;
import rcj;
import rck;
import rdb;
import rdc;
import rdo;
import rja;
import rja.a;
import rjb;
import rje;
import rjg;
import rjg.a;
import rkm;

public class EditVideoFilter
  extends rdb
  implements rbb
{
  public static final String azC = acfp.m(2131705559);
  public static final String azD = acfp.m(2131705550);
  public static final String azE = acfp.m(2131705677);
  public static final String azF = acfp.m(2131705634);
  public static final String azG = acfp.m(2131705574);
  public static final String azH = acfp.m(2131705565);
  public static final String azI = acfp.m(2131705502);
  public static final String azJ = acfp.m(2131705496);
  public long BJ;
  private SparseIntArray G = new SparseIntArray();
  protected FilterPagerAdapter a;
  public UnHandleTouchEventViewPager a;
  protected rjb a;
  protected SparseArray<rja> aT = new SparseArray();
  public int bpX;
  protected View oH;
  
  public EditVideoFilter(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  public static int a(@NonNull rja paramrja)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + paramrja.bsq);
    switch (paramrja.bsq)
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 5;
    case 3: 
      return 2;
    case 4: 
      return 6;
    case 5: 
      return 7;
    case 6: 
      return 8;
    }
    return 9;
  }
  
  protected static void a(rja.a parama)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    parama.mItemView.startAnimation(localAlphaAnimation);
  }
  
  private void setVisibility(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getVisibility() != paramInt) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setVisibility(paramInt);
      }
    } while (this.oH.getVisibility() == paramInt);
    this.oH.setVisibility(paramInt);
  }
  
  public rjb a()
  {
    return this.jdField_a_of_type_Rjb;
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    super.a(paramInt, paramrkm);
    Object localObject2 = a();
    if (localObject2 != null) {
      paramrkm.g.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().mi(), ((rjb)localObject2).country, ((rjb)localObject2).city, ((rjb)localObject2).province, ((rjb)localObject2).street, ((rjb)localObject2).building, ((rjb)localObject2).longitude, ((rjb)localObject2).latitude, ((rjb)localObject2).coordinate);
    }
    Object localObject1 = (rja)this.aT.get(paramInt);
    if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof rjb))) {
      paramrkm.g.gpsFilterDescription = ((rjb)localObject2).mY();
    }
    if (this.b.a.Ld()) {
      paramrkm.g.localCreateCity = this.b.a.getStringExtra("extra_local_address_city_name");
    }
    paramrkm.dS(ax());
    paramrkm.g.saveMode = ee(paramInt);
    paramrkm.g.putExtra("useFlowDecode", Boolean.valueOf(alzf.aHn));
    paramrkm = "";
    int i = -1;
    paramInt = 0;
    if (localObject1 != null)
    {
      paramrkm = ((rja)localObject1).aAH;
      i = ((rja)localObject1).bsr;
      paramInt = ((rja)localObject1).bsq;
    }
    long l;
    if (i != -1)
    {
      localObject2 = this.b;
      int j = this.b.tk();
      if (this.b.La())
      {
        localObject1 = "2";
        ((rdc)localObject2).d("pub_filter_menu", j, 0, new String[] { String.valueOf(i), paramrkm, localObject1 });
      }
    }
    else
    {
      if (i != -1) {
        ras.g("0X80076E9", String.valueOf(ras.bpq), String.valueOf(paramInt), paramrkm, String.valueOf(i));
      }
      l = System.currentTimeMillis() - this.BJ;
      paramInt = this.bpX;
      ram.b("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.b.La()) {
        break label397;
      }
    }
    label397:
    for (paramrkm = "2";; paramrkm = "1")
    {
      rar.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), paramrkm });
      return;
      localObject1 = "1";
      break;
    }
  }
  
  public boolean a(int paramInt1, Canvas paramCanvas, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    paramInt1 = this.G.get(paramInt1);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight();
    if (localObject2 != null)
    {
      if (!((rja.a)localObject2).LD()) {
        break label226;
      }
      localObject1 = ((rja.a)localObject2).mItemView;
      localObject2 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        paramCanvas.save();
        paramCanvas.scale(paramInt2 / i, paramInt3 / j);
        ((View)localObject1).draw(paramCanvas);
        paramCanvas.restore();
        if (localObject2 != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.destroyItem((ViewGroup)localObject1, paramInt1, localObject2);
        }
        return true;
        localObject1 = new FrameLayout(getContext());
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams()));
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.instantiateItem((ViewGroup)localObject1, paramInt1);
        ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getMeasuredHeight(), 1073741824));
        ((View)localObject1).layout(0, 0, this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight());
      }
      else
      {
        return false;
        label226:
        localObject2 = null;
      }
    }
  }
  
  public void aQ(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.aQ(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.notifyDataSetChanged();
  }
  
  @Nullable
  public View ax()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (rja)this.aT.get(i);
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if ((localObject != null) && (((rja.a)localObject).LD())) {
      return ((rja.a)localObject).mItemView;
    }
    return null;
  }
  
  protected void bsJ()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = getContext();
      if ((localObject != null) && (((Context)localObject).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
        return;
      }
    }
    String str2 = null;
    String str3 = null;
    Object localObject = null;
    String str1 = null;
    String str4 = null;
    int k = 0;
    int m = 0;
    prw localprw = (prw)((psd)psx.a(20)).a(1);
    prw.a locala = (prw.a)localprw.getData();
    int i;
    if (locala != null)
    {
      ram.d("Q.qqstory.publish.edit.EditVideoFilter", "get address from cache.");
      str2 = locala.country;
      str3 = locala.province;
      localObject = locala.city;
      str1 = locala.district;
      str4 = locala.street;
      k = locala.longitude;
      m = locala.latitude;
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(str1))) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0)
      {
        ram.d("Q.qqstory.publish.edit.EditVideoFilter", "get address from sp.");
        str2 = localprw.mq();
        str3 = localprw.mr();
        localObject = localprw.ms();
        str1 = localprw.mt();
        str4 = localprw.mu();
        k = localprw.su();
        m = localprw.sv();
        long l = localprw.dH();
        if (((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str1))) || ((float)(System.currentTimeMillis() - l) >= 1800000.0F)) {
          break label305;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label318;
        }
        ram.d("Q.qqstory.publish.edit.EditVideoFilter", "get address from net.");
        localprw.biW();
        return;
        ram.d("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty.");
        i = 0;
        break;
        label305:
        ram.d("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty or overTime.");
      }
      label318:
      this.jdField_a_of_type_Rjb = new rjb(0, azJ, 8, (String)localObject, str1, str2, (String)localObject, str3, str4, "", k, m, 1);
      return;
      i = 0;
    }
  }
  
  public void bsK()
  {
    ram.b("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.b.a.a);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new rjg("", -1, 0, 0));
    boolean bool;
    if (((this.b.a.a instanceof EditRecordVideoSource)) || ((this.b.a.a instanceof EditTakeVideoSource)))
    {
      if (((this.b.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((psr)psx.a(10)).c("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.b.a.a instanceof EditTakeVideoSource)) || (bool)) {
            break label444;
          }
          ram.w("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.b.a.a instanceof EditTakeVideoSource)) || (alzf.cBz)) {
          break label509;
        }
        ram.w("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
    }
    else
    {
      label247:
      localArrayList.add(new rje(0, azI, 7, this.b.a));
      if (this.jdField_a_of_type_Rjb != null) {
        localArrayList.add(this.jdField_a_of_type_Rjb);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.eM(localArrayList);
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
      this.BJ = System.currentTimeMillis();
      if (!localArrayList.isEmpty()) {
        break label609;
      }
    }
    label444:
    label609:
    for (int i = 0;; i = ((rja)localArrayList.get(0)).bsq)
    {
      this.bpX = i;
      return;
      bool = ((Boolean)((psr)psx.a(10)).c("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.b.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        ram.w("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new rjg(azC, 1, 2130847393, 2));
      break;
      if ((this.b.a.asi == 10) && (!this.b.a.Li()))
      {
        ram.w("Q.qqstory.publish.edit.EditVideoFilter", "it's tribe slow black model, disable slow!");
        break label201;
      }
      localArrayList.add(new rjg(azD, 2, 2130847394, 3));
      break label201;
      label509:
      if ((this.b.a.asi == 10) && (!this.b.a.Lh()))
      {
        ram.w("Q.qqstory.publish.edit.EditVideoFilter", "it's tribe revert black model, disable revert!");
        break label247;
      }
      rjg localrjg = new rjg(azE, 3, 2130847392, 1);
      if (this.b.a.Lg()) {}
      for (String str = acfp.m(2131705701);; str = null)
      {
        localrjg.aAI = str;
        localArrayList.add(localrjg);
        break;
      }
    }
  }
  
  public boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof prw.a))
      {
        paramMessage = (prw.a)paramMessage.obj;
        this.jdField_a_of_type_Rjb = new rjb(0, azJ, 8, paramMessage.city, paramMessage.district, paramMessage.country, paramMessage.city, paramMessage.province, paramMessage.street, "", paramMessage.longitude, paramMessage.latitude, 1);
        bsK();
        ram.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.country, paramMessage.city, paramMessage.district);
      }
      for (;;)
      {
        return true;
        ram.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int j = this.G.get(this.b.tj(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.te() * 50);
      ram.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(i), Integer.valueOf(j));
      if (i != j) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(j, false);
      }
    }
  }
  
  public boolean eL(int paramInt)
  {
    rja localrja = (rja)this.aT.get(paramInt);
    return (localrja != null) && (localrja.LD());
  }
  
  public int ec(int paramInt)
  {
    rja localrja = (rja)this.aT.get(paramInt);
    if (localrja == null) {
      return 0;
    }
    return localrja.bsq;
  }
  
  public int ee(int paramInt)
  {
    rja localrja = (rja)this.aT.get(paramInt);
    if (localrja == null) {
      return 0;
    }
    return a(localrja);
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)y(2131365419));
    this.oH = y(2131367098);
    this.oH.setOnTouchListener(new rcj(this));
    if ((this.b.a.asi == 10) || (this.b.a.asi == 12))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams();
      localLayoutParams.height = ((int)(aqgz.getWidth() * this.b.a.a.getHeight() / this.b.a.a.getWidth()));
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new FilterPagerAdapter(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(new rck(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new a(null));
    ram.d("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    bsJ();
    bsK();
    a(rbb.class, this);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 11: 
    case 12: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 25: 
    case 26: 
    default: 
      setVisibility(4);
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
      return;
    }
    setVisibility(0);
  }
  
  public int tc()
  {
    return ee(this.b.tj());
  }
  
  public int td()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    rja localrja = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localrja != null) {
      return localrja.bsr;
    }
    return -1;
  }
  
  public static class FilterPagerAdapter
    extends PagerAdapter
  {
    private final Context J;
    private EditVideoFilter.b a;
    private final SparseArray<rja.a> aU = new SparseArray();
    private final Map<Class<? extends rja.a>, Queue<rja.a>> ge = new HashMap();
    private final List<rja> oA = new ArrayList();
    
    public FilterPagerAdapter(@NonNull Context paramContext)
    {
      this.J = paramContext;
    }
    
    @Nullable
    public rja.a a(int paramInt)
    {
      return (rja.a)this.aU.get(paramInt);
    }
    
    public rja a(int paramInt)
    {
      paramInt = ef(paramInt);
      if ((paramInt >= 0) && (paramInt < this.oA.size())) {
        return (rja)this.oA.get(paramInt);
      }
      return null;
    }
    
    public void a(EditVideoFilter.b paramb)
    {
      this.a = paramb;
    }
    
    public void aQ(int paramInt, String paramString)
    {
      Object localObject = this.oA.iterator();
      while (((Iterator)localObject).hasNext())
      {
        rja localrja = (rja)((Iterator)localObject).next();
        if (paramInt == localrja.bsr) {
          localrja.aAI = paramString;
        }
      }
      int i = 0;
      while (i < this.aU.size())
      {
        localObject = (rja.a)this.aU.valueAt(i);
        if ((localObject != null) && (((rja.a)localObject).a.bsr == paramInt) && ((localObject instanceof rjg.a)))
        {
          localObject = (rjg.a)localObject;
          ((rjg.a)localObject).yF.setText(paramString);
          if (TextUtils.isEmpty(paramString)) {
            EditVideoFilter.a((rja.a)localObject);
          }
        }
        i += 1;
      }
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      rja.a locala = (rja.a)paramObject;
      paramViewGroup.removeView(locala.mItemView);
      locala.mItemView.setOnTouchListener(null);
      locala.buT();
      paramObject = (Queue)this.ge.get(locala.getClass());
      paramViewGroup = paramObject;
      if (paramObject == null)
      {
        paramViewGroup = new LinkedList();
        this.ge.put(locala.getClass(), paramViewGroup);
      }
      paramViewGroup.offer(locala);
      this.aU.remove(paramInt);
    }
    
    public void eM(List<rja> paramList)
    {
      this.oA.clear();
      this.oA.addAll(paramList);
      this.aU.clear();
      notifyDataSetChanged();
    }
    
    public int ef(int paramInt)
    {
      return paramInt % this.oA.size();
    }
    
    public int getCount()
    {
      return this.oA.size() * 100;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      rja localrja = a(paramInt);
      if (localrja == null)
      {
        ram.w("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
        return null;
      }
      Object localObject1 = (Queue)this.ge.get(localrja.c());
      if (localObject1 != null) {}
      for (localObject1 = (rja.a)((Queue)localObject1).poll();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localrja.a(this.J, paramViewGroup);
        }
        paramViewGroup.addView(((rja.a)localObject2).mItemView);
        ((rja.a)localObject2).mItemView.setOnTouchListener(new EditVideoFilter.c(this.a));
        ((rja.a)localObject2).a(localrja, paramInt);
        this.aU.put(paramInt, localObject2);
        return localObject2;
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return ((paramObject instanceof rja.a)) && (((rja.a)paramObject).mItemView == paramView);
    }
    
    public int te()
    {
      return this.oA.size();
    }
  }
  
  class a
    implements ViewPager.OnPageChangeListener
  {
    private a() {}
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      paramInt2 = 0;
      int i = paramInt1 % EditVideoFilter.this.a.te();
      Object localObject = EditVideoFilter.this.a.a(i);
      if (localObject != null) {}
      for (paramInt1 = ((rja)localObject).bsq;; paramInt1 = 0)
      {
        localObject = EditVideoFilter.this.a.a((i + 1) % EditVideoFilter.this.a.te());
        if (localObject != null) {
          paramInt2 = ((rja)localObject).bsq;
        }
        localObject = (rdo)EditVideoFilter.this.a(rdo.class);
        if (localObject != null) {
          ((rdo)localObject).b(paramInt1, paramInt2, paramFloat);
        }
        return;
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      Object localObject = EditVideoFilter.this.a.a(paramInt);
      if (localObject != null) {}
      for (int i = ((rja)localObject).bsq;; i = 0)
      {
        EditVideoFilter.this.aT.put(EditVideoFilter.this.b.tj(), localObject);
        if ((i == 2) || (i == 1) || (i == 3))
        {
          localObject = EditVideoFilter.this.a.a(paramInt);
          if ((localObject != null) && (TextUtils.isEmpty(((rja.a)localObject).a.aAI))) {
            EditVideoFilter.a((rja.a)localObject);
          }
        }
        localObject = EditVideoFilter.this.a.a(paramInt - 1);
        rja.a locala = EditVideoFilter.this.a.a(paramInt + 1);
        if (localObject != null) {
          ((rja.a)localObject).mItemView.clearAnimation();
        }
        if (locala != null) {
          locala.mItemView.clearAnimation();
        }
        EditVideoFilter.this.BJ = System.currentTimeMillis();
        EditVideoFilter.this.bpX = i;
        EditVideoFilter.a(EditVideoFilter.this).put(EditVideoFilter.this.b.tj(), paramInt);
        localObject = (rdo)EditVideoFilter.this.a(rdo.class);
        if (localObject != null) {
          ((rdo)localObject).setPlayMode(i);
        }
        if (i != 0)
        {
          EditVideoFilter.this.b.f("608", "9", "0", true);
          ras.so("0X80076DE");
        }
        ram.b("Q.qqstory.publish.edit.EditVideoFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(EditVideoFilter.this.BJ), Integer.valueOf(EditVideoFilter.this.bpX));
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void L(MotionEvent paramMotionEvent);
    
    public abstract boolean c(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2);
    
    public abstract void onClick(View paramView);
  }
  
  static class c
    implements View.OnTouchListener
  {
    private EditVideoFilter.b a;
    private boolean aGR;
    private final int bpY = 5;
    private MotionEvent f;
    private MotionEvent g;
    private boolean mIsScroll;
    private int mStartY;
    
    public c(EditVideoFilter.b paramb)
    {
      this.a = paramb;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (this.a == null) {}
      do
      {
        do
        {
          float f1;
          do
          {
            do
            {
              return true;
              f1 = paramMotionEvent.getY();
              switch (paramMotionEvent.getAction() & 0xFF)
              {
              case 3: 
              case 4: 
              default: 
                return true;
              case 0: 
                this.mStartY = ((int)f1);
                this.mIsScroll = false;
                this.aGR = false;
                this.f = MotionEvent.obtain(paramMotionEvent);
                return true;
              }
            } while (paramMotionEvent.getPointerCount() > 2);
            if (this.aGR)
            {
              this.a.L(paramMotionEvent);
              return true;
            }
            this.g = MotionEvent.obtain(paramMotionEvent);
            this.aGR = this.a.c(this.f, this.g);
          } while ((!this.aGR) || (!(paramView instanceof ViewParent)));
          ((ViewParent)paramView).requestDisallowInterceptTouchEvent(true);
          return true;
          if (Math.abs((int)(f1 - this.mStartY)) > 5) {
            this.mIsScroll = true;
          }
        } while (!this.aGR);
        this.a.L(paramMotionEvent);
        return true;
      } while ((paramMotionEvent.getPointerCount() > 2) || (!this.aGR));
      this.a.L(paramMotionEvent);
      return true;
      if (!this.mIsScroll) {
        this.a.onClick(paramView);
      }
      if ((this.aGR) && ((paramView instanceof ViewParent))) {
        ((ViewParent)paramView).requestDisallowInterceptTouchEvent(false);
      }
      this.a.L(paramMotionEvent);
      this.mIsScroll = false;
      this.aGR = false;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter
 * JD-Core Version:    0.7.0.1
 */