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

public class tro
  extends ydp<TaskCenterReader.TaskRecord>
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130843639, 2130843640, 2130843641, 2130843642, 2130843643, 2130843644, 2130843645, 2130843646, 2130843647, 2130843648 };
  
  public tro(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RelativeLayout a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(a()).inflate(2131560580, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369679));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378769));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new trp(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(60.0F)));
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      a(a(), ImmersiveUtils.a(60.0F));
    }
  }
  
  public void a(yeb paramyeb)
  {
    if (paramyeb.d())
    {
      paramyeb = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramyeb.setEnableCache(true);
      VSNetworkHelper.a().a(paramyeb, new trq(this));
    }
  }
  
  public int getItemCount()
  {
    return c();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!bhns.a(paramInt, b())) {
      ((QCircleTaskItemView)paramViewHolder.itemView).setData(b().get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ydo(this, new QCircleTaskItemView(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tro
 * JD-Core Version:    0.7.0.1
 */