package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.NoteStorage;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.movenote.MoveNoteAdapter;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class SettingDefaultNoteCatalogActivity
  extends BaseActivityEx
{
  private MoveNoteAdapter arrayAdapter;
  private QMContentLoadingView emptyView;
  private ListView mListView;
  private IObserver noteCategoryUpdateIObserver = new IObserver(new SettingDefaultNoteCatalogActivity.7(this));
  private String oldDefaultCatalogId;
  
  private void bindEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("NOTE_CATEGORY_UPDATE", this.noteCategoryUpdateIObserver);
      return;
    }
    QMNotification.unregistNotification("NOTE_CATEGORY_UPDATE", this.noteCategoryUpdateIObserver);
  }
  
  private void changeDefaultCategory()
  {
    Object localObject = (HashMap)this.mListView.getItemAtPosition(this.mListView.getCheckedItemPosition());
    if (localObject == null) {}
    do
    {
      return;
      localObject = (String)((Map)localObject).get("id");
    } while (this.oldDefaultCatalogId.equals(localObject));
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new SettingDefaultNoteCatalogActivity.5(this));
    localMailManagerDelegate.setOnError(new SettingDefaultNoteCatalogActivity.6(this));
    NoteManager.sharedInstance().changeDefaultCatalog((String)localObject, localMailManagerDelegate);
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingDefaultNoteCatalogActivity.class);
  }
  
  private void initDefaultCatalogId()
  {
    this.oldDefaultCatalogId = NoteStorage.getDefaultCatId();
    if (StringUtils.isEmpty(this.oldDefaultCatalogId)) {
      this.oldDefaultCatalogId = "1";
    }
  }
  
  private void initListData()
  {
    this.arrayAdapter = new MoveNoteAdapter(this, 0, 2130845613);
    this.mListView.setAdapter(this.arrayAdapter);
    this.mListView.setChoiceMode(1);
    if (updateCatalogs().size() == 0)
    {
      MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
      localMailManagerDelegate.setOnSuccess(new SettingDefaultNoteCatalogActivity.3(this));
      localMailManagerDelegate.setOnError(new SettingDefaultNoteCatalogActivity.4(this));
      NoteManager.sharedInstance().getCatalogList(localMailManagerDelegate);
    }
  }
  
  private QMTopBar initTopBar(QMTopBar paramQMTopBar)
  {
    paramQMTopBar.setTitle(2131690416);
    paramQMTopBar.setButtonLeftBack();
    paramQMTopBar.getButtonLeft().setOnClickListener(new SettingDefaultNoteCatalogActivity.1(this));
    paramQMTopBar.setButtonRightIcon(2130841079);
    paramQMTopBar.getButtonRight().setOnClickListener(new SettingDefaultNoteCatalogActivity.2(this));
    return paramQMTopBar;
  }
  
  @NonNull
  private ArrayList<HashMap<String, String>> updateCatalogs()
  {
    int j = -1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = NoteManager.sharedInstance().readAllCategory();
    int i = 0;
    int k = localArrayList2.size();
    HashMap localHashMap;
    if (i < k)
    {
      localHashMap = new HashMap();
      localHashMap.put("id", ((QMNNoteCategory)localArrayList2.get(i)).getCatalogId());
      localHashMap.put("name", ((QMNNoteCategory)localArrayList2.get(i)).getCatalogName());
      if (!this.oldDefaultCatalogId.equals(localHashMap.get("id"))) {
        break label147;
      }
      j = i;
    }
    label147:
    for (;;)
    {
      localArrayList1.add(localHashMap);
      i += 1;
      break;
      this.arrayAdapter.addAll(localArrayList1);
      this.arrayAdapter.notifyDataSetChanged();
      if (j >= 0) {
        this.mListView.setItemChecked(j, true);
      }
      return localArrayList1;
    }
  }
  
  public void finish()
  {
    super.finish();
    changeDefaultCategory();
  }
  
  public void initDataSource()
  {
    initDefaultCatalogId();
  }
  
  public void initDom()
  {
    bindEvent(true);
    initListData();
  }
  
  public void initUI()
  {
    QMBaseView localQMBaseView = initBaseView(this);
    View localView = View.inflate(getActivity(), 2131558516, null);
    initTopBar((QMTopBar)localView.findViewById(2131374722));
    localQMBaseView.addView(localView);
    this.mListView = ((ListView)localView.findViewById(2131370536));
    this.emptyView = ((QMContentLoadingView)localQMBaseView.findViewById(2131366398));
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease()
  {
    bindEvent(false);
  }
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingDefaultNoteCatalogActivity
 * JD-Core Version:    0.7.0.1
 */