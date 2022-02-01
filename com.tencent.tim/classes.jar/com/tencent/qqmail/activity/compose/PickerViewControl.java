package com.tencent.qqmail.activity.compose;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.tencent.qqmail.model.alias.AliasItem;
import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class PickerViewControl
{
  private static final HashMap<String, Integer> DOMAIN_ORDER_MAP = new HashMap(10);
  private static final int DOMAIN_ORDER_MAP_CAPACITY = 10;
  private static final String TAG = "PickerViewControl";
  private boolean animating;
  private PickerViewControlCallback callback;
  private ComposeData composeData;
  private List<AliasItem> data = null;
  private boolean isGroup;
  private boolean loadError;
  private Dialog picker;
  private boolean pickerShown;
  private int sChooseAccountId = -1;
  private String sChooseName = "";
  private int selectedRow = 0;
  private String title = "";
  
  static
  {
    DOMAIN_ORDER_MAP.put("@qq.com", Integer.valueOf(0));
    DOMAIN_ORDER_MAP.put("@vip.qq.com", Integer.valueOf(1));
    DOMAIN_ORDER_MAP.put("@exmail.qq.com", Integer.valueOf(2));
    DOMAIN_ORDER_MAP.put("@rdgz.org", Integer.valueOf(3));
    DOMAIN_ORDER_MAP.put("@foxmail.com", Integer.valueOf(4));
    DOMAIN_ORDER_MAP.put("@tencent.com", Integer.valueOf(5));
    DOMAIN_ORDER_MAP.put("@163.com", Integer.valueOf(6));
    DOMAIN_ORDER_MAP.put("@126.com", Integer.valueOf(7));
    DOMAIN_ORDER_MAP.put("@gmail.com", Integer.valueOf(8));
    DOMAIN_ORDER_MAP.put("@hotmail.com", Integer.valueOf(9));
  }
  
  private Dialog buildDialog()
  {
    if ((this.callback == null) || (this.data == null)) {}
    do
    {
      return null;
      localObject = this.callback.getActivity();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = new QMBottomDialog.BottomListSheetBuilder((Context)localObject, true);
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setTitle(this.title);
    int j = -1;
    int i = 0;
    while (i < this.data.size())
    {
      String str = ((AliasItem)this.data.get(i)).getAlias();
      int k = j;
      if (str != null)
      {
        k = j;
        if (str.length() > 0)
        {
          ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(str);
          k = j;
          if (str.equals(this.sChooseName)) {
            k = i;
          }
        }
      }
      i += 1;
      j = k;
    }
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setCheckedIndex(j);
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new PickerViewControl.1(this));
    return ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
  }
  
  private void hide()
  {
    if (!this.pickerShown) {
      return;
    }
    this.picker.dismiss();
    this.pickerShown = true;
  }
  
  private boolean isExistAlias(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.data != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.data.size())
      {
        if (((AliasItem)this.data.get(i)).getAlias().equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private ArrayList<AliasItem> parseAliasItems(ComposeData paramComposeData)
  {
    int j = paramComposeData.getAccountId();
    paramComposeData = paramComposeData.getAlias_set();
    ArrayList localArrayList = new ArrayList();
    if ((paramComposeData != null) && (paramComposeData.size() > 0))
    {
      int i = 0;
      while (i < paramComposeData.size())
      {
        String str = (String)paramComposeData.get(i);
        if (!isExistAlias(str))
        {
          AliasItem localAliasItem = new AliasItem();
          localAliasItem.setAccountId(j);
          localAliasItem.setAlias(str);
          localArrayList.add(localAliasItem);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void appendData(List<AliasItem> paramList)
  {
    if (this.data == null)
    {
      this.data = paramList;
      return;
    }
    paramList = paramList.iterator();
    label20:
    label41:
    label116:
    label123:
    label126:
    for (;;)
    {
      AliasItem localAliasItem1;
      if (paramList.hasNext())
      {
        localAliasItem1 = (AliasItem)paramList.next();
        i = 0;
        if (i >= this.data.size()) {
          break label123;
        }
        AliasItem localAliasItem2 = (AliasItem)this.data.get(i);
        if (!StringUtils.equals(localAliasItem1.getAlias(), localAliasItem2.getAlias())) {
          break label116;
        }
        this.data.set(i, localAliasItem1);
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label126;
        }
        this.data.add(localAliasItem1);
        break label20;
        break;
        i += 1;
        break label41;
      }
    }
  }
  
  public void dismissPickerView()
  {
    if (this.pickerShown)
    {
      if (this.callback != null) {
        this.callback.dismissPickerView(null);
      }
      hide();
    }
  }
  
  public PickerViewControlCallback getCallback()
  {
    return this.callback;
  }
  
  public int getChooseAccountId()
  {
    return this.sChooseAccountId;
  }
  
  public String getChooseName()
  {
    return this.sChooseName;
  }
  
  public ComposeData getComposeData()
  {
    return this.composeData;
  }
  
  public List<AliasItem> getData()
  {
    return this.data;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void init() {}
  
  public boolean isAnimating()
  {
    return this.animating;
  }
  
  public boolean isGroup()
  {
    return this.isGroup;
  }
  
  public boolean isLoadError()
  {
    return this.loadError;
  }
  
  public boolean isPickerShown()
  {
    return this.pickerShown;
  }
  
  public void loadComposeData(ComposeData paramComposeData)
  {
    this.composeData = paramComposeData;
    if (this.data == null)
    {
      this.data = parseAliasItems(this.composeData);
      return;
    }
    this.data.addAll(parseAliasItems(this.composeData));
  }
  
  public void loadGroupContactData(MailGroupContactList paramMailGroupContactList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMailGroupContactList != null) && (paramMailGroupContactList.getGroupContacts() != null))
    {
      paramMailGroupContactList = paramMailGroupContactList.getGroupContacts().iterator();
      while (paramMailGroupContactList.hasNext())
      {
        MailGroupContact localMailGroupContact = (MailGroupContact)paramMailGroupContactList.next();
        AliasItem localAliasItem = new AliasItem();
        localAliasItem.setAccountId(-1);
        localAliasItem.setAlias(localMailGroupContact.getName());
        localArrayList.add(localAliasItem);
      }
    }
    this.data = localArrayList;
  }
  
  public void setAnimating(boolean paramBoolean)
  {
    this.animating = paramBoolean;
  }
  
  public void setCallback(PickerViewControlCallback paramPickerViewControlCallback)
  {
    this.callback = paramPickerViewControlCallback;
  }
  
  public void setComposeData(ComposeData paramComposeData)
  {
    this.composeData = paramComposeData;
  }
  
  public void setDefaultSelect(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      this.sChooseName = paramString;
    }
    for (;;)
    {
      if ((this.composeData == null) || (this.data == null)) {}
      for (;;)
      {
        return;
        if (this.composeData == null) {
          break label128;
        }
        paramString = this.composeData.getDefaultName();
        break;
        int i = 0;
        while (i < this.data.size())
        {
          String str = ((AliasItem)this.data.get(i)).getAlias();
          if ((str != null) && (str.equals(paramString)))
          {
            this.selectedRow = i;
            this.sChooseAccountId = ((AliasItem)this.data.get(i)).getAccountId();
            return;
          }
          i += 1;
        }
      }
      label128:
      paramString = "";
    }
  }
  
  public void setGroup(boolean paramBoolean)
  {
    this.isGroup = paramBoolean;
  }
  
  public void setLoadError(boolean paramBoolean)
  {
    this.loadError = paramBoolean;
  }
  
  public void setPickerShown(boolean paramBoolean)
  {
    this.pickerShown = paramBoolean;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setsChooseAccountId(int paramInt)
  {
    this.sChooseAccountId = paramInt;
  }
  
  public void setsChooseName(String paramString)
  {
    this.sChooseName = paramString;
  }
  
  public boolean show()
  {
    if ((this.data == null) || (this.data.size() <= 0)) {}
    while ((!this.isGroup) && (this.data.size() <= 1)) {
      return false;
    }
    if (this.picker == null) {
      this.picker = buildDialog();
    }
    if (this.picker != null)
    {
      this.pickerShown = true;
      this.picker.show();
      return true;
    }
    this.pickerShown = false;
    return this.pickerShown;
  }
  
  public void sortData()
  {
    if ((this.data == null) || (this.data.size() <= 1)) {
      return;
    }
    Collections.sort(this.data, new PickerViewControl.2(this));
  }
  
  public static abstract interface PickerViewControlCallback
  {
    public abstract void didSelectRow(PickerViewControl paramPickerViewControl, int paramInt);
    
    public abstract void dismissPickerView(View paramView);
    
    public abstract Activity getActivity();
    
    public abstract void touchUpOutSideContainer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.PickerViewControl
 * JD-Core Version:    0.7.0.1
 */