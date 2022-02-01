import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;

public class ziz
  extends agdq
{
  private ziz.b a;
  private View.OnClickListener bJ;
  private boolean bro;
  private View.OnClickListener c;
  
  public ziz(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  private void a(ziz.a parama, FileManagerEntity paramFileManagerEntity)
  {
    if (ahav.getFileType(paramFileManagerEntity.fileName) == 0)
    {
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        ahav.a(parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.nFileType);
        return;
      }
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strThumbPath))
      {
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845173);
        parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramFileManagerEntity.strThumbPath);
        return;
      }
      ahav.a(parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity.fileName, paramFileManagerEntity.nFileType);
      return;
    }
    ahav.a(parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramFileManagerEntity);
  }
  
  private void b(ziz.a parama, FileManagerEntity paramFileManagerEntity)
  {
    switch (paramFileManagerEntity.status)
    {
    case 16: 
    case 17: 
    default: 
      parama.c.setVisibility(8);
      return;
    case 2: 
    case 18: 
      parama.c.setState(1);
      parama.c.setVisibility(0);
      parama.actionType = 2;
      return;
    case 0: 
    case 3: 
      parama.c.setState(2);
      parama.c.setVisibility(0);
      parama.actionType = 3;
      return;
    case 1: 
      boolean bool = ahbj.isFileExists(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        parama.c.setVisibility(8);
        parama.actionType = 0;
        return;
      }
      parama.c.setState(2);
      parama.c.setVisibility(0);
      parama.actionType = 1;
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      parama.c.setVisibility(8);
      parama.actionType = 0;
      return;
    case 4: 
      parama.c.setState(2);
      parama.actionType = 1;
      parama.c.setVisibility(0);
      return;
    case -1: 
    case 13: 
      parama.c.setState(2);
      parama.c.setVisibility(0);
      parama.actionType = 1;
      return;
    }
    parama.c.setState(2);
    parama.c.setVisibility(8);
    parama.actionType = 2;
  }
  
  private void c(ziz.a parama, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    if (this.bro)
    {
      parama.c.setVisibility(8);
      parama.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      parama.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      if (this.a != null)
      {
        bool = this.a.b(paramFileManagerEntity);
        this.a.d(paramFileManagerEntity);
      }
      parama.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      return;
    }
    parama.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void A(View.OnClickListener paramOnClickListener)
  {
    this.bJ = paramOnClickListener;
  }
  
  public void BG(boolean paramBoolean)
  {
    this.bro = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void a(ziz.b paramb)
  {
    this.a = paramb;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)getChild(paramInt1, paramInt2);
    if ((paramView != null) && ((paramView.getTag() instanceof ziz.a)))
    {
      ziz.a locala = (ziz.a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = locala;
    }
    for (;;)
    {
      ahav.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
      paramView.layout.setVisibility(0);
      paramView.entity = localFileManagerEntity;
      paramView.c.setOnClickListener(this.c);
      paramView.c.setTag(paramView);
      paramView.c.setProgress((int)(localFileManagerEntity.fProgress * 100.0F));
      paramView.c.setProgressRingWidth(3.0F);
      a(paramView, localFileManagerEntity);
      paramView.fileName.setText(localFileManagerEntity.fileName);
      if (5 != localFileManagerEntity.cloudType) {
        ahav.I(localFileManagerEntity);
      }
      b(paramView, localFileManagerEntity);
      c(paramView, localFileManagerEntity);
      ahav.b(paramView.aY, localFileManagerEntity);
      return paramViewGroup;
      paramView = new ziz.a();
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561003, paramViewGroup, false);
      paramView.layout = ((RelativeLayout)paramViewGroup.findViewById(2131376838));
      paramView.layout.setOnClickListener(this.bJ);
      paramView.layout.setTag(paramView);
      paramView.c = ((CircleFileStateView)paramViewGroup.findViewById(2131361963));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131367036));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131367020));
      paramView.fileName = ((TextView)paramViewGroup.findViewById(2131367034));
      paramView.fileName.setMaxLines(2);
      paramView.aY = ((TextView)paramViewGroup.findViewById(2131367018));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
      paramViewGroup.setTag(paramView);
    }
  }
  
  public void z(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public class a
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
    
    public abstract void d(FileManagerEntity paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ziz
 * JD-Core Version:    0.7.0.1
 */