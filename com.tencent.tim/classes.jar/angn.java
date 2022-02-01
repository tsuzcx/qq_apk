import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.d;

public final class angn
  implements aolm.b
{
  public angn(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, QQAppInterface paramQQAppInterface, ShortVideoResourceManager.d paramd) {}
  
  public void onResp(aomh paramaomh)
  {
    Object localObject = paramaomh.b;
    String str1 = ((aomg)localObject).atY;
    axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp] - BEGIN -, filePath=" + str1 + ", resp.mResult=" + paramaomh.mResult + ", mHttpCode=" + paramaomh.dPy + ", mErrCode=" + paramaomh.mErrCode + ", mErrDesc=" + paramaomh.clO);
    String str2 = (String)((aomg)localObject).U();
    int j;
    String str3;
    int i;
    if ((str2 != null) || ((angz.awV()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$SVConfigItem.check64BitReady())))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$SVConfigItem.arm64v8a_md5;
      j = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$SVConfigItem.versionCode;
      String str4 = ShortVideoResourceManager.zE();
      str3 = str4 + str2;
      if (paramaomh.mResult != 0) {
        break label519;
      }
      axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp], resp.mResult == NetResp.ResultOk");
      i = ShortVideoResourceManager.k(str2, (String)localObject, str1);
      axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp], verifyResource, keyName=" + str2 + ",errCode=" + i);
      if (i == 0) {
        break label408;
      }
      if (i == -108)
      {
        boolean bool = ShortVideoResourceManager.bB(str4 + str2 + "error", str1);
        axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp], renameResourceZip, success=" + bool);
      }
      ShortVideoResourceManager.access$600(str1);
      axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp], clearDownloadTempFile errCode=" + i);
      label315:
      angp.a(str2, j, 0, i);
    }
    for (;;)
    {
      axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp] - END -, errCode=" + i + ",saveFilePath=" + str3 + ",key=" + str2);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$d != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$d.Z(str2, i, str3);
      }
      axce.a().eIO();
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$SVConfigItem.armv7a_md5;
      break;
      label408:
      if (ShortVideoResourceManager.bB(str3, str1))
      {
        paramaomh = (String)localObject + '_' + j;
        i = ShortVideoResourceManager.b(this.val$app, str2, paramaomh, str3, j);
        axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp], signature=" + paramaomh + ", errCode=" + i + ", key=" + str2);
        break label315;
      }
      i = -3;
      ShortVideoResourceManager.access$600(str3);
      ShortVideoResourceManager.access$600(str1);
      break label315;
      label519:
      axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp], resp.mResult != NetResp.ResultOk");
      i = -117;
      angp.a(str2, j, 1, -117);
      ShortVideoResourceManager.access$600(str1);
      axiy.i("ShortVideoResourceManager", "[sendRequestWithoutLogin.onResp], filePath=" + str1 + ",resp.mResult=" + paramaomh.mResult + ",mErrDesc=" + paramaomh.clO + ",mErrDesc=" + paramaomh.clO);
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$d.s(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$SVConfigItem.name, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angn
 * JD-Core Version:    0.7.0.1
 */