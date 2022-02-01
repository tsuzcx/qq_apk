import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class agnh
  extends agmw
{
  private List<FileInfo> Bq;
  private final int TYPE_DIRECTORY = -1;
  private final int TYPE_FILE = 1;
  private LocalFileBrowserActivity a;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public agnh(Context paramContext, List<FileInfo> paramList, LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    super(paramContext, paramLocalFileBrowserActivity.eQ);
    this.mContext = paramContext;
    this.Bq = paramList;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.a = paramLocalFileBrowserActivity;
  }
  
  private View a(FileInfo paramFileInfo, ViewGroup paramViewGroup)
  {
    agnh.a locala = new agnh.a();
    if (!paramFileInfo.isDirectory())
    {
      paramFileInfo = this.mInflater.inflate(2131561003, paramViewGroup, false);
      locala.layout = ((RelativeLayout)paramFileInfo);
      locala.layout.setOnClickListener(this.a.eR);
      locala.layout.setOnLongClickListener(this.a.f);
      locala.layout.setTag(locala);
      locala.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramFileInfo.findViewById(2131367036));
      locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131367020));
      locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.a.eR);
      locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(locala);
      locala.arrow = ((ImageView)paramFileInfo.findViewById(2131377272));
      locala.fileName = ((TextView)paramFileInfo.findViewById(2131367034));
      locala.fileName.setMaxLines(2);
      locala.fileSize = ((TextView)paramFileInfo.findViewById(2131367037));
      locala.aY = ((TextView)paramFileInfo.findViewById(2131367018));
      locala.time = ((TextView)paramFileInfo.findViewById(2131370129));
      locala.c = ((CircleFileStateView)paramFileInfo.findViewById(2131361963));
      locala.c.setOnClickListener(this.a.eR);
    }
    for (;;)
    {
      paramFileInfo.setTag(locala);
      return paramFileInfo;
      paramFileInfo = this.mInflater.inflate(2131561013, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.a.eR);
      locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131367054));
      locala.arrow = ((ImageView)paramFileInfo.findViewById(2131377282));
      locala.fileName = ((EllipsizingTextView)paramFileInfo.findViewById(2131367059));
    }
  }
  
  public int getCount()
  {
    return this.Bq.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.Bq.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((FileInfo)this.Bq.get(paramInt)).isDirectory()) {
      return -1;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileInfo localFileInfo = (FileInfo)this.Bq.get(paramInt);
    if (localFileInfo == null) {}
    View localView;
    for (Object localObject = null;; localView = paramView)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          localObject = a(localFileInfo, paramViewGroup);
          paramView = (View)localObject;
        }
        catch (Exception localException2)
        {
          continue;
        }
        try
        {
          localObject = (agnh.a)paramView.getTag();
          ((agnh.a)localObject).b = localFileInfo;
          if (localFileInfo.isDirectory())
          {
            ((agnh.a)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845137);
            ((agnh.a)localObject).arrow.setVisibility(0);
            ((agnh.a)localObject).fileName.setText(localFileInfo.getName());
            ((agnh.a)localObject).cYf = paramInt;
          }
          else
          {
            ((agnh.a)localObject).arrow.setVisibility(8);
            ahav.a(((agnh.a)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.getPath(), ahav.getFileType(localFileInfo.getPath()));
            ((agnh.a)localObject).fileName.setText(localFileInfo.getName());
            if (this.a.akL())
            {
              ((agnh.a)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
              ((agnh.a)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(agmz.d(localFileInfo));
              String str1 = ahcb.bu(localFileInfo.getDate());
              String str2 = this.a.getString(2131693588);
              ((agnh.a)localObject).aY.setText(str1 + str2 + ahbj.g(localFileInfo.getSize()));
              ((agnh.a)localObject).cYf = paramInt;
            }
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        localException1.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public class a
    implements Cloneable
  {
    public CheckBox a;
    public AsyncImageView a;
    public TextView aY;
    public ImageView arrow;
    public FileInfo b;
    public CircleFileStateView c;
    public int cYf;
    public TextView fileName;
    public TextView fileSize;
    public RelativeLayout layout;
    public TextView time;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agnh
 * JD-Core Version:    0.7.0.1
 */