import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ztb
  extends zrx
{
  protected bahv a;
  
  private void a(JSONObject paramJSONObject, @NonNull zrt paramzrt)
  {
    paramJSONObject = this.jdField_a_of_type_Zrw.a();
    if ((paramJSONObject instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)paramJSONObject).getTitleBarHeight();; i = 0)
    {
      paramzrt = new ztc(this, i, paramzrt);
      if (this.jdField_a_of_type_Bahv == null)
      {
        this.jdField_a_of_type_Bahv = new bahv(paramJSONObject);
        this.jdField_a_of_type_Bahv.a(paramJSONObject.getString(2131653614));
        this.jdField_a_of_type_Bahv.a(a(paramJSONObject));
      }
      this.jdField_a_of_type_Bahv.a(paramzrt);
      try
      {
        this.jdField_a_of_type_Bahv.a();
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("DoraemonApi.ShareModule", 2, "actionSheet.show failed!", paramJSONObject);
      }
    }
  }
  
  public static List<bahx>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.a = paramContext.getString(2131630983);
    localbahx.jdField_b_of_type_Int = 2130838732;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 2;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.a = paramContext.getString(2131630996);
    localbahx.jdField_b_of_type_Int = 2130838733;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.a = paramContext.getString(2131631003);
    localbahx.jdField_b_of_type_Int = 2130838736;
    localbahx.c = 9;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.a = paramContext.getString(2131630986);
    localbahx.jdField_b_of_type_Int = 2130838730;
    localbahx.c = 10;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    return (List[])new ArrayList[] { localArrayList, new ArrayList() };
  }
  
  private void b(JSONObject paramJSONObject, @NonNull zrt paramzrt)
  {
    int i = paramJSONObject.optInt("shareChanel", 0);
    Activity localActivity = this.jdField_a_of_type_Zrw.a();
    if (!badq.g(BaseApplicationImpl.getContext()))
    {
      zva.a(paramzrt, -1, "net work not available");
      return;
    }
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 8);
    localIntent.putExtra("chanelId", i);
    localIntent.putExtra("params", paramJSONObject.toString());
    localActivity.startActivity(localIntent);
    zva.a(paramzrt, zrv.a);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull zrt paramzrt)
  {
    switch (paramInt)
    {
    case 28: 
    case 29: 
    default: 
      return false;
    case 30: 
      a(paramJSONObject, paramzrt);
    }
    for (;;)
    {
      return true;
      b(paramJSONObject, paramzrt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ztb
 * JD-Core Version:    0.7.0.1
 */