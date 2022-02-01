import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.1;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.2;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.3;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.lang.ref.WeakReference;
import java.util.List;

public class xam
  extends wjd
  implements AdapterView.c
{
  private WeakReference<xam.b> ed;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private List<ApolloGameData> sc;
  
  public xam(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      cdF();
      QLog.e("ChatItemBuilder", 1, "[showNoGameRoleDialog] gameData null");
      return;
    }
    if (TextUtils.isEmpty(paramApolloGameData.gameAppid))
    {
      cdF();
      QLog.e("ChatItemBuilder", 1, "[showNoGameRoleDialog] gameAppid null");
      return;
    }
    aqha.a(this.mContext, 230).setMessage(this.mContext.getResources().getString(2131690371)).setPositiveButton(2131690353, new xao(this, paramApolloGameData)).setNegativeButton(2131690354, new xan(this)).show();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      cdF();
      QLog.e("ChatItemBuilder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    aqha.a(this.mContext, 230).setMessage(this.mContext.getResources().getString(2131690356)).setPositiveButton(2131690354, new xap(this)).show();
  }
  
  private void cdF()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131690352, 0).show();
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout = (MessageForCmGameTips)paramMessageRecord;
    if (!(parama instanceof xam.a)) {
      return paramView;
    }
    parama = (xam.a)parama;
    if (paramView != null)
    {
      paramMessageRecord = paramView;
      if (parama != null)
      {
        paramMessageRecord = paramView;
        if (parama.o != null) {}
      }
    }
    else
    {
      paramMessageRecord = (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558996, null, true);
      paramMessageRecord.setId(2131374743);
      parama.o = paramMessageRecord;
    }
    if (paramLinearLayout.gameInfo != null) {
      this.sc = paramLinearLayout.gameInfo.sc;
    }
    a(parama, paramLinearLayout);
    return paramMessageRecord;
  }
  
  protected wjd.a a()
  {
    return new xam.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(xam.a parama, MessageForCmGameTips paramMessageForCmGameTips)
  {
    if (paramMessageForCmGameTips.needTopPadding) {
      parama.o.setPadding(0, wja.dp2px(86.0F, this.mContext.getResources()), 0, wja.dp2px(20.0F, this.mContext.getResources()));
    }
    for (;;)
    {
      if (parama.hz == null) {
        parama.hz = ((RelativeLayout)parama.o.findViewById(2131377423));
      }
      if (parama.description == null) {
        parama.description = ((TextView)parama.o.findViewById(2131380647));
      }
      if (parama.g == null)
      {
        parama.g = ((GridView)parama.o.findViewById(2131368287));
        parama.g.setStretchMode(2);
      }
      parama.g.setNumColumns(3);
      parama.g.setColumnWidth(wja.dp2px(103.0F, this.mContext.getResources()));
      parama.g.setVerticalSpacing(wja.dp2px(10.0F, this.mContext.getResources()));
      parama.g.setHorizontalSpacing(wja.dp2px(5.0F, this.mContext.getResources()));
      parama.g.setSelector(new ColorDrawable(0));
      Object localObject = new abmj(paramMessageForCmGameTips.gameInfo, this.mContext);
      parama.g.setAdapter((ListAdapter)localObject);
      parama.g.setOnItemClickListener(this);
      parama.g.setStretchMode(2);
      int i = paramMessageForCmGameTips.gameInfo.sc.size() / 3;
      int j = wja.dp2px(339.0F, this.mContext.getResources());
      int k = wja.dp2px(73.0F, this.mContext.getResources());
      localObject = new RelativeLayout.LayoutParams(j, wja.dp2px((i - 1) * 68, this.mContext.getResources()) + k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131380647);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      parama.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
      parama.description.setText(paramMessageForCmGameTips.gameInfo.description);
      return;
      parama.o.setPadding(0, wja.dp2px(30.0F, this.mContext.getResources()), 0, wja.dp2px(20.0F, this.mContext.getResources()));
    }
  }
  
  public aqob[] a(View paramView)
  {
    return new aqob[0];
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.ed != null)
    {
      xam.b localb = (xam.b)this.ed.get();
      if (localb != null)
      {
        ((abhh)this.app.getManager(153)).a().b(localb);
        this.ed = null;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((abhh)this.app.getManager(153)).a();
    if ((this.ed == null) || (this.ed.get() == null))
    {
      paramView = new xam.b(this);
      this.ed = new WeakReference(paramView);
      paramAdapterView.a(paramView);
    }
    if (this.sc != null)
    {
      paramView = (ApolloGameData)this.sc.get(paramInt);
      if (paramView == null) {
        QLog.e("ChatItemBuilder", 1, "[onClick] no game data for id:" + paramInt);
      }
    }
    else
    {
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "mutualhobby", 0, 0, new String[] { paramView.gameId + "" });
    paramInt = (int)(System.currentTimeMillis() / 1000L);
    ((xam.b)this.ed.get()).bSO = paramInt;
    if (!paramView.isGameApp)
    {
      paramAdapterView.gF(paramView.gameId, paramInt);
      return;
    }
    abmh.a(this.app, this.mContext, this.sessionInfo, paramView, paramInt);
  }
  
  public static class a
    extends wjd.a
  {
    public TextView description;
    public GridView g;
    public RelativeLayout hz;
    public RelativeLayout o;
  }
  
  public static class b
    extends abmi.a
  {
    public int bSO;
    private WeakReference<xam> ee;
    
    public b(xam paramxam)
    {
      this.ee = new WeakReference(paramxam);
    }
    
    public void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
      }
      if (this.bSO != paramInt2)
      {
        QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] mCreateRoomReqCode != reqCode");
        return;
      }
      xam localxam = (xam)this.ee.get();
      if ((localxam == null) || (localxam.app == null))
      {
        QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
        return;
      }
      ApolloGameData localApolloGameData = ((abxk)localxam.app.getManager(155)).a(paramInt1);
      if (localApolloGameData == null)
      {
        QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
        return;
      }
      if (paramLong == 0L)
      {
        abmh.a(localxam.app, paramString1, paramString2);
        return;
      }
      if (paramLong == -300404L)
      {
        xam.a(localxam).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localxam, localApolloGameData));
        return;
      }
      if (paramLong == -300405L)
      {
        xam.a(localxam).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localxam, localApolloGameData));
        return;
      }
      QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
      xam.a(localxam).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localxam));
    }
    
    public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
    {
      xam localxam = (xam)this.ee.get();
      if (localxam == null) {
        break label17;
      }
      label17:
      while (localxam.app == null) {
        return;
      }
      if (this.bSO != paramInt2)
      {
        QLog.e("ChatItemBuilder", 1, "onCreateRoomId mCreateRoomReqCode != reqCode");
        return;
      }
      if (!paramBoolean)
      {
        QLog.e("ChatItemBuilder", 1, "onCreateRoomId createSuccess:false");
        return;
      }
      super.a(paramBoolean, paramInt1, paramLong, paramInt2);
      ApolloPanel.b localb = new ApolloPanel.b();
      Object localObject = (abxk)localxam.app.getManager(155);
      String str = acfp.m(2131704142);
      ApolloGameData localApolloGameData = ((abxk)localObject).a(paramInt1);
      if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
      {
        localObject = ((abxk)localObject).a(localApolloGameData.actionId);
        if (localObject == null) {
          break label296;
        }
        str = ((ApolloActionData)localObject).actionName;
      }
      label296:
      for (;;)
      {
        paramInt2 = localApolloGameData.actionId;
        localb.gameName = localApolloGameData.name;
        for (;;)
        {
          localb.actionName = str;
          localb.actionId = paramInt2;
          localb.roomId = paramLong;
          localb.gameId = paramInt1;
          localb.msgType = 3;
          localb.gameStatus = 0;
          if ((localxam.sessionInfo == null) || (localxam.app == null)) {
            break;
          }
          abmh.a(localxam.app, localxam.sessionInfo.aTl, localb);
          if (!abmk.gM(localxam.sessionInfo.aTl)) {
            break;
          }
          ((abhh)localxam.app.getManager(153)).a().y(localxam.sessionInfo.aTl, paramInt1, paramLong);
          return;
          localb.gameName = acfp.m(2131704143);
          paramInt2 = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xam
 * JD-Core Version:    0.7.0.1
 */