import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class ajxs
{
  public static long ady;
  public static String bSL;
  public static String bSM = "";
  public static int dlD;
  public static String feedId;
  public static String from = "";
  protected String bSN = "";
  protected String bSO = "";
  boolean cqG = false;
  boolean cqH = false;
  protected String d1 = "";
  protected String d2 = "";
  protected String d3 = "";
  protected String d4 = "";
  protected String feedid = "";
  protected int mCount = 1;
  protected int mOpIn;
  protected String mOpName = "";
  protected int mOpResult;
  protected String mOpType = "";
  protected String mToUin = "";
  protected String networktype = "";
  protected String source = "";
  
  static
  {
    bSL = "";
    feedId = "";
  }
  
  public ajxs a()
  {
    this.cqG = true;
    return this;
  }
  
  public ajxs a(String paramString)
  {
    this.bSN = paramString;
    return this;
  }
  
  public ajxs b()
  {
    this.cqH = true;
    return this;
  }
  
  public ajxs b(String paramString)
  {
    this.feedid = paramString;
    return this;
  }
  
  public ajxs c(String paramString)
  {
    this.bSO = paramString;
    return this;
  }
  
  public ajxs d(String paramString)
  {
    this.source = paramString;
    return this;
  }
  
  public void dy(QQAppInterface paramQQAppInterface)
  {
    if (this.cqG) {
      this.d1 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
    }
    if (this.cqH) {
      this.d1 = ("" + ajrb.c(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
    }
    long l = System.currentTimeMillis() - ady;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000)
    {
      this.bSN = (l + "");
      this.feedid = feedId;
      this.bSO = bSL;
      this.source = from;
      this.networktype = (jqc.getNetWorkType() + "");
      anot.b(paramQQAppInterface, "dc02676", "grp_lbs", this.mToUin, this.mOpType, this.mOpName, this.mOpIn, this.mCount, this.mOpResult, this.d1, this.d2, this.d3, this.d4 + "|" + this.bSN + "|" + this.feedid + "|" + this.bSO + "|" + this.source + "|" + this.networktype);
      return;
    }
  }
  
  public ajxs e(String paramString)
  {
    this.d1 = paramString;
    return this;
  }
  
  public ajxs f(String paramString)
  {
    this.d2 = paramString;
    return this;
  }
  
  public ajxs g(String paramString)
  {
    this.d4 = paramString;
    return this;
  }
  
  public ajxs h(String paramString)
  {
    this.mOpType = paramString;
    return this;
  }
  
  public ajxs i(String paramString)
  {
    this.mOpName = paramString;
    return this;
  }
  
  public void report(QQAppInterface paramQQAppInterface)
  {
    if ((this.cqG) && (paramQQAppInterface != null)) {
      this.d1 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
    }
    if ((this.cqH) && (paramQQAppInterface != null))
    {
      this.cqH = true;
      this.d1 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("gender", 0));
    }
    this.networktype = (jqc.getNetWorkType() + "");
    anot.b(paramQQAppInterface, "dc02676", "grp_lbs", this.mToUin, this.mOpType, this.mOpName, this.mOpIn, this.mCount, this.mOpResult, this.d1, this.d2, this.d3, this.d4 + "|" + this.bSN + "|" + this.feedid + "|" + this.bSO + "|" + this.source + "|" + this.networktype);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxs
 * JD-Core Version:    0.7.0.1
 */