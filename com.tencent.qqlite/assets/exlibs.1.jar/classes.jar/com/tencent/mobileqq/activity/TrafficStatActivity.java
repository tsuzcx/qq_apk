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
      Toast.makeText(this, getString(2131363386), 1).show();
      return;
    }
    long l3 = 0L;
    long l1 = 0L;
    int i = 0;
    int j;
    Object localObject;
    float f2;
    float f1;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      j = ((Integer)this.jdField_a_of_type_JavaUtilVector.get(i)).intValue();
      localObject = (TextView)findViewById(j);
      String str = FileUtils.a(0, paramArrayOfLong1[(i * 2)] + paramArrayOfLong1[(i * 2 + 1)]);
      ((TextView)localObject).setText(str);
      f2 = Float.parseFloat(str.substring(0, str.length() - 1));
      if (str.endsWith("K"))
      {
        f1 = f2 * 1024.0F;
        label128:
        l2 = l1;
        if (j != 2131296487) {
          if (j != 2131296493) {
            break label204;
          }
        }
      }
      label204:
      for (l2 = l1;; l2 = (f1 + (float)l1))
      {
        i += 1;
        l1 = l2;
        break;
        if (str.endsWith("M"))
        {
          f1 = f2 * 1048576.0F;
          break label128;
        }
        f1 = f2;
        if (!str.endsWith("G")) {
          break label128;
        }
        f1 = f2 * 1.073742E+009F;
        break label128;
      }
    }
    i = 0;
    long l2 = l3;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      j = ((Integer)this.jdField_a_of_type_JavaUtilVector.get(i)).intValue();
      paramArrayOfLong1 = (TextView)findViewById(j);
      localObject = FileUtils.a(1, paramArrayOfLong2[(i * 2)] + paramArrayOfLong2[(i * 2 + 1)]);
      paramArrayOfLong1.setText((CharSequence)localObject);
      f2 = Float.parseFloat(((String)localObject).substring(0, ((String)localObject).length() - 1));
      if (((String)localObject).endsWith("K"))
      {
        f1 = f2 * 1024.0F;
        label320:
        l3 = l2;
        if (j != 2131296488) {
          if (j != 2131296494) {
            break label396;
          }
        }
      }
      label396:
      for (l3 = l2;; l3 = (f1 + (float)l2))
      {
        i += 1;
        l2 = l3;
        break;
        if (((String)localObject).endsWith("M"))
        {
          f1 = f2 * 1048576.0F;
          break label320;
        }
        f1 = f2;
        if (!((String)localObject).endsWith("G")) {
          break label320;
        }
        f1 = f2 * 1.073742E+009F;
        break label320;
      }
    }
    paramArrayOfLong1 = (TextView)findViewById(2131296475);
    paramArrayOfLong2 = (TextView)findViewById(2131296476);
    paramArrayOfLong1.setText(FileUtils.a(0, l1));
    paramArrayOfLong2.setText(FileUtils.a(1, l2));
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131296478));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131296481));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131296484));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131296487));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131296490));
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(2131296493));
    this.jdField_b_of_type_JavaUtilVector = new Vector();
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131296479));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131296482));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131296485));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131296488));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131296491));
    this.jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(2131296494));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296495));
  }
  
  public void d()
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ReportServlet.class);
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
    this.app.startServlet(localNewIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903050);
    setTitle(2131363050);
    this.app.registObserver(this);
    d();
    c();
  }
  
  protected void onDestroy()
  {
    this.app.unRegistObserver(this);
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
    Toast.makeText(this, getString(2131363386), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TrafficStatActivity
 * JD-Core Version:    0.7.0.1
 */