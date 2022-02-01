package com.tencent.qqmail.sendmaillist;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.maillist.view.MailListItemView.MailListItemData;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTask;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeState;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.ItemScrollAdapter;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Date;

public class SendMailListAdapter
  extends ArrayAdapter<QMTask>
  implements ItemScrollListView.ItemScrollAdapter
{
  private ArrayList<QMTask> taskList;
  
  public SendMailListAdapter(Context paramContext, int paramInt, ArrayList<QMTask> paramArrayList)
  {
    super(paramContext, paramInt, paramArrayList);
    this.taskList = paramArrayList;
  }
  
  public static boolean isExceedAttachLimit(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.contains(QMApplicationContext.sharedInstance().getString(2131691895))) || (paramString.contains(QMApplicationContext.sharedInstance().getString(2131691894))));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.taskList == null) {}
    for (Object localObject1 = paramView;; localObject1 = paramView)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (paramInt < this.taskList.size()) {
        break;
      }
    }
    QMSendMailTask localQMSendMailTask = (QMSendMailTask)this.taskList.get(paramInt);
    ComposeMailUI localComposeMailUI = localQMSendMailTask.getMail();
    String str = QMUIKit.ELLIPSIZE_FIXED;
    Object localObject2;
    label100:
    MailListItemView.MailListItemData localMailListItemData;
    label172:
    label188:
    Object localObject4;
    Object localObject3;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject2 = new MailListItemView(getContext());
      localObject1 = ItemScrollListView.wrap((View)localObject2);
      ((View)localObject1).setTag("");
      paramView = ((HorizontalScrollItemView)localObject1).getDeleteView();
      ItemScrollListView.formatRightViewStyle(paramView, 1);
      paramView.setText(2131692498);
      localMailListItemData = ((MailListItemView)localObject2).getItemData();
      localMailListItemData.reset();
      if (localComposeMailUI != null)
      {
        if ((localComposeMailUI.getSendState() != ComposeMailUI.QMComposeState.QMComposeStateFail) && (localComposeMailUI.getSendState() != ComposeMailUI.QMComposeState.QMComposeStateCanceled)) {
          break label750;
        }
        localMailListItemData.statusId = 4;
        if (localComposeMailUI.getClockSendTime() <= 0L) {
          break label780;
        }
        localMailListItemData.stateId = 2;
      }
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      localObject4 = localObject7;
      localObject3 = localObject6;
      paramView = localObject5;
      if (localComposeMailUI != null)
      {
        localObject4 = localObject7;
        localObject3 = localObject6;
        paramView = localObject5;
        if (localComposeMailUI.getInformation() != null)
        {
          paramView = localComposeMailUI.getInformation().getToList();
          localObject3 = localComposeMailUI.getInformation().getCcList();
          localObject4 = localComposeMailUI.getInformation().getBccList();
        }
      }
      ((MailListItemView)localObject2).setShowAvatar(QMSettingManager.sharedInstance().getMailListIcon());
      if ((paramView == null) || (paramView.size() <= 0)) {
        break label877;
      }
      paramView = paramView.get(0);
      if (!(paramView instanceof MailContact)) {
        break label842;
      }
      localObject3 = (MailContact)paramView;
      if ((((MailContact)localObject3).getName() == null) || (((MailContact)localObject3).getName().equals(""))) {
        break label789;
      }
      paramView = ((MailContact)localObject3).getName();
      label329:
      if (paramView != null) {
        break label1521;
      }
      paramView = ((MailContact)localObject3).getAddress();
    }
    label450:
    label584:
    label621:
    label750:
    label1521:
    for (;;)
    {
      localMailListItemData.nickName = (paramView + str);
      localMailListItemData.avatarOptionalName = localMailListItemData.nickName;
      if (((MailListItemView)localObject2).getShowAvatar())
      {
        paramView = localComposeMailUI.getInformation();
        if ((paramView == null) || (paramView.getToAndCCAndBCCList().size() == 0)) {
          break label1329;
        }
        paramView = (MailContact)paramView.getToAndCCAndBCCList().get(0);
        localObject2 = QMPrivateProtocolManager.getPhotoBitmapByEmail(paramView.getAddress(), 3);
        if (localObject2 != null) {
          localMailListItemData.avatarBitmap = ListViewHelper.generateAvatar(new QMAvatar(), (Bitmap)localObject2, localMailListItemData.avatarOptionalName);
        }
      }
      else
      {
        localObject3 = null;
        localObject2 = null;
        paramView = null;
        if (localComposeMailUI.getInformation() != null)
        {
          localObject3 = localComposeMailUI.getInformation().getAttachList();
          localObject2 = localComposeMailUI.getInformation().getBigAttachList();
          paramView = localComposeMailUI.getInformation().getEditAttachList();
        }
        if (((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) || ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) || ((paramView != null) && (paramView.size() > 0)) || ((localComposeMailUI != null) && (localComposeMailUI.getAddAttachInfoList() != null) && (localComposeMailUI.getAddAttachInfoList().size() > 0))) {
          localMailListItemData.hasAttach = true;
        }
        paramView = localComposeMailUI.getInformation().getDate();
        if (paramView == null) {
          break label1353;
        }
        localMailListItemData.dateTime = DateExtension.shortDateName(paramView);
        paramView = localComposeMailUI.getInformation().getSubject();
        if ((paramView != null) && (!paramView.equals(""))) {
          break label1371;
        }
        localMailListItemData.subjectTitle = getContext().getString(2131695645);
        paramView = localQMSendMailTask.getMail();
        if ((paramView instanceof ComposeMailUI))
        {
          if ((localComposeMailUI.getSendState() != ComposeMailUI.QMComposeState.QMComposeStateFail) && (localComposeMailUI.getSendState() != ComposeMailUI.QMComposeState.QMComposeStateCanceled)) {
            break label1443;
          }
          localObject2 = ((ComposeMailUI)paramView).getErrMsg();
          paramView = (View)localObject2;
          if (isExceedAttachLimit((String)localObject2)) {
            paramView = getContext().getString(2131691881);
          }
          if ((paramView != null) && (!paramView.equals(""))) {
            break label1416;
          }
          if (localComposeMailUI.getSendState() != ComposeMailUI.QMComposeState.QMComposeStateFail) {
            break label1398;
          }
          localMailListItemData.abstractText = getContext().getString(2131719534);
        }
        paramView = (View)localObject1;
        break;
        localObject2 = (MailListItemView)((HorizontalScrollItemView)paramView).getContentView();
        localObject1 = paramView;
        break label100;
        if (localComposeMailUI.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateCanceling)
        {
          localMailListItemData.statusId = 6;
          break label172;
        }
        localMailListItemData.statusId = 3;
        break label172;
        localMailListItemData.stateId = 0;
        break label188;
        if ((((MailContact)localObject3).getNick() != null) && (!((MailContact)localObject3).getNick().equals("")))
        {
          paramView = ((MailContact)localObject3).getNick();
          break label329;
        }
        if (((MailContact)localObject3).getAddress() != null)
        {
          paramView = ((MailContact)localObject3).getAddress();
          break label329;
        }
        paramView = "";
        break label329;
        if (!(paramView instanceof MailGroupContact)) {
          break label1516;
        }
        paramView = (MailGroupContact)paramView;
        if (paramView.getName() != null)
        {
          paramView = paramView.getName();
          continue;
        }
        paramView = paramView.getGid();
        continue;
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          paramView = ((ArrayList)localObject3).get(0);
          if ((paramView instanceof MailContact))
          {
            localObject3 = (MailContact)paramView;
            if ((((MailContact)localObject3).getName() != null) && (!((MailContact)localObject3).getName().equals("")))
            {
              paramView = ((MailContact)localObject3).getName();
              if (paramView != null) {
                break label1513;
              }
              paramView = ((MailContact)localObject3).getAddress();
            }
          }
        }
      }
      for (;;)
      {
        localMailListItemData.nickName = (paramView + str);
        localMailListItemData.avatarOptionalName = localMailListItemData.nickName;
        break;
        if ((((MailContact)localObject3).getNick() != null) && (!((MailContact)localObject3).getNick().equals("")))
        {
          paramView = ((MailContact)localObject3).getNick();
          break label937;
        }
        if (((MailContact)localObject3).getAddress() != null)
        {
          paramView = ((MailContact)localObject3).getAddress();
          break label937;
        }
        paramView = "";
        break label937;
        if ((paramView instanceof MailGroupContact))
        {
          paramView = (MailGroupContact)paramView;
          if (paramView.getName() != null)
          {
            paramView = paramView.getName();
          }
          else
          {
            paramView = paramView.getGid();
            continue;
            if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
            {
              paramView = ((ArrayList)localObject4).get(0);
              if ((paramView instanceof MailContact))
              {
                localObject3 = (MailContact)paramView;
                if ((((MailContact)localObject3).getName() != null) && (!((MailContact)localObject3).getName().equals("")))
                {
                  paramView = ((MailContact)localObject3).getName();
                  if (paramView != null) {
                    break label1505;
                  }
                  paramView = ((MailContact)localObject3).getAddress();
                }
              }
            }
            for (;;)
            {
              localMailListItemData.nickName = (paramView + str);
              localMailListItemData.avatarOptionalName = localMailListItemData.nickName;
              break;
              if ((((MailContact)localObject3).getNick() != null) && (!((MailContact)localObject3).getNick().equals("")))
              {
                paramView = ((MailContact)localObject3).getNick();
                break label1132;
              }
              if (((MailContact)localObject3).getAddress() != null)
              {
                paramView = ((MailContact)localObject3).getAddress();
                break label1132;
              }
              paramView = "";
              break label1132;
              if ((paramView instanceof MailGroupContact))
              {
                paramView = (MailGroupContact)paramView;
                if (paramView.getName() != null)
                {
                  paramView = paramView.getName();
                  continue;
                }
                paramView = paramView.getGid();
                continue;
                localMailListItemData.nickName = getContext().getString(2131695643);
                localMailListItemData.avatarOptionalName = localMailListItemData.nickName;
                break;
                QMPrivateProtocolManager.sharedInstance().loadEmailIcon(paramView.getAddress());
                localMailListItemData.avatarBitmap = new QMAvatar().setAvatar(null, localMailListItemData.avatarOptionalName);
                break label450;
                localMailListItemData.avatarBitmap = new QMAvatar().setAvatar(null, localMailListItemData.avatarOptionalName);
                break label450;
                localMailListItemData.dateTime = DateExtension.shortDateName(new Date());
                break label584;
                localMailListItemData.subjectTitle = (paramView + str);
                break label621;
                label1398:
                localMailListItemData.abstractText = getContext().getString(2131719522);
                break label726;
                localMailListItemData.abstractText = (paramView + str);
                break label726;
                if (localComposeMailUI.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateCanceling)
                {
                  localMailListItemData.abstractText = getContext().getString(2131719523);
                  break label726;
                }
                localMailListItemData.abstractText = getContext().getString(2131719535);
                localMailListItemData.progress = localQMSendMailTask.getSendingProgress();
                break label726;
              }
              paramView = null;
            }
          }
        }
        else
        {
          paramView = null;
        }
      }
      paramView = null;
    }
  }
  
  public int isEnabledScroll(int paramInt)
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListAdapter
 * JD-Core Version:    0.7.0.1
 */