import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.recent.RecentAdapter.3;
import com.tencent.mobileqq.activity.recent.RecentAdapter.4;
import com.tencent.mobileqq.activity.recent.RecentAdapter.7;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.a;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.c;
import com.tencent.widget.XListView;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONObject;

public class aajg
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener, aqdf.a, DragFrameLayout.a, DragFrameLayout.c, SwipListView.c
{
  private long LX;
  private aajb jdField_a_of_type_Aajb;
  private aajg.a jdField_a_of_type_Aajg$a;
  protected aakd a;
  protected DragFrameLayout a;
  public QQAppInterface app;
  protected pxv b;
  public int bKH = -1;
  private boolean bvU;
  private int chm;
  View.OnClickListener cp = new aajm(this);
  private long decodeFaceStartTime;
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  protected Context mContext;
  protected final List<Object> mDataList;
  private int mExtraFlag;
  protected aajx mFaceDecoder;
  protected XListView mListView;
  protected BubblePopupWindow mMenuPop;
  protected List<Object> vn;
  
  public aajg(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, aajb paramaajb, int paramInt)
  {
    this(paramContext, paramQQAppInterface, paramXListView, paramaajb, paramInt, false);
  }
  
  public aajg(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, aajb paramaajb, int paramInt, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mListView = paramXListView;
    this.jdField_a_of_type_Aajb = paramaajb;
    this.app = paramQQAppInterface;
    this.mDataList = new ArrayList(99);
    this.jdField_a_of_type_Aakd = new aakd(paramInt);
    this.jdField_a_of_type_Aakd.a(this);
    this.mFaceDecoder = new aajx(paramQQAppInterface, this, paramBoolean);
    this.b = new pxv(paramQQAppInterface);
    this.b.a(new aajh(this));
    if (paramInt == 0) {
      this.mExtraFlag = 0;
    }
    for (;;)
    {
      this.chm = paramInt;
      return;
      if (paramInt == 1) {
        this.mExtraFlag = 5;
      } else if (paramInt == 9) {
        this.mExtraFlag = 11;
      } else if (paramInt == 10) {
        this.mExtraFlag = 15;
      } else if (paramInt == 11) {
        this.mExtraFlag = 17;
      } else if (paramInt == 12) {
        this.mExtraFlag = 19;
      } else if (paramInt == 13) {
        this.mExtraFlag = 21;
      } else if (paramInt == 4) {
        this.mExtraFlag = 14;
      }
    }
  }
  
  private void FY(int paramInt)
  {
    if (4 == this.jdField_a_of_type_Aakd.yH())
    {
      if (paramInt == 1) {
        break label77;
      }
      if (!this.mDataList.contains(aakd.P)) {
        this.mDataList.add(aakd.P);
      }
      if (!this.mDataList.contains(aakd.R)) {
        this.mDataList.add(aakd.R);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      label77:
      if (!this.mDataList.contains(aakd.S)) {
        this.mDataList.add(aakd.S);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    boolean bool2 = false;
    if (aalb.b(paramRecentBaseData))
    {
      bool1 = true;
      return bool1;
    }
    if ((paramRecentBaseData instanceof RecentItemChatMsgData))
    {
      paramRecentBaseData = ((RecentItemChatMsgData)paramRecentBaseData).mUser;
      if ((paramRecentBaseData == null) || (paramRecentBaseData.getType() != 1008) || (!nyn.f(paramQQAppInterface, paramRecentBaseData.uin))) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      return bool1;
      bool1 = bool2;
      if (!(paramRecentBaseData instanceof RecentItemTroopMsgData)) {
        break;
      }
      paramRecentBaseData = paramQQAppInterface.a(true).a(((RecentItemTroopMsgData)paramRecentBaseData).mUser.uin);
      bool1 = bool2;
      if (paramRecentBaseData == null) {
        break;
      }
      paramQQAppInterface = ((ardq)paramQQAppInterface.getBusinessHandler(107)).a("");
      if (!paramRecentBaseData.isGameRoom)
      {
        bool1 = bool2;
        if (!paramRecentBaseData.troopUin.equals(paramQQAppInterface.cAg)) {
          break;
        }
      }
      return true;
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    int i = paramRecentBaseData.ng();
    if (i == 7220)
    {
      kxm.aHT();
      kbp.a(this.app, "CliOper", "", "", "0X80067CE", "0X80067CE", 0, 0, "", "", "", kxm.iQ(), false);
    }
    try
    {
      paramString1 = (KandianMergeManager)this.app.getManager(162);
      paramString1.aIG();
      paramString1.aIE();
      if (i == 8112) {
        if (!aqiw.isNetworkAvailable(this.mContext))
        {
          QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.d("Q.recent", 1, "clean kandian error" + paramString1);
      }
      paramString1 = paramRecentBaseData.qx();
      ((FriendListHandler)this.app.getBusinessHandler(1)).DK(paramString1);
      if (((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData)) && ((((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).mUser.extraInfo instanceof MayKnowRecommend)))
      {
        paramString1 = (MayKnowRecommend)((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).mUser.extraInfo;
        ContactReportUtils.a(this.app, paramString1.uin, "frd_list_dlt", 25, 0, paramString1.recommendReason, 0, paramString1.algBuffer, 2);
      }
      if (i == 8113)
      {
        if (!aqiw.isNetworkAvailable(this.mContext))
        {
          QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
        paramString1 = paramRecentBaseData.qx();
        ((achg)this.app.getManager(159)).Ef(paramString1);
      }
      b(paramRecentBaseData, paramString2);
      switch (i)
      {
      default: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString2, "", "");
        return;
      case 0: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString2, "");
        return;
      case 1: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString2, "");
        return;
      case 3000: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString2, "");
        return;
      case 1008: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString2, "");
        if ((paramRecentBaseData instanceof RecentItemEcShop)) {
          anot.a(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsghelper", "Clk_DelshopItem", 0, 0, paramRecentBaseData.qx(), "", paramRecentBaseData.mTitleName, "");
        }
        paramString1 = paramRecentBaseData.qx();
        anot.a(this.app, "dc00899", "Pb_account_lifeservice", paramString1, "0X80064C9", "0X80064C9", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
        anot.a(this.app, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.qx(), "", "", "");
        aakp.b(this.app, paramRecentBaseData.qx(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.wU(), 1, paramRecentBaseData.getTitleName());
        if (acbn.blN.equals(paramString1)) {
          kya.aId();
        }
        odv.pw(paramString1);
        return;
      case 5000: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString2, "");
        return;
      case 7000: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString2, "");
        return;
      case 4000: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString2, "");
        return;
      case 1022: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString2, "");
        return;
      case 6000: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString2, "");
        return;
      case 7200: 
        anot.a(this.app, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString2, "");
        return;
      case 1001: 
      case 10002: 
        anot.a(this.app, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
        if ((paramRecentBaseData instanceof RecentMsgBoxItem))
        {
          anot.a(this.app, "dc00899", "grp_lbs", ((RecentMsgBoxItem)paramRecentBaseData).hf(), "msg_box", "delete_msg", 0, 0, "", "", "", "");
          return;
        }
        anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_msg", 0, 0, "", "", "", "");
        return;
      case 1010: 
        anot.a(this.app, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
        return;
      }
    }
    anot.a(this.app, "CliOper", "", "", "0X8006353", "0X8006353", 0, 0, "", "", "", "");
    return;
    anot.a(this.app, "dc00899", "Pb_account_lifeservice", "0", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
    anot.a(this.app, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.qx(), "", "", "");
    return;
    anot.a(this.app, "dc00899", "Pb_account_lifeservice", "1", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
    anot.a(this.app, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.qx(), "", "", "");
    return;
    odv.bdI();
    aakp.b(this.app, paramRecentBaseData.qx(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.wU(), 1, paramRecentBaseData.getTitleName());
    return;
    anot.a(this.app, "dc00898", "", "", "0X80090EB", "0X80090EB", 0, 0, "", "", "", "");
    return;
    LpReportInfo_dc00518.report(100, 3, 0);
    if (QLog.isColorLevel()) {
      QLog.d("RecentAdapter", 2, "do report: QQnotice.list.delete");
    }
    anot.a(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.list.delete", 0, 0, "", "", "", "");
  }
  
  private void cuN()
  {
    if ((this.mDataList != null) && (this.mDataList.size() == 1) && (this.mDataList.get(0) != null)) {}
  }
  
  protected void Au(String paramString)
  {
    anot.a(null, "dc00899", "Grp_video", "", "notice", "call", 0, 0, paramString, "" + apuh.n(this.app, paramString), "", "");
  }
  
  public void Cq(boolean paramBoolean)
  {
    if (this.mFaceDecoder.d == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mFaceDecoder.d.edu();
      this.mFaceDecoder.d.pause();
      return;
    }
    if (this.mFaceDecoder.d.isPausing()) {
      this.mFaceDecoder.d.resume();
    }
    this.decodeFaceStartTime = System.currentTimeMillis();
    int j = this.mListView.getChildCount();
    int i = 0;
    label76:
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localRecentBaseData = a(this.mListView.getChildAt(i));
      if (localRecentBaseData != null) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label76;
      break;
      label107:
      if (!(localRecentBaseData instanceof RecentItemImaxADData)) {
        this.mFaceDecoder.a(localRecentBaseData.ng(), localRecentBaseData.qx(), false);
      }
    }
  }
  
  public void Cr(boolean paramBoolean)
  {
    this.bvU = paramBoolean;
  }
  
  public void FX(int paramInt)
  {
    this.mExtraFlag = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setExtraFlag:" + paramInt);
    }
  }
  
  public boolean QH()
  {
    return (this.mListView instanceof SwipListView);
  }
  
  public boolean Wy()
  {
    return (Wz()) || (this.mDataList.size() == 0);
  }
  
  protected boolean Wz()
  {
    return (this.mExtraFlag == 3) || (this.mExtraFlag == 8);
  }
  
  public aajx a()
  {
    return this.mFaceDecoder;
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public void a(aajg.a parama)
  {
    this.jdField_a_of_type_Aajg$a = parama;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    a(paramView, paramRecentBaseData, null);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramRecentBaseData.ng();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).WD())) {
        break label85;
      }
      i = 3002;
    }
    label85:
    for (;;)
    {
      localDrawable = this.mFaceDecoder.a(i, paramRecentBaseData.qx());
      paramDrawable = this.jdField_a_of_type_Aakd.a(paramRecentBaseData);
      if (paramDrawable == null) {
        break;
      }
      paramDrawable.a(paramView, paramRecentBaseData, this.mContext, localDrawable);
      return;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null)) {}
    Drawable localDrawable;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "updateSayHelloBoxItem|uin:" + paramMessageRecord.senderuin);
      }
      localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = this.mFaceDecoder.a(paramMessageRecord.istroop, paramMessageRecord.senderuin);
      }
      paramDrawable = this.jdField_a_of_type_Aakd.a(paramRecentBaseData);
    } while ((paramDrawable == null) || (!(paramDrawable instanceof aalc)));
    ((aalc)paramDrawable).b(paramView, paramRecentBaseData, paramMessageRecord, localDrawable);
  }
  
  protected void a(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    Resources localResources = this.mContext.getResources();
    if (aqft.equalsWithNullCheck(paramString1, localResources.getString(aakb.fy[0])))
    {
      paramRecentBaseData.ng();
      b(paramRecentBaseData, paramString1, paramString2);
      anot.a(this.app, "dc00898", "", "", "0X800A360", "0X800A360", 0, 0, "1", "", paramString2, "");
    }
    while (this.jdField_a_of_type_Aajb == null) {
      return;
    }
    this.jdField_a_of_type_Aajb.a(paramString1, paramRecentBaseData, paramString2);
    odv.a(paramRecentBaseData.ng(), paramRecentBaseData.qx(), paramString1, localResources);
  }
  
  public void a(RecentUser paramRecentUser, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    Object localObject2 = this.app.b().a(paramRecentUser.uin, 1008);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((MessageRecord)localObject2).getExtInfoFromExtStr("gdt_msgClick");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "0";
        localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("pa_msgId");
        paramStringBuilder1.append((String)localObject2 + ",");
      }
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      paramStringBuilder1 = str;
      if (((JSONObject)localObject1).has("ad_id")) {
        paramStringBuilder1 = ((JSONObject)localObject1).getString("ad_id");
      }
    }
    catch (Exception paramStringBuilder1)
    {
      for (;;)
      {
        paramStringBuilder1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.recent", 2, " parse ad_id error");
          paramStringBuilder1 = str;
        }
      }
    }
    paramStringBuilder2.append(paramStringBuilder1 + ",");
    paramStringBuilder3.append(paramRecentUser.uin + ",");
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    int i;
    Object localObject1;
    Object localObject2;
    MessageHandler localMessageHandler;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    if (paramBoolean)
    {
      if (this.chm == 0) {
        i = 1;
      }
      for (;;)
      {
        if (paramInt == 2)
        {
          if (i != 0)
          {
            paramDragFrameLayout = this.mDataList.iterator();
            for (;;)
            {
              if (paramDragFrameLayout.hasNext())
              {
                localObject1 = paramDragFrameLayout.next();
                if (((localObject1 instanceof RecentBaseData)) && ((localObject1 instanceof RecentUserBaseData)))
                {
                  localObject1 = (RecentUserBaseData)localObject1;
                  if (((RecentUserBaseData)localObject1).mUnreadNum > 0)
                  {
                    localObject2 = ((RecentUserBaseData)localObject1).a();
                    aakz.a(this.app, (RecentBaseData)localObject1, (RecentUser)localObject2, true);
                    continue;
                    i = 0;
                    break;
                  }
                }
              }
            }
          }
          paramDragFrameLayout = (kdm)this.app.getManager(88);
          if ((paramDragFrameLayout != null) && (paramDragFrameLayout.aeq))
          {
            paramDragFrameLayout.aeq = false;
            localObject1 = this.app.getCurrentAccountUin();
            paramDragFrameLayout = (DragFrameLayout)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramDragFrameLayout = "noLogin";
            }
            this.app.getApp().getSharedPreferences("ecshop_sp" + paramDragFrameLayout, 0).edit().putBoolean("folder_reddot", false).commit();
          }
          localMessageHandler = (MessageHandler)this.app.getBusinessHandler(0);
          if (localMessageHandler != null) {
            localMessageHandler.Fi(false);
          }
          paramDragFrameLayout = null;
          localObject1 = null;
          localObject2 = null;
          Iterator localIterator = this.mDataList.iterator();
          if (localIterator.hasNext())
          {
            localObject5 = localIterator.next();
            if ((!(localObject5 instanceof RecentBaseData)) || (!(localObject5 instanceof RecentUserBaseData))) {
              break label2467;
            }
            localObject3 = (RecentUserBaseData)localObject5;
            if (((RecentUserBaseData)localObject3).mUnreadNum <= 0) {
              break label2467;
            }
            localObject4 = ((RecentUserBaseData)localObject3).a();
            ((RecentUserBaseData)localObject3).cuR();
            ausb.a(this.app).ZA(((RecentUserBaseData)localObject3).qx());
            if (((RecentUser)localObject4).getType() != 1008) {
              break label2454;
            }
            if (paramDragFrameLayout != null) {
              break label2441;
            }
            localObject1 = new StringBuilder();
            paramDragFrameLayout = new StringBuilder();
            localObject2 = new StringBuilder();
            label375:
            a((RecentUser)localObject4, (StringBuilder)localObject1, paramDragFrameLayout, (StringBuilder)localObject2);
            label386:
            if ((localObject5 instanceof RecentItemTroopMsgData))
            {
              paramInt = this.app.cs(((RecentUser)localObject4).uin);
              if ((paramInt == 2) || (paramInt == 4))
              {
                aalb.a(this.app, (RecentUser)localObject4, true, false);
                localObject5 = localObject2;
                localObject4 = localObject1;
                localObject3 = paramDragFrameLayout;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject3;
      paramDragFrameLayout = (DragFrameLayout)localObject4;
      localObject2 = localObject5;
      break;
      localObject3 = this.app;
      if (localMessageHandler == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        aalb.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
        localObject3 = paramDragFrameLayout;
        localObject4 = localObject1;
        localObject5 = localObject2;
        break;
      }
      if ((localObject5 instanceof RecentItemTroopBarAssitant))
      {
        oan.a().av(this.app);
        oac.d(this.app, false);
        localObject3 = this.app;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          aalb.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
      }
      if ((localObject5 instanceof RecentItemServiceAccountFolderData))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByTabRed");
        }
        localObject3 = this.app;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          aalb.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          nyn.a().e(this.app, NetConnInfoCenter.getServerTime());
          if (obt.aee) {
            nyn.a().ag(this.app);
          }
          Manager localManager = this.app.getManager(36);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          if (!(localManager instanceof altq)) {
            break;
          }
          ((altq)localManager).dx(104000, "104000.104001");
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
      }
      if ((localObject5 instanceof SendBlessRecentItemData))
      {
        ThreadManager.post(new RecentAdapter.3(this), 5, null, true);
        localObject3 = paramDragFrameLayout;
        localObject4 = localObject1;
        localObject5 = localObject2;
      }
      else
      {
        localObject3 = this.app;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          aalb.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
        if (!this.app.bJb)
        {
          localObject3 = (alkm)this.app.getManager(38);
          if (localObject3 != null) {
            ((alkm)localObject3).kH(anaz.gQ());
          }
        }
        if (this.chm == 0)
        {
          anot.a(this.app, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
          anot.a(this.app, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
          if (!TextUtils.isEmpty(paramDragFrameLayout)) {
            anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", String.valueOf(localObject2), "0X8005C37", "0X8005C37", 0, 1, 0, String.valueOf(paramDragFrameLayout), String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", String.valueOf(localObject1));
          }
        }
        lcm.a().aKb();
        label1225:
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        int j;
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              paramDragFrameLayout = paramDragFrameLayout.bI();
                            } while (paramDragFrameLayout == null);
                            paramDragFrameLayout = (Integer)paramDragFrameLayout.getTag();
                          } while (paramDragFrameLayout == null);
                          j = paramDragFrameLayout.intValue();
                          paramDragFrameLayout = getItem(j);
                          if (QLog.isColorLevel()) {
                            QLog.d("Drag", 2, "onChange:" + paramDragFrameLayout);
                          }
                        } while (!(paramDragFrameLayout instanceof RecentBaseData));
                        localObject1 = (RecentBaseData)paramDragFrameLayout;
                        if ((i != 0) && ((paramDragFrameLayout instanceof RecentUserBaseData)))
                        {
                          localObject2 = ((RecentUserBaseData)paramDragFrameLayout).a();
                          aakz.a(this.app, (RecentBaseData)localObject1, (RecentUser)localObject2, false);
                        }
                        if ((paramDragFrameLayout instanceof RecentItemTroopBarAssitant))
                        {
                          paramDragFrameLayout = (RecentItemTroopBarAssitant)paramDragFrameLayout;
                          paramDragFrameLayout.cuR();
                          oan.a().av(this.app);
                          this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
                          return;
                        }
                        if ((paramDragFrameLayout instanceof RecentItemServiceAccountFolderData))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByFolderRed, red dot switch:" + obt.adS);
                          }
                          paramDragFrameLayout = (RecentItemServiceAccountFolderData)paramDragFrameLayout;
                          i = paramDragFrameLayout.mUnreadNum;
                          if (!obt.adS)
                          {
                            paramDragFrameLayout.cuR();
                            nyn.a().e(this.app, NetConnInfoCenter.getServerTime());
                            if (obt.aee) {
                              nyn.a().ag(this.app);
                            }
                            this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
                            this.app.ba(true, 0);
                          }
                          if (obt.adS)
                          {
                            paramInt = 1;
                            if (!paramDragFrameLayout.Gq()) {
                              break label1297;
                            }
                          }
                          for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
                          {
                            ThreadManager.executeOnSubThread(new RecentAdapter.4(this, paramInt, paramDragFrameLayout, String.valueOf(i), String.valueOf(j + 1)));
                            paramDragFrameLayout = this.app.getManager(36);
                            if (!(paramDragFrameLayout instanceof altq)) {
                              break;
                            }
                            ((altq)paramDragFrameLayout).dx(104000, "104000.104001");
                            return;
                            paramInt = 0;
                            break label1225;
                          }
                        }
                        if (!(paramDragFrameLayout instanceof RecentItemEcShopAssitant)) {
                          break;
                        }
                        paramDragFrameLayout = (RecentItemEcShopAssitant)paramDragFrameLayout;
                        paramDragFrameLayout.cuR();
                        aalb.l(this.app, paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
                        this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
                        paramDragFrameLayout = this.app.b().a(paramDragFrameLayout.qx(), 1008);
                      } while (paramDragFrameLayout == null);
                      localObject1 = (kdm)this.app.getManager(88);
                    } while (localObject1 == null);
                    ((kdm)localObject1).eh(paramDragFrameLayout.time);
                    return;
                    if ((paramDragFrameLayout instanceof RecentUserBaseData))
                    {
                      localObject1 = (RecentUserBaseData)paramDragFrameLayout;
                      localObject2 = ((RecentUserBaseData)localObject1).a();
                      if (((RecentUser)localObject2).getType() == 1008) {
                        anot.a(this.app, "dc00899", "Pb_account_lifeservice", "" + ((RecentUser)localObject2).uin, "0X80064CA", "0X80064CA", 0, 0, "" + ((RecentUserBaseData)localObject1).mUnreadNum, "", "", "");
                      }
                      for (;;)
                      {
                        ((RecentUserBaseData)localObject1).cuR();
                        ausb.a(this.app).ZA(((RecentUserBaseData)localObject1).qx());
                        aalb.a(this.app, (RecentUser)localObject2, true, false);
                        if (this.chm == 0) {
                          aalb.b(this.app, (RecentUser)localObject2);
                        }
                        if ((paramDragFrameLayout instanceof SendBlessRecentItemData)) {
                          ((ylm)this.app.getManager(138)).setRead(true);
                        }
                        if ((((RecentUser)localObject2).getType() != 0) || (!aqft.rj(((RecentUser)localObject2).uin))) {
                          break;
                        }
                        paramDragFrameLayout = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
                        if (paramDragFrameLayout.getBoolean("babyQ_toast_flag", false)) {
                          break;
                        }
                        i = paramDragFrameLayout.getInt("babyQ_drag_count", 0) + 1;
                        paramInt = i;
                        if (i >= 3)
                        {
                          aqha.a(this.mContext, 230, "babyQ提醒", "是否需要关闭babyQ的推送开关\n", acfp.m(2131713658), acfp.m(2131713657), new aajk(this), new aajl(this)).show();
                          paramInt = 0;
                          paramDragFrameLayout.edit().putBoolean("babyQ_toast_flag", true);
                        }
                        paramDragFrameLayout.edit().putInt("babyQ_drag_count", paramInt).commit();
                        return;
                        if (((RecentUser)localObject2).getType() == 6004) {
                          anot.a(this.app, "dc00898", "", "", "0X80090EA", "0X80090EA", 0, 0, "", "", "", "");
                        }
                      }
                    }
                    if (!(paramDragFrameLayout instanceof RecentTroopAssistantItem)) {
                      break;
                    }
                    paramDragFrameLayout = (RecentTroopAssistantItem)paramDragFrameLayout;
                    paramDragFrameLayout.cuR();
                    aalb.l(this.app, paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
                    this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
                    paramDragFrameLayout = this.app.b().a(paramDragFrameLayout.qx(), 1);
                  } while (paramDragFrameLayout == null);
                  aizp.a().f(this.app, paramDragFrameLayout.time);
                  return;
                  if (!(paramDragFrameLayout instanceof RecentItemEcShop)) {
                    break;
                  }
                  paramDragFrameLayout = (RecentItemEcShop)paramDragFrameLayout;
                  anot.a(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.qx(), "0X80064D3", "0X80064D3", 0, 0, "" + paramDragFrameLayout.mUnreadNum, "", "", "");
                  paramDragFrameLayout.cuR();
                  aalb.l(this.app, paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
                  this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
                  paramDragFrameLayout = this.app.b().a(paramDragFrameLayout.qx(), 1008);
                } while (paramDragFrameLayout == null);
                localObject1 = (kdm)this.app.getManager(88);
              } while (localObject1 == null);
              ((kdm)localObject1).eh(paramDragFrameLayout.time);
              return;
              if (!(paramDragFrameLayout instanceof RecentMsgBoxItem)) {
                break;
              }
              paramDragFrameLayout = (RecentMsgBoxItem)paramDragFrameLayout;
              paramDragFrameLayout.cuR();
              if (top.gR(paramDragFrameLayout.qx()))
              {
                ThreadManager.post(new RecentAdapter.7(this, paramDragFrameLayout.qx(), paramDragFrameLayout.ng()), 8, null, false);
                anot.a(this.app, "CliOper", "", "", "0X8005298", "0X8005298", 0, 0, "", "", "", "");
                anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "drag_hi", 0, 0, "", "", "", "");
                return;
              }
              aalb.l(this.app, paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
              this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
              if (top.gU(paramDragFrameLayout.qx()))
              {
                anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "drag_update", 0, 0, "", "", String.valueOf(paramDragFrameLayout.mFromFlag), "");
                return;
              }
            } while (!top.ap(paramDragFrameLayout.qx()));
            anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "drag_focus", 0, 0, "", "", "", "");
            return;
            if ((paramDragFrameLayout instanceof RecentSayHelloListItem))
            {
              paramDragFrameLayout = (RecentSayHelloListItem)paramDragFrameLayout;
              paramDragFrameLayout.cuR();
              aalb.l(this.app, paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
              this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
              return;
            }
            if (!(paramDragFrameLayout instanceof RecentHotchatItem)) {
              break;
            }
            paramDragFrameLayout = (RecentHotchatItem)paramDragFrameLayout;
            paramDragFrameLayout.cuR();
            aalb.l(this.app, paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
            this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
            paramDragFrameLayout = this.app.b().a(paramDragFrameLayout.qx(), 1);
          } while (paramDragFrameLayout == null);
          ((acfs)this.app.getManager(255)).eh(paramDragFrameLayout.time);
          return;
          if ((paramDragFrameLayout instanceof RecentItemConfessMsg))
          {
            aegu.a(this.app, (RecentItemConfessMsg)paramDragFrameLayout, false);
            return;
          }
        } while (!(paramDragFrameLayout instanceof RecentMatchChatListItem));
        label1297:
        paramDragFrameLayout = (RecentMatchChatListItem)paramDragFrameLayout;
        this.app.b().ca(paramDragFrameLayout.qx(), paramDragFrameLayout.ng());
        return;
        label2441:
        localObject3 = paramDragFrameLayout;
        paramDragFrameLayout = (DragFrameLayout)localObject1;
        localObject1 = localObject3;
        break label375;
        label2454:
        localObject3 = paramDragFrameLayout;
        paramDragFrameLayout = (DragFrameLayout)localObject1;
        localObject1 = localObject3;
        break label386;
        label2467:
        localObject3 = localObject1;
        localObject4 = paramDragFrameLayout;
        localObject5 = localObject2;
      }
    }
  }
  
  public void al(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.EO(paramBoolean);
      return;
    }
  }
  
  public void b(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.jdField_a_of_type_Aajb != null) {
      this.jdField_a_of_type_Aajb.a(paramRecentBaseData, paramString);
    }
    if (this.mDataList != null)
    {
      this.mDataList.remove(paramRecentBaseData);
      cuN();
      notifyDataSetChanged();
    }
  }
  
  public void bH(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Aakd != null) {
      this.jdField_a_of_type_Aakd.bH(paramQQAppInterface);
    }
  }
  
  public void bp(String paramString, boolean paramBoolean)
  {
    if ((this.mListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.mListView.getChildCount();
    int i = 1;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.mListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (aqft.equalsWithNullCheck(paramString, localRecentBaseData.qx()))) {
        break label74;
      }
    }
    label74:
    int k;
    do
    {
      i += 1;
      break label26;
      break;
      k = localRecentBaseData.ng();
      if ((paramBoolean) && (k == 1))
      {
        a(localView, localRecentBaseData);
        return;
      }
    } while ((paramBoolean) || ((k != 0) && (k != 1000) && (k != 1020) && (k != 1003) && (k != 1025) && (k != 1005) && (k != 1004) && (k != 1008) && (k != 1001) && (k != 10002) && (k != 10004) && (k != 1009) && (k != 1023) && (k != 1024) && (k != 7000) && (k != 1010) && (k != 7220) && (k != 10008)));
    a(localView, localRecentBaseData);
  }
  
  public void c(RecentBaseData paramRecentBaseData)
  {
    if ((this.mListView == null) || (paramRecentBaseData == null)) {
      return;
    }
    int j = this.mListView.getChildCount();
    int i = 0;
    label22:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.mListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {
        break label57;
      }
    }
    label57:
    while (!localRecentBaseData.equals(paramRecentBaseData))
    {
      i += 1;
      break label22;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void cS(List<RecentBaseData> paramList)
  {
    Object localObject2 = null;
    if (this.app == null) {
      return;
    }
    hi();
    int i;
    Object localObject3;
    Object localObject1;
    label231:
    int j;
    if (paramList != null)
    {
      i = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "setDataList size = " + i);
      }
      if (i == 0) {
        QLog.i("Q.recent", 2, "setDataList size = " + i, new Exception("setDataListEmpty"));
      }
      if ((this.mListView instanceof SwipListView))
      {
        localObject3 = (SwipListView)this.mListView;
        localObject1 = localObject2;
        if (this.bKH >= 0)
        {
          localObject1 = localObject2;
          if (this.bKH < this.mDataList.size()) {
            localObject1 = this.mDataList.get(this.bKH);
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDataList findsel, [" + this.bKH + "," + localObject1 + "]");
        }
        this.bKH = -1;
        localObject2 = localObject1;
        localObject1 = localObject3;
        this.mDataList.clear();
        j = this.jdField_a_of_type_Aakd.yH();
        if ((4 == j) && (paramList != null) && (paramList.size() > 0)) {
          this.mDataList.add(aakd.R);
        }
        if (paramList == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = paramList.iterator();
        i = -1;
        if (((Iterator)localObject3).hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject3).next();
          if (localRecentBaseData != null)
          {
            i += 1;
            if ((localRecentBaseData instanceof RecentItemChatMsgData)) {
              localRecentBaseData.mPosition = i;
            }
            if (!a(this.app, localRecentBaseData)) {
              if ((localRecentBaseData instanceof RecentItemChatMsgData))
              {
                RecentUser localRecentUser = ((RecentItemChatMsgData)localRecentBaseData).mUser;
                if ((localRecentUser != null) && (localRecentUser.getType() == 1008) && (nyn.f(this.app, localRecentUser.uin))) {}
              }
              else
              {
                this.mDataList.add(localRecentBaseData);
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("Q.recent", 2, "setDataList, [item is null]");
          }
        }
      }
      catch (Exception localException) {}
      boolean bool;
      if (localObject1 != null)
      {
        if (this.mDataList.size() == 0)
        {
          bool = false;
          localObject1.setDragEnable(bool);
        }
      }
      else
      {
        if ((localObject2 instanceof RecentBaseData))
        {
          localObject2 = (RecentBaseData)localObject2;
          i = Math.max(localObject1.getFirstVisiblePosition(), 0);
          int k = Math.min(localObject1.getLastVisiblePosition() + 1, this.mDataList.size());
          label514:
          if (i < k)
          {
            if (!((RecentBaseData)localObject2).equals(this.mDataList.get(i))) {
              break label643;
            }
            this.bKH = i;
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "setDataList getsel, [" + i + "," + this.mDataList.get(i) + "]");
            }
          }
        }
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label650;
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (this.bKH == -1)) {
          localObject1.AP();
        }
        notifyDataSetChanged();
        return;
        bool = true;
        break;
        label643:
        i += 1;
        break label514;
        label650:
        if (4 == j) {
          this.mDataList.add(aakd.Q);
        }
      }
      localObject2 = null;
      localObject1 = null;
      break label231;
      i = 0;
      break;
    }
  }
  
  public void cW(String paramString, int paramInt)
  {
    if ((this.mListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.mListView.getChildCount();
    int i = 0;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.mListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (localRecentBaseData.ng() == paramInt)) {
        break label71;
      }
    }
    label71:
    while (!aqft.equalsWithNullCheck(localRecentBaseData.qx(), paramString))
    {
      i += 1;
      break label26;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void cuM()
  {
    try
    {
      atdc localatdc = (atdc)this.app.getManager(746);
      if (localatdc != null)
      {
        FY(localatdc.Og());
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("RecentAdapter", 2, "refreshHeaderView|PstnManager is null..");
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("RecentAdapter", 2, "refreshHeaderView|NUllPointerException." + localNullPointerException.getMessage());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentAdapter", 2, "refreshHeaderView|Exception." + localException.getMessage());
      }
    }
  }
  
  public void cuO()
  {
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.cuT();
    }
  }
  
  public void d(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.bKH = i;
      return;
    }
  }
  
  public void d(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramRecentBaseData.ng() == 8) && (paramRecentBaseData.mExtraType == 25))
    {
      localObject = (ajdo)this.app.getManager(11);
      if ((localObject == null) || (paramRecentBaseData.mPhoneNumber == null)) {
        break label104;
      }
    }
    label104:
    for (Object localObject = ((ajdo)localObject).c(paramRecentBaseData.mPhoneNumber);; localObject = null)
    {
      if (localObject != null) {
        paramRecentBaseData.mTitleName = ((PhoneContact)localObject).name;
      }
      do
      {
        return;
        localObject = ((alkf)this.app.getManager(140)).a(paramRecentBaseData.qx());
      } while (localObject == null);
      paramRecentBaseData.mTitleName = ((QCallCardInfo)localObject).nickname;
      return;
    }
  }
  
  public List<View> du()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131381288);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.yK() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public List<Object> dv()
  {
    if (this.mDataList != null) {
      return new ArrayList(this.mDataList);
    }
    return null;
  }
  
  public int getCount()
  {
    if ((Wz()) || (this.mDataList.size() == 0)) {
      return 1;
    }
    return this.mDataList.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      if ((Wz()) || (this.mDataList.size() == 0)) {
        return Integer.valueOf(this.mExtraFlag);
      }
      if ((paramInt >= 0) && (paramInt < this.mDataList.size()))
      {
        Object localObject = this.mDataList.get(paramInt);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    return this.jdField_a_of_type_Aakd.h(localObject);
  }
  
  public int getStyle()
  {
    return this.chm;
  }
  
  /* Error */
  public View getView(int paramInt, View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokevirtual 576	aajg:getItem	(I)Ljava/lang/Object;
    //   5: astore 5
    //   7: aload_0
    //   8: getfield 96	aajg:jdField_a_of_type_Aakd	Laakd;
    //   11: aload 5
    //   13: invokevirtual 597	aakd:a	(Ljava/lang/Object;)Laakb;
    //   16: astore 4
    //   18: aload 5
    //   20: instanceof 223
    //   23: ifeq +54 -> 77
    //   26: aload 5
    //   28: checkcast 223	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   31: astore 5
    //   33: aload_0
    //   34: aload 5
    //   36: invokevirtual 1239	aajg:d	(Lcom/tencent/mobileqq/activity/recent/RecentBaseData;)V
    //   39: aload 4
    //   41: iload_1
    //   42: aload 5
    //   44: aload_0
    //   45: getfield 105	aajg:mFaceDecoder	Laajx;
    //   48: aload_2
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 78	aajg:mContext	Landroid/content/Context;
    //   54: aload_0
    //   55: aload_0
    //   56: aload_0
    //   57: invokevirtual 1242	aakb:a	(ILjava/lang/Object;Laajx;Landroid/view/View;Landroid/view/ViewGroup;Landroid/content/Context;Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$c;)Landroid/view/View;
    //   60: astore_2
    //   61: invokestatic 1248	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   64: iload_1
    //   65: aload_2
    //   66: aload_3
    //   67: aload_0
    //   68: iload_1
    //   69: invokevirtual 1250	aajg:getItemId	(I)J
    //   72: invokevirtual 1254	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   75: aload_2
    //   76: areturn
    //   77: aload 5
    //   79: instanceof 570
    //   82: ifeq +25 -> 107
    //   85: aload 4
    //   87: iload_1
    //   88: aload 5
    //   90: aconst_null
    //   91: aload_2
    //   92: aload_3
    //   93: aload_0
    //   94: getfield 78	aajg:mContext	Landroid/content/Context;
    //   97: aload_0
    //   98: aload_0
    //   99: aload_0
    //   100: invokevirtual 1242	aakb:a	(ILjava/lang/Object;Laajx;Landroid/view/View;Landroid/view/ViewGroup;Landroid/content/Context;Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$c;)Landroid/view/View;
    //   103: astore_2
    //   104: goto -43 -> 61
    //   107: aload 5
    //   109: instanceof 215
    //   112: ifeq +25 -> 137
    //   115: aload 4
    //   117: iload_1
    //   118: aload 5
    //   120: aconst_null
    //   121: aload_2
    //   122: aload_3
    //   123: aload_0
    //   124: getfield 78	aajg:mContext	Landroid/content/Context;
    //   127: aconst_null
    //   128: aconst_null
    //   129: aconst_null
    //   130: invokevirtual 1242	aakb:a	(ILjava/lang/Object;Laajx;Landroid/view/View;Landroid/view/ViewGroup;Landroid/content/Context;Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$c;)Landroid/view/View;
    //   133: astore_2
    //   134: goto -73 -> 61
    //   137: aload 5
    //   139: instanceof 1256
    //   142: ifeq +25 -> 167
    //   145: aload 4
    //   147: iload_1
    //   148: aload 5
    //   150: aconst_null
    //   151: aload_2
    //   152: aload_3
    //   153: aload_0
    //   154: getfield 78	aajg:mContext	Landroid/content/Context;
    //   157: aload_0
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual 1242	aakb:a	(ILjava/lang/Object;Laajx;Landroid/view/View;Landroid/view/ViewGroup;Landroid/content/Context;Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$c;)Landroid/view/View;
    //   163: astore_2
    //   164: goto -103 -> 61
    //   167: aload 4
    //   169: iload_1
    //   170: aload 5
    //   172: aconst_null
    //   173: aload_2
    //   174: aload_3
    //   175: aload_0
    //   176: getfield 78	aajg:mContext	Landroid/content/Context;
    //   179: aconst_null
    //   180: aconst_null
    //   181: aconst_null
    //   182: invokevirtual 1242	aakb:a	(ILjava/lang/Object;Laajx;Landroid/view/View;Landroid/view/ViewGroup;Landroid/content/Context;Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$c;)Landroid/view/View;
    //   185: astore_2
    //   186: goto -125 -> 61
    //   189: astore_2
    //   190: aload_0
    //   191: getfield 84	aajg:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   194: invokevirtual 723	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   197: iconst_0
    //   198: aload_2
    //   199: invokestatic 1261	aako:a	(Landroid/content/Context;ZLjava/lang/Throwable;)V
    //   202: new 1263	java/lang/RuntimeException
    //   205: dup
    //   206: aload_2
    //   207: invokespecial 1266	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	aajg
    //   0	211	1	paramInt	int
    //   0	211	2	paramView	View
    //   0	211	3	paramViewGroup	android.view.ViewGroup
    //   16	152	4	localaakb	aakb
    //   5	166	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	61	189	java/lang/Throwable
    //   77	104	189	java/lang/Throwable
    //   107	134	189	java/lang/Throwable
    //   137	164	189	java/lang/Throwable
    //   167	186	189	java/lang/Throwable
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_Aakd.getViewTypeCount();
  }
  
  public void hi()
  {
    if (this.mMenuPop != null)
    {
      this.mMenuPop.dismiss();
      this.mMenuPop = null;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    aajg.a locala = this.jdField_a_of_type_Aajg$a;
    if (locala == null) {
      return;
    }
    if ((this.mDataList == null) || (this.mDataList.size() == 0) || (!(this.mDataList.get(0) instanceof RecentUserBaseData)))
    {
      locala.bMl();
      return;
    }
    RecentUser localRecentUser = ((RecentUserBaseData)this.mDataList.get(0)).a();
    if ((localRecentUser != null) && (localRecentUser.showUpTime > 0L))
    {
      locala.bMk();
      return;
    }
    locala.bMl();
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.mFaceDecoder.onAccountChanged(paramQQAppInterface);
    if (this.app != paramQQAppInterface)
    {
      this.app = paramQQAppInterface;
      this.vn = null;
    }
    if (this.b != null) {
      this.b.destroy();
    }
    if (this.jdField_a_of_type_Aakd != null) {
      this.jdField_a_of_type_Aakd.onAccountChanged(paramQQAppInterface);
    }
    this.b = new pxv(paramQQAppInterface);
    this.b.a(new aaji(this));
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "onAccountChanged: invoked. Message: app: " + paramQQAppInterface + " recreate mRecentTabHaloPresenter: " + this.b);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject3;
      int i;
      Object localObject2;
      if (aqft.equalsWithNullCheck("tag_swip_icon_menu_item", paramView.getTag()))
      {
        Object localObject1 = paramView.getTag(-1);
        localObject3 = paramView.getTag(-2);
        if ((!(localObject1 instanceof Integer)) || (!(localObject3 instanceof Integer)))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
          }
        }
        else
        {
          i = ((Integer)localObject1).intValue();
          int j = ((Integer)localObject3).intValue();
          try
          {
            localObject1 = this.mContext.getResources().getString(j);
            localObject3 = getItem(i);
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "onClick|obj = " + localObject3 + ", " + (String)localObject1);
            }
            if ((localObject1 == null) || (!(localObject3 instanceof RecentBaseData))) {
              continue;
            }
            a((RecentBaseData)localObject3, (String)localObject1, "2");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, localException.toString());
              }
              localObject2 = null;
            }
          }
        }
      }
      else if (aqft.equalsWithNullCheck("tag_recent_item_icon", paramView.getTag()))
      {
        localObject2 = paramView.getTag(-22);
        if ((this.jdField_a_of_type_Aajb != null) && (localObject2 != null)) {
          this.jdField_a_of_type_Aajb.onClick(paramView, localObject2);
        }
      }
      else
      {
        localObject2 = (pmj)this.app.getManager(197);
        if (this.jdField_a_of_type_Aajb != null)
        {
          localObject3 = paramView.getTag(-22);
          if (((pmj)localObject2).s(localObject3)) {
            this.jdField_a_of_type_Aajb.onClick(paramView, localObject3);
          }
          localObject2 = paramView.getTag(-1);
          if (!(localObject2 instanceof Integer))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
            }
          }
          else
          {
            i = ((Integer)localObject2).intValue();
            localObject2 = getItem(i);
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "onClick|obj = " + localObject2);
            }
            if ((localObject2 instanceof RecentBaseData))
            {
              if (((paramView instanceof autv)) && ((localObject2 instanceof RecentItemEcShop))) {
                this.jdField_a_of_type_Aajb.onClick(paramView, localObject2);
              }
              for (;;)
              {
                if (!(localObject2 instanceof RecentItemTroopMsgData)) {
                  break label523;
                }
                localObject2 = (RecentItemTroopMsgData)localObject2;
                if ((localObject2 == null) || (!((RecentItemTroopMsgData)localObject2).mIsGroupVideoNotify)) {
                  break;
                }
                Au(((RecentItemTroopMsgData)localObject2).qx());
                break;
                localObject3 = (RecentBaseData)localObject2;
                ((RecentBaseData)localObject3).mPosition = i;
                this.jdField_a_of_type_Aajb.a(paramView, (RecentBaseData)localObject3, ((RecentBaseData)localObject3).mTitleName, true);
              }
              label523:
              if ((localObject2 instanceof RecentTroopAssistantItem))
              {
                localObject2 = (RecentTroopAssistantItem)localObject2;
                if ((localObject2 != null) && (((RecentTroopAssistantItem)localObject2).mIsGroupVideoNotify)) {
                  Au(((RecentTroopAssistantItem)localObject2).qx());
                }
              }
            }
            else
            {
              this.jdField_a_of_type_Aajb.onClick(paramView, localObject2);
            }
          }
        }
        else if (QLog.isDevelopLevel())
        {
          QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.mListView == null) || (TextUtils.isEmpty(paramString))) {}
    long l;
    boolean bool1;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.faceCache.put(paramInt2 + ":" + paramString, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.decodeFaceStartTime > 0L) && (l - this.decodeFaceStartTime > 300L))
          {
            bool1 = true;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder().append("RecentAdapter.onDecodeTaskCompleted type=").append(paramInt2).append(", uin=").append(paramString).append(", remainingTasks=").append(paramInt1).append(", isdecodeFaceTimeout=").append(bool1).append(", avatar == null ? | ");
              if (paramBitmap != null) {
                break label282;
              }
              bool2 = true;
              QLog.d("RecentAdapter", 2, bool2 + ",style | " + this.chm);
            }
            if ((paramInt1 > 0) && (!bool1)) {
              continue;
            }
            synchronized (this.faceCache)
            {
              if (this.faceCache.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            System.gc();
            localOutOfMemoryError.printStackTrace();
            QLog.i("RecentAdapter", 1, "onDecodeTaskCompleted error:" + localOutOfMemoryError.getMessage());
            continue;
            bool1 = false;
            continue;
            label282:
            boolean bool2 = false;
          }
        }
      }
    }
    if (paramInt1 == 0) {}
    View localView;
    RecentBaseData localRecentBaseData;
    for (this.decodeFaceStartTime = 0L;; this.decodeFaceStartTime = l)
    {
      bool1 = false;
      int k = this.mListView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 >= k) {
        break label895;
      }
      localView = this.mListView.getChildAt(paramInt1);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {
        break;
      }
      break label956;
    }
    int j = localRecentBaseData.ng();
    int i = j;
    label427:
    if (getStyle() == 4)
    {
      if (!QLog.isColorLevel()) {
        break label963;
      }
      QLog.i("RecentAdapter", 2, "====RecentAdapter onDecodeTaskCompleted === type: " + paramInt2 + ",uin: " + paramString + ",recentUserType: " + j);
      break label963;
    }
    for (;;)
    {
      i = ((Integer)aajx.a(this.app, i, localRecentBaseData.qx()).first).intValue();
      if (i != -2147483648)
      {
        Object localObject1;
        if ((localRecentBaseData instanceof RecentSayHelloBoxItem))
        {
          localObject1 = ((RecentSayHelloBoxItem)localRecentBaseData).mUnreadMRList;
          paramBitmap = ((RecentSayHelloBoxItem)localRecentBaseData).lock;
          if (localObject1 != null)
          {
            try
            {
              if (((List)localObject1).size() <= 0) {
                break label642;
              }
              localObject1 = new LinkedList((Collection)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
                Object localObject2 = i + ":" + localMessageRecord.senderuin;
                localObject2 = (Bitmap)this.faceCache.get(localObject2);
                if (localObject2 != null) {
                  a(localView, localRecentBaseData, localMessageRecord, new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject2));
                }
              }
              i = j;
            }
            finally {}
            if (paramInt2 != 101) {
              continue;
            }
            break label956;
          }
        }
        else
        {
          label642:
          paramBitmap = i + ":" + localRecentBaseData.qx();
          paramBitmap = (Bitmap)this.faceCache.get(paramBitmap);
          if (paramBitmap != null)
          {
            if (i == 103)
            {
              l = System.currentTimeMillis();
              localObject1 = BaseApplication.getContext().getResources().getDrawable(2130840893);
              if ((localObject1 instanceof SkinnableBitmapDrawable)) {
                ((SkinnableBitmapDrawable)localObject1).setGravity(81);
              }
              if ((localObject1 instanceof BitmapDrawable)) {
                ((BitmapDrawable)localObject1).setGravity(81);
              }
              ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
              localObject1 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), paramBitmap), localObject1 });
              paramBitmap = (Bitmap)localObject1;
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - l));
              }
            }
            for (paramBitmap = (Bitmap)localObject1;; paramBitmap = new BitmapDrawable(BaseApplication.getContext().getResources(), paramBitmap))
            {
              a(localView, localRecentBaseData, paramBitmap);
              bool1 = true;
              break;
            }
            label895:
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.faceCache.size() + ", isNeedUpdateAvatar=" + bool1);
            }
            this.faceCache.clear();
            return;
          }
        }
      }
      label956:
      paramInt1 += 1;
      break;
      label963:
      if (paramInt2 != 1001) {
        break label427;
      }
      i = 3002;
    }
  }
  
  public void onDestory()
  {
    this.mFaceDecoder.onDestory();
    this.app = null;
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 2, "RecentAdpater onLongClick");
    }
    if (this.jdField_a_of_type_Aakd != null) {}
    for (int i = this.jdField_a_of_type_Aakd.yH(); ((i == 0) || (i == 4)) && (FrameHelperActivity.ZW()); i = 0) {
      return false;
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
      }
      return false;
    }
    if ((paramView.getContext() instanceof TroopAssistantActivity)) {
      return false;
    }
    Object localObject1 = paramView.getTag(-1);
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
      }
      return false;
    }
    int j = ((Integer)localObject1).intValue();
    localObject1 = getItem(j);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onLongClick|obj = " + localObject1);
    }
    if ((localObject1 instanceof RecentBaseData)) {}
    for (localObject1 = (RecentBaseData)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick item is null, pos = " + j);
        }
        return false;
      }
      Object localObject2 = this.jdField_a_of_type_Aakd.a(localObject1);
      if (((RecentBaseData)localObject1).ng() == 1)
      {
        i = this.app.cs(((RecentBaseData)localObject1).qx());
        anot.a(this.app, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, ((RecentBaseData)localObject1).qx(), String.valueOf(i - 1), "", "");
      }
      if ("9970".equals(((RecentBaseData)localObject1).qx())) {
        anot.a(this.app, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Press_Shopfolderlong", 0, 0, "", "", "", "");
      }
      if (localObject2 != null) {}
      for (List localList = ((aakb)localObject2).a((RecentBaseData)localObject1, this.mContext);; localList = null)
      {
        if ((localList != null) && (localList.size() > 0) && (SystemClock.uptimeMillis() - this.LX > 100L))
        {
          localObject2 = new aqoa();
          i = 0;
          while (i < localList.size())
          {
            ((aqoa)localObject2).dV(j, (String)localList.get(i));
            i += 1;
          }
          boolean bool2 = false;
          boolean bool1;
          if ((this.bvU) && (ajig.a(this.mContext, ((RecentBaseData)localObject1).qx(), ((RecentBaseData)localObject1).ng(), ((RecentBaseData)localObject1).getTitleName(), "conversation_tab_list")))
          {
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.recent", 2, "MultiAIOStarter start multiaio successfully!");
              bool1 = bool2;
            }
          }
          for (;;)
          {
            this.LX = SystemClock.uptimeMillis();
            return bool1;
            try
            {
              this.mMenuPop = aqgq.a(paramView, (aqoa)localObject2, this.cp, new aajj(this, paramView));
              bool1 = true;
            }
            catch (Throwable paramView)
            {
              paramView.printStackTrace();
              bool1 = bool2;
            }
            if (QLog.isColorLevel())
            {
              QLog.i("Q.recent", 2, "long click showAsDropDown", paramView);
              bool1 = bool2;
            }
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + localObject2);
        }
        return false;
      }
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(this);
  }
  
  public static abstract interface a
  {
    public abstract void bMk();
    
    public abstract void bMl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajg
 * JD-Core Version:    0.7.0.1
 */