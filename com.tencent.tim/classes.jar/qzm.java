import android.os.Handler;
import android.text.TextUtils;

class qzm
  implements qxm.c<qxd.a>
{
  qzm(qzh paramqzh, String paramString) {}
  
  public void a(qxd.a parama)
  {
    if ((parama.b != null) && (TextUtils.equals(parama.b.feedId, this.dL)))
    {
      qzh.a(this.this$0).a = parama.b;
      qzh.a(this.this$0).sendMessage(qzh.a(this.this$0).obtainMessage(0, qzh.a(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzm
 * JD-Core Version:    0.7.0.1
 */