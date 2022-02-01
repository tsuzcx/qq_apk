import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.CmGameDebugManager.1;
import com.tencent.mobileqq.apollo.debug.CmGameDebugManager.2;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugBaseFragment;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugLogFragment;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugToolFragment;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import mqq.os.MqqHandler;

public class abkj
{
  public static final String[] du = { "Log", "Tool" };
  public static final String[] dv = { "All", "Log", "Info", "Error", "Game" };
  public static final String[] dw = { "#000000", "#000000", "#6a59d6", "#FF0000", "#556B2F" };
  private boolean Yp;
  private WeakReference<abkj.a> fy;
  private BlockingQueue<abkr> i = new ArrayBlockingQueue(100);
  private BlockingQueue<abkr> j = new ArrayBlockingQueue(50);
  private BlockingQueue<abkr> k = new ArrayBlockingQueue(50);
  
  private List<abkr> J(int paramInt)
  {
    Object localObject = Arrays.asList(this.i.toArray(new abkr[0]));
    if (paramInt == 0) {
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      abkr localabkr = (abkr)((Iterator)localObject).next();
      if (localabkr.logLevel == paramInt) {
        localArrayList.add(localabkr);
      }
    }
    return localArrayList;
  }
  
  public static CmGameDebugBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new CmGameDebugLogFragment();
    case 0: 
      return new CmGameDebugLogFragment();
    }
    return new CmGameDebugToolFragment();
  }
  
  private void a(abkr paramabkr)
  {
    if (paramabkr == null) {
      return;
    }
    switch (paramabkr.logLevel)
    {
    }
    for (;;)
    {
      this.i.offer(paramabkr);
      if (this.i.size() == 100) {
        this.i.poll();
      }
      ThreadManager.getUIHandler().post(new CmGameDebugManager.1(this, paramabkr));
      return;
      this.k.offer(paramabkr);
      if (this.k.size() == 50)
      {
        this.k.poll();
        continue;
        this.j.offer(paramabkr);
        if (this.j.size() == 50) {
          this.j.poll();
        }
      }
    }
  }
  
  public static boolean a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramStartCheckParam != null)
    {
      bool1 = bool2;
      if (paramStartCheckParam.isWhiteUsr)
      {
        bool1 = bool2;
        if (hN(paramStartCheckParam.gameId)) {
          bool1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0).getBoolean("game_debug_tool_switch", true);
        }
      }
    }
    return bool1;
  }
  
  public static boolean hN(int paramInt)
  {
    aboz localaboz = abmt.a();
    if (localaboz != null) {
      return localaboz.hT(paramInt);
    }
    return false;
  }
  
  public void DJ(boolean paramBoolean)
  {
    this.i.clear();
    this.k.clear();
    this.j.clear();
    if ((paramBoolean) && (!this.Yp)) {
      ThreadManager.getUIHandler().post(new CmGameDebugManager.2(this));
    }
  }
  
  public List<abkr> I(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    switch (paramInt)
    {
    default: 
      return localArrayList;
    case 0: 
      return Arrays.asList(this.i.toArray(new abkr[0]));
    case 1: 
      return J(1);
    case 2: 
      return J(2);
    case 3: 
      return Arrays.asList(this.j.toArray(new abkr[0]));
    }
    return Arrays.asList(this.k.toArray(new abkr[0]));
  }
  
  public void a(abkj.a parama)
  {
    this.fy = new WeakReference(parama);
  }
  
  public void b(String paramString, int paramInt, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    localStringBuilder.append(paramString).append(" | ");
    int m = 0;
    while (m < paramVarArgs.length)
    {
      paramString = paramVarArgs[m];
      if (paramString != null) {
        localStringBuilder.append(paramString.toString());
      }
      m += 1;
    }
    a(new abkr(localStringBuilder.toString(), paramInt));
  }
  
  public void onDestroy()
  {
    this.Yp = true;
    DJ(false);
  }
  
  public static abstract interface a
  {
    public abstract void Ho(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkj
 * JD-Core Version:    0.7.0.1
 */