import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class zrm
  extends BaseAdapter
{
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  List<aswh> jdField_a_of_type_JavaUtilList;
  private short jdField_a_of_type_Short;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public zrm(List<aswh> paramList, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<aswh> paramList)
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
    zro localzro;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560818, null);
      localzro = new zro();
      localzro.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366656));
      localzro.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366659));
      localzro.b = ((TextView)paramView.findViewById(2131366662));
      localzro.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376419);
      paramView.setTag(localzro);
      paramView.setOnClickListener(new zrn(this));
    }
    for (;;)
    {
      localzro = (zro)paramView.getTag();
      aswh localaswh = (aswh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localaswh.jdField_a_of_type_Boolean)
      {
        localzro.b.setText(amtj.a(2131716052));
        localzro.jdField_a_of_type_AndroidWidgetTextView.setText(aszt.d(localaswh.jdField_a_of_type_JavaLangString));
        localzro.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130844177);
        localzro.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        localzro.jdField_a_of_type_Aswh = localaswh;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localzro.b.setText(FileUtil.filesizeToString(localaswh.jdField_a_of_type_Long));
        localzro.jdField_a_of_type_AndroidWidgetTextView.setText(aszt.d(localaswh.jdField_a_of_type_JavaLangString));
        aszt.a(localzro.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localaswh.jdField_a_of_type_JavaLangString);
        localzro.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (aszt.a(localaswh.jdField_a_of_type_JavaLangString) == 0)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          FileManagerEntity localFileManagerEntity = localQQAppInterface.getFileManagerDataCenter().b(localaswh.b);
          localFileManagerEntity.isZipInnerFile = true;
          aszt.b(localzro.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
          localQQAppInterface.getFileManagerEngine().c(localFileManagerEntity);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zrm
 * JD-Core Version:    0.7.0.1
 */