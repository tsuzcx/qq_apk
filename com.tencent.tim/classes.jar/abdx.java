import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class abdx
  extends BaseAdapter
{
  private final String TAG = "ChatHistoryFileAdapter";
  private abdx.b a;
  private uou b;
  private boolean bro;
  private View.OnClickListener de;
  private View.OnClickListener df;
  private Context mContext;
  private List<Object> mData;
  private LayoutInflater mInflater;
  
  public abdx(Context paramContext, List<Object> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, uou paramuou)
  {
    this.mContext = paramContext;
    this.mData = paramList;
    this.df = paramOnClickListener1;
    this.de = paramOnClickListener2;
    this.b = paramuou;
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  public void BG(boolean paramBoolean)
  {
    this.bro = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void a(abdx.b paramb)
  {
    this.a = paramb;
  }
  
  public int getCount()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if ((localObject2 instanceof FileManagerEntity))
    {
      localObject1 = paramView;
      try
      {
        localFileManagerEntity = (FileManagerEntity)localObject2;
        if (paramView == null) {
          break label465;
        }
        localObject1 = paramView;
        if (!(paramView.getTag() instanceof abdx.a)) {
          break label465;
        }
        localObject1 = paramView;
        localObject2 = (abdx.a)paramView.getTag();
        localObject1 = paramView;
        ahav.a(((abdx.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        localObject1 = paramView;
        ((abdx.a)localObject2).layout.setVisibility(0);
        localObject1 = paramView;
        ((abdx.a)localObject2).entity = localFileManagerEntity;
        localObject1 = paramView;
        ((abdx.a)localObject2).c.setOnClickListener(this.de);
        localObject1 = paramView;
        ((abdx.a)localObject2).c.setTag(localObject2);
        localObject1 = paramView;
        ((abdx.a)localObject2).c.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
        localObject1 = paramView;
        ((abdx.a)localObject2).c.setProgressRingWidth(3.0F);
        localObject1 = paramView;
        if (ahav.getFileType(localFileManagerEntity.fileName) != 0) {
          break label764;
        }
        localObject1 = paramView;
        if (!aqhq.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
          break label693;
        }
        localObject1 = paramView;
        ahav.a(((abdx.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.getFilePath(), localFileManagerEntity.nFileType);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          FileManagerEntity localFileManagerEntity;
          paramView.printStackTrace();
          paramView = (View)localObject1;
          continue;
          localObject1 = paramView;
          if (aqhq.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath))
          {
            localObject1 = paramView;
            ((abdx.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845173);
            localObject1 = paramView;
            ((abdx.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileManagerEntity.strThumbPath);
          }
          else
          {
            localObject1 = paramView;
            ahav.a(((abdx.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.fileName, localFileManagerEntity.nFileType);
            continue;
            localObject1 = paramView;
            ahav.a(((abdx.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setState(1);
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(0);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 2;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setState(2);
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(0);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 3;
            continue;
            localObject1 = paramView;
            bool = ahbj.isFileExists(localFileManagerEntity.getFilePath());
            localObject1 = paramView;
            if (localFileManagerEntity.getCloudType() != 3)
            {
              localObject1 = paramView;
              if ((localFileManagerEntity.getCloudType() != 5) && (!bool)) {}
            }
            else
            {
              localObject1 = paramView;
              ((abdx.a)localObject2).c.setVisibility(8);
              localObject1 = paramView;
              ((abdx.a)localObject2).actionType = 0;
              continue;
            }
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setState(2);
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(0);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 1;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setState(2);
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(0);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 3;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(8);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 0;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setState(2);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 1;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(0);
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(8);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 0;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(8);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 0;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setState(2);
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(0);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 1;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setState(2);
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(8);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 2;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setState(2);
            localObject1 = paramView;
            ((abdx.a)localObject2).c.setVisibility(0);
            localObject1 = paramView;
            ((abdx.a)localObject2).actionType = 1;
            continue;
            localObject1 = paramView;
            ((abdx.a)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          }
        }
      }
      localObject1 = paramView;
      ((abdx.a)localObject2).fileName.setText(localFileManagerEntity.fileName);
      localObject1 = paramView;
      if (5 != localFileManagerEntity.cloudType)
      {
        localObject1 = paramView;
        ahav.I(localFileManagerEntity);
      }
      localObject1 = paramView;
      switch (localFileManagerEntity.status)
      {
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      ((abdx.a)localObject2).c.setVisibility(8);
      localObject1 = paramView;
      if (this.bro)
      {
        localObject1 = paramView;
        ((abdx.a)localObject2).c.setVisibility(8);
        localObject1 = paramView;
        ((abdx.a)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        localObject1 = paramView;
        ((abdx.a)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        localObject1 = paramView;
        if (this.a == null) {
          break label1313;
        }
        localObject1 = paramView;
      }
      label1280:
      label1313:
      for (boolean bool = this.a.b(localFileManagerEntity);; bool = false)
      {
        localObject1 = paramView;
        ((abdx.a)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        localObject1 = paramView;
        ahav.b(((abdx.a)localObject2).aY, localFileManagerEntity);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label465:
        localObject1 = paramView;
        localObject2 = new abdx.a();
        localObject1 = paramView;
        paramView = this.mInflater.inflate(2131561003, paramViewGroup, false);
        localObject1 = paramView;
        ((abdx.a)localObject2).layout = ((RelativeLayout)paramView.findViewById(2131376838));
        localObject1 = paramView;
        ((abdx.a)localObject2).layout.setOnClickListener(this.df);
        localObject1 = paramView;
        ((abdx.a)localObject2).layout.setTag(localObject2);
        localObject1 = paramView;
        ((abdx.a)localObject2).c = ((CircleFileStateView)paramView.findViewById(2131361963));
        localObject1 = paramView;
        ((abdx.a)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131367036));
        localObject1 = paramView;
        ((abdx.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367020));
        localObject1 = paramView;
        ((abdx.a)localObject2).fileName = ((TextView)paramView.findViewById(2131367034));
        localObject1 = paramView;
        ((abdx.a)localObject2).fileName.setMaxLines(2);
        localObject1 = paramView;
        ((abdx.a)localObject2).aY = ((TextView)paramView.findViewById(2131367018));
        localObject1 = paramView;
        ((abdx.a)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject2);
        break;
        label693:
        label764:
        localObject1 = paramView;
        if ((localObject2 instanceof String))
        {
          if ((paramView == null) || (!(paramView.getTag() instanceof TextView))) {
            break label1280;
          }
          localObject1 = (TextView)paramView.getTag();
        }
        for (;;)
        {
          ((TextView)localObject1).setText((String)localObject2);
          localObject1 = paramView;
          paramView = (View)localObject1;
          break;
          paramView = View.inflate(this.mContext, 2131561031, null);
          localObject1 = (TextView)paramView.findViewById(2131379419);
          paramView.setTag(localObject1);
        }
      }
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
    public Object entity;
    public TextView fileName;
    public RelativeLayout layout;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract boolean b(FileManagerEntity paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdx
 * JD-Core Version:    0.7.0.1
 */