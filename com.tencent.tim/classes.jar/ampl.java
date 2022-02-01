import android.view.View;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import java.util.List;

public class ampl
  implements ampw
{
  public static final String cbs = acfp.m(2131707078);
  private List<ampx> Bu;
  private String keyword;
  
  public ampl(List<ampx> paramList, String paramString)
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
    amxk.a(this.keyword, 40, 0, paramView);
    MessageSearchActivity.launch(paramView.getContext(), this.keyword);
  }
  
  public String getGroupName()
  {
    return cbs;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampl
 * JD-Core Version:    0.7.0.1
 */