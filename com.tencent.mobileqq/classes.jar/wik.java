import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(9)
public class wik
  extends wir<win>
{
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private wlo jdField_a_of_type_Wlo = new wil(this);
  protected boolean a;
  
  public wik()
  {
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().a();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("poi_filter_perferences", 0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("longitude", 0);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("time", 0L);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("country", "");
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    wtg localwtg = new wtg(1, paramInt1, paramInt2);
    wfi.a().a(localwtg, new wim(this));
  }
  
  protected void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  protected void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong(paramString, paramLong).apply();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  protected void a(wlk paramwlk)
  {
    ykq.b("AddressDataProvider", "requestAddress.");
    if (this.jdField_a_of_type_Boolean)
    {
      ykq.d("AddressDataProvider", "is request address ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    wll localwll = (wll)wjs.a(9);
    wlk localwlk = paramwlk;
    if (paramwlk == null) {
      localwlk = localwll.b();
    }
    if (localwlk != null)
    {
      a(localwlk.b, localwlk.a);
      return;
    }
    localwll.a(this.jdField_a_of_type_Wlo);
    localwll.c();
  }
  
  public boolean a(win paramwin)
  {
    return (paramwin != null) && (!TextUtils.isEmpty(paramwin.a)) && (!anvx.a(2131699380).equals(paramwin.a));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("latitude", 0);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("province", "");
  }
  
  public String c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("city", "");
  }
  
  public String d()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("district", "");
  }
  
  public String e()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("street", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wik
 * JD-Core Version:    0.7.0.1
 */