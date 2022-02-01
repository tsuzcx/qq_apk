import android.os.SystemClock;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class yob
{
  public static final String TAG = yob.class.getName();
  private static int[] iN = { 80000000 };
  private static int[] iO = { 80000001 };
  private static int[] iP = { 80000002 };
  private static int[] iQ = { 80000003 };
  private static int[] iR = { 80000000, 80000001, 80000002, 80000004, 80000003 };
  private static int[] iS = { 80000002, 80000003 };
  private long Kw;
  private QQAppInterface app;
  private yob.a b;
  private int cak;
  private int cal;
  private String countryCode;
  acfd h = new yoc(this);
  String keyword = null;
  
  public yob(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.countryCode = aqje.bf(paramQQAppInterface.getApplication());
  }
  
  public void El(int paramInt)
  {
    this.cak = paramInt;
  }
  
  public void a(String paramString, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt)
  {
    ((FriendListHandler)this.app.getBusinessHandler(1)).a(paramString, this.countryCode, 3, this.cak, paramArrayOfInt, paramDouble1, paramDouble2, paramBoolean, paramInt, this.Kw);
  }
  
  public void a(yob.a parama)
  {
    this.b = parama;
  }
  
  public boolean a(String paramString, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2)
  {
    addObserver();
    this.keyword = paramString;
    this.cal = paramInt1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt1)
    {
    default: 
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "warning! wrong request type = " + paramInt1);
      }
      return false;
      localObject1 = iN;
      continue;
      localObject1 = iO;
      continue;
      localObject1 = iP;
      continue;
      localObject1 = iQ;
      continue;
      localObject1 = iR;
      continue;
      localObject1 = iS;
    }
    ((FriendListHandler)this.app.getBusinessHandler(1)).a(paramString, this.countryCode, 3, this.cak, (int[])localObject1, paramDouble1, paramDouble2, true, paramInt2, this.Kw);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "searchFriend nextPage = " + this.cak);
    }
    return true;
  }
  
  final void addObserver()
  {
    if (this.app != null) {
      this.app.addObserver(this.h, true);
    }
  }
  
  final void ckg()
  {
    if (this.app != null) {
      this.app.removeObserver(this.h);
    }
  }
  
  public void ckh()
  {
    this.cak = 0;
    this.Kw = SystemClock.uptimeMillis();
  }
  
  public void destory()
  {
    this.b = null;
    this.cak = 0;
    ckg();
    this.app = null;
  }
  
  public int xh()
  {
    return this.cak;
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yob
 * JD-Core Version:    0.7.0.1
 */