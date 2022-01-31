import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleTaskItemView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import qqcircle.TaskCenterReader.TaskRecord;

public class trt
  extends yhy<TaskCenterReader.TaskRecord>
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130843689, 2130843690, 2130843691, 2130843692, 2130843693, 2130843694, 2130843695, 2130843696, 2130843697, 2130843698 };
  
  public trt(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RelativeLayout a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560597, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369698));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378824));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new tru(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(60.0F)));
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public int getItemCount()
  {
    return getDataNumber();
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(yii paramyii)
  {
    if (paramyii.d())
    {
      paramyii = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramyii.setEnableCache(true);
      VSNetworkHelper.a().a(getContext(), paramyii, new trv(this));
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!bhrz.a(paramInt, getDataList())) {
      ((QCircleTaskItemView)paramViewHolder.itemView).setData(getDataList().get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new yhx(this, new QCircleTaskItemView(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    setDatas(null);
  }
  
  public void onPrepareParams(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      addFixViewOccupySpaceAtTop(a(), ImmersiveUtils.a(60.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trt
 * JD-Core Version:    0.7.0.1
 */