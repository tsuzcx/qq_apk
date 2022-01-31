import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import qqcircle.QQCircleDitto.StItemContainer;

public class trj
  extends yei
{
  private QQCircleDitto.StItemContainer jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer;
  private tzb jdField_a_of_type_Tzb;
  
  public trj(Bundle paramBundle)
  {
    super(paramBundle);
    a(false);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, ydp paramydp)
  {
    return new QCirclePushRankTopView(paramViewGroup.getContext());
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(tzb paramtzb, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Tzb = paramtzb;
    this.jdField_a_of_type_Tzb.a().observe(paramLifecycleOwner, new trk(this));
  }
  
  public void a(yeb paramyeb) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((QCirclePushRankTopView)a()).setData(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trj
 * JD-Core Version:    0.7.0.1
 */