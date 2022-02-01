package com.tencent.qqmail.accountlist.fragment;

import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

public class FolderChoserActivity
  extends BaseActivityEx
{
  public static final String TAG = "FolderChoserActivity";
  private static ArrayList<Pair<QMFolder, boolean[]>> sFolderData;
  private ArrayList<Pair<QMFolder, boolean[]>> mFolderData;
  public ListView mListView = null;
  private QMTopBar topBar;
  
  public static Intent createIntent(@NonNull ArrayList<Pair<QMFolder, boolean[]>> paramArrayList)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), FolderChoserActivity.class);
    sFolderData = paramArrayList;
    return localIntent;
  }
  
  public void initDataSource()
  {
    this.mFolderData = sFolderData;
    sFolderData = null;
  }
  
  public void initDom()
  {
    this.mListView = ((ListView)findViewById(2131367369));
    FolderChoserActivity.1 local1 = new FolderChoserActivity.1(this, this, 2131559338, 2131367376, this.mFolderData);
    this.mListView.setAdapter(local1);
    this.mListView.setOnItemClickListener(new FolderChoserActivity.2(this, local1));
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setButtonLeftBack().setButtonRightBlue(2131693745).setTitle(2131689645);
    this.topBar.getButtonLeft().setOnClickListener(new FolderChoserActivity.3(this));
    this.topBar.getButtonRight().setOnClickListener(new FolderChoserActivity.4(this));
  }
  
  public void initUI()
  {
    setContentView(2131559336);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.FolderChoserActivity
 * JD-Core Version:    0.7.0.1
 */