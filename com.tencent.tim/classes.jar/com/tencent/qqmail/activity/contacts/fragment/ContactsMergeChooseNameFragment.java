package com.tencent.qqmail.activity.contacts.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.view.QMTopBar;
import java.util.HashMap;
import java.util.List;

public class ContactsMergeChooseNameFragment
  extends ContactsBaseFragment
{
  private static String TAG = ContactsMergeFragment.class.getSimpleName();
  private ContactsMergeChooseNameAdapter adaptor;
  private int itemIndexInMergeByEmail;
  private List<MailContact> mContacts;
  private boolean[] mWhichNameChoose;
  private int nameIndex;
  private ListView nameListView;
  
  protected ContactsMergeChooseNameFragment(int paramInt1, int paramInt2, List<MailContact> paramList)
  {
    super(false);
    this.itemIndexInMergeByEmail = paramInt1;
    this.nameIndex = paramInt2;
    this.mContacts = paramList;
    this.mWhichNameChoose = new boolean[this.mContacts.size()];
    this.mWhichNameChoose[paramInt2] = true;
  }
  
  private void initListView(View paramView)
  {
    this.nameListView = ((ListView)paramView.findViewById(2131365303));
    this.adaptor = new ContactsMergeChooseNameAdapter(this.mContacts, this.mWhichNameChoose);
    this.nameListView.setAdapter(this.adaptor);
    this.nameListView.setOnItemClickListener(new ContactsMergeChooseNameFragment.1(this));
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setButtonLeftOnclickListener(new ContactsMergeChooseNameFragment.2(this));
    localQMTopBar.setCenterOnclickListener(new ContactsMergeChooseNameFragment.3(this));
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initListView(paramView);
    initTopBar();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = (FrameLayout)super.initUI(paramViewHolder);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    View localView = View.inflate(getActivity(), 2131559098, null);
    localView.setLayoutParams(localLayoutParams);
    localView.setVerticalFadingEdgeEnabled(false);
    paramViewHolder.addView(localView);
    return paramViewHolder;
  }
  
  public void onBackPressed()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("CHOOSE_NAME_POSITION_KEY", Integer.valueOf(this.nameIndex));
    localHashMap.put("ITEM_INDEX_IN_MERGE_BY_EMAIL", Integer.valueOf(this.itemIndexInMergeByEmail));
    setFragmentActivityResult(-1, localHashMap);
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
    return 0;
  }
  
  public void render(int paramInt)
  {
    endTrace(TAG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeChooseNameFragment
 * JD-Core Version:    0.7.0.1
 */