import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class amkn
  extends amjh<View>
{
  protected ImageView Ds;
  private TextView Ys;
  private TextView Yt;
  private TextView Yu;
  private TextView Yv;
  protected TextView Yx;
  protected abfx b;
  protected MeasureListView b;
  protected int fromType;
  public RelativeLayout lS;
  private QQAppInterface mApp;
  private Context mContext;
  protected View mRootView;
  
  public amkn(int paramInt)
  {
    super(paramInt);
    this.fromType = paramInt;
  }
  
  private void refreshData()
  {
    if (this.jdField_b_of_type_Abfx != null) {
      this.jdField_b_of_type_Abfx.refreshData();
    }
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mRootView = LayoutInflater.from(this.mContext).inflate(2131560003, null);
    this.mRootView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)this.mRootView.findViewById(2131368539));
    this.jdField_b_of_type_ComTencentMobileqqWidgetMeasureListView.setDivider(null);
    this.Yx = ((TextView)this.mRootView.findViewById(2131377830));
    this.lS = ((RelativeLayout)this.mRootView.findViewById(2131365707));
    this.Ds = ((ImageView)this.mRootView.findViewById(2131365708));
    paramViewGroup = new AbsListView.LayoutParams(-1, aqcx.dip2px(this.mContext, 7.0F));
    this.Ys = new TextView(this.mContext);
    this.Ys.setLayoutParams(paramViewGroup);
    paramViewGroup = (LinearLayout)LayoutInflater.from(this.mContext).inflate(2131563016, null);
    this.Yt = ((TextView)paramViewGroup.findViewById(2131363701));
    this.Yu = ((TextView)paramViewGroup.findViewById(2131363702));
    this.Yv = ((TextView)paramViewGroup.findViewById(2131363703));
    this.jdField_b_of_type_ComTencentMobileqqWidgetMeasureListView.addHeaderView(this.Ys);
    this.jdField_b_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(paramViewGroup);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    this.Ys.setBackgroundResource(2130851241);
    if (bool) {
      this.Ds.setImageResource(2130843170);
    }
    this.jdField_b_of_type_Abfx = new abfx(this.mContext, this.mApp, this.mRootView, this.fromType);
    this.jdField_b_of_type_ComTencentMobileqqWidgetMeasureListView.setOnTouchListener(new amko(this));
    this.lS.setOnClickListener(new amkp(this, paramContext, paramQQAppInterface));
    paramContext = ((aclk)this.mApp.getManager(299)).cD();
    if (!paramContext.isEmpty())
    {
      paramQQAppInterface = new StringBuilder("");
      int i = 0;
      if (i < paramContext.size())
      {
        if (i != paramContext.size() - 1) {
          paramQQAppInterface.append((String)paramContext.get(i)).append("::");
        }
        for (;;)
        {
          i += 1;
          break;
          paramQQAppInterface.append((String)paramContext.get(i));
        }
      }
      amub.a(null, new ReportModelDC02528().module("all_result").action("exp_search_his").ver2(amub.eZ(this.fromType)).ver4(paramQQAppInterface.toString()).ver7("{experiment_id:" + amub.cce + "}"));
    }
    return this.mRootView;
  }
  
  public void initData()
  {
    super.initData();
    this.jdField_b_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_b_of_type_Abfx);
    refreshData();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_b_of_type_Abfx != null) {
      this.jdField_b_of_type_Abfx = null;
    }
  }
  
  public void refresh()
  {
    refreshData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkn
 * JD-Core Version:    0.7.0.1
 */