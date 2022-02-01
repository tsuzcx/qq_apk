package cooperation.comic.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqgz;
import aqqx;
import avcs;
import avdb;
import avdk;
import avdl;
import avdn;
import avdu;
import avdv;
import avdw;
import aveb;
import aved;
import aved.a;
import aveg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SimpleTextView;
import cooperation.comic.VipComicJumpActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class QQComicTabBarView
  extends LinearLayout
{
  static final Map<String, String> pU = new HashMap();
  static final Map<String, String> pV;
  static final Map<String, String> pW;
  RelativeLayout.LayoutParams I;
  RelativeLayout.LayoutParams J;
  List<WebViewTabBarData> Lw;
  avdk jdField_a_of_type_Avdk = new avdw(this);
  aved.a jdField_a_of_type_Aved$a = new avdv(this);
  aved jdField_a_of_type_Aved = null;
  final aveg<String, RedTouchUI> jdField_a_of_type_Aveg = new aveg();
  public final Paint aE;
  public int aXA = -1;
  final int aXD;
  final int aXu;
  public int aXz = -1;
  long avU = 0L;
  final aveg<String, String> b;
  public TabBarView.a b;
  LinearLayout.LayoutParams c;
  public final Paint cY;
  int dSh = 0;
  SparseArray<RedAppInfo> dY = new SparseArray();
  final int dep;
  boolean dmI = true;
  boolean dmJ = true;
  final int dzW;
  final int dzX;
  int ewK = -1;
  public float ki;
  final int mActiveColor;
  AppInterface mApp = null;
  public Handler mHandler = new avdu(this, Looper.getMainLooper());
  Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
  public final Paint mPaint;
  final float mTextSize;
  
  static
  {
    pU.put("index", "1113.100800");
    pU.put("fav", "1113.100801");
    pU.put("category", "1113.100804");
    pU.put("more", "1113.100802");
    pU.put("group", "1113.100803");
    pV = new HashMap(5);
    pW = new HashMap(5);
    pV.put("index", "200458");
    pV.put("fav", "200459");
    pV.put("category", "200460");
    pV.put("more", "200461");
    pV.put("group", "200462");
    pW.put("index", "100");
    pW.put("fav", "102");
    pW.put("category", "101");
    pW.put("more", "103");
    pW.put("group", "104");
  }
  
  public QQComicTabBarView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Aveg = new aveg();
    paramContext = super.getContext().getResources();
    this.dep = -8947849;
    this.mActiveColor = -14629889;
    this.mTextSize = TypedValue.applyDimension(2, 17.0F, paramContext.getDisplayMetrics());
    this.dzX = -14629889;
    this.dzW = ((int)TypedValue.applyDimension(1, 6.0F, paramContext.getDisplayMetrics()));
    this.aXD = -8947849;
    this.aXu = ((int)TypedValue.applyDimension(1, 54.0F, paramContext.getDisplayMetrics()));
    this.cY = new Paint(1);
    this.mPaint = new Paint();
    this.mPaint.setColor(this.dzX);
    this.aE = new Paint();
    this.aE.setColor(this.aXD);
    this.c = new LinearLayout.LayoutParams(0, -1);
    this.c.weight = 1.0F;
    this.c.gravity = 17;
    this.I = new RelativeLayout.LayoutParams(-1, -1);
    this.I.addRule(13);
    this.J = new RelativeLayout.LayoutParams(this.aXu, this.aXu);
    this.J.addRule(13);
    ThreadManager.post(new QQComicTabBarView.4(this), 5, null, false);
    setLayerType(2, null);
  }
  
  static void b(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramAppInterface != null)
    {
      str = (String)pV.get(paramString);
      if (!TextUtils.isEmpty(str)) {
        if (!paramBoolean) {
          break label67;
        }
      }
    }
    label67:
    for (paramString = "1";; paramString = "")
    {
      avdb.a(paramAppInterface, "3071", "2", str, "", "", "", "", "", "", paramString, new String[0]);
      return;
    }
  }
  
  float a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramFloat < 0.6F) {
        paramFloat = 0.0F;
      }
    }
    for (;;)
    {
      float f = paramFloat;
      if (this.mInterpolator != null) {
        f = this.mInterpolator.getInterpolation(paramFloat);
      }
      return f;
      paramFloat = (paramFloat - 0.6F) / 0.4F;
      continue;
      if (paramFloat < 0.6F) {
        paramFloat /= 0.6F;
      } else {
        paramFloat = 1.0F;
      }
    }
  }
  
  public View a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt < 0) || (paramInt > super.getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(super.getContext());
    SimpleTextView localSimpleTextView = new SimpleTextView(super.getContext());
    localSimpleTextView.setText(paramString2);
    localSimpleTextView.setTextSize(0, this.mTextSize);
    localSimpleTextView.setTextColor(this.dep);
    localSimpleTextView.setContentDescription(paramString2);
    localSimpleTextView.setGravity(17);
    b localb = new b();
    localb.b = localSimpleTextView;
    localRelativeLayout.setTag(-3, localb);
    boolean bool1;
    if (!this.dmI) {
      bool1 = true;
    }
    for (;;)
    {
      localRelativeLayout.setOnClickListener(new a(this, paramInt, bool1, this.Lw));
      localRelativeLayout.addView(localSimpleTextView, this.I);
      ImageView localImageView;
      File localFile;
      ColorDrawable localColorDrawable;
      boolean bool2;
      if (this.dmI)
      {
        localImageView = new ImageView(super.getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localFile = new File(paramString3);
        localColorDrawable = new ColorDrawable(getResources().getColor(17170445));
        bool2 = this.dmJ;
        bool1 = bool2;
        if (!bool2) {}
      }
      try
      {
        bool1 = ApngDrawable.isApngFile(localFile);
        if (bool1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_loop", 1);
          localBundle.putFloat("key_frame_delay_fraction", 0.6F);
          paramString3 = aqqx.a(this.mApp, paramString3, "-comic-tab-bar-", localColorDrawable, new int[] { 12 }, "-comic-tab-bar-", localBundle);
          if (paramString3 != null)
          {
            if (ApngImage.canDecodeIDs.contains(Integer.valueOf(12))) {
              break label555;
            }
            ApngImage.canDecodeIDs.add(Integer.valueOf(12));
            localb.S = paramString3;
            if (!bool1)
            {
              paramString3 = URLDrawable.URLDrawableOptions.obtain();
              paramString3.mLoadingDrawable = localColorDrawable;
              paramString3.mFailedDrawable = localColorDrawable;
              localb.S = URLDrawable.getDrawable(localFile, paramString3);
            }
            localb.mIcon = localImageView;
            localRelativeLayout.addView(localImageView, this.J);
            localImageView.setVisibility(8);
            super.addView(localRelativeLayout, paramInt, this.c);
            if (pU.containsKey(paramString1))
            {
              paramString1 = (String)pU.get(paramString1);
              paramString3 = (RedTouchUI)new RedTouchUI(super.getContext(), localSimpleTextView).a(5).a();
              paramString3.setRedpointImgResID(2130851400);
              paramString3.setTextOrNumImgRedID(2130851404);
              this.jdField_b_of_type_Aveg.put(paramString1, aV(paramString1, 0));
              this.jdField_a_of_type_Aveg.put(paramString1, paramString3);
              localb.a = paramString3;
            }
            if (AppSetting.enableTalkBack) {
              localRelativeLayout.setContentDescription(paramString2);
            }
            return localSimpleTextView;
            bool1 = false;
          }
        }
      }
      catch (IOException localIOException)
      {
        label555:
        for (;;)
        {
          QLog.e("WebViewTabBarView", 1, localIOException, new Object[0]);
          bool1 = bool2;
          continue;
          bool1 = false;
          continue;
        }
      }
    }
  }
  
  public void a(Intent paramIntent, List<WebViewTabBarData> paramList, TabBarView.a parama)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView$a = parama;
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_maintab", -1);
      paramIntent.removeExtra("key_maintab");
    }
    for (;;)
    {
      if ((!aqgz.aCG()) && (avcs.av("navSwitchAnimation", 1) == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        this.dmJ = bool;
        this.Lw = paramList;
        if (paramList == null) {
          break label159;
        }
        paramIntent = paramList.iterator();
        while (paramIntent.hasNext()) {
          if (TextUtils.isEmpty(((WebViewTabBarData)paramIntent.next()).tabIcon)) {
            this.dmI = false;
          }
        }
      }
      paramIntent = paramList.iterator();
      while (paramIntent.hasNext())
      {
        paramList = (WebViewTabBarData)paramIntent.next();
        a(super.getChildCount(), paramList.tag, paramList.tabName, paramList.tabIcon);
      }
      label159:
      super.setVisibility(0);
      bOU();
      if (i != -1)
      {
        this.dSh = i;
        lf(this.ewK, this.dSh);
        this.aXA = this.dSh;
        this.ewK = this.aXA;
      }
      return;
      i = -1;
    }
  }
  
  void a(RedTouchUI paramRedTouchUI, RedAppInfo paramRedAppInfo, boolean paramBoolean)
  {
    if ((paramRedTouchUI == null) || (paramRedAppInfo == null) || (paramRedAppInfo.a() == null) || (paramRedAppInfo.a().fT() == null)) {}
    while ((paramBoolean) && (paramRedTouchUI.a != null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    Iterator localIterator = paramRedAppInfo.a().fT().iterator();
    RedTypeInfo localRedTypeInfo;
    while (localIterator.hasNext())
    {
      localRedTypeInfo = (RedTypeInfo)localIterator.next();
      if (localRedTypeInfo.getRed_type() != 9)
      {
        if ((localRedTypeInfo.getRed_type() == 3) || (localRedTypeInfo.getRed_type() == 4)) {
          localRedTypeInfo.setRed_type(0);
        }
        if (localRedTypeInfo.getRed_type() != 0) {
          break label162;
        }
        paramRedTouchUI.a(0, 13, 12, 0).a();
      }
    }
    for (;;)
    {
      localArrayList.add(localRedTypeInfo);
      paramRedAppInfo.a().eK(localArrayList);
      paramRedTouchUI.b(paramRedAppInfo);
      return;
      label162:
      paramRedTouchUI.a(0, 8, 7, 0).a();
    }
  }
  
  public String aV(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = avdb.b();
    int i;
    if (paramInt == 0)
    {
      i = 100000000;
      localStringBuilder.append(100600);
      localStringBuilder.append('.');
    }
    while (paramString.contains("."))
    {
      paramString = paramString.split("\\.");
      if (paramString.length <= 0) {
        break label235;
      }
      int m = paramString.length;
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j >= m) {
          break label142;
        }
        String str = paramString[j];
        try
        {
          localStringBuilder.append(Integer.parseInt(str) + i);
          localStringBuilder.append('.');
          k += 1;
          j += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
      }
      if (paramInt == 1)
      {
        i = -100000000;
      }
      else
      {
        return null;
        label142:
        if (k != paramString.length) {
          break label235;
        }
        i = 1;
      }
    }
    while (i != 0)
    {
      if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == '.')) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      if (paramInt == 1)
      {
        paramInt = localStringBuilder.indexOf(".");
        if (paramInt < 0)
        {
          return null;
          try
          {
            localStringBuilder.append(i + Integer.parseInt(paramString));
            i = 1;
          }
          catch (NumberFormatException paramString)
          {
            paramString.printStackTrace();
          }
          label235:
          i = 0;
        }
        else
        {
          return localStringBuilder.substring(paramInt + 1);
        }
      }
      else
      {
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  void abF(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= super.getChildCount())) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = super.getChildAt(paramInt).getTag(-3);
        } while (!(localObject1 instanceof b));
        localObject1 = ((b)localObject1).a;
      } while ((localObject1 == null) || (!((RedTouchUI)localObject1).aux()));
      ((RedTouchUI)localObject1).dGB();
      localObject2 = (String)this.jdField_a_of_type_Aveg.h(localObject1);
      if (this.jdField_a_of_type_Aved != null)
      {
        this.jdField_a_of_type_Aved.ZK((String)localObject2);
        this.jdField_a_of_type_Aved.ZK((String)this.jdField_b_of_type_Aveg.get(localObject2));
      }
      localObject2 = (RedAppInfo)this.dY.get(paramInt);
    } while (((localObject2 != null) && (((RedTouchUI)localObject1).a == localObject2)) || (this.mApp == null));
    Object localObject1 = (WebViewTabBarData)this.Lw.get(paramInt);
    avdb.a(this.mApp, "3014", "2", "40049", "", new String[] { (String)pW.get(((WebViewTabBarData)localObject1).tag) });
  }
  
  public void bO(Canvas paramCanvas)
  {
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
      paramCanvas.drawColor(-2147483648);
    }
  }
  
  public void bOU()
  {
    ThreadManager.postImmediately(new QQComicTabBarView.7(this), null, false);
  }
  
  void cq(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= super.getChildCount())) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = super.getChildAt(paramInt).getTag(-3);
        } while (!(localObject instanceof b));
        localObject = ((b)localObject).a;
      } while (localObject == null);
      ((RedTouchUI)localObject).dGB();
    } while ((!paramBoolean) || (aveb.a == null));
    aveb.a.ezx();
  }
  
  public void df(int paramInt1, int paramInt2)
  {
    Object localObject = super.getChildAt(paramInt1);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof b)) {
        ((b)localObject).b.setTextColor(this.dep);
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof b)) {
        ((b)localObject).b.setTextColor(this.mActiveColor);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    boolean bool2 = true;
    super.dispatchDraw(paramCanvas);
    if (this.dmI)
    {
      bO(paramCanvas);
      return;
    }
    View localView1 = super.getChildAt(this.aXA);
    View localView2 = super.getChildAt(this.aXz);
    int j;
    int i;
    boolean bool1;
    float f1;
    if ((localView1 != null) && (localView2 != null))
    {
      j = localView1.getLeft();
      i = localView1.getRight();
      if (this.ki <= 0.0F) {
        break label301;
      }
      if (this.aXA >= this.aXz) {
        break label289;
      }
      bool1 = true;
      j = (int)(localView1.getLeft() + a(this.ki, bool1) * (localView2.getLeft() - localView1.getLeft()));
      f1 = localView1.getRight();
      float f2 = this.ki;
      if (bool1) {
        break label295;
      }
      bool1 = bool2;
      label142:
      i = (int)(a(f2, bool1) * (localView2.getRight() - localView1.getRight()) + f1);
    }
    label289:
    label295:
    label301:
    for (;;)
    {
      paramCanvas.drawRect(j, super.getHeight() - this.dzW, i, super.getHeight(), this.mPaint);
      i = (localView2.getLeft() + localView2.getRight()) / 2;
      j = (localView2.getTop() + localView2.getBottom()) / 2;
      f1 = (localView2.getRight() - localView2.getLeft()) / 2;
      this.aE.setAlpha((int)(96.0F * (1.0F - this.ki)));
      paramCanvas.drawCircle(i, j, f1 * 1.2F * this.ki, this.aE);
      bO(paramCanvas);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label142;
    }
  }
  
  void ezE()
  {
    Iterator localIterator = this.jdField_a_of_type_Aveg.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (RedTouchUI)((Map.Entry)localObject).getValue();
        if ((str != null) && (localObject != null) && (((RedTouchUI)localObject).aux()) && (this.mApp != null)) {
          if ("1113.100800".equals(str)) {
            avdb.a(this.mApp, "3014", "1", "30012", "", new String[] { "100" });
          } else if ("1113.100801".equals(str)) {
            avdb.a(this.mApp, "3014", "1", "30012", "", new String[] { "102" });
          } else if ("1113.100802".equals(str)) {
            avdb.a(this.mApp, "3014", "1", "30012", "", new String[] { "103" });
          } else if ("1113.100803".equals(str)) {
            avdb.a(this.mApp, "3014", "1", "30012", "", new String[] { "104" });
          } else if ("1113.100804".equals(str)) {
            avdb.a(this.mApp, "3014", "1", "30012", "", new String[] { "101" });
          }
        }
      }
    }
  }
  
  void lf(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "tab switch : old=" + paramInt1 + ", new=" + paramInt2);
    }
    Object localObject = super.getChildAt(paramInt1);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        ((b)localObject).b.setVisibility(0);
        ((b)localObject).mIcon.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("WebViewTabBarView", 2, "tab icon hide.");
        }
      }
    }
    localObject = super.getChildAt(paramInt2);
    if (localObject != null)
    {
      localObject = ((View)localObject).getTag(-3);
      if ((localObject instanceof b))
      {
        localObject = (b)localObject;
        if ((((b)localObject).mIcon != null) && (((b)localObject).b != null))
        {
          ((b)localObject).b.setVisibility(8);
          URLDrawable localURLDrawable = ((b)localObject).S;
          ((b)localObject).mIcon.setVisibility(0);
          ((b)localObject).mIcon.setImageDrawable(localURLDrawable);
          if ((localURLDrawable != null) && ((localURLDrawable.getCurrDrawable() instanceof ApngDrawable)))
          {
            ((ApngDrawable)localURLDrawable.getCurrDrawable()).repaly();
            if (QLog.isColorLevel()) {
              QLog.d("WebViewTabBarView", 2, "tab icon anim play.");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("WebViewTabBarView", 2, "tab icon show.");
          }
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ThreadManager.getSubThreadHandler().post(new QQComicTabBarView.5(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ThreadManager.getSubThreadHandler().post(new QQComicTabBarView.6(this));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.aXu, 1073741824));
    super.setMeasuredDimension(super.getMeasuredWidth(), this.aXu);
  }
  
  public int qt()
  {
    return this.aXA;
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    int j = super.getChildCount();
    paramInt = i;
    if (i >= j) {
      paramInt = j - 1;
    }
    if (this.aXA != paramInt)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView$a != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView$a.onTabSelected(this.aXA, paramInt);
      }
      if (this.dmI) {
        lf(this.ewK, paramInt);
      }
      if (!paramBoolean) {
        break label164;
      }
      this.aXz = paramInt;
      this.ki = 0.0F;
      this.mHandler.sendEmptyMessage(0);
    }
    for (;;)
    {
      this.ewK = this.aXz;
      WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)this.Lw.get(paramInt);
      b(this.mApp, localWebViewTabBarData.tag, false);
      abF(paramInt);
      paramBoolean = bool;
      if (paramInt == VipComicJumpActivity.b("fav", this.Lw)) {
        paramBoolean = true;
      }
      cq(paramInt, paramBoolean);
      return;
      label164:
      this.aXz = paramInt;
      this.ki = 1.0F;
      this.mHandler.sendEmptyMessage(2);
    }
  }
  
  static class a
    implements View.OnClickListener
  {
    final List<WebViewTabBarData> Lx;
    final boolean animate;
    final WeakReference<QQComicTabBarView> j;
    final int position;
    
    a(QQComicTabBarView paramQQComicTabBarView, int paramInt, boolean paramBoolean, List<WebViewTabBarData> paramList)
    {
      this.j = new WeakReference(paramQQComicTabBarView);
      this.position = paramInt;
      this.animate = paramBoolean;
      this.Lx = paramList;
    }
    
    void d(QQComicTabBarView paramQQComicTabBarView)
    {
      Object localObject;
      JSONObject localJSONObject;
      if ((paramQQComicTabBarView.getContext() instanceof QQBrowserActivity))
      {
        localObject = ((QQBrowserActivity)paramQQComicTabBarView.getContext()).a();
        if ((localObject instanceof QQComicFragment))
        {
          localObject = ((QQComicFragment)localObject).a();
          if (localObject != null) {
            localJSONObject = new JSONObject();
          }
        }
      }
      try
      {
        localJSONObject.put("source", "comic");
        ((avdn)localObject).dispatchJsEvent("qbrowserTabClick", null, localJSONObject);
        if ((this.Lx != null) && (this.Lx.size() > this.position))
        {
          localObject = ((WebViewTabBarData)this.Lx.get(this.position)).tag;
          QQComicTabBarView.b(paramQQComicTabBarView.mApp, (String)localObject, true);
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("WebViewTabBarView", 1, localJSONException, new Object[0]);
        }
      }
    }
    
    public void onClick(View paramView)
    {
      QQComicTabBarView localQQComicTabBarView = (QQComicTabBarView)this.j.get();
      if (localQQComicTabBarView == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.position == localQQComicTabBarView.aXA)
        {
          d(localQQComicTabBarView);
        }
        else
        {
          long l = System.currentTimeMillis();
          if (l - localQQComicTabBarView.avU >= 500L)
          {
            localQQComicTabBarView.avU = l;
            localQQComicTabBarView.setSelectedTab(this.position, this.animate);
          }
        }
      }
    }
  }
  
  public class b
  {
    public URLDrawable S;
    RedTouchUI a;
    public SimpleTextView b;
    public ImageView mIcon;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView
 * JD-Core Version:    0.7.0.1
 */