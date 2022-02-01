package com.tencent.mobileqq.widget.share;

import acbn;
import aduk;
import aduk.a;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqhu;
import armc;
import armd;
import arme;
import armf;
import armg;
import armh;
import armi;
import armj;
import ausj;
import auss;
import auvj;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import shb;

public class ShareActionSheetV2
  implements ShareActionSheet
{
  protected View Gt;
  protected List<ShareActionSheetBuilder.ActionSheetItem> Ju = new ArrayList(0);
  protected int OC;
  public Context V;
  private aduk.a jdField_a_of_type_Aduk$a = new armd(this);
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new armh(this);
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener;
  private ShareActionSheet.a jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$a;
  private final Param jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param;
  protected b a;
  protected CharSequence ac;
  public ausj an;
  private Intent aq;
  private Application.ActivityLifecycleCallbacks jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new arme(this);
  private DialogInterface.OnShowListener jdField_b_of_type_AndroidContentDialogInterface$OnShowListener = new armg(this);
  protected int bgc;
  protected int bgd;
  protected boolean bpu;
  private DialogInterface.OnShowListener c;
  protected ElasticHorScrView c;
  private boolean cUD;
  private String cuk;
  protected ElasticHorScrView d;
  protected LinearLayout dA;
  protected int dAc;
  protected int dAd;
  protected int dAe;
  protected int dAf;
  protected int dAg;
  private SparseArray<aduk> dQ;
  private boolean dcg;
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] e;
  protected int ekt;
  private int eku = 0;
  private int ekv = 0;
  private int ekw = 0;
  private DialogInterface.OnDismissListener f;
  protected ElasticHorScrView f;
  private DialogInterface.OnCancelListener g;
  private DialogInterface.OnDismissListener k;
  protected AdapterView.OnItemClickListener k;
  protected LinearLayout lg;
  protected TextView mTitleTv;
  public GridView n;
  public GridView o;
  public GridView p;
  private ResultReceiver u;
  protected ImageView yV;
  protected boolean zO = true;
  
  public ShareActionSheetV2(Param paramParam)
  {
    this.jdField_k_of_type_AndroidWidgetAdapterView$OnItemClickListener = new armc(this);
    this.jdField_f_of_type_AndroidContentDialogInterface$OnDismissListener = new armf(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param = paramParam;
    this.V = paramParam.context;
    paramParam = this.V.getResources();
    this.OC = paramParam.getDimensionPixelSize(2131296957);
    this.dAd = this.OC;
    this.dAe = paramParam.getDimensionPixelOffset(2131296959);
    this.dAf = paramParam.getDimensionPixelOffset(2131296960);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$b = new b();
    int i = paramParam.getDisplayMetrics().widthPixels;
    int j = paramParam.getDisplayMetrics().heightPixels;
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      i = (i - (int)(getIconWidth() * 5.2F)) / (((int)5.2F + 1) * 2);
      setIconMarginLeftRight(i);
      setRowMarginLeftRight((int)(i * 6 / 5.5F));
      registerActivityLifecycle();
      return;
    }
  }
  
  private String CX()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.reportDataR2 > 0)) {
      return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.reportDataR2);
    }
    return "";
  }
  
  private String CY()
  {
    if (!TextUtils.isEmpty(((Activity)this.V).getIntent().getStringExtra("url"))) {
      return "biz_src_general_url";
    }
    return "";
  }
  
  private int a(List<ShareActionSheetBuilder.ActionSheetItem> paramList, TextView paramTextView)
  {
    paramTextView.setText(q(paramList));
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(this.dAd, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramTextView.getMeasuredHeight();
  }
  
  private void a(ElasticHorScrView paramElasticHorScrView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      paramElasticHorScrView.setMove(true);
      return;
    }
    paramElasticHorScrView.setMove(false);
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    String str2 = ((Activity)this.V).getIntent().getStringExtra("big_brother_source_key");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = CY();
    }
    if (paramActionSheetItem.action == 73) {
      anot.a(null, "dc00898", "", "", "0X800AB3F", "0X800AB3F", 0, 0, CX(), "", str1, "");
    }
    do
    {
      return;
      if (paramActionSheetItem.action == 72)
      {
        anot.a(null, "dc00898", "", paramActionSheetItem.uin, "0X800AB3E", "0X800AB3E", 0, 0, CX(), "", str1, paramActionSheetItem.reportID);
        return;
      }
      if (paramInt == 1)
      {
        anot.a(null, "dc00898", "", "", "0X800AB40", "0X800AB40", 0, 0, CX(), "", str1, paramActionSheetItem.reportID);
        return;
      }
    } while (paramInt != 2);
    anot.a(null, "dc00898", "", "", "0X800AB41", "0X800AB41", 0, 0, CX(), "", str1, paramActionSheetItem.reportID);
  }
  
  private boolean aGQ()
  {
    if (this.eku != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called no need to load data");
      }
    }
    do
    {
      return false;
      if (this.aq != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called parameter illegal. Intent not set");
    return false;
    return true;
  }
  
  private void b(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    int i = 0;
    if (i < this.p.getChildCount())
    {
      paramString2 = this.p.getChildAt(i).getTag();
      if (paramString2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        if ((paramString2 instanceof ShareActionSheetBuilder.b))
        {
          paramString2 = (ShareActionSheetBuilder.b)paramString2;
          if (TextUtils.equals(paramString1, paramString2.b.uin))
          {
            paramString2.b.iconDrawable = new BitmapDrawable(paramBitmap);
            paramString2.vIcon.setBackgroundDrawable(paramString2.b.iconDrawable);
          }
        }
      }
    }
  }
  
  private void dismissInternal(boolean paramBoolean)
  {
    setOpenSource(null);
    if (isShowing())
    {
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          this.an.superDismiss();
          this.Gt = null;
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          QLog.w("ShareActionSheetV2", 2, "Exception while dismiss", localRuntimeException);
        }
        this.an.dismiss();
      }
    }
  }
  
  private void eku()
  {
    Object localObject2 = ((Activity)this.V).getIntent().getStringExtra("big_brother_source_key");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = CY();
    }
    localObject2 = new StringBuilder();
    List[] arrayOfList = a();
    if (arrayOfList.length > 0)
    {
      int i = 0;
      while (i < arrayOfList[0].size())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)arrayOfList[0].get(i);
        if (i != 0) {
          ((StringBuilder)localObject2).append(';');
        }
        ((StringBuilder)localObject2).append(localActionSheetItem.reportID);
        i += 1;
      }
    }
    anot.a(null, "dc00898", "", "", "0X800AB3D", "0X800AB3D", 0, 0, CX(), "", (String)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  private void ekv()
  {
    if (this.u != null)
    {
      this.u.send(1, new Bundle());
      this.u = null;
    }
  }
  
  private void ekw()
  {
    ((Application)this.V.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
  }
  
  private void ekx()
  {
    try
    {
      if (!isShowing())
      {
        if (this.cUD) {
          shb.f(getWindow());
        }
        this.an.show();
        if (this.cUD)
        {
          shb.e(getWindow());
          shb.g(getWindow());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheetV2", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  private void eky()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.fullScreen) {}
    int i;
    for (this.an = ((ausj)auss.b(this.V, null));; this.an = ((ausj)auss.a(this.V, null, i, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.lp)))
    {
      this.an.setOnShowListener(this.jdField_b_of_type_AndroidContentDialogInterface$OnShowListener);
      this.an.a(new armi(this));
      this.an.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
      if ((this.Gt == null) || (this.bpu)) {
        this.Gt = L();
      }
      this.an.setActionContentView(this.Gt, null);
      Window localWindow = this.an.getWindow();
      localWindow.setDimAmount(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.dimAmount);
      localWindow.setGravity(80);
      localWindow.setLayout(-1, -1);
      this.an.setOutsideDismissEnableCompat(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.canceledOnTouchOutside);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
        localWindow.setLayout(-1, -2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
        localWindow.setFlags(32, 32);
      }
      localWindow.setAttributes(localLayoutParams);
      return;
      i = 2131558463;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$Param.flagNotTouchModal) {
        i = 2131558464;
      }
    }
  }
  
  private void ekz()
  {
    ekv();
    Intent localIntent = new Intent();
    if (this.aq != null) {
      localIntent = this.aq;
    }
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    localIntent.setClass(this.V, ForwardRecentTranslucentActivity.class);
    localIntent.putExtra("caller_name", this.V.getClass().getSimpleName());
    localIntent.putExtra("forward_source_business_type", -1);
    localIntent.putExtra("key_req", ForwardRecentActivity.bGT);
    localIntent.putExtra("PARAM_ActivityResultReceiver", new MyResultReceiver(this));
    this.V.startActivity(localIntent);
    ((Activity)this.V).overridePendingTransition(0, 0);
  }
  
  private void fj(ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onRecentUserChanged() called with: recentUsers = [" + paramArrayList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.Ju.clear();
    int i = 0;
    for (;;)
    {
      if ((paramArrayList != null) && (i < paramArrayList.size()))
      {
        if (i >= 15)
        {
          paramArrayList = ShareActionSheetBuilder.ActionSheetItem.build(73);
          paramArrayList.iconNeedBg = false;
          paramArrayList.iconDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130850709);
          this.Ju.add(paramArrayList);
        }
      }
      else
      {
        eky();
        ekx();
        return;
      }
      Object localObject1 = (ResultRecord)paramArrayList.get(i);
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(72);
      localActionSheetItem.label = ((ResultRecord)localObject1).name;
      localActionSheetItem.uin = ((ResultRecord)localObject1).uin;
      localActionSheetItem.uinType = ((ResultRecord)localObject1).type;
      localActionSheetItem.iconNeedBg = false;
      Object localObject2 = new StringBuilder().append("isNewTroop=");
      int j;
      if (((ResultRecord)localObject1).isNewTroop)
      {
        j = 1;
        localActionSheetItem.argus = j;
        if ((6000 == localActionSheetItem.uinType) && (TextUtils.equals(acbn.bkw, localActionSheetItem.uin)))
        {
          localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(26);
          localActionSheetItem.label = ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label;
          localActionSheetItem.reportID = ((ShareActionSheetBuilder.ActionSheetItem)localObject1).reportID;
          localActionSheetItem.iconNeedBg = false;
          localActionSheetItem.icon = 2130845073;
          if (auvj.isNightMode())
          {
            localObject1 = new Paint();
            ((Paint)localObject1).setAntiAlias(true);
            ((Paint)localObject1).setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
          }
        }
      }
      try
      {
        localObject2 = BitmapFactory.decodeResource(this.V.getResources(), localActionSheetItem.icon).copy(Bitmap.Config.ARGB_8888, true);
        Canvas localCanvas = new Canvas((Bitmap)localObject2);
        localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, localCanvas.getWidth(), localCanvas.getHeight()), aqhu.dZk, aqhu.dZk, (Paint)localObject1);
        localActionSheetItem.iconDrawable = new BitmapDrawable((Bitmap)localObject2);
        this.Ju.add(localActionSheetItem);
        i += 1;
        continue;
        j = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("ShareActionSheetV2", 1, "onRecentUserChanged: no night mode mask", localThrowable);
        }
      }
    }
  }
  
  private void ni(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)paramList.next();
        if ((localActionSheetItem.action == 50) || (localActionSheetItem.action == 60) || (localActionSheetItem.action == 3)) {
          paramList.remove();
        }
      }
    }
  }
  
  private void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onDestroy() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if ((this.dQ != null) && (this.dQ.size() > 0))
    {
      int i = 0;
      while (i < this.dQ.size())
      {
        int j = this.dQ.keyAt(i);
        aduk localaduk = (aduk)this.dQ.get(j);
        if (localaduk != null) {
          localaduk.destroy();
        }
        i += 1;
      }
      this.dQ.clear();
    }
    ekv();
  }
  
  private void registerActivityLifecycle()
  {
    ((Application)this.V.getApplicationContext()).registerActivityLifecycleCallbacks(this.jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
  }
  
  @TargetApi(9)
  protected View L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "createViewFlipper() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    View localView = View.inflate(this.V, 2131559038, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$b.B((RelativeLayout)localView.findViewById(2131362258));
    this.lg = ((LinearLayout)localView.findViewById(2131362012));
    if (auvj.isNightMode()) {
      this.lg.setBackgroundResource(2130850711);
    }
    int j = 1;
    int m = 1;
    int i1 = 1;
    this.mTitleTv = ((TextView)localView.findViewById(2131362010));
    Object localObject3;
    Object localObject1;
    label234:
    Object localObject2;
    label258:
    label289:
    Object localObject4;
    int i;
    int i2;
    int i3;
    if (this.zO)
    {
      this.mTitleTv.setVisibility(0);
      if (this.ac != null) {
        this.mTitleTv.setText(this.ac);
      }
      this.jdField_f_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377767));
      this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377768));
      this.d = ((ElasticHorScrView)localView.findViewById(2131377769));
      this.dA = ((LinearLayout)localView.findViewById(2131362001));
      localObject3 = a();
      if (localObject3.length <= 0) {
        break label482;
      }
      localObject1 = this.Ju;
      if (((List)localObject1).isEmpty()) {
        j = 0;
      }
      if (localObject3.length <= 0) {
        break label495;
      }
      localObject2 = localObject3[0];
      ni((List)localObject2);
      if (((List)localObject2).isEmpty()) {
        m = 0;
      }
      if (localObject3.length <= 1) {
        break label508;
      }
      localObject3 = localObject3[1];
      if (((List)localObject3).isEmpty()) {
        i1 = 0;
      }
      localObject4 = (TextView)LayoutInflater.from(this.V).inflate(2131559036, null);
      ((TextView)localObject4).setLayoutParams(new ViewGroup.LayoutParams(this.dAd, -2));
      i = a((List)localObject1, (TextView)localObject4);
      i2 = a((List)localObject2, (TextView)localObject4);
      i3 = a((List)localObject3, (TextView)localObject4);
      i2 = Math.max(Math.max(i, i2), i3);
      i3 = this.V.getResources().getDimensionPixelOffset(2131296956);
      if (j == 0) {
        break label696;
      }
      this.p = ((GridView)localView.findViewById(2131368139));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_f_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      }
      localObject4 = ((List)localObject1).iterator();
      i = 0;
      label442:
      if (!((Iterator)localObject4).hasNext()) {
        break label521;
      }
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
        break label1373;
      }
      i += 1;
    }
    label521:
    label696:
    label1367:
    label1370:
    label1373:
    for (;;)
    {
      break label442;
      hideTitle();
      break;
      label482:
      localObject1 = new ArrayList(0);
      break label234;
      label495:
      localObject2 = new ArrayList(0);
      break label258;
      label508:
      localObject3 = new ArrayList(0);
      break label289;
      int i4 = this.dAc + getIconWidth() + this.dAc;
      this.p.setColumnWidth(i4);
      this.p.setNumColumns(i);
      localObject4 = this.p.getLayoutParams();
      this.p.setPadding(this.dAg, this.p.getPaddingTop(), this.dAg, this.p.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject4).width = (i4 * i + this.dAg + this.dAg);
      this.ekt = ((ViewGroup.LayoutParams)localObject4).width;
      ((ViewGroup.LayoutParams)localObject4).height = (this.OC + this.dAe + i2 + i3);
      this.p.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.p.setAdapter(new a(this.V, (List)localObject1, this));
      this.p.setSelector(new ColorDrawable(0));
      this.p.setOnItemClickListener(this.jdField_k_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      if (m != 0)
      {
        this.n = ((GridView)localView.findViewById(2131368140));
        if (Build.VERSION.SDK_INT >= 9) {
          this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
        }
        localObject1 = ((List)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
            break label1370;
          }
          i += 1;
        }
      }
      for (;;)
      {
        break;
        i4 = this.dAc + getIconWidth() + this.dAc;
        this.n.setColumnWidth(i4);
        this.n.setNumColumns(i);
        localObject1 = this.n.getLayoutParams();
        this.n.setPadding(this.dAg, this.n.getPaddingTop(), this.dAg, this.n.getPaddingBottom());
        ((ViewGroup.LayoutParams)localObject1).width = (i4 * i + this.dAg + this.dAg);
        this.bgd = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject1).height = (this.OC + this.dAe + i2 + i3);
        this.n.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.n.setAdapter(new a(this.V, (List)localObject2, this));
        this.n.setSelector(new ColorDrawable(0));
        this.n.setOnItemClickListener(this.jdField_k_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        if (i1 != 0)
        {
          this.o = ((GridView)localView.findViewById(2131368141));
          if (Build.VERSION.SDK_INT >= 9) {
            this.d.setOverScrollMode(2);
          }
          this.o.setSmoothScrollbarEnabled(false);
          localObject1 = ((List)localObject3).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
              break label1367;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break;
          i4 = this.dAc + getIconWidth() + this.dAc;
          this.o.setColumnWidth(i4);
          this.o.setNumColumns(i);
          localObject1 = this.o.getLayoutParams();
          this.o.setPadding(this.dAg, this.o.getPaddingTop(), this.dAg, this.o.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject1).width = (i4 * i + this.dAg + this.dAg);
          this.bgc = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject1).height = (this.OC + this.dAe + i2 + i3);
          this.o.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.o.setNumColumns(i);
          this.o.setAdapter(new a(this.V, (List)localObject3, this));
          this.o.setSelector(new ColorDrawable(0));
          this.o.setOnItemClickListener(this.jdField_k_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          this.yV = ((ImageView)localView.findViewById(2131362002));
          this.yV.setOnClickListener(new armj(this));
          if ((j == 0) || (this.eku == 8)) {
            this.jdField_f_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          if ((m == 0) || (this.ekv == 8)) {
            this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
          }
          if ((i1 == 0) || (this.ekw == 8)) {
            this.d.setVisibility(8);
          }
          localView.post(new ShareActionSheetV2.9(this));
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$a != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$a.cw();
            if (localObject1 != null) {
              this.dA.addView((View)localObject1);
            }
          }
          return localView;
        }
      }
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (this.e != null) {
      return this.e;
    }
    return (List[])new ArrayList[0];
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "dismiss() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    dismissInternal(false);
  }
  
  public void dismissImmediately()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "dismissImmediately() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    dismissInternal(true);
  }
  
  public View findViewById(int paramInt)
  {
    if (this.an == null) {}
    Window localWindow;
    do
    {
      return null;
      localWindow = this.an.getWindow();
    } while (localWindow == null);
    return localWindow.findViewById(paramInt);
  }
  
  public ausj getActionSheet()
  {
    return this.an;
  }
  
  public int getIconWidth()
  {
    return this.OC;
  }
  
  public String getOpenSource()
  {
    return this.cuk;
  }
  
  public Window getWindow()
  {
    if (this.an == null) {
      return null;
    }
    return this.an.getWindow();
  }
  
  public void hideTitle()
  {
    this.zO = false;
    if ((this.mTitleTv != null) && (this.mTitleTv.getVisibility() != 8)) {
      this.mTitleTv.setVisibility(8);
    }
  }
  
  public boolean isShowing()
  {
    return (this.an != null) && (this.an.isShowing());
  }
  
  public void onConfigurationChanged()
  {
    if ((this.V == null) || (!isShowing())) {
      return;
    }
    int i = this.V.getResources().getDisplayMetrics().widthPixels - this.dAg;
    a(this.jdField_f_of_type_ComTencentBizWidgetsElasticHorScrView, i, this.ekt);
    a(this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView, i, this.bgd);
    a(this.d, i, this.bgc);
  }
  
  protected String q(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label54;
      }
      localObject = str;
    }
    label54:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public void refresh()
  {
    if (this.an == null) {}
    while (!this.an.isShowing()) {
      return;
    }
    this.Gt = L();
    this.an.setActionContentView(this.Gt, null);
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> paramList1, List<ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    setActionSheetItems(new ArrayList[] { (ArrayList)paramList1, (ArrayList)paramList2 });
  }
  
  public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.e = paramArrayOfList;
    this.bpu = true;
  }
  
  public void setActionSheetTitle(CharSequence paramCharSequence)
  {
    this.ac = paramCharSequence;
    if (this.mTitleTv != null) {
      this.mTitleTv.setText(this.ac);
    }
  }
  
  public void setAdvBgColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$b.setBgColor(paramInt);
  }
  
  public void setAdvView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$b.b(paramView, paramLayoutParams);
  }
  
  public void setBottomBarInterface(ShareActionSheet.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$a = parama;
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setCancelListener() called with: listener = [" + paramOnCancelListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.g = paramOnCancelListener;
  }
  
  public void setEnableNotTriggerVirtualNavigationBar(boolean paramBoolean)
  {
    this.cUD = paramBoolean;
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setIconMarginLeftRight(int paramInt)
  {
    this.dAc = paramInt;
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setIntentForStartForwardRecentActivity() called with: intent = [" + paramIntent + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.aq = paramIntent;
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = paramOnItemClickListener;
    this.bpu = true;
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "setOnDismissListener() called with: dismissListener = [" + paramOnDismissListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_k_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.jdField_c_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
  
  public void setOpenSource(String paramString)
  {
    this.cuk = paramString;
  }
  
  public void setRowMarginLeftRight(int paramInt)
  {
    this.dAg = paramInt;
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    this.eku = paramInt1;
    this.ekv = paramInt2;
    this.ekw = paramInt3;
  }
  
  public void show()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "show() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if ((this.dcg) || (isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "show() isShowing #this = " + Integer.toHexString(System.identityHashCode(this)));
      }
      return;
    }
    this.dcg = true;
    if (aGQ())
    {
      ekz();
      return;
    }
    eky();
    ekx();
  }
  
  public void updateUI() {}
  
  public void updateUIIfShowing() {}
  
  public static class MyResultReceiver
    extends ResultReceiver
  {
    private WeakReference<ShareActionSheetV2> mRef;
    
    public MyResultReceiver(ShareActionSheetV2 paramShareActionSheetV2)
    {
      super();
      this.mRef = new WeakReference(paramShareActionSheetV2);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
      }
      ShareActionSheetV2 localShareActionSheetV2 = (ShareActionSheetV2)this.mRef.get();
      if ((localShareActionSheetV2 != null) && (paramBundle != null))
      {
        paramBundle.setClassLoader(ShareActionSheetV2.class.getClassLoader());
        if (paramBundle.getInt("key_req") == ForwardRecentActivity.bGT)
        {
          if (paramInt != -1) {
            break label192;
          }
          paramBundle = paramBundle.getParcelableArrayList("result_set");
          if (paramBundle != null)
          {
            localIterator = paramBundle.iterator();
            while (localIterator.hasNext())
            {
              localResultRecord = (ResultRecord)localIterator.next();
              if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheetV2", 2, "onReceiveResult() called with: record = [" + localResultRecord);
              }
            }
          }
          ShareActionSheetV2.a(localShareActionSheetV2, paramBundle);
          ShareActionSheetV2.a(localShareActionSheetV2, null);
        }
      }
      label192:
      while (paramInt != 100)
      {
        Iterator localIterator;
        ResultRecord localResultRecord;
        return;
      }
      ShareActionSheetV2.a(localShareActionSheetV2, (ResultReceiver)paramBundle.getParcelable("receiver"));
    }
  }
  
  public static class Param
  {
    public boolean canceledOnTouchOutside = true;
    public Context context;
    public float dimAmount = 0.5F;
    public boolean flagNotTouchModal;
    public boolean fullScreen;
    public ViewGroup.LayoutParams lp;
    public int reportDataR2;
  }
  
  public static class a
    extends BaseAdapter
  {
    private int OE;
    private a a;
    private ShareActionSheetV2 b;
    private LayoutInflater inflater;
    private List<ShareActionSheetBuilder.ActionSheetItem> items;
    private Resources mRes;
    
    public a(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList, ShareActionSheetV2 paramShareActionSheetV2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheetV2", 2, "ActionSheetItemAdapter() called with: context = [" + paramContext + "], objects = [" + paramList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
      }
      this.items = paramList;
      this.inflater = LayoutInflater.from(paramContext);
      this.b = paramShareActionSheetV2;
    }
    
    private static void a(int paramInt, String paramString, ImageView paramImageView, ShareActionSheetBuilder.b paramb, a parama, ShareActionSheetV2 paramShareActionSheetV2)
    {
      if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
        return;
      }
      switch (paramInt)
      {
      case 6000: 
      default: 
        paramInt = -1;
      }
      while (paramInt != -1)
      {
        if (ShareActionSheetV2.a(paramShareActionSheetV2) == null) {
          ShareActionSheetV2.a(paramShareActionSheetV2, new SparseArray());
        }
        aduk localaduk = (aduk)ShareActionSheetV2.a(paramShareActionSheetV2).get(paramInt);
        parama = localaduk;
        if (localaduk == null)
        {
          parama = new aduk(paramShareActionSheetV2.V, paramInt);
          parama.j((byte)1);
          parama.init();
          ShareActionSheetV2.a(paramShareActionSheetV2).put(paramInt, parama);
        }
        paramImageView.setTag(paramString);
        parama.a(ShareActionSheetV2.a(paramShareActionSheetV2));
        paramString = parama.getFaceBitmap(paramString, true);
        if (paramString == null) {
          break;
        }
        paramb.b.iconDrawable = new BitmapDrawable(paramString);
        b(paramb);
        return;
        paramInt = 1;
        continue;
        if ((!TextUtils.isEmpty(paramb.b.argus)) && (paramb.b.argus.contains("isNewTroop=1")))
        {
          paramInt = 113;
          continue;
          paramInt = 101;
        }
        else
        {
          paramInt = 4;
        }
      }
    }
    
    private void a(ShareActionSheetBuilder.b paramb)
    {
      if (paramb.b.action == 72) {
        a(paramb.b.uinType, paramb.b.uin, paramb.vIcon, paramb, this, this.b);
      }
    }
    
    private static void b(ShareActionSheetBuilder.b paramb)
    {
      if (paramb.b.iconDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          paramb.vIcon.setBackground(paramb.b.iconDrawable);
          return;
        }
        paramb.vIcon.setBackgroundDrawable(paramb.b.iconDrawable);
        return;
      }
      paramb.vIcon.setBackgroundResource(paramb.b.icon);
    }
    
    public ShareActionSheetBuilder.ActionSheetItem c(int paramInt)
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.items == null) || (paramInt < 0))
      {
        localActionSheetItem = null;
        return localActionSheetItem;
      }
      int j = -1;
      int i = 0;
      for (;;)
      {
        if (i >= this.items.size()) {
          break label89;
        }
        localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.items.get(i);
        int k = j;
        if (localActionSheetItem != null)
        {
          k = j;
          if (localActionSheetItem.visibility == 0) {
            k = j + 1;
          }
        }
        if (k == paramInt) {
          break;
        }
        i += 1;
        j = k;
      }
      label89:
      return null;
    }
    
    public int getCount()
    {
      if (this.items == null) {
        return 0;
      }
      Iterator localIterator = this.items.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
        if ((localActionSheetItem == null) || (localActionSheetItem.visibility != 0)) {
          break label60;
        }
        i += 1;
      }
      label60:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      if (this.mRes == null) {
        this.mRes = paramViewGroup.getContext().getResources();
      }
      if (this.OE == 0) {
        this.OE = ((int)this.mRes.getDimension(2131296957));
      }
      if (this.a == null) {
        this.a = new a(paramViewGroup.getContext());
      }
      View localView;
      if (paramView == null)
      {
        localView = this.inflater.inflate(2131559035, paramViewGroup, false);
        paramView = new ShareActionSheetBuilder.b();
        paramView.vIcon = ((ImageView)localView.findViewById(2131378172));
        paramView.vLabel = ((TextView)localView.findViewById(2131378173));
        localView.setTag(paramView);
      }
      for (;;)
      {
        paramView.b = c(paramInt);
        if (paramView.b != null) {
          break;
        }
        QLog.e("ShareActionSheetV2", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (ShareActionSheetBuilder.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
      localView.setId(paramView.b.id);
      float f = this.mRes.getDimension(2131296957);
      paramView.vLabel.getPaint().setTextSize(this.mRes.getDimensionPixelSize(2131299552));
      paramView.vLabel.setMaxWidth((int)f);
      paramView.vLabel.setText(paramView.b.label);
      int i = -8947849;
      Object localObject = paramView.vLabel;
      if (paramView.b.enable)
      {
        label299:
        ((TextView)localObject).setTextColor(i);
        if (!paramView.b.iconNeedBg) {
          break label537;
        }
        if (paramView.b.iconDrawable == null) {
          break label478;
        }
        localObject = paramView.b.iconDrawable;
        label335:
        i = ((Drawable)localObject).getIntrinsicWidth();
        int k = ((Drawable)localObject).getIntrinsicHeight();
        if (this.OE <= i) {
          break label497;
        }
        i = (int)((this.OE - i) / 2.0F);
        label371:
        if (this.OE > k) {
          j = (int)((this.OE - k) / 2.0F);
        }
        localObject = this.a.a((Drawable)localObject, i, j);
        if (!paramView.b.enable) {
          break label503;
        }
        Drawable localDrawable = a.a(this.a, (Drawable)localObject);
        localObject = this.a.a((Drawable)localObject, localDrawable);
        paramView.vIcon.setImageDrawable((Drawable)localObject);
        label451:
        if (Build.VERSION.SDK_INT < 16) {
          break label526;
        }
        paramView.vIcon.setBackground(null);
      }
      for (;;)
      {
        break;
        i = 2138535799;
        break label299;
        label478:
        localObject = this.mRes.getDrawable(paramView.b.icon);
        break label335;
        label497:
        i = 0;
        break label371;
        label503:
        localObject = a.b(this.a, (Drawable)localObject);
        paramView.vIcon.setImageDrawable((Drawable)localObject);
        break label451;
        label526:
        paramView.vIcon.setBackgroundDrawable(null);
      }
      label537:
      if ((paramView.b.action == 72) || (paramView.b.action == 73)) {
        paramView.vIcon.setImageResource(2130837638);
      }
      for (;;)
      {
        b(paramView);
        a(paramView);
        break;
        paramView.vIcon.setImageResource(2130837636);
      }
    }
    
    static class a
    {
      private final Drawable cy;
      private final Drawable cz;
      
      a(Context paramContext)
      {
        paramContext = paramContext.getResources();
        int i = 2130837635;
        if (auvj.isNightMode()) {
          i = 2130837634;
        }
        this.cy = paramContext.getDrawable(i);
        this.cz = paramContext.getDrawable(2130837639);
      }
      
      private Drawable A(Drawable paramDrawable)
      {
        return new LayerDrawable(new Drawable[] { paramDrawable, this.cz });
      }
      
      private Drawable B(Drawable paramDrawable)
      {
        paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
        paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
        return paramDrawable;
      }
      
      Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
      {
        paramDrawable = new LayerDrawable(new Drawable[] { this.cy, paramDrawable });
        paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
        return paramDrawable;
      }
      
      StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
      {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
        localStateListDrawable.addState(new int[0], paramDrawable1);
        return localStateListDrawable;
      }
    }
  }
  
  public static class b
  {
    private View Gu;
    private ViewGroup ew;
    
    private void R(ViewGroup paramViewGroup)
    {
      if (paramViewGroup != null) {
        paramViewGroup.removeAllViews();
      }
    }
    
    private void bind()
    {
      if ((this.ew != null) && (this.Gu != null)) {
        this.ew.addView(this.Gu);
      }
    }
    
    private void is(View paramView)
    {
      if (paramView != null)
      {
        paramView = paramView.getParent();
        if ((paramView != null) && ((paramView instanceof ViewGroup))) {
          R((ViewGroup)paramView);
        }
      }
    }
    
    public void B(RelativeLayout paramRelativeLayout)
    {
      R(this.ew);
      R(paramRelativeLayout);
      this.ew = paramRelativeLayout;
      bind();
    }
    
    void b(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
    {
      is(this.Gu);
      is(paramView);
      if (paramView != null) {
        paramView.setLayoutParams(paramLayoutParams);
      }
      this.Gu = paramView;
      bind();
    }
    
    void setBgColor(int paramInt)
    {
      if (this.ew != null) {
        this.ew.setBackgroundColor(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2
 * JD-Core Version:    0.7.0.1
 */