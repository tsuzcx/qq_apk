package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.res.Resources;
import aqiw;

class PersonalityLabelGalleryActivity$1
  implements Runnable
{
  PersonalityLabelGalleryActivity$1(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, PersonalityLabel paramPersonalityLabel) {}
  
  public void run()
  {
    PersonalityLabelGalleryActivity localPersonalityLabelGalleryActivity;
    if (!this.this$0.isFinishing())
    {
      this.this$0.b(this.d, false);
      if (aqiw.isNetSupport(this.this$0)) {
        break label101;
      }
      PersonalityLabelGalleryActivity.a(this.this$0, this.this$0.getResources().getString(2131696270));
      if ((this.d == null) || (this.d.getSize() <= 0)) {
        break label91;
      }
      i = 1;
      localPersonalityLabelGalleryActivity = this.this$0;
      if (i == 0) {
        break label96;
      }
    }
    label91:
    label96:
    for (int i = 8;; i = 0)
    {
      localPersonalityLabelGalleryActivity.x(i, "加载失败", false);
      return;
      i = 0;
      break;
    }
    label101:
    PersonalityLabelGalleryActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.1
 * JD-Core Version:    0.7.0.1
 */