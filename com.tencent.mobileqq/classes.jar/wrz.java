import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(9)
public class wrz
  extends wsg<wsc>
{
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private wvd jdField_a_of_type_Wvd = new wsa(this);
  protected boolean a;
  
  public wrz()
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
    xcv localxcv = new xcv(1, paramInt1, paramInt2);
    wow.a().a(localxcv, new wsb(this));
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
  
  protected void a(wuz paramwuz)
  {
    yuk.b("AddressDataProvider", "requestAddress.");
    if (this.jdField_a_of_type_Boolean)
    {
      yuk.d("AddressDataProvider", "is request address ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    wva localwva = (wva)wth.a(9);
    wuz localwuz = paramwuz;
    if (paramwuz == null) {
      localwuz = localwva.b();
    }
    if (localwuz != null)
    {
      a(localwuz.b, localwuz.a);
      return;
    }
    localwva.a(this.jdField_a_of_type_Wvd);
    localwva.c();
  }
  
  public boolean a(wsc paramwsc)
  {
    return (paramwsc != null) && (!TextUtils.isEmpty(paramwsc.a)) && (!anzj.a(2131698794).equals(paramwsc.a));
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
 * Qualified Name:     wrz
 * JD-Core Version:    0.7.0.1
 */