import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment;
import java.util.List;

public class vgz
  extends ILoadPluginDelegate
{
  public vgz(QCirclePluginLoadingFragment paramQCirclePluginLoadingFragment, QCirclePluginInitBean paramQCirclePluginInitBean) {}
  
  public void onLoadingFailed(int paramInt, String paramString)
  {
    vho.a().b();
    QCircleInitInject.g().getPluginCallbacks().clear();
    if ((this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity() != null) && (!this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity().isFinishing()))
    {
      QCirclePluginLoadingFragment.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment).dismiss();
      this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity().finish();
    }
  }
  
  public void onLoadingSuccess()
  {
    vho.a().b();
    QCircleInitInject.g().getPluginCallbacks().clear();
    if ((this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity() != null) && (!this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity().isFinishing()))
    {
      vgn.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity(), this.jdField_a_of_type_ComTencentBizQcircleshadowLibQCirclePluginInitBean);
      QCirclePluginLoadingFragment.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment).dismiss();
      this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgz
 * JD-Core Version:    0.7.0.1
 */