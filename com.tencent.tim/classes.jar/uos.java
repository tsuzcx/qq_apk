import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistoryStructMsgView.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import mqq.os.MqqHandler;

public class uos
  extends uou
  implements Handler.Callback, AbsListView.e
{
  private static int bFw = 30;
  public long FH = 9223372036854775807L;
  public long FI = 9223372036854775807L;
  public long FJ = 9223372036854775807L;
  final String TAG = "ChatHistory_Struct";
  abdy a;
  public String aLX;
  boolean aUa = false;
  public boolean aUg = false;
  public int bFx = 3;
  View.OnClickListener de;
  View.OnClickListener df;
  private RelativeLayout gp;
  XListView l;
  public QQAppInterface mApp;
  Context mContext;
  public ArrayList<Object> mData = new ArrayList();
  public String mUin;
  public int mUinType;
  View rS;
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private TextView xQ;
  
  private void bKj()
  {
    if (this.df != null) {
      return;
    }
    this.df = new uot(this);
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mUin = paramIntent.getStringExtra("uin");
    this.mUinType = paramIntent.getIntExtra("uintype", 0);
    this.aLX = paramIntent.getStringExtra("uinname");
    bKj();
    this.gp = ((RelativeLayout)View.inflate(this.mContext, 2131563126, null));
    this.xQ = ((TextView)this.gp.findViewById(2131366437));
    this.xQ.setVisibility(0);
    this.l = ((XListView)this.gp.findViewById(2131378827));
    this.l.setCacheColorHint(0);
    this.l.setOnScrollListener(this);
    this.rS = View.inflate(this.mContext, 2131563125, null);
    this.rS.setVisibility(0);
    this.l.addFooterView(this.rS);
    wu(true);
    this.a = new abdy(this.mContext, (ArrayList)this.mData.clone(), this.df, this.de, this);
    this.l.setAdapter(this.a);
  }
  
  public View aI()
  {
    return this.gp;
  }
  
  public boolean bC()
  {
    return this.aUa;
  }
  
  public void bJY()
  {
    this.aUa = true;
    this.a.notifyDataSetChanged();
  }
  
  public void bJZ()
  {
    this.aUa = false;
    this.a.notifyDataSetChanged();
  }
  
  public void fG(List<ChatMessage> paramList)
  {
    Iterator localIterator;
    int i;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.mData.removeAll(paramList);
      localIterator = this.mData.iterator();
      paramList = null;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = paramList;
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof String))
        {
          localObject1 = paramList;
          if (i == 0) {
            localObject1 = localObject2;
          }
          int j = i + 1;
          paramList = (List<ChatMessage>)localObject1;
          i = j;
          if (j != 2) {
            continue;
          }
        }
      }
      else
      {
        if (localObject1 != null) {
          this.mData.remove(localObject1);
        }
        this.uiHandler.sendEmptyMessage(1);
        return;
      }
      paramList = null;
      i = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (this.mData.isEmpty())
    {
      this.xQ.setVisibility(0);
      this.l.setVisibility(4);
    }
    for (;;)
    {
      this.a.notifyDataSetChanged();
      return false;
      this.xQ.setVisibility(8);
      this.rS.setVisibility(8);
      this.l.setVisibility(0);
      this.a.mData = ((ArrayList)this.mData.clone());
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!this.aUg))
    {
      this.rS.setVisibility(0);
      wu(false);
      this.a.notifyDataSetChanged();
    }
  }
  
  public void wu(boolean paramBoolean)
  {
    ThreadManager.post(new ChatHistoryStructMsgView.2(this, paramBoolean), 10, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uos
 * JD-Core Version:    0.7.0.1
 */