import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;

public class ampd
  implements ampw
{
  private List<ampx> Bu;
  private boolean cDO;
  private String searchKey;
  
  public ampd(yow paramyow, List<ampx> paramList, String paramString, boolean paramBoolean)
  {
    this.Bu = paramList;
    this.searchKey = paramString;
    this.cDO = paramBoolean;
  }
  
  public int Ex()
  {
    return 1;
  }
  
  public List<ampx> eX()
  {
    return this.Bu;
  }
  
  public void gJ(View paramView)
  {
    amxk.a(this.searchKey, 80, 0, paramView);
    new Intent().putExtra("last_key_words", this.searchKey);
    long l1 = Double.valueOf(NetSearchEngine.bo * 1000000.0D).longValue();
    long l2 = Double.valueOf(NetSearchEngine.bG * 1000000.0D).longValue();
    Object localObject2 = "https://qqweb.qq.com/m/relativegroup/index.html?source=qun_recent_search&keyword=" + URLEncoder.encode(this.searchKey) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1);
    Object localObject1 = localObject2;
    if (this.cDO) {
      localObject1 = (String)localObject2 + "&show_tab=hot";
    }
    if (QLog.isColorLevel()) {
      QLog.d("search", 2, "lastKeywords = " + this.searchKey + " jump url is : " + (String)localObject1);
    }
    localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("uin", ((BaseActivity)paramView.getContext()).app.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("isShowAd", false);
    paramView.getContext().startActivity((Intent)localObject2);
  }
  
  public String getGroupName()
  {
    return acfp.m(2131707033);
  }
  
  public String getKeyword()
  {
    return this.searchKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampd
 * JD-Core Version:    0.7.0.1
 */