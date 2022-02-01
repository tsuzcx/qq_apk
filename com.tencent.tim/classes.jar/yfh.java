import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.6;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingRelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class yfh
  extends BaseChatPie
{
  Comparator<MessageRecord> C = new yfk(this);
  Comparator<MessageRecord> D = new yfl(this);
  private Long[] a;
  private TextView aS;
  private boolean bmi;
  private acfd c = new yfm(this);
  private wki f;
  private List<ChatMessage> jl;
  private boolean np;
  private RelativeLayout root;
  private View xs;
  
  public yfh(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void DD(int paramInt)
  {
    aavt localaavt = (aavt)a(4);
    if (localaavt != null) {
      localaavt.Ck(paramInt);
    }
  }
  
  private void a(View paramView, int paramInt, ausj paramausj)
  {
    if (paramView == null)
    {
      paramausj.dismiss();
      return;
    }
    String str = paramausj.getContent(paramInt);
    if (str == null)
    {
      paramausj.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      paramausj.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131690257)))
    {
      forward();
      anot.a(null, "dc00898", "", "", "0X800AE92", "0X800AE92", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramausj.dismiss();
      return;
      if (str.equals(paramView.getResources().getString(2131690258)))
      {
        chQ();
        anot.a(null, "dc00898", "", "", "0X800AE93", "0X800AE93", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void chQ()
  {
    if ((this.jl != null) && (this.jl.size() > 0))
    {
      ChatMessage localChatMessage = (ChatMessage)this.jl.get(0);
      ((ykc)this.app.getManager(365)).a(a(), localChatMessage, this.sessionInfo.aTn);
    }
  }
  
  private void chR()
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangLong != null) && (this.jdField_a_of_type_ArrayOfJavaLangLong.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangLong;
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        MessageRecord localMessageRecord = localObject[i];
        localMessageRecord = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, localMessageRecord.longValue());
        if (((localMessageRecord instanceof ChatMessage)) && (ykf.O(localMessageRecord))) {
          localArrayList.add((ChatMessage)localMessageRecord);
        }
        for (;;)
        {
          i += 1;
          break;
          this.bmi = true;
        }
      }
      gx(localArrayList);
      localObject = Message.obtain();
      ((Message)localObject).what = 96;
      ((Message)localObject).obj = localArrayList;
      this.uiHandler.sendMessage((Message)localObject);
    }
  }
  
  private void fA(View paramView)
  {
    paramView = ausj.d(paramView.getContext());
    paramView.addButton(2131690257);
    paramView.addButton(2131690258);
    paramView.addCancelButton(2131721058);
    paramView.a(new yfj(this, paramView));
    paramView.show();
  }
  
  private void forward()
  {
    ((yju)this.jdField_a_of_type_Wvm.a(59)).gD(this.jl);
  }
  
  private void gx(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (((ChatMessage)paramList.get(0)).istroop == 1) {
        Collections.sort(paramList, this.C);
      }
    }
    else {
      return;
    }
    Collections.sort(paramList, this.D);
  }
  
  private void parseIntent()
  {
    Intent localIntent = a().getIntent();
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_ArrayOfJavaLangLong = ((Long[])localIntent.getSerializableExtra("key_uniseq"));
      if ((this.jdField_a_of_type_ArrayOfJavaLangLong == null) || (this.jdField_a_of_type_ArrayOfJavaLangLong.length == 0)) {
        a().finish();
      }
      this.sessionInfo = new SessionInfo();
      this.sessionInfo.aTl = localIntent.getStringExtra("uin");
      this.sessionInfo.cZ = localIntent.getIntExtra("uintype", -1);
      if (this.sessionInfo.cZ != 0) {
        break label242;
      }
    }
    label242:
    for (this.sessionInfo.aTn = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);; this.sessionInfo.aTn = localIntent.getStringExtra("uinname"))
    {
      this.sessionInfo.beB = true;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.TAG, 2, "Q.aio.BaseChatPie parseIntent...sessionInfo.curFriendUin = " + this.sessionInfo.aTl + ", sessionInfo.curType = " + this.sessionInfo.cZ);
      }
      return;
      Object[] arrayOfObject = (Object[])localIntent.getSerializableExtra("key_uniseq");
      this.jdField_a_of_type_ArrayOfJavaLangLong = ((Long[])Arrays.copyOf(arrayOfObject, arrayOfObject.length, [Ljava.lang.Long.class));
      break;
    }
  }
  
  public void Ib()
  {
    this.TAG = "UpComingMsgLogic.UpComingMsgChatPie";
  }
  
  public boolean af(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "Q.aio.BaseChatPie doOnCreate...");
    }
    this.bmi = false;
    this.aSD = true;
    parseIntent();
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = (ViewGroup)this.mAIORootView.findViewById(2131362332);
    ((ViewGroup)localObject1).removeView(this.mAIORootView.findViewById(2131377546));
    Object localObject2 = this.mAIORootView.findViewById(2131362568);
    if (localObject2 != null) {
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    this.root = new UpComingRelativeLayout(a());
    this.root.setId(2131362568);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.root.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ViewGroup)localObject1).addView(this.root, 0);
    this.b = new ChatXListView(a());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.root.addView(this.b);
    this.xs = new View(this.mActivity);
    this.xs.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.mActivity.getResources().getDisplayMetrics())));
    this.b.addFooterView(this.xs);
    this.b.setStackFromBottom(false);
    this.b.setTranscriptMode(0);
    this.b.setLongClickable(true);
    this.b.setDelAnimationDuration(300L);
    this.b.setDivider(null);
    this.b.setVerticalScrollBarEnabled(false);
    this.aS = new TextView(a());
    this.aS.setText(a().getResources().getString(2131690259));
    this.aS.setTextSize(2, 16.0F);
    this.aS.setTextColor(-7829368);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.root.addView(this.aS, (ViewGroup.LayoutParams)localObject1);
    this.aS.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.mAIORootView.findViewById(2131377361));
    this.pz = ((ImageView)this.mAIORootView.findViewById(2131377362));
    this.Cr = ((TextView)this.mAIORootView.findViewById(2131369579));
    this.pp = ((ImageView)this.mAIORootView.findViewById(2131369594));
    this.ps = ((ImageView)this.mAIORootView.findViewById(2131369588));
    this.pq = ((ImageView)this.mAIORootView.findViewById(2131369967));
    this.mTitleText = ((TextView)this.mAIORootView.findViewById(2131379769));
    this.Cu = ((TextView)this.mAIORootView.findViewById(2131379857));
    this.Cu.setVisibility(8);
    this.mDensity = this.app.getApplication().getResources().getDisplayMetrics().density;
    wja.i(this.pq, 0, 0, 0, (int)(50.0F * this.mDensity + 0.5F));
    this.Cs = ((TextView)this.mAIORootView.findViewById(2131380514));
    this.cJ = ((ViewGroup)this.mAIORootView.findViewById(2131379823));
    localObject2 = this.cJ.getLayoutParams();
    int i;
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = wja.dp2px(64.0F, this.cJ.getResources());
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.Cr.setOnClickListener(this);
    this.pq.setOnClickListener(this);
    this.Cs.setOnClickListener(this);
    this.pp.setContentDescription(acfp.m(2131708574));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = new AIOAnimationConatiner(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.p(this.b);
    this.f = new wki(this.app, this.mActivity, this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    this.f.Y = Boolean.valueOf(false);
    if (this.rM == null)
    {
      this.rM = new View(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(2131299627);
      this.rM.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.rM.setId(2131362463);
      this.b.addHeaderView(this.rM, null, false);
      this.b.setOverscrollHeaderTop(i);
    }
    this.b.setAdapter(this.f);
    this.sessionInfo.a = new wkj();
    this.sessionInfo.cN = ChatTextSizeSettingActivity.ag(BaseApplicationImpl.getContext());
    if (wkj.a(BaseApplicationImpl.getContext(), this.app.getCurrentAccountUin(), this.sessionInfo.aTl, true, 7, this.sessionInfo.a)) {
      this.root.setBackgroundDrawable(this.sessionInfo.a.img);
    }
    this.ps.setVisibility(4);
    this.pp.setVisibility(4);
    this.Cr.setText(this.mActivity.getString(2131691039));
    vU(false);
    this.mTitleText.setSingleLine(false);
    this.mTitleText.setMaxLines(2);
    this.mTitleText.setTextSize(16.0F);
    this.mTitleText.setText(a().getResources().getString(2131690256));
    if (!this.aey)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851105);
      this.pz.setVisibility(8);
      this.pq.setVisibility(8);
      this.Cs.setVisibility(8);
      localObject1 = this.mContext.getResources().getColorStateList(2131167301);
      this.mTitleText.setTextColor((ColorStateList)localObject1);
      this.Cr.setVisibility(0);
      ThreadManager.post(new UpComingMsgChatPie.1(this), 8, null, true);
      localObject1 = this.pp;
      i = 2130840663;
      if (this.aey) {
        i = 2130844509;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(acfp.m(2131708573));
      ((ImageView)localObject1).setOnClickListener(new yfi(this));
      bHZ();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851106);
    this.pz.setVisibility(0);
    if (!TextUtils.isEmpty(this.Cs.getText())) {
      this.Cs.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.mContext.getResources().getColorStateList(2131167302);
      this.mTitleText.setTextColor((ColorStateList)localObject1);
      this.Cr.setVisibility(8);
      break;
      this.Cs.setVisibility(4);
    }
  }
  
  public void bHZ()
  {
    if (this.app == null) {
      return;
    }
    this.app.addObserver(this.c);
  }
  
  public void bIa()
  {
    if (this.app == null) {
      return;
    }
    this.app.removeObserver(this.c);
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "Q.aio.BaseChatPie doOnDestroy...");
    }
    this.bEu = 9;
    DD(12);
    this.rK = null;
    this.rL = null;
    this.Hy = 0;
    this.bEz = 0;
    this.f.destroy();
    if (this.jl != null) {
      this.jl.clear();
    }
    bIa();
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "Q.aio.BaseChatPie doOnPause...");
    }
    BaseChatItemLayout.bdx = this.np;
    AbstractGifImage.pauseAll();
    this.bEu = 5;
    DD(9);
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "Q.aio.BaseChatPie doOnResume...");
    }
    this.np = BaseChatItemLayout.bdx;
    BaseChatItemLayout.bdx = false;
    if (this.aSD)
    {
      this.b.postDelayed(new UpComingMsgChatPie.6(this), 600L);
      this.aSD = false;
    }
    for (;;)
    {
      AbstractGifImage.resumeAll();
      this.bEu = 4;
      DD(5);
      return;
      this.f.notifyDataSetChanged();
    }
  }
  
  public void doOnStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "Q.aio.BaseChatPie doOnStart...");
    }
    this.bEu = 3;
  }
  
  public void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "Q.aio.BaseChatPie doOnStop...");
    }
    this.bEu = 6;
    DD(10);
  }
  
  public void ey(View paramView)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleScrollOutScreen , view = ");
      if (paramView == null)
      {
        str = "null";
        QLog.i("Q.aio.BaseChatPie", 2, str);
      }
    }
    else
    {
      if (paramView != null) {
        break label56;
      }
    }
    label56:
    do
    {
      do
      {
        return;
        str = paramView.toString();
        break;
        paramView = wja.a(paramView);
      } while (!(paramView instanceof xov.a));
      paramView = (xov.a)paramView;
    } while (paramView.a == null);
    paramView.a.detach();
  }
  
  public boolean fV(int paramInt)
  {
    this.bEu = 8;
    return false;
  }
  
  public void finish()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label231:
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if ((paramMessage.obj instanceof List))
      {
        List localList = (List)paramMessage.obj;
        this.jl = localList;
        if (this.jl.size() <= 0)
        {
          this.b.setVisibility(8);
          this.aS.setVisibility(0);
          this.pp.setVisibility(8);
          anot.a(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 1, 0, "", "", "", "");
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label231;
          }
          QLog.d(this.TAG, 2, "Q.aio.BaseChatPie upComing. dataList.size = " + this.jl.size());
          break;
          if (this.bmi)
          {
            QQToast.a(a(), 0, 2131690260, 3000).show();
            anot.a(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 2, 0, "", "", "", "");
          }
          this.pp.setVisibility(0);
          this.f.a(localList, null);
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    aavt localaavt = (aavt)a(4);
    return (localaavt != null) && (localaavt.XE());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.Hy < paramInt1) {
      ey(this.rK);
    }
    for (;;)
    {
      this.Hy = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.bEz = (paramInt1 + paramInt2 - 1);
      }
      this.rK = paramAbsListView.getChildAt(0);
      this.rL = paramAbsListView.getChildAt(paramInt2 - 1);
      return;
      if ((paramInt1 + paramInt2 - 1 < this.bEz) && (paramInt1 + paramInt2 - 1 > 0)) {
        ey(this.rL);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      DD(16);
      return;
    }
    DD(14);
  }
  
  public void zZ(int paramInt)
  {
    anot.a(null, "dc00898", "", "", "0X800AE91", "0X800AE91", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfh
 * JD-Core Version:    0.7.0.1
 */