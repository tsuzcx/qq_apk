import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class ijq
{
  private ijq.a a;
  private VideoAppInterface mApp;
  
  public ijq(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.a = new ijq.a(this);
    this.mApp.addObserver(this.a);
  }
  
  private void U(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < 15)
    {
      if (this.mApp.ch(i)) {
        this.mApp.a(i).U(paramString, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void handlerObserver(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    default: 
    case 101: 
    case 6009: 
    case 6103: 
    case 13: 
    case 203: 
      long l1;
      do
      {
        return;
        d(jlc.a(paramObservable, 1), 2, null);
        return;
        g(((Integer)paramObservable[1]).intValue(), (String)paramObservable[2]);
        return;
        f(((Integer)paramObservable[1]).intValue(), (String)paramObservable[2]);
        return;
        l1 = jlc.a(paramObservable, 1);
        if (QLog.isColorLevel()) {
          QLog.w("BusinessMessageCenter", 1, "onSessionStatusChanged[Connected],");
        }
        d(l1, 1, null);
        return;
        paramObject = (String)paramObservable[1];
        bool = ((Boolean)paramObservable[2]).booleanValue();
        l1 = jlc.a(paramObservable, 3);
        paramObservable = this.mApp.b().b().peerUin;
        long l2 = this.mApp.b().b().ll;
        QLog.w("BusinessMessageCenter", 1, "onSessionStatusChanged[END], eventPeerUin[" + paramObject + "], isQuit[" + bool + "], curPeerUin[" + paramObservable + "], relationId[" + l2 + "]");
      } while ((paramObservable != null) && (!paramObservable.equalsIgnoreCase(paramObject)));
      d(l1, 3, null);
      return;
    }
    paramObject = (String)paramObservable[1];
    boolean bool = ((Boolean)paramObservable[2]).booleanValue();
    paramObservable = paramObject;
    if (TextUtils.isEmpty(paramObject)) {
      paramObservable = "";
    }
    U(paramObservable, bool);
  }
  
  public int al(String paramString)
  {
    Object localObject;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString.split("\\|");
      str1 = null;
      if (localObject.length <= 0) {
        break label678;
      }
    }
    label651:
    label656:
    label661:
    label678:
    for (ilg localilg = localObject[0];; localilg = null)
    {
      if (localilg == null) {
        return 0;
      }
      if (localObject.length > 1) {
        str1 = localObject[1];
      }
      if (localObject.length > 2) {}
      for (String str2 = localObject[2];; str2 = null)
      {
        if (localObject.length > 3) {}
        for (long l1 = AudioHelper.stringToLong(localObject[3]);; l1 = 0L)
        {
          long l2 = AudioHelper.hF();
          long l3 = AudioHelper.hG();
          int i;
          if (localilg.startsWith("EMPTY_ITEM"))
          {
            if (!ZimuToolbar.isSupport()) {
              break;
            }
            localilg = (ilg)this.mApp.a(0);
            localObject = (ZimuItem)localilg.a();
            if ((localObject == null) || (TextUtils.isEmpty(((ZimuItem)localObject).getId()))) {
              break label661;
            }
            QLog.w("BusinessMessageCenter", 1, "onReceivedChangingZimuOfPeer, 对方取消字幕, info[" + paramString + "], sessionid[" + str1 + "], cmdSeq[" + str2 + "], seq[" + l3 + "], sendTime[" + l1 + "], offset[" + (l2 - l1) + "], isTranslation[" + localilg.tQ() + "], cur[" + ((ZimuItem)localObject).getId() + "]");
            paramString = (ilg)this.mApp.a(0);
            paramString.p("onReceivedChangingZimuOfPeer", l3);
            new iya.f(l3, "onReceivedChangingZimuOfPeer", 3, "0").n(this.mApp);
            paramString.d(l3, null);
            i = 1;
            notifyEvent(Integer.valueOf(6010), Integer.valueOf(1));
          }
          for (;;)
          {
            this.mApp.kI(0);
            return i;
            if (!ZimuToolbar.isSupport()) {
              break;
            }
            localObject = (ilg)this.mApp.a(0);
            ZimuItem localZimuItem1 = (ZimuItem)((ilg)localObject).a(localilg);
            ZimuItem localZimuItem2 = (ZimuItem)((ilg)localObject).a();
            QLog.w("BusinessMessageCenter", 1, "onReceivedChangingZimuOfPeer, 对方选择字幕, info[" + paramString + "], zimuId[" + localilg + "], sessionid[" + str1 + "], cmdSeq[" + str2 + "], seq[" + l3 + "], sendTime[" + l1 + "], offset[" + (l2 - l1) + "], isTranslation[" + ((ilg)localObject).tQ() + "], ZimuItem[" + localZimuItem1 + "], CurItem[" + localZimuItem2 + "]");
            boolean bool;
            if (localZimuItem1 != null) {
              if (localZimuItem2 == null)
              {
                bool = false;
                if (bool) {
                  break label656;
                }
                ((ilg)localObject).a("onReceivedChangingZimuOfPeer", false, l3, str1);
                ((ilg)localObject).d(l3, localilg);
                if (!localZimuItem1.isUsable()) {
                  ((ilg)localObject).a(l3, localZimuItem1);
                }
                new iya.f(l3, "onReceivedChangingZimuOfPeer", 1, localilg).n(this.mApp);
                if (localZimuItem2 != null) {
                  break label651;
                }
                i = 3;
                label581:
                notifyEvent(Integer.valueOf(6010), Integer.valueOf(i));
                j = i;
                if (!ZimuToolbar.isShow(this.mApp)) {
                  notifyEvent(Integer.valueOf(6012), Integer.valueOf(i));
                }
              }
            }
            for (int j = i;; j = 0)
            {
              this.mApp.kI(0);
              return j;
              bool = localZimuItem2.getId().equalsIgnoreCase(localZimuItem1.getId());
              break;
              i = 2;
              break label581;
            }
            i = 0;
          }
        }
      }
    }
  }
  
  public void d(long paramLong, int paramInt, String paramString)
  {
    String str = this.mApp.b().by() + "";
    int i = 0;
    while (i < 15)
    {
      if (this.mApp.ch(i)) {
        this.mApp.a(i).a(paramLong, paramInt, str, paramString);
      }
      i += 1;
    }
  }
  
  public int f(int paramInt, String paramString)
  {
    if (((paramInt == 3) || (paramInt == 1)) && (!((ikt)this.mApp.a(5)).b(3, paramInt, paramString))) {
      ((ijv)this.mApp.a(3)).h(paramInt, paramString);
    }
    return 0;
  }
  
  public int g(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return 0;
      } while (((ikt)this.mApp.a(5)).b(0, paramInt, paramString));
      al(paramString);
      return 0;
    } while (((ikt)this.mApp.a(5)).b(0, paramInt, paramString));
    String str = paramString;
    if (paramString.equals("。")) {
      str = "。 ";
    }
    paramString = new ijn(this.mApp.b().b().peerUin, str, str, 2);
    paramString.RH = true;
    notifyEvent(Integer.valueOf(6008), paramString);
    return 0;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject)
  {
    igd.aJ("BusinessMessageCenter", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.mApp.l(new Object[] { paramInteger, paramObject });
  }
  
  static class a
    implements Observer
  {
    private WeakReference<ijq> bk;
    
    a(ijq paramijq)
    {
      this.bk = new WeakReference(paramijq);
    }
    
    public void update(Observable paramObservable, Object paramObject)
    {
      ijq localijq = (ijq)this.bk.get();
      if (localijq == null) {
        return;
      }
      ijq.a(localijq, paramObservable, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijq
 * JD-Core Version:    0.7.0.1
 */