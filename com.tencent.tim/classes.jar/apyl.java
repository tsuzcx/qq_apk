import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class apyl
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, StoryHomeHorizontalListView.a
{
  public static final int dXW = rpq.dip2px(BaseApplicationImpl.getContext(), 111.0F);
  public TextView Wg = null;
  protected apyo a;
  protected apys a;
  protected ValueAnimator aK;
  protected ValueAnimator aL;
  public Animatable c = null;
  public int dSG = 1;
  protected apat e;
  ViewGroup eH = null;
  protected RelativeLayout ep;
  protected StoryHomeHorizontalListView g;
  private ValueAnimator.AnimatorUpdateListener h = new apym(this);
  private ValueAnimator.AnimatorUpdateListener i = new apyn(this);
  protected QQAppInterface mApp;
  public Context mContext;
  protected boolean mIsShowing;
  protected String mTroopUin;
  private int mViewType = 1;
  protected RelativeLayout ms;
  
  public apyl(QQAppInterface paramQQAppInterface, Context paramContext, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, apat paramapat)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.ep = paramRelativeLayout1;
    this.e = paramapat;
    this.ms = paramRelativeLayout2;
    this.jdField_a_of_type_Apys = ((apys)paramQQAppInterface.getManager(234));
  }
  
  private void stopLoading()
  {
    if ((this.c != null) && (this.c.isRunning())) {
      this.c.stop();
    }
    if (this.Wg != null)
    {
      this.Wg.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.Wg.setVisibility(8);
    }
  }
  
  public int LN()
  {
    if (this.g == null) {
      return this.mViewType;
    }
    if (this.aL == null)
    {
      this.aL = ValueAnimator.ofInt(new int[] { this.mContext.getResources().getDimensionPixelSize(2131299627), -dXW + this.mContext.getResources().getDimensionPixelSize(2131299627) });
      this.aL.setDuration(500L);
      this.aL.addUpdateListener(this.i);
    }
    if ((this.Wg != null) && (this.Wg.getVisibility() == 0)) {
      this.Wg.setVisibility(8);
    }
    this.aL.start();
    this.mIsShowing = false;
    this.jdField_a_of_type_Apyo.IA.clear();
    return this.mViewType;
  }
  
  public boolean aBH()
  {
    return ((this.mIsShowing) && (this.aK != null) && (this.aK.isRunning())) || ((!this.mIsShowing) && (this.aL != null) && (this.aL.isRunning()));
  }
  
  public void bqs()
  {
    int k;
    if (this.dSG == 2) {
      k = 22;
    }
    for (int j = 8;; j = 1)
    {
      if (this.dSG == 3) {
        j = 5;
      }
      Intent localIntent = TroopMemberListActivity.c(this.mContext, this.mTroopUin, k);
      localIntent.putExtra("selfSet_leftViewText", acfp.m(2131716048));
      localIntent.putExtra("sort_type", j);
      this.mContext.startActivity(localIntent);
      if (this.dSG == 2)
      {
        aqfr.b("Grp_idol", "Grp_renshu", "right", 0, 0, new String[] { this.mTroopUin });
        return;
      }
      new anov(this.mApp).a("dc00899").b("Grp_online").c("online_box").d("enter_mberList").a(new String[] { this.mTroopUin }).report();
      return;
      k = 17;
    }
  }
  
  public void bqt() {}
  
  public void destroy()
  {
    int j = this.ep.getChildCount() - 1;
    while (j >= 0)
    {
      if (this.ep.getChildAt(j) == this.eH) {
        this.ep.removeView(this.eH);
      }
      j -= 1;
    }
    if (this.aK != null) {
      this.aK.removeUpdateListener(this.h);
    }
    if (this.aL != null) {
      this.aL.removeUpdateListener(this.i);
    }
  }
  
  public boolean isShowing()
  {
    return this.mIsShowing;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    apyr localapyr = ((apyo.b)paramView.getTag()).a;
    if (localapyr == null) {}
    label185:
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (localapyr.type == 2) {
        aqfr.b("Grp_idol", "Grp_renshu", "clk", 0, 0, new String[] { this.mTroopUin });
      }
      for (;;)
      {
        if (((aptw)this.mApp.getManager(203)).c(this.mContext, this.mTroopUin, Long.valueOf(localapyr.uin).longValue())) {
          break label185;
        }
        aldj.a(this.mApp, (Activity)this.mContext, this.mTroopUin, localapyr.uin, 0, -1);
        break;
        new anov(this.mApp).a("dc00899").b("Grp_online").c("online_box").d("clk_mberHead").a(new String[] { this.mTroopUin, localapyr.tag }).report();
      }
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (apyo.b)paramView.getTag();
    paramView = paramAdapterView.a;
    TroopChatPie localTroopChatPie = (TroopChatPie)((FragmentActivity)this.mContext).getChatFragment().a();
    if (localTroopChatPie != null) {
      localTroopChatPie.b(paramView.uin, paramAdapterView.nameView.getText().toString(), false, 1);
    }
    new anov(this.mApp).a("dc00899").b("Grp_online").c("online_box").d("press_mberHead").a(new String[] { this.mTroopUin, paramView.tag }).report();
    return true;
  }
  
  public void show(int paramInt)
  {
    this.mViewType = paramInt;
    if (this.eH == null) {
      this.eH = ((ViewGroup)LayoutInflater.from(this.mContext).inflate(2131560756, null));
    }
    Object localObject;
    if (this.g == null)
    {
      this.g = ((StoryHomeHorizontalListView)this.eH.findViewById(2131380368));
      this.g.setOnItemClickListener(this);
      this.g.setOnItemLongClickListener(this);
      this.g.setOnOverScrollRightListener(this);
      if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null))
      {
        this.g.setBackgroundColor(-16445151);
        this.jdField_a_of_type_Apyo = new apyo(this.mApp, this.mTroopUin);
        this.g.setAdapter(this.jdField_a_of_type_Apyo);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        this.g.setDataCount(2147483647);
        this.ep.addView(this.eH, (ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      stopLoading();
      localObject = ((apys)this.mApp.getManager(234)).bb(this.mTroopUin);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label384;
      }
      this.jdField_a_of_type_Apyo.setData((List)localObject);
      this.jdField_a_of_type_Apyo.notifyDataSetChanged();
      this.mViewType = 0;
    }
    for (;;)
    {
      if (this.aK == null)
      {
        this.aK = ValueAnimator.ofInt(new int[] { -dXW + this.mContext.getResources().getDimensionPixelSize(2131299627), this.mContext.getResources().getDimensionPixelSize(2131299627) });
        this.aK.setDuration(500L);
        this.aK.addUpdateListener(this.h);
      }
      this.g.setVisibility(0);
      if (this.e != null) {
        this.e.Rv(true);
      }
      this.aK.start();
      this.mIsShowing = true;
      if (this.dSG != 2) {
        break label459;
      }
      aqfr.b("Grp_idol", "Grp_renshu", "exp", 0, 0, new String[] { this.mTroopUin });
      return;
      this.g.setBackgroundColor(-436207617);
      break;
      label384:
      if (this.Wg == null) {
        this.Wg = ((TextView)this.eH.findViewById(2131362472));
      }
      this.jdField_a_of_type_Apyo.clearData();
      this.jdField_a_of_type_Apyo.notifyDataSetChanged();
      ThreadManager.getUIHandler().postDelayed(new TroopOnlineMemberBar.1(this), 500L);
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberBar", 2, "show(), itemList == null || itemList.empty");
      }
    }
    label459:
    new anov(this.mApp).a("dc00899").b("Grp_online").c("online_box").d("exp").a(new String[] { this.mTroopUin }).report();
  }
  
  public void update()
  {
    if (isShowing())
    {
      List localList = ((apys)this.mApp.getManager(234)).bb(this.mTroopUin);
      if (localList != null)
      {
        this.mViewType = 0;
        stopLoading();
        this.jdField_a_of_type_Apyo.setData(localList);
        this.jdField_a_of_type_Apyo.notifyDataSetChanged();
      }
    }
  }
  
  public void yJ(String paramString)
  {
    this.mTroopUin = paramString;
    int j = this.jdField_a_of_type_Apys.eY(this.mTroopUin);
    if (j == 3)
    {
      this.dSG = 2;
      return;
    }
    if (j == 5)
    {
      this.dSG = 3;
      return;
    }
    this.dSG = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyl
 * JD-Core Version:    0.7.0.1
 */