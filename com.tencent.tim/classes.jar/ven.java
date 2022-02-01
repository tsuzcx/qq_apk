import com.tencent.mobileqq.activity.KPLProfileCardActivity;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.qphone.base.util.QLog;

public class ven
  extends accn
{
  public ven(KPLProfileCardActivity paramKPLProfileCardActivity) {}
  
  protected void onGetKplCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KPLProfileCardActivity", 2, "onGetKplCard, isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof KplCard)))
    {
      KPLProfileCardActivity.a(this.this$0, (KplCard)paramObject);
      this.this$0.a = ((KplCard)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ven
 * JD-Core Version:    0.7.0.1
 */