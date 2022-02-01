package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.widget.ListView;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import java.text.CollationKey;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class QMShareLinkDialogHelper
{
  private static final String LaunchComposeMail = "com.tencent.qqmail.LaunchComposeMail";
  private static final String LaunchComposeNote = "com.tencent.qqmail.LaunchComposeNote";
  private static final String LaunchCopyShareLink = "com.tencent.qqmail.LaunchCopyShareLink";
  private static final String LaunchFtnUpload = "com.tencent.qqmail.LaunchFtnUpload";
  private static final String mobileqqPackageName = "com.tencent.mobileqq";
  private static final String mobileqqSendToFriend = "com.tencent.mobileqq.activity.JumpActivity";
  private static final String qqDefaultPackageName = "com.tencent.qqmail";
  private static final String qqPackageName = "com.tencent.androidqqmail";
  private static final String rtxPackageName = "com.tencent.wework";
  private static final String wxAddFavoriteUI = "com.tencent.mm.ui.tools.AddFavoriteUI";
  private static final String wxPackageName = "com.tencent.mm";
  private static final String wxShareImgUI = "com.tencent.mm.ui.tools.ShareImgUI";
  private static final String wxShareToTimeLineUI = "com.tencent.mm.ui.tools.ShareToTimeLineUI";
  private Context context;
  private ListView listView;
  private String name;
  private PackageManager pm;
  private String title;
  private String url;
  
  public QMShareLinkDialogHelper(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.context = paramContext;
    this.title = paramString1;
    this.url = paramString2;
    this.name = paramString3;
  }
  
  private ArrayList<ResolveInfo> SortByChinese(ArrayList<ResolveInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return new ArrayList();
    }
    Collections.sort(paramArrayList, new ShareLinkComparator());
    return paramArrayList;
  }
  
  private void collectData(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return;
      if ((paramString1.equals("com.tencent.mobileqq")) && (paramString2.equals("com.tencent.mobileqq.activity.JumpActivity")))
      {
        DataCollector.logEvent("Event_Share_File_To_Qq_Friend");
        return;
      }
      if ((paramString1.equals("com.tencent.mm")) && (paramString2.equals("com.tencent.mm.ui.tools.ShareImgUI")))
      {
        DataCollector.logEvent("Event_Share_File_To_Wechat_Friend");
        return;
      }
    } while ((!paramString1.equals("com.tencent.mm")) || (!paramString2.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI")));
    DataCollector.logEvent("Event_Share_File_To_Timeline");
  }
  
  private ArrayList<ResolveInfo> getResolveInfo()
  {
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new Intent("android.intent.action.SEND");
    ((Intent)localObject2).setType("text/plain");
    Iterator localIterator = this.pm.queryIntentActivities((Intent)localObject2, 0).iterator();
    Object localObject3 = null;
    localObject2 = null;
    while (localIterator.hasNext())
    {
      localObject4 = (ResolveInfo)localIterator.next();
      localObject5 = ((ResolveInfo)localObject4).activityInfo.packageName;
      String str = ((ResolveInfo)localObject4).activityInfo.name;
      if (((!"com.tencent.androidqqmail".equals(localObject5)) || ((!"com.tencent.qqmail.LaunchComposeMail".equals(str)) && (!"com.tencent.qqmail.LaunchComposeNote".equals(str)) && (!"com.tencent.qqmail.LaunchFtnUpload".equals(str)))) && ((!((String)localObject5).equals("com.tencent.mm")) || (!str.equals("com.tencent.mm.ui.tools.AddFavoriteUI"))))
      {
        if ((((String)localObject5).equals("com.tencent.mobileqq")) && (str.equals("com.tencent.mobileqq.activity.JumpActivity")))
        {
          localObject2 = localObject3;
          localObject3 = localObject4;
        }
        for (;;)
        {
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
          break;
          if ((((String)localObject5).equals("com.tencent.mm")) && (str.equals("com.tencent.mm.ui.tools.ShareImgUI")))
          {
            localObject3 = localObject2;
            localObject2 = localObject4;
          }
          else if ((((String)localObject5).equals("com.tencent.mm")) && (str.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI")))
          {
            localObject5 = localObject2;
            localObject1 = localObject4;
            localObject2 = localObject3;
            localObject3 = localObject5;
          }
          else
          {
            if (!((String)localObject5).equals("com.tencent.wework")) {
              localArrayList.add(localObject4);
            }
            localObject4 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject4;
          }
        }
      }
    }
    Object localObject4 = new Intent("android.intent.action.SEND");
    ((Intent)localObject4).setType("image/jpeg");
    ((Intent)localObject4).setPackage("com.tencent.mm");
    Object localObject5 = this.pm.queryIntentActivities((Intent)localObject4, 0);
    localObject4 = localObject1;
    if (localObject5 != null)
    {
      localObject5 = ((List)localObject5).iterator();
      do
      {
        localObject4 = localObject1;
        if (!((Iterator)localObject5).hasNext()) {
          break;
        }
        localObject4 = (ResolveInfo)((Iterator)localObject5).next();
      } while (!((ResolveInfo)localObject4).activityInfo.name.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI"));
    }
    localObject1 = SortByChinese(localArrayList);
    if (localObject4 != null) {
      ((ArrayList)localObject1).add(0, localObject4);
    }
    if (localObject3 != null) {
      ((ArrayList)localObject1).add(0, localObject3);
    }
    if (localObject2 != null) {
      ((ArrayList)localObject1).add(0, localObject2);
    }
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName("com.tencent.androidqqmail", "com.tencent.qqmail.LaunchCopyShareLink");
    localObject2 = this.pm.queryIntentActivities((Intent)localObject2, 0);
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      ((ArrayList)localObject1).add(0, ((List)localObject2).get(0));
    }
    return localObject1;
  }
  
  private boolean shareToWX(String paramString)
  {
    if (WXEntryActivity.canShareToWX(QMApplicationContext.sharedInstance()))
    {
      Object localObject = new WXWebpageObject();
      ((WXWebpageObject)localObject).webpageUrl = this.url;
      localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
      ((WXMediaMessage)localObject).title = this.name;
      ((WXMediaMessage)localObject).description = (this.name + QMApplicationContext.sharedInstance().getString(2131695202));
      int i = ImageResourceUtil.getImageResource(FtnCommonUtils.getFileType(this.name), ImageResourceUtil.IMAGE_SIZE_124);
      ((WXMediaMessage)localObject).thumbData = WXEntryActivity.bmpToByteArray(BitmapFactory.decodeResource(QMApplicationContext.sharedInstance().getResources(), i), false);
      if (paramString.equals("com.tencent.mm.ui.tools.ShareImgUI"))
      {
        DataCollector.logEvent("Event_Share_File_To_Wechat_Friend");
        WXEntryActivity.shareWebpage(QMApplicationContext.sharedInstance(), 0, (WXMediaMessage)localObject, 6);
      }
      do
      {
        return true;
        if (paramString.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI"))
        {
          DataCollector.logEvent("Event_Share_File_To_Timeline");
          WXEntryActivity.shareWebpage(QMApplicationContext.sharedInstance(), 1, (WXMediaMessage)localObject, 6);
          return true;
        }
      } while (!paramString.equals("com.tencent.mm.ui.tools.AddFavoriteUI"));
      return true;
    }
    return false;
  }
  
  public QMBottomDialog createDialog()
  {
    this.pm = this.context.getPackageManager();
    ArrayList localArrayList = getResolveInfo();
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.context);
    localBottomListSheetBuilder.setTitle(this.title);
    int i = 0;
    while (i < localArrayList.size())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localArrayList.get(i);
      if (localResolveInfo != null) {
        localBottomListSheetBuilder.addItem(localResolveInfo.loadIcon(this.pm), localResolveInfo.loadLabel(this.pm).toString());
      }
      i += 1;
    }
    localBottomListSheetBuilder.setOnSheetItemClickListener(new QMShareLinkDialogHelper.1(this, localArrayList));
    return localBottomListSheetBuilder.build();
  }
  
  public boolean isLetterOrDight(char paramChar)
  {
    if (((paramChar <= 'Z') && (paramChar >= 'A')) || ((paramChar <= 'z') && (paramChar >= 'a'))) {}
    while ((paramChar >= '0') && (paramChar <= '9')) {
      return true;
    }
    return false;
  }
  
  class ShareLinkComparator
    implements Comparator<ResolveInfo>
  {
    private RuleBasedCollator collator = (RuleBasedCollator)Collator.getInstance(Locale.CHINA);
    
    public ShareLinkComparator() {}
    
    public int compare(ResolveInfo paramResolveInfo1, ResolveInfo paramResolveInfo2)
    {
      paramResolveInfo1 = paramResolveInfo1.loadLabel(QMShareLinkDialogHelper.this.pm).toString();
      paramResolveInfo2 = paramResolveInfo2.loadLabel(QMShareLinkDialogHelper.this.pm).toString();
      CollationKey localCollationKey1 = this.collator.getCollationKey(paramResolveInfo1);
      CollationKey localCollationKey2 = this.collator.getCollationKey(paramResolveInfo2);
      if ((paramResolveInfo1.length() > 0) && (paramResolveInfo2.length() > 0))
      {
        if (QMShareLinkDialogHelper.this.isLetterOrDight(paramResolveInfo1.charAt(0)))
        {
          if (QMShareLinkDialogHelper.this.isLetterOrDight(paramResolveInfo2.charAt(0))) {
            return paramResolveInfo1.compareTo(paramResolveInfo2);
          }
          return 1;
        }
        if (QMShareLinkDialogHelper.this.isLetterOrDight(paramResolveInfo2.charAt(0))) {
          return -1;
        }
        return this.collator.compare(localCollationKey1.getSourceString(), localCollationKey2.getSourceString());
      }
      return this.collator.compare(localCollationKey1.getSourceString(), localCollationKey2.getSourceString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMShareLinkDialogHelper
 * JD-Core Version:    0.7.0.1
 */