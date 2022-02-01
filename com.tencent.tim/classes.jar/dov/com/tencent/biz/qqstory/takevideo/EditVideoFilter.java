package dov.com.tencent.biz.qqstory.takevideo;

import acfp;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
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
import android.widget.TextView;
import aydh;
import aygy;
import aygz;
import ayhm;
import ayis;
import ayoq;
import ayoq.a;
import ayor;
import ayos;
import ayou;
import ayou.a;
import ayqb;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import prw.a;
import psr;
import psx;
import ram;
import rar;
import ras;

public class EditVideoFilter
  extends aygy
  implements aydh
{
  public static final String azC = acfp.m(2131705665);
  public static final String azD = acfp.m(2131705543);
  public static final String azE = acfp.m(2131705507);
  public static final String azF = acfp.m(2131705580);
  public static final String azG = acfp.m(2131705491);
  public static final String azH = acfp.m(2131705486);
  public static final String azI = acfp.m(2131705690);
  public static final String azJ = acfp.m(2131705586);
  public static final String cWU = acfp.m(2131705639);
  public static final String cWV = acfp.m(2131705661);
  public static final String cWW = acfp.m(2131705685);
  public long BJ;
  private SparseIntArray G = new SparseIntArray();
  protected ayor a;
  protected UnHandleTouchEventViewPager a;
  protected FilterPagerAdapter a;
  protected SparseArray<ayoq> aT = new SparseArray();
  public int bpX;
  
  public EditVideoFilter(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  public static int a(@NonNull ayoq paramayoq)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + paramayoq.bsq);
    switch (paramayoq.bsq)
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 8: 
      return 3;
    case 1: 
      return 5;
    case 3: 
      return 2;
    case 9: 
      return 4;
    case 4: 
      return 6;
    case 5: 
      return 7;
    case 6: 
      return 8;
    }
    return 9;
  }
  
  protected static void a(ayoq.a parama)
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
    } while (this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getVisibility() == paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setVisibility(paramInt);
  }
  
  public ayoq a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    ayoq localayoq = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localayoq != null) {
      return localayoq;
    }
    return null;
  }
  
  public ayor a()
  {
    return this.jdField_a_of_type_Ayor;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    Object localObject1 = a();
    if (localObject1 != null) {
      paramayqb.g.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().mi(), ((ayor)localObject1).country, ((ayor)localObject1).city, ((ayor)localObject1).province, ((ayor)localObject1).street, ((ayor)localObject1).building, ((ayor)localObject1).longitude, ((ayor)localObject1).latitude, ((ayor)localObject1).coordinate);
    }
    Object localObject2 = (ayoq)this.aT.get(paramInt);
    if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof ayor))) {
      paramayqb.g.gpsFilterDescription = ((ayor)localObject1).mY();
    }
    if (this.b.a.Ld()) {
      paramayqb.g.localCreateCity = this.b.a.getStringExtra("extra_local_address_city_name");
    }
    paramayqb.dS(ax());
    paramayqb.g.saveMode = ee(paramInt);
    paramayqb = "";
    int i = -1;
    paramInt = 0;
    int j;
    if (localObject2 != null)
    {
      localObject1 = ((ayoq)localObject2).aAH;
      j = ((ayoq)localObject2).bsr;
      int k = ((ayoq)localObject2).bsq;
      paramInt = k;
      i = j;
      paramayqb = (ayqb)localObject1;
      if (((ayoq)localObject2).bsr != -1)
      {
        this.b.a().setFilterId(((ayoq)localObject2).aAH);
        this.b.a().setFilterType(2);
        paramayqb = (ayqb)localObject1;
        i = j;
        paramInt = k;
      }
    }
    long l;
    if (i != -1)
    {
      localObject2 = this.b;
      j = this.b.tk();
      if (this.b.La())
      {
        localObject1 = "2";
        ((aygz)localObject2).d("pub_filter_menu", j, 0, new String[] { String.valueOf(i), paramayqb, localObject1 });
      }
    }
    else
    {
      if (i != -1) {
        ras.g("0X80076E9", String.valueOf(ras.bpq), String.valueOf(paramInt), paramayqb, String.valueOf(i));
      }
      l = System.currentTimeMillis() - this.BJ;
      paramInt = this.bpX;
      ram.b("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.b.La()) {
        break label437;
      }
    }
    label437:
    for (paramayqb = "2";; paramayqb = "1")
    {
      rar.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), paramayqb });
      return;
      localObject1 = "1";
      break;
    }
  }
  
  public boolean a(int paramInt1, Canvas paramCanvas, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    paramInt1 = this.G.get(paramInt1);
    Object localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight();
    if (localObject2 != null)
    {
      if (!((ayoq.a)localObject2).LD()) {
        break label226;
      }
      localObject1 = ((ayoq.a)localObject2).mItemView;
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
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.destroyItem((ViewGroup)localObject1, paramInt1, localObject2);
        }
        return true;
        localObject1 = new FrameLayout(getContext());
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams()));
        localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.instantiateItem((ViewGroup)localObject1, paramInt1);
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
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.aQ(paramInt, paramString);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.notifyDataSetChanged();
  }
  
  @Nullable
  public View ax()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (ayoq)this.aT.get(i);
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if ((localObject != null) && (((ayoq.a)localObject).LD())) {
      return ((ayoq.a)localObject).mItemView;
    }
    return null;
  }
  
  public void bsK()
  {
    ram.b("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.b.a.a);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ayou(cWU, -1, 0, 0));
    boolean bool;
    if (((this.b.a.a instanceof EditRecordVideoSource)) || ((this.b.a.a instanceof EditTakeVideoSource)))
    {
      if (((this.b.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((psr)psx.a(10)).c("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.b.a.a instanceof EditTakeVideoSource)) || (bool)) {
            break label492;
          }
          ram.w("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.b.a.a instanceof EditTakeVideoSource)) || (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"CHE-TL00".equalsIgnoreCase(Build.MODEL)) && (!"CAM-TL00".equalsIgnoreCase(Build.MODEL)) && (!"MHA-AL00".equalsIgnoreCase(Build.MODEL)) && (!"CHM-TL00".equalsIgnoreCase(Build.MODEL)))) {
          break label543;
        }
      }
    }
    else
    {
      label277:
      localArrayList.add(new ayos(0, azI, 7));
      if (this.jdField_a_of_type_Ayor != null) {
        localArrayList.add(this.jdField_a_of_type_Ayor);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.eM(localArrayList);
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
      this.BJ = System.currentTimeMillis();
      if (!localArrayList.isEmpty()) {
        break label948;
      }
    }
    label543:
    label948:
    for (int i = 0;; i = ((ayoq)localArrayList.get(0)).bsq)
    {
      this.bpX = i;
      return;
      bool = ((Boolean)((psr)psx.a(10)).c("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.b.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        ram.w("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new ayou(azC, 1, 2130847393, 2));
      localArrayList.add(new ayou(cWV, 9, 2130847393, 8));
      break;
      label492:
      localArrayList.add(new ayou(azD, 2, 2130847394, 3));
      localArrayList.add(new ayou(cWW, 10, 2130847394, 9));
      break label201;
      if ((((this.b.a.a instanceof EditTakeVideoSource)) && ("GIONEE".equalsIgnoreCase(Build.MANUFACTURER)) && ("GN9011".equalsIgnoreCase(Build.MODEL))) || (((this.b.a.a instanceof EditTakeVideoSource)) && ("ZTE".equalsIgnoreCase(Build.MANUFACTURER)) && ("ZTE A2017".equalsIgnoreCase(Build.MODEL))) || (((this.b.a.a instanceof EditTakeVideoSource)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("HM NOTE 1W".equalsIgnoreCase(Build.MODEL))) || (((this.b.a.a instanceof EditTakeVideoSource)) && ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) && ("ONEPLUS A3000".equalsIgnoreCase(Build.MODEL))) || (((this.b.a.a instanceof EditTakeVideoSource)) && ("vivo Y67".equalsIgnoreCase(Build.MODEL))) || (((this.b.a.a instanceof EditTakeVideoSource)) && ("OPPO R7sm".equalsIgnoreCase(Build.MODEL))) || (((this.b.a.a instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL))) || (((this.b.a.a instanceof EditTakeVideoSource)) && ("GN5001S".equalsIgnoreCase(Build.MODEL)))) {
        break label277;
      }
      bool = ((Boolean)((psr)psx.a(10)).c("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.b.a.a instanceof EditTakeVideoSource)) && (!bool))
      {
        ram.w("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break label277;
      }
      ayou localayou = new ayou(azE, 3, 2130847392, 1);
      if (this.b.a.Lg()) {}
      for (String str = acfp.m(2131705612);; str = null)
      {
        localayou.aAI = str;
        localArrayList.add(localayou);
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
        this.jdField_a_of_type_Ayor = new ayor(0, azJ, 8, paramMessage.city, paramMessage.district, paramMessage.country, paramMessage.city, paramMessage.province, paramMessage.street, "", paramMessage.longitude, paramMessage.latitude, 1);
        bsK();
        ram.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.country, paramMessage.city, paramMessage.district);
      }
      for (;;)
      {
        return true;
        ram.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int j = this.G.get(this.b.tj(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.te() * 50);
      ram.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(i), Integer.valueOf(j));
      if (i != j) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(j, false);
      }
    }
  }
  
  public boolean eL(int paramInt)
  {
    ayoq localayoq = (ayoq)this.aT.get(paramInt);
    return (localayoq != null) && (localayoq.LD());
  }
  
  protected void eRz() {}
  
  public int ec(int paramInt)
  {
    ayoq localayoq = (ayoq)this.aT.get(paramInt);
    if (localayoq == null) {
      return 0;
    }
    return localayoq.bsq;
  }
  
  public int ee(int paramInt)
  {
    ayoq localayoq = (ayoq)this.aT.get(paramInt);
    if (localayoq == null) {
      return 0;
    }
    return a(localayoq);
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)y(2131365419));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new FilterPagerAdapter(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new a(null));
    ram.d("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    bsK();
    a(aydh.class, this);
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
    ayoq localayoq = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localayoq != null) {
      return localayoq.bsr;
    }
    return -1;
  }
  
  public static class FilterPagerAdapter
    extends PagerAdapter
  {
    private final Context J;
    private EditVideoFilter.b a;
    private final SparseArray<ayoq.a> aU = new SparseArray();
    private final Map<Class<? extends ayoq.a>, Queue<ayoq.a>> ge = new HashMap();
    public final List<ayoq> oA = new ArrayList();
    
    public FilterPagerAdapter(@NonNull Context paramContext)
    {
      this.J = paramContext;
    }
    
    @Nullable
    public ayoq.a a(int paramInt)
    {
      return (ayoq.a)this.aU.get(paramInt);
    }
    
    public ayoq a(int paramInt)
    {
      paramInt = ef(paramInt);
      if ((paramInt >= 0) && (paramInt < this.oA.size())) {
        return (ayoq)this.oA.get(paramInt);
      }
      return null;
    }
    
    public void aQ(int paramInt, String paramString)
    {
      Object localObject = this.oA.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ayoq localayoq = (ayoq)((Iterator)localObject).next();
        if (paramInt == localayoq.bsr) {
          localayoq.aAI = paramString;
        }
      }
      int i = 0;
      while (i < this.aU.size())
      {
        localObject = (ayoq.a)this.aU.valueAt(i);
        if ((localObject != null) && (((ayoq.a)localObject).a.bsr == paramInt) && ((localObject instanceof ayou.a)))
        {
          localObject = (ayou.a)localObject;
          ((ayou.a)localObject).yF.setText(paramString);
          if (TextUtils.isEmpty(paramString)) {
            EditVideoFilter.a((ayoq.a)localObject);
          }
        }
        i += 1;
      }
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      ayoq.a locala = (ayoq.a)paramObject;
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
    
    public void eM(List<ayoq> paramList)
    {
      this.oA.clear();
      this.oA.addAll(paramList);
      this.aU.clear();
      notifyDataSetChanged();
    }
    
    public int ef(int paramInt)
    {
      int i = this.oA.size();
      if (i != 0) {
        return paramInt % i;
      }
      return 0;
    }
    
    public int getCount()
    {
      return this.oA.size() * 100;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      ayoq localayoq = a(paramInt);
      if (localayoq == null)
      {
        ram.w("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
        return null;
      }
      Object localObject1 = (Queue)this.ge.get(localayoq.c());
      if (localObject1 != null) {}
      for (localObject1 = (ayoq.a)((Queue)localObject1).poll();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localayoq.a(this.J, paramViewGroup);
        }
        paramViewGroup.addView(((ayoq.a)localObject2).mItemView);
        ((ayoq.a)localObject2).mItemView.setOnTouchListener(new EditVideoFilter.c(this.a));
        ((ayoq.a)localObject2).a(localayoq, paramInt);
        this.aU.put(paramInt, localObject2);
        return localObject2;
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return ((paramObject instanceof ayoq.a)) && (((ayoq.a)paramObject).mItemView == paramView);
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
      for (paramInt1 = ((ayoq)localObject).bsq;; paramInt1 = 0)
      {
        localObject = EditVideoFilter.this.a.a((i + 1) % EditVideoFilter.this.a.te());
        if (localObject != null) {
          paramInt2 = ((ayoq)localObject).bsq;
        }
        localObject = (ayhm)EditVideoFilter.this.a(ayhm.class);
        if (localObject != null) {
          ((ayhm)localObject).b(paramInt1, paramInt2, paramFloat);
        }
        return;
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      Object localObject = EditVideoFilter.this.a.a(paramInt);
      if (localObject != null) {}
      for (int i = ((ayoq)localObject).bsq;; i = 0)
      {
        EditVideoFilter.this.aT.put(EditVideoFilter.this.b.tj(), localObject);
        if ((i == 2) || (i == 1) || (i == 3) || (i == 0))
        {
          localObject = EditVideoFilter.this.a.a(paramInt);
          if ((localObject != null) && (TextUtils.isEmpty(((ayoq.a)localObject).a.aAI))) {
            EditVideoFilter.a((ayoq.a)localObject);
          }
        }
        localObject = EditVideoFilter.this.a.a(paramInt - 1);
        ayoq.a locala = EditVideoFilter.this.a.a(paramInt + 1);
        if (localObject != null) {
          ((ayoq.a)localObject).mItemView.clearAnimation();
        }
        if (locala != null) {
          locala.mItemView.clearAnimation();
        }
        EditVideoFilter.this.BJ = System.currentTimeMillis();
        EditVideoFilter.this.bpX = i;
        EditVideoFilter.a(EditVideoFilter.this).put(EditVideoFilter.this.b.tj(), paramInt);
        localObject = (ayhm)EditVideoFilter.this.a(ayhm.class);
        if (localObject != null)
        {
          ((ayhm)localObject).setPlayMode(i);
          if ((localObject instanceof HWEditLocalVideoPlayer)) {
            ((HWEditLocalVideoPlayer)localObject).setSpeedType(i);
          }
          if ((localObject instanceof ayis)) {
            ((ayis)localObject).setSpeedType(i);
          }
        }
        EditVideoFilter.this.eRz();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter
 * JD-Core Version:    0.7.0.1
 */