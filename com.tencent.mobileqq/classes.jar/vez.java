import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import java.lang.ref.WeakReference;

public class vez
  extends uvr
{
  private static int d;
  private WeakReference a;
  private int jdField_c_of_type_Int;
  private final String jdField_c_of_type_JavaLangString = "ArkApp.SSODataRequest";
  
  public vez(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.substring(0, 6).equalsIgnoreCase("sso://")) {
      return null;
    }
    int i = paramString.indexOf('/', 6);
    if (i == -1) {
      return paramString.substring(6);
    }
    return paramString.substring(6, i);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = null;
    a(null);
  }
  
  void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != this.jdField_c_of_type_Int) {
      ArkAppCenter.b("ArkApp.SSODataRequest", String.format("# onComplete, req canceled, cookie=%d-%d, ret=%d, rsp=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(paramInt2), paramString }));
    }
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_Int = 0;
      paramString = this.jdField_a_of_type_Vaj;
      this.jdField_a_of_type_Vaj = null;
    } while (paramString == null);
    paramString.a();
  }
  
  public boolean a(String paramString)
  {
    if (!super.a(paramString))
    {
      ArkAppCenter.b("ArkApp.SSODataRequest", String.format("# fail to open, url=%s", new Object[] { paramString }));
      return false;
    }
    return true;
  }
  
  void b(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this);
    ArkAppCenter.a().post(new vfc(this, localWeakReference, paramInt));
  }
  
  public boolean b(String paramString)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      ArkAppCenter.b("ArkApp.SSODataRequest", String.format("# fail to send, app is null, url=%s, req=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString }));
      return false;
    }
    if ((this.jdField_c_of_type_Int != 0) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      ArkAppCenter.b("ArkApp.SSODataRequest", String.format("# fail to send, cookie=%d, url=%s, req=%s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_a_of_type_JavaLangString, paramString }));
      return false;
    }
    int i = d + 1;
    d = i;
    this.jdField_c_of_type_Int = i;
    String str = a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(str))
    {
      ArkAppCenter.b("ArkApp.SSODataRequest", String.format("# fail to send, cmd is empty, cookie=%d, url=%s, reqData=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_JavaLangString, paramString }));
      b(i);
      return true;
    }
    localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(120)).a();
    WeakReference localWeakReference = new WeakReference(this);
    if (!((ArkAppSSO)localObject).a(str, paramString, this.jdField_a_of_type_Int, i, new vfa(this, localWeakReference)))
    {
      ArkAppCenter.b("ArkApp.SSODataRequest", String.format("# fail to send, sso.sendAppMsg fail, cookie=%d, url=%s, reqData=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_JavaLangString, paramString }));
      b(i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vez
 * JD-Core Version:    0.7.0.1
 */