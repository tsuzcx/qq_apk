package com.tencent.qqmail.activity.contacts.view;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

class ContactEditBirthdayItemView$1
  implements View.OnClickListener
{
  ContactEditBirthdayItemView$1(ContactEditBirthdayItemView paramContactEditBirthdayItemView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = this.this$0.getNodeInputText().split("-");
    int m = ((Calendar)localObject1).get(1);
    int i = ((Calendar)localObject1).get(2);
    int j = ((Calendar)localObject1).get(5);
    int k;
    if (localObject2.length == 3)
    {
      k = Integer.valueOf(localObject2[0]).intValue();
      i = Integer.valueOf(localObject2[1]).intValue() - 1;
      j = Integer.valueOf(localObject2[2]).intValue();
      if (Build.VERSION.SDK_INT < 11) {
        break label250;
      }
      localObject1 = new DatePickerDialog(this.this$0.context, 3, null, k, i, j);
      localObject2 = ((DatePickerDialog)localObject1).getDatePicker();
      ((DatePickerDialog)localObject1).setButton(-1, this.this$0.getResources().getString(2131693745), new ContactEditBirthdayItemView.1.1(this, (DatePicker)localObject2));
      ((DatePickerDialog)localObject1).setButton(-2, this.this$0.getResources().getString(2131691246), new ContactEditBirthdayItemView.1.2(this));
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        ((DatePickerDialog)localObject1).getDatePicker().setMaxDate(System.currentTimeMillis());
      }
      ((DatePickerDialog)localObject1).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      k = m;
      if (localObject2.length != 2) {
        break;
      }
      i = Integer.valueOf(localObject2[0]).intValue() - 1;
      j = Integer.valueOf(localObject2[1]).intValue();
      k = m;
      break;
      label250:
      localObject1 = new DatePickerDialog(this.this$0.context, 3, new ContactEditBirthdayItemView.1.3(this), k, i, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditBirthdayItemView.1
 * JD-Core Version:    0.7.0.1
 */