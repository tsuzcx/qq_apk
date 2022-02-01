import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class vaa
  extends vbn
{
  private QCirclePersonalBottomView jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean;
  private vxe jdField_a_of_type_Vxe;
  
  public vaa(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Vxe = ((vxe)getViewModel(vxe.class));
    this.jdField_a_of_type_Vxe.d().observe((QCircleBaseFragment)getParentFragment(), new vab(this));
    this.jdField_a_of_type_Vxe.a().observe((QCircleBaseFragment)getParentFragment(), new vac(this));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView.b();
    }
    return -1;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView = new QCirclePersonalBottomView(paramViewGroup.getContext(), paramaabp);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView.setReportBean(a());
    a();
    return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView;
  }
  
  protected String a()
  {
    return "QCirclePersonalBottomBlock";
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean = paramQCircleInitBean;
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vaa
 * JD-Core Version:    0.7.0.1
 */