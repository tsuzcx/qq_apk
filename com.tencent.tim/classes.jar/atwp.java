import android.view.View;
import com.tencent.mobileqq.search.activity.AIOTransferFileSearchActivity;
import java.util.List;

public class atwp
  implements ampw
{
  List<ampx> Bu;
  int fromType;
  String keyword;
  
  public atwp(List<ampx> paramList, String paramString, int paramInt)
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
    amxk.a(this.keyword, 100, 0, paramView);
    int i = 45;
    switch (this.fromType)
    {
    }
    for (;;)
    {
      AIOTransferFileSearchActivity.a(paramView.getContext(), this.keyword, this.Bu, i);
      return;
      i = 46;
      continue;
      i = 47;
      continue;
      i = 48;
    }
  }
  
  public String getGroupName()
  {
    return "收发的文件";
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwp
 * JD-Core Version:    0.7.0.1
 */