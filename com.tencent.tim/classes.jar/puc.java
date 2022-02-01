import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;

class puc
  extends SosoInterface.a
{
  puc(pub parampub, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    ram.d("LbsManager", "onLocationFinish.");
    boolean bool;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      bool = true;
      if (!bool) {
        break label114;
      }
      this.this$0.b = pua.a(paramSosoLbsInfo.a);
      ram.b("LbsManager", "onLocationFinish success, [longitude=%s, latitude=%s]", Integer.valueOf(this.this$0.b.mLongitude), Integer.valueOf(this.this$0.b.mLatitude));
    }
    for (;;)
    {
      if (!pub.a(this.this$0)) {
        this.this$0.b(bool, this.this$0.b);
      }
      this.this$0.aBE = false;
      return;
      bool = false;
      break;
      label114:
      ram.w("LbsManager", "onLocationFinish errorCode = %d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puc
 * JD-Core Version:    0.7.0.1
 */