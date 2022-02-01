import android.content.Intent;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import java.util.List;

public class aifk
  extends aclp
{
  public aifk(ShareToQQActivity paramShareToQQActivity) {}
  
  protected void t(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.e == null)
    {
      this.a.finish();
      return;
    }
    String str = this.a.e.uin;
    if (ProfileActivity.AllInOne.i(this.a.e)) {
      str = this.a.oP();
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
      if (k != 0)
      {
        paramList = new Intent();
        paramList.putExtra("isSuccess", paramBoolean);
        paramList.putExtra("isCancelShield", false);
        this.a.setResult(-1, paramList);
      }
      this.a.finish();
      return;
    }
  }
  
  protected void u(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    if (this.a.e == null)
    {
      this.a.finish();
      return;
    }
    String str = this.a.e.uin;
    if (ProfileActivity.AllInOne.i(this.a.e)) {
      str = this.a.oP();
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
      if (k != 0)
      {
        paramList = new Intent();
        paramList.putExtra("isSuccess", paramBoolean);
        paramList.putExtra("isCancelShield", true);
        this.a.setResult(-1, paramList);
      }
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aifk
 * JD-Core Version:    0.7.0.1
 */