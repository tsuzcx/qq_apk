import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.1;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class abej
  extends abeg
{
  QQAppInterface app;
  private abej.b b;
  private boolean bCc;
  private acdu c;
  private View.OnClickListener dm = new abek(this);
  CardHandler f;
  private TroopManager h;
  private acff l;
  private Context mContext;
  private List<abej.a> mList = new ArrayList();
  
  public abej(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<RecentUser> paramList, abej.b paramb)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, false);
    bQ(paramQQAppInterface);
    this.mContext = paramContext;
    this.b = paramb;
    hT(paramList);
  }
  
  private ArrayList<abej.a> u(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = 0;
    RecentUser localRecentUser;
    String str;
    int i;
    Object localObject2;
    if (j < paramList.size())
    {
      localRecentUser = (RecentUser)paramList.get(j);
      abej.a locala = new abej.a();
      str = localRecentUser.uin;
      i = localRecentUser.getType();
      switch (localRecentUser.getType())
      {
      default: 
        i = 1;
        localObject1 = null;
      case 6002: 
        for (;;)
        {
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str;
          }
          locala.name = ((String)localObject2);
          locala.avatarType = i;
          locala.uin = str;
          locala.b = localRecentUser;
          localArrayList.add(locala);
          j += 1;
          break;
          localObject1 = localRecentUser.displayName;
          i = 104;
        }
      case 1008: 
        label292:
        localObject1 = ((acja)this.app.getManager(56)).b(str);
        if (localObject1 == null) {
          break;
        }
      }
    }
    for (Object localObject1 = ((PublicAccountInfo)localObject1).name;; localObject1 = null)
    {
      i = 1;
      break;
      localObject1 = aqgv.x(this.app, str);
      localObject2 = ((ajdo)this.app.getManager(11)).c(str);
      if (localObject2 != null) {
        localObject1 = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        i = 11;
        break;
        if (localObject1 != null) {
          localObject1 = aqgv.b(this.app, (String)localObject1, true);
        } else {
          localObject1 = str;
        }
      }
      localObject1 = this.l.e(str);
      if ((localObject1 != null) && (((Friends)localObject1).uin != null) && (((Friends)localObject1).uin.length() > 0)) {}
      for (localObject1 = aqgv.c((Friends)localObject1);; localObject1 = null)
      {
        if ((i == 1000) || (i == 1020))
        {
          localObject1 = this.h.jp(localRecentUser.troopUin);
          localObject1 = aqgv.a(this.app, str, (String)localObject1, localRecentUser.troopUin, true, null);
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (!"".equals(localObject1)) {}
          }
          else
          {
            localObject2 = aqgv.b(this.app, str, true);
          }
          localObject1 = localObject2;
          i = 1;
          break;
          if (i == 1004) {
            localObject1 = aqgv.m(this.app, localRecentUser.troopUin, str);
          }
        }
        if ((0 == 0) || ("".equals(null))) {}
        for (localObject1 = aqgv.b(this.app, str, true);; localObject1 = null)
        {
          i = 1;
          break;
          localObject1 = this.h.b(str);
          int k = 4;
          if (localObject1 != null) {}
          for (localObject2 = ((TroopInfo)localObject1).getTroopName();; localObject2 = localRecentUser.displayName)
          {
            if (localObject2 != null)
            {
              i = k;
              localObject1 = localObject2;
              if (!((String)localObject2).trim().equals("")) {
                break;
              }
            }
            localObject1 = str;
            i = k;
            break;
          }
          localObject1 = this.c.a(str);
          if ((localObject1 == null) || (((DiscussionInfo)localObject1).isHidden())) {
            break label292;
          }
          if (TextUtils.isEmpty(((DiscussionInfo)localObject1).discussionName)) {}
          for (localObject1 = localRecentUser.displayName;; localObject1 = ((DiscussionInfo)localObject1).discussionName)
          {
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = this.mContext.getResources().getString(2131692826);
            }
            localObject1 = localObject2;
            i = 101;
            break;
          }
          return localArrayList;
        }
      }
    }
  }
  
  public void Dv(boolean paramBoolean)
  {
    this.bCc = paramBoolean;
  }
  
  public void bQ(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.f = ((CardHandler)paramQQAppInterface.getBusinessHandler(2));
    this.l = ((acff)paramQQAppInterface.getManager(51));
    this.h = ((TroopManager)paramQQAppInterface.getManager(52));
    this.c = ((acdu)paramQQAppInterface.getManager(53));
  }
  
  public int getCount()
  {
    return this.mList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ForwardRecentItemView localForwardRecentItemView;
    Object localObject1;
    abej.a locala;
    BitmapDrawable localBitmapDrawable;
    boolean bool3;
    Object localObject2;
    if (paramView == null)
    {
      localForwardRecentItemView = new ForwardRecentItemView(this.mContext);
      localObject1 = new abeg.a();
      localForwardRecentItemView.setTag(localObject1);
      locala = (abej.a)getItem(paramInt);
      ((abeg.a)localObject1).uin = locala.uin;
      ((abeg.a)localObject1).type = locala.avatarType;
      ((abeg.a)localObject1).pQ = localForwardRecentItemView.xl;
      localBitmapDrawable = new BitmapDrawable(a(locala.avatarType, locala.uin));
      bool3 = this.b.F(locala.uin, locala.b.getType());
      localObject2 = localForwardRecentItemView.b;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ResultRecord();
      }
      ((ResultRecord)localObject1).b(locala.uin, locala.name, locala.b.getType(), locala.b.troopUin, "");
      if (locala.b.getType() != 3000) {
        break label323;
      }
      localObject2 = this.c.a(locala.uin);
      if ((localObject2 == null) || (((DiscussionInfo)localObject2).hasRenamed())) {
        break label299;
      }
      localForwardRecentItemView.a(locala.name, String.valueOf(this.c.cn(locala.uin)), localBitmapDrawable, (ResultRecord)localObject1, this.bCc, bool3);
    }
    for (;;)
    {
      localForwardRecentItemView.setOnClickListener(this.dm);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localForwardRecentItemView;
      localForwardRecentItemView = (ForwardRecentItemView)paramView;
      localObject1 = (abeg.a)localForwardRecentItemView.getTag();
      break;
      label299:
      localForwardRecentItemView.a(locala.name, null, localBitmapDrawable, (ResultRecord)localObject1, this.bCc, bool3);
      continue;
      label323:
      localObject2 = this.h.b(locala.uin);
      if ((localObject2 != null) && (!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
      {
        localForwardRecentItemView.a(locala.name, String.valueOf(((TroopInfo)localObject2).wMemberNumClient), localBitmapDrawable, (ResultRecord)localObject1, this.bCc, bool3);
      }
      else
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject2 == null)
        {
          bool1 = bool2;
          if (aprg.V(this.app, locala.uin)) {
            bool1 = true;
          }
        }
        localForwardRecentItemView.a(locala.name, null, localBitmapDrawable, (ResultRecord)localObject1, this.bCc, bool3, bool1);
      }
    }
  }
  
  public void hT(List<RecentUser> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new ForwardRecentListAdapter.1(this, paramList));
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardRecentListAdapter", 2, "notifyDataSetChanged() called");
    }
    super.notifyDataSetChanged();
  }
  
  public static class a
  {
    public int avatarType;
    public RecentUser b;
    public String name;
    public String uin;
  }
  
  public static abstract interface b
  {
    public abstract boolean F(String paramString, int paramInt);
    
    public abstract void eK(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     abej
 * JD-Core Version:    0.7.0.1
 */