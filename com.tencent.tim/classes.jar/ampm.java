import android.view.View;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.util.List;

public class ampm
  implements ampw
{
  public List<ampx> Bu;
  protected int fromType;
  private String keyword;
  
  public ampm(List<ampx> paramList, String paramString, int paramInt)
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
    amub.a(null, 0, this.fromType, "0X8009D47", 0, 0, null, null);
    String str = amxk.hu("pages/search-results/search-results?mode=search&q=" + this.keyword);
    str = amxk.hu("https://m.q.qq.com/a/p/1108291530?via=2005_2&referer=2005&s=" + str);
    str = "mqqapi://microapp/open?url=" + str;
    MiniAppLauncher.startMiniApp(paramView.getContext(), str, 2005, null);
  }
  
  public String getGroupName()
  {
    return acfp.m(2131707076);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public int sZ()
  {
    return this.fromType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampm
 * JD-Core Version:    0.7.0.1
 */