import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(9)
public class uqj
  extends uqq<uqm>
{
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private utn jdField_a_of_type_Utn = new uqk(this);
  protected boolean a;
  
  public uqj()
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
    vbf localvbf = new vbf(1, paramInt1, paramInt2);
    ung.a().a(localvbf, new uql(this));
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
  
  protected void a(utj paramutj)
  {
    wsv.b("AddressDataProvider", "requestAddress.");
    if (this.jdField_a_of_type_Boolean)
    {
      wsv.d("AddressDataProvider", "is request address ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    utk localutk = (utk)urr.a(9);
    utj localutj = paramutj;
    if (paramutj == null) {
      localutj = localutk.b();
    }
    if (localutj != null)
    {
      a(localutj.b, localutj.a);
      return;
    }
    localutk.a(this.jdField_a_of_type_Utn);
    localutk.c();
  }
  
  public boolean a(uqm paramuqm)
  {
    return (paramuqm != null) && (!TextUtils.isEmpty(paramuqm.a)) && (!alpo.a(2131700249).equals(paramuqm.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqj
 * JD-Core Version:    0.7.0.1
 */