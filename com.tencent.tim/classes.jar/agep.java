import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.LinkedHashMap;
import java.util.List;

public class agep
  extends agdq
{
  private BaseFileAssistantActivity b;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  private Context mContext;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private View.OnClickListener r;
  
  public agep(Context paramContext, LinkedHashMap<String, List<WeiYunFileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.q = paramOnClickListener1;
    this.r = paramOnClickListener2;
    this.g = paramOnLongClickListener;
    this.eV = paramOnClickListener3;
    this.mContext = paramContext;
    this.b = paramBaseFileAssistantActivity;
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  private String a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return ahbj.g(paramWeiYunFileInfo.nFileSize);
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130845173);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  private String aW(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject2 = new agep.a();
        localObject1 = paramView;
        paramView = this.mInflater.inflate(2131561003, paramViewGroup, false);
        localObject1 = paramView;
        ((agep.a)localObject2).layout = ((RelativeLayout)paramView.findViewById(2131376838));
        localObject1 = paramView;
        ((agep.a)localObject2).layout.setOnClickListener(this.r);
        localObject1 = paramView;
        ((agep.a)localObject2).layout.setOnLongClickListener(this.g);
        localObject1 = paramView;
        ((agep.a)localObject2).layout.setTag(localObject2);
        localObject1 = paramView;
        ((agep.a)localObject2).c = ((CircleFileStateView)paramView.findViewById(2131361963));
        localObject1 = paramView;
        ((agep.a)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131367036));
        localObject1 = paramView;
        ((agep.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367020));
        localObject1 = paramView;
        ((agep.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.r);
        localObject1 = paramView;
        ((agep.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
        localObject1 = paramView;
        ((agep.a)localObject2).fileName = ((TextView)paramView.findViewById(2131367034));
        localObject1 = paramView;
        ((agep.a)localObject2).fileName.setGravity(48);
        localObject1 = paramView;
        ((agep.a)localObject2).fileName.setMaxLines(2);
        localObject1 = paramView;
        ((agep.a)localObject2).aY = ((TextView)paramView.findViewById(2131367018));
        localObject1 = paramView;
        ((agep.a)localObject2).time = ((TextView)paramView.findViewById(2131370129));
        localObject1 = paramView;
        ((agep.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject2);
        paramViewGroup = (ViewGroup)localObject2;
      }
      catch (Exception paramViewGroup)
      {
        Object localObject2;
        int i;
        paramView = (View)localObject1;
        continue;
        continue;
      }
      try
      {
        i = ahav.getFileType(localWeiYunFileInfo.strFileName);
        ahav.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.bIz, i);
        paramViewGroup.ccW = paramInt1;
        paramViewGroup.cWL = paramInt2;
        paramViewGroup.entity = localWeiYunFileInfo;
        paramViewGroup.c.setOnClickListener(this.eV);
        paramViewGroup.c.setState(2);
        paramViewGroup.c.setTag(paramViewGroup);
        paramViewGroup.actionType = 1;
        if ((ahav.getFileType(localWeiYunFileInfo.strFileName) == 0) && (aqhq.fileExistsAndNotEmpty(localWeiYunFileInfo.bIz))) {
          a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.bIz);
        }
        paramViewGroup.fileName.setText(localWeiYunFileInfo.strFileName);
        paramViewGroup.aY.setText(a(localWeiYunFileInfo));
        localObject1 = this.b.getString(2131693614);
        localObject2 = this.b.getString(2131693588);
        localObject1 = ahcb.bu(localWeiYunFileInfo.mtime) + aW((String)localObject2, (String)localObject1);
        paramViewGroup.time.setText((CharSequence)localObject1);
        localObject2 = this.b.app.a().f(localWeiYunFileInfo.bIk);
        if (localObject2 == null) {
          continue;
        }
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setState(1);
        paramViewGroup.c.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        paramViewGroup.actionType = 2;
        paramViewGroup.c.TH(true);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.b.app.a().c(localWeiYunFileInfo.bIk);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!ahbj.fileExistsAndNotEmpty(((FileManagerEntity)localObject2).getFilePath()))
            {
              ((FileManagerEntity)localObject2).setCloudType(2);
              if (((FileManagerEntity)localObject2).getId() > 0L) {
                ((FileManagerEntity)localObject2).nOpType = 5;
              }
              localObject1 = localObject2;
              if (((FileManagerEntity)localObject2).status != 1)
              {
                paramViewGroup.c.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
                paramViewGroup.c.TH(true);
                localObject1 = localObject2;
              }
            }
          }
        }
        if (localObject1 != null) {
          switch (((FileManagerEntity)localObject1).status)
          {
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setState(2);
        paramViewGroup.actionType = 3;
        continue;
        paramViewGroup.c.setVisibility(4);
        paramViewGroup.actionType = 0;
        continue;
        paramViewGroup.c.setState(2);
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.actionType = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      if (!this.b.akL()) {
        continue;
      }
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(agmz.c(localWeiYunFileInfo));
      localObject1 = (LinearLayout.LayoutParams)paramViewGroup.aY.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = wja.dp2px(3.0F, this.mContext.getResources());
      paramViewGroup.aY.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.mContext.getResources().getDisplayMetrics()), 1.0F);
      paramViewGroup.aY.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.fileName.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.mContext.getResources().getDisplayMetrics()), 1.0F);
      return paramView;
      localObject1 = paramView;
      paramViewGroup = (agep.a)paramView.getTag();
      continue;
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.TH(false);
    }
  }
  
  public class a
    implements Cloneable
  {
    public CheckBox a;
    public AsyncImageView a;
    public TextView aY;
    public int actionType;
    public CircleFileStateView c;
    public int cWL;
    public int ccW;
    public Object entity;
    public TextView fileName;
    public RelativeLayout layout;
    public TextView time;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agep
 * JD-Core Version:    0.7.0.1
 */