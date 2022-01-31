import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bzt
  extends MessageObserver
{
  public bzt(StrangerChatPie paramStrangerChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(StrangerChatPie.i(this.a).jdField_a_of_type_JavaLangString)) || (paramInt1 != StrangerChatPie.j(this.a).jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StrangerChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StrangerChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2);
    }
    if (paramInt1 == 1005) {
      switch (paramInt2)
      {
      default: 
        QQToast.a(StrangerChatPie.f(this.a), StrangerChatPie.g(this.a).getString(2131362963), 0).b(StrangerChatPie.e(this.a).getTitleBarHeight());
      }
    }
    for (;;)
    {
      this.a.a(196608);
      return;
      QQToast.a(StrangerChatPie.c(this.a), StrangerChatPie.d(this.a).getString(2131362962), 0).b(StrangerChatPie.b(this.a).getTitleBarHeight());
      continue;
      if (paramInt1 == 1004) {
        switch (paramInt2)
        {
        default: 
          break;
        case 102: 
        case 103: 
        case 104: 
          paramString1 = String.format(StrangerChatPie.h(this.a).getString(2131362965), new Object[] { StrangerChatPie.k(this.a).d });
          QQToast.a(StrangerChatPie.j(this.a), paramString1, 0).b(StrangerChatPie.i(this.a).getTitleBarHeight());
          break;
        }
      } else if (paramInt1 == 1000) {
        switch (paramInt2)
        {
        default: 
          break;
        case 102: 
        case 103: 
        case 104: 
          paramString1 = String.format(StrangerChatPie.k(this.a).getString(2131362966), new Object[] { StrangerChatPie.l(this.a).d });
          QQToast.a(StrangerChatPie.m(this.a), paramString1, 0).b(StrangerChatPie.l(this.a).getTitleBarHeight());
          break;
        }
      } else if (paramInt1 == 1020) {
        switch (paramInt2)
        {
        default: 
          break;
        case 40: 
        case 102: 
        case 103: 
        case 104: 
          paramString1 = String.format(StrangerChatPie.n(this.a).getString(2131362175), new Object[] { StrangerChatPie.m(this.a).d });
          QQToast.a(StrangerChatPie.p(this.a), paramString1, 0).b(StrangerChatPie.o(this.a).getTitleBarHeight());
          break;
        }
      } else if (paramInt1 == 1009) {
        switch (paramInt2)
        {
        default: 
          break;
        case 3: 
        case 21: 
        case 22: 
        case 23: 
        case 28: 
        case 48: 
          QQToast.a(StrangerChatPie.r(this.a), StrangerChatPie.s(this.a).getString(2131362964), 0).b(StrangerChatPie.q(this.a).getTitleBarHeight());
          break;
        }
      } else if (paramInt1 == 1006) {
        switch (paramInt2)
        {
        default: 
          break;
        case 1600: 
          QQToast.a(StrangerChatPie.u(this.a), StrangerChatPie.v(this.a).getString(2131363000), 0).b(StrangerChatPie.t(this.a).getTitleBarHeight());
          break;
        case 1601: 
          QQToast.a(StrangerChatPie.x(this.a), StrangerChatPie.y(this.a).getString(2131363000), 0).b(StrangerChatPie.w(this.a).getTitleBarHeight());
          break;
        case 1602: 
          QQToast.a(StrangerChatPie.A(this.a), StrangerChatPie.B(this.a).getString(2131363001), 0).b(StrangerChatPie.z(this.a).getTitleBarHeight());
          break;
        }
      } else if (paramInt1 == 1022) {
        switch (paramInt2)
        {
        default: 
          break;
        case 16: 
          ChatActivityFacade.c(StrangerChatPie.a(this.a), StrangerChatPie.n(this.a));
          break;
        }
      } else if (paramInt1 == 1023) {
        QQToast.a(StrangerChatPie.D(this.a), "errorCode" + paramInt2, 0).b(StrangerChatPie.C(this.a).getTitleBarHeight());
      } else if (paramInt1 == 1025) {
        switch (paramInt2)
        {
        default: 
          QQToast.a(StrangerChatPie.H(this.a), "errorCode" + paramInt2, 0).b(StrangerChatPie.G(this.a).getTitleBarHeight());
          break;
        case 55: 
          QQToast.a(StrangerChatPie.F(this.a), "已屏蔽的临时会话", 0).b(StrangerChatPie.E(this.a).getTitleBarHeight());
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (StrangerChatPie.p(this.a).jdField_a_of_type_JavaLangString != null) && (StrangerChatPie.q(this.a).jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.a();
      if (paramBoolean) {
        this.a.h();
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      this.a.C();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (StrangerChatPie.r(this.a).jdField_a_of_type_JavaLangString != null) && (StrangerChatPie.s(this.a).jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.a();
      if (paramBoolean) {
        this.a.h();
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.a(65536);
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(StrangerChatPie.o(this.a).jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.j = true;
    this.a.a(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzt
 * JD-Core Version:    0.7.0.1
 */