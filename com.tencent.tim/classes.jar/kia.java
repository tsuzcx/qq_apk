import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class kia
  extends lce
{
  public kia(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void cp(int paramInt1, int paramInt2)
  {
    if (ReadInJoyFeedsActivity.a(this.this$0) == 1)
    {
      ((KandianMergeManager)this.this$0.app.getManager(162)).qj(1);
      return;
    }
    ReadInJoyFeedsActivity.b(this.this$0, paramInt1);
    ((kfn)this.this$0.dI.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.this$0)))).aCb();
  }
  
  public void oU(int paramInt)
  {
    this.this$0.oP(paramInt);
  }
  
  public void oV(int paramInt)
  {
    ReadInJoyFeedsActivity.a(this.this$0, paramInt);
    if ((paramInt > 0) && (ReadInJoyFeedsActivity.a(this.this$0) == 0)) {
      ((kfn)this.this$0.dI.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.this$0)))).aCb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kia
 * JD-Core Version:    0.7.0.1
 */