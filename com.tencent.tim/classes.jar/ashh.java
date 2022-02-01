import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;

public class ashh
  extends jos
{
  public ashh(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    this.this$0.aAt();
    if ((paramBoolean) && (paramBmqqUserSimpleInfo != null)) {
      if (paramBmqqUserSimpleInfo.mBmqqUin.equals(this.this$0.a.e.uin)) {
        if (!paramBmqqUserSimpleInfo.equals(this.this$0.b))
        {
          i = 1;
          if (i == 0) {
            break label80;
          }
          this.this$0.b = paramBmqqUserSimpleInfo;
          this.this$0.Fo(0);
        }
      }
    }
    label80:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            int i = 0;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not change");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not current uin");
      return;
    }
    QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashh
 * JD-Core Version:    0.7.0.1
 */