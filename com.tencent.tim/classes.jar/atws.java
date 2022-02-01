import android.view.View;
import com.tencent.mobileqq.search.activity.OnlineFilesSearchActivity;
import java.util.List;

public class atws
  implements ampw
{
  List<ampx> Bu;
  String keyword;
  
  public atws(List<ampx> paramList, String paramString)
  {
    this.Bu = paramList;
    this.keyword = paramString;
  }
  
  public int Ex()
  {
    return 3;
  }
  
  public List<ampx> eX()
  {
    return this.Bu;
  }
  
  public void gJ(View paramView)
  {
    amxk.a(this.keyword, 100, 0, paramView);
    OnlineFilesSearchActivity.a(paramView.getContext(), this.keyword, this.Bu, 27);
  }
  
  public String getGroupName()
  {
    return "腾讯文档";
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atws
 * JD-Core Version:    0.7.0.1
 */