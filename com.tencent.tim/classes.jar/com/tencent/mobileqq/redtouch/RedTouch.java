package com.tencent.mobileqq.redtouch;

import alto;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoop;
import aqdj;
import aqhu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class RedTouch
  extends FrameLayout
{
  protected static int id = 1;
  protected List<BusinessInfoCheckUpdate.RedTypeInfo> DY;
  private ImageView Dc;
  public ImageView Dd;
  protected View Fs;
  public TextView XW;
  public TextView XX;
  private int bHY;
  public String bYg;
  protected Context context;
  protected boolean csu;
  protected boolean czh;
  protected boolean czi;
  protected boolean czj;
  protected boolean czk;
  protected boolean czl;
  public boolean czm;
  public boolean czn;
  boolean czo = true;
  protected BusinessInfoCheckUpdate.RedTypeInfo d;
  protected int dnb;
  protected int dnc;
  protected int dnd;
  protected int dne = 21;
  protected int dnf;
  protected int dng;
  protected int dnh;
  protected int dni;
  protected int dnj;
  protected int dxj;
  protected int dxk;
  protected int dxl;
  protected int dxm;
  protected int dxn = -2;
  protected int dxo = 30;
  protected int gravity;
  protected Handler handler;
  protected int imageRightMargin;
  protected LinearLayout kc;
  protected int leftMargin;
  protected int maxNum;
  protected int redPointId;
  protected int rightMargin;
  protected int topMargin;
  
  public RedTouch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouch(Context paramContext, View paramView)
  {
    super(paramContext);
    this.context = paramContext;
    this.Fs = paramView;
    init();
  }
  
  private void OP(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.Dd.getMeasuredWidth();
    localURLDrawableOptions.mRequestHeight = this.Dd.getMeasuredHeight();
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    QLog.i("RedTouch", 1, "leba show waterMark url = " + paramString + " width = " + localURLDrawableOptions.mRequestWidth + " height = " + localURLDrawableOptions.mRequestHeight);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTargetDensity(getResources().getDisplayMetrics().densityDpi);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    this.Dd.setVisibility(0);
    this.Dd.setImageDrawable(paramString);
  }
  
  private void Tq(int paramInt)
  {
    ImageView localImageView = (ImageView)this.Fs.findViewById(2131381235);
    if (localImageView != null) {
      localImageView.setVisibility(0);
    }
    localImageView = c(paramInt);
    if (localImageView != null)
    {
      if (this.bHY == 10)
      {
        View localView = cp();
        if (localView != null) {
          this.kc.addView(localView);
        }
      }
      paramInt = this.redPointId;
      this.redPointId = (paramInt + 1);
      localImageView.setId(paramInt);
      this.kc.addView(localImageView);
    }
  }
  
  private FrameLayout.LayoutParams a()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.gravity;
    localLayoutParams.leftMargin = this.leftMargin;
    localLayoutParams.rightMargin = this.rightMargin;
    localLayoutParams.topMargin = this.topMargin;
    localLayoutParams.bottomMargin = this.dnj;
    return localLayoutParams;
  }
  
  private FrameLayout a(ImageView paramImageView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(iJ(30), iJ(30));
    localLayoutParams.gravity = 80;
    localLayoutParams.topMargin = iJ(16);
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.context);
    paramImageView.setImageResource(2130851400);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 49;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(c());
    return localFrameLayout;
  }
  
  private void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, JSONObject paramJSONObject, int paramInt)
    throws JSONException
  {
    int i = -1;
    int j = 0;
    if (paramJSONObject.has("cr")) {
      i = dO(paramJSONObject.getString("cr"));
    }
    if (paramJSONObject.has("cn")) {
      j = dO(paramJSONObject.getString("cn"));
    }
    paramJSONObject = b(paramRedTypeInfo.red_content.get(), i, j, paramInt);
    if (paramJSONObject != null)
    {
      if (paramRedTypeInfo.red_type.get() != 4) {
        break label110;
      }
      paramInt = this.dnc;
      this.dnc = (paramInt + 1);
    }
    for (;;)
    {
      paramJSONObject.setId(paramInt);
      this.kc.addView(paramJSONObject);
      return;
      label110:
      paramInt = this.dnd;
      this.dnd = (paramInt + 1);
    }
  }
  
  private boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2)
  {
    if (paramRedTypeInfo1.red_type.get() != paramRedTypeInfo2.red_type.get()) {}
    while ((!paramRedTypeInfo1.red_content.get().equals(paramRedTypeInfo2.red_content.get())) || (!paramRedTypeInfo1.red_desc.get().equals(paramRedTypeInfo2.red_desc.get())) || (paramRedTypeInfo1.red_priority.get() != paramRedTypeInfo2.red_priority.get())) {
      return false;
    }
    return true;
  }
  
  private boolean as(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    if (this.DY.size() == 0) {}
    while (this.DY.size() != paramList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.DY.size()) {
        break label84;
      }
      if (!a((BusinessInfoCheckUpdate.RedTypeInfo)this.DY.get(i), (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i))) {
        break;
      }
      i += 1;
    }
    label84:
    return true;
  }
  
  private FrameLayout.LayoutParams b()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  private FrameLayout b(ImageView paramImageView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    int j = 38;
    int i = 4;
    if (this.czk)
    {
      j = this.dxo + 12;
      i = 6;
    }
    paramImageView.setLayoutParams(new FrameLayout.LayoutParams(iJ(j), iJ(j)));
    paramImageView.setPadding(iJ(i), iJ(i), iJ(i), iJ(i));
    localFrameLayout.addView(paramImageView);
    paramImageView = new ImageView(this.context);
    paramImageView.setImageResource(2130851400);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 53;
    paramImageView.setLayoutParams(localLayoutParams);
    localFrameLayout.addView(paramImageView);
    localFrameLayout.setLayoutParams(c());
    return localFrameLayout;
  }
  
  public static String b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "";
    }
    if ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0)) {
      return "";
    }
    if ((paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null))
    {
      paramAppInfo = paramAppInfo.red_display_info.red_type_info.get().iterator();
      while (paramAppInfo.hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next();
        if ((localRedTypeInfo != null) && ((localRedTypeInfo.red_type.get() == 4) || (localRedTypeInfo.red_type.get() == -100))) {
          return localRedTypeInfo.red_content.get();
        }
      }
    }
    return "";
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, JSONObject paramJSONObject, int paramInt)
    throws JSONException
  {
    int i = 0;
    if (this.czj) {
      dJD();
    }
    if (paramJSONObject.has("av")) {}
    for (int j = paramJSONObject.getInt("av");; j = 0)
    {
      if (paramJSONObject.has("dot")) {}
      for (int k = paramJSONObject.getInt("dot");; k = 0)
      {
        if (paramJSONObject.has("drawable")) {}
        for (int m = paramJSONObject.getInt("drawable");; m = 0)
        {
          if (paramJSONObject.has("st")) {
            i = Integer.valueOf(paramJSONObject.getString("st")).intValue();
          }
          if (paramJSONObject.has("uin")) {
            i = 2;
          }
          if (i == 0)
          {
            paramRedTypeInfo = a(paramRedTypeInfo.red_content.get(), j, k, paramInt, m, "");
            if (paramRedTypeInfo != null)
            {
              paramInt = this.dnb;
              this.dnb = (paramInt + 1);
              paramRedTypeInfo.setId(paramInt);
              this.kc.addView(paramRedTypeInfo);
            }
          }
          do
          {
            do
            {
              do
              {
                return;
                if (i != 1) {
                  break;
                }
                paramRedTypeInfo = i(paramRedTypeInfo.red_content.get());
              } while (paramRedTypeInfo == null);
              this.kc.addView(paramRedTypeInfo);
              return;
            } while (i != 2);
            paramRedTypeInfo = a("", j, k, paramInt, m, paramJSONObject.getString("uin"));
          } while (paramRedTypeInfo == null);
          paramInt = this.dnb;
          this.dnb = (paramInt + 1);
          paramRedTypeInfo.setId(paramInt);
          this.kc.addView(paramRedTypeInfo);
          return;
        }
      }
    }
  }
  
  public static String c(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "";
    }
    if ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0)) {
      return "";
    }
    if ((paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null))
    {
      paramAppInfo = paramAppInfo.red_display_info.red_type_info.get().iterator();
      while (paramAppInfo.hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next();
        if ((localRedTypeInfo != null) && (localRedTypeInfo.red_type.get() == 11)) {
          return localRedTypeInfo.red_content.get();
        }
      }
    }
    return "";
  }
  
  public static boolean c(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0) || (paramAppInfo.red_display_info.get() == null) || (paramAppInfo.red_display_info.red_type_info.get() == null) || (paramAppInfo.red_display_info.red_type_info.get().size() == 0)) {
      return false;
    }
    return true;
  }
  
  private View cp()
  {
    View localView = new View(this.context);
    LinearLayout.LayoutParams localLayoutParams = c();
    localLayoutParams.width = 0;
    localLayoutParams.height = 1;
    localLayoutParams.weight = 1.0F;
    localView.setLayoutParams(localLayoutParams);
    return localView;
  }
  
  private void d(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    int i = 0;
    if (this.czo) {
      this.kc.setVisibility(0);
    }
    JSONObject localJSONObject;
    try
    {
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {}
      for (localJSONObject = new JSONObject();; localJSONObject = new JSONObject(paramRedTypeInfo.red_desc.get()))
      {
        if (localJSONObject.has("bg")) {
          i = dO(localJSONObject.getString("bg"));
        }
        switch (paramRedTypeInfo.red_type.get())
        {
        }
      }
      Tq(i);
    }
    catch (Exception paramRedTypeInfo)
    {
      QLog.e("RedTouch", 1, "addRedTouch ", paramRedTypeInfo);
      return;
    }
    return;
    b(paramRedTypeInfo, localJSONObject, i);
    return;
    a(paramRedTypeInfo, localJSONObject, i);
    return;
    e(paramRedTypeInfo);
    return;
  }
  
  private void dJB()
  {
    this.kc = new LinearLayout(this.context);
    this.kc.setLayoutParams(a());
    this.kc.setOrientation(0);
    this.kc.setId(100);
    this.kc.setVisibility(8);
    addView(this.kc);
  }
  
  private void e(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    paramRedTypeInfo = j(paramRedTypeInfo.red_content.get());
    if (paramRedTypeInfo != null) {
      this.kc.addView(paramRedTypeInfo);
    }
  }
  
  public static void h(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.red_display_info.red_type_info.get() != null))
    {
      paramAppInfo = paramAppInfo.red_display_info.red_type_info.get().iterator();
      while (paramAppInfo.hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next();
        if (localRedTypeInfo.red_type.get() == 3) {
          localRedTypeInfo.red_type.set(0);
        } else if (localRedTypeInfo.red_type.get() == 4) {
          localRedTypeInfo.red_type.set(-100);
        } else if (localRedTypeInfo.red_type.get() == 9) {
          localRedTypeInfo.red_type.set(-1);
        }
      }
    }
  }
  
  private void hA(View paramView)
  {
    paramView.setLayoutParams(b());
    addView(paramView);
  }
  
  private void hz(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup == null) {
      return;
    }
    if ((localViewGroup instanceof RelativeLayout))
    {
      i = id;
      id = i + 1;
      setId(i);
      int k = paramView.getId();
      RelativeLayout localRelativeLayout = (RelativeLayout)localViewGroup;
      i = 0;
      while (i < localRelativeLayout.getChildCount())
      {
        View localView = localRelativeLayout.getChildAt(i);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        int[] arrayOfInt = localLayoutParams.getRules();
        int j = 0;
        while (j < arrayOfInt.length)
        {
          if (arrayOfInt[j] == k) {
            arrayOfInt[j] = getId();
          }
          j += 1;
        }
        localView.setLayoutParams(localLayoutParams);
        i += 1;
      }
    }
    int i = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    setLayoutParams(paramView.getLayoutParams());
    localViewGroup.addView(this, i);
  }
  
  private View i(String paramString)
  {
    Object localObject = getResources().getDrawable(2130840645);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mRequestWidth = iJ(30);
    localURLDrawableOptions.mRequestHeight = iJ(30);
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = new ImageView(this.context);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    LinearLayout.LayoutParams localLayoutParams = c();
    localLayoutParams.width = iJ(30);
    localLayoutParams.height = iJ(30);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    return localObject;
  }
  
  private void init()
  {
    this.gravity = this.dne;
    this.leftMargin = this.dnf;
    this.rightMargin = this.dng;
    this.topMargin = this.dnh;
    this.dnj = this.dni;
    this.maxNum = 99;
    this.DY = new ArrayList();
    this.handler = new Handler(Looper.getMainLooper());
    this.redPointId = 10;
    this.dnb = 20;
    this.dnc = 30;
    this.dnd = 40;
  }
  
  public void Of(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (this.Dc != null)
      {
        this.czm = paramBoolean;
        this.Dc.setVisibility(8);
        return;
      }
      if (!this.czm)
      {
        this.czm = paramBoolean;
        Object localObject2 = (ViewGroup)getParent();
        Object localObject1 = (TextView)((ViewGroup)localObject2).findViewById(2131379576);
        if ((localObject1 != null) && ((localObject2 instanceof LinearLayout)))
        {
          removeView(this.Fs);
          ((ViewGroup)localObject2).removeAllViews();
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.context.getResources().getDimension(2131299280));
          RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
          ((ViewGroup)localObject2).addView(localRelativeLayout, localLayoutParams);
          localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(24.0F, this.context.getResources()), wja.dp2px(24.0F, this.context.getResources()));
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          ((RelativeLayout.LayoutParams)localObject2).addRule(15);
          localRelativeLayout.addView(this.Fs, (ViewGroup.LayoutParams)localObject2);
          localObject2 = new RelativeLayout.LayoutParams(((TextView)localObject1).getLayoutParams());
          ((RelativeLayout.LayoutParams)localObject2).addRule(1, this.Fs.getId());
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(15.0F, this.context.getResources());
          localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.Fs.getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, this.Fs.getId());
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = wja.dp2px(-5.0F, this.context.getResources());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = wja.dp2px(-5.0F, this.context.getResources());
          this.Dc = new ImageView(this.context);
          this.Dc.setImageResource(2130850758);
          localRelativeLayout.addView(this.Dc, (ViewGroup.LayoutParams)localObject1);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("RedTouch", 1, "parseRedBagTouch, ", localException);
    }
  }
  
  protected View a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    URLImageView localURLImageView = new URLImageView(this.context);
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setBackgroundColor(paramInt3);
    if (paramInt4 != 0) {
      localURLImageView.setImageDrawable(getResources().getDrawable(paramInt4));
    }
    while (paramInt2 == 1) {
      if (this.csu)
      {
        return a(localURLImageView);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = null;
          if ((this.context instanceof BaseActivity)) {
            paramString1 = ((BaseActivity)this.context).app;
          }
          if (paramString1 != null)
          {
            paramString1 = aqdj.a(paramString1, 1, 4, paramString2);
            if (paramString1 != null) {
              localURLImageView.setImageDrawable(paramString1);
            } else {
              localURLImageView.setImageBitmap(aqhu.f(true));
            }
          }
          else
          {
            localURLImageView.setImageBitmap(aqhu.f(true));
          }
        }
        else
        {
          a(paramString1, localURLImageView, paramInt1);
        }
      }
      else
      {
        return b(localURLImageView);
      }
    }
    if (paramInt4 != 0)
    {
      localURLImageView.setLayoutParams(c());
      localURLImageView.setPadding(iJ(3), iJ(3), iJ(3), iJ(3));
    }
    for (;;)
    {
      return localURLImageView;
      paramString1 = c();
      paramString1.width = iJ(30);
      paramString1.height = iJ(30);
      localURLImageView.setLayoutParams(paramString1);
    }
  }
  
  public RedTouch a()
  {
    if (!this.czh)
    {
      hz(this.Fs);
      hA(this.Fs);
      dJB();
      this.czh = true;
      return this;
    }
    dJC();
    return this;
  }
  
  public RedTouch a(int paramInt)
  {
    this.gravity = paramInt;
    return this;
  }
  
  public RedTouch a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.leftMargin = iJ(paramInt1);
    this.rightMargin = iJ(paramInt2);
    this.topMargin = iJ(paramInt3);
    this.dnj = iJ(paramInt4);
    return this;
  }
  
  public RedTouch a(boolean paramBoolean)
  {
    this.czi = paramBoolean;
    return this;
  }
  
  public String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = paramString.toCharArray();
    int m = localObject.length;
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      k = paramInt1;
      if (i < m)
      {
        int n = localObject[i];
        k = j + 1;
        if (((65 > n) || (n > 90)) && ((97 > n) || (n > 122))) {
          break label140;
        }
      }
      label140:
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          paramInt1 = paramInt2;
        }
        if (k < paramInt1) {
          break;
        }
        k = paramInt1;
        localObject = paramString;
        if (paramString.length() > k)
        {
          paramString = paramString.substring(0, k);
          localObject = paramString;
          if (paramBoolean) {
            localObject = paramString + "...";
          }
        }
        return localObject;
      }
      i += 1;
    }
  }
  
  protected void a(String paramString, URLImageView paramURLImageView, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      Object localObject = getResources().getDrawable(2130840645);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      int i = 30;
      if (this.czk) {
        i = this.dxo;
      }
      localURLDrawableOptions.mRequestWidth = iJ(i);
      localURLDrawableOptions.mRequestHeight = iJ(i);
      try
      {
        localObject = URLDrawable.getDrawable(new URL("redtouchpicdownloadprotoc", null, paramString), localURLDrawableOptions);
        ((URLDrawable)localObject).setTag(paramString);
        ((URLDrawable)localObject).addHeader("isCircle", String.valueOf(paramInt));
        paramURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("RedTouch", 2, "parse img exception : e = " + paramString);
  }
  
  public boolean auw()
  {
    return ((this.XW != null) && (this.XW.getVisibility() == 0)) || ((this.XX != null) && (this.XX.getVisibility() == 0)) || (aux());
  }
  
  public boolean aux()
  {
    if (this.kc == null) {}
    while (this.kc.getChildCount() == 0) {
      return false;
    }
    return true;
  }
  
  protected TextView b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(this.context);
    try
    {
      if (Integer.parseInt(paramString) > this.maxNum) {
        localTextView.setText(this.maxNum + "+");
      }
      for (;;)
      {
        localTextView.setTextColor(paramInt1);
        localTextView.setGravity(17);
        localTextView.setSingleLine(true);
        if (paramInt2 == 0) {
          break label197;
        }
        localTextView.setTextSize(11.0F);
        if (!this.czl) {
          break;
        }
        localTextView.setIncludeFontPadding(false);
        localTextView.setBackgroundResource(2130851406);
        if (this.bHY == 10) {
          localTextView.setTextSize(1, 17.0F);
        }
        localTextView.setLayoutParams(c());
        if (this.czi)
        {
          localTextView.measure(0, 0);
          this.leftMargin = (localTextView.getMeasuredWidth() / 2);
          dJC();
        }
        return localTextView;
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localTextView.setText(paramString.trim());
        continue;
        localTextView.setBackgroundResource(2130851404);
        continue;
        label197:
        localTextView.setTextSize(13.0F);
      }
    }
  }
  
  public RedTouch b(int paramInt)
  {
    this.leftMargin = iJ(paramInt);
    return this;
  }
  
  protected ImageView c(int paramInt)
  {
    ImageView localImageView = new ImageView(this.context);
    try
    {
      localImageView.setImageResource(2130851400);
      localImageView.setBackgroundColor(paramInt);
      c();
      localImageView.setLayoutParams(c());
      return localImageView;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("RedTouch", 1, "getRedPoint oom");
      }
    }
  }
  
  protected LinearLayout.LayoutParams c()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.dxn, this.dxn);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public RedTouch c(int paramInt)
  {
    this.rightMargin = iJ(paramInt);
    return this;
  }
  
  public void c(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    this.d = paramRedTypeInfo;
    if (paramRedTypeInfo == null)
    {
      dGB();
      return;
    }
    dGB();
    d(paramRedTypeInfo);
  }
  
  public View cq()
  {
    return this.Fs;
  }
  
  public RedTouch d(int paramInt)
  {
    this.topMargin = iJ(paramInt);
    return this;
  }
  
  public void dGB()
  {
    if (this.kc != null)
    {
      this.kc.removeAllViews();
      this.kc.setVisibility(8);
      this.redPointId = 10;
      this.dnb = 20;
      this.dnc = 30;
      this.dnd = 40;
    }
  }
  
  public void dJA()
  {
    if (this.Dd == null) {
      return;
    }
    if (!this.czn)
    {
      this.Dd.setVisibility(8);
      return;
    }
    if (!auw())
    {
      this.Dd.setVisibility(8);
      return;
    }
    if (TextUtils.isEmpty(this.bYg))
    {
      this.Dd.setVisibility(8);
      QLog.i("RedTouch", 1, "leba show waterMark but json isEmpty");
      return;
    }
    try
    {
      String str = new JSONObject(this.bYg).optString("waterMarkUrl");
      if (TextUtils.isEmpty(str))
      {
        this.Dd.setVisibility(8);
        QLog.i("RedTouch", 1, "leba show waterMark but url isEmpty");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("RedTouch", 1, "leba show waterMark", localException);
      return;
    }
    if (this.Dd.getMeasuredHeight() > 0)
    {
      OP(localException);
      return;
    }
    this.Dd.getViewTreeObserver().addOnGlobalLayoutListener(new alto(this, localException));
  }
  
  protected void dJC()
  {
    this.kc.setLayoutParams(a());
  }
  
  protected void dJD()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.dxj;
    localLayoutParams.leftMargin = this.dxk;
    localLayoutParams.rightMargin = this.imageRightMargin;
    localLayoutParams.topMargin = this.dxl;
    localLayoutParams.bottomMargin = this.dxm;
    this.kc.setLayoutParams(localLayoutParams);
  }
  
  public void dJz()
  {
    if (this.XX != null)
    {
      this.XX.setText("");
      this.XX.setVisibility(8);
    }
    if (this.XW != null)
    {
      this.XW.setText("");
      this.XW.setVisibility(8);
    }
  }
  
  protected int dO(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("#"))) {
      return 0;
    }
    return Color.parseColor(paramString);
  }
  
  public RedTouch e(int paramInt)
  {
    this.dnj = iJ(paramInt);
    return this;
  }
  
  public void e(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    dGB();
    if (paramAppInfo == null) {}
    for (;;)
    {
      return;
      this.DY.clear();
      if ((paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.exposure_max.get() >= 0) && (paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null) && (!as(paramAppInfo.red_display_info.red_type_info.get())))
      {
        this.bHY = paramAppInfo.type.get();
        this.DY.addAll(paramAppInfo.red_display_info.red_type_info.get());
        paramAppInfo = this.DY.iterator();
        while (paramAppInfo.hasNext()) {
          d((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next());
        }
      }
    }
  }
  
  public RedTouch f(int paramInt)
  {
    this.dxo = paramInt;
    this.czk = true;
    return this;
  }
  
  public void f(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    e(paramAppInfo);
    String str;
    if (this.XX != null)
    {
      str = c(paramAppInfo);
      if (!TextUtils.isEmpty(str)) {
        break label82;
      }
      this.XX.setText("");
      this.XX.setVisibility(8);
    }
    for (;;)
    {
      if (this.XW != null)
      {
        paramAppInfo = b(paramAppInfo);
        if (!TextUtils.isEmpty(paramAppInfo)) {
          break;
        }
        this.XW.setText("");
        this.XW.setVisibility(8);
      }
      return;
      label82:
      str = a(str, 3, 2, false);
      this.XX.setText(str);
      this.XX.setVisibility(0);
    }
    paramAppInfo = a(paramAppInfo, 8, 6, true);
    this.XW.setText(paramAppInfo);
    this.XW.setVisibility(0);
  }
  
  public List<BusinessInfoCheckUpdate.RedTypeInfo> fU()
  {
    return this.DY;
  }
  
  public void g(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    dGB();
    if (paramAppInfo == null) {}
    for (;;)
    {
      return;
      this.DY.clear();
      if ((paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.exposure_max.get() >= 0) && (paramAppInfo.red_display_info.get() != null) && (paramAppInfo.red_display_info.red_type_info.get() != null) && (!as(paramAppInfo.red_display_info.red_type_info.get())))
      {
        this.bHY = paramAppInfo.type.get();
        this.DY.addAll(paramAppInfo.red_display_info.red_type_info.get());
        paramAppInfo = this.DY.iterator();
        while (paramAppInfo.hasNext())
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next();
          if (localRedTypeInfo.red_type.get() == 4) {
            localRedTypeInfo.red_type.set(-1);
          }
          d(localRedTypeInfo);
        }
      }
    }
  }
  
  protected int iJ(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  protected View j(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      if (i <= 0) {
        return null;
      }
    }
    catch (NumberFormatException paramString)
    {
      int i;
      for (;;)
      {
        i = 0;
      }
      paramString = new View(this.context);
      LinearLayout.LayoutParams localLayoutParams = c();
      localLayoutParams.width = iJ(i);
      localLayoutParams.height = 1;
      paramString.setLayoutParams(localLayoutParams);
    }
    return paramString;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo n()
  {
    return this.d;
  }
  
  public void setHostEnable(boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    if (this.kc != null)
    {
      localLinearLayout = this.kc;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 4)
    {
      localLinearLayout.setVisibility(i);
      this.czo = paramBoolean;
      return;
    }
  }
  
  public void setMaxNum(int paramInt)
  {
    this.maxNum = paramInt;
  }
  
  public String yy()
  {
    if (this.DY != null)
    {
      Iterator localIterator = this.DY.iterator();
      while (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)localIterator.next();
        if ((localRedTypeInfo != null) && (localRedTypeInfo.red_type.get() == 4)) {
          return localRedTypeInfo.red_content.get();
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouch
 * JD-Core Version:    0.7.0.1
 */