import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

public class jvr
  extends acje
{
  public jvr(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void I(boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    super.I(paramBoolean, paramInt);
    if (this.this$0.a == null) {
      return;
    }
    this.this$0.ack = true;
    if (paramInt == 0)
    {
      jtr localjtr = jub.a(this.this$0.app).a(this.this$0.uin);
      if (localjtr != null)
      {
        this.this$0.a.n(localjtr.ba(), localjtr.isFirstEnter);
        this.this$0.a.bJ(localjtr.ba());
      }
    }
    if (paramBoolean) {
      if (this.this$0.a.mW() == 0)
      {
        paramBoolean = bool1;
        if (paramBoolean) {
          this.this$0.aAe();
        }
        this.this$0.b.lA(paramBoolean);
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "onDynamicListGet: --hasMoreData=" + paramBoolean);
          bool1 = paramBoolean;
        }
        label172:
        if (paramInt != 1) {
          break label246;
        }
      }
    }
    for (this.this$0.errorStatus = AccountDetailActivity.NETWORK_ERROR;; this.this$0.errorStatus = AccountDetailActivity.aDK) {
      label246:
      do
      {
        this.this$0.a.setErrorStatus(this.this$0.errorStatus);
        this.this$0.a.notifyDataSetChanged();
        return;
        paramBoolean = true;
        break;
        this.this$0.a.notifyDataSetChanged();
        this.this$0.b.aAc();
        bool1 = bool2;
        break label172;
      } while ((paramInt != 4) && ((paramInt != 0) || (bool1)));
    }
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    super.a(paramInt, paramPublicAccountInfo);
    refresh();
  }
  
  public void m(boolean paramBoolean, String paramString)
  {
    super.m(paramBoolean, paramString);
    refresh();
  }
  
  void refresh()
  {
    if (this.this$0.abZ) {
      this.this$0.initData();
    }
    this.this$0.abZ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvr
 * JD-Core Version:    0.7.0.1
 */