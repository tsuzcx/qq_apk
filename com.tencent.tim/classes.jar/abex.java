import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.adapter.MayKnowAdapter.5;
import com.tencent.mobileqq.adapter.MayKnowAdapter.7;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.b;
import com.tencent.widget.HorizontalListView.d;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class abex
  extends BaseAdapter
  implements View.OnClickListener, aqdf.a, HorizontalListView.b
{
  abex.c jdField_a_of_type_Abex$c;
  protected aqdf a;
  private HorizontalListView.d jdField_a_of_type_ComTencentWidgetHorizontalListView$d = new abfc(this);
  acff b;
  private int bJo;
  private int caS;
  private int cod;
  acfd jdField_e_of_type_Acfd = new abex.b(this);
  achg jdField_e_of_type_Achg;
  protected Runnable eJ = new MayKnowAdapter.5(this);
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private Runnable fq = new MayKnowAdapter.7(this);
  View.OnTouchListener j = new abey(this);
  private QQAppInterface mApp;
  Activity mContext;
  private int mMaxCount;
  private HorizontalListView q;
  private List<MayKnowRecommend> vT = new ArrayList();
  View.OnTouchListener x = new abez(this);
  
  public abex(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView, abex.c paramc, int paramInt1, int paramInt2)
  {
    paramHorizontalListView.setAdapter(this);
    this.q = paramHorizontalListView;
    this.jdField_a_of_type_Abex$c = paramc;
    this.mContext = paramActivity;
    this.mApp = paramQQAppInterface;
    this.b = ((acff)paramQQAppInterface.getManager(51));
    this.jdField_e_of_type_Achg = ((achg)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Aqdf = new aqdf(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Aqdf.a(this);
    this.bJo = paramInt1;
    this.caS = paramInt2;
    this.cod = wja.dp2px(12.0F, this.mContext.getResources());
    this.q.setOnItemScollEventListener(this);
    paramQQAppInterface.addObserver(this.jdField_e_of_type_Acfd);
    cBn();
    this.mMaxCount = achg.cwk;
    if ((this.vT != null) && (this.vT.size() > 0) && (this.mApp != null)) {
      switch (this.caS)
      {
      }
    }
    for (;;)
    {
      this.q.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$d);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "MayKnowAdapter ,mFriendObserver = " + this.jdField_e_of_type_Acfd);
      }
      this.q.postDelayed(this.fq, 1000L);
      return;
      anot.a(this.mApp, "CliOper", "", "", "0X800674D", "0X800674D", 0, 0, "", "", "", "");
      continue;
      anot.a(this.mApp, "CliOper", "", "", "0X800673E", "0X800673E", 0, 0, "", "", "", "");
      continue;
      anot.a(this.mApp, "CliOper", "", "", "0X800673F", "0X800673F", 0, 0, "", "", "", "");
      continue;
      anot.a(this.mApp, "CliOper", "", "", "0X8006773", "0X8006773", 0, 0, "", "", "", "");
    }
  }
  
  private void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    abfb localabfb = new abfb(this, paramView, paramView.getMeasuredWidth());
    if (paramAnimationListener != null) {
      localabfb.setAnimationListener(paramAnimationListener);
    }
    localabfb.setDuration(240L);
    paramView.startAnimation(localabfb);
  }
  
  private View bN()
  {
    int i = 0;
    View localView;
    if (i < this.q.getChildCount())
    {
      localView = this.q.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof abex.a)))
      {
        abex.a locala = (abex.a)localView.getTag();
        if ((locala == null) || (locala.c == null) || (locala.c.friendStatus == 0)) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "findTargetChangeStatusView view:" + localView);
      }
      return localView;
      i += 1;
      break;
      localView = null;
    }
  }
  
  private void cBm()
  {
    cli();
    if (this.jdField_e_of_type_Achg != null) {
      this.vT = this.jdField_e_of_type_Achg.cw();
    }
    notifyDataSetChanged();
    if ((this.vT == null) || (this.vT.size() == 0)) {
      if (this.jdField_a_of_type_Abex$c != null) {
        this.jdField_a_of_type_Abex$c.bUJ();
      }
    }
    while (this.jdField_a_of_type_Abex$c == null) {
      return;
    }
    this.jdField_a_of_type_Abex$c.bUK();
  }
  
  private void cBn()
  {
    if (this.jdField_e_of_type_Achg != null) {
      this.vT = this.jdField_e_of_type_Achg.cw();
    }
    notifyDataSetChanged();
    if ((this.vT == null) || (this.vT.size() == 0)) {
      if (this.jdField_a_of_type_Abex$c != null) {
        this.jdField_a_of_type_Abex$c.bUJ();
      }
    }
    while (this.jdField_a_of_type_Abex$c == null) {
      return;
    }
    this.jdField_a_of_type_Abex$c.bUK();
  }
  
  private View e(String paramString)
  {
    int i = 0;
    View localView;
    if (i < this.q.getChildCount())
    {
      localView = this.q.getChildAt(i);
      if ((localView != null) && ((localView.getTag() instanceof abex.a)))
      {
        abex.a locala = (abex.a)localView.getTag();
        if ((locala == null) || (locala.c == null) || (!TextUtils.equals(locala.c.uin, paramString))) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "findTargetDeleteView view:" + localView + "   uin:" + paramString);
      }
      return localView;
      i += 1;
      break;
      localView = null;
    }
  }
  
  private void gi(View paramView)
  {
    a(paramView, new abfa(this, paramView));
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.b(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.a(paramString, paramInt, true, (byte)0);
    }
    return aqhu.G();
  }
  
  public MayKnowRecommend a(int paramInt)
  {
    if ((this.vT != null) && (paramInt >= 0) && (paramInt < this.vT.size())) {
      return (MayKnowRecommend)this.vT.get(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "getItem Illegal Adapter with overflowed data,position =  " + paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public void ap(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onItemScrollNonVisible " + paramInt + " fromLeft=" + paramBoolean);
    }
    if (this.jdField_e_of_type_Achg != null) {
      this.jdField_e_of_type_Achg.b(a(paramInt), this.bJo, this.caS, 1);
    }
  }
  
  public void ckZ()
  {
    if ((this.q != null) && (this.q.isShown()) && (this.vT != null) && (!this.vT.isEmpty()))
    {
      int k = this.q.getFirstVisiblePosition();
      int m = this.q.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = k;
      while (i <= m)
      {
        if ((i >= 0) && (i < this.vT.size()) && (this.vT.get(i) != null))
        {
          localArrayList1.add(((MayKnowRecommend)this.vT.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.vT.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.vT.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + k + " lastVisibleItem: " + m + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if ((!localArrayList1.isEmpty()) && (this.mApp != null)) {
        ContactReportUtils.a(this.mApp, this.bJo, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 1, null);
      }
    }
  }
  
  public void cli()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "stopVisibleExpose firstVisible: " + this.q.getFirstVisiblePosition() + " lastvisible: " + this.q.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.q.isShown()) && (this.jdField_e_of_type_Achg != null)) {
      i = this.q.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.q.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_e_of_type_Achg.b(a(i), this.bJo, this.caS, 1);
      i += 1;
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "destroy");
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_e_of_type_Acfd);
    }
    for (;;)
    {
      if (this.q != null)
      {
        this.q.setOnScrollStateChangedListener(null);
        this.q.removeCallbacks(this.fq);
      }
      this.b = null;
      this.jdField_e_of_type_Achg = null;
      this.mApp = null;
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)localAppRuntime).removeObserver(this.jdField_e_of_type_Acfd);
      }
    }
  }
  
  public int getCount()
  {
    if (this.vT == null) {
      return 0;
    }
    if (this.vT.size() > this.mMaxCount) {
      return this.mMaxCount;
    }
    return this.vT.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "getView position: " + paramInt);
    }
    abex.a locala = null;
    if (paramView != null) {
      locala = (abex.a)paramView.getTag();
    }
    if ((paramView == null) || (locala == null) || (locala.needInflate) || (!TextUtils.equals(locala.themeId, ThemeUtil.curThemeId)))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558532, paramViewGroup, false);
      locala = new abex.a();
      locala.pQ = ((ImageView)paramView.findViewById(2131368406));
      locala.rc = ((TextView)paramView.findViewById(2131372383));
      locala.rc.getPaint();
      locala.Pu = ((TextView)paramView.findViewById(2131367735));
      locala.Pv = ((TextView)paramView.findViewById(2131361966));
      locala.Pw = ((TextView)paramView.findViewById(2131362174));
      locala.AC = paramView.findViewById(2131364677);
      locala.AC.setOnClickListener(this);
      locala.AC.setOnTouchListener(this.j);
      locala.pQ.setOnClickListener(this);
      locala.pQ.setOnTouchListener(this.x);
      if ((locala.pQ instanceof ThemeImageView)) {
        ((ThemeImageView)locala.pQ).setSupportMaskView(false);
      }
      locala.rc.setOnClickListener(this);
      locala.rc.setOnTouchListener(this.j);
      paramView.setTag(locala);
      if (this.bJo != 25)
      {
        locala.rc.setTextColor(this.mContext.getResources().getColor(2131167304));
        locala.Pu.setTextColor(this.mContext.getResources().getColor(2131167393));
      }
      locala.themeId = ThemeUtil.curThemeId;
    }
    for (;;)
    {
      MayKnowRecommend localMayKnowRecommend = a(paramInt);
      if (this.jdField_e_of_type_Achg != null) {
        this.jdField_e_of_type_Achg.a(localMayKnowRecommend, this.bJo, this.caS, 1);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      locala.uin = localMayKnowRecommend.uin;
      locala.c = localMayKnowRecommend;
      locala.AC.setTag(localMayKnowRecommend);
      locala.pQ.setTag(locala);
      locala.rc.setTag(locala);
      locala.pQ.setImageBitmap(a(1, locala.uin));
      if (this.jdField_e_of_type_Achg != null) {}
      for (boolean bool = this.jdField_e_of_type_Achg.aaC();; bool = false)
      {
        String str = localMayKnowRecommend.getDisplayName(bool);
        locala.rc.setText(str);
        if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(str))) {
          localStringBuilder.append(str);
        }
        if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason))
        {
          locala.Pu.setText(localMayKnowRecommend.recommendReason);
          if (AppSetting.enableTalkBack) {
            localStringBuilder.append(",你们有").append(localMayKnowRecommend.recommendReason);
          }
          if (localMayKnowRecommend.friendStatus != 0) {
            break label701;
          }
          locala.Pv.setVisibility(0);
          locala.Pv.setTag(localMayKnowRecommend);
          locala.Pw.setVisibility(8);
          locala.Pv.setOnClickListener(this);
          if (AppSetting.enableTalkBack)
          {
            locala.Pv.setContentDescription(acfp.m(2131721053));
            localStringBuilder.append(",添加他为好友");
          }
          label636:
          if (paramInt != getCount() - 1) {
            break label848;
          }
          paramView.setPadding(0, 0, this.cod, 0);
        }
        for (;;)
        {
          if (AppSetting.enableTalkBack) {
            paramView.setContentDescription(localStringBuilder.toString());
          }
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          locala.Pu.setText("");
          break;
          label701:
          if (localMayKnowRecommend.friendStatus == 1)
          {
            locala.Pv.setVisibility(8);
            locala.Pw.setVisibility(0);
            locala.Pw.setText(2131718834);
            if (!AppSetting.enableTalkBack) {
              break label636;
            }
            locala.Pw.setContentDescription(this.mContext.getResources().getString(2131718834));
            localStringBuilder.append(",等待验证");
            break label636;
          }
          locala.Pv.setVisibility(8);
          locala.Pw.setVisibility(0);
          locala.Pw.setText(2131690291);
          if (!AppSetting.enableTalkBack) {
            break label636;
          }
          locala.Pw.setContentDescription(this.mContext.getResources().getString(2131690291));
          localStringBuilder.append(",已添加");
          break label636;
          label848:
          paramView.setPadding(0, 0, 0, 0);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    boolean bool;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            localObject1 = (MayKnowRecommend)paramView.getTag();
          } while (localObject1 == null);
          if ((this.b != null) && (!this.b.isFriend(((MayKnowRecommend)localObject1).uin)) && (!this.b.kd(((MayKnowRecommend)localObject1).uin)))
          {
            bool = false;
            if (this.jdField_e_of_type_Achg != null) {
              bool = this.jdField_e_of_type_Achg.aaC();
            }
            localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
            localObject2 = AddFriendLogicActivity.a(this.mContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, this.bJo, (String)localObject2, null, null, this.mContext.getString(2131721053), null);
            ((Intent)localObject2).putExtra("key_param_age_area", aqep.a(this.mContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
            this.mContext.startActivity((Intent)localObject2);
            if (this.mApp != null) {
              switch (this.caS)
              {
              }
            }
          }
          for (;;)
          {
            if (this.jdField_e_of_type_Achg != null) {
              this.jdField_e_of_type_Achg.a((MayKnowRecommend)localObject1, this.bJo, this.caS, 3);
            }
            if ((this.vT == null) || (this.mApp == null)) {
              break;
            }
            ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.bJo, 1, ((MayKnowRecommend)localObject1).recommendReason, this.vT.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
            break;
            anot.a(this.mApp, "CliOper", "", "", "0X8006750", "0X8006750", 0, 0, "", "", "", "");
            continue;
            anot.a(this.mApp, "CliOper", "", "", "0X8006744", "0X8006744", 0, 0, "", "", "", "");
            continue;
            anot.a(this.mApp, "CliOper", "", "", "0X8006745", "0X8006745", 0, 0, "", "", "", "");
            continue;
            anot.a(this.mApp, "CliOper", "", "", "0X8006771", "0X8006771", 0, 0, "", "", "", "");
            continue;
            if ((this.b != null) && (this.b.isFriend(((MayKnowRecommend)localObject1).uin)))
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
          localObject1 = (MayKnowRecommend)paramView.getTag();
        } while ((localObject1 == null) || (this.mApp == null));
        ((FriendListHandler)this.mApp.getBusinessHandler(1)).DK(((MayKnowRecommend)localObject1).uin);
        switch (this.caS)
        {
        }
        while ((this.vT != null) && (this.mApp != null))
        {
          ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_dlt", this.bJo, 0, ((MayKnowRecommend)localObject1).recommendReason, this.vT.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
          break;
          anot.a(this.mApp, "CliOper", "", "", "0X800674F", "0X800674F", 0, 0, "", "", "", "");
          continue;
          anot.a(this.mApp, "CliOper", "", "", "0X8006742", "0X8006742", 0, 0, "", "", "", "");
          continue;
          anot.a(this.mApp, "CliOper", "", "", "0X8006743", "0X8006743", 0, 0, "", "", "", "");
          continue;
          anot.a(this.mApp, "CliOper", "", "", "0X8006772", "0X8006772", 0, 0, "", "", "", "");
        }
        localObject1 = (abex.a)paramView.getTag();
      } while (localObject1 == null);
      localObject1 = ((abex.a)localObject1).c;
    } while (localObject1 == null);
    int i = 84;
    switch (this.bJo)
    {
    default: 
      label872:
      int k = i;
      if (this.b != null)
      {
        k = i;
        if (this.b.isFriend(((MayKnowRecommend)localObject1).uin)) {
          k = 1;
        }
      }
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, k);
      bool = false;
      if (this.jdField_e_of_type_Achg != null) {
        bool = this.jdField_e_of_type_Achg.aaC();
      }
      Object localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((ProfileActivity.AllInOne)localObject2).aOH = ((String)localObject3);
      }
      if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
        ((ProfileActivity.AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
      }
      ((ProfileActivity.AllInOne)localObject2).bJa = 88;
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
      if (this.vT != null) {
        ((Bundle)localObject3).putInt("recommend_pos", this.vT.indexOf(localObject1));
      }
      ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
      ((Bundle)localObject3).putInt("key_display_type", 1);
      ProfileActivity.a(this.mContext, (ProfileActivity.AllInOne)localObject2, (Bundle)localObject3);
      if (this.jdField_e_of_type_Achg != null) {
        this.jdField_e_of_type_Achg.a((MayKnowRecommend)localObject1, this.bJo, this.caS, 2);
      }
      if (this.mApp != null) {
        switch (this.caS)
        {
        }
      }
      break;
    }
    while ((this.vT != null) && (this.mApp != null))
    {
      ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.bJo, 0, ((MayKnowRecommend)localObject1).recommendReason, this.vT.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
      break;
      i = 82;
      break label872;
      i = 81;
      break label872;
      i = 83;
      break label872;
      i = 102;
      break label872;
      i = 107;
      break label872;
      anot.a(this.mApp, "CliOper", "", "", "0X800674E", "0X800674E", 0, 0, "", "", "", "");
      continue;
      anot.a(this.mApp, "CliOper", "", "", "0X8006740", "0X8006740", 0, 0, "", "", "", "");
      continue;
      anot.a(this.mApp, "CliOper", "", "", "0X8006741", "0X8006741", 0, 0, "", "", "", "");
      continue;
      anot.a(this.mApp, "CliOper", "", "", "0X800678A", "0X800678A", 0, 0, "", "", "", "");
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.faceCache.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.q.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.q.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof abex.a)))
        {
          paramString = (abex.a)paramString;
          if ((paramString != null) && (paramString.uin != null) && (paramString.uin.length() > 0))
          {
            paramBitmap = (Bitmap)this.faceCache.get(paramString.uin);
            if (paramBitmap != null) {
              paramString.pQ.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.faceCache.clear();
    }
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "startVisibleExpose firstVisible: " + this.q.getFirstVisiblePosition() + " lastvisible: " + this.q.getLastVisiblePosition());
    }
    int i;
    if ((getCount() > 0) && (this.q.isShown()) && (this.jdField_e_of_type_Achg != null)) {
      i = this.q.getFirstVisiblePosition();
    }
    for (;;)
    {
      if ((i > this.q.getLastVisiblePosition()) || (i < 0)) {
        return;
      }
      this.jdField_e_of_type_Achg.a(a(i), this.bJo, this.caS, 1);
      i += 1;
    }
  }
  
  public static class a
  {
    public View AC;
    public TextView Pu;
    public TextView Pv;
    public TextView Pw;
    public MayKnowRecommend c;
    public boolean needInflate;
    public ImageView pQ;
    public TextView rc;
    public String themeId;
    public int type = 1;
    public String uin;
  }
  
  static final class b
    extends acfd
  {
    WeakReference<abex> ak;
    
    b(abex paramabex)
    {
      this.ak = new WeakReference(paramabex);
    }
    
    protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
    {
      abex localabex;
      if (paramBoolean)
      {
        localabex = (abex)this.ak.get();
        if (localabex == null) {
          break label71;
        }
        paramString = abex.a(localabex, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onCancelMayKnowRecommend target：" + paramString);
        }
        if (paramString != null) {
          abex.a(localabex, paramString);
        }
      }
      else
      {
        return;
      }
      abex.a(localabex);
      return;
      label71:
      QLog.d("MayKnowAdapter", 1, "onCancelMayKnowRecommend  adapter is null!");
    }
    
    protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
    {
      if (paramBoolean)
      {
        paramBundle = (abex)this.ak.get();
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayKnowAdapter", 2, "onGetMayKnowRecommend ");
          }
          abex.a(paramBundle);
        }
      }
      else
      {
        return;
      }
      QLog.d("MayKnowAdapter", 1, "onGetMayKnowRecommend adapter is null!");
    }
    
    protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
    {
      super.onMayKnowListPushAdd(paramBoolean, paramList);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "onMayKnowListPushAdd");
      }
      if (paramBoolean)
      {
        paramList = (abex)this.ak.get();
        if (paramList != null) {
          abex.a(paramList);
        }
      }
      else
      {
        return;
      }
      QLog.d("MayKnowAdapter", 1, "onMayKnowListPushAdd adapter is null!");
    }
    
    protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
    {
      super.onMayKnowListPushDel(paramBoolean, paramList);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "onMayKnowListPushDel");
      }
      if (paramBoolean)
      {
        paramList = (abex)this.ak.get();
        if (paramList != null) {
          abex.a(paramList);
        }
      }
      else
      {
        return;
      }
      QLog.d("MayKnowAdapter", 1, "onMayKnowListPushDel adapter is null!");
    }
    
    protected void onMayknowStateChanged(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        abex localabex = (abex)this.ak.get();
        if (localabex == null) {
          break label60;
        }
        if (abex.a(localabex) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayKnowAdapter", 2, "onMayknowStateChanged");
          }
          localabex.notifyDataSetChanged();
          abex.a(localabex).postDelayed(localabex.eJ, 1600L);
        }
      }
      return;
      label60:
      QLog.d("MayKnowAdapter", 1, "onMayknowStateChanged adapter is null!");
    }
  }
  
  public static abstract interface c
  {
    public abstract void bUJ();
    
    public abstract void bUK();
  }
  
  public static abstract interface d
    extends abex.c
  {
    public abstract void fX(List<MayKnowRecommend> paramList);
    
    public abstract void wo(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abex
 * JD-Core Version:    0.7.0.1
 */