import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class wwb
  implements wvs
{
  public ajgw a;
  private BaseChatPie a;
  private QQAppInterface app;
  private Activity mActivity;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  public wwb(BaseChatPie paramBaseChatPie)
  {
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.sessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  private void gl(List<ChatMessage> paramList)
  {
    ajlc.a().lx(paramList);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "multiForwardSperate|checklist.size = " + paramList.size());
    }
    if (paramList.size() == 0) {
      return;
    }
    ajlc.a().xL.clear();
    ajlc.a().xL.addAll(paramList);
    ajlc.a().lD.clear();
    ajlc.a().lD.put(this.app.getCurrentUin(), this.app.getCurrentNickname());
    b(ajlc.a().lD, ajlc.a().xL, 1);
    switch (this.sessionInfo.cZ)
    {
    default: 
      paramList = "0X80078B8";
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      paramList = "0X80078B8";
      continue;
      paramList = "0X80078B9";
      continue;
      paramList = "0X80078BA";
    }
  }
  
  private void gm(List<ChatMessage> paramList)
  {
    ausj localausj = (ausj)auss.a(this.mActivity, null);
    localausj.addButton(this.mActivity.getString(2131696130));
    localausj.addButton(this.mActivity.getString(2131696131));
    localausj.addCancelButton(2131721058);
    localausj.a(new wwc(this, paramList, localausj));
    localausj.show();
  }
  
  public int[] C()
  {
    return new int[] { 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Ajgw == null);
    this.jdField_a_of_type_Ajgw.destroy();
    this.jdField_a_of_type_Ajgw = null;
  }
  
  public void I(List<ChatMessage> paramList, int paramInt)
  {
    if (!aqiw.isNetSupport(this.mContext)) {
      QQToast.a(this.app.getApp(), 2131693404, 0).show(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getTitleBarHeight());
    }
    do
    {
      return;
      ajlc.a().lx(paramList);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.am(2131700604);
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = top.g((ChatMessage)((Iterator)localObject).next());
      if (!localArrayList.contains(str)) {
        localArrayList.add(str);
      }
    }
    ajlc.a().xL.clear();
    ajlc.a().xL.addAll(paramList);
    ajlc.a().djF = paramInt;
    if (this.sessionInfo.cZ == 1)
    {
      ((acms)this.app.getBusinessHandler(20)).a(this.sessionInfo.aTl, localArrayList, false, null);
      paramList = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getUIHandler();
      localObject = paramList.obtainMessage(24);
      ((Message)localObject).arg1 = localArrayList.size();
      paramList.sendMessageDelayed((Message)localObject, 30000L);
      switch (this.sessionInfo.cZ)
      {
      default: 
        paramList = "0X80078BB";
      }
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      if ((this.sessionInfo.cZ != 0) && (this.sessionInfo.cZ != 3000) && (this.sessionInfo.cZ != 1000) && (this.sessionInfo.cZ != 1004)) {
        break;
      }
      ((FriendListHandler)this.app.getBusinessHandler(1)).E(localArrayList);
      break;
      paramList = "0X80078BB";
      continue;
      paramList = "0X80078BC";
      continue;
      paramList = "0X80078BD";
    }
  }
  
  public void a(wki paramwki, boolean paramBoolean)
  {
    if (!aqiw.isNetSupport(this.mContext)) {
      QQToast.a(this.app.getApp(), 2131693404, 0).show(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getTitleBarHeight());
    }
    do
    {
      return;
      paramwki = ajlc.a().fH();
      paramwki = ajlg.a(this.app, (ArrayList)paramwki);
    } while ((paramwki == null) || (paramwki.size() == 0));
    if (paramBoolean)
    {
      I(paramwki, 2);
      return;
    }
    gm(paramwki);
  }
  
  public void aAL()
  {
    if (this.jdField_a_of_type_Ajgw == null) {
      this.jdField_a_of_type_Ajgw = new ajgw(this.app, this.mContext, this.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getUIHandler());
    }
    this.jdField_a_of_type_Ajgw.aAL();
  }
  
  public void b(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 4) {
      if (this.jdField_a_of_type_Ajgw != null) {
        this.jdField_a_of_type_Ajgw.d(paramMap, paramArrayList);
      }
    }
    do
    {
      return;
      if (paramInt != 3) {
        break;
      }
    } while (this.jdField_a_of_type_Ajgw == null);
    this.jdField_a_of_type_Ajgw.c(paramMap, paramArrayList);
    return;
    String str = " ";
    label78:
    Context localContext;
    if (this.sessionInfo.cZ == 0)
    {
      str = aqgv.t(this.app, this.sessionInfo.aTl);
      localContext = this.mContext;
      if (paramInt == 1) {
        break label182;
      }
    }
    for (;;)
    {
      paramMap = ujt.a(localContext, str, paramArrayList, paramMap, bool);
      if (paramMap == null) {
        break;
      }
      if (paramInt != 2) {
        break label188;
      }
      ajlc.a().a(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.troopUin, paramMap, 0L, false, paramInt);
      return;
      if ((this.sessionInfo.cZ != 1) && (this.sessionInfo.cZ != 3000)) {
        break label78;
      }
      str = this.sessionInfo.aTn;
      break label78;
      label182:
      bool = false;
    }
    label188:
    paramMap.mMsg_A_ActionData = null;
    paramArrayList = new Intent();
    paramArrayList.putExtra("forward_type", -3);
    paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
    paramArrayList.putExtra("is_need_show_sources", false);
    paramArrayList.putExtra("forward_msg_from_together", paramInt);
    ahgq.f(this.mActivity, paramArrayList, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwb
 * JD-Core Version:    0.7.0.1
 */