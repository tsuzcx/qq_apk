import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.logic.WeiKeEntranceHelper.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apiq
  implements View.OnClickListener, apip
{
  protected String En = "";
  protected View Is;
  protected View It;
  protected PublishHomeWorkFragment a;
  protected Boolean aJ = Boolean.valueOf(false);
  protected TextView aaI;
  protected JSONObject bU;
  protected String cpA = "";
  protected int dUm;
  protected int dUn;
  public LinearLayout kU;
  protected String mTroopUin = "";
  
  public apiq(PublishHomeWorkFragment paramPublishHomeWorkFragment, String paramString)
  {
    this.a = paramPublishHomeWorkFragment;
    this.mTroopUin = paramString;
  }
  
  private void ie(View paramView)
  {
    setSelect(false);
    if (this.kU != null) {
      this.kU.setVisibility(8);
    }
    this.a.WK(1);
  }
  
  public void RK(boolean paramBoolean)
  {
    if (!this.aJ.booleanValue()) {
      return;
    }
    if (paramBoolean)
    {
      this.kU.setVisibility(8);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new WeiKeEntranceHelper.1(this), 20L);
  }
  
  public void WM(int paramInt)
  {
    Bundle localBundle;
    if ((this.aJ.booleanValue()) && (paramInt == 1))
    {
      localBundle = this.a.r();
      if (this.mTroopUin != null) {
        break label75;
      }
    }
    label75:
    for (String str = "";; str = this.mTroopUin)
    {
      aqfr.b("Grp_edu", "homework", "createHW_lele", 0, 0, new String[] { str, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
      return;
    }
  }
  
  public boolean aBf()
  {
    return this.aJ.booleanValue();
  }
  
  public void bL(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("exam_type");
    String str3 = paramJSONObject.optString("appid");
    if ((str1 != null) && (str1.equals("exam")) && (str2 != null) && (!str2.equals("0")) && (str3 != null) && (str3.equals("101036803")))
    {
      this.bU = paramJSONObject;
      str1 = paramJSONObject.optString("exam_id");
      paramJSONObject = paramJSONObject.optString("title");
      this.aaI.setText(paramJSONObject);
      this.dUn = Integer.valueOf(str1).intValue();
      this.kU.setVisibility(0);
      this.kU.setClickable(false);
      this.It.setVisibility(8);
      setSelect(true);
      this.a.WK(1);
    }
  }
  
  public void ca(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramBoolean) {
        this.Is.setEnabled(false);
      }
    }
    else {
      return;
    }
    this.Is.setEnabled(true);
  }
  
  protected void jdMethod_if(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onJumpToWeiKe");
    }
    aurd.cE(this.a.getActivity());
    paramView = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder(((apha)aeif.a().o(605)).Bk());
    localStringBuilder.append("?gc=").append(this.mTroopUin);
    localStringBuilder.append("&appid=").append("101036803");
    localStringBuilder.append("&_wwv=128&_wv=3");
    paramView.putExtra("url", localStringBuilder.toString());
    this.a.getActivity().startActivityForResult(paramView, 264);
    if (this.a.a() != null) {
      this.a.a().aLz();
    }
  }
  
  protected void ig(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onClickWeiKeLink");
    }
    paramView = ((apha)aeif.a().o(605)).Bl();
    if (paramView.isEmpty()) {}
    do
    {
      return;
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=").append(this.mTroopUin);
      paramView.append("&appid=").append("101036803");
      paramView.append("&examid=").append(this.dUn);
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
    } while (this.a.a() == null);
    this.a.a().aLz();
  }
  
  public void initUI()
  {
    this.Is = this.a.findViewById(2131373835);
    apha localapha = (apha)aeif.a().o(605);
    if (localapha != null)
    {
      if (!localapha.aBa()) {
        break label168;
      }
      this.Is.setVisibility(0);
      this.Is.setOnClickListener(this);
      if (this.a.getMode() != 1) {
        break label157;
      }
      this.Is.setClickable(true);
    }
    for (;;)
    {
      this.kU = ((LinearLayout)this.a.findViewById(2131380289));
      this.kU.setOnClickListener(this);
      if (!this.aJ.booleanValue()) {
        this.kU.setVisibility(8);
      }
      this.aaI = ((TextView)this.a.findViewById(2131380295));
      this.It = this.a.findViewById(2131380412);
      this.It.setOnClickListener(this);
      return;
      label157:
      this.Is.setClickable(false);
      continue;
      label168:
      this.Is.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 264) {
      return;
    }
    if (paramIntent == null)
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult data == null");
      return;
    }
    paramIntent = paramIntent.getStringExtra("params");
    if (paramIntent.isEmpty())
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult strData.isEmpty");
      return;
    }
    Object localObject;
    try
    {
      paramIntent = new JSONObject(paramIntent);
      if (paramIntent == null)
      {
        QLog.e("DocsEntranceHelper", 2, "onActivityResult argsJson == null");
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent = null;
      }
      this.En = paramIntent.optString("title");
      this.dUm = paramIntent.optInt("num", 0);
      localObject = acfp.m(2131699641) + " (" + this.dUm + acfp.m(2131699642) + ")\n" + acfp.m(2131699643) + "\n" + this.En;
      this.cpA = paramIntent.optString("course_name");
      this.dUn = paramIntent.optInt("exam_id", -1);
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("type", "str");
      paramIntent.put("text", localObject);
      localObject = new JSONArray();
      ((JSONArray)localObject).put(paramIntent);
      if (this.a.a() != null)
      {
        this.a.a().setDataByEdit((JSONArray)localObject);
        this.a.dZD();
      }
      this.aaI.setText(this.En);
      this.kU.setVisibility(0);
      setSelect(true);
      this.a.WK(1);
      return;
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdMethod_if(paramView);
      continue;
      ig(paramView);
      continue;
      ie(paramView);
    }
  }
  
  public void setSelect(boolean paramBoolean)
  {
    this.aJ = Boolean.valueOf(paramBoolean);
  }
  
  public void v(JSONArray paramJSONArray)
  {
    if (this.aJ.booleanValue())
    {
      if (this.bU != null) {
        paramJSONArray.put(this.bU);
      }
    }
    else {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "exam");
      localJSONObject.put("exam_type", "1");
      localJSONObject.put("appid", "101036803");
      localJSONObject.put("exam_id", String.valueOf(this.dUn));
      localJSONObject.put("course_name", this.cpA);
      localJSONObject.put("exam_count", String.valueOf(this.dUm));
      localJSONObject.put("title", this.En);
      paramJSONArray.put(localJSONObject);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apiq
 * JD-Core Version:    0.7.0.1
 */