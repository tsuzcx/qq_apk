import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ugi
  extends acfd
{
  public ugi(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  private void a(String paramString, ArrayList<anxi> paramArrayList, abdp paramabdp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "updateAssociatedAccountInfo  uin = " + paramString);
    }
    Iterator localIterator = paramArrayList.iterator();
    boolean bool1 = false;
    anxi localanxi;
    if (localIterator.hasNext())
    {
      localanxi = (anxi)localIterator.next();
      if ((localanxi.type == 2) && (localanxi.eY != null) && ((localanxi.eY instanceof ArrayList)))
      {
        paramArrayList = ((ArrayList)localanxi.eY).iterator();
        do
        {
          bool2 = bool1;
          if (!paramArrayList.hasNext()) {
            break;
          }
        } while (!paramString.equals(((SubAccountInfo)((anxi)paramArrayList.next()).eY).subuin));
        String str = aqgv.c(this.this$0.app, paramString, true);
        paramArrayList = str;
        if (TextUtils.isEmpty(str)) {
          paramArrayList = paramString;
        }
        boolean bool2 = bool1;
        if (!paramArrayList.equals(localanxi.bQA))
        {
          localanxi.bQA = paramArrayList;
          bool2 = true;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      break;
      if ((localanxi.type == 6) && (localanxi.eY != null) && ((localanxi.eY instanceof SimpleAccount)))
      {
        paramArrayList = (SimpleAccount)localanxi.eY;
        if (paramString.equals(paramArrayList.getUin()))
        {
          paramArrayList = anxk.a(this.this$0.app, paramArrayList);
          if (!paramArrayList.equals(localanxi.bQA))
          {
            localanxi.bQA = paramArrayList;
            bool1 = true;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("AssociatedAccountActivity", 2, "updateAssociatedAccountInfo needUpdate = " + bool1);
            }
            if (bool1) {
              paramabdp.notifyDataSetInvalidated();
            }
            return;
          }
        }
      }
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int k = 0;
    int i = 0;
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Iterator localIterator;
    label54:
    boolean bool;
    if ((this.this$0.oM != null) && (this.this$0.oM.size() > 0))
    {
      localIterator = this.this$0.oM.iterator();
      paramBoolean = false;
      bool = paramBoolean;
      if (!localIterator.hasNext()) {
        break label95;
      }
      if (!TextUtils.equals(paramString, ((SubAccountInfo)localIterator.next()).subuin)) {
        break label248;
      }
      paramBoolean = true;
    }
    label95:
    label248:
    for (;;)
    {
      break label54;
      bool = false;
      int j = k;
      if (this.this$0.oN != null)
      {
        j = k;
        if (this.this$0.oN.size() > 0)
        {
          localIterator = this.this$0.oN.iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            if (TextUtils.equals(paramString, ((SimpleAccount)localIterator.next()).getUin())) {
              i = 1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onUpdateCustomHead uin = " + paramString + " needUpdate=" + bool);
      }
      if (bool) {
        this.this$0.b.notifyDataSetInvalidated();
      }
      if (j == 0) {
        break;
      }
      this.this$0.a.notifyDataSetInvalidated();
      return;
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onUpdateFriendInfo  uin = " + paramString + " isSuccess = " + paramBoolean);
    }
    a(paramString, this.this$0.oP, this.this$0.b);
    a(paramString, this.this$0.oO, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugi
 * JD-Core Version:    0.7.0.1
 */