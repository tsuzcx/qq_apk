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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class trm
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tro jdField_a_of_type_Tro;
  private trp jdField_a_of_type_Trp;
  private LinearLayout b;
  
  public trm(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755339);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131560202);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370442));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370453));
    this.jdField_a_of_type_Trp = new trp(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Trp);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new trn(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370453));
    this.b = ((LinearLayout)findViewById(2131370459));
    this.b.setOnClickListener(this);
    uad.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, agej.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    uad.a(this.jdField_a_of_type_AndroidWidgetListView, agej.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, tro paramtro, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Tro = paramtro;
    this.jdField_a_of_type_Trp.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        paramtro = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(paramtro.t)) && (paramtro.t.equals(paramString))) {
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
 * Qualified Name:     trm
 * JD-Core Version:    0.7.0.1
 */