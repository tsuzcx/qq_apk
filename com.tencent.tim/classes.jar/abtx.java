import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class abtx
  implements abja
{
  abtx(abtv paramabtv, DisplayMetrics paramDisplayMetrics, abtv.b paramb) {}
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.this$0.bFr = true;
    float f = this.j.density;
    this.this$0.sJ = (paramInt1 / 2 / f);
    if ((this.this$0.g != null) && (this.this$0.a != null) && (abtv.a(this.this$0) != null))
    {
      this.this$0.g.onExecDispose();
      this.this$0.a.onExecDispose();
      Message localMessage = abtv.a(this.this$0).obtainMessage(19, this.b.actionType, this.b.crP);
      if (this.b.bFz) {
        localMessage.obj = Float.valueOf(this.b.sK);
      }
      abtv.a(this.this$0).sendMessageDelayed(localMessage, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtx
 * JD-Core Version:    0.7.0.1
 */