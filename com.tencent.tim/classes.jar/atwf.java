import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;
import java.util.List;

public class atwf
  extends atvy
{
  private List<FileInfo> Bq;
  private final int TYPE_DIRECTORY = -1;
  private final int TYPE_FILE = 1;
  private LocalFileBrowserActivity a;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public atwf(Context paramContext, List<FileInfo> paramList, LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    super(paramContext, paramLocalFileBrowserActivity.eQ);
    this.mContext = paramContext;
    this.Bq = paramList;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.a = paramLocalFileBrowserActivity;
  }
  
  private View a(FileInfo paramFileInfo, ViewGroup paramViewGroup)
  {
    atwf.a locala = new atwf.a();
    if (!paramFileInfo.isDirectory())
    {
      paramFileInfo = this.mInflater.inflate(2131561016, paramViewGroup, false);
      locala.layout = ((RelativeLayout)paramFileInfo.findViewById(2131370828));
      locala.layout.setOnClickListener(this.a.eR);
      locala.layout.setOnLongClickListener(this.a.f);
      locala.layout.setTag(locala);
      locala.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramFileInfo.findViewById(2131367036));
      locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131367020));
      locala.arrow = ((ImageView)paramFileInfo.findViewById(2131377272));
      locala.fileName = ((TextView)paramFileInfo.findViewById(2131367034));
      locala.fileSize = ((TextView)paramFileInfo.findViewById(2131367037));
      locala.aY = ((TextView)paramFileInfo.findViewById(2131367018));
      locala.time = ((TextView)paramFileInfo.findViewById(2131370129));
      locala.el = ((Button)paramFileInfo.findViewById(2131361963));
      locala.el.setOnClickListener(this.a.eR);
    }
    for (;;)
    {
      paramFileInfo.setTag(locala);
      return paramFileInfo;
      paramFileInfo = this.mInflater.inflate(2131561013, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.a.eR);
      locala.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131367054));
      locala.arrow = ((ImageView)paramFileInfo.findViewById(2131377282));
      locala.fileName = ((TextView)paramFileInfo.findViewById(2131367059));
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
          localObject = (atwf.a)paramView.getTag();
          ((atwf.a)localObject).b = localFileInfo;
          if (localFileInfo.isDirectory())
          {
            ((atwf.a)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130845137);
            ((atwf.a)localObject).arrow.setVisibility(0);
            ((atwf.a)localObject).fileName.setText(localFileInfo.getName());
            ((atwf.a)localObject).cYf = paramInt;
          }
          else
          {
            ((atwf.a)localObject).arrow.setVisibility(8);
            atpp.a(((atwf.a)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.getPath(), audx.fM(localFileInfo.getPath()));
            ((atwf.a)localObject).fileName.setText(localFileInfo.getName());
            if (this.a.akL())
            {
              ((atwf.a)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
              ((atwf.a)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(atwb.d(localFileInfo));
              String str = auem.bu(localFileInfo.getDate());
              this.a.getString(2131693588);
              ((atwf.a)localObject).fileSize.setText(aueh.g(localFileInfo.getSize()));
              ((atwf.a)localObject).time.setText(str);
              ((atwf.a)localObject).cYf = paramInt;
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
    public int cYf;
    public Button el;
    public TextView fileName;
    public TextView fileSize;
    public RelativeLayout layout;
    public TextView time;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwf
 * JD-Core Version:    0.7.0.1
 */