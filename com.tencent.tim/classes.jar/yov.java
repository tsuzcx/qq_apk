import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.activity.contact.addcontact.ViewFactory.GuideView.b;
import com.tencent.qphone.base.util.QLog;

public class yov
  implements ViewFactory.GuideView.b
{
  public yov(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void bj(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "guide view | onItemClick type is:" + paramInt + " keyWords is:" + paramString);
    }
    this.a.bnS = true;
    this.a.searchType = paramInt;
    if (paramInt == 80000001) {
      amxk.d("add_page", "search", "clk_search_grp", this.a.mFrom + 1, 0, new String[] { "", "", paramString, "" });
    }
    this.a.bc(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yov
 * JD-Core Version:    0.7.0.1
 */