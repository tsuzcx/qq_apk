import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class cuo
  extends AsyncTask
{
  private static final String jdField_a_of_type_JavaLangString = "PhoneContactManager.ContactFriendTask";
  
  private cuo(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  protected List a(RespondQueryQQBindingStat... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager.ContactFriendTask", 2, "doInBackground");
    }
    Object localObject = paramVarArgs[0];
    paramVarArgs = new ArrayList();
    paramVarArgs.addAll(PhoneContactManagerImp.a(this.a).values());
    Collections.sort(paramVarArgs, new cup(this));
    ArrayList localArrayList = new ArrayList();
    FriendManager localFriendManager = (FriendManager)PhoneContactManagerImp.a(this.a).getManager(8);
    Iterator localIterator;
    if (paramVarArgs.size() > 0)
    {
      localObject = ((RespondQueryQQBindingStat)localObject).mobileNo;
      localIterator = paramVarArgs.iterator();
    }
    PhoneContact localPhoneContact;
    do
    {
      do
      {
        if (localIterator.hasNext())
        {
          paramVarArgs = (PhoneContact)localIterator.next();
          if (!isCancelled()) {}
        }
        else
        {
          Collections.sort(localArrayList, new cuq(this));
          return localArrayList;
        }
      } while ((localObject != null) && (((String)localObject).endsWith(paramVarArgs.mobileNo.trim())));
      localPhoneContact = (PhoneContact)paramVarArgs.clone();
      if (localPhoneContact.pinyinFirst == null) {
        localPhoneContact.pinyinFirst = PhoneContactManagerImp.d(localPhoneContact.pinyinInitial);
      }
    } while (TextUtils.isEmpty(localPhoneContact.uin));
    if (localPhoneContact.uin.equals("0"))
    {
      paramVarArgs = null;
      label222:
      if ((paramVarArgs == null) || (paramVarArgs.groupid < 0)) {
        break label295;
      }
      localPhoneContact.nickName = ContactSorter.a(paramVarArgs);
      localPhoneContact.remark = paramVarArgs.remark;
      localPhoneContact.faceUrl = Short.toString(paramVarArgs.faceid);
      localPhoneContact.sortWeight = 262144;
    }
    for (;;)
    {
      localArrayList.add(localPhoneContact);
      break;
      paramVarArgs = localFriendManager.c(localPhoneContact.uin);
      break label222;
      label295:
      localPhoneContact.uin = "0";
      if (localFriendManager.e(localPhoneContact.nationCode + localPhoneContact.mobileCode))
      {
        localPhoneContact.sortWeight = 131072;
        localPhoneContact.hasSendAddReq = true;
      }
      else
      {
        localPhoneContact.sortWeight = 65536;
      }
    }
  }
  
  protected void a(List paramList)
  {
    if (!isCancelled()) {
      this.a.a(paramList);
    }
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager.ContactFriendTask", 2, "on cancelled");
    }
    PhoneContactManagerImp.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cuo
 * JD-Core Version:    0.7.0.1
 */