import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter.2;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter.6;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView.c;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abfm
  extends abeg
  implements View.OnClickListener, SwipListView.c
{
  abex.c jdField_a_of_type_Abex$c;
  private achg jdField_a_of_type_Achg;
  private amhj jdField_a_of_type_Amhj;
  auvd jdField_a_of_type_Auvd;
  private int bJo;
  int bKH = -1;
  private String bfy = "";
  private amfh c = new abfn(this);
  private int caS;
  int cof;
  acfd e = new abfo(this);
  protected Runnable eJ = new RecommendFriendAdapter.2(this);
  protected Runnable eK = new RecommendFriendAdapter.6(this);
  private QQAppInterface mApp;
  private Context mContext;
  private XListView mListView;
  private AbsListView.e mOnScrollListener = new abfq(this);
  private Resources mRes;
  private List<MayKnowRecommend> ta = new ArrayList();
  
  public abfm(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, abex.c paramc)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mRes = this.mContext.getResources();
    this.jdField_a_of_type_Achg = ((achg)paramQQAppInterface.getManager(159));
    paramXListView.setAdapter(this);
    this.mListView = paramXListView;
    this.caS = paramInt;
    this.bJo = 3;
    if (this.caS == 8) {
      this.bJo = 24;
    }
    for (;;)
    {
      this.jdField_a_of_type_Amhj = ((amhj)paramQQAppInterface.getManager(15));
      this.jdField_a_of_type_Amhj.addListener(this.c);
      this.jdField_a_of_type_Abex$c = paramc;
      setOnScrollListener(this.mOnScrollListener);
      this.mApp.addObserver(this.e);
      this.jdField_a_of_type_Auvd = a(paramContext);
      return;
      if ((this.caS == 3) || (this.caS == 6)) {
        this.bJo = 21;
      } else if (this.caS == 10) {
        this.bJo = 28;
      }
    }
  }
  
  public static void C(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || (paramView.findViewById(2131377370) == null)) {}
    Object localObject;
    do
    {
      return;
      paramView = paramView.findViewById(2131377370);
      localObject = paramView.getTag(2131369034);
    } while ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue() == paramBoolean));
    paramView.setTag(2131369034, Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839644);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839642);
      return;
    }
    paramView.setBackgroundResource(2130839639);
  }
  
  private void cBp()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Achg.cw();
    if ((this.jdField_a_of_type_Abex$c != null) && ((this.jdField_a_of_type_Abex$c instanceof abex.d))) {
      ((abex.d)this.jdField_a_of_type_Abex$c).fX(localArrayList);
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      gJ(localArrayList);
      if (this.jdField_a_of_type_Abex$c != null) {
        this.jdField_a_of_type_Abex$c.bUK();
      }
    }
    do
    {
      return;
      gJ(new ArrayList());
    } while (this.jdField_a_of_type_Abex$c == null);
    this.jdField_a_of_type_Abex$c.bUJ();
  }
  
  public void Bu(String paramString)
  {
    this.bfy = paramString;
    if (this.bfy == null) {
      this.bfy = "";
    }
  }
  
  public void GY(int paramInt)
  {
    this.cof = paramInt;
  }
  
  public void GZ(int paramInt)
  {
    this.bJo = paramInt;
  }
  
  protected View a(Context paramContext, int paramInt, abfm.a parama)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Auvd.a(paramContext, localView, parama, -1);
  }
  
  protected auvd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299263);
    int j = paramContext.getResources().getDimensionPixelSize(2131299264);
    paramContext = ysa.fA;
    int[] arrayOfInt1 = ysa.fy;
    int[] arrayOfInt2 = ysa.fz;
    return new abfp(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, auvd.a parama, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Auvd != null) {}
    for (int i = this.jdField_a_of_type_Auvd.a(paramContext, paramView, paramInt, paramObject, parama, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.bKH == paramInt)) {
        paramView.scrollTo(i, 0);
      }
      while (j == 0) {
        return;
      }
      paramView.scrollTo(0, 0);
      return;
    }
  }
  
  public void al(boolean paramBoolean) {}
  
  public void ckZ()
  {
    int j = 2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    if ((this.mListView != null) && (this.mListView.isShown()) && (!this.ta.isEmpty()))
    {
      this.mListView.removeCallbacks(this.eK);
      int k = this.mListView.getFirstVisiblePosition();
      int m = this.mListView.getLastVisiblePosition();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localArrayList4 = new ArrayList();
      i = k;
      while (i <= m)
      {
        if ((i >= 0) && (i < this.ta.size()) && (this.ta.get(i) != null))
        {
          localArrayList1.add(((MayKnowRecommend)this.ta.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.ta.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.ta.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + k + " lastVisibleItem: " + m + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if (!localArrayList1.isEmpty()) {
        if (this.bJo != 21) {
          break label365;
        }
      }
    }
    label365:
    for (int i = j;; i = 0)
    {
      String str = "";
      if (this.bJo == 24) {
        str = "2";
      }
      ContactReportUtils.a(this.mApp, this.bJo, localArrayList1, localArrayList2, localArrayList3, localArrayList4, i, str);
      return;
    }
  }
  
  public void cli()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "stopVisibleExpose firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.mListView.isShown()))
    {
      int i = this.mListView.getFirstVisiblePosition();
      while (i <= this.mListView.getLastVisiblePosition())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_Achg.b(localMayKnowRecommend, this.bJo, this.caS, 1);
        i += 1;
      }
    }
    if (this.mListView != null) {
      this.mListView.removeCallbacks(this.eK);
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
  
  public void destroy()
  {
    this.jdField_a_of_type_Amhj.removeListener(this.c);
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    setOnScrollListener(null);
    this.mApp.removeObserver(this.e);
    if (this.mListView != null) {
      this.mListView.removeCallbacks(this.eJ);
    }
  }
  
  public void gJ(List<MayKnowRecommend> paramList)
  {
    MayKnowRecommend localMayKnowRecommend;
    if ((!TextUtils.isEmpty(this.bfy)) && (paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
      } while (!this.bfy.equals(localMayKnowRecommend.uin));
    }
    for (;;)
    {
      if (localMayKnowRecommend != null)
      {
        paramList.remove(localMayKnowRecommend);
        paramList.add(0, localMayKnowRecommend);
      }
      this.ta = paramList;
      if (this.ta == null) {
        this.ta = new ArrayList();
      }
      notifyDataSetChanged();
      return;
      localMayKnowRecommend = null;
    }
  }
  
  public int getCount()
  {
    return this.ta.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.ta.size())) {
      return new MayKnowRecommend();
    }
    return this.ta.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    abfm.a locala;
    MayKnowRecommend localMayKnowRecommend;
    StringBuilder localStringBuilder;
    if (paramView == null)
    {
      locala = new abfm.a();
      paramView = a(this.mContext, 2131561722, locala);
      locala.LG = ((TextView)paramView.findViewById(2131371194));
      locala.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131380324));
      locala.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      locala.pQ = ((ImageView)paramView.findViewById(2131361802));
      locala.us = ((TextView)paramView.findViewById(2131372384));
      locala.LE = ((Button)paramView.findViewById(2131377201));
      locala.LF = ((TextView)paramView.findViewById(2131377211));
      paramView.setTag(locala);
      if ((locala.pQ instanceof ThemeImageView)) {
        ((ThemeImageView)locala.pQ).setSupportMaskView(false);
      }
      ysa.D(locala.Lz, false);
      localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder(512);
        localStringBuilder.append("getView position: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", mobile_name : ");
        localStringBuilder.append(localMayKnowRecommend.mobile_name);
        localStringBuilder.append(", remark : ");
        localStringBuilder.append(localMayKnowRecommend.remark);
        localStringBuilder.append(", nick : ");
        localStringBuilder.append(localMayKnowRecommend.nick);
        localStringBuilder.append(", gender : ");
        localStringBuilder.append(localMayKnowRecommend.gender);
        localStringBuilder.append(", age : ");
        localStringBuilder.append(localMayKnowRecommend.age);
        localStringBuilder.append(", category : ");
        localStringBuilder.append(localMayKnowRecommend.category);
        localStringBuilder.append(", recommendReason : ");
        localStringBuilder.append(localMayKnowRecommend.recommendReason);
        localStringBuilder.append(", hasQZoneUpdate : ");
        localStringBuilder.append(localMayKnowRecommend.hasQZoneUpdate);
        localStringBuilder.append(", signature : ");
        localStringBuilder.append(localMayKnowRecommend.richSingature);
        QLog.d("RecommendFriendAdapter", 2, localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder(512);
      locala.uin = localMayKnowRecommend.uin;
      locala.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
      this.jdField_a_of_type_Achg.a(localMayKnowRecommend, this.bJo, this.caS, 1);
      Object localObject = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Achg.aaC());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label833;
      }
      locala.us.setVisibility(0);
      locala.us.setText((CharSequence)localObject);
      if (AppSetting.enableTalkBack) {
        localStringBuilder.append((String)localObject);
      }
      label502:
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.mContext, paramView, paramInt, localMayKnowRecommend, locala, this);
      locala.Lz.setTag(localMayKnowRecommend);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(localMayKnowRecommend.category)) {
        ((StringBuilder)localObject).append(localMayKnowRecommend.category).append(" ");
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        ((StringBuilder)localObject).append(localMayKnowRecommend.recommendReason);
      }
      localObject = ((StringBuilder)localObject).toString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label846;
      }
      locala.LG.setVisibility(0);
      locala.LG.setText((CharSequence)localObject);
      if (AppSetting.enableTalkBack) {
        localStringBuilder.append(",").append((String)localObject);
      }
      label649:
      locala.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.b(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label859;
      }
      locala.LE.setOnClickListener(this);
      locala.LE.setVisibility(0);
      locala.LE.setTag(localMayKnowRecommend);
      locala.LE.setText(acfp.m(2131721053));
      locala.LF.setVisibility(8);
      if (AppSetting.enableTalkBack)
      {
        localStringBuilder.append(",点击添加");
        locala.LE.setContentDescription(acfp.m(2131721053));
      }
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      locala.Lz.setOnClickListener(this);
      locala.pQ.setImageBitmap(a(1, locala.uin));
      C(paramView, localMayKnowRecommend.bHighLight);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (abfm.a)paramView.getTag();
      break;
      label833:
      locala.us.setVisibility(8);
      break label502;
      label846:
      locala.LG.setVisibility(8);
      break label649;
      label859:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        locala.LE.setVisibility(8);
        locala.LF.setVisibility(0);
        locala.LF.setText(2131718834);
        if (AppSetting.enableTalkBack)
        {
          localStringBuilder.append(",等待验证");
          locala.LF.setContentDescription(this.mContext.getResources().getString(2131718834));
        }
      }
      else
      {
        locala.LE.setVisibility(8);
        locala.LF.setVisibility(0);
        locala.LF.setText(2131690291);
        if (AppSetting.enableTalkBack)
        {
          localStringBuilder.append(",已添加");
          locala.LF.setContentDescription(this.mContext.getResources().getString(2131690291));
        }
      }
    }
  }
  
  public void hi() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    MayKnowRecommend localMayKnowRecommend;
    Object localObject2;
    boolean bool;
    label406:
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (!aqiw.isNetworkAvailable(this.mContext))
          {
            QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          }
          else
          {
            localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
            if (localMayKnowRecommend != null)
            {
              localObject2 = localMayKnowRecommend.uin;
              if (QLog.isColorLevel()) {
                QLog.d("RecommendFriendAdapter", 2, "onClick_ delete item uin = " + (String)localObject2);
              }
              ((FriendListHandler)this.mApp.getBusinessHandler(1)).DK((String)localObject2);
              this.ta.remove(localMayKnowRecommend);
              notifyDataSetChanged();
              i = 0;
              if (this.bJo == 21) {
                i = 2;
              }
              localObject1 = "";
              if (this.bJo == 24) {
                localObject1 = "2";
              }
              ContactReportUtils.a(this.mApp, (String)localObject2, "frd_list_dlt", this.bJo, 0, localMayKnowRecommend.recommendReason, this.ta.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
            }
          }
        }
        localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
      } while (localMayKnowRecommend == null);
      localObject1 = (acff)this.mApp.getManager(51);
      if ((!((acff)localObject1).isFriend(localMayKnowRecommend.uin)) && (!((acff)localObject1).kd(localMayKnowRecommend.uin)))
      {
        bool = ((Activity)this.mContext).getIntent().getBooleanExtra("from_babyq", false);
        localObject1 = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Achg.aaC());
        int j = 3045;
        switch (this.caS)
        {
        case 5: 
        case 6: 
        case 7: 
        case 9: 
        default: 
          i = 3;
          if (bool)
          {
            j = 3083;
            i = 1;
          }
          localObject1 = AddFriendLogicActivity.a(this.mContext, 1, localMayKnowRecommend.uin, null, j, i, (String)localObject1, null, null, this.mContext.getString(2131721053), null);
          ((Intent)localObject1).putExtra("key_param_age_area", aqep.a(this.mContext, localMayKnowRecommend.gender, localMayKnowRecommend.age, localMayKnowRecommend.country, localMayKnowRecommend.province, localMayKnowRecommend.city));
          ((Intent)localObject1).putExtra("from_babyq", bool);
          ((BaseActivity)this.mContext).startActivity((Intent)localObject1);
          switch (this.caS)
          {
          }
          break;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Achg.a(localMayKnowRecommend, this.bJo, this.caS, 3);
        i = 0;
        if (this.bJo == 21) {
          i = 2;
        }
        localObject1 = "";
        if (this.bJo == 24) {
          localObject1 = "2";
        }
        ContactReportUtils.a(this.mApp, localMayKnowRecommend.uin, "frd_list_add", this.bJo, 1, localMayKnowRecommend.recommendReason, this.ta.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
        break;
        i = 24;
        break label406;
        i = 21;
        break label406;
        i = 28;
        break label406;
        anot.a(this.mApp, "CliOper", "", "", "0X800678B", "0X800678B", 0, 0, "", "", "", "");
        continue;
        anot.a(this.mApp, "CliOper", "", "", "0X8006748", "0X8006748", 0, 0, "", "", "", "");
        continue;
        anot.a(this.mApp, "CliOper", "", "", "0X8006749", "0X8006749", 0, 0, "", "", "", "");
        continue;
        anot.a(this.mApp, "CliOper", "", "", "0X8006789", "0X8006789", 0, 0, "", "", "", "");
        continue;
        if (((acff)localObject1).isFriend(localMayKnowRecommend.uin))
        {
          localMayKnowRecommend.friendStatus = 2;
          notifyDataSetChanged();
        }
        else
        {
          localMayKnowRecommend.friendStatus = 1;
          notifyDataSetChanged();
        }
      }
      localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
    } while (localMayKnowRecommend == null);
    Object localObject1 = (acff)this.mApp.getManager(51);
    label881:
    Bundle localBundle;
    if ((localObject1 != null) && (((acff)localObject1).isFriend(localMayKnowRecommend.uin)))
    {
      i = 1;
      localObject2 = new ProfileActivity.AllInOne(localMayKnowRecommend.uin, i);
      localObject1 = localMayKnowRecommend.getRecommendName(this.jdField_a_of_type_Achg.aaC());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((ProfileActivity.AllInOne)localObject2).aOH = ((String)localObject1);
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
        ((ProfileActivity.AllInOne)localObject2).nickname = localMayKnowRecommend.nick;
      }
      ((ProfileActivity.AllInOne)localObject2).bJa = 88;
      bool = ((Activity)this.mContext).getIntent().getBooleanExtra("from_babyq", false);
      localBundle = new Bundle();
      if (bool) {
        localBundle.putBoolean("from_babyq", true);
      }
      if (this.bJo != 21) {
        break label1455;
      }
    }
    label1455:
    for (int i = 2;; i = 0)
    {
      localObject1 = "";
      if (this.bJo == 24) {
        localObject1 = "2";
      }
      localBundle.putString("recommend_entry_type", (String)localObject1);
      localBundle.putInt("key_display_type", i);
      localBundle.putString("recommend_reason", localMayKnowRecommend.recommendReason);
      localBundle.putInt("recommend_pos", this.ta.indexOf(localMayKnowRecommend));
      localBundle.putByteArray("recommend_algh_id", localMayKnowRecommend.algBuffer);
      ProfileActivity.a(this.mContext, (ProfileActivity.AllInOne)localObject2, localBundle);
      this.jdField_a_of_type_Achg.a(localMayKnowRecommend, this.bJo, this.caS, 2);
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendAdapter", 2, "onClick_ open profile item uin = " + localMayKnowRecommend.uin);
      }
      switch (this.caS)
      {
      }
      for (;;)
      {
        localObject1 = "";
        if (this.bJo == 24) {
          localObject1 = "2";
        }
        ContactReportUtils.a(this.mApp, localMayKnowRecommend.uin, "frd_list_clk", this.bJo, 0, localMayKnowRecommend.recommendReason, this.ta.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
        break;
        if (this.caS == 8)
        {
          i = 101;
          break label881;
        }
        if ((this.caS == 3) || (this.caS == 4))
        {
          i = 82;
          break label881;
        }
        if (this.caS == 10)
        {
          i = 107;
          break label881;
        }
        i = 83;
        if (this.bJo != 21) {
          break label881;
        }
        i = 82;
        break label881;
        anot.a(this.mApp, "CliOper", "", "", "0X800678F", "0X800678F", 0, 0, "", "", "", "");
        continue;
        anot.a(this.mApp, "CliOper", "", "", "0X800678C", "0X800678C", 0, 0, "", "", "", "");
        continue;
        anot.a(this.mApp, "CliOper", "", "", "0X800678D", "0X800678D", 0, 0, "", "", "", "");
        continue;
        anot.a(this.mApp, "CliOper", "", "", "0X800678E", "0X800678E", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onResume firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.mListView.isShown()))
    {
      int i = this.mListView.getFirstVisiblePosition();
      while (i <= this.mListView.getLastVisiblePosition())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(i);
        this.jdField_a_of_type_Achg.a(localMayKnowRecommend, this.bJo, this.caS, 1);
        i += 1;
      }
    }
    if (this.mListView != null)
    {
      this.mListView.removeCallbacks(this.eK);
      this.mListView.postDelayed(this.eK, 1000L);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onScroll firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    if (paramInt1 >= 1)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_Achg.b(paramAbsListView, this.bJo, this.caS, 1);
      }
    }
    if (paramInt1 + paramInt2 < paramInt3)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 + paramInt2);
      if (paramAbsListView != null) {
        this.jdField_a_of_type_Achg.b(paramAbsListView, this.bJo, this.caS, 1);
      }
    }
  }
  
  static class a
    extends abeg.a
  {
    public TextView LE;
    public TextView LF;
    public TextView LG;
    public MayKnowRecommend a;
    public TroopLabelLayout a;
    public TextView us;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfm
 * JD-Core Version:    0.7.0.1
 */