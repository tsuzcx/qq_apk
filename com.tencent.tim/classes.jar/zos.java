import android.content.Context;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class zos
  implements wvs
{
  public static String TAG = "MiniPie.MiniPieHelper";
  private achq a = new zot(this);
  private QQAppInterface app;
  private zof c;
  private Context mContext;
  boolean mIsMsgSignalOpen = false;
  int mMsgSignalCount = 0;
  int mMsgSignalSum = 0;
  private SessionInfo sessionInfo;
  
  public zos(zof paramzof)
  {
    this.app = paramzof.mApp;
    this.mContext = paramzof.mContext;
    this.c = paramzof;
    this.sessionInfo = paramzof.mSessionInfo;
    TAG = paramzof.TAG + ".Helper";
  }
  
  public static boolean VB()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  static int b(ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "doNewRefreshForAio");
    }
    int j;
    int i;
    if (paramChatXListView.getLastVisiblePosition() >= 0)
    {
      paramList1 = paramChatXListView.getChildAt(paramChatXListView.getChildCount() - 1);
      if (paramList1 != null)
      {
        paramInt = paramList1.getBottom();
        j = paramChatXListView.getHeight();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "refreshlistadapter=====lastbuttom=" + paramInt + " listHeight=" + j);
        }
        i = paramInt;
        paramInt = j;
      }
    }
    for (;;)
    {
      j = k;
      if (i <= paramInt) {
        j = 3;
      }
      return j;
      paramInt = 0;
      break;
      paramInt = 0;
      i = 0;
    }
  }
  
  public int[] C()
  {
    return new int[] { 3, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      this.app.addDefaultObservers(this.a);
      this.app.b().addObserver(this.c);
      bJm();
      return;
    }
    this.app.removeObserver(this.a);
    this.app.b().deleteObserver(this.c);
    bJn();
  }
  
  int a(ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "keepPostionScroll");
    }
    return BaseChatpieHelper.a(TAG, paramChatXListView, paramInt, paramList1, paramList2);
  }
  
  int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "doDefaultSrollPosition");
    }
    int i = paramInt;
    int k;
    int j;
    long l;
    if (paramList1 != paramList2)
    {
      k = paramList1.size();
      j = paramList2.size();
      if ((k <= 0) || (j <= 0)) {
        break label197;
      }
      l = ((ChatMessage)paramList1.get(k - 1)).uniseq;
      i = j - 1;
      if (i < 0) {
        break label197;
      }
      if ((i != j - 1) || (!ahwb.aB((MessageRecord)paramList2.get(i)))) {
        break label132;
      }
      i = -1;
    }
    for (;;)
    {
      label107:
      if (i >= 0) {
        i = j - (k - paramInt + j - 1 - i);
      }
      label132:
      do
      {
        do
        {
          return i;
          if (((ChatMessage)paramList2.get(i)).uniseq == l) {
            break label107;
          }
          i -= 1;
          break;
          i = paramInt;
        } while (j <= 0);
        i = paramInt;
      } while (ahwb.aB((MessageRecord)paramList2.get(j - 1)));
      return j;
      label197:
      i = -1;
    }
  }
  
  protected void a(ujt.d paramd)
  {
    paramd.mMsgSignalCount = this.mMsgSignalCount;
    paramd.mMsgSignalSum = this.mMsgSignalSum;
    paramd.mIsMsgSignalOpen = this.mIsMsgSignalOpen;
    paramd.mMsgSignalNetType = aqiw.getSystemNetwork(BaseApplication.getContext());
    paramd.mMsgSendTime = System.currentTimeMillis();
    paramd.isBarrageMsg = this.c.mSessionInfo.isBarrageMsg;
    paramd.barrageTimeLocation = this.c.mSessionInfo.Ie;
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = this.c.mSourceMsgInfo;
    if ((localSourceMsgInfo != null) && (localSourceMsgInfo.mSourceMsgText.length() > BaseChatPie.bEE))
    {
      localSourceMsgInfo.mSourceMsgText = localSourceMsgInfo.mSourceMsgText.substring(0, BaseChatPie.bEE);
      localSourceMsgInfo.mSourceSummaryFlag = 0;
      if (localSourceMsgInfo.mType == -1036) {
        localSourceMsgInfo.oriMsgType = 1;
      }
    }
    paramd.mSourceMsgInfo = localSourceMsgInfo;
  }
  
  protected void bIN()
  {
    this.c.a.setText("");
    this.c.a.setCompoundDrawables(null, null, null, null);
    this.c.a.setTag(2131374473, null);
    this.c.a.setSelection(0);
    this.c.eE.setEnabled(false);
    if (this.c.mSessionInfo != null) {
      this.c.a.setMinHeight(wja.dp2px(36.0F, this.c.a.getResources()));
    }
    this.c.mSourceMsgInfo = null;
    this.c.mSessionInfo.isBarrageMsg = false;
    this.c.mSessionInfo.Ie = 0L;
  }
  
  public void bJm()
  {
    if (this.c.Vz()) {
      znk.a().a(this.sessionInfo.cZ, this.sessionInfo.aTl, this.c);
    }
  }
  
  public void bJn()
  {
    if (this.c.Vz())
    {
      znk.a().b(this.sessionInfo.cZ, this.sessionInfo.aTl, this.c);
      if ((this.app.b() != null) && (!znk.a().l(this.sessionInfo.cZ, this.sessionInfo.aTl))) {
        this.app.b().aZ(this.sessionInfo.cZ, this.sessionInfo.aTl);
      }
    }
  }
  
  protected void bsq()
  {
    Object localObject1 = "";
    if (this.c.a.getText() != null) {
      localObject1 = this.c.a.getText().toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    int i = ((String)localObject1).length();
    localObject1 = this.c;
    if (i > zof.bEA)
    {
      ChatActivityUtils.h(this.mContext, 2131719509, 1);
      return;
    }
    Object localObject3 = this.c.a;
    Object localObject2 = this.c.mSourceMsgInfo;
    if (((XEditTextEx)localObject3).getTag(2131374473) == null) {
      localObject2 = null;
    }
    for (;;)
    {
      if ((0 == 0) && (localObject2 != null)) {}
      label904:
      for (localObject1 = yfp.c(this.app, this.sessionInfo, (MessageForReplyText.SourceMsgInfo)localObject2);; localObject1 = null)
      {
        Object localObject4 = new ujt.d();
        a((ujt.d)localObject4);
        ((ujt.d)localObject4).barrageSourceMsgType = aeeu.b(this.app, (MessageRecord)localObject1);
        Object localObject5;
        if (((ujt.d)localObject4).isBarrageMsg)
        {
          ((ujt.d)localObject4).barrageSourceMsgType = aeeu.b(this.app, (MessageRecord)localObject1);
          if ((((ujt.d)localObject4).barrageSourceMsgType == 1) || (((ujt.d)localObject4).barrageSourceMsgType == 3)) {
            anot.a(this.app, "dc00898", "", "", "0X800A883", "0X800A883", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.c.mSessionInfo.cZ != 1) && (this.c.mSessionInfo.cZ != 3000)) {
            break label777;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
          }
          if ((localObject2 == null) || (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName)) || (localObject1 != null)) {
            break label910;
          }
          localObject1 = this.c.mSessionInfo.aTl;
          i = this.c.mSessionInfo.cZ;
          localObject5 = this.c.mApp.b().a(this.c.mSessionInfo.aTl, i, -1L, true);
          i = ((List)localObject5).size() - 1;
          label383:
          if (i < 0) {
            break label904;
          }
          localObject1 = (ChatMessage)((List)localObject5).get(i);
          if (((ChatMessage)localObject1).shmsgseq != ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq) {
            break label734;
          }
          label414:
          MessageForReplyText.reportReplyMsg(this.app, "suc_replyMsg", "reply_suc", this.sessionInfo.aTl, (ChatMessage)localObject1);
        }
        label777:
        label910:
        for (;;)
        {
          if (((ujt.d)localObject4).mSourceMsgInfo != null)
          {
            ((ujt.d)localObject4).mSourceMsgInfo.mType = 0;
            if (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForMixedMsg))) {
              ((ujt.d)localObject4).mSourceMsgInfo.oriMsgType = 1;
            }
            if (localObject1 != null) {
              ((ujt.d)localObject4).mSourceMsgInfo.packSourceMsg(this.app, (MessageRecord)localObject1);
            }
          }
          ArrayList localArrayList1 = new ArrayList();
          localObject5 = appb.a(((XEditTextEx)localObject3).getEditableText(), localArrayList1);
          localObject2 = this.c.a(true);
          ArrayList localArrayList2 = new ArrayList();
          localObject3 = appb.a(((XEditTextEx)localObject3).getEditableText(), localArrayList2);
          if (this.c.mSourceMsgInfo != null)
          {
            i = 1;
            label561:
            if (i == 0) {
              break label746;
            }
            alvn.a().a(this.app, this.sessionInfo, (String)localObject5, localArrayList1, (ujt.d)localObject4, (MessageRecord)localObject1, (String)localObject3, localArrayList2);
            if (((ujt.d)localObject4).isBarrageMsg)
            {
              localObject3 = aeer.a();
              long l1 = ((ujt.d)localObject4).mMsgSendTime;
              long l2 = ((ujt.d)localObject4).barrageTimeLocation;
              localObject4 = this.c.mSessionInfo.aTl;
              long l3 = this.c.mSourceMsgInfo.mSourceMsgSeq;
              localObject1 = localObject2;
              if (localArrayList1.isEmpty()) {
                localObject1 = null;
              }
              ((aeer)localObject3).a(l1, l2, (String)localObject5, (String)localObject4, l3, (SpannableString)localObject1);
            }
          }
          for (;;)
          {
            bIN();
            return;
            if ((((ujt.d)localObject4).barrageSourceMsgType != 2) && (((ujt.d)localObject4).barrageSourceMsgType != 4)) {
              break;
            }
            anot.a(this.app, "dc00898", "", "", "0X800A884", "0X800A884", 0, 0, "", "", "", "");
            break;
            label734:
            i -= 1;
            break label383;
            i = 0;
            break label561;
            label746:
            ujt.a(this.c.mApp, this.mContext, this.c.mSessionInfo, (String)localObject5, localArrayList1, (ujt.d)localObject4);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
            }
            localObject1 = new ArrayList();
            localObject2 = appb.a(this.c.a.getEditableText(), (ArrayList)localObject1);
            ujt.a(this.c.mApp, this.mContext, this.c.mSessionInfo, (String)localObject2, (ArrayList)localObject1, (ujt.d)localObject4);
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
            }
          }
          localObject1 = null;
          break label414;
        }
      }
    }
  }
  
  void onScroll(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.c.d;
    int j = ((ChatXListView)localObject).getFooterViewsCount();
    int m = ((ChatXListView)localObject).getHeaderViewsCount();
    int k = paramInt3 - m - j;
    int i = k - (paramInt1 - m) - paramInt2;
    if (QLog.isColorLevel()) {
      QLog.d("MiniPie.onScroll", 2, " listSize =" + k + " chatPie.mReadedCnt =" + this.c.bEg);
    }
    Message localMessage;
    if (this.c.bEg < k)
    {
      paramInt2 = paramInt1 + paramInt2 - j - m;
      paramInt1 = paramInt2;
      if (paramInt2 >= paramInt3 - m - j) {
        paramInt1 = k - 1;
      }
      if (paramInt1 >= this.c.bEg) {
        this.c.bEg = (paramInt1 + j);
      }
      if (i == 0) {
        this.c.bEg = k;
      }
      paramInt1 = k - this.c.bEg;
      if (paramInt1 != this.c.bEh)
      {
        if (this.c.b.hasMessages(5)) {
          this.c.b.removeMessages(5);
        }
        localObject = this.c.b;
        localMessage = this.c.b.obtainMessage(5, paramInt1, i);
        if (!this.c.T.booleanValue()) {
          break label294;
        }
      }
    }
    label294:
    for (long l = 1500L;; l = 0L)
    {
      ((MqqHandler)localObject).sendMessageDelayed(localMessage, l);
      this.c.T = Boolean.valueOf(false);
      this.c.bEh = paramInt1;
      return;
      paramInt1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zos
 * JD-Core Version:    0.7.0.1
 */