package com.tencent.mobileqq.profile.PersonalityLabel;

import akyj;
import albi;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class PersonalityLabelGalleryActivity$4
  implements Runnable
{
  PersonalityLabelGalleryActivity$4(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(9);
    int i = PersonalityLabelGalleryActivity.a(this.this$0).size() - 1;
    if (i >= 0)
    {
      Object localObject = (String)PersonalityLabelGalleryActivity.a(this.this$0).get(i);
      if (this.this$0.cvW)
      {
        this.this$0.runOnUiThread(new PersonalityLabelGalleryActivity.4.1(this));
        return;
      }
      localObject = new CompressInfo((String)localObject, 0);
      ((CompressInfo)localObject).picType = 0;
      akyj.c((CompressInfo)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label uploadPhoto(), thumb_path = " + ((CompressInfo)localObject).destPath);
      }
      if (!TextUtils.isEmpty(((CompressInfo)localObject).destPath))
      {
        localArrayList.add(localObject);
        localObject = new File(((CompressInfo)localObject).destPath);
      }
      for (;;)
      {
        try
        {
          localObject = new URL("file:///" + ((File)localObject).getAbsolutePath());
          int j = (int)(120.0F * PersonalityLabelGalleryActivity.a(this.this$0));
          URLDrawable.getDrawable((URL)localObject, j, j, this.this$0.mDefaultDrawable, this.this$0.mDefaultDrawable).startDownload();
          i -= 1;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          continue;
        }
        this.this$0.runOnUiThread(new PersonalityLabelGalleryActivity.4.2(this, i));
      }
    }
    if (localArrayList.size() > 0) {
      this.this$0.a.a(localArrayList, PersonalityLabelGalleryActivity.a(this.this$0));
    }
    this.this$0.runOnUiThread(new PersonalityLabelGalleryActivity.4.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.4
 * JD-Core Version:    0.7.0.1
 */