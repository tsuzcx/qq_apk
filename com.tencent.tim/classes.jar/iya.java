import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ControlUIObserver.1;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class iya
  implements Observer
{
  Handler mHandler = null;
  
  public static <T extends iya.a> T a(Object[] paramArrayOfObject)
  {
    return (iya.a)paramArrayOfObject[1];
  }
  
  protected void C(long paramLong, int paramInt) {}
  
  public void I(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("qav.ControlUIObserver", 2, "OnUpdate，msgType = " + i);
    }
    Object localObject;
    switch (i)
    {
    default: 
      return;
    case 101: 
      cE(jlc.a(paramObject, 1));
      return;
    case 174: 
      cF(jlc.a(paramObject, 1));
      return;
    case 102: 
      arp();
      return;
    case 103: 
      localObject = (ArrayList)paramObject[1];
      g(jlc.a(paramObject, 2), (ArrayList)localObject);
      return;
    case 104: 
      bB((ArrayList)paramObject[1]);
      return;
    case 105: 
      o(((Boolean)paramObject[1]).booleanValue(), jlc.a(paramObject, 2));
      return;
    case 106: 
      cG(jlc.a(paramObject, 1));
      return;
    case 107: 
      cQ(jlc.a(paramObject, 1));
      return;
    case 108: 
      arT();
      return;
    case 109: 
      arU();
      return;
    case 110: 
      cS(jlc.a(paramObject, 1));
      return;
    case 8001: 
      jQ((String)paramObject[1]);
      return;
    case 119: 
      me(((Integer)paramObject[1]).intValue());
      return;
    case 111: 
      ju(((Boolean)paramObject[1]).booleanValue());
      return;
    case 113: 
      arq();
      return;
    case 114: 
      arS();
      return;
    case 115: 
      b((String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Integer)paramObject[4]).intValue());
      return;
    case 172: 
      g(((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 117: 
      i = -1;
      if (paramObject.length > 1) {
        i = ((Integer)paramObject[1]).intValue();
      }
      mc(i);
      return;
    case 8002: 
      arV();
      return;
    case 123: 
      if (paramObject.length <= 1) {
        break;
      }
    }
    for (i = ((Integer)paramObject[1]).intValue();; i = 0)
    {
      C(jlc.a(paramObject, 2), i);
      return;
      md(((Integer)paramObject[1]).intValue());
      return;
      a((iya.d)paramObject[1]);
      return;
      localObject = (String)paramObject[1];
      paramObject = (String)paramObject[2];
      ild.aU((String)localObject, paramObject);
      bg((String)localObject, paramObject);
      return;
      if (paramObject.length < 4) {
        break;
      }
      boolean bool1 = ((Boolean)paramObject[1]).booleanValue();
      boolean bool2 = ((Boolean)paramObject[2]).booleanValue();
      long l = ((Long)paramObject[3]).longValue();
      a(jlc.a(paramObject, 4), bool1, bool2, l);
      return;
      arW();
      return;
      K(paramObject[1]);
      return;
      cR(jlc.a(paramObject, 1));
      return;
      bool1 = ((Boolean)paramObject[1]).booleanValue();
      i = ((Integer)paramObject[2]).intValue();
      f(jlc.a(paramObject, 3), bool1, i);
      return;
      cT(jlc.a(paramObject, 1));
      return;
      jM((String)paramObject[1]);
      return;
      asg();
      return;
      arX();
      return;
      ash();
      return;
      asi();
      return;
      asj();
      return;
      ask();
      return;
      mh(((Integer)paramObject[1]).intValue());
      return;
      arr();
      return;
      w(((Integer)paramObject[1]).intValue(), jlc.a(paramObject, 2));
      return;
      arY();
      return;
      jV((String)paramObject[1]);
      return;
      b((String)paramObject[1], (Boolean)paramObject[2]);
      return;
      jW((String)paramObject[1]);
      return;
      c((String)paramObject[1], (Boolean)paramObject[2]);
      return;
      b((iya.d)paramObject[1]);
      return;
      a((iya.b)paramObject[1]);
      return;
      a((iya.c)paramObject[1]);
      return;
      c((iya.d)paramObject[1]);
      return;
      d((iya.d)paramObject[1]);
      return;
      e((iya.d)paramObject[1]);
      return;
      f((iya.d)paramObject[1]);
      return;
      a((aqji.b)paramObject[1]);
      return;
      be((String)paramObject[1], (String)paramObject[2]);
      return;
      ars();
      return;
      mf(((Integer)paramObject[1]).intValue());
      return;
      jR((String)paramObject[2]);
      return;
      mg(((Integer)paramObject[1]).intValue());
      return;
      jv(((Boolean)paramObject[1]).booleanValue());
      return;
      a(jlc.a(paramObject, 1), ((Boolean)paramObject[2]).booleanValue(), (String)paramObject[3]);
      return;
      t(jlc.a(paramObject, 1), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
      a((String)paramObject[1], (AVFunChat.AVFunChatMessage)paramObject[2]);
      return;
      x(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
      return;
    }
  }
  
  protected void K(Object paramObject) {}
  
  protected void a(long paramLong, boolean paramBoolean, String paramString) {}
  
  protected void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2) {}
  
  protected void a(aqji.b paramb) {}
  
  protected void a(iya.b paramb) {}
  
  protected void a(iya.c paramc) {}
  
  public void a(iya.d paramd) {}
  
  protected void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage) {}
  
  protected void arS() {}
  
  protected void arT() {}
  
  protected void arU() {}
  
  public void arV() {}
  
  protected void arW() {}
  
  protected void arX() {}
  
  protected void arY() {}
  
  protected void arp() {}
  
  protected void arq() {}
  
  protected void arr() {}
  
  public void ars() {}
  
  protected void asg() {}
  
  protected void ash() {}
  
  protected void asi() {}
  
  protected void asj() {}
  
  protected void ask() {}
  
  protected void b(iya.d paramd) {}
  
  protected void b(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  protected void b(String paramString, Boolean paramBoolean) {}
  
  protected void bB(ArrayList<ioa> paramArrayList) {}
  
  public void be(String paramString1, String paramString2) {}
  
  public void bg(String paramString1, String paramString2) {}
  
  protected void c(iya.d paramd) {}
  
  protected void c(String paramString, Boolean paramBoolean) {}
  
  public void cE(long paramLong) {}
  
  protected void cF(long paramLong) {}
  
  protected void cG(long paramLong) {}
  
  protected void cQ(long paramLong) {}
  
  protected void cR(long paramLong) {}
  
  protected void cS(long paramLong) {}
  
  protected void cT(long paramLong) {}
  
  protected void d(iya.d paramd) {}
  
  protected void e(iya.d paramd) {}
  
  protected void f(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void f(iya.d paramd) {}
  
  protected void g(int paramInt1, int paramInt2, String paramString) {}
  
  protected void g(long paramLong, ArrayList<ioa> paramArrayList) {}
  
  protected void jM(String paramString) {}
  
  protected void jQ(String paramString) {}
  
  public void jR(String paramString) {}
  
  protected void jV(String paramString) {}
  
  protected void jW(String paramString) {}
  
  protected void ju(boolean paramBoolean) {}
  
  protected void jv(boolean paramBoolean) {}
  
  protected void mc(int paramInt) {}
  
  protected void md(int paramInt) {}
  
  protected void me(int paramInt) {}
  
  public void mf(int paramInt) {}
  
  protected void mg(int paramInt) {}
  
  protected void mh(int paramInt) {}
  
  protected void o(boolean paramBoolean, long paramLong) {}
  
  protected void t(long paramLong, int paramInt1, int paramInt2) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler(paramObservable);
      }
      this.mHandler.post(new ControlUIObserver.1(this, paramObject));
      return;
    }
    I(paramObject);
  }
  
  protected void w(int paramInt, long paramLong) {}
  
  protected void x(int paramInt, long paramLong) {}
  
  public static class a
  {
    private int avA;
    String mFrom = null;
    private long mSeq;
    
    a(int paramInt)
    {
      this.avA = paramInt;
    }
    
    public long bK()
    {
      if ((this.mSeq == 0L) && (AudioHelper.isDev())) {
        throw new IllegalArgumentException("seq未初始化:" + getClass().getSimpleName());
      }
      return this.mSeq;
    }
    
    public void n(VideoAppInterface paramVideoAppInterface)
    {
      if (paramVideoAppInterface == null) {
        return;
      }
      paramVideoAppInterface.l(new Object[] { Integer.valueOf(this.avA), this });
    }
    
    public void u(long paramLong, String paramString)
    {
      this.mSeq = paramLong;
      this.mFrom = paramString;
    }
  }
  
  public static class b
    extends iya.d
  {
    public int avB = 0;
    public int avC = -1;
    
    public b(View paramView, int paramInt)
    {
      super();
      this.avB = paramInt;
    }
  }
  
  public static class c
    extends iya.d
  {
    public boolean VZ;
    public int avD;
  }
  
  public static class d
    extends iya.a
  {
    public String Rj;
    public boolean Wa;
    private View hR;
    
    public d(int paramInt, View paramView)
    {
      super();
      this.hR = paramView;
    }
    
    public d(View paramView)
    {
      super();
      this.hR = paramView;
    }
    
    public View W()
    {
      return this.hR;
    }
  }
  
  public static class e
    extends iya.d
  {
    public final boolean Wb;
    public final int mFrom;
    public final String mId;
    
    public e(long paramLong, String paramString, boolean paramBoolean, int paramInt)
    {
      super(null);
      u(paramLong, null);
      this.mId = paramString;
      this.Wb = paramBoolean;
      this.mFrom = paramInt;
    }
    
    public String toString()
    {
      return "mId[" + this.mId + "], mFrom[" + this.mFrom + "], mSender[" + this.Wb + "], seq[" + bK() + "]";
    }
  }
  
  public static class f
    extends iya.a
  {
    public String Rk;
    public int avE;
    
    public f(long paramLong, String paramString1, int paramInt, String paramString2)
    {
      super();
      u(paramLong, paramString1);
      this.avE = paramInt;
      this.Rk = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iya
 * JD-Core Version:    0.7.0.1
 */