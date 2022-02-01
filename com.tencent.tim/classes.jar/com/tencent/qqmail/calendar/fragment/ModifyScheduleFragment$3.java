package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import org.apache.commons.lang3.StringUtils;

class ModifyScheduleFragment$3
  implements View.OnClickListener
{
  ModifyScheduleFragment$3(ModifyScheduleFragment paramModifyScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    if (ModifyScheduleFragment.access$400(this.this$0) != null)
    {
      localObject2 = ModifyScheduleFragment.access$400(this.this$0).getText().toString();
      localObject1 = localObject2;
      if (StringUtils.isBlank((CharSequence)localObject2)) {
        localObject1 = this.this$0.getString(2131691066);
      }
      ModifyScheduleFragment.access$100(this.this$0).setSubject((String)localObject1);
    }
    if (ModifyScheduleFragment.access$500(this.this$0) != null) {
      ModifyScheduleFragment.access$100(this.this$0).setLocation(ModifyScheduleFragment.access$500(this.this$0).getText().toString());
    }
    if (ModifyScheduleFragment.access$600(this.this$0) != null) {
      ModifyScheduleFragment.access$100(this.this$0).setBody(ModifyScheduleFragment.access$600(this.this$0).getText().toString());
    }
    Object localObject1 = new ModifyScheduleFragment.Solution(this.this$0);
    ((ModifyScheduleFragment.Solution)localObject1).setAction(ModifyScheduleFragment.access$300(this.this$0));
    Object localObject2 = new EventChecker.EventTimeChecker(this.this$0.getActivity());
    EventChecker.EventRecurrentChecker localEventRecurrentChecker = new EventChecker.EventRecurrentChecker(this.this$0.getActivity(), ModifyScheduleFragment.access$000(this.this$0));
    EventChecker.EventFolderChecker localEventFolderChecker = new EventChecker.EventFolderChecker(this.this$0.getActivity());
    EventChecker.EventProtocolChecker localEventProtocolChecker = new EventChecker.EventProtocolChecker(this.this$0.getActivity());
    new EventChecker.EventNoActionChecker(this.this$0.getActivity());
    if (ModifyScheduleFragment.access$300(this.this$0) == 1)
    {
      ((EventChecker.EventTimeChecker)localObject2).addNextChecker(localEventProtocolChecker).addNextChecker(localEventFolderChecker);
      ((EventChecker)localObject2).validateEventData(ModifyScheduleFragment.access$700(this.this$0), ModifyScheduleFragment.access$100(this.this$0), this.this$0, (ModifyScheduleFragment.Solution)localObject1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((ModifyScheduleFragment.access$300(this.this$0) == 2) && (ModifyScheduleFragment.access$700(this.this$0).isDiffer(ModifyScheduleFragment.access$100(this.this$0))))
      {
        ((EventChecker.EventTimeChecker)localObject2).addNextChecker(localEventRecurrentChecker).addNextChecker(localEventProtocolChecker).addNextChecker(localEventFolderChecker);
        ((ModifyScheduleFragment.Solution)localObject1).setModifyType(0);
        break;
      }
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment.3
 * JD-Core Version:    0.7.0.1
 */