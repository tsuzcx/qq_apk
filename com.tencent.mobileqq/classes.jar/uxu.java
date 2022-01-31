import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

class uxu
  extends ampt
{
  uxu(uxt paramuxt, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    wxe.b("LbsManager", "onLocationFinish.");
    boolean bool;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      bool = true;
      if (!bool) {
        break label114;
      }
      this.a.b = uxs.a(paramSosoLbsInfo.a);
      wxe.a("LbsManager", "onLocationFinish success, [longitude=%s, latitude=%s]", Integer.valueOf(this.a.b.b), Integer.valueOf(this.a.b.a));
    }
    for (;;)
    {
      if (!uxt.a(this.a)) {
        this.a.a(bool, this.a.b);
      }
      this.a.a = false;
      return;
      bool = false;
      break;
      label114:
      wxe.d("LbsManager", "onLocationFinish errorCode = %d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxu
 * JD-Core Version:    0.7.0.1
 */