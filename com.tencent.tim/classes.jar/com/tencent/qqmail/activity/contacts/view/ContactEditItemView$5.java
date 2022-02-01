package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.validate.ValidateEmail;

class ContactEditItemView$5
  implements View.OnFocusChangeListener
{
  ContactEditItemView$5(ContactEditItemView paramContactEditItemView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView.hasWindowFocus()) {
      if (this.this$0.iconClear != null)
      {
        if ((this.this$0.nodeInput.getText().toString().isEmpty()) || (!paramBoolean)) {
          break label124;
        }
        this.this$0.iconClear.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.this$0.itemType == ContactBaseItemView.ContactItemType.TYPE_EMAIL)
      {
        paramView = this.this$0.nodeInput.getText().toString().trim();
        if ((paramBoolean) || (paramView.isEmpty()) || (ValidateEmail.isEmailValidate(paramView))) {
          break;
        }
        this.this$0.nodeInput.setTextColor(-65536);
        Toast.makeText(QMApplicationContext.sharedInstance(), 2131692043, 0).show();
      }
      return;
      label124:
      this.this$0.iconClear.setVisibility(4);
    }
    this.this$0.nodeInput.setTextColor(-16777216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditItemView.5
 * JD-Core Version:    0.7.0.1
 */