import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer.a;

public class athb
  extends CloudFileSendRecvSyncer.a
{
  long lastUpdateTime;
  
  public athb(CloudFileSendRecvActivity paramCloudFileSendRecvActivity) {}
  
  public void f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    if ((paramInt1 > 0) && ((paramInt6 != 0) || (paramInt3 > 0))) {
      CloudFileSendRecvActivity.a(this.this$0, false);
    }
    CloudFileSendRecvActivity.a(this.this$0).VN(true);
  }
  
  public void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.this$0.isFinishing()) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while ((paramInt2 <= 0) || (l - this.lastUpdateTime <= 3000L));
    if (this.lastUpdateTime != 0L) {
      CloudFileSendRecvActivity.a(this.this$0).VN(true);
    }
    this.lastUpdateTime = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     athb
 * JD-Core Version:    0.7.0.1
 */