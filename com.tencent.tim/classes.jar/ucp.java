import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AccountManageActivity.25.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.List;

public class ucp
  extends acfd
{
  public ucp(AccountManageActivity paramAccountManageActivity) {}
  
  void cf(String paramString, int paramInt)
  {
    this.this$0.runOnUiThread(new AccountManageActivity.25.1(this, paramString, paramInt));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (this.this$0.fJ != null) {
        i = this.this$0.fJ.getChildCount();
      }
      while (j < this.this$0.qg.size())
      {
        if ((i > j) && (this.this$0.qg.get(j) != null) && (paramString.equals(((SimpleAccount)this.this$0.qg.get(j)).getUin())))
        {
          cf(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    Object localObject3 = (anxr)this.this$0.app.getManager(61);
    Object localObject1 = "";
    int i = ((anxr)localObject3).Kx();
    label67:
    label124:
    Object localObject2;
    if (i == 0)
    {
      AccountManageActivity.a(this.this$0).setVisibility(8);
      AccountManageActivity.b(this.this$0).setVisibility(8);
      if (AppSetting.enableTalkBack) {
        AccountManageActivity.a(this.this$0).setContentDescription("关联QQ号" + (String)localObject1);
      }
      if (this.this$0.fJ == null) {
        break label566;
      }
      i = this.this$0.fJ.getChildCount();
      if (j >= this.this$0.qg.size()) {
        break label569;
      }
      if ((i > j) && (this.this$0.qg.get(j) != null) && (paramString.equals(((SimpleAccount)this.this$0.qg.get(j)).getUin())))
      {
        localObject1 = (TextView)this.this$0.fJ.getChildAt(j).findViewById(2131372190);
        localObject2 = (TextView)this.this$0.fJ.getChildAt(j).findViewById(2131361874);
        ((TextView)localObject1).setText(aqgv.n(this.this$0.app, paramString));
        ((TextView)localObject2).setText(paramString);
        cf(paramString, j);
      }
    }
    else if (i == 1)
    {
      localObject3 = ((anxr)localObject3).a("sub.uin.default");
      if (localObject3 == null) {
        break label571;
      }
      localObject2 = aqgv.c(this.this$0.app, ((SubAccountInfo)localObject3).subuin, false);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        if (!TextUtils.isEmpty(((SubAccountInfo)localObject3).subname))
        {
          localObject1 = localObject2;
          if (((String)localObject2).equals(((SubAccountInfo)localObject3).subname)) {}
        }
        else
        {
          ((SubAccountInfo)localObject3).subname = ((String)localObject2);
          this.this$0.h(AccountManageActivity.b(this.this$0), ((SubAccountInfo)localObject3).subuin);
          AccountManageActivity.b(this.this$0).setVisibility(0);
          AccountManageActivity.a(this.this$0).setVisibility(8);
          localObject1 = localObject2;
          if (AppSetting.enableTalkBack) {
            AccountManageActivity.a(this.this$0).setContentDescription("关联QQ号" + (String)localObject2);
          }
        }
      }
    }
    label566:
    label569:
    label571:
    for (localObject1 = localObject2;; localObject1 = "")
    {
      break label67;
      localObject2 = i + acfp.m(2131701969);
      localObject3 = ((anxr)localObject3).dK();
      localObject1 = localObject2;
      if (((ArrayList)localObject3).size() != 2) {
        break label67;
      }
      this.this$0.h(AccountManageActivity.b(this.this$0), (String)((ArrayList)localObject3).get(0));
      AccountManageActivity.b(this.this$0).setVisibility(0);
      this.this$0.h(AccountManageActivity.b(this.this$0), (String)((ArrayList)localObject3).get(1));
      AccountManageActivity.a(this.this$0).setVisibility(0);
      localObject1 = localObject2;
      break label67;
      j += 1;
      break label124;
      i = 0;
      break label124;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucp
 * JD-Core Version:    0.7.0.1
 */