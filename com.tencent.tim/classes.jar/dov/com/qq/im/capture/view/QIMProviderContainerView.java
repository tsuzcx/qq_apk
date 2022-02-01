package dov.com.qq.im.capture.view;

import acfp;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import axoo;
import axov;
import axpr;
import axwc;
import axwg;
import axxk;
import axxl;
import axxm;
import axxn;
import axxo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.a;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import rpq;

public class QIMProviderContainerView
  extends FrameLayout
{
  private ArrayList<View> FC = new ArrayList();
  private float Fr;
  View Gp;
  View Gq;
  private View Gr;
  public View MU;
  private List<a> Ns = new ArrayList();
  private axoo jdField_a_of_type_Axoo;
  private axwg jdField_a_of_type_Axwg;
  private b jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView$b;
  private boolean aUU;
  private ProviderView b;
  FrameLayout bw;
  private boolean dtL;
  private boolean dxd;
  private boolean dxe = true;
  boolean dxf = false;
  public boolean dxg;
  public boolean dxh;
  private boolean dxi;
  private boolean dxj;
  public int eIC;
  View.OnClickListener fG = new axxk(this);
  private HashMap<Integer, ProviderView> jx = new HashMap();
  public LinearLayout kg;
  private List<ProviderContainerView.a> mListeners;
  private RelativeLayout oc;
  
  public QIMProviderContainerView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private void OG(boolean paramBoolean)
  {
    this.dtL = false;
    int i = rpq.dip2px(getContext(), 88.0F);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, i }));
    ((List)localObject1).add(ObjectAnimator.ofFloat(this.kg, "alpha", new float[] { 1.0F, 0.0F }));
    ((List)localObject1).add(axwc.a(this.Gp, getResources().getColor(2131165625), 153, 0));
    ((List)localObject1).add(axwc.a(this.Gq, getResources().getColor(2131165625), 153, 0));
    Object localObject2 = this.jdField_a_of_type_Axoo.mRootView.findViewById(2131381661);
    if (localObject2 != null) {
      ((List)localObject1).add(ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { 0.0F, i }));
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).addListener(new axxn(this));
    ((AnimatorSet)localObject2).setDuration(300L).start();
    localObject1 = axwc.a(this.b, 1.0F, 0.0F);
    ((Animation)localObject1).setStartOffset(0L);
    ((Animation)localObject1).setDuration(100L);
    ((Animation)localObject1).setAnimationListener(new axxo(this, paramBoolean));
    startAnimation((Animation)localObject1);
  }
  
  private void TY(int paramInt)
  {
    this.dtL = true;
    bN(paramInt, true);
    paramInt = rpq.dip2px(getContext(), 88.0F);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }));
    ((List)localObject1).add(ObjectAnimator.ofFloat(this.kg, "alpha", new float[] { 0.0F, 1.0F }));
    ((List)localObject1).add(axwc.a(this.Gp, getResources().getColor(2131165625), 0, 153));
    ((List)localObject1).add(axwc.a(this.Gq, getResources().getColor(2131165625), 0, 153));
    Object localObject2 = this.jdField_a_of_type_Axoo.mRootView.findViewById(2131381661);
    if (localObject2 != null) {
      ((List)localObject1).add(ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { paramInt, 0.0F }));
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).addListener(new axxl(this));
    ((AnimatorSet)localObject2).setDuration(300L).start();
    localObject1 = axwc.a(this.b, 0.0F, 1.0F);
    ((Animation)localObject1).setStartOffset(200L);
    ((Animation)localObject1).setDuration(100L);
    ((Animation)localObject1).setAnimationListener(new axxm(this));
    startAnimation((Animation)localObject1);
  }
  
  private void bN(int paramInt, boolean paramBoolean)
  {
    if (this.b != null)
    {
      this.b.dLs();
      this.b.setAlpha(1.0F);
      this.b.setVisibility(8);
      this.b = null;
    }
    Object localObject;
    if (this.jx.containsKey(Integer.valueOf(this.jdField_a_of_type_Axwg.iQ(paramInt))))
    {
      localObject = (ProviderView)this.jx.get(Integer.valueOf(this.jdField_a_of_type_Axwg.iQ(paramInt)));
      if (localObject == null) {
        break label316;
      }
      if (!((ProviderView)localObject).mInited)
      {
        ((ProviderView)localObject).setProviderViewListener(this.jdField_a_of_type_Axoo);
        ((ProviderView)localObject).setDoodleEventListener(this.jdField_a_of_type_Axoo);
        ((ProviderView)localObject).onCreate(null);
      }
      this.b = ((ProviderView)localObject);
      if (paramBoolean) {
        break label317;
      }
      this.b.setAlpha(1.0F);
      this.b.setVisibility(0);
    }
    for (;;)
    {
      if (this.b.getId() != 2131364259) {
        this.jdField_a_of_type_Axoo.YI(false);
      }
      localObject = this.Ns.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        if (locala != null) {
          locala.Zd(false);
        }
      }
      int i = this.jdField_a_of_type_Axwg.iQ(paramInt);
      localObject = this.jdField_a_of_type_Axwg.a(getContext(), i);
      if (localObject != null)
      {
        ((ProviderView)localObject).setLiuHaiParentView(this.oc);
        this.jx.put(Integer.valueOf(this.jdField_a_of_type_Axwg.iQ(paramInt)), localObject);
        this.bw.addView((View)localObject);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ProviderContainerView", 2, "build provider view failed " + paramInt);
      label316:
      return;
      label317:
      this.b.setAlpha(1.0F);
      this.b.setVisibility(8);
    }
    this.b.dKI();
    this.b.busType = this.jdField_a_of_type_Axoo.busType;
  }
  
  private void ePj()
  {
    ThreadManager.excute(new QIMProviderContainerView.7(this), 64, null, true);
  }
  
  private void g(ImageView paramImageView, int paramInt)
  {
    paramInt = this.jdField_a_of_type_Axwg.iQ(paramInt);
    if (paramInt == 101) {
      paramImageView.setContentDescription(acfp.m(2131711227));
    }
    do
    {
      return;
      if (paramInt == 102)
      {
        paramImageView.setContentDescription(acfp.m(2131711233));
        return;
      }
      if (paramInt == 103)
      {
        paramImageView.setContentDescription(acfp.m(2131711231));
        return;
      }
      if (paramInt == 108)
      {
        paramImageView.setContentDescription(acfp.m(2131711229));
        return;
      }
      if (paramInt == 104)
      {
        paramImageView.setContentDescription(acfp.m(2131711230));
        return;
      }
    } while (paramInt != 105);
    paramImageView.setContentDescription(acfp.m(2131711232));
  }
  
  private void initUI()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131561123, null);
    addView(localView);
    this.kg = ((LinearLayout)localView.findViewById(2131368712));
    this.kg.setGravity(0);
    this.bw = ((FrameLayout)localView.findViewById(2131373724));
    this.Gp = localView.findViewById(2131366700);
    this.Gq = localView.findViewById(2131366699);
    this.MU = localView.findViewById(2131381459);
    this.jdField_a_of_type_Axwg = new axwg(0);
    this.FC.add(this.kg);
    this.FC.add(this.Gp);
    this.FC.add(this.Gq);
    this.FC.add(this.MU);
  }
  
  public Bundle D()
  {
    Bundle localBundle1 = new Bundle();
    Iterator localIterator = this.jx.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      Bundle localBundle2 = localProviderView.D();
      if (localBundle2 != null) {
        localBundle1.putBundle(localProviderView.getClass().getSimpleName(), localBundle2);
      }
    }
    return localBundle1;
  }
  
  public void OF(boolean paramBoolean)
  {
    if (this.Gr != null)
    {
      this.Gr.setSelected(false);
      this.Gr = null;
      this.dxd = false;
    }
    if (this.b != null)
    {
      this.b.dLs();
      this.b.setVisibility(8);
      this.b = null;
    }
    if (this.dtL) {
      OG(paramBoolean);
    }
    this.dxi = false;
    if (this.mListeners != null)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        ProviderContainerView.a locala = (ProviderContainerView.a)localIterator.next();
        if ((this.oc != null) && ((locala instanceof a)))
        {
          if (!this.dxj) {
            locala.dKp();
          }
        }
        else {
          locala.dKp();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "panelOpened : " + this.dxi);
    }
  }
  
  public void S(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByCategoryId");
    }
    Intent localIntent = ((Activity)getContext()).getIntent();
    f(this.jdField_a_of_type_Axwg.iR(paramInt1), paramInt2, paramString, true);
    localIntent.removeExtra("qim_camera_open_specific");
  }
  
  public void T(int paramInt1, int paramInt2, String paramString)
  {
    f(paramInt1, paramInt2, paramString, true);
  }
  
  public void Zc(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.kg == null) || (this.dxf == paramBoolean)) {}
    Object localObject3;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    do
    {
      return;
      this.dxf = paramBoolean;
      if ((this.Fr == 0.0F) && (this.kg.getChildCount() > 1)) {
        this.Fr = (this.kg.getChildAt(1).getX() - this.kg.getChildAt(0).getX());
      }
      localObject3 = this.kg.findViewById(2131374657);
      localObject1 = this.kg.findViewById(2131374659);
      localObject2 = this.kg.findViewById(2131374658);
      localObject4 = this.kg.findViewById(2131374662);
      if (!paramBoolean) {
        break;
      }
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (localObject4 != null)
      {
        localObject1 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).weight = 3.0F;
        ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = (MusicProviderView)this.jx.get(Integer.valueOf(104));
    } while (localObject1 == null);
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((MusicProviderView)localObject1).setChangeMusicEnabled(paramBoolean);
      return;
      if ((localObject3 == null) || (localObject1 == null) || (localObject2 == null) || (localObject4 == null) || (this.dxg) || (this.dxh)) {
        break;
      }
      ((View)localObject3).setVisibility(0);
      ((View)localObject1).setVisibility(0);
      Object localObject5 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((View)localObject2).setTranslationX(-this.Fr);
      ((View)localObject4).setTranslationX(-this.Fr);
      ((View)localObject3).setAlpha(0.0F);
      ((View)localObject1).setAlpha(0.0F);
      localObject2 = ObjectAnimator.ofFloat(localObject2, "translationX", new float[] { -this.Fr, 0.0F });
      localObject4 = ObjectAnimator.ofFloat(localObject4, "translationX", new float[] { -this.Fr, 0.0F });
      localObject3 = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 0.0F, 1.0F });
      localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F });
      localObject5 = new AnimatorSet();
      ((AnimatorSet)localObject5).playTogether(new Animator[] { localObject3, localObject2, localObject1, localObject4 });
      ((AnimatorSet)localObject5).setDuration(400L).start();
      break;
    }
  }
  
  public ProviderView a()
  {
    return this.b;
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!this.aUU) {
      if (QLog.isColorLevel()) {
        QLog.e("ProviderContainerView", 2, "doOpenProviderView failed isInflated" + this.aUU);
      }
    }
    do
    {
      return;
      if ((paramInt1 >= 0) && (paramInt1 < this.kg.getChildCount())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ProviderContainerView", 2, "doOpenProviderView failed out bounds" + paramInt1 + " size:" + this.kg.getChildCount());
    return;
    if (this.Gr != null)
    {
      this.Gr.setSelected(false);
      this.dxd = true;
    }
    this.Gr = this.kg.getChildAt(paramInt1);
    this.Gr.setSelected(true);
    this.eIC = paramInt1;
    ((ImageView)this.Gr).setImageResource(this.jdField_a_of_type_Axwg.lR(paramInt1));
    if (!this.dxd) {
      TY(paramInt1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Axoo != null) {
        this.jdField_a_of_type_Axoo.cx(paramInt1, paramBoolean);
      }
      this.jdField_a_of_type_Axwg.TK(paramInt1);
      if (!paramBoolean) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "openSpecificTabByWeb tab_index= " + paramInt1 + ",categoryId=" + paramInt2 + ",categoryName=" + paramString1 + "itemId=" + paramString2);
      }
      this.b.aq(paramInt2, paramString1, paramString2);
      return;
      bN(paramInt1, false);
    }
  }
  
  public void a(RedDotImageView paramRedDotImageView)
  {
    ThreadManager.excute(new QIMProviderContainerView.6(this, paramRedDotImageView), 64, null, true);
  }
  
  public boolean aPV()
  {
    return !this.dxi;
  }
  
  public void aeS(int paramInt)
  {
    int i = this.jdField_a_of_type_Axwg.iR(paramInt);
    ProviderView localProviderView = this.jdField_a_of_type_Axwg.a(getContext(), paramInt);
    if (localProviderView != null)
    {
      localProviderView.setLiuHaiParentView(this.oc);
      this.jx.put(Integer.valueOf(this.jdField_a_of_type_Axwg.iQ(i)), localProviderView);
      localProviderView.ex(null);
      this.bw.addView(localProviderView);
      localProviderView.setProviderViewListener(this.jdField_a_of_type_Axoo);
    }
  }
  
  public void aeT(int paramInt)
  {
    View localView = this.kg.getChildAt(paramInt);
    if ((this.Gr == null) || (this.Gr != localView)) {
      localView.performClick();
    }
  }
  
  public void apk()
  {
    this.dxe = true;
    Iterator localIterator = this.jx.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).apk();
    }
    ((axpr)axov.a(5)).cT((Activity)getContext());
  }
  
  public void as(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByCategoryName");
    }
    if (((Activity)getContext()).getIntent().getIntExtra("entrance_type", 99) == 7) {
      a(this.jdField_a_of_type_Axwg.iR(paramInt), -1, paramString1, paramString2, true);
    }
  }
  
  @TargetApi(11)
  public void ces()
  {
    this.jdField_a_of_type_Axwg.ie();
    this.kg.removeAllViews();
    int i = 0;
    while (i < this.jdField_a_of_type_Axwg.getCount())
    {
      localObject = new PressScaleImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, rpq.dip2px(getContext(), 44.0F));
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      ((ImageView)localObject).setPadding(0, rpq.dip2px(getContext(), 9.0F), 0, rpq.dip2px(getContext(), 9.0F));
      ((ImageView)localObject).setTag(Integer.valueOf(i));
      ((ImageView)localObject).setId(this.jdField_a_of_type_Axwg.lS(i));
      ((ImageView)localObject).setImageResource(this.jdField_a_of_type_Axwg.lR(i));
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)localObject).setOnClickListener(this.fG);
      g((ImageView)localObject, i);
      this.kg.addView((View)localObject, localLayoutParams);
      i += 1;
    }
    Object localObject = this.bw.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = rpq.dip2px(getContext(), 206.0F);
    setTranslationY(rpq.dip2px(getContext(), 88.0F));
    this.bw.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void dLp()
  {
    OF(false);
  }
  
  public void eNq()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByOut");
    }
    Object localObject1 = ((Activity)getContext()).getIntent();
    int i = ((Intent)localObject1).getIntExtra("entrance_type", 99);
    boolean bool = ((Intent)localObject1).getBooleanExtra("qim_camera_open_specific", false);
    String str = ((Intent)localObject1).getStringExtra("video_tag_info");
    if (QLog.isColorLevel()) {
      QLog.i("ProviderContainerView", 2, "openSpecificTabByOut return " + i + ",openSpecific=" + bool + ",musicLabel =" + str);
    }
    if (((i == 8) || (i == 7) || (i == 103) || (i == 15)) && (bool))
    {
      i = ((Intent)localObject1).getIntExtra("firsttab", 0);
      j = ((Intent)localObject1).getIntExtra("secondtab", 0);
      str = ((Intent)localObject1).getStringExtra("itemid");
      f(this.jdField_a_of_type_Axwg.iR(i), j, str, true);
      ((Intent)localObject1).removeExtra("qim_camera_open_specific");
    }
    Object localObject2;
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(str)) {
        try
        {
          localObject2 = new JSONObject(str);
          i = ((JSONObject)localObject2).optInt("music_type", -1);
          j = ((JSONObject)localObject2).optInt("music_id", -2);
          localObject1 = ((JSONObject)localObject2).optString("music_download_url");
          str = ((JSONObject)localObject2).optString("music_title");
          localObject2 = ((JSONObject)localObject2).optString("music_path");
          if ((i != 1) || (j == -2) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str)))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ProviderContainerView", 2, "json no music info musicTpe= " + i);
          }
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProviderContainerView", 2, "musicLabel cannot pasrse jsonObject");
          }
          localJSONException.printStackTrace();
          return;
        }
      }
    }
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mItemId = j;
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mUrl = localJSONException;
    localMusicItemInfo.mMusicName = str;
    localMusicItemInfo.musicStart = 0;
    int j = localMusicItemInfo.musicStart;
    if (this.jdField_a_of_type_Axoo == null) {}
    for (i = 10000;; i = this.jdField_a_of_type_Axoo.getVideoDuration())
    {
      localMusicItemInfo.musicEnd = (i + j);
      localMusicItemInfo.musicDuration = localMusicItemInfo.musicEnd;
      localMusicItemInfo.setPath((String)localObject2);
      ((MusicProviderView)a(MusicProviderView.class)).l(localMusicItemInfo);
      MusicProviderView.dwS = true;
      return;
    }
  }
  
  public void f(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, null, paramString, paramBoolean);
  }
  
  public boolean f(Class<? extends ProviderView> paramClass)
  {
    paramClass = a(paramClass);
    return (this.b != null) && (this.b == paramClass) && (this.b.getVisibility() == 0);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Axwg.getCount();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.jx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.jx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).onResume();
    }
    localIterator = this.Ns.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.Zd(true);
      }
    }
    if ((this.b != null) && (this.b.getVisibility() == 0)) {
      this.b.dKI();
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = this.jx.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).onStop();
    }
  }
  
  public void setBackGroundAlpha(float paramFloat)
  {
    if (this.FC != null)
    {
      Iterator localIterator = this.FC.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if (localView != null) {
          localView.setAlpha(paramFloat);
        }
      }
    }
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axwg != null) {
      this.jdField_a_of_type_Axwg.setBeautyEnable(paramBoolean);
    }
  }
  
  public void setBottomTabParentLH(RelativeLayout paramRelativeLayout)
  {
    this.oc = paramRelativeLayout;
  }
  
  public void setCaptureControllerAndPreloadView(axoo paramaxoo)
  {
    this.jdField_a_of_type_Axoo = paramaxoo;
    this.aUU = true;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "preloadProviderView");
    }
  }
  
  public void setCloseEventTouch(boolean paramBoolean)
  {
    this.dxj = paramBoolean;
  }
  
  public void setComboEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axwg != null) {
      this.jdField_a_of_type_Axwg.setComboEnable(paramBoolean);
    }
  }
  
  public void setContainerViewListener(b paramb)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView$b = paramb;
  }
  
  public void setDpcEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axwg != null) {
      this.jdField_a_of_type_Axwg.setDpcEnable(paramBoolean);
    }
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axwg != null) {
      this.jdField_a_of_type_Axwg.setFaceEffectEnable(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axwg != null) {
      this.jdField_a_of_type_Axwg.setFilterEnable(paramBoolean);
    }
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jx.get(Integer.valueOf(104));
    if (localMusicProviderView != null) {
      localMusicProviderView.setIsGuideMode(paramBoolean);
    }
  }
  
  public void setMusicEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axwg != null) {
      this.jdField_a_of_type_Axwg.setMusicEnable(paramBoolean);
    }
  }
  
  public static abstract interface a
    extends ProviderContainerView.a
  {
    public abstract void Zd(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void eFt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView
 * JD-Core Version:    0.7.0.1
 */