import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.TransitionProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.3;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ayeh
  extends aygy
  implements ayeg, ProviderView.a, DoodleLayout.b
{
  public static String cWP = "EditProviderPart";
  protected View Nf;
  View Ng;
  private View Nh;
  axrh jdField_a_of_type_Axrh = new ayeo(this);
  private axti.a jdField_a_of_type_Axti$a = new ayen(this);
  private axti jdField_a_of_type_Axti;
  private axtm.a jdField_a_of_type_Axtm$a = new ayem(this);
  private axtm jdField_a_of_type_Axtm;
  private axwg jdField_a_of_type_Axwg;
  private ayho jdField_a_of_type_Ayho = new ayel(this);
  public ProviderViewEditContainer a;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  HorizontalAlumbListLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
  private TextView agL;
  TextView ahT;
  private ProviderView b;
  FrameLayout bw;
  private VideoFilterViewPager c;
  public boolean dyJ;
  public boolean dyK;
  public int eCJ = -1;
  private int eJX = 0;
  private HashMap<Integer, ProviderView> jx = new HashMap();
  float mDownX;
  float mDownY;
  
  public ayeh(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private Bundle E()
  {
    Bundle localBundle = null;
    if (this.jdField_b_of_type_Aygz.bQ != null) {
      localBundle = this.jdField_b_of_type_Aygz.bQ.getBundle("container");
    }
    return localBundle;
  }
  
  private void P(int paramInt, Object paramObject)
  {
    if ((this.Nh != null) && (this.Nh.getVisibility() == 0))
    {
      this.Nh.setVisibility(8);
      this.Nh = null;
    }
    if (this.jdField_b_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_b_of_type_DovComQqImCaptureViewProviderView.dLs();
      this.jdField_b_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_b_of_type_DovComQqImCaptureViewProviderView = null;
    }
    Object localObject;
    if (this.jx.containsKey(Integer.valueOf(paramInt))) {
      localObject = (ProviderView)this.jx.get(Integer.valueOf(paramInt));
    }
    int i;
    while (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditProviderPart", 2, "build provider view failed " + paramInt);
      }
      return;
      ProviderView localProviderView = this.jdField_a_of_type_Axwg.a(getContext(), paramInt);
      if (localProviderView != null) {
        this.jx.put(Integer.valueOf(paramInt), localProviderView);
      }
      localObject = localProviderView;
      if ((localProviderView instanceof TransitionProviderView))
      {
        i = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getIntExtra("extra_transiton_src_from", -1);
        ((TransitionProviderView)localProviderView).eIK = i;
        localObject = localProviderView;
      }
    }
    a((ProviderView)localObject, paramObject);
    if (!((ProviderView)localObject).isInit())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfw.a();
      }
      if (this.jdField_b_of_type_Aygz.ok != null)
      {
        paramInt = ((ProviderView)localObject).getContentHeight();
        i = this.jdField_b_of_type_Aygz.ok.getHeight();
        ((ProviderView)localObject).TZ(paramInt + (int)rpq.b(getContext(), i));
      }
      ((ProviderView)localObject).onCreate(E());
    }
    this.jdField_b_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
    if (this.jdField_b_of_type_DovComQqImCaptureViewProviderView.getId() != 2131364259) {
      YI(false);
    }
    this.jdField_b_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    this.jdField_b_of_type_DovComQqImCaptureViewProviderView.dKI();
    this.bw.setVisibility(0);
    this.Ng.setVisibility(0);
  }
  
  private void a(ProviderView paramProviderView, Object paramObject)
  {
    paramProviderView.busType = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi;
    if ((paramProviderView instanceof MusicProviderView))
    {
      paramProviderView = (MusicProviderView)MusicProviderView.class.cast(paramProviderView);
      if ((paramObject != null) && (paramObject.equals(Integer.valueOf(1001)))) {
        paramProviderView.setPreSelectTagIndex(((QIMMusicConfigManager)axov.a(2)).Rt() - 1);
      }
    }
    try
    {
      paramProviderView.onShow();
      return;
    }
    catch (Throwable paramProviderView)
    {
      QLog.d("EditProviderPart", 1, String.format("throwable = %s", new Object[] { paramProviderView }));
    }
  }
  
  private void afb(int paramInt)
  {
    P(paramInt, null);
  }
  
  private void eQQ()
  {
    Object localObject1;
    if (this.jdField_b_of_type_Aygz != null)
    {
      localObject1 = this.jdField_b_of_type_Aygz;
      if (aygz.r(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 16))
      {
        localObject1 = this.jdField_b_of_type_Aygz;
        if (!aygz.F(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 137438953472L))
        {
          localObject1 = ((axpr)axov.a(5)).jdField_a_of_type_Ayva$a;
          if (localObject1 != null) {
            break label86;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "comboFilterData null");
          }
        }
      }
    }
    label86:
    do
    {
      return;
      localObject1 = ((ayva.a)localObject1).eS();
      if ((localObject1 == null) || (((List)localObject1).size() >= 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo", 2, "recommend trans less than 3");
    return;
    this.Nh = y(2131380144);
    Object localObject2;
    if (this.jdField_b_of_type_Aygz.ok != null)
    {
      if (!this.jdField_b_of_type_Aygz.dzj) {
        break label240;
      }
      localObject2 = (RelativeLayout)y(2131366263);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Nh.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(2, 0);
      ((ViewGroup)this.Nh.getParent()).removeView(this.Nh);
      ((RelativeLayout)localObject2).addView(this.Nh, localLayoutParams);
    }
    for (;;)
    {
      this.Nh.postDelayed(new EditProviderPart.2(this, (List)localObject1), 1000L);
      return;
      label240:
      localObject2 = (RelativeLayout.LayoutParams)this.Nh.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 0);
      this.Nh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  private void eQS()
  {
    String str = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_transiton_default");
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "EditProviderPart setDedaultTransition transId=" + str);
    }
    Object localObject = ((axpr)axov.a(5)).jdField_a_of_type_Ayva$a;
    if (localObject != null)
    {
      localObject = ((ayva.a)localObject).eR();
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((FilterCategory)((ArrayList)localObject).get(0)).Fv.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TransitionCategoryItem localTransitionCategoryItem = (TransitionCategoryItem)((Iterator)localObject).next();
          if (localTransitionCategoryItem.transId.equals(str))
          {
            ayva.a().a(localTransitionCategoryItem);
            aey(Integer.parseInt(localTransitionCategoryItem.id));
          }
        }
      }
    }
  }
  
  private void eQT()
  {
    Object localObject = rly.a(getContext()).ch();
    axro localaxro = (axro)axov.a().c(8);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      QIMMusicConfigManager localQIMMusicConfigManager = (QIMMusicConfigManager)axov.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        rly.a locala = (rly.a)((Iterator)localObject).next();
        boolean bool = localaxro.a(localQIMMusicConfigManager.a(locala.tagId, locala.itemId), this.jdField_a_of_type_Axrh);
        if (QLog.isColorLevel()) {
          QLog.d("EditProviderPart", 2, "EditProviderPart preDownloadMusic needDownload=" + bool + " itemId=" + locala.itemId);
        }
      }
    }
  }
  
  public boolean La()
  {
    return false;
  }
  
  public void O(int paramInt, Object paramObject)
  {
    this.jdField_b_of_type_Aygz.r(paramInt, paramObject);
  }
  
  public int RP()
  {
    if (this.jdField_b_of_type_Aygz.Ld())
    {
      if (this.jdField_b_of_type_Aygz.La()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_b_of_type_Aygz.La()) {
      return 1;
    }
    return 2;
  }
  
  public void S(byte[] paramArrayOfByte) {}
  
  public void YI(boolean paramBoolean)
  {
    if (this.agL == null) {}
    for (;;)
    {
      return;
      MusicProviderView localMusicProviderView = (MusicProviderView)this.jx.get(Integer.valueOf(104));
      MusicItemInfo localMusicItemInfo = ((axro)axov.a().c(8)).b();
      if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.aPD())) {}
      for (paramBoolean = true; (this.jdField_a_of_type_Ayii != null) && ((this.jdField_a_of_type_Ayii instanceof EditVideoActivity)) && (this.jdField_a_of_type_Ayii.getActivity() != null); paramBoolean = false)
      {
        this.jdField_a_of_type_Ayii.getActivity().runOnUiThread(new EditProviderPart.4(this, paramBoolean));
        return;
      }
    }
  }
  
  public void Zk(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "preloadProviderView count" + this.jdField_a_of_type_Axwg.getCount());
    }
    Bundle localBundle = E();
    int i = 0;
    if (i < this.jdField_a_of_type_Axwg.getCount())
    {
      int j = this.jdField_a_of_type_Axwg.iQ(i);
      if ((paramBoolean) && (!this.jdField_a_of_type_Axwg.ox(j))) {}
      label223:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ((ProviderView)this.jx.get(Integer.valueOf(j)) == null)
          {
            ProviderView localProviderView = this.jdField_a_of_type_Axwg.a(getContext(), j);
            if (localProviderView == null) {
              break label223;
            }
            this.jx.put(Integer.valueOf(this.jdField_a_of_type_Axwg.iQ(i)), localProviderView);
            localProviderView.setProviderViewListener(this);
            localProviderView.setDoodleEventListener(this);
            localProviderView.ex(localBundle);
            this.bw.addView(localProviderView);
            localProviderView.setVisibility(8);
            if ((localProviderView instanceof TransitionProviderView))
            {
              j = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getIntExtra("extra_transiton_src_from", -1);
              ((TransitionProviderView)localProviderView).eIK = j;
            }
            if (!paramBoolean) {
              localProviderView.onResume();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("EditProviderPart", 2, "preloadProviderView failed " + i);
    }
  }
  
  public <T extends ProviderView> T a(Class<? extends ProviderView> paramClass)
  {
    Iterator localIterator = this.jx.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      if (paramClass.isInstance(localProviderView)) {
        return localProviderView;
      }
    }
    return null;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    if ((QIMFilterProviderView)a(QIMFilterProviderView.class) != null) {
      if (ayva.a().c(this.eCJ) == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      paramayqb.aIC = bool;
      if ((paramayqb.aIC) && (this.jdField_b_of_type_Aygz.La()))
      {
        paramayqb = paramayqb.a;
        paramayqb.bsR += 1;
      }
      return;
    }
  }
  
  public void a(aynd.a parama)
  {
    ((psr)psx.a(10)).n("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString) {}
  
  public void adg(String paramString) {}
  
  public void aev(int paramInt) {}
  
  public void aew(int paramInt) {}
  
  public void aex(int paramInt)
  {
    this.jdField_b_of_type_Aygz.changeState(32);
    this.jdField_b_of_type_Aygz.changeState(paramInt);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.dLp();
    }
  }
  
  public void aey(int paramInt)
  {
    ((ayfb)a(ayfb.class)).afc(paramInt);
  }
  
  public void asq() {}
  
  public void b(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramInt != -1) {
      this.c.setCurrentItem(paramInt, false);
    }
  }
  
  public void bsE() {}
  
  public void bsF() {}
  
  public void close() {}
  
  public void cm(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject1 = (axpr)axov.a(5);
        Object localObject2 = localObject1.jdField_a_of_type_ArrayOfAxpr$b[this.eCJ].jdField_b_of_type_Axqc;
        if (localObject2 == null) {
          break label183;
        }
        localObject2 = (QIMFilterCategoryItem)((axqc)localObject2).target;
        if (localObject2 == null) {
          break label183;
        }
        localJSONObject.put("comboItem", ((QIMFilterCategoryItem)localObject2).convertToJSON());
        i = 1;
        localObject1 = localObject1.jdField_a_of_type_ArrayOfAxpr$b[this.eCJ].jdField_b_of_type_Axqf;
        j = i;
        if (localObject1 != null)
        {
          localObject1 = (QIMFilterCategoryItem)((axqf)localObject1).target;
          j = i;
          if (localObject1 != null)
          {
            localJSONObject.put("filterItem", ((QIMFilterCategoryItem)localObject1).convertToJSON());
            j = 1;
          }
        }
        localObject1 = ((axro)axov.a().c(8)).b();
        if (localObject1 != null)
        {
          localJSONObject.put("musicItem", ((MusicItemInfo)localObject1).convertToJSON());
          i = 1;
          if (i != 0) {
            paramJSONObject.put(cWP, localJSONObject);
          }
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      int i = j;
      continue;
      label183:
      i = 0;
    }
  }
  
  public void d(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void dLp()
  {
    if ((this.Nh != null) && (this.Nh.getVisibility() == 0))
    {
      this.Nh.setVisibility(8);
      this.Nh = null;
    }
    if (this.jdField_b_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_b_of_type_DovComQqImCaptureViewProviderView.dLs();
      this.jdField_b_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_b_of_type_DovComQqImCaptureViewProviderView = null;
    }
    this.bw.setVisibility(8);
    this.Ng.setVisibility(8);
  }
  
  public void e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void eNr() {}
  
  public void eNs() {}
  
  public void eNu()
  {
    this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayic.xe(this.jdField_b_of_type_Aygz.tj());
  }
  
  public void eNv() {}
  
  public void eNw() {}
  
  public void eQM()
  {
    eQQ();
  }
  
  public void eQN()
  {
    if ((this.Nh != null) && (this.Nh.getVisibility() == 0)) {
      this.Nh.setVisibility(8);
    }
  }
  
  public void eQO()
  {
    Object localObject;
    if (this.jdField_a_of_type_Ayii != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout = ((HorizontalAlumbListLayout)y(2131372286));
      this.ahT = ((TextView)y(2131375240));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsContent(this.ahT);
      if (this.jdField_b_of_type_Aygz.ok == null) {
        break label394;
      }
      if (!this.jdField_b_of_type_Aygz.dzj) {
        break label345;
      }
      localObject = (RelativeLayout)y(2131366263);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(2, 0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, 0);
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getParent();
      localViewGroup.removeView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout, localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.ahT.getLayoutParams();
      localViewGroup.removeView(this.ahT);
      ((RelativeLayout)localObject).addView(this.ahT, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setEditVideoUI(this.jdField_a_of_type_Ayii);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.bJ(rma.a().getPhotoList());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(0);
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getBooleanExtra("PhotoConst.IS_FROM_EDIT", false)) {
        rma.a().bvq();
      }
      rma.a().bf(this.jdField_a_of_type_Ayii.getActivity());
      eQN();
      if (aygz.r(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 16)) {
        eQS();
      }
      eQT();
      try
      {
        localObject = this.jdField_a_of_type_Ayii.getActivity().getIntent();
        int i = ((EditVideoParams)((Intent)localObject).getParcelableExtra(EditVideoParams.class.getName())).getIntExtra("extra_slide_entrance", -1);
        rar.a("video_edit_new", "exp_albumbar", (Intent)localObject, new String[] { i + "" });
        return;
        label345:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, getResources().getDimensionPixelOffset(2131298491));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        continue;
        label394:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, getResources().getDimensionPixelOffset(2131298491));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("EditProviderPart", 2, aurp.getStackTraceAsString(localException));
      }
    }
  }
  
  public void eQP()
  {
    boolean bool2 = true;
    ayva.a locala = ((axpr)axov.a(5)).jdField_a_of_type_Ayva$a;
    if ((locala != null) && (this.c != null))
    {
      this.c.bD(locala.a(this.eCJ).filterList);
      this.c.eTR();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    boolean bool1;
    if (locala == null)
    {
      bool1 = true;
      if (this.c != null) {
        break label111;
      }
    }
    for (;;)
    {
      QLog.d("EditProviderPart", 2, new Object[] { "comboFilterData is null, ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2) });
      return;
      bool1 = false;
      break;
      label111:
      bool2 = false;
    }
  }
  
  public void eQR()
  {
    if (this.jdField_b_of_type_Aygz != null)
    {
      aygz localaygz = this.jdField_b_of_type_Aygz;
      if (aygz.F(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 137438953472L))
      {
        if (rma.a().tF() != 13) {
          break label101;
        }
        rma.a().bvs();
        rma.a().resetUI();
      }
    }
    for (;;)
    {
      ((axro)axov.a().c(8)).eOq();
      if (this.ahT != null) {
        this.ahT.setVisibility(8);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(8);
      }
      return;
      label101:
      rma.a().bvs();
    }
  }
  
  public void eb(int paramInt1, int paramInt2)
  {
    if (1 == paramInt1) {
      QQToast.a(this.jdField_a_of_type_Ayii.getContext(), acfp.m(2131705467), 0).show();
    }
  }
  
  public int getVideoDuration()
  {
    return (int)this.jdField_b_of_type_Aygz.x(this.jdField_b_of_type_Aygz.tj());
  }
  
  public void h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onActivityFinish()
  {
    super.onActivityFinish();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.apk();
    }
    ((axpr)axov.a(5)).jdField_a_of_type_ArrayOfAxpr$b[this.eCJ].cW((Activity)this.bw.getContext());
    eQR();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    a(ayeg.class, this);
    int i = RP();
    this.eCJ = i;
    ayva.a().k(this.jdField_b_of_type_Aygz);
    this.bw = ((FrameLayout)y(2131373724));
    this.Ng = y(2131365336);
    int j;
    Object localObject;
    if (this.jdField_b_of_type_Aygz.ok != null)
    {
      j = this.jdField_b_of_type_Aygz.ok.getHeight();
      localObject = this.bw.getLayoutParams();
      if (j > 0) {
        break label443;
      }
      ((ViewGroup.LayoutParams)localObject).height += ayxa.eMW;
      this.bw.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.Ng.getLayoutParams();
      if (j > 0) {
        break label456;
      }
    }
    label443:
    label456:
    for (((ViewGroup.LayoutParams)localObject).height += ayxa.eMW;; ((ViewGroup.LayoutParams)localObject).height = (j + ((ViewGroup.LayoutParams)localObject).height))
    {
      this.Ng.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_Axwg = new axwg(i);
      this.jdField_a_of_type_Axwg.ie();
      this.jdField_a_of_type_Axtm = new axtm();
      this.jdField_a_of_type_Axtm.a(this.jdField_a_of_type_Axtm$a);
      this.jdField_a_of_type_Axtm.bm(this.jdField_a_of_type_Ayii.getRootView());
      this.jdField_a_of_type_Axti = new axti();
      this.jdField_a_of_type_Axti.a(this.jdField_a_of_type_Axti$a);
      this.jdField_a_of_type_Axti.bm(this.jdField_a_of_type_Ayii.getRootView());
      this.c = ((VideoFilterViewPager)y(2131374669));
      this.c.setReadyToApply(false);
      this.c.setCaptureScene(this.eCJ);
      if (axcg.c.ob(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.entryType)) {
        this.c.dzQ = true;
      }
      eQP();
      this.Nf = y(2131374670);
      this.Nf.setOnTouchListener(new ayei(this));
      if ((this.jdField_a_of_type_Ayii instanceof EditVideoActivity)) {
        this.agL = ((TextView)y(2131366224));
      }
      Zk(true);
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        ((ViewStub)y(2131374671)).inflate();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)y(2131373720));
        i = this.jdField_b_of_type_Aygz.RP();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.aeQ(i);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this);
        localObject = (BgmRecognitionProviderView)this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(110);
        if (localObject != null) {
          ((BgmRecognitionProviderView)localObject).setRecognitionPart(this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayep);
        }
      }
      return;
      ((ViewGroup.LayoutParams)localObject).height += j;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
    ayva.a().eTO();
  }
  
  public void onMusicOriginalChange(boolean paramBoolean) {}
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.jx.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).onStop();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ayva.a().afK(this.eCJ);
    Object localObject = this.jx.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ProviderView)((Iterator)localObject).next()).onResume();
    }
    ((axpr)axov.a(5)).jdField_a_of_type_ArrayOfAxpr$b[this.eCJ].cU((Activity)this.bw.getContext());
    localObject = this.jdField_b_of_type_Aygz;
    if ((aygz.F(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 137438953472L)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.bJ(rma.a().getPhotoList());
    }
    if (!this.dyK) {
      ThreadManager.getUIHandler().postDelayed(new EditProviderPart.3(this), 500L);
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    super.p(paramInt, paramObject);
    this.eJX = paramInt;
    switch (paramInt)
    {
    default: 
      dLp();
    }
    for (;;)
    {
      if ((paramInt != -1) && (paramInt != 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsGone();
      }
      return;
      afb(103);
      continue;
      afb(104);
      if (rma.a().tG() == 22)
      {
        LpReportInfo_pf00064.allReport(680, 3, 1);
        continue;
        P(104, paramObject);
        continue;
        afb(107);
        continue;
        afb(101);
        continue;
        afb(108);
        continue;
        afb(112);
        continue;
        this.dyJ = true;
        dLp();
        continue;
        this.dyJ = false;
        dLp();
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.dLp();
        }
      }
    }
  }
  
  public void q(int paramInt, Object paramObject)
  {
    if (paramInt == 7) {
      dLp();
    }
  }
  
  public void r(int paramInt, Object... paramVarArgs)
  {
    Pair localPair = new Pair(Integer.valueOf(paramInt), paramVarArgs);
    this.jdField_b_of_type_Aygz.r(31, localPair);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.s(paramInt, paramVarArgs);
    }
  }
  
  public void ss(String paramString)
  {
    this.jdField_a_of_type_Axtm.bsQ();
    this.jdField_a_of_type_Axtm.a().d(true, this.jdField_a_of_type_Ayii.getActivity());
    this.jdField_a_of_type_Axtm.a().a(this.jdField_a_of_type_Ayho, paramString);
  }
  
  public void uZ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_Aygz.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_b_of_type_Aygz.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayeh
 * JD-Core Version:    0.7.0.1
 */