import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;

class awez
  implements awal.a
{
  awez(awey paramawey) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 1;
    int j = paramBaseResp.errCode;
    if (j == 0)
    {
      i = 0;
      paramBaseResp = acfp.m(2131713380);
      awey.d(this.this$0, paramBaseResp);
    }
    for (;;)
    {
      awey.a(this.this$0, awey.a(this.this$0), i, paramBaseResp);
      return;
      if (j == -2)
      {
        paramBaseResp = acfp.m(2131713374);
        awey.d(this.this$0, paramBaseResp);
      }
      else
      {
        paramBaseResp = acfp.m(2131713372);
        QLog.e("QZoneSharePictureJsPlugin", 1, "wx share fail:" + j);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awez
 * JD-Core Version:    0.7.0.1
 */