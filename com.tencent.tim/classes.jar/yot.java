import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class yot
  implements yql.a
{
  public yot(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void xP(String paramString)
  {
    this.a.bnS = true;
    this.a.searchType = 80000001;
    if (!TextUtils.isEmpty(paramString))
    {
      anot.a(this.a.app, "dc00899", "add_page", "", "search_grp", "clk_history", 0, 0, "", "", paramString, "");
      this.a.bc(paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yot
 * JD-Core Version:    0.7.0.1
 */