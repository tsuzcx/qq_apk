import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.e;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.h;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class zih
  implements View.OnClickListener
{
  public zih(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "mOnKickOutBtnClickListener onclick");
      }
      int j = paramView.getId();
      Object localObject1 = (String)paramView.getTag();
      boolean bool1 = ((String)localObject1).equals(this.this$0.aPW);
      int i;
      if ((this.this$0.aPX != null) && (this.this$0.aPX.contains((CharSequence)localObject1)))
      {
        i = 1;
        label100:
        boolean bool4 = this.this$0.app.getCurrentAccountUin().equals(this.this$0.aPW);
        if (((!bool4) || (((String)localObject1).equals(this.this$0.app.getCurrentAccountUin()))) && ((bool4) || (bool1) || (i != 0))) {
          break label314;
        }
        i = 1;
      }
      Object localObject2;
      for (;;)
      {
        if (j == 2131365684)
        {
          localObject2 = paramView.findViewById(2131365685);
          bool1 = bool2;
          if (((View)localObject2).getTag() != null)
          {
            bool1 = bool2;
            if ((((View)localObject2).getTag() instanceof Boolean)) {
              bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
            }
          }
          localObject2 = this.this$0.a((String)localObject1, bool1);
          if (this.this$0.mFrom == 20)
          {
            if (localObject2 == null) {
              break;
            }
            localObject1 = ((ChatHistoryTroopMemberFragment.h)localObject2).b.getTag();
            if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
              break;
            }
            i = ((Integer)localObject1).intValue();
            if (i < 0) {
              break;
            }
            localObject1 = (ChatHistoryTroopMemberFragment.a)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.getItem(i);
            this.this$0.a((ChatHistoryTroopMemberFragment.a)localObject1);
            break;
            i = 0;
            break label100;
            label314:
            i = 0;
            continue;
          }
          if (this.this$0.bbo)
          {
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.ru.contains(localObject1)) {
              this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.ru.remove(localObject1);
            }
            for (;;)
            {
              ChatHistoryTroopMemberFragment.a(this.this$0);
              this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.notifyDataSetChanged();
              break;
              if (i != 0) {
                this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.ru.add(localObject1);
              }
            }
          }
          if (bool1)
          {
            if (this.this$0.aRa.equals(localObject1)) {
              break;
            }
            if (localObject2 != null) {
              ((ChatHistoryTroopMemberFragment.h)localObject2).b.TR(true);
            }
            if (!TextUtils.isEmpty(this.this$0.aRa))
            {
              localObject2 = this.this$0.a(this.this$0.aRa, bool1);
              if (localObject2 != null) {
                ((ChatHistoryTroopMemberFragment.h)localObject2).b.TS(true);
              }
            }
            this.this$0.aRa = ((String)localObject1);
            break;
          }
          if (this.this$0.aQZ.equals(localObject1)) {
            break;
          }
          if (localObject2 != null) {
            ((ChatHistoryTroopMemberFragment.h)localObject2).b.TR(true);
          }
          if (!TextUtils.isEmpty(this.this$0.aQZ))
          {
            localObject2 = this.this$0.a(this.this$0.aQZ, bool1);
            if (localObject2 != null) {
              ((ChatHistoryTroopMemberFragment.h)localObject2).b.TS(true);
            }
          }
          this.this$0.aQZ = ((String)localObject1);
          break;
        }
      }
      if (j == 2131378486)
      {
        localObject2 = paramView.findViewById(2131380801);
        bool1 = bool3;
        if (((View)localObject2).getTag() != null)
        {
          bool1 = bool3;
          if ((((View)localObject2).getTag() instanceof Boolean)) {
            bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
          }
        }
        if (this.this$0.bbo)
        {
          if (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.ru.contains(localObject1)) {
            break label767;
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.ru.remove(localObject1);
        }
        for (;;)
        {
          ChatHistoryTroopMemberFragment.a(this.this$0);
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.notifyDataSetChanged();
          if (!bool1) {
            break label792;
          }
          localObject1 = this.this$0.a(this.this$0.aRa, bool1);
          if (localObject1 != null)
          {
            ((ChatHistoryTroopMemberFragment.h)localObject1).b.TS(true);
            this.this$0.aRa = "";
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$e.notifyDataSetChanged();
          break;
          label767:
          if (i != 0) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.ru.add(localObject1);
          }
        }
        label792:
        localObject1 = this.this$0.a(this.this$0.aQZ, bool1);
        if (localObject1 != null)
        {
          ((ChatHistoryTroopMemberFragment.h)localObject1).b.TS(true);
          this.this$0.aQZ = "";
        }
      }
      else if ((j == 2131363898) && (this.this$0.bbn))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "delBtn onClick, uin=" + (String)localObject1);
        }
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          if (this.this$0.getActivity().isResume()) {
            QQToast.a(this.this$0.getActivity(), this.this$0.getString(2131696272), 0).show(this.this$0.getActivity().getTitleBarHeight());
          }
        }
        else if (this.this$0.mFrom == 1)
        {
          this.this$0.wO((String)localObject1);
        }
        else if (this.this$0.mFrom == 13)
        {
          localObject2 = this.this$0.a((String)localObject1);
          this.this$0.pM.add(localObject1);
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.bSJ();
          if (this.this$0.W.isShowing())
          {
            if (localObject2 != null) {
              this.this$0.mSearchResultList.remove(localObject2);
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$e.notifyDataSetChanged();
          }
        }
        else if (this.this$0.mFrom == 21)
        {
          localObject2 = this.this$0.a((String)localObject1);
          this.this$0.pM.add(localObject1);
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.bSJ();
          if (this.this$0.W.isShowing())
          {
            if (localObject2 != null) {
              this.this$0.mSearchResultList.remove(localObject2);
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$e.notifyDataSetChanged();
          }
        }
        else
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(Long.valueOf(Long.parseLong((String)localObject1)));
          ChatHistoryTroopMemberFragment.a(this.this$0, (List)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zih
 * JD-Core Version:    0.7.0.1
 */