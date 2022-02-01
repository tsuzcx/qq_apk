package com.tencent.qqmail.attachment.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.utilities.StatusBarUtil;
import java.util.ArrayList;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;

public class AttachFolderComposeActivity
  extends BaseFragmentActivity
{
  public static final String ARG_FAV_SELECTED_ATTACH_ID_LIST = "arg_fav_selected_attach_id_list";
  public static final String TAG = "AttachFolderComposeActivity";
  
  public int getContextViewId()
  {
    return 2131367566;
  }
  
  public int getHistorySize()
  {
    return QMActivityManager.shareInstance().getActivitySize();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(null);
    StatusBarUtil.immerseWhite(this);
    paramBundle = new AttachFolderListFragment(true, (ArrayList)getIntent().getSerializableExtra("arg_fav_selected_attach_id_list"));
    getSupportFragmentManager().beginTransaction().add(2131367566, paramBundle, paramBundle.getClass().getSimpleName()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderComposeActivity
 * JD-Core Version:    0.7.0.1
 */