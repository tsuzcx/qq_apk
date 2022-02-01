import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.1;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.5;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ReqBody;

public class agoo
  implements amkg.a, amwd<agor>
{
  private List<amjz> Bx;
  private long Zp;
  private long Zq;
  private agny a;
  private amkg b;
  private String bIF = "";
  private String bIG = "";
  private amwe<agor> c;
  private int cYl = 0;
  private int cYn = 1;
  private volatile boolean ceB;
  private boolean ceC;
  private boolean ceD;
  private volatile boolean ceE = true;
  protected accd d = new agop(this);
  public List<Long> jf;
  private QQAppInterface mApp;
  private Context mContext;
  private List<apen> mSearchResultList;
  
  public agoo(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt, agny paramagny)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.cYl = paramInt;
    this.Zp = paramLong;
    this.a = paramagny;
  }
  
  private void Jb(String paramString)
  {
    for (;;)
    {
      try
      {
        QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. keyWord[" + paramString + "]");
        boolean bool = this.ceC;
        if (bool) {
          return;
        }
        if (this.Bx == null)
        {
          this.ceB = true;
          QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. friend set is null. wait");
          continue;
        }
        if (this.b == null) {
          break label93;
        }
      }
      finally {}
      this.b.cancel(true);
      this.b = null;
      label93:
      QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. success.");
      this.b = new amkg(paramString, paramString, this.Bx, this);
      this.b.start();
    }
  }
  
  private void Q(boolean paramBoolean, List<apen> paramList)
  {
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.3(this, paramBoolean, paramList));
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, List<Long> paramList, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        QLog.i("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch.");
        boolean bool = this.ceE;
        if (!bool) {
          return;
        }
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.d("TroopFileSearchEngine<QFile>", 1, "doReqTroopFileSearch err marchWord is null--------------");
          continue;
        }
        this.Zq = System.currentTimeMillis();
      }
      finally {}
      this.ceE = false;
      Object localObject = new cmd0x383.ApplyFileSearchReqBody();
      ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
      if (paramList != null) {
        ((cmd0x383.ApplyFileSearchReqBody)localObject).uint64_uin_list.set(paramList);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_sync_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      ((cmd0x383.ApplyFileSearchReqBody)localObject).uint32_count.set(20);
      paramList = new cmd0x383.ReqBody();
      paramList.uint64_groupcode.set(paramLong);
      paramList.uint32_app_id.set(3);
      paramList.msg_file_search_req_body.set((MessageMicro)localObject);
      paramList.setHasFlag(true);
      localObject = new Bundle();
      ((Bundle)localObject).putLong("troopUin", paramLong);
      ((Bundle)localObject).putString("reqKeyword", paramString1);
      ((accc)paramQQAppInterface.getBusinessHandler(22)).a("GroupFileAppSvr.GetFileSearch", paramList.toByteArray(), (Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch troopUin = " + paramLong + ", marchWord = " + paramString1 + ", cookie = " + paramString2);
      }
    }
  }
  
  private void diy()
  {
    this.ceB = false;
    this.ceC = false;
    this.ceD = false;
    this.bIF = "";
    this.bIG = "";
    this.ceE = true;
    if (this.mSearchResultList != null)
    {
      this.mSearchResultList.clear();
      this.mSearchResultList = null;
    }
  }
  
  private void diz()
  {
    ThreadManagerV2.executeOnSubThread(new TroopFileSearchEngine.2(this));
  }
  
  public void Jc(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.bIG)))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. keyword is not match keyWord[" + paramString + "] lastKeyWord[" + this.bIG + "]");
      return;
    }
    if (!this.ceE)
    {
      QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish.");
      return;
    }
    QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish. keyWord[" + paramString + "] lastKeyWord[" + this.bIG + "]");
    a(this.mApp, this.Zp, this.jf, this.bIG, this.bIF);
  }
  
  public void M(int paramInt, List<? extends amka> paramList)
  {
    QLog.i("TroopFileSearchEngine<QFile>", 4, "onSearchFinish. search contact with keyWord finish.");
    ThreadManagerV2.getUIHandlerV2().post(new TroopFileSearchEngine.5(this, paramInt, paramList));
  }
  
  public void On(int paramInt)
  {
    this.cYn = paramInt;
  }
  
  public List<agor> a(amwt paramamwt)
  {
    return null;
  }
  
  public void a(amwt paramamwt, amwe<agor> paramamwe)
  {
    if ((paramamwt == null) || (paramamwt.keyword == null) || (TextUtils.isEmpty(paramamwt.keyword.trim()))) {
      return;
    }
    if (this.c == null) {
      this.c = paramamwe;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileSearchEngine.1(this), 800L);
  }
  
  public void cancel()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "cancel.");
    }
    diy();
  }
  
  public void destroy()
  {
    if (this.d != null) {
      this.mApp.removeObserver(this.d);
    }
    if (this.Bx != null)
    {
      this.Bx.clear();
      this.Bx = null;
    }
    if (this.b != null) {
      this.b.cancel(true);
    }
  }
  
  public void init()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "init. get contact info.");
    }
    diz();
  }
  
  public boolean mB(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.bIG))) {
      return this.ceD;
    }
    return true;
  }
  
  public void pause()
  {
    if (this.d != null) {
      this.mApp.removeObserver(this.d);
    }
  }
  
  public void resume()
  {
    if (this.d != null) {
      this.mApp.addObserver(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agoo
 * JD-Core Version:    0.7.0.1
 */