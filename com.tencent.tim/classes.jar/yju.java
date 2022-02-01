import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class yju
  implements Handler.Callback, wvs
{
  private long Kd = -1L;
  private aeaz.b jdField_a_of_type_Aeaz$b = new yjy(this);
  private ykb jdField_a_of_type_Ykb;
  private ykh jdField_a_of_type_Ykh;
  private QQAppInterface app;
  private BaseChatPie c;
  private achq g = new yjv(this);
  private boolean isReady;
  private MessageRecord m;
  private aeaz mColorNoteCurd;
  private SessionInfo mSessionInfo;
  private MqqHandler mUIHandler;
  private MessageRecord n;
  
  public yju(BaseChatPie paramBaseChatPie)
  {
    this.app = paramBaseChatPie.app;
    this.c = paramBaseChatPie;
    this.mSessionInfo = paramBaseChatPie.sessionInfo;
    this.mUIHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void c(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (this.m != null)
    {
      ArrayList localArrayList = new ArrayList();
      if (1 == paramInt) {
        if (this.m.uniseq != ((MessageRecord)paramList.get(0)).uniseq) {
          localArrayList.add(paramList.get(0));
        }
      }
      while (!localArrayList.isEmpty())
      {
        a(paramList, paramLong, paramInt);
        return;
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (this.m.uniseq != localMessageRecord.uniseq) {
            localArrayList.add(paramList.get(0));
          }
        }
      }
      QQToast.a(this.c.a(), 1, 2131690255, 0).show();
      return;
    }
    a(paramList, paramLong, paramInt);
  }
  
  private void ciK()
  {
    this.isReady = true;
    ciN();
  }
  
  private void ciL()
  {
    if (this.jdField_a_of_type_Ykh == null) {
      this.jdField_a_of_type_Ykh = new ykh(this.c.a());
    }
  }
  
  private void ciM()
  {
    if (this.mColorNoteCurd == null)
    {
      this.mColorNoteCurd = new aeaz();
      this.mColorNoteCurd.setOnColorNoteCurdListener(this.jdField_a_of_type_Aeaz$b);
    }
  }
  
  private void ciN()
  {
    if ((this.n != null) && (this.isReady))
    {
      if (!(this.c instanceof xys)) {
        break label65;
      }
      ((xys)this.c).a(22, this.n.msgUid, this.n.time, this.n);
    }
    for (;;)
    {
      this.isReady = false;
      this.n = null;
      return;
      label65:
      if (this.c.OP())
      {
        QQMessageFacade.Message localMessage = this.app.b().a(this.mSessionInfo.aTl, this.mSessionInfo.cZ);
        this.c.a(22, this.n.shmsgseq, (int)(localMessage.shmsgseq - this.n.shmsgseq), null);
      }
    }
  }
  
  private void doOnCreate()
  {
    Intent localIntent = this.c.a().getIntent();
    if (localIntent != null) {
      this.Kd = localIntent.getLongExtra("key_uniseq", -1L);
    }
    this.app.addObserver(this.g);
    this.m = null;
  }
  
  private void doOnDestroy()
  {
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(yju.class);
    }
    this.app.removeObserver(this.g);
  }
  
  private void doOnResume()
  {
    this.isReady = false;
    if (this.Kd != -1L)
    {
      this.c.a(false, null, false, false, true);
      long l = this.Kd;
      this.Kd = -1L;
      ThreadManager.getSubThreadHandler().postAtTime(new AIOUpComingMsgHelper.1(this, l), yju.class, 0L);
    }
  }
  
  private void yL(String paramString)
  {
    Object localObject;
    Message localMessage;
    if (this.mSessionInfo.cZ == 1)
    {
      localObject = ((HotChatManager)this.app.getManager(60)).a(paramString);
      localMessage = this.mUIHandler.obtainMessage();
      localMessage.what = 2;
      if (localObject == null) {
        break label123;
      }
      if (((HotChatInfo)localObject).state != 6) {
        break label91;
      }
      localMessage.obj = this.c.a().getResources().getString(2131690275);
    }
    for (;;)
    {
      if (localMessage.obj != null) {
        this.mUIHandler.sendMessage(localMessage);
      }
      return;
      label91:
      if (((HotChatInfo)localObject).state == 7)
      {
        localMessage.obj = this.c.a().getResources().getString(2131690281);
        continue;
        label123:
        localObject = (TroopManager)this.app.getManager(52);
        if (localObject != null)
        {
          paramString = ((TroopManager)localObject).a(paramString + "", true);
          if (paramString != null)
          {
            if ((paramString.isKicked()) || (paramString.isExited())) {
              localMessage.obj = this.c.a().getResources().getString(2131690275);
            } else if (paramString.isDisband()) {
              localMessage.obj = this.c.a().getResources().getString(2131690281);
            }
          }
          else {
            localMessage.obj = this.c.a().getResources().getString(2131690275);
          }
        }
      }
    }
  }
  
  public int[] C()
  {
    return new int[] { 3, 13, 5, 7 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      doOnCreate();
      return;
    case 5: 
      doOnResume();
      return;
    case 7: 
      ciK();
      return;
    }
    doOnDestroy();
  }
  
  public void M(ChatMessage paramChatMessage)
  {
    QLog.d("UpComingMsgLogic.AIOUpComingMsgHelper", 4, paramChatMessage.toString());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramChatMessage);
    ciL();
    this.jdField_a_of_type_Ykh.Ed(1);
    this.jdField_a_of_type_Ykh.a(new yjw(this, localArrayList));
    int i = ykf.e(paramChatMessage);
    anot.a(this.app, "dc00898", "", "", "0X800AE7D", "0X800AE7D", i, 0, "", "", "", "");
  }
  
  ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt)
    throws IllegalAccessException
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if (this.jdField_a_of_type_Ykb == null) {
        this.jdField_a_of_type_Ykb = new ykb(this.app);
      }
      return this.jdField_a_of_type_Ykb.a(paramList, paramLong, 1, this.mSessionInfo);
    }
    if (this.jdField_a_of_type_Ykb == null) {
      this.jdField_a_of_type_Ykb = new ykb(this.app);
    }
    return this.jdField_a_of_type_Ykb.a(paramList, paramLong, 2, this.mSessionInfo);
  }
  
  public void a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    ciM();
    this.mColorNoteCurd.m(0, "update_process_state", false);
    if (!this.mColorNoteCurd.canAddColorNote()) {
      aebs.ed(this.c.a());
    }
    for (;;)
    {
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        ciM();
        try
        {
          paramList = a(paramList, paramLong, paramInt);
          if (paramList != null)
          {
            paramList = paramList.parseBundle();
            this.mColorNoteCurd.cm(paramList);
            return;
          }
        }
        catch (IllegalAccessException paramList)
        {
          QLog.e("UpComingMsgLogic.AIOUpComingMsgHelper", 1, "addColorNote occur error.", paramList);
        }
      }
    }
  }
  
  public void b(List<ChatMessage> paramList, long paramLong, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    ciL();
    this.jdField_a_of_type_Ykh.Ed(2);
    this.jdField_a_of_type_Ykh.a(new yjx(this, localArrayList, paramList));
    anot.a(this.app, "dc00898", "", "", "0X800AE7E", "0X800AE7E", paramList.size(), 0, "", "", "", "");
  }
  
  public void gD(List<ChatMessage> paramList)
  {
    if (!aqiw.isNetSupport(this.c.a())) {
      QQToast.a(this.app.getApp(), 2131693404, 0).show(this.c.getTitleBarHeight());
    }
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = ajlg.a(this.app, (ArrayList)paramList);
      } while ((localObject1 == null) || (((ArrayList)localObject1).size() == 0));
      ajlc.a().lx((List)localObject1);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + ((ArrayList)localObject1).size());
      }
    } while (((ArrayList)localObject1).size() == 0);
    this.c.am(2131700604);
    paramList = new ArrayList();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = top.g((ChatMessage)((Iterator)localObject2).next());
      if (!paramList.contains(str)) {
        paramList.add(str);
      }
    }
    ajlc.a().xL.clear();
    ajlc.a().xL.addAll((Collection)localObject1);
    ajlc.a().djF = 0;
    if (this.mSessionInfo.cZ == 1) {
      ((acms)this.app.getBusinessHandler(20)).a(this.mSessionInfo.aTl, paramList, false, null);
    }
    for (;;)
    {
      localObject1 = this.c.getUIHandler();
      localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
      ((Message)localObject2).arg1 = paramList.size();
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 30000L);
      return;
      if ((this.mSessionInfo.cZ == 0) || (this.mSessionInfo.cZ == 3000) || (this.mSessionInfo.cZ == 1000) || (this.mSessionInfo.cZ == 1004)) {
        ((FriendListHandler)this.app.getBusinessHandler(1)).E(paramList);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(yju.class);
      this.n = ((MessageRecord)paramMessage.obj);
      if (this.n == null)
      {
        QQToast.a(this.c.a(), 2131699910, 0).show(this.c.a().getTitleBarHeight());
      }
      else
      {
        ciN();
        continue;
        if (this.c.a != null) {
          this.c.a.setRightRootVisibility(4);
        }
        QQToast.a(this.c.a(), (String)paramMessage.obj, 0).show(this.c.a().getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yju
 * JD-Core Version:    0.7.0.1
 */