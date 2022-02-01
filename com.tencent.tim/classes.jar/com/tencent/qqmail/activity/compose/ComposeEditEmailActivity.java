package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.contacts.view.ContactBaseItemView.ContactItemType;
import com.tencent.qqmail.activity.contacts.view.ContactEditComposeEmailView;
import com.tencent.qqmail.activity.contacts.view.ContactTableView;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComposeEditEmailActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNTID = "arg_account_id";
  private static final String ARG_EMAIL = "arg_email";
  private int accountId;
  private QMBaseView baseView;
  private ContactEditComposeEmailView emailItemView;
  private String newEmail;
  private String newName;
  private List<String> newNameAndEmail;
  private String oldEmail;
  private String oldName;
  private List<String> originalNameAndEmail;
  private QMTopBar topBar;
  
  public static Intent createIntent(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ComposeEditEmailActivity.class);
    localIntent.putExtra("arg_email", paramString);
    localIntent.putExtra("arg_account_id", paramInt);
    return localIntent;
  }
  
  private List<String> getNameAndEmail(String paramString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramString = Pattern.compile("(.*?)<(.*?)>").matcher(paramString);
    if (paramString.find())
    {
      localArrayList.add(paramString.group(1));
      localArrayList.add(paramString.group(2));
    }
    return localArrayList;
  }
  
  private void initTopBar()
  {
    this.topBar = this.baseView.getTopBar();
    this.topBar.setTitle(2131692033);
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.getButtonLeft().setOnClickListener(new ComposeEditEmailActivity.1(this));
    this.topBar.setButtonRightBlue(2131693745);
    this.topBar.setButtonRightOnclickListener(new ComposeEditEmailActivity.2(this));
  }
  
  public void initDataSource()
  {
    this.oldEmail = getIntent().getStringExtra("arg_email");
    this.originalNameAndEmail = getNameAndEmail(this.oldEmail);
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
  }
  
  public void initDom() {}
  
  public void initUI()
  {
    this.baseView = initScrollView(this);
    initTopBar();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render()
  {
    if (this.emailItemView == null)
    {
      ContactTableView localContactTableView = new ContactTableView(getActivity());
      this.emailItemView = new ContactEditComposeEmailView(getActivity());
      this.emailItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_EMAIL);
      this.emailItemView.setNodeInputText(this.oldEmail);
      if (this.emailItemView.getNodeInput() != null) {
        this.emailItemView.getNodeInput().setPadding(0, this.emailItemView.getNodeInput().getPaddingTop(), this.emailItemView.getNodeInput().getPaddingRight(), this.emailItemView.getNodeInput().getPaddingBottom());
      }
      this.emailItemView.setRequestFocus();
      this.emailItemView.hideLabel();
      if (this.emailItemView.getIconClear() != null) {
        this.emailItemView.getIconClear().setVisibility(0);
      }
      localContactTableView.addView(this.emailItemView);
      this.baseView.addContentView(localContactTableView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeEditEmailActivity
 * JD-Core Version:    0.7.0.1
 */