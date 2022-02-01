import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class uyp
  extends uzx
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private QCirclePersonalBottomView jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView;
  private vuf jdField_a_of_type_Vuf;
  
  public uyp(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Vuf = ((vuf)getViewModel(vuf.class));
    this.jdField_a_of_type_Vuf.a().observe((QCircleBaseFragment)getParentFragment(), new uyq(this));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView.b();
    }
    return -1;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zxu paramzxu)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView = new QCirclePersonalBottomView(paramViewGroup.getContext(), paramzxu);
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
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = paramQCircleInitBean;
  }
  
  public void loadData(zxz paramzxz) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyp
 * JD-Core Version:    0.7.0.1
 */