package com.tencent.mobileqq.filemanager.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.Settings.System;
import android.text.TextUtils;
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
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class RecentFileAdapter
  extends BaseFileAdapter
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private String jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  private long jdField_b_of_type_Long = -1L;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener c;
  
  public RecentFileAdapter(Context paramContext, List paramList, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramOnClickListener1);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    c();
    a();
  }
  
  private String a(FileManagerEntity paramFileManagerEntity)
  {
    String str4 = null;
    Object localObject;
    String str2;
    label234:
    String str3;
    switch (paramFileManagerEntity.cloudType)
    {
    case 4: 
    default: 
      localObject = null;
      str2 = null;
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
        str1 = null;
        if (paramFileManagerEntity.cloudType == 0) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558709);
        }
        str3 = str4;
        if (str1 != null)
        {
          str3 = str4;
          if (!str1.equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558703)))
          {
            str3 = str4;
            if (!str1.equals(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558710))) {
              str3 = paramFileManagerEntity.peerNick;
            }
          }
        }
        if (paramFileManagerEntity.cloudType == 5) {
          if (!paramFileManagerEntity.bSend) {
            break label760;
          }
        }
        break;
      }
      break;
    }
    label760:
    for (String str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558711);; str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558709))
    {
      str3 = paramFileManagerEntity.peerNick;
      str4 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558715);
      str2 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str4, str2) + a(str4, (String)localObject) + a(str4, str1) + a("", str3);
      str1 = FileUtil.a(paramFileManagerEntity.fileSize) + a(str4, (String)localObject) + a(str4, str1) + a("", str3);
      if ((paramFileManagerEntity.cloudType != 2) || (3 != paramFileManagerEntity.nOpType)) {
        break label773;
      }
      return str2;
      str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558682);
      str1 = FileManagerUtil.a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType, false);
      localObject = str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558712);
      break;
      str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558683);
      localObject = null;
      break;
      localObject = null;
      str2 = null;
      break;
      localObject = null;
      str2 = null;
      break;
      str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131560836);
      localObject = null;
      break;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558709);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558703);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558711);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558710);
      break label234;
      if (paramFileManagerEntity.bSend)
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558711);
        break label234;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558709);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558781);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558782);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558783);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558784);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558785);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558786);
      break label234;
      str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558787);
      break label234;
    }
    label773:
    if (paramFileManagerEntity.cloudType == 5) {
      return str2;
    }
    if (paramFileManagerEntity.TroopUin != 0L)
    {
      localObject = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b.getManager(8)).a(String.valueOf(paramFileManagerEntity.TroopUin));
      if (paramFileManagerEntity.bSend) {
        return str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558798) + ((TroopInfo)localObject).troopname;
      }
      return str1 + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131558797) + ((TroopInfo)localObject).troopname;
    }
    return str1;
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString + "_" + LocaleUtil.a());
    if ((localObject == null) || (!a()))
    {
      localObject = new HashMap();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString + "_" + LocaleUtil.a(), localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = TimeFormatterUtils.a(paramLong, true, this.jdField_a_of_type_JavaLangString);
      paramString.put(paramLong + "", localObject);
      paramString = (String)localObject;
      String str;
      do
      {
        return paramString;
        str = (String)((HashMap)localObject).get(paramLong + "");
        paramString = str;
      } while (str != null);
      ((HashMap)localObject).clear();
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
    paramAsyncImageView.setDefaultImage(2130838614);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      c();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
  }
  
  private void c()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  public void a()
  {
    String str = Settings.System.getString(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "date_format");
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_JavaLangString = str;
      return;
    }
    this.jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
  
  @SuppressLint({"InlinedApi"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)getItem(paramInt);
    View localView;
    if (localFileManagerEntity == null)
    {
      localView = null;
      label18:
      return localView;
    }
    if (paramView == null) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          localItemHolder = new RecentFileAdapter.ItemHolder(this);
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903504, paramViewGroup, false);
          paramView = paramViewGroup;
          paramViewGroup = paramView;
        }
        catch (Exception localException)
        {
          RecentFileAdapter.ItemHolder localItemHolder;
          paramViewGroup = paramView;
          paramView = localException;
          continue;
          continue;
        }
        try
        {
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232748));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localItemHolder);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232752));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131232741));
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232753));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131232742));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232750));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232743));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131231506));
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232746));
          paramViewGroup = paramView;
          localItemHolder.d = ((TextView)paramView.findViewById(2131231883));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131230987));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131231701));
          paramViewGroup = paramView;
          paramView.setTag(localItemHolder);
          paramViewGroup = paramView;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) {
            continue;
          }
          paramViewGroup = paramView;
          if (localFileManagerEntity.cloudType != 0) {
            continue;
          }
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_Long = localFileManagerEntity.uniseq;
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_Long = localFileManagerEntity.nSessionId;
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = localFileManagerEntity;
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.c);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(localItemHolder);
          paramViewGroup = paramView;
          if (FileManagerUtil.a(localFileManagerEntity.fileName) != 0) {
            continue;
          }
          paramViewGroup = paramView;
          if (!FileUtils.b(localFileManagerEntity.strThumbPath)) {
            continue;
          }
          paramViewGroup = paramView;
          a(localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.strThumbPath);
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileManagerEntity));
          paramViewGroup = paramView;
          localItemHolder.d.setText(a(localFileManagerEntity.selfUin, localFileManagerEntity.srvTime));
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup = paramView;
          switch (localFileManagerEntity.status)
          {
          case 16: 
          case 17: 
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.d.setVisibility(0);
            paramViewGroup = paramView;
            if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) {
              continue;
            }
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837850);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileManagerEntity));
            localView = paramView;
            paramViewGroup = paramView;
            if (!a(paramInt, paramView, localItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout, localItemHolder.jdField_a_of_type_AndroidWidgetButton, localFileManagerEntity)) {
              break label18;
            }
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.d.setVisibility(4);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            return paramView;
          }
        }
        catch (Exception paramView) {}
      }
      paramView.printStackTrace();
      return paramViewGroup;
      localItemHolder = (RecentFileAdapter.ItemHolder)paramView.getTag();
      continue;
      paramViewGroup = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g())
      {
        paramViewGroup = paramView;
        if (localFileManagerEntity.cloudType == 5)
        {
          paramViewGroup = paramView;
          if (!localFileManagerEntity.bSend)
          {
            paramViewGroup = paramView;
            if (localFileManagerEntity.status != 1)
            {
              paramViewGroup = paramView;
              localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              continue;
            }
          }
        }
      }
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      continue;
      paramViewGroup = paramView;
      if (localFileManagerEntity.strFilePath != null)
      {
        paramViewGroup = paramView;
        if (localFileManagerEntity.strFilePath.length() > 0)
        {
          paramViewGroup = paramView;
          a(localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.strFilePath, localFileManagerEntity.nFileType);
          continue;
        }
      }
      paramViewGroup = paramView;
      a(localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.fileName, localFileManagerEntity.nFileType);
      continue;
      paramViewGroup = paramView;
      FileManagerUtil.a(localItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      continue;
      paramViewGroup = paramView;
      localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramViewGroup = paramView;
      localItemHolder.d.setVisibility(0);
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      continue;
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      paramViewGroup = paramView;
      localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewGroup = paramView;
      localItemHolder.d.setVisibility(0);
      continue;
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      paramViewGroup = paramView;
      localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewGroup = paramView;
      localItemHolder.d.setVisibility(0);
      continue;
      paramViewGroup = paramView;
      localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      paramViewGroup = paramView;
      localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramViewGroup = paramView;
      localItemHolder.d.setVisibility(4);
      continue;
      paramViewGroup = paramView;
      if (13 == localFileManagerEntity.nOpType)
      {
        paramViewGroup = paramView;
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup = paramView;
        localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup = paramView;
        localItemHolder.d.setVisibility(4);
      }
      else
      {
        paramViewGroup = paramView;
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup = paramView;
        localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramViewGroup = paramView;
        localItemHolder.d.setVisibility(0);
        continue;
        paramViewGroup = paramView;
        localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        paramViewGroup = paramView;
        localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramViewGroup = paramView;
        localItemHolder.d.setVisibility(0);
        continue;
        paramViewGroup = paramView;
        if (10 == localFileManagerEntity.nOpType)
        {
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          paramViewGroup = paramView;
          localItemHolder.d.setVisibility(0);
        }
        else
        {
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramViewGroup = paramView;
          localItemHolder.d.setVisibility(4);
          continue;
          paramViewGroup = paramView;
          localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          paramViewGroup = paramView;
          localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          paramViewGroup = paramView;
          localItemHolder.d.setVisibility(0);
          continue;
          paramViewGroup = paramView;
          if (9 == localFileManagerEntity.nOpType)
          {
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramViewGroup = paramView;
            localItemHolder.d.setVisibility(0);
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
          }
          else
          {
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
            paramViewGroup = paramView;
            localItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            paramViewGroup = paramView;
            localItemHolder.d.setVisibility(0);
            continue;
            paramViewGroup = paramView;
            localItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.RecentFileAdapter
 * JD-Core Version:    0.7.0.1
 */