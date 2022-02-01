package com.tencent.qqmail.activity.setting;

import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.LoginType;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class SettingCalendarDefaultFragment
  extends SettingCalendarBaseFragment
{
  private int defaultFolderId;
  private HashMap<Integer, Integer> folderIDANDAccountIDMap = new HashMap();
  private QMBaseView mBaseView;
  private QMTopBar mTopBar = null;
  private QMCalendarManager qmCalendarManager = QMCalendarManager.getInstance();
  private ArrayList<QMRadioGroup> radioGroups = new ArrayList();
  private int selectFolderId;
  
  protected SettingCalendarDefaultFragment()
  {
    super(false);
  }
  
  private void createDefaultCalendarView()
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList().toArrayList();
    ((List)localObject1).add(this.qmCalendarManager.getLocalAccount());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Account)((Iterator)localObject1).next();
      Object localObject3 = QMCalendarManager.getInstance().getSortedCalendarFoldersByAccountId(((Account)localObject2).getId());
      if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty()))
      {
        int i = 0;
        QMRadioGroup localQMRadioGroup = new QMRadioGroup(getActivity());
        Object localObject4;
        if (((Account)localObject2).getId() != 0)
        {
          localObject4 = QMCalendarProtocolManager.getLoginTypeWithAccountTypeNone((Account)localObject2);
          localQMRadioGroup.setCaption(((QMCalendarProtocolManager.LoginType)localObject4).getName() + "(" + ((Account)localObject2).getEmail() + ")");
        }
        for (;;)
        {
          localObject2 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (QMCalendarFolder)((Iterator)localObject2).next();
            int j = i;
            if (((QMCalendarFolder)localObject4).isEditable())
            {
              j = i;
              if (((QMCalendarFolder)localObject4).isSelfFolder())
              {
                j = 1;
                i = ((QMCalendarFolder)localObject4).getAccountId();
                int k = ((QMCalendarFolder)localObject4).getId();
                localObject3 = DrawBitmapUtil.drawCircle(getActivity(), QMUIHelper.getCalendarColor(getActivity(), (QMCalendarFolder)localObject4), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE);
                localObject4 = localQMRadioGroup.addItem(k, ((QMCalendarFolder)localObject4).getName()).getTitleView();
                ((TextView)localObject4).setCompoundDrawables((Drawable)localObject3, null, null, null);
                ((TextView)localObject4).setCompoundDrawablePadding(10);
                this.folderIDANDAccountIDMap.put(Integer.valueOf(k), Integer.valueOf(i));
              }
            }
            i = j;
          }
          localQMRadioGroup.setCaption(((Account)localObject2).getName());
        }
        localQMRadioGroup.setOnCheckedChangeListener(new SettingCalendarDefaultFragment.2(this));
        if (i != 0)
        {
          this.mBaseView.addContentView(localQMRadioGroup);
          this.radioGroups.add(localQMRadioGroup);
        }
        localQMRadioGroup.commit();
        localQMRadioGroup.setSelectedItem(this.selectFolderId);
      }
    }
  }
  
  private void onBack()
  {
    if (this.selectFolderId != this.defaultFolderId) {
      this.qmCalendarManager.modifyDefaultAccountAndFolder(((Integer)this.folderIDANDAccountIDMap.get(Integer.valueOf(this.selectFolderId))).intValue(), this.selectFolderId);
    }
    popBackStack();
  }
  
  public QMTopBar getTopBar()
  {
    if (this.mTopBar == null) {
      this.mTopBar = new QMTopBar(getActivity());
    }
    return this.mTopBar;
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.defaultFolderId = this.qmCalendarManager.getDefaultFolderId();
    this.selectFolderId = this.defaultFolderId;
    createDefaultCalendarView();
  }
  
  public void initTopbar(View paramView)
  {
    this.mTopBar = getTopBar();
    this.mTopBar.setTitle(2131719687);
    this.mTopBar.setButtonLeftBack();
    this.mTopBar.setButtonLeftOnclickListener(new SettingCalendarDefaultFragment.1(this));
    this.mBaseView.addView(this.mTopBar);
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = new QMBaseView(getActivity());
    this.mBaseView.initScrollView();
    return this.mBaseView;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    onBack();
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarDefaultFragment
 * JD-Core Version:    0.7.0.1
 */