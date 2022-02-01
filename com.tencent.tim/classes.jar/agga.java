import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class agga
  extends agdq
{
  private BaseFileAssistantActivity b;
  private boolean cdn;
  private View.OnClickListener eV;
  private View.OnClickListener eY;
  private View.OnLongClickListener g;
  private HashMap<Integer, Bitmap> kC;
  private Context mContext;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private View.OnClickListener r;
  
  public agga(Context paramContext, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    if (paramBaseFileAssistantActivity.eA() != -1)
    {
      this.cdn = true;
      dgh();
    }
    this.kC = new HashMap();
    this.q = paramOnClickListener1;
    this.r = paramOnClickListener2;
    this.g = paramOnLongClickListener;
    this.eV = paramOnClickListener3;
    this.mContext = paramContext;
    this.b = paramBaseFileAssistantActivity;
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, agga.a parama)
  {
    int i = paramString.hashCode();
    if (this.kC.containsKey(Integer.valueOf(i)) == true)
    {
      parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
      parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap((Bitmap)this.kC.get(Integer.valueOf(i)));
    }
    do
    {
      return;
      switch (paramInt1)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(ahav.hL(paramInt1));
        return;
      case 0: 
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845173);
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
        return;
      case 5: 
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845117);
      }
    } while (!ahbj.fileExistsAndNotEmpty(paramString));
    parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
    return;
    parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
    parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845245);
    parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
  }
  
  private String b(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ahcb.bu(paramFileInfo.getDate()));
    localStringBuilder.append("  ");
    if (this.b.akQ()) {
      localStringBuilder.append("来自微信").append("  ");
    }
    localStringBuilder.append(ahbj.g(paramFileInfo.getSize()));
    return localStringBuilder.toString();
  }
  
  private void dgh()
  {
    if (this.eY == null) {
      this.eY = new aggb(this);
    }
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "groupPosition[" + paramInt1 + "],childPosition[" + paramInt2 + "]");
    }
    if ((paramInt1 == 5) && (paramInt2 == 0) && (QLog.isDevelopLevel())) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "ready crash!");
    }
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (paramView == null) {}
    try
    {
      agga.a locala = new agga.a();
      paramViewGroup = this.mInflater.inflate(2131561003, paramViewGroup, false);
      paramView = paramViewGroup;
      try
      {
        locala.layout = ((RelativeLayout)paramViewGroup.findViewById(2131376838));
        paramView = paramViewGroup;
        locala.layout.setOnClickListener(this.r);
        paramView = paramViewGroup;
        locala.layout.setOnLongClickListener(this.g);
        paramView = paramViewGroup;
        locala.layout.setTag(locala);
        paramView = paramViewGroup;
        locala.c = ((CircleFileStateView)paramViewGroup.findViewById(2131361963));
        paramView = paramViewGroup;
        locala.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131367036));
        paramView = paramViewGroup;
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367020));
        paramView = paramViewGroup;
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.r);
        paramView = paramViewGroup;
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(locala);
        paramView = paramViewGroup;
        locala.fileName = ((TextView)paramViewGroup.findViewById(2131367034));
        paramView = paramViewGroup;
        locala.fileName.setGravity(48);
        paramView = paramViewGroup;
        locala.fileName.setMaxLines(2);
        paramView = paramViewGroup;
        locala.aY = ((TextView)paramViewGroup.findViewById(2131367018));
        paramView = paramViewGroup;
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
        paramView = paramViewGroup;
        paramViewGroup.setTag(locala);
        while (localFileInfo == null)
        {
          return paramViewGroup;
          locala = (agga.a)paramView.getTag();
          paramViewGroup = paramView;
        }
        paramView = paramViewGroup;
        locala.ccW = paramInt1;
        paramView = paramViewGroup;
        locala.cWL = paramInt2;
        paramView = paramViewGroup;
        localFileInfo.setGroupName((String)getGroup(paramInt1));
        paramView = paramViewGroup;
        locala.entity = localFileInfo;
        paramView = paramViewGroup;
        locala.c.setOnClickListener(this.eV);
        paramView = paramViewGroup;
        locala.c.setTag(locala);
        paramView = paramViewGroup;
        if (this.cdn)
        {
          paramView = paramViewGroup;
          locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(locala);
          paramView = paramViewGroup;
          locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.eY);
        }
        paramView = paramViewGroup;
        paramInt1 = locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getHeight();
        paramView = paramViewGroup;
        paramInt2 = locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getWidth();
        paramView = paramViewGroup;
        Object localObject = localFileInfo.getPath();
        paramView = paramViewGroup;
        if (this.a != null)
        {
          paramView = paramViewGroup;
          localObject = this.a.a(localFileInfo);
        }
        paramView = paramViewGroup;
        a((String)localObject, ahav.getFileType((String)localObject), paramInt2, paramInt1, locala);
        paramView = paramViewGroup;
        locala.fileName.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        paramView = paramViewGroup;
        localObject = localFileInfo.getName();
        paramView = paramViewGroup;
        locala.fileName.setText((CharSequence)localObject);
        paramView = paramViewGroup;
        locala.fileName.setVisibility(0);
        paramView = paramViewGroup;
        locala.aY.setText(b(localFileInfo));
        paramView = paramViewGroup;
        locala.c.setVisibility(4);
        paramView = paramViewGroup;
        locala.actionType = 0;
        paramView = paramViewGroup;
        if (this.b.akL())
        {
          paramView = paramViewGroup;
          locala.c.setVisibility(8);
          paramView = paramViewGroup;
          locala.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramView = paramViewGroup;
          locala.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          locala.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(agmz.d(localFileInfo));
        }
        for (;;)
        {
          paramView = paramViewGroup;
          localObject = (LinearLayout.LayoutParams)locala.aY.getLayoutParams();
          paramView = paramViewGroup;
          ((LinearLayout.LayoutParams)localObject).topMargin = wja.dp2px(3.0F, this.mContext.getResources());
          paramView = paramViewGroup;
          locala.aY.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.mContext.getResources().getDisplayMetrics()), 1.0F);
          paramView = paramViewGroup;
          locala.aY.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramView = paramViewGroup;
          locala.fileName.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.mContext.getResources().getDisplayMetrics()), 1.0F);
          return paramViewGroup;
          paramView = paramViewGroup;
          locala.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
        paramViewGroup.printStackTrace();
      }
      catch (Exception paramViewGroup) {}
    }
    catch (Exception paramViewGroup)
    {
      label906:
      break label906;
    }
    return paramView;
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
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agga
 * JD-Core Version:    0.7.0.1
 */