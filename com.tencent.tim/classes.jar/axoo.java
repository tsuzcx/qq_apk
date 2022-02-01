import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(17)
public class axoo
  implements ProviderView.a, DoodleLayout.b
{
  private View Gm;
  private View LX;
  private ViewStub Q;
  private ViewStub R;
  private axti.a jdField_a_of_type_Axti$a = new axou(this);
  private axti jdField_a_of_type_Axti;
  private axtm.a jdField_a_of_type_Axtm$a = new axot(this);
  private axtm jdField_a_of_type_Axtm;
  ayca jdField_a_of_type_Ayca;
  private ayho jdField_a_of_type_Ayho = new axos(this);
  private final EffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  private ProviderViewEditContainer jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
  protected DoodleLayout a;
  private QIMCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  private long aCr;
  public axpu b;
  public QIMProviderContainerView b;
  private SpeedFlexibleRecyclerView jdField_b_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView;
  private QIMCameraCaptureButtonLayout jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  public int busType;
  private QIMCameraCaptureButtonLayout c;
  private int cIM = -1;
  private boolean dp;
  private boolean drt;
  private boolean dvG;
  private boolean dvH;
  public boolean dvI;
  boolean dvJ = true;
  private int eGp;
  private int eGq = -1;
  private ViewGroup fb;
  private boolean isOriginal = true;
  public AppInterface mApp;
  public View mRootView;
  private RelativeLayout nY;
  
  public axoo(AppInterface paramAppInterface, View paramView, ayca paramayca)
  {
    this.jdField_b_of_type_Axpu = new axor(this);
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.mRootView = paramView;
    this.jdField_a_of_type_Ayca = paramayca;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.mRootView.findViewById(2131364201));
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView = ((QIMProviderContainerView)this.mRootView.findViewById(2131373718));
    this.fb = ((ViewGroup)this.mRootView.findViewById(2131367583));
    this.nY = ((RelativeLayout)this.mRootView.findViewById(2131364266));
    this.LX = this.mRootView.findViewById(2131365505);
    this.Gm = this.mRootView.findViewById(2131367317);
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)paramView.findViewById(2131364256));
    this.c = ((QIMCameraCaptureButtonLayout)paramView.findViewById(2131377927));
    if ((this.c == null) && ((this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout instanceof QIMCameraStoryCaptureButtonLayout))) {
      this.c = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    this.mApp = paramAppInterface;
    this.jdField_a_of_type_Axtm = new axtm();
    this.jdField_a_of_type_Axtm.a(this.jdField_a_of_type_Axtm$a);
    this.jdField_a_of_type_Axtm.bm(paramView);
    this.jdField_a_of_type_Axti = new axti();
    this.jdField_a_of_type_Axti.a(this.jdField_a_of_type_Axti$a);
    this.jdField_a_of_type_Axti.bm(paramView);
  }
  
  public boolean La()
  {
    return false;
  }
  
  public void O(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureController", 2, "changeProviderViewStateWithExtra: invoked. info: index = " + paramInt);
    }
    MusicProviderView localMusicProviderView;
    if (paramInt == 104)
    {
      paramObject = (QIMMusicConfigManager)axov.a(2);
      localMusicProviderView = (MusicProviderView)this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
      if (localMusicProviderView != null) {
        localMusicProviderView.setPreSelectTagIndex(paramObject.Rt() - 1);
      }
    }
    try
    {
      localMusicProviderView.onShow();
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.d("CaptureController", 1, String.format("throwable = %s", new Object[] { paramObject }));
    }
  }
  
  public void S(byte[] paramArrayOfByte) {}
  
  public void YI(boolean paramBoolean)
  {
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
    MusicItemInfo localMusicItemInfo = ((axro)axov.a().c(8)).b();
    EffectsCameraCaptureView localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
    if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.aPD())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localEffectsCameraCaptureView.Oz(paramBoolean);
      return;
    }
  }
  
  public void YJ(boolean paramBoolean)
  {
    if (this.drt != paramBoolean)
    {
      this.drt = paramBoolean;
      if (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
        this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.Zc(paramBoolean);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eSJ();
      }
    }
  }
  
  public void YK(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      if (((awrz)axov.a(13)).aNw()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.db(paramBoolean, false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eSJ();
  }
  
  public void YL(boolean paramBoolean)
  {
    this.dvJ = paramBoolean;
  }
  
  public DoodleLayout a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public void a(aynd.a parama)
  {
    ((psr)psx.a(10)).n("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString)
  {
    boolean bool2 = true;
    Object localObject;
    if (VideoPrefsUtil.getDefaultPrefs() != null)
    {
      if (!this.isOriginal)
      {
        bool1 = true;
        VideoPrefsUtil.setMaterialMute(bool1);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onDrawTemplateOnScreen isOriginal").append(this.isOriginal).append(" ");
        if (VideoPrefsUtil.getDefaultPrefs() != null) {
          break label138;
        }
        bool1 = true;
        label64:
        QLog.d("CaptureController", 2, bool1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
        if ((anjo.lC(ayzs.dyy)) && (paramPtvTemplateInfo != null))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
          if (paramPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) {
            break label143;
          }
        }
      }
    }
    label138:
    label143:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).OA(bool1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(paramString);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label64;
    }
  }
  
  public boolean aOc()
  {
    if (this.dp) {}
    while ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.aOc())) {
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.aQP()))
    {
      q(7, null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ZD(false);
      return true;
    }
    return false;
  }
  
  public boolean aPm()
  {
    if (this.jdField_a_of_type_Axtm.aPI())
    {
      this.jdField_a_of_type_Axtm.onHide();
      return true;
    }
    if (this.jdField_a_of_type_Axti.aPI())
    {
      this.jdField_a_of_type_Axti.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean aPn()
  {
    return this.dvH;
  }
  
  public boolean aPo()
  {
    return this.dvJ;
  }
  
  public void adg(String paramString)
  {
    if (this.isOriginal) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setMovieEffect(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawMovieTemplateOnScreen isOriginal" + this.isOriginal);
      }
      return;
      VideoPrefsUtil.setMaterialMute(true);
    }
  }
  
  public void aev(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.getBeautyLevel() == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature AdvancedProviderView.sBeautyLevel equals to level");
      }
      return;
    }
    if (GLVideoClipUtil.aRj())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(paramInt);
  }
  
  public void aew(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.cAX)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawSharpFaceFeature unSupport!");
      }
      return;
    }
    boolean bool;
    label32:
    EffectsCameraCaptureView localEffectsCameraCaptureView;
    if (paramInt > 0)
    {
      bool = true;
      QQSharpFaceFilter.sSharpFaceOpen = bool;
      localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if (!QQSharpFaceFilter.sSharpFaceOpen) {
        break label122;
      }
    }
    label122:
    for (int i = paramInt;; i = -1)
    {
      localEffectsCameraCaptureView.updateSharpFace(i);
      if ((!QLog.isColorLevel()) || (QQSharpFaceFilter.sSharpFaceOpen)) {
        break;
      }
      QLog.d("CaptureController", 2, new Object[] { "onDrawSharpFaceFeature level = ", paramInt + ", faceOpen:", Boolean.valueOf(QQSharpFaceFilter.sSharpFaceOpen) });
      return;
      bool = false;
      break label32;
    }
  }
  
  public void aex(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.fb != null))
    {
      if (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.f(MusicProviderView.class)) {
        this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.a().ePe();
      }
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
      this.fb.setVisibility(0);
      this.nY.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.dLp();
    }
  }
  
  public void aey(int paramInt) {}
  
  public void aez(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.auV())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.dLf();
    }
  }
  
  public void apk()
  {
    dLp();
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null))
    {
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.apk();
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.tK(true);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().clear();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().clear();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().clear();
    }
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.apk();
    ayva.a().afK(0);
    VideoFilterViewPager localVideoFilterViewPager = (VideoFilterViewPager)this.mRootView.findViewById(2131367272);
    if (localVideoFilterViewPager != null) {
      localVideoFilterViewPager.adv(0);
    }
    axvy.a().aeL(0);
  }
  
  public void asq() {}
  
  public void b(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Object localObject;
    if (paramInt != -1)
    {
      localObject = (VideoFilterViewPager)this.mRootView.findViewById(2131367272);
      if (localObject != null) {
        ((VideoFilterViewPager)localObject).setCurrentItem(paramInt, false);
      }
    }
    if (paramQIMFilterCategoryItem != null)
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.za.iterator();
      while (paramQIMFilterCategoryItem.hasNext())
      {
        localObject = (String)paramQIMFilterCategoryItem.next();
        if (EffectsCameraCaptureView.a(ayva.a().a((String)localObject))) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.dLj();
        }
      }
    }
  }
  
  public void bsE() {}
  
  public void bsF() {}
  
  public void bsQ()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("makeSureInitStub mDoodleLayout:");
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
        break label400;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" mEditContainer:");
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
        break label405;
      }
    }
    label400:
    label405:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("CaptureController", 2, bool);
      long l1;
      long l2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
      {
        l1 = System.currentTimeMillis();
        this.Q = ((ViewStub)this.mRootView.findViewById(2131366037));
        this.Q.inflate();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.mRootView.findViewById(2131364258));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEntrance(0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eSz();
        this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCaptureControllerAndPreloadView(this);
        axvy.a().a(0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CaptureController", 2, new Object[] { "onFirstFrameShownInternal initDoodleLayout:", Long.valueOf(l2 - l1) });
        }
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        l1 = System.currentTimeMillis();
        this.R = ((ViewStub)this.mRootView.findViewById(2131374671));
        this.R.inflate();
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)this.mRootView.findViewById(2131373720));
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.aeQ(0);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setStickerListener(((DoodleEditView)localObject).a());
        ((DoodleEditView)localObject).setFrom(0);
        ((DoodleEditView)localObject).ZC(false);
        ((DoodleEditView)localObject).setDoodleEditViewListener(new axop(this));
        this.mRootView.findViewById(2131366228).setOnTouchListener(new axoq(this));
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CaptureController", 2, new Object[] { "onFirstFrameShownInternal initEditContainer:", Long.valueOf(l2 - l1) });
        }
      }
      if (this.mApp != null) {
        this.mApp.registObserver(this.jdField_b_of_type_Axpu);
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void bta()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.bue();
    }
  }
  
  public void by(boolean paramBoolean, int paramInt)
  {
    float f = this.fb.getHeight();
    ObjectAnimator localObjectAnimator2;
    Object localObject1;
    if (paramBoolean)
    {
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.fb, "translationY", new float[] { 0.0F, f });
      localObject1 = ObjectAnimator.ofFloat(this.nY, "translationY", new float[] { 0.0F, f });
      if (!aPn()) {
        break label292;
      }
    }
    label292:
    for (ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, "translationY", new float[] { 0.0F, f });; localObjectAnimator1 = null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);
      Object localObject2 = localObject1;
      localObject1 = localScaleAnimation;
      ((ScaleAnimation)localObject1).setDuration(paramInt);
      ((ScaleAnimation)localObject1).setFillAfter(true);
      localObjectAnimator2.setDuration(paramInt).start();
      ((ObjectAnimator)localObject2).setDuration(paramInt).start();
      if (aPn()) {
        localObjectAnimator1.setDuration(paramInt).start();
      }
      this.LX.startAnimation((Animation)localObject1);
      return;
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.fb, "translationY", new float[] { f, 0.0F });
      localObject2 = ObjectAnimator.ofFloat(this.nY, "translationY", new float[] { f, 0.0F });
      if (aPn()) {}
      for (localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, "translationY", new float[] { f, 0.0F });; localObjectAnimator1 = null)
      {
        localObject1 = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F);
        break;
      }
    }
  }
  
  public void close() {}
  
  @TargetApi(11)
  public void cx(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == this.cIM) && (!paramBoolean))
    {
      dLp();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().tJ(true);
    }
    for (this.cIM = -1;; this.cIM = paramInt)
    {
      this.eGq = paramInt;
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ZD(true);
      if ((this.cIM == -1) || (this.dvI)) {
        by(true, 150);
      }
    }
  }
  
  public void d(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void dLp()
  {
    if (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.dLp();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.buy();
    }
    if (this.fb != null) {
      this.fb.setVisibility(0);
    }
    this.cIM = -1;
  }
  
  public void e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void eGZ()
  {
    ayva.a().afK(0);
    ((axpr)axov.a(5)).a[0].cU((Activity)this.mRootView.getContext());
  }
  
  public void eHZ()
  {
    if ((this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.f(AdvancedProviderView.class)))
    {
      AdvancedProviderView localAdvancedProviderView = (AdvancedProviderView)this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(AdvancedProviderView.class);
      if (localAdvancedProviderView != null) {
        localAdvancedProviderView.eHZ();
      }
    }
  }
  
  public void eNA()
  {
    this.dvI = true;
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.T(this.cIM, axpa.eGs, axpa.cVC);
    this.dvI = false;
  }
  
  public void eNp()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      axvy.a().a(0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void eNq()
  {
    if (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.eNq();
    }
  }
  
  public void eNr() {}
  
  public void eNs()
  {
    eNt();
  }
  
  public void eNt()
  {
    Object localObject = this.mRootView.findViewById(2131370820);
    if ((localObject != null) && ((localObject instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout)localObject;
      if ((localObject != null) && (((RelativeLayout)localObject).isShown()))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        localObject = (VideoFilterViewPager)this.mRootView.findViewById(2131367272);
        if (localObject != null) {
          ((VideoFilterViewPager)localObject).eTS();
        }
      }
    }
  }
  
  public void eNu()
  {
    Activity localActivity = (Activity)this.mRootView.getContext();
    if ((!MusicProviderView.dwS) && (localActivity.getIntent() != null)) {
      localActivity.getIntent().removeExtra("video_tag_info");
    }
  }
  
  public void eNv() {}
  
  public void eNw() {}
  
  public void eNx()
  {
    this.dp = true;
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
    DoodleLayout localDoodleLayout = axvy.a().a(0);
    if (localDoodleLayout != null) {
      localDoodleLayout.setRecording(this.dp);
    }
    if (localMusicProviderView != null) {
      localMusicProviderView.Zb(true);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.db(true, true);
    }
  }
  
  public void eNy()
  {
    this.dp = false;
    DoodleLayout localDoodleLayout = axvy.a().a(0);
    if (localDoodleLayout != null) {
      localDoodleLayout.setRecording(this.dp);
    }
  }
  
  public void eNz()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eNz();
    }
  }
  
  public void eb(int paramInt1, int paramInt2)
  {
    long l = SystemClock.elapsedRealtime();
    if ((1 == paramInt1) && (l - this.aCr > 4000L))
    {
      QQToast.a(this.mRootView.getContext(), acfp.m(2131711188), 0).show();
      this.aCr = l;
    }
  }
  
  public int getVideoDuration()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout == null) {
      return 10000;
    }
    return (int)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.cp();
  }
  
  public void h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public boolean isRecording()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.auU());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      if ((paramInt2 == 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ZE(this.drt);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onActivityResult null!!!");
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.onDestroy();
    if (this.mApp != null) {
      this.mApp.unRegistObserver(this.jdField_b_of_type_Axpu);
    }
    this.mApp = null;
    axvy.a().aeL(0);
  }
  
  public void onMusicOriginalChange(boolean paramBoolean)
  {
    boolean bool = true;
    this.isOriginal = paramBoolean;
    Object localObject;
    if (this.isOriginal)
    {
      VideoPrefsUtil.setMaterialMute(false);
      localObject = EffectsCameraCaptureView.b();
      if (localObject != null)
      {
        localObject = ((QQFilterRenderManager)localObject).getBusinessOperation();
        if (paramBoolean) {
          break label85;
        }
      }
    }
    label85:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((FilterBusinessOperation)localObject).setEffectMute(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onPlayVideoMusic isOriginal" + this.isOriginal);
      }
      return;
      VideoPrefsUtil.setMaterialMute(true);
      break;
    }
  }
  
  public void onResume()
  {
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.onResume();
    ayva.a().afK(0);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.dLf();
    }
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      axvy.a().a(0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureController", 2, "onStop...");
    }
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.onStop();
    ((axph)axov.a(9)).YN(true);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.dLe();
    }
  }
  
  public void q(int paramInt, Object paramObject)
  {
    if (anhq.a().axb()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt != 4) {
                break;
              }
            } while ((this.eGp != 0) || (this.fb.getVisibility() != 0));
            this.fb.setVisibility(8);
            if (!this.drt) {
              this.nY.setVisibility(8);
            }
            this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
            this.Gm.setVisibility(8);
          } while (!aPn());
          this.jdField_b_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setVisibility(8);
          return;
          if (paramInt != 0) {
            break;
          }
        } while (this.fb.getVisibility() != 8);
        this.fb.setVisibility(0);
        if (!this.drt) {
          this.nY.setVisibility(0);
        }
        this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVisibility(8);
        this.Gm.setVisibility(0);
      } while (!aPn());
      this.jdField_b_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setVisibility(0);
      return;
      if (paramInt == 7)
      {
        if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.fb != null))
        {
          this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
          this.fb.setVisibility(0);
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.dLp();
        }
        dLp();
        return;
      }
    } while (paramInt != 3);
    this.fb.setVisibility(8);
    if (!this.drt) {
      this.nY.setVisibility(8);
    }
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
    this.Gm.setVisibility(0);
  }
  
  public void r(int paramInt, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.fb != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0) && (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.f(MusicProviderView.class)))
    {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.a().ePd();
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
      this.fb.setVisibility(8);
      this.nY.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.s(paramInt, paramVarArgs);
    }
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    this.dvG = paramBoolean;
    if (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setIsGuideMode(paramBoolean);
    }
  }
  
  public void setVisible(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      bta();
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null) || (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0))
    {
      if (!this.dvG) {
        break label57;
      }
      if (paramInt != 0) {
        this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.eGp = paramInt;
      return;
      label57:
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(paramInt);
    }
  }
  
  public void ss(String paramString)
  {
    this.jdField_a_of_type_Axtm.bsQ();
    if (this.mRootView != null) {
      this.jdField_a_of_type_Axtm.a().d(true, (Activity)this.mRootView.getContext());
    }
    this.jdField_a_of_type_Axtm.a().a(this.jdField_a_of_type_Ayho, paramString);
  }
  
  public void uZ(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axoo
 * JD-Core Version:    0.7.0.1
 */