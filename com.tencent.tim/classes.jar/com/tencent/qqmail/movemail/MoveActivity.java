package com.tencent.qqmail.movemail;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMTopBar;

public abstract class MoveActivity
  extends BaseActivityEx
{
  protected QMBottomBar mBottomBar;
  protected ListView mListView;
  
  protected abstract View.OnClickListener getBottomBarListener();
  
  protected abstract String getBottomText();
  
  protected abstract String getTitleText();
  
  public void initDataSource() {}
  
  public void initDom()
  {
    Object localObject = getTopBar();
    ((QMTopBar)localObject).setTitle(getTitleText());
    ((QMTopBar)localObject).setButtonLeftNormal(2131691246);
    ((QMTopBar)localObject).setButtonRightBlue(2131696547);
    ((QMTopBar)localObject).getButtonRight().setOnClickListener(new MoveActivity.1(this));
    ((QMTopBar)localObject).getButtonLeft().setOnClickListener(new MoveActivity.2(this));
    localObject = this.mBottomBar.addButton(0, getBottomText(), getBottomBarListener());
    ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject).getLayoutParams();
    localLayoutParams.width = QMUIKit.dpToPx(150);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
  }
  
  public void initUI()
  {
    QMBaseView localQMBaseView = initBaseView(this);
    this.mListView = localQMBaseView.addPtrListView(false);
    this.mBottomBar = new QMBottomBar(this);
    localQMBaseView.addView(this.mBottomBar);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, getResources().getDimensionPixelSize(2131297365));
    localQMBaseView.setBackgroundColor(ActivityCompat.getColor(this, 2131167681));
    this.mListView.setLayoutParams(localLayoutParams);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  protected abstract boolean onClickConfirm(View paramView);
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.MoveActivity
 * JD-Core Version:    0.7.0.1
 */