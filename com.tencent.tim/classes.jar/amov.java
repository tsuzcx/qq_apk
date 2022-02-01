import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;

public class amov
  extends amrc
{
  public List<ampx> Bu;
  public List<String> FZ;
  public long ajO;
  String bTQ;
  public boolean cDF;
  public boolean cDG;
  public boolean cDH;
  public String cbj;
  public String cbk;
  String groupName;
  String moreUrl;
  private String searchKey;
  long totalCount;
  
  public amov() {}
  
  public amov(String paramString1, long paramLong1, String paramString2, List<ampx> paramList, long paramLong2, String paramString3, String paramString4, List<String> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString5, String paramString6)
  {
    this.searchKey = paramString1;
    this.ajO = paramLong1;
    this.groupName = paramString2;
    this.Bu = paramList;
    this.totalCount = paramLong2;
    this.moreUrl = paramString3;
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "GroupBaseNetSearchModel ,moreUrl = " + paramString3);
    }
    this.bTQ = paramString4;
    this.FZ = paramList1;
    this.cDF = paramBoolean1;
    this.cDG = paramBoolean2;
    this.cDH = paramBoolean3;
    this.cbk = paramString6;
    this.cbj = paramString5;
  }
  
  public int Ex()
  {
    return 1;
  }
  
  public int IV()
  {
    return (int)this.ajO;
  }
  
  public void Uz(int paramInt)
  {
    if ((this.ajO == 1002L) && (!this.moreUrl.isEmpty())) {
      this.moreUrl = (this.moreUrl + "&sourceext=" + paramInt);
    }
  }
  
  public List<ampx> eX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "getResultList." + this.Bu);
    }
    return this.Bu;
  }
  
  public void gJ(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "onMoreAction. searchKey=" + this.searchKey + " groupName=" + this.groupName + " groupMask=" + this.ajO);
    }
    if (this.ajO == 1002L) {
      amxg.C(this.Bu, this.searchKey);
    }
    if (this.ajO == 1701L)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("search_keyword", this.searchKey);
      ((Intent)localObject).putExtra("key_refer", 1005);
      PublicFragmentActivity.start(paramView.getContext(), (Intent)localObject, MiniAppSearchFragment.class);
    }
    do
    {
      return;
      ActiveEntitySearchActivity.cDf = true;
      if (TextUtils.isEmpty(this.moreUrl)) {
        break;
      }
      localObject = aqik.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.moreUrl);
      if (localObject != null)
      {
        ((aqhv)localObject).ace();
        return;
      }
    } while ((!this.moreUrl.startsWith("http://")) && (!this.moreUrl.startsWith("https://")));
    long l1 = Double.valueOf(NetSearchEngine.bo * 1000000.0D).longValue();
    long l2 = Double.valueOf(NetSearchEngine.bG * 1000000.0D).longValue();
    Object localObject = this.moreUrl + "&keyword=" + URLEncoder.encode(this.searchKey) + "&gpstype=1&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1);
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "onMoreAction,moreUrl = " + this.moreUrl + ",dstUrl = " + ahwx.encrypt((String)localObject));
      paramView = paramView.getContext();
      Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      paramView.startActivity(localIntent);
      return;
    }
    catch (XorCipherException localXorCipherException)
    {
      for (;;)
      {
        localXorCipherException.printStackTrace();
      }
    }
    ActiveEntitySearchActivity.a(paramView.getContext(), this.searchKey, this.groupName, new long[] { this.ajO });
  }
  
  public String getGroupName()
  {
    if (this.groupName == null) {
      return "";
    }
    return this.groupName;
  }
  
  public String getKeyword()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "getKeyword." + this.searchKey);
    }
    return this.searchKey;
  }
  
  public String ze()
  {
    if (this.bTQ == null) {
      return acfp.m(2131707028);
    }
    return this.bTQ;
  }
  
  public String zf()
  {
    if (this.moreUrl == null) {
      return "";
    }
    return this.moreUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amov
 * JD-Core Version:    0.7.0.1
 */