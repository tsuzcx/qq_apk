import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountHandler.5.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import mqq.os.MqqHandler;

public class acjc
  extends SosoInterface.a
{
  public acjc(PublicAccountHandler paramPublicAccountHandler, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, int paramInt2)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramInt = (int)(paramSosoLbsInfo.a.cd * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.a.ce * 1000000.0D);
      this.this$0.J(this.val$type, paramInt, i, 0);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new PublicAccountHandler.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acjc
 * JD-Core Version:    0.7.0.1
 */