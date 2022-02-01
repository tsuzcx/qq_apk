package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecTroopBusinessItem;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.RecommendTroopMsg;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.util.WeakReferenceHandler;
import efx;
import efy;
import efz;
import egb;
import egc;
import egd;
import ege;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RecommendTroopView
  extends BaseTroopView
  implements View.OnClickListener, SlideDetectListView.OnSlideListener, Observer
{
  static final int b = 104;
  public static final int c = 105;
  private static final int d = 3;
  private static final int e = 4;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new efx(this);
  public RecommendTroopInfo a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public SlideDetectListView a;
  public ege a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  public RelativeLayout b;
  public boolean c = false;
  protected boolean d = true;
  protected boolean e = false;
  private boolean f = false;
  
  public RecommendTroopView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopInfo = null;
  }
  
  private void a(RecTroopBusinessItem paramRecTroopBusinessItem)
  {
    if (paramRecTroopBusinessItem.jumpType == 3) {
      TroopQQBrowserHelper.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    do
    {
      return;
      if (paramRecTroopBusinessItem.jumpType == 2)
      {
        paramRecTroopBusinessItem = new Intent(a(), NearbyTroopsLocationActivity.class);
        paramRecTroopBusinessItem.putExtra("lat", 0);
        paramRecTroopBusinessItem.putExtra("lon", 0);
        paramRecTroopBusinessItem.putExtra("mode", 0);
        a(paramRecTroopBusinessItem);
        return;
      }
    } while (paramRecTroopBusinessItem.jumpType != 1);
    TroopQQBrowserHelper.b(a(), paramRecTroopBusinessItem.jumpUrl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private void a(RecommendTroopInfo paramRecommendTroopInfo, String paramString1, String paramString2)
  {
    if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramRecommendTroopInfo.uin) != null)
    {
      b(2131563234);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString2 = paramRecommendTroopInfo.uin;
      if (!this.e) {
        break label218;
      }
    }
    label218:
    for (paramRecommendTroopInfo = "0";; paramRecommendTroopInfo = "1")
    {
      ReportController.b(paramString1, "P_CliOper", "", "", "Grp_recommend", "Direct_joingrp", 0, 0, paramString2, paramRecommendTroopInfo, "", "");
      return;
      if (paramRecommendTroopInfo.option == 3)
      {
        b(2131563078);
        break;
      }
      Intent localIntent = new Intent(a(), AddFriendLogicActivity.class);
      localIntent.putExtra("uin", paramRecommendTroopInfo.uin);
      localIntent.putExtra("troop_code", paramRecommendTroopInfo.uin);
      localIntent.putExtra("name", paramRecommendTroopInfo.name);
      localIntent.putExtra("group_option", paramRecommendTroopInfo.option);
      localIntent.putExtra("type", 1);
      localIntent.putExtra("param_last_activity_name", getResources().getString(2131558946));
      localIntent.putExtra("stat_option", 3017);
      localIntent.putExtra("join_group_question", paramString1);
      localIntent.putExtra("join_group_answer", paramString2);
      b(localIntent, 3);
      break;
    }
  }
  
  private void a(RecommendTroopInfo paramRecommendTroopInfo, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if (paramRecommendTroopInfo != null)
    {
      localObject = TroopUtils.a(1, paramRecommendTroopInfo, 3017);
      TroopUtils.a(a(), (Bundle)localObject, 2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = paramRecommendTroopInfo.uin;
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (paramRecommendTroopInfo = "0";; paramRecommendTroopInfo = "1")
    {
      ReportController.b((QQAppInterface)localObject, "P_CliOper", "", "", "Grp_recommend", "view_grpinfor", 0, 0, str, paramRecommendTroopInfo, "", "");
      return;
    }
  }
  
  private void a(List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject1 = (RecommendTroopMsg)paramList.get(i);
      if (((RecommendTroopMsg)localObject1).isTroop())
      {
        RecommendTroopInfo localRecommendTroopInfo = ((RecommendTroopMsg)localObject1).troop;
        if ((!localRecommendTroopInfo.isSameCity) && (TextUtils.isEmpty(localRecommendTroopInfo.location)) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localRecommendTroopInfo.uin)))
        {
          String str = String.valueOf(localRecommendTroopInfo.classId);
          Object localObject2 = GroupCatalogTool.a(a()).a();
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (str.equals(((GroupCatalogBean)localObject2).b)) {}
          }
          else
          {
            localObject1 = GroupCatalogTool.a(a()).a(a(), str);
          }
          if (localObject1 != null)
          {
            localObject1 = ((GroupCatalogBean)localObject1).a();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.jdField_a_of_type_JavaUtilHashMap.put(localRecommendTroopInfo.uin, localObject1);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().obtainMessage();
              ((Message)localObject2).arg1 = Integer.valueOf(localRecommendTroopInfo.uin).intValue();
              ((Message)localObject2).obj = localObject1;
              ((Message)localObject2).what = 104;
              this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().sendMessage((Message)localObject2);
            }
          }
        }
      }
      i += 1;
    }
  }
  
  private boolean c()
  {
    a(2130903443);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232605));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232608));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131232606));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232607));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232610));
    this.jdField_a_of_type_Ege = new ege(this, a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    return true;
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new efy(this));
  }
  
  private void n()
  {
    if (((RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19) != null) && (!this.jdField_b_of_type_Boolean) && (RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
    {
      a(1, true);
      return;
    }
    a(1, false);
  }
  
  public void a()
  {
    if (this.f) {
      return;
    }
    this.f = true;
    Object localObject = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
    if (localObject != null) {}
    for (localObject = ((RecommendTroopManagerImp)localObject).a();; localObject = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new efz(this, (List)localObject));
      this.f = false;
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 3) || (paramInt1 == 4)) {
      m();
    }
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(RecommendTroopView.class, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if ((paramSlideDetectListView != this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_Ege.getCount())) {}
    do
    {
      return;
      this.jdField_a_of_type_Ege.a = paramInt;
      View localView = paramView.findViewById(2131232313);
      if (localView != null)
      {
        Button localButton = (Button)localView.findViewById(2131232457);
        localButton.setTag(Integer.valueOf(paramInt));
        localButton.setOnClickListener(this);
        ((ShaderAnimLayout)localView).a();
        paramSlideDetectListView.setDeleteAreaWidth(localView.getLayoutParams().width);
      }
      paramSlideDetectListView = paramView.findViewById(2131232455);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setVisibility(4);
      }
      paramSlideDetectListView = paramView.findViewById(2131232456);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setVisibility(4);
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)) && (this.jdField_a_of_type_Ege != null))
      {
        this.jdField_a_of_type_Ege.a(String.valueOf(paramMessage.arg1), String.valueOf(paramMessage.obj));
        continue;
        a();
      }
    }
  }
  
  public void b()
  {
    super.b();
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
    int i = RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ag, 9000, 0 - i);
    if ((this.d) || (RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0))
    {
      this.d = false;
      a();
    }
    localRecommendTroopManagerImp.a();
    n();
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    Object localObject;
    if (paramSlideDetectListView == this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView)
    {
      this.jdField_a_of_type_Ege.a = paramInt;
      this.jdField_a_of_type_Ege.a = -1;
      paramSlideDetectListView = paramView.findViewById(2131232313);
      if (paramSlideDetectListView != null)
      {
        ((ShaderAnimLayout)paramSlideDetectListView).d();
        paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131232457);
        paramSlideDetectListView.setTag(null);
        paramSlideDetectListView.setOnClickListener(null);
      }
      paramSlideDetectListView = paramView.findViewById(2131232455);
      paramView = paramView.findViewById(2131232456);
      localObject = this.jdField_a_of_type_Ege.a(paramInt);
      if (!((RecommendTroopMsg)localObject).isTroop()) {
        break label186;
      }
      localObject = ((RecommendTroopMsg)localObject).troop;
      localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localFriendManager != null)
      {
        if (localFriendManager.a(String.valueOf(((RecommendTroopInfo)localObject).uin)) == null) {
          break label164;
        }
        if (paramView == null) {}
      }
    }
    label164:
    label186:
    while ((!((RecommendTroopMsg)localObject).isBusiness()) || (paramSlideDetectListView == null))
    {
      FriendManager localFriendManager;
      paramView.postDelayed(new egb(this, paramView), 300L);
      do
      {
        return;
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.postDelayed(new egc(this, paramSlideDetectListView), 300L);
      return;
    }
    paramSlideDetectListView.postDelayed(new egd(this, paramSlideDetectListView), 300L);
  }
  
  protected void e()
  {
    super.e();
    a();
  }
  
  protected void g()
  {
    super.g();
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
    if (localRecommendTroopManagerImp != null) {
      localRecommendTroopManagerImp.a();
    }
  }
  
  protected void h()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    GroupCatalogTool.a(a()).a();
    if (this.jdField_a_of_type_Ege != null) {
      this.jdField_a_of_type_Ege.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
  }
  
  public void k()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), this.jdField_a_of_type_AndroidViewView.getHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562645);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      RecommendTroopManagerImp.a(localException.toString());
    }
  }
  
  public void l()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      RecommendTroopManagerImp.a(localException.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = (RecommendTroopMsg)paramView.getTag();
          } while (paramView == null);
          if (!paramView.isTroop()) {
            break;
          }
          if (!NetworkUtil.e(a()))
          {
            b(2131562451);
            return;
          }
          localObject1 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
        } while (localObject1 == null);
        try
        {
          long l = Long.parseLong(paramView.troop.uin);
          k();
          this.e = paramView.isRead;
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopInfo = paramView.troop;
          ((TroopHandler)localObject1).a(l, 8388736);
          return;
        }
        catch (Exception paramView)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopInfo = null;
          return;
        }
      } while (!paramView.isBusiness());
      a(paramView.rtbItem);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "recommend_more", 0, 0, "", "", "", "");
      return;
      TroopQQBrowserHelper.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
      this.jdField_a_of_type_Ege.a = -1;
      paramView = (Button)paramView;
    } while (paramView.getTag() == null);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.jdField_a_of_type_Ege.a(i);
    Object localObject2;
    if (paramView != null)
    {
      localObject1 = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
      if (localObject1 != null)
      {
        if (!paramView.isTroop()) {
          break label343;
        }
        localObject2 = paramView.troop;
        ((RecommendTroopManagerImp)localObject1).a(((RecommendTroopInfo)localObject2).uin, paramView.uniseq, paramView.msgtype);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Grp_recom_dltgrp", 0, 0, ((RecommendTroopInfo)localObject2).code, "", "", "");
      }
    }
    for (;;)
    {
      m();
      return;
      label343:
      if (paramView.isBusiness())
      {
        localObject2 = paramView.rtbItem;
        ((RecommendTroopManagerImp)localObject1).a(paramView.uniseq, paramView.msgtype);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Delete_grp_recommend", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = String.valueOf(AppConstants.ag);
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if ((paramObservable.equals(paramObject.frienduin)) && ((paramObject.msgtype == -1039) || (paramObject.msgtype == -1040))) {
        m();
      }
    }
    while ((!(paramObject instanceof RecentUser)) || (!paramObservable.equals(((RecentUser)paramObject).uin))) {
      return;
    }
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.RecommendTroopView
 * JD-Core Version:    0.7.0.1
 */