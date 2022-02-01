package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.Utility;
import icb;
import icc;
import icd;
import ice;
import java.util.ArrayList;
import java.util.Iterator;

public class UploadServerSetting
  extends Activity
{
  public static final int a = 0;
  public static final String a = "113.108.67.20";
  public static final int b = 1;
  public static final String b = "113.108.76.228";
  public static final int c = 2;
  public static final String c = "119.147.14.28";
  public static final int d = 3;
  protected static final String d = "UploadServerSetting";
  public static final int e = 4;
  public static final int f = 19995;
  public static final int g = 8080;
  public static final int h = 19994;
  public BaseAdapter a;
  private UploadServerSetting.ConfigItem jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String e = "";
  private int i;
  
  private void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    try
    {
      this.e = paramString1;
      this.i = Integer.parseInt(paramString2);
      QZoneHelper.LocalConfig.a("ServerUploadCustomIp", paramString1);
      QZoneHelper.LocalConfig.a("ServerUploadCustomPort", this.i);
      this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem.jdField_a_of_type_Int = this.i;
      this.jdField_a_of_type_JavaUtilArrayList.set(4, this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem);
      a(this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem);
      Utility.CUSTOM_IP = this.e;
      Utility.CUSTOM_PORT = this.i;
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void b()
  {
    d();
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem("", 0, 0));
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem("预发布：113.108.67.20", 19995, 1));
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem("测试：113.108.76.228", 8080, 2));
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem("调试：119.147.14.28", 19994, 3));
    if (this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem);
    }
    Utility.CUSTOM_IP = this.e;
    Utility.CUSTOM_PORT = this.i;
  }
  
  private void c()
  {
    int j = QZoneHelper.LocalConfig.a("ServerUploadEnvironment", 0);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      UploadServerSetting.ConfigItem localConfigItem = (UploadServerSetting.ConfigItem)localIterator.next();
      if (localConfigItem.b == j) {
        localConfigItem.jdField_a_of_type_Boolean = true;
      } else {
        localConfigItem.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void d()
  {
    this.e = QZoneHelper.LocalConfig.a("ServerUploadCustomIp", "113.108.67.16");
    this.i = QZoneHelper.LocalConfig.a("ServerUploadCustomPort", 19994);
    this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem = new UploadServerSetting.ConfigItem("自定义：" + this.e, this.i, 4);
    Utility.CUSTOM_IP = this.e;
    Utility.CUSTOM_PORT = this.i;
    if (QLog.isColorLevel()) {
      QLog.d("upload", 2, "custom server loaded:" + Utility.CUSTOM_IP + ":" + Utility.CUSTOM_PORT);
    }
  }
  
  public QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131624405);
    paramContext.setContentView(2130903912);
    EditText localEditText1 = (EditText)paramContext.findViewById(2131234306);
    EditText localEditText2 = (EditText)paramContext.findViewById(2131234307);
    if (!TextUtils.isEmpty(this.e))
    {
      localEditText1.setText(this.e);
      localEditText2.setText(this.i + "");
    }
    paramContext.setNegativeButton(paramInt1, new icc(this, paramContext));
    paramContext.setPositiveButton(paramInt2, new icd(this, localEditText1, localEditText2, paramContext));
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public void a()
  {
    a(this, 2131561746, 2131560962).show();
  }
  
  public void a(UploadServerSetting.ConfigItem paramConfigItem)
  {
    QZoneHelper.LocalConfig.a("ServerUploadEnvironment", paramConfigItem.b);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      UploadServerSetting.ConfigItem localConfigItem = (UploadServerSetting.ConfigItem)localIterator.next();
      if (paramConfigItem.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localConfigItem.jdField_a_of_type_JavaLangString)) {
        localConfigItem.jdField_a_of_type_Boolean = true;
      } else {
        localConfigItem.jdField_a_of_type_Boolean = false;
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    c();
    paramBundle = new ice(this, this.jdField_a_of_type_JavaUtilArrayList);
    setContentView(2130903909);
    ListView localListView = (ListView)findViewById(2131234283);
    localListView.setAdapter(paramBundle);
    localListView.setOnItemClickListener(new icb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.UploadServerSetting
 * JD-Core Version:    0.7.0.1
 */