import android.view.View;
import com.tencent.mobileqq.search.activity.AddFilesSearchActivity;
import java.util.List;

public class atwq
  implements ampw
{
  List<ampx> Bu;
  int fromType;
  String keyword;
  
  public atwq(List<ampx> paramList, String paramString, int paramInt)
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
    int i = 36;
    switch (this.fromType)
    {
    }
    for (;;)
    {
      AddFilesSearchActivity.a(paramView.getContext(), this.keyword, this.Bu, i, null);
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
    return "我添加的文件";
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwq
 * JD-Core Version:    0.7.0.1
 */