package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Vector;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class TrafficStatActivity
  extends IphoneTitleBarActivity
  implements BusinessObserver
{
  public long a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  Vector jdField_a_of_type_JavaUtilVector = null;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "param_XGChatFlow", "param_XGPicFlow", "param_XGVoiceFlow", "param_XGVideoFlow", "param_XGFileFlow", "param_XGQZoneFlow" };
  public long b;
  Vector jdField_b_of_type_JavaUtilVector = null;
  String[] jdField_b_of_type_ArrayOfJavaLangString = null;
  
  public TrafficStatActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramArrayOfLong1 == null)
    {
      Toast.makeText(this, getString(2131562783), 1).show();
      return;
    }
    long l2 = 0L;
    long l1 = 0L;
    int i = 0;
    Object localObject;
    float f2;
    float f1;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      localObject = (TextView)findViewById(((Integer)this.jdField_a_of_type_JavaUtilVector.get(i)).intValue());
      String str = FileUtils.a(0, paramArrayOfLong1[(i * 2)] + paramArrayOfLong1[(i * 2 + 1)]);
      ((TextView)localObject).setText(str);
      f2 = Float.parseFloat(str.substring(0, str.length() - 1));
      if (str.endsWith("K")) {
        f1 = f2 * 1024.0F;
      }
      for (;;)
      {
        l1 = (f1 + (float)l1);
        i += 1;
        break;
        if (str.endsWith("M"))
        {
          f1 = f2 * 1048576.0F;
        }
        else
        {
          f1 = f2;
          if (str.endsWith("G")) {
            f1 = f2 * 1.073742E+009F;
          }
        }
      }
    }
    i = 0;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramArrayOfLong1 = (TextView)findViewById(((Integer)this.jdField_b_of_type_JavaUtilVector.get(i)).intValue());
      localObject = FileUtils.a(1, paramArrayOfLong2[(i * 2)] + paramArrayOfLong2[(i * 2 + 1)]);
      paramArrayOfLong1.setText((CharSequence)localObject);
      f2 = Float.parseFloat(((String)localObject).substring(0, ((String)localObject).length() - 1));
      if (((String)localObject).endsWith("K")) {
        f1 = f2 * 1024.0F;
      }
      for (;;)
      {
        l2 = (f1 + (float)l2);
        i += 1;
        break;
        if (((String)localObject).endsWith("M"))
        {
          f1 = f2 * 1048576.0F;
        }
        else
        {
          f1 = f2;
          if (((String)localObject).endsWith("G")) {
            f1 = f2 * 1.073742E+009F;
          }
        }
      }
    }
    paramArrayOfLong1 = (TextView)findViewById(2131231034);
    paramArrayOfLong2 = (TextView)findViewById(2131231035);
    paramArrayOfLong1.setText(FileUtils.a(0, l1));
    paramArrayOfLong2.setText(FileUtils.a(1, l2));
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131231037));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131231040));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131231043));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131231046));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131231049));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131231052));
    this.jdField_b_of_type_JavaUtilVector = new Vector();
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131231038));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131231041));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131231044));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131231047));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131231050));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131231053));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231054));
  }
  
  public void e()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 3);
    if (this.jdField_b_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_b_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfJavaLangString.length * 2];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        this.jdField_b_of_type_ArrayOfJavaLangString[(i * 2)] = this.jdField_a_of_type_ArrayOfJavaLangString[i];
        this.jdField_b_of_type_ArrayOfJavaLangString[(i * 2 + 1)] = (this.jdField_a_of_type_ArrayOfJavaLangString[i] + "_bg");
        i += 1;
      }
    }
    localNewIntent.putExtra("tags", this.jdField_b_of_type_ArrayOfJavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903074);
    setTitle(2131561905);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
    e();
    d();
  }
  
  protected void onDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
    super.onDestroy();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long[] arrayOfLong;
    if (3 == paramInt)
    {
      if (!paramBoolean) {
        break label51;
      }
      arrayOfLong = paramBundle.getLongArray("__base_tag_curentDay");
      paramBundle = paramBundle.getLongArray("__base_tag_curentMonth");
      if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (arrayOfLong.length == this.jdField_b_of_type_ArrayOfJavaLangString.length)) {}
    }
    else
    {
      return;
    }
    a(arrayOfLong, paramBundle);
    return;
    label51:
    Toast.makeText(this, getString(2131562783), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TrafficStatActivity
 * JD-Core Version:    0.7.0.1
 */