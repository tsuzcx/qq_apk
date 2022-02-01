import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ampt
  extends ampy
  implements Cloneable
{
  public static final String TAG = ampt.class.getSimpleName();
  public amxi a;
  private String aZo;
  private long ajK = -1L;
  private long ajT;
  protected long akb;
  private CharSequence an;
  protected CharSequence ao;
  public QQAppInterface app;
  public boolean cDS;
  protected String cbp;
  private String cbv;
  protected String cbw;
  protected String cbx;
  protected int fromType;
  public HashMap<String, String> mV;
  
  public ampt(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    this.app = paramQQAppInterface;
    this.fromType = paramInt;
    this.akb = paramLong;
  }
  
  public int IU()
  {
    return 0;
  }
  
  public void PR(String paramString)
  {
    this.cbp = paramString;
  }
  
  public abstract Object S();
  
  public amxi a()
  {
    return this.a;
  }
  
  public amxi a(String paramString)
  {
    return null;
  }
  
  protected abstract long au(String paramString);
  
  public final long aw(String paramString)
  {
    long l2 = au(paramString);
    long l1 = l2;
    if (l2 != -9223372036854775808L)
    {
      l1 = l2;
      if (awc()) {
        l1 = l2 + (this.akb << SearchConfigManager.contactSearchRecentBaseBit);
      }
    }
    this.ajT = l1;
    return l1;
  }
  
  protected boolean awc()
  {
    return true;
  }
  
  public void cR(View paramView)
  {
    Integer localInteger1;
    Integer localInteger2;
    amkl.a locala;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (amxk.lo(this.fromType))
    {
      localInteger1 = (Integer)paramView.getTag(2131381961);
      localInteger2 = (Integer)paramView.getTag(2131381959);
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch..ContectReport", 2, " view.getTag(R.id.view_tag_position) = " + localInteger1);
      }
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (amkl.mT.containsKey(this)))
      {
        locala = (amkl.a)amkl.mT.get(this);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", locala.index);
      localJSONObject.put("get_src", "native");
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(locala.ajO + "").obj2(locala.caE).ver1(locala.key).ver2(amub.eZ(this.fromType)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (!(this instanceof amqy)) && (localInteger2.intValue() >= 0) && (localInteger1.intValue() >= 0))
      {
        amxk.b("all_result", "clk_contact", new String[] { "" + getKeyword(), "" + localInteger2, "" + (localInteger1.intValue() + 1), "" + zh() });
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        for (;;)
        {
          QLog.e(TAG, 2, "e = " + localJSONException);
        }
        if (((paramView.getContext() instanceof ContactSearchActivity)) && (!(this instanceof amqy)))
        {
          amxk.b("contact", "clk_result", new String[] { "" + getKeyword(), "" + localInteger2, "" + (localInteger1.intValue() + 1), "" + zh() });
          return;
        }
        if (((paramView.getContext() instanceof UniteSearchActivity)) && ((this instanceof amqy)))
        {
          amxk.b("all_result", "clk_public_uin", new String[] { "" + getKeyword(), "" + localInteger2, "" + (localInteger1.intValue() + 1), "" + zh() });
          return;
        }
      } while (((paramView.getContext() instanceof UniteSearchActivity)) || (!(this instanceof amqy)));
      amxk.b("all_result", "clk_public_uin_page", new String[] { "" + getKeyword(), "" + localInteger2, "" + (localInteger1.intValue() + 1), "" + zh() });
    }
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public CharSequence f()
  {
    String str = zb();
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.equals(this.cbx)) || (!TextUtils.equals(this.cbw, getKeyword())))
      {
        this.cbx = str;
        this.cbw = getKeyword();
        if ((!this.cDS) || (this.a == null)) {
          break label94;
        }
      }
      label94:
      for (this.ao = amxk.d(amxk.a(this.app, str, getKeyword(), 6, this.a));; this.ao = amxk.d(amxk.a(str, getKeyword(), 6))) {
        return this.ao;
      }
    }
    this.cbx = null;
    return null;
  }
  
  public long gM()
  {
    QQMessageFacade.Message localMessage;
    if (this.ajK == -1L)
    {
      localMessage = this.app.b().a(getUin(), lk());
      if (localMessage == null) {
        break label47;
      }
    }
    label47:
    for (this.ajK = localMessage.time;; this.ajK = 0L) {
      return this.ajK;
    }
  }
  
  public final long gN()
  {
    return this.ajT;
  }
  
  public CharSequence getTitle()
  {
    String str = za();
    if (!TextUtils.isEmpty(str))
    {
      if ((!str.equals(this.aZo)) || (!TextUtils.equals(this.cbv, getKeyword())))
      {
        this.aZo = str;
        this.cbv = getKeyword();
        if ((!this.cDS) || (this.a == null)) {
          break label98;
        }
      }
      label98:
      for (this.an = amxk.a(this.app, str, getKeyword(), 6, this.a); this.an != null; this.an = amxk.a(this.app, str, getKeyword(), 6)) {
        return this.an;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getTitle str is null");
    }
    this.aZo = null;
    return "";
    return "";
  }
  
  public abstract String getUin();
  
  public abstract int lk();
  
  public CharSequence y()
  {
    return getTitle();
  }
  
  public abstract String za();
  
  public abstract String zb();
  
  public String zh()
  {
    if (((this instanceof amoi)) || ((this instanceof amoh)) || ((this instanceof amoj))) {
      return acfp.m(2131707351);
    }
    if (((this instanceof amol)) || ((this instanceof amom)) || ((this instanceof amos)) || ((this instanceof amot)) || ((this instanceof amon)) || ((this instanceof amoo))) {
      return acfp.m(2131707352);
    }
    return acfp.m(2131707353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampt
 * JD-Core Version:    0.7.0.1
 */