import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import java.util.List;

public class aimm
  implements aimi
{
  public aers a;
  private aimo jdField_a_of_type_Aimo = new aimm.b(null);
  private aimy jdField_a_of_type_Aimy;
  private aimz jdField_a_of_type_Aimz;
  private FPSXListView b;
  private int ddM = 18;
  private int ddN = 0;
  private QQAppInterface mApp;
  private View sB;
  private List<aevs> un;
  private float wO;
  private float wP;
  
  private boolean a(ImageView paramImageView, Drawable paramDrawable, String paramString)
  {
    if (this.jdField_a_of_type_Aers == null) {
      this.jdField_a_of_type_Aers = aert.c();
    }
    if (!this.jdField_a_of_type_Aers.aht()) {
      return false;
    }
    try
    {
      int i = paramImageView.getResources().getIdentifier(paramString, "drawable", "com.tencent.mobileqq");
      if (!SkinEngine.getInstances().checkResExist(i))
      {
        paramDrawable.clearColorFilter();
        paramImageView.setImageDrawable(paramDrawable);
        paramImageView.setBackground(null);
        paramImageView.setPadding(0, 0, 0, 0);
        return false;
      }
      paramImageView.setBackground(paramImageView.getResources().getDrawable(i));
      paramDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
      paramString = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      i = paramString.width;
      int j = paramString.height;
      int k = ankt.dip2px(this.ddM);
      paramImageView.setPadding((i - k) / 2, (j - k) / 2, (i - k) / 2, (j - k) / 2);
      paramImageView.setImageDrawable(paramDrawable);
      paramImageView.invalidate();
      return true;
    }
    catch (Exception paramString)
    {
      paramImageView.setImageDrawable(paramDrawable);
    }
    return false;
  }
  
  private void dsS()
  {
    for (;;)
    {
      try
      {
        aekh localaekh = (aekh)aeif.a().o(614);
        if (localaekh == null)
        {
          QLog.i("Q.lebatab.LebaTabletController", 1, "configBean == null");
          return;
        }
        if (localaekh.style == 1)
        {
          i = 1;
          QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle " + i);
          if (i == this.ddN) {
            break;
          }
          this.ddN = i;
          if (this.sB == null) {
            break;
          }
          gT(this.sB);
          gU(this.sB);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle", localException);
        return;
      }
      int i = 0;
    }
  }
  
  private void gS(View paramView)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    int i;
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("2101".equals(localObject1)) || ("1103".equals(localObject1)) || ("2920".equals(localObject1)) || (anlm.pp((String)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label182;
      }
      localObject1 = paramView.findViewById(2131370331);
      aqnm.setViewBackground((View)localObject1, null);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131377584);
      ((LebaRoundLayout)localObject2).mRadius = aqnm.dpToPx(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131377585);
      if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
        break label171;
      }
      ((View)localObject2).setBackgroundResource(2130851219);
      label129:
      aqnm.setViewBackground(((View)localObject1).findViewById(2131366542), null);
    }
    for (;;)
    {
      paramView.findViewById(2131379174).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131367158)).setVisibility(0);
      return;
      i = 0;
      break;
      label171:
      ((View)localObject2).setBackgroundResource(2130851241);
      break label129;
      label182:
      localObject1 = paramView.findViewById(2131370331);
      ((View)localObject1).setBackgroundResource(2130851332);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131377584);
      ((LebaRoundLayout)localObject2).mRadius = aqnm.dpToPx(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131366542).setBackgroundResource(2130851343);
    }
  }
  
  private void gT(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131376042);
    aqnm.setViewBackground(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = aqnm.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = aqnm.dip2px(16.0F);
    if (this.ddN == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = aqnm.dip2px(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131377582);
      ((LebaRoundLayout)localObject).mRadius = aqnm.dpToPx(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131377577);
      if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
        break label325;
      }
      ((View)localObject).setBackgroundResource(2130841227);
    }
    for (;;)
    {
      localObject = (ImageView)localRelativeLayout.findViewById(2131370398);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = aqnm.dpToPx(32.0F);
      localLayoutParams.height = aqnm.dpToPx(32.0F);
      localLayoutParams.leftMargin = aqnm.dip2px(12.0F);
      a((ImageView)localObject, paramView.getResources().getDrawable(2130846245), "skin_leba_haoyoudongtai_bg");
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131377382);
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).width = aqnm.dip2px(19.0F);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362981)).getLayoutParams();
      paramView.width = aqnm.dip2px(9.0F);
      paramView.height = aqnm.dip2px(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131370399)).getLayoutParams()).leftMargin = aqnm.dip2px(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131376249)).getLayoutParams()).leftMargin = aqnm.dip2px(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = aqnm.dip2px(56.0F);
      break;
      label325:
      ((View)localObject).setBackgroundResource(2130839642);
    }
  }
  
  private void gU(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375019);
    aqnm.setViewBackground(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = aqnm.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = aqnm.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = aqnm.dip2px(12.0F);
    if (this.ddN == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = aqnm.dip2px(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131377582);
      ((LebaRoundLayout)localObject).mRadius = aqnm.dpToPx(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131377577);
      if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
        break label351;
      }
      ((View)localObject).setBackgroundResource(2130841227);
    }
    for (;;)
    {
      localObject = (ImageView)localRelativeLayout.findViewById(2131370398);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = aqnm.dpToPx(32.0F);
      localLayoutParams.height = aqnm.dpToPx(32.0F);
      localLayoutParams.leftMargin = aqnm.dip2px(12.0F);
      if (a((ImageView)localObject, paramView.getResources().getDrawable(2130846234), "skin_leba_xiaoshijie_bg")) {
        ((ImageView)localObject).setImageDrawable(paramView.getResources().getDrawable(2130846236));
      }
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131377382);
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).width = aqnm.dip2px(19.0F);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362981)).getLayoutParams();
      paramView.width = aqnm.dip2px(9.0F);
      paramView.height = aqnm.dip2px(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131375025)).getLayoutParams()).leftMargin = aqnm.dip2px(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131375026)).getLayoutParams()).leftMargin = aqnm.dip2px(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = aqnm.dip2px(56.0F);
      break;
      label351:
      ((View)localObject).setBackgroundResource(2130839642);
    }
  }
  
  public void a(zjo.a parama)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = parama.qL;
    FPSXListView localFPSXListView = parama.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = parama.rM;
    aimj localaimj = parama.jdField_a_of_type_Aimj;
    Context localContext = parama.context;
    this.mApp = parama.app;
    this.un = localList;
    this.b = localFPSXListView;
    this.sB = localView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaTabletController", 1, "initView lebaSV == null ");
      return;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() != null) {
        localFPSXListView.setOverscrollHeader(null);
      }
      dsS();
      if (localView != null) {}
      try
      {
        if (localFPSXListView.getHeaderViewsCount() <= 0) {
          localFPSXListView.addHeaderView(localView);
        }
        gS(localView);
        gT(localView);
        gU(localView);
      }
      catch (Exception parama)
      {
        for (;;)
        {
          label157:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", parama);
        }
      }
      try
      {
        parama = localFPSXListView.getAdapter();
        if ((parama == null) || (!(parama instanceof aimm.a))) {
          localFPSXListView.setAdapter(new aimm.a());
        }
      }
      catch (Exception parama)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", parama);
        break label157;
      }
      if (this.jdField_a_of_type_Aimz == null) {
        this.jdField_a_of_type_Aimz = new aimz(localContext);
      }
      if ((this.jdField_a_of_type_Aimz.mRootLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Aimz.mRootLayout = ((LinearLayout)localView.findViewById(2131379174));
      }
      this.jdField_a_of_type_Aimz.mApp = this.mApp;
      this.jdField_a_of_type_Aimz.jdField_a_of_type_Aimo = this.jdField_a_of_type_Aimo;
      this.jdField_a_of_type_Aimz.c = localaimj;
      this.jdField_a_of_type_Aimz.lf(this.un);
      if (this.jdField_a_of_type_Aimy == null) {
        this.jdField_a_of_type_Aimy = new aimy(localContext);
      }
      if ((this.jdField_a_of_type_Aimy.mRootLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Aimy.mRootLayout = ((FrameLayout)localView.findViewById(2131367158));
      }
      this.jdField_a_of_type_Aimy.notifyDataSetChanged();
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", parama);
      }
    }
  }
  
  public void dsR()
  {
    if (this.jdField_a_of_type_Aimy != null)
    {
      this.jdField_a_of_type_Aimy.dsU();
      this.jdField_a_of_type_Aimy.mRootLayout = null;
    }
    if (this.jdField_a_of_type_Aimz != null)
    {
      this.jdField_a_of_type_Aimz.dsU();
      this.jdField_a_of_type_Aimz.mRootLayout = null;
    }
  }
  
  public void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Aimz != null) {
      this.jdField_a_of_type_Aimz.a(this.wO, this.wP, this.b, this.sB, paramInt1, this.ddN, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Aimy != null) {
      this.jdField_a_of_type_Aimy.onPause();
    }
    if (this.jdField_a_of_type_Aimo != null) {
      this.jdField_a_of_type_Aimo.onPause();
    }
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_a_of_type_Aimy != null) {
      this.jdField_a_of_type_Aimy.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_Aimz != null) {
      this.jdField_a_of_type_Aimz.lf(this.un);
    }
  }
  
  public void onPostThemeChanged()
  {
    if (this.sB != null)
    {
      gS(this.sB);
      gT(this.sB);
      gU(this.sB);
    }
    notifyDataSetChanged();
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Aimy != null) {
      this.jdField_a_of_type_Aimy.notifyDataSetChanged();
    }
    if (this.sB != null)
    {
      this.wO = (-this.sB.getY());
      this.wP = this.wO;
    }
    dsS();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.sB != null)
    {
      float f = -this.sB.getY();
      if (f > this.wP) {
        this.wP = f;
      }
      if (f < this.wO) {
        this.wO = f;
      }
    }
  }
  
  public int yj()
  {
    if (this.jdField_a_of_type_Aimo != null) {
      return this.jdField_a_of_type_Aimo.yj();
    }
    return -1;
  }
  
  public int yk()
  {
    return this.ddN;
  }
  
  public static class a
    extends BaseAdapter
  {
    public int getCount()
    {
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return null;
    }
  }
  
  static class b
    extends aimo
  {
    public BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
    {
      paramQQAppInterface = ((altq)paramQQAppInterface.getManager(36)).a(0, paramString);
      if ((RedTouch.c(paramQQAppInterface)) && (paramQQAppInterface.type.get() != 5)) {
        RedTouch.h(paramQQAppInterface);
      }
      return paramQQAppInterface;
    }
    
    public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
    {
      paramRedTouch.f(paramAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimm
 * JD-Core Version:    0.7.0.1
 */