import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.b;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class abbt
  extends acfd
{
  public abbt(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    paramArrayOfObject = (String[])paramArrayOfObject[1];
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onSetSpecialCareSwitch_global isSucess= " + paramBoolean + ",type=" + i + ",uinSize=" + paramArrayOfObject.length);
    }
    if ((SpecailCareListActivity.a(this.this$0) != null) && (paramArrayOfObject != null)) {}
    for (boolean bool = Arrays.equals(SpecailCareListActivity.a(this.this$0), paramArrayOfObject);; bool = false)
    {
      if (bool) {
        if (paramArrayOfObject.length >= 1)
        {
          this.this$0.hideProgressDialog();
          if (paramBoolean) {
            if (this.this$0.nn != null)
            {
              this.this$0.cAS();
              QQToast.a(BaseApplication.getContext(), 2, 2131689767, 0).show(this.this$0.getTitleBarHeight());
              this.this$0.cAQ();
              this.this$0.a.notifyDataSetChanged();
            }
          }
        }
      }
      while (!paramBoolean)
      {
        do
        {
          for (;;)
          {
            return;
            QQToast.a(BaseApplication.getContext(), 2, 2131701731, 0).show(this.this$0.getTitleBarHeight());
          }
          if (this.this$0.nn != null)
          {
            QQToast.a(BaseApplication.getContext(), 1, 2131701714, 0).show(this.this$0.getTitleBarHeight());
            return;
          }
          QQToast.a(BaseApplication.getContext(), 1, 2131701730, 0).show(this.this$0.getTitleBarHeight());
          return;
        } while (!paramBoolean);
        this.this$0.cAQ();
        this.this$0.a.notifyDataSetChanged();
        return;
      }
      this.this$0.cAQ();
      this.this$0.a.notifyDataSetChanged();
      return;
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateDelFriend isSucess= " + paramBoolean + ", uin=" + (Long)paramObject);
    }
    if (paramBoolean)
    {
      this.this$0.cAQ();
      this.this$0.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateFriendList isSuccess=" + paramBoolean1 + ", isComplete=" + paramBoolean2 + " mIsPullRefresh=" + this.this$0.bBM);
    }
    if ((!paramBoolean1) || (paramBoolean2))
    {
      this.this$0.cAQ();
      this.this$0.a.notifyDataSetChanged();
    }
    if (this.this$0.bBM)
    {
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label135;
      }
      this.this$0.g.tT(0);
      this.this$0.mHandler.sendEmptyMessageDelayed(2001, 1000L);
      this.this$0.bBM = false;
    }
    label135:
    while (paramBoolean1) {
      return;
    }
    this.this$0.g.tT(1);
    this.this$0.mHandler.sendEmptyMessageDelayed(2001, 1000L);
    this.this$0.bBM = false;
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateSignature isSucess= " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.this$0.mScrollState != 0) {
        this.this$0.bBN = true;
      }
    }
    else {
      return;
    }
    this.this$0.a.notifyDataSetChanged();
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateSignature isSucess= " + paramBoolean);
    }
    if (this.this$0.mScrollState != 0)
    {
      this.this$0.bBN = true;
      return;
    }
    this.this$0.a.notifyDataSetChanged();
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onUpdateSpecialCareList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.this$0.cAQ();
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbt
 * JD-Core Version:    0.7.0.1
 */