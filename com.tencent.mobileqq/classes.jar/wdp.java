import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

@TargetApi(14)
public class wdp
  extends wdr
{
  public String a;
  public wdd a;
  public String b;
  
  public wdp(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Wdd = new wdd();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private void c()
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new wdq(this);
    localTransferRequest.mLocalPath = this.b;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 196609;
    QQStoryContext.a();
    localTransferRequest.mSelfUin = QQStoryContext.a().getCurrentUin();
    localTransferRequest.mPeerUin = "";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().getTransFileController().transferAsync(localTransferRequest);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.b)) || (!zeb.c(this.b)))
    {
      Object localObject = ((wde)wjs.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((wdh)localObject).a.isSuccess())
      {
        this.b = ((wdh)localObject).b;
        if ((TextUtils.isEmpty(this.b)) || (!zeb.c(this.b)))
        {
          ykq.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.b });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.b }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((wdh)localObject).a.extraMsg = "composite";
        super.notifyResult(((wdh)localObject).a);
        return;
      }
    }
    wcz.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdp
 * JD-Core Version:    0.7.0.1
 */