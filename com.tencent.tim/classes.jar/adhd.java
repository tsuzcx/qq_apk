import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import mqq.app.QQPermissionCallback;

class adhd
  implements QQPermissionCallback
{
  adhd(adgy paramadgy) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new adhf();
    paramArrayOfString.retCode = 2;
    adhr.a(this.this$0.b.recognitions, adgy.a(this.this$0), paramArrayOfString);
    if (adgy.a(this.this$0) != null) {
      adgy.a(this.this$0).b(0, adgy.a(this.this$0));
    }
    adgy.a(this.this$0, null);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.this$0.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhd
 * JD-Core Version:    0.7.0.1
 */