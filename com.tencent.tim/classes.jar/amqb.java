import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.activity.MessageSearchDetailActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class amqb
  extends ampy
{
  private QQAppInterface app;
  private FullMessageSearchResult.SearchResultItem b;
  private String cbb;
  private CharSequence description;
  private String keyword;
  private CharSequence title;
  
  public amqb(QQAppInterface paramQQAppInterface, String paramString, FullMessageSearchResult.SearchResultItem paramSearchResultItem)
  {
    this.app = paramQQAppInterface;
    this.keyword = paramString;
    this.b = paramSearchResultItem;
    int i;
    if (paramSearchResultItem.user.getType() == 3000)
    {
      i = ((acdu)paramQQAppInterface.getManager(53)).cn(paramSearchResultItem.user.uin);
      if (i <= 0) {
        this.cbb = "";
      }
    }
    else
    {
      return;
    }
    this.cbb = String.valueOf(i);
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    amkl.a locala;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (amkl.mT.containsKey(this)))
    {
      locala = (amkl.a)amkl.mT.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", locala.index);
      localJSONObject.put("get_src", "native");
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(locala.ajO + "").obj2(locala.caE).ver1(locala.key).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
      if (this.b.secondPageMessageUniseq.size() == 1)
      {
        aalb.bwg = true;
        aalb.r = (MessageRecord)this.b.secondPageList.get(0);
        aalb.a(paramView.getContext(), this.app, this.b.user.uin, this.b.user.getType(), aqgv.d(this.app, this.b.user.uin, this.b.user.getType()), false);
        aclj.Q(this.app, this.keyword);
        amxk.a(this.keyword, 40, paramView, false);
        amxk.a(this.keyword, 40, 0, paramView);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MessageSearchResultModel", 2, "e = " + localJSONException);
        continue;
        MessageSearchDetailActivity.a(paramView.getContext(), getKeyword(), this.b);
      }
    }
  }
  
  public CharSequence f()
  {
    if ((this.b.user.getType() == 3000) && (!TextUtils.isEmpty(this.cbb))) {
      return amxk.d(this.cbb);
    }
    return "";
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    int i;
    if (this.description == null)
    {
      i = this.b.secondPageMessageUniseq.size();
      if (i != 1) {
        break label60;
      }
    }
    label60:
    SpannableStringBuilder localSpannableStringBuilder;
    for (this.description = amxk.a(((MessageRecord)this.b.secondPageList.get(0)).msg, this.keyword);; this.description = localSpannableStringBuilder)
    {
      return this.description;
      localSpannableStringBuilder = new SpannableStringBuilder(i + acfp.m(2131708240) + "\"");
      localSpannableStringBuilder.append(amxk.a(this.keyword, this.keyword));
      localSpannableStringBuilder.append("\"").append("相关记录");
    }
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    if (this.title == null) {
      this.title = aqgv.d(this.app, this.b.user.uin, this.b.user.getType());
    }
    return this.title;
  }
  
  public String getUin()
  {
    return this.b.user.uin;
  }
  
  public int pG()
  {
    switch (this.b.user.getType())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("MessageSearchResultModel", 2, "Face type is illegal. type = " + this.b.user.getType());
      }
    case 0: 
      return 1;
    case 1: 
      return 4;
    }
    return 101;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqb
 * JD-Core Version:    0.7.0.1
 */