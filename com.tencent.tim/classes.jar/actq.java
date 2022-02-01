import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class actq
  extends acuk
{
  public actq(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acf();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("ContactAddAction", 1, "doAction error: " + localException.getMessage());
      Ge("ContactAddAction");
    }
    return false;
  }
  
  public boolean acf()
  {
    Intent localIntent = new Intent(this.context, AddContactsActivity.class);
    localIntent.setFlags(67108864);
    int j = Integer.parseInt((String)this.attrs.get("des_type"));
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        i = j;
        if (j != 2) {
          i = 0;
        }
      }
    }
    localIntent.putExtra("tab_index_key", i);
    this.context.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     actq
 * JD-Core Version:    0.7.0.1
 */