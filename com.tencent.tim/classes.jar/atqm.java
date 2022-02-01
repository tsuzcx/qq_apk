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
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import java.util.LinkedHashMap;
import java.util.List;

public class atqm
  extends atpo
{
  private BaseFileAssistantActivity b;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  private View.OnClickListener gu;
  private Context mContext;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private View.OnClickListener r;
  
  public atqm(Context paramContext, LinkedHashMap<String, List<WeiYunFileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3, View.OnClickListener paramOnClickListener4)
  {
    super(paramContext, paramLinkedHashMap);
    this.q = paramOnClickListener1;
    this.r = paramOnClickListener2;
    this.g = paramOnLongClickListener;
    this.eV = paramOnClickListener3;
    this.gu = paramOnClickListener4;
    this.mContext = paramContext;
    this.b = paramBaseFileAssistantActivity;
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  private String a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return aueh.g(paramWeiYunFileInfo.nFileSize);
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
        localObject2 = new atqm.a();
        localObject1 = paramView;
        paramView = this.mInflater.inflate(2131561003, paramViewGroup, false);
        localObject1 = paramView;
        ((atqm.a)localObject2).layout = ((RelativeLayout)paramView.findViewById(2131376838));
        localObject1 = paramView;
        ((atqm.a)localObject2).layout.setOnClickListener(this.r);
        localObject1 = paramView;
        ((atqm.a)localObject2).layout.setOnLongClickListener(this.g);
        localObject1 = paramView;
        ((atqm.a)localObject2).layout.setTag(localObject2);
        localObject1 = paramView;
        ((atqm.a)localObject2).el = ((Button)paramView.findViewById(2131361963));
        localObject1 = paramView;
        ((atqm.a)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131367036));
        localObject1 = paramView;
        ((atqm.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367020));
        localObject1 = paramView;
        ((atqm.a)localObject2).J = ((ImageView)paramView.findViewById(2131367042));
        localObject1 = paramView;
        ((atqm.a)localObject2).fileName = ((TextView)paramView.findViewById(2131367034));
        localObject1 = paramView;
        ((atqm.a)localObject2).k = ((ProgressBar)paramView.findViewById(2131367035));
        localObject1 = paramView;
        ((atqm.a)localObject2).aY = ((TextView)paramView.findViewById(2131367018));
        localObject1 = paramView;
        ((atqm.a)localObject2).time = ((TextView)paramView.findViewById(2131370129));
        localObject1 = paramView;
        ((atqm.a)localObject2).delBtn = ((Button)paramView.findViewById(2131365671));
        localObject1 = paramView;
        ((atqm.a)localObject2).delBtn.setOnClickListener(this.q);
        localObject1 = paramView;
        ((atqm.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
        localObject1 = paramView;
        ((atqm.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.gu);
        localObject1 = paramView;
        ((atqm.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
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
        paramViewGroup.el.setOnClickListener(this.eV);
        paramViewGroup.el.setText(2131693838);
        paramViewGroup.el.setTag(paramViewGroup);
        paramViewGroup.actionType = 1;
        if ((ahav.getFileType(localWeiYunFileInfo.strFileName) == 0) && (aqhq.fileExistsAndNotEmpty(localWeiYunFileInfo.bIz))) {
          a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.bIz);
        }
        paramViewGroup.fileName.setText(ahav.kY(localWeiYunFileInfo.strFileName));
        paramViewGroup.aY.setText(a(localWeiYunFileInfo));
        localObject1 = this.b.getString(2131693614);
        localObject2 = this.b.getString(2131693588);
        localObject1 = auem.bu(localWeiYunFileInfo.mtime) + aW((String)localObject2, (String)localObject1);
        paramViewGroup.time.setText((CharSequence)localObject1);
        paramViewGroup.k.setVisibility(8);
        localObject1 = this.b.app.a().f(localWeiYunFileInfo.bIk);
        if ((localObject1 == null) || (((FileManagerEntity)localObject1).status != 2)) {
          continue;
        }
        paramViewGroup.k.setVisibility(0);
        paramViewGroup.k.setProgress((int)(((FileManagerEntity)localObject1).getfProgress() * 100.0F));
        paramViewGroup.el.setText(2131693840);
        paramViewGroup.actionType = 2;
        if (localObject1 == null)
        {
          localObject1 = this.b.app.a().c(localWeiYunFileInfo.bIk);
          if ((localObject1 != null) && (!aueh.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).getFilePath())))
          {
            ((FileManagerEntity)localObject1).setCloudType(2);
            if (((FileManagerEntity)localObject1).getId() > 0L) {
              ((FileManagerEntity)localObject1).nOpType = 5;
            }
            if (((FileManagerEntity)localObject1).status == 1) {
              ((FileManagerEntity)localObject1).status = -1;
            }
          }
          if (localObject1 != null) {
            switch (((FileManagerEntity)localObject1).status)
            {
            }
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        paramViewGroup.el.setText(2131693841);
        paramViewGroup.el.setVisibility(0);
        paramViewGroup.actionType = 3;
        continue;
        paramViewGroup.el.setText(2131693842);
        paramViewGroup.el.setVisibility(8);
        paramViewGroup.actionType = 0;
        continue;
        paramViewGroup.el.setText(2131693838);
        paramViewGroup.el.setVisibility(0);
        paramViewGroup.actionType = 1;
        continue;
        paramViewGroup.el.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      if (!this.b.akL()) {
        continue;
      }
      paramViewGroup.el.setVisibility(8);
      paramViewGroup.layout.setBackgroundResource(2130839639);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(atwb.c(localWeiYunFileInfo));
      return paramView;
      localObject1 = paramView;
      paramViewGroup = (atqm.a)paramView.getTag();
      continue;
      paramViewGroup.k.setVisibility(8);
    }
  }
  
  public class a
    implements Cloneable
  {
    public ImageView J;
    public CheckBox a;
    public AsyncImageView a;
    public TextView aY;
    public int actionType;
    public int cWL;
    public int ccW;
    public Button delBtn;
    public Button el;
    public Object entity;
    public TextView fileName;
    public ProgressBar k;
    public RelativeLayout layout;
    public TextView time;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqm
 * JD-Core Version:    0.7.0.1
 */