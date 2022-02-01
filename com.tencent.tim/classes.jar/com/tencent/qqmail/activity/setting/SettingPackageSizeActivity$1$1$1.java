package com.tencent.qqmail.activity.setting;

import android.content.pm.PackageStats;
import android.os.Build.VERSION;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingPackageSizeActivity$1$1$1
  implements Runnable
{
  SettingPackageSizeActivity$1$1$1(SettingPackageSizeActivity.1.1 param1, PackageStats paramPackageStats) {}
  
  public void run()
  {
    SettingPackageSizeActivity.access$002(this.this$2.this$1.this$0, this.val$pStats);
    int i = Build.VERSION.SDK_INT;
    SettingPackageSizeActivity.access$200(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)this.val$pStats.codeSize));
    if (i >= 14) {
      SettingPackageSizeActivity.access$300(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)this.val$pStats.externalCodeSize));
    }
    for (;;)
    {
      SettingPackageSizeActivity.access$400(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)this.val$pStats.dataSize));
      SettingPackageSizeActivity.access$500(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)this.val$pStats.externalDataSize));
      SettingPackageSizeActivity.access$600(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)this.val$pStats.cacheSize));
      SettingPackageSizeActivity.access$700(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)this.val$pStats.externalCacheSize));
      SettingPackageSizeActivity.access$800(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)this.val$pStats.externalMediaSize));
      SettingPackageSizeActivity.access$900(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)this.val$pStats.externalObbSize));
      long l = SettingPackageSizeActivity.access$1000(this.this$2.this$1.this$0, this.val$pStats);
      SettingPackageSizeActivity.access$1100(this.this$2.this$1.this$0).setDetail(SettingPackageSizeActivity.access$100(this.this$2.this$1.this$0, (float)l));
      return;
      SettingPackageSizeActivity.access$300(this.this$2.this$1.this$0).setDetail("0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity.1.1.1
 * JD-Core Version:    0.7.0.1
 */