import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class uum
  extends acdv
{
  public uum(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void N(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.this$0).equals(paramString))
    {
      if (!paramBoolean) {
        break label152;
      }
      paramString = DiscussionInfoCardActivity.a(this.this$0).a(paramString);
      if (paramString != null)
      {
        DiscussionInfoCardActivity.a(this.this$0, paramString.discussionName);
        DiscussionInfoCardActivity.a(this.this$0, DiscussionInfoCardActivity.b(this.this$0));
      }
      if ((DiscussionInfoCardActivity.a(this.this$0) != null) && (DiscussionInfoCardActivity.a(this.this$0).isShowing()) && (!this.this$0.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.this$0).setMessage(this.this$0.getString(2131691365));
        DiscussionInfoCardActivity.a(this.this$0).setTipImageView(2130840113);
        DiscussionInfoCardActivity.a(this.this$0).showProgerss(false);
        this.this$0.q.sendEmptyMessageDelayed(17, 1500L);
      }
    }
    label152:
    do
    {
      return;
      DiscussionInfoCardActivity.a(this.this$0, DiscussionInfoCardActivity.b(this.this$0));
    } while ((DiscussionInfoCardActivity.a(this.this$0) == null) || (!DiscussionInfoCardActivity.a(this.this$0).isShowing()) || (this.this$0.isFinishing()));
    DiscussionInfoCardActivity.a(this.this$0).setMessage(this.this$0.getString(2131691363));
    DiscussionInfoCardActivity.a(this.this$0).setTipImageView(2130840113);
    DiscussionInfoCardActivity.a(this.this$0).showProgerss(false);
    this.this$0.q.sendEmptyMessageDelayed(17, 1500L);
  }
  
  protected void V(boolean paramBoolean, String paramString)
  {
    if (DiscussionInfoCardActivity.a(this.this$0).equals(paramString))
    {
      if (!paramBoolean) {
        break label110;
      }
      if ((DiscussionInfoCardActivity.a(this.this$0) != null) && (DiscussionInfoCardActivity.a(this.this$0).isShowing()) && (!this.this$0.isFinishing()))
      {
        DiscussionInfoCardActivity.a(this.this$0).setMessage(this.this$0.getString(2131693297));
        DiscussionInfoCardActivity.a(this.this$0).setTipImageView(2130840113);
        DiscussionInfoCardActivity.a(this.this$0).showProgerss(false);
        this.this$0.q.sendEmptyMessageDelayed(16, 1500L);
      }
    }
    label110:
    while ((DiscussionInfoCardActivity.a(this.this$0) == null) || (!DiscussionInfoCardActivity.a(this.this$0).isShowing()) || (this.this$0.isFinishing())) {
      return;
    }
    DiscussionInfoCardActivity.a(this.this$0).setMessage(this.this$0.getString(2131693293));
    DiscussionInfoCardActivity.a(this.this$0).setTipImageView(2130840095);
    DiscussionInfoCardActivity.a(this.this$0).showProgerss(false);
    this.this$0.q.sendEmptyMessageDelayed(17, 1500L);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onGetFlyTicket: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        paramString1 = acfp.m(2131705142);
      }
      for (;;)
      {
        this.this$0.aL(2130840095, paramString1);
        return;
        paramString1 = acfp.m(2131705157);
        continue;
        paramString1 = acfp.m(2131705153);
      }
    }
    SharedPreferences.Editor localEditor = this.this$0.getSharedPreferences("qrcode", 0).edit();
    localEditor.putLong("discussionvalidtime" + DiscussionInfoCardActivity.a(this.this$0), paramLong1);
    localEditor.putString("discussion" + DiscussionInfoCardActivity.a(this.this$0), paramString2);
    localEditor.putString("discussionfullSig" + DiscussionInfoCardActivity.a(this.this$0), paramString1);
    localEditor.commit();
    this.this$0.mValidTime = paramLong1;
    this.this$0.aCs = paramString2;
    this.this$0.aCt = paramString1;
    this.this$0.aVB = true;
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onCollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.this$0))))
    {
      anot.a(this.this$0.app, "CliOper", "", "", "discuss", "discuss_common", 0, 0, "", "", "", "");
      if (!this.this$0.isFinishing())
      {
        paramLong = this.this$0.app.getApp().getSharedPreferences(this.this$0.app.getCurrentAccountUin(), 0);
        if (paramLong.getBoolean("multi_chat_set_common_use_key", true))
        {
          this.this$0.L = aqha.a(this.this$0, 230, this.this$0.getString(2131696106), this.this$0.getString(2131696105), 2131721058, 2131720564, new uun(this), null);
          this.this$0.L.show();
          paramLong.edit().putBoolean("multi_chat_set_common_use_key", false).commit();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if ((paramBoolean) && (paramLong1 != null) && (String.valueOf(paramLong1).equals(DiscussionInfoCardActivity.a(this.this$0))))
    {
      DiscussionInfoCardActivity.c(this.this$0);
      return;
    }
    QQToast.a(this.this$0, 1, this.this$0.getString(2131692874), 0).show(this.this$0.getTitleBarHeight());
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == Long.valueOf(DiscussionInfoCardActivity.a(this.this$0)).longValue()))
    {
      DiscussionInfoCardActivity.c(this.this$0);
      this.this$0.aL(2, this.this$0.getString(2131689767));
    }
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    if ((paramBoolean) && (paramLong != null) && (String.valueOf(paramLong).equals(DiscussionInfoCardActivity.a(this.this$0)))) {}
  }
  
  protected void p(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(DiscussionInfoCardActivity.a(this.this$0));
    if (i != -1)
    {
      paramObject = (Boolean)paramObject.get(i + 1);
      if ((paramBoolean) && (paramObject.booleanValue()))
      {
        this.this$0.a = DiscussionInfoCardActivity.a(this.this$0).a(DiscussionInfoCardActivity.a(this.this$0));
        DiscussionInfoCardActivity.c(this.this$0);
        this.this$0.bNd();
        this.this$0.bNn();
        DiscussionInfoCardActivity.d(this.this$0);
      }
    }
  }
  
  protected void w(Object[] paramArrayOfObject)
  {
    String str = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    paramArrayOfObject = (String)paramArrayOfObject[2];
    if ((paramArrayOfObject == null) || (paramArrayOfObject.trim().equals(""))) {
      paramArrayOfObject = this.this$0.getString(2131694582);
    }
    for (;;)
    {
      if ((DiscussionInfoCardActivity.a(this.this$0).equals(str)) && (!this.this$0.isFinishing()))
      {
        if ((10001 == i) || (10002 == i)) {
          aqha.a(this.this$0, 230, null, paramArrayOfObject, new uuo(this, str), null).show();
        }
      }
      else {
        return;
      }
      this.this$0.aL(1, paramArrayOfObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uum
 * JD-Core Version:    0.7.0.1
 */