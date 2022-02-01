package com.tencent.tim.teamwork;

import android.content.SharedPreferences;
import aull;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class TeamWorkManager$1
  implements Runnable
{
  public void run()
  {
    int j = 0;
    aull.a(this.this$0);
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    String[] arrayOfString = localSharedPreferences.getString("tencentdoc_host_list", auko.iD[0]).split("#");
    int k;
    int i;
    String str;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      this.this$0.Ek.clear();
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        str = arrayOfString[i];
        this.this$0.Ek.add(str);
        i += 1;
      }
    }
    arrayOfString = localSharedPreferences.getString("tencentdoc_content_page_path_head_list", auko.iE[0]).split("#");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      this.this$0.El.clear();
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        str = arrayOfString[i];
        this.this$0.El.add(str);
        i += 1;
      }
    }
    arrayOfString = localSharedPreferences.getString("tencentdoc_template_path_head_list", auko.iF[0]).split("#");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      this.this$0.Em.clear();
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        str = arrayOfString[i];
        this.this$0.Em.add(str);
        i += 1;
      }
    }
    arrayOfString = localSharedPreferences.getString("tencentdoc_template_preview_path_head_list", auko.iG[0]).split("#");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      this.this$0.En.clear();
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        str = arrayOfString[i];
        this.this$0.En.add(str);
        i += 1;
      }
    }
    this.this$0.evz();
    this.this$0.evy();
    aull.access$102(localSharedPreferences.getString("tencentdoc_pre_img_url_doc", "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png"));
    aull.access$202(localSharedPreferences.getString("tencentdoc_pre_img_url_sheet", "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png"));
    aull.nB(localSharedPreferences.getString("tencentdoc_pre_img_url_form", "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png"));
    aull.br(localSharedPreferences.getString("tencentdoc_pre_img_url_ppt", "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png"));
    aull.access$502(localSharedPreferences.getString("tencentdoc_pre_img_url_miniproj_doc", "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png"));
    aull.eB(localSharedPreferences.getString("tencentdoc_pre_img_url_miniproj_sheet", "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkManager.1
 * JD-Core Version:    0.7.0.1
 */