package com.tencent.qqmail.movenote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.movemail.MoveActivity;
import com.tencent.qqmail.note.NoteListDefine;
import com.tencent.qqmail.trd.guava.Sets;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observer;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class MoveNoteActivity
  extends MoveActivity
{
  private static final int ADD_NOTE_CATALOG = 1;
  public static final String CATALOG_ID = "catalogId";
  public static final String N_MOVENOTE_ERROR = "N_MOVENOTE_ERROR";
  public static final String N_MOVENOTE_SUCC = "N_MOVENOTE_SUCC";
  public static final String TAG = "MoveNoteActivity";
  private MoveNoteAdapter arrayAdapter;
  private String currentCatalogId;
  private ArrayList<String> currentNoteIds;
  private boolean mFromBatchOp = false;
  @Deprecated
  private NoteManager mNoteManager;
  private Observer moveNoteErrorObserver = new IObserver(new MoveNoteActivity.2(this));
  private Observer moveNoteSuccObserver = new IObserver(new MoveNoteActivity.1(this));
  private QMTips tips;
  
  @SuppressLint({"NewApi"})
  public static int getCheckedItemCount(ListView paramListView)
  {
    int k;
    if (Build.VERSION.SDK_INT >= 11)
    {
      k = paramListView.getCheckedItemCount();
      return k;
    }
    int j = paramListView.getCount();
    int i = 0;
    j -= 1;
    for (;;)
    {
      k = i;
      if (j < 0) {
        break;
      }
      k = i;
      if (paramListView.isItemChecked(j)) {
        k = i + 1;
      }
      j -= 1;
      i = k;
    }
  }
  
  private void postNotificationBackToNormalView()
  {
    if (this.mFromBatchOp) {
      QMNotification.postNotification("NOTE_TONORMALVIEW", null);
    }
  }
  
  private void registerNotifications()
  {
    QMNotification.registNotification("N_MOVENOTE_SUCC", this.moveNoteSuccObserver);
    QMNotification.registNotification("N_MOVENOTE_ERROR", this.moveNoteErrorObserver);
  }
  
  private void renderListData()
  {
    int j = -1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = getNoteManager().readAllCategory();
    int k = localArrayList2.size();
    int i = 0;
    HashMap localHashMap;
    if (i < k)
    {
      localHashMap = new HashMap();
      localHashMap.put("id", ((QMNNoteCategory)localArrayList2.get(i)).getCatalogId());
      localHashMap.put("name", ((QMNNoteCategory)localArrayList2.get(i)).getCatalogName());
      if ((this.currentCatalogId == null) || (!this.currentCatalogId.equals(localHashMap.get("id")))) {
        break label173;
      }
      j = i;
    }
    label173:
    for (;;)
    {
      localArrayList1.add(localHashMap);
      i += 1;
      break;
      this.arrayAdapter = new MoveNoteAdapter(this, 0, 2130845612, localArrayList1);
      this.mListView.setAdapter(this.arrayAdapter);
      this.mListView.setChoiceMode(1);
      if (j >= 0) {
        this.mListView.setItemChecked(j, true);
      }
      return;
    }
  }
  
  private void start()
  {
    Object localObject1 = getIntent().getExtras();
    this.currentNoteIds = ((Bundle)localObject1).getStringArrayList("NoteIds");
    this.currentCatalogId = ((Bundle)localObject1).getString("CurrCatalogId");
    this.mFromBatchOp = ((Bundle)localObject1).getBoolean("fromBatchOp", false);
    if (StringUtils.isEmpty(this.currentCatalogId))
    {
      HashSet localHashSet = Sets.newHashSet();
      Iterator localIterator = null;
      localObject1 = localIterator;
      if (this.currentNoteIds != null)
      {
        localObject1 = localIterator;
        if (this.currentNoteIds.size() > 0)
        {
          localIterator = this.currentNoteIds.iterator();
          localObject1 = null;
          while (localIterator.hasNext())
          {
            Object localObject2 = (String)localIterator.next();
            localObject2 = NoteManager.sharedInstance().readNoteData((String)localObject2);
            if (localObject2 != null)
            {
              localObject1 = ((QMNNote)localObject2).information.category.getCatalogId();
              localHashSet.add(localObject1);
            }
          }
        }
      }
      if (localHashSet.size() == 1) {
        this.currentCatalogId = ((String)localObject1);
      }
    }
    for (;;)
    {
      renderListData();
      return;
      if ((this.currentCatalogId.equals(NoteListDefine.CATALOG_ALL_ID)) && (this.currentNoteIds != null) && (this.currentNoteIds.size() == 1))
      {
        localObject1 = (String)this.currentNoteIds.get(0);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = NoteManager.sharedInstance().readNoteData((String)localObject1);
          if (localObject1 != null) {
            this.currentCatalogId = ((QMNNote)localObject1).information.category.getCatalogId();
          }
        }
      }
    }
  }
  
  private void unregisterNotifications()
  {
    QMNotification.unregistNotification("N_MOVENOTE_SUCC", this.moveNoteSuccObserver);
    QMNotification.unregistNotification("N_MOVENOTE_ERROR", this.moveNoteErrorObserver);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772423, 2130772068);
  }
  
  public View.OnClickListener getBottomBarListener()
  {
    return new MoveNoteActivity.3(this);
  }
  
  public String getBottomText()
  {
    return getString(2131696403);
  }
  
  public NoteManager getNoteManager()
  {
    return NoteManager.sharedInstance();
  }
  
  public String getTitleText()
  {
    return getString(2131696402);
  }
  
  public void initDom()
  {
    super.initDom();
    this.tips = new QMTips(this);
    registerNotifications();
    start();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      new HashMap();
      paramIntent = paramIntent.getStringExtra("catalogId");
      if (!TextUtils.isEmpty(paramIntent))
      {
        postNotificationBackToNormalView();
        getNoteManager().moveNotesWithNotifications(this.currentNoteIds, paramIntent);
      }
    }
  }
  
  public boolean onClickConfirm(View paramView)
  {
    if (getCheckedItemCount(this.mListView) <= 0)
    {
      this.tips.showInfo(getString(2131696421));
      return false;
    }
    postNotificationBackToNormalView();
    paramView = (String)((HashMap)this.mListView.getItemAtPosition(this.mListView.getCheckedItemPosition())).get("id");
    if (this.currentCatalogId.equals(paramView))
    {
      this.tips.hide();
      finish();
      return true;
    }
    getNoteManager().moveNotesWithNotifications(this.currentNoteIds, paramView);
    return true;
  }
  
  public void onDestroy()
  {
    unregisterNotifications();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.tips != null) {
      this.tips.hide();
    }
  }
  
  public void onRelease()
  {
    super.onRelease();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.MoveNoteActivity
 * JD-Core Version:    0.7.0.1
 */