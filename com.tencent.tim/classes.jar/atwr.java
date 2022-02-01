import android.view.View;
import com.tencent.mobileqq.search.activity.FoldersSearchActivity;
import java.util.List;

public class atwr
  implements ampw
{
  List<ampx> Bu;
  String keyword;
  
  public atwr(List<ampx> paramList, String paramString)
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
    FoldersSearchActivity.d(paramView.getContext(), this.keyword, this.Bu);
  }
  
  public String getGroupName()
  {
    return "文件夹";
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwr
 * JD-Core Version:    0.7.0.1
 */