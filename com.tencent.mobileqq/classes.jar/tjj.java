import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.msg.TroopReceiptMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class tjj
  extends XBaseAdapter
{
  CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public tjj(QQLSActivity paramQQLSActivity) {}
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (!(paramViewGroup instanceof tjn)) {}
    }
    for (paramViewGroup = (tjn)paramViewGroup;; paramViewGroup = null)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130970410, null);
        localObject = new tjn();
        ((tjn)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370422));
        ((tjn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131370426));
        ((tjn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((tjn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
        paramView.setTag(localObject);
      }
      ((tjn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      ((tjn)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.b);
      ((tjn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      CustomWidgetUtil.a(((tjn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, 1, 0);
      return paramView;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
    paramViewGroup = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a(), ((MessageRecord)localObject1).uniseq);
    if (((RecentBaseData)localObject3).a() == 1032) {
      paramViewGroup = ConfessMsgUtil.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageRecord)localObject1);
    }
    if (paramView != null)
    {
      localObject1 = paramView;
      if ((paramView.getTag() instanceof tjk)) {}
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130970411, null);
      paramView = new tjk();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370422));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370423));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131370426));
      ((View)localObject1).setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131361999));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131362000));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)((View)localObject1).findViewById(2131362002));
    }
    tjk localtjk = (tjk)((View)localObject1).getTag();
    localtjk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    int i = 0;
    if ((((RecentBaseData)localObject3).a().equals(AppConstants.ac)) || (((RecentBaseData)localObject3).a().equals(AppConstants.ad))) {
      i = 1;
    }
    int j;
    if (i != 0)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label398:
      label464:
      Object localObject2;
      if ((((RecentBaseData)localObject3).a() == 0) || (((RecentBaseData)localObject3).a() == 3000) || (((RecentBaseData)localObject3).a() == 8)) {
        if (j > 0)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
          if ((paramView == null) || (paramView.size() <= 0))
          {
            this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).jdField_c_of_type_JavaLangCharSequence;
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
            }
            localtjk.jdField_a_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject3).b);
            localtjk.jdField_b_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject3).jdField_c_of_type_JavaLangString);
            if (((RecentBaseData)localObject3).a() == 4000) {
              i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.d();
            }
            if (i + j != 0) {
              break label1536;
            }
            localtjk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
            if ((((RecentBaseData)localObject3).a().equals(AppConstants.ad)) || (((RecentBaseData)localObject3).a().equals(AppConstants.ac))) {
              localtjk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
            }
            paramView = new BaseChatItemLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
            paramView.setId(2131361996);
            paramView.setFocusableInTouchMode(true);
            paramView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
            localtjk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
            if ((paramViewGroup instanceof MessageForPtt))
            {
              localObject2 = (MessageForPtt)paramViewGroup;
              paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramViewGroup);
              ((TextView)((View)localObject1).findViewById(2131370438)).setText(paramView);
              localObject3 = (ViewGroup.MarginLayoutParams)localtjk.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
              if (paramView.equals("")) {
                break label1563;
              }
              ((ViewGroup.MarginLayoutParams)localObject3).setMargins(AIOUtils.a(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), AIOUtils.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
              j = PttItemBuilder.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageForPtt)localObject2);
              i = j;
              if (j == -1)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localtjk, (MessageForPtt)localObject2, false, true);
                i = 2001;
              }
              if (QLog.isColorLevel()) {
                QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + ((MessageForPtt)localObject2).url + " uniseq " + ((MessageForPtt)localObject2).uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localtjk, (MessageForPtt)localObject2, i, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a((ChatMessage)localObject2));
              PttInfoCollector.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), i, paramViewGroup);
              FileTransferManager.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
              if ((QQLSActivity.b()) && (localtjk.jdField_a_of_type_JavaLangStringBuilder == null)) {
                localtjk.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
              }
              localtjk.jdField_b_of_type_Int = paramInt;
              localtjk.jdField_c_of_type_Int = paramInt;
              if (QQLSActivity.b())
              {
                localtjk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
                if (!TextUtils.isEmpty(localtjk.jdField_a_of_type_JavaLangStringBuilder)) {
                  localtjk.jdField_a_of_type_JavaLangStringBuilder.replace(0, localtjk.jdField_a_of_type_JavaLangStringBuilder.length(), "");
                }
                if ((!((ChatMessage)paramViewGroup).mNeedTimeStamp) || (paramViewGroup.time <= 0L)) {}
              }
            }
          }
        }
      }
      try
      {
        paramView = TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, 3, paramViewGroup.time * 1000L);
        localtjk.jdField_a_of_type_JavaLangStringBuilder.append(paramView).append(" ");
        localtjk.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)paramViewGroup);
        PTTPreDownloader.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).b((MessageForPtt)localObject2);
        return localObject1;
        i = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
        j = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + paramView.size());
        }
        localObject2 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
        long l1 = ((RecentBaseData)localObject3).a();
        long l2 = ((MessageRecord)paramView.get(paramView.size() - 1)).time;
        if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject2).msgtype != -2016) && (((MessageRecord)localObject2).msgtype != -2009) && (((MessageRecord)localObject2).msgtype != -2026))
        {
          this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).jdField_c_of_type_JavaLangCharSequence;
          break label398;
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)paramView.get(paramView.size() - 1)).msg;
        break label398;
        this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).jdField_c_of_type_JavaLangCharSequence;
        break label398;
        if ((((RecentBaseData)localObject3).a() == 1001) || (((RecentBaseData)localObject3).a() == 1010) || (((RecentBaseData)localObject3).a() == 10002))
        {
          if (((RecentBaseData)localObject3).a().equals(AppConstants.ad))
          {
            ((RecentBaseData)localObject3).b = BaseApplicationImpl.getApplication().getString(2131437976);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131437977);
            paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
            if (paramView.length() <= 0) {
              break label398;
            }
            paramView = paramView.split("\\|");
            if (paramView.length < 6) {
              break label398;
            }
            ((RecentBaseData)localObject3).b = paramView[4];
            this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
            break label398;
          }
          if (((RecentBaseData)localObject3).a().equals(AppConstants.ac))
          {
            ((RecentBaseData)localObject3).b = BaseApplicationImpl.getApplication().getString(2131437978);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131437979);
            paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
            if (paramView.length() <= 0) {
              break label398;
            }
            paramView = paramView.split("\\|");
            if (paramView.length < 6) {
              break label398;
            }
            ((RecentBaseData)localObject3).b = paramView[4];
            this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
            break label398;
          }
          QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
          localObject2 = ContactUtils.q(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
          paramView = (View)localObject2;
          if (localObject2 == null) {
            paramView = "";
          }
          this.jdField_a_of_type_JavaLangCharSequence = (paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
          break label398;
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).jdField_c_of_type_JavaLangCharSequence;
        break label398;
        label1536:
        localtjk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
        CustomWidgetUtil.a(localtjk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, j + i, 0);
        break label464;
        label1563:
        ((ViewGroup.MarginLayoutParams)localObject3).setMargins(0, AIOUtils.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView = "";
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((List)paramArrayList.clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      if ((localRecentBaseData.a() == 1012) || (localRecentBaseData.a() == 7432) || (localRecentBaseData.a() == 1030)) {
        return 1;
      }
      if ((localMessage != null) && ((localMessage.msgtype == -2002) || (localMessage.msgtype == -1031))) {
        return 2;
      }
      if ((localMessage != null) && (localMessage.msgtype == -2025)) {
        return 3;
      }
      if (localRecentBaseData.a() == 9653) {
        return 4;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int k = getItemViewType(paramInt);
    if ((k == 1) || (k == 4))
    {
      paramView = b(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    if (k == 2) {
      return a(paramInt, paramView, paramViewGroup);
    }
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if ((paramView.getTag() instanceof tjm)) {}
    }
    else
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130970409, null);
      paramView = new tjm();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370422));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370440));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370423));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131370426));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131370439));
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    }
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    tjm localtjm = (tjm)paramViewGroup.getTag();
    localtjm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    paramInt = 0;
    int j = 0;
    if ((localRecentBaseData.a().equals(AppConstants.ac)) || (localRecentBaseData.a().equals(AppConstants.ad))) {
      paramInt = 1;
    }
    int i;
    if (paramInt != 0)
    {
      i = 0;
      paramInt = j;
      label259:
      if (k == 3)
      {
        paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
        if (paramView != null) {
          localRecentBaseData.jdField_c_of_type_JavaLangCharSequence = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramView, false);
        }
      }
      if ((localRecentBaseData.a() != 0) && (localRecentBaseData.a() != 3000) && (localRecentBaseData.a() != 8)) {
        break label1076;
      }
      if (i <= 0) {
        break label1019;
      }
      localtjm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.a(), localRecentBaseData.a());
      if ((paramView != null) && (paramView.size() > 0)) {
        break label804;
      }
      this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_c_of_type_JavaLangCharSequence;
      localtjm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
      }
      label425:
      localtjm.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.jdField_c_of_type_JavaLangString);
    }
    label490:
    label503:
    Object localObject;
    for (;;)
    {
      if ((localRecentBaseData.a() == 8) && (localRecentBaseData.g == 25))
      {
        paramView = (PhoneContactManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(10);
        if (paramView == null) {
          break label1839;
        }
        paramView = paramView.c(localRecentBaseData.f);
        if (paramView == null) {
          break label1768;
        }
        localRecentBaseData.b = paramView.name;
        if (localRecentBaseData.b.equals(localRecentBaseData.a())) {
          localRecentBaseData.b = localRecentBaseData.f;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, "getView mTitleName = " + localRecentBaseData.b);
        }
      }
      localtjm.jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.b);
      localtjm.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_JavaLangCharSequence, 5, 16, localRecentBaseData.a()));
      localtjm.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.jdField_c_of_type_JavaLangString);
      if (localRecentBaseData.a() != 4000) {
        break label1836;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.d();
      label640:
      if ((!TextUtils.equals(localRecentBaseData.a(), AppConstants.as)) || (localRecentBaseData.a() != 7220))
      {
        j = paramInt;
        if (TextUtils.equals(localRecentBaseData.a(), AppConstants.ar))
        {
          j = paramInt;
          if (localRecentBaseData.a() != 1008) {}
        }
      }
      else
      {
        j = 1;
      }
      if (j + i != 0) {
        break label1809;
      }
      localtjm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      label716:
      if (!localRecentBaseData.a().equals(AppConstants.ad))
      {
        paramView = paramViewGroup;
        if (!localRecentBaseData.a().equals(AppConstants.ac)) {
          break;
        }
      }
      localtjm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      return paramViewGroup;
      paramInt = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.a(), localRecentBaseData.a());
      break label259;
      label804:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + paramView.size());
      }
      localObject = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      long l1 = localRecentBaseData.a();
      long l2 = ((MessageRecord)paramView.get(paramView.size() - 1)).time;
      if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject).msgtype != -2016) && (((MessageRecord)localObject).msgtype != -2009) && (((MessageRecord)localObject).msgtype != -2026) && (localRecentBaseData.a() != 8))
      {
        this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_c_of_type_JavaLangCharSequence;
        localtjm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        break label425;
      }
      this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)paramView.get(paramView.size() - 1)).msg;
      localtjm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-570319);
      break label425;
      label1019:
      localtjm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_JavaLangCharSequence = ((String)localRecentBaseData.d + localRecentBaseData.jdField_c_of_type_JavaLangCharSequence);
      localtjm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
    }
    label1076:
    if ((localRecentBaseData.a() == 1001) || (localRecentBaseData.a() == 1010) || (localRecentBaseData.a() == 10002))
    {
      if (localRecentBaseData.a().equals(AppConstants.ad))
      {
        localRecentBaseData.b = BaseApplicationImpl.getApplication().getString(2131437976);
        this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131437977);
        paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
        if (paramView.length() > 0)
        {
          paramView = paramView.split("\\|");
          if (paramView.length >= 6)
          {
            localRecentBaseData.b = paramView[4];
            this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
          }
        }
      }
      for (;;)
      {
        localtjm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        localtjm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (localRecentBaseData.a().equals(AppConstants.ac))
        {
          localRecentBaseData.b = BaseApplicationImpl.getApplication().getString(2131437978);
          this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131437979);
          paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
          if (paramView.length() > 0)
          {
            paramView = paramView.split("\\|");
            if (paramView.length >= 6)
            {
              localRecentBaseData.b = paramView[4];
              this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
            }
          }
        }
        else
        {
          QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
          if (localMessage.msgtype == -2053)
          {
            paramView = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
            paramView.msgData = localMessage.msgData;
            paramView.parse();
            localObject = paramView.nickName;
            this.jdField_a_of_type_JavaLangCharSequence = (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getString(2131437862) + (String)localObject + paramView.msg);
          }
          else
          {
            localObject = ContactUtils.q(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
            paramView = (View)localObject;
            if (localObject == null) {
              paramView = "";
            }
            this.jdField_a_of_type_JavaLangCharSequence = (paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
          }
        }
      }
    }
    if (localRecentBaseData.a() == 1)
    {
      paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(paramView.frienduin, paramView.istroop, paramView.uniseq);
      if ((!(paramView instanceof MessageForPubAccount)) || (((MessageForPubAccount)paramView).isTextMsg())) {}
    }
    for (paramView = PublicAccountConfigUtil.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), BaseApplicationImpl.getContext()) + ":";; paramView = "")
    {
      this.jdField_a_of_type_JavaLangCharSequence = (paramView + localRecentBaseData.jdField_c_of_type_JavaLangCharSequence);
      if (localRecentBaseData.a() == 7220)
      {
        paramView = ((KandianMergeManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(161)).b();
        if (paramView != null) {
          this.jdField_a_of_type_JavaLangCharSequence = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramView, false);
        }
      }
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) && ((localRecentBaseData instanceof RecentItemTroopMsgData)))
      {
        paramView = ((RecentItemTroopMsgData)localRecentBaseData).a().msg;
        if ((paramView instanceof TroopReceiptMsg)) {
          this.jdField_a_of_type_JavaLangCharSequence = ((TroopReceiptMsg)paramView).a;
        }
      }
      localtjm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      localtjm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1768:
      paramView = ((QCallCardManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(139)).a(localRecentBaseData.a());
      if (paramView == null) {
        break label503;
      }
      localRecentBaseData.b = paramView.nickname;
      break label503;
      label1809:
      localtjm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      CustomWidgetUtil.a(localtjm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, j + i, 0);
      break label716;
      label1836:
      break label640;
      label1839:
      paramView = null;
      break label490;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tjj
 * JD-Core Version:    0.7.0.1
 */