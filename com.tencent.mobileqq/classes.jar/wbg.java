import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;

class wbg
  implements wbj
{
  protected INetEngine.IBreakDownFix a;
  
  private wbg(wbb paramwbb)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new wbi(this);
  }
  
  protected INetEngine a()
  {
    AppInterface localAppInterface = bogd.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(wbk paramwbk)
  {
    paramwbk.jdField_d_of_type_Int = 0;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramwbk.jdField_d_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramwbk.e;
    localHttpNetReq.mTempPath = paramwbk.f;
    localHttpNetReq.mPrioty = paramwbk.g;
    localHttpNetReq.mContinuErrorLimit = 3;
    localHttpNetReq.setUserData(paramwbk);
    localHttpNetReq.mBreakDownFix = this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    paramwbk.a = localHttpNetReq;
    localHttpNetReq.mCallback = new wbh(this);
    INetEngine localINetEngine = a();
    if (localINetEngine != null) {
      localINetEngine.sendReq(localHttpNetReq);
    }
    ykq.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramwbk);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(wbk paramwbk)
  {
    HttpNetReq localHttpNetReq = paramwbk.a;
    if (localHttpNetReq != null)
    {
      INetEngine localINetEngine = a();
      if (localINetEngine != null) {
        localINetEngine.cancelReq(localHttpNetReq);
      }
      ykq.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramwbk }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbg
 * JD-Core Version:    0.7.0.1
 */