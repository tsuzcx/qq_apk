package com.tencent.qqmail.activity.setting.tableactivity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.setting.tableactivity.model.CheckBoxTableItem;
import com.tencent.qqmail.activity.setting.tableactivity.model.DetailTableItem;
import com.tencent.qqmail.activity.setting.tableactivity.model.StartActivityTableItem;
import com.tencent.qqmail.activity.setting.tableactivity.model.Table;
import com.tencent.qqmail.activity.setting.tableactivity.model.TableItem;
import com.tencent.qqmail.activity.setting.tableactivity.onclick.OnClickAnnotationUtil;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;

public abstract class BaseTableActivity
  extends BaseActivityEx
{
  private static final int INVALID_RESID = 0;
  private static final String TAG = "BaseTableActivity";
  private Map<String, TableItem> idTableItemMap;
  private SparseArray<Method> mMethods;
  protected QMBaseView mSettingView;
  private List<Table> tables;
  private Map<String, Table> valueTableMap;
  
  public static void goActivity(Intent paramIntent)
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if (localActivity != null) {
      localActivity.startActivity(paramIntent);
    }
  }
  
  private void initCheckboxTableItem(CheckBoxTableItem paramCheckBoxTableItem, Method paramMethod)
  {
    UITableItemView localUITableItemView = paramCheckBoxTableItem.getTableItemView();
    localUITableItemView.setChecked(paramCheckBoxTableItem.isChecked());
    if (paramMethod != null) {
      localUITableItemView.setOnClickListener(new BaseTableActivity.4(this, paramMethod, localUITableItemView));
    }
  }
  
  private void initDetailTableItem(DetailTableItem paramDetailTableItem, Method paramMethod)
  {
    UITableItemView localUITableItemView = paramDetailTableItem.getTableItemView();
    if (paramDetailTableItem.getStyle() != 0) {
      localUITableItemView.setDetail(paramDetailTableItem.getDetail(), paramDetailTableItem.getStyle());
    }
    for (;;)
    {
      if (paramDetailTableItem.isHideArrow()) {
        localUITableItemView.hideArrow();
      }
      if (paramMethod != null) {
        localUITableItemView.setOnClickListener(new BaseTableActivity.3(this, paramMethod, paramDetailTableItem, localUITableItemView));
      }
      return;
      localUITableItemView.setDetail(paramDetailTableItem.getDetail());
    }
  }
  
  private int initItemsInTable(Table paramTable)
  {
    Object localObject = paramTable.getTableItems();
    if (localObject == null) {
      return 0;
    }
    Iterator localIterator = ((List)localObject).iterator();
    int i = 0;
    TableItem localTableItem;
    if (localIterator.hasNext())
    {
      localTableItem = (TableItem)localIterator.next();
      if (localTableItem.getLevel() != 1) {
        break label247;
      }
      i = 1;
    }
    label102:
    label247:
    for (;;)
    {
      int j = localTableItem.getResid();
      if (j != 0)
      {
        localObject = paramTable.getTableView().addItem(localTableItem.getResid());
        this.idTableItemMap.put(getString(localTableItem.getResid()), localTableItem);
        localTableItem.setTableItemView((UITableItemView)localObject);
        if (j == 0) {
          break label186;
        }
        localObject = (Method)this.mMethods.get(localTableItem.getResid());
        if (!(localTableItem instanceof CheckBoxTableItem)) {
          break label192;
        }
        initCheckboxTableItem((CheckBoxTableItem)localTableItem, (Method)localObject);
      }
      for (;;)
      {
        break;
        localObject = paramTable.getTableView().addItem(localTableItem.getTitle());
        this.idTableItemMap.put(localTableItem.getTitle(), localTableItem);
        break label102;
        localObject = null;
        break label130;
        if ((localTableItem instanceof DetailTableItem)) {
          initDetailTableItem((DetailTableItem)localTableItem, (Method)localObject);
        } else if ((localTableItem instanceof StartActivityTableItem)) {
          initStartActivityTableItem((StartActivityTableItem)localTableItem);
        } else {
          initNomalTableItem(localTableItem, (Method)localObject);
        }
      }
      return i;
    }
  }
  
  private void initNomalTableItem(TableItem paramTableItem, Method paramMethod)
  {
    if (paramMethod != null) {
      paramTableItem.getTableItemView().setOnClickListener(new BaseTableActivity.2(this, paramMethod));
    }
  }
  
  private void initStartActivityTableItem(StartActivityTableItem paramStartActivityTableItem)
  {
    UITableItemView localUITableItemView = paramStartActivityTableItem.getTableItemView();
    paramStartActivityTableItem = paramStartActivityTableItem.getActivityClass();
    if (paramStartActivityTableItem != null) {
      localUITableItemView.setOnClickListener(new BaseTableActivity.1(this, paramStartActivityTableItem));
    }
  }
  
  @Nullable
  private Object invokeCheckboxTableItemClickMethod(Method paramMethod, boolean paramBoolean)
    throws IllegalAccessException, InvocationTargetException
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Object localObject2 = null;
    Object localObject1;
    if ((arrayOfClass == null) || (arrayOfClass.length == 0)) {
      localObject1 = paramMethod.invoke(this, new Object[0]);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (arrayOfClass.length != 1);
      localObject1 = localObject2;
    } while (!arrayOfClass[0].isAssignableFrom(Boolean.TYPE));
    return paramMethod.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @Nullable
  private Object invokeDetailTableItemClickMethod(Method paramMethod, String paramString)
    throws IllegalAccessException, InvocationTargetException
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Object localObject2 = null;
    Object localObject1;
    if ((arrayOfClass == null) || (arrayOfClass.length == 0)) {
      localObject1 = paramMethod.invoke(this, new Object[0]);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (arrayOfClass.length != 1);
      localObject1 = localObject2;
    } while (!arrayOfClass[0].isAssignableFrom(String.class));
    return paramMethod.invoke(this, new Object[] { paramString });
  }
  
  public Table createTable(int paramInt)
  {
    Table localTable = new Table(paramInt);
    this.tables.add(localTable);
    return localTable;
  }
  
  public Table createTable(String paramString)
  {
    paramString = new Table(0, paramString);
    this.tables.add(paramString);
    return paramString;
  }
  
  public UITableItemView getTableItemViewByResid(int paramInt)
  {
    return ((TableItem)this.idTableItemMap.get(getString(paramInt))).getTableItemView();
  }
  
  public UITableView getTableViewByValue(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ((Table)this.valueTableMap.get(paramString)).getTableView();
    }
    return null;
  }
  
  public void initDataSource()
  {
    this.tables = new ArrayList();
    this.valueTableMap = new HashMap();
    this.idTableItemMap = new HashMap();
    this.mMethods = OnClickAnnotationUtil.getMethodsWithOnClickAnnotation(getClass(), false);
  }
  
  public void initDom()
  {
    initViewData();
    Iterator localIterator = this.tables.iterator();
    if (localIterator.hasNext())
    {
      Table localTable = (Table)localIterator.next();
      UITableView localUITableView = new UITableView(this);
      this.mSettingView.addContentView(localUITableView);
      if (localTable.getResid() != 0)
      {
        localUITableView.setCaption(localTable.getResid());
        this.valueTableMap.put(getString(localTable.getResid()), localTable);
      }
      for (;;)
      {
        localTable.setTableView(localUITableView);
        localTable.setLevel(initItemsInTable(localTable));
        localUITableView.commit();
        break;
        this.valueTableMap.put(localTable.getValue(), localTable);
      }
    }
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public abstract void initViewData();
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData()
  {
    boolean bool = QMSettingManager.sharedInstance().getBonusTest();
    Observable.from(this.tables).doOnNext(new BaseTableActivity.9(this, bool)).filter(new BaseTableActivity.8(this)).flatMap(new BaseTableActivity.7(this)).filter(new BaseTableActivity.6(this)).doOnNext(new BaseTableActivity.5(this, bool)).subscribe();
  }
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity
 * JD-Core Version:    0.7.0.1
 */