import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity.7.1;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity.7.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.List;

public class vmm
  extends acfd
{
  public vmm(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean)
    {
      this.this$0.cf(2131719591, 1);
      this.this$0.ay.setOnCheckedChangeListener(null);
      this.this$0.ay.setChecked(true);
      this.this$0.ay.setOnCheckedChangeListener(this.this$0);
    }
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean)
    {
      this.this$0.cf(2131719591, 1);
      this.this$0.ay.setOnCheckedChangeListener(null);
      this.this$0.ay.setChecked(false);
      this.this$0.ay.setOnCheckedChangeListener(this.this$0);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((!this.this$0.e.uin.equals(paramString1)) || (!ProfileActivity.AllInOne.b(this.this$0.e))) {
      return;
    }
    if (paramBoolean)
    {
      this.this$0.aOQ = paramString2;
      this.this$0.vx(paramString2);
      if ((this.this$0.bFB & 0x1) == 1)
      {
        paramString1 = this.this$0;
        if (!paramBoolean) {
          break label189;
        }
        paramByte = 2131694915;
        label77:
        if (!paramBoolean) {
          break label196;
        }
      }
    }
    label187:
    label189:
    label196:
    for (int i = 2;; i = 1)
    {
      paramString1.cf(paramByte, i);
      this.this$0.bFB &= 0xFFFFFFFE;
      return;
      paramString1 = (acff)this.this$0.app.getManager(51);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = paramString1.e(this.this$0.e.uin))
      {
        if (paramString1 == null) {
          break label187;
        }
        if (paramString1.remark != null) {
          this.this$0.aOQ = paramString1.remark;
        }
        this.this$0.vx(this.this$0.aOQ);
        break;
      }
      break;
      paramByte = 2131694914;
      break label77;
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.this$0.e.uin.equals(String.valueOf(paramObject))))
    {
      this.this$0.cf(2131692481, 2);
      if (this.this$0.L == null) {
        this.this$0.L = new Intent();
      }
      this.this$0.L.putExtra("finchat", true);
      this.this$0.setResult(-1, this.this$0.L);
      this.this$0.finish();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2) && (this.this$0.e.uin != null) && (ProfileActivity.AllInOne.b(this.this$0.e)))
    {
      localObject2 = (acff)this.this$0.app.getManager(51);
      if (localObject2 != null) {
        break label171;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        if (((Friends)localObject1).remark != null) {
          this.this$0.aOQ = ((Friends)localObject1).remark;
        }
        this.this$0.vx(this.this$0.aOQ);
        localObject1 = ((acff)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
        if ((localObject1 != null) && (!aqft.equalsWithNullCheck(this.this$0.aOP, ((Groups)localObject1).group_name)))
        {
          this.this$0.aOP = ((Groups)localObject1).group_name;
          localObject2 = this.this$0.Y;
          if (!TextUtils.isEmpty(this.this$0.aOP)) {
            break label190;
          }
        }
      }
    }
    label171:
    label190:
    for (Object localObject1 = "";; localObject1 = this.this$0.aOP)
    {
      ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
      return;
      localObject1 = ((acff)localObject2).e(this.this$0.e.uin);
      break;
    }
  }
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (!String.valueOf(paramLong).equals(this.this$0.e.uin)) {}
    do
    {
      return;
      if (!paramBoolean1) {}
      for (paramBoolean1 = true; Thread.currentThread() == Looper.getMainLooper().getThread(); paramBoolean1 = false)
      {
        this.this$0.aT(paramBoolean2, paramBoolean1);
        return;
      }
    } while (this.this$0.ax == null);
    this.this$0.ax.post(new ProfileCardMoreActivity.7.2(this, paramBoolean2, paramBoolean1));
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((this.this$0.e == null) || (TextUtils.isEmpty(this.this$0.e.uin)) || (!aqft.equalsWithNullCheck(this.this$0.e.uin, paramString))) {}
    for (;;)
    {
      return;
      paramString = (acff)this.this$0.app.getManager(51);
      if (paramString == null) {}
      for (paramString = null; (paramString != null) && (!aqft.equalsWithNullCheck(this.this$0.aOP, paramString.group_name)); paramString = paramString.a(String.valueOf(paramByte1)))
      {
        this.this$0.aOP = paramString.group_name;
        this.this$0.runOnUiThread(new ProfileCardMoreActivity.7.1(this));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmm
 * JD-Core Version:    0.7.0.1
 */