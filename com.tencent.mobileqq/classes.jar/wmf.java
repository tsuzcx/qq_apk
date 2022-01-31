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

public class wmf
  extends BaseAdapter
{
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  List<aoys> jdField_a_of_type_JavaUtilList;
  private short jdField_a_of_type_Short;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public wmf(List<aoys> paramList, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<aoys> paramList)
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
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131494936, null);
      paramView = new wmh();
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131300635));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300638));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131300641));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131309509);
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(new wmg(this));
    }
    paramView = (wmh)paramViewGroup.getTag();
    aoys localaoys = (aoys)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localaoys.jdField_a_of_type_Boolean)
    {
      paramView.b.setText(ajjy.a(2131651254));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(apck.d(localaoys.jdField_a_of_type_JavaLangString));
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130843371);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_Aoys = localaoys;
      return paramViewGroup;
      paramView.b.setText(apdh.a(localaoys.jdField_a_of_type_Long));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(apck.d(localaoys.jdField_a_of_type_JavaLangString));
      apck.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localaoys.jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (apck.a(localaoys.jdField_a_of_type_JavaLangString) == 0)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        FileManagerEntity localFileManagerEntity = localQQAppInterface.a().b(localaoys.b);
        localFileManagerEntity.isZipInnerFile = true;
        apck.b(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
        localQQAppInterface.a().c(localFileManagerEntity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wmf
 * JD-Core Version:    0.7.0.1
 */