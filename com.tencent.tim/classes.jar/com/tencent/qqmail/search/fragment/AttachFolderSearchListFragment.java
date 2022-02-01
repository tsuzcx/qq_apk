package com.tencent.qqmail.search.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity;
import com.tencent.qqmail.activity.media.ImageAttachData;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity;
import com.tencent.qqmail.attachment.cursor.AttachFolderListSearchCursor;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.util.AttachFolderHelper;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.search.view.SearchToggleView;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.timer.TinyTimer;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.SaveArgumentField;

public class AttachFolderSearchListFragment
  extends QMBaseFragment
{
  private static final String BACKGROUND_IMAGE_FILENAME = "accountlistbg.png";
  public static final String TAG = AttachFolderSearchListFragment.class.getSimpleName();
  private static final int TIMER_ID = 9;
  private boolean isDirty = true;
  private boolean isFirstIn = true;
  @SaveArgumentField
  private int mAccountId;
  private AttachFolderSearchListAdapter mAdapter;
  private long[] mAttachIds;
  private Bitmap mBackgroundImage;
  private ImageView mBackgroundImageView;
  private View mCurrentSelectedButton = null;
  @SaveArgumentField
  private int mFolderId;
  private AttachFolderListSearchCursor mListCursor;
  private ListView mListView;
  private QMContentLoadingView mListViewEmpty;
  private int mOldSoftInputMode = 0;
  private QMSearchBar mSearchBar;
  private EditText mSearchBarInput;
  private String mSearchContent = "";
  private SearchToggleView mSearchToggleView;
  private int mSearchType = 7;
  private final View.OnTouchListener mSearchTypeButtonClickListener = new AttachFolderSearchListFragment.12(this);
  private TinyTimer mTextChangedSaveTimer = null;
  
  public AttachFolderSearchListFragment(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    super(true);
    this.mAccountId = paramInt1;
    this.mFolderId = paramInt2;
    this.mAttachIds = paramArrayOfLong;
  }
  
  private void clickAttachFolderItemView(Attach paramAttach)
  {
    if (AttachToolbox.isAttachTypeImage(paramAttach))
    {
      startImageAttachPreview(paramAttach);
      return;
    }
    startActivity(AttachFolderPreviewActivity.createIntentToPreview(getActivity(), paramAttach));
  }
  
  private void closeIMM()
  {
    if (getActivity() != null) {
      ((InputMethodManager)getActivity().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchBarInput.getWindowToken(), 0);
    }
  }
  
  private void closeSearch()
  {
    this.mSearchBarInput.setText("");
    hideKeyBoard();
    popBackStack();
  }
  
  private int getSelectedSearchType()
  {
    if (getBaseView().findViewById(2131377874).isSelected()) {
      return 1;
    }
    if (getBaseView().findViewById(2131377875).isSelected()) {
      return 2;
    }
    if (getBaseView().findViewById(2131377871).isSelected()) {
      return 4;
    }
    return 7;
  }
  
  private void initListView(View paramView)
  {
    this.mListView = ((ListView)paramView.findViewById(2131377911));
    this.mListView.setOnScrollListener(new AttachFolderSearchListFragment.10(this));
    this.mListView.setOnItemClickListener(new AttachFolderSearchListFragment.11(this));
  }
  
  private void initNewSearch()
  {
    if (this.mAdapter != null) {
      this.mAdapter.resetCursor();
    }
  }
  
  private void initSearchBarView(View paramView)
  {
    this.mSearchToggleView = ((SearchToggleView)paramView.findViewById(2131377864));
    this.mSearchToggleView.init();
    this.mSearchToggleView.setToggleViewCallback(new AttachFolderSearchListFragment.2(this));
    this.mSearchBar = new QMSearchBar(getActivity());
    this.mSearchBar.setStateSearch();
    this.mSearchBar.setSearchHint(2131690604);
    this.mSearchBar.setBtnRight();
    ((RelativeLayout)paramView.findViewById(2131377781)).addView(this.mSearchBar, 0);
    paramView = this.mSearchBar.getBtnRight();
    paramView.setText(2131691246);
    paramView.setVisibility(0);
    paramView.setOnClickListener(new AttachFolderSearchListFragment.3(this));
    paramView = this.mSearchBar.searchInputCleaner;
    paramView.setVisibility(8);
    paramView.setOnClickListener(new AttachFolderSearchListFragment.4(this));
    this.mSearchBarInput = this.mSearchBar.searchInput;
    this.mSearchBarInput.setText(this.mSearchContent);
    this.mSearchBarInput.setOnTouchListener(new AttachFolderSearchListFragment.5(this));
    this.mSearchBarInput.setOnEditorActionListener(new AttachFolderSearchListFragment.6(this));
    this.mSearchBarInput.addTextChangedListener(new AttachFolderSearchListFragment.7(this, paramView));
    KeyBoardHelper.showSoftInputDelay(this.mSearchBarInput, 100L);
  }
  
  private void initSearchTypeButton(View paramView)
  {
    if (this.mSearchType == 1) {
      this.mCurrentSelectedButton = paramView.findViewById(2131377874);
    }
    for (;;)
    {
      this.mCurrentSelectedButton.setSelected(true);
      paramView.findViewById(2131377874).setOnTouchListener(this.mSearchTypeButtonClickListener);
      paramView.findViewById(2131377875).setOnTouchListener(this.mSearchTypeButtonClickListener);
      paramView.findViewById(2131377871).setOnTouchListener(this.mSearchTypeButtonClickListener);
      paramView.findViewById(2131377870).setOnTouchListener(this.mSearchTypeButtonClickListener);
      return;
      if (this.mSearchType == 2) {
        this.mCurrentSelectedButton = paramView.findViewById(2131377875);
      } else if (this.mSearchType == 4) {
        this.mCurrentSelectedButton = paramView.findViewById(2131377871);
      } else {
        this.mCurrentSelectedButton = paramView.findViewById(2131377870);
      }
    }
  }
  
  private void prepareSearch(boolean paramBoolean, Runnable paramRunnable)
  {
    if (getActivity() == null) {
      return;
    }
    if (this.mListCursor != null) {
      this.mListCursor.setSearchInfo(this.mAccountId, getSelectedSearchType(), this.mSearchContent, this.mAttachIds);
    }
    if (this.mAdapter != null)
    {
      this.mAdapter.update(paramBoolean, paramRunnable);
      return;
    }
    this.mAdapter = new AttachFolderSearchListAdapter(getActivity(), this.mListView, this.mListCursor);
    this.mListView.setAdapter(this.mAdapter);
  }
  
  private void renderList(boolean paramBoolean)
  {
    this.mListViewEmpty.hide();
    this.mSearchToggleView.hide();
    this.mBackgroundImageView.setVisibility(0);
    this.mListView.setVisibility(0);
  }
  
  private void renderSearchEmpty()
  {
    if (this.mBackgroundImage != null)
    {
      this.mBackgroundImageView.setVisibility(0);
      this.mSearchToggleView.show();
      this.mListView.setVisibility(8);
      if ((this.mListCursor == null) || (this.mListCursor.getCount() <= 0) || (this.isFirstIn)) {
        break label98;
      }
      this.mSearchToggleView.hide();
    }
    for (;;)
    {
      this.mListViewEmpty.hide();
      return;
      this.mBackgroundImageView.setVisibility(8);
      this.mSearchToggleView.hide();
      this.mListView.setVisibility(0);
      break;
      label98:
      this.mSearchToggleView.show();
    }
  }
  
  private void search(boolean paramBoolean)
  {
    if (this.mSearchContent.length() == 0) {
      if (this.mBackgroundImage != null) {
        renderSearchEmpty();
      }
    }
    while ((this.mSearchContent != null) && (",html,head,body,style,title,meta,link,img,div,span,table,th,tr,td,li,ul,fieldset,label,input,button,<,</,>,".indexOf("," + this.mSearchContent.trim().toLowerCase() + ",") > -1))
    {
      return;
      prepareSearch(this.isFirstIn, new AttachFolderSearchListFragment.8(this));
      return;
    }
    prepareSearch(this.isFirstIn, new AttachFolderSearchListFragment.9(this, paramBoolean));
  }
  
  private void setDataSource()
  {
    this.mListCursor = QMAttachManager.sharedInstance().getSearchAttachFolderListCursor(this.mAccountId, this.mSearchType, this.mSearchContent, this.mAttachIds);
    this.mListCursor.setThreadWrapper(new AttachFolderSearchListFragment.1(this));
  }
  
  private void startImageAttachPreview(Attach paramAttach)
  {
    if (this.mAdapter != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int k;
      for (int i = 0; j < this.mAdapter.getCount(); i = k)
      {
        Attach localAttach = this.mAdapter.getItem(j);
        k = i;
        if ((localAttach instanceof Attach))
        {
          localAttach = (Attach)localAttach;
          k = i;
          if (AttachToolbox.isAttachTypeImage(localAttach))
          {
            k = i;
            if (AttachFolderHelper.isAttachPreviewLegal(localAttach))
            {
              k = i;
              if (!FileUtil.isFileTypeTiff(localAttach.getName()))
              {
                if (localAttach.getHashId() == paramAttach.getHashId()) {
                  i = localArrayList.size();
                }
                localArrayList.add(localAttach);
                k = i;
              }
            }
          }
        }
        j += 1;
      }
      if (localArrayList.size() > 0)
      {
        ImageAttachData.loadData(localArrayList);
        startActivity(ImageAttachBucketSelectActivity.createAttachFolderIntent(paramAttach.getAccountId(), i, -19, false, false));
      }
    }
  }
  
  private void startTextChangedTimer(Handler paramHandler)
  {
    stopTextChangedTimer();
    if (this.mTextChangedSaveTimer == null)
    {
      this.mTextChangedSaveTimer = new TinyTimer();
      this.mTextChangedSaveTimer.RunOnce(paramHandler, 9, 400L);
    }
  }
  
  private void stopTextChangedTimer()
  {
    if (this.mTextChangedSaveTimer != null)
    {
      this.mTextChangedSaveTimer.StopTimer();
      this.mTextChangedSaveTimer = null;
    }
  }
  
  public QMTopBar getTopBar()
  {
    return null;
  }
  
  public void initDataSource()
  {
    setDataSource();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.mListViewEmpty = ((QMContentLoadingView)paramView.findViewById(2131370545));
    this.mBackgroundImageView = ((ImageView)paramView.findViewById(2131363403));
    if (this.mBackgroundImage != null) {
      this.mBackgroundImageView.setImageBitmap(this.mBackgroundImage);
    }
    initSearchBarView(paramView);
    initSearchTypeButton(paramView);
    initListView(paramView);
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return LayoutInflater.from(getActivity()).inflate(2131563006, null, false);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease()
  {
    stopTextChangedTimer();
    closeIMM();
    this.mListCursor.close();
    this.mListCursor = null;
    this.mAdapter = null;
    this.mListView.setAdapter(null);
  }
  
  public void onRestoreArguments(Bundle paramBundle)
  {
    super.onRestoreArguments(paramBundle);
    paramBundle = getArguments().getString("accountlistbg.png");
    if ((paramBundle != null) && (paramBundle.length() > 0)) {
      this.mBackgroundImage = ImageUtil.memSafeScaleImage(paramBundle, 1, 1.0F);
    }
  }
  
  public void onWindowConfiguration(boolean paramBoolean)
  {
    Window localWindow = getActivity().getWindow();
    if (paramBoolean)
    {
      this.mOldSoftInputMode = localWindow.getAttributes().softInputMode;
      localWindow.setSoftInputMode(36);
      return;
    }
    if (this.mOldSoftInputMode == 0)
    {
      localWindow.getAttributes().softInputMode = this.mOldSoftInputMode;
      localWindow.setSoftInputMode(0);
      return;
    }
    localWindow.setSoftInputMode(this.mOldSoftInputMode);
  }
  
  public int refreshData()
  {
    prepareSearch(this.isFirstIn, null);
    return 0;
  }
  
  public void render(int paramInt)
  {
    search(true);
    this.isFirstIn = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListFragment
 * JD-Core Version:    0.7.0.1
 */