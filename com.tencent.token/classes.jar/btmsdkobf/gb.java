package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

class gb
  extends Handler
{
  gb(cy paramcy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(boolean paramBoolean, cy.f paramf)
  {
    cy.j(this.a).submit(new gc(this, paramf, paramBoolean));
  }
  
  public void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return;
    case 0: 
      cy.d(this.a).removeMessages(0);
      if ((cy.b(this.a) != null) && (???.arg1 == 1))
      {
        eh.f("SharkNetwork", "MSG_SHARK_SEND_VIP mSharkSendRsa");
        a(false, cy.b(this.a));
        return;
      }
      if ((cy.c(this.a) != null) && (???.arg1 == 2))
      {
        eh.f("SharkNetwork", "MSG_SHARK_SEND_VIP mSharkSendGuid");
        a(true, cy.c(this.a));
        return;
      }
      eh.h("SharkNetwork", "MSG_SHARK_SEND_VIP null");
      return;
    case 1: 
      eh.f("SharkNetwork", "MSG_SHARK_SEND");
      cy.d(this.a).removeMessages(1);
      ??? = cy.k(this.a).ai();
      if ((TextUtils.isEmpty(???.ir)) || (TextUtils.isEmpty(???.is)))
      {
        eh.g("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, without rsakey, handleOnNeedRsaKey()");
        cy.b(this.a, false);
        return;
      }
      if (cy.l(this.a))
      {
        eh.g("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, rsakey expired, handleOnNeedRsaKey()");
        cy.b(this.a, true);
        return;
      }
      if (cy.m(this.a).aZ())
      {
        eh.g("SharkNetwork", "[cu_guid] MSG_SHARK_SEND, without guid, handleOnNeedGuid()");
        cy.n(this.a);
        return;
      }
      synchronized (cy.o(this.a))
      {
        if (cy.o(this.a).size() <= 0) {
          return;
        }
      }
      Object localObject2 = (ArrayList)cy.o(this.a).clone();
      cy.o(this.a).clear();
      ??? = ((ArrayList)localObject2).iterator();
      while (???.hasNext())
      {
        localObject2 = (cy.f)???.next();
        if (localObject2 != null)
        {
          if (cy.l(this.a))
          {
            eh.g("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, rsakey expired suddenly, handleOnNeedRsaKey()");
            cy.b(this.a, true);
            return;
          }
          if (((cy.f)localObject2).jL) {
            a(false, (cy.f)localObject2);
          } else {
            a(true, (cy.f)localObject2);
          }
        }
      }
    case 2: 
      cy.d(this.a).removeMessages(2);
      eh.f("SharkNetwork", "[rsa_key]msg: MSG_SHARK_UPDATE_RSAKEY");
      cy.j(this.a).submit(new gd(this));
      return;
    case 3: 
      eh.f("SharkNetwork", "[cu_guid]MSG_SHARK_GET_GUID");
      cy.d(this.a).removeMessages(3);
      cy.j(this.a).submit(new gf(this));
      return;
    case 6: 
      eh.f("SharkNetwork", "[cu_guid]handle: MSG_REQUEST_SENDPROCESS_GET_GUID");
      cf.f(cy.e(this.a));
      return;
    case 7: 
      eh.f("SharkNetwork", "[rsa_key]handle: MSG_REQUEST_SENDPROCESS_UPDATE_RSAKEY");
      cs.g(cy.e(this.a));
      return;
    case 4: 
      cy.j(this.a).submit(new gh(this));
      return;
    case 10: 
      cy.j(this.a).submit(new gi(this));
      return;
    case 8: 
      eh.f("SharkNetwork", "[cu_vid]deal msg: MSG_REGISTER_VID_IFNEED");
      cy.r(this.a).av();
      return;
    case 9: 
      eh.f("SharkNetwork", "[cu_vid]deal msg: MSG_UPDATE_VID_IFNEED");
      cy.r(this.a).b(0, false);
      return;
    }
    cs.a(cy.e(this.a), 0, this.a.ai());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gb
 * JD-Core Version:    0.7.0.1
 */