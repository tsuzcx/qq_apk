import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;

public class agex
  extends agdu
  implements View.OnClickListener
{
  LinkedHashMap<String, List<FileInfo>> S = null;
  int mFileType = -1;
  
  public agex(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
  {
    super(paramBaseFileAssistantActivity, paramObject, null, null, null, null, null);
    this.S = ((LinkedHashMap)paramObject);
    this.mFileType = paramInt;
  }
  
  protected View e(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    for (Object localObject = (FileInfo)paramViewGroup;; localObject = null)
    {
      if (localObject == null) {
        return null;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          paramViewGroup = this.mInflater.inflate(2131561022, null);
          paramView = paramViewGroup;
          try
          {
            locala = new agex.a();
            paramView = paramViewGroup;
            locala.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131368820));
            paramView = paramViewGroup;
            locala.zH = ((ImageView)paramViewGroup.findViewById(2131368840));
            paramView = paramViewGroup;
            locala.aj = ((ImageView)paramViewGroup.findViewById(2131368836));
            paramView = paramViewGroup;
            locala.d = ((EllipsizingTextView)paramViewGroup.findViewById(2131367034));
            paramView = paramViewGroup;
            locala.fileSize = ((TextView)paramViewGroup.findViewById(2131367037));
            paramView = paramViewGroup;
            locala.bD = ((FrameLayout)paramViewGroup.findViewById(2131364676));
            paramView = paramViewGroup;
            paramViewGroup.setTag(locala);
            paramView = paramViewGroup;
            ((FileInfo)localObject).setGroupName((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            locala.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            locala.position = paramInt2;
            paramView = paramViewGroup;
            locala.cWI = paramInt1;
            paramView = paramViewGroup;
            locala.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            locala.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            locala.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130848704);
            paramView = paramViewGroup;
            locala.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.cWJ, this.cWJ);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).isIgonFilename())
            {
              paramView = paramViewGroup;
              locala.d.setText(((FileInfo)localObject).getName());
              paramView = paramViewGroup;
              locala.d.setMaxLines(2);
              paramView = paramViewGroup;
              locala.fileSize.setText(ahbj.g(((FileInfo)localObject).getSize()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              locala.bD.setOnClickListener(this);
              paramView = paramViewGroup;
              locala.bD.setTag(locala);
              paramView = paramViewGroup;
              if (this.a != null)
              {
                paramView = paramViewGroup;
                str = this.a.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (ahbj.fileExistsAndNotEmpty(str))
                {
                  paramView = paramViewGroup;
                  locala.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.b.getString(2131693611) + ((FileInfo)localObject).getName();
              paramView = paramViewGroup;
              locala.zH.setVisibility(0);
              paramView = paramViewGroup;
              if (!agmz.d((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.b.getString(2131693612);
              paramView = paramViewGroup;
              locala.zH.setImageResource(2130841267);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.b.getResources().getColor(2131167654));
              paramView = paramViewGroup;
              locala.aj.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              locala.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              locala = (agex.a)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            locala.d.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          agex.a locala;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        locala.aj.setVisibility(4);
        paramView = paramViewGroup;
        locala.zH.setImageResource(2130846606);
        localObject = str;
      }
    }
  }
  
  protected int getColumnCount()
  {
    return 4;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getGroupView(paramInt, paramBoolean, paramView, paramViewGroup);
    paramView = null;
    if (paramViewGroup != null) {
      paramView = (agdq.b)paramViewGroup.getTag();
    }
    if (paramView != null)
    {
      if (this.b.eA() == 1)
      {
        paramView.mCheckBox.setVisibility(8);
        paramViewGroup.setEnabled(false);
        onGroupExpanded(0);
      }
    }
    else {
      return paramViewGroup;
    }
    paramViewGroup.setEnabled(true);
    paramView.mCheckBox.setVisibility(0);
    return paramViewGroup;
  }
  
  public void j(View paramView, int paramInt)
  {
    super.j(paramView, paramInt);
    agdq.b localb = (agdq.b)paramView.getTag();
    if (localb != null)
    {
      if (this.b.eA() == 1)
      {
        localb.mCheckBox.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localb.mCheckBox.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject = (agex.a)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.a != null) {
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (agmz.d(((agex.a)localObject).jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        agmz.e(((agex.a)localObject).jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((agex.a)localObject).zH.setSelected(false);
        ((agex.a)localObject).zH.setImageResource(2130846606);
        ((agex.a)localObject).aj.setVisibility(4);
        if (this.a != null) {
          this.a.a(((agex.a)localObject).jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.b.deR();
        break;
        agmz.d(((agex.a)localObject).jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((agex.a)localObject).zH.setSelected(true);
        ((agex.a)localObject).zH.setImageResource(2130841267);
        ((agex.a)localObject).aj.setVisibility(0);
        if (this.a != null) {
          this.a.a(((agex.a)localObject).jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
      FileManagerEntity localFileManagerEntity = ahav.a(((agex.a)localObject).jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
      localFileManagerEntity.nFileType = this.mFileType;
      localFileManagerEntity.setFilePath(this.a.a(((agex.a)localObject).jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
      localObject = new agvl(this.b.app, this.mContext, localFileManagerEntity, 10000);
      localObject = new agvn(this.mContext, (agvq)localObject);
      ((agvn)localObject).Oy(8);
      ((agvn)localObject).k(sxx.getViewRect(paramView));
      ((agvn)localObject).djN();
    }
  }
  
  public class a
  {
    ImageView aj;
    FileInfo jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    AsyncImageView jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    FrameLayout bD;
    public int cWI;
    EllipsizingTextView d;
    TextView fileSize;
    public int position;
    ImageView zH;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agex
 * JD-Core Version:    0.7.0.1
 */