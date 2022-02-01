package com.tencent.qqmail.model;

import android.content.Context;
import com.tencent.qqmail.ManagerLifecycle;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.model.qmnote.storage.QMNoteSQLite;
import com.tencent.qqmail.model.qmnote.storage.QMNoteSQLiteItem;
import com.tencent.qqmail.model.uidomain.NoteUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class NoteStorage
  extends ManagerLifecycle
{
  public static final String DEFAULT_CATEGORY = "未分类";
  public static final String DEFAULT_CATEGORY_ID = "1";
  private static final String TAG = "NoteStorage";
  private ArrayList<QMNNote> mNoteCacheArray = new ArrayList();
  private ArrayList<QMNNoteCategory> mNoteCategoryCacheArray = new ArrayList();
  private final QMNoteSQLite mNoteDatabase;
  private HashMap<String, ArrayList<QMNNote>> mNoteListCacheDict = new HashMap(200);
  private HashMap<String, ByteBuffer> mNoteThumbListDict = new HashMap();
  
  public NoteStorage(Context paramContext, String paramString)
  {
    this.mNoteDatabase = new QMNoteSQLite(paramContext, paramString);
  }
  
  private void addNoteData(QMNNote paramQMNNote)
  {
    this.mNoteCacheArray.add(0, paramQMNNote);
  }
  
  private void deleteNote(String paramString, ArrayList<QMNNote> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        QMNNote localQMNNote = (QMNNote)paramArrayList.get(i);
        if ((localQMNNote != null) && (paramString.equals(localQMNNote.information.noteId))) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void deleteNoteCache(String paramString)
  {
    if (this.mNoteCacheArray != null) {
      deleteNote(paramString, this.mNoteCacheArray);
    }
  }
  
  private void deleteNoteCategoryList()
  {
    if (this.mNoteCategoryCacheArray != null) {
      this.mNoteCategoryCacheArray.clear();
    }
  }
  
  @Deprecated
  private void deleteNoteList()
  {
    if (this.mNoteListCacheDict != null) {
      this.mNoteListCacheDict.clear();
    }
  }
  
  public static String getDefaultCatId()
  {
    int i = QMSettingManager.sharedInstance().getDefaultNoteAccountID();
    if (i == -1) {
      return null;
    }
    return QMSettingManager.sharedInstance().getNoteDefaultCat(i);
  }
  
  public static String readSortType()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
    if (localQQMailAccount != null)
    {
      int i = localQQMailAccount.getId();
      if (StringUtils.equals(QMSettingManager.sharedInstance().getNoteSortType(i), "1")) {
        return "1";
      }
    }
    return "0";
  }
  
  public static void setDefaultCatId(int paramInt, String paramString)
  {
    if (!StringUtils.equals(QMSettingManager.sharedInstance().getNoteDefaultCat(paramInt), paramString)) {
      QMSettingManager.sharedInstance().setNoteDefaultCat(paramInt, paramString);
    }
  }
  
  public void deleteCategoryCache()
  {
    deleteNoteCategoryList();
  }
  
  public boolean deleteDatabase()
  {
    return this.mNoteDatabase.deleteDatabase();
  }
  
  public boolean deleteNote(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      this.mNoteDatabase.deleteDataWithId(paramString);
      deleteNote(paramString, this.mNoteCacheArray);
      deleteNoteList();
      return false;
    }
    finally {}
  }
  
  public boolean deleteNoteCategory(QMNNoteCategory paramQMNNoteCategory)
  {
    if (paramQMNNoteCategory == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    try
    {
      boolean bool = this.mNoteDatabase.deleteCategoryWithItem(paramQMNNoteCategory);
      return bool;
    }
    finally {}
  }
  
  public void deleteNoteIndexCache()
  {
    deleteNoteList();
  }
  
  public void deleteNoteItemCache(String paramString)
  {
    deleteNoteCache(paramString);
  }
  
  public boolean deleteOneItemByCreateTime(double paramDouble)
  {
    try
    {
      boolean bool = this.mNoteDatabase.deleteOneItemByCreateTime(paramDouble);
      if (bool)
      {
        this.mNoteCacheArray.clear();
        deleteNoteList();
      }
      return true;
    }
    finally {}
  }
  
  public boolean deleteUsendNote(String paramString)
  {
    QMLog.log(4, "NoteStorage", "deleteUsendNote:" + paramString);
    try
    {
      this.mNoteDatabase.deleteDataWithId(paramString);
      this.mNoteDatabase.deleteUnsendNoteById(paramString);
      deleteNote(paramString, this.mNoteCacheArray);
      deleteNoteList();
      return true;
    }
    finally {}
  }
  
  public String findCategoryNameByCid(String paramString)
  {
    if (paramString == null) {
      return "未分类";
    }
    if (this.mNoteCategoryCacheArray.size() == 0) {
      readAllCategory();
    }
    int i = 0;
    while (i < this.mNoteCategoryCacheArray.size())
    {
      Object localObject = this.mNoteCategoryCacheArray.get(i);
      if ((localObject instanceof QMNNoteCategory))
      {
        localObject = (QMNNoteCategory)localObject;
        if (paramString.equals(((QMNNoteCategory)localObject).getCatalogId())) {
          return ((QMNNoteCategory)localObject).getCatalogName();
        }
      }
      i += 1;
    }
    return "未分类";
  }
  
  public boolean fixNoteData()
  {
    try
    {
      boolean bool = this.mNoteDatabase.fixNoteData();
      return bool;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "NoteStorage", "fixNoteData error: " + localException.toString());
    }
    return false;
  }
  
  public List<String> getPendingDeleteIds()
  {
    try
    {
      List localList = this.mNoteDatabase.getPendingDeleteIds();
      return localList;
    }
    finally {}
  }
  
  public double getSeq(String paramString)
  {
    try
    {
      double d = this.mNoteDatabase.getSeq(paramString);
      return d;
    }
    finally {}
  }
  
  public boolean isNoteDatabaseEmpty()
  {
    try
    {
      boolean bool = this.mNoteDatabase.isNoteDatabaseEmpty();
      return bool;
    }
    finally {}
  }
  
  public void moveNote(String paramString1, String paramString2)
  {
    try
    {
      this.mNoteDatabase.moveNote(paramString2, paramString1);
      deleteNote(paramString1, this.mNoteCacheArray);
      deleteNoteList();
      return;
    }
    finally {}
  }
  
  public boolean moveUnsendNotes(List<String> paramList, String paramString)
  {
    paramString = new QMNNoteCategory(paramString, findCategoryNameByCid(paramString));
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      QMComposeNote localQMComposeNote = readUnsendNote(str);
      if ((localQMComposeNote != null) && (localQMComposeNote.information != null) && (localQMComposeNote.information.category != null))
      {
        localQMComposeNote.information.category = paramString;
        if ((bool) && (saveUnsendNote(localQMComposeNote))) {
          bool = true;
        }
      }
      for (;;)
      {
        break;
        bool = false;
        continue;
        QMLog.log(6, "NoteStorage", String.format("move unsend note and id not exists (%s)", new Object[] { str }));
        bool = false;
      }
    }
    return bool;
  }
  
  public ArrayList<QMComposeNote> newAddedAllUnsendNotes()
  {
    try
    {
      ArrayList localArrayList = this.mNoteDatabase.newAddedAllUnsendNotes();
      return localArrayList;
    }
    finally {}
  }
  
  public void onTerminate()
  {
    try
    {
      this.mNoteDatabase.closeDatabase();
      return;
    }
    finally {}
  }
  
  public ArrayList<QMNNoteCategory> readAllCategory()
  {
    if (this.mNoteCategoryCacheArray.size() > 0) {}
    for (;;)
    {
      return this.mNoteCategoryCacheArray;
      try
      {
        ArrayList localArrayList = this.mNoteDatabase.readAllCategory();
        this.mNoteCategoryCacheArray.addAll(localArrayList);
      }
      finally {}
    }
  }
  
  public ArrayList<String> readAllUnsendNote()
  {
    try
    {
      ArrayList localArrayList = this.mNoteDatabase.readAllUnsendNotes();
      return localArrayList;
    }
    finally {}
  }
  
  public ArrayList<Double> readCreateUTC(String paramString)
  {
    try
    {
      paramString = this.mNoteDatabase.readCreateUTC(paramString);
      return paramString;
    }
    finally {}
  }
  
  public double readLastUpdateUTC()
  {
    try
    {
      double d = this.mNoteDatabase.readLastUpdateUTC();
      return d;
    }
    finally {}
  }
  
  public ArrayList<String> readModifiedItemIds()
  {
    try
    {
      ArrayList localArrayList = this.mNoteDatabase.searchItemIdByStatus(2);
      return localArrayList;
    }
    finally {}
  }
  
  public QMNNote readNoteData(String paramString)
  {
    return readNoteData(paramString, true, false);
  }
  
  public QMNNote readNoteData(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      QMComposeNote localQMComposeNote = this.mNoteDatabase.readUnsendNoteById(paramString);
      Object localObject = localQMComposeNote;
      if (localQMComposeNote == null) {
        localObject = this.mNoteDatabase.readDataById(paramString);
      }
      if ((localObject != null) && ((!paramBoolean2) || (((QMNNote)localObject).read)))
      {
        ((QMNNote)localObject).information.category.setCatalogName(findCategoryNameByCid(((QMNNote)localObject).information.category.getCatalogId()));
        addNoteData((QMNNote)localObject);
        return localObject;
      }
    }
    finally {}
    return null;
  }
  
  public QMNNote readNoteDataNeedContent(String paramString)
  {
    return readNoteData(paramString, true, true);
  }
  
  public NoteUI readNoteUIByCategoryId(String paramString)
  {
    String str = "updateTime";
    if (StringUtils.equals("1", readSortType())) {
      str = "createTime";
    }
    try
    {
      paramString = this.mNoteDatabase.readNoteUIByCategoryId(paramString, str);
      return paramString;
    }
    finally {}
  }
  
  public NoteUI readNoteUIByMergeIds(List<String> paramList1, List<String> paramList2)
  {
    String str = "updateTime";
    if (StringUtils.equals("1", readSortType())) {
      str = "createTime";
    }
    if ((paramList1 == null) || (paramList1.size() == 0)) {
      return this.mNoteDatabase.readNoteUIByNoteids(paramList2, str);
    }
    if ((paramList2 == null) || (paramList2.size() == 0)) {
      return this.mNoteDatabase.readNoteUIByNoteids(paramList1, str);
    }
    return this.mNoteDatabase.readNoteUIByMergeIds(str, paramList1, paramList2);
  }
  
  public NoteUI readNoteUIByNoteids(List<String> paramList)
  {
    String str = "updateTime";
    if (StringUtils.equals("1", readSortType())) {
      str = "createTime";
    }
    try
    {
      paramList = this.mNoteDatabase.readNoteUIByNoteids(paramList, str);
      return paramList;
    }
    finally {}
  }
  
  public List<QMNNote> readNotesByCreateTime(List<Double> paramList)
  {
    return this.mNoteDatabase.readNotesByCreateTime(paramList);
  }
  
  public QMComposeNote readUnsendNote(String paramString)
  {
    try
    {
      paramString = this.mNoteDatabase.readUnsendNoteById(paramString);
      return paramString;
    }
    finally {}
  }
  
  public boolean saveNote(QMNNote paramQMNNote)
  {
    try
    {
      this.mNoteDatabase.insertDataWithItem(paramQMNNote);
      deleteNote(paramQMNNote.information.noteId, this.mNoteCacheArray);
      deleteNoteList();
      return true;
    }
    finally {}
  }
  
  public boolean saveNoteCategory(QMNNoteCategory paramQMNNoteCategory)
  {
    if (paramQMNNoteCategory == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    try
    {
      boolean bool = this.mNoteDatabase.insertCategoryWithItem(paramQMNNoteCategory);
      deleteNoteCategoryList();
      return bool;
    }
    finally {}
  }
  
  public boolean saveNoteStatus(int paramInt, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      this.mNoteDatabase.saveNoteStatus(paramInt, paramString);
      return true;
    }
    finally {}
  }
  
  public boolean saveNotes(List<QMNNote> paramList)
  {
    try
    {
      this.mNoteDatabase.insertNoteWithItem(paramList);
      this.mNoteCacheArray.clear();
      deleteNoteList();
      return true;
    }
    finally {}
  }
  
  public boolean saveNotesStatus(int paramInt, List<String> paramList)
  {
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((bool) && (saveNoteStatus(paramInt, str))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public boolean saveStarStatus(int paramInt, String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    try
    {
      QMNoteSQLite localQMNoteSQLite = this.mNoteDatabase;
      if (paramInt == 1) {
        bool = true;
      }
      localQMNoteSQLite.saveStarStatus(bool, paramString);
      deleteNote(paramString, this.mNoteCacheArray);
      deleteNoteList();
      return true;
    }
    finally {}
  }
  
  public boolean saveUnsendNote(QMComposeNote paramQMComposeNote)
  {
    if (paramQMComposeNote == null) {
      return false;
    }
    try
    {
      this.mNoteDatabase.insertDataWithItem(paramQMComposeNote);
      QMNoteSQLiteItem localQMNoteSQLiteItem = new QMNoteSQLiteItem();
      localQMNoteSQLiteItem.itemId = paramQMComposeNote.information.noteId;
      localQMNoteSQLiteItem.domain = paramQMComposeNote.ConvertToByte();
      this.mNoteDatabase.insertUnsendNoteToBytes(localQMNoteSQLiteItem);
      return true;
    }
    finally {}
  }
  
  public NoteUI searchNote(String paramString)
  {
    String str = "updateTime";
    if (StringUtils.equals("1", readSortType())) {
      str = "createTime";
    }
    return this.mNoteDatabase.searchNote(paramString, str);
  }
  
  public List<String> searchNoteWithKey(String paramString)
  {
    String str = "updateTime";
    if (StringUtils.equals("1", readSortType())) {
      str = "createTime";
    }
    return this.mNoteDatabase.searchNoteWithKey(paramString, str);
  }
  
  public boolean setSeq(String paramString, double paramDouble)
  {
    try
    {
      boolean bool = this.mNoteDatabase.setSeq(paramString, paramDouble);
      return bool;
    }
    finally {}
  }
  
  public void setSortType(int paramInt, String paramString)
  {
    if (!StringUtils.equals(QMSettingManager.sharedInstance().getNoteSortType(paramInt), paramString)) {
      QMSettingManager.sharedInstance().setNoteSortType(paramInt, paramString);
    }
  }
  
  public void transactionCommit()
  {
    this.mNoteDatabase.transactionCommit();
    ValidateHelper.checkSynchronized(this);
  }
  
  public void transactionStart()
  {
    ValidateHelper.checkSynchronized(this);
    this.mNoteDatabase.transactionStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteStorage
 * JD-Core Version:    0.7.0.1
 */