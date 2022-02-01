import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class alyn
  extends alyt
{
  private String bZx;
  private SparseArray<alyn.a> dp = new SparseArray();
  private Handler mHandler = new alyo(this, g());
  
  public alyn(Context paramContext)
  {
    super(paramContext);
    int i = ((Activity)paramContext).getIntent().getIntExtra("forward_source_uin_type", -1);
    if (i == 0)
    {
      this.bZx = "c2c";
      return;
    }
    if (i == 1)
    {
      this.bZx = "grp";
      return;
    }
    if (i == 3000)
    {
      this.bZx = "dis";
      return;
    }
    this.bZx = "other";
  }
  
  private alyn.a a(int paramInt)
  {
    alyn.a locala2 = (alyn.a)this.dp.get(paramInt);
    alyn.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new alyn.a(paramInt, this.bZx);
      this.dp.put(paramInt, locala1);
    }
    return locala1;
  }
  
  public void Uc(int paramInt)
  {
    alyn.a.a(a(paramInt));
  }
  
  public void Ud(int paramInt)
  {
    alyn.a locala = (alyn.a)this.dp.get(paramInt);
    if ((locala != null) && (alyn.a.a(locala))) {
      alyn.a.c(locala);
    }
  }
  
  public void Ue(int paramInt)
  {
    alyn.a locala = (alyn.a)this.dp.get(paramInt);
    if ((locala != null) && (alyn.a.a(locala))) {
      alyn.a.a(locala, "sender");
    }
  }
  
  public void bO(int paramInt, boolean paramBoolean)
  {
    alyn.a locala = (alyn.a)this.dp.get(paramInt);
    if (locala != null) {
      alyn.a.a(locala, paramBoolean);
    }
  }
  
  public void bP(int paramInt, boolean paramBoolean)
  {
    alyn.a locala = (alyn.a)this.dp.get(paramInt);
    if (locala != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      alyn.a.c(locala, str);
      return;
    }
  }
  
  public void dE(int paramInt, String paramString)
  {
    alyn.a locala = (alyn.a)this.dp.get(paramInt);
    if (locala != null) {
      alyn.a.d(locala, paramString);
    }
  }
  
  public void dLB()
  {
    this.mHandler.obtainMessage().sendToTarget();
  }
  
  public void exit(int paramInt)
  {
    alyn.a locala = (alyn.a)this.dp.get(paramInt);
    if ((locala != null) && (alyn.a.a(locala))) {
      alyn.a.b(locala);
    }
  }
  
  public void j(int paramInt, long paramLong1, long paramLong2)
  {
    alyn.a locala = (alyn.a)this.dp.get(paramInt);
    String str;
    if (locala != null)
    {
      paramInt = alyv.g(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      alyn.a.b(locala, str);
      return;
      str = "long";
      continue;
      str = "small";
      continue;
      str = "mid";
      continue;
      str = "large";
      continue;
      str = "extra";
    }
  }
  
  static class a
    extends alys
  {
    private long aia;
    private String bZA;
    private String bZB;
    private String bZy = "receiver";
    private String bZz;
    private boolean cBo;
    private boolean cBp;
    private boolean cBq;
    private int dAk;
    private long ie;
    private int mViewCount;
    
    public a(int paramInt, String paramString) {}
    
    private void dLC()
    {
      if ((this.cBp) && (this.dAk == 0)) {
        this.dAk = 1;
      }
    }
    
    private void enter()
    {
      if (!this.cBp)
      {
        this.mViewCount += 1;
        this.ie = SystemClock.uptimeMillis();
        if (this.mViewCount > 1) {
          this.cBo = true;
        }
        this.cBp = true;
        this.dAk = 0;
      }
    }
    
    private void exit()
    {
      if (this.cBp)
      {
        this.aia = Math.max((SystemClock.uptimeMillis() - this.ie) / 1000L, this.aia);
        this.ie = 0L;
        this.cBp = false;
      }
    }
    
    public HashMap<String, String> v(String paramString)
    {
      Object localObject2 = null;
      Object localObject1;
      if (this.mViewCount <= 0)
      {
        localObject1 = localObject2;
        if (QLog.isDevelopLevel())
        {
          QLog.i(alyt.aeM, 4, "View count is 0!");
          localObject1 = localObject2;
        }
      }
      do
      {
        do
        {
          do
          {
            return localObject1;
            if (!"Pic.AioPreview".equals(paramString)) {
              break;
            }
            paramString = new HashMap();
            paramString.put("stay_seconds", String.valueOf(this.aia));
            paramString.put("gesture_double_click", String.valueOf(this.dAk));
            paramString.put("view_count", String.valueOf(this.mViewCount));
            paramString.put("send_type", this.bZy);
            if (this.cBo) {
              paramString.put("view_again", "1");
            }
            if (this.bZz != null) {
              paramString.put("size_type", this.bZz);
            }
            localObject1 = paramString;
          } while (this.bZA == null);
          paramString.put("format_type", this.bZA);
          return paramString;
          localObject1 = localObject2;
        } while (!"Pic.AioPreview.Preload".equals(paramString));
        localObject1 = localObject2;
      } while (this.bZB == null);
      paramString = new HashMap();
      paramString.put("preload_status", String.valueOf(this.cBq));
      paramString.put("preload_fail_filetype", this.bZB);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyn
 * JD-Core Version:    0.7.0.1
 */