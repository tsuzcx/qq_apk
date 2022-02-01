import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.2;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.1;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.2;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.3;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abzq
  extends acbg
  implements View.OnClickListener
{
  public static boolean bGx;
  public static long sStartTime;
  private XListView L;
  private ProgressBar Y;
  private abzq.a a;
  private URLImageView aQ;
  private abkf jdField_b_of_type_Abkf = new abkf(-1, -1);
  private auvw jdField_b_of_type_Auvw;
  public ApolloGameData c;
  private SparseArray<SparseArray<ApolloGameRedDot>> cg;
  private int cuc = -1;
  private ViewGroup dP;
  private ViewGroup dQ;
  private ViewGroup dR;
  private ViewGroup dS;
  private Button eC;
  private WeakReference<abzq.b> ed;
  private Button fE;
  private Button fF;
  private Button fG;
  int[] kd = { 1002, 1001, 1000, 1005 };
  private QQAppInterface mApp;
  private BaseChatPie mBaseChatPie;
  private EntityManager mEntityManager;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private SessionInfo mSessionInfo;
  private int mSessionType;
  private List<ApolloGameData> wU;
  private List<ApolloGameRankData> wV;
  private ImageView xR;
  private ImageView xS;
  private ImageView xT;
  private ImageView xU;
  private ImageView xV;
  
  public abzq(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.mBinderType = 100;
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mEntityManager = this.mApp.a().createEntityManager();
    this.mSessionInfo = paramSessionInfo;
    this.mBaseChatPie = paramBaseChatPie;
    this.mSessionType = ApolloUtil.a(this.mSessionInfo, paramQQAppInterface);
    paramContext = ApolloGameUtil.p();
    if ((paramContext != null) && (paramContext.getBoolean("sp.aio.show", true))) {}
    for (;;)
    {
      bGx = bool;
      return;
      bool = false;
    }
  }
  
  private void a(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      cdF();
      QLog.e("ApolloGameViewBinder", 1, "[showNoGameRoleDialog] gameData null");
      return;
    }
    if (TextUtils.isEmpty(paramApolloGameData.gameAppid))
    {
      cdF();
      QLog.e("ApolloGameViewBinder", 1, "[showNoGameRoleDialog] gameAppid null");
      return;
    }
    aqha.a(this.mContext, 230).setMessage(this.mContext.getResources().getString(2131690371)).setPositiveButton(2131690353, new abzt(this, paramApolloGameData)).setNegativeButton(2131690354, new abzs(this)).show();
  }
  
  private void b(ApolloGameData paramApolloGameData)
  {
    if (paramApolloGameData == null)
    {
      cdF();
      QLog.e("ApolloGameViewBinder", 1, "[showFriendNoGameRoleDialog] gameData null");
      return;
    }
    aqha.a(this.mContext, 230).setMessage(this.mContext.getResources().getString(2131690356)).setPositiveButton(2131690354, new abzu(this)).show();
  }
  
  private void cdF()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131702493), 0).show();
  }
  
  private void d(ApolloGameData paramApolloGameData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[onGameItemClick] gameInfo=", paramApolloGameData });
    }
    if (paramApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onGameItemClick] gameInfo null");
      return;
    }
    Object localObject1;
    if (paramApolloGameData.isSetting) {
      if (this.mContext != null)
      {
        localObject1 = abxi.bjT;
        if (!TextUtils.isEmpty(paramApolloGameData.toolUrl)) {
          localObject1 = paramApolloGameData.toolUrl;
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if ("1".equals(Uri.parse((String)localObject1).getQueryParameter("useApolloBrowser")))
        {
          ApolloUtil.a(this.mContext, null, "aio", (String)localObject1, null);
          if (this.mApp != null) {
            ApolloGameUtil.Z(this.mApp);
          }
          localObject2 = this.mApp;
          i = ApolloUtil.a(this.mSessionInfo, this.mApp);
          if (!ZC()) {
            break label762;
          }
          paramApolloGameData = "0";
          if (!ApolloGameUtil.Z(this.mApp)) {
            break label261;
          }
          localObject1 = "0";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "clk_more_game_enter", i, 0, new String[] { paramApolloGameData, localObject1 });
          return;
        }
      }
      catch (Throwable paramApolloGameData)
      {
        QLog.e("ApolloGameViewBinder", 1, paramApolloGameData, new Object[] { "[onGameItemClick]" });
        return;
      }
      paramApolloGameData = new Intent(this.mContext, QQBrowserActivity.class);
      paramApolloGameData.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(this.mContext, (String)localObject1, -1L, paramApolloGameData, false, -1);
      continue;
      label261:
      localObject1 = "1";
      continue;
      QLog.e("ApolloGameViewBinder", 1, "[onGameItemClick] empty context");
      this.dS.setVisibility(8);
      if (this.mSessionInfo.cZ == 1036)
      {
        localObject1 = ((abhh)this.mApp.getManager(153)).a();
        if ((this.ed == null) || (this.ed.get() == null))
        {
          localObject2 = new abzq.b(this);
          this.ed = new WeakReference(localObject2);
          ((abmi)localObject1).a((abmi.b)localObject2);
        }
        ((abzq.b)this.ed.get()).bSO = ((int)(System.currentTimeMillis() / 1000L));
        if (!paramApolloGameData.isGameApp)
        {
          ((abmi)localObject1).gF(paramApolloGameData.gameId, ((abzq.b)this.ed.get()).bSO);
          if ((this.cg == null) || (this.cg.get(paramApolloGameData.gameId) == null) || (((SparseArray)this.cg.get(paramApolloGameData.gameId)).size() <= 0)) {
            break label757;
          }
          localObject1 = (SparseArray)this.cg.get(paramApolloGameData.gameId);
          if (((SparseArray)localObject1).get(2000) != null)
          {
            ((SparseArray)localObject1).remove(2000);
            ApolloGameUtil.a(this.mEntityManager, paramApolloGameData.gameId, 2000);
            if (this.a != null) {
              this.a.notifyDataSetChanged();
            }
          }
        }
      }
      label547:
      label749:
      label757:
      for (int i = 1;; i = 0)
      {
        QQAppInterface localQQAppInterface = this.mApp;
        int j = this.mSessionType;
        int k = paramApolloGameData.gameId;
        if (i != 0)
        {
          localObject1 = "1";
          if (paramApolloGameData.type != 2) {
            break label749;
          }
        }
        for (localObject2 = "1";; localObject2 = "0")
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_game_banner", j, 0, new String[] { String.valueOf(k), localObject1, localObject2, String.valueOf(paramApolloGameData.tagType) });
          return;
          abmh.a(this.mApp, this.mContext, this.mSessionInfo, paramApolloGameData, ((abzq.b)this.ed.get()).bSO);
          break;
          j = paramApolloGameData.gameId;
          k = this.mSessionInfo.cZ;
          int m = ApolloGameUtil.a(this.mApp, this.mSessionInfo.cZ, this.mSessionInfo.aTl);
          localObject1 = this.mSessionInfo.aTl;
          if (ZC()) {}
          for (i = 317;; i = 100)
          {
            localObject1 = new CmGameStartChecker.StartCheckParam(j, true, "launch", 0L, 0, 0, k, m, (String)localObject1, i, null);
            ApolloGameUtil.a(this.mContext, (CmGameStartChecker.StartCheckParam)localObject1);
            break;
          }
          localObject1 = "0";
          break label547;
        }
      }
      label762:
      paramApolloGameData = "1";
    }
  }
  
  private void u(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[initView] panelView=", paramView, ", mGameRootView=", this.dP });
    }
    if (this.dP != paramView)
    {
      this.dP = ((ViewGroup)paramView);
      this.L = ((XListView)this.dP.findViewById(2131367865));
      this.dQ = ((ViewGroup)this.dP.findViewById(2131365342));
      this.aQ = ((URLImageView)this.dQ.findViewById(2131368719));
      this.xR = ((ImageView)this.dQ.findViewById(2131368709));
      this.xR.setOnClickListener(this);
      this.xS = ((ImageView)this.dQ.findViewById(2131368750));
      this.xS.setOnClickListener(this);
      this.xT = ((ImageView)this.dQ.findViewById(2131368720));
      this.xT.setOnClickListener(this);
      this.xU = ((ImageView)this.dQ.findViewById(2131368718));
      this.xU.setOnClickListener(this);
      this.dR = ((ViewGroup)this.dQ.findViewById(2131365338));
      this.eC = ((Button)this.dR.findViewById(2131363961));
      this.eC.setOnClickListener(this);
      this.fE = ((Button)this.dR.findViewById(2131364007));
      this.fE.setOnClickListener(this);
      this.fF = ((Button)this.dQ.findViewById(2131364008));
      this.fF.setOnClickListener(this);
      this.fG = ((Button)this.dQ.findViewById(2131363795));
      this.fG.setOnClickListener(this);
      this.dS = ((ViewGroup)this.dP.findViewById(2131365351));
      this.Y = ((ProgressBar)this.dS.findViewById(2131373677));
      this.xV = ((ImageView)this.dP.findViewById(2131373681));
      this.dS.setVisibility(8);
      this.xV.setVisibility(8);
      this.Y.setProgress(0);
    }
  }
  
  public int Ad()
  {
    return 1;
  }
  
  public boolean ZC()
  {
    return (this.mBaseChatPie != null) && (this.mBaseChatPie.a != null) && (this.mBaseChatPie.a.Ae() == 7);
  }
  
  public ApolloGameData a()
  {
    ApolloGameData localApolloGameData = new ApolloGameData();
    localApolloGameData.gameId = 2147483647;
    localApolloGameData.isShow = 1;
    localApolloGameData.name = ablf.it("aio.enter.name");
    localApolloGameData.listCoverUrl = ablf.it("aio.enter.bg");
    localApolloGameData.isSetting = true;
    localApolloGameData.toolUrl = ablf.it("aio.enter");
    return localApolloGameData;
  }
  
  public void a(abkf paramabkf)
  {
    if (QLog.isColorLevel()) {
      if (paramabkf != null) {
        break label41;
      }
    }
    label41:
    for (int i = -1;; i = paramabkf.gameId)
    {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[setJumpGameId] jumpGameId=", Integer.valueOf(i) });
      this.jdField_b_of_type_Abkf = paramabkf;
      return;
    }
  }
  
  public void ac(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updatePanel] panelView=", paramView, ", pageIndex=", Integer.valueOf(paramInt) });
    }
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[updatePanel] panelView null");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.awS == 8);
      if ((this.wU != null) && (this.wU.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameViewBinder", 2, "[updatePanel] no game data");
    return;
    u(paramView);
    paramInt = ApolloGameUtil.d(this.mApp);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updatePanel] gameCoinCount=", Integer.valueOf(paramInt) });
    }
    if (paramInt > 9999) {}
    this.dS.setVisibility(8);
    this.xV.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[updatePanel] prepare list data");
    }
    if (this.a == null) {
      this.a = new abzq.a(this.mContext, this);
    }
    this.a.iv(this.wU);
    this.L.setAdapter(this.a);
    if ((this.jdField_b_of_type_Abkf != null) && (this.jdField_b_of_type_Abkf.gameId > 0) && (this.wU.size() > 1))
    {
      paramView = this.wU.iterator();
      while (paramView.hasNext()) {
        if (((ApolloGameData)paramView.next()).gameId == this.jdField_b_of_type_Abkf.gameId)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameViewBinder", 2, new Object[] { "[updatePanel] jump gameId:", Integer.valueOf(this.jdField_b_of_type_Abkf.gameId), ",from:", Integer.valueOf(this.jdField_b_of_type_Abkf.from) });
          }
          VipUtils.a(this.mApp, "cmshow", "Apollo", "avatar_clk_togame", this.mSessionType, this.jdField_b_of_type_Abkf.from, new String[] { String.valueOf(this.jdField_b_of_type_Abkf.gameId) });
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[updatePanel] show game list");
    }
    this.L.setVisibility(0);
    this.dS.setVisibility(8);
    this.dQ.setVisibility(8);
  }
  
  public ApolloGameData b()
  {
    return this.c;
  }
  
  public View bQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[createPanelView]");
    }
    Object localObject1;
    if (this.mContext == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[createPanelView] context null");
      localObject1 = null;
    }
    Object localObject2;
    TextView localTextView;
    do
    {
      return localObject1;
      switch (this.awS)
      {
      default: 
        localObject1 = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131558716, null);
        localObject2 = (XListView)((ViewGroup)localObject1).findViewById(2131367865);
        return localObject1;
      }
      localObject2 = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131558721, null);
      localTextView = (TextView)((ViewGroup)localObject2).findViewById(2131372421);
      if (abhe.XY())
      {
        localTextView.setOnClickListener(null);
        localTextView.setText(this.mContext.getResources().getString(2131690388));
        return localObject2;
      }
      localObject1 = localObject2;
    } while (!aqiw.isNetworkAvailable(this.mContext));
    localTextView.setText(acfp.m(2131702523));
    localTextView.setOnClickListener(new abzr(this));
    return localObject2;
  }
  
  public String getFriendUin()
  {
    if ((this.mApp != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.sessionInfo != null) && (this.mBaseChatPie.sessionInfo.cZ == 0)) {
      return this.mBaseChatPie.sessionInfo.aTl;
    }
    return null;
  }
  
  public boolean im(int paramInt)
  {
    if (this.mApp != null)
    {
      ??? = (abxk)this.mApp.getManager(155);
      if (TextUtils.isEmpty(getFriendUin())) {
        return false;
      }
      if (this.mSessionInfo != null) {
        this.wV = ((abxk)???).d(ApolloGameUtil.Ab(), this.mSessionInfo.aTl);
      }
      if ((this.wV != null) && (paramInt > 0))
      {
        Object localObject3;
        synchronized (this.wV)
        {
          ArrayList localArrayList = new ArrayList();
          localObject3 = this.wV.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ApolloGameRankData localApolloGameRankData = (ApolloGameRankData)((Iterator)localObject3).next();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameViewBinder", 2, new Object[] { "[hasRankIcon] t ", localApolloGameRankData });
            }
            String str = getFriendUin();
            if ((localApolloGameRankData != null) && (!TextUtils.isEmpty(str)) && (localApolloGameRankData.isInvalid()) && (localApolloGameRankData.mGameId == paramInt) && (localApolloGameRankData.mRank == 1) && (str.equals(localApolloGameRankData.mFriendUin))) {
              return true;
            }
            if ((localApolloGameRankData != null) && (!localApolloGameRankData.isInvalid())) {
              localArrayList.add(localApolloGameRankData);
            }
          }
        }
        if (localObject2.size() > 0)
        {
          Iterator localIterator = localObject2.iterator();
          while (localIterator.hasNext())
          {
            localObject3 = (ApolloGameRankData)localIterator.next();
            ApolloGameUtil.a(this.mApp, (ApolloGameRankData)localObject3);
            this.wV.remove(localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameViewBinder", 2, new Object[] { "[valid] remove red corner for ", localObject3 });
            }
            VipUtils.a(this.mApp, "cmshow", "Apollo", "beyond_notice_disappear", 2, 0, new String[] { String.valueOf(((ApolloGameRankData)localObject3).mGameId) });
          }
        }
      }
    }
    return false;
  }
  
  public void iv(List<ApolloGameData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[setGameList] list=", paramList });
    }
    if ((this.mSessionInfo.cZ != 1036) && (paramList != null) && (ablf.b("aio.city.game", this.mApp) == ablg.cpH)) {
      paramList.add(0, a());
    }
    this.wU = paramList;
    this.cg = ApolloGameUtil.a(this.mEntityManager);
    if (this.cg != null)
    {
      int i = 0;
      while ((this.wU != null) && (i < this.wU.size()))
      {
        paramList = (ApolloGameData)this.wU.get(i);
        if (paramList != null)
        {
          SparseArray localSparseArray = (SparseArray)this.cg.get(paramList.gameId);
          if ((localSparseArray != null) && (localSparseArray.size() > 0))
          {
            localSparseArray.remove(1001);
            if (TextUtils.isEmpty(paramList.toolUrl)) {
              localSparseArray.remove(1002);
            }
          }
        }
        i += 1;
      }
    }
    this.wV = ((abxk)this.mApp.getManager(155)).Q(6);
  }
  
  public void iw(List<ApolloGameData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, "[updateGameList]");
    }
    if ((this.mSessionInfo != null) && (this.mSessionInfo.cZ == 1036))
    {
      this.wU.clear();
      this.wU.addAll(paramList);
      this.a.notifyDataSetChanged();
    }
    do
    {
      return;
      if ((paramList != null) && (ablf.b("aio.city.game", this.mApp) == ablg.cpH)) {
        paramList.add(0, a());
      }
    } while ((this.wU == null) || (paramList == null) || (this.a == null));
    this.wU.clear();
    this.wU.addAll(paramList);
    this.a.notifyDataSetChanged();
  }
  
  public void onClick(View paramView) {}
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.destroy();
    }
    if ((ZC()) && (abhe.cb("apollo_aio_game_guide") == -1))
    {
      abhe.cZ("apollo_aio_game_guide", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, "[onDestroy] from destory");
      }
    }
    if (this.jdField_b_of_type_Auvw != null) {}
    try
    {
      this.jdField_b_of_type_Auvw.dismiss();
      this.jdField_b_of_type_Auvw = null;
      QLog.i("ApolloGameViewBinder", 1, "onDestroy CmGameTempSessionHandler");
      if (this.ed != null)
      {
        abzq.b localb = (abzq.b)this.ed.get();
        if (localb != null)
        {
          ((abhh)this.mApp.getManager(153)).a().b(localb);
          this.ed = null;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloGameViewBinder", 1, localThrowable, new Object[] { "[onPanelClose] dissmiss window " });
      }
    }
  }
  
  public static class a
    extends BaseAdapter
    implements View.OnClickListener
  {
    private auvw c;
    private Context context;
    private WeakReference<abzq> fX;
    private int itemHeight;
    private int itemWidth;
    private List<ApolloGameData> wJ;
    
    public a(Context paramContext, abzq paramabzq)
    {
      this.context = paramContext;
      this.fX = new WeakReference(paramabzq);
      long l = Math.min(aqgz.hK(), aqgz.hL());
      this.itemWidth = ((int)((float)l - 30.0F * aqgz.getDesity()) / 3);
      this.itemHeight = ((int)(9.0D * (this.itemWidth / 16.0D)));
      QLog.i("GameListAdapter", 1, "screenWidth:" + l + ",itemWidth:" + this.itemWidth + ",itemHeight:" + this.itemHeight);
    }
    
    public void a(ViewGroup paramViewGroup, abzq.a.a parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "[showHighLightGame] ");
      }
      if (parama.AU != null)
      {
        paramViewGroup.removeView(parama.AU);
        parama.AU = null;
      }
      paramViewGroup.setClipChildren(true);
      paramViewGroup.setClipToPadding(true);
      Object localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131369390);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131369390);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131369390);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131369390);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
      localRelativeLayout.setId(2131362766);
      localRelativeLayout.setBackgroundDrawable(null);
      paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      parama.AU = localRelativeLayout;
      localObject = new ImageView(this.context);
      ((ImageView)localObject).setImageResource(2130838679);
      ((ImageView)localObject).setVisibility(8);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      localRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(this.itemWidth, this.itemHeight));
      ((ImageView)localObject).setVisibility(8);
      ((ImageView)localObject).postDelayed(new ApolloGameViewBinder.GameListAdapter.2(this, (ImageView)localObject, localRelativeLayout, paramViewGroup, parama), 400L);
    }
    
    public void cGy()
    {
      if (this.c != null) {
        this.c.dismiss();
      }
    }
    
    public void destroy()
    {
      cGy();
    }
    
    public int getCount()
    {
      int i;
      if ((this.wJ == null) || (this.wJ.size() == 0)) {
        i = 0;
      }
      int k;
      int j;
      do
      {
        return i;
        k = this.wJ.size();
        j = k / 3;
        i = j;
      } while (k % 3 == 0);
      return j + 1;
    }
    
    public Object getItem(int paramInt)
    {
      Object localObject;
      if ((this.wJ == null) || (this.wJ.size() == 0))
      {
        localObject = null;
        return localObject;
      }
      ArrayList localArrayList = new ArrayList(3);
      int i = paramInt * 3;
      paramInt = i;
      for (;;)
      {
        localObject = localArrayList;
        if (paramInt >= i + 3) {
          break;
        }
        localObject = localArrayList;
        if (paramInt < 0) {
          break;
        }
        localObject = localArrayList;
        if (paramInt >= this.wJ.size()) {
          break;
        }
        localArrayList.add(this.wJ.get(paramInt));
        paramInt += 1;
      }
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      abzq.a.a locala;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.context).inflate(2131558717, paramViewGroup, false);
        locala = new abzq.a.a(null);
        locala.e[0] = ((ViewGroup)paramView.findViewById(2131369383));
        locala.a[0] = ((URLImageView)paramView.findViewById(2131369384));
        locala.q[0] = ((TextView)paramView.findViewById(2131369385));
        locala.r[0] = ((ImageView)paramView.findViewById(2131369386));
        locala.a[0].setLayoutParams(new RelativeLayout.LayoutParams(this.itemWidth, this.itemHeight));
        locala.s[0] = ((ImageView)paramView.findViewById(2131369387));
        locala.e[1] = ((ViewGroup)paramView.findViewById(2131369389));
        locala.a[1] = ((URLImageView)paramView.findViewById(2131369390));
        locala.q[1] = ((TextView)paramView.findViewById(2131369391));
        locala.r[1] = ((ImageView)paramView.findViewById(2131369392));
        locala.a[1].setLayoutParams(new RelativeLayout.LayoutParams(this.itemWidth, this.itemHeight));
        locala.s[1] = ((ImageView)paramView.findViewById(2131369393));
        locala.e[2] = ((ViewGroup)paramView.findViewById(2131369395));
        locala.a[2] = ((URLImageView)paramView.findViewById(2131369396));
        locala.q[2] = ((TextView)paramView.findViewById(2131369397));
        locala.r[2] = ((ImageView)paramView.findViewById(2131369398));
        locala.a[2].setLayoutParams(new RelativeLayout.LayoutParams(this.itemWidth, this.itemHeight));
        locala.s[2] = ((ImageView)paramView.findViewById(2131369399));
        paramView.setTag(locala);
        localObject1 = (abzq)this.fX.get();
        if (localObject1 == null) {
          break label1636;
        }
        abzq.a((abzq)localObject1);
      }
      label418:
      label722:
      label1627:
      label1630:
      label1636:
      for (Object localObject1 = abzq.a((abzq)localObject1);; localObject1 = null)
      {
        ArrayList localArrayList = (ArrayList)getItem(paramInt);
        int i;
        ApolloGameData localApolloGameData;
        Object localObject3;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          i = 0;
          if (i >= 3) {
            break label1611;
          }
          if (i < localArrayList.size())
          {
            localApolloGameData = (ApolloGameData)localArrayList.get(i);
            locala.e[i].setVisibility(0);
            locala.e[i].setTag(localApolloGameData);
            locala.e[i].setOnClickListener(this);
            locala.q[i].setText(localApolloGameData.name);
            if (localObject1 == null) {
              break label1630;
            }
            localObject2 = (SparseArray)((SparseArray)localObject1).get(localApolloGameData.gameId);
            if ((localObject2 == null) || (((SparseArray)localObject2).size() <= 0)) {
              break label1630;
            }
            localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1002);
            localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1001);
            localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1005);
          }
        }
        for (Object localObject2 = (ApolloGameRedDot)((SparseArray)localObject2).get(1000);; localObject2 = null)
        {
          label618:
          int j;
          if (localApolloGameData.isGameApp)
          {
            locala.r[i].setImageResource(2130838584);
            locala.r[i].setVisibility(0);
            int k = 0;
            j = k;
            if (localObject2 != null)
            {
              j = k;
              if (!((ApolloGameRedDot)localObject2).mIsShow) {
                j = 1;
              }
            }
            if (j == 0) {
              break label1456;
            }
            localObject2 = this.context.getResources().getDrawable(2130851400);
            ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
            locala.q[i].setCompoundDrawablePadding(wja.dp2px(5.0F, this.context.getResources()));
            locala.q[i].setCompoundDrawables((Drawable)localObject2, null, null, null);
            if (TextUtils.isEmpty(localApolloGameData.listCoverUrl)) {
              break label1486;
            }
            localObject2 = this.context.getResources();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Resources)localObject2).getDrawable(2130838653);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Resources)localObject2).getDrawable(2130838653);
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.itemWidth;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.itemHeight;
            localObject2 = URLDrawable.getDrawable(localApolloGameData.listCoverUrl, (URLDrawable.URLDrawableOptions)localObject3);
            locala.a[i].setImageDrawable((Drawable)localObject2);
            j = paramInt * 3 + i;
            if ((this.fX == null) || (this.fX.get() == null) || (ablf.b("aio.city.game", abzq.a((abzq)this.fX.get())) != ablg.cpH)) {
              break label1627;
            }
            j -= 1;
          }
          for (;;)
          {
            if ((j < ApolloGameUtil.Ab()) && (this.fX != null) && (this.fX.get() != null) && (((abzq)this.fX.get()).im(localApolloGameData.gameId)) && (locala.s[i].getVisibility() != 0))
            {
              localObject2 = locala.s[i];
              ((ImageView)localObject2).setVisibility(0);
              localObject3 = new RedTouch(this.context, (View)localObject2).a(19).a();
              BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
              localRedTypeInfo.red_type.set(4);
              localRedTypeInfo.red_content.set(acfp.m(2131702490));
              localRedTypeInfo.red_desc.set("{'cn':'#FF0000', 'av':1}");
              ((RedTouch)localObject3).c(localRedTypeInfo);
              ((ImageView)localObject2).setTag(localObject3);
              if (abzq.sStartTime == 0L) {
                abzq.sStartTime = System.currentTimeMillis();
              }
              if ((this.fX != null) && (this.fX.get() != null)) {
                VipUtils.a(abzq.a((abzq)this.fX.get()), "cmshow", "Apollo", "beyond_notice", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
              }
              if (abzq.bGx)
              {
                abzq.bGx = false;
                localObject3 = ApolloGameUtil.p();
                if (localObject3 != null) {
                  ((SharedPreferences)localObject3).edit().putBoolean("sp.aio.show", false).apply();
                }
                if (QLog.isColorLevel()) {
                  QLog.d("GameListAdapter", 2, "show guide window");
                }
                ((ImageView)localObject2).postDelayed(new ApolloGameViewBinder.GameListAdapter.1(this, (ImageView)localObject2), 200L);
              }
              if ((this.fX != null) && (this.fX.get() != null) && (abzq.a((abzq)this.fX.get()) != null) && (localApolloGameData.gameId == abzq.a((abzq)this.fX.get()).gameId))
              {
                a(locala.e[i], locala);
                localObject2 = (abhe)abzq.a((abzq)this.fX.get()).getManager(211);
                ((abhe)localObject2).gA(-1, -1);
                ((abzq)this.fX.get()).a(((abhe)localObject2).a());
              }
            }
            for (;;)
            {
              i += 1;
              break label418;
              locala = (abzq.a.a)paramView.getTag();
              break;
              if (!TextUtils.isEmpty(localApolloGameData.tagUrl))
              {
                locala.r[i].setImageDrawable(abtn.a(String.valueOf(localApolloGameData.tagUrl.hashCode()), null, localApolloGameData.tagUrl, true));
                locala.r[i].setVisibility(0);
                VipUtils.a(abzq.a((abzq)this.fX.get()), "cmshow", "Apollo", "showtag", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId), String.valueOf(paramInt * 3 + i), String.valueOf(localApolloGameData.tagType) });
                break label618;
              }
              locala.r[i].setVisibility(8);
              break label618;
              locala.q[i].setCompoundDrawablePadding(0);
              locala.q[i].setCompoundDrawables(null, null, null, null);
              break label722;
              locala.a[i].setImageResource(2130838653);
              break label816;
              if ((locala.s[i].getTag() != null) && ((locala.s[i].getTag() instanceof RedTouch))) {
                ((RedTouch)locala.s[i].getTag()).dGB();
              }
              locala.s[i].setVisibility(4);
              break label1176;
              locala.e[i].setVisibility(4);
            }
            i = 0;
            while (i < 3)
            {
              locala.e[i].setVisibility(4);
              i += 1;
            }
            EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
            return paramView;
          }
        }
      }
    }
    
    public void iv(List<ApolloGameData> paramList)
    {
      this.wJ = paramList;
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      ApolloGameData localApolloGameData;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localApolloGameData = (ApolloGameData)paramView.getTag();
        if (localApolloGameData != null) {
          break;
        }
        QLog.e("GameListAdapter", 1, "[onClick] no game data");
      }
      abzq localabzq = (abzq)this.fX.get();
      Object localObject1;
      if (localabzq != null) {
        if (abzq.a(localabzq) != null) {
          if (paramView.getId() == 2131369383) {
            localObject1 = paramView.findViewById(2131369387);
          }
        }
      }
      for (;;)
      {
        label116:
        if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
        {
          ((View)localObject1).setVisibility(8);
          if ((((View)localObject1).getTag() != null) && ((((View)localObject1).getTag() instanceof RedTouch))) {
            ((RedTouch)((View)localObject1).getTag()).dGB();
          }
          VipUtils.a(abzq.a((abzq)this.fX.get()), "cmshow", "Apollo", "beyond_notice_disappear", 1, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
        }
        localObject1 = abzq.a(localabzq);
        label231:
        Object localObject2;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          Iterator localIterator = ((List)localObject1).iterator();
          localObject1 = null;
          if (localIterator.hasNext())
          {
            localObject2 = (ApolloGameRankData)localIterator.next();
            if ((localObject2 == null) || (((ApolloGameRankData)localObject2).mGameId != localApolloGameData.gameId)) {
              break label421;
            }
            localObject1 = localObject2;
          }
        }
        label421:
        for (;;)
        {
          for (;;)
          {
            break label231;
            if (paramView.getId() == 2131369389)
            {
              localObject1 = paramView.findViewById(2131369393);
              break label116;
            }
            if (paramView.getId() != 2131369395) {
              break label424;
            }
            localObject1 = paramView.findViewById(2131369399);
            break label116;
            localObject2 = abzq.a(localabzq);
            if (localObject1 != null) {}
            try
            {
              ((ApolloGameRankData)localObject1).mValidTime = (System.currentTimeMillis() - 1000L);
              ApolloGameUtil.a(abzq.a(localabzq), (ApolloGameRankData)localObject1);
              abzq.a(localabzq).remove(localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("GameListAdapter", 2, new Object[] { "[onClick] remove red corner for ", Integer.valueOf(localApolloGameData.gameId) });
              }
              abzq.c(localabzq, localApolloGameData);
              break;
            }
            finally {}
          }
          QLog.e("GameListAdapter", 1, "[onClick] binder null");
          break;
        }
        label424:
        localObject1 = null;
      }
    }
    
    public static final class a
    {
      View AU;
      URLImageView[] a = new URLImageView[3];
      ViewGroup[] e = new ViewGroup[3];
      TextView[] q = new TextView[3];
      ImageView[] r = new ImageView[3];
      ImageView[] s = new ImageView[3];
    }
  }
  
  public static class b
    extends abmi.a
  {
    public int bSO;
    private WeakReference<abzq> fY;
    
    public b(abzq paramabzq)
    {
      this.fY = new WeakReference(paramabzq);
    }
    
    public void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameViewBinder", 2, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong), ", gameId=", Integer.valueOf(paramInt1), ", resultStr=", paramString2 });
      }
      if (this.bSO != paramInt2)
      {
        QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] mCreateRoomReqCode != reqCode");
        return;
      }
      abzq localabzq = (abzq)this.fY.get();
      if (localabzq == null)
      {
        QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
        return;
      }
      if (abzq.a(localabzq) == null)
      {
        QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
        return;
      }
      ApolloGameData localApolloGameData = ((abxk)abzq.a(localabzq).getManager(155)).a(paramInt1);
      if (localApolloGameData == null)
      {
        QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
        return;
      }
      if (paramLong == 0L)
      {
        abmh.a(abzq.a(localabzq), paramString1, paramString2);
        return;
      }
      if (paramLong == -300404L)
      {
        abzq.a(localabzq).post(new ApolloGameViewBinder.ISessionHandler.1(this, localabzq, localApolloGameData));
        return;
      }
      if (paramLong == -300405L)
      {
        abzq.a(localabzq).post(new ApolloGameViewBinder.ISessionHandler.2(this, localabzq, localApolloGameData));
        return;
      }
      QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
      abzq.a(localabzq).post(new ApolloGameViewBinder.ISessionHandler.3(this, localabzq));
    }
    
    public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
    {
      abzq localabzq = (abzq)this.fY.get();
      if (localabzq == null) {
        break label17;
      }
      label17:
      while (abzq.a(localabzq) == null) {
        return;
      }
      if (this.bSO != paramInt2)
      {
        QLog.e("ApolloGameViewBinder", 1, "onCreateRoomId mCreateRoomReqCode != reqCode");
        return;
      }
      if (!paramBoolean)
      {
        QLog.e("ApolloGameViewBinder", 1, "onCreateRoomId createSuccess:false");
        return;
      }
      super.a(paramBoolean, paramInt1, paramLong, paramInt2);
      ApolloPanel.b localb = new ApolloPanel.b();
      Object localObject = (abxk)abzq.a(localabzq).getManager(155);
      String str = acfp.m(2131702489);
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
          if ((abzq.a(localabzq) == null) || (abzq.a(localabzq) == null)) {
            break;
          }
          abmh.a(abzq.a(localabzq), abzq.a(localabzq).aTl, localb);
          if (!abmk.gM(abzq.a(localabzq).aTl)) {
            break;
          }
          ((abhh)abzq.a(localabzq).getManager(153)).a().y(abzq.a(localabzq).aTl, paramInt1, paramLong);
          return;
          localb.gameName = acfp.m(2131702529);
          paramInt2 = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzq
 * JD-Core Version:    0.7.0.1
 */