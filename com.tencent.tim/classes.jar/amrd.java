import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class amrd
  extends ampy
{
  public int blx;
  public boolean cEe = true;
  public String cbY;
  public String cbZ;
  public String cca;
  public String ccb;
  public String ccc;
  public String ccd;
  public int dDC;
  public String iconUrl;
  public String jumpUrl;
  
  public amrd(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.cbY = paramString;
    this.blx = paramInt1;
    this.dDC = paramInt2;
    this.cEe = paramBoolean;
  }
  
  public amrd(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.cbY = paramString1;
    this.cbZ = paramString2;
    this.blx = paramInt;
    this.iconUrl = paramString3;
    dOq();
  }
  
  private void dOq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchResultModelForEntrance", 2, "extension info:" + this.cbZ);
    }
    if (!TextUtils.isEmpty(this.cbZ)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.cbZ);
      if (localJSONObject.getInt("hideArrow") == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cEe = bool;
        this.cca = localJSONObject.optString("title1");
        this.cbY = localJSONObject.optString("title2");
        this.ccb = localJSONObject.optString("title3");
        this.ccc = localJSONObject.optString("secondLine");
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public boolean DR()
  {
    return this.cEe;
  }
  
  public boolean awi()
  {
    return this.blx == -1;
  }
  
  public void cR(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (this.blx)
    {
    case -2: 
    default: 
      localObject1 = this.jumpUrl;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = aqik.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), (String)localObject1);
        if (localObject2 == null) {
          break label825;
        }
        ((aqhv)localObject2).ace();
      }
    case -1: 
      do
      {
        return;
        ActiveEntitySearchActivity.a(paramView.getContext(), this.cbY, acfp.m(2131714125), new long[] { 1001L, 1002L });
        amxk.b("all_result", "clk_people_group", new String[] { this.cbY });
        amxk.d("all_search", "all_result", "clk_user_grp", 0, 0, new String[] { "", "", this.cbY, "" });
      } while (!(paramView.getContext() instanceof UniteSearchActivity));
      if (amkl.mT.containsKey(this))
      {
        paramView = (amkl.a)amkl.mT.get(this);
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject2).put("project", amub.zn());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("obj_lct", paramView.index);
        ((JSONObject)localObject2).put("get_src", "native");
        amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.ajO + "").obj2(paramView.caE).ver1(paramView.key).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + amkl.ajN));
        amub.a(null, this.source, 0, "0X8009D3F", 0, 0, null, null);
        return;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, "e = " + localJSONException1);
        }
      }
    }
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      switch (((UniteSearchActivity)paramView.getContext()).source)
      {
      }
    }
    for (int i = 0;; i = 0)
    {
      for (;;)
      {
        if (TextUtils.isEmpty(this.jumpUrl))
        {
          localObject1 = amxh.k(this.cbY, i, "group");
          label480:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            ((Intent)localObject2).putExtra("search_title", this.cbY);
            paramView.getContext().startActivity((Intent)localObject2);
          }
          if (TextUtils.isEmpty(this.cbY)) {
            break label787;
          }
          localObject1 = this.cbY;
          amxk.b("all_result", "clk_net_search", new String[] { localObject1 });
          if ((!(paramView.getContext() instanceof UniteSearchActivity)) || (!amkl.mT.containsKey(this))) {
            break;
          }
          paramView = (amkl.a)amkl.mT.get(this);
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject2 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject2).put("project", amub.zn());
          ((JSONObject)localObject2).put("event_src", "client");
          ((JSONObject)localObject2).put("obj_lct", paramView.index);
          ((JSONObject)localObject2).put("get_src", "web");
          amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.ajO + "").obj2(paramView.caE).ver1(paramView.key).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + amkl.ajN));
          return;
          i = 1;
          continue;
          i = 2;
          continue;
          i = 3;
          continue;
          localObject1 = this.jumpUrl;
          break label480;
          label787:
          localObject1 = "";
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, "e = " + localJSONException2);
          }
        }
      }
      label825:
      if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://"))) {
        break;
      }
      paramView = paramView.getContext();
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      return;
    }
  }
  
  public CharSequence f()
  {
    return this.cbY;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    switch (this.blx)
    {
    case -3: 
    case -2: 
    default: 
      return "";
    case -1: 
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      return amkd.C(BaseApplicationImpl.getContext(), localQQAppInterface.getCurrentUin());
    }
    return this.ccc;
  }
  
  public String getKeyword()
  {
    return null;
  }
  
  public int getLayoutId()
  {
    switch (this.blx)
    {
    case -2: 
    case -1: 
    default: 
      return 2131560005;
    }
    return 2131559998;
  }
  
  public CharSequence getTitle()
  {
    switch (this.blx)
    {
    case -3: 
    case -2: 
    default: 
      return acfp.m(2131714140);
    case -4: 
      return this.cca;
    }
    return this.cbY;
  }
  
  public String getUin()
  {
    return null;
  }
  
  public int pG()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrd
 * JD-Core Version:    0.7.0.1
 */