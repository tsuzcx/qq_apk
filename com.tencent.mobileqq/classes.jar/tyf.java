import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class tyf
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tyh jdField_a_of_type_Tyh;
  private tyi jdField_a_of_type_Tyi;
  private LinearLayout b;
  
  public tyf(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755340);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131560209);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370410));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370421));
    this.jdField_a_of_type_Tyi = new tyi(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Tyi);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new tyg(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370421));
    this.b = ((LinearLayout)findViewById(2131370427));
    this.b.setOnClickListener(this);
    ugs.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, AIOUtils.dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    ugs.a(this.jdField_a_of_type_AndroidWidgetListView, AIOUtils.dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, tyh paramtyh, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Tyh = paramtyh;
    this.jdField_a_of_type_Tyi.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        paramtyh = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(paramtyh.t)) && (paramtyh.t.equals(paramString))) {
          this.jdField_a_of_type_Int = i;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */