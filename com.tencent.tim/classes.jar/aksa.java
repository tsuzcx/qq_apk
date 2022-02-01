import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class aksa
  extends achq
{
  aksa(akrv paramakrv) {}
  
  public void a(boolean paramBoolean, String paramString, anxt paramanxt)
  {
    if (akrv.a(this.this$0, paramBoolean, paramString, paramanxt)) {}
    for (;;)
    {
      return;
      if (akrv.a(this.this$0))
      {
        if (paramBoolean) {
          akrv.c(this.this$0, true);
        }
        if (akrv.b(this.this$0) > 0) {
          akrv.c(this.this$0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "onSubAccountThirdQQUnreadMsgNum() mRequestNum = " + akrv.b(this.this$0));
        }
        if (akrv.b(this.this$0) == 0)
        {
          akrv.b(this.this$0, false);
          if (akrv.b(this.this$0)) {
            akrv.a(this.this$0);
          }
        }
      }
      else if ((paramBoolean) && (akrv.a(this.this$0) != null))
      {
        int j = akrv.a(this.this$0).getChildCount();
        int i = 0;
        while (i < j)
        {
          paramanxt = akrv.a(this.this$0).getChildAt(i);
          paramString = (String)paramanxt.getTag(2131361946);
          if ((!TextUtils.isEmpty(paramString)) && ((paramanxt.getTag() instanceof akrv.a)))
          {
            paramanxt = (akrv.a)paramanxt.getTag();
            if (paramanxt.type == 1) {
              paramanxt.bI(anxk.l(akrv.a(this.this$0), paramString), false);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString, anxs paramanxs)
  {
    if (akrv.a(this.this$0, paramString, paramanxs)) {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!akrv.a(this.this$0)) {
              break;
            }
            if (paramBoolean) {
              akrv.c(this.this$0, true);
            }
            if (akrv.b(this.this$0) > 0) {
              akrv.c(this.this$0);
            }
            if (QLog.isColorLevel()) {
              QLog.d("AccountPanel", 2, "onGetSubAccountMsg() mRequestNum=" + akrv.b(this.this$0));
            }
          } while (akrv.b(this.this$0) != 0);
          akrv.b(this.this$0, false);
        } while (!akrv.b(this.this$0));
        akrv.a(this.this$0);
        return;
      } while (!paramBoolean);
      paramanxs = akrv.a(this.this$0, paramString);
    } while (paramanxs == null);
    paramString = anxk.a(akrv.a(this.this$0), paramString);
    paramanxs.bI(paramString.unReadCount, paramString.showRedDot);
  }
  
  public void h(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (akrv.a(this.this$0) == null)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("AccountPanel onSubAccountMsgNumConfirm isSuccess=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("AccountPanel", 2, paramBoolean + " nextAction=" + paramString2);
      if (paramString1.equals(akrv.a(this.this$0).getUin())) {
        this.this$0.d(akrv.a(this.this$0));
      }
      akrv.a(this.this$0, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksa
 * JD-Core Version:    0.7.0.1
 */