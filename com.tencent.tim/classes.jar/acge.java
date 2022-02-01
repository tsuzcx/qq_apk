import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class acge
  implements AdapterView.OnItemClickListener
{
  acge(ShareActionSheetBuilder paramShareActionSheetBuilder, int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.d.dismiss();
      int j = ((ShareActionSheetBuilder.b)localObject).b.action;
      localObject = "";
      label59:
      label120:
      int i;
      if (1 == this.val$from)
      {
        localObject = "0X8005D50";
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        switch (j)
        {
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          if ((j != 9) && (j != 10)) {
            break label358;
          }
          i = -1;
          if (!WXShareHelper.a().isWXinstalled()) {
            i = 2131721935;
          }
          break;
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label358;
        }
        QQToast.a(this.val$activity, this.val$activity.getString(i), 0).show(this.val$activity.getResources().getDimensionPixelSize(2131299627));
        break;
        if (2 == this.val$from)
        {
          localObject = "0X8005D51";
          break label59;
        }
        if (3 != this.val$from) {
          break label59;
        }
        localObject = "";
        break label59;
        anot.a(this.val$app, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "1", "", "", "");
        break label120;
        anot.a(this.val$app, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "2", "", "", "");
        break label120;
        anot.a(this.val$app, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "3", "", "", "");
        break label120;
        anot.a(this.val$app, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "4", "", "", "");
        break label120;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      label358:
      localObject = "邀请加入QQ热聊：" + this.val$name;
      switch (j)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        break;
      case 2: 
        localObject = acfp.m(2131707209) + this.val$name + acfp.m(2131707210);
        acfx.a(this.val$activity, this.val$name, (String)localObject, this.aHr, this.val$jumpUrl, this.boo, this.bop, false);
        break;
      case 3: 
        acfx.b(this.val$activity, this.val$name, (String)localObject, this.aHr, this.val$jumpUrl, this.bop);
        break;
      case 9: 
        acfx.a(this.val$activity, this.val$name, (String)localObject, "立即加入，一起热聊！\nQQ热聊有上百个热门话题，与同兴趣的人一起群聊。", this.Uf, this.val$jumpUrl, this.val$localPath);
        break;
      case 10: 
        acfx.b(this.val$activity, this.val$name, (String)localObject, this.aHr, this.Uf, this.val$jumpUrl, this.val$localPath);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acge
 * JD-Core Version:    0.7.0.1
 */