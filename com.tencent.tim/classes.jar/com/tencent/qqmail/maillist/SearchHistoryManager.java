package com.tencent.qqmail.maillist;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SearchHistoryManager
{
  private static final String HISTORY_SP_NAME = "historySharedPreferences";
  private static final String SEARCH_DEFAULT_TYPE = "searchDefaultType";
  private static volatile SearchHistoryManager instance;
  private final int historyMaxSize = 5;
  private PreferencesManager preferencesManager = new PreferencesManager(5);
  
  public static SearchHistoryManager createInstance()
  {
    try
    {
      if (instance == null) {
        instance = new SearchHistoryManager();
      }
      SearchHistoryManager localSearchHistoryManager = instance;
      return localSearchHistoryManager;
    }
    finally {}
  }
  
  private boolean equal(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      if (paramString2 == null) {
        return true;
      }
    }
    else {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public static int getSearchDefaultType()
  {
    return SPManager.getSp("historySharedPreferences").getInt("searchDefaultType", 1);
  }
  
  private boolean hasSameFieldValue(SearchHistoryItem paramSearchHistoryItem1, SearchHistoryItem paramSearchHistoryItem2)
  {
    return (paramSearchHistoryItem1 != null) && (paramSearchHistoryItem2 != null) && (equal(paramSearchHistoryItem1.getSearchContent(), paramSearchHistoryItem2.getSearchContent())) && (equal(paramSearchHistoryItem1.getSearchTag(), paramSearchHistoryItem2.getSearchTag())) && (paramSearchHistoryItem1.getSearchTime() == paramSearchHistoryItem2.getSearchTime());
  }
  
  public static void setSearchDefaultType(int paramInt)
  {
    SPManager.getEditor("historySharedPreferences").putInt("searchDefaultType", paramInt).apply();
  }
  
  public static SearchHistoryManager shareInstance()
  {
    if (instance == null) {
      createInstance();
    }
    return instance;
  }
  
  private void sortedAdd(SearchHistoryItem paramSearchHistoryItem)
  {
    int i = 0;
    while (i < this.preferencesManager.size())
    {
      if (this.preferencesManager.get(i).getSearchTime() < paramSearchHistoryItem.getSearchTime())
      {
        this.preferencesManager.add(i, paramSearchHistoryItem);
        return;
      }
      i += 1;
    }
    this.preferencesManager.add(paramSearchHistoryItem);
  }
  
  public boolean add(SearchHistoryItem paramSearchHistoryItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramSearchHistoryItem != null)
    {
      bool1 = bool2;
      if (paramSearchHistoryItem.getSearchContent() != null)
      {
        bool1 = bool2;
        if (!paramSearchHistoryItem.getSearchContent().equals(""))
        {
          paramSearchHistoryItem = paramSearchHistoryItem.copy();
          if (paramSearchHistoryItem.getSearchTag() == null) {
            paramSearchHistoryItem.setSearchTag("all");
          }
          i = this.preferencesManager.indexOf(paramSearchHistoryItem);
          if ((i >= 0) && (this.preferencesManager.get(i).getSearchTime() < paramSearchHistoryItem.getSearchTime()))
          {
            this.preferencesManager.remove(i);
            sortedAdd(paramSearchHistoryItem);
          }
          if (i < 0)
          {
            if (this.preferencesManager.isFull()) {
              break label122;
            }
            sortedAdd(paramSearchHistoryItem);
          }
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      label122:
      do
      {
        return bool1;
        i = this.preferencesManager.size() - 1;
        bool1 = bool2;
      } while (this.preferencesManager.get(i).getSearchTime() >= paramSearchHistoryItem.getSearchTime());
      this.preferencesManager.remove(i);
      sortedAdd(paramSearchHistoryItem);
    }
  }
  
  public void clear()
  {
    this.preferencesManager.clear();
  }
  
  public SearchHistoryItem get(int paramInt)
  {
    return this.preferencesManager.get(paramInt).copy();
  }
  
  public ArrayList<SearchHistoryItem> getNewestSearchHistory(int paramInt)
  {
    Object localObject;
    if (paramInt <= 0)
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= paramInt) {
        break;
      }
      localObject = localArrayList;
      if (i >= this.preferencesManager.size()) {
        break;
      }
      localArrayList.add(this.preferencesManager.get(i).copy());
      i += 1;
    }
  }
  
  public SearchHistoryItem remove(int paramInt)
  {
    return this.preferencesManager.remove(paramInt);
  }
  
  public SearchHistoryItem remove(SearchHistoryItem paramSearchHistoryItem)
  {
    if (paramSearchHistoryItem != null)
    {
      int i = 0;
      while (i < this.preferencesManager.size())
      {
        if (hasSameFieldValue(this.preferencesManager.get(i), paramSearchHistoryItem)) {
          return this.preferencesManager.remove(i);
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void save()
  {
    this.preferencesManager.save();
  }
  
  public int size()
  {
    return this.preferencesManager.size();
  }
  
  class PreferencesManager
  {
    private LinkedList<SearchHistoryItem> historyItems = null;
    private final String itemKeyBase = "historyItem";
    private int maxSize;
    
    public PreferencesManager(int paramInt)
    {
      this.maxSize = paramInt;
    }
    
    private String itemKey(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.maxSize))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        getClass();
        return "historyItem" + paramInt;
      }
      return null;
    }
    
    private void readPreferenceToList()
    {
      if (this.historyItems == null)
      {
        this.historyItems = new LinkedList();
        SharedPreferences localSharedPreferences = SPManager.getSp("historySharedPreferences");
        int i = 0;
        while (i < this.maxSize)
        {
          if (localSharedPreferences.contains(itemKey(i)))
          {
            SearchHistoryItem localSearchHistoryItem = SearchHistoryItem.string2Object(localSharedPreferences.getString(itemKey(i), null));
            if (localSearchHistoryItem != null) {
              this.historyItems.add(localSearchHistoryItem);
            }
          }
          i += 1;
        }
      }
    }
    
    public boolean add(int paramInt, SearchHistoryItem paramSearchHistoryItem)
    {
      readPreferenceToList();
      if ((paramSearchHistoryItem != null) && (paramSearchHistoryItem.getSearchContent() != null) && (!paramSearchHistoryItem.getSearchContent().equals("")) && (this.maxSize > this.historyItems.size()))
      {
        this.historyItems.add(paramInt, paramSearchHistoryItem);
        return true;
      }
      return false;
    }
    
    public boolean add(SearchHistoryItem paramSearchHistoryItem)
    {
      readPreferenceToList();
      if ((paramSearchHistoryItem != null) && (paramSearchHistoryItem.getSearchContent() != null) && (!paramSearchHistoryItem.getSearchContent().equals("")) && (this.maxSize > this.historyItems.size()))
      {
        this.historyItems.add(paramSearchHistoryItem);
        return true;
      }
      return false;
    }
    
    public void clear()
    {
      readPreferenceToList();
      this.historyItems.clear();
    }
    
    public SearchHistoryItem get(int paramInt)
    {
      readPreferenceToList();
      return (SearchHistoryItem)this.historyItems.get(paramInt);
    }
    
    public int indexOf(SearchHistoryItem paramSearchHistoryItem)
    {
      readPreferenceToList();
      if (paramSearchHistoryItem != null)
      {
        int i = 0;
        while (i < this.historyItems.size())
        {
          if (((SearchHistoryItem)this.historyItems.get(i)).getSearchContent().equalsIgnoreCase(paramSearchHistoryItem.getSearchContent())) {
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    
    public boolean isFull()
    {
      readPreferenceToList();
      return this.maxSize <= this.historyItems.size();
    }
    
    public SearchHistoryItem remove(int paramInt)
    {
      readPreferenceToList();
      return (SearchHistoryItem)this.historyItems.remove(paramInt);
    }
    
    public void save()
    {
      if (this.historyItems != null)
      {
        SharedPreferences localSharedPreferences = SPManager.getSp("historySharedPreferences");
        SharedPreferences.Editor localEditor = SPManager.getEditor("historySharedPreferences");
        int i = 0;
        if (i < this.maxSize)
        {
          if (i < this.historyItems.size()) {
            localEditor.putString(itemKey(i), ((SearchHistoryItem)this.historyItems.get(i)).object2String());
          }
          for (;;)
          {
            i += 1;
            break;
            if (localSharedPreferences.contains(itemKey(i))) {
              localEditor.remove(itemKey(i));
            }
          }
        }
        localEditor.apply();
        this.historyItems = null;
      }
    }
    
    public int size()
    {
      readPreferenceToList();
      return this.historyItems.size();
    }
    
    public SearchHistoryItem[] toArray()
    {
      readPreferenceToList();
      SearchHistoryItem[] arrayOfSearchHistoryItem = new SearchHistoryItem[this.historyItems.size()];
      return (SearchHistoryItem[])this.historyItems.toArray(arrayOfSearchHistoryItem);
    }
    
    public String toString()
    {
      readPreferenceToList();
      Iterator localIterator = this.historyItems.iterator();
      SearchHistoryItem localSearchHistoryItem;
      for (String str = ""; localIterator.hasNext(); str = str + localSearchHistoryItem + "\n") {
        localSearchHistoryItem = (SearchHistoryItem)localIterator.next();
      }
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.SearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */