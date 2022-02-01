import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class atrj
  extends atpo
{
  private BaseFileAssistantActivity b;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  private View.OnClickListener gu;
  private HashMap<Integer, Bitmap> kC = new HashMap();
  private Context mContext;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private View.OnClickListener r;
  
  public atrj(Context paramContext, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3, View.OnClickListener paramOnClickListener4)
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
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, atrj.a parama)
  {
    paramInt2 = paramString.hashCode();
    if (this.kC.containsKey(Integer.valueOf(paramInt2)) == true) {
      parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap((Bitmap)this.kC.get(Integer.valueOf(paramInt2)));
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
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(ahav.hL(paramInt1));
        return;
      case 0: 
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845173);
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
        return;
      case 5: 
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845117);
      }
    } while (!aueh.fileExistsAndNotEmpty(paramString));
    parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
    return;
    parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845245);
    parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
  }
  
  private String b(FileInfo paramFileInfo)
  {
    return aueh.g(paramFileInfo.getSize());
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
      atrj.a locala = new atrj.a();
      paramViewGroup = this.mInflater.inflate(2131563197, paramViewGroup, false);
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
        locala.el = ((Button)paramViewGroup.findViewById(2131361963));
        paramView = paramViewGroup;
        locala.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131367036));
        paramView = paramViewGroup;
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367020));
        paramView = paramViewGroup;
        locala.J = ((ImageView)paramViewGroup.findViewById(2131367042));
        paramView = paramViewGroup;
        locala.fileName = ((TextView)paramViewGroup.findViewById(2131367034));
        paramView = paramViewGroup;
        locala.k = ((ProgressBar)paramViewGroup.findViewById(2131367035));
        paramView = paramViewGroup;
        locala.aY = ((TextView)paramViewGroup.findViewById(2131367018));
        paramView = paramViewGroup;
        locala.time = ((TextView)paramViewGroup.findViewById(2131370129));
        paramView = paramViewGroup;
        locala.delBtn = ((Button)paramViewGroup.findViewById(2131365671));
        paramView = paramViewGroup;
        locala.delBtn.setOnClickListener(this.q);
        paramView = paramViewGroup;
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.gu);
        paramView = paramViewGroup;
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(locala);
        paramView = paramViewGroup;
        locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
        paramView = paramViewGroup;
        paramViewGroup.setTag(locala);
        while (localFileInfo == null)
        {
          return paramViewGroup;
          locala = (atrj.a)paramView.getTag();
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
        locala.el.setOnClickListener(this.eV);
        paramView = paramViewGroup;
        locala.el.setTag(locala);
        paramView = paramViewGroup;
        paramInt1 = locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getHeight();
        paramView = paramViewGroup;
        paramInt2 = locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getWidth();
        paramView = paramViewGroup;
        a(localFileInfo.getPath(), ahav.getFileType(localFileInfo.getPath()), paramInt2, paramInt1, locala);
        paramView = paramViewGroup;
        locala.fileName.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        paramView = paramViewGroup;
        locala.fileName.setText(localFileInfo.getName());
        paramView = paramViewGroup;
        locala.aY.setText(b(localFileInfo));
        paramView = paramViewGroup;
        locala.time.setText(auem.bu(localFileInfo.getDate()));
        paramView = paramViewGroup;
        locala.J.setVisibility(8);
        paramView = paramViewGroup;
        locala.el.setText(2131693842);
        paramView = paramViewGroup;
        locala.el.setVisibility(8);
        paramView = paramViewGroup;
        locala.actionType = 0;
        paramView = paramViewGroup;
        locala.k.setVisibility(8);
        paramView = paramViewGroup;
        if (this.b.akL())
        {
          paramView = paramViewGroup;
          locala.el.setVisibility(8);
          paramView = paramViewGroup;
          locala.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramView = paramViewGroup;
          locala.k.setVisibility(8);
          paramView = paramViewGroup;
          locala.layout.setBackgroundResource(2130839639);
          paramView = paramViewGroup;
          locala.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          locala.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(atwb.d(localFileInfo));
        }
        else
        {
          paramView = paramViewGroup;
          locala.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
      }
      catch (Exception paramViewGroup) {}
    }
    catch (Exception paramViewGroup)
    {
      label853:
      break label853;
    }
    paramViewGroup.printStackTrace();
    return paramView;
    return paramViewGroup;
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
 * Qualified Name:     atrj
 * JD-Core Version:    0.7.0.1
 */