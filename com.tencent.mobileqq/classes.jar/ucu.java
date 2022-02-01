import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.nativevue.NativeVuePreconditionAdapter.LoadSoResult;
import com.tencent.qphone.base.util.QLog;

public class ucu
  implements bdgc
{
  public ucu(NativeVueLoaderManager paramNativeVueLoaderManager, NativeVuePreconditionAdapter.LoadSoResult paramLoadSoResult) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentNativevueNativeVuePreconditionAdapter$LoadSoResult.onLoadSuccess();
      QLog.d("NativeVueLoaderManager", 1, "load NativeVue Success");
      return;
    }
    this.jdField_a_of_type_ComTencentNativevueNativeVuePreconditionAdapter$LoadSoResult.onLoadError();
    QLog.e("NativeVueLoaderManager", 1, "load NativeVue Error: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucu
 * JD-Core Version:    0.7.0.1
 */