import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apri
  implements Manager
{
  public static final String TAG = ".troop.school_troop." + apri.class.getSimpleName();
  private static final String[] hE = { "", acfp.m(2131714054), acfp.m(2131714056) };
  private static final String[] hF = { "", acfp.m(2131714057), acfp.m(2131714053) };
  protected LinkedHashMap<String, apri.a> aj = new LinkedHashMap();
  protected SparseArray<String[]> dG = new SparseArray();
  protected final QQAppInterface mApp;
  
  public apri(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    loadConfig();
  }
  
  public static String A(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    if (paramString1.length() <= 0) {
      return "";
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = new StringBuilder();
    int k = paramString1.length();
    int i = 0;
    if (i < k)
    {
      int m = paramString1.codePointAt(i);
      if (aoff.ah.get(m, -1) != -1)
      {
        int j = i;
        if (m > 65535) {
          j = i + 1;
        }
        paramString2.append(str);
        i = j;
      }
      for (;;)
      {
        i += 1;
        break;
        if (m == 20)
        {
          i += 1;
          paramString2.append(str);
        }
        else
        {
          paramString2.append(paramString1.charAt(i));
        }
      }
    }
    return paramString2.toString();
  }
  
  public static boolean i(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.cZ != 1) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramSessionInfo.aTl);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.dwGroupClassExt == 32L;
  }
  
  private void loadConfig()
  {
    long l = System.currentTimeMillis();
    String str = this.mApp.getApp().getSharedPreferences("homework_troop_config" + this.mApp.getCurrentUin(), 0).getString("troop_school_keyword_config", "");
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "The configString is empty, new user or no config");
      }
      return;
    }
    updateConfig(str);
    QLog.i(TAG, 1, "loadConfig cost time: " + (System.currentTimeMillis() - l));
  }
  
  public apri.a a(SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    long l1 = System.currentTimeMillis();
    if ((paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.msg))) {
      paramSessionInfo = null;
    }
    long l2;
    String str1;
    do
    {
      return paramSessionInfo;
      i = f(paramSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "detectKeyword.detectRole time cost: " + (System.currentTimeMillis() - l1));
      }
      if (i <= 0) {
        return null;
      }
      if (((i & 0x2) != 2) && ((i & 0x1) != 1)) {
        return null;
      }
      if (this.dG.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(TAG, 2, "Keywords is empty, the config is error?");
        }
        return null;
      }
      l2 = paramMessageRecord.uniseq;
      str1 = l2 + "_" + i;
      locala = (apri.a)this.aj.get(str1);
      if (locala == null) {
        break;
      }
      paramSessionInfo = locala;
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "detectKeyword.useCache time cost: " + (System.currentTimeMillis() - l1));
    return locala;
    paramMessageRecord = paramMessageRecord.msg;
    apri.a locala = new apri.a();
    locala.msgId = l2;
    locala.dVx = i;
    locala.troopUin = paramSessionInfo.aTl;
    locala.setContent(paramMessageRecord);
    int k = this.dG.size();
    int i = 0;
    while (i < k)
    {
      int m = this.dG.keyAt(i);
      paramSessionInfo = (String[])this.dG.get(m);
      int n = paramSessionInfo.length;
      int j = 0;
      while (j < n)
      {
        String str2 = paramSessionInfo[j];
        int i1 = paramMessageRecord.indexOf(str2);
        if (i1 != -1)
        {
          locala.action = m;
          locala.keyword = str2;
          locala.ahi = i1;
          locala.adh = (str2.length() + i1);
          this.aj.put(str1, locala);
          return locala;
        }
        j += 1;
      }
      i += 1;
    }
    locala.action = -1;
    this.aj.put(str1, locala);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "detectKeyword time cost: " + (System.currentTimeMillis() - l1) + ", result = " + locala.action);
    }
    return locala;
  }
  
  public int f(SessionInfo paramSessionInfo)
  {
    int j;
    if (paramSessionInfo.cZ != 1)
    {
      j = -1;
      return j;
    }
    if (this.dG.size() == 0) {
      return -4;
    }
    String str = this.mApp.getCurrentAccountUin();
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).c(paramSessionInfo.aTl);
    if (localTroopInfo == null)
    {
      QLog.w(TAG, 2, "it must be wrong. The troopUin '" + paramSessionInfo.aTl + "' has not troopInfo");
      return -2;
    }
    if (localTroopInfo.dwGroupClassExt != 32L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(TAG, 2, "Not school troop. The troopUin '" + paramSessionInfo.aTl + "', dwGroupClassExt = " + localTroopInfo.dwGroupClassExt);
      }
      return -3;
    }
    int i = 0;
    if (localTroopInfo.isTroopOwner(str)) {
      i = 1;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i(TAG, 2, "detect role. The currentUin '" + str + "', role = " + i);
      return i;
      if (localTroopInfo.isTroopAdmin(str)) {
        i = 2;
      }
    }
  }
  
  public void onDestroy() {}
  
  public void updateConfig(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "update config, config=" + paramString);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int k = localJSONArray.length();
        i = 0;
        if (i < k)
        {
          Object localObject = localJSONArray.optJSONObject(i);
          int m = ((JSONObject)localObject).getInt("action");
          if (m >= hE.length) {
            break label308;
          }
          ArrayList localArrayList = new ArrayList();
          localObject = ((JSONObject)localObject).getJSONArray("words");
          int n = ((JSONArray)localObject).length();
          int j = 0;
          if (j < n)
          {
            localArrayList.add(((JSONArray)localObject).getString(j));
            j += 1;
            continue;
          }
          this.dG.put(m, localArrayList.toArray(new String[localArrayList.size()]));
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.w(TAG, 2, "parse config error, config = " + paramString);
        return;
        this.aj.clear();
        return;
      }
      finally
      {
        QLog.i(TAG, 1, "updateConfig cost time: " + (System.currentTimeMillis() - l));
      }
      label308:
      i += 1;
    }
  }
  
  public static class a
  {
    public int action;
    public int adh;
    public int ahi;
    public boolean cSe;
    private String content;
    public int dVx;
    public String keyword;
    public long msgId;
    public String troopUin;
    
    public String Bz()
    {
      if ((this.dVx & 0x4) == 4) {
        return "classteacher";
      }
      if ((this.dVx & 0x8) == 8) {
        return "teacher";
      }
      if ((this.dVx & 0x1) == 1) {
        return "owner";
      }
      if ((this.dVx & 0x2) == 2) {
        return "admin";
      }
      return "other";
    }
    
    public String getContent()
    {
      return this.content;
    }
    
    public void setContent(String paramString)
    {
      this.content = apri.A(paramString, "").trim().replaceAll("\\s+", " ");
    }
    
    public String toString()
    {
      return "KeywordResult{msgId=" + this.msgId + ", troopUin='" + this.troopUin + '\'' + ", userRole=" + this.dVx + ", action=" + this.action + ", keyword='" + this.keyword + '\'' + ", startPos=" + this.ahi + ", endPos=" + this.adh + ", content=" + this.content + '}';
    }
  }
  
  public static class b
    extends ClickableSpan
    implements ausj.a
  {
    private final apri.a a;
    private ausj mActionSheet;
    private final QQAppInterface mApp;
    private final Context mContext;
    
    public b(QQAppInterface paramQQAppInterface, Context paramContext, apri.a parama)
    {
      this.mApp = paramQQAppInterface;
      this.mContext = paramContext;
      this.a = parama;
      a("Grp_edu", "", "Grp_AIO", "GuideWords_Show", 0, 0);
    }
    
    private void Qq()
    {
      if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
        this.mActionSheet.dismiss();
      }
      this.mActionSheet = ((ausj)auss.a(this.mContext, null));
      Object localObject2 = this.a.getContent();
      Object localObject1 = localObject2;
      if (((String)localObject2).length() > 10) {
        localObject1 = ((String)localObject2).substring(0, 5) + "…" + ((String)localObject2).substring(((String)localObject2).length() - 5, ((String)localObject2).length());
      }
      localObject1 = MessageFormat.format(apri.l()[this.a.action], new Object[] { localObject1 });
      localObject2 = LayoutInflater.from(this.mContext).inflate(2131558467, null);
      ((View)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130837648));
      ((View)localObject2).setOnClickListener(new aprj(this));
      TextView localTextView = (TextView)((View)localObject2).findViewById(2131362018);
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setContentDescription((CharSequence)localObject1);
      localTextView.setGravity(17);
      localTextView.setPadding(rpq.dip2px(this.mContext, 10.0F), 0, rpq.dip2px(this.mContext, 10.0F), 0);
      this.mActionSheet.addViewCustomeTitle((View)localObject2);
      this.mActionSheet.addButton(apri.Q()[this.a.action]);
      this.mActionSheet.addCancelButton(acfp.m(2131714055));
      this.mActionSheet.a(this);
      this.mActionSheet.show();
    }
    
    private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
    {
      ThreadManager.excute(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1(this, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2), 32, null, true);
    }
    
    public void OnClick(View paramView, int paramInt)
    {
      Object localObject;
      aptl localaptl;
      if (paramInt == 0)
      {
        localObject = null;
        localaptl = aptl.a();
        if (this.a.action != 1) {
          break label203;
        }
        paramView = localaptl.getUrl("troop_homework_create_notice");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramView))
        {
          localObject = new aptl.a();
          ((aptl.a)localObject).crf = this.a.troopUin;
          ((aptl.a)localObject).from = "aio_keyword";
          ((aptl.a)localObject).title = this.a.keyword;
          ((aptl.a)localObject).content = this.a.getContent();
          paramView = localaptl.a(paramView, (aptl.a)localObject);
          if (QLog.isDevelopLevel()) {
            QLog.i(apri.TAG, 2, "do action '" + this.a.action + "', open url: " + paramView);
          }
          localObject = new Intent(this.mContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          this.mContext.startActivity((Intent)localObject);
        }
        a("Grp_edu", "", "Grp_AIO", "GuideActionsheet_Clk", 0, 0);
        if (this.mActionSheet != null) {
          this.mActionSheet.dismiss();
        }
        return;
        label203:
        if (this.a.action == 2)
        {
          paramView = localaptl.getUrl("troop_create_homework");
        }
        else
        {
          paramView = (View)localObject;
          if (QLog.isColorLevel())
          {
            QLog.e(apri.TAG, 2, "I don't know this action '" + this.a.action + "'");
            paramView = (View)localObject;
          }
        }
      }
    }
    
    public void onClick(View paramView)
    {
      if (aqgq.cTW)
      {
        if (QLog.isColorLevel()) {
          QLog.e(apri.TAG, 2, "SchoolTroopHighlightSpan onCLick is invoked by LongClick misstake");
        }
        return;
      }
      if ((paramView instanceof ETTextView)) {
        ((ETTextView)paramView).mHasClickedArkSpan = true;
      }
      Qq();
      a("Grp_edu", "", "Grp_AIO", "GuideWords_Clk", 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apri
 * JD-Core Version:    0.7.0.1
 */