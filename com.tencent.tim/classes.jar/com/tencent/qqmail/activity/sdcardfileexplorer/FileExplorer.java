package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMListItemView;
import com.tencent.qqmail.view.sectionlist.SectionListAdapter.ViewHolderSimple;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class FileExplorer
{
  public static final String NOTICATION_CHANGE_TOPBAR_TITLE = "changeTopbarTitle";
  private static final String TAG = "FileExplorer";
  private static List<String> selectPaths = new ArrayList();
  private Comparator<File> comparator = new FileExplorer.2(this);
  private Context context;
  private File[] currentFiles;
  private File currentParent;
  private boolean isMultiSelectable = false;
  private boolean isSystem = false;
  private Stack<String> lastOpenDirPathStack = new Stack();
  private ListView listView;
  private File root;
  private File[] rootFiles;
  private String rootPath;
  private String savePath = Environment.getExternalStorageDirectory() + "/";
  private HashMap<File, ScrollPosition> scrollToMap = new HashMap();
  private MultiSelectCallBack selectCallback;
  
  public FileExplorer(String paramString, Activity paramActivity, int paramInt)
  {
    this(paramString, null, paramActivity, paramInt);
  }
  
  public FileExplorer(String paramString, File[] paramArrayOfFile, Activity paramActivity, int paramInt)
  {
    this.context = paramActivity;
    this.rootPath = paramString;
    this.savePath = paramString;
    this.root = new File(paramString);
    if (this.root.exists())
    {
      this.currentParent = this.root;
      paramString = paramArrayOfFile;
      if (paramArrayOfFile == null) {
        paramString = getCurrentFiles(this.root);
      }
      this.currentFiles = paramString;
      this.rootFiles = this.currentFiles;
    }
    this.listView = new ListView(paramActivity);
    this.listView.setOnItemClickListener(new FileExplorer.1(this, paramInt, paramActivity));
  }
  
  private boolean autoSelectPath(String paramString)
  {
    Iterator localIterator = selectPaths.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.equals(paramString))
      {
        selectPaths.remove(str);
        return false;
      }
    }
    selectPaths.add(paramString);
    DataCollector.logEvent("Event_Click_Add_File");
    return true;
  }
  
  private File[] getCurrentFiles(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) && (!"/storage/emulated".equals(paramFile.getAbsolutePath()))) {
      return new File[0];
    }
    ArrayList localArrayList = new ArrayList();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (!localFile.isHidden()) {
          localArrayList.add(localFile);
        }
        i += 1;
      }
    }
    if ("/storage/emulated".equals(paramFile.getAbsolutePath()))
    {
      paramFile = new File("/storage/emulated/0");
      if (paramFile.exists()) {
        localArrayList.add(paramFile);
      }
    }
    Collections.sort(localArrayList, this.comparator);
    return (File[])localArrayList.toArray(new File[0]);
  }
  
  public static List<String> getSelectPaths()
  {
    return selectPaths;
  }
  
  private void goBack()
  {
    if ((!isRoot()) && (this.currentParent != null))
    {
      this.lastOpenDirPathStack.push(this.currentParent.getAbsolutePath());
      if (this.currentParent.getParentFile() == null) {
        break label71;
      }
      this.currentParent = this.currentParent.getParentFile();
    }
    label182:
    for (;;)
    {
      try
      {
        this.savePath = this.currentParent.getCanonicalPath();
        String str = this.savePath;
        if (str != null) {
          break label99;
        }
        return;
      }
      catch (IOException localIOException)
      {
        label71:
        localIOException.printStackTrace();
      }
      QMLog.log(5, "FileExplorer", "currentParent is null");
      QMUIHelper.showToast(this.context, 2131693719, "");
      return;
      label99:
      if (isRoot()) {}
      for (this.currentFiles = this.rootFiles;; this.currentFiles = getCurrentFiles(this.currentParent))
      {
        if (this.currentFiles == null) {
          break label182;
        }
        inflate();
        if (this.scrollToMap.get(this.currentParent) == null) {
          break;
        }
        ((ScrollPosition)this.scrollToMap.get(this.currentParent)).restorePosition();
        this.scrollToMap.remove(this.currentParent);
        return;
      }
    }
  }
  
  private boolean isRoot()
  {
    try
    {
      if (this.currentParent != null)
      {
        if (this.root == null) {
          return true;
        }
        boolean bool = this.currentParent.getCanonicalPath().equals(this.root.getCanonicalPath());
        return bool;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return true;
  }
  
  private boolean isRootFile(File paramFile)
  {
    boolean bool = true;
    try
    {
      if (paramFile.getParentFile() != null) {
        bool = paramFile.getParentFile().getCanonicalPath().equals(this.root.getCanonicalPath());
      }
      return bool;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return true;
  }
  
  private File[] sdRootFilter(File[] paramArrayOfFile)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      if ((!localFile.isHidden()) && (!localFile.getName().startsWith("."))) {
        localArrayList.add(localFile);
      }
      i += 1;
    }
    return (File[])localArrayList.toArray(new File[localArrayList.size()]);
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public File getCurrentParent()
  {
    return this.currentParent;
  }
  
  public String getFolderName()
  {
    return this.context.getString(2131693655);
  }
  
  public Stack<String> getLastOpenDirStack()
  {
    return this.lastOpenDirPathStack;
  }
  
  public ListView getListView()
  {
    return this.listView;
  }
  
  public void inflate()
  {
    if ((!this.rootPath.equals("/system/")) && (isRoot())) {
      this.currentFiles = sdRootFilter(this.currentFiles);
    }
    File[] arrayOfFile = this.currentFiles;
    ArrayList localArrayList = new ArrayList();
    FileItemData localFileItemData;
    if (!isRoot())
    {
      localFileItemData = new FileItemData();
      if (isRootFile(this.currentParent))
      {
        localObject1 = "" + getFolderName();
        QMNotification.postNotification("changeTopbarTitle", this.currentParent.getAbsolutePath());
        localFileItemData.isFolder = false;
        localFileItemData.resItemIcon = 2130840972;
        localFileItemData.itemName = String.format(this.context.getString(2131693653), new Object[] { localObject1 });
        localArrayList.add(localFileItemData);
      }
    }
    int i;
    for (;;)
    {
      int j = arrayOfFile.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label513;
        }
        localFileItemData = new FileItemData();
        if (!arrayOfFile[i].isDirectory()) {
          break;
        }
        localFileItemData.isFolder = true;
        localFileItemData.resItemIcon = 2130840923;
        localFileItemData.itemName = arrayOfFile[i].getName();
        localArrayList.add(localFileItemData);
        i += 1;
      }
      localObject1 = "" + this.currentParent.getParentFile().getName();
      break;
      QMNotification.postNotification("changeTopbarTitle", "" + this.currentParent.getAbsolutePath());
    }
    int k = ImageResourceUtil.getImageResource(AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(arrayOfFile[i].getName()))).name().toLowerCase(Locale.getDefault()), ImageResourceUtil.IMAGE_SIZE_32);
    long l1 = arrayOfFile[i].lastModified();
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    long l2 = arrayOfFile[i].length();
    localFileItemData.isFolder = false;
    localFileItemData.resItemIcon = k;
    localFileItemData.itemName = arrayOfFile[i].getName();
    if (l2 == 0L) {}
    for (localObject1 = "0B，" + ((SimpleDateFormat)localObject1).format(new Date(l1));; localObject2 = StringExtention.getHumanReadableSizeString(l2) + "，" + localIOException.format(new Date(l1)))
    {
      for (;;)
      {
        localFileItemData.itemModifyDateTime = ((String)localObject1);
        try
        {
          localFileItemData.canonicalPath = arrayOfFile[i].getCanonicalPath();
        }
        catch (IOException localIOException)
        {
          QMLog.log(6, "FileExplorer", "get file canomicalPath io Exception");
        }
      }
      break;
    }
    label513:
    QMLog.log(4, "FileExplorer", String.format("items[%s], rootPath[%s], savePath[%s], isSystem[%b], currentParent[%s]", new Object[] { Integer.valueOf(localArrayList.size()), this.rootPath, this.savePath, Boolean.valueOf(this.isSystem), this.currentParent }));
    Object localObject2 = new FileListAdapter(this.context, 0, localArrayList);
    this.listView.setAdapter((ListAdapter)localObject2);
  }
  
  public String saveDirectory()
  {
    return this.savePath + "/";
  }
  
  public void setCurrentParent(File paramFile)
  {
    this.currentParent = paramFile;
    this.savePath = paramFile.getAbsolutePath();
    if ((!this.rootPath.equals("/system/")) && (isRoot()))
    {
      this.currentFiles = this.rootFiles;
      return;
    }
    this.currentFiles = getCurrentFiles(paramFile);
  }
  
  public void setIsSystem(boolean paramBoolean)
  {
    this.isSystem = paramBoolean;
  }
  
  public void setMultiSelectable(boolean paramBoolean)
  {
    this.isMultiSelectable = paramBoolean;
  }
  
  public void setSelectCallBack(MultiSelectCallBack paramMultiSelectCallBack)
  {
    this.selectCallback = paramMultiSelectCallBack;
  }
  
  @TargetApi(8)
  public void smoothToTop()
  {
    try
    {
      if (this.currentFiles == null) {
        return;
      }
      if (this.currentFiles.length > 8) {
        this.listView.setSelectionFromTop(8, 0);
      }
      Threads.runOnMainThread(new FileExplorer.3(this), 30L);
      return;
    }
    catch (Exception localException) {}
  }
  
  class FileListAdapter
    extends ArrayAdapter<FileItemData>
  {
    public FileListAdapter(int paramInt, List<FileItemData> paramList)
    {
      super(paramList, localList);
    }
    
    private boolean isSelected(String paramString)
    {
      Iterator localIterator = FileExplorer.selectPaths.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(paramString)) {
          return true;
        }
      }
      return false;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      FileItemData localFileItemData = (FileItemData)getItem(paramInt);
      SectionListAdapter.ViewHolderSimple localViewHolderSimple;
      label139:
      Object localObject;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(getContext()).inflate(2131559495, paramViewGroup, false);
        localViewHolderSimple = new SectionListAdapter.ViewHolderSimple();
        localViewHolderSimple.imageView = ((ImageView)paramView.findViewById(2131368846));
        localViewHolderSimple.chevron = ((ImageView)paramView.findViewById(2131364597));
        localViewHolderSimple.titleTextView = ((TextView)paramView.findViewById(2131379784));
        localViewHolderSimple.detailTextView = ((TextView)paramView.findViewById(2131365757));
        paramView.setTag(localViewHolderSimple);
        if (localFileItemData.resItemIcon > 0) {
          localViewHolderSimple.imageView.setImageResource(localFileItemData.resItemIcon);
        }
        if (localFileItemData.itemModifyDateTime != null) {
          break label247;
        }
        localViewHolderSimple.detailTextView.setVisibility(8);
        if ((!localFileItemData.isFolder) && (FileExplorer.this.isMultiSelectable))
        {
          localObject = (QMListItemView)paramView;
          if (!isSelected(localFileItemData.canonicalPath)) {
            break label272;
          }
          ((QMListItemView)localObject).setChecked(true);
        }
        label181:
        localObject = localViewHolderSimple.chevron;
        if (!localFileItemData.isFolder) {
          break label281;
        }
      }
      label272:
      label281:
      for (int i = 0;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        localViewHolderSimple.titleTextView.setText(localFileItemData.itemName);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localViewHolderSimple = (SectionListAdapter.ViewHolderSimple)paramView.getTag();
        break;
        label247:
        localViewHolderSimple.detailTextView.setVisibility(0);
        localViewHolderSimple.detailTextView.setText(localFileItemData.itemModifyDateTime);
        break label139;
        ((QMListItemView)localObject).setChecked(false);
        break label181;
      }
    }
  }
  
  public static abstract interface MultiSelectCallBack
  {
    public abstract void selectUpdate();
  }
  
  class ScrollPosition
  {
    private int lastIndex = -1;
    private int lastTop = -1;
    
    public ScrollPosition()
    {
      if (FileExplorer.this.listView != null)
      {
        this.lastIndex = FileExplorer.this.listView.getFirstVisiblePosition();
        this$1 = FileExplorer.this.listView.getChildAt(0);
        if (FileExplorer.this != null) {
          break label58;
        }
      }
      for (;;)
      {
        this.lastTop = i;
        return;
        label58:
        i = FileExplorer.this.getTop();
      }
    }
    
    public void restorePosition()
    {
      if (this.lastIndex > -1) {
        FileExplorer.this.listView.setSelectionFromTop(this.lastIndex, this.lastTop);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.FileExplorer
 * JD-Core Version:    0.7.0.1
 */