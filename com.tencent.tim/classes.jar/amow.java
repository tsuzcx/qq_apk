import NearbyGroup.GroupLabel;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amow
  extends ampy
{
  public List<String> FZ;
  public int age;
  protected CharSequence aj;
  protected long ajO;
  public long ajZ;
  protected CharSequence ak;
  public long aka;
  public String bOx;
  public boolean bnU;
  public boolean cDH;
  protected boolean cDI;
  public boolean cDJ;
  public boolean cDK;
  private boolean cDL;
  private boolean cDM;
  public boolean cDN;
  public String cbl;
  public String cbm;
  public String cbn = "";
  public String cbo;
  private String cbp;
  public int dDj;
  public int dDk = 2131167380;
  public int dDl = -1;
  public int dDm;
  private int dDn;
  public int dDo;
  public int dDp;
  public int dDq = -1;
  public int dDr = -1;
  public int dDs;
  public int dDt;
  public int dDu;
  protected String extension;
  public int friendStatus;
  public int fromType;
  public String iconUrl;
  public String id;
  private int idType = 0;
  protected String jumpUrl;
  protected String keyword;
  StringBuffer l = new StringBuffer();
  Context mContext = BaseApplicationImpl.getContext();
  public List<RecommendLabel> msgLabel;
  public String name;
  public int[] nd = new int[3];
  protected String picUrl;
  public int position;
  public int positionInList;
  private int positionType;
  public int sex;
  protected String subTitle;
  public ArrayList<GroupLabel> zz;
  
  public amow() {}
  
  public amow(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List<String> paramList, int paramInt)
  {
    this.keyword = paramString1;
    this.id = paramString2;
    this.name = paramString3;
    this.picUrl = paramString4;
    this.jumpUrl = paramString5;
    this.extension = paramString6;
    this.ajO = paramLong;
    this.FZ = paramList;
    this.fromType = paramInt;
    this.cDN = false;
    this.dDp = 1;
    this.aka = 0L;
    dOq();
  }
  
  private void dOq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "extension info:" + this.extension);
    }
    Object localObject3;
    label272:
    Object localObject2;
    label555:
    Object localObject1;
    int i;
    if (!TextUtils.isEmpty(this.extension))
    {
      try
      {
        localObject3 = new JSONObject(this.extension);
        String str2 = ((JSONObject)localObject3).optString("thirdLineText");
        if (a(this.ajO, (JSONObject)localObject3))
        {
          if (!QLog.isColorLevel()) {
            break label1227;
          }
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "child class has already parsed json data. groupMask=" + this.ajO);
          return;
        }
        switch ((int)this.ajO)
        {
        case 1001: 
          if (TextUtils.isEmpty(str2)) {
            break label1227;
          }
          this.ak = str2;
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
      this.subTitle = ("(" + this.id + ")");
      this.sex = ((JSONObject)localObject3).optInt("gender");
      this.age = ((JSONObject)localObject3).optInt("age");
      fP(((JSONObject)localObject3).optString("college"), 1);
      if (((JSONObject)localObject3).optString("location").equals(((JSONObject)localObject3).optString("hometown")))
      {
        fP(((JSONObject)localObject3).optString("location"), 4);
        fP(((JSONObject)localObject3).optString("constellation"), 2);
        this.aj = ((JSONObject)localObject3).optString("location");
        this.cbl = ((JSONObject)localObject3).optString("authIcon");
        this.cbo = ((JSONObject)localObject3).optString("longnick");
        this.dDr = ((JSONObject)localObject3).optInt("allow", -1);
      }
      for (;;)
      {
        try
        {
          this.dDo = ((JSONObject)localObject3).optInt("cspecialflag");
          String str1 = ((JSONObject)localObject3).optString("qdmasteruin");
          localObject2 = ((JSONObject)localObject3).optString("qdemailuin");
          this.cbm = ((JSONObject)localObject3).optString("kfaccount");
          localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          asgx.f((QQAppInterface)localObject3, this.dDo, this.id);
          asgx.x((QQAppInterface)localObject3, this.id, str1);
          if ((!asgx.mS(this.dDo)) && (!asgx.cU(this.dDo))) {
            break;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label555;
          }
          this.subTitle = "";
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json qdemailuin is empty ");
          if (!TextUtils.isEmpty(this.cbm)) {
            break;
          }
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json kfaccount is empty ");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "Parse search qidian json fail: " + this.id + " | " + localException.getMessage());
        break;
        fP(((JSONObject)localObject3).optString("location"), 4);
        fP(((JSONObject)localObject3).optString("hometown"), 4);
        break label272;
        this.subTitle = ("(" + (String)localObject2 + ")");
      }
      this.ajZ = ((JSONObject)localObject3).optLong("flag_ext");
      this.subTitle = "";
      localObject1 = ((JSONObject)localObject3).optJSONArray("label");
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        i = 0;
        for (;;)
        {
          int j = ((JSONArray)localObject1).length();
          if (i < j) {
            try
            {
              JSONObject localJSONObject1 = ((JSONArray)localObject1).getJSONObject(i);
              GroupLabel localGroupLabel = new GroupLabel();
              NearbyGroup.Color localColor = new NearbyGroup.Color();
              JSONObject localJSONObject2 = localJSONObject1.optJSONObject("edging_color");
              localColor.R = localJSONObject2.optLong("r");
              localColor.G = localJSONObject2.optLong("g");
              localColor.B = localJSONObject2.optLong("b");
              localGroupLabel.edging_color = localColor;
              localColor = new NearbyGroup.Color();
              localJSONObject2 = localJSONObject1.optJSONObject("text_color");
              localColor.R = localJSONObject2.optLong("r");
              localColor.G = localJSONObject2.optLong("g");
              localColor.B = localJSONObject2.optLong("b");
              localGroupLabel.text_color = localColor;
              localGroupLabel.strWording = localJSONObject1.optString("name");
              localGroupLabel.type = localJSONObject1.optLong("attr");
              ((ArrayList)localObject2).add(localGroupLabel);
              i += 1;
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "parse extension JSONException:" + localJSONException2.toString());
                }
              }
            }
          }
        }
        this.zz = ((ArrayList)localObject2);
      }
      localObject2 = ((JSONObject)localObject3).optString("memo");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.mContext.getString(2131698378);
      }
      this.aj = ((CharSequence)localObject1);
      long l1 = ((JSONObject)localObject3).optLong("active", 0L);
      long l2 = ((JSONObject)localObject3).optLong("join_group_flag", -1L);
      long l3 = ((JSONObject)localObject3).optLong("privilege_flag", 0L);
      this.cbn = ((JSONObject)localObject3).optString("arithmetic");
      if (((JSONObject)localObject3).optInt("exact_search") != 1) {
        break label1231;
      }
      bool = true;
      label978:
      this.bnU = bool;
      this.aka = l1;
      if (l2 <= -1L) {
        break label1237;
      }
      i = 0;
      label1000:
      this.dDp = i;
      if ((0x200 & l3) == 0L) {
        break label1242;
      }
    }
    label1227:
    label1231:
    label1237:
    label1242:
    for (boolean bool = true;; bool = false)
    {
      this.cDN = bool;
      this.bOx = ((JSONObject)localObject3).optString("join_group_auth");
      this.dDr = ((JSONObject)localObject3).optInt("allow", -1);
      this.dDs = ((JSONObject)localObject3).optInt("invite_only", 0);
      break;
      this.dDj = ((JSONObject)localObject3).optInt("video_or_music");
      localObject1 = ((JSONObject)localObject3).optString("busi_mask");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      if (Integer.parseInt((String)localObject1) == 2049) {
        this.aj = ((JSONObject)localObject3).optString("brief");
      }
      for (;;)
      {
        localObject1 = ((JSONObject)localObject3).optString("from");
        localObject2 = amwz.getDateString(Long.parseLong(((JSONObject)localObject3).optString("create_time")));
        this.ak = ((String)localObject1 + (String)localObject2);
        this.cDI = true;
        break;
        if (Integer.parseInt((String)localObject1) == 64) {
          this.aj = ((JSONObject)localObject3).optString("content");
        } else if (Integer.parseInt((String)localObject1) == 4096) {
          this.aj = ((JSONObject)localObject3).optString("description");
        }
      }
      return;
      break;
      bool = false;
      break label978;
      i = 1;
      break label1000;
    }
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return this.idType;
  }
  
  public int IW()
  {
    return (int)this.ajO;
  }
  
  public void PR(String paramString)
  {
    this.cbp = paramString;
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "JSONObject info:" + paramJSONObject);
    }
    if (paramJSONObject == null) {}
    return false;
  }
  
  public void aZ(int paramInt1, int paramInt2, int paramInt3)
  {
    iv(2, paramInt1);
    iv(1, paramInt2);
    iv(3, paramInt3);
  }
  
  public int bW(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "getPosition(). type=" + paramInt + "  position=" + i);
      }
      return i;
      i = this.positionInList;
      continue;
      i = this.dDt;
      continue;
      i = this.dDu;
    }
  }
  
  public void cR(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "onAction(). jumpUrl = " + this.jumpUrl + "  id=" + this.id);
    }
    Object localObject2;
    Object localObject3;
    switch (IW())
    {
    default: 
      if (this.ajO == 1002L) {
        amxg.a(this);
      }
      localObject2 = paramView.getContext();
      if ((localObject2 instanceof amkf))
      {
        localObject3 = (amkf)localObject2;
        if (((amkf)localObject3).awa()) {}
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = ((amkf)localObject3).c();
        if (!(localObject1 instanceof amke)) {
          break label2613;
        }
      }
      break;
    }
    label2565:
    label2613:
    for (Object localObject1 = (amke)localObject1;; localObject1 = null)
    {
      switch (((amkf)localObject3).IQ())
      {
      default: 
        label204:
        if (IW() == 268435456)
        {
          amxk.b("all_result", "clk_function", new String[] { "" + this.keyword, "" + this.id, "" + (this.position + 1) });
          if ("63".equals(getUin()))
          {
            localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if (!abdi.b(paramView.getContext(), (QQAppInterface)localObject1)) {
              break;
            }
          }
        }
        break;
      }
      do
      {
        Object localObject4;
        for (;;)
        {
          return;
          amxk.a(this.keyword, 70, 0, this.position, paramView);
          if (this.dDq == 1)
          {
            anot.a(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
            anot.a(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 2, 0, "", "", "", "");
            break;
          }
          anot.a(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
          anot.a(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 1, 0, "", "", "", "");
          break;
          amxk.a(this.keyword, 80, 0, this.position, paramView);
          break;
          amxk.e((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.keyword, this.cbp, uU(), IU());
          amxk.a(this.keyword, 120, 0, this.position, paramView);
          if ((this.cbp != null) && (!TextUtils.isEmpty(this.cbp)))
          {
            amub.a(null, 0, this.fromType, "0X8009D31", 4, 0, this.id, null);
            break;
          }
          if ((!TextUtils.isEmpty(this.name)) && (this.name.equals(this.keyword)))
          {
            amub.a(null, 0, this.fromType, "0X8009D35", 0, 0, this.id, null);
            break;
          }
          amub.a(null, 0, this.fromType, "0X8009D49", 0, 0, this.id, null);
          break;
          QQAppInterface localQQAppInterface;
          JSONObject localJSONObject;
          if ((amkl.mT.containsKey(this)) && (IW() != 268435456))
          {
            localObject4 = (amkl.a)amkl.mT.get(this);
            localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put("project", amub.zn());
            localJSONObject.put("event_src", "client");
            localJSONObject.put("obj_lct", ((amkl.a)localObject4).index);
            localJSONObject.put("get_src", "web");
            amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(this.ajO + "").obj2(((amkl.a)localObject4).caE).ver1(this.keyword).ver2(amub.eZ(this.fromType)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
            if (amxk.cF(this.ajO)) {
              if (amkl.mS.containsKey(this))
              {
                localObject4 = (amkl.a)amkl.mS.get(this);
                if (((amkl.a)localObject4).cDd)
                {
                  i = 2;
                  amxk.e("all_result", "clk_object", i, 0, new String[] { this.keyword, "" + this.ajO, ((amkl.a)localObject4).caE + "", ((amkl.a)localObject4).index + "" });
                }
              }
              else
              {
                if ((localObject1 == null) || (!((amke)localObject1).avY())) {
                  break label204;
                }
                ((amke)localObject1).Pm(true);
                amxk.b("all_result", "clk_first_result", new String[] { ((amkf)localObject3).vo(), "" + this.ajO, "" + bW(3), amxk.a("dynamic_tab_search.1", ((amkf)localObject3).m()) });
              }
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "e = " + localJSONException2);
              continue;
              i = 1;
            }
            if (amkl.cDc) {}
            for (i = 2;; i = 1)
            {
              amxk.e("all_result", "clk_content", i, 0, new String[] { ((amkf)localObject3).vo(), "" + this.ajO, "", amxk.a("dynamic_tab_search.1", ((amkf)localObject3).m()) });
              if ((localObject1 == null) || (!((amke)localObject1).avY())) {
                break;
              }
              ((amke)localObject1).Pm(true);
              amxk.b("all_result", "clk_first_result", new String[] { ((amkf)localObject3).vo(), "" + this.ajO, "" + bW(2), amxk.a("dynamic_tab_search.1", ((amkf)localObject3).m()) });
              break;
            }
          }
        }
        if ((localObject1 != null) && (((amke)localObject1).avY()))
        {
          ((amke)localObject1).Pm(true);
          amxk.b("all_result", "clk_tab_first_result", new String[] { ((amkf)localObject3).vo(), "" + this.ajO, "" + bW(2), amxk.a("dynamic_tab_search.1", ((amkf)localObject3).m()) });
        }
        amxk.b("all_result", "clk_tab_result", new String[] { ((amkf)localObject3).vo(), "" + this.ajO, "", amxk.a("dynamic_tab_search.1", ((amkf)localObject3).m()) });
        break label204;
        if ((localObject1 != null) && (((amke)localObject1).avY()))
        {
          ((amke)localObject1).Pm(true);
          amxk.b("sub_result", "clk_sub_first_result", new String[] { ((amkf)localObject3).vo(), "" + this.ajO, "" + bW(2), amxk.a("dynamic_tab_search.1", ((amkf)localObject3).m()) });
        }
        amxk.b("sub_result", "clk_result", new String[] { ((amkf)localObject3).vo(), "" + this.ajO, "" + bW(2), amxk.a("dynamic_tab_search.1", ((amkf)localObject3).m()) });
        break label204;
        if (((paramView.getContext() instanceof UniteSearchActivity)) && (amkl.mT.containsKey(this)))
        {
          localObject1 = (amkl.a)amkl.mT.get(this);
          localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject4 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject4).put("project", amub.zn());
          ((JSONObject)localObject4).put("event_src", "client");
          ((JSONObject)localObject4).put("obj_lct", ((amkl.a)localObject1).index);
          ((JSONObject)localObject4).put("get_src", "native");
          amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((amkl.a)localObject1).ajO + "").obj2(((amkl.a)localObject1).caE).ver1(((amkl.a)localObject1).key).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(((JSONObject)localObject4).toString()).session_id(((QQAppInterface)localObject3).getCurrentAccountUin() + amkl.ajN));
          if (!TextUtils.isEmpty(this.jumpUrl)) {
            if ((this.jumpUrl.startsWith("http")) || (this.jumpUrl.startsWith("https")))
            {
              paramView = new Intent((Context)localObject2, QQBrowserActivity.class);
              paramView.putExtra("url", this.jumpUrl);
              ((Context)localObject2).startActivity(paramView);
              return;
            }
          }
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "e = " + localJSONException1);
          }
          if ((localObject2 instanceof BaseActivity))
          {
            paramView = aqik.c(((BaseActivity)paramView.getContext()).app, (Context)localObject2, this.jumpUrl);
            if (paramView != null)
            {
              paramView.ace();
              return;
            }
            ((Context)localObject2).startActivity(new Intent((Context)localObject2, JumpActivity.class).setData(Uri.parse(this.jumpUrl)));
            return;
          }
          ((Context)localObject2).startActivity(new Intent((Context)localObject2, JumpActivity.class).setData(Uri.parse(this.jumpUrl)));
          return;
        }
        if (this.ajO == 268435456L)
        {
          amxk.x(paramView.getContext(), Integer.valueOf(this.id).intValue(), this.fromType);
          return;
        }
        if (this.ajO == 1001L)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject2 = new SearchResultItem();
          ((SearchResultItem)localObject2).lUIN = Long.valueOf(this.id).longValue();
          try
          {
            if ((asgx.mS(this.dDo)) || (asgx.cU(this.dDo))) {
              ((SearchResultItem)localObject2).lUIN = Long.valueOf(this.cbm).longValue();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "qidian corp jump error");
            }
            AddFriendActivity.a((Activity)paramView.getContext(), (SearchResultItem)localObject2, (QQAppInterface)localObject1, true, 3);
            return;
          }
          ((SearchResultItem)localObject2).strNick = this.name;
          if (aprg.V((QQAppInterface)localObject1, this.id))
          {
            aprg.H(paramView.getContext(), null, this.id);
            return;
          }
        }
      } while (this.ajO != 1002L);
      int i = 0;
      localObject1 = paramView.getContext();
      int k = i;
      if ((localObject1 instanceof Activity))
      {
        Intent localIntent = ((Activity)localObject1).getIntent();
        k = i;
        if (localIntent != null) {
          k = localIntent.getIntExtra("from_type_for_report", 0);
        }
      }
      int j = 103;
      if (k == 9) {
        j = 112;
      }
      i = j;
      if (localObject1 != null)
      {
        i = j;
        if ((localObject2 instanceof ActiveEntitySearchActivity))
        {
          localObject1 = ((Activity)localObject1).getIntent().getLongArrayExtra("group_mask_long_array");
          i = j;
          if (localObject1 != null)
          {
            i = j;
            if (localObject1.length == 1)
            {
              i = j;
              if (localObject1[0] == 1002L)
              {
                if (k != 9) {
                  break label2565;
                }
                i = 113;
              }
            }
          }
        }
      }
      switch (i)
      {
      }
      for (;;)
      {
        localObject1 = TroopInfoActivity.c(this.id, i);
        ((Bundle)localObject1).putInt("exposureSource", 3);
        ((Bundle)localObject1).putInt("t_s_f", 1000);
        ((Bundle)localObject1).putString("authSig", this.bOx);
        apuh.a(paramView.getContext(), (Bundle)localObject1, 2);
        return;
        i = 104;
        break;
        if (this.bnU)
        {
          i = 30014;
        }
        else
        {
          i = 30016;
          continue;
          if (this.bnU) {
            i = 30018;
          } else {
            i = 30020;
          }
        }
      }
    }
  }
  
  public void cW(int paramInt1, int paramInt2)
  {
    this.dDn = paramInt1;
    this.positionType = paramInt2;
  }
  
  public CharSequence f()
  {
    Object localObject = new amxa(this.FZ, getKeyword());
    this.subTitle = amxk.g(this.subTitle);
    SpannableString localSpannableString = ((amxa)localObject).a(this.subTitle);
    localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public void fP(String paramString, int paramInt)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (this.msgLabel == null) {
        this.msgLabel = new ArrayList();
      }
      if ((paramInt != 3) || (((this.msgLabel.size() <= 2) || ((this.sex != 1) && (this.sex != 2))) && (this.msgLabel.size() <= 3))) {}
    }
    else
    {
      return;
    }
    MayKnowRecommend.MayKnowRecommendLabel localMayKnowRecommendLabel = new MayKnowRecommend.MayKnowRecommendLabel();
    localMayKnowRecommendLabel.text_color = -1;
    localMayKnowRecommendLabel.bytes_name = paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.msgLabel.add(localMayKnowRecommendLabel);
      return;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FF8A2D");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#7373FF");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#C573FF");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FFC619");
    }
  }
  
  public CharSequence g()
  {
    Object localObject;
    if ((this.cDL) || (this.cDM)) {
      localObject = this.ak;
    }
    SpannableString localSpannableString;
    do
    {
      return localObject;
      localSpannableString = new amxa(this.FZ, getKeyword()).a(this.ak, false, this.cDI);
      localObject = localSpannableString;
    } while (localSpannableString != null);
    return "";
  }
  
  public String getCoverUrl()
  {
    return this.picUrl;
  }
  
  public CharSequence getDescription()
  {
    boolean bool = false;
    amxa localamxa = new amxa(this.FZ, getKeyword());
    this.aj = amxk.g(this.aj);
    SpannableString localSpannableString = localamxa.a(this.aj, false, false, false);
    if (localamxa.dDM > 0) {
      bool = true;
    }
    this.cDM = bool;
    if (localSpannableString == null) {
      return "";
    }
    return localSpannableString;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    boolean bool = true;
    if (IW() == 268435456) {}
    Object localObject;
    do
    {
      try
      {
        CharSequence localCharSequence = amxk.a(this.name, getKeyword(), true);
        return localCharSequence;
      }
      catch (Exception localException)
      {
        QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localException, new Object[0]);
        return this.name;
      }
      localObject = new amxa(this.FZ, getKeyword());
      if (IW() != 1002) {
        break;
      }
      this.name = amxk.g(this.name);
      localSpannableString = ((amxa)localObject).a(this.name, true);
      localObject = localSpannableString;
    } while (localSpannableString != null);
    return "";
    this.name = amxk.g(this.name);
    SpannableString localSpannableString = ((amxa)localObject).a(this.name, true);
    if (((amxa)localObject).dDM > 0) {}
    for (;;)
    {
      this.cDL = bool;
      if (localSpannableString != null) {
        break;
      }
      return "";
      bool = false;
    }
    return localSpannableString;
  }
  
  public String getUin()
  {
    return this.id;
  }
  
  public void iv(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.positionInList = paramInt2;
      return;
    case 2: 
      this.dDt = paramInt2;
      return;
    }
    this.dDu = paramInt2;
  }
  
  public int pE()
  {
    return this.dDn;
  }
  
  public int pF()
  {
    return this.positionType;
  }
  
  public int pG()
  {
    if (IW() == 1001) {
      return 1;
    }
    if (IW() == 1002) {
      return 4;
    }
    return 0;
  }
  
  public Object s(String paramString)
  {
    int j = 0;
    boolean bool = false;
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131701840);
      switch (this.dDp)
      {
      default: 
        bool = true;
      }
      for (;;)
      {
        return new Pair(paramString, Boolean.valueOf(bool));
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131701842);
        continue;
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131701840);
        bool = true;
        continue;
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131701841);
      }
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return Boolean.valueOf(this.cDN);
    }
    int i;
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString))
    {
      i = (int)this.aka;
      if (i >= 0) {
        break label190;
      }
      i = j;
    }
    label190:
    for (;;)
    {
      j = i;
      if (i > 10) {
        j = 10;
      }
      return Integer.valueOf(j);
      return super.s(paramString);
    }
  }
  
  public String uU()
  {
    return this.id;
  }
  
  public String zg()
  {
    if (this.cbn != null) {
      return this.cbn;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amow
 * JD-Core Version:    0.7.0.1
 */