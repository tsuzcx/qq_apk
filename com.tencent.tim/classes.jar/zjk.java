import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.1;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zjk
  extends zkv
{
  public Set<Long> by = new HashSet();
  private SimpleDateFormat e = new SimpleDateFormat("M月d日");
  public Object mLock = new Object();
  public List<zmc> uk = new ArrayList();
  
  public zjk(Context paramContext, aurf paramaurf, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramaurf, paramSessionInfo, paramQQAppInterface);
  }
  
  public void a(List<zmc> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("setMessageItems loadType: ").append(paramInt1).append(", searchMode: ").append(paramInt2).append(", cloudGetCompleted: ").append(paramBoolean).append(", messageItems size: ");
      if (paramList == null)
      {
        i = 0;
        QLog.d("LinkMessageResultAdapter", 2, i);
      }
    }
    else
    {
      if ((paramInt1 != 1) || (paramInt2 != 0)) {
        break label98;
      }
      this.uy = paramList;
    }
    label98:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        if ((paramInt1 == 2) && (paramInt2 == 0))
        {
          this.uy.addAll(paramList);
          return;
        }
      } while ((paramInt1 != 4) || (paramList == null) || (paramList.size() == 0) || (paramInt2 != 1));
      if ((this.uy.size() <= 0) || (paramList.size() <= 0)) {
        break label237;
      }
      localObject = (zmc)paramList.get(0);
      zmc localzmc = (zmc)this.uy.get(this.uy.size() - 1);
      if (((zmc)localObject).messageRecord.time <= localzmc.messageRecord.time) {
        break label237;
      }
    } while (!QLog.isColorLevel());
    QLog.e("LinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label237:
    this.uy.addAll(paramList);
  }
  
  public void a(List<zmc> paramList, String paramString, long paramLong)
  {
    this.uk.clear();
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new TroopAllMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
  }
  
  public void ac(List<zmc> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: " + paramBoolean);
    }
    this.uy.clear();
    this.uy.addAll(paramList);
  }
  
  public void clearData()
  {
    this.uy.clear();
    notifyDataSetChanged();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    zmc localzmc = (zmc)getItem(paramInt);
    View localView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, 2131559542, null);
      paramView = new zkv.a();
      paramView.c = ((ColorNickTextView)localView.findViewById(2131379402));
      paramView.KQ = ((TextView)localView.findViewById(2131379404));
      paramView.icon = ((ImageView)localView.findViewById(2131368698));
      paramView.time = ((TextView)localView.findViewById(2131370129));
      localView.setTag(paramView);
      localObject1 = localzmc.messageRecord;
      localObject2 = aqgv.a(this.app, this.mSessionInfo, ((MessageRecord)localObject1).isSend(), ((MessageRecord)localObject1).senderuin);
      paramView.KQ.setText(localzmc.a(((MessageRecord)localObject1).msg, -11353092));
      if (!((MessageRecord)localObject1).isSend()) {
        break label289;
      }
      this.app.getCurrentAccountUin();
      label162:
      if (!jof.a((MessageRecord)localObject1)) {
        break label301;
      }
      localObject2 = jof.a((MessageRecord)localObject1);
      paramView.c.setText(this.mContext.getResources().getString(2131699453) + ((jof.a)localObject2).TG);
      paramView.icon.setBackgroundDrawable(URLDrawable.getDrawable(jof.aV(((jof.a)localObject2).aCv)));
    }
    for (;;)
    {
      paramView.time.setText(localzmc.be(((MessageRecord)localObject1).time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (zkv.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
      label289:
      String str = this.mSessionInfo.aTl;
      break label162;
      label301:
      paramView.c.setText(localzmc.a((String)localObject2, -11353092));
      paramView.icon.setBackgroundDrawable(aqdj.a(this.app, 1, ((MessageRecord)localObject1).senderuin));
    }
  }
  
  public void j(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new TroopAllMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjk
 * JD-Core Version:    0.7.0.1
 */