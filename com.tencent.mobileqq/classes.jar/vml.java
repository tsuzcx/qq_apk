import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;

class vml
  implements vmo
{
  protected INetEngine.IBreakDownFix a;
  
  private vml(vmg paramvmg)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new vmn(this);
  }
  
  protected INetEngine a()
  {
    AppInterface localAppInterface = bmql.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(vmp paramvmp)
  {
    paramvmp.jdField_d_of_type_Int = 0;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramvmp.jdField_d_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramvmp.e;
    localHttpNetReq.mTempPath = paramvmp.f;
    localHttpNetReq.mPrioty = paramvmp.g;
    localHttpNetReq.mContinuErrorLimit = 3;
    localHttpNetReq.setUserData(paramvmp);
    localHttpNetReq.mBreakDownFix = this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    paramvmp.a = localHttpNetReq;
    localHttpNetReq.mCallback = new vmm(this);
    INetEngine localINetEngine = a();
    if (localINetEngine != null) {
      localINetEngine.sendReq(localHttpNetReq);
    }
    xvv.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramvmp);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(vmp paramvmp)
  {
    HttpNetReq localHttpNetReq = paramvmp.a;
    if (localHttpNetReq != null)
    {
      INetEngine localINetEngine = a();
      if (localINetEngine != null) {
        localINetEngine.cancelReq(localHttpNetReq);
      }
      xvv.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramvmp }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vml
 * JD-Core Version:    0.7.0.1
 */