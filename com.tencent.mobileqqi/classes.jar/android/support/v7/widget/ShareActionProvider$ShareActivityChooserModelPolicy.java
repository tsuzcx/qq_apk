package android.support.v7.widget;

import android.content.Intent;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.support.v7.internal.widget.ActivityChooserModel.OnChooseActivityListener;

class ShareActionProvider$ShareActivityChooserModelPolicy
  implements ActivityChooserModel.OnChooseActivityListener
{
  private ShareActionProvider$ShareActivityChooserModelPolicy(ShareActionProvider paramShareActionProvider) {}
  
  public boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent)
  {
    if (ShareActionProvider.access$400(this.this$0) != null) {
      ShareActionProvider.access$400(this.this$0).onShareTargetSelected(this.this$0, paramIntent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.widget.ShareActionProvider.ShareActivityChooserModelPolicy
 * JD-Core Version:    0.7.0.1
 */