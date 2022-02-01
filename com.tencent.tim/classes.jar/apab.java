import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import java.util.Observable;
import java.util.Observer;

public abstract class apab
  extends Observable
{
  public static int dSq = 1;
  public static int dSr = 2;
  public static int dSs = 3;
  protected View Ih;
  public ScrollerRunnable a;
  public wki a;
  public QQAppInterface app;
  public ChatXListView b;
  public boolean bvv;
  public Context context;
  public Observer d;
  public RelativeLayout fs;
  public Observer j;
  public SessionInfo sessionInfo;
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, wki paramwki, ChatXListView paramChatXListView, ScrollerRunnable paramScrollerRunnable)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.sessionInfo = paramSessionInfo;
    this.fs = paramRelativeLayout;
    if (this.fs != null) {
      this.Ih = this.fs.findViewById(2131374819);
    }
    this.jdField_a_of_type_Wki = paramwki;
    this.b = paramChatXListView;
    this.j = paramObserver;
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = paramScrollerRunnable;
    deleteObservers();
    addObserver(paramObserver);
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000))
    {
      this.bvv = true;
      onInit();
      return;
    }
    this.bvv = false;
  }
  
  protected abstract void cbf();
  
  public View cx()
  {
    return null;
  }
  
  public void dYh()
  {
    if (this.d != null) {
      this.d.update(null, null);
    }
  }
  
  protected abstract void onInit();
  
  public void uninit()
  {
    if (this.bvv) {
      cbf();
    }
    this.bvv = false;
    deleteObservers();
  }
  
  public static final class a
  {
    public boolean cPu;
    public boolean cPv;
    public int dSt;
    public int dSu;
    public int id;
    public long shmsgseq;
    public int type;
    public long uniseq;
    
    public static long a(int paramInt, long paramLong1, long paramLong2)
    {
      if (lV(paramInt)) {
        return paramLong1;
      }
      return paramLong2;
    }
    
    public static a a(int paramInt1, long paramLong, int paramInt2)
    {
      a locala = new a();
      locala.type = apab.dSq;
      a(paramInt1, paramLong, locala);
      locala.dSt = paramInt1;
      locala.dSu = paramInt2;
      return locala;
    }
    
    public static void a(int paramInt, long paramLong, a parama)
    {
      if (lV(paramInt))
      {
        parama.shmsgseq = paramLong;
        return;
      }
      parama.uniseq = paramLong;
    }
    
    private static boolean lV(int paramInt)
    {
      return (paramInt == 1) || (paramInt == 22) || (paramInt == 17) || (paramInt == 100) || (paramInt == 11) || (paramInt == 10);
    }
    
    public long hp()
    {
      return a(this.dSt, this.shmsgseq, this.uniseq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apab
 * JD-Core Version:    0.7.0.1
 */