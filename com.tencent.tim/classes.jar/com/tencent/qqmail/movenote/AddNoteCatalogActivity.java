package com.tencent.qqmail.movenote;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.view.QMTopBar;

public class AddNoteCatalogActivity
  extends BaseActivityEx
{
  private EditText input;
  private QMTopBar topBar;
  
  private void bindTopBarEvent()
  {
    this.topBar.getButtonLeft().setOnClickListener(new AddNoteCatalogActivity.3(this));
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new AddNoteCatalogActivity.4(this));
    localMailManagerDelegate.setOnError(new AddNoteCatalogActivity.5(this));
    this.topBar.getButtonRight().setOnClickListener(new AddNoteCatalogActivity.6(this, localMailManagerDelegate));
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), AddNoteCatalogActivity.class);
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(getString(2131696403)).setButtonLeftNormal(2131691246).setButtonRightBlue(2131693745);
    View localView = this.topBar.getButtonRight();
    if (this.input.getText().toString().length() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localView.setEnabled(bool);
      return;
    }
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    this.input = ((EditText)findViewById(2131364342));
    this.input.postDelayed(new AddNoteCatalogActivity.1(this), 300L);
    initTopBar();
  }
  
  public void initUI()
  {
    setContentView(2131559524);
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Helper.initEditTextAndClearButton((EditText)findViewById(2131364342), (Button)findViewById(2131364664));
    bindTopBarEvent();
    this.input.addTextChangedListener(new AddNoteCatalogActivity.2(this));
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.AddNoteCatalogActivity
 * JD-Core Version:    0.7.0.1
 */