import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class koh
  extends ViewBase
  implements View.OnClickListener
{
  protected JSONObject Q;
  private kte jdField_a_of_type_Kte;
  private lie jdField_a_of_type_Lie;
  private int aKD;
  protected int aKE = -6447715;
  protected FrameLayout ae;
  protected JSONObject ai;
  protected kjt b;
  protected mrm b;
  public NativeAdDownloadView c;
  private AdvertisementInfo e;
  protected Context mContext;
  protected View mRootView;
  private int origin = jzk.aFw;
  public TextView ox;
  
  public koh(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mContext = paramVafContext.getContext();
    a(paramVafContext);
  }
  
  private void F(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    if (this.ai != null)
    {
      int i = this.ai.optInt("iconSize");
      if (i > 0)
      {
        i = wja.dp2px(i, this.mContext.getResources());
        paramDrawable.setBounds(0, 0, i, i);
        return;
      }
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
  }
  
  private void a(VafContext paramVafContext)
  {
    this.mRootView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131560232, null);
    this.ae = ((FrameLayout)this.mRootView.findViewById(2131370959));
    this.ae.setVisibility(8);
    this.ox = ((TextView)this.mRootView.findViewById(2131362826));
    this.ox.setVisibility(8);
    this.ox.setOnClickListener(this);
    this.c = ((NativeAdDownloadView)this.mRootView.findViewById(2131381902));
    this.c.setVisibility(8);
    this.c.setOnClickListener(this);
    this.mRootView.setOnClickListener(this);
  }
  
  private void aFf()
  {
    if (zA())
    {
      this.ox.setClickable(false);
      this.mRootView.setClickable(false);
    }
    for (;;)
    {
      this.c.setClickable(false);
      this.ox.setVisibility(0);
      this.c.setVisibility(8);
      return;
      this.ox.setClickable(true);
      this.mRootView.setClickable(true);
    }
  }
  
  private void aFg()
  {
    if ((zy()) && (this.jdField_b_of_type_Mrm != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_Mrm.mDownloadUrl)))
    {
      this.ox.setClickable(true);
      this.mRootView.setClickable(true);
      this.c.setClickable(true);
    }
    for (;;)
    {
      this.ox.setVisibility(0);
      this.c.setVisibility(8);
      aDU();
      return;
      this.ox.setClickable(false);
      this.mRootView.setClickable(false);
      this.c.setClickable(false);
    }
  }
  
  private void aFh()
  {
    this.ox.setClickable(true);
    this.mRootView.setClickable(true);
    this.c.setClickable(true);
    this.ox.setVisibility(0);
    this.c.setVisibility(8);
    aDU();
  }
  
  private void aFi()
  {
    String str2 = iy();
    if ((QLog.isColorLevel()) && (TextUtils.isEmpty(str2))) {
      QLog.d("ReadInJoyAdDownloadView", 2, "bindData adDownloadApi null");
    }
    boolean bool = Ad();
    String str1 = "0";
    if (this.Q != null) {
      str1 = this.Q.optString("showProgress", "0");
    }
    if ((!TextUtils.isEmpty(str2)) && (bool) && (zy()) && (str1.equals("1")) && (Ae()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdDownloadView", 2, "bindData apptype adDownloadApi=" + str2);
      }
      this.ox.setClickable(true);
      this.c.setClickable(true);
      this.mRootView.setClickable(true);
      aDU();
      return;
    }
    if (Ab())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdDownloadView", 2, "bindData ams subscribe type.");
      }
      this.ox.setClickable(true);
      this.mRootView.setClickable(true);
      this.c.setClickable(false);
      this.ox.setVisibility(0);
      this.c.setVisibility(8);
      aDU();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdDownloadView", 2, "bindData not apptype");
    }
    this.ox.setClickable(false);
    this.c.setClickable(false);
    this.mRootView.setClickable(false);
    this.ox.setVisibility(0);
    this.c.setVisibility(8);
  }
  
  private void aFn()
  {
    int j;
    int i;
    if ((this.ai != null) && (zy()) && (this.ai.optString("showBunttonLeftIconOrNot").trim().equals("1")))
    {
      j = -15550475;
      i = j;
    }
    try
    {
      if (!TextUtils.isEmpty(this.ai.optString("buttonTextColor"))) {
        i = jzp.l(this.ai.optString("buttonTextColor"), "#12B7F5");
      }
      Object localObject = al();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        F((Drawable)localObject);
        this.ox.setCompoundDrawables((Drawable)localObject, null, null, null);
        i = nr();
        this.ox.setCompoundDrawablePadding(i);
      }
      if (zw())
      {
        this.ox.setVisibility(0);
        this.c.setVisibility(8);
      }
      do
      {
        do
        {
          return;
        } while ((this.jdField_b_of_type_Mrm == null) || (this.jdField_b_of_type_Mrm.advertisementInfo == null));
        localObject = a();
      } while (localObject == null);
      ((jzh)localObject).b(this.jdField_b_of_type_Mrm, this.jdField_b_of_type_Mrm.advertisementInfo.downloadState);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private void aFo()
  {
    if (this.e == null) {
      return;
    }
    ods.h(this.mContext, this.e.mPopFormH5Url, this.e.mAdRl, this.e.mAdTraceId);
  }
  
  private int nr()
  {
    int j = wja.dp2px(4.0F, this.mContext.getResources());
    int i = j;
    if (this.ai != null)
    {
      int k = this.ai.optInt("drawablePadding");
      i = j;
      if (k > 0) {
        i = wja.dp2px(k, this.mContext.getResources());
      }
    }
    return i;
  }
  
  private boolean zw()
  {
    if ((zy()) && (this.jdField_b_of_type_Mrm != null)) {
      try
      {
        String str = this.jdField_b_of_type_Mrm.mPackageName;
        if (!TextUtils.isEmpty(str))
        {
          DownloadInfo localDownloadInfo = arvv.a().f(str);
          if ((jzh.B(this.mContext, str)) && (localDownloadInfo != null) && (localDownloadInfo.getState() == 4))
          {
            aDG();
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  protected boolean Aa()
  {
    return knd.h(this.e);
  }
  
  protected boolean Ab()
  {
    return knd.j(this.e);
  }
  
  protected boolean Ac()
  {
    return (this.jdField_b_of_type_Mrm != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_Mrm.mPackageName)) && (!TextUtils.isEmpty(this.jdField_b_of_type_Mrm.mAppID)) && (!TextUtils.isEmpty(this.jdField_b_of_type_Mrm.mDownloadUrl));
  }
  
  protected boolean Ad()
  {
    return knc.a(this.e);
  }
  
  protected boolean Ae()
  {
    return true;
  }
  
  public jzh a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Kte != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Kte.b() != null) {
        localObject1 = this.jdField_a_of_type_Kte.b();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Lie != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_Lie.b() != null) {
          localObject2 = this.jdField_a_of_type_Lie.b().c();
        }
      }
    }
    return localObject2;
  }
  
  public void a(kte paramkte)
  {
    this.jdField_a_of_type_Kte = paramkte;
  }
  
  public void a(boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    if ((paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(ix())))
    {
      this.ox.setText("");
      this.ox.setTextColor(this.aKE);
      this.ox.setClickable(false);
      this.mRootView.setClickable(false);
    }
  }
  
  protected void aDE()
  {
    if (this.jdField_b_of_type_Mrm != null)
    {
      jzh localjzh = a();
      if (localjzh != null) {
        localjzh.c(this.jdField_b_of_type_Mrm);
      }
    }
  }
  
  protected void aDF()
  {
    if (this.jdField_b_of_type_Mrm != null)
    {
      jzh localjzh = a();
      if (localjzh != null) {
        localjzh.f(this.jdField_b_of_type_Mrm);
      }
    }
  }
  
  protected void aDG()
  {
    if (this.e == null) {
      return;
    }
    this.e.downloadState = 5;
    this.e.progress = 100;
  }
  
  protected void aDH()
  {
    if (this.jdField_b_of_type_Kjt != null) {
      this.jdField_b_of_type_Kjt.aDH();
    }
    do
    {
      do
      {
        return;
      } while ((!zy()) || (this.jdField_b_of_type_Mrm == null));
      if ((this.jdField_b_of_type_Mrm.anA) && (!TextUtils.isEmpty(this.jdField_b_of_type_Mrm.mPackageName)))
      {
        knd.D(this.mContext, this.jdField_b_of_type_Mrm.mPackageName);
        return;
      }
    } while (this.e == null);
    ods.b(this.mContext, this.e, null, (int)this.e.mChannelID, true);
  }
  
  public void aDI()
  {
    if ((this.jdField_b_of_type_Mrm == null) || (this.e == null)) {
      return;
    }
    if (jzg.a(this.jdField_b_of_type_Mrm, getDownloadState()))
    {
      aDF();
      this.e.downloadState = 5;
      jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(this.origin).a(this.e).a());
      return;
    }
    doDownload();
    jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFL).a(this.e).a());
  }
  
  protected void aDU()
  {
    if ((this.e != null) && (!this.e.mShowAdButton)) {
      return;
    }
    try
    {
      aFp();
      if (this.jdField_b_of_type_Mrm != null)
      {
        bool1 = aqiz.isAppInstalled(BaseApplicationImpl.getContext(), this.jdField_b_of_type_Mrm.mPackageName);
        boolean bool2 = zw();
        if ((bool1) || (bool2) || ((getDownloadState() != 4) && (getDownloadState() != 3)) || (getProgress() < 0) || (getProgress() >= 100)) {
          break label137;
        }
        this.ox.setVisibility(8);
        this.c.setVisibility(0);
        this.c.ck(getDownloadState(), getProgress());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        boolean bool1 = false;
      }
      label137:
      this.ox.setVisibility(0);
      this.c.setVisibility(8);
    }
  }
  
  protected void aEq()
  {
    for (;;)
    {
      float f2;
      float f3;
      float f4;
      try
      {
        Drawable localDrawable = al();
        int i4 = -12541697;
        int i6 = nr();
        f1 = 14.0F;
        int i3 = 0;
        int i2 = 0;
        i1 = 0;
        n = 0;
        String str1 = in();
        kvl.setBackground(this.ox, null);
        f2 = f1;
        if (this.ai != null)
        {
          if (TextUtils.isEmpty(this.ai.optString("buttonTextColor"))) {
            break label1059;
          }
          n = jzp.l(this.ai.optString("buttonTextColor"), "#40A0FF");
          if (!TextUtils.isEmpty(this.ai.optString("buttonTextSize")))
          {
            f1 = jzp.o(this.ai.optString("buttonTextSize"), 14);
            f2 = f1;
            if (f1 >= 10.0F) {
              break label1067;
            }
            f2 = 10.0F;
            break label1067;
          }
          localObject2 = this.ai.optString("buttonBorderColor");
          Object localObject1 = this.ai.optString("buttonBorderSize");
          String str2 = this.ai.optString("buttonBackgroundColor");
          String str3 = this.ai.optString("buttonCornerSize");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)))
          {
            GradientDrawable localGradientDrawable = new GradientDrawable();
            if (!TextUtils.isEmpty(str2)) {
              localGradientDrawable.setColor(jzp.l(str2, "#40A0FF"));
            }
            if (jzp.b((String)localObject1, 0.0F) > 0.0F)
            {
              f3 = jzp.b((String)localObject1, 0.0F);
              f2 = f3;
              if (f3 > 2.0F) {
                f2 = 2.0F;
              }
              localGradientDrawable.setStroke(wja.dp2px(f2, this.mContext.getResources()), jzp.l((String)localObject2, "#40A0FF"));
            }
            if (!TextUtils.isEmpty(str3))
            {
              f3 = jzp.b(str3, 0.0F);
              if (f3 >= 0.0F) {
                break label1096;
              }
              f2 = 0.0F;
              localGradientDrawable.setCornerRadius(wja.dp2px(f2, this.mContext.getResources()));
            }
            kvl.setBackground(this.ox, localGradientDrawable);
          }
          if ((!"1".equals(this.ai.optString("buttonTextBold"))) || (localDrawable != null))
          {
            F(localDrawable);
            localDrawable.setColorFilter(n, PorterDuff.Mode.SRC_ATOP);
          }
          f3 = jzp.b(this.ai.optString("buttonHorizontalPadding").trim(), 0.0F);
          f4 = jzp.b(this.ai.optString("buttonVerticalPadding").trim(), 0.0F);
          if (f3 >= 0.0F) {
            break label1113;
          }
          f2 = 0.0F;
          break label1084;
          label436:
          if (f2 <= 0.0F) {
            break label1050;
          }
          j = wja.dp2px(f2, this.mContext.getResources());
          i = j;
          if (f3 <= 0.0F) {
            break label1041;
          }
          m = wja.dp2px(f3, this.mContext.getResources());
          k = m;
          localObject2 = this.ai.optString("buttonAlignment");
          if (!"3".equals(localObject2)) {
            continue;
          }
          localObject2 = (FrameLayout.LayoutParams)this.ox.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).gravity = 21;
          this.ox.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).gravity = 21;
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          int i5 = cY(n);
          f2 = jzp.b(this.ai.optString("buttonWidth").trim(), 0.0F);
          f3 = jzp.b(this.ai.optString("buttonHeight").trim(), 0.0F);
          if ((f2 <= 0.0F) || (f3 <= 0.0F)) {
            break label1014;
          }
          localObject2 = (FrameLayout.LayoutParams)this.ox.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).height = wja.dp2px(f3, this.mContext.getResources());
          ((FrameLayout.LayoutParams)localObject2).width = wja.dp2px(f2, this.mContext.getResources());
          this.ox.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.ox.setGravity(17);
          m = 0;
          k = 0;
          j = 0;
          i = 0;
          f4 = jzp.b(this.ai.optString("width").trim(), 0.0F);
          n = i;
          i1 = j;
          i2 = k;
          i3 = m;
          f2 = f1;
          i4 = i5;
          if (f4 > 0.0F)
          {
            f2 = 0.0F;
            if (jzp.b((String)localObject1, 0.0F) <= 0.0F) {
              break label1011;
            }
            f3 = jzp.b((String)localObject1, 0.0F);
            f2 = f3;
            if (f3 <= 2.0F) {
              break label1011;
            }
            f2 = 2.0F;
            localObject2 = getComLayoutParams();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Layout.Params();
            }
            ((Layout.Params)localObject1).mLayoutWidth = wja.dp2px(f2 * 2.0F + f4, this.mContext.getResources());
            setComLayoutParams((Layout.Params)localObject1);
            i4 = i5;
            f2 = f1;
            i3 = m;
            i2 = k;
            i1 = j;
            n = i;
          }
        }
        this.ox.setText(str1);
        this.ox.setCompoundDrawables(localDrawable, null, null, null);
        this.ox.setCompoundDrawablePadding(i6);
        this.ox.setTextColor(i4);
        this.ox.setTextSize(f2);
        this.ox.setPadding(i3, i1, i2, n);
        this.ox.setVisibility(0);
        this.ae.setVisibility(0);
        return;
        if (!"1".equals(localObject2)) {
          continue;
        }
        Object localObject2 = (FrameLayout.LayoutParams)this.ox.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).gravity = 19;
        this.ox.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).gravity = 19;
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        continue;
        continue;
      }
      catch (Exception localException)
      {
        this.ox.setVisibility(8);
        this.ae.setVisibility(8);
        return;
      }
      label1011:
      label1014:
      int n = j;
      int i1 = i;
      int i = m;
      int j = k;
      int k = n;
      int m = i1;
      continue;
      label1041:
      k = 0;
      m = 0;
      continue;
      label1050:
      i = 0;
      j = 0;
      continue;
      label1059:
      n = -12541697;
      continue;
      label1067:
      float f1 = f2;
      if (f2 > 16.0F)
      {
        f1 = 16.0F;
        continue;
        for (;;)
        {
          label1084:
          if (f4 >= 0.0F) {
            break label1130;
          }
          f3 = 0.0F;
          break label436;
          label1096:
          f2 = f3;
          if (f3 <= 20.0F) {
            break;
          }
          f2 = 20.0F;
          break;
          label1113:
          f2 = f3;
          if (f3 > 12.0F) {
            f2 = 12.0F;
          }
        }
        label1130:
        f3 = f4;
        if (f4 > 12.0F) {
          f3 = 12.0F;
        }
      }
    }
  }
  
  protected void aFe()
  {
    this.ox.setClickable(true);
    this.mRootView.setClickable(true);
    this.c.setClickable(false);
    this.ox.setVisibility(0);
    this.mRootView.setVisibility(0);
  }
  
  public void aFj()
  {
    if (this.ox != null) {
      this.ox.setClickable(false);
    }
  }
  
  protected void aFk()
  {
    aEq();
  }
  
  public void aFl()
  {
    if ((this.e != null) && (this.e.isCommentAd())) {
      this.e.clickPos = 8;
    }
  }
  
  protected void aFm()
  {
    if ((this.ox.getVisibility() == 0) && (this.ox.isClickable())) {
      onClick(this.ox);
    }
    do
    {
      return;
      if ((this.c.getVisibility() == 0) && (this.c.isClickable()))
      {
        onClick(this.c);
        return;
      }
    } while (!(this.mContext instanceof Activity));
    kks localkks = new kks();
    localkks.afZ = true;
    ods.a((Activity)this.mContext, this.e, this.jdField_a_of_type_Lie.b(), (int)this.e.mChannelID, true, localkks);
  }
  
  protected void aFp()
  {
    if (this.e == null) {
      return;
    }
    this.e.mProgressFromFeeds = true;
  }
  
  protected Drawable al()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Drawable localDrawable;
    if (this.ai != null)
    {
      localObject1 = localObject2;
      if (this.ai.optString("showBunttonLeftIconOrNot").trim().equals("1"))
      {
        localDrawable = this.mContext.getResources().getDrawable(2130843557);
        if ((this.jdField_b_of_type_Mrm == null) || (!aqiz.isAppInstalled(this.mContext, this.jdField_b_of_type_Mrm.mPackageName))) {
          break label87;
        }
        localObject1 = this.mContext.getResources().getDrawable(2130843557);
      }
    }
    label87:
    do
    {
      return localObject1;
      if (Ac()) {
        return this.mContext.getResources().getDrawable(2130843555);
      }
      if ((Aa()) || (Ab())) {
        return this.mContext.getResources().getDrawable(2130843558);
      }
      localObject1 = localObject2;
    } while (zA());
    return localDrawable;
  }
  
  protected void c(AdData paramAdData)
  {
    this.c.setVisibility(8);
    aFk();
    if (((paramAdData != null) && (knk.n(paramAdData))) || (knk.w(this.e))) {
      aFe();
    }
    int i;
    do
    {
      return;
      i = ns();
    } while (zZ());
    if (i == 1)
    {
      aFf();
      return;
    }
    if (i == 2)
    {
      aFg();
      return;
    }
    if (Ac())
    {
      aFh();
      return;
    }
    aFi();
  }
  
  protected int cY(int paramInt)
  {
    if (zA()) {
      paramInt = this.aKE;
    }
    return paramInt;
  }
  
  public void ck(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
      return;
    case 3: 
      this.c.ck(paramInt1, paramInt2);
      this.ox.setVisibility(8);
      this.c.setVisibility(0);
      return;
    case 5: 
      this.ox.setVisibility(0);
      this.c.ck(paramInt1, paramInt2);
      this.c.setVisibility(8);
      ph(paramInt1);
      return;
    case 1: 
      this.ox.setVisibility(0);
      this.c.ck(paramInt1, paramInt2);
      this.c.setVisibility(8);
      return;
    case 4: 
      this.ox.setVisibility(8);
      this.c.setVisibility(0);
      this.c.ck(paramInt1, paramInt2);
      return;
    case 6: 
      this.ox.setVisibility(0);
      this.c.setVisibility(8);
      return;
    }
    aDI();
  }
  
  protected void doDownload()
  {
    if (this.jdField_b_of_type_Mrm != null)
    {
      jzh localjzh = a();
      if (localjzh != null) {
        localjzh.a(this.jdField_b_of_type_Mrm);
      }
      if (this.c != null)
      {
        if ((this.e == null) || (this.e.downloadState != 4)) {
          break label65;
        }
        this.c.setProgress(this.e.progress);
      }
    }
    return;
    label65:
    this.c.setProgress(0);
  }
  
  protected void doPause()
  {
    if (this.jdField_b_of_type_Mrm != null)
    {
      jzh localjzh = a();
      if (localjzh != null) {
        localjzh.d(this.jdField_b_of_type_Mrm);
      }
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.mRootView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mRootView.getMeasuredWidth();
  }
  
  protected int getDownloadState()
  {
    if (this.e == null) {
      return 0;
    }
    return this.e.downloadState;
  }
  
  public View getNativeView()
  {
    return this.mRootView;
  }
  
  protected int getProgress()
  {
    if (this.e == null) {
      return 0;
    }
    return this.e.progress;
  }
  
  protected String in()
  {
    return knd.b(this.e);
  }
  
  protected String ix()
  {
    return knd.c(this.e);
  }
  
  protected String iy()
  {
    if (this.e == null) {
      return "";
    }
    return this.e.mAdDownloadApiUrl;
  }
  
  public void ma()
  {
    if (this.e != null)
    {
      String str = knd.b(this.e);
      if (zy()) {
        aFn();
      }
      if (!TextUtils.isEmpty(str)) {
        this.ox.setText(str);
      }
    }
  }
  
  protected int ns()
  {
    return knd.f(this.e);
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    int i = 1;
    if (this.e == null) {}
    label105:
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.mRootView)
      {
        aFm();
      }
      else
      {
        aFl();
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131362826: 
          try
          {
            if (!knk.w(this.e)) {
              break label105;
            }
            knk.a(this.mContext, this.e);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
          continue;
          j = knd.f(this.e);
          if (j != 1) {
            if (Ab())
            {
              aFo();
              aFl();
              jzk.a(new kku.a().a(this.mContext).a(jzk.aFu).b(this.origin).a(this.e).a());
            }
            else if (this.jdField_b_of_type_Mrm != null)
            {
              this.e.mProgressFromFeeds = true;
              localObject = this.jdField_b_of_type_Mrm.mPackageName;
              if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject))
              {
                aDH();
                aFl();
                this.e.downloadState = 1;
                jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFC).a(this.e).a());
              }
              else if (jzh.a(this.mContext, this.jdField_b_of_type_Mrm))
              {
                localObject = arvv.a().f(this.jdField_b_of_type_Mrm.mPackageName);
                arvv.a().d((DownloadInfo)localObject);
                this.e.downloadState = 5;
                jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFI).a(this.e).a());
              }
              else
              {
                if (!jzg.a(this.jdField_b_of_type_Mrm, this.e.downloadState)) {
                  break label429;
                }
                aDF();
                this.e.downloadState = 5;
                jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(this.origin).a(this.e).a());
              }
            }
          }
          break;
        }
      }
    }
    label429:
    if ((aqiw.isMobileNetWork(this.mContext)) && (knc.dv(this.e.mAdExtInfo))) {}
    for (;;)
    {
      for (;;)
      {
        if ((tll.isWifiConnected()) || (i != 0))
        {
          if (j == 2)
          {
            aDE();
            break;
          }
          doDownload();
          jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(jzk.aFI).a(this.e).a());
          break;
        }
        if (!(this.mContext instanceof Activity)) {
          break;
        }
        ods.a((Activity)this.mContext, this.e, this.jdField_a_of_type_Lie.b(), (int)this.e.mChannelID, true, null);
        jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(this.origin).a(this.e).a());
        break;
        try
        {
          this.e.mProgressFromFeeds = true;
          if (this.jdField_b_of_type_Mrm == null) {
            break;
          }
          localObject = this.jdField_b_of_type_Mrm.mPackageName;
          i = knd.f(this.e);
          if (!aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject)) {
            break label731;
          }
          aDH();
          this.e.downloadState = 1;
          jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(this.origin).a(this.e).a());
          this.ox.setVisibility(0);
          this.c.setVisibility(8);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      break;
      label731:
      if (jzh.a(this.mContext, this.jdField_b_of_type_Mrm))
      {
        DownloadInfo localDownloadInfo = arvv.a().f(this.jdField_b_of_type_Mrm.mPackageName);
        arvv.a().d(localDownloadInfo);
        this.e.downloadState = 5;
        jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(this.origin).a(this.e).a());
        this.ox.setVisibility(0);
        this.c.setVisibility(8);
        break;
      }
      if ((i == 2) && (jzg.a(this.jdField_b_of_type_Mrm, this.e.downloadState)))
      {
        aDF();
        this.e.downloadState = 5;
        jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(this.origin).a(this.e).a());
        this.ox.setVisibility(0);
        this.c.setVisibility(8);
        break;
      }
      i = j;
      if (aqiw.isMobileNetWork(this.mContext))
      {
        i = j;
        if (knc.dv(this.e.mAdExtInfo)) {
          i = 1;
        }
      }
      if ((tll.isWifiConnected()) || (i != 0)) {
        if (this.e.downloadState == 3) {
          doPause();
        }
      }
      for (;;)
      {
        jzk.a(new kku.a().a(this.mContext).a(jzk.aEJ).b(this.origin).a(this.e).a());
        break;
        if ((this.e.downloadState == 4) || (this.e.downloadState == 0))
        {
          doDownload();
          continue;
          if ((this.mContext instanceof Activity)) {
            ods.a((Activity)this.mContext, this.e, this.jdField_a_of_type_Lie.b(), (int)this.e.mChannelID, true, null);
          }
        }
      }
      i = 0;
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRootView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mRootView.measure(paramInt1, paramInt2);
  }
  
  protected void ph(int paramInt) {}
  
  public void pq(int paramInt)
  {
    this.aKD = paramInt;
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
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
              for (;;)
              {
                return bool1;
                bool1 = bool2;
                if (paramObject != null)
                {
                  bool1 = bool2;
                  try
                  {
                    if ((paramObject instanceof AdvertisementInfo))
                    {
                      this.e = ((AdvertisementInfo)paramObject);
                      if ((this.e != null) && (this.e.isCommentAd()))
                      {
                        if (this.ox != null) {
                          this.ox.setTypeface(Typeface.DEFAULT);
                        }
                        this.origin = jzk.aFZ;
                        c(null);
                      }
                      if ((this.e != null) && (!this.e.mShowAdButton) && (this.mRootView != null))
                      {
                        this.mRootView.setVisibility(8);
                        return true;
                      }
                    }
                  }
                  catch (Exception paramObject)
                  {
                    this.e = null;
                    QLog.d("ReadInJoyAdDownloadView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
                    return true;
                  }
                }
              }
              this.jdField_b_of_type_Mrm = mrm.a(this.e);
              return true;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (!(paramObject instanceof JSONObject));
          this.Q = ((JSONObject)paramObject);
          bool1 = bool2;
        } while (this.c == null);
        this.c.setProgressStyle(this.Q);
        return true;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof JSONObject));
    this.ai = ((JSONObject)paramObject);
    return true;
  }
  
  public void setModel(lie paramlie, boolean paramBoolean)
  {
    this.jdField_a_of_type_Lie = paramlie;
    if ((paramBoolean) && (this.e != null) && (this.e.mShowAdButton)) {
      c(null);
    }
  }
  
  protected boolean zA()
  {
    return knd.g(this.e);
  }
  
  protected boolean zZ()
  {
    return false;
  }
  
  protected boolean zy()
  {
    if (this.e == null) {
      return false;
    }
    return AdvertisementInfo.isAppAdvertisementInfo(this.e);
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new koh(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     koh
 * JD-Core Version:    0.7.0.1
 */