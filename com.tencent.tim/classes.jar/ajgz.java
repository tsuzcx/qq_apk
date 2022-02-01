import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class ajgz
  implements ajlm.a
{
  ajgz(ajgy paramajgy) {}
  
  public void cancel()
  {
    if ((ajgw.a(this.a.b) != null) && (ajgw.a(this.a.b).sessionInfo != null)) {
      this.a.d.d(this.a.qu, 2, ajgw.a(this.a.b).sessionInfo.cZ);
    }
    this.a.d.dyf();
    if (ajgw.a(this.a.b) != null) {
      ajgw.a(this.a.b).a(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgz
 * JD-Core Version:    0.7.0.1
 */