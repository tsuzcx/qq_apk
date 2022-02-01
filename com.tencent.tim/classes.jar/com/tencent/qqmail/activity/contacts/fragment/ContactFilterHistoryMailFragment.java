package com.tencent.qqmail.activity.contacts.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ContactFilterHistoryMailFragment
  extends ContactsBaseFragment
{
  public static final String ARG_CHECKED_ACCOUNTS_RESULT = "ARG_CHECKED_ACCOUNTS_RESULT";
  public static final String ARG_CHECKED_EMAILS_RESULT = "ARG_CHECKED_EMAILS_RESULT";
  public static final String TAG = "ContactFilterHistoryMailFragment";
  private List<Integer> checkedAccountsId;
  private List<String> contactCheckEmails;
  private List<String> contactEmails;
  private String contactName;
  public AccountList mAccountsList;
  public BaseAdapter mAdapter;
  public List<DataHolder> mData;
  private QMBaseView mDector;
  private UITableView mEmailSelectView;
  private UITableView mTableView;
  
  public ContactFilterHistoryMailFragment(List<Integer> paramList, List<String> paramList1, List<String> paramList2, String paramString)
  {
    super(true);
    this.checkedAccountsId = paramList;
    this.contactEmails = paramList1;
    this.contactCheckEmails = paramList2;
    this.contactName = paramString;
  }
  
  private static ArrayList<String> extractCheckedEmails(List<DataHolder> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DataHolder localDataHolder = (DataHolder)paramList.next();
      if ((localDataHolder.email != null) && (localDataHolder.mChecked)) {
        localArrayList.add(localDataHolder.email);
      }
    }
    return localArrayList;
  }
  
  private static ArrayList<Integer> extractCheckedIds(List<DataHolder> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DataHolder localDataHolder = (DataHolder)paramList.next();
      if ((localDataHolder.mAcc != null) && (localDataHolder.mChecked)) {
        localArrayList.add(Integer.valueOf(localDataHolder.mAcc.getId()));
      }
    }
    return localArrayList;
  }
  
  private View.OnClickListener getClickCallback(DataHolder paramDataHolder)
  {
    return new ContactFilterHistoryMailFragment.1(this, paramDataHolder);
  }
  
  protected void finishWithData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ARG_CHECKED_ACCOUNTS_RESULT", extractCheckedIds(this.mData));
    localHashMap.put("ARG_CHECKED_EMAILS_RESULT", extractCheckedEmails(this.mData));
    setFragmentResult(-1, localHashMap);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.mTableView = new UITableView(getActivity());
    this.mDector.addContentView(this.mTableView);
    this.mEmailSelectView = new UITableView(getActivity());
    this.mDector.addContentView(this.mEmailSelectView);
  }
  
  public void initTopbar(View paramView)
  {
    paramView = ((QMBaseView)paramView).getTopBar();
    paramView.setButtonLeftBack();
    paramView.getButtonLeft().setOnClickListener(new ContactFilterHistoryMailFragment.2(this));
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mDector = new QMBaseView(getActivity());
    this.mDector.initScrollView();
    this.mDector.setBackgroundColor(getResources().getColor(2131167654));
    initTopbar(this.mDector);
    return this.mDector;
  }
  
  public void onBackPressed()
  {
    finishWithData();
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    this.mTableView.clear();
    this.mEmailSelectView.clear();
    this.mEmailSelectView.setVisibility(8);
    this.mTableView.setVisibility(8);
    this.mAccountsList = AccountManager.shareInstance().getAccountList();
    this.mData = Lists.newArrayList();
    Iterator localIterator1;
    Object localObject1;
    Object localObject2;
    if (this.mAccountsList != null)
    {
      localIterator1 = this.mAccountsList.iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (Account)localIterator1.next();
        localObject2 = new DataHolder(null);
        ((DataHolder)localObject2).mAcc = ((Account)localObject1);
        ((DataHolder)localObject2).mChecked = this.checkedAccountsId.contains(Integer.valueOf(((Account)localObject1).getId()));
        this.mData.add(localObject2);
      }
    }
    if ((this.mAccountsList != null) && (this.mAccountsList.size() > 1))
    {
      localIterator1 = this.mData.iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (DataHolder)localIterator1.next();
        if (((DataHolder)localObject1).mAcc != null)
        {
          localObject2 = this.mTableView.addItem(((DataHolder)localObject1).mAcc.getEmail());
          ((UITableItemView)localObject2).setTailImage(2130850509);
          ((UITableItemView)localObject2).setChecked(((DataHolder)localObject1).mChecked);
          ((UITableItemView)localObject2).setOnClickListener(getClickCallback((DataHolder)localObject1));
        }
      }
      this.mTableView.setVisibility(0);
      this.mTableView.setCaption(2131696157);
      this.mTableView.getCaptionView().setBackgroundColor(getResources().getColor(2131167654));
      this.mTableView.commit();
    }
    if (this.contactEmails != null)
    {
      localIterator1 = this.contactEmails.iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (String)localIterator1.next();
        localObject2 = new DataHolder(null);
        ((DataHolder)localObject2).email = ((String)localObject1);
        ((DataHolder)localObject2).mChecked = false;
        Iterator localIterator2 = this.contactCheckEmails.iterator();
        while (localIterator2.hasNext()) {
          if (((String)localIterator2.next()).equals(localObject1)) {
            ((DataHolder)localObject2).mChecked = true;
          }
        }
        this.mData.add(localObject2);
      }
    }
    if ((this.contactEmails != null) && (this.contactEmails.size() > 1))
    {
      this.mEmailSelectView.setVisibility(0);
      if (this.contactName != null) {
        this.mEmailSelectView.setCaption(String.format(getString(2131719413), new Object[] { this.contactName }));
      }
      localIterator1 = this.mData.iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (DataHolder)localIterator1.next();
        if (((DataHolder)localObject1).email != null)
        {
          localObject2 = this.mEmailSelectView.addItem(((DataHolder)localObject1).email);
          ((UITableItemView)localObject2).setTailImage(2130850509);
          ((UITableItemView)localObject2).setChecked(((DataHolder)localObject1).mChecked);
          ((UITableItemView)localObject2).setOnClickListener(getClickCallback((DataHolder)localObject1));
        }
      }
      this.mEmailSelectView.getCaptionView().setBackgroundColor(getResources().getColor(2131167654));
      this.mEmailSelectView.commit();
    }
    return 0;
  }
  
  public void render(int paramInt) {}
  
  class DataHolder
  {
    public String email;
    public Account mAcc;
    public boolean mChecked = false;
    
    private DataHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactFilterHistoryMailFragment
 * JD-Core Version:    0.7.0.1
 */