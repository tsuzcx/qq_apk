import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class abse
{
  private absk b;
  public boolean bEU;
  public boolean bEV;
  private Set<String> bI = new HashSet();
  public AtomicBoolean cq = new AtomicBoolean(false);
  public int cqS;
  public int cqT = -1;
  public int cqU = 3;
  private int cqV;
  public AtomicBoolean cr = new AtomicBoolean(false);
  private AtomicBoolean cs = new AtomicBoolean(false);
  public WeakReference<BaseChatPie> fK;
  public WeakReference<abix> fL;
  private WeakReference<abrm> fM;
  public int mAioType;
  public int mBubbleType = -1;
  public String mFriendUin;
  public SharedPreferences mPref;
  public float mScale;
  public String mSelfUin = ApolloUtil.getCurrentUin();
  
  public abse()
  {
    cEB();
    this.mPref = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    cEC();
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
  
  public void HT(int paramInt)
  {
    this.cqV = paramInt;
  }
  
  public abix a()
  {
    if (this.fL == null) {
      return null;
    }
    return (abix)this.fL.get();
  }
  
  public abrm a()
  {
    if (this.fM == null) {
      return null;
    }
    return (abrm)this.fM.get();
  }
  
  public IPCSpriteContext a()
  {
    IPCSpriteContext localIPCSpriteContext = new IPCSpriteContext();
    localIPCSpriteContext.mAioType = this.mAioType;
    localIPCSpriteContext.mFriendUin = this.mFriendUin;
    localIPCSpriteContext.mSelfUin = this.mSelfUin;
    localIPCSpriteContext.cqU = this.cqU;
    localIPCSpriteContext.cqS = this.cqS;
    localIPCSpriteContext.scale = this.mScale;
    return localIPCSpriteContext;
  }
  
  public void a(abix paramabix)
  {
    this.fL = new WeakReference(paramabix);
  }
  
  public void a(absk paramabsk)
  {
    this.b = paramabsk;
  }
  
  public void cEB() {}
  
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
  
  public boolean isSurfaceReady()
  {
    if (this.cq == null) {
      return false;
    }
    return this.cq.get();
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
 * Qualified Name:     abse
 * JD-Core Version:    0.7.0.1
 */