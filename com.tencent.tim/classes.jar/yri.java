import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.2;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.7;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.9;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView.c;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class yri
  extends abeg
  implements View.OnClickListener, SwipListView.c
{
  private accn jdField_a_of_type_Accn = new yrl(this);
  private achg jdField_a_of_type_Achg;
  private amhj jdField_a_of_type_Amhj;
  private auvd jdField_a_of_type_Auvd;
  private zbq b;
  private TextView bI;
  int bKH = -1;
  private boolean bol;
  private boolean bor;
  private amfh c = new yrj(this);
  private int caH;
  private acfd e = new yrk(this);
  protected Runnable eJ = new ConnectsExplorationFriendAdapter.2(this);
  protected Runnable eK = new ConnectsExplorationFriendAdapter.9(this);
  private QQAppInterface mApp;
  private Comparator<MayKnowRecommend> mComparator = new yrn(this);
  private Context mContext;
  private int mLastVisibleIndex;
  private XListView mListView;
  private View mLoadingView;
  private AbsListView.e mOnScrollListener = new yro(this);
  private int mPos;
  private View sf;
  private List<MayKnowRecommend> ta = new ArrayList();
  private View xX;
  
  public yri(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView1, View paramView2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Achg = ((achg)paramQQAppInterface.getManager(159));
    paramXListView.setAdapter(this);
    this.mListView = paramXListView;
    this.sf = paramView1;
    this.bI = ((TextView)this.sf.findViewById(2131366397));
    this.xX = this.sf.findViewById(2131368227);
    this.xX.setOnClickListener(this);
    if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
      this.xX.setBackgroundResource(2130839546);
    }
    paramXListView = (ThemeImageView)this.sf.findViewById(2131368223);
    paramXListView.setSupportMaskView(true);
    paramXListView.setMaskShape(auvj.euL);
    this.mLoadingView = paramView2;
    this.jdField_a_of_type_Amhj = ((amhj)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_Amhj.addListener(this.c);
    setOnScrollListener(this.mOnScrollListener);
    this.mApp.addObserver(this.e);
    this.mApp.addObserver(this.jdField_a_of_type_Accn);
    this.jdField_a_of_type_Auvd = a(paramContext);
    this.bol = paramBoolean;
    this.caH = paramInt1;
    this.mPos = paramInt2;
    this.b = ((zbq)paramQQAppInterface.getManager(295));
    this.jdField_a_of_type_Achg = ((achg)this.mApp.getManager(159));
    if (this.mPos == 0) {
      AH(true);
    }
    if (this.mListView != null)
    {
      this.mListView.removeCallbacks(this.eK);
      this.mListView.postDelayed(this.eK, 1000L);
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
  
  private void a(yri.a parama)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null))
    {
      parama.ek.setBackgroundResource(2130839545);
      parama.zG.setTextColor(Color.parseColor("#12B7F5"));
      parama.LD.setTextColor(Color.parseColor("#7F12B7F5"));
      parama.uy.setImageDrawable(getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    parama.ek.setBackgroundResource(2130839546);
    parama.zG.setTextColor(Color.argb(102, 255, 255, 255));
    parama.LD.setTextColor(Color.argb(102, 255, 255, 255));
    parama.uy.setImageDrawable(getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  private URLDrawable getDrawable(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    URLDrawable localURLDrawable;
    do
    {
      return localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectsExplorationFriendAdapter", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  public void AH(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "reloadRecommendData " + this.caH + " " + paramBoolean);
    }
    if ((this.caH != 23) && (this.b.Vf()))
    {
      this.mLoadingView.setVisibility(8);
      this.sf.setVisibility(0);
      this.bI.setText(2131701426);
      this.xX.setVisibility(0);
      anot.a(this.mApp, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "2", "", "", "");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ConnectsExplorationFriendAdapter.7(this, paramBoolean));
  }
  
  protected View a(Context paramContext, int paramInt, yri.a parama)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Auvd.a(paramContext, localView, parama, -1);
  }
  
  protected View a(Context paramContext, int paramInt, yri.b paramb)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Auvd.a(paramContext, localView, paramb, -1);
  }
  
  protected auvd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299263);
    int j = paramContext.getResources().getDimensionPixelSize(2131299264);
    paramContext = ysa.fA;
    int[] arrayOfInt1 = ysa.fy;
    int[] arrayOfInt2 = ysa.fz;
    return new yrm(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
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
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    String str = paramMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Achg.aaC());
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!str.equals(paramMayKnowRecommend.mobile_name)))
    {
      paramTextView.setText("(" + paramMayKnowRecommend.mobile_name + ")");
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public boolean aB(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "userInfoState " + paramBoolean);
    }
    Object localObject = ((acff)this.mApp.getManager(51)).c(this.mApp.getCurrentAccountUin());
    ArrayList localArrayList = ((adyp)this.mApp.getManager(112)).cN();
    Iterator localIterator = this.ta.iterator();
    while (localIterator.hasNext()) {
      if (((MayKnowRecommend)localIterator.next() instanceof ConnectsExplorationBanner)) {
        localIterator.remove();
      }
    }
    if ((TextUtils.isEmpty(((Card)localObject).strSchool)) && ((localArrayList == null) || (localArrayList.isEmpty())))
    {
      localObject = new ConnectsExplorationBanner();
      ((ConnectsExplorationBanner)localObject).setBanner(true);
      if (this.ta.size() == 0) {
        return false;
      }
      if (this.ta.size() > 4) {
        break label201;
      }
      this.ta.add(localObject);
    }
    for (;;)
    {
      if (paramBoolean) {
        notifyDataSetChanged();
      }
      return true;
      label201:
      this.ta.add(4, localObject);
    }
  }
  
  public void al(boolean paramBoolean) {}
  
  public void ckY()
  {
    if (this.mPos != 0) {
      AH(true);
    }
  }
  
  public void ckZ()
  {
    if ((this.mListView != null) && (this.mListView.isShown()) && (!this.ta.isEmpty()))
    {
      this.mListView.removeCallbacks(this.eK);
      int j = this.mListView.getFirstVisiblePosition();
      int k = this.mListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = j;
      if (i <= k)
      {
        if ((i < 0) || (i >= this.ta.size()) || (this.ta.get(i) == null) || ((this.ta.get(i) instanceof ConnectsExplorationBanner))) {}
        for (;;)
        {
          i += 1;
          break;
          localArrayList1.add(((MayKnowRecommend)this.ta.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.ta.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.ta.get(i)).algBuffer);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConnectsExplorationFriendAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + j + " lastVisibleItem: " + k + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if (!localArrayList1.isEmpty()) {
        ContactReportUtils.a(this.mApp, this.caH, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, "4");
      }
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
    this.mApp.removeObserver(this.jdField_a_of_type_Accn);
    if (this.mListView != null) {
      this.mListView.removeCallbacks(this.eJ);
    }
  }
  
  public void gJ(List<MayKnowRecommend> paramList)
  {
    this.ta = paramList;
    if (this.ta == null) {
      this.ta = new ArrayList();
    }
    if (this.bol) {
      aB(false);
    }
    notifyDataSetChanged();
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
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    Object localObject1;
    StringBuilder localStringBuilder;
    if ((localMayKnowRecommend instanceof ConnectsExplorationBanner))
    {
      localObject1 = new yri.a();
      paramView = a(this.mContext, 2131561723, (yri.a)localObject1);
      ((yri.a)localObject1).uy = ((ImageView)paramView.findViewById(2131369676));
      ((yri.a)localObject1).LD = ((TextView)paramView.findViewById(2131380710));
      ((yri.a)localObject1).zG = ((TextView)paramView.findViewById(2131380976));
      ((yri.a)localObject1).ek = ((Button)paramView.findViewById(2131363797));
      ((yri.a)localObject1).ek.setOnClickListener(this);
      paramView.setTag(localObject1);
      ysa.D(((yri.a)localObject1).Lz, false);
      a((yri.a)localObject1);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.mContext, paramView, paramInt, localMayKnowRecommend, (auvd.a)localObject1, this);
      ((yri.a)localObject1).Lz.setTag(localMayKnowRecommend);
      paramView.setOnClickListener(this);
      ((yri.a)localObject1).Lz.setOnClickListener(this);
      anot.a(this.mApp, "dc00898", "", "", "frd_list", "info_add_exp", 2, 0, "", "", "", "");
      localObject1 = null;
      if (localObject1 != null)
      {
        localStringBuilder = new StringBuilder(512);
        ((yri.b)localObject1).uin = localMayKnowRecommend.uin;
        ((yri.b)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
        Object localObject2 = localMayKnowRecommend.getDisplayName(this.jdField_a_of_type_Achg.aaC());
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label841;
        }
        ((yri.b)localObject1).us.setVisibility(0);
        ((yri.b)localObject1).us.setText((CharSequence)localObject2);
        if (AppSetting.enableTalkBack) {
          localStringBuilder.append((String)localObject2);
        }
        label307:
        paramView.setTag(-1, Integer.valueOf(paramInt));
        a(this.mContext, paramView, paramInt, localMayKnowRecommend, (auvd.a)localObject1, this);
        ((yri.b)localObject1).Lz.setTag(localMayKnowRecommend);
        localObject2 = new StringBuilder();
        if (!TextUtils.isEmpty(localMayKnowRecommend.category)) {
          ((StringBuilder)localObject2).append(localMayKnowRecommend.category).append(" ");
        }
        if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
          ((StringBuilder)localObject2).append(localMayKnowRecommend.recommendReason);
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label854;
        }
        ((yri.b)localObject1).LG.setVisibility(0);
        ((yri.b)localObject1).LG.setText((CharSequence)localObject2);
        if (AppSetting.enableTalkBack) {
          localStringBuilder.append(",").append((String)localObject2);
        }
        label454:
        ((yri.b)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.b(localMayKnowRecommend);
        if (localMayKnowRecommend.friendStatus != 0) {
          break label867;
        }
        ((yri.b)localObject1).LE.setOnClickListener(this);
        ((yri.b)localObject1).LE.setVisibility(0);
        ((yri.b)localObject1).LE.setTag(localMayKnowRecommend);
        ((yri.b)localObject1).LE.setText(acfp.m(2131721053));
        ((yri.b)localObject1).LF.setVisibility(8);
        if (AppSetting.enableTalkBack)
        {
          localStringBuilder.append(",点击添加");
          ((yri.b)localObject1).LE.setContentDescription(acfp.m(2131721053));
        }
      }
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      ((yri.b)localObject1).Lz.setOnClickListener(this);
      ((yri.b)localObject1).pQ.setImageBitmap(a(1, ((yri.b)localObject1).uin));
      C(paramView, localMayKnowRecommend.bHighLight);
      a(((yri.b)localObject1).LH, localMayKnowRecommend);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if ((paramView == null) || (!(paramView.getTag() instanceof yri.b)))
      {
        localObject1 = new yri.b();
        paramView = a(this.mContext, 2131561722, (yri.b)localObject1);
        ((yri.b)localObject1).LG = ((TextView)paramView.findViewById(2131371194));
        ((yri.b)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131380324));
        ((yri.b)localObject1).jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        ((yri.b)localObject1).pQ = ((ImageView)paramView.findViewById(2131361802));
        ((yri.b)localObject1).us = ((TextView)paramView.findViewById(2131372384));
        ((yri.b)localObject1).LE = ((Button)paramView.findViewById(2131377201));
        ((yri.b)localObject1).LF = ((TextView)paramView.findViewById(2131377211));
        ((yri.b)localObject1).LH = ((TextView)paramView.findViewById(2131378956));
        paramView.setTag(localObject1);
        if ((((yri.b)localObject1).pQ instanceof ThemeImageView)) {
          ((ThemeImageView)((yri.b)localObject1).pQ).setSupportMaskView(true);
        }
        ysa.D(((yri.b)localObject1).Lz, false);
        break;
      }
      localObject1 = (yri.b)paramView.getTag();
      break;
      label841:
      ((yri.b)localObject1).us.setVisibility(8);
      break label307;
      label854:
      ((yri.b)localObject1).LG.setVisibility(8);
      break label454;
      label867:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        ((yri.b)localObject1).LE.setVisibility(8);
        ((yri.b)localObject1).LF.setVisibility(0);
        ((yri.b)localObject1).LF.setText(2131718834);
        if (AppSetting.enableTalkBack)
        {
          localStringBuilder.append(",等待验证");
          ((yri.b)localObject1).LF.setContentDescription(this.mContext.getResources().getString(2131718834));
        }
      }
      else
      {
        ((yri.b)localObject1).LE.setVisibility(8);
        ((yri.b)localObject1).LF.setVisibility(0);
        ((yri.b)localObject1).LF.setText(2131690291);
        if (AppSetting.enableTalkBack)
        {
          localStringBuilder.append(",已添加");
          ((yri.b)localObject1).LF.setContentDescription(this.mContext.getResources().getString(2131690291));
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
        Object localObject1 = (MayKnowRecommend)paramView.getTag();
        if (localObject1 != null)
        {
          Object localObject2 = ((MayKnowRecommend)localObject1).uin;
          if (QLog.isColorLevel()) {
            QLog.d("ConnectsExplorationFriendAdapter", 2, "onClick_ delete item uin = " + (String)localObject2);
          }
          ((FriendListHandler)this.mApp.getBusinessHandler(1)).DK((String)localObject2);
          this.ta.remove(localObject1);
          notifyDataSetChanged();
          ContactReportUtils.a(this.mApp, (String)localObject2, "frd_list_dlt", this.caH, 0, ((MayKnowRecommend)localObject1).recommendReason, this.ta.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.w(((MayKnowRecommend)localObject1).msgLabel), 0, "4");
          continue;
          localObject1 = (MayKnowRecommend)paramView.getTag();
          if (localObject1 != null)
          {
            localObject2 = (acff)this.mApp.getManager(51);
            int i;
            if ((!((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin)) && (!((acff)localObject2).kd(((MayKnowRecommend)localObject1).uin)))
            {
              boolean bool = ((Activity)this.mContext).getIntent().getBooleanExtra("from_babyq", false);
              localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(this.jdField_a_of_type_Achg.aaC());
              i = this.caH;
              localObject2 = AddFriendLogicActivity.a(this.mContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.mContext.getString(2131721053), null);
              ((Intent)localObject2).putExtra("key_param_age_area", aqep.a(this.mContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
              ((Intent)localObject2).putExtra("from_babyq", bool);
              ((BaseActivity)this.mContext).startActivity((Intent)localObject2);
            }
            for (;;)
            {
              ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.caH, 1, ((MayKnowRecommend)localObject1).recommendReason, this.ta.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "4");
              break;
              if (((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))
              {
                ((MayKnowRecommend)localObject1).friendStatus = 2;
                notifyDataSetChanged();
              }
              else
              {
                ((MayKnowRecommend)localObject1).friendStatus = 1;
                notifyDataSetChanged();
              }
            }
            anot.a(this.mApp, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
            localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
            paramView.getContext().startActivity((Intent)localObject1);
            continue;
            localObject1 = (MayKnowRecommend)paramView.getTag();
            if ((localObject1 instanceof ConnectsExplorationBanner))
            {
              anot.a(this.mApp, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
              localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
              paramView.getContext().startActivity((Intent)localObject1);
            }
            else if (localObject1 != null)
            {
              localObject2 = (acff)this.mApp.getManager(51);
              if ((localObject2 != null) && (((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))) {}
              for (i = 1;; i = 110)
              {
                localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
                String str = ((MayKnowRecommend)localObject1).getRecommendName(this.jdField_a_of_type_Achg.aaC());
                if (!TextUtils.isEmpty(str)) {
                  ((ProfileActivity.AllInOne)localObject2).aOH = str;
                }
                if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
                  ((ProfileActivity.AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
                }
                ((ProfileActivity.AllInOne)localObject2).bJa = 88;
                str = ContactReportUtils.w(((MayKnowRecommend)localObject1).msgLabel);
                Bundle localBundle = new Bundle();
                localBundle.putString("recommend_entry_type", "4");
                localBundle.putInt("key_display_type", 0);
                localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
                localBundle.putInt("recommend_pos", this.ta.indexOf(localObject1));
                localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
                localBundle.putString("recommend_label", str);
                localBundle.putInt("tabID", this.caH);
                ProfileActivity.a(this.mContext, (ProfileActivity.AllInOne)localObject2, localBundle);
                if (QLog.isColorLevel()) {
                  QLog.d("ConnectsExplorationFriendAdapter", 2, "onClick_ open profile item uin = " + ((MayKnowRecommend)localObject1).uin);
                }
                ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.caH, 0, ((MayKnowRecommend)localObject1).recommendReason, this.ta.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, str, 0, "4");
                break;
              }
              if (aqiw.isNetSupport(this.mContext))
              {
                anot.a(this.mApp, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "2", "", "", "");
                this.b.Bo(true);
              }
              else
              {
                QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
              }
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectsExplorationFriendAdapter", 2, "onResume firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
    }
    if (this.bol) {
      aB(true);
    }
  }
  
  static class a
    extends abeg.a
  {
    public TextView LD;
    public Button ek;
    public ImageView uy;
    public TextView zG;
  }
  
  static class b
    extends abeg.a
  {
    public TextView LE;
    public TextView LF;
    public TextView LG;
    public TextView LH;
    public MayKnowRecommend a;
    public TroopLabelLayout a;
    public TextView us;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yri
 * JD-Core Version:    0.7.0.1
 */