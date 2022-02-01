import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class vlx
  extends akwl
{
  vlx(vlw paramvlw) {}
  
  protected void xM(boolean paramBoolean)
  {
    super.xM(paramBoolean);
    PhoneUnityChangeActivity.a(this.a.a.a);
    this.a.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      ((yuu)this.a.a.a.app.getManager(102)).bC(null);
      this.a.a.a.setResult(4001);
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlx
 * JD-Core Version:    0.7.0.1
 */