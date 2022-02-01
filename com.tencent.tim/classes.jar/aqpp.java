import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import java.util.Vector;

class aqpp
  extends VasQuickUpdateManager.CallBacker
{
  aqpp(aqpm paramaqpm) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if (paramLong == 27L)
    {
      paramInt2 = Integer.parseInt(paramString1.substring("groupnickitem.".length(), paramString1.length()));
      aqpm.a(this.this$0).removeElement(Integer.valueOf(paramInt2));
      if (paramInt1 == 0) {
        this.this$0.XJ(paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpp
 * JD-Core Version:    0.7.0.1
 */