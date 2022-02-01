package com.tencent.qqmail.utilities.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
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

public class QMShareFileDialogHelper
{
  public static int FROM_SHARE_MAIL_OR_NOTE_CONTENT = 1;
  public static int FROM_UNKNOWN = 0;
  private static final String LaunchComposeMail = "com.tencent.qqmail.LaunchComposeMail";
  private static final String LaunchComposeNote = "com.tencent.qqmail.LaunchComposeNote";
  private static final String LaunchCopyShareLink = "com.tencent.qqmail.LaunchCopyShareLink";
  private static final String LaunchFtnUpload = "com.tencent.qqmail.LaunchFtnUpload";
  public static int SHARE_TYPE_BIG_ATT = 0;
  public static int SHARE_TYPE_IMG = 0;
  public static int SHARE_TYPE_NORMAL_ATT = 1;
  public static final String TAG = "QMShareFileDialogHelper";
  private static final String mobileqqPackageName = "com.tencent.mobileqq";
  private static final String mobileqqSendToFriend = "com.tencent.mobileqq.activity.JumpActivity";
  private static final String qqDefaultPackageName = "com.tencent.qqmail";
  private static final String qqPackageName = "com.tencent.androidqqmail";
  private static final String qqmailPackageName = "com.tencent.androidqqmail";
  private static final String rtxPackageName = "com.tencent.wework";
  private static final String timChatClassName = "com.tencent.mobileqq.activity.JumpActivity";
  private static final String timFavClassName = "cooperation.qqfav.widget.QfavJumpActivity";
  private static final String timPackageName = "com.tencent.tim";
  private static final String wxAddFavoriteUI = "com.tencent.mm.ui.tools.AddFavoriteUI";
  private static final String wxPackageName = "com.tencent.mm";
  private static final String wxShareImgUI = "com.tencent.mm.ui.tools.ShareImgUI";
  private static final String wxShareToTimeLineUI = "com.tencent.mm.ui.tools.ShareToTimeLineUI";
  private Context context;
  private String filePath;
  private int from = FROM_UNKNOWN;
  private long hashId;
  private PackageManager pm;
  private ShareFilter shareFilter;
  private String title;
  private int type;
  private String url;
  
  static
  {
    SHARE_TYPE_BIG_ATT = 2;
    FROM_UNKNOWN = -1;
  }
  
  public QMShareFileDialogHelper(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.context = paramContext;
    this.title = paramString1;
    this.filePath = paramString2;
    this.type = paramInt;
  }
  
  public QMShareFileDialogHelper(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this(paramContext, paramString1, paramString2, paramInt1);
    this.from = paramInt2;
  }
  
  public QMShareFileDialogHelper(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, ShareFilter paramShareFilter)
  {
    this.context = paramContext;
    this.title = paramString1;
    this.filePath = paramString2;
    this.type = paramInt1;
    this.from = paramInt2;
    this.shareFilter = paramShareFilter;
  }
  
  public QMShareFileDialogHelper(Context paramContext, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    this.context = paramContext;
    this.title = paramString1;
    this.url = paramString2;
    this.type = paramInt;
    this.hashId = paramLong;
  }
  
  private ArrayList<ResolveInfo> SortByChinese(ArrayList<ResolveInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return new ArrayList();
    }
    Collections.sort(paramArrayList, new ShareLinkComparator());
    return paramArrayList;
  }
  
  private void colectDataForShareContent(String paramString1, String paramString2)
  {
    if (isShareImgUI(paramString1, paramString2))
    {
      DataCollector.logEvent("Event_Share_Email_Content_To_Wechat");
      return;
    }
    if (isShareToQqFriend(paramString1, paramString2))
    {
      DataCollector.logEvent("Event_Share_Email_Content_To_QQ");
      return;
    }
    DataCollector.logEvent("Event_Share_Email_Content_To_Other_App");
  }
  
  private void collectDataForShareAttachment(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      do
      {
        return;
        if (isShareToQqFriend(paramString1, paramString2))
        {
          DataCollector.logEvent("Event_Share_File_To_Qq_Friend");
          return;
        }
        if (!isShareImgUI(paramString1, paramString2)) {
          break;
        }
        DataCollector.logEvent("Event_Share_File_To_Wechat_Friend");
      } while (((this.type != SHARE_TYPE_IMG) && (this.type != SHARE_TYPE_NORMAL_ATT)) || (this.filePath == null) || (FileUtil.getFileSize(this.filePath) <= 10485760L));
      DataCollector.logEvent("Event_Share_File_Size_To_Limit");
      return;
      if (isShareToTimeLineUI(paramString1, paramString2))
      {
        DataCollector.logEvent("Event_Share_File_To_Timeline");
        return;
      }
    } while (!paramString1.equals("com.tencent.wework"));
    DataCollector.logEvent("Event_RTX_Share_Attachment");
  }
  
  private ArrayList<ResolveInfo> getResolveInfoList()
  {
    this.pm = this.context.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new Intent("android.intent.action.SEND");
    if (this.type == SHARE_TYPE_BIG_ATT)
    {
      ((Intent)localObject).setType("text/*");
      localObject = this.pm.queryIntentActivities((Intent)localObject, 0).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label236;
      }
      ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
      String str1 = localResolveInfo.activityInfo.packageName;
      String str2 = localResolveInfo.activityInfo.name;
      Log.i("QMShareFileDialogHelper", "packageName = " + str1 + " className = " + str2);
      if (((this.shareFilter == null) || (!this.shareFilter.filter(str1))) && (!"cooperation.qqfav.widget.QfavJumpActivity".equals(str2)) && (!"com.tencent.mm".equals(str1)) && (!"com.tencent.androidqqmail".equals(str1)) && (!"com.tencent.mobileqq".equals(str1)))
      {
        if ("com.tencent.mobileqq.activity.JumpActivity".equals(str2))
        {
          localArrayList.add(0, localResolveInfo);
          continue;
          ((Intent)localObject).setType("image/*");
          break;
        }
        localArrayList.add(localResolveInfo);
      }
    }
    label236:
    if (this.type == SHARE_TYPE_BIG_ATT)
    {
      localObject = new Intent("android.intent.action.SEND");
      ((Intent)localObject).setType("image/jpeg");
      ((Intent)localObject).setPackage("com.tencent.mm");
      localObject = this.pm.queryIntentActivities((Intent)localObject, 0);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while ((((Iterator)localObject).hasNext()) && (!((ResolveInfo)((Iterator)localObject).next()).activityInfo.name.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI"))) {}
      }
    }
    if (this.type == SHARE_TYPE_BIG_ATT)
    {
      localObject = new Intent();
      ((Intent)localObject).setClassName("com.tencent.androidqqmail", "com.tencent.qqmail.LaunchCopyShareLink");
      localObject = this.pm.queryIntentActivities((Intent)localObject, 0);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        localArrayList.add(0, ((List)localObject).get(0));
      }
    }
    return localArrayList;
  }
  
  private void handleShareMailContent(String paramString1, String paramString2, Intent paramIntent)
  {
    colectDataForShareContent(paramString1, paramString2);
    if (isShareImgUI(paramString1, paramString2))
    {
      WXEntryActivity.shareImageToFriend(QMApplicationContext.sharedInstance(), this.filePath, 1, new QMShareFileDialogHelper.2(this));
      return;
    }
    if (isShareToTimeLineUI(paramString1, paramString2))
    {
      WXEntryActivity.shareImageToTimeLine(QMApplicationContext.sharedInstance(), this.filePath, 1, new QMShareFileDialogHelper.3(this));
      return;
    }
    paramIntent.setClassName(paramString1, paramString2);
    paramIntent.setComponent(new ComponentName(paramString1, paramString2));
    this.context.startActivity(paramIntent);
  }
  
  private void handleShareResult(boolean paramBoolean)
  {
    if (!paramBoolean) {
      new QMTips(this.context).showInfo(QMApplicationContext.sharedInstance().getString(2131696756));
    }
  }
  
  private boolean isShareImgUI(String paramString1, String paramString2)
  {
    return (paramString1.equals("com.tencent.mm")) && (paramString2.equals("com.tencent.mm.ui.tools.ShareImgUI"));
  }
  
  private boolean isShareToQqFriend(String paramString1, String paramString2)
  {
    return (paramString1.equals("com.tencent.mobileqq")) && (paramString2.equals("com.tencent.mobileqq.activity.JumpActivity"));
  }
  
  private boolean isShareToTimeLineUI(String paramString1, String paramString2)
  {
    return (paramString1.equals("com.tencent.mm")) && (paramString2.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI"));
  }
  
  private void shareToWechatThroughSDK(String paramString)
  {
    MailBigAttach localMailBigAttach = QMAttachManager.sharedInstance().getBigAttach(this.hashId);
    if (localMailBigAttach == null) {}
    do
    {
      return;
      Object localObject = new WXWebpageObject();
      ((WXWebpageObject)localObject).webpageUrl = localMailBigAttach.getPreview().getDownloadUrl();
      localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
      ((WXMediaMessage)localObject).title = localMailBigAttach.getName();
      ((WXMediaMessage)localObject).description = (localMailBigAttach.getName() + QMApplicationContext.sharedInstance().getString(2131695202));
      int i = ImageResourceUtil.getImageResource(FtnCommonUtils.getFileType(localMailBigAttach.getName()), ImageResourceUtil.IMAGE_SIZE_124);
      ((WXMediaMessage)localObject).thumbData = WXEntryActivity.bmpToByteArray(BitmapFactory.decodeResource(QMApplicationContext.sharedInstance().getResources(), i), false);
      if (paramString.equals("com.tencent.mm.ui.tools.ShareImgUI"))
      {
        DataCollector.logEvent("Event_Share_File_To_Wechat_Friend");
        WXEntryActivity.shareWebpage(QMApplicationContext.sharedInstance(), 0, (WXMediaMessage)localObject, 6);
        return;
      }
      if (paramString.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI"))
      {
        DataCollector.logEvent("Event_Share_File_To_Timeline");
        WXEntryActivity.shareWebpage(QMApplicationContext.sharedInstance(), 1, (WXMediaMessage)localObject, 6);
        return;
      }
    } while (!paramString.equals("com.tencent.mm.ui.tools.AddFavoriteUI"));
  }
  
  public QMBottomDialog createDialog()
  {
    ArrayList localArrayList = getResolveInfoList();
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.context);
    localBottomListSheetBuilder.setTitle(this.title);
    int i = 0;
    if (i < localArrayList.size())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localArrayList.get(i);
      if (localResolveInfo != null)
      {
        if (!localResolveInfo.activityInfo.packageName.equals("com.tencent.wework")) {
          break label100;
        }
        localBottomListSheetBuilder.addItem(localResolveInfo.loadIcon(this.pm), this.context.getResources().getString(2131720199));
      }
      for (;;)
      {
        i += 1;
        break;
        label100:
        if ((localResolveInfo.activityInfo.packageName.equals("com.tencent.mm")) && (localResolveInfo.activityInfo.name.equals("com.tencent.mm.ui.tools.ShareImgUI"))) {
          localBottomListSheetBuilder.addItem(localResolveInfo.loadIcon(this.pm), this.context.getResources().getString(2131720192));
        } else if ((localResolveInfo.activityInfo.packageName.equals("com.tencent.mm")) && (localResolveInfo.activityInfo.name.equals("com.tencent.mm.ui.tools.ShareToTimeLineUI"))) {
          localBottomListSheetBuilder.addItem(localResolveInfo.loadIcon(this.pm), this.context.getResources().getString(2131720193));
        } else {
          localBottomListSheetBuilder.addItem(localResolveInfo.loadIcon(this.pm), localResolveInfo.loadLabel(this.pm).toString());
        }
      }
    }
    localBottomListSheetBuilder.setOnSheetItemClickListener(new QMShareFileDialogHelper.1(this, localArrayList));
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
  
  public static abstract interface ShareFilter
  {
    public abstract boolean filter(String paramString);
  }
  
  class ShareLinkComparator
    implements Comparator<ResolveInfo>
  {
    private RuleBasedCollator collator = (RuleBasedCollator)Collator.getInstance(Locale.CHINA);
    
    public ShareLinkComparator() {}
    
    public int compare(ResolveInfo paramResolveInfo1, ResolveInfo paramResolveInfo2)
    {
      paramResolveInfo1 = paramResolveInfo1.loadLabel(QMShareFileDialogHelper.this.pm).toString();
      paramResolveInfo2 = paramResolveInfo2.loadLabel(QMShareFileDialogHelper.this.pm).toString();
      CollationKey localCollationKey1 = this.collator.getCollationKey(paramResolveInfo1);
      CollationKey localCollationKey2 = this.collator.getCollationKey(paramResolveInfo2);
      if ((paramResolveInfo1.length() > 0) && (paramResolveInfo2.length() > 0))
      {
        if (QMShareFileDialogHelper.this.isLetterOrDight(paramResolveInfo1.charAt(0)))
        {
          if (QMShareFileDialogHelper.this.isLetterOrDight(paramResolveInfo2.charAt(0))) {
            return paramResolveInfo1.compareTo(paramResolveInfo2);
          }
          return 1;
        }
        if (QMShareFileDialogHelper.this.isLetterOrDight(paramResolveInfo2.charAt(0))) {
          return -1;
        }
        return this.collator.compare(localCollationKey1.getSourceString(), localCollationKey2.getSourceString());
      }
      return this.collator.compare(localCollationKey1.getSourceString(), localCollationKey2.getSourceString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper
 * JD-Core Version:    0.7.0.1
 */