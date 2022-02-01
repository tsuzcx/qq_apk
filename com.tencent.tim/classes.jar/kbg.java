import com.tencent.biz.pubaccount.PublicAccountManager.4;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;

public class kbg
  extends SosoInterface.a
{
  public kbg(PublicAccountManager.4 param4, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, boolean paramBoolean5)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null)) {}
    try
    {
      if (paramSosoLbsInfo.a != null)
      {
        double d1 = paramSosoLbsInfo.a.cd;
        double d2 = paramSosoLbsInfo.a.ce;
        String str1 = "";
        if (paramSosoLbsInfo.a.address != null) {
          str1 = "" + paramSosoLbsInfo.a.address;
        }
        String str2 = str1;
        if (paramSosoLbsInfo.a.name != null) {
          str2 = str1 + paramSosoLbsInfo.a.name;
        }
        this.a.this$0.a(true, d1, d2, str2, null, this.val$key, this.ads);
      }
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
      this.a.this$0.a(false, 0.0D, 0.0D, null, null, this.val$key, this.ads);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbg
 * JD-Core Version:    0.7.0.1
 */