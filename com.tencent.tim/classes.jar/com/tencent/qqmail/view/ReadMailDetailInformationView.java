package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.moai.downloader.util.StringUtil;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class ReadMailDetailInformationView
  extends FrameLayout
{
  private static final String TAG = "ReadMailInfomationView";
  private ViewGroup SummaryView;
  private Drawable attachImage;
  private TextView attachName;
  private LinearLayout ccLayout;
  private LinearLayout ccPerentLayout;
  private boolean detailRendered;
  private LinearLayout detailView;
  private MailContact fromContact;
  private int fromFolderType = -1;
  private TextView fromLabelView;
  private LinearLayout fromLayout;
  private LinearLayout fromPerentLayout;
  private TextView groupLabel;
  private LinearLayout groupLayout;
  private MailGroupContactClickListener groupListener;
  private LinearLayout groupPerentLayout;
  private ImageView importantLinkMan;
  private LayoutInflater inflater;
  MailContact mContact;
  private MailContactClickListener mailListener;
  private TextView sendTime;
  private LinearLayout senderLayout;
  private LinearLayout senderPerentLayout;
  private LinearLayout sepLayout;
  private LinearLayout sepParentLayout;
  private TextView summaryAttach;
  private TextView summaryNickName;
  
  public ReadMailDetailInformationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.inflater = LayoutInflater.from(paramContext);
    this.detailView = ((LinearLayout)this.inflater.inflate(2131562908, null));
    this.SummaryView = ((ViewGroup)this.inflater.inflate(2131562939, null));
    this.summaryNickName = ((TextView)this.SummaryView.findViewById(2131372384));
    this.importantLinkMan = ((ImageView)this.SummaryView.findViewById(2131369121));
    this.importantLinkMan.setVisibility(0);
    this.groupLabel = ((TextView)this.SummaryView.findViewById(2131368180));
    this.summaryAttach = ((TextView)this.SummaryView.findViewById(2131363032));
    this.groupPerentLayout = ((LinearLayout)this.detailView.findViewById(2131368147));
    this.groupLayout = ((LinearLayout)this.groupPerentLayout.findViewById(2131381467));
    this.fromPerentLayout = ((LinearLayout)this.detailView.findViewById(2131367736));
    this.fromLayout = ((LinearLayout)this.fromPerentLayout.findViewById(2131367739));
    this.fromLabelView = ((TextView)this.fromPerentLayout.findViewById(2131367737));
    this.senderPerentLayout = ((LinearLayout)this.detailView.findViewById(2131378018));
    this.senderLayout = ((LinearLayout)this.senderPerentLayout.findViewById(2131381467));
    this.ccPerentLayout = ((LinearLayout)this.detailView.findViewById(2131364373));
    this.ccLayout = ((LinearLayout)this.ccPerentLayout.findViewById(2131381467));
    this.sepParentLayout = ((LinearLayout)this.detailView.findViewById(2131378041));
    this.sepLayout = ((LinearLayout)this.sepParentLayout.findViewById(2131381467));
    this.sendTime = ((TextView)this.detailView.findViewById(2131379661).findViewById(2131381467));
    this.attachName = ((TextView)this.detailView.findViewById(2131363032).findViewById(2131381467));
    addView(this.detailView);
    addView(this.SummaryView);
  }
  
  private void addArressButtonToView(ArrayList<Object> paramArrayList, LinearLayout paramLinearLayout, MailUI paramMailUI)
  {
    paramLinearLayout.removeAllViews();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    int i = 0;
    LinearLayout localLinearLayout;
    Object localObject1;
    TextView localTextView;
    Object localObject2;
    if (i < paramArrayList.size())
    {
      localLinearLayout = (LinearLayout)this.inflater.inflate(2131562935, null);
      localObject1 = (TextView)localLinearLayout.findViewById(2131372369);
      localTextView = (TextView)localLinearLayout.findViewById(2131362252);
      localObject2 = (TextView)localLinearLayout.findViewById(2131378019);
      if (!(paramArrayList.get(i) instanceof MailContact)) {
        break label549;
      }
    }
    for (;;)
    {
      try
      {
        this.mContact = ((MailContact)paramArrayList.get(i));
        if (this.mContact != null)
        {
          Object localObject3 = this.mContact.getAddress();
          String str = this.mContact.getName();
          localObject3 = QMContactManager.sharedInstance().getPossibleNickname(paramMailUI.getInformation().getAccountId(), (String)localObject3, str, paramMailUI);
          ((TextView)localObject1).setText((String)localObject3 + QMUIKit.ELLIPSIZE_FIXED);
          if (((this.mContact.getAddress() != null) && (this.mContact.getAddress().contains("@groupmail.qq.com"))) || ((paramMailUI.getStatus() != null) && (paramMailUI.getStatus().isGroupMail())))
          {
            localTextView.setVisibility(8);
            localObject3 = new MailGroupContact();
            localObject2 = paramMailUI.getInformation().getGroupId();
            localObject1 = localObject2;
            if (!StringUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = ((String)localObject2).replaceFirst("(@group.qq.com)*$", "@group.qq.com");
            }
            ((MailGroupContact)localObject3).setGid((String)localObject1);
            ((MailGroupContact)localObject3).setName(this.mContact.getName());
            ((MailGroupContact)localObject3).setNick(this.mContact.getNick());
            localTextView.setVisibility(8);
            localLinearLayout.setTag(localObject3);
            paramLinearLayout.addView(localLinearLayout, localLayoutParams);
            localLinearLayout.setOnClickListener(new ReadMailDetailInformationView.3(this, (MailGroupContact)localObject3));
          }
        }
        else
        {
          i += 1;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "ReadMailInfomationView", localException.toString());
        continue;
        localTextView.setText(this.mContact.getAddress() + QMUIKit.ELLIPSIZE_FIXED);
        localTextView.setVisibility(0);
        if ((paramLinearLayout == this.fromLayout) && (paramMailUI.getInformation() != null) && (paramMailUI.getInformation().getSender() != null) && (!StringUtil.isNullOrEmpty(paramMailUI.getInformation().getSender().getAddress())) && (!this.mContact.getAddress().equals(paramMailUI.getInformation().getSender().getAddress())))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText(String.format("(由 %s 代发)", new Object[] { paramMailUI.getInformation().getSender().getAddress() }));
        }
        if (this.mContact.getAddress() != null) {
          break label515;
        }
      }
      localTextView.setVisibility(8);
      return;
      label515:
      localLinearLayout.setTag(this.mContact);
      paramLinearLayout.addView(localLinearLayout, localLayoutParams);
      localLinearLayout.setOnClickListener(new ReadMailDetailInformationView.4(this, paramMailUI));
      continue;
      label549:
      if (!(paramArrayList.get(i) instanceof MailGroupContact)) {
        break label641;
      }
      localObject2 = (MailGroupContact)paramArrayList.get(i);
      ((TextView)localObject1).setText(((MailGroupContact)localObject2).getName() + QMUIKit.ELLIPSIZE_FIXED);
      localTextView.setVisibility(8);
      localLinearLayout.setTag(localObject2);
      paramLinearLayout.addView(localLinearLayout, localLayoutParams);
      localLinearLayout.setOnClickListener(new ReadMailDetailInformationView.5(this, (MailGroupContact)localObject2));
    }
    label641:
    throw new DevRuntimeException(paramArrayList.get(i).getClass().toString());
  }
  
  private void renderDetail(MailUI paramMailUI)
  {
    renderDetailArress(paramMailUI);
    renderDetailTime(paramMailUI);
    renderDetailAttach(paramMailUI);
  }
  
  private void renderDetailArress(MailUI paramMailUI)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMailUI.getStatus() != null) && (paramMailUI.getStatus().isGroupMail()))
    {
      this.groupPerentLayout.setVisibility(0);
      this.fromPerentLayout.setVisibility(8);
      this.senderPerentLayout.setVisibility(8);
      this.ccPerentLayout.setVisibility(8);
      this.sepParentLayout.setVisibility(8);
      localArrayList.add(paramMailUI.getInformation().getFrom());
      addArressButtonToView(localArrayList, (LinearLayout)this.groupPerentLayout.findViewById(2131381467), paramMailUI);
    }
    do
    {
      return;
      this.groupPerentLayout.setVisibility(8);
      this.fromPerentLayout.setVisibility(0);
      this.senderPerentLayout.setVisibility(0);
      this.ccPerentLayout.setVisibility(0);
      this.sepParentLayout.setVisibility(0);
      localArrayList.add(paramMailUI.getInformation().getFrom());
      addArressButtonToView(localArrayList, this.fromLayout, paramMailUI);
      if (paramMailUI.getInformation().getToList() != null) {
        addArressButtonToView(paramMailUI.getInformation().getToList(), this.senderLayout, paramMailUI);
      }
      if (paramMailUI.getInformation().getCcList() != null) {
        addArressButtonToView(paramMailUI.getInformation().getCcList(), this.ccLayout, paramMailUI);
      }
    } while ((paramMailUI.getInformation().getBccList() == null) || (!paramMailUI.getStatus().isSepCpy()));
    addArressButtonToView(paramMailUI.getInformation().getBccList(), this.sepLayout, paramMailUI);
  }
  
  private void renderDetailAttach(MailUI paramMailUI)
  {
    int i;
    int j;
    label42:
    int k;
    label64:
    int m;
    if (paramMailUI.getInformation().getAttachListNoInlineImg() != null)
    {
      i = paramMailUI.getInformation().getAttachListNoInlineImg().size();
      if (paramMailUI.getInformation().getBigAttachList() == null) {
        break label203;
      }
      j = paramMailUI.getInformation().getBigAttachList().size();
      if (paramMailUI.getInformation().getEditAttachList() == null) {
        break label208;
      }
      k = paramMailUI.getInformation().getEditAttachList().size();
      m = i + j + k;
      if (m <= 0) {
        break label296;
      }
      this.detailView.findViewById(2131363032).setVisibility(0);
      if (i <= 0) {
        break label214;
      }
      paramMailUI = ((Attach)paramMailUI.getInformation().getAttachListNoInlineImg().get(0)).getName();
    }
    for (;;)
    {
      label112:
      AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramMailUI))).name().toLowerCase(Locale.getDefault());
      if (m == 1) {
        this.attachName.setText(paramMailUI);
      }
      for (;;)
      {
        this.attachImage = getResources().getDrawable(2130841063);
        this.attachImage.setBounds(0, 0, this.attachImage.getMinimumWidth(), this.attachImage.getMinimumHeight());
        this.attachName.setCompoundDrawables(this.attachImage, null, null, null);
        return;
        i = 0;
        break;
        label203:
        j = 0;
        break label42;
        label208:
        k = 0;
        break label64;
        label214:
        if (j > 0)
        {
          paramMailUI = ((MailBigAttach)paramMailUI.getInformation().getBigAttachList().get(0)).getName();
          break label112;
        }
        if (k <= 0) {
          break label311;
        }
        paramMailUI = ((MailEditAttach)paramMailUI.getInformation().getEditAttachList().get(0)).getName();
        break label112;
        this.attachName.setText(m + "个");
      }
      label296:
      this.detailView.findViewById(2131363032).setVisibility(8);
      return;
      label311:
      paramMailUI = "";
    }
  }
  
  private void renderDetailTime(MailUI paramMailUI)
  {
    this.sendTime.setText(DateExtension.fullDateName_yyyyMMddHHmm(paramMailUI.getInformation().getDate()));
  }
  
  private void renderSummer(MailUI paramMailUI)
  {
    MailInformation localMailInformation = paramMailUI.getInformation();
    int i;
    int j;
    label40:
    int k;
    label58:
    Object localObject;
    if (localMailInformation.getAttachListNoInlineImg() != null)
    {
      i = localMailInformation.getAttachListNoInlineImg().size();
      if (localMailInformation.getBigAttachList() == null) {
        break label265;
      }
      j = localMailInformation.getBigAttachList().size();
      if (localMailInformation.getEditAttachList() == null) {
        break label270;
      }
      k = localMailInformation.getEditAttachList().size();
      i = i + j + k;
      localObject = paramMailUI.getStatus();
      if (localObject == null) {
        break label324;
      }
      if (!((MailStatus)localObject).isGroupMail()) {
        break label276;
      }
      this.groupLabel.setVisibility(0);
      label92:
      if ((!localMailInformation.getFrom().isVip()) && (!QMContactManager.sharedInstance().isVipAddressForAccount(localMailInformation.getAccountId(), localMailInformation.getFrom().getAddress())) && (!QMContactManager.sharedInstance().isVipAddress(localMailInformation.getFrom().getAddress()))) {
        break label300;
      }
      if (((MailStatus)localObject).isGroupMail()) {
        break label288;
      }
      this.importantLinkMan.setVisibility(0);
      label158:
      if (i <= 0) {
        break label312;
      }
      this.summaryAttach.setVisibility(0);
      this.summaryAttach.setText(Integer.toString(i));
    }
    for (;;)
    {
      this.fromContact = localMailInformation.getFrom();
      if (this.fromContact != null)
      {
        localObject = this.fromContact.getName();
        String str = this.fromContact.getAddress();
        paramMailUI = QMContactManager.sharedInstance().getPossibleNickname(localMailInformation.getAccountId(), str, (String)localObject, paramMailUI);
        this.summaryNickName.setText(paramMailUI + QMUIKit.ELLIPSIZE_FIXED);
      }
      return;
      i = 0;
      break;
      label265:
      j = 0;
      break label40;
      label270:
      k = 0;
      break label58;
      label276:
      this.groupLabel.setVisibility(8);
      break label92;
      label288:
      this.importantLinkMan.setVisibility(8);
      break label158;
      label300:
      this.importantLinkMan.setVisibility(8);
      break label158;
      label312:
      this.summaryAttach.setVisibility(8);
      continue;
      label324:
      this.groupLabel.setVisibility(8);
      this.summaryAttach.setVisibility(8);
    }
  }
  
  public int getFromFolderType()
  {
    return this.fromFolderType;
  }
  
  public void onMailContactClick(View paramView, MailContact paramMailContact, int paramInt)
  {
    if (this.mailListener == null)
    {
      QMLog.log(6, "ReadMailInfomationView", "mailListner is null!!");
      return;
    }
    if (paramView == null)
    {
      Log.w("ReadMailInfomationView", "click view is null!!");
      return;
    }
    if (paramMailContact == null)
    {
      Log.w("ReadMailInfomationView", "mailContact is null!!");
      return;
    }
    this.mailListener.onClick(paramView, paramMailContact, paramInt);
  }
  
  public void render(MailUI paramMailUI, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      renderDetail(paramMailUI);
      this.detailRendered = true;
      this.detailView.setVisibility(0);
      this.SummaryView.setVisibility(8);
      if ((paramMailUI.getInformation().getCcList() == null) || (paramMailUI.getInformation().getCcList().size() == 0)) {
        this.ccPerentLayout.setVisibility(8);
      }
      if (((getFromFolderType() != 3) && (getFromFolderType() != 4)) || ((paramMailUI.getStatus() != null) && (!paramMailUI.getStatus().isSepCpy())) || (paramMailUI.getInformation().getBccList() == null) || (paramMailUI.getInformation().getBccList().size() == 0)) {
        this.sepParentLayout.setVisibility(8);
      }
      if ((paramMailUI.getInformation().getToList() == null) || (paramMailUI.getInformation().getToList().size() == 0)) {
        this.senderPerentLayout.setVisibility(8);
      }
      return;
    }
    renderSummer(paramMailUI);
    this.detailRendered = false;
    this.detailView.setVisibility(8);
    this.SummaryView.setVisibility(0);
    if (((this.fromContact.getAddress() != null) && (this.fromContact.getAddress().contains("@groupmail.qq.com"))) || ((paramMailUI.getStatus() != null) && (paramMailUI.getStatus().isGroupMail())))
    {
      MailGroupContact localMailGroupContact = new MailGroupContact();
      String str = paramMailUI.getInformation().getGroupId();
      paramMailUI = str;
      if (!StringUtils.isEmpty(str)) {
        paramMailUI = str.replaceFirst("(@group.qq.com)*$", "@group.qq.com");
      }
      localMailGroupContact.setGid(paramMailUI);
      localMailGroupContact.setName(this.fromContact.getName());
      localMailGroupContact.setNick(this.fromContact.getNick());
      this.summaryNickName.setOnClickListener(new ReadMailDetailInformationView.1(this, localMailGroupContact));
      return;
    }
    this.summaryNickName.setOnClickListener(new ReadMailDetailInformationView.2(this));
  }
  
  public void setFromFolderType(int paramInt)
  {
    this.fromFolderType = paramInt;
  }
  
  public void setMailContactClickListener(MailContactClickListener paramMailContactClickListener)
  {
    this.mailListener = paramMailContactClickListener;
  }
  
  public void setMailGroupContactClickListener(MailGroupContactClickListener paramMailGroupContactClickListener)
  {
    this.groupListener = paramMailGroupContactClickListener;
  }
  
  public void setShowAttachOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.attachName.setOnClickListener(paramOnClickListener);
    this.summaryAttach.setOnClickListener(paramOnClickListener);
  }
  
  public static abstract interface MailContactClickListener
  {
    public static final int CHECK_CONTACT = 0;
    public static final int COMPOSE_MAIL = 2;
    public static final int COPY_MAIL = 3;
    public static final int CREATE_CONTACT = 1;
    
    public abstract void onClick(View paramView, MailContact paramMailContact, int paramInt);
  }
  
  public static abstract interface MailGroupContactClickListener
  {
    public abstract void onClick(View paramView, MailGroupContact paramMailGroupContact);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailDetailInformationView
 * JD-Core Version:    0.7.0.1
 */