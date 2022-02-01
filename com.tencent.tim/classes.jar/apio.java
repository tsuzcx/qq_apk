import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper.1;
import com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper.2;
import com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper.3;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apio
  implements View.OnClickListener, apip
{
  protected String En = "";
  protected View Ip;
  protected View Iq;
  protected View Ir;
  public PublishHomeWorkFragment a;
  protected Boolean aJ = Boolean.valueOf(false);
  protected TextView aaG;
  protected TextView aaH;
  protected JSONObject bU;
  protected boolean cQN;
  public boolean cQO;
  protected boolean cQP = true;
  protected boolean cQQ;
  protected String cpA = "";
  protected String cpB = "";
  protected int dUm;
  public LinearLayout kT;
  protected String mTroopUin = "";
  
  public apio(PublishHomeWorkFragment paramPublishHomeWorkFragment, String paramString)
  {
    this.a = paramPublishHomeWorkFragment;
    this.mTroopUin = paramString;
  }
  
  private String Bo()
  {
    QQAppInterface localQQAppInterface;
    Object localObject;
    if (this.a.getActivity() == null)
    {
      localQQAppInterface = null;
      if (localQQAppInterface != null) {
        break label61;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label86;
      }
      localQQAppInterface = (QQAppInterface)localObject;
    }
    label61:
    label86:
    for (;;)
    {
      localObject = localQQAppInterface;
      if (localQQAppInterface == null)
      {
        return "publish_hw_docs_guide_counts";
        localQQAppInterface = (QQAppInterface)this.a.getActivity().getAppInterface();
        break;
        localObject = localQQAppInterface;
      }
      return "publish_hw_docs_guide_counts" + ((QQAppInterface)localObject).getCurrentAccountUin();
    }
  }
  
  private void RL(boolean paramBoolean)
  {
    if (this.aaG != null)
    {
      if (paramBoolean)
      {
        this.aaG.setVisibility(0);
        this.aaG.setText("");
        this.aaG.setBackgroundResource(0);
        this.aaG.setCompoundDrawablesWithIntrinsicBounds(2130838050, 0, 0, 0);
      }
    }
    else {
      return;
    }
    this.aaG.setVisibility(8);
  }
  
  private void RM(boolean paramBoolean)
  {
    if (this.Iq != null)
    {
      if ((paramBoolean) && (!this.cQN))
      {
        this.Iq.setVisibility(0);
        this.cQN = true;
      }
    }
    else {
      return;
    }
    this.Iq.setVisibility(8);
  }
  
  private void bF(boolean paramBoolean, int paramInt)
  {
    ThreadManager.postImmediately(new DocsEntranceHelper.3(this, paramBoolean, paramInt), null, false);
  }
  
  private void ic(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onJumpToDocs");
    }
    paramView = (apha)aeif.a().o(605);
    if (paramView != null)
    {
      paramView = paramView.Bm();
      if (paramView.isEmpty()) {
        return;
      }
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=").append(this.mTroopUin);
      paramView.append("&appid=").append("101458937");
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.a.getActivity().startActivityForResult((Intent)localObject, 265);
      if (this.a.a() != null) {
        this.a.a().aLz();
      }
      if (this.aaG.getVisibility() == 0)
      {
        bF(false, 3);
        RL(false);
        RM(false);
      }
    }
    Object localObject = this.a.r();
    if (this.mTroopUin == null) {}
    for (paramView = "";; paramView = this.mTroopUin)
    {
      aqfr.b("Grp_edu", "homework", "createHW_doc_clk", 0, 0, new String[] { paramView, ((Bundle)localObject).getString("reportIdentity", ""), ((Bundle)localObject).getString("reportCourse", "") });
      return;
    }
  }
  
  private void id(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onClickDocsLink");
    }
    paramView = (apha)aeif.a().o(605);
    if (paramView != null)
    {
      paramView = paramView.Bn();
      if (!paramView.isEmpty()) {
        break label45;
      }
    }
    label45:
    do
    {
      return;
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=").append(this.mTroopUin);
      paramView.append("&appid=").append("101458937");
      paramView.append("&examid=").append(this.cpB);
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
    } while (this.a.a() == null);
    this.a.a().aLz();
  }
  
  private void ie(View paramView)
  {
    setSelect(false);
    if (this.kT != null) {
      this.kT.setVisibility(8);
    }
    this.a.WK(2);
  }
  
  private boolean needShowGuide()
  {
    apha localapha = (apha)aeif.a().o(605);
    if ((localapha != null) && (!localapha.aBb())) {
      return false;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(this.a.getActivity()).getInt(Bo(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    if (i < 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void RK(boolean paramBoolean)
  {
    this.cQO = paramBoolean;
    if (!paramBoolean) {
      RM(false);
    }
    while (!this.aJ.booleanValue())
    {
      return;
      if (this.cQP)
      {
        this.cQP = false;
        if (this.cQQ) {
          ThreadManager.getUIHandler().postDelayed(new DocsEntranceHelper.1(this), 500L);
        }
      }
    }
    if (paramBoolean)
    {
      this.kT.setVisibility(8);
      RM(false);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new DocsEntranceHelper.2(this), 20L);
  }
  
  public void WM(int paramInt)
  {
    Bundle localBundle;
    if ((this.aJ.booleanValue()) && (paramInt == 1))
    {
      localBundle = this.a.r();
      if (this.mTroopUin != null) {
        break label76;
      }
    }
    label76:
    for (String str = "";; str = this.mTroopUin)
    {
      aqfr.b("Grp_edu", "homework", "createHW_doc", 0, 0, new String[] { str, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
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
    if ((str1 != null) && (str1.equals("exam")) && (str2 != null) && (!str2.equals("0")) && (str3 != null) && (str3.equals("101458937")))
    {
      this.bU = paramJSONObject;
      str1 = paramJSONObject.optString("title");
      this.aaH.setText(str1);
      this.cpB = paramJSONObject.optString("exam_id");
      this.kT.setVisibility(0);
      this.kT.setClickable(false);
      this.Ir.setVisibility(8);
      setSelect(true);
      this.a.WK(2);
    }
  }
  
  public void ca(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 2)
    {
      if (paramBoolean) {
        this.Ip.setEnabled(false);
      }
    }
    else {
      return;
    }
    this.Ip.setEnabled(true);
  }
  
  public void initUI()
  {
    this.Ip = this.a.findViewById(2131373807);
    this.aaG = ((TextView)this.a.findViewById(2131373809));
    this.Iq = this.a.findViewById(2131373017);
    apha localapha = (apha)aeif.a().o(605);
    if (localapha != null)
    {
      if (!localapha.aBb()) {
        break label225;
      }
      this.Ip.setVisibility(0);
      this.Ip.setOnClickListener(this);
      if (this.a.getMode() != 1) {
        break label214;
      }
      this.Ip.setClickable(true);
    }
    for (;;)
    {
      this.kT = ((LinearLayout)this.a.findViewById(2131380287));
      this.kT.setOnClickListener(this);
      if (!this.aJ.booleanValue()) {
        this.kT.setVisibility(8);
      }
      this.aaH = ((TextView)this.kT.findViewById(2131380421));
      this.Ir = this.kT.findViewById(2131380257);
      this.Ir.setOnClickListener(this);
      this.cQQ = needShowGuide();
      if (!this.cQQ) {
        break;
      }
      RL(true);
      bF(true, 1);
      return;
      label214:
      this.Ip.setClickable(false);
      continue;
      label225:
      this.Ip.setVisibility(8);
    }
    RL(false);
    RM(false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 265) {
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
      this.cpA = paramIntent.optString("course_name");
      this.cpB = paramIntent.optString("exam_id");
      this.aaH.setText(this.En);
      this.kT.setVisibility(0);
      setSelect(true);
      this.a.WK(2);
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
      ic(paramView);
      continue;
      id(paramView);
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
      localJSONObject.put("appid", "101458937");
      localJSONObject.put("exam_id", this.cpB);
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
 * Qualified Name:     apio
 * JD-Core Version:    0.7.0.1
 */