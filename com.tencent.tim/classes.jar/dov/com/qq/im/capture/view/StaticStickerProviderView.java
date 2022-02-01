package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import axov;
import axqg;
import axrf;
import axsu;
import axtd;
import axxs;
import axxt;
import ayeh;
import ayfw.d;
import aygz;
import ayjn.b;
import aymz;
import aync;
import aynd;
import ayne;
import ayng;
import aynj;
import ayoo.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.a;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import ras;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements ayng, QIMSlidingTabView.a, FaceViewPager.a
{
  public ArrayList<String> Gk;
  aynj jdField_a_of_type_Aynj;
  FacePagerAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  FaceViewPager jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager;
  axrf c;
  private axqg d;
  private int eIJ = 0;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Axrf = new axxt(this);
  }
  
  private void a(axsu paramaxsu, ayfw.d paramd)
  {
    paramaxsu = new ArrayList(paramaxsu.hU());
    if (aPW())
    {
      paramaxsu.add(0, new aync());
      paramd.Zm(true);
    }
    for (;;)
    {
      paramd.e(paramaxsu);
      return;
      paramd.Zm(false);
    }
  }
  
  private boolean aPW()
  {
    if ((this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) && ((this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a instanceof ayeh)))
    {
      aygz localaygz = ((ayeh)this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a).b;
      if ((localaygz != null) && (localaygz.a != null)) {
        return true;
      }
    }
    return false;
  }
  
  private void clearMemory()
  {
    long l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l2 = (Runtime.getRuntime().maxMemory() * 0.8D);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("clearMemory ");
      if (l1 <= l2) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("StaticStickerProviderView", 2, bool);
      if ((l1 > l2) && (BaseApplicationImpl.sImageCache != null)) {
        BaseApplicationImpl.sImageCache.evictAll();
      }
      return;
    }
  }
  
  private void ePk()
  {
    ArrayList localArrayList1 = ((axtd)axov.a(1)).eK();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      if (((DoodleEmojiItem)localArrayList1.get(i)).hide != 1)
      {
        String str = ((DoodleEmojiItem)localArrayList1.get(i)).name;
        if (!localArrayList2.contains(str)) {
          localArrayList2.add(str);
        }
      }
      i += 1;
    }
    if (aPW()) {
      localArrayList2.add(0, aync.PACKAGE_NAME);
    }
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.fD(localArrayList2);
    this.Gk = localArrayList2;
  }
  
  public static void j(Collection<aymz> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      aymz localaymz = (aymz)paramCollection.next();
      if (localaymz.dzZ) {
        if ((localaymz instanceof ayne)) {
          Collections.shuffle(((ayne)localaymz).oT);
        } else if ((localaymz instanceof aynd)) {
          Collections.shuffle(((aynd)localaymz).items);
        }
      }
    }
  }
  
  protected int QW()
  {
    return 2131561131;
  }
  
  public void TX(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.aHL) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.e("change_face", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Aynj != null)
      {
        localObject = this.jdField_a_of_type_Aynj.a(paramInt);
        if ((localObject != null) && ((localObject instanceof aymz)))
        {
          ras.g("0X80076C7", "", "", ((aymz)localObject).id, "");
          ras.cz("0X80075DC", ((aymz)localObject).id);
        }
      }
      if (paramInt == 1)
      {
        ras.so("0X80076CC");
        ras.sp("0X80075E1");
      }
      return;
    }
  }
  
  public void apk()
  {
    super.apk();
    if (this.d != null) {
      this.d.eNU();
    }
  }
  
  public void b(ayoo.a parama)
  {
    if (((parama instanceof ayjn.b)) && (this.Gk != null))
    {
      Object localObject = (ayjn.b)parama;
      parama = ((ayjn.b)localObject).name;
      localObject = ((ayjn.b)localObject).category;
      int i = 0;
      while (i < this.Gk.size())
      {
        if (TextUtils.equals((String)this.Gk.get(i), (CharSequence)localObject))
        {
          TX(i);
          postDelayed(new StaticStickerProviderView.3(this, i, parama), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + (String)localObject + " name=" + parama);
      }
    }
  }
  
  public void buP()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.onChange();
  }
  
  public void dKI()
  {
    super.dKI();
    axsu localaxsu = (axsu)axov.a(4);
    ayfw.d locald = localaxsu.a();
    if (locald.aQw() != aPW()) {
      a(localaxsu, locald);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.notifyDataSetChanged();
  }
  
  public void dLs()
  {
    super.dLs();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.removeAllViews();
    clearMemory();
  }
  
  public void ePl()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (axsu.eL.compareAndSet(true, false))) {
      updateData();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561131, this, false);
    }
    addContentView(this.mContentView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager = ((FaceViewPager)findViewById(2131366657));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.a(this);
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    ePk();
    axsu localaxsu = (axsu)axov.a(4);
    localaxsu.eNH();
    paramBundle = localaxsu.a();
    a(localaxsu, paramBundle);
    setAdapter(paramBundle);
    Activity localActivity = (Activity)getContext();
    setDownloadListener(new axxs(this, localActivity));
    paramBundle = (DoodleLayout)localActivity.findViewById(2131366036);
    if (paramBundle == null) {
      paramBundle = (DoodleLayout)localActivity.findViewById(2131364258);
    }
    for (;;)
    {
      setOnFaceSelectedListener(paramBundle.a());
      this.mApp.registObserver(this.jdField_c_of_type_Axrf);
      localaxsu.c(true, (Activity)getContext());
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aynj != null) {
      this.jdField_a_of_type_Aynj.b(this);
    }
    ayfw.d locald = ((axsu)axov.a(4)).a();
    if (locald != null) {
      locald.b(this);
    }
    if (this.mApp != null) {
      this.mApp.unRegistObserver(this.jdField_c_of_type_Axrf);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.eIJ = paramInt;
    if (this.eIJ == 0) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.afq(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.getCurrentItem());
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.eIJ == 1)
    {
      if (paramInt1 >= this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.getCurrentItem()) {
        break label28;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.afp(paramInt1);
    }
    label28:
    while (paramInt1 != this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.getCurrentItem()) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.afp(paramInt1 + 1);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.onPageSelected(paramInt);
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab paster onResume");
    }
    ePl();
  }
  
  public void setAdapter(aynj paramaynj)
  {
    if (this.jdField_a_of_type_Aynj != null)
    {
      this.jdField_a_of_type_Aynj.b(this);
      this.jdField_a_of_type_Aynj = null;
    }
    if (paramaynj != null)
    {
      paramaynj.b(this);
      this.jdField_a_of_type_Aynj = paramaynj;
      this.jdField_a_of_type_Aynj.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_Aynj);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(FaceListPage.a parama)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(parama);
  }
  
  public void setOnFaceSelectedListener(axqg paramaxqg)
  {
    this.d = paramaxqg;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.setOnFaceSelectedListener(paramaxqg);
  }
  
  public void updateData()
  {
    ePk();
    axsu localaxsu = (axsu)axov.a(4);
    ayfw.d locald = localaxsu.a();
    if (locald != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localaxsu, locald);
      setAdapter(locald);
      buP();
      this.jdField_c_of_type_DovComQqImCaptureViewQIMSlidingTabView.TX(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.getCurrentItem());
    }
  }
  
  public void xA(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.onChange(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */