import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afwt
  extends afsr
{
  public afwt(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  protected void Be(int paramInt)
  {
    aizy.a(this.this$0.I, ExtendFriendLimitChatMatchFragment.a(this.this$0).app);
  }
  
  protected void a(boolean paramBoolean1, ArrayList<afub> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3)
  {
    paramBoolean2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatMatchFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean1);
    }
    if (paramBoolean1)
    {
      if (paramInt > 0) {
        break label130;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "onlineCount  wrong");
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
      {
        if (this.this$0.b == null) {
          break label197;
        }
        this.this$0.b.setUinList(paramArrayList1);
      }
      label85:
      if ((ExtendFriendLimitChatMatchFragment.a(this.this$0) != null) && (!ExtendFriendLimitChatMatchFragment.a(this.this$0).isFinishing()) && (ExtendFriendLimitChatMatchFragment.a(this.this$0).app != null)) {
        break label208;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mActivity finish ");
    }
    label130:
    label197:
    label208:
    do
    {
      return;
      Object localObject = paramInt + BaseApplication.getContext().getResources().getString(2131701166);
      if (ExtendFriendLimitChatMatchFragment.a(this.this$0) != null)
      {
        ExtendFriendLimitChatMatchFragment.a(this.this$0).setText((CharSequence)localObject);
        break;
      }
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mMatchCountTxt is null");
      break;
      QLog.e("ExtendFriendLimitChatMatchFragment", 2, "mHeadsPanleView is null");
      break label85;
      paramArrayList1 = (afsi)ExtendFriendLimitChatMatchFragment.a(this.this$0).app.getManager(264);
      if (paramArrayList1.akd())
      {
        ExtendFriendLimitChatMatchFragment.a(this.this$0).setVisibility(0);
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "signalBtn VISIBLE with controlbit");
        if (!paramBoolean3) {
          break label454;
        }
        if (paramArrayList1 != null)
        {
          if (paramArrayList1.akd()) {
            break label418;
          }
          ExtendFriendLimitChatMatchFragment.b(this.this$0, true);
          QLog.e("ExtendFriendLimitChatMatchFragment", 2, "bSignalBombOpen FALSE BUG signaflag open NEED PB CLOSE");
        }
      }
      for (;;)
      {
        if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (ExtendFriendLimitChatMatchFragment.a(this.this$0) == null)) {
          break label592;
        }
        paramInt = 0;
        while (paramInt < paramArrayList.size())
        {
          localObject = (afub)paramArrayList.get(paramInt);
          if (!TextUtils.isEmpty(((afub)localObject).tagName)) {
            ExtendFriendLimitChatMatchFragment.a(this.this$0, ExtendFriendLimitChatMatchFragment.a(this.this$0) + ((afub)localObject).tagName + ";");
          }
          paramInt += 1;
        }
        ExtendFriendLimitChatMatchFragment.a(this.this$0).setVisibility(8);
        QLog.d("ExtendFriendLimitChatMatchFragment", 2, "signalBtn GONE with controlbit");
        break;
        if (!afwz.yQ())
        {
          ExtendFriendLimitChatMatchFragment.b(this.this$0, true);
          ExtendFriendLimitChatMatchFragment.e(this.this$0);
        }
        else
        {
          ExtendFriendLimitChatMatchFragment.a(this.this$0, true, true);
          continue;
          ExtendFriendLimitChatMatchFragment.a(this.this$0, false, true);
        }
      }
      paramBoolean1 = paramBoolean2;
      if (paramArrayList1 != null) {
        paramBoolean1 = paramArrayList1.akc();
      }
      paramInt = paramArrayList.size() - 1;
      while (paramInt >= 0)
      {
        if ((((afub)paramArrayList.get(paramInt)).tagId == 10000) && (!paramBoolean1))
        {
          QLog.e("ExtendFriendLimitChatMatchFragment", 2, "MATCH_CHAT_TAG_ID_FOR_VOICE_MATCH REMOVE by flag");
          paramArrayList.remove(paramInt);
        }
        paramInt -= 1;
      }
      paramArrayList1 = new afzn();
      paramArrayList1.eh(paramArrayList);
      if (paramArrayList.size() <= 0) {
        break label583;
      }
    } while (ExtendFriendLimitChatMatchFragment.a(this.this$0) == null);
    label418:
    label454:
    ExtendFriendLimitChatMatchFragment.a(this.this$0).setAdapter(paramArrayList1);
    return;
    label583:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TaginfoInfo size 0");
    return;
    label592:
    QLog.e("ExtendFriendLimitChatMatchFragment", 2, "TagInfo size 0");
  }
  
  protected void aB(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatMatchFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((ExtendFriendLimitChatMatchFragment.a(this.this$0) == 1) && (ExtendFriendLimitChatMatchFragment.a(this.this$0) != null) && (ExtendFriendLimitChatMatchFragment.a(this.this$0).isResume()) && (ExtendFriendLimitChatMatchFragment.a(this.this$0).getState() != 2) && (!ExtendFriendLimitChatMatchFragment.a(this.this$0))) {
      ExtendFriendLimitChatMatchFragment.a(this.this$0, afwz.a(ExtendFriendLimitChatMatchFragment.a(this.this$0), ExtendFriendLimitChatMatchFragment.a(this.this$0).app, ExtendFriendLimitChatMatchFragment.a(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwt
 * JD-Core Version:    0.7.0.1
 */