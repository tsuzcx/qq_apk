import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.TroopLinkHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zji
  implements aolm.b
{
  private long Lc;
  private final ChatHistoryTroopLinkFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment;
  @NonNull
  private zjh jdField_a_of_type_Zjh;
  private aolm c;
  private QQAppInterface mApp;
  
  public zji(QQAppInterface paramQQAppInterface, ChatHistoryTroopLinkFragment paramChatHistoryTroopLinkFragment, @NonNull zjh paramzjh)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment = paramChatHistoryTroopLinkFragment;
    this.c = ((aomf)paramQQAppInterface.getManager(21)).a(this.mApp, 0);
    this.jdField_a_of_type_Zjh = paramzjh;
  }
  
  @UiThread
  private void F(boolean paramBoolean, @NonNull List<TroopLinkElement> paramList)
  {
    paramList = new TroopLinkHandler.1(this, paramBoolean, paramList);
    ThreadManager.getUIHandler().post(paramList);
  }
  
  private void T(String paramString, long paramLong)
  {
    aoll localaoll = new aoll();
    localaoll.bZ = "https://qun.qq.com/cgi-bin/groupchat_url_collect/get_url_collect";
    localaoll.mHttpMethod = 1;
    localaoll.dPo = 0;
    localaoll.f = this;
    String str = ((TicketManagerImpl)this.mApp.getManager(2)).getSkey(this.mApp.getCurrentUin());
    paramString = String.format("bkn=%s&gc=%s&seq=%s&n=%s&noui=1", new Object[] { Integer.valueOf(apuh.eU(str)), paramString, Long.valueOf(paramLong), Integer.valueOf(200) });
    if (QLog.isColorLevel()) {
      QLog.i("TroopLinkHandler", 2, "send: invoked.  postData: " + paramString);
    }
    str = "uin=" + this.mApp.getCurrentUin() + ";skey=" + str;
    localaoll.X = paramString.getBytes();
    localaoll.u = new HashMap();
    localaoll.u.put("Cookie", str);
    this.c.a(localaoll);
  }
  
  private void aC(JSONObject paramJSONObject)
    throws JSONException
  {
    this.Lc = paramJSONObject.optLong("seq");
    long l = paramJSONObject.optLong("n_all", -1L);
    if ((this.Lc == 0L) || (l == 0L)) {
      this.jdField_a_of_type_Zjh.cpt();
    }
  }
  
  private void b(aomh paramaomh)
  {
    try
    {
      paramaomh = new JSONObject(new String(paramaomh.mRespData));
      if (QLog.isColorLevel()) {
        QLog.i("TroopLinkHandler", 2, "resolveResponse: invoked.  json: " + paramaomh);
      }
      F(true, e(paramaomh));
      aC(paramaomh);
      return;
    }
    catch (Exception paramaomh)
    {
      QLog.e("TroopLinkHandler", 1, "resolveResponse: failed. ", paramaomh);
      F(false, new ArrayList());
    }
  }
  
  private ArrayList<TroopLinkElement> e(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONArray("url_list");
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      localArrayList.add(TroopLinkElement.mergeFromJson(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment.getUin(), localJSONObject));
      i += 1;
    }
    return localArrayList;
  }
  
  public void bh(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      T(paramString, this.Lc);
      return;
    }
    T(paramString, 0L);
  }
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.dPy == 200)
    {
      b(paramaomh);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopLinkHandler", 2, "onResp: invoked.  resp: " + paramaomh);
    }
    F(false, new ArrayList());
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zji
 * JD-Core Version:    0.7.0.1
 */