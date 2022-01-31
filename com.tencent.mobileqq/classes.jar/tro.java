import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;

public class tro
  extends yiu
{
  private QQCircleDitto.StCircleDittoDataNew jdField_a_of_type_QqcircleQQCircleDitto$StCircleDittoDataNew;
  private ubm jdField_a_of_type_Ubm;
  
  public tro(Bundle paramBundle)
  {
    super(paramBundle);
    a(false);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, yhy paramyhy)
  {
    return new QCirclePushRankTopView(paramViewGroup.getContext());
  }
  
  public void a(ubm paramubm, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Ubm = paramubm;
    this.jdField_a_of_type_Ubm.a().observe(paramLifecycleOwner, new trp(this));
  }
  
  public void loadData(yii paramyii) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((QCirclePushRankTopView)a()).setData(this.jdField_a_of_type_QqcircleQQCircleDitto$StCircleDittoDataNew);
  }
  
  public void onPrepareParams(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tro
 * JD-Core Version:    0.7.0.1
 */