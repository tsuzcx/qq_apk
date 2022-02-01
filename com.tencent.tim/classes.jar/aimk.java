import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.Iterator;
import java.util.List;

public class aimk
  implements aimi
{
  private aimo a = new aimk.a(null);
  private abew jdField_b_of_type_Abew;
  private aimj jdField_b_of_type_Aimj;
  private View sB;
  
  private void gS(View paramView)
  {
    View localView = paramView.findViewById(2131370331);
    localView.setBackgroundResource(2130851332);
    LebaRoundLayout localLebaRoundLayout = (LebaRoundLayout)localView.findViewById(2131377584);
    localLebaRoundLayout.mRadius = aqnm.dpToPx(16.0F);
    localLebaRoundLayout.setVisibility(8);
    localView.findViewById(2131366542).setBackgroundResource(2130851343);
    paramView.findViewById(2131379174).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131367158)).setVisibility(8);
  }
  
  private void gT(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131376042);
    aqnm.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839642);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = aqnm.dip2px(56.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LebaRoundLayout)paramView.findViewById(2131377582);
    ((LebaRoundLayout)localObject).mRadius = aqnm.dpToPx(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131370398);
    ((ImageView)localObject).setImageResource(2130846231);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = aqnm.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = aqnm.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = aqnm.dip2px(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131377382);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = aqnm.dip2px(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362981)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = aqnm.dip2px(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (aqnm.dip2px(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131370399)).getLayoutParams()).leftMargin = aqnm.dip2px(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131376249)).getLayoutParams()).leftMargin = aqnm.dip2px(14.0F);
  }
  
  private void gU(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131375019);
    aqnm.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839642);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    localObject = (LebaRoundLayout)paramView.findViewById(2131377582);
    ((LebaRoundLayout)localObject).mRadius = aqnm.dpToPx(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131370398);
    ((ImageView)localObject).setImageResource(2130846235);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = aqnm.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = aqnm.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = aqnm.dip2px(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131377382);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = aqnm.dip2px(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362981)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = aqnm.dip2px(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (aqnm.dip2px(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131375025)).getLayoutParams()).leftMargin = aqnm.dip2px(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131375026)).getLayoutParams()).leftMargin = aqnm.dip2px(14.0F);
  }
  
  public void a(zjo.a parama)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    QQAppInterface localQQAppInterface = parama.app;
    List localList = parama.qL;
    Context localContext = parama.context;
    FPSXListView localFPSXListView = parama.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = parama.rM;
    aimj localaimj = parama.jdField_a_of_type_Aimj;
    this.sB = parama.rM;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localaimj != null) {
      this.jdField_b_of_type_Aimj = localaimj;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130851241));
      }
      if (localView == null) {}
    }
    catch (Exception parama)
    {
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
        try
        {
          for (;;)
          {
            if (this.jdField_b_of_type_Abew == null)
            {
              this.jdField_b_of_type_Abew = new abew(localContext, localList, 2131559242, 2131559243, localQQAppInterface, localFPSXListView, new aiml(this));
              localFPSXListView.setAdapter(this.jdField_b_of_type_Abew);
            }
            this.jdField_b_of_type_Abew.bQ(localQQAppInterface);
            this.jdField_b_of_type_Abew.hN(localList);
            this.jdField_b_of_type_Abew.a(this.a);
            return;
            parama = parama;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", parama);
            continue;
            parama = parama;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", parama);
          }
        }
        catch (Exception parama)
        {
          for (;;)
          {
            QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", parama);
          }
        }
      }
    }
  }
  
  public void dsR() {}
  
  public void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_b_of_type_Abew != null) {
      this.jdField_b_of_type_Abew.e(paramInt1, paramBoolean, paramInt2);
    }
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_b_of_type_Abew != null) {
      this.jdField_b_of_type_Abew.notifyDataSetChanged();
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
    if (this.jdField_b_of_type_Abew != null) {
      this.jdField_b_of_type_Abew.onPostThemeChanged();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_b_of_type_Abew != null) {
      this.jdField_b_of_type_Abew.onResume();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public int yj()
  {
    if (this.a != null) {
      return this.a.yj();
    }
    return -1;
  }
  
  public int yk()
  {
    return 0;
  }
  
  static class a
    extends aimo
  {
    public BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
    {
      paramQQAppInterface = ((altq)paramQQAppInterface.getManager(36)).a(0, paramString);
      if ((RedTouch.c(paramQQAppInterface)) && (paramQQAppInterface.type.get() != 5) && (paramQQAppInterface.red_display_info.has()) && (paramQQAppInterface.red_display_info.get() != null) && (paramQQAppInterface.red_display_info.red_type_info.has()) && (paramQQAppInterface.red_display_info.red_type_info.get() != null))
      {
        paramString = paramQQAppInterface.red_display_info.red_type_info.get().iterator();
        while (paramString.hasNext())
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramString.next();
          if (localRedTypeInfo.red_type.get() == 11) {
            localRedTypeInfo.red_type.set(0);
          }
        }
      }
      return paramQQAppInterface;
    }
    
    public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
    {
      paramRedTouch.e(paramAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimk
 * JD-Core Version:    0.7.0.1
 */