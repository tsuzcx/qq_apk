package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;

class ContactHeaderItemView$2
  implements View.OnFocusChangeListener
{
  ContactHeaderItemView$2(ContactHeaderItemView paramContactHeaderItemView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = ContactHeaderItemView.access$000(this.this$0).getText().toString();
    if ((paramBoolean) && (!paramView.isEmpty()))
    {
      ContactHeaderItemView.access$100(this.this$0).setVisibility(0);
      return;
    }
    ContactHeaderItemView.access$100(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactHeaderItemView.2
 * JD-Core Version:    0.7.0.1
 */