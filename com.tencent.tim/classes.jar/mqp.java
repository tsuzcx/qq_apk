import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1;
import com.tencent.qphone.base.util.QLog;

public class mqp
  implements mqv.a
{
  public mqp(RIJUgcImageUploader.1 param1) {}
  
  public void L(float paramFloat)
  {
    mqo.a(this.a.this$0).N(paramFloat);
  }
  
  public void aDx() {}
  
  public void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i(mqo.TAG, 2, "uploadImage finish, url=" + paramString1);
    }
    mqo.a(this.a.this$0, false);
    if (paramInt == 0)
    {
      QLog.i(mqo.TAG, 1, "uploadImage success");
      mqo.a(this.a.this$0).onSuccess(paramString1);
    }
    for (;;)
    {
      mqo.a(this.a.this$0).onDestroy();
      return;
      QLog.i(mqo.TAG, 1, "uploadImage failed, errCode=" + paramInt);
      mqo.a(this.a.this$0).onFailed(paramInt, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqp
 * JD-Core Version:    0.7.0.1
 */