package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anki;
import axim;
import axip;
import axov;
import axpr;
import axpr.a;
import axqc;
import axqf;
import axqm;
import ayjb;
import aytq;
import ayva;
import ayva.a;
import ayva.b;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.ProviderView.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import rar;

public class VideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements axpr.a
{
  private c jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$c;
  private d jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d;
  long aDk = 0L;
  private int atZ = -1;
  private a jdField_b_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$a;
  private b jdField_b_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$b;
  private boolean dBd = true;
  private boolean dBe;
  private boolean dBf = true;
  private boolean dBg;
  public boolean dBh = true;
  public boolean dBi;
  public boolean dBj;
  public boolean dBk;
  public boolean dzQ;
  private ProviderView.a e;
  public int eGE = 0;
  private View mContainer;
  
  public VideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void a(View paramView, QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131364964);
    TextView localTextView2 = (TextView)paramView.findViewById(2131364963);
    ViewParent localViewParent = getParent();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localViewParent != null)
    {
      localObject1 = localObject2;
      if ((localViewParent instanceof RelativeLayout)) {
        localObject1 = (RelativeLayout)((RelativeLayout)localViewParent).findViewById(2131370820);
      }
    }
    boolean bool = ((axpr)axov.a(5)).aPt();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.dBe) && (localTextView1 != null) && (localTextView2 != null))
      {
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(8);
      }
      return;
      if (!bool)
      {
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
        localTextView1.setText(paramQIMFilterCategoryItem.name);
        if (localTextView2 != null) {
          localTextView2.setText(paramQIMFilterCategoryItem.desc);
        }
        paramQIMFilterCategoryItem = new VideoFilterViewPager.1(this, paramView);
        paramView.setVisibility(0);
        paramView.postDelayed(paramQIMFilterCategoryItem, 800L);
        paramView.setTag(paramQIMFilterCategoryItem);
      }
      else
      {
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
        localTextView1.setText(paramQIMFilterCategoryItem.name);
        localTextView1.setVisibility(8);
        if (localTextView2 != null)
        {
          localTextView2.setText(paramQIMFilterCategoryItem.desc);
          localTextView2.setVisibility(8);
          continue;
          if (!bool)
          {
            if (!this.dBk) {
              if (localObject1 != null)
              {
                ((RelativeLayout)localObject1).setVisibility(0);
                QLog.i("VideoFilterViewPager", 2, "loadingView VISIBLE");
              }
            }
            for (;;)
            {
              paramView.setVisibility(0);
              localTextView1.setText(paramQIMFilterCategoryItem.name);
              if (localTextView2 == null) {
                break;
              }
              localTextView2.setText(paramQIMFilterCategoryItem.desc);
              break;
              if (localObject1 != null)
              {
                ((RelativeLayout)localObject1).setVisibility(8);
                QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
              }
            }
          }
          localTextView1.setText(paramQIMFilterCategoryItem.name);
          localTextView1.setVisibility(8);
          if (localTextView2 != null)
          {
            localTextView2.setText(paramQIMFilterCategoryItem.desc);
            localTextView2.setVisibility(8);
          }
          if (localObject1 != null)
          {
            ((RelativeLayout)localObject1).setVisibility(8);
            QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
            continue;
            if (localObject1 != null)
            {
              ((RelativeLayout)localObject1).setVisibility(8);
              QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
            }
            paramView.setVisibility(8);
          }
        }
      }
    }
  }
  
  private void afL(int paramInt)
  {
    View localView = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.F(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.e(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, ((axpr)axov.a(5)).a(localQIMFilterCategoryItem).outState);
      }
    }
  }
  
  private void afM(int paramInt)
  {
    View localView = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.F(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.e(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, 4);
      }
    }
  }
  
  private void e(View paramView, int paramInt, boolean paramBoolean)
  {
    if (anki.axM()) {}
    QIMFilterCategoryItem localQIMFilterCategoryItem;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "onPageSelect position: " + paramInt + ", mCurPosition: " + this.atZ + ", mFromOnlyChangeUi: " + this.dBj);
        }
      } while (paramInt == this.atZ);
      this.mContainer = paramView;
      this.atZ = paramInt;
      paramView.setVisibility(0);
      localQIMFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.e(paramInt);
      if (localQIMFilterCategoryItem != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
    return;
    Object localObject2;
    Object localObject1;
    if (axip.a().aOI())
    {
      localObject2 = axim.a();
      if (paramInt == 0)
      {
        localObject1 = "none";
        label137:
        ((axim)localObject2).acQ((String)localObject1);
        localObject1 = (TextView)paramView.findViewById(2131364964);
        localObject2 = (TextView)paramView.findViewById(2131364963);
        Object localObject3 = (axpr)axov.a(5);
        if (!this.dBj)
        {
          Object localObject4 = new Bundle();
          ((Bundle)localObject4).putInt("apply_source", 2);
          ((Bundle)localObject4).putInt("capture_scene", this.eGE);
          ((axpr)localObject3).a(localQIMFilterCategoryItem, (Activity)getContext(), (Bundle)localObject4);
          if ((this.dBg) && (this.dBf)) {
            AEFilterProviderView.ack(localQIMFilterCategoryItem.id);
          }
          if (paramBoolean)
          {
            localObject4 = (Activity)getContext();
            if (((Activity)localObject4).getIntent() != null)
            {
              paramInt = ((Activity)getContext()).getIntent().getIntExtra("edit_video_type", 10002);
              if (!(localObject4 instanceof QIMCameraCaptureActivity)) {
                break label558;
              }
              rar.a("clk_swipe", paramInt, 0, new String[] { "", localQIMFilterCategoryItem.id });
            }
          }
        }
        label323:
        localObject3 = ((axpr)localObject3).a(localQIMFilterCategoryItem);
        paramInt = ((axqf)localObject3).Rs();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "onPageSelect state = " + paramInt + " " + ((axqf)localObject3).toString());
        }
        if ((!localQIMFilterCategoryItem.auG()) && (!localQIMFilterCategoryItem.dwd) && (!this.dBi)) {
          break label587;
        }
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.dBh) {
        this.dBh = false;
      }
      if (!this.dBd) {
        this.dBd = true;
      }
      paramView.setVisibility(0);
      a(paramView, localQIMFilterCategoryItem, paramInt);
      if (this.e == null) {
        break;
      }
      this.e.YI(true);
      return;
      localObject1 = "" + localQIMFilterCategoryItem.id;
      break label137;
      localObject2 = axim.a();
      if (paramInt == 0) {}
      for (localObject1 = "none";; localObject1 = "" + localQIMFilterCategoryItem.id)
      {
        ((axim)localObject2).acM((String)localObject1);
        break;
      }
      label558:
      rar.b("filter_swipe", paramInt, 0, new String[] { "", localQIMFilterCategoryItem.id });
      break label323;
      label587:
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
    }
  }
  
  private void init()
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d = new d();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$c = new c();
    setAdapter(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d);
    setOnPageChangeListener(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$c);
  }
  
  public void ZQ(boolean paramBoolean)
  {
    this.dBe = paramBoolean;
  }
  
  public void a(axqc paramaxqc) {}
  
  public void a(axqc paramaxqc, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      QLog.e("QCombo", 1, "onComboApply aborted");
    }
    for (;;)
    {
      return;
      paramInt = paramBundle.getInt("capture_scene", -1);
      if (this.eGE != paramInt)
      {
        QLog.e("QCombo", 2, "onComboApply aborted " + this.eGE + paramInt);
        return;
      }
      paramBundle = ((axpr)axov.a(5)).a(paramaxqc, this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.sd);
      ArrayList localArrayList = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.sd;
      this.dBi = true;
      int i;
      if (localArrayList != null)
      {
        i = localArrayList.indexOf(paramBundle);
        paramInt = i;
        if (i >= 0)
        {
          paramInt = i;
          if (i != getCurrentItem())
          {
            this.dBj = true;
            adv(i);
          }
        }
      }
      for (paramInt = i; QLog.isColorLevel(); paramInt = -1)
      {
        QLog.i("QCombo", 2, "vp onComboApply combo " + paramaxqc.target + " filter " + paramBundle + " index " + paramInt);
        return;
      }
    }
  }
  
  public void a(axqf paramaxqf, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      QLog.e("QCombo", 1, "onFilterApply aborted");
    }
    do
    {
      ArrayList localArrayList;
      do
      {
        do
        {
          return;
          paramInt = paramBundle.getInt("capture_scene", -1);
          if (this.eGE != paramInt)
          {
            QLog.e("QCombo", 2, "onFilterApply aborted " + this.eGE + paramInt);
            return;
          }
        } while (!(paramaxqf.target instanceof QIMFilterCategoryItem));
        axip.a().setFilterId(paramaxqf.getUniqueId());
        paramaxqf = (QIMFilterCategoryItem)paramaxqf.target;
        localArrayList = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.sd;
      } while (localArrayList == null);
      paramInt = localArrayList.indexOf(paramaxqf);
    } while (paramInt < 0);
    this.dBi = false;
    int i;
    if ((paramBundle.getInt("apply_source", 2) == 1) || (paramBundle.getInt("apply_source", 2) == axpr.eGC))
    {
      this.dBj = true;
      i = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.te() * 50 + paramInt;
      if (i == this.atZ) {
        if (paramBoolean)
        {
          afL(i);
          this.dBj = false;
        }
      }
    }
    for (;;)
    {
      rar.b((Activity)getContext(), "filter_element", String.valueOf(paramaxqf.categoryId), paramaxqf.id);
      if (!this.dzQ) {
        break;
      }
      ayjb.a().eRW();
      return;
      afM(i);
      continue;
      if (paramBoolean)
      {
        adv(paramInt);
        continue;
        if ((paramBundle.getInt("apply_source", 2) == 2) && (paramInt == this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.ef(this.atZ)))
        {
          paramInt = this.atZ;
          if (paramBoolean) {
            afL(paramInt);
          } else {
            afM(paramInt);
          }
        }
      }
    }
  }
  
  public void a(axqm paramaxqm, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(ayva.a parama)
  {
    if (parama != null)
    {
      parama = parama.a(this.eGE);
      if (parama != null)
      {
        bD(parama.filterList);
        int i = parama.filterList.indexOf(ayva.a().d(this.eGE));
        QLog.i("VideoFilterViewPager", 2, "onResourceDownload - update viewpagerIndex = " + i + "; getCurrentItem()" + getCurrentItem());
        if ((i != -1) && (i != getCurrentItem()))
        {
          QLog.i("VideoFilterViewPager", 2, "onResourceDownload - initialViewPagerPosition ");
          this.dBj = true;
          adv(i);
          this.dBj = false;
        }
      }
    }
  }
  
  public boolean aRi()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mContainer != null)
    {
      bool1 = bool2;
      if (this.mContainer.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void adv(int paramInt)
  {
    setCurrentItem(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.te() * 50 + paramInt);
  }
  
  public void bD(List<QIMFilterCategoryItem> paramList)
  {
    if (anki.axM())
    {
      setVisibility(8);
      setEnabled(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.bD(paramList);
      QLog.i("VideoFilterViewPager", 2, "update getCurrentItem = " + getCurrentItem());
      return;
      if (!(getContext() instanceof QzoneEditVideoActivity))
      {
        setVisibility(0);
        setEnabled(true);
      }
    }
  }
  
  public void clearState()
  {
    this.aDk = 0L;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void eTQ()
  {
    String str = AEFilterProviderView.getFilterId();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.adG(str);
  }
  
  public void eTR()
  {
    int i = getCurrentItem();
    QLog.i("VideoFilterViewPager", 2, "needReselectMiddle getActualCount " + this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.te());
    if ((i == 0) || (i % this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.te() == 0)) {
      QLog.i("VideoFilterViewPager", 2, "needReselectMiddle ");
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        setCurrentItem(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$d.te() * 50, false);
      }
      return;
    }
  }
  
  public void eTS()
  {
    if (this.mContainer != null) {
      this.mContainer.setVisibility(8);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ((axpr)axov.a(5)).a(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ((axpr)axov.a(5)).b(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.aDk = System.currentTimeMillis();
    }
  }
  
  public void setCaptureScene(int paramInt)
  {
    this.eGE = paramInt;
  }
  
  public void setIsNormalMode(boolean paramBoolean)
  {
    this.dBf = paramBoolean;
    if (!this.dBg) {
      this.dBg = true;
    }
  }
  
  public void setProviderViewListener(ProviderView.a parama)
  {
    this.e = parama;
  }
  
  public void setReadyToApply(boolean paramBoolean)
  {
    this.dBd = paramBoolean;
  }
  
  public void setScrollCallBack(a parama)
  {
    this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$a = parama;
  }
  
  public void setSecleteCallBack(b paramb)
  {
    this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void eFx();
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem);
  }
  
  class c
    implements ViewPager.OnPageChangeListener
  {
    public int AS;
    public View Nw;
    
    c() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageScrollStateChanged state: " + paramInt);
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageScrolled position: " + paramInt1 + ", positionOffset: " + paramFloat + ", positionOffsetPixels: " + paramInt2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      if (anki.axM()) {
        return;
      }
      if (System.currentTimeMillis() - VideoFilterViewPager.this.aDk < 400L) {}
      for (boolean bool = true; this.AS == paramInt; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "onPageSelected l " + this.AS + ",n " + paramInt + " scroll " + bool);
        }
        VideoFilterViewPager.this.dBj = false;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageSelected 2 " + this.AS + ",n" + paramInt + " scroll " + bool);
      }
      if ((bool) && (VideoFilterViewPager.a(VideoFilterViewPager.this) != null)) {
        VideoFilterViewPager.a(VideoFilterViewPager.this).eFx();
      }
      if (VideoFilterViewPager.a(VideoFilterViewPager.this) != null) {
        VideoFilterViewPager.a(VideoFilterViewPager.this).a(VideoFilterViewPager.a(VideoFilterViewPager.this).ef(paramInt), VideoFilterViewPager.a(VideoFilterViewPager.this).e(paramInt));
      }
      aytq.h("", "0X8007804", "", "", "", "");
      View localView;
      if (bool)
      {
        try
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = VideoFilterViewPager.a(VideoFilterViewPager.this).e(paramInt);
          if (localQIMFilterCategoryItem != null)
          {
            if ((paramInt <= this.AS) || (VideoFilterViewPager.a(VideoFilterViewPager.this).te() == 0) || (paramInt % VideoFilterViewPager.a(VideoFilterViewPager.this).te() == 0)) {
              break label503;
            }
            if ((paramInt != 0) && (localQIMFilterCategoryItem.auG()) && (paramInt + 1 < VideoFilterViewPager.a(VideoFilterViewPager.this).getCount()))
            {
              VideoFilterViewPager.this.setCurrentItem(paramInt + 1, false);
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
      else
      {
        this.AS = paramInt;
        localView = VideoFilterViewPager.a(VideoFilterViewPager.this).F(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "onPageSelected 3 " + paramInt + ",n" + paramInt + " pageItem " + localView);
        }
        if (localView == null) {
          break label556;
        }
        if (this.Nw != null)
        {
          localRunnable = (Runnable)this.Nw.getTag();
          if (localRunnable != null) {
            this.Nw.removeCallbacks(localRunnable);
          }
          this.Nw.clearAnimation();
        }
        Runnable localRunnable = (Runnable)localView.getTag();
        if (localRunnable != null)
        {
          localView.removeCallbacks(localRunnable);
          localView.setTag(null);
        }
        VideoFilterViewPager.a(VideoFilterViewPager.this, localView, paramInt, bool);
      }
      for (;;)
      {
        this.Nw = localView;
        VideoFilterViewPager.this.dBj = false;
        VideoFilterViewPager.this.dBk = false;
        return;
        label503:
        if ((!localView.auG()) || (VideoFilterViewPager.a(VideoFilterViewPager.this).te() == 0) || (paramInt % VideoFilterViewPager.a(VideoFilterViewPager.this).te() == 0) || (paramInt - 1 <= 0)) {
          break;
        }
        VideoFilterViewPager.this.setCurrentItem(paramInt - 1, false);
        return;
        label556:
        if (!VideoFilterViewPager.a(VideoFilterViewPager.this)) {
          VideoFilterViewPager.a(VideoFilterViewPager.this, true);
        }
      }
    }
  }
  
  class d
    extends PagerAdapter
  {
    public final SparseArray<View> aU = new SparseArray();
    public final Map<Class<? extends View>, Queue<View>> ge = new HashMap();
    public ArrayList<QIMFilterCategoryItem> sd = new ArrayList();
    
    public d() {}
    
    @Nullable
    public View F(int paramInt)
    {
      return (View)this.aU.get(paramInt);
    }
    
    public void adG(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        return;
        int i = 0;
        while (i < this.sd.size())
        {
          if (paramString.equals(((QIMFilterCategoryItem)this.sd.get(i)).id))
          {
            VideoFilterViewPager.this.adv(i);
            if (QLog.isColorLevel()) {
              QLog.d("VideoFilterViewPager", 2, "onResourceDownload - selectFilterById() - set last selected item: (" + i + ", " + ((QIMFilterCategoryItem)this.sd.get(i)).id + ")");
            }
          }
          i += 1;
        }
      }
    }
    
    public void bD(List<QIMFilterCategoryItem> paramList)
    {
      this.sd.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)paramList.next();
        if (!localQIMFilterCategoryItem.isWsBanner()) {
          this.sd.add(localQIMFilterCategoryItem);
        }
      }
      if (!ayva.a().aRg()) {
        ayva.oW(this.sd);
      }
      notifyDataSetChanged();
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "destroyItem position: " + paramInt);
      }
      View localView = (View)paramObject;
      localView.removeCallbacks((Runnable)localView.getTag());
      localView.clearAnimation();
      paramViewGroup.removeView(localView);
      paramObject = (Queue)this.ge.get(localView.getClass());
      paramViewGroup = paramObject;
      if (paramObject == null)
      {
        paramViewGroup = new LinkedList();
        this.ge.put(localView.getClass(), paramViewGroup);
      }
      paramViewGroup.offer(localView);
      this.aU.remove(paramInt);
    }
    
    public QIMFilterCategoryItem e(int paramInt)
    {
      paramInt = ef(paramInt);
      if ((paramInt >= 0) && (paramInt < this.sd.size())) {
        return (QIMFilterCategoryItem)this.sd.get(paramInt);
      }
      return null;
    }
    
    public int ef(int paramInt)
    {
      int i = this.sd.size();
      if (i > 0) {
        return paramInt % i;
      }
      return -1;
    }
    
    public int getCount()
    {
      return this.sd.size() * 100;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject1 = e(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "instantiateItem position: " + localObject1);
      }
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("VideoFilterViewPager", 2, "instantiateItem find data is null!");
        }
        return null;
      }
      localObject1 = (Queue)this.ge.get(localObject1.getClass());
      if (localObject1 != null) {}
      for (localObject1 = (View)((Queue)localObject1).poll();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = ((LayoutInflater)VideoFilterViewPager.this.getContext().getSystemService("layout_inflater")).inflate(2131559255, null);
          ((View)localObject2).setVisibility(8);
        }
        paramViewGroup.addView((View)localObject2);
        this.aU.put(paramInt, localObject2);
        return localObject2;
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return ((paramObject instanceof View)) && (paramObject == paramView);
    }
    
    public int te()
    {
      return this.sd.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */