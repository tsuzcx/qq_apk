import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.12.1;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class uvs
  extends accn
{
  public uvs(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (!this.this$0.aVP) {}
    do
    {
      return;
      this.this$0.aVP = false;
      this.this$0.runOnUiThread(new EditInfoActivity.12.1(this, paramBoolean, paramCard));
    } while (!QLog.isColorLevel());
    QLog.d("EditInfoActivity", 2, String.format("onGetDetailInfo, isSuccess: %s, resultCode:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvs
 * JD-Core Version:    0.7.0.1
 */