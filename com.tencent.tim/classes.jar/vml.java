import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import java.util.List;

public class vml
  extends aclp
{
  public vml(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void t(boolean paramBoolean, List<Long> paramList)
  {
    if (this.this$0.e == null) {
      return;
    }
    String str = this.this$0.e.uin;
    if (ProfileActivity.AllInOne.i(this.this$0.e)) {
      str = this.this$0.oP();
    }
    for (;;)
    {
      if (paramList == null) {}
      int k;
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        k = 0;
        while ((k == 0) && (j < i))
        {
          if (aqft.equalsWithNullCheck(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      this.this$0.aT(paramBoolean, false);
      return;
    }
  }
  
  protected void u(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    if (this.this$0.e == null) {
      return;
    }
    String str = this.this$0.e.uin;
    if (ProfileActivity.AllInOne.i(this.this$0.e)) {
      str = this.this$0.oP();
    }
    for (;;)
    {
      if (paramList == null) {}
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        while ((k == 0) && (j < i))
        {
          if (aqft.equalsWithNullCheck(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      this.this$0.aT(paramBoolean, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vml
 * JD-Core Version:    0.7.0.1
 */