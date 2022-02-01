import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.teamwork.PadInfo;

public class amqx
  implements ampx
{
  public PadInfo a = new PadInfo();
  private QQAppInterface app;
  public String keyword;
  
  public amqx(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private String bu(String paramString1, String paramString2)
  {
    if (this.app.getCurrentAccountUin().equals(paramString1)) {
      paramString1 = "我";
    }
    String str;
    do
    {
      return paramString1;
      str = aqgv.b(this.app, paramString1, true);
      if ((str != null) && (!str.equals(paramString1))) {
        break;
      }
      paramString1 = paramString2;
    } while (!TextUtils.isEmpty(paramString2));
    return str;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    amxk.a(this.keyword, 120, 0, paramView);
    if (this.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", jpa.r(this.a.pad_url, "_bid=2517"));
      localBundle.putInt("key_team_work_edit_type", this.a.type);
      localBundle.putString("key_team_work_title", this.a.title);
      localBundle.putString("key_team_work_rul", this.a.pad_url);
      localBundle.putString("tdsourcetag", "s_tim_cloud_folder");
      TeamWorkDocEditBrowserActivity.a(paramView.getContext(), localBundle, true);
    }
  }
  
  public void cW(int paramInt1, int paramInt2) {}
  
  public CharSequence f()
  {
    if (this.a == null) {
      localObject1 = "";
    }
    String str;
    do
    {
      PadInfo localPadInfo;
      do
      {
        do
        {
          return localObject1;
          localPadInfo = this.a;
          int i = localPadInfo.type_list;
          if ((i == 1) || (this.app.getCurrentAccountUin().equals("" + localPadInfo.creatorUin))) {
            return this.app.getApp().getResources().getString(2131720888);
          }
          if (i == 3)
          {
            localObject1 = bu("" + localPadInfo.creatorUin, localPadInfo.shardNick);
            return this.app.getApp().getResources().getString(2131720946, new Object[] { localObject1 });
          }
          str = bu("" + localPadInfo.creatorUin, localPadInfo.creatorNick);
          localObject2 = this.app.getApp().getResources().getString(2131720943, new Object[] { str });
          localObject1 = localObject2;
        } while (TextUtils.isEmpty(this.app.getCurrentUin()));
        localObject1 = localObject2;
      } while (this.app.getCurrentUin().equals(Long.valueOf(localPadInfo.creatorUin)));
      localObject1 = localObject2;
    } while (!(amxk.a(str, this.keyword, 10) instanceof SpannableStringBuilder));
    Object localObject1 = (SpannableStringBuilder)amxk.a(str, this.keyword, 10);
    Object localObject2 = new ForegroundColorSpan(Color.parseColor("#888888"));
    ((SpannableStringBuilder)localObject1).insert(0, "由");
    ((SpannableStringBuilder)localObject1).append("创建");
    ((SpannableStringBuilder)localObject1).setSpan(localObject2, 0, 1, 33);
    ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#888888")), ((SpannableStringBuilder)localObject1).length() - 2, ((SpannableStringBuilder)localObject1).length(), 33);
    return localObject1;
  }
  
  public CharSequence g()
  {
    Object localObject1;
    if (this.a == null)
    {
      localObject1 = "";
      return localObject1;
    }
    PadInfo localPadInfo = this.a;
    int i = localPadInfo.type_list;
    if (localPadInfo.isCloudFile) {}
    for (long l1 = this.a.iCloudFileCreateTime;; l1 = 0L)
    {
      if (i == 3) {}
      Object localObject2;
      for (long l2 = Math.max(l1, localPadInfo.lastEditTime);; l2 = Math.max(Math.max(l1, localPadInfo.lastEditTime), localPadInfo.currentUserBrowseTime))
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (l2 <= 0L) {
          break;
        }
        if (l2 != localPadInfo.lastEditTime) {
          break label323;
        }
        String str = bu("" + localPadInfo.lastEditorUin, localPadInfo.lastEditorNick);
        localObject2 = String.format(this.app.getApp().getResources().getString(2131720944), new Object[] { str });
        localObject1 = localObject2;
        if (TextUtils.isEmpty(this.app.getCurrentUin())) {
          break;
        }
        localObject1 = localObject2;
        if (this.app.getCurrentUin().equals(Long.valueOf(localPadInfo.lastEditorUin))) {
          break;
        }
        localObject1 = localObject2;
        if (!(amxk.a(str, this.keyword, 10) instanceof SpannableStringBuilder)) {
          break;
        }
        localObject1 = (SpannableStringBuilder)amxk.a(str, this.keyword, 10);
        localObject2 = new ForegroundColorSpan(Color.parseColor("#888888"));
        ((SpannableStringBuilder)localObject1).insert(0, "由");
        ((SpannableStringBuilder)localObject1).append("编辑");
        ((SpannableStringBuilder)localObject1).setSpan(localObject2, 0, 1, 33);
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#888888")), ((SpannableStringBuilder)localObject1).length() - 2, ((SpannableStringBuilder)localObject1).length(), 33);
        return localObject1;
      }
      label323:
      if (l2 == l1) {
        return String.format(this.app.getApp().getResources().getString(2131720942), new Object[] { "我" });
      }
      localObject1 = localObject2;
      if (l2 != localPadInfo.currentUserBrowseTime) {
        break;
      }
      return String.format(this.app.getApp().getResources().getString(2131720947), new Object[] { "我" });
    }
  }
  
  public CharSequence getDescription()
  {
    if (this.a == null) {
      return "";
    }
    PadInfo localPadInfo = this.a;
    int i = localPadInfo.type_list;
    long l = 0L;
    if (localPadInfo.isCloudFile) {
      l = this.a.iCloudFileCreateTime;
    }
    if (i == 3) {}
    for (l = Math.max(l, localPadInfo.lastEditTime);; l = Math.max(Math.max(l, localPadInfo.lastEditTime), localPadInfo.currentUserBrowseTime)) {
      return auqb.bG(l);
    }
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    if (this.a == null) {
      return null;
    }
    return amxk.a(this.a.title, this.keyword);
  }
  
  public String getUin()
  {
    return "##teamwork##";
  }
  
  public int pE()
  {
    return 0;
  }
  
  public int pF()
  {
    return 0;
  }
  
  public int pG()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqx
 * JD-Core Version:    0.7.0.1
 */