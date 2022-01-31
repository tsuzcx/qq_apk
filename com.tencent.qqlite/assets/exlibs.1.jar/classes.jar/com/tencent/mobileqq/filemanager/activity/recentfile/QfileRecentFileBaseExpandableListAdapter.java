package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.FileUtils;
import dns;
import dnt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class QfileRecentFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private View.OnClickListener b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public QfileRecentFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.b = paramOnClickListener1;
    this.c = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.d = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(FileManagerEntity paramFileManagerEntity)
  {
    String str = null;
    Object localObject1;
    switch (paramFileManagerEntity.nOpType)
    {
    case 2: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    default: 
      localObject1 = null;
      if (paramFileManagerEntity.cloudType != 0) {
        break;
      }
    }
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361971);; localObject2 = localObject1)
    {
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361964)))
        {
          localObject1 = str;
          if (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361972))) {
            localObject1 = paramFileManagerEntity.peerNick;
          }
        }
      }
      if (paramFileManagerEntity.TroopUin != 0L)
      {
        localObject1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(8)).a(String.valueOf(paramFileManagerEntity.TroopUin));
        if (!paramFileManagerEntity.bSend) {
          break label559;
        }
      }
      label559:
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362056) + ((TroopInfo)localObject1).troopname;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362055) + ((TroopInfo)localObject1).troopname)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361977);
        return QfileTimeUtils.b(paramFileManagerEntity.srvTime) + a(str, (String)localObject2) + a("", (String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361971);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361964);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361973);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361972);
        break;
        if (paramFileManagerEntity.bSend)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361973);
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361971);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362039);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362040);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362041);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362042);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362043);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362044);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362045);
        break;
      }
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130838552);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  private String b(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject;
    String str2;
    switch (paramFileManagerEntity.cloudType)
    {
    default: 
      localObject = null;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361977);
      str2 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, (String)localObject) + a(str3, str1);
      localObject = FileUtil.a(paramFileManagerEntity.fileSize) + a(str3, str1);
      if ((paramFileManagerEntity.cloudType == 2) && (3 == paramFileManagerEntity.nOpType)) {
        localObject = str2;
      }
      break;
    }
    while (paramFileManagerEntity.TroopUin == 0L)
    {
      return localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361945);
      str1 = FileManagerUtil.a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType, false);
      str1 = str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361974);
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131361946);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
    }
    return str2;
  }
  
  public int a()
  {
    return 2130903119;
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject = (dnt)paramView.getTag();
    if (localObject == null)
    {
      localObject = new dnt();
      paramView.findViewById(2131296844).setVisibility(0);
      ((dnt)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296845));
      ((dnt)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296846));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = (String)getGroup(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j())
    {
      localObject3 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (dns)((Iterator)localObject3).next();
          if (((dns)localObject2).jdField_a_of_type_Int != paramInt2) {
            break label1524;
          }
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((dns)localObject2).jdField_b_of_type_Int);
        }
      }
    }
    while (localObject2 == null)
    {
      return paramView;
      localObject2 = (FileManagerEntity)getChild(paramInt1, paramInt2);
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject3 = new QfileRecentFileBaseExpandableListAdapter.RecentItemHolder(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903413, paramViewGroup, false);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297983));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.c);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject3);
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131297988));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131297984));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297986));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297987));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297990));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296950));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297991));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).d = ((TextView)paramView.findViewById(2131297251));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131296445));
        localObject1 = paramView;
        ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.b);
        localObject1 = paramView;
        paramView.setTag(localObject3);
        paramViewGroup = (ViewGroup)localObject3;
      }
      catch (Exception paramViewGroup)
      {
        paramView = (View)localObject1;
        continue;
      }
      try
      {
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject2);
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        paramViewGroup.c = paramInt2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject2;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.d);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
        if (FileManagerUtil.a(((FileManagerEntity)localObject2).fileName) == 0)
        {
          if (FileUtils.b(((FileManagerEntity)localObject2).strFilePath))
          {
            FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).strFilePath, ((FileManagerEntity)localObject2).nFileType);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((FileManagerEntity)localObject2).fileName);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(b((FileManagerEntity)localObject2));
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.d.setText(a((FileManagerEntity)localObject2));
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            if (((FileManagerEntity)localObject2).cloudType == 3)
            {
              if (((FileManagerEntity)localObject2).nFileType == 5) {
                FileCategoryUtil.a((FileManagerEntity)localObject2);
              }
              if ((!FileUtils.a(((FileManagerEntity)localObject2).strFilePath)) && (((FileManagerEntity)localObject2).status == 1))
              {
                if ((((FileManagerEntity)localObject2).Uuid == null) || (((FileManagerEntity)localObject2).Uuid.length() <= 0)) {
                  continue;
                }
                ((FileManagerEntity)localObject2).cloudType = 1;
                ((FileManagerEntity)localObject2).status = -1;
              }
            }
          }
          switch (((FileManagerEntity)localObject2).status)
          {
          case 16: 
          case 17: 
            paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j())
            {
              paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837917);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
              paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a((FileManagerEntity)localObject2));
              return paramView;
              localObject1 = paramView;
              paramViewGroup = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
              continue;
              if (FileUtils.b(((FileManagerEntity)localObject2).strThumbPath))
              {
                a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).strThumbPath);
                continue;
              }
            }
            break;
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).fileName, ((FileManagerEntity)localObject2).nFileType);
        continue;
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject2);
        continue;
        if ((((FileManagerEntity)localObject2).WeiYunFileId == null) || (((FileManagerEntity)localObject2).WeiYunFileId.length() <= 0)) {
          continue;
        }
        ((FileManagerEntity)localObject2).cloudType = 2;
        ((FileManagerEntity)localObject2).status = -1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362075);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 2;
        paramViewGroup.d.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362076);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 3;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramBoolean = FileUtil.a(((FileManagerEntity)localObject2).strFilePath);
        if ((((FileManagerEntity)localObject2).cloudType == 3) || (paramBoolean))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362074);
          paramViewGroup.jdField_a_of_type_Int = 0;
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          continue;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362077);
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362076);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 3;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362074);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362077);
        paramViewGroup.jdField_a_of_type_Int = 1;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362074);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362074);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362077);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362074);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 0;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131362077);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_Int = 1;
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      label1524:
      break;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject = (ArrayList)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.j())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((ArrayList)localObject).iterator();
        int j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          int k;
          if (((FileManagerEntity)localIterator.next()).cloudType == 0)
          {
            k = j + 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            k = j;
            j = i;
            i = k;
            break;
            dns localdns = new dns(this);
            localdns.jdField_a_of_type_Int = i;
            localdns.jdField_b_of_type_Int = (i + j);
            localArrayList.add(localdns);
            k = i + 1;
            i = j;
            j = k;
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
        i = ((ArrayList)localObject).size() - j;
      }
    }
    else
    {
      return i;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    return ((ArrayList)localObject).size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (dnt)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (String)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (!paramBoolean) {
        break label150;
      }
      paramViewGroup.setContentDescription((String)localObject + "分组已展开，双击此处可收起分组");
    }
    for (;;)
    {
      paramViewGroup.setFocusable(true);
      paramViewGroup.setFocusableInTouchMode(true);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903119, paramViewGroup, false);
      paramView = new dnt();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296845));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296846));
      paramViewGroup.setTag(paramView);
      break;
      label150:
      paramViewGroup.setContentDescription((String)localObject + "分组已折叠，双击此处可展开分组");
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */