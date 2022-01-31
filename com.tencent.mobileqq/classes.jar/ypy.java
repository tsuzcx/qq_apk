import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import java.util.List;

public class ypy
  extends BaseAdapter
{
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  List<arjn> jdField_a_of_type_JavaUtilList;
  private short jdField_a_of_type_Short;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public ypy(List<arjn> paramList, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<arjn> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean, String paramString, short paramShort)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.f = paramString;
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560684, null);
      paramView = new yqa();
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131366325));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366328));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131366331));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131375741);
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(new ypz(this));
    }
    paramView = (yqa)paramViewGroup.getTag();
    arjn localarjn = (arjn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localarjn.jdField_a_of_type_Boolean)
    {
      paramView.b.setText(alpo.a(2131717428));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(arni.d(localarjn.jdField_a_of_type_JavaLangString));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130843815);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_Arjn = localarjn;
      return paramViewGroup;
      paramView.b.setText(arof.a(localarjn.jdField_a_of_type_Long));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(arni.d(localarjn.jdField_a_of_type_JavaLangString));
      arni.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localarjn.jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (arni.a(localarjn.jdField_a_of_type_JavaLangString) == 0)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        FileManagerEntity localFileManagerEntity = localQQAppInterface.a().b(localarjn.b);
        localFileManagerEntity.isZipInnerFile = true;
        arni.b(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        localQQAppInterface.a().c(localFileManagerEntity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ypy
 * JD-Core Version:    0.7.0.1
 */