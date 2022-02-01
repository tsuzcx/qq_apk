import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ampf
  extends amrc
{
  private ampw a;
  public String bQA;
  private boolean cDG;
  private boolean cDP;
  public boolean cDQ = true;
  public boolean cDR;
  private String moreText = acfp.m(2131707056);
  private String moreUrl;
  
  public ampf(ampw paramampw)
  {
    this.a = paramampw;
    this.bQA = paramampw.getGroupName();
    if (paramampw.eX() != null) {
      if (paramampw.eX().size() <= paramampw.Ex()) {
        break label70;
      }
    }
    for (;;)
    {
      this.cDP = bool;
      return;
      label70:
      bool = false;
    }
  }
  
  public ampf(ampw paramampw, String paramString, boolean paramBoolean)
  {
    this.a = paramampw;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.bQA = paramampw.getGroupName();; this.bQA = paramString)
    {
      this.cDP = paramBoolean;
      return;
    }
  }
  
  public ampf(ampw paramampw, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramampw;
    this.bQA = paramampw.getGroupName();
    this.cDP = paramBoolean1;
    this.cDG = paramBoolean2;
  }
  
  public ampf(String paramString1, String paramString2, String paramString3)
  {
    this.bQA = paramString1;
    this.moreText = paramString2;
    this.moreUrl = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.moreText = acfp.m(2131707061);
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      this.cDP = bool;
      return;
      bool = false;
    }
  }
  
  public int Ex()
  {
    return 3;
  }
  
  public ampw a()
  {
    return this.a;
  }
  
  public boolean awe()
  {
    return this.cDP;
  }
  
  public boolean awf()
  {
    return this.cDG;
  }
  
  public List<ampx> eX()
  {
    return null;
  }
  
  public void gJ(View paramView)
  {
    Context localContext = paramView.getContext();
    amkf localamkf;
    Object localObject1;
    if ((localContext instanceof amkf))
    {
      localamkf = (amkf)localContext;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    switch (localamkf.IQ())
    {
    default: 
      if (this.a != null) {
        this.a.gJ(paramView);
      }
      break;
    }
    label144:
    label421:
    while (!this.cDP)
    {
      for (;;)
      {
        return;
        int i;
        Object localObject2;
        if (((this.a instanceof amov)) && (amxk.cF(((amov)this.a).ajO)))
        {
          if ((TextUtils.isEmpty(this.moreUrl)) || ((!this.moreUrl.startsWith("http://")) && (!this.moreUrl.startsWith("https://"))))
          {
            i = 1;
            localObject2 = localamkf.vo();
            String str = "" + gP();
            if (i == 0) {
              break label421;
            }
            localObject1 = "1";
            amxk.b("all_result", "more_object", new String[] { localObject2, str, localObject1 });
          }
        }
        else if (!amkl.cDb) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", amub.zn());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          amub.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(gP() + "").ver1(localamkf.vo()).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + amkl.ajN));
          amxk.b("all_result", "clk_tab_more", new String[] { getKeyword(), amxk.c(localamkf.m()), "", amxk.a("dynamic_unite_search.1", localamkf.m()) });
          break;
          i = 0;
          break label144;
          localObject1 = "0";
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, "e = " + localJSONException);
          }
          amxk.b("sub_result", "more_result", new String[] { localamkf.vo(), "" + localamkf.m(), "" + bW(1), amxk.a("dynamic_tab_search.1", localamkf.m()) });
        }
      }
      break;
    }
    localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(this.moreUrl)));
  }
  
  public long gP()
  {
    if (this.a != null)
    {
      int i = amkl.a(this.a);
      if (i > 0) {
        return i;
      }
    }
    if ((this.a != null) && ((this.a instanceof amov))) {
      return ((amov)this.a).ajO;
    }
    return -1L;
  }
  
  public String getGroupName()
  {
    return this.bQA;
  }
  
  public int getGroupType()
  {
    if ((this.a instanceof amov))
    {
      if (amxk.cF(((amov)this.a).ajO)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String getKeyword()
  {
    if (this.a != null) {
      return this.a.getKeyword();
    }
    return null;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.cDQ = paramBoolean;
  }
  
  public String ze()
  {
    if (this.moreText == null) {
      return "";
    }
    return this.moreText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampf
 * JD-Core Version:    0.7.0.1
 */