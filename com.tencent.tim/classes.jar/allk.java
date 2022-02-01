import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

class allk
  implements anlz
{
  allk(allj paramallj, LoadSoCallback paramLoadSoCallback) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "initSDKAsync, onLoadResult, resCode = " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Allj.cxB = true;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiLoadSoCallback.onLoad(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiLoadSoCallback.onLoad(false);
    this.jdField_a_of_type_Allj.cxB = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allk
 * JD-Core Version:    0.7.0.1
 */