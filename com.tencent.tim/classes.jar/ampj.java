import android.view.View;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import java.util.List;

public class ampj
  implements ampw
{
  public List<ampx> Bu;
  private int fromType;
  private String keyword;
  
  public ampj(List<ampx> paramList, String paramString, int paramInt)
  {
    this.Bu = paramList;
    this.keyword = paramString;
    this.fromType = paramInt;
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
    ContactSearchActivity.a(paramView.getContext(), this.keyword, this.fromType, 197437, true);
    amxk.a(this.keyword, 20, 0, paramView);
  }
  
  public String getGroupName()
  {
    return acfp.m(2131707064);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampj
 * JD-Core Version:    0.7.0.1
 */