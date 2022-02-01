import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class you
  implements yqp.b
{
  public you(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void xP(String paramString)
  {
    this.a.bnS = true;
    this.a.searchType = 80000001;
    if (!TextUtils.isEmpty(paramString))
    {
      anot.a(this.a.app, "dc00899", "add_page", "", "search_grp", "clk_label", 0, 0, "", "", paramString, "");
      this.a.bnT = false;
      this.a.bc(paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     you
 * JD-Core Version:    0.7.0.1
 */