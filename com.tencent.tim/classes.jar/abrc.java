import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class abrc
{
  public abkg a;
  private abrd b;
  public boolean bEU;
  public boolean bEV;
  private Set<String> bI = new HashSet();
  public AtomicBoolean cq = new AtomicBoolean(false);
  public int cqS;
  public int cqT = -1;
  public int cqU = 0;
  private int cqV;
  public AtomicBoolean cr = new AtomicBoolean(false);
  private AtomicBoolean cs = new AtomicBoolean(false);
  private AtomicBoolean ct;
  public WeakReference<BaseChatPie> fK;
  public WeakReference<abix> fL;
  private WeakReference<abrm> fM;
  public int mAioType;
  public WeakReference<QQAppInterface> mAppRef;
  public int mBubbleType = -1;
  public String mFriendUin;
  public SharedPreferences mPref;
  public String mSelfUin;
  
  public abrc(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("cmshow_scripted_SpriteContext", 1, "[SpriteContext], app is null.");
      return;
    }
    setApp(paramQQAppInterface);
    this.mSelfUin = paramQQAppInterface.getCurrentAccountUin();
    cEB();
    this.mPref = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    cEC();
  }
  
  public void Ea(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.cqT = i;
      if (this.mPref != null) {
        this.mPref.edit().putInt("sprite_hide_key" + this.mSelfUin, this.cqT).commit();
      }
      return;
    }
  }
  
  public void Eb(boolean paramBoolean)
  {
    if (this.cq != null) {
      this.cq.set(paramBoolean);
    }
  }
  
  public void Ec(boolean paramBoolean)
  {
    if (this.cr != null) {
      this.cr.set(paramBoolean);
    }
  }
  
  public void Ed(boolean paramBoolean)
  {
    if (this.cs != null) {
      this.cs.set(paramBoolean);
    }
  }
  
  public void HT(int paramInt)
  {
    this.cqV = paramInt;
  }
  
  public boolean Zb()
  {
    return (this.mAioType == 1) || (this.mAioType == 3000);
  }
  
  protected boolean Zc()
  {
    try
    {
      Iterator localIterator = this.bI.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        QLog.i("cmshow_scripted_SpriteContext", 1, "cmshow should hide from:" + str);
        abwh.a(this.cqV, 10, 104, new Object[] { "cmshow should hide from:", str });
      }
      i = this.bI.size();
    }
    finally {}
    int i;
    if (i > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean Zd()
  {
    if (this.cr == null) {
      return false;
    }
    return this.cr.get();
  }
  
  public boolean Ze()
  {
    if (!Zf()) {
      return true;
    }
    if (this.cs == null) {
      return false;
    }
    return this.cs.get();
  }
  
  public boolean Zf()
  {
    if (this.ct == null)
    {
      this.ct = new AtomicBoolean(false);
      this.ct.set(abhh.Ye());
    }
    return this.ct.get();
  }
  
  public abix a()
  {
    if (this.fL == null) {
      return null;
    }
    return (abix)this.fL.get();
  }
  
  public abrd a()
  {
    return this.b;
  }
  
  public abrm a()
  {
    if (this.fM == null) {
      return null;
    }
    return (abrm)this.fM.get();
  }
  
  public void a(abix paramabix)
  {
    this.fL = new WeakReference(paramabix);
  }
  
  public void a(abkg paramabkg)
  {
    this.a = paramabkg;
  }
  
  public void a(abrd paramabrd)
  {
    this.b = paramabrd;
  }
  
  public void a(abrm paramabrm)
  {
    this.fM = new WeakReference(paramabrm);
  }
  
  public void bw(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.bI.add(paramString);
        return;
      }
      finally {}
      this.bI.remove(paramString);
    }
  }
  
  public void cEB()
  {
    this.cqS = abhh.x(getApp());
  }
  
  public void cEC()
  {
    if (this.mPref != null) {
      this.cqT = this.mPref.getInt("sprite_hide_key" + this.mSelfUin, -1);
    }
  }
  
  public void clear()
  {
    if (this.cq != null) {
      this.cq.set(false);
    }
    if (this.cr != null) {
      this.cr.set(false);
    }
    if (this.cs != null) {
      this.cs.set(false);
    }
    this.bEU = false;
    this.fL = null;
    this.mAioType = -1;
    this.mBubbleType = -1;
    this.bI.clear();
  }
  
  public BaseChatPie d()
  {
    if (this.fK == null) {
      return null;
    }
    return (BaseChatPie)this.fK.get();
  }
  
  public void gJ(int paramInt1, int paramInt2)
  {
    this.mAioType = paramInt1;
    this.cqU = paramInt2;
    if (this.cqU == 0)
    {
      if ((1 != paramInt1) && (3000 != paramInt1)) {
        break label43;
      }
      this.mBubbleType = 1;
    }
    for (;;)
    {
      setBubbleType(this.mBubbleType);
      return;
      label43:
      if (paramInt1 == 0) {
        this.mBubbleType = 0;
      }
    }
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef == null) {
      return null;
    }
    return (QQAppInterface)this.mAppRef.get();
  }
  
  public boolean isSurfaceReady()
  {
    if (this.cq == null) {
      return false;
    }
    return this.cq.get();
  }
  
  protected boolean jy(String paramString)
  {
    try
    {
      boolean bool = this.bI.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void q(BaseChatPie paramBaseChatPie)
  {
    this.fK = new WeakReference(paramBaseChatPie);
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
  }
  
  public void setBubbleType(int paramInt)
  {
    abix localabix = a();
    if (localabix != null) {
      localabix.setBubbleType(paramInt);
    }
  }
  
  public void setUin(String paramString)
  {
    this.mSelfUin = paramString;
  }
  
  public int zM()
  {
    return this.cqV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrc
 * JD-Core Version:    0.7.0.1
 */